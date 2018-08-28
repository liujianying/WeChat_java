package com.tencent.mm.plugin.appbrand.jsapi.video;

import android.view.View;
import com.tencent.mm.plugin.appbrand.jsapi.base.c;
import com.tencent.mm.plugin.appbrand.jsapi.coverview.CoverViewContainer;
import com.tencent.mm.plugin.appbrand.page.p;
import com.tencent.mm.sdk.platformtools.x;
import org.json.JSONException;
import org.json.JSONObject;

public final class d extends c {
    private static final int CTRL_INDEX = 87;
    public static final String NAME = "updateVideoPlayer";

    protected final int k(JSONObject jSONObject) {
        return jSONObject.optInt("videoPlayerId");
    }

    protected final boolean c(p pVar, int i, View view, JSONObject jSONObject) {
        x.i("MicroMsg.JsApiUpdateVideoPlayer", "onUpdateView : videoPlayerId=%d", new Object[]{Integer.valueOf(i)});
        if (view instanceof CoverViewContainer) {
            AppBrandVideoView appBrandVideoView = (AppBrandVideoView) ((CoverViewContainer) view).A(AppBrandVideoView.class);
            if (appBrandVideoView == null) {
                x.e("MicroMsg.JsApiUpdateVideoPlayer", "view not AppBrandVideoView");
                return false;
            }
            try {
                if (jSONObject.has("showDanmuBtn")) {
                    appBrandVideoView.setShowDanmakuBtn(jSONObject.getBoolean("showDanmuBtn"));
                }
            } catch (JSONException e) {
                x.i("MicroMsg.JsApiUpdateVideoPlayer", "onUpdateView param=%s exp=%s", new Object[]{"showDanmuBtn", e.getLocalizedMessage()});
            }
            try {
                if (jSONObject.has("danmuList")) {
                    appBrandVideoView.setDanmakuItemList(jSONObject.getJSONArray("danmuList"));
                }
            } catch (JSONException e2) {
                x.i("MicroMsg.JsApiUpdateVideoPlayer", "onUpdateView param=%s exp=%s", new Object[]{"danmuList", e2.getLocalizedMessage()});
            }
            try {
                if (jSONObject.has("objectFit")) {
                    appBrandVideoView.setObjectFit(jSONObject.getString("objectFit"));
                }
            } catch (JSONException e22) {
                x.i("MicroMsg.JsApiUpdateVideoPlayer", "onUpdateView param=%s exp=%s", new Object[]{"objectFit", e22.getLocalizedMessage()});
            }
            try {
                if (jSONObject.has("autoplay")) {
                    appBrandVideoView.setAutoPlay(jSONObject.getBoolean("autoplay"));
                }
            } catch (JSONException e222) {
                x.i("MicroMsg.JsApiUpdateVideoPlayer", "onUpdateView param=%s exp=%s", new Object[]{"autoplay", e222.getLocalizedMessage()});
            }
            try {
                if (jSONObject.has("showBasicControls")) {
                    appBrandVideoView.setIsShowBasicControls(jSONObject.getBoolean("showBasicControls"));
                }
            } catch (JSONException e2222) {
                x.i("MicroMsg.JsApiUpdateVideoPlayer", "onUpdateView param=%s exp=%s", new Object[]{"showBasicControls", e2222.getLocalizedMessage()});
            }
            try {
                if (jSONObject.has("poster")) {
                    appBrandVideoView.setCover$16da05f7(jSONObject.getString("poster"));
                }
            } catch (JSONException e22222) {
                x.i("MicroMsg.JsApiUpdateVideoPlayer", "onUpdateView param=%s exp=%s", new Object[]{"poster", e22222.getLocalizedMessage()});
            }
            try {
                if (jSONObject.has("direction")) {
                    appBrandVideoView.setFullScreenDirection(jSONObject.getInt("direction"));
                }
            } catch (Exception e3) {
                x.i("MicroMsg.JsApiUpdateVideoPlayer", "onUpdateView param=%s exp=%s", new Object[]{"direction", e3.getLocalizedMessage()});
            }
            try {
                if (jSONObject.has("muted")) {
                    appBrandVideoView.setMute(jSONObject.getBoolean("muted"));
                }
            } catch (JSONException e222222) {
                x.i("MicroMsg.JsApiUpdateVideoPlayer", "onUpdateView param=%s exp=%s", new Object[]{"muted", e222222.getLocalizedMessage()});
            }
            try {
                if (jSONObject.has("loop")) {
                    appBrandVideoView.setLoop(jSONObject.getBoolean("loop"));
                }
            } catch (JSONException e2222222) {
                x.i("MicroMsg.JsApiUpdateVideoPlayer", "onUpdateView param=%s exp=%s", new Object[]{"loop", e2222222.getLocalizedMessage()});
            }
            try {
                if (jSONObject.has("data")) {
                    appBrandVideoView.setCookieData(jSONObject.getString("data"));
                }
            } catch (JSONException e22222222) {
                x.i("MicroMsg.JsApiUpdateVideoPlayer", "onUpdateView param=%s exp=%s", new Object[]{"data", e22222222.getLocalizedMessage()});
            }
            try {
                if (jSONObject.has("pageGesture")) {
                    appBrandVideoView.setPageGesture(jSONObject.getBoolean("pageGesture"));
                }
            } catch (JSONException e222222222) {
                x.i("MicroMsg.JsApiUpdateVideoPlayer", "onUpdateView param=%s exp=%s", new Object[]{"pageGesture", e222222222.getLocalizedMessage()});
            }
            try {
                if (jSONObject.has("showLiveBtn")) {
                    appBrandVideoView.setShowLiveBtn(jSONObject.getBoolean("showLiveBtn"));
                }
            } catch (JSONException e2222222222) {
                x.i("MicroMsg.JsApiUpdateVideoPlayer", "onUpdateView param=%s exp=%s", new Object[]{"showLiveBtn", e2222222222.getLocalizedMessage()});
            }
            try {
                if (jSONObject.has("showProgress")) {
                    appBrandVideoView.setShowProgress(jSONObject.getBoolean("showProgress"));
                }
            } catch (JSONException e22222222222) {
                x.i("MicroMsg.JsApiUpdateVideoPlayer", "onUpdateView param=%s exp=%s", new Object[]{"showProgress", e22222222222.getLocalizedMessage()});
            }
            try {
                if (jSONObject.has("showFullScreenBtn")) {
                    appBrandVideoView.setShowFullScreenBtn(jSONObject.getBoolean("showFullScreenBtn"));
                }
            } catch (JSONException e222222222222) {
                x.i("MicroMsg.JsApiUpdateVideoPlayer", "onUpdateView param=%s exp=%s", new Object[]{"showFullScreenBtn", e222222222222.getLocalizedMessage()});
            }
            try {
                if (jSONObject.has("showPlayBtn")) {
                    appBrandVideoView.setShowPlayBtn(jSONObject.getBoolean("showPlayBtn"));
                }
            } catch (JSONException e2222222222222) {
                x.i("MicroMsg.JsApiUpdateVideoPlayer", "onUpdateView param=%s exp=%s", new Object[]{"showPlayBtn", e2222222222222.getLocalizedMessage()});
            }
            try {
                if (jSONObject.has("showCenterPlayBtn")) {
                    appBrandVideoView.setShowCenterPlayBtn(jSONObject.getBoolean("showCenterPlayBtn"));
                }
            } catch (JSONException e22222222222222) {
                x.i("MicroMsg.JsApiUpdateVideoPlayer", "onUpdateView param=%s exp=%s", new Object[]{"showCenterPlayBtn", e22222222222222.getLocalizedMessage()});
            }
            try {
                if (jSONObject.has("enableProgressGesture")) {
                    appBrandVideoView.cU(jSONObject.getBoolean("enableProgressGesture"));
                }
            } catch (JSONException e222222222222222) {
                x.i("MicroMsg.JsApiUpdateVideoPlayer", "onUpdateView param=%s exp=%s", new Object[]{"enableProgressGesture", e222222222222222.getLocalizedMessage()});
            }
            try {
                if (jSONObject.has("duration")) {
                    appBrandVideoView.setDuration(jSONObject.getInt("duration"));
                }
            } catch (JSONException e2222222222222222) {
                x.i("MicroMsg.JsApiUpdateVideoPlayer", "onUpdateView param=%s exp=%s", new Object[]{"disableScroll", e2222222222222222.getLocalizedMessage()});
            }
            try {
                if (jSONObject.has("hide") && jSONObject.getBoolean("hide")) {
                    x.i("MicroMsg.JsApiUpdateVideoPlayer", "onUpdateView hide stop");
                    appBrandVideoView.stop();
                }
            } catch (JSONException e22222222222222222) {
                x.i("MicroMsg.JsApiUpdateVideoPlayer", "onUpdateView param=%s exp=%s", new Object[]{"hide", e22222222222222222.getLocalizedMessage()});
            }
            try {
                if (jSONObject.has("initialTime")) {
                    appBrandVideoView.setInitialTime(jSONObject.getInt("initialTime"));
                }
            } catch (JSONException e222222222222222222) {
                x.i("MicroMsg.JsApiUpdateVideoPlayer", "onUpdateView param=%s exp=%s", new Object[]{"initialTime", e222222222222222222.getLocalizedMessage()});
            }
            try {
                if (jSONObject.has("needEvent")) {
                    if (jSONObject.getBoolean("needEvent")) {
                        if ((appBrandVideoView.gaz != null ? 1 : 0) == 0) {
                            appBrandVideoView.setCallback(new e(appBrandVideoView, pVar));
                        }
                    } else {
                        appBrandVideoView.setCallback(null);
                    }
                }
            } catch (JSONException e2222222222222222222) {
                x.i("MicroMsg.JsApiUpdateVideoPlayer", "onUpdateView param=%s exp=%s", new Object[]{"needEvent", e2222222222222222222.getLocalizedMessage()});
            }
            try {
                if (jSONObject.has("filePath")) {
                    appBrandVideoView.e(jSONObject.getString("filePath"), jSONObject.optBoolean("live"), jSONObject.optInt("duration"));
                }
            } catch (JSONException e4) {
                x.i("MicroMsg.JsApiUpdateVideoPlayer", "onUpdateView param=%s exp=%s", new Object[]{"filePath", e4.getLocalizedMessage()});
            }
            return true;
        }
        x.w("MicroMsg.JsApiUpdateVideoPlayer", "the view(%s) is not a instance of CoverViewContainer", new Object[]{Integer.valueOf(i)});
        return false;
    }
}
