package com.tencent.mm.plugin.voip.model.a;

import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.model.au;
import com.tencent.mm.plugin.voip.b.a;
import com.tencent.mm.protocal.c.byw;
import com.tencent.mm.protocal.c.caf;

class a$1 implements e {
    final /* synthetic */ a oNO;

    a$1(a aVar) {
        this.oNO = aVar;
    }

    public final void a(int i, int i2, String str, l lVar) {
        a.eU(this.oNO.TAG, "ack response:" + i + " errCode:" + i2 + " status:" + this.oNO.oKs.mStatus);
        if (this.oNO.oKs.mStatus == 1) {
            a.eU(this.oNO.TAG, "reject ok!");
        } else if (this.oNO.oKs.mStatus != 3) {
            a.eT(this.oNO.TAG, "ack response not within WAITCONNECT, ignored.");
        } else if (i == 0) {
            byw byw = (byw) this.oNO.bLq();
            if (byw.suJ != 1) {
                a.eU(this.oNO.TAG, "onVoipAckResp: do not use preconnect");
                return;
            }
            this.oNO.oKs.oJz = true;
            this.oNO.oKs.oJX.oON = 1;
            this.oNO.oKs.oJX.kpo = byw.rxG;
            this.oNO.oKs.oJX.kpp = byw.rxH;
            this.oNO.oKs.oJX.kpw = byw.suP;
            this.oNO.oKs.oJX.oOu = byw.suT;
            this.oNO.oKs.oJX.oOv = byw.suU;
            this.oNO.oKs.yB(byw.suR);
            a.eU(this.oNO.TAG, "ack ok, roomid =" + this.oNO.oKs.oJX.kpo + ",memberid = " + this.oNO.oKs.oJX.kpw);
            final caf caf = byw.suQ;
            if (caf.kpK > 0) {
                caf.kpK--;
                a.eU(this.oNO.TAG, "zhengxue[ENCRYPT] got encryptStrategy[" + caf.kpK + "] from ackresp relaydata");
            } else {
                caf.kpK = 1;
                a.eU(this.oNO.TAG, "zhengxue[LOGIC]:got no EncryptStrategy in ackresp mrdata");
            }
            a.eU(this.oNO.TAG, "ack with switchtcpcnt  =" + this.oNO.oKs.oJX.oOt + " RedirectReqThreshold =" + caf.sww + " BothSideSwitchFlag =" + caf.swx + " WifiScanInterval =" + byw.suU);
            this.oNO.oKs.oJX.oPm = caf.swx;
            this.oNO.oKs.yA(caf.swb);
            this.oNO.oKs.aQ(caf.suK.rfy.siK.toByteArray());
            if (!(caf.swi == null || caf.swi.siK == null || caf.swu == null || caf.swu.siK == null)) {
                this.oNO.oKs.a(caf.swi.siK.toByteArray(), caf.swh, caf.kpK, caf.swu.siK.toByteArray());
            }
            this.oNO.oKs.h(caf.swl, caf.swm, caf.swn, caf.swo, caf.swp);
            this.oNO.oKs.aR(caf.suL.rfy.siK.toByteArray());
            au.Em().H(new Runnable() {
                public final void run() {
                    a$1.this.oNO.oKs.a(caf.swc, caf.swd, caf.swk);
                    a$1.this.oNO.oKs.yz(caf.swt);
                    a$1.this.oNO.oKs.yy(caf.sww);
                    if (!(caf.swr == null || caf.sws == null)) {
                        a$1.this.oNO.oKs.b(caf.swq, caf.swr.siK.toByteArray(), caf.sws.siK.toByteArray());
                    }
                    a.eU(a$1.this.oNO.TAG, "ack success, try connect channel");
                    a$1.this.oNO.oKs.bJZ();
                }
            });
        } else if (i == 4) {
            this.oNO.oKs.oJX.oPS.oKQ = 12;
            this.oNO.oKs.oJX.oPS.oKR = i2;
            this.oNO.oKs.o(1, i2, "");
        } else {
            this.oNO.oKs.oJX.oPS.oKQ = 12;
            this.oNO.oKs.oJX.oPS.oKR = i2;
            this.oNO.oKs.o(1, -9004, "");
        }
    }
}
