package com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel;

import android.content.Intent;
import android.content.pm.PackageInfo;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.os.Build;
import android.os.Build.VERSION;
import com.tencent.mm.ab.l;
import com.tencent.mm.compatible.util.f;
import com.tencent.mm.g.a.lm;
import com.tencent.mm.model.au;
import com.tencent.mm.plugin.backup.a.d;
import com.tencent.mm.plugin.backup.bakoldlogic.bakoldmodel.a;
import com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.d.1;
import com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.f.2;
import com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.f.4;
import com.tencent.mm.plugin.backup.bakoldlogic.d.b;
import com.tencent.mm.plugin.backup.f.b$d;
import com.tencent.mm.plugin.backup.h.ab;
import com.tencent.mm.plugin.backup.h.ac;
import com.tencent.mm.plugin.backup.h.q;
import com.tencent.mm.plugin.backup.h.r;
import com.tencent.mm.plugin.backup.h.s;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.aa;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.OutputStream;
import java.util.List;

public final class e implements b$d {
    private d gZC;
    public c gZK;
    public a gZL;
    public e gZM;
    public d gZN = new d();
    public f gZO = new f();
    com.tencent.mm.plugin.backup.bakoldlogic.c.e gZP;
    private a gZQ;
    public int gZR = -1;
    public String gZS;
    public String gZT;
    public int gZU = -1;
    public int gZV = 1;
    private boolean gZW = false;

    /* renamed from: com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.e$3 */
    class AnonymousClass3 implements com.tencent.mm.ab.e {
        final /* synthetic */ Runnable haa;
        final /* synthetic */ Runnable hab;

        AnonymousClass3(Runnable runnable, Runnable runnable2) {
            this.haa = runnable;
            this.hab = runnable2;
        }

        public final void a(int i, int i2, String str, l lVar) {
            if (lVar != e.this.gZP) {
                x.w("MicroMsg.BakPcProcessMgr", "last canceded scene");
                return;
            }
            if (i == 0 && i2 == 0) {
                x.i("MicroMsg.BakPcProcessMgr", "getPcPwd OK");
                com.tencent.mm.plugin.backup.bakoldlogic.c.e eVar = (com.tencent.mm.plugin.backup.bakoldlogic.c.e) lVar;
                a.asN().gRA = eVar.hax;
                this.haa.run();
            } else {
                e.this.T(10010, new String("getPcPwd Fail"));
                x.i("MicroMsg.BakPcProcessMgr", "getPcPwd Fail");
                this.hab.run();
            }
            au.DF().b(596, this);
        }
    }

    public final void bS(String str, String str2) {
        this.gZS = str;
        this.gZT = str2;
    }

    public final synchronized void dD(boolean z) {
        this.gZW = z;
    }

    public final synchronized boolean asV() {
        return this.gZW;
    }

    public final synchronized void asW() {
        this.gZC = null;
        this.gZN.gZC = null;
        this.gZO.gZC = null;
    }

    public final synchronized void a(d dVar) {
        if (dVar == null) {
            if (this.gZC instanceof com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcui.a) {
                x.d("MicroMsg.BakPcProcessMgr", "setOperatorCallbck BakchatBannerView null ilegal, fking return");
            }
        }
        x.d("MicroMsg.BakPcProcessMgr", "setOperatorCallbck:%s", new Object[]{dVar});
        this.gZC = dVar;
        this.gZN.gZC = dVar;
        this.gZO.gZC = dVar;
    }

    public final void arg() {
        if (this.gZO.haf) {
            f fVar = this.gZO;
            x.i("MicroMsg.RecoverPCServer", "startMerge");
            if (fVar.gSS) {
                x.i("MicroMsg.RecoverPCServer", "hasStartMerge , return");
                return;
            }
            fVar.gZI = 0;
            a.asN().asO().gZV = 6;
            fVar.gSS = true;
            b.atl().a(new 4(fVar));
            return;
        }
        x.e("MicroMsg.BakPcProcessMgr", "startMerge err state");
    }

