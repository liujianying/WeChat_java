package com.tencent.mm.plugin.appbrand;

import android.annotation.TargetApi;
import android.app.ActivityManager.TaskDescription;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Looper;
import android.util.Pair;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import com.tencent.mm.plugin.appbrand.appcache.WxaCommLibRuntimeReader;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfig;
import com.tencent.mm.plugin.appbrand.config.AppBrandSysConfig;
import com.tencent.mm.plugin.appbrand.config.d$a;
import com.tencent.mm.plugin.appbrand.debugger.DebuggerShell;
import com.tencent.mm.plugin.appbrand.i.a;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.ipc.MMToClientEvent;
import com.tencent.mm.plugin.appbrand.launching.AppBrandPrepareTask;
import com.tencent.mm.plugin.appbrand.launching.AppBrandTaskUsageRecorder.LaunchCheckParams;
import com.tencent.mm.plugin.appbrand.launching.AppBrandTaskUsageRecorder.UpdateTask;
import com.tencent.mm.plugin.appbrand.launching.ILaunchWxaAppInfoNotify.a.2;
import com.tencent.mm.plugin.appbrand.media.music.AppBrandMusicClientService;
import com.tencent.mm.plugin.appbrand.page.f;
import com.tencent.mm.plugin.appbrand.page.f.1;
import com.tencent.mm.plugin.appbrand.page.k;
import com.tencent.mm.plugin.appbrand.page.n;
import com.tencent.mm.plugin.appbrand.r.b;
import com.tencent.mm.plugin.appbrand.report.AppBrandIDKeyBatchReport;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.report.a.m;
import com.tencent.mm.plugin.appbrand.task.AppBrandRemoteTaskController;
import com.tencent.mm.plugin.appbrand.task.AppBrandRemoteTaskController.c;
import com.tencent.mm.plugin.appbrand.task.d;
import com.tencent.mm.plugin.appbrand.ui.AppBrandEmbedUI;
import com.tencent.mm.plugin.appbrand.ui.banner.AppBrandStickyBannerLogic;
import com.tencent.mm.plugin.appbrand.ui.h;
import com.tencent.mm.plugin.appbrand.ui.j;
import com.tencent.mm.plugin.appbrand.ui.l;
import com.tencent.mm.plugin.appbrand.widget.c.e;
import com.tencent.mm.pluginsdk.model.u;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.aw;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.LinkedBlockingDeque;
import org.json.JSONObject;

public final class g {
    public volatile boolean dti;
    public FrameLayout fcA;
    public l fcB;
    h fcC;
    public e fcD;
    public AppBrandStatObject fcE;
    AppBrandRemoteTaskController fcF;
    private com.tencent.mm.plugin.appbrand.page.g fcG;
    private f fcH;
    private b fcI;
    public i fcJ;
    public k fcK;
    public volatile com.tencent.mm.plugin.appbrand.b.b fcL;
    public a fcM;
    private int fcN = 0;
    private boolean fcO;
    boolean fcP;
    boolean fcQ;
    public boolean fcR;
    boolean fcS;
    private int fcT;
    boolean fcU;
    boolean fcV;
    boolean fcW;
    boolean fcX;
    boolean fcY;
    m fcZ;
    public MMActivity fcq;
    public q fcr;
    g fcs;
    public volatile AppBrandInitConfig fct;
    public volatile AppBrandSysConfig fcu;
    public volatile com.tencent.mm.plugin.appbrand.config.a fcv;
    public volatile com.tencent.mm.plugin.appbrand.jsapi.file.a fcw;
    final Deque<Runnable> fcx = new LinkedBlockingDeque();
    public l fcy;
    public n fcz;
    private AppBrandRemoteTaskController.b fda = new 8(this);
    private AppBrandMainProcessService.a fdb = new 9(this);
    Runnable fdc = new 10(this);
    public volatile String mAppId;
    public boolean mFinished;
    Handler mHandler;

    static /* synthetic */ void c(g gVar) {
        while (!gVar.fcx.isEmpty()) {
            gVar.fcq.runOnUiThread((Runnable) gVar.fcx.removeFirst());
        }
    }

