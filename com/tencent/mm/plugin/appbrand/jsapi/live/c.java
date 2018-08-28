package com.tencent.mm.plugin.appbrand.jsapi.live;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import com.tencent.mm.plugin.appbrand.jsapi.base.a;
import com.tencent.mm.plugin.appbrand.jsapi.coverview.CoverViewContainer;
import com.tencent.mm.plugin.appbrand.jsapi.h;
import com.tencent.mm.plugin.appbrand.page.p;
import com.tencent.mm.plugin.appbrand.page.p.d;
import com.tencent.mm.plugin.appbrand.page.p.e;
import com.tencent.mm.plugin.appbrand.page.p.f;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.rtmp.TXLiveBase;
import org.json.JSONObject;

public final class c extends a {
    private static final int CTRL_INDEX = 360;
    public static final String NAME = "insertLivePusher";
    private int fRM;

    private static final class b extends h {
        private static final int CTRL_INDEX = 368;
        private static final String NAME = "onLivePusherEvent";

        private b() {
        }

        /* synthetic */ b(byte b) {
            this();
        }
    }

    public final void a(p pVar, JSONObject jSONObject, int i) {
        k.aje();
        if (pVar.mContext instanceof Activity) {
            this.fRM = 0;
            a((Activity) pVar.mContext, pVar, jSONObject, i);
            return;
        }
        x.w("MicroMsg.JsApiInsertLivePusher", "invokeAfterRequestPermission pageContext not activity");
        pVar.E(i, f("fail", null));
        com.tencent.mm.plugin.appbrand.a.pZ(pVar.mAppId);
    }

    protected final View a(p pVar, JSONObject jSONObject) {
        return new CoverViewContainer(pVar.mContext, new AppBrandLivePusherView(pVar.mContext));
    }

    protected final int k(JSONObject jSONObject) {
        return jSONObject.getInt("livePusherId");
    }

    protected final void a(p pVar, int i, View view, JSONObject jSONObject) {
        x.i("MicroMsg.JsApiInsertLivePusher", "onInsertView livePusherId=%d", new Object[]{Integer.valueOf(i)});
        if (view instanceof CoverViewContainer) {
            TXLiveBase.setAppVersion(String.format("weixin_%s", new Object[]{pVar.mAppId}));
            final AppBrandLivePusherView appBrandLivePusherView = (AppBrandLivePusherView) ((CoverViewContainer) view).A(AppBrandLivePusherView.class);
            if (appBrandLivePusherView == null) {
                x.e("MicroMsg.JsApiInsertLivePusher", "pusherView null");
                return;
            }
            j jVar;
            final f 1 = new 1(this, appBrandLivePusherView);
            final d anonymousClass2 = new d() {
                public final void agK() {
                    j cQ = appBrandLivePusherView.fRF.cQ(false);
                    x.i("MicroMsg.AppBrandLivePusherView", "onBackground code:%d info:%s", new Object[]{Integer.valueOf(cQ.errorCode), cQ.fRT});
                }
            };
            final 3 3 = new 3(this, appBrandLivePusherView, pVar);
            final p pVar2 = pVar;
            e anonymousClass4 = new e() {
                public final void onDestroy() {
                    appBrandLivePusherView.ua();
                    pVar2.b(1);
                    pVar2.b(anonymousClass2);
                    pVar2.b((e) this);
                    com.tencent.mm.plugin.appbrand.e.b(pVar2.mAppId, 3);
                }
            };
            pVar.a(1);
            pVar.a(anonymousClass2);
            pVar.a(anonymousClass4);
            com.tencent.mm.plugin.appbrand.e.a(pVar.mAppId, 3);
            appBrandLivePusherView.setOnPushEventListener(new 5(this, i, pVar));
            Bundle bundle = new Bundle();
            bundle.putString("pushUrl", jSONObject.optString("pushUrl"));
            bundle.putInt("mode", jSONObject.optInt("mode", 0));
            bundle.putBoolean("autopush", jSONObject.optBoolean("autopush", false));
            bundle.putBoolean("muted", jSONObject.optBoolean("muted", false));
            bundle.putBoolean("enableCamera", jSONObject.optBoolean("enableCamera", true));
            bundle.putInt("focusMode", jSONObject.optInt("focusMode", 0));
            bundle.putString("orientation", jSONObject.optString("orientation"));
            bundle.putInt("beauty", jSONObject.optInt("beauty", 0));
            bundle.putInt("whiteness", jSONObject.optInt("whiteness", 0));
            bundle.putString("audioQuality", jSONObject.optString("audioQuality", "high"));
            bundle.putInt("aspect", jSONObject.optInt("aspect", 0));
            bundle.putInt("minBitrate", jSONObject.optInt("minBitrate", 0));
            bundle.putInt("maxBitrate", jSONObject.optInt("maxBitrate", 0));
            bundle.putBoolean("backgroundMute", jSONObject.optBoolean("backgroundMute", false));
            bundle.putBoolean("zoom", jSONObject.optBoolean("zoom", true));
            bundle.putBoolean("needEvent", jSONObject.optBoolean("needEvent", false));
            bundle.putBoolean("debug", jSONObject.optBoolean("debug", false));
            x.i("MicroMsg.JsApiInsertLivePusher", "convertParams pushUrl:%s", new Object[]{jSONObject.optString("pushUrl")});
            m mVar = appBrandLivePusherView.fRF;
            if (appBrandLivePusherView == null) {
                jVar = new j(-1, "invalid params");
            } else {
                m.d("InitLivePusher", bundle);
                mVar.fRV = appBrandLivePusherView;
                mVar.fRV.disableLog(false);
                mVar.fSm = bundle.getString("pushUrl", "");
                mVar.c(bundle, true);
                mVar.fSq = bundle.getBoolean("autopush", mVar.fSq);
                if (!(!mVar.fSq || mVar.fSm == null || mVar.fSm.isEmpty() || mVar.fSk.isPushing())) {
                    x.i("TXLivePusherJSAdapter", "initLivePusher: startPusher");
                    mVar.fRV.setVisibility(0);
                    if (mVar.fSv) {
                        mVar.fSk.startCameraPreview(mVar.fRV);
                    }
                    mVar.fSk.startPusher(mVar.fSm);
                }
                mVar.dni = true;
                jVar = new j();
            }
            x.i("MicroMsg.AppBrandLivePusherView", "onInsert code:%d info:%s", new Object[]{Integer.valueOf(jVar.errorCode), jVar.fRT});
            a.a(jSONObject.optString("backgroundImage"), jSONObject.optString("backgroundMD5"), new 6(this, appBrandLivePusherView));
            return;
        }
        x.w("MicroMsg.JsApiInsertLivePusher", "the view(%s) is not a instance of CoverViewContainer", new Object[]{Integer.valueOf(i)});
    }

