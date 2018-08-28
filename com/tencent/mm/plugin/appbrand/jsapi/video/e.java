package com.tencent.mm.plugin.appbrand.jsapi.video;

import com.tencent.mm.plugin.appbrand.page.p;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.x;
import org.json.JSONObject;

public final class e implements com.tencent.mm.plugin.appbrand.page.p.e {
    AppBrandVideoView gbp;
    private p gbq;
    al gbr;
    int gbs;

    private static final class a extends com.tencent.mm.plugin.appbrand.jsapi.h {
        private static final int CTRL_INDEX = 131;
        private static final String NAME = "onVideoClickDanmuBtn";

        private a() {
        }

        /* synthetic */ a(byte b) {
            this();
        }
    }

    private static final class b extends com.tencent.mm.plugin.appbrand.jsapi.h {
        private static final int CTRL_INDEX = 138;
        private static final String NAME = "onVideoEnded";

        private b() {
        }

        /* synthetic */ b(byte b) {
            this();
        }
    }

    private static final class d extends com.tencent.mm.plugin.appbrand.jsapi.h {
        private static final int CTRL_INDEX = 130;
        private static final String NAME = "onVideoFullScreenChange";

        private d() {
        }

        /* synthetic */ d(byte b) {
            this();
        }
    }

    private static final class e extends com.tencent.mm.plugin.appbrand.jsapi.h {
        private static final int CTRL_INDEX = 128;
        private static final String NAME = "onVideoPause";

        private e() {
        }

        /* synthetic */ e(byte b) {
            this();
        }
    }

    private static final class f extends com.tencent.mm.plugin.appbrand.jsapi.h {
        private static final int CTRL_INDEX = 127;
        private static final String NAME = "onVideoPlay";

        private f() {
        }

        /* synthetic */ f(byte b) {
            this();
        }
    }

    private static final class g extends com.tencent.mm.plugin.appbrand.jsapi.h {
        private static final int CTRL_INDEX = 127;
        private static final String NAME = "onVideoTimeUpdate";

        private g() {
        }

        /* synthetic */ g(byte b) {
            this();
        }
    }

    private static final class h extends com.tencent.mm.plugin.appbrand.jsapi.h {
        private static final int CTRL_INDEX = 350;
        private static final String NAME = "onVideoWaiting";

        private h() {
        }

        /* synthetic */ h(byte b) {
            this();
        }
    }

    public e(AppBrandVideoView appBrandVideoView, p pVar) {
        this.gbp = appBrandVideoView;
        this.gbq = pVar;
        this.gbq.a(this);
    }

    public final void onDestroy() {
        x.d("MicroMsg.JsApiVideoCallback", "onDestroy clean");
        clean();
        this.gbp.setCallback(null);
    }

    public final void clean() {
        this.gbq.b(this);
        akb();
    }

    final void a(com.tencent.mm.plugin.appbrand.jsapi.h hVar, JSONObject jSONObject) {
        if (!(hVar instanceof g)) {
            x.i("MicroMsg.JsApiVideoCallback", "dispatchEvent event %s", new Object[]{hVar.getName()});
        }
        com.tencent.mm.plugin.appbrand.jsapi.h aC = hVar.aC(this.gbq.mAppId, this.gbq.hashCode());
        aC.mData = jSONObject.toString();
        aC.ahM();
    }

    final JSONObject aka() {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("data", this.gbp.getCookieData());
        return jSONObject;
    }

    final void akb() {
        if (this.gbr != null) {
            this.gbr.SO();
        }
    }
}
