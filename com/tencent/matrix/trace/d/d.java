package com.tencent.matrix.trace.d;

import android.app.Activity;
import android.support.v4.app.Fragment;
import android.view.ViewTreeObserver.OnDrawListener;
import com.tencent.matrix.d.b;
import java.util.Iterator;
import java.util.LinkedList;

public final class d extends a implements OnDrawListener {
    private boolean bum;
    private final LinkedList<com.tencent.matrix.trace.b.a> buy = new LinkedList();

    private static final class a implements Runnable {
        com.tencent.matrix.trace.b.a buE;
        String buF;
        int buG;
        long buH;
        long buI;

        a(com.tencent.matrix.trace.b.a aVar, long j, long j2, String str, int i) {
            this.buE = aVar;
            this.buF = str;
            this.buG = i;
            this.buH = j;
            this.buI = j2;
        }

        public final void run() {
        }
    }

    public d(com.tencent.matrix.trace.a aVar) {
        super(aVar);
    }

    protected final String getTag() {
        return null;
    }

    public final void h(long j, long j2) {
        if (this.bum) {
            this.bum = false;
            int i = (int) ((j2 - j) / 16666668);
            if (i > 1) {
                Iterator it = this.buy.iterator();
                while (it.hasNext()) {
                    com.tencent.matrix.trace.b.a aVar = (com.tencent.matrix.trace.b.a) it.next();
                    aVar.a(j, j2, this.btH, i);
                    if (aVar.mHandler != null) {
                        final com.tencent.matrix.trace.b.a aVar2 = aVar;
                        final long j3 = j;
                        final long j4 = j2;
                        final int i2 = i;
                        aVar.mHandler.post(new Runnable() {
                            public final void run() {
                                aVar2.mHandler.post(new a(aVar2, j3, j4, d.this.btH, i2));
                            }
                        });
                    }
                }
            }
        }
    }

    public final void onChange(final Activity activity, Fragment fragment) {
        super.onChange(activity, fragment);
        b.i("Matrix.FrameTracer", "[onChange] activity:%s", activity.getClass().getSimpleName());
        activity.getWindow().getDecorView().post(new Runnable() {
            public final void run() {
                activity.getWindow().getDecorView().getViewTreeObserver().removeOnDrawListener(d.this);
                activity.getWindow().getDecorView().getViewTreeObserver().addOnDrawListener(d.this);
            }
        });
    }

    public final void onDraw() {
        this.bum = true;
    }

    public final void a(com.tencent.matrix.trace.b.a aVar) {
        if (!this.buy.contains(aVar)) {
            this.buy.add(aVar);
        }
    }

    public final void b(com.tencent.matrix.trace.b.a aVar) {
        this.buy.remove(aVar);
    }
}
