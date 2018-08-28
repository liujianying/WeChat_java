package com.tencent.mm.plugin.appbrand.jsapi.video;

import android.content.Context;
import android.view.View;
import com.tencent.mm.plugin.appbrand.jsapi.coverview.CoverViewContainer;
import com.tencent.mm.plugin.appbrand.page.p;
import com.tencent.mm.plugin.appbrand.page.p.d;
import com.tencent.mm.plugin.appbrand.page.p.e;
import com.tencent.mm.plugin.appbrand.page.p.f;
import com.tencent.mm.sdk.platformtools.x;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class a extends com.tencent.mm.plugin.appbrand.jsapi.base.a {
    private static final int CTRL_INDEX = 6;
    public static final String NAME = "insertVideoPlayer";

    protected final View a(p pVar, JSONObject jSONObject) {
        Context context = pVar.mContext;
        return new CoverViewContainer(context, new AppBrandVideoView(context));
    }

    protected final int k(JSONObject jSONObject) {
        return jSONObject.getInt("videoPlayerId");
    }

    protected final void a(p pVar, int i, View view, JSONObject jSONObject) {
        x.i("MicroMsg.JsApiInsertVideoPlayer", "onInsertView videoPlayerId=%d", new Object[]{Integer.valueOf(i)});
        final AppBrandVideoView appBrandVideoView = (AppBrandVideoView) ((CoverViewContainer) view).A(AppBrandVideoView.class);
        if (appBrandVideoView == null) {
            x.e("MicroMsg.JsApiInsertVideoPlayer", "onInsertView appBrandVideoView null");
            return;
        }
        1 1 = new 1(this, appBrandVideoView);
        f anonymousClass2 = new f() {
            public final void agL() {
                AppBrandVideoView appBrandVideoView = appBrandVideoView;
                x.i("MicroMsg.AppBrandVideoView", "onUIResume");
                appBrandVideoView.gak.SM();
            }
        };
        d 3 = new 3(this, appBrandVideoView);
        e 4 = new 4(this, appBrandVideoView, pVar, anonymousClass2, 3);
        pVar.a(anonymousClass2);
        pVar.a(3);
        pVar.a(4);
        appBrandVideoView.setFullScreenDelegate(new 5(this, pVar, i, 1));
        appBrandVideoView.setMute(jSONObject.optBoolean("muted", false));
        boolean optBoolean = jSONObject.optBoolean("needEvent", false);
        JSONObject jSONObject2 = jSONObject;
        x.i("MicroMsg.JsApiInsertVideoPlayer", "onInsertView autoPlay=%b needEvent=%b", new Object[]{Boolean.valueOf(jSONObject2.optBoolean("autoplay", false)), Boolean.valueOf(optBoolean)});
        boolean optBoolean2 = jSONObject.optBoolean("showDanmuBtn", true);
        boolean optBoolean3 = jSONObject.optBoolean("enableDanmu", false);
        JSONArray optJSONArray = jSONObject.optJSONArray("danmuList");
        String optString = jSONObject.optString("objectFit");
        String optString2 = jSONObject.optString("poster");
        boolean optBoolean4 = jSONObject.optBoolean("showBasicControls", true);
        String optString3 = jSONObject.optString("data");
        int optInt = jSONObject.optInt("direction", 90);
        boolean optBoolean5 = jSONObject.optBoolean("loop", false);
        boolean optBoolean6 = jSONObject.optBoolean("pageGesture", false);
        int optInt2 = jSONObject.optInt("initialTime", 0);
        boolean optBoolean7 = jSONObject.optBoolean("showLiveBtn", true);
        boolean optBoolean8 = jSONObject.optBoolean("showProgress", true);
        boolean optBoolean9 = jSONObject.optBoolean("showFullScreenBtn", true);
        boolean optBoolean10 = jSONObject.optBoolean("showPlayBtn", true);
        boolean optBoolean11 = jSONObject.optBoolean("showCenterPlayBtn", true);
        boolean optBoolean12 = jSONObject.optBoolean("enableProgressGesture", true);
        appBrandVideoView.setAppId(pVar.mAppId);
        appBrandVideoView.setIsGame(pVar.fdO.aaq());
        appBrandVideoView.setCookieData(optString3);
        appBrandVideoView.setIsShowBasicControls(optBoolean4);
        appBrandVideoView.setCover$16da05f7(optString2);
        appBrandVideoView.setFullScreenDirection(optInt);
        appBrandVideoView.setObjectFit(optString);
        appBrandVideoView.setLoop(optBoolean5);
        appBrandVideoView.setPageGesture(optBoolean6);
        try {
            appBrandVideoView.setVideoPlayerId(k(jSONObject));
        } catch (JSONException e) {
            x.e("MicroMsg.JsApiInsertVideoPlayer", "inflateView setVideoPlayerId exp=%s", new Object[]{e});
        }
        appBrandVideoView.setShowDanmakuBtn(optBoolean2);
        appBrandVideoView.setDanmakuEnable(optBoolean3);
        appBrandVideoView.setDanmakuItemList(optJSONArray);
        appBrandVideoView.setInitialTime(optInt2);
        appBrandVideoView.setShowLiveBtn(optBoolean7);
        appBrandVideoView.setShowProgress(optBoolean8);
        appBrandVideoView.setShowFullScreenBtn(optBoolean9);
        appBrandVideoView.setShowPlayBtn(optBoolean10);
        appBrandVideoView.setShowCenterPlayBtn(optBoolean11);
        appBrandVideoView.cU(optBoolean12);
        if (optBoolean) {
            appBrandVideoView.setCallback(new e(appBrandVideoView, pVar));
        }
        int optInt3 = jSONObject.optInt("duration", -1);
        x.i("MicroMsg.JsApiInsertVideoPlayer", "onInsertView filePath=%s live=%b", new Object[]{jSONObject.optString("filePath"), Boolean.valueOf(jSONObject.optBoolean("live", false))});
        appBrandVideoView.e(r4, optBoolean2, optInt3);
    }
}
