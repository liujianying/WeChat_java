package com.tencent.mm.plugin.voip_cs.b;

import android.os.Looper;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.model.au;
import com.tencent.mm.plugin.brandservice.b.j;
import com.tencent.mm.plugin.voip_cs.b.b.a;
import com.tencent.mm.plugin.voip_cs.b.c.c;
import com.tencent.mm.plugin.voip_cs.b.c.f;
import com.tencent.mm.protocal.c.bju;
import com.tencent.mm.protocal.c.byx;
import com.tencent.mm.protocal.c.byy;
import com.tencent.mm.protocal.c.bzc;
import com.tencent.mm.protocal.c.bze;
import com.tencent.mm.protocal.c.bzi;
import com.tencent.mm.protocal.c.bzl;
import com.tencent.mm.protocal.c.bzo;
import com.tencent.mm.protocal.c.bzq;
import com.tencent.mm.protocal.c.cah;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.tmassistantsdk.logreport.BaseReportManager;
import java.util.Arrays;
import java.util.List;

public final class d implements e {
    public int kpy = 0;
    public int oKh = 0;
    public int oWI = 0;
    public a oXl;
    public int oXm = 0;
    public int oXn = 0;
    public int oXo = 0;
    public byte[] oXp = null;
    public int oXq = 0;
    public int oXr = 0;
    public int oXs = 0;
    public String oXt = "";
    public int oXu = 0;
    public int oXv = 999;
    public al oXw = new al(Looper.getMainLooper(), new 1(this), true);
    public al oXx = new al(Looper.getMainLooper(), new 2(this), true);

    public final void bMB() {
        au.DF().a(818, this);
        au.DF().a(new f(b.bMv().kqx.oOl, b.bMv().kqx.kpp, this.oXm), 0);
    }

    private static void b(int i, int i2, l lVar) {
        x.i("MicroMsg.voipcs.VoipCSService", "Redirect response:" + i + " errCode:" + i2);
        if (i2 != 0) {
            x.i("MicroMsg.voipcs.VoipCSService", " redirect response with error code:" + i2);
            return;
        }
        bzl bzl = (bzl) ((com.tencent.mm.plugin.voip_cs.b.c.d) lVar).diG.dIE.dIL;
        x.i("MicroMsg.voipcs.VoipCSService", "roomid " + bzl.svs + " key " + bzl.rxH + "relay addr cnt " + bzl.rfi.size());
        List<bzc> list = bzl.rfi;
        byy byy = new byy();
        for (bzc bzc : list) {
            byx byx = new byx();
            b.bMv();
            byx.spR = a.OP(bzc.rTO);
            byx.sed = bzc.sed;
            byy.suX.add(byx);
        }
        byy.suW = list.size();
        b.bMv().kqx.a(byy, byy, null, 0, 0);
    }

