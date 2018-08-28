package com.tencent.mm.plugin.appbrand.ipc;

import android.os.IBinder;
import android.os.IBinder.DeathRecipient;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService.2;
import com.tencent.mm.sdk.platformtools.x;

class AppBrandMainProcessService$2$1 implements DeathRecipient {
    final /* synthetic */ String dmp;
    final /* synthetic */ IBinder fDO;
    final /* synthetic */ 2 fDP;

    AppBrandMainProcessService$2$1(2 2, IBinder iBinder, String str) {
        this.fDP = 2;
        this.fDO = iBinder;
        this.dmp = str;
    }

    public final void binderDied() {
        this.fDO.unlinkToDeath((DeathRecipient) AppBrandMainProcessService.b(this.fDP.fDN).get(this.dmp), 0);
        AppBrandMainProcessService.b(this.fDP.fDN).remove(this.dmp);
        AppBrandMainProcessService.ahs();
        x.e("MicroMsg.AppBrandMainProcessService", "Client Process Died: %s", new Object[]{this.dmp});
    }
}
