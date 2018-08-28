package com.tencent.mm.plugin.ipcall.ui;

import android.graphics.Bitmap;
import android.widget.ImageView;
import com.tencent.mm.sdk.platformtools.at.a;
import java.lang.ref.WeakReference;

class d$1 implements a {
    final /* synthetic */ String dhF;
    final /* synthetic */ String dhm;
    private boolean dtu = false;
    final /* synthetic */ ImageView joW;
    final /* synthetic */ String ktT;
    final /* synthetic */ d ktU;

    d$1(d dVar, String str, String str2, ImageView imageView, String str3) {
        this.ktU = dVar;
        this.ktT = str;
        this.dhm = str2;
        this.joW = imageView;
        this.dhF = str3;
    }

    public final boolean Kr() {
        Bitmap ay = com.tencent.mm.plugin.ipcall.b.a.ay(this.ktU.context, this.ktT);
        if (ay != null) {
            this.ktU.ktS.put(this.dhm, new WeakReference(ay));
            this.dtu = true;
            d.a(this.ktU, this.joW, this.dhm, ay);
        }
        return true;
    }

    public final boolean Ks() {
        if (!this.dtu) {
            d dVar = this.ktU;
            String str = this.ktT;
            String str2 = this.dhF;
            dVar.ktR.c(new d$2(dVar, str2, this.joW, d.ds(str, str2)));
        }
        return true;
    }
}
