package com.tencent.mm.plugin.facedetect.views;

import com.tencent.mm.sdk.platformtools.ah;
import java.lang.ref.WeakReference;
import java.util.TimerTask;

class FaceNumberItemView$a extends TimerTask {
    final /* synthetic */ FaceNumberItemView iUl;
    private WeakReference<Runnable> iUm;

    /* synthetic */ FaceNumberItemView$a(FaceNumberItemView faceNumberItemView, Runnable runnable, byte b) {
        this(faceNumberItemView, runnable);
    }

    private FaceNumberItemView$a(FaceNumberItemView faceNumberItemView, Runnable runnable) {
        this.iUl = faceNumberItemView;
        this.iUm = null;
        this.iUm = new WeakReference(runnable);
    }

    public final void run() {
        if (this.iUm == null || this.iUm.get() == null) {
            cancel();
        } else {
            ah.A((Runnable) this.iUm.get());
        }
    }
}