    public g(MMActivity mMActivity, q qVar) {
        this.fcq = mMActivity;
        this.fcr = qVar;
        this.mHandler = new Handler();
        this.fcA = new com.tencent.mm.plugin.appbrand.widget.e(mMActivity);
        this.fcA.setLayoutParams(new LayoutParams(-1, -1));
        this.fcF = new AppBrandRemoteTaskController();
        AppBrandRemoteTaskController appBrandRemoteTaskController = this.fcF;
        c aaC = qVar.aaC();
        AppBrandRemoteTaskController.b bVar = this.fda;
        appBrandRemoteTaskController.fex = mMActivity.getClass().getName();
        if (mMActivity instanceof AppBrandEmbedUI) {
            appBrandRemoteTaskController.gtr = ((AppBrandEmbedUI) mMActivity).gul;
        }
        appBrandRemoteTaskController.fdp = aaC;
        appBrandRemoteTaskController.fda = bVar;
        this.fcG = new com.tencent.mm.plugin.appbrand.page.g();
        this.fcH = new f();
        this.fcI = new b();
        this.fcJ = new i();
        this.fcK = new k();
    }

    final void a(AppBrandInitConfig appBrandInitConfig, AppBrandStatObject appBrandStatObject) {
        if (appBrandInitConfig == null || appBrandStatObject == null) {
            x.i("MicroMsg.AppBrandRuntime", "null current config, ignored");
            return;
        }
        this.fct = appBrandInitConfig;
        this.fcE = appBrandStatObject;
        this.mAppId = appBrandInitConfig.appId;
        x.i("MicroMsg.AppBrandRuntime", "init %s, isGame %b, scene %d", new Object[]{this.mAppId, Boolean.valueOf(appBrandInitConfig.aaq()), Integer.valueOf(aan())});
        this.fcL = new com.tencent.mm.plugin.appbrand.b.b(this);
        com.tencent.mm.plugin.appbrand.b.b bVar = this.fcL;
        com.tencent.mm.ipcinvoker.g.fD("com.tencent.mm");
        ad.getContext().registerComponentCallbacks(bVar.fjl);
        bVar.fjj.start();
        this.fcL.a(new 1(this));
        if (!this.mFinished) {
            ILaunchWxaAppInfoNotify$a$1 iLaunchWxaAppInfoNotify$a$1 = new ILaunchWxaAppInfoNotify$a$1(this);
            MMToClientEvent.a(iLaunchWxaAppInfoNotify$a$1);
            this.fcL.a(new 2(iLaunchWxaAppInfoNotify$a$1));
        }
        x.i("MicroMsg.AppBrandRuntime", "init %s, config %s, stat %s", new Object[]{this.mAppId, this.fct, this.fcE});
        this.dti = false;
        this.fcO = false;
        this.mFinished = false;
        this.fcP = false;
        this.fcQ = false;
        this.fcR = false;
        this.fcU = false;
        this.fcV = false;
        this.fcX = false;
        this.fcY = false;
        this.fcW = false;
        this.fcT = 0;
        u.v("weapp_id", this.fct.appId);
        u.v("weapp_name", this.fct.bKC);
        u.v("use_private_classloader", Boolean.valueOf(false));
        a.b(this);
        k.qr(this.mAppId);
        this.fcJ.o(0, System.currentTimeMillis() - appBrandInitConfig.startTime);
        jy(1);
        com.tencent.mm.plugin.appbrand.performance.a.a(this.mAppId, "ActivityCreate", this.fct.startTime, System.currentTimeMillis());
    }

