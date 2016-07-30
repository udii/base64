package com.exercise.encoderDecode.custom64;

import com.exercise.encoderDecode.DecoderInterface;
import org.apache.commons.io.input.ReaderInputStream;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.UnsupportedEncodingException;

/**
 * Created by edavidovich on 6/18/16.
 */
public class Custom64Decoder implements DecoderInterface {
    private String CODE;
    public Custom64Decoder(String code) {
        CODE=code;
    }
    public Reader decode(Reader in) {
        Reader out = new Custom64DecodingFilter(in,CODE);
        InputStream r = new ReaderInputStream(out, "ISO-8859-1");
        Reader plain = null;
        try {
            plain = new InputStreamReader(r,"UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return plain;
    }
}


