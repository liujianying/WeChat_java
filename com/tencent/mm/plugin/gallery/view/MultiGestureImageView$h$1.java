package com.tencent.mm.plugin.gallery.view;

import com.tencent.mm.plugin.gallery.view.MultiGestureImageView.h;

class MultiGestureImageView$h$1 implements Runnable {
    final /* synthetic */ h jFp;

    MultiGestureImageView$h$1(h hVar) {
        this.jFp = hVar;
    }

    public final void run() {
        this.jFp.jFl.getImageMatrix().getValues(this.jFp.jFk);
        float imageWidth = ((float) this.jFp.jFl.getImageWidth()) * this.jFp.jFl.getScale();
        float f = this.jFp.jFk[2] + imageWidth;
        float g = (float) MultiGestureImageView.g(this.jFp.jFj);
        if (imageWidth < ((float) MultiGestureImageView.g(this.jFp.jFj))) {
            g = (((float) MultiGestureImageView.g(this.jFp.jFj)) / 2.0f) + (imageWidth / 2.0f);
        }
        g -= f;
        if (g <= 0.0f) {
            this.jFp.bwt = true;
        } else if (Math.abs(g) <= 5.0f) {
            this.jFp.bwt = true;
        } else {
            g = ((float) (((double) Math.abs(g)) - Math.pow(Math.sqrt((double) Math.abs(g)) - 1.0d, 2.0d))) * 2.0f;
        }
        this.jFp.jFl.V(g, 0.0f);
    }
}
