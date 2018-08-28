package com.tencent.mm.plugin.exdevice.service;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.tencent.mm.model.au;
import com.tencent.mm.plugin.exdevice.service.h.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public final class c implements ServiceConnection {
    public a iyE;
    public volatile boolean iyF;
    private List<Runnable> iyG = new LinkedList();

    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        List arrayList;
        x.i("MicroMsg.exdevice.ExDeviceServiceConnection", "onServiceConnected");
        x xVar = new x(a.J(iBinder));
        u.a(xVar);
        ad.cif();
        xVar.a(com.tencent.mm.plugin.exdevice.b.a.aGy());
        xVar.b(com.tencent.mm.plugin.exdevice.model.a.aGJ());
        if (!xVar.a(com.tencent.mm.plugin.exdevice.model.ad.aHq())) {
            x.e("MicroMsg.exdevice.ExDeviceServiceConnection", "simpleBluetoothRegistOnRecv error");
        }
        if (this.iyE != null) {
            this.iyE.onServiceConnected();
        }
        this.iyF = true;
        synchronized (this.iyG) {
            arrayList = new ArrayList(this.iyG);
            this.iyG.clear();
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < arrayList.size()) {
                Runnable runnable = (Runnable) arrayList.get(i2);
                if (runnable != null) {
                    runnable.run();
                }
                i = i2 + 1;
            } else {
                arrayList.clear();
                return;
            }
        }
    }

    public final void onServiceDisconnected(ComponentName componentName) {
        x.i("MicroMsg.exdevice.ExDeviceServiceConnection", "onServiceDisconnected");
        this.iyF = false;
        u.a(null);
        ad.cif();
        if (!au.HW() || au.Dr()) {
            x.i("MicroMsg.exdevice.ExDeviceServiceConnection", "no user login, ignore this disconnection");
        } else {
            dd(ad.getContext());
        }
    }

    public final void dd(Context context) {
        if (!d.de(context)) {
            x.i("MicroMsg.exdevice.ExDeviceServiceConnection", "ensureServiceInstance return false");
        } else if (context.bindService(new Intent(context, ExDeviceService.class), this, 1)) {
            x.i("MicroMsg.exdevice.ExDeviceServiceConnection", "bind exdeviceservice success");
        } else {
            x.e("MicroMsg.exdevice.ExDeviceServiceConnection", "bind exdeviceservice failed");
        }
    }

    public final boolean x(Runnable runnable) {
        if (this.iyF) {
            runnable.run();
        } else {
            synchronized (this.iyG) {
                this.iyG.add(runnable);
            }
        }
        return true;
    }
}