    final void aak() {
        this.fcZ = new m(this);
        this.fcZ.gsj = bi.VF();
        if (this.fcB != null) {
            aam();
        }
        String str = this.fct.iconUrl;
        String str2 = this.fct.bKC;
        l b = l.a.b(this.fcq, this);
        b.bL(str, str2);
        if (aan() == 1023) {
            b.ann();
        }
        this.fcA.addView(b.getView(), -1, -1);
        b.getView().setClickable(true);
        this.fcB = b;
        if (aaq()) {
            this.fcV = true;
        } else {
            final long currentTimeMillis = System.currentTimeMillis();
            d.a(new d.a() {
                public final void onReady() {
                    g.this.fcV = true;
                    g.this.fcJ.o(2, System.currentTimeMillis() - currentTimeMillis);
                    com.tencent.mm.plugin.appbrand.performance.a.a(g.this.mAppId, "X5Prepare", currentTimeMillis, System.currentTimeMillis());
                    g.this.aat();
                }
            }, false);
        }
        aas();
        AppBrandMainProcessService.a(new AppBrandMainProcessPrepareTask(new 16(this)));
        x.i("MicroMsg.AppBrandRuntime", "appOnCreate: %s, %s", new Object[]{this.fct.bKC, this.fct.appId});
        AppBrandMainProcessService.a(this.fdb);
        g pY = a.pY(this.mAppId);
        if (!(pY == null || this == pY)) {
            pY.finish();
        }
        AppBrandRemoteTaskController appBrandRemoteTaskController = this.fcF;
        String str3 = this.mAppId;
        appBrandRemoteTaskController.gts = AppBrandRemoteTaskController.a.gtH;
        appBrandRemoteTaskController.mAppId = str3;
        AppBrandMainProcessService.a(appBrandRemoteTaskController);
        this.fcF.aM(this.mAppId, this.fct.fig);
        this.fcL.fjj.jG(3);
        MMToClientEvent.tg(this.mAppId);
        e.qm(this.mAppId);
        e.qg(this.mAppId);
        e.a(this.mAppId, e.a.fbZ);
        AppBrandStickyBannerLogic.a.ac(this.mAppId, this.fct.fqy);
        b bVar = this.fcI;
        bVar.appId = this.mAppId;
        x.i("MicroMsg.AppBrandUserCaptureScreenMonitor", "init");
        aw.a(ad.getContext(), bVar.gBu);
        com.tencent.mm.plugin.appbrand.media.a.a.onCreate(this.mAppId);
        com.tencent.mm.plugin.appbrand.media.record.c.onCreate();
        aat();
        this.mHandler.postDelayed(this.fdc, 10000);
    }

    final void a(AppBrandStatObject appBrandStatObject) {
        if (appBrandStatObject == null) {
            x.e("MicroMsg.AppBrandRuntime", "statObject is null!");
            return;
        }
        String str = this.mAppId;
        int aan = aan();
        AppBrandIDKeyBatchReport.amv().gqy = 1;
        AppBrandIDKeyBatchReport.amv().gqA = str;
        AppBrandIDKeyBatchReport.amv().gqB = aan;
        AppBrandMainProcessService.a(AppBrandIDKeyBatchReport.amv());
        j.g(this).fdE = this.fct.fdE;
        this.fcE = appBrandStatObject;
        if (this.fcz != null) {
            this.fcz.getReporter().aea();
        }
        x.i("MicroMsg.AppBrandRuntime", "updateStat %s, scene %d", new Object[]{this.mAppId, Integer.valueOf(aan())});
    }

    public final g aal() {
        return this.fcr.d(this);
    }

    public final void a(com.tencent.mm.plugin.appbrand.widget.c.h hVar) {
        if (ah.isMainThread()) {
            this.fcq.YC();
            if (hVar != null && !this.mFinished && this.fcD != null) {
                e eVar = this.fcD;
                com.tencent.mm.plugin.appbrand.widget.c.g gVar = eVar.gFU;
                int i = (gVar.gGc == null || !gVar.gGc.isRunning()) ? 0 : 1;
                if (i != 0) {
                    gVar = eVar.gFU;
                    if (gVar.gGc != null) {
                        gVar.gGc.cancel();
                    }
                }
                View contentView = hVar.getContentView();
                if (contentView.getParent() != eVar) {
                    e.bT(contentView);
                    eVar.addView(contentView, new FrameLayout.LayoutParams(-2, -2, 17));
                    if (eVar.gFY != hVar) {
                        contentView.clearAnimation();
                        contentView.startAnimation(AnimationUtils.loadAnimation(eVar.getContext(), s$a.appbrand_dialog_enter));
                    }
                    eVar.gFY = hVar;
                }
                contentView.setOnClickListener(eVar.mOnClickListener);
                eVar.gFV.add(hVar);
                hVar.a(eVar);
                eVar.setVisibility(0);
                eVar.gFU.c(Color.argb(127, 0, 0, 0), null);
                return;
            }
            return;
        }
        ah.A(new 12(this, hVar));
    }

