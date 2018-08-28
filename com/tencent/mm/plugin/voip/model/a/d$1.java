package com.tencent.mm.plugin.voip.model.a;

import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.plugin.voip.b.a;
import com.tencent.mm.plugin.voip.model.v2protocal;
import com.tencent.mm.protocal.c.bzy;

class d$1 implements e {
    final /* synthetic */ d oNU;

    d$1(d dVar) {
        this.oNU = dVar;
    }

    public final void a(int i, int i2, String str, l lVar) {
        a.eU("MicroMsg.Voip.DoubleLinkSwitch", "double link switch response:" + i + " errCode:" + i2 + " status:" + this.oNU.oKs.mStatus);
        if (i2 != 0) {
            a.eT("MicroMsg.Voip.DoubleLinkSwitch", " double link switch  response with error code:" + i2);
            return;
        }
        bzy bzy = (bzy) this.oNU.bLq();
        this.oNU.oKs.oJK = bzy.rZq;
        if (this.oNU.oKs.oJK != 0) {
            if (this.oNU.oKs.oJX.doubleLinkSwitch(bzy.svR) == 0) {
                v2protocal v2protocal;
                if (1 == bzy.svR) {
                    v2protocal = this.oNU.oKs.oJX;
                    v2protocal.oPh++;
                } else if (2 == bzy.svR) {
                    v2protocal = this.oNU.oKs.oJX;
                    v2protocal.oPi++;
                }
            }
            a.eU("MicroMsg.Voip.DoubleLinkSwitch", "zhengxue[DOUBLELINK]room " + bzy.rxG + " member " + bzy.seq + " key " + bzy.rxH + "report flag " + bzy.rZq + "switch to link type " + bzy.svR + "doubleLinkSwitchReportStatus " + this.oNU.oKs.oJK + "mDoubleLinkSwitchSucToDirectCnt" + this.oNU.oKs.oJX.oPh + "mDoubleLinkSwitchSucToRelayCnt" + this.oNU.oKs.oJX.oPi);
        }
    }
}
