package com.tencent.mm.plugin.bottle.ui;

import android.graphics.drawable.AnimationDrawable;

class LightHouseImageView$1 implements Runnable {
    final /* synthetic */ int Xt;
    final /* synthetic */ LightHouseImageView hlI;

    LightHouseImageView$1(LightHouseImageView lightHouseImageView, int i) {
        this.hlI = lightHouseImageView;
        this.Xt = i;
    }

    public final void run() {
        LightHouseImageView.a(this.hlI, this.Xt);
        LightHouseImageView.a(this.hlI, (AnimationDrawable) this.hlI.getBackground());
        if (LightHouseImageView.a(this.hlI) != null) {
            LightHouseImageView.b(this.hlI);
            LightHouseImageView.a(this.hlI).start();
        }
    }
}
