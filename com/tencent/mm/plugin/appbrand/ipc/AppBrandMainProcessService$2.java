package com.tencent.mm.plugin.appbrand.ipc;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Message;
import com.tencent.mm.sdk.platformtools.x;

class AppBrandMainProcessService$2 extends c$a {
    final /* synthetic */ AppBrandMainProcessService fDN;

    AppBrandMainProcessService$2(AppBrandMainProcessService appBrandMainProcessService) {
        this.fDN = appBrandMainProcessService;
    }

    public final void s(Bundle bundle) {
        Message obtain = Message.obtain();
        obtain.setData(bundle);
        AppBrandMainProcessService.a(this.fDN).send(obtain);
    }

    public final void t(Bundle bundle) {
        AppBrandMainProcessService.b(bundle, false).aai();
    }

    public final void a(IBinder iBinder, String str) {
        1 1 = new 1(this, iBinder, str);
        try {
            iBinder.linkToDeath(1, 0);
            AppBrandMainProcessService.b(this.fDN).put(str, 1);
            AppBrandMainProcessService.aht();
        } catch (Exception e) {
            x.e("MicroMsg.AppBrandMainProcessService", "registerDeathRecipient: %s", new Object[]{e});
        }
    }
}
