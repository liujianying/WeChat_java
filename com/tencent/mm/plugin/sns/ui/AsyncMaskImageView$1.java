package com.tencent.mm.plugin.sns.ui;

class AsyncMaskImageView$1 implements Runnable {
    final /* synthetic */ AsyncMaskImageView nLq;

    AsyncMaskImageView$1(AsyncMaskImageView asyncMaskImageView) {
        this.nLq = asyncMaskImageView;
    }

    public final void run() {
        this.nLq.setPressed(false);
        this.nLq.invalidate();
    }
}
