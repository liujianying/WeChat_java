package com.tencent.mm.plugin.appbrand.jsapi;

import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.text.TextUtils;
import com.tencent.mm.ab.b;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyTransparentUI;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyTransparentUIProcessTask;
import com.tencent.mm.plugin.appbrand.jsapi.JsApiLaunchApplication.1;
import com.tencent.mm.plugin.appbrand.jsapi.JsApiLaunchApplication.LaunchApplicationTask;
import com.tencent.mm.plugin.appbrand.jsapi.JsApiLaunchApplication.a;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.protocal.c.aoh;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import java.lang.ref.WeakReference;
import java.util.List;

class JsApiLaunchApplication$1$1 implements Runnable {
    final /* synthetic */ int bFq;
    final /* synthetic */ int bFr;
    final /* synthetic */ b dKr;
    final /* synthetic */ 1 fFZ;

    JsApiLaunchApplication$1$1(1 1, int i, int i2, b bVar) {
        this.fFZ = 1;
        this.bFq = i;
        this.bFr = i2;
        this.dKr = bVar;
    }

    public final void run() {
        if (this.bFq == 0 && this.bFr == 0) {
            aoh aoh = (aoh) this.dKr.dIE.dIL;
            switch (aoh.bMH) {
                case 0:
                    a aVar = new a(new 1(this));
                    x.i("MicroMsg.JsApiLaunchApplication", "launchApplication check result(showType : %d, errCode : %d)", new Object[]{Integer.valueOf(aoh.rQQ), Integer.valueOf(aoh.bMH)});
                    if (!bi.oW(this.fFZ.fFT)) {
                        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(this.fFZ.fFT));
                        intent.addFlags(268435456);
                        List B = bi.B(this.fFZ.fCl.getContext(), intent);
                        if (!(B == null || B.isEmpty())) {
                            Object b;
                            if (TextUtils.isEmpty(intent.getPackage()) && B.size() == 1) {
                                b = g.b((ResolveInfo) B.get(0));
                            } else {
                                b = intent.getPackage();
                            }
                            if (!bi.oV(ad.getPackageName()).equals(b)) {
                                ah.A(new 2(this, intent, aoh, aVar));
                                return;
                            }
                        }
                    }
                    final LaunchApplicationTask launchApplicationTask = new LaunchApplicationTask((MMActivity) this.fFZ.fCl.getContext());
                    launchApplicationTask.appId = this.fFZ.fFV;
                    launchApplicationTask.fGe = this.fFZ.fFW;
                    launchApplicationTask.extInfo = this.fFZ.fFX;
                    launchApplicationTask.bJx = this.fFZ.fFU;
                    launchApplicationTask.showType = aoh.rQQ;
                    launchApplicationTask.fFC = new Runnable() {
                        public final void run() {
                            x.i("MicroMsg.JsApiLaunchApplication", "callback task.success:%b", new Object[]{Boolean.valueOf(launchApplicationTask.success)});
                            launchApplicationTask.ahB();
                            if (launchApplicationTask.success) {
                                JsApiLaunchApplication$1$1.this.fFZ.fCl.E(JsApiLaunchApplication$1$1.this.fFZ.doP, JsApiLaunchApplication$1$1.this.fFZ.fFY.f("ok", null));
                            } else {
                                JsApiLaunchApplication$1$1.this.fFZ.fCl.E(JsApiLaunchApplication$1$1.this.fFZ.doP, JsApiLaunchApplication$1$1.this.fFZ.fFY.f("fail:sdk launch fail", null));
                            }
                        }
                    };
                    launchApplicationTask.ahA();
                    if (launchApplicationTask.mContext != null) {
                        AppBrandProxyTransparentUIProcessTask.fDJ.put(launchApplicationTask.fEl, new WeakReference(launchApplicationTask));
                        Intent intent2 = new Intent();
                        intent2.setClass(launchApplicationTask.mContext, AppBrandProxyTransparentUI.class);
                        intent2.putExtra("task_object", launchApplicationTask);
                        intent2.putExtra("task_class_name", launchApplicationTask.getClass().getName());
                        intent2.putExtra("task_id", launchApplicationTask.fEl);
                        intent2.putExtra("orientation", launchApplicationTask.fEj);
                        if (launchApplicationTask.mContext instanceof MMActivity) {
                            launchApplicationTask.ahA();
                            ((MMActivity) launchApplicationTask.mContext).geJ = launchApplicationTask.fEk;
                            ((MMActivity) launchApplicationTask.mContext).startActivityForResult(intent2, launchApplicationTask.hashCode() & 65535);
                            return;
                        }
                        intent2.addFlags(268435456);
                        launchApplicationTask.mContext.startActivity(intent2);
                        return;
                    }
                    return;
                case 2:
                    this.fFZ.fCl.E(this.fFZ.doP, this.fFZ.fFY.f("fail:check fail forbidden scene 2", null));
                    return;
                default:
                    this.fFZ.fCl.E(this.fFZ.doP, this.fFZ.fFY.f("fail:check fail 1", null));
                    return;
            }
        }
        this.fFZ.fCl.E(this.fFZ.doP, this.fFZ.fFY.f("fail:check fail", null));
    }
}
