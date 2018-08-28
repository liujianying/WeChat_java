package com.tencent.mm.plugin.ipcall.ui;

import android.graphics.Bitmap;
import android.widget.ImageView;
import com.tencent.mm.aa.c;
import com.tencent.mm.aa.q;
import com.tencent.mm.sdk.platformtools.at.a;

class d$2 implements a {
    final /* synthetic */ String dhF;
    final /* synthetic */ String dhm;
    final /* synthetic */ ImageView joW;
    final /* synthetic */ d ktU;

    d$2(d dVar, String str, ImageView imageView, String str2) {
        this.ktU = dVar;
        this.dhF = str;
        this.joW = imageView;
        this.dhm = str2;
    }

    public final boolean Kr() {
        Bitmap a = c.a(this.dhF, false, -1);
        if (a == null) {
            a = q.Kp().jT(this.dhF);
        }
        d.a(this.ktU, this.joW, this.dhm, a);
        return true;
    }

    public final boolean Ks() {
        return false;
    }
}
