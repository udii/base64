package com.exercise.encoderDecode.base64;

import com.exercise.encoderDecode.EncoderInterface;

import java.io.Reader;

/**
 * Created by edavidovich on 6/18/16.
 */
public class Base64Encoder implements EncoderInterface {
    public Reader encode(Reader in) {
        return new Base64EncodingFilter(in);
    }
}
