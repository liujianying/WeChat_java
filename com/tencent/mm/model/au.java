package com.tencent.mm.model;

import android.database.Cursor;
import com.tencent.map.lib.gl.model.GLIcon;
import com.tencent.mm.ab.o;
import com.tencent.mm.ab.s;
import com.tencent.mm.compatible.b.f;
import com.tencent.mm.g.a.z;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.c.a;
import com.tencent.mm.network.n;
import com.tencent.mm.plugin.account.friend.a.r;
import com.tencent.mm.plugin.account.friend.a.t;
import com.tencent.mm.plugin.account.friend.a.u;
import com.tencent.mm.plugin.report.b.b$a;
import com.tencent.mm.plugin.report.b.c;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.zero.a.e;
import com.tencent.mm.protocal.c.ace;
import com.tencent.mm.protocal.c.pb;
import com.tencent.mm.protocal.d;
import com.tencent.mm.protocal.j;
import com.tencent.mm.protocal.k;
import com.tencent.mm.protocal.m;
import com.tencent.mm.protocal.p;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.ay;
import com.tencent.mm.storage.az;
import com.tencent.mm.storage.w;
import com.tencent.tmassistantsdk.logreport.BaseReportManager;
import junit.framework.Assert;

public final class au {
    private static au dBx = null;
    private static final bs dBz = new bs();
    private final int dBA = 1;
    final a dBB;
    private bw dBC = new bw();
    private bo dBD = new bo();
    private e dBE = new e();
    private bz dBF = new bz();
    private v dBG = new v();
    private ay.a dBH = new 4(this);
    private az.a dBI = new 5(this);
    private az.a dBJ = new 6(this);
    private f dBK = new f();
    private final c dBo;
    private final ak dBw;
    private f dBy = null;

    public static boolean HM() {
        return dBx == null;
    }

    public static void a(n nVar) {
        g.Ek();
        g.Eh().a(nVar);
    }

    public static void b(n nVar) {
        g.Ek();
        g.Eh().b(nVar);
    }

    public static void a(aj ajVar) {
        b.a(ajVar);
    }

    public static void gc(String str) {
        com.tencent.mm.kernel.a.gc(str);
    }

    public static bs HN() {
        HR();
        return dBz;
    }

    public static by El() {
        HR();
        return g.El();
    }

    public static boolean HO() {
        return com.tencent.mm.kernel.a.Dq();
    }

    public static void HP() {
        com.tencent.mm.kernel.a.bt(false);
    }

    public static void a(ak akVar, o.a aVar) {
        dBx = new au(akVar, aVar);
        com.tencent.mm.modelstat.o.bS(ad.getContext());
    }

    public static al getNotification() {
        return HR().dBw.getNotification();
    }

    public static ad vv() {
        return HR().dBw.vv();
    }

