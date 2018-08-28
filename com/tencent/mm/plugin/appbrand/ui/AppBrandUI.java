package com.tencent.mm.plugin.appbrand.ui;

import android.app.ActivityManager.TaskDescription;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.ActivityInfo;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.WindowManager;
import android.widget.FrameLayout;
import com.tencent.mm.plugin.appbrand.app.b;
import com.tencent.mm.plugin.appbrand.b.d;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfig;
import com.tencent.mm.plugin.appbrand.e;
import com.tencent.mm.plugin.appbrand.g;
import com.tencent.mm.plugin.appbrand.h;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProcessProxyUI;
import com.tencent.mm.plugin.appbrand.launching.AppBrandLaunchProxyUI;
import com.tencent.mm.plugin.appbrand.page.n;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.s$a;
import com.tencent.mm.plugin.appbrand.s.j;
import com.tencent.mm.plugin.appbrand.task.AppBrandRemoteTaskController;
import com.tencent.mm.plugin.appbrand.task.AppBrandRemoteTaskController.c;
import com.tencent.mm.plugin.appbrand.widget.input.a.1;
import com.tencent.mm.plugin.appbrand.widget.input.af;
import com.tencent.mm.plugin.appbrand.widget.input.ah;
import com.tencent.mm.plugin.appbrand.widget.input.l;
import com.tencent.mm.plugin.report.f;
import com.tencent.mm.plugin.report.service.KVCommCrossProcessReceiver;
import com.tencent.mm.plugin.webview.ui.tools.widget.m;
import com.tencent.mm.sdk.platformtools.MultiProcessSharedPreferences;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.widget.a.c$a;

@a(1)
public class AppBrandUI extends MMActivity implements android.support.v4.app.a.a, m {
    private c fdp = new 3(this);
    private Intent gwA = null;
    public boolean gwB = false;
    private Boolean gwC;
    private com.tencent.mm.ui.widget.a.c gwD = null;
    private final com.tencent.mm.plugin.appbrand.widget.input.a gww = new com.tencent.mm.plugin.appbrand.widget.input.a(this);
    h gwx;
    private i gwy;
    private d gwz;

