package com.tencent.mm.plugin.appbrand.ipc;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

class AppBrandMainProcessService$1 extends Handler {
    final /* synthetic */ AppBrandMainProcessService fDN;

    AppBrandMainProcessService$1(AppBrandMainProcessService appBrandMainProcessService, Looper looper) {
        this.fDN = appBrandMainProcessService;
        super(looper);
    }

    public final void handleMessage(Message message) {
        AppBrandMainProcessService.b(message.getData(), true).aai();
    }
}
