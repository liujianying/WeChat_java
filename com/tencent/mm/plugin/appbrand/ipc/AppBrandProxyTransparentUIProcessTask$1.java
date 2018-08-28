package com.tencent.mm.plugin.appbrand.ipc;

import android.content.Intent;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity.a;

class AppBrandProxyTransparentUIProcessTask$1 implements a {
    final /* synthetic */ AppBrandProxyTransparentUIProcessTask fEm;

    AppBrandProxyTransparentUIProcessTask$1(AppBrandProxyTransparentUIProcessTask appBrandProxyTransparentUIProcessTask) {
        this.fEm = appBrandProxyTransparentUIProcessTask;
    }

    public final void b(int i, int i2, Intent intent) {
        if (i == (this.fEm.hashCode() & 65535) && intent != null) {
            AppBrandProxyTransparentUIProcessTask appBrandProxyTransparentUIProcessTask = (AppBrandProxyTransparentUIProcessTask) intent.getParcelableExtra("task_object");
            AppBrandProxyTransparentUIProcessTask te = AppBrandProxyTransparentUIProcessTask.te(intent.getStringExtra("task_id"));
            if (te == null) {
                x.e("MicroMsg.AppBrandProxyTransparentUIProcessTask", "task is null");
                return;
            }
            AppBrandProxyTransparentUIProcessTask.a(appBrandProxyTransparentUIProcessTask, te);
            te.ahB();
            te.aaj();
            this.fEm.mContext = null;
        }
    }
}
