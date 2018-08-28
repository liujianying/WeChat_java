package com.tencent.mm.plugin.sns.ui;

class MaskImageView$1 implements Runnable {
    final /* synthetic */ MaskImageView nOL;

    MaskImageView$1(MaskImageView maskImageView) {
        this.nOL = maskImageView;
    }

    public final void run() {
        this.nOL.setPressed(false);
        this.nOL.invalidate();
    }
}
