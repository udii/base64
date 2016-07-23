package com.exercise.encoderDecode;

import com.exercise.encoderDecode.custom64.Custom64Decoder;
import com.exercise.encoderDecode.custom64.Custom64Encoder;

import java.io.Reader;
import java.util.HashSet;

/**
 * This class is used to generate encoderes and decoders.
 * Currenty is supports base-64 encoding and custom-64 encoding
 */
public class EncoderDecoderFactory {
    private static final String BASE64_CODE = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/=";
    private static final String MY_CODE = "1234567890!@#$%^&*()qwertyuiopQWERTYUIOPasdfghjklASDFGHJKLzxcv="; //any 65 chars

    /**
     * Create a base64 encoder
     * @return a base64 encoder
     */
    public static EncoderInterface getBase64Encoder() {
        return new Custom64Encoder(BASE64_CODE);
    }

    /**
     * Create a base64 decoder
     * @return a base64 decoder
     */
    public static DecoderInterface getBase64Decoder() {
        return new Custom64Decoder(BASE64_CODE);
    }

    /**
     * Create a my64 encoder
     * @return a my64 encoder
     */
    public static EncoderInterface getMy64Encoder() {
        return new Custom64Encoder(MY_CODE);
    }

    /**
     * Create a my64 decoder
     * @return a my64 decoder
     */
    public static DecoderInterface getMy64Decoder() {
        return new Custom64Decoder(MY_CODE);
    }

    /**
     * Create a 64 encoder with a custom code
     * @param code 65 char string that represents the code to encode with
     * @return a custom-64 encoder
     */
    public static EncoderInterface getCustom64Encoder(String code){
        assertCode(code);
        return new Custom64Encoder(code);
    }

    /**
     * Create a 64 decoder with a custom code
     * @param code 65 char string that represents the code to decode with
     * @return a custom-64 decoder
     */
    public static DecoderInterface getCustom64Decoder(String code){
        assertCode(code);
        return new Custom64Decoder(code);
    }

    /**
     * verify that the code
     * @param code
     * @throws IllegalArgumentException
     */
    private static void assertCode(String code) throws IllegalArgumentException {
        if (code.length()!=65) {
            throw new IllegalArgumentException("Code must have 64+1 characters");
        }
        HashSet<Character> set = new HashSet<Character>();
        for (char c:code.toCharArray()) {
            set.add(c);
        }
        if (set.size()!=65) {
            throw new IllegalArgumentException("Code must have 64+1 unique characters");
        }

    }

}
