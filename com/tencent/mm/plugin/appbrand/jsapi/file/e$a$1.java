package com.tencent.mm.plugin.appbrand.jsapi.file;

import com.tencent.mm.plugin.appbrand.q.c;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;

class e$a$1 implements e {
    private final Charset lt = Charset.forName("US-ASCII");

    e$a$1() {
    }

    public final String i(ByteBuffer byteBuffer) {
        return new String(c.k(byteBuffer), this.lt);
    }

    public final ByteBuffer ty(String str) {
        return ByteBuffer.wrap(str.getBytes(this.lt));
    }
}
