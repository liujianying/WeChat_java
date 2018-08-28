package com.tencent.mm.plugin.scanner.ui;

import android.graphics.Point;
import android.graphics.Rect;
import com.tencent.mm.plugin.scanner.util.d;

class p$8 implements Runnable {
    final /* synthetic */ byte[] etO;
    final /* synthetic */ int fOS;
    final /* synthetic */ p mLr;
    final /* synthetic */ Point mLv;
    final /* synthetic */ Rect mLw;

    p$8(p pVar, byte[] bArr, Point point, int i, Rect rect) {
        this.mLr = pVar;
        this.etO = bArr;
        this.mLv = point;
        this.fOS = i;
        this.mLw = rect;
    }

    public final void run() {
        Object a = ((d) this.mLr.bsk()).a(this.etO, this.mLv, this.fOS, this.mLw, this.mLr.mLm);
        if (a != null) {
            if (this.mLr.mLl == null || this.mLr.mLn < a.length) {
                this.mLr.mLl = new byte[a.length];
                this.mLr.mLn = a.length;
            }
            System.arraycopy(a, 0, this.mLr.mLl, 0, a.length);
            synchronized (this.mLr.dMd) {
                p pVar = this.mLr;
                pVar.bufferSize++;
                p.b(this.mLr);
            }
        }
    }
}
