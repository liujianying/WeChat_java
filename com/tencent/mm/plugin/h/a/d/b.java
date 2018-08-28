package com.tencent.mm.plugin.h.a.d;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothManager;
import android.content.Context;
import android.content.IntentFilter;
import android.os.Build.VERSION;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.plugin.exdevice.service.v;
import com.tencent.mm.plugin.h.a.b.c;
import com.tencent.mm.plugin.h.a.b.g;
import com.tencent.mm.plugin.h.a.c.a;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.x;
import java.util.HashSet;
import junit.framework.Assert;

public final class b {
    public com.tencent.mm.plugin.h.a.b.b hje = null;
    public a hjf = null;
    c hjg = null;
    final HashSet<String> hjh = new HashSet();
    private ag mHandler = null;

    public b(Context context, c cVar, ah ahVar) {
        this.hjf = new a(ahVar);
        if (VERSION.SDK_INT >= 18) {
            this.hje = new com.tencent.mm.plugin.h.a.b.b(ahVar);
            com.tencent.mm.plugin.h.a.b.b bVar = this.hje;
            b bVar2 = new b(this);
            x.i("MicroMsg.exdevice.BluetoothLEManager", "------init------");
            Assert.assertNotNull(context);
            Assert.assertNotNull(bVar2);
            if (!bVar.mIsInit) {
                bVar.mIsInit = true;
                bVar.rc = context;
                bVar.hfE = bVar2;
                bVar.hfH = c.atP();
                if (d.fR(21)) {
                    bVar.hfI = g.atU();
                }
                if (bVar.atN()) {
                    bVar.heY = ((BluetoothManager) bVar.rc.getSystemService("bluetooth")).getAdapter();
                } else {
                    x.w("MicroMsg.exdevice.BluetoothLEManager", "BLE Unsupport!!!");
                }
            }
        }
        a aVar = this.hjf;
        a aVar2 = new a(this);
        x.i("MicroMsg.exdevice.BluetoothChatManager", "------init------");
        Assert.assertNotNull(context);
        Assert.assertNotNull(aVar2);
        if (!aVar.mIsInit) {
            aVar.mIsInit = true;
            aVar.hiH = aVar2;
            aVar.hiI = context;
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.bluetooth.adapter.action.DISCOVERY_FINISHED");
            intentFilter.addAction("android.bluetooth.device.action.FOUND");
            intentFilter.addAction("android.bluetooth.adapter.action.SCAN_MODE_CHANGED");
            intentFilter.addAction("android.bluetooth.device.action.ACL_DISCONNECTED");
            aVar.hiI.registerReceiver(aVar.hiJ, intentFilter);
            aVar.heY = BluetoothAdapter.getDefaultAdapter();
        }
        this.mHandler = new c(v.aHH().egm.lnJ.getLooper(), this);
        this.hjg = cVar;
    }

    public final boolean a(int i, int... iArr) {
        x.i("MicroMsg.exdevice.BluetoothSDKManager", "---scan--- aBluetoothVersion = " + i);
        switch (i) {
            case 0:
                if (this.hje == null) {
                    x.e("MicroMsg.exdevice.BluetoothSDKManager", "mMrgBLE == null");
                    return false;
                } else if (iArr == null) {
                    return this.hje.a(true, new int[0]);
                } else {
                    return this.hje.a(true, iArr);
                }
            case 1:
                if (this.hjf != null) {
                    return this.hjf.dJ(true);
                }
                x.e("MicroMsg.exdevice.BluetoothSDKManager", "mMrgBC == null");
                return false;
            default:
                Assert.assertTrue(false);
                return false;
        }
    }

    public final void b(long j, long j2, int i) {
        x.i("MicroMsg.exdevice.BluetoothSDKManager", "***createSession*** deviceId = " + j + "aBluetoothVersion = " + i);
        switch (i) {
            case 0:
                if (this.hje == null) {
                    x.e("MicroMsg.exdevice.BluetoothSDKManager", "mMrgBLE == null");
                    return;
                }
                com.tencent.mm.plugin.h.a.b.b bVar = this.hje;
                x.i("MicroMsg.exdevice.BluetoothLEManager", "------createSession------ macAddr = %d channelId = %d", new Object[]{Long.valueOf(j), Long.valueOf(j2)});
                Assert.assertTrue(bVar.mIsInit);
                if (bVar.atN()) {
                    Assert.assertTrue(bVar.mHandler.post(new b$b(bVar, j, j2)));
                    return;
                } else {
                    x.e("MicroMsg.exdevice.BluetoothLEManager", "BLE Unsupport");
                    return;
                }
            case 1:
                if (this.hjf == null) {
                    x.e("MicroMsg.exdevice.BluetoothSDKManager", "mMrgBC == null");
                    return;
                }
                a aVar = this.hjf;
                x.i("MicroMsg.exdevice.BluetoothChatManager", "createSession");
                Assert.assertTrue(aVar.mIsInit);
                if (aVar.atW()) {
                    Assert.assertTrue(aVar.mHandler.post(new com.tencent.mm.plugin.h.a.c.a.b(aVar, j, j2)));
                    return;
                } else {
                    x.e("MicroMsg.exdevice.BluetoothChatManager", "BC Unsupport!!!");
                    return;
                }
            default:
                Assert.assertTrue(false);
                return;
        }
    }
}