    final void aam() {
        if (this.fcB == null) {
            x.e("MicroMsg.AppBrandRuntime", "hideSplash, splash view null");
            return;
        }
        com.tencent.mm.plugin.appbrand.page.l currentPage = this.fcz.getCurrentPage();
        if (currentPage == null) {
            x.e("MicroMsg.AppBrandRuntime", "hideSplash, null currentPage, appId %s", new Object[]{this.mAppId});
        } else {
            this.fcB.a(currentPage.getPageConfig());
        }
        this.fcB.anm();
        this.fcB = null;
    }

    public final int aan() {
        if (this.fcE == null) {
            return 0;
        }
        return this.fcE.scene;
    }

    public final String aao() {
        if (this.fct == null) {
            return "";
        }
        if (!bi.oW(this.fct.fqx)) {
            return this.fct.fqx;
        }
        if (this.fcv == null) {
            return "";
        }
        return this.fcv.adU();
    }

    public final boolean aap() {
        return this.fct == null || this.fct.fqr;
    }

    public final boolean aaq() {
        return this.fct == null || this.fct.aaq();
    }

    public final boolean aar() {
        if (this.fcy instanceof com.tencent.mm.plugin.appbrand.debugger.n) {
            return true;
        }
        if (this.fct != null && this.fct.fqw && (this.fcE.scene == 1011 || this.fcE.scene == 1012 || this.fcE.scene == 1013)) {
            return true;
        }
        return false;
    }

    final void aas() {
        if (d.ana() || aaq()) {
            long currentTimeMillis = System.currentTimeMillis();
            AppBrandPrepareTask appBrandPrepareTask = new AppBrandPrepareTask(this.fcq, this);
            appBrandPrepareTask.geT = new 15(this, currentTimeMillis);
            appBrandPrepareTask.akB();
            return;
        }
        d.a(new 14(this), false);
    }

    final void a(d$a d_a) {
        if (this.mFinished) {
            x.i("MicroMsg.AppBrandRuntime", "mFinished is true return,mAppId:%s", new Object[]{this.mAppId});
            return;
        }
        x.i("MicroMsg.AppBrandRuntime", "AppBrandRuntime.mayRequestOrientation %s,mAppId:%s", new Object[]{this.fcv.adT(), this.mAppId});
        com.tencent.mm.plugin.appbrand.config.d.b(this.fcq).a(this.fcq, com.tencent.mm.plugin.appbrand.config.d.a(this.fct, this.fcv), d_a);
    }

    final void aat() {
        x.i("MicroMsg.AppBrandRuntime", "initRuntime, mFinished: %b, ResourceReady: %b, WebViewReady: %b,isOrientationReady: %b, MainProcessReady: %b", new Object[]{Boolean.valueOf(this.mFinished), Boolean.valueOf(this.fcU), Boolean.valueOf(this.fcV), Boolean.valueOf(this.fcW), Boolean.valueOf(this.fcX)});
        if (this.mFinished || !this.fcU || !this.fcV || !this.fcW || !this.fcX) {
            return;
        }
        if (this.dti) {
            x.e("MicroMsg.AppBrandRuntime", "initRuntime, mInitialized TRUE !!!  go check callee");
            return;
        }
        18 18 = new 18(this);
        int i = this.fcN + 1;
        this.fcN = i;
        if (i > 1) {
            18.run();
        } else {
            Looper.myQueue().addIdleHandler(new 19(this, 18));
        }
    }