    public final void a(bzq bzq) {
        if (bzq.svC > this.oXm && b.bMw().oXs != 3) {
            x.i("MicroMsg.voipcs.VoipCSService", "get callee sync resp,notifySeq:" + bzq.svC + ",calleeMemberId:" + bzq.svD + ",calleeStatus:" + bzq.svE + ",calleeSubStatus:" + bzq.svF + ",recv roomId:" + bzq.svs + ",recv roomKey:" + bzq.rxH);
            if (b.bMv().kqx.oOl == 0 || b.bMv().kqx.oOl == bzq.svs) {
                this.oXm = bzq.svC;
                this.oWI = bzq.svD;
                this.oXn = bzq.svE;
                this.oXo = bzq.svF;
                b.bMx().oWI = this.oWI;
                if (this.oXn == 2) {
                    x.i("MicroMsg.voipcs.VoipCSService", "callee accept!");
                    this.oXw.SO();
                    bMB();
                    b.bMv().kqx.kpp = bzq.rxH;
                    x.i("MicroMsg.voipcs.VoipCSService", "csroomId:" + bzq.svs + ",roomkey:" + bzq.rxH);
                    this.oXp = bzq.svG != null ? bzq.svG.toByteArray() : null;
                    if (b.bMv().kqx.field_capInfo != null && this.oXp != null) {
                        int i;
                        c bMx = b.bMx();
                        x.d("MicroMsg.VoipCSReportHelper", "markUserAccept");
                        if (bMx.oWV == 0) {
                            bMx.oXh = (int) (System.currentTimeMillis() / 1000);
                            bMx.oWV = (long) (bMx.oXh - bMx.oXf);
                        }
                        b.bMv().kqx.oOn = this.oXp;
                        x.i("MicroMsg.voipcs.VoipCSService", "calleeCapDump is " + Arrays.toString(b.bMv().kqx.oOn));
                        x.i("MicroMsg.voipcs.VoipCSService", "calleeCap length:" + this.oXp.length);
                        if (b.bMv().kqx.oOn != null && b.bMv().kqx.exchangeCabInfo(b.bMv().kqx.oOn, b.bMv().kqx.oOn.length) < 0) {
                            x.i("MicroMsg.voipcs.VoipCSService", "exchangeCabInfo fail!");
                        }
                        if (b.bMv().kqx.oOq == null) {
                            i = 0;
                        } else {
                            i = b.bMv().kqx.oOq.length;
                        }
                        if (b.bMv().kqx.setConfigInfo(b.bMv().kqx.oOk, b.bMv().kqx.oOl, b.bMv().kqx.kpw, b.bMv().kqx.kpp, b.bMv().kqx.field_peerId, 1, b.bMv().kqx.oOr, b.bMv().kqx.oOs, b.bMv().kqx.oOp, i, b.bMv().kqx.oOq, this.oXv, 1, b.bMv().kqx.netType, b.bMv().kqx.oPj, b.bMv().kqx.oPk, 255, 0) != 0) {
                            x.e("MicroMsg.voipcs.VoipCSService", "setConfig fail, ret:%d", new Object[]{Integer.valueOf(b.bMv().kqx.setConfigInfo(b.bMv().kqx.oOk, b.bMv().kqx.oOl, b.bMv().kqx.kpw, b.bMv().kqx.kpp, b.bMv().kqx.field_peerId, 1, b.bMv().kqx.oOr, b.bMv().kqx.oOs, b.bMv().kqx.oOp, i, b.bMv().kqx.oOq, this.oXv, 1, b.bMv().kqx.netType, b.bMv().kqx.oPj, b.bMv().kqx.oPk, 255, 0))});
                        }
                        if (b.bMv().kqx.connectToPeer() != 0) {
                            x.e("MicroMsg.voipcs.VoipCSService", "connectToPeer fail, ret:%d", new Object[]{Integer.valueOf(b.bMv().kqx.connectToPeer())});
                        }
                        if (this.oXx.ciq()) {
                            this.oXx.J(50000, 50000);
                        }
                        b.bMx().oWO = 1;
                        return;
                    }
                    return;
                } else if (this.oXn != 0 && this.oXn != 1 && this.oXn == 3) {
                    x.i("MicroMsg.voipcs.VoipCSService", "callee hangup!");
                    b.bMx().bjS = 5;
                    b.bMx().bMy();
                    b.bMx().oWS = 2;
                    if (this.oXo == 1) {
                        b.bMx().oWK = 12;
                    } else if (this.oXo == 3) {
                        b.bMx().oWK = 99;
                    }
                    if (this.oXl != null) {
                        this.oXl.yZ(1);
                        return;
                    }
                    return;
                } else {
                    return;
                }
            }
            x.i("MicroMsg.voipcs.VoipCSService", "csRoomId:" + b.bMv().kqx.oOl + ",recv roomId:" + bzq.svs + ",current and recv not equal!!");
        }
    }

