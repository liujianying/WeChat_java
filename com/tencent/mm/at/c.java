package com.tencent.mm.at;

import android.graphics.Bitmap;
import com.tencent.mm.a.e;
import com.tencent.mm.a.g;
import com.tencent.mm.plugin.ag.a;
import com.tencent.mm.sdk.platformtools.at;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.h;
import com.tencent.mm.sdk.platformtools.x;
import java.io.File;

public final class c {
    private static c edE;
    private at edF = null;

    public static c Qt() {
        if (edE == null) {
            edE = new c();
        }
        return edE;
    }

    private c() {
    }

    public static String my(String str) {
        if (bi.oW(str)) {
            return null;
        }
        return h.b(a.bqP(), "remark_", g.u((str + "ZnVjaw==").getBytes()), ".png", 1);
    }

    public static boolean mz(String str) {
        x.d("MicroMsg.RemarkImageStorage", "remove remark image: %s, path:%s", new Object[]{str, my(str)});
        return new File(my(str)).exists();
    }

    public static boolean mA(String str) {
        x.d("MicroMsg.RemarkImageStorage", "remove remark image: %s, path:%s", new Object[]{str, my(str)});
        return e.deleteFile(my(str));
    }

    public static Bitmap mB(String str) {
        int i = 0;
        Bitmap aj = com.tencent.mm.sdk.platformtools.c.aj(my(str), 0, 0);
        if (!(aj == null || aj.isRecycled())) {
            i = 1;
        }
        return i != 0 ? aj : null;
    }

    public final void a(String str, String str2, a aVar) {
        if (!bi.oW(str2) && !mz(str)) {
            if (this.edF == null || this.edF.ciz()) {
                this.edF = new at(1, "download-remark-img", 1);
            }
            this.edF.c(new b(this, str, str2, aVar));
        }
    }
}