    public final void pause() {
        if (this.gZR == 1) {
            this.gZN.pause();
        } else if (this.gZR == 6) {
            this.gZO.pause();
        }
    }

    final synchronized void T(int i, String str) {
        x.e("MicroMsg.BakPcProcessMgr", "callbackErr type:%d,  %s", new Object[]{Integer.valueOf(i), str});
        if (i == 10006 || i == 10008) {
            x.e("MicroMsg.BakPcProcessMgr", "callbackErr socketClose");
            this.gZU = -1;
            this.gZV = 1;
            asZ();
            a.asN().asP().gZu = 2;
            a.asN().asP().IF();
            if (this.gZK != null) {
                this.gZK.onError(i);
            }
            if (this.gZL != null) {
                this.gZL.onError(i);
            }
            if (this.gZC != null) {
                this.gZC.onError(i);
            }
            if (this.gZM != null) {
                this.gZM.onError(i);
            }
        }
        if (i == 10009 || i == 10004) {
            x.e("MicroMsg.BakPcProcessMgr", "callbackErr ip not match or connect failed: %d", new Object[]{Integer.valueOf(i)});
            a.asN().asP().gZu = 2;
            a.asN().asP().IF();
            asX();
        } else {
            x.d("MicroMsg.BakPcProcessMgr", "summerbak errtype:%d, authcallback[%s], operatorcallback[%s], eventCallback[%s]", new Object[]{Integer.valueOf(i), this.gZL, this.gZC, this.gZK});
            if (i == 15) {
                if (this.gZL != null) {
                    this.gZL.onError(i);
                }
                if (this.gZC != null) {
                    this.gZC.onError(i);
                }
                if (this.gZK != null) {
                    this.gZK.mS(i);
                }
            }
            if (i == -1) {
                if (this.gZL != null) {
                    this.gZL.onError(i);
                } else if (this.gZC != null) {
                    this.gZC.onError(i);
                } else if (this.gZK != null) {
                    this.gZK.mS(i);
                }
            }
        }
    }

