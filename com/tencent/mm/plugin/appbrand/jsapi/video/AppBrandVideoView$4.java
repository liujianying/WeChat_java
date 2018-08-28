package com.tencent.mm.plugin.appbrand.jsapi.video;

import com.tencent.mm.plugin.appbrand.jsapi.video.e.a;
import com.tencent.mm.sdk.platformtools.x;
import org.json.JSONException;
import org.json.JSONObject;

class AppBrandVideoView$4 implements AppBrandVideoViewControlBar$a {
    final /* synthetic */ AppBrandVideoView gaM;

    AppBrandVideoView$4(AppBrandVideoView appBrandVideoView) {
        this.gaM = appBrandVideoView;
    }

    public final void cW(boolean z) {
        if (!z) {
            AppBrandVideoView.c(this.gaM).hide();
        } else if (AppBrandVideoView.b(this.gaM).isPlaying()) {
            AppBrandVideoView.c(this.gaM).show();
        } else {
            AppBrandVideoView.c(this.gaM).pause();
        }
        if (AppBrandVideoView.d(this.gaM) != null) {
            e d = AppBrandVideoView.d(this.gaM);
            int e = AppBrandVideoView.e(this.gaM);
            try {
                x.i("MicroMsg.JsApiVideoCallback", "onVideoClickDanmuBtn showDanmu=%b", new Object[]{Boolean.valueOf(z)});
                JSONObject aka = d.aka();
                aka.put("showDanmu", z);
                aka.put("videoPlayerId", e);
                d.a(new a((byte) 0), aka);
            } catch (JSONException e2) {
                x.e("MicroMsg.JsApiVideoCallback", "onVideoClickDanmuBtn e=%s", new Object[]{e2});
            }
        }
    }
}
