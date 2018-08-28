package com.tencent.mm.plugin.appbrand.ipc;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.Binder;
import android.os.IBinder;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.x;

class AppBrandMainProcessService$4 implements ServiceConnection {
    AppBrandMainProcessService$4() {
    }

    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        AppBrandMainProcessService.a(c$a.G(iBinder));
        AppBrandMainProcessService.ahu();
        AppBrandMainProcessService.aht();
        try {
            AppBrandMainProcessService.ahv().a(new Binder(), ad.getProcessName());
        } catch (Exception e) {
            x.e("MicroMsg.AppBrandMainProcessService", "onServiceConnected, registerDeathRecipient, %s", new Object[]{e});
        }
        x.i("MicroMsg.AppBrandMainProcessService", "onServiceConnected(%s)", new Object[]{ad.getProcessName()});
    }

    public final void onServiceDisconnected(ComponentName componentName) {
        AppBrandMainProcessService.a(null);
        AppBrandMainProcessService.ahs();
        AppBrandMainProcessService.ahr();
        x.i("MicroMsg.AppBrandMainProcessService", "onServiceDisconnected(%s)", new Object[]{ad.getProcessName()});
    }
}
