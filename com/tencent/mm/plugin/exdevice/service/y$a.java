package com.tencent.mm.plugin.exdevice.service;

import android.os.Looper;
import android.os.Message;
import com.tencent.mm.plugin.exdevice.service.y.b;
import com.tencent.mm.plugin.exdevice.service.y.d;
import com.tencent.mm.plugin.exdevice.service.y.e;
import com.tencent.mm.plugin.exdevice.service.y.f;
import com.tencent.mm.plugin.exdevice.service.y.g;
import com.tencent.mm.plugin.exdevice.service.y.h;
import com.tencent.mm.plugin.exdevice.service.y.i;
import com.tencent.mm.plugin.exdevice.service.y.j;
import com.tencent.mm.plugin.exdevice.service.y.k;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.x;

final class y$a extends ag {
    final /* synthetic */ y izl;

    public y$a(y yVar, Looper looper) {
        this.izl = yVar;
        super(looper);
    }

    public final void handleMessage(Message message) {
        switch (message.what) {
            case 0:
                k kVar = (k) message.obj;
                if (!y.a(this.izl, kVar.iyn, kVar.izt)) {
                    x.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "startTaskImp failed!!!");
                    return;
                }
                return;
            case 1:
                if (!y.a(this.izl, ((Long) message.obj).longValue())) {
                    x.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "stopTaskImp failed!!!");
                    return;
                }
                return;
            case 2:
                d dVar = (d) message.obj;
                y.a(this.izl, dVar.iyn, dVar.isM, dVar.isA, dVar.fGO);
                return;
            case 3:
                j jVar = (j) message.obj;
                if (!y.a(this.izl, jVar.hjj, jVar.izs, jVar.izo)) {
                    x.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "startChannelImp failed!!!");
                    return;
                }
                return;
            case 4:
                if (!y.b(this.izl, ((Long) message.obj).longValue())) {
                    x.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "stopChannelImp failed!!!");
                    return;
                }
                return;
            case 5:
                y$c y_c = (y$c) message.obj;
                y.a(this.izl, y_c.hjj, y_c.iyl, y_c.iym, y_c.isA);
                return;
            case 6:
                b bVar = (b) message.obj;
                y.a(this.izl, bVar.mErrorCode, bVar.hjj, bVar.isH, bVar.iyk, bVar.isB);
                return;
            case 7:
                e eVar = (e) message.obj;
                if (!this.izl.c(eVar.ivA, eVar.izn, eVar.izo)) {
                    x.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "simpleBTConnectImpl error");
                    return;
                }
                return;
            case 8:
                long longValue = ((Long) message.obj).longValue();
                y yVar = this.izl;
                x.d("MicroMsg.exdevice.RemoteBTDeviceAdapter", "simpleBTDisonnectImpl. mac=%d", new Object[]{Long.valueOf(longValue)});
                if (yVar.izj != null) {
                    com.tencent.mm.plugin.h.a.b.e eVar2 = yVar.izj;
                    x.d("MicroMsg.exdevice.BluetoothLESimpleManager", "disconnect. mac = %d", new Object[]{Long.valueOf(longValue)});
                    if (eVar2.atN()) {
                        eVar2.v(new e$5(eVar2, longValue));
                        return;
                    } else {
                        x.e("MicroMsg.exdevice.BluetoothLESimpleManager", "BLE Unsupport");
                        return;
                    }
                }
                return;
            case 9:
                y$c y_c2 = (y$c) message.obj;
                if (!this.izl.b(y_c2.hjj, y_c2.iyl, y_c2.iym, y_c2.isA, y_c2.hgC)) {
                    x.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "simpleBTOnSateChangeImpl error");
                    return;
                }
                return;
            case 10:
                i iVar = (i) message.obj;
                if (!this.izl.c(iVar.ivA, iVar.hfA, iVar.izr)) {
                    x.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "simpleBTSendDataImpl error");
                    return;
                }
                return;
            case 11:
                h hVar = (h) message.obj;
                if (!this.izl.e(hVar.ivA, hVar.isM, hVar.isA, hVar.fGO)) {
                    x.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "simpleBTOnSendEndImpl error");
                    return;
                }
                return;
            case 12:
                f fVar = (f) message.obj;
                this.izl.d(fVar.ivA, fVar.hfA);
                return;
            case 13:
                y.a(this.izl, (g) message.obj);
                return;
            default:
                return;
        }
    }
}
