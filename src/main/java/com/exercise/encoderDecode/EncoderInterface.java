package com.exercise.encoderDecode;

import java.io.Reader;

/**
 * TODO: descibe
 * This version uses byte arrays
 * Future version will suport Streams
 * Created by edavidovich on 6/18/16.
 */
public interface EncoderInterface {
    /**
     *
     * @param in
     * @return
     */
    byte[] encode(byte[] in);
    Reader encode(Reader in);
}