    public final void a(boolean z, int i, byte[] bArr, int i2) {
        if (z && bArr != null) {
            T(i, new String(bArr));
        }
        if (i == 10001 || i == 10002) {
            a.asN().asP().gZu = 1;
            new com.tencent.mm.plugin.backup.bakoldlogic.c.a(a.asN().gRv, a.asN().gRw, d.aqT(), a.asN().gRu).ass();
        }
        if (i == 3) {
            this.gZR = -1;
            ab abVar = new ab();
            try {
                abVar.aG(bArr);
                x.i("MicroMsg.BakPcProcessMgr", "recv cmd:%d (%s)", new Object[]{Integer.valueOf(abVar.hbr), mQ(abVar.hbr)});
                switch (abVar.hbr) {
                    case 0:
                        if (au.HX()) {
                            this.gZR = abVar.hbr;
                            if (this.gZL != null) {
                                this.gZL.ata();
                            } else {
                                x.i("MicroMsg.BakPcProcessMgr", "authCallback is null");
                                Intent className = new Intent().setClassName(ad.getContext(), "com.tencent.mm.ui.LauncherUI");
                                className.addFlags(335544320);
                                className.putExtra("nofification_type", "back_to_pcmgr_notification");
                                className.putExtra("newPCBackup", false);
                                ad.getContext().startActivity(className);
                            }
                            this.gZU = 0;
                            this.gZV = 1;
                            return;
                        }
                        x.w("MicroMsg.BakPcProcessMgr", "acc is not ready, not support pcmgr's auth");
                        a(abVar.hbr, 1, null);
                        return;
                    case 1:
                        a.asN().asQ().asR();
                        a.asN().asP().IF();
                        T(-1, null);
                        x.e("MicroMsg.BakPcProcessMgr", "summerback new version not support old pc backup request toast upgrade pc");
                        return;
                    case 3:
                        this.gZV = 2;
                        this.gZU = 3;
                        asZ();
                        a(abVar.hbr, 0, null);
                        com.tencent.mm.sdk.f.e.b(new 1(this.gZN), "BakPCServer_startBak").start();
                        return;
                    case 4:
                        this.gZU = -1;
                        this.gZV = 1;
                        asZ();
                        a(abVar.hbr, 0, null);
                        if (this.gZP != null) {
                            this.gZP.cancel();
                            this.gZP = null;
                        }
                        if (this.gZN != null) {
                            this.gZN.cancel();
                        }
                        if (this.gZQ != null) {
                            a aVar = this.gZQ;
                            x.i("MicroMsg.BakCalculator", "calculator cancel.");
                            x.d("MicroMsg.BakCalculator", "calculator cancel. stack:%s", new Object[]{bi.cjd()});
                            aVar.dJO = true;
                            this.gZQ = null;
                        }
                        if (this.gZC != null) {
                            this.gZC.atc();
                            return;
                        }
                        return;
                    case 6:
                        this.gZU = 5;
                        this.gZV = 4;
                        asZ();
                        this.gZR = abVar.hbr;
                        if (this.gZK != null) {
                            this.gZK.mR(abVar.hbr);
                        } else {
                            x.i("MicroMsg.BakPcProcessMgr", "callback is null");
                        }
                        c asP = a.asN().asP();
                        asP.gZx++;
                        b.atl().a(new 1(this));
                        return;
                    case 7:
                        this.gZU = -1;
                        this.gZV = 1;
                        asZ();
                        a(abVar.hbr, 0, null);
                        if (this.gZP != null) {
                            this.gZP.cancel();
                            this.gZP = null;
                        }
                        if (this.gZO != null) {
                            this.gZO.cancel();
                        }
                        if (this.gZC != null) {
                            this.gZC.atc();
                            return;
                        }
                        return;
                    case 9:
                        a(abVar.hbr, 0, null);
                        if (this.gZN != null) {
                            this.gZN.pause();
                            return;
                        }
                        return;
                    case 10:
                        a(abVar.hbr, 0, null);
                        if (this.gZO != null) {
                            this.gZO.pause();
                            return;
                        }
                        return;
                    case 11:
                        a(abVar.hbr, 0, null);
                        if (this.gZN != null) {
                            this.gZN.resume();
                            return;
                        }
                        return;
                    case 12:
                        a(abVar.hbr, 0, null);
                        if (this.gZO != null) {
                            this.gZO.resume();
                            return;
                        }
                        return;
                    case 15:
                        a.asN().asQ().asR();
                        a.asN().asP().IF();
                        T(15, null);
                        return;
                    case 16:
                        a(abVar.hbr, 0, null);
                        if (this.gZM != null) {
                            this.gZM.atd();
                            return;
                        }
                        return;
                    default:
                        return;
                }
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.BakPcProcessMgr", e, "buf to PacketCommandReq error", new Object[0]);
            }
            x.printErrStackTrace("MicroMsg.BakPcProcessMgr", e, "buf to PacketCommandReq error", new Object[0]);
        }
    }

    public static void asX() {
        Intent className = new Intent().setClassName(ad.getContext(), "com.tencent.mm.ui.LauncherUI");
        className.addFlags(335544320);
        className.putExtra("nofification_type", "back_to_pcmgr_error_notification");
        ad.getContext().startActivity(className);
    }

    public final int asY() {
        x.i("MicroMsg.BakPcProcessMgr", "getPCProgressPercent now progress:%d", new Object[]{Integer.valueOf(this.gZV)});
        if (this.gZV == 2 || this.gZV == 3) {
            return this.gZN.gZH;
        }
        if (this.gZV == 4 || this.gZV == 5) {
            return this.gZO.hai;
        }
        if (this.gZV == 6 || this.gZV == 7) {
            return this.gZO.hae;
        }
        x.w("MicroMsg.BakPcProcessMgr", "wrong operatorStatus");
        return 0;
    }

