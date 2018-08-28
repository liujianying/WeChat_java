package com.tencent.mm.plugin.voip;

import android.content.Context;
import com.tencent.mm.R;
import com.tencent.mm.compatible.util.g;
import com.tencent.mm.g.a.su;
import com.tencent.mm.g.a.su$b;
import com.tencent.mm.model.au;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.voip.model.i;
import com.tencent.mm.plugin.voip.model.m;
import com.tencent.mm.plugin.voip.model.q;
import com.tencent.mm.plugin.voip.model.r;
import com.tencent.mm.plugin.voip.model.s;
import com.tencent.mm.protocal.c.caa;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.nio.ByteBuffer;

public final class a extends c<su> {
    public a() {
        this.sFo = su.class.getName().hashCode();
    }

    private static boolean a(su suVar) {
        boolean z = true;
        if ((suVar instanceof su) && au.HX()) {
            r bJI;
            Object obj;
            Object obj2;
            caa caa;
            s sVar;
            switch (suVar.cdE.bOh) {
                case 1:
                    i.bJI();
                    com.tencent.mm.plugin.voip.model.n.a OG = r.OG(suVar.cdE.content);
                    if (OG != null) {
                        if (!OG.bKi()) {
                            if (OG.oLD != com.tencent.mm.plugin.voip.model.n.a.oLK) {
                                z = false;
                            }
                            if (z) {
                                suVar.cdF.type = 3;
                                break;
                            }
                        }
                        suVar.cdF.type = 2;
                        break;
                    }
                    break;
                case 2:
                    suVar.cdF.cdG = i.bJI().bCI;
                    break;
                case 3:
                    bJI = i.bJI();
                    obj = suVar.cdE.cdy;
                    if (obj != null && obj.length >= 10 && obj[0] == (byte) 1) {
                        obj2 = new byte[(obj.length - 1)];
                        System.arraycopy(obj, 1, obj2, 0, obj2.length);
                        m mVar = bJI.oNa.oHa.oJX.oPS;
                        mVar.oLw = System.currentTimeMillis();
                        com.tencent.mm.plugin.voip.b.a.eV("MicroMsg.VoipDailReport", "devin:recvInvite:" + mVar.oLw);
                        try {
                            caa caa2 = (caa) new caa().aG(obj2);
                            x.d("MicroMsg.Voip.VoipService", "doTaskCallin in onInviteNotify");
                            if (!bJI.oNa.bLd()) {
                                h.mEJ.a(11523, true, true, new Object[]{Integer.valueOf(caa2.rxG), Long.valueOf(caa2.rxH), Integer.valueOf(caa2.svK), Integer.valueOf(0), Long.valueOf(System.currentTimeMillis())});
                                bJI.a(caa2);
                                break;
                            }
                            h.mEJ.a(11523, true, true, new Object[]{Integer.valueOf(caa2.rxG), Long.valueOf(caa2.rxH), Integer.valueOf(caa2.svK), Integer.valueOf(0), Long.valueOf(System.currentTimeMillis())});
                            break;
                        } catch (Throwable e) {
                            x.printErrStackTrace("MicroMsg.Voip.VoipService", e, "", new Object[0]);
                            break;
                        }
                    }
                case 4:
                    su$b su_b = suVar.cdF;
                    r bJI2 = i.bJI();
                    Context context = ad.getContext();
                    if (bJI2.bCI && bJI2.oNl && !bJI2.oNm) {
                        x.d("MicroMsg.Voip.VoipService", "isVideoCalling " + bJI2.oNc + " isAudioCalling " + bJI2.oNd);
                        if (!bi.oW(bJI2.talker)) {
                            au.HU();
                            if (com.tencent.mm.model.c.FR().Yg(bJI2.talker) != null) {
                                r.a(context, bJI2.talker, true, bJI2.oNc, true);
                                su_b.cdH = z;
                                break;
                            }
                        }
                    }
                    z = false;
                    su_b.cdH = z;
                case 5:
                    if (!com.tencent.mm.p.a.BQ()) {
                        if (suVar.cdE.cdz != 2) {
                            if (suVar.cdE.cdz != 3) {
                                if (suVar.cdE.cdz == 4) {
                                    q.aM(suVar.cdE.context, suVar.cdE.talker);
                                    break;
                                }
                            }
                            q.aL(suVar.cdE.context, suVar.cdE.talker);
                            break;
                        }
                        q.aK(suVar.cdE.context, suVar.cdE.talker);
                        break;
                    }
                    com.tencent.mm.ui.base.h.i(suVar.cdE.context, R.l.multitalk_in_tip, R.l.app_tip);
                    break;
                    break;
                case 6:
                    bJI = i.bJI();
                    byte[] bArr = suVar.cdE.cdy;
                    if (bArr != null) {
                        x.i("MicroMsg.Voip.VoipService", "____voipNotify with data size:" + bArr.length);
                        int i = ByteBuffer.wrap(bArr, 0, 4).getInt();
                        long j = ByteBuffer.wrap(bArr, 4, 8).getLong();
                        x.i("MicroMsg.Voip.VoipService", "voipNotify roomid:" + i + " roomkey:" + j);
                        if (bJI.oNn == null) {
                            x.i("MicroMsg.Voip.VoipServiceEx", "current roomid:%d, params roomid:%d", new Object[]{Integer.valueOf(bJI.oNa.oHa.oJX.kpo), Integer.valueOf(i)});
                            if (i == 0 || r5.oHa.oJX.kpo != i) {
                                z = false;
                            }
                            if (!z) {
                                x.e("MicroMsg.Voip.VoipService", "voipSyncStatus ignored , not current roomid");
                                break;
                            }
                        }
                        if (bArr.length > 12) {
                            bJI.b(r.R(bArr, bArr.length - 12), i, j);
                        }
                        s sVar2 = bJI.oNa;
                        com.tencent.mm.plugin.voip.b.a.eU("MicroMsg.Voip.VoipServiceEx", g.Ac() + " need doSync by notify, status:" + sVar2.oHa.mStatus);
                        sVar2.oHa.oKa.a(null, false, 7);
                        break;
                    }
                    x.i("MicroMsg.Voip.VoipService", "sidney:notify content null");
                    break;
                case 9:
                    bJI = i.bJI();
                    obj = suVar.cdE.cdy;
                    if (!bi.bC(obj) && obj[0] == (byte) 3) {
                        try {
                            x.i("MicroMsg.Voip.VoipService", "onCancelNotify");
                            obj2 = new byte[(obj.length - 1)];
                            System.arraycopy(obj, 1, obj2, 0, obj2.length);
                            caa = new caa();
                            caa.aG(obj2);
                            bJI.yH(caa.rxG);
                            if (!(bJI.oNn == null || caa.rxG != bJI.oNn.rxG || bJI.ltH.ciq())) {
                                bJI.oNn = null;
                                bJI.oNo = 0;
                                bJI.ltH.SO();
                            }
                            sVar = bJI.oNa;
                            x.i("MicroMsg.Voip.VoipServiceEx", "onCancelInviteNotify, roomId: %s", new Object[]{Integer.valueOf(caa.rxG)});
                            if (sVar.oHa.oKc != null && caa.rxG == sVar.oHa.oKc.rxG) {
                                sVar.bLi();
                                sVar.oHa.shutdown();
                                break;
                            }
                        } catch (Exception e2) {
                            x.e("MicroMsg.Voip.VoipService", "onCancelNotify error: %s", new Object[]{e2.getMessage()});
                            break;
                        }
                    }
                case 10:
                    bJI = i.bJI();
                    obj = suVar.cdE.cdy;
                    if (!bi.bC(obj) && obj[0] == (byte) 2) {
                        try {
                            x.i("MicroMsg.Voip.VoipService", "onAnswerNotify");
                            obj2 = new byte[(obj.length - 1)];
                            System.arraycopy(obj, 1, obj2, 0, obj2.length);
                            caa = new caa();
                            caa.aG(obj2);
                            sVar = bJI.oNa;
                            x.i("MicroMsg.Voip.VoipServiceEx", "onAnswerNotify, roomId: %s", new Object[]{Integer.valueOf(caa.rxG)});
                            if (caa.rxG == sVar.oHa.oKc.rxG) {
                                if (!sVar.oHa.bXc) {
                                    x.i("MicroMsg.Voip.VoipServiceEx", "onAnswerNotify, not accept, hangout");
                                    sVar.bLi();
                                    sVar.oHa.shutdown();
                                    break;
                                }
                                x.i("MicroMsg.Voip.VoipServiceEx", "onAnswerNotify, already accept, ignore it");
                                break;
                            }
                        } catch (Exception e22) {
                            x.e("MicroMsg.Voip.VoipService", "onAnswerNotify error: %s", new Object[]{e22.getMessage()});
                            break;
                        }
                    }
                    break;
            }
        }
        return false;
    }
}
