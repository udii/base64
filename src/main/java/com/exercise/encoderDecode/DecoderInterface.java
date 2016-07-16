package com.exercise.encoderDecode;

import java.io.Reader;

/**
 * TODO: describe
 * Created by edavidovich on 6/18/16.
 */
public interface DecoderInterface {
    /**
     * This abstract method is used decodes a byte array into a byte array
     * @param in the input array to decode
     * @return the decoded array
     */
    byte[] decode(byte[] in);
    Reader decode(Reader in);
}
