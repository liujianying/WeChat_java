package com.tencent.mm.plugin.appbrand.jsapi.media;

import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Rect;
import com.tencent.mm.plugin.appbrand.appcache.ao;
import com.tencent.mm.plugin.appbrand.g;
import com.tencent.mm.plugin.appbrand.jsapi.media.c.b;
import com.tencent.mm.plugin.appbrand.jsapi.media.c.c;
import com.tencent.mm.plugin.appbrand.jsapi.media.c.e;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.vending.j.a;
import java.io.Closeable;
import java.io.IOException;

final class c$d implements b {
    private c$d() {
    }

    /* synthetic */ c$d(byte b) {
        this();
    }

    public final a i(g gVar, String str) {
        Closeable d = ao.d(gVar, str);
        if (d == null) {
            return a.cz(e.fVa);
        }
        d.mark(0);
        Options options = new Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeStream(d, new Rect(), options);
        c cVar = new c((byte) 0);
        cVar.width = options.outWidth;
        cVar.height = options.outHeight;
        cVar.type = com.tencent.mm.plugin.appbrand.r.a.b(options);
        boolean a = com.tencent.mm.plugin.appbrand.r.a.a(options);
        try {
            d.reset();
        } catch (IOException e) {
        }
        cVar.fqt = a ? com.tencent.mm.plugin.appbrand.r.a.lQ(com.tencent.mm.plugin.appbrand.r.a.q(d)) : "up";
        bi.d(d);
        return a.x(e.fVc, cVar);
    }
}
