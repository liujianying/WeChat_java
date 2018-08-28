package com.tencent.mm.plugin.appbrand.widget;

import android.support.annotation.Keep;

class CircleProgressDrawable$RingPathTransform {
    public float kb;
    public float kc;
    public float kd;

    private CircleProgressDrawable$RingPathTransform() {
        this.kb = 0.0f;
        this.kc = 0.0f;
        this.kd = 0.0f;
    }

    /* synthetic */ CircleProgressDrawable$RingPathTransform(byte b) {
        this();
    }

    @Keep
    public void setTrimPathStart(float f) {
        this.kb = f;
    }

    @Keep
    public void setTrimPathEnd(float f) {
        this.kc = f;
    }

    @Keep
    public void setTrimPathOffset(float f) {
        this.kd = f;
    }
}
