package com.tencent.mm.plugin.gallery.view;

import com.tencent.mm.plugin.gallery.view.MultiGestureImageView.e;

class MultiGestureImageView$e$1 implements Runnable {
    final /* synthetic */ e jFm;

    MultiGestureImageView$e$1(e eVar) {
        this.jFm = eVar;
    }

    public final void run() {
        this.jFm.jFl.getImageMatrix().getValues(this.jFm.jFk);
        float imageHeight = ((float) this.jFm.jFl.getImageHeight()) * this.jFm.jFl.getScale();
        float f = this.jFm.jFk[5] + imageHeight;
        float i = (float) MultiGestureImageView.i(this.jFm.jFj);
        if (imageHeight < ((float) MultiGestureImageView.i(this.jFm.jFj))) {
            i = (((float) MultiGestureImageView.i(this.jFm.jFj)) / 2.0f) + (imageHeight / 2.0f);
        }
        i -= f;
        if (i <= 0.0f) {
            this.jFm.bwt = true;
        } else if (Math.abs(i) <= 5.0f) {
            this.jFm.bwt = true;
        } else {
            i = ((float) (((double) Math.abs(i)) - Math.pow(Math.sqrt((double) Math.abs(i)) - 1.0d, 2.0d))) * 2.0f;
        }
        this.jFm.jFl.V(0.0f, i);
    }
}