    private void a(Activity activity, p pVar, JSONObject jSONObject, int i) {
        int i2 = this.fRM;
        this.fRM = i2 + 1;
        if (i2 > 5) {
            x.i("MicroMsg.JsApiInsertLivePusher", "doInvokeAfterRequestPermission, avoid dead loop");
            return;
        }
        final Activity activity2 = activity;
        final p pVar2 = pVar;
        final JSONObject jSONObject2 = jSONObject;
        final int i3 = i;
        com.tencent.mm.plugin.appbrand.a.a(pVar.mAppId, new android.support.v4.app.a.a() {
            public final void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
                x.i("MicroMsg.JsApiInsertLivePusher", "onRequestPermissionsResult callback requestCode:%d", new Object[]{Integer.valueOf(i)});
                if (i == 117) {
                    if (iArr == null || iArr.length <= 0 || iArr[0] != 0) {
                        x.i("MicroMsg.JsApiInsertLivePusher", "onRequestPermissionsResult callback not grant");
                        pVar2.E(i3, c.this.f("fail:system permission denied", null));
                        return;
                    }
                    ah.i(new 1(this), 50);
                } else if (i != 118) {
                } else {
                    if (iArr == null || iArr.length <= 0 || iArr[0] != 0) {
                        x.i("MicroMsg.JsApiInsertLivePusher", "onRequestPermissionsResult callback not grant");
                        pVar2.E(i3, c.this.f("fail:system permission denied", null));
                        return;
                    }
                    ah.i(new 2(this), 50);
                }
            }
        });
        if (!com.tencent.mm.pluginsdk.permission.a.a(activity, "android.permission.CAMERA", 117, "", "")) {
            x.i("MicroMsg.JsApiInsertLivePusher", "doInvokeAfterRequestPermission, !retCameraPermission");
        } else if (com.tencent.mm.pluginsdk.permission.a.a(activity, "android.permission.RECORD_AUDIO", 118, "", "")) {
            x.i("MicroMsg.JsApiInsertLivePusher", "doInvokeAfterRequestPermission, super.invoke");
            super.a(pVar, jSONObject, i);
        } else {
            x.i("MicroMsg.JsApiInsertLivePusher", "doInvokeAfterRequestPermission, !retMicrophonePermission");
        }
    }
}
