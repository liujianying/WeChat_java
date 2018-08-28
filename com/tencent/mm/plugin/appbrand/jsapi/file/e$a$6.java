package com.tencent.mm.plugin.appbrand.jsapi.file;

import com.tencent.mm.plugin.appbrand.q.c;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.Charset;

class e$a$6 implements e {
    final /* synthetic */ Charset fQf;

    e$a$6(Charset charset) {
        this.fQf = charset;
    }

    public final String i(ByteBuffer byteBuffer) {
        byteBuffer.order(ByteOrder.LITTLE_ENDIAN);
        return new String(c.k(byteBuffer), this.fQf);
    }

    public final ByteBuffer ty(String str) {
        return ByteBuffer.wrap(str.getBytes(this.fQf)).order(ByteOrder.LITTLE_ENDIAN);
    }
}
