package com.eclipsesource.a;

import java.io.Writer;

public final class k extends l {
    private final char[] acc;

    k(char[] cArr) {
        this.acc = cArr;
    }

    protected final i a(Writer writer) {
        return new a(writer, this.acc, (byte) 0);
    }
}
