package com.tencent.mm.plugin.sight.decode.ui;

import android.view.ViewGroup.LayoutParams;

class SightPlayTextureView$3 implements Runnable {
    final /* synthetic */ LayoutParams ndI;
    final /* synthetic */ SightPlayTextureView ndL;

    SightPlayTextureView$3(SightPlayTextureView sightPlayTextureView, LayoutParams layoutParams) {
        this.ndL = sightPlayTextureView;
        this.ndI = layoutParams;
    }

    public final void run() {
        this.ndL.setLayoutParams(this.ndI);
    }
}
