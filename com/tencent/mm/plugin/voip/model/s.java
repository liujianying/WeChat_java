package com.tencent.mm.plugin.voip.model;

import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Looper;
import android.telephony.TelephonyManager;
import com.tencent.mm.compatible.e.q;
import com.tencent.mm.compatible.util.g;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.voip.model.a.b;
import com.tencent.mm.plugin.voip.model.a.l;
import com.tencent.mm.plugin.voip.model.j.a;
import com.tencent.mm.plugin.voip.video.i;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.bn;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;

public final class s implements a {
    private static int fNP = -1;
    private static int oNv = -1;
    static int oNw = 20;
    WifiManager bnh;
    public j oHa = k.bKc();
    WifiInfo oNA;
    private al oNB = new al(Looper.getMainLooper(), new 1(this), false);
    private byte[] oNC = new byte[500];
    al oND = new al(Looper.getMainLooper(), new 2(this), true);
    al oNE = new al(Looper.getMainLooper(), new 3(this), true);
    al oNF = new al(Looper.getMainLooper(), new 4(this), true);
    private Object oNs = new Object();
    i oNt;
    int oNu = 0;
    public String oNx;
    int oNy;
    Timer oNz = null;

    public s() {
        this.oHa.a(this);
        this.oNt = new i(ad.getContext());
    }

    public final void stop() {
        x.i("MicroMsg.Voip.VoipServiceEx", "stop");
        reset();
        this.oHa.a(null);
    }

    protected final void finalize() {
        stop();
        super.finalize();
    }

    public final void reset() {
        x.d("MicroMsg.Voip.VoipServiceEx", "reset");
        this.oHa.reset();
        this.oNE.SO();
        this.oNB.SO();
        this.oND.SO();
        this.oNF.SO();
        if (this.oNz != null) {
            this.oNz.cancel();
            this.oNz = null;
        }
        this.oNu = 0;
        i.bJI().oMr = null;
    }

    public final boolean bLd() {
        return this.oHa.oJX.kpo != 0;
    }

    public final boolean bJP() {
        if (this.oHa.bJP()) {
            return true;
        }
        return false;
    }

    public static boolean bLe() {
        if (((TelephonyManager) ad.getContext().getSystemService("phone")).getCallState() != 0) {
            return true;
        }
        return false;
    }

    public final void bLf() {
        if (this.oHa.bJP()) {
            com.tencent.mm.plugin.voip.b.a.eT("MicroMsg.Voip.VoipServiceEx", "checkStartup failed, stauts = " + this.oHa.mStatus);
        }
        com.tencent.mm.plugin.voip.b.a.eT("MicroMsg.Voip.VoipServiceEx", "checkStartup...devicekey = " + bn.cmZ());
        this.oHa.bJL();
        x.d("MicroMsg.Voip.VoipServiceEx", "reset");
        this.oHa.reset();
        this.oNE.SO();
        this.oNB.SO();
        this.oND.SO();
        this.oNF.SO();
        this.oNu = 0;
        au.HU();
        q.fd(c.DU().cmX());
    }

    public final void o(int i, int i2, String str) {
        x.i("MicroMsg.Voip.VoipServiceEx", "onFinishVoIP finishType: " + i);
        switch (i) {
            case 1:
                bLi();
                this.oHa.oJY.onError(i2, str);
                return;
            case 4:
                bLi();
                this.oHa.oJY.onReject();
                return;
            case 5:
                bLi();
                this.oHa.oJY.bKy();
                return;
            case 6:
                bLi();
                this.oHa.oJY.bKA();
                return;
            default:
                return;
        }
    }

