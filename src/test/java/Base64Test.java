import com.exercise.encoderDecode.DecoderInterface;
import com.exercise.encoderDecode.EncoderInterface;
import com.exercise.encoderDecode.base64.Base64Decoder;
import com.exercise.encoderDecode.base64.Base64Encoder;
import com.exercise.encoderDecode.base64.Base64EncodingFilter;
import org.apache.commons.io.IOUtils;
import org.junit.*;

import java.io.*;


/**
 * Created by edavidovich on 6/11/16.
 */
public class Base64Test {
    /***
     *
     */


    @Test
    public void encodeDecodeStreamTest() {
        System.out.println("");
        System.out.println("Encode And Decode Stream Test: ");
        String input = "john";
        System.out.println("Input: "+input);
        Reader plain = new StringReader(input);
        //TODO: move the common test setup to a setup method
        EncoderInterface encoder = new Base64Encoder();
        DecoderInterface decoder = new Base64Decoder();
        Reader decoded = decoder.decode(encoder.encode(plain));
        try {
            Reader expected = new StringReader(input);
            Assert.assertTrue(IOUtils.contentEquals(expected,decoded));
        } catch (IOException e) {
            e.printStackTrace();
            Assert.fail();
        }
        System.out.println("Decoded: "+input);
        System.out.println("");
    }

    @Test
    public void encoderDecoderKnownInputStreamTest() {
        System.out.println("");
        System.out.println("Encode Known Input Stream Test: ");
        String input = "any carnal pleasure.";
        System.out.println("Input: "+input);
        Reader plain = new StringReader(input);
        EncoderInterface encoder = new Base64Encoder();
//        DecoderInterface decoder = new Base64Decoder();
        Reader encoded = encoder.encode(plain);
        String result = null;
        try {
            result = IOUtils.toString(encoded);
        } catch (IOException e) {
            e.printStackTrace();
            Assert.fail();
        }
        System.out.println("Encoded: "+result);
        Assert.assertEquals("YW55IGNhcm5hbCBwbGVhc3VyZS4=",result);
//        byte[] decoded = decoder.decode(encoded);
//        System.out.println("Decoded: "+new String(decoded));
//        Assert.assertArrayEquals(input,decoded);
        System.out.println("");
    }

    @Test
    public void shortInputTwoEqualsStreamTest() {
        System.out.println("");
        System.out.println("Short Input Stream Test:");
        String input = "a";
        System.out.println("Input: "+input);
        Reader plain = new StringReader(input);
        EncoderInterface encoder = new Base64Encoder();
        Reader encoded = encoder.encode(plain);
        String result = null;
        try {
            result = IOUtils.toString(encoded);
        } catch (IOException e) {
            e.printStackTrace();
            Assert.fail();
        }
        System.out.println("Encoded: "+result);
        Assert.assertEquals("YQ==",result);
        System.out.println("");
    }

    @Test
    public void encoderDecoderKnownOutputStreamTest() {
        System.out.println("");
        System.out.println("Decode a Known Output Stream Test: ");
        String input = "YW55IGNhcm5hbCBwbGVhc3VyZS4=";
        System.out.println("Input: "+input);
        Reader code = new StringReader(input);
        //EncoderInterface encoder = new Base64Encoder();
        DecoderInterface decoder = new Base64Decoder();
        Reader decoded = decoder.decode(code);
        String result = null;
        try {
            result = IOUtils.toString(decoded);
        } catch (IOException e) {
            e.printStackTrace();
            Assert.fail();
        }
        System.out.println("Decoded: "+result);
        Assert.assertEquals("any carnal pleasure.",result);
//        byte[] decoded = decoder.decode(encoded);
//        System.out.println("Decoded: "+new String(decoded));
//        Assert.assertArrayEquals(input,decoded);
        System.out.println("");
    }


    @Test
    public void encoderDecoderKnownShortOutputStreamTest() {
        System.out.println("");
        System.out.println("Decode Known Short Output Stream Test: ");
        String input = "YQ==";
        System.out.println("Input: "+input);
        Reader code = new StringReader(input);
        //EncoderInterface encoder = new Base64Encoder();
        DecoderInterface decoder = new Base64Decoder();
        Reader decoded = decoder.decode(code);
        String result = null;
        try {
            result = IOUtils.toString(decoded);
        } catch (IOException e) {
            e.printStackTrace();
            Assert.fail();
        }
        System.out.println("Decoded: "+result);
        Assert.assertEquals("a",result);
//        byte[] decoded = decoder.decode(encoded);
//        System.out.println("Decoded: "+new String(decoded));
//        Assert.assertArrayEquals(input,decoded);
        System.out.println("");
    }

}

