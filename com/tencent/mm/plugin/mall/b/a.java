package com.tencent.mm.plugin.mall.b;

import android.widget.ImageView;
import com.tencent.mm.a.g;
import com.tencent.mm.ak.o;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.g.a.ri;
import com.tencent.mm.sdk.platformtools.bi;
import java.text.SimpleDateFormat;

public final class a {
    private static SimpleDateFormat hIH = null;
    private static SimpleDateFormat hII = null;
    private static final String lag = (e.bnE + "wallet/mall");

    public static void bcf() {
        ri riVar = new ri();
        riVar.ccb.ccc = false;
        com.tencent.mm.sdk.b.a.sFg.m(riVar);
    }

    public static void j(ImageView imageView, String str) {
        f(imageView, str, 0);
    }

    public static void f(ImageView imageView, String str, int i) {
        String str2 = null;
        if (imageView != null) {
            imageView.setImageBitmap(null);
            if (!bi.oW(str)) {
                com.tencent.mm.ak.a.a.c.a aVar = new com.tencent.mm.ak.a.a.c.a();
                if (!bi.oW(str)) {
                    str2 = String.format("%s/%s", new Object[]{lag, g.u(str.getBytes())});
                }
                aVar.dXB = str2;
                aVar.dXy = true;
                aVar.dXV = true;
                aVar.dXW = false;
                if (i != 0) {
                    aVar.dXN = i;
                }
                o.Pj().a(str, imageView, aVar.Pt());
            } else if (i != 0) {
                imageView.setImageResource(i);
            }
        }
    }
}
