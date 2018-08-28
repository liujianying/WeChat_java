package com.tencent.mm.plugin.appbrand.jsapi.video;

import com.tencent.mm.plugin.appbrand.jsapi.video.e.1;
import com.tencent.mm.plugin.appbrand.jsapi.video.e.c;
import com.tencent.mm.plugin.appbrand.jsapi.video.e.e;
import com.tencent.mm.plugin.appbrand.jsapi.video.e.f;
import com.tencent.mm.plugin.appbrand.jsapi.video.e.h;
import com.tencent.mm.pluginsdk.ui.h.b;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.x;
import org.json.JSONException;
import org.json.JSONObject;

class AppBrandVideoView$6 implements b {
    final /* synthetic */ AppBrandVideoView gaM;

    AppBrandVideoView$6(AppBrandVideoView appBrandVideoView) {
        this.gaM = appBrandVideoView;
    }

    public final void d(String str, String str2, String str3, int i, int i2) {
        x.i("MicroMsg.AppBrandVideoView", "onError errorMsg=%s what=%d extra=%d", new Object[]{str3, Integer.valueOf(i), Integer.valueOf(i2)});
        if (AppBrandVideoView.d(this.gaM) != null) {
            e d = AppBrandVideoView.d(this.gaM);
            d.clean();
            try {
                JSONObject aka = d.aka();
                aka.put("errMsg", str3);
                d.a(new c((byte) 0), aka);
            } catch (JSONException e) {
                x.e("MicroMsg.JsApiVideoCallback", "onError e=%s", new Object[]{e});
            }
        }
    }

    public final void bu(String str, String str2) {
        x.i("MicroMsg.AppBrandVideoView", "onPrepared");
        f n = AppBrandVideoView.n(this.gaM);
        n.gbA = -1;
        n.gbB = 0;
        n.gbz = 0.0f;
    }

    public final void bv(String str, String str2) {
        x.i("MicroMsg.AppBrandVideoView", "onVideoEnded");
        AppBrandVideoView.o(this.gaM).setVisibility(0);
        if (AppBrandVideoView.p(this.gaM) || !AppBrandVideoView.q(this.gaM)) {
            AppBrandVideoView.r(this.gaM).setVisibility(8);
        } else {
            if (AppBrandVideoView.s(this.gaM) <= 0) {
                AppBrandVideoView.t(this.gaM).setText(AppBrandVideoView.kU(AppBrandVideoView.b(this.gaM).getVideoDurationSec()));
            }
            AppBrandVideoView.r(this.gaM).setVisibility(0);
        }
        if (AppBrandVideoView.d(this.gaM) != null) {
            e d = AppBrandVideoView.d(this.gaM);
            try {
                d.a(new e.b((byte) 0), d.aka());
            } catch (JSONException e) {
                x.e("MicroMsg.JsApiVideoCallback", "OnVideoEnded e=%s", new Object[]{e});
            }
            d.akb();
        }
        if (AppBrandVideoView.u(this.gaM)) {
            this.gaM.C(0, true);
        }
    }

    public final void d(String str, String str2, int i, int i2) {
        x.i("MicroMsg.AppBrandVideoView", "onGetVideoSize width=%d height=%d", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
        if (AppBrandVideoView.v(this.gaM) == -1) {
            AppBrandVideoView.a(this.gaM, i < i2 ? 0 : 90);
            x.i("MicroMsg.AppBrandVideoView", "onGetVideoSize adjust direction from AUTO to %s", new Object[]{Integer.valueOf(AppBrandVideoView.v(this.gaM))});
        }
    }

    public final void bw(String str, String str2) {
        x.i("MicroMsg.AppBrandVideoView", "onVideoPause");
        if (AppBrandVideoView.d(this.gaM) != null) {
            e d = AppBrandVideoView.d(this.gaM);
            try {
                d.a(new e((byte) 0), d.aka());
            } catch (JSONException e) {
                x.e("MicroMsg.JsApiVideoCallback", "OnVideoPause e=%s", new Object[]{e});
            }
            d.akb();
        }
    }

    public final void bx(String str, String str2) {
        x.i("MicroMsg.AppBrandVideoView", "onVideoPlay, isLive:%b", new Object[]{Boolean.valueOf(AppBrandVideoView.p(this.gaM))});
        if (AppBrandVideoView.s(this.gaM) <= 0 && !AppBrandVideoView.p(this.gaM)) {
            AppBrandVideoView.t(this.gaM).setText(AppBrandVideoView.kU(AppBrandVideoView.b(this.gaM).getVideoDurationSec()));
        }
        AppBrandVideoView.a(this.gaM, AppBrandVideoView.p(this.gaM));
        if (AppBrandVideoView.f(this.gaM)) {
            AppBrandVideoView.g(this.gaM).ajR();
        }
        if (AppBrandVideoView.d(this.gaM) != null) {
            e d = AppBrandVideoView.d(this.gaM);
            try {
                d.gbs = 0;
                JSONObject aka = d.aka();
                aka.put("timeStamp", System.currentTimeMillis());
                d.a(new f((byte) 0), aka);
                if (d.gbr == null) {
                    d.gbr = new al(new 1(d), true);
                }
                d.gbr.J(250, 250);
            } catch (JSONException e) {
                x.e("MicroMsg.JsApiVideoCallback", "OnVideoPlay e=%s", new Object[]{e});
            }
        }
    }

    public final void by(String str, String str2) {
        x.i("MicroMsg.AppBrandVideoView", "onVideoWaiting");
        if (AppBrandVideoView.d(this.gaM) != null) {
            e d = AppBrandVideoView.d(this.gaM);
            try {
                JSONObject aka = d.aka();
                aka.put("timeStamp", System.currentTimeMillis());
                d.a(new h((byte) 0), aka);
            } catch (JSONException e) {
                x.e("MicroMsg.JsApiVideoCallback", "onVideoWaiting e=%s", new Object[]{e});
            }
        }
    }

    public final void bz(String str, String str2) {
    }
}
