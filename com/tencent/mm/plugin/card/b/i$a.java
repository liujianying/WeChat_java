package com.tencent.mm.plugin.card.b;

import android.annotation.TargetApi;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothAdapter.LeScanCallback;
import android.bluetooth.BluetoothManager;
import android.content.BroadcastReceiver;
import android.os.Build.VERSION;
import com.tencent.mm.plugin.card.b.i.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.x;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

class i$a {
    public BroadcastReceiver fKZ;
    private BluetoothAdapter fQu;
    final /* synthetic */ i huq;
    private volatile boolean hur;
    boolean hus;
    Map<String, b> hut;
    long huu;
    Runnable huv;
    private LeScanCallback huw;

    private i$a(i iVar) {
        this.huq = iVar;
        this.hur = false;
        this.hus = false;
        this.hut = new ConcurrentHashMap();
        this.huu = 3000;
        this.huv = new 1(this);
        this.huw = new 3(this);
    }

    /* synthetic */ i$a(i iVar, byte b) {
        this(iVar);
    }

    public final void reset() {
        this.hut.clear();
    }

    public final b awR() {
        b bVar = new b("", -100, "", null);
        if (this.hut.size() <= 0) {
            return bVar;
        }
        Iterator it = this.hut.values().iterator();
        while (true) {
            b bVar2 = bVar;
            if (!it.hasNext()) {
                return bVar2;
            }
            bVar = (b) it.next();
            if (bVar2.bMF >= bVar.bMF) {
                bVar = bVar2;
            }
        }
    }

    @TargetApi(18)
    public final void awS() {
        if (VERSION.SDK_INT < 18) {
            x.i("MicroMsg.CardLbsOrBluetooth", "not support bluetooth, return");
        } else if (this.hur) {
            x.i("MicroMsg.CardLbsOrBluetooth", "already start");
        } else {
            this.hut.clear();
            BluetoothManager bluetoothManager = (BluetoothManager) ad.getContext().getSystemService("bluetooth");
            if (bluetoothManager == null) {
                this.hus = false;
                x.e("MicroMsg.CardLbsOrBluetooth", "bluetoothManager is null");
                return;
            }
            this.hus = true;
            this.fQu = bluetoothManager.getAdapter();
            if (this.fQu == null || !this.fQu.isEnabled()) {
                this.hus = false;
                x.e("MicroMsg.CardLbsOrBluetooth", "bluetoothAdapter is null or bluetoothAdapter is disable");
                return;
            }
            boolean startLeScan = this.fQu.startLeScan(this.huw);
            x.i("MicroMsg.CardLbsOrBluetooth", "startLeScan isOK:%b", new Object[]{Boolean.valueOf(startLeScan)});
            this.hur = true;
        }
    }

    @TargetApi(18)
    public final void awT() {
        if (VERSION.SDK_INT < 18) {
            x.i("MicroMsg.CardLbsOrBluetooth", "not support bluetooth, return");
        } else if (!this.hur) {
            x.i("MicroMsg.CardLbsOrBluetooth", "not start");
        } else if (this.fQu == null || !this.fQu.isEnabled()) {
            this.hus = false;
            x.e("MicroMsg.CardLbsOrBluetooth", "bluetoothAdapter is null or bluetoothAdapter is disable");
        } else {
            this.hus = true;
            this.fQu.stopLeScan(this.huw);
            x.i("MicroMsg.CardLbsOrBluetooth", "stopLeScan");
            this.hur = false;
        }
    }

    public static byte[] ah(byte[] bArr) {
        byte[] bArr2 = null;
        if (bArr != null) {
            int i = 0;
            while (i < bArr.length) {
                int i2 = i + 1;
                i = bArr[i] & 255;
                if (i != 0) {
                    i--;
                    int i3 = i2 + 1;
                    switch (bArr[i2] & 255) {
                        case 255:
                            bArr2 = new byte[i];
                            System.arraycopy(bArr, i3, bArr2, 0, i);
                            break;
                        default:
                            break;
                    }
                    i += i3;
                }
            }
        }
        return bArr2;
    }
}