    public final void aau() {
        this.fcT++;
    }

    public final void aav() {
        if (this.fcT != 0) {
            this.fcT--;
        }
    }

    public final void onPause() {
        if (this.dti) {
            x.i("MicroMsg.AppBrandRuntime", "onPause: %s", new Object[]{this.mAppId});
            this.fcO = true;
            this.fcL.fjj.jG(1);
            f fVar = this.fcH;
            Map hashMap = new HashMap(1);
            Object obj = "hide";
            switch (1.fjK[e.qn(this.mAppId).ordinal()]) {
                case 1:
                    obj = "close";
                    break;
                case 2:
                    obj = "back";
                    break;
                case 3:
                case 4:
                case 5:
                    obj = "hide";
                    break;
                case 6:
                    obj = "hang";
                    break;
                case 7:
                    obj = "launchMiniProgram";
                    break;
            }
            hashMap.put("mode", obj);
            JSONObject jSONObject = new JSONObject(hashMap);
            Pair h = com.tencent.mm.plugin.appbrand.report.a.e.h(this.fcz.getCurrentPage().getCurrentPageView());
            String str = (String) h.second;
            try {
                jSONObject.put("targetAction", ((Integer) h.first).intValue());
                jSONObject.put("targetPagePath", str);
            } catch (Exception e) {
                x.e("MicroMsg.AppBrandPageVisitStatisticsHelper", "fillEventOnAppEnterBackground ex = %s", new Object[]{e});
            }
            fVar.mData = jSONObject.toString();
            fVar.a(this.fcy).ahM();
            this.fcz.agK();
            e.qi(this.mAppId);
            e.a(this.mAppId, e.a.fcb);
            x.i("MicroMsg.AppBrandUserCaptureScreenMonitor", "onPause");
            aw.a(ad.getContext(), null);
        }
    }

    public final void onResume() {
        if (this.dti) {
            x.i("MicroMsg.AppBrandRuntime", "onResume: %s", new Object[]{this.mAppId});
            if (this.mFinished || this.fcP) {
                reload();
                return;
            }
            String aao;
            this.fcO = false;
            e.qm(this.mAppId);
            e.qj(this.mAppId);
            e.a(this.mAppId, e.a.fca);
            AppBrandRemoteTaskController appBrandRemoteTaskController = this.fcF;
            String str = this.mAppId;
            int i = this.fct.fig;
            appBrandRemoteTaskController.gts = AppBrandRemoteTaskController.a.gtA;
            appBrandRemoteTaskController.mAppId = str;
            appBrandRemoteTaskController.gfg = i;
            AppBrandMainProcessService.a(appBrandRemoteTaskController);
            if (this.fcQ) {
                this.fcz.getReporter().gqV = true;
            }
            this.fcz.agL();
            this.fcL.fjj.jG(3);
            this.fcy.onResume();
            com.tencent.mm.plugin.appbrand.page.g gVar = this.fcG;
            boolean z = this.fcQ;
            Map hashMap = new HashMap();
            AppBrandStatObject appBrandStatObject = this.fcE;
            if (appBrandStatObject != null) {
                hashMap.put("scene", Integer.valueOf(appBrandStatObject.scene));
            }
            JSONObject aef = this.fct.fqA.aef();
            if (aef != null) {
                hashMap.put("referrerInfo", aef);
            }
            aef = this.fct.aec();
            if (aef != null) {
                hashMap.put("shareInfo", aef);
            }
            hashMap.put("relaunch", Boolean.valueOf(z));
            hashMap.put("reLaunch", Boolean.valueOf(z));
            if (z) {
                aao = aao();
                hashMap.put("path", com.tencent.mm.plugin.appbrand.q.l.vP(aao));
                hashMap.put("query", com.tencent.mm.plugin.appbrand.q.l.vQ(aao));
            } else {
                aao = this.fcz.getCurrentUrl();
            }
            x.i("MicroMsg.AppBrandOnAppEnterForegroundEvent", "path: %s, query: %s, relaunch: %s, url: %s", new Object[]{hashMap.get("path"), hashMap.get("query"), hashMap.get("relaunch"), aao});
            com.tencent.mm.plugin.appbrand.r.c.m(hashMap);
            JSONObject jSONObject = new JSONObject(hashMap);
            if (z) {
                com.tencent.mm.plugin.appbrand.report.a.e.a(this, jSONObject);
            } else {
                try {
                    com.tencent.mm.plugin.appbrand.report.a.e.b(this, jSONObject);
                    jSONObject.put("referpagepath", this.fcz.getReporter().gqZ.amJ().grt);
                    jSONObject.put("clickTimestamp", this.fcz.getCurrentPage().getCurrentPageView().gnC.grg);
                } catch (Exception e) {
                    x.e("MicroMsg.AppBrandPageVisitStatisticsHelper", "fillEventOnAppEnterForeground ex = %s", new Object[]{e});
                }
            }
            gVar.mData = jSONObject.toString();
            gVar.a(this.fcy).ahM();
            if (this.fcQ) {
                this.fcz.V(aao(), true);
            }
            AppBrandInitConfig appBrandInitConfig = this.fct;
            if (!bi.oW(appBrandInitConfig.appId)) {
                AppBrandSysConfig qa = a.qa(appBrandInitConfig.appId);
                if (qa != null) {
                    AppBrandStatObject qb = a.qb(appBrandInitConfig.appId);
                    if (qb != null) {
                        x.i("MicroMsg.AppBrandTaskUsageRecorder", "updateUsage, appId %s, type %d", new Object[]{appBrandInitConfig.appId, Integer.valueOf(appBrandInitConfig.fig)});
                        AppBrandMainProcessService.a(new UpdateTask(new LaunchCheckParams(appBrandInitConfig, qb, qa.frm.fii, WxaCommLibRuntimeReader.abP().fii, j.qq(appBrandInitConfig.appId).fdE)));
                    }
                }
            }
            b bVar = this.fcI;
            x.i("MicroMsg.AppBrandUserCaptureScreenMonitor", "onResume");
            aw.a(ad.getContext(), bVar.gBu);
            a(this.fcu);
            d.vv(this.mAppId);
            this.fcP = false;
            this.fcQ = false;
            a(new 3(this));
        }
    }

