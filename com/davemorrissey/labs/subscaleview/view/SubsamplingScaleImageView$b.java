package com.davemorrissey.labs.subscaleview.view;

import android.graphics.PointF;
import com.davemorrissey.labs.subscaleview.view.SubsamplingScaleImageView.a;
import com.davemorrissey.labs.subscaleview.view.SubsamplingScaleImageView.d;
import com.davemorrissey.labs.subscaleview.view.SubsamplingScaleImageView.g;
import com.tencent.mm.sdk.platformtools.x;

public final class SubsamplingScaleImageView$b {
    final /* synthetic */ SubsamplingScaleImageView abb;
    boolean abo;
    int abp;
    private int abq;
    private d abr;
    private final float abs;
    private final PointF abt;
    private final PointF abu;
    boolean abv;
    long duration;

    /* synthetic */ SubsamplingScaleImageView$b(SubsamplingScaleImageView subsamplingScaleImageView, float f, PointF pointF, PointF pointF2, byte b) {
        this(subsamplingScaleImageView, f, pointF, pointF2);
    }

    private SubsamplingScaleImageView$b(SubsamplingScaleImageView subsamplingScaleImageView, PointF pointF) {
        this.abb = subsamplingScaleImageView;
        this.duration = 500;
        this.abp = 2;
        this.abq = 1;
        this.abo = true;
        this.abv = true;
        this.abs = SubsamplingScaleImageView.i(subsamplingScaleImageView);
        this.abt = pointF;
        this.abu = null;
    }

    private SubsamplingScaleImageView$b(SubsamplingScaleImageView subsamplingScaleImageView, float f, PointF pointF) {
        this.abb = subsamplingScaleImageView;
        this.duration = 500;
        this.abp = 2;
        this.abq = 1;
        this.abo = true;
        this.abv = true;
        this.abs = f;
        this.abt = pointF;
        this.abu = null;
    }

    private SubsamplingScaleImageView$b(SubsamplingScaleImageView subsamplingScaleImageView, float f, PointF pointF, PointF pointF2) {
        this.abb = subsamplingScaleImageView;
        this.duration = 500;
        this.abp = 2;
        this.abq = 1;
        this.abo = true;
        this.abv = true;
        this.abs = f;
        this.abt = pointF;
        this.abu = pointF2;
    }

    public final void start() {
        if (!(SubsamplingScaleImageView.v(this.abb) == null || SubsamplingScaleImageView.v(this.abb).abr == null)) {
            try {
                SubsamplingScaleImageView.v(this.abb);
            } catch (Exception e) {
                x.w(SubsamplingScaleImageView.hM(), "Error thrown by animation listener", new Object[]{e});
            }
        }
        int width = (((this.abb.getWidth() - this.abb.getPaddingRight()) - this.abb.getPaddingLeft()) / 2) + this.abb.getPaddingLeft();
        int height = (((this.abb.getHeight() - this.abb.getPaddingBottom()) - this.abb.getPaddingTop()) / 2) + this.abb.getPaddingTop();
        float b = SubsamplingScaleImageView.b(this.abb, this.abs);
        PointF a = this.abv ? SubsamplingScaleImageView.a(this.abb, this.abt.x, this.abt.y, b, new PointF()) : this.abt;
        SubsamplingScaleImageView.a(this.abb, new a((byte) 0));
        SubsamplingScaleImageView.v(this.abb).ZH = SubsamplingScaleImageView.i(this.abb);
        SubsamplingScaleImageView.v(this.abb).abi = b;
        SubsamplingScaleImageView.v(this.abb).time = System.currentTimeMillis();
        SubsamplingScaleImageView.v(this.abb).abl = a;
        SubsamplingScaleImageView.v(this.abb).abj = this.abb.getCenter();
        SubsamplingScaleImageView.v(this.abb).abk = a;
        SubsamplingScaleImageView.v(this.abb).abm = this.abb.c(a);
        SubsamplingScaleImageView.v(this.abb).abn = new PointF((float) width, (float) height);
        SubsamplingScaleImageView.v(this.abb).duration = this.duration;
        SubsamplingScaleImageView.v(this.abb).abo = this.abo;
        SubsamplingScaleImageView.v(this.abb).abp = this.abp;
        SubsamplingScaleImageView.v(this.abb).abq = this.abq;
        SubsamplingScaleImageView.v(this.abb).time = System.currentTimeMillis();
        SubsamplingScaleImageView.v(this.abb).abr = this.abr;
        if (this.abu != null) {
            float f = this.abu.x - (SubsamplingScaleImageView.v(this.abb).abj.x * b);
            float f2 = this.abu.y - (SubsamplingScaleImageView.v(this.abb).abj.y * b);
            g gVar = new g(b, new PointF(f, f2), (byte) 0);
            SubsamplingScaleImageView.a(this.abb, gVar);
            SubsamplingScaleImageView.v(this.abb).abn = new PointF((gVar.ZI.x - f) + this.abu.x, (gVar.ZI.y - f2) + this.abu.y);
        }
        this.abb.invalidate();
    }
}
