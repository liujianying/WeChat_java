package com.tencent.mm.plugin.exdevice.service;

import com.tencent.mm.plugin.exdevice.service.y.c;
import com.tencent.mm.plugin.exdevice.service.y.f;
import com.tencent.mm.plugin.exdevice.service.y.g;
import com.tencent.mm.plugin.exdevice.service.y.h;
import com.tencent.mm.plugin.h.a.b.e.a;
import com.tencent.mm.sdk.platformtools.x;

class y$1 extends a {
    final /* synthetic */ y izl;

    y$1(y yVar) {
        this.izl = yVar;
    }

    public final void a(long j, boolean z, long j2) {
        String str = "MicroMsg.exdevice.RemoteBTDeviceAdapter";
        String str2 = "onConnected. seesionId=%d, connected=%s, profileType=%d";
        Object[] objArr = new Object[3];
        objArr[0] = Long.valueOf(j);
        objArr[1] = z ? "true" : "false";
        objArr[2] = Long.valueOf(j2);
        x.d(str, str2, objArr);
        c cVar = new c((byte) 0);
        cVar.hjj = j;
        cVar.iym = z ? 2 : 4;
        cVar.iyl = 1;
        cVar.isA = 0;
        cVar.hgC = j2;
        if (!y.a(this.izl).sendMessage(y.a(this.izl).obtainMessage(9, cVar))) {
            x.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "mHandler.sendMessage failed!!!, message what = %d", new Object[]{Integer.valueOf(9)});
        }
    }

    public final void b(long j, byte[] bArr) {
        f fVar = new f((byte) 0);
        fVar.ivA = j;
        fVar.hfA = bArr;
        if (!y.a(this.izl).sendMessage(y.a(this.izl).obtainMessage(12, fVar))) {
            x.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "mHandler.sendMessage failed!!!, message what = %d", new Object[]{Integer.valueOf(12)});
        }
    }

    public final void j(long j, boolean z) {
        String str = "MicroMsg.exdevice.RemoteBTDeviceAdapter";
        String str2 = "onSend. sessionId=%d, success=%s";
        Object[] objArr = new Object[2];
        objArr[0] = Long.valueOf(j);
        objArr[1] = z ? "true" : "false";
        x.d(str, str2, objArr);
        h hVar = new h((byte) 0);
        hVar.ivA = j;
        if (z) {
            hVar.isM = 0;
            hVar.isA = 0;
        } else {
            hVar.isM = -1;
            hVar.isA = -1;
        }
        hVar.fGO = "";
        if (!y.a(this.izl).sendMessage(y.a(this.izl).obtainMessage(11, hVar))) {
            x.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "mHandler.sendMessage failed!!!, message what = %d", new Object[]{Integer.valueOf(11)});
        }
    }

    public final void a(String str, String str2, int i, byte[] bArr) {
        x.d("MicroMsg.exdevice.RemoteBTDeviceAdapter", "onDiscover. deviceMac=%s, deviceName=%s", new Object[]{str, str2});
        g gVar = new g((byte) 0);
        gVar.izp = false;
        gVar.hjn = str;
        gVar.fNv = str2;
        gVar.fNP = i;
        gVar.izq = bArr;
        if (!y.a(this.izl).sendMessage(y.a(this.izl).obtainMessage(13, gVar))) {
            x.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "mHandler.sendMessage failed!!!, message what = %d", new Object[]{Integer.valueOf(13)});
        }
    }

    public final void atO() {
        x.d("MicroMsg.exdevice.RemoteBTDeviceAdapter", "onDiscoverFinished");
        g gVar = new g((byte) 0);
        gVar.izp = true;
        gVar.hjn = null;
        gVar.fNv = null;
        gVar.fNP = 0;
        gVar.izq = null;
        if (!y.a(this.izl).sendMessage(y.a(this.izl).obtainMessage(13, gVar))) {
            x.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "mHandler.sendMessage failed!!!, message what = %d", new Object[]{Integer.valueOf(13)});
        }
    }
}