    public final void cleanup() {
        if (!this.mFinished) {
            this.mFinished = true;
            x.i("MicroMsg.AppBrandRuntime", "onDestroy: %s", new Object[]{this.mAppId});
            String str = this.mAppId;
            if (DebuggerShell.aeq()) {
                com.tencent.mm.plugin.appbrand.r.c.Em().H(new 4(this, str));
            }
            AppBrandRemoteTaskController appBrandRemoteTaskController = this.fcF;
            String str2 = this.mAppId;
            appBrandRemoteTaskController.gts = AppBrandRemoteTaskController.a.gtB;
            appBrandRemoteTaskController.mAppId = str2;
            AppBrandMainProcessService.a(appBrandRemoteTaskController);
            AppBrandMainProcessService.b(this.fdb);
            MMToClientEvent.th(this.mAppId);
            e.qh(this.mAppId);
            e.a(this.mAppId, e.a.fcd);
            com.tencent.mm.plugin.appbrand.jsapi.l.tl(this.mAppId);
            AppBrandStickyBannerLogic.a.vK(this.mAppId);
            a.qd(this.mAppId);
            AppBrandMusicClientService appBrandMusicClientService = AppBrandMusicClientService.ghS;
            appBrandMusicClientService.ghR.clear();
            appBrandMusicClientService.ghT = "";
            com.tencent.mm.plugin.appbrand.media.a.a.Pa(this.mAppId);
            com.tencent.mm.plugin.appbrand.media.record.c.onDestroy();
            com.tencent.mm.plugin.appbrand.permission.b.vm(this.mAppId);
            this.fcq.YC();
            com.tencent.mm.plugin.appbrand.b.b bVar = this.fcL;
            com.tencent.mm.plugin.appbrand.b.c cVar = bVar.fjj;
            cVar.fjt.set(true);
            cVar.quit();
            cVar.b(com.tencent.mm.plugin.appbrand.b.a.fjh);
            ad.getContext().unregisterComponentCallbacks(bVar.fjl);
            synchronized (bVar.fjk) {
                bVar.fjk.clear();
            }
            if (this.fcD != null) {
                this.fcA.removeView(this.fcD);
            }
            com.tencent.mm.plugin.appbrand.jsapi.file.a aVar = this.fcw;
            if (aVar != null) {
                aVar.release();
                this.fcw = null;
            }
            if (this.fcZ != null) {
                m mVar = this.fcZ;
                try {
                    k qu = k.qu(mVar.fdD.mAppId);
                    mVar.grI = com.tencent.mm.plugin.appbrand.report.a.cH(ad.getContext());
                    mVar.appId = mVar.fdD.mAppId;
                    mVar.cbu = mVar.fdD.fcu == null ? 0 : mVar.fdD.fcu.frm.fii;
                    mVar.bGF = mVar.fdD.fct.fig + 1;
                    mVar.scene = mVar.fdD.aan();
                    mVar.gsl = mVar.gsk ? 1 : 0;
                    mVar.gsm = qu.fdI.get() ? 1 : 0;
                    mVar.gsn = bi.VF() - mVar.gsj;
                    mVar.gso = bi.VF();
                    x.i("MicroMsg.AppBrand.Report.kv_14576", "report|" + mVar.toString());
                    com.tencent.mm.plugin.report.f.mDy.h(14576, new Object[]{mVar.grI, mVar.appId, Integer.valueOf(mVar.cbu), Integer.valueOf(mVar.bGF), Integer.valueOf(mVar.scene), mVar.bJK, Integer.valueOf(mVar.gsl), Integer.valueOf(mVar.gsm), Long.valueOf(mVar.gsn), Long.valueOf(mVar.gso)});
                } catch (Exception e) {
                    x.e("MicroMsg.AppBrand.Report.kv_14576", "report exp %s", new Object[]{e});
                }
            }
            this.fcZ = null;
            e.ql(this.mAppId);
            if (this.fcy != null) {
                this.fcy.cleanup();
            }
            if (this.fcz != null) {
                this.fcz.cleanup();
                this.fcA.removeView(this.fcz);
            }
            a.a(this);
            k.remove(this.mAppId);
            this.fcx.clear();
            this.fct.startTime = System.currentTimeMillis();
        }
    }

