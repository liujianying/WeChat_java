package com.tencent.mm.plugin.sight.decode.ui;

import android.view.ViewGroup.LayoutParams;
import com.tencent.mm.plugin.sight.decode.ui.SightPlayImageView.a;

class SightPlayImageView$a$1 implements Runnable {
    final /* synthetic */ SightPlayImageView ndH;
    final /* synthetic */ LayoutParams ndI;
    final /* synthetic */ a ndJ;

    SightPlayImageView$a$1(a aVar, SightPlayImageView sightPlayImageView, LayoutParams layoutParams) {
        this.ndJ = aVar;
        this.ndH = sightPlayImageView;
        this.ndI = layoutParams;
    }

    public final void run() {
        this.ndH.setLayoutParams(this.ndI);
    }
}
