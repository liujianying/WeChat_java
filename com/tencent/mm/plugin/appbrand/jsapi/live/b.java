package com.tencent.mm.plugin.appbrand.jsapi.live;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import com.tencent.mm.plugin.appbrand.jsapi.base.a;
import com.tencent.mm.plugin.appbrand.jsapi.coverview.CoverViewContainer;
import com.tencent.mm.plugin.appbrand.page.p;
import com.tencent.mm.plugin.appbrand.page.p.d;
import com.tencent.mm.plugin.appbrand.page.p.e;
import com.tencent.mm.plugin.appbrand.page.p.f;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.smtt.sdk.WebView;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class b extends a {
    private static final int CTRL_INDEX = 364;
    public static final String NAME = "insertLivePlayer";

    public final void a(p pVar, JSONObject jSONObject, int i) {
        k.aje();
        if (jSONObject.optInt("mode", 0) != 2) {
            super.a(pVar, jSONObject, i);
        } else if (pVar.mContext instanceof Activity) {
            try {
                if (android.support.v4.content.a.f((Activity) pVar.mContext, "android.permission.RECORD_AUDIO") == 0) {
                    super.a(pVar, jSONObject, i);
                    return;
                }
                Map hashMap = new HashMap();
                hashMap.put("errCode", Integer.valueOf(10001));
                pVar.E(i, f("fail:system permission denied", hashMap));
            } catch (Exception e) {
                x.e("MicroMsg.JsApiInsertLivePlayer", "check mpermission exception:%s.", new Object[]{e});
                pVar.E(i, f("fail", null));
            }
        } else {
            x.w("MicroMsg.JsApiInsertLivePlayer", "invokeAfterRequestPermission pageContext not activity");
            pVar.E(i, f("fail", null));
        }
    }

    protected final int k(JSONObject jSONObject) {
        return jSONObject.getInt("livePlayerId");
    }

    protected final View a(p pVar, JSONObject jSONObject) {
        CoverViewContainer coverViewContainer = new CoverViewContainer(pVar.mContext, new AppBrandLivePlayerView(pVar.mContext));
        coverViewContainer.setBackgroundColor(WebView.NIGHT_MODE_COLOR);
        return coverViewContainer;
    }

    protected final void a(p pVar, int i, View view, JSONObject jSONObject) {
        x.i("MicroMsg.JsApiInsertLivePlayer", "onInsertView livePlayerId=%d", new Object[]{Integer.valueOf(i)});
        if (view instanceof CoverViewContainer) {
            final AppBrandLivePlayerView appBrandLivePlayerView = (AppBrandLivePlayerView) ((CoverViewContainer) view).A(AppBrandLivePlayerView.class);
            if (appBrandLivePlayerView == null) {
                x.e("MicroMsg.JsApiInsertLivePlayer", "playerView null");
                return;
            }
            j jVar;
            1 1 = new 1(this, appBrandLivePlayerView);
            f anonymousClass2 = new f() {
                public final void agL() {
                    l lVar = appBrandLivePlayerView.fRA;
                    j tC = (lVar.fSb && lVar.fSh) ? lVar.tC("resume") : new j();
                    x.i("MicroMsg.AppBrandLivePlayerView", "onForeground code:%d info:%s", new Object[]{Integer.valueOf(tC.errorCode), tC.fRT});
                }
            };
            d 3 = new 3(this, appBrandLivePlayerView);
            e 4 = new 4(this, appBrandLivePlayerView, pVar, anonymousClass2, 3);
            pVar.a(anonymousClass2);
            pVar.a(3);
            pVar.a(4);
            appBrandLivePlayerView.setFullScreenDelegate(new 5(this, pVar, i, 1));
            appBrandLivePlayerView.setNeedEvent(jSONObject.optBoolean("needEvent", false));
            appBrandLivePlayerView.setOnFullScreenChangeListener(new 6(this, i, pVar));
            Bundle bundle = new Bundle();
            bundle.putString("playUrl", jSONObject.optString("playUrl"));
            bundle.putInt("mode", jSONObject.optInt("mode", 0));
            bundle.putBoolean("autoplay", jSONObject.optBoolean("autoplay", false));
            bundle.putBoolean("muted", jSONObject.optBoolean("muted", false));
            bundle.putString("orientation", jSONObject.optString("orientation"));
            bundle.putString("objectFit", jSONObject.optString("objectFit"));
            bundle.putBoolean("backgroundMute", jSONObject.optBoolean("backgroundMute", true));
            bundle.putFloat("minCache", BigDecimal.valueOf(jSONObject.optDouble("minCache", 1.0d)).floatValue());
            bundle.putFloat("maxCache", BigDecimal.valueOf(jSONObject.optDouble("maxCache", 3.0d)).floatValue());
            bundle.putBoolean("needEvent", jSONObject.optBoolean("needEvent", false));
            bundle.putBoolean("debug", jSONObject.optBoolean("debug", false));
            bundle.putString("soundMode", jSONObject.optString("soundMode", "speaker"));
            x.i("MicroMsg.JsApiInsertLivePlayer", "convertParams playUrl:%s", new Object[]{jSONObject.optString("playUrl")});
            l lVar = appBrandLivePlayerView.fRA;
            if (appBrandLivePlayerView == null) {
                jVar = new j(-1, "invalid params");
            } else {
                l.d("initLivePlayer", bundle);
                lVar.fRV = appBrandLivePlayerView;
                lVar.fRV.disableLog(false);
                lVar.fRX.setPlayerView(appBrandLivePlayerView);
                lVar.fRZ = bundle.getString("playUrl", lVar.fRZ);
                lVar.fSa = lVar.v(bundle);
                lVar.w(bundle);
                lVar.mAutoPlay = bundle.getBoolean("autoplay", lVar.mAutoPlay);
                if (!(!lVar.mAutoPlay || lVar.fRZ == null || lVar.fRZ.isEmpty())) {
                    x.i("TXLivePlayerJSAdapter", "initLivePlayer: startPlay");
                    lVar.fRX.startPlay(lVar.fRZ, lVar.fSa);
                }
                lVar.dni = true;
                jVar = new j();
            }
            x.i("MicroMsg.AppBrandLivePlayerView", "onInsert code:%d info:%s", new Object[]{Integer.valueOf(jVar.errorCode), jVar.fRT});
            appBrandLivePlayerView.setPlayEventListener(new 7(this, i, pVar));
            return;
        }
        x.w("MicroMsg.JsApiInsertLivePlayer", "the view(%s) is not a instance of CoverViewContainer", new Object[]{Integer.valueOf(i)});
    }
}
