package com.exercise.encoderDecode;
import com.exercise.encoderDecode.base64.Base64Decoder;
import com.exercise.encoderDecode.base64.Base64Encoder;


/**
 *
 */


public class EncoderDecoderFactory {
    //TODO: implement
    private static final String CUSTOM_CODE="1234567890!@#$%^&*()qwertyuiopQWERTYUIOPasdfghjklASDFGHJKLzxcv="; //any 65 chars

    public static EncoderInterface getBase64Encoder() {
        return new Base64Encoder();
    }
    public static DecoderInterface getBase64Decoder() {
        return new Base64Decoder();
    }
    //public static EncoderInterface getCustom64Encoder(CUSTOM_CODE){
        //return new Base64Encoder();
    //}
    //public static DecoderInterface getCustom64Decoder(CUSTOM_CODE){
        //return new Base64Decoder();
    //}

}
