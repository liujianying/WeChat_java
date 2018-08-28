package com.tencent.mm.plugin.appbrand.launching;

import com.tencent.mm.plugin.appbrand.appcache.base.WxaPkgLoadProgress;

public abstract class RuntimeLoadModuleTask {
    public final LoadParams ggL;

    public abstract void b(WxaPkgLoadProgress wxaPkgLoadProgress);

    public abstract void un(String str);

    public RuntimeLoadModuleTask(String str, int i, int i2, String str2) {
        this.ggL = new LoadParams(str, i, i2, str2, (byte) 0);
    }
}
