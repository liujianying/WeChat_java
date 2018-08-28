package com.tencent.mm.plugin.gallery.view;

import com.tencent.mm.plugin.gallery.view.MultiGestureImageView.f;

class MultiGestureImageView$f$1 implements Runnable {
    final /* synthetic */ f jFn;

    MultiGestureImageView$f$1(f fVar) {
        this.jFn = fVar;
    }

    public final void run() {
        float g;
        this.jFn.jFl.getImageMatrix().getValues(this.jFn.jFk);
        float scale = this.jFn.jFl.getScale() * ((float) this.jFn.jFl.getImageWidth());
        float imageHeight = ((float) this.jFn.jFl.getImageHeight()) * this.jFn.jFl.getScale();
        float f = this.jFn.jFk[2];
        float f2 = this.jFn.jFk[5];
        float f3 = this.jFn.jFk[2] + scale;
        float f4 = this.jFn.jFk[5] + imageHeight;
        float f5 = 0.0f;
        float i = (float) MultiGestureImageView.i(this.jFn.jFj);
        float f6 = 0.0f;
        float g2 = (float) MultiGestureImageView.g(this.jFn.jFj);
        if (imageHeight < ((float) MultiGestureImageView.i(this.jFn.jFj))) {
            f5 = (((float) MultiGestureImageView.i(this.jFn.jFj)) / 2.0f) - (imageHeight / 2.0f);
            imageHeight = (((float) MultiGestureImageView.i(this.jFn.jFj)) / 2.0f) + (imageHeight / 2.0f);
        } else {
            imageHeight = i;
        }
        i = f5 - f2;
        imageHeight -= f4;
        if (i >= 0.0f) {
            if (imageHeight > 0.0f) {
                i = imageHeight;
            } else {
                i = 0.0f;
            }
        }
        if (scale < ((float) MultiGestureImageView.g(this.jFn.jFj))) {
            g = (((float) MultiGestureImageView.g(this.jFn.jFj)) / 2.0f) + (scale / 2.0f);
            f6 = (((float) MultiGestureImageView.g(this.jFn.jFj)) / 2.0f) - (scale / 2.0f);
        } else {
            g = g2;
        }
        imageHeight = f6 - f;
        g -= f3;
        if (imageHeight >= 0.0f) {
            if (g > 0.0f) {
                imageHeight = g;
            } else {
                imageHeight = 0.0f;
            }
        }
        if (Math.abs(imageHeight) > 5.0f || Math.abs(i) > 5.0f) {
            if (imageHeight >= 0.0f) {
                imageHeight = ((float) (((double) Math.abs(imageHeight)) - Math.pow(Math.sqrt((double) Math.abs(imageHeight)) - 1.0d, 2.0d))) * 2.0f;
            } else {
                imageHeight = (-((float) (((double) Math.abs(imageHeight)) - Math.pow(Math.sqrt((double) Math.abs(imageHeight)) - 1.0d, 2.0d)))) * 2.0f;
            }
            if (i >= 0.0f) {
                i = ((float) (((double) Math.abs(i)) - Math.pow(Math.sqrt((double) Math.abs(i)) - 1.0d, 2.0d))) * 2.0f;
            } else {
                i = (-((float) (((double) Math.abs(i)) - Math.pow(Math.sqrt((double) Math.abs(i)) - 1.0d, 2.0d)))) * 2.0f;
            }
        } else {
            this.jFn.bwt = true;
        }
        this.jFn.jFl.V(imageHeight, i);
    }
}