    public final int cn(String str, int i) {
        x.i("MicroMsg.Voip.VoipServiceEx", "call username:%s, callType:%d, inviteType:%d", str, Integer.valueOf(0), Integer.valueOf(i));
        if (bi.oW(str)) {
            com.tencent.mm.plugin.voip.b.a.eT("MicroMsg.Voip.VoipServiceEx", "Failed call without valid username.");
            return -1;
        } else if (this.oHa.bJP()) {
            com.tencent.mm.plugin.voip.b.a.eT("MicroMsg.Voip.VoipServiceEx", "Failed call withing calling.");
            return -1;
        } else {
            this.oHa.oJX.oOk = 1;
            this.oHa.oJX.kFn = str;
            com.tencent.mm.plugin.voip.b.a.eV("MicroMsg.Voip.VoipServiceEx", g.Ac() + "call username:" + str);
            if (this.oHa.oJX.lkO) {
                com.tencent.mm.plugin.voip.b.a.eT("MicroMsg.Voip.VoipServiceEx", g.Ac() + "v2protocal already init.");
                this.oHa.oJX.iT(false);
                this.oHa.oJX.reset();
            }
            if (this.oHa.oJX.bGN() < 0) {
                com.tencent.mm.plugin.voip.b.a.eT("MicroMsg.Voip.VoipServiceEx", "Failed to init v2protocol.");
                return -1;
            }
            if (this.oHa.oJX.oPT != null) {
                this.oHa.oJX.oPT.oHa = this.oHa;
            }
            if (v2protocal.oPU != null) {
                v2protocal.oPU.a(this.oHa);
            }
            this.oNE.J(50000, 50000);
            this.oHa.oJX.kpr = (int) System.currentTimeMillis();
            List arrayList = new ArrayList();
            arrayList.add(str);
            new com.tencent.mm.plugin.voip.model.a.g(arrayList, this.oHa.oJX.field_peerId, this.oHa.oJX.field_capInfo, this.oHa.oJX.netType, i, this.oHa.oJX.kpr).bLp();
            this.oHa.setStatus(2);
            this.oHa.oJZ.oKv = 1;
            this.oNB.J(60000, 60000);
            this.oHa.oJX.oPS.oLv = System.currentTimeMillis();
            this.oHa.oJX.oPS.beginTime = System.currentTimeMillis();
            this.oHa.oJX.oPS.oLb = i;
            x.d("MicroMsg.Voip.VoipServiceEx", "iRoomType " + this.oHa.oJX.oPS.oLb);
            return 0;
        }
    }

    public final int bLg() {
        if (this.oHa.bJP()) {
            x.i("MicroMsg.Voip.VoipServiceEx", "cancelCallEx, roomId:%d, msgID:%d, inviteId:%d", Integer.valueOf(this.oHa.oJX.kpo), Integer.valueOf(this.oHa.oJX.oOh), Integer.valueOf(this.oHa.oJX.kpr));
            synchronized (this.oNs) {
                if (this.oHa.oJX.kpo == 0 && this.oHa.oJX.kpr == 0) {
                    com.tencent.mm.plugin.voip.b.a.eT("MicroMsg.Voip.VoipServiceEx", "Failed to cancel call with roomid = 0 and inviteId = 0 ");
                    return -1;
                }
                String iT = this.oHa.oJX.iT(true);
                if (iT.length() > 0) {
                    int i = this.oHa.oJX.kpo;
                    long j = this.oHa.oJX.kpp;
                    int i2 = this.oHa.oJX.oOh;
                    new com.tencent.mm.plugin.voip.model.a.c(i, j, this.oHa.oJX.kFn, iT, this.oHa.oJX.kpr).bLp();
                }
                m mVar = this.oHa.oJX.oPS;
                mVar.oLl = (int) (System.currentTimeMillis() - mVar.oLv);
                com.tencent.mm.plugin.voip.b.a.eV("MicroMsg.VoipDailReport", "devin:cancelInvite:" + mVar.oLl);
                if (this.oHa.oJX.oOz == 0 && this.oHa.oJX.oOA == 0) {
                    this.oHa.bJM();
                }
                this.oHa.yv(this.oNt.bMk());
                this.oHa.oJX.oPS.oLA = this.oHa.oJY.bKD();
                String bLy = v2protocal.bLy();
                String bLz = this.oHa.oJX.bLz();
                String bLB = this.oHa.oJX.bLB();
                String bLA = this.oHa.oJX.bLA();
                iT = this.oHa.oJX.bLC();
                if (bLz.length() > 0) {
                    int i3 = this.oHa.oJX.kpo;
                    long j2 = this.oHa.oJX.kpp;
                    i3 = this.oHa.oJX.oOh;
                    String str = this.oHa.oJX.kFn;
                    new l(bLy, bLz, bLA, bLB, iT).bLp();
                }
                this.oHa.bJK();
                reset();
                this.oHa.oJX.kpo = 0;
                this.oHa.oJX.kpr = 0;
                return 0;
            }
        }
        com.tencent.mm.plugin.voip.b.a.eT("MicroMsg.Voip.VoipServiceEx", "Failed to cancel call ,as not in calling.");
        return -1;
    }

