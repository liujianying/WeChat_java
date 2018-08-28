package com.tencent.mm.plugin.gallery.view;

import com.tencent.mm.plugin.gallery.view.MultiGestureImageView.i;

class MultiGestureImageView$i$1 implements Runnable {
    final /* synthetic */ i jFq;

    MultiGestureImageView$i$1(i iVar) {
        this.jFq = iVar;
    }

    public final void run() {
        this.jFq.jFl.getImageMatrix().getValues(this.jFq.jFk);
        float f = this.jFq.jFk[5];
        float scale = this.jFq.jFl.getScale() * ((float) this.jFq.jFl.getImageHeight());
        if (scale < ((float) MultiGestureImageView.i(this.jFq.jFj))) {
            scale = (((float) MultiGestureImageView.i(this.jFq.jFj)) / 2.0f) - (scale / 2.0f);
        } else {
            scale = 0.0f;
        }
        scale -= f;
        if (scale >= 0.0f) {
            this.jFq.bwt = true;
        } else if (Math.abs(scale) <= 5.0f) {
            this.jFq.bwt = true;
        } else {
            scale = (-((float) (((double) Math.abs(scale)) - Math.pow(Math.sqrt((double) Math.abs(scale)) - 1.0d, 2.0d)))) * 2.0f;
        }
        this.jFq.jFl.V(0.0f, scale);
    }
}
