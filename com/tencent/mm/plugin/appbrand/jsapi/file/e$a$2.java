package com.tencent.mm.plugin.appbrand.jsapi.file;

import android.util.Base64;
import com.tencent.mm.plugin.appbrand.q.c;
import java.nio.ByteBuffer;

class e$a$2 implements e {
    e$a$2() {
    }

    public final String i(ByteBuffer byteBuffer) {
        return new String(Base64.encode(c.k(byteBuffer), 2), UTF_8);
    }

    public final ByteBuffer ty(String str) {
        return ByteBuffer.wrap(Base64.decode(str.getBytes(UTF_8), 2));
    }
}
