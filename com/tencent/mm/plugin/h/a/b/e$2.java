package com.tencent.mm.plugin.h.a.b;

import com.tencent.mm.plugin.exdevice.j.b;
import com.tencent.mm.plugin.h.a.b.f.a;
import com.tencent.mm.sdk.platformtools.x;

class e$2 extends a {
    final /* synthetic */ e hgr;

    e$2(e eVar) {
        this.hgr = eVar;
    }

    public final void a(long j, boolean z, long j2) {
        String str = "MicroMsg.exdevice.BluetoothLESimpleManager";
        String str2 = "onConnected. mac = %s, connected = %s";
        Object[] objArr = new Object[2];
        objArr[0] = b.cY(j);
        objArr[1] = z ? "true" : "false";
        x.d(str, str2, objArr);
        this.hgr.v(new 1(this, j, z, j2));
        x.d("MicroMsg.exdevice.BluetoothLESimpleManager", "session size = %d", new Object[]{Integer.valueOf(this.hgr.hfF.size())});
    }

    public final void b(long j, byte[] bArr) {
        x.d("MicroMsg.exdevice.BluetoothLESimpleManager", "onRecv. mac = %s", new Object[]{b.cY(j)});
        if (this.hgr.hgn != null) {
            this.hgr.hgn.b(j, bArr);
        } else {
            x.w("MicroMsg.exdevice.BluetoothLESimpleManager", "no BLEManagerCallback");
        }
    }

    public final void j(long j, boolean z) {
        String str = "MicroMsg.exdevice.BluetoothLESimpleManager";
        String str2 = "onSend. mac = %s, success = %s";
        Object[] objArr = new Object[2];
        objArr[0] = b.cY(j);
        objArr[1] = z ? "true" : "false";
        x.d(str, str2, objArr);
        if (this.hgr.hgn != null) {
            this.hgr.hgn.j(j, z);
        }
    }
}
