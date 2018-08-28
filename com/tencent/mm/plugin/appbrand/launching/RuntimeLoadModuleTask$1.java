package com.tencent.mm.plugin.appbrand.launching;

import com.tencent.mm.ipcinvoker.c;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.plugin.appbrand.appcache.base.WxaPkgLoadProgress;
import com.tencent.mm.plugin.appbrand.launching.RuntimeLoadModuleTask.2;
import com.tencent.mm.plugin.appbrand.launching.RuntimeLoadModuleTask.WxaPkgResultProgressPair;
import com.tencent.mm.sdk.platformtools.x;

class RuntimeLoadModuleTask$1 implements c<WxaPkgResultProgressPair> {
    final /* synthetic */ RuntimeLoadModuleTask ggM;

    public RuntimeLoadModuleTask$1(RuntimeLoadModuleTask runtimeLoadModuleTask) {
        this.ggM = runtimeLoadModuleTask;
    }

    public final /* synthetic */ void at(Object obj) {
        WxaPkgResultProgressPair wxaPkgResultProgressPair = (WxaPkgResultProgressPair) obj;
        switch (2.ggN[WxaPkgResultProgressPair.a(wxaPkgResultProgressPair).ordinal()]) {
            case 1:
                WxaPkgWrappingInfo wxaPkgWrappingInfo = wxaPkgResultProgressPair.ggP;
                this.ggM.un(wxaPkgWrappingInfo == null ? null : wxaPkgWrappingInfo.ffK);
                return;
            case 2:
                WxaPkgLoadProgress wxaPkgLoadProgress = wxaPkgResultProgressPair.ggQ;
                if (wxaPkgLoadProgress != null) {
                    this.ggM.b(wxaPkgLoadProgress);
                    return;
                } else {
                    x.e("MicroMsg.AppBrand.RuntimeLoadModuleTask", "hy: non progress info! should not happen");
                    return;
                }
            default:
                return;
        }
    }
}
