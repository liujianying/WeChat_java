package com.tencent.mm.plugin.appbrand.jsapi.file;

import com.tencent.mm.plugin.appbrand.q.c;
import java.math.BigInteger;
import java.nio.ByteBuffer;

class e$a$4 implements e {
    e$a$4() {
    }

    public final String i(ByteBuffer byteBuffer) {
        return new BigInteger(1, c.k(byteBuffer)).toString(16);
    }

    public final ByteBuffer ty(String str) {
        return ByteBuffer.wrap(new BigInteger(str, 16).toByteArray());
    }
}
