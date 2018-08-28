package com.tencent.mm.plugin.appbrand.canvas;

import android.graphics.Bitmap;
import com.tencent.mm.modelappbrand.b.b.h;
import com.tencent.mm.plugin.appbrand.canvas.g.a;

class j$1 implements h {
    final /* synthetic */ a fno;
    final /* synthetic */ j fnp;
    final /* synthetic */ String sk;
    final /* synthetic */ String val$url;

    j$1(j jVar, a aVar, String str, String str2) {
        this.fnp = jVar;
        this.fno = aVar;
        this.sk = str;
        this.val$url = str2;
    }

    public final void Kc() {
    }

    public final void n(Bitmap bitmap) {
        if (this.fno != null && bitmap != null && !bitmap.isRecycled()) {
            this.fno.adn();
        }
    }

    public final void Kd() {
    }

    public final String Ke() {
        return "WxaIcon";
    }
}