    public final int bLh() {
        x.i("MicroMsg.Voip.VoipServiceEx", "reject");
        if (this.oHa.bJO()) {
            synchronized (this.oNs) {
                if (this.oHa.oJX.kpo == 0) {
                    com.tencent.mm.plugin.voip.b.a.eT("MicroMsg.Voip.VoipServiceEx", "Failed to reject with roomid = 0. ");
                    return -1;
                }
                this.oHa.oJX.oPS.bKf();
                com.tencent.mm.plugin.voip.b.a.eV("MicroMsg.Voip.VoipServiceEx", " reject, status:" + this.oHa.mStatus + " roomid:" + this.oHa.oJX.kpo);
                new b(2, this.oHa.oJX.netType, this.oHa.oJX.kpo, new byte[0], new byte[0], this.oHa.oJX.kpp, false, false).bLp();
                if (this.oHa.oJX.oOz == 0 && this.oHa.oJX.oOA == 0) {
                    this.oHa.bJM();
                }
                this.oHa.yv(this.oNt.bMk());
                this.oHa.oJX.oPS.oLA = this.oHa.oJY.bKD();
                this.oHa.oJX.iT(true);
                String bLy = v2protocal.bLy();
                String bLz = this.oHa.oJX.bLz();
                String bLB = this.oHa.oJX.bLB();
                String bLA = this.oHa.oJX.bLA();
                String bLC = this.oHa.oJX.bLC();
                com.tencent.mm.plugin.voip.b.a.eV("MicroMsg.Voip.VoipServiceEx", "devin: statreport");
                if (bLz.length() > 0) {
                    com.tencent.mm.plugin.voip.b.a.eV("MicroMsg.Voip.VoipServiceEx", "devin: reject() newdialInfo.length() > 0");
                    int i = this.oHa.oJX.kpo;
                    long j = this.oHa.oJX.kpp;
                    i = this.oHa.oJX.oOh;
                    String str = this.oHa.oJX.kFn;
                    new l(bLy, bLz, bLA, bLB, bLC).bLp();
                } else {
                    com.tencent.mm.plugin.voip.b.a.eV("MicroMsg.Voip.VoipServiceEx", "devin: reject() newdialInfo.length() <= 0");
                }
                this.oHa.bJK();
                reset();
                this.oHa.oJX.kpo = 0;
                return 0;
            }
        }
        com.tencent.mm.plugin.voip.b.a.eT("MicroMsg.Voip.VoipServiceEx", "Failed to reject with calling, status =" + this.oHa.mStatus);
        return -1;
    }

