package com.tencent.mm.plugin.mmsight.segment;

import java.lang.ref.WeakReference;

class VideoSegmentUI$c implements Runnable {
    private WeakReference<c> YB;
    private int egD;
    private int lnx;

    public VideoSegmentUI$c(c cVar, int i, int i2) {
        this.YB = new WeakReference(cVar);
        this.lnx = i;
        this.egD = i2;
    }

    public final void run() {
        c cVar = (c) this.YB.get();
        if (cVar != null) {
            cVar.setCurrentCursorPosition(((float) this.lnx) / ((float) this.egD));
        }
    }
}
