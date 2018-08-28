package com.davemorrissey.labs.subscaleview.view;

import android.content.Context;
import android.graphics.PointF;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import com.davemorrissey.labs.subscaleview.view.SubsamplingScaleImageView.b;
import com.tencent.mm.sdk.platformtools.x;

class SubsamplingScaleImageView$3 extends SimpleOnGestureListener {
    final /* synthetic */ SubsamplingScaleImageView abb;
    final /* synthetic */ Context val$context;

    SubsamplingScaleImageView$3(SubsamplingScaleImageView subsamplingScaleImageView, Context context) {
        this.abb = subsamplingScaleImageView;
        this.val$context = context;
    }

    public final boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        if (!SubsamplingScaleImageView.e(this.abb) || !SubsamplingScaleImageView.f(this.abb) || SubsamplingScaleImageView.g(this.abb) == null || motionEvent == null || motionEvent2 == null || ((Math.abs(motionEvent.getX() - motionEvent2.getX()) <= 50.0f && Math.abs(motionEvent.getY() - motionEvent2.getY()) <= 50.0f) || ((Math.abs(f) <= 500.0f && Math.abs(f2) <= 500.0f) || SubsamplingScaleImageView.h(this.abb)))) {
            return super.onFling(motionEvent, motionEvent2, f, f2);
        }
        PointF pointF = new PointF(SubsamplingScaleImageView.g(this.abb).x + (f * 0.25f), SubsamplingScaleImageView.g(this.abb).y + (0.25f * f2));
        b bVar = new b(this.abb, new PointF((((float) (this.abb.getWidth() / 2)) - pointF.x) / SubsamplingScaleImageView.i(this.abb), (((float) (this.abb.getHeight() / 2)) - pointF.y) / SubsamplingScaleImageView.i(this.abb)), (byte) 0);
        if (SubsamplingScaleImageView.hN().contains(Integer.valueOf(1))) {
            bVar.abp = 1;
            bVar.abv = false;
            b.a(bVar, 3).start();
            return true;
        }
        throw new IllegalArgumentException("Unknown easing type: 1");
    }

    public final boolean onSingleTapConfirmed(MotionEvent motionEvent) {
        if (SubsamplingScaleImageView.j(this.abb) != null) {
            boolean onSingleTapConfirmed = SubsamplingScaleImageView.j(this.abb).onSingleTapConfirmed(motionEvent);
            if (onSingleTapConfirmed) {
                return onSingleTapConfirmed;
            }
        }
        this.abb.performClick();
        return true;
    }

    public final boolean onDoubleTap(MotionEvent motionEvent) {
        if (!SubsamplingScaleImageView.k(this.abb) || !SubsamplingScaleImageView.f(this.abb) || SubsamplingScaleImageView.g(this.abb) == null) {
            return super.onDoubleTapEvent(motionEvent);
        }
        SubsamplingScaleImageView.a(this.abb, this.val$context);
        x.i(SubsamplingScaleImageView.hM(), "alvinluo onDoubleTap, quickScaledEnabled: %b", new Object[]{Boolean.valueOf(SubsamplingScaleImageView.l(this.abb))});
        if (SubsamplingScaleImageView.l(this.abb)) {
            SubsamplingScaleImageView.a(this.abb, new PointF(motionEvent.getX(), motionEvent.getY()));
            SubsamplingScaleImageView.b(this.abb, new PointF(SubsamplingScaleImageView.g(this.abb).x, SubsamplingScaleImageView.g(this.abb).y));
            SubsamplingScaleImageView.a(this.abb, SubsamplingScaleImageView.i(this.abb));
            SubsamplingScaleImageView.m(this.abb);
            SubsamplingScaleImageView.n(this.abb);
            SubsamplingScaleImageView.o(this.abb);
            SubsamplingScaleImageView.c(this.abb, this.abb.b(SubsamplingScaleImageView.p(this.abb)));
            SubsamplingScaleImageView.d(this.abb, new PointF(motionEvent.getX(), motionEvent.getY()));
            SubsamplingScaleImageView.e(this.abb, new PointF(SubsamplingScaleImageView.q(this.abb).x, SubsamplingScaleImageView.q(this.abb).y));
            SubsamplingScaleImageView.r(this.abb);
            return false;
        }
        SubsamplingScaleImageView.a(this.abb, this.abb.b(new PointF(motionEvent.getX(), motionEvent.getY())), new PointF(motionEvent.getX(), motionEvent.getY()));
        return true;
    }
}
