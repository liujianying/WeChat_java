package com.tencent.mm.plugin.expt.roomexpt;

import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.expt.a.a;
import com.tencent.mm.plugin.expt.a.a$a;

class a$3 implements Runnable {
    final /* synthetic */ boolean iIq;
    final /* synthetic */ a iIr;
    final /* synthetic */ String iIs;

    a$3(a aVar, String str, boolean z) {
        this.iIr = aVar;
        this.iIs = str;
        this.iIq = z;
    }

    public final void run() {
        int i = 0;
        if (((a) g.l(a.class)).a(a$a.mmchatroom_mute_abtest_flag, a.a(this.iIr) != null ? a.a(this.iIr).chM : false)) {
            int min = Math.min(a.b(this.iIr).length, 5);
            while (i < min) {
                if (this.iIs.equals(a.b(this.iIr)[i])) {
                    a.aq(this.iIs, this.iIq);
                    a.a(this.iIr).chJ = 6;
                    a.a(this.iIr).chL = "";
                    a.c(this.iIr);
                    return;
                }
                i++;
            }
        }
    }
}
