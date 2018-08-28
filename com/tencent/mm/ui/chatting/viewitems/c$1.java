package com.tencent.mm.ui.chatting.viewitems;

import com.tencent.mm.an.b;
import com.tencent.mm.model.s;
import com.tencent.mm.protocal.c.avq;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.y.g.a;

class c$1 implements Runnable {
    final /* synthetic */ String bAA;
    final /* synthetic */ String tZD;
    final /* synthetic */ long tZE;

    c$1(String str, String str2, long j) {
        this.tZD = str;
        this.bAA = str2;
        this.tZE = j;
    }

    public final void run() {
        String str = this.tZD;
        if (s.fq(this.bAA) && !bi.aG(str, "").startsWith("<")) {
            int indexOf = this.tZD.indexOf(58);
            if (indexOf != -1) {
                str = this.tZD.substring(indexOf + 1);
            }
        }
        a gp = a.gp(bi.WT(str));
        if (gp != null) {
            switch (gp.type) {
                case 3:
                    avq Qa = b.Qa();
                    if (Qa != null && Qa.rsp != null && Qa.rYj == 0) {
                        try {
                            if (this.tZE == bi.getLong(Qa.rsp, 0)) {
                                ah.A(new Runnable() {
                                    public final void run() {
                                        b.PW();
                                    }
                                });
                                return;
                            }
                            return;
                        } catch (Exception e) {
                            return;
                        }
                    }
                    return;
                default:
                    return;
            }
        }
    }
}
