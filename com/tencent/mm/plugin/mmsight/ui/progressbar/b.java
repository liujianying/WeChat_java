package com.tencent.mm.plugin.mmsight.ui.progressbar;

import android.animation.ValueAnimator;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.PointF;

public final class b {
    ValueAnimator gGc;
    float lrh = 0.0f;
    a lri;
    a lrj;
    boolean lrk = false;
    public a lrl;
    PointF lrm;
    PointF lrn;
    PointF lro;
    PointF lrp;
    PointF lrq;
    PointF lrr;
    float lrs = 0.0f;
    float lrt = 0.0f;
    float lru = 0.0f;
    float lrv = 0.0f;
    Path lrw;
    private Paint lrx = null;

    public b(a aVar, a aVar2, a aVar3) {
        this.lri = aVar;
        this.lrj = aVar2;
        this.lrl = aVar3;
        this.lrt = ((float) MMSightProgressBar.iGr) * 2.0f;
        this.lru = ((float) (-MMSightProgressBar.iGr)) * 0.5f;
        this.lrw = new Path();
        this.lrx = new Paint();
        this.lrx.setAntiAlias(true);
        this.lrx.setStyle(Style.FILL);
    }
}
