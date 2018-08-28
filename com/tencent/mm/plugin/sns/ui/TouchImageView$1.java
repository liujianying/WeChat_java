package com.tencent.mm.plugin.sns.ui;

class TouchImageView$1 implements Runnable {
    final /* synthetic */ TouchImageView oib;

    TouchImageView$1(TouchImageView touchImageView) {
        this.oib = touchImageView;
    }

    public final void run() {
        this.oib.setPressed(false);
        this.oib.invalidate();
    }
}
