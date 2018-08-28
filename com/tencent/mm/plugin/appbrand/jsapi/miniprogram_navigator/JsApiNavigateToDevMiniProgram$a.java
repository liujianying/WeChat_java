package com.tencent.mm.plugin.appbrand.jsapi.miniprogram_navigator;

import com.tencent.mm.ipcinvoker.i;
import com.tencent.mm.ipcinvoker.type.IPCVoid;
import com.tencent.mm.plugin.appbrand.app.e;
import com.tencent.mm.plugin.appbrand.jsapi.miniprogram_navigator.JsApiNavigateToDevMiniProgram.DevPkgInfo;
import com.tencent.mm.plugin.appbrand.launching.h;
import com.tencent.mm.sdk.platformtools.bi;

final class JsApiNavigateToDevMiniProgram$a implements i<DevPkgInfo, IPCVoid> {
    private JsApiNavigateToDevMiniProgram$a() {
    }

    public final /* synthetic */ Object av(Object obj) {
        DevPkgInfo devPkgInfo = (DevPkgInfo) obj;
        ((h) e.x(h.class)).n(devPkgInfo.appId, 1, devPkgInfo.fVN);
        if (e.abi().a(devPkgInfo.appId, 1, devPkgInfo.cbv, devPkgInfo.cbw, 0, bi.VE() + 7200)) {
            com.tencent.mm.plugin.appbrand.task.e.aN(devPkgInfo.appId, 1);
        }
        return IPCVoid.dnk;
    }
}
