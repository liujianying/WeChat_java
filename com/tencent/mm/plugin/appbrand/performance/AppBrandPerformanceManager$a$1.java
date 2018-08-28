package com.tencent.mm.plugin.appbrand.performance;

import com.tencent.mm.plugin.appbrand.jsapi.storage.JsApiGetStorageInfoTask;
import com.tencent.mm.plugin.appbrand.performance.AppBrandPerformanceManager.a;
import com.tencent.mm.sdk.platformtools.bi;

class AppBrandPerformanceManager$a$1 implements Runnable {
    final /* synthetic */ JsApiGetStorageInfoTask fZp;
    final /* synthetic */ a gpz;

    AppBrandPerformanceManager$a$1(a aVar, JsApiGetStorageInfoTask jsApiGetStorageInfoTask) {
        this.gpz = aVar;
        this.fZp = jsApiGetStorageInfoTask;
    }

    public final void run() {
        AppBrandPerformanceManager.o(this.gpz.mAppId, 401, bi.bF((long) this.fZp.size));
        this.fZp.ahB();
    }
}
