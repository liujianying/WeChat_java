package com.tencent.mm.plugin.appbrand.appcache;

import android.util.Pair;
import com.tencent.mm.ipcinvoker.i;
import com.tencent.mm.ipcinvoker.type.IPCVoid;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.appcache.WxaCommLibRuntimeReader.AccountNotReadyError;
import com.tencent.mm.plugin.appbrand.appcache.ak.a;
import com.tencent.mm.sdk.f.e;

final class WxaCommLibRuntimeReader$b implements i<IPCVoid, Object> {
    private WxaCommLibRuntimeReader$b() {
    }

    public final /* synthetic */ Object av(Object obj) {
        if (!g.Eg().dpD) {
            return new AccountNotReadyError();
        }
        WxaPkgWrappingInfo cu = cu(false);
        if (cu == null) {
            cu = cu(true);
        }
        ab.jF(cu == null ? af.VERSION : cu.fii);
        return cu;
    }

    private WxaPkgWrappingInfo cu(boolean z) {
        Pair cw = ak.cw(z);
        if (cw.first == a.fhF && cw.second == null && !z) {
            e.post(new 1(this), "AppBrand$checkLibUnbrokenOrDownload_releaseLib(false)");
        }
        if (cw.second != null && ((WxaPkgWrappingInfo) cw.second).fih == 999) {
            ((WxaPkgWrappingInfo) cw.second).fii = 0;
        }
        return (WxaPkgWrappingInfo) cw.second;
    }
}
