package com.tencent.mm.pluginsdk.ui.applet;

import android.view.View;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;

class k$4 implements OnLongClickListener {
    final /* synthetic */ int hW;
    final /* synthetic */ k qJE;
    final /* synthetic */ ViewGroup qJF;

    k$4(k kVar, ViewGroup viewGroup, int i) {
        this.qJE = kVar;
        this.qJF = viewGroup;
        this.hW = i;
    }

    public final boolean onLongClick(View view) {
        return this.qJE.qJD.oe(this.hW);
    }
}
