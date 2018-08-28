package com.tencent.mm.plugin.appbrand.jsapi.live;

import android.view.View;
import com.tencent.mm.plugin.appbrand.jsapi.base.c;
import com.tencent.mm.plugin.appbrand.jsapi.coverview.CoverViewContainer;
import com.tencent.mm.plugin.appbrand.page.p;
import com.tencent.mm.sdk.platformtools.x;
import org.json.JSONArray;
import org.json.JSONObject;

public final class d extends c {
    private static final int CTRL_INDEX = 367;
    public static final String NAME = "operateLivePlayer";

    protected final int k(JSONObject jSONObject) {
        return jSONObject.optInt("livePlayerId");
    }

    protected final boolean c(p pVar, int i, View view, JSONObject jSONObject) {
        x.i("MicroMsg.JsApiOperateLivePlayer", "onUpdateView : livePlayerId=%d", new Object[]{Integer.valueOf(i)});
        if (view instanceof CoverViewContainer) {
            View A = ((CoverViewContainer) view).A(View.class);
            if (A instanceof AppBrandLivePlayerView) {
                AppBrandLivePlayerView appBrandLivePlayerView = (AppBrandLivePlayerView) A;
                String optString = jSONObject.optString("type");
                x.i("MicroMsg.JsApiOperateLivePlayer", "onUpdateView operateType=%s", new Object[]{optString});
                boolean z = true;
                switch (optString.hashCode()) {
                    case -802181223:
                        if (optString.equals("exitFullScreen")) {
                            z = true;
                            break;
                        }
                        break;
                    case 458133450:
                        if (optString.equals("requestFullScreen")) {
                            z = false;
                            break;
                        }
                        break;
                }
                switch (z) {
                    case false:
                        int i2;
                        JSONArray optJSONArray = jSONObject.optJSONArray("data");
                        if (optJSONArray == null || optJSONArray.length() == 0) {
                            x.w("MicroMsg.JsApiOperateLivePlayer", "onUpdateView directionArr nil");
                            i2 = 0;
                        } else {
                            i2 = optJSONArray.optInt(0, 0);
                        }
                        x.i("MicroMsg.AppBrandLivePlayerView", "enterFullScreen direction:%s", new Object[]{Integer.valueOf(i2)});
                        if (appBrandLivePlayerView.fRB == null) {
                            x.w("MicroMsg.AppBrandLivePlayerView", "enterFullScreen mFullScreenDelegate null");
                            return false;
                        } else if (appBrandLivePlayerView.fRB.isFullScreen()) {
                            x.i("MicroMsg.AppBrandLivePlayerView", "enterFullScreen already full screen");
                            return true;
                        } else {
                            appBrandLivePlayerView.fRB.kM(i2);
                            appBrandLivePlayerView.fRD = i2;
                            appBrandLivePlayerView.cP(true);
                            return true;
                        }
                    case true:
                        x.i("MicroMsg.AppBrandLivePlayerView", "quitFullScreen");
                        if (appBrandLivePlayerView.fRB == null) {
                            x.w("MicroMsg.AppBrandLivePlayerView", "quitFullScreen mFullScreenDelegate null");
                            return false;
                        } else if (appBrandLivePlayerView.fRB.isFullScreen()) {
                            appBrandLivePlayerView.fRB.ajc();
                            return true;
                        } else {
                            x.i("MicroMsg.AppBrandLivePlayerView", "quitFullScreen already quit full screen");
                            return true;
                        }
                    default:
                        x.i("MicroMsg.AppBrandLivePlayerView", "onOperate code:%d info:%s", new Object[]{Integer.valueOf(r0.errorCode), appBrandLivePlayerView.fRA.tC(optString).fRT});
                        if (appBrandLivePlayerView.fRA.tC(optString).errorCode == 0) {
                            return true;
                        }
                        return false;
                }
            }
            x.e("MicroMsg.JsApiOperateLivePlayer", "targetView not AppBrandLivePlayerView");
            return false;
        }
        x.w("MicroMsg.JsApiOperateLivePlayer", "the view(%s) is not a instance of CoverViewContainer", new Object[]{Integer.valueOf(i)});
        return false;
    }
}
