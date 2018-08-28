package com.tencent.mm.plugin.exdevice.model;

import android.os.Looper;
import com.tencent.mm.g.a.ej;
import com.tencent.mm.plugin.exdevice.model.d.2;
import com.tencent.mm.plugin.exdevice.model.d.3;
import com.tencent.mm.plugin.exdevice.model.e.b;
import com.tencent.mm.plugin.exdevice.service.c;
import com.tencent.mm.plugin.exdevice.service.f;
import com.tencent.mm.plugin.exdevice.service.j;
import com.tencent.mm.plugin.exdevice.service.j.a;
import com.tencent.mm.plugin.exdevice.service.m;
import com.tencent.mm.plugin.exdevice.service.s$a;
import com.tencent.mm.plugin.exdevice.service.t;
import com.tencent.mm.plugin.exdevice.service.u;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.x;
import java.util.LinkedList;
import java.util.List;

public class h extends s$a {
    protected static final String TAG = h.class.getName();
    private boolean iuY = false;
    f iuZ = new f();
    private a iva = new 1(this);

    public final void aGU() {
        if (this.iuY) {
            x.d(TAG, "still scanning. return");
            return;
        }
        d aHl = ad.aHl();
        j jVar = this.iva;
        x.d("MicroMsg.exdevice.ExdeviceConnectManager", "simpleBTScan");
        if (aHl.itd == null) {
            aHl.itd = new c();
            aHl.itd.iyE = new 2(aHl, jVar);
            aHl.itd.dd(ad.getContext());
        } else if (u.aHG().isY == null) {
            x.e("MicroMsg.exdevice.ExdeviceConnectManager", "dispatcher is null.");
        } else {
            x.i("MicroMsg.exdevice.ExdeviceConnectManager", "try start scan");
            if (!u.aHG().isY.a(jVar)) {
                x.e("MicroMsg.exdevice.ExdeviceConnectManager", "scan failed!!!");
            }
        }
        this.iuY = true;
    }

    public final void atI() {
        if (this.iuY) {
            d aHl = ad.aHl();
            a aVar = this.iva;
            x.d("MicroMsg.exdevice.ExdeviceConnectManager", "simpleBTStopScan");
            if (aHl.itd == null) {
                x.i("MicroMsg.exdevice.ExdeviceConnectManager", "exdevice process is dead, just leave");
            } else if (u.aHG().isY == null) {
                x.e("MicroMsg.exdevice.ExdeviceConnectManager", "dispatcher is null.");
            } else if (!u.aHG().isY.b(aVar)) {
                x.e("MicroMsg.exdevice.ExdeviceConnectManager", "stopScan failed!!!");
            }
            this.iuY = false;
            return;
        }
        x.d(TAG, "not yet scan. return");
    }

    public final void a(long j, a aVar) {
        f.a cO = this.iuZ.cO(j);
        if (cO == null || 2 != cO.bLv) {
            d aHl = ad.aHl();
            2 2 = new 2(this, aVar);
            x.d("MicroMsg.exdevice.ExdeviceConnectManager", "simpleBTConnect");
            if (aHl.itd == null) {
                aHl.itd = new c();
                aHl.itd.iyE = new 3(aHl, j, 2);
                aHl.itd.dd(ad.getContext());
                return;
            }
            x.i("MicroMsg.exdevice.ExdeviceConnectManager", "try start connect");
            m mVar = u.aHG().isY;
            if (mVar == null || !mVar.a(j, 2)) {
                x.e("MicroMsg.exdevice.ExdeviceConnectManager", "connect failed!!!");
                return;
            }
            return;
        }
        x.d(TAG, "device(" + j + ") has been connected");
        aVar.a(j, 2, 2, 0, cO.hgC);
    }

    public static void cB(long j) {
        d aHl = ad.aHl();
        x.d("MicroMsg.exdevice.ExdeviceConnectManager", "simpleBTDisconnect");
        if (aHl.itd == null) {
            x.i("MicroMsg.exdevice.ExdeviceConnectManager", "exdevice process is dead, just leave");
        } else if (u.aHG().isY == null) {
            x.e("MicroMsg.exdevice.ExdeviceConnectManager", "dispatcher is null.");
        } else if (!u.aHG().isY.cW(j)) {
            x.e("MicroMsg.exdevice.ExdeviceConnectManager", "simpleBluetoothDisconnect failed!!!");
        }
    }

    public static boolean a(long j, byte[] bArr, t tVar) {
        boolean z = false;
        if (bArr == null || bArr.length <= 0) {
            x.e(TAG, "no data for transmit");
        } else if (u.aHG().isY == null) {
            x.e(TAG, "can not send data");
        } else {
            z = u.aHG().isY.b(j, bArr, tVar);
            if (!z) {
                x.e(TAG, "simpleBluetoothSendData error");
            }
        }
        return z;
    }

    public final void c(long j, byte[] bArr) {
        if (bArr == null || bArr.length <= 0) {
            x.e(TAG, "data is null or nil");
            return;
        }
        List<b> linkedList;
        x.d(TAG, "onDataRecv. mac=%d, data=%s", new Object[]{Long.valueOf(j), com.tencent.mm.plugin.exdevice.j.b.aq(bArr)});
        e aHp = ad.aHp();
        String cY = com.tencent.mm.plugin.exdevice.j.b.cY(j);
        synchronized (aHp.itw) {
            linkedList = new LinkedList(aHp.itw);
        }
        for (b b : linkedList) {
            b.b(cY, bArr, true);
        }
        linkedList.clear();
        for (b b2 : aHp.itx.values()) {
            b2.b(cY, bArr, true);
        }
        ej ejVar = new ej();
        ejVar.bMk.mac = cY;
        ejVar.bMk.data = bArr;
        com.tencent.mm.sdk.b.a.sFg.a(ejVar, Looper.getMainLooper());
    }
}
