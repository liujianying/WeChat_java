package com.tencent.mm.plugin.h.a.d;

import com.tencent.mm.plugin.h.a.c.a.a;
import com.tencent.mm.plugin.h.a.d.b.d;
import com.tencent.mm.plugin.h.a.d.b.f;
import com.tencent.mm.plugin.h.a.d.b.h;
import com.tencent.mm.plugin.h.a.d.b.i;
import com.tencent.mm.plugin.h.a.d.b.j;
import com.tencent.mm.sdk.platformtools.x;
import junit.framework.Assert;

class b$a extends a {
    final /* synthetic */ b hji;

    b$a(b bVar) {
        this.hji = bVar;
    }

    public final void b(long j, long j2, long j3) {
        x.i("MicroMsg.exdevice.BluetoothSDKManager", "***BC onSessionCreate*** sessionID = " + j + " deviceID = " + j2);
        Assert.assertTrue(b.a(this.hji, 6, 1, new d(j, j2, j3)));
    }

    public final void atO() {
        x.i("MicroMsg.exdevice.BluetoothSDKManager", "***BC onDiscoverFinished***");
        this.hji.hjh.clear();
        Assert.assertTrue(b.a(this.hji, 2, 1, null));
    }

    public final void bW(String str, String str2) {
        int i;
        b bVar = this.hji;
        if (str == null) {
            x.e("MicroMsg.exdevice.BluetoothSDKManager", "null == aDeviceMac");
            i = 0;
        } else if (bVar.hjh.contains(str)) {
            i = 0;
        } else {
            bVar.hjh.add(str);
            i = 1;
        }
        if (i != 0) {
            x.i("MicroMsg.exdevice.BluetoothSDKManager", "***BC onDiscover*** deviceMac = " + str + "deviceName = " + str2);
            Assert.assertTrue(b.a(this.hji, 3, 1, new i(str, str2, 0, null)));
        }
    }

    public final void i(long j, boolean z) {
        x.i("MicroMsg.exdevice.BluetoothSDKManager", "***BC onConnected*** SessionId = " + j + " Connected = " + z);
        Assert.assertTrue(b.a(this.hji, 4, 1, new f(j, z)));
    }

    public final void b(long j, byte[] bArr) {
        x.i("MicroMsg.exdevice.BluetoothSDKManager", "***BC onRecv*** sessionId = " + j);
        Assert.assertTrue(b.a(this.hji, 1, 1, new h(j, bArr)));
    }

    public final void j(long j, boolean z) {
        x.i("MicroMsg.exdevice.BluetoothSDKManager", "***BC onSend*** SessionId = " + j + " success = " + z);
        Assert.assertTrue(b.a(this.hji, 0, 1, new j(j, z)));
    }

    public final void b(long j, int i, String str) {
        x.i("MicroMsg.exdevice.BluetoothSDKManager", "***BC onError*** SessionId = " + j + " errorCode = " + i + " errorInfo = " + str);
        Assert.assertTrue(b.a(this.hji, 5, 1, new b$g(j, i, str)));
    }
}