    public final void a(int i, int i2, String str, l lVar) {
        x.i("MicroMsg.voipcs.VoipCSService", "onSceneEnd :netId:%s,errType:%s,errCode:%s,errMsg:%s", new Object[]{Integer.valueOf(lVar.getType()), Integer.valueOf(i), Integer.valueOf(i2), str});
        String str2;
        if (i != 0 || i2 != 0) {
            x.i("MicroMsg.voipcs.VoipCSService", "onSceneEnd  resp error!:netId:%s,errType:%s,errCode:%s,errMsg:%s", new Object[]{Integer.valueOf(lVar.getType()), Integer.valueOf(i), Integer.valueOf(i2), str});
            if (i != 0 && i != 4) {
                this.oXu = -1;
                this.oXl.onError(10);
            } else if (lVar.getType() == 823) {
                if (i2 == 406) {
                    x.i("MicroMsg.voipcs.VoipCSService", "CS_INVITE_RESP_REPEAT_INVTIE 503..");
                    return;
                }
                b.bMx().bjS = 1;
                this.oXu = 823;
                this.oXl.onError(i2);
            } else if (lVar.getType() != 880 && lVar.getType() != 818 && lVar.getType() == 455) {
                this.oXl.eX("", "");
            }
        } else if (lVar.getType() == 823) {
            byx byx;
            bzi bzi = (bzi) ((c) lVar).diG.dIE.dIL;
            long j = bzi.svs;
            long j2 = bzi.rxH;
            List<bzc> list = bzi.rfi;
            List<bzc> list2 = bzi.svB;
            this.kpy = bzi.svx;
            this.oXv = bzi.svA;
            x.i("MicroMsg.voipcs.VoipCSService", "tcpStartCnt : " + this.oXv);
            b.bMv().kqx.oOs = bzi.kpF;
            this.oXq = bzi.kpz;
            b.bMv().kqx.oPj = bzi.kpK;
            b.bMv().kqx.oPk = bzi.seu.toByteArray();
            b.bMv().kqx.oOr = bzi.kpG;
            byy byy = new byy();
            for (bzc bzc : list) {
                byx = new byx();
                b.bMv();
                byx.spR = a.OP(bzc.rTO);
                byx.sed = bzc.sed;
                byy.suX.add(byx);
            }
            byy.suW = list.size();
            byy byy2 = new byy();
            for (bzc bzc2 : list2) {
                byx = new byx();
                b.bMv();
                byx.spR = a.OP(bzc2.rTO);
                byx.sed = bzc2.sed;
                byy2.suX.add(byx);
            }
            byy2.suW = list2.size();
            b.bMv().kqx.oOl = j;
            b.bMv().kqx.kpp = j2;
            x.i("MicroMsg.voipcs.VoipCSService", "recv invite resp csRoomId : " + j + ",roomKey:" + j2);
            b.bMv().kqx.oPt = bzi.svy;
            b.bMv().kqx.oPu = bzi.svz;
            cah cah = new cah();
            cah.swD = 0;
            cah.swE = 0;
            cah.swF = 0;
            cah.userName = "";
            cah.eSH = "";
            if (b.bMv().kqx.a(byy, byy, byy, cah) != 0) {
                x.i("MicroMsg.voipcs.VoipCSService", "setIp fail!");
            }
            c bMx = b.bMx();
            str2 = this.oXt;
            x.d("MicroMsg.VoipCSReportHelper", "setVoipCSBaseInfo");
            bMx.oWG = j;
            bMx.kpp = j2;
            bMx.oWH = str2;
            if (this.oXw.ciq()) {
                if (this.kpy > 0) {
                    j = (long) (this.kpy * BaseReportManager.MAX_READ_COUNT);
                    this.oXw.J(j, j);
                } else {
                    this.oXw.J(4000, 4000);
                }
            }
            bMx = b.bMx();
            x.d("MicroMsg.VoipCSReportHelper", "markRecvInvite");
            if (bMx.oXf != 0) {
                bMx.oXg = (int) (System.currentTimeMillis() / 1000);
            }
        } else if (lVar.getType() == 818) {
            bzq bzq = (bzq) ((f) lVar).diG.dIE.dIL;
            x.i("MicroMsg.voipcs.VoipCSService", "sync status = " + bzq.svE + ",notifySeq = " + bzq.svC);
            a(bzq);
        } else if (lVar.getType() == 880) {
            bze bze = (bze) ((com.tencent.mm.plugin.voip_cs.b.c.a) lVar).diG.dIE.dIL;
            if (b.bMv().kqx.oOl == bze.svs && b.bMv().kqx.kpp == bze.rxH) {
                x.i("MicroMsg.voipcs.VoipCSService", "hangup success!");
            }
            au.DF().b(880, this);
            b.bMx().za(com.tencent.mm.plugin.voip_cs.b.a.a.bMD().oNt.bMk());
        } else if (lVar.getType() == 455) {
            j jVar = (j) lVar;
            str2 = "";
            String str3 = "";
            if (jVar.hnV == null || jVar.hnV.size() <= 0) {
                x.i("MicroMsg.voipcs.VoipCSService", "search Or Recommend items is null or empty !");
            } else {
                bju bju = (bju) jVar.hnV.get(0);
                str2 = bju.rqZ;
                str3 = bju.rQz.siM;
            }
            this.oXl.eX(str2, str3);
        } else if (lVar.getType() == 285) {
            b(i, i2, lVar);
        } else if (lVar.getType() == 312) {
            bzo bzo = (bzo) ((com.tencent.mm.plugin.voip_cs.b.c.e) lVar).diG.dIE.dIL;
            if (bzo.svs == b.bMv().kqx.oOl && bzo.rxH == b.bMv().kqx.kpp) {
                x.i("MicroMsg.voipcs.VoipCSService", "report data success!");
            }
        }
    }
}
