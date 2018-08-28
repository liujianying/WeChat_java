package com.tencent.matrix.trace.core;

import android.app.Activity;
import android.support.v4.app.Fragment;
import android.view.Choreographer;
import android.view.Choreographer.FrameCallback;
import com.tencent.matrix.trace.core.a.a;
import java.util.Iterator;
import java.util.LinkedList;

public final class b implements FrameCallback, a {
    private static b btx;
    public boolean btA;
    public long btB;
    public final LinkedList<com.tencent.matrix.trace.b.b> bty = new LinkedList();
    public Choreographer btz;

    private b() {
    }

    public static b tF() {
        if (btx == null) {
            btx = new b();
        }
        return btx;
    }

    public final void doFrame(long j) {
        if (j < this.btB) {
            com.tencent.matrix.d.b.w("Matrix.FrameBeat", "frameTimeNanos < mLastFrameNanos, just return", new Object[0]);
            this.btB = j;
            this.btz.postFrameCallback(this);
        } else if (this.bty != null) {
            Iterator it = this.bty.iterator();
            while (it.hasNext()) {
                ((com.tencent.matrix.trace.b.b) it.next()).h(this.btB, j);
            }
            this.btz.postFrameCallback(this);
            this.btB = j;
        }
    }

    public final void onFront(Activity activity) {
        com.tencent.matrix.d.b.i("Matrix.FrameBeat", "[onFront] isExist:%s postFrameCallback", Boolean.valueOf(this.btA));
        if (this.btA && this.btz != null) {
            this.btB = System.nanoTime();
            this.btz.removeFrameCallback(this);
            this.btz.postFrameCallback(this);
        }
    }

    public final void onBackground(Activity activity) {
        com.tencent.matrix.d.b.i("Matrix.FrameBeat", "[onBackground] isExist:%s removeFrameCallback", Boolean.valueOf(this.btA));
        if (this.btA && this.btz != null) {
            this.btz.removeFrameCallback(this);
        }
    }

    public final void onChange(Activity activity, Fragment fragment) {
        com.tencent.matrix.d.b.i("Matrix.FrameBeat", "[onChange] reset mLastFrameNanos, current activity:%s", activity.getClass().getSimpleName());
    }

    public final void onActivityCreated(Activity activity) {
    }

    public final void onActivityPause(Activity activity) {
    }

    public final void onActivityStarted(Activity activity) {
    }
}
