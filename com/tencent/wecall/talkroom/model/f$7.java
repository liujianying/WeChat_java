package com.tencent.wecall.talkroom.model;

import com.tencent.wecall.talkroom.model.f.f;
import java.util.TimerTask;

class f$7 extends TimerTask {
    final /* synthetic */ f vyi;

    f$7(f fVar) {
        this.vyi = fVar;
    }

    public final void run() {
        if (!this.vyi.vyd) {
            f.a(this.vyi, f.n(this.vyi) + 1);
            if (f.o(this.vyi)) {
                f.b(this.vyi, f.p(this.vyi) + 1);
            }
            if (f.q(this.vyi) == 3 || f.q(this.vyi) == 2) {
                f.c(this.vyi, f.r(this.vyi) + 1);
                this.vyi.vxH.oWZ = f.r(this.vyi);
            }
            this.vyi.vxH.vyZ = f.n(this.vyi) * 1000;
            this.vyi.vxH.oWY = f.n(this.vyi);
        }
        if (this.vyi.vxm != null) {
            f fVar = this.vyi.vxm;
            boolean z = this.vyi.vyd;
            f.n(this.vyi);
        }
    }
}
