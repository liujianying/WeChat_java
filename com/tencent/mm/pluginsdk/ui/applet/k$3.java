package com.tencent.mm.pluginsdk.ui.applet;

import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;

class k$3 implements OnClickListener {
    final /* synthetic */ int hW;
    final /* synthetic */ k qJE;
    final /* synthetic */ ViewGroup qJF;

    k$3(k kVar, ViewGroup viewGroup, int i) {
        this.qJE = kVar;
        this.qJF = viewGroup;
        this.hW = i;
    }

    public final void onClick(View view) {
        this.qJE.qIS.BZ(this.hW);
    }
}
