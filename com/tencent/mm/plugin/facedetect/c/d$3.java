package com.tencent.mm.plugin.facedetect.c;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;

class d$3 implements OnClickListener {
    final /* synthetic */ int bFq;
    final /* synthetic */ int bFr;
    final /* synthetic */ String dJG;
    final /* synthetic */ Bundle iNb;
    final /* synthetic */ d iNd;

    d$3(d dVar, int i, int i2, String str, Bundle bundle) {
        this.iNd = dVar;
        this.bFq = i;
        this.bFr = i2;
        this.dJG = str;
        this.iNb = bundle;
    }

    public final void onClick(View view) {
        this.iNd.a(this.bFq, this.bFr, this.dJG, this.iNb);
    }
}
