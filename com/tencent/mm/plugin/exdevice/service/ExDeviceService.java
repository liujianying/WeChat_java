package com.tencent.mm.plugin.exdevice.service;

import android.app.Service;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.IBinder;
import android.os.Process;
import com.tencent.mm.plugin.exdevice.jni.Java2CExDevice;
import com.tencent.mm.plugin.exdevice.service.h.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.x;

public class ExDeviceService extends Service {
    private a iyD = null;

    public void onCreate() {
        x.i("MicroMsg.exdevice.ExDeviceService", "ExDeviceService onCreate");
        super.onCreate();
    }

    public void onDestroy() {
        x.i("MicroMsg.exdevice.ExDeviceService", "ExDeviceService onDestroy");
        Java2CExDevice.closeBluetoothAccessoryLib();
        super.onDestroy();
        if (!aHv()) {
            x.i("MicroMsg.exdevice.ExDeviceService", "kill exdevice process now");
            Process.killProcess(Process.myPid());
        }
    }

    private static boolean aHv() {
        boolean z;
        PackageManager packageManager = ad.getContext().getPackageManager();
        try {
            packageManager.getPackageInfo("com.google.android.wearable.app.cn", 1);
            packageManager.getPackageInfo("com.google.android.wearable.app", 1);
            z = true;
        } catch (NameNotFoundException e) {
            z = false;
        }
        x.i("MicroMsg.exdevice.ExDeviceService", "isInstallWearApp %b", new Object[]{Boolean.valueOf(z)});
        return z;
    }

    public IBinder onBind(Intent intent) {
        x.i("MicroMsg.exdevice.ExDeviceService", "ExDeviceService onBind");
        if (this.iyD == null) {
            this.iyD = new y();
        }
        return this.iyD;
    }
}