    private au(ak akVar, o.a aVar) {
        this.dBw = akVar;
        this.dBB = new a() {
            public final void bu(boolean z) {
                ab abVar;
                x.i("MicroMsg.MMCore", "summeranrt2 onAccountPostReset tid:%d stack[%s]", new Object[]{Long.valueOf(Thread.currentThread().getId()), bi.cjd()});
                au.b(au.this);
                long currentTimeMillis = System.currentTimeMillis();
                au.HU();
                long dO = c.FO().dO(Thread.currentThread().getId());
                au.this.dBo;
                au.HQ();
                if (z) {
                    c.FR().Ym("readerapp");
                    c.DT().set(GLIcon.TOP, Boolean.valueOf(true));
                    ab.HA();
                    ab.HA();
                    Cursor clm = c.FR().clm();
                    if (clm.moveToFirst()) {
                        do {
                            abVar = new ab();
                            abVar.d(clm);
                            abVar.Bn();
                            c.FR().a(abVar.field_username, abVar);
                        } while (clm.moveToNext());
                    }
                    clm.close();
                    bf.iH("ver" + d.qVN);
                }
                aa aaVar = new aa(au.this.dBo);
                if (z) {
                    aa.w(c.FR().Yg("filehelper"));
                    String GF = q.GF();
                    if (!bi.oW(GF)) {
                        abVar = c.FR().Yg(GF);
                        if (((int) abVar.dhP) == 0) {
                            abVar.setUsername(GF);
                            abVar.Bb();
                            au.HU();
                            c.FR().T(abVar);
                        } else if (!com.tencent.mm.l.a.gd(abVar.field_type)) {
                            abVar.Bb();
                            au.HU();
                            c.FR().a(GF, abVar);
                        }
                    }
                    aa.a(z, "qqmail", false);
                    aa.a(z, "floatbottle", false);
                    aa.a(z, "shakeapp", false);
                    aa.a(z, "lbsapp", false);
                    aa.a(z, "medianote", false);
                    aa.a(z, "newsapp", true);
                    c.FW().Yp("blogapp");
                    c.FT().GK("blogapp");
                    c.FR().Ym("blogapp");
                    aa.a(z, "facebookapp", true);
                    aa.a(z, "qqfriend", false);
                    aa.a(z, "masssendapp", true);
                    aa.a(z, "feedsapp", true);
                    c.FW().Yp("tmessage");
                    c.FR().Ym("tmessage");
                    abVar = c.FR().Yg("voip");
                    com.tencent.mm.l.a Yg = c.FR().Yg("voipapp");
                    if (Yg == null) {
                        Yg = new ab();
                    }
                    if (!(abVar == null || ((int) abVar.dhP) == 0)) {
                        c.FR().Ym("voip");
                    }
                    if (((int) Yg.dhP) == 0) {
                        Yg.setUsername("voipapp");
                        Yg.Bb();
                        aa.x(Yg);
                        Yg.eI(4);
                        Yg.Bk();
                        c.FR().U(Yg);
                    } else if (z) {
                        Yg.Bk();
                        c.FR().a("voipapp", Yg);
                    }
                    Yg = c.FR().Yg("officialaccounts");
                    if (Yg == null) {
                        Yg = new ab();
                    }
                    x.i("MicroMsg.HardCodeHelper", "hardcodeOfficialAccounts:update[%B], contactID[%d]", new Object[]{Boolean.valueOf(z), Integer.valueOf((int) Yg.dhP)});
                    if (((int) Yg.dhP) == 0) {
                        Yg.setUsername("officialaccounts");
                        Yg.Bc();
                        aa.x(Yg);
                        Yg.eI(3);
                        c.FR().U(Yg);
                    } else if (z) {
                        x.i("MicroMsg.HardCodeHelper", "do update hardcode official accounts");
                        Yg.Bc();
                        c.FR().a("officialaccounts", Yg);
                    }
                    abVar = c.FR().Yg("voipaudio");
                    Yg = c.FR().Yg("voicevoipapp");
                    if (Yg == null) {
                        Yg = new ab();
                    }
                    if (!(abVar == null || ((int) abVar.dhP) == 0)) {
                        c.FR().Ym("voipaudio");
                    }
                    if (((int) Yg.dhP) == 0) {
                        Yg.setUsername("voicevoipapp");
                        Yg.Bb();
                        aa.x(Yg);
                        Yg.eI(4);
                        Yg.Bk();
                        c.FR().U(Yg);
                    } else if (z) {
                        Yg.Bk();
                        c.FR().a("voicevoipapp", Yg);
                    }
                    aa.a(z, "voiceinputapp", false);
                    aa.a(z, "linkedinplugin", false);
                    Yg = c.FR().Yg("notifymessage");
                    if (Yg == null) {
                        Yg = new ab();
                    }
                    x.i("MicroMsg.HardCodeHelper", "hardcodeOfficialAccounts:update[%B], contactID[%d]", new Object[]{Boolean.valueOf(z), Integer.valueOf((int) Yg.dhP)});
                    if (((int) Yg.dhP) == 0) {
                        Yg.setUsername("notifymessage");
                        Yg.Bc();
                        aa.x(Yg);
                        Yg.eI(3);
                        c.FR().U(Yg);
                    } else if (z) {
                        x.i("MicroMsg.HardCodeHelper", "do update hardcode official accounts");
                        Yg.Bc();
                        c.FR().a("notifymessage", Yg);
                    }
                    Yg = c.FR().Yg("appbrandcustomerservicemsg");
                    if (Yg == null) {
                        Yg = new ab();
                    }
                    x.i("MicroMsg.HardCodeHelper", "hardcodeAppBrandServiceMessage:update[%B], contactID[%d]", new Object[]{Boolean.valueOf(z), Integer.valueOf((int) Yg.dhP)});
                    if (((int) Yg.dhP) == 0) {
                        Yg.setUsername("appbrandcustomerservicemsg");
                        Yg.Bc();
                        aa.x(Yg);
                        Yg.setType(0);
                        Yg.eI(3);
                        c.FR().U(Yg);
                    } else if (z) {
                        x.i("MicroMsg.HardCodeHelper", "do update app brand service message accunt");
                        Yg.Bc();
                        c.FR().a("appbrandcustomerservicemsg", Yg);
                    }
                    if (z) {
                        au.HU();
                        c.FW().Yp("Weixin");
                        au.HU();
                        c.FR().Ym("Weixin");
                    }
                }
                au.HU();
                c.FO().gp(dO);
                x.i("MicroMsg.MMCore", "summeranrt dkwt set forceManual :%b, tid[%d], take[%s]ms, stack[%s]", new Object[]{Boolean.valueOf(z), Long.valueOf(Thread.currentThread().getId()), Long.valueOf(System.currentTimeMillis() - currentTimeMillis), bi.cjd()});
                au.this.dBo;
                c.FW().a(au.HR().dBw.vu());
            }
        };
        g.Ek();
        g.a(a.class, new a(this));
        g.Ek().dqS.aI(aVar);
        this.dBo = new c();
        h.mEJ.a(99, 142, 1, false);
        s.a(new e() {
            public final byte[] a(k.d dVar, int i) {
                switch (i) {
                    case 107:
                        return ((u.a) dVar).eKE.rhB.siK.toByteArray();
                    case 145:
                        return ((m.a) dVar).qWG.rhB.siK.toByteArray();
                    case 429:
                        return ((t.a) dVar).eKC.rhB.siK.toByteArray();
                    case 481:
                        return ((r.a) dVar).eKz.rhB.siK.toByteArray();
                    case 499:
                        return ((c.a) dVar).mDL.rhB.siK.toByteArray();
                    case 572:
                        return ((com.tencent.mm.plugin.account.friend.a.s.a) dVar).eKB.rhB.siK.toByteArray();
                    case 616:
                        return ((ay.a) dVar).dBS.rhB.siK.toByteArray();
                    case 617:
                        return ((ba.a) dVar).dBW.rhB.siK.toByteArray();
                    case 618:
                        return ((az.a) dVar).dBU.rhB.siK.toByteArray();
                    case 694:
                        return ((b$a) dVar).mDL.rhB.siK.toByteArray();
                    case 722:
                        return ((p.a) dVar).qWO.rxD.rhB.siK.toByteArray();
                    case 987:
                    case 997:
                        return ((pb) ((com.tencent.mm.ab.b.b) dVar).dIL).rtm.toByteArray();
                    case 989:
                        return ((ace) ((com.tencent.mm.ab.b.b) dVar).dIL).rtm.toByteArray();
                    case BaseReportManager.MAX_READ_COUNT /*1000*/:
                        return ((j.a) dVar).qWq;
                    default:
                        return null;
                }
            }
        });
        g.Ek();
        b Eh = g.Eh();
        Eh.dpO.aI(new 3(this));
    }

