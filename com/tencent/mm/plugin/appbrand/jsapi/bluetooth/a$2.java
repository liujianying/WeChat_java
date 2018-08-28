package com.tencent.mm.plugin.appbrand.jsapi.bluetooth;

import android.content.BroadcastReceiver;

class a$2 extends BroadcastReceiver {
    a$2() {
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onReceive(android.content.Context r8, android.content.Intent r9) {
        /*
        r7 = this;
        r0 = 1;
        r1 = 0;
        if (r9 != 0) goto L_0x000e;
    L_0x0004:
        r0 = "MicroMsg.Ble.BleManager";
        r1 = "Receive intent failed";
        com.tencent.mm.sdk.platformtools.x.i(r0, r1);
    L_0x000d:
        return;
    L_0x000e:
        r2 = android.bluetooth.BluetoothAdapter.getDefaultAdapter();
        if (r2 == 0) goto L_0x000d;
    L_0x0014:
        r2 = r2.getState();
        r3 = "MicroMsg.Ble.BleManager";
        r4 = "state:%d";
        r5 = new java.lang.Object[r0];
        r6 = java.lang.Integer.valueOf(r2);
        r5[r1] = r6;
        com.tencent.mm.sdk.platformtools.x.d(r3, r4, r5);
        r3 = 12;
        if (r2 != r3) goto L_0x005c;
    L_0x002d:
        r1 = r0;
    L_0x002e:
        r0 = com.tencent.mm.plugin.appbrand.jsapi.bluetooth.a.fLa;
        if (r0 == 0) goto L_0x0034;
    L_0x0032:
        if (r1 == 0) goto L_0x003a;
    L_0x0034:
        r0 = com.tencent.mm.plugin.appbrand.jsapi.bluetooth.a.fLa;
        if (r0 != 0) goto L_0x0061;
    L_0x0038:
        if (r1 == 0) goto L_0x0061;
    L_0x003a:
        r0 = com.tencent.mm.plugin.appbrand.jsapi.bluetooth.a.acl();
        r0 = r0.values();
        r2 = r0.iterator();
    L_0x0046:
        r0 = r2.hasNext();
        if (r0 == 0) goto L_0x0061;
    L_0x004c:
        r0 = r2.next();
        r0 = (com.tencent.mm.plugin.appbrand.jsapi.bluetooth.b) r0;
        r3 = r0.fLd;
        if (r3 == 0) goto L_0x0046;
    L_0x0056:
        r0 = r0.fLd;
        r0.cL(r1);
        goto L_0x0046;
    L_0x005c:
        r0 = 10;
        if (r2 != r0) goto L_0x002e;
    L_0x0060:
        goto L_0x002e;
    L_0x0061:
        com.tencent.mm.plugin.appbrand.jsapi.bluetooth.a.fLa = r1;
        goto L_0x000d;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.appbrand.jsapi.bluetooth.a$2.onReceive(android.content.Context, android.content.Intent):void");
    }
}
