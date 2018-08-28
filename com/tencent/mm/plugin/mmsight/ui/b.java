package com.tencent.mm.plugin.mmsight.ui;

import android.os.Looper;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

public final class b {
    boolean bTv;
    private int duration;
    al eaF = null;
    private float lpp = 0.0f;
    private float lpq;
    float lpr;
    long lps;
    float lpt;
    a lpu;
    private Runnable lpv = new Runnable() {
        public final void run() {
            b.a(b.this);
            if (!b.this.bTv) {
                x.i("MicroMsg.ProgressHandlerAnimator", "isStart is false now");
            } else if (b.this.lpt < b.this.lpr) {
                b.this.eaF.post(this);
            } else {
                b.this.bTv = false;
                x.i("MicroMsg.ProgressHandlerAnimator", "reach end, currentValue: %s, end: %s", new Object[]{Float.valueOf(b.this.lpt), Float.valueOf(b.this.lpr)});
                if (b.this.lpu != null) {
                    b.this.lpu.onAnimationEnd();
                }
            }
        }
    };

    static /* synthetic */ void a(b bVar) {
        x.d("MicroMsg.ProgressHandlerAnimator", "updateImpl, currentValue: %s", new Object[]{Float.valueOf(bVar.lpt)});
        bVar.lpt = (((float) bi.bI(bVar.lps)) / ((float) bVar.duration)) * (bVar.lpr - bVar.lpq);
        if (bVar.lpu != null) {
            bVar.lpu.an(bVar.lpt);
        }
    }

    public b(float f, float f2, int i) {
        this.lpq = f;
        this.lpr = f2;
        this.duration = i;
        if (f2 > f) {
            this.lpp = ((f2 - f) / ((float) this.duration)) * 20.0f;
        }
        x.i("MicroMsg.ProgressHandlerAnimator", "create ProgressHandlerAnimator, start: %s, end: %s, duration: %s, updateStep: %s", new Object[]{Float.valueOf(f), Float.valueOf(f2), Integer.valueOf(i), Float.valueOf(this.lpp)});
        this.bTv = false;
        this.lps = 0;
        this.eaF = new al(Looper.getMainLooper(), new 1(this), true);
    }
}