    public final void finish() {
        this.fcq.runOnUiThread(new 5(this));
    }

    final void reload() {
        this.fcy.fEH = true;
        cleanup();
        a(this.fct, this.fcE);
        aak();
        x.i("MicroMsg.AppBrandRuntime", "reload: %s", new Object[]{this.mAppId});
    }

    public final void close() {
        if (this.fcr.aaB() != 1) {
            finish();
        } else if (aap()) {
            this.fcr.a(null);
        } else {
            this.fcr.close();
        }
    }

    @TargetApi(21)
    final void a(final AppBrandSysConfig appBrandSysConfig) {
        if (VERSION.SDK_INT >= 21 && !aap()) {
            final int aO = j.aO(this.fcv.foN.fpj, -16777216);
            this.fcq.setTaskDescription(new TaskDescription(appBrandSysConfig.bKC, null, aO));
            com.tencent.mm.modelappbrand.b.b.Ka().a(new com.tencent.mm.modelappbrand.b.b.b() {
                public final void n(Bitmap bitmap) {
                    g.this.fcq.setTaskDescription(new TaskDescription(appBrandSysConfig.bKC, bitmap, aO));
                }
            }, appBrandSysConfig.fqJ, null);
        }
    }

    public final boolean aaw() {
        if (!this.fcO || this.fcT != 0) {
            return false;
        }
        cleanup();
        return true;
    }

    final void jy(int i) {
        int i2 = 369;
        if (aaq()) {
            i2 = 777;
        }
        com.tencent.mm.plugin.report.service.h.mEJ.a((long) i2, (long) i, 1, false);
    }
}
