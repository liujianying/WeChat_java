package com.tencent.mm.plugin.talkroom.model;

import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Looper;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.ax.a;
import com.tencent.mm.ax.c;
import com.tencent.mm.model.ae;
import com.tencent.mm.model.au;
import com.tencent.mm.model.r;
import com.tencent.mm.plugin.talkroom.b.f;
import com.tencent.mm.plugin.talkroom.component.TalkRoomService;
import com.tencent.mm.plugin.talkroom.component.b;
import com.tencent.mm.plugin.talkroom.component.d;
import com.tencent.mm.plugin.talkroom.model.c.1;
import com.tencent.mm.plugin.talkroom.model.i.10;
import com.tencent.mm.plugin.talkroom.model.i.11;
import com.tencent.mm.plugin.talkroom.model.i.12;
import com.tencent.mm.plugin.talkroom.model.i.2;
import com.tencent.mm.plugin.talkroom.model.i.3;
import com.tencent.mm.plugin.talkroom.model.i.4;
import com.tencent.mm.plugin.talkroom.model.i.6;
import com.tencent.mm.pointers.PByteArray;
import com.tencent.mm.protocal.c.bhz;
import com.tencent.mm.protocal.c.bsl;
import com.tencent.mm.protocal.c.bsm;
import com.tencent.mm.protocal.c.bsn;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.ai;
import java.net.InetAddress;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class g implements e, a, c, ae {
    public static final int[] oxg = new int[]{80, 8080, 16285};
    public static final byte[][] oxh = new byte[][]{new byte[]{(byte) 101, (byte) -30, (byte) 76, (byte) 27}, new byte[]{(byte) 112, (byte) 64, (byte) -19, (byte) -29}, new byte[]{(byte) 120, (byte) -52, (byte) -55, (byte) -58}};
    private final ServiceConnection hKe = new 1(this);
    private int kpo;
    private long kpp;
    private int owR = 0;
    private int owS = 0;
    private boolean owT = false;
    public String owU;
    private int owV;
    private int owW;
    private int owX;
    private LinkedList<bsl> owY = new LinkedList();
    private com.tencent.mm.plugin.talkroom.component.a owZ;
    private b oxa;
    private com.tencent.mm.plugin.talkroom.component.e oxb;
    private d oxc;
    private ab oxd;
    private al oxe;
    private i oxf = new i();
    public boolean oxi = false;
    private int state = 0;

    public g() {
        TalkRoomReceiver.init();
    }

    public final int bHb() {
        if (this.owR != 1) {
            return (com.tencent.mm.ay.d.elh == null || !com.tencent.mm.ay.d.elh.nt(this.owU)) ? 0 : 1;
        } else {
            return 1;
        }
    }

    public final List aZp() {
        return b.bGU().np(this.owU);
    }

    public final String bHc() {
        Iterator it = b.bGU().np(this.owU).iterator();
        while (it.hasNext()) {
            bsm bsm = (bsm) it.next();
            if (bsm.spS == this.owX) {
                return bsm.hbL;
            }
        }
        return null;
    }

    public final void a(com.tencent.mm.ax.d dVar) {
        i iVar = this.oxf;
        synchronized (dVar) {
            if (iVar.cWy.contains(dVar)) {
            } else {
                iVar.cWy.add(dVar);
            }
        }
        this.oxf.nr(bHc());
    }

    public final void b(com.tencent.mm.ax.d dVar) {
        i iVar = this.oxf;
        synchronized (dVar) {
            iVar.cWy.remove(dVar);
        }
    }

    private boolean bHd() {
        if (bHb() == 1) {
            b(b.bGS().ovZ);
        } else {
            a(b.bGS().ovZ);
        }
        if (this.owS > 0) {
            x.i("MicroMsg.TalkRoomServer", "addListener has init before");
        } else {
            au.DF().a(332, this);
            au.DF().a(334, this);
            au.DF().a(336, this);
            au.DF().a(335, this);
            b.bGU().a(this);
            au.vv().a(this);
            this.owS = 1;
            if (this.owZ != null) {
                try {
                    this.owZ.Close();
                    this.owZ.uninitLive();
                } catch (Throwable e) {
                    x.printErrStackTrace("MicroMsg.TalkRoomServer", e, "", new Object[0]);
                }
            }
            ad.getContext().bindService(new Intent(ad.getContext(), TalkRoomService.class), this.hKe, 1);
            this.oxa = new 2(this);
        }
        return true;
    }

    public final void T(String str, int i) {
        x.i("MicroMsg.TalkRoomServer", "enterTalkRoom %s scene %d", new Object[]{str, Integer.valueOf(i)});
        this.owR = i;
        bHd();
        if (str.equals(this.owU)) {
            x.d("MicroMsg.TalkRoomServer", "enterTalkRoom %s has enter the talkroom", new Object[]{str});
            if (this.state == 2) {
                this.oxf.St();
                return;
            }
            return;
        }
        x.d("MicroMsg.TalkRoomServer", "%s enter the talkroom", new Object[]{str});
        this.owU = str;
        au.DF().a(new com.tencent.mm.plugin.talkroom.b.a(this.owU, bHb()), 0);
        b.bGS().owb = new f();
        b.bGW().owL = bi.VG();
        b.bGW().owI = str;
        if (bHb() == 0) {
            b.bGS().ovZ.kGt = true;
        }
        i iVar = this.oxf;
        11 11 = new 11(iVar, str);
        if (Looper.myLooper() == Looper.getMainLooper()) {
            11.run();
        } else {
            iVar.handler.post(11);
        }
    }

    public final void aZL() {
        x.i("MicroMsg.TalkRoomServer", "exitTalkRoom");
        iz(false);
        if (bi.oW(this.owU)) {
            x.i("MicroMsg.TalkRoomServer", "exitTalkRoom: has exited");
            return;
        }
        int Close;
        f bGW = b.bGW();
        if (bGW.owL != 0) {
            bGW.owp = (int) (bi.bI(bGW.owL) / 1000);
        }
        this.state = 0;
        this.owT = false;
        au.DF().a(new com.tencent.mm.plugin.talkroom.b.b(this.kpo, this.kpp, this.kpo != 0 ? this.owU : "", bHb()), 0);
        if (this.owZ != null) {
            try {
                Close = this.owZ.Close();
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.TalkRoomServer", e, "", new Object[0]);
                Close = -99999;
            }
            if (Close < 0) {
                x.e("MicroMsg.TalkRoomServer", "engine.Close error %d", new Object[]{Integer.valueOf(Close)});
            }
            PByteArray pByteArray = new PByteArray();
            if (a(pByteArray, r.gT(this.owU)) == 0) {
                x.i("MicroMsg.TalkRoomServer", "getStatis==> pba.len %d, info: %s", new Object[]{Integer.valueOf(pByteArray.value.length), new String(pByteArray.value)});
                LinkedList linkedList = new LinkedList();
                bsn bsn = new bsn();
                bsn.rSt = 10402;
                bsn.spT = new bhz().VO(r1);
                bsn bsn2 = new bsn();
                bsn2.rSt = 10404;
                bsn2.spT = new bhz().VO(b.bGW().toString());
                linkedList.add(bsn);
                linkedList.add(bsn2);
                au.DF().a(new com.tencent.mm.plugin.talkroom.b.g(linkedList, bHb()), 0);
            }
        }
        this.owU = "";
        this.kpo = 0;
        this.kpp = 0;
        this.owV = 0;
        this.owW = 0;
        this.owX = 0;
        this.owY.clear();
        bHe();
        i iVar = this.oxf;
        12 12 = new 12(iVar);
        if (Looper.myLooper() == Looper.getMainLooper()) {
            12.run();
        } else {
            iVar.handler.post(12);
        }
        c cVar = b.bGS().ovZ;
        cVar.mHandler.post(new 1(cVar));
        this.owS = 0;
        au.DF().b(332, this);
        au.DF().b(334, this);
        au.DF().b(336, this);
        au.DF().b(335, this);
        b.bGU().b(this);
        au.vv().b(this);
        b(b.bGS().ovZ);
        if (this.owZ != null) {
            try {
                Close = this.owZ.uninitLive();
            } catch (Throwable e2) {
                x.printErrStackTrace("MicroMsg.TalkRoomServer", e2, "", new Object[0]);
            }
            ad.getContext().unbindService(this.hKe);
            ad.getContext().stopService(new Intent(ad.getContext(), TalkRoomService.class));
            this.owZ = null;
            if (Close < 0) {
                x.e("MicroMsg.TalkRoomServer", "engine.uninitLive error %d", new Object[]{Integer.valueOf(Close)});
            }
        }
        Close = -99999;
        ad.getContext().unbindService(this.hKe);
        ad.getContext().stopService(new Intent(ad.getContext(), TalkRoomService.class));
        this.owZ = null;
        if (Close < 0) {
            x.e("MicroMsg.TalkRoomServer", "engine.uninitLive error %d", new Object[]{Integer.valueOf(Close)});
        }
    }

    private void bHe() {
        if (this.oxb != null) {
            try {
                this.oxb.release();
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.TalkRoomServer", e, "", new Object[0]);
            }
            this.oxb = null;
        }
        if (this.oxc != null) {
            try {
                this.oxc.release();
            } catch (Throwable e2) {
                x.printErrStackTrace("MicroMsg.TalkRoomServer", e2, "", new Object[0]);
            }
            this.oxc = null;
        }
        if (this.oxd != null) {
            this.oxd.SO();
            this.oxd = null;
        }
        if (this.oxe != null) {
            this.oxe.SO();
            this.oxe = null;
        }
    }

    private void iz(boolean z) {
        if (!bi.oW(this.owU)) {
            au.HU();
            ai Yq = com.tencent.mm.model.c.FW().Yq(this.owU);
            if (Yq != null) {
                Yq.at(com.tencent.mm.plugin.messenger.foundation.a.a.a.a(Yq, z ? 5 : 6, Yq.field_conversationTime));
                au.HU();
                com.tencent.mm.model.c.FW().a(Yq, this.owU);
            }
        }
    }

    public final boolean Sq() {
        x.i("MicroMsg.TalkRoomServer", "seizeMic");
        if (this.state != 2) {
            x.i("MicroMsg.TalkRoomServer", "seizeMic  not int the appropriate state");
            if (this.state == 0) {
                this.oxf.b(3, -1, "seizeMic in outside room state");
            }
            return false;
        }
        if (this.oxb != null) {
            try {
                this.oxb.bAf();
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.TalkRoomServer", e, "", new Object[0]);
            }
        }
        this.state = 3;
        au.DF().a(new com.tencent.mm.plugin.talkroom.b.d(this.kpo, this.kpp, 1, this.owU, bHb()), 0);
        b.bGW().owN = bi.VG();
        b.bGW().owQ = true;
        return true;
    }

    public final void Sr() {
        x.i("MicroMsg.TalkRoomServer", "putAwayMic");
        f bGW = b.bGW();
        if (bGW.owQ && !bGW.owP) {
            bGW.owK++;
        }
        bGW.owP = false;
        bGW.owQ = false;
        if (this.state < 3) {
            x.w("MicroMsg.TalkRoomServer", "putAwayMic  err, isnot getting or has not got mic");
            return;
        }
        if (this.oxe != null) {
            this.oxe.SO();
            this.oxe = null;
        }
        bHf();
        au.DF().a(new com.tencent.mm.plugin.talkroom.b.d(this.kpo, this.kpp, 2, this.owU, bHb()), 0);
    }

    public final void a(int i, int i2, String str, l lVar) {
        x.i("MicroMsg.TalkRoomServer", "type:%d  errType:%d  errCode:%d", new Object[]{Integer.valueOf(lVar.getType()), Integer.valueOf(i), Integer.valueOf(i2)});
        f fVar = (f) lVar;
        if (fVar.bHj() == null || !fVar.bHj().equals(this.owU)) {
            x.w("MicroMsg.TalkRoomServer", "%s, now :%s this is the old sceneEnd, abandon it!!", new Object[]{fVar.bHj(), this.owU});
            return;
        }
        f bGW;
        if (!(i == 0 && i2 == 0)) {
            if (lVar.getType() == 332) {
                b.bGW().xY(2);
                if (i == 4) {
                    b.bGW().owJ = i2;
                }
                this.oxf.i("cgi enter failed : errType:" + i + " errCode:" + i2, i, i2);
                aZL();
                return;
            } else if (lVar.getType() == 334) {
                if (((com.tencent.mm.plugin.talkroom.b.d) lVar).actionType == 1) {
                    bGW = b.bGW();
                    bGW.ows++;
                    bGW.owN = 0;
                    bHf();
                    x.w("MicroMsg.TalkRoomServer", "onSceneEnd SeizeMicFailed");
                    if (i == 4 && (i2 == 311 || i2 == 340)) {
                        this.oxf.iA(i2);
                        return;
                    } else {
                        this.oxf.b(i, i2, "TalkMicAction failed!!");
                        return;
                    }
                }
                return;
            } else if (lVar.getType() == 336) {
                this.owT = false;
                this.oxf.b(i, i2, "TalkGetMember failed!!");
                aZL();
                return;
            } else if (lVar.getType() == 335) {
                this.oxf.b(i, i2, "TalkNoop failed!!");
                aZL();
                return;
            }
        }
        if (lVar.getType() == 332) {
            b.bGW().xY(1);
            com.tencent.mm.plugin.talkroom.b.a aVar = (com.tencent.mm.plugin.talkroom.b.a) lVar;
            this.kpo = aVar.kpo;
            this.kpp = aVar.kpp;
            this.owV = aVar.owV;
            this.owW = aVar.owW;
            this.owY = aVar.owY;
            bGW = b.bGW();
            int i3 = this.kpo;
            long j = this.kpp;
            bGW.kpo = i3;
            bGW.kpp = j;
            b.bGU().a(this.owU, aVar.oxr, null, null, fVar.bHk());
            xZ(100);
        } else if (lVar.getType() == 334) {
            com.tencent.mm.plugin.talkroom.b.d dVar = (com.tencent.mm.plugin.talkroom.b.d) lVar;
            if (dVar.actionType == 1) {
                bGW = b.bGW();
                if (bGW.owN != 0) {
                    bGW.owq = (bi.bI(bGW.owN) + (bGW.owq * ((long) bGW.owM))) / ((long) (bGW.owM + 1));
                    bGW.owM++;
                    bGW.owr++;
                    bGW.owN = 0;
                }
                x.i("MicroMsg.TalkRoomServer", "dealWithSeizeMic seize Mic successFul");
                if (dVar.owV < this.owV) {
                    x.w("MicroMsg.TalkRoomServer", "micSeq is smaller seizeSeq %d, now %d", new Object[]{Integer.valueOf(dVar.owV), Integer.valueOf(this.owV)});
                    bHf();
                    this.oxf.iA(311);
                    return;
                }
                this.owV = dVar.owV;
                int i4 = -99999;
                try {
                    i4 = this.owZ.SetCurrentMicId(this.owV);
                } catch (Throwable e) {
                    x.printErrStackTrace("MicroMsg.TalkRoomServer", e, "", new Object[0]);
                }
                if (this.state != 3) {
                    x.i("MicroMsg.TalkRoomServer", "dealWithSeizeMic not in getting mic state");
                    return;
                }
                i iVar = this.oxf;
                6 6 = new 6(iVar);
                if (Looper.myLooper() == Looper.getMainLooper()) {
                    6.run();
                } else {
                    iVar.handler.post(6);
                }
                this.state = 4;
                if (i4 < 0) {
                    x.e("MicroMsg.TalkRoomServer", "SetCurrentMicId err: %d ", new Object[]{Integer.valueOf(i4)});
                }
                if (this.oxe == null) {
                    this.oxe = new al(new 3(this), true);
                    this.oxe.J(5000, 5000);
                    return;
                }
                return;
            }
            x.i("MicroMsg.TalkRoomServer", "putaway Mic successFul");
        } else {
            if (lVar.getType() == 336) {
                com.tencent.mm.plugin.talkroom.b.c cVar = (com.tencent.mm.plugin.talkroom.b.c) lVar;
                b.bGU().a(this.owU, cVar.oxr, null, null, fVar.bHk());
                ya(cVar.owV);
                this.owT = false;
                this.oxf.nr(bHc());
            }
            if (lVar.getType() == 335 && this.state == 0) {
                this.oxf.b(3, -1, "talknoop success but in outside room state");
            }
        }
    }

    private void bHf() {
        try {
            f bGW = b.bGW();
            if (bGW.owO != 0) {
                long bI = bi.bI(bGW.owO) / 1000;
                if (bI < 2) {
                    bGW.owz++;
                } else if (bI < 6) {
                    bGW.owA++;
                } else if (bI < 11) {
                    bGW.owB++;
                } else if (bI < 21) {
                    bGW.owC++;
                } else if (bI < 31) {
                    bGW.owD++;
                } else if (bI < 41) {
                    bGW.owE++;
                } else if (bI < 51) {
                    bGW.owF++;
                } else if (bI < 61) {
                    bGW.owG++;
                } else {
                    bGW.owH++;
                }
                bGW.owO = 0;
            }
            if (this.oxc != null) {
                this.oxc.bGP();
            }
            if (this.oxb != null) {
                this.oxb.bGR();
            }
            this.state = 2;
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.TalkRoomServer", e, "", new Object[0]);
        }
    }

    public final void Sn() {
        x.i("MicroMsg.TalkRoomServer", "resumeRecord in state %d", new Object[]{Integer.valueOf(this.state)});
        if (this.state == 4) {
            f bGW = b.bGW();
            bGW.owP = true;
            bGW.owO = bi.VG();
            try {
                this.oxc.Sn();
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.TalkRoomServer", e, "", new Object[0]);
            }
        }
    }

    private void xZ(int i) {
        if (this.owZ != null) {
            try {
                this.state = 1;
                this.owT = false;
                if (bHg()) {
                    bHe();
                    bHi();
                    bHh();
                    if (this.oxd != null) {
                        x.w("MicroMsg.TalkRoomServer", "enter talkroom not first time");
                        return;
                    }
                    this.oxd = new ab(new 5(this));
                    ab abVar = this.oxd;
                    ab.sGv = true;
                    abVar.dkB = 50000;
                    abVar.ts = bi.VG();
                    boolean fY = ab.fY(abVar.dkB);
                    abVar.SO();
                    ab.sGs.put(Integer.valueOf(abVar.sGr), abVar);
                    if (ab.cWE != null && fY) {
                        x.v("MicroMsg.MAlarmHandler", "prepare bumper");
                        ab.cWE.prepare();
                    }
                }
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.TalkRoomServer", e, "", new Object[0]);
            }
        } else if (i == 0) {
            this.oxf.i("bind talkroomService timeout", 3, -1);
        } else {
            new ag().postDelayed(new 4(this, i), 50);
        }
    }

    private boolean bHg() {
        int i = -99999;
        try {
            i = this.owZ.bGN();
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.TalkRoomServer", e, "", new Object[0]);
        }
        x.i("MicroMsg.TalkRoomServer", "engine.protocalInit");
        if (i >= 0 || i == -3) {
            return true;
        }
        this.owZ = null;
        x.f("MicroMsg.TalkRoomServer", "engine.protocalInit error %d", new Object[]{Integer.valueOf(i)});
        this.oxf.i("enterTalkRoom protocalInit failed", 3, -1);
        return false;
    }

    private void ya(int i) {
        if (i > this.owV) {
            this.owV = i;
            if (this.state >= 3) {
                this.oxf.iA(311);
            }
            bHf();
        }
    }

    public final void iA(boolean z) {
        x.i("MicroMsg.TalkRoomServer", "reConnect talkRoomUsername: %s", new Object[]{this.owU});
        if (!bi.oW(this.owU) && this.state >= 2) {
            f bGW = b.bGW();
            bGW.owv++;
            if (z) {
                if (bHg()) {
                    try {
                        bHh();
                    } catch (Throwable e) {
                        x.e("MicroMsg.TalkRoomServer", e.toString());
                        x.printErrStackTrace("MicroMsg.TalkRoomServer", e, "", new Object[0]);
                    }
                } else {
                    return;
                }
            }
            bHf();
            this.state = 1;
            try {
                if (this.owZ != null) {
                    this.owZ.Close();
                }
            } catch (Throwable e2) {
                x.printErrStackTrace("MicroMsg.TalkRoomServer", e2, "", new Object[0]);
            }
            if (this.kpo != 0) {
                bHi();
            }
            if (!z) {
                i iVar = this.oxf;
                4 4 = new 4(iVar);
                if (Looper.myLooper() == Looper.getMainLooper()) {
                    4.run();
                } else {
                    iVar.handler.post(4);
                }
            }
        }
    }

    private void bHh() {
        if (this.owZ == null) {
            x.e("MicroMsg.TalkRoomServer", "the engine should not be null.");
            return;
        }
        this.oxb = this.owZ.a(new 6(this));
        this.oxb.start();
        this.oxc = this.owZ.bGO();
        this.oxc.start();
    }

    private static String yb(int i) {
        try {
            return InetAddress.getByAddress(new byte[]{(byte) ((i >>> 24) & 255), (byte) ((i >>> 16) & 255), (byte) ((i >>> 8) & 255), (byte) (i & 255)}).getHostAddress();
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.TalkRoomServer", e, "", new Object[0]);
            return null;
        }
    }

    private void bHi() {
        if (this.owY.size() == 0) {
            x.e("MicroMsg.TalkRoomServer", "engine. talk relay addr list is empty");
            this.oxf.b(3, -1, "engine.talk relay addr list empty");
            return;
        }
        int a;
        int[] iArr = new int[this.owY.size()];
        int[] iArr2 = new int[this.owY.size()];
        x.i("MicroMsg.TalkRoomServer", "talk relay addr cnt %d", new Object[]{Integer.valueOf(this.owY.size())});
        for (int i = 0; i < this.owY.size(); i++) {
            iArr[i] = ((bsl) this.owY.get(i)).spR;
            iArr2[i] = ((bsl) this.owY.get(i)).sed;
            x.i("MicroMsg.TalkRoomServer", "add talk relay addr %s %d", new Object[]{yb(((bsl) this.owY.get(i)).spR), Integer.valueOf(((bsl) this.owY.get(i)).sed)});
        }
        x.i("MicroMsg.TalkRoomServer", "engine.Open myRoomMemId %d, roomId %d, roomKey %d", new Object[]{Integer.valueOf(this.owW), Integer.valueOf(this.kpo), Long.valueOf(this.kpp)});
        try {
            com.tencent.mm.plugin.talkroom.component.a aVar = this.owZ;
            b bVar = this.oxa;
            au.HU();
            a = aVar.a(bVar, com.tencent.mm.model.c.Df(), this.owW, this.kpo, this.kpp, iArr, iArr2, 0);
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.TalkRoomServer", e, "", new Object[0]);
            a = -99999;
        }
        if (a < 0 && a != -3) {
            x.e("MicroMsg.TalkRoomServer", "engine.Open error %d", new Object[]{Integer.valueOf(a)});
            this.oxf.b(3, a, "engine.Open error");
        }
    }

    public final short So() {
        short s = (short) 0;
        if (this.oxc == null) {
            return s;
        }
        try {
            return (short) this.oxc.bGQ();
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.TalkRoomServer", e, "", new Object[s]);
            return s;
        }
    }

    public final short Sp() {
        short s = (short) 0;
        if (this.oxb == null) {
            return s;
        }
        try {
            return (short) this.oxb.bGQ();
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.TalkRoomServer", e, "", new Object[s]);
            return s;
        }
    }

    private int a(PByteArray pByteArray, String str) {
        if (this.owZ == null) {
            return -99;
        }
        int[] iArr = new int[1];
        try {
            pByteArray.value = this.owZ.e(iArr, str);
        } catch (Throwable e) {
            iArr[0] = -99999;
            x.printErrStackTrace("MicroMsg.TalkRoomServer", e, "", new Object[0]);
        }
        return iArr[0];
    }

    public final void p(String str, String str2, String str3) {
        if (str.equals(this.owU)) {
            i iVar = this.oxf;
            10 10 = new 10(iVar, str2, str3);
            if (Looper.myLooper() == Looper.getMainLooper()) {
                10.run();
            } else {
                iVar.handler.post(10);
            }
        }
    }

    public final boolean Ss() {
        return this.oxi;
    }

    public final void HB() {
        x.v("MicroMsg.TalkRoomServer", "yy talkroom onResume");
        if (bi.oW(this.owU)) {
            x.d("MicroMsg.TalkRoomServer", "pause");
        } else {
            bHf();
        }
        this.oxi = false;
        i iVar = this.oxf;
        3 3 = new 3(iVar);
        if (Looper.myLooper() == Looper.getMainLooper()) {
            3.run();
        } else {
            iVar.handler.post(3);
        }
    }

    public final void HC() {
        x.v("MicroMsg.TalkRoomServer", "yy talkroom onPause");
        try {
            if (bi.oW(this.owU)) {
                x.d("MicroMsg.TalkRoomServer", "pause");
            } else {
                if (this.oxc != null) {
                    this.oxc.bGP();
                }
                if (this.oxb != null) {
                    this.oxb.bAf();
                }
                this.state = 2;
            }
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.TalkRoomServer", e, "", new Object[0]);
        }
        this.oxi = true;
        i iVar = this.oxf;
        2 2 = new 2(iVar);
        if (Looper.myLooper() == Looper.getMainLooper()) {
            2.run();
        } else {
            iVar.handler.post(2);
        }
    }
}
