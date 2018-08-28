package com.tencent.mm.plugin.h.a.d;

import com.tencent.mm.plugin.h.a.b.b.a;
import com.tencent.mm.plugin.h.a.d.b.h;
import com.tencent.mm.plugin.h.a.d.b.i;
import com.tencent.mm.plugin.h.a.d.b.j;
import com.tencent.mm.sdk.platformtools.x;
import junit.framework.Assert;

class b$b extends a {
    final /* synthetic */ b hji;

    b$b(b bVar) {
        this.hji = bVar;
    }

    public final void b(long j, long j2, long j3) {
        x.i("MicroMsg.exdevice.BluetoothSDKManager", "***BLE onSessionCreate*** sessionID = " + j + " deviceID = " + j2);
        Assert.assertTrue(b.a(this.hji, 6, 0, new b$d(j, j2, j3)));
    }

    public final void atO() {
        x.i("MicroMsg.exdevice.BluetoothSDKManager", "***BLE onDiscoverFinished***");
        this.hji.hjh.clear();
        Assert.assertTrue(b.a(this.hji, 2, 0, null));
    }

    public final void a(String str, String str2, int i, byte[] bArr) {
        x.d("MicroMsg.exdevice.BluetoothSDKManager", "---BLE onDiscover---, %s, %s", new Object[]{str, str2});
        Assert.assertTrue(b.a(this.hji, 3, 0, new i(str, str2, i, bArr)));
    }

    public final void i(long j, boolean z) {
        x.i("MicroMsg.exdevice.BluetoothSDKManager", "***BLE onConnected*** SessionId = " + j + " Connected = " + z);
        Assert.assertTrue(b.a(this.hji, 4, 0, new b$f(j, z)));
    }

    public final void b(long j, byte[] bArr) {
        x.i("MicroMsg.exdevice.BluetoothSDKManager", "***BLE onRecv*** sessionId = " + j);
        Assert.assertTrue(b.a(this.hji, 1, 0, new h(j, bArr)));
    }

    public final void j(long j, boolean z) {
        x.i("MicroMsg.exdevice.BluetoothSDKManager", "***BLE onSend*** SessionId = " + j + " success = " + z);
        Assert.assertTrue(b.a(this.hji, 0, 0, new j(j, z)));
    }
}
