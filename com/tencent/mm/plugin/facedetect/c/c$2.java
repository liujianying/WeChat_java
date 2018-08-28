package com.tencent.mm.plugin.facedetect.c;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;

class c$2 implements OnClickListener {
    final /* synthetic */ int bFq;
    final /* synthetic */ int bFr;
    final /* synthetic */ String dJG;
    final /* synthetic */ c iMZ;
    final /* synthetic */ boolean iNa;
    final /* synthetic */ Bundle iNb;

    c$2(c cVar, boolean z, int i, int i2, String str, Bundle bundle) {
        this.iMZ = cVar;
        this.iNa = z;
        this.bFq = i;
        this.bFr = i2;
        this.dJG = str;
        this.iNb = bundle;
    }

    public final void onClick(View view) {
        if (this.iNa) {
            c cVar = this.iMZ;
            cVar.aJv();
            cVar.hUE = true;
            return;
        }
        this.iMZ.a(this.bFq, this.bFr, this.dJG, this.iNb);
    }
}
