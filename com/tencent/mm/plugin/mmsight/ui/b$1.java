package com.tencent.mm.plugin.mmsight.ui;

import com.tencent.mm.sdk.platformtools.al.a;
import com.tencent.mm.sdk.platformtools.x;

class b$1 implements a {
    final /* synthetic */ b lpw;

    b$1(b bVar) {
        this.lpw = bVar;
    }

    public final boolean vD() {
        b.a(this.lpw);
        if (!this.lpw.bTv) {
            x.i("MicroMsg.ProgressHandlerAnimator", "isStart is false now");
            return false;
        } else if (this.lpw.lpt < this.lpw.lpr) {
            return true;
        } else {
            this.lpw.bTv = false;
            x.i("MicroMsg.ProgressHandlerAnimator", "reach end, currentValue: %s, end: %s, callback: %s", new Object[]{Float.valueOf(this.lpw.lpt), Float.valueOf(this.lpw.lpr), this.lpw.lpu});
            if (this.lpw.lpu != null) {
                this.lpw.lpu.onAnimationEnd();
            }
            return false;
        }
    }
}
