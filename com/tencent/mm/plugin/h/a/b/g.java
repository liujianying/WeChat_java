package com.tencent.mm.plugin.h.a.b;

import android.annotation.TargetApi;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothManager;
import android.bluetooth.le.BluetoothLeScanner;
import android.bluetooth.le.ScanCallback;
import android.bluetooth.le.ScanResult;
import android.content.Context;
import com.tencent.mm.plugin.exdevice.j.b;
import com.tencent.mm.plugin.h.a.e.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;
import java.util.List;

@TargetApi(21)
public final class g extends ScanCallback {
    private static g hgH;
    private BluetoothAdapter heY;
    private ArrayList<a> hfT;
    private boolean hfU;
    private BluetoothManager hgI;
    private BluetoothLeScanner hgJ;
    private Context mContext;
    ag mHandler;

    static /* synthetic */ boolean a(g gVar, boolean z, a aVar) {
        boolean z2;
        if (gVar.mContext == null) {
            x.e("MicroMsg.exdevice.NewBluetoothLEScanner", "not found context");
            z2 = false;
        } else {
            z2 = gVar.mContext.getPackageManager().hasSystemFeature("android.hardware.bluetooth_le");
        }
        if (z2) {
            if (gVar.hgJ == null) {
                gVar.heY = gVar.hgI.getAdapter();
                if (gVar.heY != null) {
                    x.d("MicroMsg.exdevice.NewBluetoothLEScanner", "Get bluetoothLeScanner");
                    gVar.hgJ = gVar.heY.getBluetoothLeScanner();
                    if (gVar.hgJ == null) {
                        return false;
                    }
                }
                x.e("MicroMsg.exdevice.NewBluetoothLEScanner", "not found BluetoothScannner");
                return false;
            }
            if (!a.atY()) {
                x.i("MicroMsg.exdevice.NewBluetoothLEScanner", "Bluetooth state off");
            } else if (z) {
                x.d("MicroMsg.exdevice.NewBluetoothLEScanner", "start scan");
                if (gVar.hfU) {
                    x.w("MicroMsg.exdevice.NewBluetoothLEScanner", "ble has scan. just add callback and return");
                    gVar.a(aVar);
                } else {
                    gVar.hgJ.startScan(gVar);
                    gVar.a(aVar);
                    gVar.hfU = true;
                }
            } else if (gVar.hfU) {
                if (aVar == null) {
                    x.e("MicroMsg.exdevice.NewBluetoothLEScanner", "callback is null");
                } else {
                    x.d("MicroMsg.exdevice.NewBluetoothLEScanner", "remove callback " + gVar.hfT.remove(aVar));
                }
                if (gVar.hfT.size() <= 0) {
                    x.d("MicroMsg.exdevice.NewBluetoothLEScanner", "stop scan");
                    gVar.hgJ.stopScan(gVar);
                    gVar.hfU = false;
                }
            } else {
                x.w("MicroMsg.exdevice.NewBluetoothLEScanner", "scan haven't started. just return, callback size = %d", new Object[]{Integer.valueOf(gVar.hfT.size())});
            }
            return true;
        }
        x.e("MicroMsg.exdevice.NewBluetoothLEScanner", "this phone is not support BLE");
        return false;
    }

    public static g atU() {
        if (hgH != null) {
            return hgH;
        }
        g gVar = new g(ad.getContext());
        hgH = gVar;
        return gVar;
    }

    private g(Context context) {
        if (context == null) {
            x.e("MicroMsg.exdevice.NewBluetoothLEScanner", "No context for scanner");
            return;
        }
        this.mContext = context;
        this.hfT = new ArrayList();
        this.hfU = false;
        this.heY = null;
        this.hgJ = null;
        this.mHandler = null;
        this.hgI = (BluetoothManager) this.mContext.getSystemService("bluetooth");
        this.heY = this.hgI.getAdapter();
        if (this.heY != null) {
            x.d("MicroMsg.exdevice.NewBluetoothLEScanner", "Get bluetoothLeScanner");
            this.hgJ = this.heY.getBluetoothLeScanner();
        }
        this.mHandler = new ag(new ah("NewBluetoothLEScannerThread").lnJ.getLooper());
    }

    private boolean a(a aVar) {
        boolean z = false;
        if (aVar == null) {
            x.e("MicroMsg.exdevice.NewBluetoothLEScanner", "callback is null");
            return false;
        }
        int i;
        while (true) {
            i = z;
            if (i >= this.hfT.size()) {
                i = -1;
                break;
            } else if (((a) this.hfT.get(i)) == aVar) {
                break;
            } else {
                z = i + 1;
            }
        }
        if (i < 0) {
            z = this.hfT.add(aVar);
            x.d("MicroMsg.exdevice.NewBluetoothLEScanner", "add callback " + z);
            return z;
        }
        x.w("MicroMsg.exdevice.NewBluetoothLEScanner", "callback has in queue. pass");
        return true;
    }

    public final void onScanFailed(int i) {
        this.mHandler.post(new 3(this, i));
    }

    public final void onScanResult(int i, ScanResult scanResult) {
        if (scanResult != null && scanResult.getScanRecord() != null) {
            x.d("MicroMsg.exdevice.NewBluetoothLEScanner", "onLeScan. device addr = %s, name = %s, data = %s", new Object[]{scanResult.getDevice().getAddress(), scanResult.getDevice().getName(), b.aq(scanResult.getScanRecord().getBytes())});
            x.d("MicroMsg.exdevice.NewBluetoothLEScanner", "callback size = %d", new Object[]{Integer.valueOf(this.hfT.size())});
            this.mHandler.post(new 2(this, scanResult.getDevice(), scanResult.getRssi(), scanResult.getScanRecord().getBytes()));
        }
    }

    public final void onBatchScanResults(List<ScanResult> list) {
        if (list != null) {
            for (ScanResult scanResult : list) {
                x.d("MicroMsg.exdevice.NewBluetoothLEScanner", "onLeScan. device addr = %s, name = %s, data = %s", new Object[]{scanResult.getDevice().getAddress(), scanResult.getDevice().getName(), b.aq(scanResult.getScanRecord().getBytes())});
            }
        }
    }
}
