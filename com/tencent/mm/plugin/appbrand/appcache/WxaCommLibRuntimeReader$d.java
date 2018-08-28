package com.tencent.mm.plugin.appbrand.appcache;

import java.io.InputStream;
import java.util.Locale;

final class WxaCommLibRuntimeReader$d implements WxaCommLibRuntimeReader$c {
    private final ag fgC;
    private final WxaPkgWrappingInfo fgz;

    /* synthetic */ WxaCommLibRuntimeReader$d(WxaPkgWrappingInfo wxaPkgWrappingInfo, byte b) {
        this(wxaPkgWrappingInfo);
    }

    private WxaCommLibRuntimeReader$d(WxaPkgWrappingInfo wxaPkgWrappingInfo) {
        this.fgz = wxaPkgWrappingInfo;
        this.fgC = new ag(wxaPkgWrappingInfo.ffK);
    }

    public final InputStream openRead(String str) {
        this.fgC.abW();
        return this.fgC.qN(str);
    }

    public final WxaPkgWrappingInfo abQ() {
        return this.fgz;
    }

    public final String toString() {
        return String.format(Locale.US, "PkgReader[%d]", new Object[]{Integer.valueOf(this.fgz.fii)});
    }
}
