package com.tencent.mm.plugin.appbrand.launching;

import com.tencent.mm.ipcinvoker.a;
import com.tencent.mm.ipcinvoker.c;
import com.tencent.mm.plugin.appbrand.launching.RuntimeLoadModuleTask.LoadParams;
import com.tencent.mm.plugin.appbrand.launching.RuntimeLoadModuleTask.WxaPkgResultProgressPair;

final class RuntimeLoadModuleTask$a implements a<LoadParams, WxaPkgResultProgressPair> {
    private c<WxaPkgResultProgressPair> dmE = null;

    private RuntimeLoadModuleTask$a() {
    }

    public final /* synthetic */ void a(Object obj, c cVar) {
        LoadParams loadParams = (LoadParams) obj;
        this.dmE = cVar;
        j f = j.a.f(loadParams.appId, loadParams.fgp, loadParams.bPh, loadParams.fii);
        f.a(new 1(this));
        f.a(new 2(this));
        f.prepareAsync();
    }
}
