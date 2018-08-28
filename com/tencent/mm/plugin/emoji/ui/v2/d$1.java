package com.tencent.mm.plugin.emoji.ui.v2;

import android.view.View;
import android.view.View.OnClickListener;

class d$1 implements OnClickListener {
    final /* synthetic */ int gPT;
    final /* synthetic */ PaddingImageView ish;
    final /* synthetic */ d isi;

    d$1(d dVar, PaddingImageView paddingImageView, int i) {
        this.isi = dVar;
        this.ish = paddingImageView;
        this.gPT = i;
    }

    public final void onClick(View view) {
        if (d.a(this.isi) != null) {
            d.a(this.isi).ms(this.gPT);
        }
    }
}