    public static void HQ() {
    }

    private static au HR() {
        Assert.assertNotNull("MMCore not initialized by MMApplication", dBx);
        return dBx;
    }

    public static w HS() {
        g.Ek();
        return g.Ei().dqk;
    }

    public static ah Em() {
        return g.Em();
    }

    public static bv getSysCmdMsgExtension() {
        return ((com.tencent.mm.plugin.messenger.foundation.a.o) g.n(com.tencent.mm.plugin.messenger.foundation.a.o.class)).getSysCmdMsgExtension();
    }

    public static String DA() {
        return com.tencent.mm.kernel.a.DA();
    }

    public static void HT() {
        com.tencent.mm.sdk.b.a.sFg.m(new z());
    }

    public static c HU() {
        c cVar = HR().dBo;
        Assert.assertTrue("MMCore has not been initialize ?", cVar != null);
        return cVar;
    }

    public static o DF() {
        g.Ek();
        return g.Eh().dpP;
    }

    public static f HV() {
        return f.yz();
    }

    public static boolean HW() {
        g.Eg();
        return com.tencent.mm.kernel.a.Dw();
    }

    public static boolean HX() {
        if (ad.cic()) {
            return g.Eg().Dx();
        }
        return false;
    }

    public static boolean Dr() {
        return com.tencent.mm.kernel.a.Dr();
    }

    public static void hold() {
        com.tencent.mm.kernel.a.hold();
    }

    public static void unhold() {
        com.tencent.mm.kernel.a.unhold();
    }

    public static String Dh() {
        g.Ek();
        g.Eg();
        return com.tencent.mm.kernel.a.Dh();
    }

    public static f HY() {
        return HR().dBK;
    }
}
