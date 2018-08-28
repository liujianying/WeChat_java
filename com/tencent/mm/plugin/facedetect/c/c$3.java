package com.tencent.mm.plugin.facedetect.c;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;

class c$3 implements OnClickListener {
    final /* synthetic */ int bFq;
    final /* synthetic */ int bFr;
    final /* synthetic */ String dJG;
    final /* synthetic */ c iMZ;
    final /* synthetic */ Bundle iNb;

    c$3(c cVar, int i, int i2, String str, Bundle bundle) {
        this.iMZ = cVar;
        this.bFq = i;
        this.bFr = i2;
        this.dJG = str;
        this.iNb = bundle;
    }

    public final void onClick(View view) {
        this.iMZ.a(this.bFq, this.bFr, this.dJG, this.iNb);
    }
}
