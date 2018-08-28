package com.tencent.mm.plugin.appbrand.jsapi.file;

import com.tencent.mm.plugin.appbrand.q.c;
import java.math.BigInteger;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;

public class e$a {
    static final Map<String, e> fQd;

    static void init() {
    }

    static {
        Map hashMap = new HashMap();
        fQd = hashMap;
        hashMap.put("ascii", new 1());
        fQd.put("base64", new 2());
        fQd.put("binary", new e() {
            public final String i(ByteBuffer byteBuffer) {
                return new BigInteger(1, c.k(byteBuffer)).toString(2);
            }

            public final ByteBuffer ty(String str) {
                return ByteBuffer.wrap(new BigInteger(str, 2).toByteArray());
            }
        });
        fQd.put("hex", new 4());
        final Charset forName = Charset.forName("ISO-10646-UCS-2");
        AnonymousClass5 anonymousClass5 = new e() {
            public final String i(ByteBuffer byteBuffer) {
                byteBuffer.order(ByteOrder.LITTLE_ENDIAN);
                return new String(c.k(byteBuffer), forName);
            }

            public final ByteBuffer ty(String str) {
                return ByteBuffer.wrap(str.getBytes(forName)).order(ByteOrder.LITTLE_ENDIAN);
            }
        };
        fQd.put("ucs2", anonymousClass5);
        fQd.put("ucs-2", anonymousClass5);
        6 6 = new 6(Charset.forName("UTF-16LE"));
        fQd.put("utf16le", 6);
        fQd.put("utf-16le", 6);
        AnonymousClass7 anonymousClass7 = new e() {
            public final String i(ByteBuffer byteBuffer) {
                return new String(c.k(byteBuffer), UTF_8);
            }

            public final ByteBuffer ty(String str) {
                return ByteBuffer.wrap(str.getBytes(UTF_8));
            }
        };
        fQd.put("utf8", anonymousClass7);
        fQd.put("utf-8", anonymousClass7);
        fQd.put("latin1", new 8());
    }
}
