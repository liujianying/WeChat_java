package com.tencent.mm.ui;

import android.graphics.Bitmap;
import com.tencent.mm.ak.a.c.i;
import com.tencent.mm.g.a.gq;
import com.tencent.mm.sdk.b.a;

class h$11 implements i {
    final /* synthetic */ gq kdk;
    final /* synthetic */ h tiG;

    h$11(h hVar, gq gqVar) {
        this.tiG = hVar;
        this.kdk = gqVar;
    }

    public final void a(String str, Bitmap bitmap, Object... objArr) {
        this.kdk.bPN.nc = 2;
        this.kdk.bPN.url = str;
        a.sFg.m(this.kdk);
    }
}
