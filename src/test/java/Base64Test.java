import com.exercise.encoderDecode.DecoderInterface;
import com.exercise.encoderDecode.EncoderInterface;
import com.exercise.encoderDecode.EncoderDecoderFactory;
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

    private static final String CODE = "qwertyuiopQWERTYUIOPasdfghjklASDFGHJKLzxcvbnmZXCVBNM1092837465$-="; //any 65 chars


    @Test
    public void encodeDecodeStreamTest() {
        System.out.println("");
        System.out.println("Encode And Decode Stream Test: ");
        String input = "john";
        System.out.println("Input: "+input);
        Reader plain = new StringReader(input);
        EncoderInterface encoder = EncoderDecoderFactory.getBase64Encoder();
        DecoderInterface decoder = EncoderDecoderFactory.getBase64Decoder();
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
        EncoderInterface encoder = EncoderDecoderFactory.getBase64Encoder();
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
        System.out.println("");
    }

    @Test
    public void encoderDecoderCustomEncoder() {
        System.out.println("");
        System.out.println("Encode Known Input Stream Test with new Code: ");
        String input = "any carnal pleasure.";
        System.out.println("Input: "+input);
        Reader plain = new StringReader(input);
        EncoderInterface encoder = EncoderDecoderFactory.getMy64Encoder();
        Reader encoded = encoder.encode(plain);
        String result = null;
        try {
            result = IOUtils.toString(encoded);
        } catch (IOException e) {
            e.printStackTrace();
            Assert.fail();
        }
        System.out.println("Encoded: "+result);
        System.out.println("");
        //TODO need to assert
    }

    @Test
    public void encoderDecoderCustomDecoder() {
        System.out.println("");
        System.out.println("Decode Known Input Stream Test with new Code: ");
        String input = "teLL97$RoOLRi32li7wRoJwSy(K=";
        System.out.println("Input: "+input);
        Reader plain = new StringReader(input);
        DecoderInterface decoder = EncoderDecoderFactory.getMy64Decoder();
        Reader decoded = decoder.decode(plain);
        String result = null;
        try {
            result = IOUtils.toString(decoded);
        } catch (IOException e) {
            e.printStackTrace();
            Assert.fail();
        }
        System.out.println("Decoded: "+result);
        System.out.println("");
        //TODO need to assert
    }

    @Test
    public void encoderDecoderNewCustomEncoder() {
        System.out.println("");
        System.out.println("Encode Known Input Stream Test with Brand new Code: ");
        String input = "any carnal pleasure.";
        System.out.println("Input: "+input);
        Reader plain = new StringReader(input);
        EncoderInterface encoder = EncoderDecoderFactory.getCustom64Encoder(CODE);
        Reader encoded = encoder.encode(plain);
        String result = null;
        try {
            result = IOUtils.toString(encoded);
        } catch (IOException e) {
            e.printStackTrace();
            Assert.fail();
        }
        System.out.println("Encoded: "+result);
        System.out.println("");
        //TODO need to assert
    }

    @Test
    public void encoderDecoderNewCustomDecoder() {
        System.out.println("");
        System.out.println("Decode Known Input Stream Test with Brand new Code: ");
        String input = "gd33ouRGlz3GkewVkusGl2sNhO8=";
        System.out.println("Input: "+input);
        Reader plain = new StringReader(input);
        DecoderInterface decoder = EncoderDecoderFactory.getCustom64Decoder(CODE);
        Reader decoded = decoder.decode(plain);
        String result = null;
        try {
            result = IOUtils.toString(decoded);
        } catch (IOException e) {
            e.printStackTrace();
            Assert.fail();
        }
        System.out.println("Decoded: "+result);
        System.out.println("");
        //TODO need to assert

    }


    @Test
    public void shortInputTwoEqualsStreamTest() {
        System.out.println("");
        System.out.println("Short Input Stream Test:");
        String input = "a";
        System.out.println("Input: "+input);
        Reader plain = new StringReader(input);
        EncoderInterface encoder = EncoderDecoderFactory.getBase64Encoder();
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
        DecoderInterface decoder = EncoderDecoderFactory.getBase64Decoder();
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
        System.out.println("");
    }


    @Test
    public void encoderDecoderOutputStreamTest() {
        System.out.println("");
        System.out.println("Decode an Unknown Output Stream Test: ");
        String input = "VGhpcyBpcyBhbiBBcnhhbiBzYW1wbGUgc3RyaW5nIHRoYXQgc2hvdWxkIGJlIGVhc2lseSBkZWNvZGVkIGZyb20gYmFzZTY0LiAgSXQgaW5jbHVkZXMgYSBudW1iZXIgb2YgVVRGOCBjaGFyYWN0ZXJzIHN1Y2ggYXMgdGhlIPEsIOksIOgsIOcgYW5kICYjOTYwOyBjaGFyYWN0ZXJzLg==";
        System.out.println("Input: "+input);
        Reader code = new StringReader(input);
        DecoderInterface decoder = EncoderDecoderFactory.getBase64Decoder();
        Reader decoded = decoder.decode(code);
        String result = null;
        try {
            result = IOUtils.toString(decoded);
        } catch (IOException e) {
            e.printStackTrace();
            Assert.fail();
        }
        System.out.println("Decoded: "+result);
        System.out.println("");
    }

    @Test
    public void encoderDecoderKnownShortOutputStreamTest() {
        System.out.println("");
        System.out.println("Decode Known Short Output Stream Test: ");
        String input = "YQ==";
        System.out.println("Input: "+input);
        Reader code = new StringReader(input);
        DecoderInterface decoder = EncoderDecoderFactory.getBase64Decoder();
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
        System.out.println("");
    }

    @Test
    public void mytest() {
        System.out.println("");
        System.out.println("Decode an Unknown Output Stream Test: ");
        String input = "VGhpcyBpcyBhbiBBcnhhbiBzYW1wbGUgc3RyaW5nIHRoYXQgc2hvdWxkIGJlIGVhc2lseSBkZWNvZGVkIGZyb20gYmFzZTY0LiAgSXQgaW5jbHVkZXMgYSBudW1iZXIgb2YgVVRGOCBjaGFyYWN0ZXJzIHN1Y2ggYXMgdGhlIPEsIOksIOgsIOcgYW5kICYjOTYwOyBjaGFyYWN0ZXJzLg==";
        System.out.println("Input: "+input);
        Reader code = new StringReader(input);
        DecoderInterface decoder = EncoderDecoderFactory.getBase64Decoder();
        Reader decoded = decoder.decode(code);
        String result = null;
        try {
            result = IOUtils.toString(decoded);
        } catch (IOException e) {
            e.printStackTrace();
            Assert.fail();
        }
        System.out.println("Decoded: "+result);
        System.out.println("");
    }

    @Test
    public void mytest2() {
        String input = "ñ, é, è, ç, π";
        Reader plain = new StringReader(input);
        EncoderInterface encoder = EncoderDecoderFactory.getBase64Encoder();
        Reader encoded = encoder.encode(plain);
        DecoderInterface decoder = EncoderDecoderFactory.getBase64Decoder();
        Reader decoded = decoder.decode(encoded);
        String result = null;
        try {
            result = IOUtils.toString(decoded);
        } catch (IOException e) {
            e.printStackTrace();
            Assert.fail();
        }
        Assert.assertEquals(input,result);
    }

    @Test
    public void testPi2() {
        System.out.println("");
        System.out.println("Short Input Stream Test:");
        String input = "π";
        System.out.println("Input: "+input);
        Reader plain = new StringReader(input);
        try {
            EncoderInterface encoder = EncoderDecoderFactory.getBase64Encoder();
            Reader encoded = encoder.encode(plain);
            String result = null;
            result = IOUtils.toString(encoded);
            System.out.println("Encoded: "+result);
            Assert.assertEquals("z4A=",result);
            System.out.println("");
        } catch (IOException e) {
            e.printStackTrace();
            Assert.fail();
        }
    }

}

