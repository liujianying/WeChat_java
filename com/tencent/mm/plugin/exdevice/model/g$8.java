package com.tencent.mm.plugin.exdevice.model;

import com.tencent.mm.plugin.exdevice.jni.Java2CExDevice;
import com.tencent.mm.sdk.platformtools.x;

class g$8 implements Runnable {
    final /* synthetic */ g iuX;

    g$8(g gVar) {
        this.iuX = gVar;
    }

    public final void run() {
        x.i("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "releaseWCLanDeviceLib...");
        Java2CExDevice.releaseWCLanDeviceLib();
    }
}
