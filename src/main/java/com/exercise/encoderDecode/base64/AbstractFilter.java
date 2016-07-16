package com.exercise.encoderDecode.base64;

import java.io.FilterReader;
import java.io.IOException;
import java.io.Reader;

/**
 * Created by adonaldson on 7/16/16.
 */
public class AbstractFilter extends FilterReader {

    protected AbstractFilter(Reader in) {
        super(in);
    }

    @Override
    public long skip(long n) throws IOException {
        throw new IOException("This Reader does not support skip");
    }

    @Override
    public boolean markSupported() {
        return false;
    }

    @Override
    public void mark(int readAheadLimit) throws IOException {
        throw new IOException("This Reader does not support mark");
    }

    @Override
    public void reset() throws IOException {
        throw new IOException("This Reader does not support reset");
    }

    @Override
    public int read(char[] cbuf) throws IOException {
        return read(cbuf,0,1);
    }

    @Override
    public int read(char[] cbuf,
                    int off,
                    int len)
            throws IOException {
        int c = read();
        if (c!=-1) {
            cbuf[off] = (char)c;
            return 1;
        } else {
            return -1;
        }
    }
}
