package com.exercise.encoderDecode.base64;

import com.exercise.encoderDecode.EncoderInterface;

import java.io.Reader;

/**
 * Created by edavidovich on 6/18/16.
 */
public class Base64Encoder implements EncoderInterface {
    private static final String CODES = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/=";

    /**
     * This implementation was borrowed from Wikipidia
     * https://en.wikipedia.org/wiki/Base64
     * @param in
     * @return
     */
    public byte[] encode(byte[] in) {
        StringBuilder out = new StringBuilder((in.length * 4) / 3);
        int b;
        for (int i = 0; i < in.length; i += 3)  {
            b = (in[i] & 0xFC) >> 2;
            out.append(CODES.charAt(b));
            b = (in[i] & 0x03) << 4;
            if (i + 1 < in.length)      {
                b |= (in[i + 1] & 0xF0) >> 4;
                out.append(CODES.charAt(b));
                b = (in[i + 1] & 0x0F) << 2;
                if (i + 2 < in.length)  {
                    b |= (in[i + 2] & 0xC0) >> 6;
                    out.append(CODES.charAt(b));
                    b = in[i + 2] & 0x3F;
                    out.append(CODES.charAt(b));
                } else  {
                    out.append(CODES.charAt(b));
                    out.append('=');
                }
            } else      {
                out.append(CODES.charAt(b));
                out.append("==");
            }
        }

        return out.toString().getBytes();
    }

    public Reader encode(Reader in) {
        return new Base64EncodingFilter(in);
    }
}
