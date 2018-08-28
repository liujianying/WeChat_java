package com.tencent.mm.plugin.voip.model;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningTaskInfo;
import android.app.KeyguardManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.graphics.Point;
import android.os.Looper;
import com.tencent.mm.R;
import com.tencent.mm.a.f;
import com.tencent.mm.bk.b;
import com.tencent.mm.compatible.util.g;
import com.tencent.mm.g.a.ih;
import com.tencent.mm.g.a.su;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.model.q;
import com.tencent.mm.network.n;
import com.tencent.mm.plugin.voip.b.d;
import com.tencent.mm.plugin.voip.model.a.e;
import com.tencent.mm.plugin.voip.model.a.h;
import com.tencent.mm.plugin.voip.ui.VideoActivity;
import com.tencent.mm.protocal.c.aqd;
import com.tencent.mm.protocal.c.bhy;
import com.tencent.mm.protocal.c.bsb;
import com.tencent.mm.protocal.c.bxi;
import com.tencent.mm.protocal.c.bzb;
import com.tencent.mm.protocal.c.bzv;
import com.tencent.mm.protocal.c.bzw;
import com.tencent.mm.protocal.c.caa;
import com.tencent.mm.protocal.c.cak;
import com.tencent.mm.protocal.c.cav;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.bd;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public final class r {
    private static final f<Integer, com.tencent.mm.plugin.voip.model.n.a> dzj = new f(5);
    public boolean bCI;
    public al ltH;
    private n mHI;
    public String oMr;
    public s oNa;
    public o oNb;
    public boolean oNc;
    public boolean oNd;
    private long oNe;
    public Map<Integer, Long> oNf;
    public int oNg;
    public long oNh;
    public long oNi;
    public Point oNj;
    public boolean oNk;
    public boolean oNl;
    public boolean oNm;
    public caa oNn;
    public long oNo;
    List<a> oNp;
    public String talker;

    public class a {
        boolean gej;
        caa oNr;
    }

    public r() {
        this.bCI = false;
        this.oNc = false;
        this.oNd = false;
        this.talker = null;
        this.oNe = 0;
        this.oNf = new HashMap();
        this.oNg = -1;
        this.oNh = 0;
        this.oNi = 0;
        this.oNk = false;
        this.oNl = false;
        this.oNm = false;
        this.oNn = null;
        this.oNo = 0;
        this.oMr = null;
        this.mHI = new com.tencent.mm.network.n.a() {
            public final void ev(int i) {
                x.d("MicroMsg.Voip.VoipService", "network status change from " + i);
                if (r.this.bCI && i == 4) {
                    j jVar = r.this.oNa.oHa;
                    if (jVar.oKh == 0) {
                        jVar.oKh = jVar.oJX.oOj;
                    }
                    int netType = com.tencent.mm.plugin.voip.b.a.getNetType(ad.getContext());
                    if (netType != jVar.oKh) {
                        com.tencent.mm.plugin.voip.b.a.eU("MicroMsg.Voip.VoipContext", "steve: onVoipLocalNetTypeChange: local network type change from " + jVar.oKh + " to " + netType);
                        try {
                            byte[] bArr = new byte[4];
                            bArr[0] = (byte) netType;
                            int appCmd = jVar.oJX.setAppCmd(301, bArr, 4);
                            if (appCmd < 0) {
                                com.tencent.mm.plugin.voip.b.a.eU("MicroMsg.Voip.VoipContext", "steve:[ENGINE]IMVQQEngine::SetAppCmd[EMethodSetLocalNetType] update local network type" + netType + "fail:" + appCmd + ", [roomid=" + jVar.oJX.kpw + ", roomkey=" + jVar.oJX.kpp + "]");
                            }
                            bxi bxi = new bxi();
                            bxi.stM = 3;
                            bxi.stN = new b(bArr, 0, 1);
                            jVar.oJX.SendRUDP(bxi.toByteArray(), bxi.toByteArray().length);
                        } catch (Exception e) {
                            com.tencent.mm.plugin.voip.b.a.eU("MicroMsg.Voip.VoipContext", "onVoipLocalNetTypeChange Error");
                        }
                        jVar.oKh = netType;
                    }
                    s sVar = r.this.oNa;
                    new h(sVar.oHa.oJX.kpo, sVar.oHa.oJX.kpp, sVar.oHa.oJX.kpw, 0, 0, null).bLp();
                }
            }
        };
        this.ltH = new al(Looper.getMainLooper(), new 3(this), true);
        this.oNp = null;
        this.oNa = new s();
        this.bCI = false;
        this.oNc = false;
        this.oNd = false;
        this.talker = null;
        this.oMr = null;
        au.a(this.mHI);
    }

    protected final void finalize() {
        this.oNa.stop();
        this.oNa = null;
        au.b(this.mHI);
        super.finalize();
    }

    public final void a(boolean z, boolean z2, String str) {
        x.i("MicroMsg.Voip.VoipService", "setCalling " + z + "  videoCall " + z2);
        this.bCI = z;
        if (z2) {
            this.oNc = z;
            this.oNa.oHa.oJX.oOw = 0;
        } else {
            this.oNa.oHa.oJX.oOw = 1;
            this.oNd = z;
        }
        this.talker = str;
    }

    public final void F(boolean z, boolean z2) {
        this.oNl = z;
        this.oNm = z2;
        x.d("MicroMsg.Voip.VoipService", "isMinimize: %b, miniOnlyHideVoip: %b", new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)});
    }

    public final void aO(Context context, String str) {
        x.i("MicroMsg.Voip.VoipService", "startVoiceCall, toUser:" + str);
        if (!bi.oW(str) && System.currentTimeMillis() - this.oNe >= 2000) {
            if (System.currentTimeMillis() - this.oNh < this.oNi) {
                x.i("MicroMsg.Voip.VoipService", "fail! cuz overloadInterval fail!");
                com.tencent.mm.ui.base.h.a(context, R.l.voip_server_not_available, R.l.voip_warnning_title, null);
                return;
            }
            this.oNe = System.currentTimeMillis();
            au.HU();
            if (c.FR().Yg(str) != null) {
                a(context, str, true, false, false);
                bKQ();
            }
        }
    }

    public final void aP(Context context, String str) {
        x.i("MicroMsg.Voip.VoipService", "startVideoCall, toUser:" + str);
        if (!bi.oW(str) && System.currentTimeMillis() - this.oNe >= 2000) {
            if (System.currentTimeMillis() - this.oNh < this.oNi) {
                x.i("MicroMsg.Voip.VoipService", "fail! cuz overloadInterval fail!");
                com.tencent.mm.ui.base.h.a(context, R.l.voip_server_not_available, R.l.voip_warnning_title, null);
                return;
            }
            this.oNe = System.currentTimeMillis();
            au.HU();
            if (c.FR().Yg(str) != null) {
                a(context, str, true, true, false);
                bKQ();
            }
        }
    }

    private static void bKQ() {
        su suVar = new su();
        suVar.cdE.bOh = 7;
        com.tencent.mm.sdk.b.a.sFg.m(suVar);
    }

    public final void O(final int i, final long j) {
        ah.A(new Runnable() {
            public final void run() {
                x.i("MicroMsg.Voip.VoipService", "onDelayInvite, roomId:%s, roomKey:%s", new Object[]{Integer.valueOf(i), Long.valueOf(j)});
                if (!com.tencent.mm.k.f.Ak() && !r.dE(ad.getContext())) {
                    x.i("MicroMsg.Voip.VoipService", "background now and notification Is closed.");
                } else if (r.this.oNa.bLd()) {
                    x.i("MicroMsg.Voip.VoipService", "room is ready, ingore the msg");
                } else {
                    new e(i, j, "").bLp();
                }
            }
        });
    }

    public final void a(caa caa) {
        if (com.tencent.mm.k.f.Ak() || dE(ad.getContext())) {
            String str = caa.svS;
            String GF = q.GF();
            int i = caa.svK;
            x.i("MicroMsg.Voip.VoipService", "doTaskCallin self:%s talker:%s type:%d roomid:%d", new Object[]{GF, str, Integer.valueOf(i), Integer.valueOf(caa.rxG)});
            if (this.oNa.bJP()) {
                s.a(caa.rxG, caa.rxH, 2, null, null, str);
                x.d("MicroMsg.Voip.VoipService", "doTaskCallin invite ignor because voip busy:roomid " + caa.rxG);
                com.tencent.mm.plugin.report.service.h.mEJ.a(11525, true, true, new Object[]{Integer.valueOf(caa.rxG), Long.valueOf(caa.rxH), Integer.valueOf(caa.svK), Integer.valueOf(2), Integer.valueOf(com.tencent.mm.plugin.voip.b.a.getNetType(ad.getContext())), Long.valueOf(System.currentTimeMillis())});
                com.tencent.mm.plugin.report.service.h.mEJ.a(11526, true, true, new Object[]{Integer.valueOf(i.bJI().oNa.oHa.oJX.kpo), Long.valueOf(i.bJI().bKT()), Long.valueOf(i.bJI().bKU()), Integer.valueOf(7)});
                return;
            } else if (s.bLe()) {
                s.a(caa.rxG, caa.rxH, 3, null, null, str);
                x.e("MicroMsg.Voip.VoipService", "doTaskCallin invite ignor because telephone busy:roomid " + caa.rxG);
                com.tencent.mm.plugin.report.service.h.mEJ.a(11525, true, true, new Object[]{Integer.valueOf(caa.rxG), Long.valueOf(caa.rxH), Integer.valueOf(caa.svK), Integer.valueOf(3), Integer.valueOf(com.tencent.mm.plugin.voip.b.a.getNetType(ad.getContext())), Long.valueOf(System.currentTimeMillis())});
                com.tencent.mm.plugin.report.service.h.mEJ.a(11526, true, true, new Object[]{Integer.valueOf(i.bJI().oNa.oHa.oJX.kpo), Long.valueOf(i.bJI().bKT()), Long.valueOf(i.bJI().bKU()), Integer.valueOf(7)});
                return;
            } else {
                Object obj;
                this.oNa.bLf();
                s sVar = this.oNa;
                if (sVar.oHa.bJP()) {
                    com.tencent.mm.plugin.voip.b.a.eT("MicroMsg.Voip.VoipServiceEx", "Failed to setInviteContent during calling, status =" + sVar.oHa.mStatus);
                    obj = null;
                } else if (caa == null) {
                    obj = null;
                } else {
                    sVar.oHa.oJX.oPS.oLb = caa.svK;
                    x.d("MicroMsg.Voip.VoipServiceEx", "iRoomType " + sVar.oHa.oJX.oPS.oLb);
                    if (sVar.oHa.oJX.lkO) {
                        com.tencent.mm.plugin.voip.b.a.eW("MicroMsg.Voip.VoipServiceEx", g.Ac() + "v2protocal already init.");
                        sVar.oHa.oJX.iT(false);
                        sVar.oHa.oJX.reset();
                    }
                    j jVar = sVar.oHa;
                    jVar.oKc = caa;
                    jVar.oJX.kFn = jVar.oKc.svS;
                    jVar.oJX.kpo = jVar.oKc.rxG;
                    jVar.oJX.kpp = jVar.oKc.rxH;
                    jVar.oJX.kpw = 1;
                    jVar.oJX.oOk = 0;
                    jVar.mStatus = 3;
                    if (d.bLS() || com.tencent.mm.p.a.BQ() || d.bLV()) {
                        x.e("MicroMsg.Voip.VoipServiceEx", "setInviteContent, reject, pstn/multitak/f2f talking");
                        if (d.bLS()) {
                            s.a(caa.rxG, caa.rxH, 2, null, null, caa.svS);
                        } else {
                            sVar.bLh();
                            q.a(caa.svS, (caa.svK == 0 ? 1 : null) != null ? bd.tby : bd.tbx, 0, 6, ad.getContext().getString(R.l.voip_callfrom_reject_msg));
                        }
                        obj = null;
                    } else if (sVar.oHa.oJX.bGN() < 0) {
                        com.tencent.mm.plugin.voip.b.a.eT("MicroMsg.Voip.VoipServiceEx", "Failed to init v2protocol.");
                        obj = null;
                    } else {
                        if (v2protocal.oPU != null) {
                            v2protocal.oPU.a(sVar.oHa);
                        }
                        com.tencent.mm.plugin.report.service.h.mEJ.a(11524, true, true, new Object[]{Integer.valueOf(caa.rxG), Long.valueOf(caa.rxH), Integer.valueOf(caa.svK), Integer.valueOf(0), Long.valueOf(System.currentTimeMillis())});
                        sVar.oHa.oJY.bKw();
                        obj = 1;
                    }
                }
                if (obj == null) {
                    x.e("MicroMsg.Voip.VoipService", "doTaskCallin setInviteContent failed!");
                    com.tencent.mm.plugin.report.service.h.mEJ.a(11525, true, true, new Object[]{Integer.valueOf(caa.rxG), Long.valueOf(caa.rxH), Integer.valueOf(caa.svK), Integer.valueOf(5), Integer.valueOf(com.tencent.mm.plugin.voip.b.a.getNetType(ad.getContext())), Long.valueOf(System.currentTimeMillis())});
                    com.tencent.mm.plugin.report.service.h.mEJ.a(11526, true, true, new Object[]{Integer.valueOf(i.bJI().oNa.oHa.oJX.kpo), Long.valueOf(i.bJI().bKT()), Long.valueOf(i.bJI().bKU()), Integer.valueOf(7)});
                    return;
                }
                Context context = ad.getContext();
                au.HU();
                if (c.FR().Yg(str) == null) {
                    s.a(caa.rxG, caa.rxH, 4, null, null, str);
                    x.d("MicroMsg.Voip.VoipService", "doTaskCallin invite ignor because talker nil:roomid " + caa.rxG);
                    com.tencent.mm.plugin.report.service.h.mEJ.a(11525, true, true, new Object[]{Integer.valueOf(caa.rxG), Long.valueOf(caa.rxH), Integer.valueOf(caa.svK), Integer.valueOf(4), Integer.valueOf(com.tencent.mm.plugin.voip.b.a.getNetType(ad.getContext())), Long.valueOf(System.currentTimeMillis())});
                    com.tencent.mm.plugin.report.service.h.mEJ.a(11526, true, true, new Object[]{Integer.valueOf(i.bJI().oNa.oHa.oJX.kpo), Long.valueOf(i.bJI().bKT()), Long.valueOf(i.bJI().bKU()), Integer.valueOf(7)});
                    return;
                }
                if (1 == i || i == 0) {
                    a(context, str, false, i == 0, true);
                    if (this.oNa != null) {
                        sVar = this.oNa;
                        sVar.oNu = caa.rxG;
                        if (!sVar.oNF.ciq()) {
                            sVar.oNF.SO();
                        }
                        sVar.oNF.J(70000, 70000);
                    }
                    x.d("MicroMsg.Voip.VoipService", "doTaskCallin invite startActivity VideoActivity");
                }
                s.a(caa.rxG, caa.rxH, 1, this.oNa.oHa.oJX.field_peerId, this.oNa.oHa.oJX.field_capInfo, str);
                com.tencent.mm.plugin.report.service.h.mEJ.a(11525, true, true, new Object[]{Integer.valueOf(caa.rxG), Long.valueOf(caa.rxH), Integer.valueOf(caa.svK), Integer.valueOf(1), Integer.valueOf(com.tencent.mm.plugin.voip.b.a.getNetType(ad.getContext())), Long.valueOf(System.currentTimeMillis())});
                return;
            }
        }
        x.i("MicroMsg.Voip.VoipService", "NotificationConfig.isNewVoipMsgNotification() is false and is not in foreground, now return.");
        if (this.oNn == null && this.ltH.ciq()) {
            x.i("MicroMsg.Voip.VoipService", "voipGetRoomInfoResp is null and time is stopped.");
            this.oNn = caa;
            this.ltH.J(2000, 2000);
            this.oNo = System.currentTimeMillis();
            com.tencent.mm.plugin.report.service.h.mEJ.a(500, 4, 1, false);
        }
    }

    public final void yH(int i) {
        if (this.oNp != null && !this.oNp.isEmpty()) {
            for (a aVar : this.oNp) {
                if (aVar != null && aVar.oNr != null && aVar.oNr.rxG == i) {
                    aVar.gej = true;
                    return;
                }
            }
        }
    }

    public static com.tencent.mm.plugin.voip.model.n.a OG(String str) {
        if (str == null || str.length() == 0) {
            return null;
        }
        int hashCode = str.hashCode();
        com.tencent.mm.plugin.voip.model.n.a aVar = (com.tencent.mm.plugin.voip.model.n.a) dzj.get(Integer.valueOf(hashCode));
        if (aVar != null) {
            return aVar;
        }
        aVar = new com.tencent.mm.plugin.voip.model.n.a();
        if (!aVar.parse(str)) {
            return null;
        }
        dzj.m(Integer.valueOf(hashCode), aVar);
        return aVar;
    }

    private static Map<Integer, Long> aS(byte[] bArr) {
        if (bi.bC(bArr)) {
            return null;
        }
        try {
            bsb bsb = (bsb) new bsb().aG(bArr);
            if (bsb == null) {
                return null;
            }
            x.d("MicroMsg.Voip.VoipService", "dkpush : keyCount:" + bsb.slH);
            LinkedList linkedList = bsb.slI;
            if (linkedList.size() != bsb.slH) {
                return null;
            }
            Map<Integer, Long> hashMap = new HashMap();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= bsb.slH) {
                    break;
                }
                hashMap.put(Integer.valueOf(((aqd) linkedList.get(i2)).mEb), Long.valueOf(4294967295L & ((long) ((aqd) linkedList.get(i2)).rSE)));
                i = i2 + 1;
            }
            if (hashMap.size() != bsb.slH) {
                return null;
            }
            return hashMap;
        } catch (Exception e) {
            return null;
        }
    }

    private static byte[] P(Map<Integer, Long> map) {
        bsb bsb = new bsb();
        LinkedList linkedList = new LinkedList();
        for (Integer num : map.keySet()) {
            aqd aqd = new aqd();
            aqd.mEb = num.intValue();
            aqd.rSE = ((Long) map.get(num)).intValue();
            linkedList.push(aqd);
        }
        bsb.slI = linkedList;
        bsb.slH = linkedList.size();
        try {
            return bsb.toByteArray();
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.Voip.VoipService", e, "", new Object[0]);
            return null;
        }
    }

    private static String aT(byte[] bArr) {
        String str = "";
        for (byte b : bArr) {
            String toHexString = Integer.toHexString(b & 255);
            if (toHexString.length() == 1) {
                toHexString = "0" + toHexString;
            }
            str = str + toHexString.toUpperCase();
        }
        return str;
    }

    public final int b(byte[] bArr, int i, long j) {
        long j2;
        long j3;
        long j4 = 0;
        long j5 = 0;
        long j6 = 0;
        long j7 = 0;
        long j8 = 0;
        x.i("MicroMsg.Voip.VoipService", "__parse voip notify begin");
        Map aS = aS(this.oNa.oHa.oKb);
        if (aS == null) {
            x.i("MicroMsg.Voip.VoipService", "local voipsynckey buff nil");
            j2 = 0;
        } else {
            j3 = 0;
            for (Integer num : aS.keySet()) {
                Long l = (Long) aS.get(num);
                switch (num.intValue()) {
                    case 1:
                        j4 = l.longValue();
                        break;
                    case 2:
                        j5 = l.longValue();
                        break;
                    case 3:
                        j3 = l.longValue();
                        break;
                    default:
                        String str = "MicroMsg.Voip.VoipService";
                        x.i(str, "parse local voipsynckey:" + num.intValue() + ",value:" + l);
                        break;
                }
            }
            j2 = j3;
        }
        x.i("MicroMsg.Voip.VoipService", "local voip synckey: statuskey:" + j4 + " relayData key:" + j5 + " connectingStatusKey:" + j2);
        try {
            bzw bzw = (bzw) new bzw().aG(bArr);
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 < bzw.svL.size()) {
                    bzv bzv = (bzv) bzw.svL.get(i3);
                    x.i("MicroMsg.Voip.VoipService", "__parse voip notify, item cmdid:" + bzv.rtM);
                    StringBuilder stringBuilder;
                    if (bzv.rtM == 1) {
                        cav cav;
                        try {
                            cav = (cav) new cav().aG(bzv.rfy.siK.lR);
                        } catch (Throwable e) {
                            x.i("MicroMsg.Voip.VoipService", "parse Voip notify status item fail");
                            x.printErrStackTrace("MicroMsg.Voip.VoipService", e, "", new Object[0]);
                            cav = null;
                        }
                        if (cav != null) {
                            x.i("MicroMsg.Voip.VoipService", "voip notify status:" + cav.hcd);
                            if (j6 < ((long) bzv.mEb)) {
                                j3 = (long) bzv.mEb;
                            } else {
                                j3 = j6;
                            }
                            if (((long) bzv.mEb) > j4) {
                                x.i("MicroMsg.Voip.VoipService", "voiop notify status key[" + bzv.mEb + "] > local status key[" + j4 + "] status[" + cav.hcd + "]");
                                this.oNa.oHa.oKa.a(cav, 1);
                                j6 = j3;
                            }
                        } else {
                            x.i("MicroMsg.Voip.VoipService", "parse Voip notify status item fail");
                            j3 = j6;
                        }
                        j6 = j3;
                    } else if (bzv.rtM == 2) {
                        cak cak;
                        try {
                            cak = (cak) new cak().aG(bzv.rfy.siK.lR);
                        } catch (Throwable e2) {
                            x.i("MicroMsg.Voip.VoipService", "parse Voip notify relaydata item fail");
                            x.printErrStackTrace("MicroMsg.Voip.VoipService", e2, "", new Object[0]);
                            cak = null;
                        }
                        if (cak != null) {
                            x.i("MicroMsg.Voip.VoipService", "notify relay data type:" + cak.hcE);
                            if (j7 < ((long) bzv.mEb)) {
                                j3 = (long) bzv.mEb;
                            } else {
                                j3 = j7;
                            }
                            if (((long) bzv.mEb) > j5) {
                                stringBuilder = new StringBuilder("notify relaydata key:[");
                                x.i("MicroMsg.Voip.VoipService", stringBuilder.append(bzv.mEb).append("] > local relaydata key[").append(j5).append("]").toString());
                                if (cak.hcE == 5) {
                                    this.oNa.oHa.oKa.a(cak);
                                    j7 = j3;
                                } else if (cak.hcE == 1) {
                                    this.oNa.oHa.oKa.b(cak);
                                    j7 = j3;
                                } else {
                                    x.i("MicroMsg.Voip.VoipService", "notify relaydata unknown type:" + cak.hcE);
                                    j7 = j3;
                                }
                            } else {
                                stringBuilder = new StringBuilder("notify relaydata item key[");
                                x.i("MicroMsg.Voip.VoipService", stringBuilder.append(bzv.mEb).append("] <=local relaydatakey[").append(j5).append("]").toString());
                                j7 = j3;
                            }
                        } else {
                            x.i("MicroMsg.Voip.VoipService", "parse Voip notify relaydata item fail");
                        }
                    } else if (bzv.rtM == 3) {
                        bhy br;
                        try {
                            br = new bhy().br(bzv.rfy.siK.lR);
                        } catch (Throwable e22) {
                            x.printErrStackTrace("MicroMsg.Voip.VoipService", e22, "", new Object[0]);
                            br = null;
                        }
                        if (br != null) {
                            if (j8 < ((long) bzv.mEb)) {
                                j3 = (long) bzv.mEb;
                            } else {
                                j3 = j8;
                            }
                            if (((long) bzv.mEb) > j2) {
                                stringBuilder = new StringBuilder("notify connectingStatkey[");
                                x.i("MicroMsg.Voip.VoipService", stringBuilder.append(bzv.mEb).append("]> local connectingstatus key[").append(j2).append("]").toString());
                                this.oNa.oHa.oKa.c(br);
                                if (this.oNn != null && (com.tencent.mm.plugin.voip.b.a.aV(br.siK.toByteArray()) & 255) == 1) {
                                    this.oNn.svK = 1;
                                }
                            }
                            j8 = j3;
                        }
                    }
                    i2 = i3 + 1;
                } else {
                    if (j6 <= j4) {
                        j6 = j4;
                    }
                    if (j7 <= j5) {
                        j7 = j5;
                    }
                    if (j8 <= j2) {
                        j8 = j2;
                    }
                    Map hashMap = new HashMap();
                    hashMap.put(Integer.valueOf(1), Long.valueOf(j6));
                    hashMap.put(Integer.valueOf(2), Long.valueOf(j7));
                    hashMap.put(Integer.valueOf(3), Long.valueOf(j8));
                    byte[] P = P(hashMap);
                    if (i == this.oNa.oHa.oJX.kpo && j == this.oNa.oHa.oJX.kpp) {
                        this.oNa.oHa.oKb = P;
                        x.i("MicroMsg.Voip.VoipService", "voipNotify:ext notify data new keys:" + j6 + ", " + j7 + ", " + j8);
                    }
                    x.i("MicroMsg.Voip.VoipService", "__parse voip notify end");
                    return 0;
                }
            }
        } catch (Throwable e3) {
            x.printErrStackTrace("MicroMsg.Voip.VoipService", e3, "", new Object[0]);
            x.i("MicroMsg.Voip.VoipService", "parse voip extNotifyData fail extNotifyData size " + bArr.length + " first byte " + aT(bArr));
            return 0;
        }
    }

    public static byte[] R(byte[] bArr, int i) {
        byte[] bArr2 = new byte[i];
        for (int i2 = 12; i2 < i + 12; i2++) {
            bArr2[i2 - 12] = bArr[i2];
        }
        return bArr2;
    }

    public final int G(boolean z, boolean z2) {
        s sVar = this.oNa;
        sVar.bLk();
        if (!sVar.oNF.ciq()) {
            sVar.oNF.SO();
        }
        m mVar = sVar.oHa.oJX.oPS;
        mVar.oLx = System.currentTimeMillis();
        com.tencent.mm.plugin.voip.b.a.eV("MicroMsg.VoipDailReport", "devin:acceptCallTime:" + mVar.oLx);
        x.i("MicroMsg.Voip.VoipServiceEx", "accept onlyAudio:" + z);
        if (!sVar.oHa.bJO()) {
            com.tencent.mm.plugin.voip.b.a.eT("MicroMsg.Voip.VoipServiceEx", "Failed to accept with calling, status =" + sVar.oHa.mStatus);
            return -1;
        } else if (sVar.oHa.oJX.kpo == 0) {
            com.tencent.mm.plugin.voip.b.a.eT("MicroMsg.Voip.VoipServiceEx", "Failed to accept with roomid = 0. ");
            return -1;
        } else {
            com.tencent.mm.plugin.voip.b.a.eV("MicroMsg.Voip.VoipServiceEx", g.Ac() + "accept invite, roomid:" + sVar.oHa.oJX.kpo);
            sVar.oNE.J(50000, 50000);
            sVar.oHa.oJX.oPS.bKf();
            new com.tencent.mm.plugin.voip.model.a.b(1, sVar.oHa.oJX.netType, sVar.oHa.oJX.kpo, sVar.oHa.oJX.field_peerId, sVar.oHa.oJX.field_capInfo, sVar.oHa.oJX.kpp, z, z2).bLp();
            sVar.oHa.setStatus(4);
            sVar.oHa.oJZ.oKv = 1;
            sVar.oHa.bXc = true;
            return 0;
        }
    }

    public final int bKR() {
        s sVar = this.oNa;
        x.i("MicroMsg.Voip.VoipServiceEx", "hangUp");
        if (sVar.oHa.oJX.kpo == 0) {
            sVar.oHa.oJZ.bKe();
            sVar.reset();
            return 0;
        }
        sVar.oHa.oJX.oPS.oKQ = sVar.oHa.bJN();
        return sVar.bLi();
    }

    public final void yw(int i) {
        this.oNa.oHa.yw(i);
    }

    public final int bKS() {
        return this.oNa.oHa.oJX.kpo;
    }

    public final long bKT() {
        return this.oNa.oHa.oJX.kpp;
    }

    public final long bKU() {
        return (long) this.oNa.oHa.oJX.oOw;
    }

    public final boolean bKV() {
        return this.oNa.oHa.bJV();
    }

    public final boolean bKW() {
        return this.oNa.oHa.bJW();
    }

    public final int bJx() {
        l lVar = this.oNa.oHa.oJZ;
        return lVar.oKt != null ? lVar.oKt.bJx() : 0;
    }

    public final void yI(int i) {
        x.d("MicroMsg.Voip.VoipService", "devin: camera errcode: %d", new Object[]{Integer.valueOf(i)});
        this.oNa.oHa.oJX.oOx = Math.abs(i);
    }

    public final void bKX() {
        x.d("MicroMsg.Voip.VoipService", "devin: setCallResult: %d", new Object[]{Integer.valueOf(1)});
        this.oNa.oHa.oJX.oPS.oLc = 1;
    }

    public final int a(byte[] bArr, int i, int i2, int i3, int i4, int[] iArr, boolean z) {
        l lVar = this.oNa.oHa.oJZ;
        if (((!z ? 1 : 0) & (lVar.oKv == l.oKu ? 1 : 0)) != 0) {
            return -1;
        }
        return !lVar.oHa.oJX.lkO ? -1 : lVar.oHa.oJX.videoEncodeToLocal(bArr, i, i3, i4, i2, 0, 75, iArr);
    }

    public final boolean iJ(boolean z) {
        l lVar = this.oNa.oHa.oJZ;
        return lVar.oKt != null ? lVar.oKt.iJ(z) : false;
    }

    public final int iQ(boolean z) {
        j jVar = this.oNa.oHa;
        int tf = z ? jVar.oJX.tf(412) : jVar.oJX.tf(413);
        if (tf < 0) {
            com.tencent.mm.plugin.voip.b.a.eT("MicroMsg.Voip.VoipContext", "voipContext tryMuteMicrophone ret:" + tf);
        }
        return tf;
    }

    public final int iR(boolean z) {
        j jVar = this.oNa.oHa;
        int tf = z ? jVar.oJX.tf(401) : jVar.oJX.tf(402);
        if (tf < 0) {
            com.tencent.mm.plugin.voip.b.a.eU("MicroMsg.Voip.VoipContext", "voipContext trySwitchSpeakerPhone ret:" + tf);
        }
        return tf;
    }

    public final void l(int i, int i2, boolean z) {
        s sVar = this.oNa;
        if (sVar.oNt != null && i > 0) {
            sVar.oNt.n(i, i2, z);
        }
    }

    public final void dO(int i, int i2) {
        s sVar = this.oNa;
        if (sVar.oNt != null && i > 0) {
            sVar.oNt.o(i, i2, true);
        }
    }

    public final void yJ(int i) {
        s sVar = this.oNa;
        if (sVar.oNt != null && i > 0) {
            sVar.oNt.o(i, 0, false);
        }
    }

    public final void stopRing() {
        s sVar = this.oNa;
        if (sVar.oNt != null) {
            sVar.oNt.stop();
        }
    }

    public final boolean bKY() {
        s sVar = this.oNa;
        return sVar.oNt != null ? sVar.oNt.alf() : true;
    }

    public static void bKZ() {
    }

    public static void bLa() {
    }

    public static void a(Context context, String str, boolean z, boolean z2, boolean z3) {
        if (context == null) {
            context = ad.getContext();
        }
        long currentTimeMillis = System.currentTimeMillis();
        ih ihVar = new ih();
        ihVar.bRN.bRQ = false;
        ihVar.bRN.bRP = currentTimeMillis;
        ihVar.bRN.bRO = context;
        com.tencent.mm.sdk.b.a.sFg.m(ihVar);
        x.i("MicroMsg.Voip.VoipService", "start VideoActivity");
        Intent intent = new Intent(context, VideoActivity.class);
        intent.putExtra("Voip_User", str);
        intent.putExtra("Voip_Outcall", z);
        intent.putExtra("Voip_VideoCall", z2);
        intent.putExtra("Voip_LastPage_Hash", currentTimeMillis);
        if (z3) {
            intent.setFlags(603979776);
            intent.addFlags(268435456);
        }
        context.startActivity(intent);
    }

    public static float iS(boolean z) {
        float f = 0.74766356f;
        try {
            byte[] bArr;
            r bJI = i.bJI();
            if (z) {
                bArr = bJI.oNa.oHa.oJX.field_capInfo;
            } else {
                bArr = bJI.oNa.oHa.oJX.oOn;
            }
            if (bArr != null) {
                ByteBuffer wrap = ByteBuffer.wrap(bArr);
                if (wrap.getInt() > 65535) {
                    wrap.order(ByteOrder.LITTLE_ENDIAN);
                }
                wrap.getShort();
                wrap.getShort();
                float f2 = ((float) wrap.getInt()) / 100.0f;
                if (f2 != 0.0f) {
                    f = f2;
                }
                x.d("MicroMsg.Voip.VoipService", "use rate: %s, changed: %s", new Object[]{Float.valueOf(f), Boolean.valueOf(z)});
            }
        } catch (Exception e) {
            x.e("MicroMsg.Voip.VoipService", "update failed: " + e.getMessage());
        }
        return f;
    }

    public final void bLb() {
        this.oNa.oND.J(1000, 1000);
    }

    private static boolean dE(Context context) {
        List runningTasks = ((ActivityManager) context.getSystemService("activity")).getRunningTasks(1);
        if (!(runningTasks == null || runningTasks.isEmpty())) {
            ComponentName componentName = ((RunningTaskInfo) runningTasks.get(0)).topActivity;
            x.d("MicroMsg.Voip.VoipService", "topActivity:" + componentName.flattenToString());
            if (!componentName.getPackageName().equals(context.getPackageName())) {
                x.i("MicroMsg.Voip.VoipService", "is in backGround.");
                return false;
            }
        }
        if (((KeyguardManager) ad.getContext().getSystemService("keyguard")).inKeyguardRestrictedInputMode()) {
            return false;
        }
        x.i("MicroMsg.Voip.VoipService", "is in foreGround.");
        return true;
    }

    public final void yK(int i) {
        j jVar = this.oNa.oHa;
        com.tencent.mm.plugin.voip.b.a.eU("MicroMsg.Voip.VoipContext", "zhengxue: audio device occupied stat sync stat " + i + " app 1");
        try {
            byte[] bArr = new byte[4];
            bArr[0] = (byte) i;
            jVar.oJX.setJNIAppCmd(2, bArr, 4);
            bzb bzb = new bzb();
            bzb.svq = i;
            bzb.svr = 1;
            bxi bxi = new bxi();
            bxi.stM = 4;
            bxi.stN = new b(bzb.toByteArray(), 0, 1);
            jVar.oJX.SendRUDP(bxi.toByteArray(), bxi.toByteArray().length);
        } catch (Exception e) {
            com.tencent.mm.plugin.voip.b.a.eU("MicroMsg.Voip.VoipContext", "onAudioDevOccupiedStat Error");
        }
    }

    public final void OH(String str) {
        for (int i = 0; i < 2; i++) {
            ah.i(new 4(this, str), 1000);
        }
    }

    public final void bLc() {
        l lVar = this.oNa.oHa.oJZ;
        x.l("MicroMsg.Voip.VoipDeviceHandler", "forceCleanRecord, recorder %s", new Object[]{lVar.ltc});
        synchronized (lVar.oKF) {
            if (lVar.ltc != null) {
                x.i("MicroMsg.Voip.VoipDeviceHandler", "do stop record");
                lVar.ltc.we();
                lVar.ltc = null;
            }
        }
    }
}