    public final int bLi() {
        com.tencent.mm.plugin.voip.b.a.eU("MicroMsg.Voip.VoipServiceEx", "hangUp,status:" + this.oHa.mStatus + " roomid:" + this.oHa.oJX.kpo + ",threadid = " + Thread.currentThread().getId());
        this.oHa.oJZ.bKe();
        if (this.oHa.oJX.oPS.oLa == (byte) 1) {
            m mVar = this.oHa.oJX.oPS;
            if (mVar.oLr == 0) {
                mVar.oLk = 0;
            } else {
                mVar.oLk = (int) ((System.currentTimeMillis() - mVar.oLr) / 1000);
            }
            if (mVar.oLk < 0) {
                mVar.oLk = 0;
                com.tencent.mm.plugin.voip.b.a.eT("MicroMsg.VoipDailReport", "devin:endTalk, iCallTime Err, rest 0");
            }
            com.tencent.mm.plugin.voip.b.a.eU("MicroMsg.VoipDailReport", "devin:endTalk:" + mVar.oLk);
        }
        synchronized (this.oNs) {
            int i = this.oHa.oJX.oPS.oLc;
            if (this.oHa.oJX.kpo != 0 || 8 == i || 9 == i || 10 == i || 11 == i || 12 == i || 99 == i) {
                this.oHa.oJY.bKB();
                com.tencent.mm.plugin.voip.b.a.eU("MicroMsg.Voip.VoipServiceEx", "steve:hangUp, uninitGLRender before protocalUninit first!!");
                String iT = this.oHa.oJX.iT(true);
                if (iT.length() > 0) {
                    new com.tencent.mm.plugin.voip.model.a.i(this.oHa.oJX.kpo, this.oHa.oJX.kpp, iT).bLp();
                    com.tencent.mm.plugin.voip.b.a.eT("MicroMsg.Voip.VoipServiceEx", "devin: shutdown cgi ");
                }
                this.oHa.oJX.oPS.oLA = this.oHa.oJY.bKD();
                this.oHa.yv(this.oNt.bMk());
                String bLy = v2protocal.bLy();
                String bLz = this.oHa.oJX.bLz();
                String bLB = this.oHa.oJX.bLB();
                String bLA = this.oHa.oJX.bLA();
                String bLC = this.oHa.oJX.bLC();
                if (bLz.length() > 0) {
                    int i2 = this.oHa.oJX.kpo;
                    long j = this.oHa.oJX.kpp;
                    i2 = this.oHa.oJX.oOh;
                    String str = this.oHa.oJX.kFn;
                    new l(bLy, bLz, bLA, bLB, bLC).bLp();
                    com.tencent.mm.plugin.voip.b.a.eT("MicroMsg.Voip.VoipServiceEx", "devin: statreport cgi ");
                }
            } else {
                com.tencent.mm.plugin.voip.b.a.eT("MicroMsg.Voip.VoipServiceEx", "call hangUp roomId == 0 ");
            }
            this.oHa.bJK();
            reset();
            this.oHa.oJX.kpo = 0;
            com.tencent.mm.plugin.voip.b.a.eV("MicroMsg.Voip.VoipServiceEx", "hangUp over");
        }
        return 0;
    }

    public final int bLj() {
        x.i("MicroMsg.Voip.VoipServiceEx", "ignoreInvite");
        if (this.oHa.bJO()) {
            synchronized (this.oNs) {
                if (this.oHa.oJX.kpo == 0) {
                    com.tencent.mm.plugin.voip.b.a.eT("MicroMsg.Voip.VoipServiceEx", "Failed to reject with roomid = 0. ");
                    return -1;
                }
                new b(3, this.oHa.oJX.netType, this.oHa.oJX.kpo, new byte[0], new byte[0], this.oHa.oJX.kpp, false, false).bLp();
                reset();
                this.oHa.oJX.kpo = 0;
                return 0;
            }
        }
        com.tencent.mm.plugin.voip.b.a.eT("MicroMsg.Voip.VoipServiceEx", "Failed to ignore with calling, status =" + this.oHa.mStatus);
        return -1;
    }

    public static void a(int i, long j, int i2, byte[] bArr, byte[] bArr2, String str) {
        com.tencent.mm.plugin.voip.b.a.eU("MicroMsg.Voip.VoipServiceEx", "doAck roomId " + i + "  roomKey " + j + " status " + i2);
        if (i != 0 && j != 0) {
            new com.tencent.mm.plugin.voip.model.a.a(i, j, i2, bArr, bArr2, str).bLp();
        }
    }

    public final int setNetSignalValue(int i, int i2) {
        return this.oHa.oJX.setNetSignalValue(i, i2);
    }

    public final void bLk() {
        com.tencent.mm.plugin.voip.b.a.eU("MicroMsg.Voip.VoipServiceEx", "devincdai: voip reset timecount");
        this.oNB.SO();
        this.oNB.J(60000, 60000);
    }
}
