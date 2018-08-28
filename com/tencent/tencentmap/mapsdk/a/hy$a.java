package com.tencent.tencentmap.mapsdk.a;

import android.graphics.PointF;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import com.tencent.mm.plugin.game.gamewebview.jsapi.biz.b;

class hy$a extends SimpleOnGestureListener {
    final /* synthetic */ hy a;
    private PointF b;
    private boolean c;

    private hy$a(hy hyVar) {
        this.a = hyVar;
        this.b = new PointF();
        this.c = true;
    }

    public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
        hy.a(this.a).b(motionEvent.getX(), motionEvent.getY());
        return true;
    }

    public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        hy.a(this.a).c(f, f2);
        return true;
    }

    public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        hy.a(this.a).d(-f, -f2);
        return true;
    }

    public boolean onDoubleTap(MotionEvent motionEvent) {
        return false;
    }

    public void onLongPress(MotionEvent motionEvent) {
        if (!hy.b(this.a)) {
            hy.a(this.a).e(motionEvent.getX(), motionEvent.getY());
        }
    }

    public boolean onDoubleTapEvent(MotionEvent motionEvent) {
        float x = motionEvent.getX();
        float y = motionEvent.getY();
        switch (motionEvent.getAction() & b.CTRL_BYTE) {
            case 0:
                this.c = true;
                hy.c(this.a).setIsLongpressEnabled(false);
                this.b.set(motionEvent.getX(), motionEvent.getY());
                hy.a(this.a).f(x, y);
                break;
            case 1:
                if (this.c) {
                    if (hy.a(this.a, x, y)) {
                        hy.a(this.a).a(x, y);
                    } else {
                        hy.a(this.a).a(x, y);
                    }
                }
                this.b.set(0.0f, 0.0f);
                hy.c(this.a).setIsLongpressEnabled(true);
                hy.a(this.a).h(x, y);
                break;
            case 2:
                float f = y - this.b.y;
                if (Math.abs(x - this.b.x) > 10.0f || Math.abs(f) > 10.0f) {
                    this.c = false;
                    hy.a(this.a).g(x, y);
                }
                hy.c(this.a).setIsLongpressEnabled(true);
                break;
        }
        return true;
    }
}
