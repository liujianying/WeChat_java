package com.tencent.mm.ui;

import android.os.Looper;
import android.provider.Settings.Secure;
import com.tencent.mars.BaseEvent;
import com.tencent.matrix.d.b;
import com.tencent.matrix.mrs.core.MatrixReport;
import com.tencent.mm.aw.e;
import com.tencent.mm.aw.e.1;
import com.tencent.mm.booter.z;
import com.tencent.mm.g.a.cq;
import com.tencent.mm.g.a.d;
import com.tencent.mm.g.a.gs;
import com.tencent.mm.g.a.k;
import com.tencent.mm.g.a.nf;
import com.tencent.mm.g.a.oa;
import com.tencent.mm.g.a.ri;
import com.tencent.mm.g.a.rw;
import com.tencent.mm.g.a.ub;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.au;
import com.tencent.mm.model.br;
import com.tencent.mm.modelmulti.i;
import com.tencent.mm.modelmulti.o;
import com.tencent.mm.platformtools.ai;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.f.f;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.al.a;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.c;
import java.util.Map;

class MMAppMgr$8 implements a {
    final /* synthetic */ MMAppMgr tnp;

    MMAppMgr$8(MMAppMgr mMAppMgr) {
        this.tnp = mMAppMgr;
    }

    public final boolean vD() {
        if (this.tnp.tnm == this.tnp.tnl) {
            x.d("MicroMsg.MMAppMgr", "status not changed, cur=" + this.tnp.tnm);
            return true;
        } else if (au.HM()) {
            return false;
        } else {
            this.tnp.tnm = this.tnp.tnl;
            boolean z = this.tnp.tnm;
            if (MatrixReport.isInstalled()) {
                MatrixReport.with().onForeground(z);
            } else {
                b.e("Matrix.Manager", "onForeground, matrix report is not installed, just return", new Object[0]);
            }
            BaseEvent.onForeground(this.tnp.tnm);
            com.tencent.mm.af.a.bI(this.tnp.tnm);
            k kVar;
            ub ubVar;
            gs gsVar;
            if (this.tnp.tnm) {
                x.w("MicroMsg.MMAppMgr", "[ACTIVATED MODE]");
                au.DF().bB(true);
                if (au.HX() && g.Eg().dpD && !au.Dr()) {
                    z zVar = z.cXH;
                    if (!zVar.hasInit) {
                        Map ckq;
                        zVar.hasInit = true;
                        c fJ = com.tencent.mm.model.c.c.Jx().fJ("100066");
                        if (fJ.isValid()) {
                            ckq = fJ.ckq();
                            zVar.cXT = ai.getInt((String) ckq.get("maxCacheCount"), 20);
                            zVar.cXU = ai.getInt((String) ckq.get("maxCacheHours"), 24);
                        }
                        fJ = com.tencent.mm.model.c.c.Jx().fJ("100058");
                        if (fJ.isValid()) {
                            ckq = fJ.ckq();
                            zVar.cXV = ai.getInt((String) ckq.get("cacheLogCount"), 30);
                            zVar.cXW = ai.getInt((String) ckq.get("maxCacheTime"), 10800);
                        }
                        x.i("MicroMsg.StayTimeReport", "initAbtestChattingArg appMaxCnt:%d, appMaxHour:%d, chattingMaxCnt:%d, chattingMaxSeconds:%d", new Object[]{Integer.valueOf(zVar.cXT), Integer.valueOf(zVar.cXU), Integer.valueOf(zVar.cXV), Integer.valueOf(zVar.cXW)});
                    }
                    com.tencent.mm.modelsimple.c.bN(true);
                    o.PM().id(3);
                    au.DF().a(new i(), 0);
                    com.tencent.mm.blink.b.xi().g(new 1(this));
                    br.IE().c(19, new Object[]{Integer.valueOf(1)});
                    e RQ = e.RQ();
                    x.d("MicroMsg.SpeexUploadCore", "now pause speex uploader");
                    RQ.dRY.lh(true);
                    com.tencent.mm.ak.o.Ph().bB(true);
                    if (f.qBo != null) {
                        f.qBo.bGn();
                    }
                    kVar = new k();
                    kVar.bGu.bGv = true;
                    com.tencent.mm.sdk.b.a.sFg.m(kVar);
                    com.tencent.mm.modelstat.o.iw(4);
                    com.tencent.mm.modelstat.o.iw(3);
                    com.tencent.mm.modelstat.o.bQ(true);
                    ri riVar = new ri();
                    riVar.ccb.ccc = true;
                    riVar.ccb.scene = 1;
                    com.tencent.mm.sdk.b.a.sFg.m(riVar);
                    ubVar = new ub();
                    ubVar.cfW.bIH = 5;
                    com.tencent.mm.sdk.b.a.sFg.m(ubVar);
                    gsVar = new gs();
                    gsVar.bPT.bIH = 2;
                    com.tencent.mm.sdk.b.a.sFg.m(gsVar);
                }
                au.DF().bA(false);
                ad.getContext().getSharedPreferences("notify_prep", 0).edit().putBoolean("longNoopIntervalFlag", false).commit();
                if (this.tnp.tnn.ciq()) {
                    return true;
                }
                this.tnp.tnn.SO();
                return true;
            }
            x.w("MicroMsg.MMAppMgr", "[DEACTIVATED MODE]");
            this.tnp.egx = bi.VG();
            this.tnp.eTr = "desktop";
            kVar = new k();
            kVar.bGu.bGv = false;
            com.tencent.mm.sdk.b.a.sFg.m(kVar);
            au.DF().bB(false);
            if (au.HX()) {
                g.Ek();
                if (g.Eg().dpD) {
                    com.tencent.mm.bh.a.Ut(com.tencent.mm.bh.a.cfI());
                    Looper.myQueue().addIdleHandler(new 1(e.RQ()));
                    nf nfVar = new nf();
                    nfVar.bYj.state = 0;
                    com.tencent.mm.sdk.b.a.sFg.m(nfVar);
                    com.tencent.mm.sdk.b.a.sFg.m(new rw());
                    d dVar = new d();
                    dVar.bGd.bGe = false;
                    com.tencent.mm.sdk.b.a.sFg.m(dVar);
                    oa oaVar = new oa();
                    oaVar.bYW.ahg = false;
                    com.tencent.mm.sdk.b.a.sFg.m(oaVar);
                    com.tencent.mm.ak.o.Ph().bB(false);
                    x.d("MicroMsg.MMAppMgr", "[oneliang][statInputMethod]");
                    au.HU();
                    Object obj = com.tencent.mm.model.c.DT().get(327808, null);
                    if (obj == null) {
                        z = true;
                    } else if (bi.oW(obj.toString())) {
                        z = true;
                    } else {
                        z = System.currentTimeMillis() - bi.WV(obj.toString()) >= 604800000;
                    }
                    x.d("MicroMsg.MMAppMgr", "[oneliang][statInputMethod] needToStat:%s", new Object[]{String.valueOf(z)});
                    if (z) {
                        try {
                            h.mEJ.k(11375, bi.oV(Secure.getString(ad.getContext().getContentResolver(), "default_input_method")));
                            au.HU();
                            com.tencent.mm.model.c.DT().set(327808, Long.valueOf(System.currentTimeMillis()));
                        } catch (Exception e) {
                            x.e("MicroMsg.MMAppMgr", "[oneliang][inputMethodStat]exception:" + e.getMessage());
                        }
                    }
                    cq cqVar = new cq();
                    cqVar.bKc.state = 0;
                    com.tencent.mm.sdk.b.a.sFg.m(cqVar);
                    ubVar = new ub();
                    ubVar.cfW.bIH = 3;
                    com.tencent.mm.sdk.b.a.sFg.m(ubVar);
                    gsVar = new gs();
                    gsVar.bPT.bIH = 1;
                    com.tencent.mm.sdk.b.a.sFg.m(gsVar);
                    com.tencent.mm.modelsimple.c.bN(false);
                    com.tencent.mm.modelstat.o.bQ(false);
                }
            }
            if (!this.tnp.tnn.ciq()) {
                this.tnp.tnn.SO();
            }
            x.i("MicroMsg.MMAppMgr", "before kill tools, tools is running : %b", new Object[]{Boolean.valueOf(bi.bs(ad.getContext(), ad.getPackageName() + ":tools"))});
            if (!bi.bs(ad.getContext(), ad.getPackageName() + ":tools")) {
                return true;
            }
            this.tnp.tnn.J(60000, 60000);
            return true;
        }
    }
}
