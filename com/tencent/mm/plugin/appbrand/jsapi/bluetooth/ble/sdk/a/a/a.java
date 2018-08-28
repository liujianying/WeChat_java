package com.tencent.mm.plugin.appbrand.jsapi.bluetooth.ble.sdk.a.a;

import android.annotation.TargetApi;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.ble.sdk.c.j;

@TargetApi(18)
public final class a extends com.tencent.mm.plugin.appbrand.jsapi.bluetooth.ble.sdk.c.a {
    public final void aiu() {
        if (this.fMb.fLV == null) {
            com.tencent.mm.plugin.appbrand.jsapi.bluetooth.ble.sdk.d.a.e("MicroMsg.Ble.Action", "connection is not open.", new Object[0]);
            a(j.fMD);
            done();
            return;
        }
        this.fMb.cM(true);
        a(j.fMv);
        done();
    }

    public final String getName() {
        return "CloseAction";
    }
}