    public final void mO(int i) {
        if (i == 0) {
            this.gZU = 1;
        } else {
            this.gZU = -1;
        }
        ac acVar;
        if (i == 1) {
            acVar = new ac();
            acVar.hbr = 0;
            acVar.hcd = i;
            try {
                x.i("MicroMsg.BakPcProcessMgr", "send auth cmd resp, status:%d", new Object[]{Integer.valueOf(acVar.hcd)});
                com.tencent.mm.plugin.backup.f.b.J(acVar.toByteArray(), 4);
                return;
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.BakPcProcessMgr", e, "buf to PacketCommandResponse err", new Object[0]);
                return;
            }
        }
        q qVar = new q();
        qVar.hco = 0;
        qVar.hcq = Build.MANUFACTURER;
        qVar.hbQ = Build.MODEL;
        qVar.hcp = 0;
        qVar.hcr = VERSION.RELEASE;
        String str = aa.duN;
        if (new File(com.tencent.mm.compatible.util.e.bnC).exists() && f.zZ()) {
            File file = new File(com.tencent.mm.compatible.util.e.bnE);
            if (file.exists() || file.mkdirs()) {
                str = com.tencent.mm.compatible.util.e.bnE;
            }
        }
        qVar.hcn = str;
        qVar.hcm = com.tencent.mm.model.q.GH();
        qVar.hcl = com.tencent.mm.model.q.GF();
        qVar.hck = com.tencent.mm.protocal.d.qVN;
        try {
            PackageInfo packageInfo = ad.getContext().getPackageManager().getPackageInfo(ad.getContext().getPackageName(), 0);
            qVar.hck = packageInfo.versionName + ";" + packageInfo.versionCode + ";" + com.tencent.mm.protocal.d.qVN;
        } catch (Throwable e2) {
            x.printErrStackTrace("MicroMsg.BakPcProcessMgr", e2, "get packageInfo failed", new Object[0]);
        }
        Bitmap jT = com.tencent.mm.aa.q.Kp().jT(qVar.hcl);
        byte[] bArr = null;
        if (jT != null) {
            OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            jT.compress(CompressFormat.PNG, 0, byteArrayOutputStream);
            bArr = byteArrayOutputStream.toByteArray();
            try {
                byteArrayOutputStream.close();
            } catch (Throwable e3) {
                x.printErrStackTrace("MicroMsg.BakPcProcessMgr", e3, "close", new Object[0]);
            }
        }
        String c = com.tencent.mm.aa.q.Kp().c(qVar.hcl, true, false);
        String str2 = "MicroMsg.BakPcProcessMgr";
        String str3 = ", bmHDPath:%s, bm.buf.len:%d";
        Object[] objArr = new Object[2];
        objArr[0] = c;
        objArr[1] = Integer.valueOf(bArr == null ? 0 : bArr.length);
        x.i(str2, str3, objArr);
        if (!bi.bC(bArr)) {
            qVar.hcs = new com.tencent.mm.bk.b(bArr);
        }
        bArr = com.tencent.mm.a.e.f(c, 0, -1);
        if (!bi.bC(bArr)) {
            qVar.hct = new com.tencent.mm.bk.b(bArr);
        }
        acVar = new ac();
        acVar.hbr = 0;
        acVar.hcd = i;
        acVar.hcW = qVar;
        try {
            x.i("MicroMsg.BakPcProcessMgr", "send auth cmd resp, status:%d", new Object[]{Integer.valueOf(acVar.hcd)});
            com.tencent.mm.plugin.backup.f.b.J(acVar.toByteArray(), 4);
        } catch (Throwable e22) {
            x.printErrStackTrace("MicroMsg.BakPcProcessMgr", e22, "buf to PacketCommandResponse err", new Object[0]);
        }
    }

