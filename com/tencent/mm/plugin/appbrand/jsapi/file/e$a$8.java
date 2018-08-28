package com.tencent.mm.plugin.appbrand.jsapi.file;

import com.tencent.mm.plugin.appbrand.q.c;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;

class e$a$8 implements e {
    private final Charset fQg = Charset.forName("ISO-8859-1");

    e$a$8() {
    }

    public final String i(ByteBuffer byteBuffer) {
        return new String(c.k(byteBuffer), this.fQg);
    }

    public final ByteBuffer ty(String str) {
        return ByteBuffer.wrap(str.getBytes(this.fQg));
    }
}
