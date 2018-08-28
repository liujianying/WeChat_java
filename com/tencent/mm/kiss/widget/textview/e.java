package com.tencent.mm.kiss.widget.textview;

import android.text.Layout.Alignment;
import android.text.TextPaint;

public final class e {
    private final d[] dud = new d[3];
    private final Object mLock = new Object();
    private int tN;

    public final d Fb() {
        d dVar = null;
        synchronized (this.mLock) {
            if (this.tN > 0) {
                int i = this.tN - 1;
                dVar = this.dud[i];
                this.dud[i] = null;
                this.tN--;
            }
        }
        return dVar;
    }

    public final boolean a(d dVar) {
        synchronized (this.mLock) {
            boolean z;
            for (int i = 0; i < this.tN; i++) {
                if (this.dud[i] == dVar) {
                    z = true;
                    break;
                }
            }
            z = false;
            if (z) {
                throw new IllegalStateException("Already in the pool!");
            }
            dVar.dtQ = null;
            dVar.dtR = null;
            dVar.dtS = 0;
            dVar.dtT = 0;
            dVar.dtU = new TextPaint();
            dVar.width = 0;
            dVar.dtV = Alignment.ALIGN_NORMAL;
            dVar.gravity = 51;
            dVar.dtW = null;
            dVar.dtX = 0;
            dVar.maxLines = Integer.MAX_VALUE;
            dVar.dtY = null;
            dVar.dtZ = 0.0f;
            dVar.dua = 1.0f;
            dVar.dub = false;
            dVar.maxLength = 0;
            dVar.duc = null;
            if (this.tN < this.dud.length) {
                this.dud[this.tN] = dVar;
                this.tN++;
                return true;
            }
            return false;
        }
    }
}
