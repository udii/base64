package com.exercise.encoderDecode.custom64;

import com.exercise.encoderDecode.EncoderInterface;

import java.io.*;

import org.apache.commons.io.input.*;
/**
 * Created by edavidovich on 6/18/16.
 */
public class Custom64Encoder implements EncoderInterface {
    private String CODE;
    public Custom64Encoder(String code) {
        CODE=code;
    }
    public Reader encode(Reader in) {
        InputStream r = new ReaderInputStream(in);
        Reader plain = null;
        try {
            plain = new InputStreamReader(r,"ISO-8859-1");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return new Custom64EncodingFilter(plain,CODE);
    }
}
