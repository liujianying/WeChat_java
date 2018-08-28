package com.tencent.mm.plugin.voip.model.a;

import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.model.au;
import com.tencent.mm.plugin.voip.b.a;
import com.tencent.mm.protocal.c.bza;
import com.tencent.mm.protocal.c.caf;
import com.tencent.mm.sdk.platformtools.x;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

class b$1 implements e {
    final /* synthetic */ b oNR;

    b$1(b bVar) {
        this.oNR = bVar;
    }

    public final void a(int i, int i2, String str, l lVar) {
        a.eU(this.oNR.TAG, "Anwser response:" + i + " errCode:" + i2 + " status:" + this.oNR.oKs.mStatus);
        if (this.oNR.oKs.mStatus == 1) {
            a.eU(this.oNR.TAG, "reject ok!");
        } else if (this.oNR.oKs.mStatus != 4) {
            a.eT(this.oNR.TAG, "Anwser response not within WAITCONNECT, ignored.");
        } else if (i == 0) {
            bza bza = (bza) this.oNR.bLq();
            this.oNR.oKs.oJX.kpo = bza.rxG;
            this.oNR.oKs.oJX.kpp = bza.rxH;
            this.oNR.oKs.oJX.kpw = bza.suP;
            this.oNR.oKs.oJX.oOP = bza.svc;
            this.oNR.oKs.oJX.oOQ = bza.svd;
            this.oNR.oKs.oJX.oOR = bza.sve;
            this.oNR.oKs.oJX.oOS = bza.svf;
            this.oNR.oKs.oJX.oOU = bza.svh;
            this.oNR.oKs.oJX.oOT = bza.svm;
            this.oNR.oKs.oJX.oOu = bza.suT;
            this.oNR.oKs.oJX.oOW = bza.svo;
            this.oNR.oKs.yB(bza.suR);
            this.oNR.oKs.oJX.oOv = bza.suU;
            if (bza.suV.siI >= 12) {
                ByteBuffer wrap = ByteBuffer.wrap(bza.suV.siK.toByteArray(), 8, 4);
                ByteOrder nativeOrder = ByteOrder.nativeOrder();
                ByteOrder order = wrap.order();
                int i3 = wrap.getInt();
                a.eV(this.oNR.TAG, "steve:nSvrBaseBRTuneRatio1:" + i3 + ", nativeOrder:" + nativeOrder + ", bbOrder:" + order);
                this.oNR.oKs.oJX.oOV = i3;
            }
            a.eU(this.oNR.TAG, "onAnwserResp: audioTsdfBeyond3G = " + this.oNR.oKs.oJX.oOP + ",audioTsdEdge = " + this.oNR.oKs.oJX.oOQ + ",passthroughQosAlgorithm = " + this.oNR.oKs.oJX.oOR + ",fastPlayRepair = " + this.oNR.oKs.oJX.oOS + ", audioDtx = " + this.oNR.oKs.oJX.oOU + ", switchtcppktCnt=" + this.oNR.oKs.oJX.oOt + ", SvrCfgListV=" + this.oNR.oKs.oJX.oOT + ", setMaxBRForRelay=" + this.oNR.oKs.oJX.oOW + ", RedirectreqThreshold=" + bza.suQ.sww + ", BothSideSwitchFlag=" + bza.suQ.swx + ", WifiScanInterval=" + bza.suU + ", BaseBRTuneRatio=" + this.oNR.oKs.oJX.oOV);
            this.oNR.oKs.oJX.oOX = bza.svl;
            this.oNR.oKs.oJX.oOY = bza.svp;
            a.eU(this.oNR.TAG, "answerResp AudioAecMode5 = " + this.oNR.oKs.oJX.oOX);
            this.oNR.oKs.oJx = true;
            a.eU(this.oNR.TAG, "answer ok, roomid =" + this.oNR.oKs.oJX.kpo + ",memberid = " + this.oNR.oKs.oJX.kpw);
            caf caf = bza.suQ;
            if (caf.kpK > 0) {
                caf.kpK--;
                a.eU(this.oNR.TAG, "zhengxue[ENCRYPT] got encryptStrategy[" + caf.kpK + "] from answerresp relaydata");
            } else {
                caf.kpK = 1;
                a.eU(this.oNR.TAG, "zhengxue[LOGIC]:got no EncryptStrategy in answerresp mrdata");
            }
            a.eU(this.oNR.TAG, "answer with relayData peerid.length =" + caf.suK.rfy.siI);
            a.eU(this.oNR.TAG, "answer with relayData capinfo.length =" + caf.suL.rfy.siI);
            this.oNR.oKs.yA(caf.swb);
            try {
                au.Em().H(new 1(this, caf));
            } catch (Exception e) {
                x.e(this.oNR.TAG, "get proxy ip fail..");
            }
        } else if (i == 4) {
            this.oNR.oKs.oJX.oPS.oKQ = 12;
            this.oNR.oKs.oJX.oPS.oKR = i2;
            this.oNR.oKs.o(1, i2, "");
        } else {
            this.oNR.oKs.oJX.oPS.oKQ = 12;
            this.oNR.oKs.oJX.oPS.oKR = i2;
            this.oNR.oKs.o(1, -9004, "");
        }
    }
}
