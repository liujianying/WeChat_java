package com.tencent.mm.plugin.gallery.view;

import com.tencent.mm.plugin.gallery.view.MultiGestureImageView.g;

class MultiGestureImageView$g$1 implements Runnable {
    final /* synthetic */ g jFo;

    MultiGestureImageView$g$1(g gVar) {
        this.jFo = gVar;
    }

    public final void run() {
        this.jFo.jFl.getImageMatrix().getValues(this.jFo.jFk);
        float f = this.jFo.jFk[2];
        float scale = this.jFo.jFl.getScale() * ((float) this.jFo.jFl.getImageWidth());
        if (scale < ((float) MultiGestureImageView.g(this.jFo.jFj))) {
            scale = (((float) MultiGestureImageView.g(this.jFo.jFj)) / 2.0f) - (scale / 2.0f);
        } else {
            scale = 0.0f;
        }
        scale -= f;
        if (scale >= 0.0f) {
            this.jFo.bwt = true;
        } else if (Math.abs(scale) <= 5.0f) {
            this.jFo.bwt = true;
        } else {
            scale = (-((float) (((double) Math.abs(scale)) - Math.pow(Math.sqrt((double) Math.abs(scale)) - 1.0d, 2.0d)))) * 2.0f;
        }
        this.jFo.jFl.V(scale, 0.0f);
    }
}
