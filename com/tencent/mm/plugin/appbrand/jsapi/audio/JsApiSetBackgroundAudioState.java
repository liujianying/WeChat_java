package com.tencent.mm.plugin.appbrand.jsapi.audio;

import com.tencent.mm.model.u;
import com.tencent.mm.model.u.b;
import com.tencent.mm.plugin.appbrand.config.AppBrandSysConfig;
import com.tencent.mm.plugin.appbrand.e$b;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.appbrand.l;
import com.tencent.mm.plugin.appbrand.ui.banner.f;
import com.tencent.mm.sdk.platformtools.x;
import org.json.JSONObject;

public final class JsApiSetBackgroundAudioState extends a {
    public static final int CTRL_INDEX = 160;
    public static final String NAME = "setBackgroundAudioState";
    public static int fIS = 0;
    private SetBackgroundAudioListenerTask fIj;

    public final void a(l lVar, JSONObject jSONObject, int i) {
        if (jSONObject == null) {
            lVar.E(i, f("fail:data is null", null));
            x.e("MicroMsg.Music.JsApiSetBackgroundAudioState", "setBackgroundAudioState data is null");
            return;
        }
        String str = lVar.mAppId;
        x.i("MicroMsg.Music.JsApiSetBackgroundAudioState", "setBackgroundAudioState appId:%s ,data:%s", new Object[]{str, jSONObject.toString()});
        if (this.fIj == null) {
            this.fIj = new SetBackgroundAudioListenerTask(this, lVar, i);
        }
        this.fIj.fFd = i;
        this.fIj.appId = str;
        SetBackgroundAudioListenerTask.a(this.fIj);
        AppBrandSysConfig appBrandSysConfig = lVar.fdO.fcu;
        this.fIj.bPh = appBrandSysConfig.frm.fih;
        this.fIj.bKC = appBrandSysConfig.bKC;
        this.fIj.bPg = appBrandSysConfig.bGy;
        x.i("MicroMsg.Music.JsApiSetBackgroundAudioState", "pkgType:%d, brandName:%s, appUserName", new Object[]{Integer.valueOf(this.fIj.bPh), this.fIj.bKC, this.fIj.bPg});
        b v = u.Hx().v(u.ic("AppBrandService#" + lVar.hashCode()), true);
        synchronized (v) {
            f fVar;
            f fVar2 = (f) v.get("StickyBannerChangeListener", null);
            if (fVar2 == null) {
                1 1 = new 1(this, v, lVar, i);
                v.p("pkgType", Integer.valueOf(appBrandSysConfig.frm.fih));
                v.p("StickyBannerChangeListener", 1);
                v.p("appId", lVar.mAppId);
                fVar = 1;
            } else {
                fVar = fVar2;
            }
            if (((e$b) v.get("AppBrandLifeCycle.Listener", null)) == null) {
                2 2 = new 2(this, v, lVar, i);
                v.p("AppBrandLifeCycle.Listener", 2);
                this.fIj.fIs = 2;
            }
            this.fIj.fIr = fVar;
            this.fIj.fvX = v;
        }
        AppBrandMainProcessService.a(this.fIj);
        SetBackgroundAudioStateTask setBackgroundAudioStateTask = new SetBackgroundAudioStateTask(this, lVar, i);
        setBackgroundAudioStateTask.fFd = i;
        setBackgroundAudioStateTask.appId = str;
        setBackgroundAudioStateTask.fIo = jSONObject.toString();
        AppBrandMainProcessService.a(setBackgroundAudioStateTask);
    }
}
