package com.tencent.mm.plugin.voip.model.a;

import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.voip.b.a;
import com.tencent.mm.plugin.voip.model.i;
import com.tencent.mm.protocal.c.cad;
import com.tencent.mm.protocal.c.cae;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.x;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

class g$1 implements e {
    final /* synthetic */ g oNX;

    g$1(g gVar) {
        this.oNX = gVar;
    }

    public final void a(int i, int i2, String str, l lVar) {
        a.eU("MicroMsg.NetSceneVoipInvite", "Invite response:" + i + " errCode:" + i2 + " status:" + this.oNX.oKs.mStatus);
        if (this.oNX.oKs.mStatus != 2) {
            a.eT("MicroMsg.NetSceneVoipInvite", " invite response with error status:" + this.oNX.oKs.mStatus + " should:2");
            return;
        }
        int i3;
        cae cae = (cae) this.oNX.bLq();
        this.oNX.oKs.oJX.oOP = cae.svc;
        this.oNX.oKs.oJX.oOQ = cae.svd;
        this.oNX.oKs.oJX.oOR = cae.sve;
        this.oNX.oKs.oJX.oOS = cae.svf;
        this.oNX.oKs.oJX.oOU = cae.svh;
        this.oNX.oKs.oJX.oOT = cae.svm;
        this.oNX.oKs.oJX.oPv = cae.svZ;
        this.oNX.oKs.oJX.oOu = cae.suT;
        this.oNX.oKs.oJX.oOW = cae.svo;
        this.oNX.oKs.yB(cae.suR);
        this.oNX.oKs.oJX.oOv = cae.suU;
        if (cae.suV != null && cae.suV.siI >= 12) {
            ByteBuffer wrap = ByteBuffer.wrap(cae.suV.siK.toByteArray(), 8, 4);
            ByteOrder nativeOrder = ByteOrder.nativeOrder();
            ByteOrder order = wrap.order();
            i3 = wrap.getInt();
            a.eV("MicroMsg.NetSceneVoipInvite", "steve:nSvrBaseBRTuneRatio1:" + i3 + ", nativeOrder:" + nativeOrder + ", bbOrder:" + order);
            this.oNX.oKs.oJX.oOV = i3;
        }
        a.eU("MicroMsg.NetSceneVoipInvite", "setSvrConfig onInviteResp: audioTsdfBeyond3G = " + this.oNX.oKs.oJX.oOP + ",audioTsdEdge = " + this.oNX.oKs.oJX.oOQ + ",passthroughQosAlgorithm = " + this.oNX.oKs.oJX.oOR + ",fastPlayRepair = " + this.oNX.oKs.oJX.oOS + ", audioDtx = " + this.oNX.oKs.oJX.oOU + ",switchtcpPktCnt = " + this.oNX.oKs.oJX.oOt + ",SvrCfgListV = " + this.oNX.oKs.oJX.oOT + ", setMaxBRForRelay=" + this.oNX.oKs.oJX.oOW + ",EnableDataAccept = " + this.oNX.oKs.oJX.oPv + ",WifiScanInterval = " + this.oNX.oKs.oJX.oOv + ",BaseBRTuneRatio=" + this.oNX.oKs.oJX.oOV);
        this.oNX.oKs.oJX.oOX = cae.svl;
        a.eU("MicroMsg.NetSceneVoipInvite", "inviteResp AudioAecMode5 = " + this.oNX.oKs.oJX.oOX);
        this.oNX.oKs.oJX.oOY = cae.svp;
        a.eU("MicroMsg.NetSceneVoipInvite", "inviteResp AudioEnableXnoiseSup = " + this.oNX.oKs.oJX.oOY);
        i3 = a.getNetType(ad.getContext());
        if (i == 0) {
            this.oNX.oKs.setStatus(4);
            this.oNX.oKs.oJX.kpo = cae.rxG;
            this.oNX.oKs.oJX.kpp = cae.rxH;
            this.oNX.oKs.oJX.kpw = cae.seq;
            h.mEJ.a(11518, true, true, new Object[]{Integer.valueOf(i.bJI().bKS()), Long.valueOf(i.bJI().bKT()), Long.valueOf(i.bJI().bKU()), Integer.valueOf(1), Integer.valueOf(i3)});
            if (cae.svY > 0) {
                long j = (long) (cae.svY * 1000);
                this.oNX.oKs.oKk.J(j, j);
            }
            i.bJI().bLb();
            a.eU("MicroMsg.NetSceneVoipInvite", "invite ok, roomid =" + this.oNX.oKs.oJX.kpo + ",memberid = " + this.oNX.oKs.oJX.kpw + "VoipSyncInterval = " + cae.svY);
            this.oNX.oKs.oJY.bKw();
        } else if (i == 4) {
            a.eU("MicroMsg.NetSceneVoipInvite", "RoomId in InviteResp: " + cae.rxG + "," + cae.rxH);
            switch (i2) {
                case 211:
                    this.oNX.oKs.oJX.oPS.oKQ = 12;
                    this.oNX.oKs.oJX.oPS.oLc = 12;
                    h.mEJ.a(11518, true, true, new Object[]{Integer.valueOf(i.bJI().bKS()), Long.valueOf(i.bJI().bKT()), Long.valueOf(i.bJI().bKU()), Integer.valueOf(8), Integer.valueOf(i3)});
                    break;
                case 233:
                    this.oNX.oKs.oJX.oPS.oKQ = 12;
                    this.oNX.oKs.oJX.oPS.oLc = 1;
                    h.mEJ.a(11518, true, true, new Object[]{Integer.valueOf(i.bJI().bKS()), Long.valueOf(i.bJI().bKT()), Long.valueOf(i.bJI().bKU()), Integer.valueOf(3), Integer.valueOf(i3)});
                    break;
                case 234:
                    this.oNX.oKs.oJX.oPS.oKQ = 13;
                    this.oNX.oKs.oJX.oPS.oLc = 11;
                    h.mEJ.a(11518, true, true, new Object[]{Integer.valueOf(i.bJI().bKS()), Long.valueOf(i.bJI().bKT()), Long.valueOf(i.bJI().bKU()), Integer.valueOf(4), Integer.valueOf(i3)});
                    break;
                case 235:
                    this.oNX.oKs.oJX.oPS.oKQ = 13;
                    this.oNX.oKs.oJX.oPS.oLc = 2;
                    h.mEJ.a(11518, true, true, new Object[]{Integer.valueOf(i.bJI().bKS()), Long.valueOf(i.bJI().bKT()), Long.valueOf(i.bJI().bKU()), Integer.valueOf(2), Integer.valueOf(i3)});
                    break;
                case 236:
                    this.oNX.oKs.oJX.oPS.oKQ = 12;
                    this.oNX.oKs.oJX.oPS.oLc = 10;
                    h.mEJ.a(11518, true, true, new Object[]{Integer.valueOf(i.bJI().bKS()), Long.valueOf(i.bJI().bKT()), Long.valueOf(i.bJI().bKU()), Integer.valueOf(7), Integer.valueOf(i3)});
                    break;
                case 237:
                    this.oNX.oKs.oJX.oPS.oKQ = 13;
                    this.oNX.oKs.oJX.oPS.oLc = 9;
                    h.mEJ.a(11518, true, true, new Object[]{Integer.valueOf(i.bJI().bKS()), Long.valueOf(i.bJI().bKT()), Long.valueOf(i.bJI().bKU()), Integer.valueOf(2), Integer.valueOf(i3)});
                    break;
                case 238:
                    this.oNX.oKs.oJx = true;
                    this.oNX.oKs.oJz = false;
                    this.oNX.oKs.oJy = false;
                    this.oNX.oKs.oJX.oOO = 0;
                    this.oNX.oKs.oJX.oON = 0;
                    this.oNX.oKs.setStatus(3);
                    this.oNX.oKs.oJX.kpo = cae.rxG;
                    this.oNX.oKs.oJX.kpp = cae.rxH;
                    this.oNX.oKs.oJX.kpw = cae.seq;
                    this.oNX.oKs.oJY.yG(((cad) ((g) lVar).bLr()).soz);
                    return;
                case 241:
                    x.i("MicroMsg.NetSceneVoipInvite", "invite fail cuz server unavailable! reInvtieInterval is : " + cae.swa + " seconds!");
                    i.bJI().oNh = System.currentTimeMillis();
                    if (cae.swa == 0) {
                        i.bJI().oNi = 30000;
                        break;
                    }
                    i.bJI().oNi = (long) (cae.swa * 1000);
                    break;
                default:
                    this.oNX.oKs.oJX.oPS.oKQ = 12;
                    this.oNX.oKs.oJX.oPS.oLc = 99;
                    h.mEJ.a(11518, true, true, new Object[]{Integer.valueOf(i.bJI().bKS()), Long.valueOf(i.bJI().bKT()), Long.valueOf(i.bJI().bKU()), Integer.valueOf(5), Integer.valueOf(i3)});
                    break;
            }
            this.oNX.oKs.oJX.oPS.oKR = i2;
            this.oNX.oKs.o(1, i2, str);
        } else {
            this.oNX.oKs.oJX.oPS.oKQ = 12;
            this.oNX.oKs.oJX.oPS.oKR = i2;
            this.oNX.oKs.oJX.oPS.oLc = 99;
            h.mEJ.a(11518, true, true, new Object[]{Integer.valueOf(i.bJI().bKS()), Long.valueOf(i.bJI().bKT()), Long.valueOf(i.bJI().bKU()), Integer.valueOf(9), Integer.valueOf(i3)});
            this.oNX.oKs.o(1, -9004, "");
        }
    }
}
