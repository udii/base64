package com.exercise.encoderDecode.custom64;

import com.exercise.encoderDecode.EncoderInterface;

import java.io.Reader;

/**
 * Created by edavidovich on 6/18/16.
 */
public class Custom64Encoder implements EncoderInterface {
    private String CODE;
    public Custom64Encoder(String code) {
        CODE=code;
    }
    public Reader encode(Reader in) {
        return new Custom64EncodingFilter(in,CODE);
    }
}
