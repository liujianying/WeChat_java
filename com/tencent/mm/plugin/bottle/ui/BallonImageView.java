package com.tencent.mm.plugin.bottle.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.animation.Animation;
import android.view.animation.Transformation;
import android.widget.ImageView;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.a;

public class BallonImageView extends ImageView {
    private Animation hkg = new Animation() {
        private int ftm;
        private int ftn;
        private float hkh = 0.1f;
        private float hki = AnonymousClass1.E(0.1f, 0.8f);
        private float hkj = 0.1f;
        private float hkk = AnonymousClass1.E(0.1f, 0.3f);
        private float hkl = 1.0f;
        private float hkm = AnonymousClass1.E(0.7f, 1.0f);
        private float hkn;
        private float hko;
        private float hkp;
        private float hkq;

        protected final void applyTransformation(float f, Transformation transformation) {
            float f2 = this.hkn;
            float f3 = this.hkp;
            if (this.hkn != this.hko) {
                f2 = this.hkn + ((this.hko - this.hkn) * f);
            }
            if (this.hkp != this.hkq) {
                f3 = this.hkp + ((this.hkq - this.hkp) * f);
            }
            transformation.getMatrix().setTranslate(f2, f3);
            f2 = this.hkl + ((this.hkm - this.hkl) * f);
            transformation.getMatrix().postScale(f2, f2);
            if (f == 1.0f) {
                this.hkh = this.hki;
                this.hkj = this.hkk;
                this.hki = AnonymousClass1.E(0.1f, 0.8f);
                this.hkk = AnonymousClass1.E(0.1f, 0.3f);
                this.hkl = this.hkm;
                this.hkm = AnonymousClass1.E(0.7f, 1.0f);
                aum();
            }
        }

        public final void initialize(int i, int i2, int i3, int i4) {
            super.initialize(i, i2, i3, i4);
            this.ftm = i3;
            this.ftn = i4;
            aum();
        }

        private void aum() {
            this.hkn = this.hkh * ((float) this.ftm);
            this.hko = this.hki * ((float) this.ftm);
            this.hkp = this.hkj * ((float) this.ftn);
            this.hkq = this.hkk * ((float) this.ftn);
        }

        private static float E(float f, float f2) {
            return (((float) Math.random()) * (f2 - f)) + f;
        }
    };

    public BallonImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.hkg.setRepeatCount(-1);
        this.hkg.setDuration(15000);
        this.hkg.setFillAfter(true);
    }

    public BallonImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.hkg.setRepeatCount(-1);
        this.hkg.setDuration(15000);
        this.hkg.setFillAfter(true);
    }

    public void setVisibility(int i) {
        if (i == 0) {
            setAnimation(this.hkg);
        } else {
            a.c(this, this.hkg);
        }
        super.setVisibility(i);
    }
}
