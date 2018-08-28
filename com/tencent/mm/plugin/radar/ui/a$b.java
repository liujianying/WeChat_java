package com.tencent.mm.plugin.radar.ui;

import android.view.View;
import android.view.View.OnClickListener;
import b.c.b.e;

final class a$b implements OnClickListener {
    final /* synthetic */ a mkH;
    final /* synthetic */ int mkI;

    a$b(a aVar, int i) {
        this.mkH = aVar;
        this.mkI = i;
    }

    public final void onClick(View view) {
        RadarSpecialGridView$a onItemClickListener = this.mkH.mkF.getOnItemClickListener();
        if (onItemClickListener != null) {
            int i = this.mkI;
            e.h(view, "v");
            onItemClickListener.f(i, view);
        }
    }
}
