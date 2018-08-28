package com.tencent.mm.ui.tools;

import android.content.Context;
import android.view.GestureDetector;
import android.view.GestureDetector.OnGestureListener;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.x;

public final class j implements OnGestureListener {
    public final GestureDetector ZY = new GestureDetector(this.context, this);
    private final Context context;
    public a uAc;
    private final float uAd;
    private final float uAe;
    private final int uj;
    private final int uk;

    public interface a {
    }

    public j(Context context) {
        this.context = context;
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        this.uj = viewConfiguration.getScaledMinimumFlingVelocity();
        this.uk = viewConfiguration.getScaledMaximumFlingVelocity();
        this.uAd = (float) b.b(context, 70.0f);
        this.uAe = (float) b.b(context, 50.0f);
    }

    public final boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        if (this.uAc == null) {
            return true;
        }
        x.v("MicroMsg.MMGestureDetector", "lastX:%f, curX:%f, lastY:%f, curY:%f, vX:%f, vY:%f", new Object[]{Float.valueOf(motionEvent.getX()), Float.valueOf(motionEvent2.getX()), Float.valueOf(motionEvent.getY()), Float.valueOf(motionEvent2.getY()), Float.valueOf(f), Float.valueOf(f2)});
        float abs = Math.abs(motionEvent2.getY() - motionEvent.getY());
        float abs2 = Math.abs(motionEvent2.getX() - motionEvent.getX());
        if (abs < this.uAe && f > 800.0f && abs2 > this.uAd) {
            return true;
        }
        if (abs < this.uAe && f < -800.0f && abs2 < (-this.uAd)) {
            return true;
        }
        if (abs2 < this.uAe && f2 > 800.0f) {
            return true;
        }
        if (abs2 >= this.uAe || f2 >= -800.0f) {
            return false;
        }
        return true;
    }

    public final boolean onDown(MotionEvent motionEvent) {
        return false;
    }

    public final void onShowPress(MotionEvent motionEvent) {
    }

    public final boolean onSingleTapUp(MotionEvent motionEvent) {
        return false;
    }

    public final boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        return false;
    }

    public final void onLongPress(MotionEvent motionEvent) {
    }
}
