package com.tencent.mm.plugin.mmsight.ui;

import android.graphics.Bitmap;
import com.tencent.mm.plugin.mmsight.ui.a.1.1;
import com.tencent.mm.plugin.w.a.f;
import com.tencent.mm.ui.base.h;

class a$1$1$4 implements Runnable {
    final /* synthetic */ Bitmap abc;
    final /* synthetic */ 1 lpm;

    a$1$1$4(1 1, Bitmap bitmap) {
        this.lpm = 1;
        this.abc = bitmap;
    }

    public final void run() {
        this.lpm.lpl.lpk.eXe = h.a(this.lpm.lpl.lpk.bGc, this.lpm.lpl.lpk.bGc.getString(f.mmsight_video_edit_processing), false, null);
        this.lpm.lpl.lpk.lkZ.pause();
        a.a(this.lpm.lpl.lpk, this.abc);
    }
}
