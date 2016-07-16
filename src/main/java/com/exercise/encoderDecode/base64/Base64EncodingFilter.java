package com.exercise.encoderDecode.base64;

import java.io.FilterReader;
import java.io.IOException;
import java.io.Reader;

/**
 * Created by edavidovich on 6/25/16.
 */
public class Base64EncodingFilter extends AbstractFilter {

    private static final String CODES = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/=";

    int buffer; //remaining bits from last read
    int length = 0; //number of bits remained in buffer
    int done = -1; //number of = chars to return or -1 if not done yet

    public Base64EncodingFilter(Reader in) {
        super(in);
    }

    public int read() throws IOException {
        if (done>0) {
            done-=1;
            return '=';
        } else if (done==0) {
            return -1;
        } else if (length==6) {
            length=0;
            return CODES.charAt(buffer);
        } else if (length==4) {
            int next = super.read();
            if (next==-1) {
                done = 1;
                int index = ((buffer & 0x0F) << 2);
                return CODES.charAt(index);
            }
            int index = ((buffer & 0x0F) << 2) | ((next & 0xC0) >> 6);
            buffer = next & 0x3F;
            length = 6;
            return CODES.charAt(index);
        } else if (length==2) {
            int next = super.read();
            if (next==-1) {
                done = 2;
                int index = ((buffer & 0x03) << 4);
                return CODES.charAt(index);
            }
            int index = ((buffer & 0x03) << 4) | ((next & 0xF0) >> 4);
            buffer = next & 0x0F;
            length = 4;
            return CODES.charAt(index);
        } else if (length==0) {
            int next = super.read();
            if (next==-1) {
                return -1;
            }
            int index = (next & 0xFC) >> 2;
            buffer = next & 0x03;
            length = 2;
            return CODES.charAt(index);
        }
        return -1; //this should never happen
    }
}
