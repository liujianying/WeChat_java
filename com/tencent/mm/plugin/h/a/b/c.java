package com.tencent.mm.plugin.h.a.b;

import android.annotation.TargetApi;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothAdapter.LeScanCallback;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothManager;
import android.content.Context;
import com.tencent.mm.plugin.exdevice.j.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bd;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;
import junit.framework.Assert;

@TargetApi(18)
public final class c implements LeScanCallback {
    private static c hfS;
    private BluetoothAdapter heY;
    private ArrayList<a> hfT;
    private boolean hfU;
    private Context mContext;
    private ag mHandler;

    static /* synthetic */ boolean a(c cVar, boolean z, a aVar) {
        boolean z2;
        if (cVar.mContext == null) {
            x.e("MicroMsg.exdevice.BluetoothLEScaner", "not found context");
            z2 = false;
        } else {
            z2 = cVar.mContext.getPackageManager().hasSystemFeature("android.hardware.bluetooth_le");
        }
        if (!z2) {
            x.e("MicroMsg.exdevice.BluetoothLEScaner", "this phone is not support BLE");
            return false;
        } else if (cVar.heY == null) {
            x.e("MicroMsg.exdevice.BluetoothLEScaner", "not found BluetoothAdapter");
            return false;
        } else {
            if (z) {
                if (cVar.hfU) {
                    x.w("MicroMsg.exdevice.BluetoothLEScaner", "ble has scan. just add callback and return");
                    cVar.a(aVar);
                    return true;
                }
                x.d("MicroMsg.exdevice.BluetoothLEScaner", "start scan");
                z2 = cVar.heY.startLeScan(cVar);
                if (z2) {
                    cVar.hfU = true;
                    cVar.a(aVar);
                } else if (cVar.hfT.size() <= 0) {
                    x.e("MicroMsg.exdevice.BluetoothLEScaner", "start BLE scan failed and callbacklist size is 0,start retry,and bluetooth state is(12 is on ,10 is off): " + cVar.heY.getState());
                    int i = 0;
                    while (!z2 && i < 3) {
                        cVar.heY.stopLeScan(cVar);
                        cVar.hfU = false;
                        x.e("MicroMsg.exdevice.BluetoothLEScaner", "start BLE scan failed,retry no " + i + " time");
                        z2 = cVar.heY.startLeScan(cVar);
                        if (z2) {
                            cVar.hfU = true;
                            cVar.a(aVar);
                        }
                        i++;
                    }
                    return z2;
                } else if (cVar.heY.getState() == 12) {
                    x.e("MicroMsg.exdevice.BluetoothLEScaner", "start BLE scan failed when bluetooth state is on.");
                    cVar.hfU = true;
                    cVar.a(aVar);
                    z2 = true;
                } else {
                    x.e("MicroMsg.exdevice.BluetoothLEScaner", "start BLE scan failed");
                }
            } else if (cVar.hfU) {
                if (aVar == null) {
                    x.e("MicroMsg.exdevice.BluetoothLEScaner", "callback is null");
                } else {
                    x.d("MicroMsg.exdevice.BluetoothLEScaner", "remove callback " + cVar.hfT.remove(aVar));
                }
                if (aVar != null) {
                    aVar.atO();
                }
                x.d("MicroMsg.exdevice.BluetoothLEScaner", "stop deleteCallback");
                if (cVar.hfT.size() <= 0) {
                    x.d("MicroMsg.exdevice.BluetoothLEScaner", "stop scan");
                    cVar.heY.stopLeScan(cVar);
                    cVar.hfU = false;
                }
                z2 = true;
            } else {
                x.w("MicroMsg.exdevice.BluetoothLEScaner", "scan haven't started. just return, callback size = %d", new Object[]{Integer.valueOf(cVar.hfT.size())});
                return true;
            }
            return z2;
        }
    }

    public static c atP() {
        if (hfS != null) {
            return hfS;
        }
        c cVar = new c(ad.getContext());
        hfS = cVar;
        return cVar;
    }

    private c(Context context) {
        if (context == null) {
            x.e("MicroMsg.exdevice.BluetoothLEScaner", "no context for scaner");
            return;
        }
        this.mContext = context;
        this.hfT = new ArrayList();
        this.hfU = false;
        this.heY = null;
        this.mHandler = null;
        this.heY = ((BluetoothManager) this.mContext.getSystemService("bluetooth")).getAdapter();
        this.mHandler = new ag(new ah("BluetoothLEScanerThread").lnJ.getLooper());
    }

    public final boolean a(final boolean z, final a aVar) {
        Boolean bool = (Boolean) new bd<Boolean>() {
            protected final /* synthetic */ Object run() {
                return Boolean.valueOf(c.a(c.this, z, aVar));
            }
        }.a(this.mHandler);
        Assert.assertTrue(bool != null);
        return bool.booleanValue();
    }

    private boolean a(a aVar) {
        boolean z = false;
        if (aVar == null) {
            x.e("MicroMsg.exdevice.BluetoothLEScaner", "callback is null");
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
            x.d("MicroMsg.exdevice.BluetoothLEScaner", "add callback " + z);
            return z;
        }
        x.w("MicroMsg.exdevice.BluetoothLEScaner", "callback has in queue. pass");
        return true;
    }

    public final void onLeScan(BluetoothDevice bluetoothDevice, int i, byte[] bArr) {
        x.d("MicroMsg.exdevice.BluetoothLEScaner", "onLeScan. device addr = %s, name = %s, data = %s", new Object[]{bluetoothDevice.getAddress(), bluetoothDevice.getName(), b.aq(bArr)});
        x.d("MicroMsg.exdevice.BluetoothLEScaner", "callback size = %d", new Object[]{Integer.valueOf(this.hfT.size())});
        this.mHandler.post(new 2(this, bluetoothDevice, i, bArr));
    }
}
