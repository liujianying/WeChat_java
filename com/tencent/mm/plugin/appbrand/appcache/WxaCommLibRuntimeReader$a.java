package com.tencent.mm.plugin.appbrand.appcache;

import java.io.InputStream;

final class WxaCommLibRuntimeReader$a implements WxaCommLibRuntimeReader$c {
    static final WxaCommLibRuntimeReader$a fgA = new WxaCommLibRuntimeReader$a();
    final WxaPkgWrappingInfo fgz;

    public final InputStream openRead(String str) {
        return af.openRead(str);
    }

    public final WxaPkgWrappingInfo abQ() {
        return this.fgz;
    }

    WxaCommLibRuntimeReader$a() {
        this.fgz = new WxaPkgWrappingInfo();
        this.fgz.fik = true;
        this.fgz.fih = 0;
        this.fgz.fii = af.VERSION;
        this.fgz.bKg = "";
    }

    public final String toString() {
        return "AssetReader";
    }
}