    static /* synthetic */ void a(AppBrandUI appBrandUI, AppBrandRemoteTaskController appBrandRemoteTaskController) {
        if (appBrandUI.gwD == null || !appBrandUI.gwD.isShowing()) {
            c$a aVar = new a(appBrandUI.mController.tml);
            aVar.Gq(j.app_tip);
            aVar.Gr(j.app_brand_account_release_error);
            aVar.mF(false);
            aVar.Gt(j.app_brand_confirm).a(new 4(appBrandUI, appBrandRemoteTaskController));
            appBrandUI.gwD = aVar.anj();
            appBrandUI.gwD.show();
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        x.i("MicroMsg.AppBrandUI", "onCreate");
        SharedPreferences sharedPreferences = MultiProcessSharedPreferences.getSharedPreferences(ad.getContext(), "pref_appbrand_process", 4);
        String str = ad.getProcessName() + ":start_time";
        Editor edit = sharedPreferences.edit();
        if (sharedPreferences.contains(str)) {
            edit.remove(str);
            f.mDy.a(365, 2, 1, false);
        }
        f.mDy.a(365, 4, 1, false);
        edit.putLong(str, System.currentTimeMillis());
        edit.commit();
        x.v("MicroMsg.AppBrandReporter", "onProcessStart");
        KVCommCrossProcessReceiver.brL();
        View frameLayout = new FrameLayout(this.mController.tml);
        frameLayout.setLayoutParams(new LayoutParams(-1, -1));
        setContentView(frameLayout);
        com.tencent.mm.plugin.appbrand.widget.input.a aVar = this.gww;
        if (!(aVar.activity == null || aVar.activity.getWindow() == null || frameLayout.getParent() == null || !(frameLayout.getParent() instanceof ViewGroup))) {
            aVar.gGf = true;
            ViewGroup viewGroup = (ViewGroup) frameLayout.getParent();
            viewGroup.removeView(frameLayout);
            l lVar = new l(aVar.activity, frameLayout);
            viewGroup.addView(lVar, new LayoutParams(-1, -1));
            if (VERSION.SDK_INT < 20) {
                af.a.a(aVar.activity, viewGroup);
                aVar.a(lVar);
            }
            if (com.tencent.mm.plugin.appbrand.widget.input.a.gGe && com.tencent.mm.plugin.appbrand.widget.input.a.cO(aVar.activity)) {
                ah.a(viewGroup, new 1(aVar));
            }
        }
        this.gwx = new h(this, this.fdp, frameLayout);
        this.gwy = new i(this, this.gwx);
        i iVar = this.gwy;
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.SCREEN_OFF");
        try {
            ad.getContext().registerReceiver(iVar.fjD, intentFilter);
        } catch (Exception e) {
            x.e("MicroMsg.BaseAppBrandUIScreenOffReceiver", "register screen off receiver e = " + e);
        }
        this.gwz = new 1(this, this);
        d dVar = this.gwz;
        intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.CLOSE_SYSTEM_DIALOGS");
        try {
            ad.getContext().registerReceiver(dVar.rj, intentFilter);
        } catch (Exception e2) {
            x.e("MicroMsg.BaseAppBrandUIHomePressReceiver", "register screen off receiver e = " + e2);
        }
        com.tencent.mm.plugin.appbrand.config.d b = com.tencent.mm.plugin.appbrand.config.d.b(this);
        x.i("MicroMsg.AppBrandDeviceOrientationHandler", "init");
        synchronized (b) {
            b.mFinished = false;
        }
        this.gwA = getIntent();
    }

    public void onNewIntent(Intent intent) {
        if (intent == null || !intent.getBooleanExtra("key_appbrand_bring_ui_to_front", false)) {
            x.i("MicroMsg.AppBrandUI", "onNewIntent");
            this.gwA = intent;
            this.gwB = true;
        } else if (this.gwx == null || this.gwx.fdn.size() == 0) {
            finish();
        }
    }

    protected final void ahy() {
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onConfigurationChanged(android.content.res.Configuration r11) {
        /*
        r10 = this;
        r6 = 1;
        r7 = 0;
        r0 = "MicroMsg.AppBrandUI";
        r1 = "onConfigurationChanged newConfig: %s";
        r2 = new java.lang.Object[r6];
        r3 = r11.orientation;
        r3 = java.lang.Integer.valueOf(r3);
        r2[r7] = r3;
        com.tencent.mm.sdk.platformtools.x.i(r0, r1, r2);
        super.onConfigurationChanged(r11);
        r0 = r10.gww;
        if (r11 == 0) goto L_0x0032;
    L_0x001c:
        r1 = "MicroMsg.AppBrandFixInputIssuesActivityHelper";
        r2 = "onActivityConfigurationChanged, orientation %d";
        r3 = new java.lang.Object[r6];
        r4 = r11.orientation;
        r4 = java.lang.Integer.valueOf(r4);
        r3[r7] = r4;
        com.tencent.mm.sdk.platformtools.x.i(r1, r2, r3);
        r0.a();
    L_0x0032:
        r0 = r10.gwx;
        r1 = "MicroMsg.AppBrandRuntimeContainer";
        r2 = "AppBrandRuntimeContainer.onConfigurationChanged newConfig [%d]";
        r3 = new java.lang.Object[r6];
        r4 = r11.orientation;
        r4 = java.lang.Integer.valueOf(r4);
        r3[r7] = r4;
        com.tencent.mm.sdk.platformtools.x.d(r1, r2, r3);
        r1 = r0.fdn;
        if (r1 == 0) goto L_0x0063;
    L_0x004b:
        r0 = r0.fdn;
        r1 = r0.iterator();
    L_0x0051:
        r0 = r1.hasNext();
        if (r0 == 0) goto L_0x0063;
    L_0x0057:
        r0 = r1.next();
        r0 = (com.tencent.mm.plugin.appbrand.g) r0;
        r0 = r0.mAppId;
        com.tencent.mm.plugin.appbrand.jsapi.m.e.a(r11, r0);
        goto L_0x0051;
    L_0x0063:
        r8 = com.tencent.mm.plugin.appbrand.config.d.b(r10);
        r0 = "MicroMsg.AppBrandDeviceOrientationHandler";
        r1 = "AppBrandDeviceOrientationHandler.onConfigurationChanged";
        com.tencent.mm.sdk.platformtools.x.i(r0, r1);
        if (r10 == 0) goto L_0x0074;
    L_0x0072:
        if (r11 != 0) goto L_0x0097;
    L_0x0074:
        r1 = "MicroMsg.AppBrandDeviceOrientationHandler";
        r2 = new java.lang.RuntimeException;
        r2.<init>();
        r3 = "onConfigurationChanged activity[isNull ? %b] newConfig[isNull ? %b]";
        r0 = 2;
        r4 = new java.lang.Object[r0];
        if (r10 != 0) goto L_0x00ac;
    L_0x0084:
        r0 = r6;
    L_0x0085:
        r0 = java.lang.Boolean.valueOf(r0);
        r4[r7] = r0;
        if (r11 != 0) goto L_0x00ae;
    L_0x008d:
        r0 = r6;
    L_0x008e:
        r0 = java.lang.Boolean.valueOf(r0);
        r4[r6] = r0;
        com.tencent.mm.sdk.platformtools.x.printErrStackTrace(r1, r2, r3, r4);
    L_0x0097:
        r9 = new java.util.LinkedList;
        r9.<init>();
        monitor-enter(r8);
        r0 = r8.mFinished;	 Catch:{ all -> 0x00bf }
        if (r0 == 0) goto L_0x00b0;
    L_0x00a1:
        r0 = "MicroMsg.AppBrandDeviceOrientationHandler";
        r1 = "onConfigurationChanged Finished = true";
        com.tencent.mm.sdk.platformtools.x.i(r0, r1);	 Catch:{ all -> 0x00bf }
        monitor-exit(r8);	 Catch:{ all -> 0x00bf }
    L_0x00ab:
        return;
    L_0x00ac:
        r0 = r7;
        goto L_0x0085;
    L_0x00ae:
        r0 = r7;
        goto L_0x008e;
    L_0x00b0:
        r0 = r8.fpt;	 Catch:{ all -> 0x00bf }
        if (r0 != 0) goto L_0x00c2;
    L_0x00b4:
        r0 = "MicroMsg.AppBrandDeviceOrientationHandler";
        r1 = "No current request..., dismiss";
        com.tencent.mm.sdk.platformtools.x.d(r0, r1);	 Catch:{ all -> 0x00bf }
        monitor-exit(r8);	 Catch:{ all -> 0x00bf }
        goto L_0x00ab;
    L_0x00bf:
        r0 = move-exception;
        monitor-exit(r8);	 Catch:{ all -> 0x00bf }
        throw r0;
    L_0x00c2:
        r2 = com.tencent.mm.plugin.appbrand.config.d.b(r11);	 Catch:{ all -> 0x00bf }
        r1 = "MicroMsg.AppBrandDeviceOrientationHandler";
        r3 = "AppBrandDeviceOrientationConfig.onConfigurationChanged [%s]";
        r0 = 1;
        r4 = new java.lang.Object[r0];	 Catch:{ all -> 0x00bf }
        r5 = 0;
        if (r2 != 0) goto L_0x014c;
    L_0x00d2:
        r0 = "null";
    L_0x00d5:
        r4[r5] = r0;	 Catch:{ all -> 0x00bf }
        com.tencent.mm.sdk.platformtools.x.i(r1, r3, r4);	 Catch:{ all -> 0x00bf }
        r0 = r8.fpt;	 Catch:{ all -> 0x00bf }
        r0 = r0.fpz;	 Catch:{ all -> 0x00bf }
        if (r0 == 0) goto L_0x00f7;
    L_0x00e0:
        r0 = new com.tencent.mm.plugin.appbrand.config.d$c;	 Catch:{ all -> 0x00bf }
        r1 = r8.fpt;	 Catch:{ all -> 0x00bf }
        r1 = r1.fpz;	 Catch:{ all -> 0x00bf }
        r3 = r8.fpt;	 Catch:{ all -> 0x00bf }
        r3 = r3.fpA;	 Catch:{ all -> 0x00bf }
        if (r2 != r3) goto L_0x0151;
    L_0x00ec:
        r3 = r6;
    L_0x00ed:
        r4 = "CurrentRequest.listener result received";
        r5 = 0;
        r0.<init>(r1, r2, r3, r4);	 Catch:{ all -> 0x00bf }
        r9.add(r0);	 Catch:{ all -> 0x00bf }
    L_0x00f7:
        r0 = 0;
        r8.fpt = r0;	 Catch:{ all -> 0x00bf }
        r0 = r8.fpu;	 Catch:{ all -> 0x00bf }
        if (r0 == 0) goto L_0x011e;
    L_0x00fe:
        r0 = r8.fpu;	 Catch:{ all -> 0x00bf }
        r0 = r0.fpA;	 Catch:{ all -> 0x00bf }
        if (r2 != r0) goto L_0x0153;
    L_0x0104:
        r0 = r8.fpu;	 Catch:{ all -> 0x00bf }
        r0 = r0.fpz;	 Catch:{ all -> 0x00bf }
        if (r0 == 0) goto L_0x011b;
    L_0x010a:
        r0 = new com.tencent.mm.plugin.appbrand.config.d$c;	 Catch:{ all -> 0x00bf }
        r1 = r8.fpu;	 Catch:{ all -> 0x00bf }
        r1 = r1.fpz;	 Catch:{ all -> 0x00bf }
        r3 = 1;
        r4 = "PendingRequest.Listener orientation equal direct";
        r5 = 0;
        r0.<init>(r1, r2, r3, r4);	 Catch:{ all -> 0x00bf }
        r9.add(r0);	 Catch:{ all -> 0x00bf }
    L_0x011b:
        r0 = 0;
        r8.fpu = r0;	 Catch:{ all -> 0x00bf }
    L_0x011e:
        monitor-exit(r8);	 Catch:{ all -> 0x00bf }
        r1 = r9.iterator();
    L_0x0123:
        r0 = r1.hasNext();
        if (r0 == 0) goto L_0x00ab;
    L_0x0129:
        r0 = r1.next();
        r0 = (com.tencent.mm.plugin.appbrand.config.d$c) r0;
        r2 = "MicroMsg.AppBrandDeviceOrientationHandler";
        r3 = "Notify Listener[%s]";
        r4 = new java.lang.Object[r6];
        r5 = r0.name;
        r4[r7] = r5;
        com.tencent.mm.sdk.platformtools.x.i(r2, r3, r4);
        r2 = r0.fpz;
        if (r2 != 0) goto L_0x0183;
    L_0x0142:
        r0 = "MicroMsg.AppBrandDeviceOrientationHandler";
        r2 = "PendingNotify: Listener is null when execute.";
        com.tencent.mm.sdk.platformtools.x.i(r0, r2);
        goto L_0x0123;
    L_0x014c:
        r0 = r2.name();	 Catch:{ all -> 0x00bf }
        goto L_0x00d5;
    L_0x0151:
        r3 = r7;
        goto L_0x00ed;
    L_0x0153:
        if (r10 != 0) goto L_0x0176;
    L_0x0155:
        r0 = "MicroMsg.AppBrandDeviceOrientationHandler";
        r1 = "No Activity when handle pending request";
        com.tencent.mm.sdk.platformtools.x.e(r0, r1);	 Catch:{ all -> 0x00bf }
        r0 = r8.fpu;	 Catch:{ all -> 0x00bf }
        r0 = r0.fpz;	 Catch:{ all -> 0x00bf }
        if (r0 == 0) goto L_0x011e;
    L_0x0164:
        r0 = new com.tencent.mm.plugin.appbrand.config.d$c;	 Catch:{ all -> 0x00bf }
        r1 = r8.fpu;	 Catch:{ all -> 0x00bf }
        r1 = r1.fpz;	 Catch:{ all -> 0x00bf }
        r3 = 0;
        r4 = "PendingRequest.Listener activity == null";
        r5 = 0;
        r0.<init>(r1, r2, r3, r4);	 Catch:{ all -> 0x00bf }
        r9.add(r0);	 Catch:{ all -> 0x00bf }
        goto L_0x011e;
    L_0x0176:
        r0 = r8.fpu;	 Catch:{ all -> 0x00bf }
        r8.fpt = r0;	 Catch:{ all -> 0x00bf }
        r0 = 0;
        r8.fpu = r0;	 Catch:{ all -> 0x00bf }
        r0 = r8.fpt;	 Catch:{ all -> 0x00bf }
        com.tencent.mm.plugin.appbrand.config.d.a(r10, r0);	 Catch:{ all -> 0x00bf }
        goto L_0x011e;
    L_0x0183:
        r2 = r0.fpz;
        r3 = r0.fpA;
        r0 = r0.success;
        r2.a(r3, r0);
        goto L_0x0123;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.appbrand.ui.AppBrandUI.onConfigurationChanged(android.content.res.Configuration):void");
    }

    public void onWindowAttributesChanged(WindowManager.LayoutParams layoutParams) {
        super.onWindowAttributesChanged(layoutParams);
        com.tencent.mm.plugin.appbrand.widget.input.a aVar = this.gww;
        if (layoutParams != null) {
            x.i("MicroMsg.AppBrandFixInputIssuesActivityHelper", "onActivityWindowAttributesChanged, oldFlags %d, newFlags %d", new Object[]{Integer.valueOf(aVar.gGg), Integer.valueOf(layoutParams.flags)});
            if (layoutParams.flags != aVar.gGg) {
                aVar.gGg = layoutParams.flags;
                aVar.a();
            }
        }
    }

    public void startActivityForResult(Intent intent, int i, Bundle bundle) {
        Object obj = 1;
        Object obj2 = (intent == null || (intent.getFlags() & 268435456) <= 0) ? null : 1;
        if (intent == null || !com.tencent.mm.plugin.appbrand.r.c.b(intent.getComponent()).equals(com.tencent.mm.plugin.appbrand.r.c.b(getComponentName()))) {
            obj = null;
        }
        boolean t = AppBrandProcessProxyUI.t(intent);
        boolean v = AppBrandLaunchProxyUI.v(intent);
        boolean x = AppBrandEmbedUI.x(intent);
        if (this.gwx.aaA() != null) {
            String str = this.gwx.aaA().mAppId;
            if (v || x) {
                e.a(str, e.c.fcl);
            } else if ((obj2 == null || obj != null || t) && e.c.fch == e.qn(str)) {
                e.a(str, e.c.fck);
            }
        }
        try {
            this.gwx.aaA().fcz.getReporter().gqU = intent;
        } catch (Exception e) {
        }
        super.startActivityForResult(intent, i, bundle);
    }

    public void onStart() {
        super.onStart();
        x.i("MicroMsg.AppBrandUI", "onStart");
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        x.i("MicroMsg.AppBrandUI", "onWindowFocusChanged %b", new Object[]{Boolean.valueOf(z)});
        if (!z) {
            this.gwB = false;
        }
    }

    public void onResume() {
        AppBrandInitConfig appBrandInitConfig;
        Exception e;
        Object appBrandInitConfig2;
        g gVar;
        g aaA;
        super.onResume();
        x.i("MicroMsg.AppBrandUI", "onResume");
        if (this.gwA != null) {
            setIntent(this.gwA);
            Bundle extras = this.gwA.getExtras();
            if (extras == null) {
                finish();
            } else {
                AppBrandStatObject appBrandStatObject;
                try {
                    extras.setClassLoader(AppBrandInitConfig.class.getClassLoader());
                    appBrandInitConfig2 = (AppBrandInitConfig) extras.getParcelable("key_appbrand_init_config");
                    try {
                        appBrandStatObject = (AppBrandStatObject) extras.getParcelable("key_appbrand_stat_object");
                    } catch (Exception e2) {
                        e = e2;
                        Object gVar2 = appBrandInitConfig2;
                        x.e("MicroMsg.AppBrandUI", "getParcelable: %s", new Object[]{e});
                        appBrandStatObject = null;
                        appBrandInitConfig2 = gVar2;
                        if (appBrandInitConfig2 == null) {
                        }
                        finish();
                        this.gwA = null;
                        aaA = this.gwx.aaA();
                        if (aaA != null) {
                            aaA.onResume();
                        }
                        com.tencent.mm.modelstat.d.b(3, "AppBrandUI_" + this.gwx.aaA().mAppId, hashCode());
                        if (this.gwx.aaA() != null) {
                            return;
                        }
                    }
                } catch (Exception e3) {
                    e = e3;
                    gVar2 = null;
                    x.e("MicroMsg.AppBrandUI", "getParcelable: %s", new Object[]{e});
                    appBrandStatObject = null;
                    appBrandInitConfig2 = gVar2;
                    if (appBrandInitConfig2 == null) {
                    }
                    finish();
                    this.gwA = null;
                    aaA = this.gwx.aaA();
                    if (aaA != null) {
                        aaA.onResume();
                    }
                    com.tencent.mm.modelstat.d.b(3, "AppBrandUI_" + this.gwx.aaA().mAppId, hashCode());
                    if (this.gwx.aaA() != null) {
                    }
                    return;
                }
                if (appBrandInitConfig2 == null && appBrandStatObject != null) {
                    if (!bi.oW(appBrandInitConfig2.fqt)) {
                        com.tencent.mm.plugin.appbrand.config.d.b(this).a(this, com.tencent.mm.plugin.appbrand.config.d.a(appBrandInitConfig2, null), new 2(this));
                    }
                    x.i("MicroMsg.AppBrandUI", "load() config %s , stat %s", new Object[]{appBrandInitConfig2, appBrandStatObject});
                    if (appBrandInitConfig2.aaq()) {
                        b.aaR();
                        m.Bk(1);
                    }
                    this.gwx.a(null, appBrandInitConfig2, appBrandStatObject);
                    initActivityOpenAnimation(getIntent());
                } else if (this.gwx == null || this.gwx.aaA() == null) {
                    finish();
                }
            }
            this.gwA = null;
        }
        aaA = this.gwx.aaA();
        if (aaA != null) {
            aaA.onResume();
        }
        try {
            com.tencent.mm.modelstat.d.b(3, "AppBrandUI_" + this.gwx.aaA().mAppId, hashCode());
        } catch (Throwable th) {
            x.printErrStackTrace("MicroMsg.AppBrandUI", th, "[oneliang]AppBrandUI click flow exception.", new Object[0]);
        }
        if (this.gwx.aaA() != null && this.gwx.aaA().aaq()) {
            m.Bk(1);
        }
    }

    public void onPause() {
        super.onPause();
        x.i("MicroMsg.AppBrandUI", "onPause");
        g aaA = this.gwx.aaA();
        if (aaA != null) {
            aaA.onPause();
        }
        try {
            com.tencent.mm.modelstat.d.b(4, "AppBrandUI_" + this.gwx.aaA().mAppId, hashCode());
        } catch (Throwable th) {
            x.printErrStackTrace("MicroMsg.AppBrandUI", th, "[oneliang]AppBrandUI click flow exception.", new Object[0]);
        }
        if (this.gwx.aaA() != null && this.gwx.aaA().aaq()) {
            m.Bk(2);
        }
    }

    protected void initActivityOpenAnimation(Intent intent) {
        AppBrandStatObject appBrandStatObject;
        try {
            appBrandStatObject = (AppBrandStatObject) (intent == null ? null : intent.getParcelableExtra("key_appbrand_stat_object"));
        } catch (Exception e) {
            appBrandStatObject = null;
        }
        if (appBrandStatObject != null) {
            f.a(this, appBrandStatObject);
        } else if (!AppBrandLaunchProxyUI.v(intent)) {
            super.initActivityOpenAnimation(intent);
        }
    }

    protected void initActivityCloseAnimation() {
        if (this != null) {
            overridePendingTransition(s$a.appbrand_ui_push_close_enter, s$a.appbrand_ui_push_close_exit);
        }
    }

    protected final void anC() {
        super.finish();
    }

    public void finish() {
        if (!isFinishing() && !this.tlP) {
            if (VERSION.SDK_INT >= 21) {
                super.finishAndRemoveTask();
            } else {
                super.finish();
            }
            initActivityCloseAnimation();
        }
    }

    public boolean moveTaskToBack(boolean z) {
        try {
            boolean moveTaskToBack = super.moveTaskToBack(z);
            initActivityCloseAnimation();
            return moveTaskToBack;
        } catch (NullPointerException e) {
            finish();
            return true;
        }
    }

    public void onDestroy() {
        super.onDestroy();
        x.i("MicroMsg.AppBrandUI", "onDestroy");
        this.gwx.cleanup();
        if (this.gwz != null) {
            try {
                ad.getContext().unregisterReceiver(this.gwz.rj);
            } catch (Exception e) {
                x.e("MicroMsg.BaseAppBrandUIHomePressReceiver", "unregister screen off receiver e = " + e);
            }
        }
        if (this.gwy != null) {
            try {
                ad.getContext().unregisterReceiver(this.gwy.fjD);
            } catch (Exception e2) {
                x.e("MicroMsg.BaseAppBrandUIScreenOffReceiver", "unregister screen off receiver e = " + e2);
            }
        }
        com.tencent.mm.plugin.appbrand.config.d b = com.tencent.mm.plugin.appbrand.config.d.b(this);
        x.i("MicroMsg.AppBrandDeviceOrientationHandler", "release");
        synchronized (b) {
            if (b.fpt == null && b.fpu == null) {
                x.i("MicroMsg.AppBrandDeviceOrientationHandler", "Every request is executed well");
                return;
            }
            x.i("MicroMsg.AppBrandDeviceOrientationHandler", "Still has request not executed current[%s] pending[%s]", new Object[]{b.fpt, b.fpu});
            b.fpt = null;
            b.fpu = null;
            b.mFinished = true;
            synchronized (com.tencent.mm.plugin.appbrand.config.d.fpr) {
                int indexOfValue = com.tencent.mm.plugin.appbrand.config.d.fpr.indexOfValue(b);
                if (indexOfValue >= 0) {
                    com.tencent.mm.plugin.appbrand.config.d.fpr.removeAt(indexOfValue);
                }
            }
        }
    }

    public void onBackPressed() {
        x.i("MicroMsg.AppBrandUI", "onBackPressed");
        g aaA = this.gwx.aaA();
        if (aaA == null) {
            return;
        }
        if (aaA.fcB == null) {
            if (aaA.fcD != null) {
                Object obj;
                com.tencent.mm.plugin.appbrand.widget.c.e eVar = aaA.fcD;
                com.tencent.mm.plugin.appbrand.widget.c.h hVar = (com.tencent.mm.plugin.appbrand.widget.c.h) eVar.gFV.peekLast();
                if (hVar == null) {
                    eVar.setVisibility(8);
                    obj = null;
                } else {
                    hVar.onCancel();
                    eVar.b(hVar);
                    obj = 1;
                }
                if (obj != null) {
                    return;
                }
            }
            if (aaA.fcz != null) {
                n nVar = aaA.fcz;
                if (!nVar.getCurrentPage().getCurrentPageView().agV()) {
                    nVar.agJ();
                    return;
                }
                return;
            }
            return;
        }
        aaA.finish();
    }

    protected final void onCreateBeforeSetContentView() {
        super.onCreateBeforeSetContentView();
        supportRequestWindowFeature(10);
        supportRequestWindowFeature(1);
        com.tencent.mm.plugin.appbrand.widget.input.a aVar = this.gww;
        if (aVar.activity != null && aVar.activity.getWindow() != null) {
            aVar.activity.getWindow().setSoftInputMode(16);
        }
    }

    public final boolean noActionBar() {
        return true;
    }

    protected final int getLayoutId() {
        return -1;
    }

    public final boolean needShowIdcError() {
        return false;
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        g aaA = this.gwx.aaA();
        if (aaA != null) {
            com.tencent.mm.plugin.appbrand.a.a(aaA.mAppId, i, strArr, iArr);
        }
    }

    public final boolean anD() {
        boolean z = true;
        if (this.gwC != null) {
            return this.gwC.booleanValue();
        }
        ActivityInfo activityInfo;
        try {
            activityInfo = ad.getContext().getPackageManager().getActivityInfo(getComponentName(), 128);
        } catch (Exception e) {
            x.e("MicroMsg.AppBrandUI", "runInStandaloneTask, resolve info e = %s", new Object[]{e});
            activityInfo = null;
        }
        if (activityInfo == null) {
            return true;
        }
        if (ad.getPackageName().equals(activityInfo.taskAffinity)) {
            z = false;
        }
        Boolean valueOf = Boolean.valueOf(z);
        this.gwC = valueOf;
        return valueOf.booleanValue();
    }

    public void setTaskDescription(TaskDescription taskDescription) {
        if (anD()) {
            super.setTaskDescription(taskDescription);
        }
    }
}
