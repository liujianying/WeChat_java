package com.tencent.mm.plugin.shake.ui;

import android.os.MessageQueue.IdleHandler;
import com.tencent.mm.R;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.shake.ui.ShakeReportUI.4;
import com.tencent.mm.ui.base.s;

class ShakeReportUI$4$1 implements IdleHandler {
    final /* synthetic */ 4 nbi;

    ShakeReportUI$4$1(4 4) {
        this.nbi = 4;
    }

    public final boolean queueIdle() {
        s.a(this.nbi.nbh, 0, this.nbi.nbh.getString(R.l.shake_set_mute_tips));
        au.HU();
        c.DT().set(4117, Boolean.valueOf(true));
        return false;
    }
}
