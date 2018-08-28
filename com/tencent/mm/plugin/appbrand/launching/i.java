package com.tencent.mm.plugin.appbrand.launching;

import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import java.util.concurrent.Callable;

public interface i extends Callable<WxaPkgWrappingInfo> {

    public static final class a extends Error {
        final String gfG;

        a(String str, String str2) {
            super(str);
            this.gfG = str2;
        }
    }

    void onDownloadProgress(int i);
}
