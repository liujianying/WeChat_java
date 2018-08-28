package com.tencent.mm.plugin.appbrand.game.b;

import android.util.Base64;
import com.tencent.magicbrush.handler.image.a.a;
import java.io.ByteArrayInputStream;
import java.io.InputStream;

class b$b extends a {
    private b$b() {
    }

    public /* synthetic */ b$b(byte b) {
        this();
    }

    private static int sR(String str) {
        int i = 14;
        if (str == null) {
            return 0;
        }
        if (!str.startsWith("data:image/")) {
            return 0;
        }
        if (str.startsWith("jpeg", 11)) {
            i = 15;
        } else if (!(str.startsWith("png", 11) || str.startsWith("gif", 11))) {
            return 0;
        }
        if (str.startsWith(";base64,", i)) {
            return i + 8;
        }
        return 0;
    }

    public final boolean bV(String str) {
        return sR(str) > 0;
    }

    public final InputStream bW(String str) {
        return new ByteArrayInputStream(Base64.decode(str.substring(sR(str)), 2));
    }
}
