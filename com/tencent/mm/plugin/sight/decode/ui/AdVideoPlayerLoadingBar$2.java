package com.tencent.mm.plugin.sight.decode.ui;

import android.widget.FrameLayout.LayoutParams;

class AdVideoPlayerLoadingBar$2 implements Runnable {
    final /* synthetic */ AdVideoPlayerLoadingBar ndw;

    AdVideoPlayerLoadingBar$2(AdVideoPlayerLoadingBar adVideoPlayerLoadingBar) {
        this.ndw = adVideoPlayerLoadingBar;
    }

    public final void run() {
        LayoutParams layoutParams = (LayoutParams) this.ndw.ndk.getLayoutParams();
        layoutParams.leftMargin = (((LayoutParams) this.ndw.ndj.getLayoutParams()).leftMargin - this.ndw.ndk.getPaddingLeft()) - (((this.ndw.getBarPointWidth() - this.ndw.ndk.getPaddingLeft()) - this.ndw.ndk.getPaddingRight()) / 2);
        this.ndw.ndk.setLayoutParams(layoutParams);
    }
}
