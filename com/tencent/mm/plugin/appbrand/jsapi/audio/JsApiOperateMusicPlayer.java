package com.tencent.mm.plugin.appbrand.jsapi.audio;

import com.tencent.mm.model.u;
import com.tencent.mm.plugin.appbrand.config.AppBrandSysConfig;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.jsapi.h;
import com.tencent.mm.plugin.appbrand.l;
import com.tencent.mm.plugin.appbrand.ui.banner.f;
import org.json.JSONObject;

public final class JsApiOperateMusicPlayer extends com.tencent.mm.plugin.appbrand.jsapi.a {
    public static final int CTRL_INDEX = 47;
    public static final String NAME = "operateMusicPlayer";
    OperateMusicPlayer fIp;

    private static final class a extends h {
        private static final int CTRL_INDEX = 82;
        private static final String NAME = "onMusicEnd";

        private a() {
        }

        /* synthetic */ a(byte b) {
            this();
        }
    }

    private static final class b extends h {
        private static final int CTRL_INDEX = 81;
        private static final String NAME = "onMusicPause";

        private b() {
        }

        /* synthetic */ b(byte b) {
            this();
        }
    }

    private static final class c extends h {
        private static final int CTRL_INDEX = 80;
        private static final String NAME = "onMusicPlay";

        private c() {
        }

        /* synthetic */ c(byte b) {
            this();
        }
    }

    public final void a(l lVar, JSONObject jSONObject, int i) {
        this.fIp = new OperateMusicPlayer(this, lVar, i);
        com.tencent.mm.model.u.b v = u.Hx().v(u.ic("AppBrandService#" + lVar.hashCode()), true);
        synchronized (v) {
            f fVar;
            f fVar2 = (f) v.get("StickyBannerChangeListener", null);
            if (fVar2 == null) {
                1 1 = new 1(this, v, lVar);
                AppBrandSysConfig appBrandSysConfig = lVar.fdO.fcu;
                if (appBrandSysConfig != null) {
                    v.p("pkgType", Integer.valueOf(appBrandSysConfig.frm.fih));
                }
                v.p("StickyBannerChangeListener", 1);
                v.p("appId", lVar.mAppId);
                fVar = 1;
            } else {
                fVar = fVar2;
            }
            if (((com.tencent.mm.plugin.appbrand.e.b) v.get("AppBrandLifeCycle.Listener", null)) == null) {
                2 2 = new 2(this, v, lVar);
                v.p("AppBrandLifeCycle.Listener", 2);
                this.fIp.fIs = 2;
            }
            this.fIp.fIr = fVar;
            this.fIp.fvX = v;
        }
        this.fIp.bVc = jSONObject.toString();
        this.fIp.bPS = lVar.mAppId;
        AppBrandMainProcessService.a(this.fIp);
    }
}
