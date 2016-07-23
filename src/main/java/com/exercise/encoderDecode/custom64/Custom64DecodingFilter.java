package com.exercise.encoderDecode.custom64;

import java.io.IOException;
import java.io.Reader;

/**
 * Created by edavidovich on 6/25/16.
 */
public class Custom64DecodingFilter extends AbstractFilter {

    private String CODES;

    int buffer; //remaining bits from last read
    int length = 0; //number of bits remained in buffer


    public Custom64DecodingFilter(Reader in, String code) {
        super(in);
        CODES = code;
    }

    public int read() throws IOException {
        if (length==0) {
            int next = super.read();
            int next2 = super.read();
            if (next == -1 || next == CODES.charAt(64)) {
                return -1;
            } else if (next2 == -1 || next2 == CODES.charAt(64)) {
                return (char)CODES.indexOf((char)next);
            } else {
                int idx = CODES.indexOf((char)next);
                int idx2 = CODES.indexOf((char)next2);
                int value = (idx << 2) | (idx2 >> 4);
                buffer = idx2 & 0x0F;
                length = 4;
                return (char)value;
            }
        } else if (length==4) {
            int next = super.read();
            if (next == -1 || next == CODES.charAt(64)) {
                length = 0;
                return -1;
            } else {
                int idx = CODES.indexOf((char)next);
                int value = (buffer << 4) | (idx >> 2);
                length = 2;
                buffer = idx & 0x03;
                return (char)value;
            }
        } else if (length==2) {
            int next = super.read();
            if (next == -1 || next == CODES.charAt(64)) {
                length = 0;
                return -1;
            } else {
                int idx = CODES.indexOf((char)next);
                int value = (buffer << 6) | idx;
                length = 0;
                return (char)value;
            }
        }
        return -1; //this should never happen
    }
}
