package com.tencent.mm.plugin.exdevice.model;

import android.os.Bundle;
import com.tencent.mm.g.a.ds;
import com.tencent.mm.sdk.platformtools.x;

public final class a extends com.tencent.mm.plugin.exdevice.service.n.a {
    private static final a isW = new a();

    private a() {
    }

    public static a aGJ() {
        return isW;
    }

    public final Bundle k(int i, Bundle bundle) {
        x.i("MicroMsg.exdevice.ExDeviceInvokerHandler", "onExdeviceInvoke, action code = %d", Integer.valueOf(i));
        if (bundle != null) {
            switch (i) {
                case 0:
                    if (bundle != null) {
                        int i2 = bundle.getInt("key_state");
                        x.i("MicroMsg.exdevice.ExDeviceInvokerHandler", "handleOnBluetoothStateChange, state = %d", Integer.valueOf(i2));
                        if (-1 != i2) {
                            ds dsVar = new ds();
                            dsVar.bLC.bLD = i2;
                            if (!com.tencent.mm.sdk.b.a.sFg.m(dsVar)) {
                                x.e("MicroMsg.exdevice.ExDeviceInvokerHandler", "EventCenter.instance.publish failed!!!");
                                break;
                            }
                        }
                        x.e("MicroMsg.exdevice.ExDeviceInvokerHandler", "invalid state, just leave!!!");
                        break;
                    }
                    x.e("MicroMsg.exdevice.ExDeviceInvokerHandler", "null == aData");
                    break;
                    break;
            }
        }
        x.e("MicroMsg.exdevice.ExDeviceInvokerHandler", "null == aData");
        return null;
    }
}
