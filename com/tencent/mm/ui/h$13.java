package com.tencent.mm.ui;

import android.graphics.Bitmap;
import android.view.View;
import com.tencent.mm.ak.a.c.g;
import com.tencent.mm.ak.a.d.b;
import com.tencent.mm.g.a.gq;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.ui.base.preference.IconPreference;

class h$13 implements g {
    final /* synthetic */ String bAj;
    final /* synthetic */ String dAy;
    final /* synthetic */ String fhQ;
    final /* synthetic */ gq kdk;
    final /* synthetic */ int pre;
    final /* synthetic */ h tiG;
    final /* synthetic */ IconPreference tiO;
    final /* synthetic */ int tiP;
    final /* synthetic */ String tiQ;

    h$13(h hVar, gq gqVar, IconPreference iconPreference, int i, String str, int i2, String str2, String str3, String str4) {
        this.tiG = hVar;
        this.kdk = gqVar;
        this.tiO = iconPreference;
        this.tiP = i;
        this.bAj = str;
        this.pre = i2;
        this.tiQ = str2;
        this.dAy = str3;
        this.fhQ = str4;
    }

    public final void me(String str) {
        ah.A(new 1(this));
    }

    public final Bitmap a(String str, b bVar) {
        return null;
    }

    public final void a(String str, View view, b bVar) {
        this.kdk.bPN.nc = 2;
        this.kdk.bPN.url = str;
        a.sFg.m(this.kdk);
        if (bVar != null) {
            int i = bVar.bJu;
            if (bVar.status != 0 || bVar.bitmap == null) {
                ah.A(new 3(this, i));
            } else {
                ah.A(new 2(this, bVar.bitmap, i));
            }
        }
    }
}
