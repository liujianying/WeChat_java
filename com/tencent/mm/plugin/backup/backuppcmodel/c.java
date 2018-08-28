package com.tencent.mm.plugin.backup.backuppcmodel;

import android.content.Intent;
import com.tencent.mm.ab.e;
import com.tencent.mm.bk.b;
import com.tencent.mm.plugin.backup.backuppcmodel.d.2;
import com.tencent.mm.plugin.backup.f.b.d;
import com.tencent.mm.plugin.backup.f.f.a;
import com.tencent.mm.plugin.backup.f.g;
import com.tencent.mm.plugin.backup.f.i;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.x;
import java.util.HashSet;
import java.util.Set;

public final class c {
    private static int dHg = 2;
    private static boolean gUi = false;
    private al gUh;
    final e gUj = new 1(this);
    private final e gUk = new 3(this);
    com.tencent.mm.plugin.backup.f.b.c gUo = new 9(this);
    private final a gUp = new 6(this);
    private final i.a gUq = new i.a() {
        public final void arG() {
            int i = b.arV().arW().gWw;
            if (1 == i || 3 == i) {
                b.arV().arX().mH(b.arV().aqP().gRC);
            } else if (2 == i || 4 == i) {
                b.arV().arY().mw(b.arV().aqP().gRC);
            }
        }

        public final void mB(int i) {
        }

        public final void arH() {
            int i = b.arV().aqP().gRC;
            x.e("MicroMsg.BackupPcProcessMgr", "speedOverTime callback, state[%d]", new Object[]{Integer.valueOf(i)});
            int i2 = b.arV().arW().gWw;
            if ((1 == i2 || 3 == i2) && (i == 14 || i == 4)) {
                b.arV().arw().stop();
                b.arV().arX().an(true);
                h.mEJ.a(400, 9, 1, false);
                b.arV().arX().mG(18);
                b.arV().aqP().gRC = -4;
                b.arV().arX().mH(-4);
            } else if (2 != i2 && 4 != i2) {
            } else {
                if (i == 23 || i == 4) {
                    b.arV().arw().stop();
                    b.arV().arY().a(true, false, -4);
                    h.mEJ.a(400, 17, 1, false);
                    b.arV().arY().mG(18);
                }
            }
        }
    };
    boolean gWA;
    private b gWB;
    public int gWC;
    public boolean gWD = true;
    private final d gWE = new 4(this);
    public final g.a gWF = new 8(this);
    public int gWw = 0;
    public String gWx;
    String gWy;
    int gWz;

    static /* synthetic */ void a(c cVar, int i, int i2) {
        x.i("MicroMsg.BackupPcProcessMgr", "newBackup, command[%d]", new Object[]{Integer.valueOf(i)});
        cVar.gWw = 1;
        b.arV().gRx = null;
        b.arV().arX().init();
        e arX = b.arV().arX();
        x.i("MicroMsg.BackupPcServer", "clearContinueBackupData.");
        arX.gUw.dt(false);
        cf(i, i2);
        b.arV().arX().aqN();
    }

    static /* synthetic */ void b(c cVar) {
        com.tencent.mm.plugin.backup.f.b.mx(1);
        b.arV().aqQ();
        com.tencent.mm.plugin.backup.f.b.a(cVar.gUo);
        com.tencent.mm.plugin.backup.f.b.a(cVar.gWE);
        com.tencent.mm.plugin.backup.f.b.a(b.arV().arw());
        com.tencent.mm.plugin.backup.f.b.a(cVar.gUq);
        com.tencent.mm.plugin.backup.f.b.a(cVar.gUp);
        b.arV().aqP().gRC = 1;
        Intent className = new Intent().setClassName(ad.getContext(), "com.tencent.mm.ui.LauncherUI");
        className.addFlags(335544320);
        className.putExtra("nofification_type", "back_to_pcmgr_notification");
        ad.getContext().startActivity(className);
        gUi = false;
        x.i("MicroMsg.BackupPcProcessMgr", "startConnectPc, PC ip:%s, PC wifi:%s, Phone wifi:%s", new Object[]{cVar.gWy, cVar.gWx, com.tencent.mm.plugin.backup.a.g.cQ(ad.getContext())});
        dHg = 2;
        cVar.asa();
    }

    static /* synthetic */ void b(c cVar, int i, int i2) {
        x.i("MicroMsg.BackupPcProcessMgr", "newRecover, command[%d]", new Object[]{Integer.valueOf(i)});
        cVar.gWw = 2;
        b.arV().gRx = null;
        b.arV().arY().init();
        b.arV().arY().arB();
        cf(i, i2);
        d arY = b.arV().arY();
        Set hashSet = new HashSet();
        hashSet.addAll(arY.gWI);
        ah.A(new 2(arY, hashSet));
    }

