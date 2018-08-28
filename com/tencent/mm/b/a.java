package com.tencent.mm.b;

import android.animation.Animator.AnimatorListener;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.view.animation.LinearInterpolator;
import com.tencent.mm.d.c;
import com.tencent.mm.sdk.platformtools.x;

public final class a extends b {
    private int bwf = 200;
    private ValueAnimator bwg;
    c bwh;
    public float bwi;
    public float bwj;
    public float bwk;
    public Rect bwl;
    public RectF bwm;
    Matrix bwn;
    public long bwo = 0;
    public AnimatorListener bwp;

    public a(c cVar) {
        this.bwh = cVar;
        this.bwn = new Matrix();
        this.bwm = new RectF();
    }

    public final void play() {
        x.i("MicroMsg.CropActionUpAnim", "[play]");
        if (this.bwt) {
            this.bwu = false;
            this.bwt = false;
            PropertyValuesHolder ofFloat = PropertyValuesHolder.ofFloat("scale", new float[]{1.0f, this.bwi});
            PropertyValuesHolder ofFloat2 = PropertyValuesHolder.ofFloat("deltaX", new float[]{0.0f, this.bwj});
            PropertyValuesHolder ofFloat3 = PropertyValuesHolder.ofFloat("deltaY", new float[]{0.0f, this.bwk});
            PropertyValuesHolder ofFloat4 = PropertyValuesHolder.ofFloat("background_alpha", new float[]{0.0f, 255.0f});
            this.bwg = ValueAnimator.ofPropertyValuesHolder(new PropertyValuesHolder[]{ofFloat, ofFloat2, ofFloat3, ofFloat4});
            this.bwg.addUpdateListener(new 1(this));
            this.bwg.addListener(new 2(this));
            this.bwg.setInterpolator(new LinearInterpolator());
            this.bwg.setDuration((long) this.bwf);
            this.bwg.setStartDelay(this.bwo);
            this.bwg.start();
        }
    }

    public final void cancel() {
        x.d("MicroMsg.CropActionUpAnim", "[cancel]");
        this.bwu = false;
        this.bwt = true;
        if (this.bwg != null) {
            this.bwg.cancel();
        }
    }
}
