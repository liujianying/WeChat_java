package com.tencent.mm.plugin.appbrand.ipc;

import android.content.Intent;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyTransparentUIProcessTask.a;
import com.tencent.mm.sdk.platformtools.x;

class AppBrandProxyTransparentUI$1 implements a {
    final /* synthetic */ AppBrandProxyTransparentUIProcessTask fEf;
    final /* synthetic */ String fEg;
    final /* synthetic */ AppBrandProxyTransparentUI fEh;

    AppBrandProxyTransparentUI$1(AppBrandProxyTransparentUI appBrandProxyTransparentUI, AppBrandProxyTransparentUIProcessTask appBrandProxyTransparentUIProcessTask, String str) {
        this.fEh = appBrandProxyTransparentUI;
        this.fEf = appBrandProxyTransparentUIProcessTask;
        this.fEg = str;
    }

    public final void ahz() {
        x.i("MicroMsg.AppBrandProxyTransparentUI", "onResult");
        Intent intent = new Intent();
        intent.putExtra("task_object", this.fEf);
        intent.putExtra("task_id", this.fEg);
        this.fEh.setResult(-1, intent);
        this.fEh.finish();
    }
}
