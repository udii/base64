package com.exercise.encoderDecode.custom64;

import com.exercise.encoderDecode.DecoderInterface;

import java.io.Reader;

/**
 * Created by edavidovich on 6/18/16.
 */
public class Custom64Decoder implements DecoderInterface {
    private String CODE;
    public Custom64Decoder(String code) {
        CODE=code;
    }
    public Reader decode(Reader in) {
        return new Custom64DecodingFilter(in,CODE);
    }
}


