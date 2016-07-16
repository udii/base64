package com.exercise.encoderDecode.base64;

import com.exercise.encoderDecode.DecoderInterface;

import java.io.Reader;

/**
 * Created by edavidovich on 6/18/16.
 */
public class Base64Decoder implements DecoderInterface {
    public Reader decode(Reader in) {
        return new Base64DecodingFilter(in);
    }
}


