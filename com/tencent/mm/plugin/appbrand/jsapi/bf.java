package com.tencent.mm.plugin.appbrand.jsapi;

import android.os.PowerManager;
import android.os.PowerManager.WakeLock;
import com.eclipsesource.v8.BuildConfig;
import com.tencent.mm.plugin.appbrand.e;
import com.tencent.mm.plugin.appbrand.l;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import org.json.JSONObject;

public final class bf extends a {
    public static final int CTRL_INDEX = -2;
    public static final String NAME = "setKeepScreenOn";
    private static boolean fHd = false;
    private l fFa;
    WakeLock wakeLock;

    public final void a(l lVar, JSONObject jSONObject, int i) {
        if (jSONObject == null) {
            x.e("MicroMsg.JsApiSetKeepScreenOn", "setKeepScreenOn data is null");
            lVar.E(i, f("fail:data is null", null));
        } else if (lVar.getContext() == null) {
            x.e("MicroMsg.JsApiSetKeepScreenOn", "setKeepScreenOn, server context is nul");
            lVar.E(i, f("fail:context is null", null));
        } else {
            boolean optBoolean = jSONObject.optBoolean("keepScreenOn", false);
            fHd = optBoolean;
            x.i("MicroMsg.JsApiSetKeepScreenOn", "setKeepScreenOn, keepScreenOn:%b, appId:%s", new Object[]{Boolean.valueOf(optBoolean), lVar.mAppId});
            synchronized (this) {
                this.fFa = lVar;
            }
            if (optBoolean) {
                e.a(lVar.mAppId, new 1(this, lVar));
                optBoolean = ahR();
            } else if (isHeld()) {
                x.i("MicroMsg.JsApiSetKeepScreenOn", "reset screen off");
                optBoolean = release();
            } else {
                x.e("MicroMsg.JsApiSetKeepScreenOn", "fail, has not set screen");
                lVar.E(i, f("fail:has not set screen", null));
                return;
            }
            if (optBoolean) {
                x.i("MicroMsg.JsApiSetKeepScreenOn", "setKeepScreenOn ok");
                lVar.E(i, f("ok", null));
                return;
            }
            x.e("MicroMsg.JsApiSetKeepScreenOn", "setKeepScreenOn fail");
            lVar.E(i, f("fail", null));
        }
    }

    private synchronized boolean ahR() {
        boolean z;
        if (this.fFa.getContext() == null) {
            x.e("MicroMsg.JsApiSetKeepScreenOn", "acquire fail, server context is nul");
            z = false;
        } else {
            x.e("MicroMsg.JsApiSetKeepScreenOn", "acquire ok");
            MMActivity mMActivity = (MMActivity) this.fFa.getContext();
            if (this.wakeLock == null) {
                this.wakeLock = ((PowerManager) mMActivity.getSystemService("power")).newWakeLock(536870922, "MicroMsg.JsApiSetKeepScreenOn");
            }
            if (this.wakeLock.isHeld()) {
                x.i("MicroMsg.JsApiSetKeepScreenOn", "wakeLock has held ");
            } else {
                this.wakeLock.acquire();
                x.i("MicroMsg.JsApiSetKeepScreenOn", "wakeLock acquire");
            }
            z = true;
        }
        return z;
    }

    private synchronized boolean release() {
        boolean z;
        x.e("MicroMsg.JsApiSetKeepScreenOn", BuildConfig.BUILD_TYPE);
        if (this.wakeLock == null || !this.wakeLock.isHeld()) {
            x.e("MicroMsg.JsApiSetKeepScreenOn", "wakeLock is  null");
            z = false;
        } else {
            this.wakeLock.release();
            this.wakeLock = null;
            z = true;
        }
        return z;
    }

    private synchronized boolean isHeld() {
        boolean z;
        z = this.wakeLock != null && this.wakeLock.isHeld();
        return z;
    }
}