    static /* synthetic */ void d(c cVar) {
        String str = cVar.gWx;
        String str2 = cVar.gWy;
        String cQ = com.tencent.mm.plugin.backup.a.g.cQ(ad.getContext());
        b.arV().arw().stop();
        x.e("MicroMsg.BackupPcProcessMgr", "tryConnectFailed thisWifiName:%s, pcWifiName:%s, pcIpAddress:%s, tryCount:%d", new Object[]{cQ, str, str2, Integer.valueOf(dHg)});
        if (cQ == null || cQ.equals("")) {
            h.mEJ.a(400, 1, 1, false);
            h.mEJ.h(13736, new Object[]{Integer.valueOf(1), str, cQ, Integer.valueOf(0), Integer.valueOf(b.arV().arW().gWC)});
            b.arV().aqP().gRC = -1;
            b.arV().arX().mH(-1);
        } else if (str == null || !str.equals(cQ)) {
            h.mEJ.a(400, 2, 1, false);
            h.mEJ.h(13736, new Object[]{Integer.valueOf(2), str, cQ, Integer.valueOf(0), Integer.valueOf(b.arV().arW().gWC)});
            b.arV().aqP().gRC = -2;
            b.arV().arX().mH(-2);
        } else if (!com.tencent.mm.plugin.backup.a.g.ww(str2)) {
            h.mEJ.a(400, 3, 1, false);
            h.mEJ.h(13736, new Object[]{Integer.valueOf(3), str, cQ, Integer.valueOf(0), Integer.valueOf(b.arV().arW().gWC)});
            b.arV().aqP().gRC = -3;
            b.arV().arX().mH(-3);
        } else if (dHg <= 0) {
            h.mEJ.a(400, 63, 1, false);
            h.mEJ.h(13736, new Object[]{Integer.valueOf(6), str, cQ, Integer.valueOf(0), Integer.valueOf(b.arV().arW().gWC)});
            b.arV().aqP().gRC = -5;
            b.arV().arX().mH(-5);
        } else {
            dHg--;
            cVar.asa();
        }
    }

    public final void a(boolean z, b bVar) {
        this.gWA = z;
        this.gWB = bVar;
    }

    private void asa() {
        b.arV().arw().connect(this.gWy, this.gWz);
        com.tencent.mm.plugin.backup.f.b.clear();
        com.tencent.mm.plugin.backup.f.b.a(1, this.gUk);
        com.tencent.mm.plugin.backup.f.a aVar = new com.tencent.mm.plugin.backup.f.a(b.arV().gRv, b.arV().gRw, com.tencent.mm.plugin.backup.a.d.aqT(), b.arV().gRu, 0, 1);
        aVar.s(true, true);
        aVar.gXt.hcG = 1;
        aVar.ass();
        x.i("MicroMsg.BackupPcProcessMgr", "tryConnect start backupConnectTimerHandler.");
        if (this.gUh == null) {
            this.gUh = new al(new al.a() {
                public final boolean vD() {
                    if (!c.gUi) {
                        x.e("MicroMsg.BackupPcProcessMgr", "tryConnect overtime failed.");
                        if (c.this.gUh != null) {
                            c.this.gUh.SO();
                        }
                        c.d(c.this);
                    }
                    return true;
                }
            }, false);
        }
        this.gUh.J(3000, 3000);
    }

    public static String asb() {
        return com.tencent.mm.plugin.backup.f.b.asp();
    }

    public final void mF(int i) {
        x.i("MicroMsg.BackupPcProcessMgr", "backupSendCommandRequest cmd:%d", new Object[]{Integer.valueOf(i)});
        com.tencent.mm.plugin.backup.h.b bVar = new com.tencent.mm.plugin.backup.h.b();
        bVar.hbr = i;
        if (i == 9) {
            bVar.hbs = this.gWB;
        }
        try {
            com.tencent.mm.plugin.backup.f.b.J(bVar.toByteArray(), 17);
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.BackupPcProcessMgr", e, "BackupCommandRequest to buf err.", new Object[0]);
        }
    }

    public static void cf(int i, int i2) {
        x.i("MicroMsg.BackupPcProcessMgr", "backupSendCommandResponse cmd:%d", new Object[]{Integer.valueOf(i)});
        com.tencent.mm.plugin.backup.h.c cVar = new com.tencent.mm.plugin.backup.h.c();
        cVar.hbr = i;
        try {
            com.tencent.mm.plugin.backup.f.b.o(cVar.toByteArray(), 18, i2);
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.BackupPcProcessMgr", e, "BackupCommandResponse to buf err.", new Object[0]);
        }
    }

    public static void arE() {
        x.i("MicroMsg.BackupPcProcessMgr", "backupSendCancelRequest.");
        com.tencent.mm.plugin.backup.h.a aVar = new com.tencent.mm.plugin.backup.h.a();
        aVar.ID = b.arV().gRu;
        try {
            com.tencent.mm.plugin.backup.f.b.J(aVar.toByteArray(), 5);
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.BackupPcProcessMgr", e, "BackupCancelRequest to buf err.", new Object[0]);
        }
    }
}