    public static void a(int i, int i2, s sVar) {
        ac acVar = new ac();
        acVar.hbr = i;
        acVar.hcd = i2;
        acVar.hcZ = sVar;
        try {
            x.i("MicroMsg.BakPcProcessMgr", "send cmd resp, status:%d, cmd:%d (%s)", new Object[]{Integer.valueOf(i2), Integer.valueOf(i), mQ(i)});
            com.tencent.mm.plugin.backup.f.b.J(acVar.toByteArray(), 4);
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.BakPcProcessMgr", e, "buf to PacketCommandResponse err", new Object[0]);
        }
    }

    public static void mP(int i) {
        ab abVar = new ab();
        abVar.hbr = i;
        try {
            x.i("MicroMsg.BakPcProcessMgr", "sendNormalReq cmd :%d (%s)", new Object[]{Integer.valueOf(i), mQ(i)});
            com.tencent.mm.plugin.backup.f.b.J(abVar.toByteArray(), 3);
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.BakPcProcessMgr", e, "buf to PacketCommandRequest err", new Object[0]);
        }
    }

    final synchronized void a(r rVar) {
        if (this.gZO != null) {
            this.gZO.cancel();
        }
        this.gZO = new f();
        f fVar = this.gZO;
        List list = rVar.hcu;
        List list2 = rVar.hcv;
        long j = rVar.hcc;
        fVar.hac = list;
        fVar.had = list2;
        fVar.bPd = false;
        fVar.dJO = false;
        fVar.gZB.clear();
        fVar.gZE = false;
        fVar.haf = false;
        fVar.gSS = false;
        fVar.hae = 0;
        fVar.hah = 0;
        fVar.hag = j;
        com.tencent.mm.plugin.backup.bakoldlogic.c.d.setProgress(0);
        this.gZO.gZC = this.gZC;
        x.i("MicroMsg.BakPcProcessMgr", "reve textList:%d,  mediaList:%d, convDataSize:%d", new Object[]{Integer.valueOf(rVar.hcu.size()), Integer.valueOf(rVar.hcv.size()), Long.valueOf(rVar.hcc)});
        fVar = this.gZO;
        fVar.gZI = 0;
        if (fVar.had.size() < rVar.hch || fVar.hac.size() < rVar.hcg) {
            com.tencent.mm.plugin.backup.f.b.a(3, new 2(fVar));
            x.i("MicroMsg.RecoverPCServer", "send restore info cmd");
            new com.tencent.mm.plugin.backup.bakoldlogic.c.b(2).ass();
        } else {
            x.i("MicroMsg.RecoverPCServer", "startRecover start directly");
            com.tencent.mm.sdk.f.e.post(new f.1(fVar), "RecoverPCServer_recover");
        }
    }

    public static void asZ() {
        com.tencent.mm.sdk.b.a.sFg.m(new lm());
    }

    private static String mQ(int i) {
        switch (i) {
            case -1:
                return "COMMAND_NOT_SUPPORT";
            case 0:
                return "AUTHORIZE";
            case 1:
                return "BACKUP_INFO";
            case 2:
                return "RESTORE_INFO";
            case 3:
                return "BACKUP_START";
            case 4:
                return "BACKUP_CANCEL";
            case 5:
                return "BACKUP_FINISH";
            case 6:
                return "RESTORE_START";
            case 7:
                return "RESTORE_CANCE";
            case 8:
                return "RESTORE_FINISH";
            case 9:
                return "BACKUP_PAUSE";
            case 10:
                return "RESTORE_PAUSE";
            case 11:
                return "BACKUP_RESUME";
            case 12:
                return "RESTORE_RESUME";
            case 13:
                return "MERGE_PROGRESS";
            case 14:
                return "LOGOFF";
            case 15:
                return "EXIT";
            case 16:
                return "SHOW_BACKUP_RESTORE";
            case 17:
                return "COMMAND_WECHAT_LEAVE";
            default:
                return String.valueOf(i);
        }
    }
}
