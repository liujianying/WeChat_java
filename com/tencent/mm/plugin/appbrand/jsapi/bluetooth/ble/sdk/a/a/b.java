package com.tencent.mm.plugin.appbrand.jsapi.bluetooth.ble.sdk.a.a;

import android.annotation.TargetApi;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGatt;
import android.os.Looper;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.ble.sdk.c.a;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.ble.sdk.c.f;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.ble.sdk.c.j;

@TargetApi(18)
public final class b extends a {
    public String byN;

    public b(String str) {
        this.byN = str;
    }

    public final void aiu() {
        boolean z = false;
        BluetoothAdapter aiA = com.tencent.mm.plugin.appbrand.jsapi.bluetooth.ble.sdk.d.b.aiA();
        if (aiA == null) {
            com.tencent.mm.plugin.appbrand.jsapi.bluetooth.ble.sdk.d.a.e("MicroMsg.Ble.ConnectAction", "action:%s, bluetoothGatt is null", new Object[]{this});
            a(j.BLE_NO_CONNECTION);
            done();
        } else if (this.byN == null || !BluetoothAdapter.checkBluetoothAddress(this.byN)) {
            com.tencent.mm.plugin.appbrand.jsapi.bluetooth.ble.sdk.d.a.w("MicroMsg.Ble.ConnectAction", "action:%s, unspecified deviceId", new Object[]{this});
            a(j.FAIL);
            done();
        } else if (!com.tencent.mm.plugin.appbrand.jsapi.bluetooth.ble.sdk.d.b.aiB()) {
            com.tencent.mm.plugin.appbrand.jsapi.bluetooth.ble.sdk.d.a.e("MicroMsg.Ble.ConnectAction", "bluetooth is not enable.", new Object[0]);
            a(j.BLE_NOT_AVAILABLE);
            done();
        } else if (this.fMb.fLV != null) {
            com.tencent.mm.plugin.appbrand.jsapi.bluetooth.ble.sdk.d.a.w("MicroMsg.Ble.ConnectAction", "already connect, please close", new Object[0]);
            a(j.BLE_ALREADY_CONNECT);
            done();
        } else {
            BluetoothDevice remoteDevice = aiA.getRemoteDevice(this.byN);
            if (remoteDevice != null) {
                BluetoothGatt connectGatt = remoteDevice.connectGatt(this.fMb.context, false, new com.tencent.mm.plugin.appbrand.jsapi.bluetooth.ble.sdk.a.a(this.fMb));
                String str;
                if (connectGatt != null) {
                    str = "MicroMsg.Ble.ConnectAction";
                    String str2 = "create a new connection deviceId=%s mainthread:%b";
                    Object[] objArr = new Object[2];
                    objArr[0] = this.byN;
                    if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
                        z = true;
                    }
                    objArr[1] = Boolean.valueOf(z);
                    com.tencent.mm.plugin.appbrand.jsapi.bluetooth.ble.sdk.d.a.i(str, str2, objArr);
                    this.fMb.fLV = connectGatt;
                    return;
                }
                String str3 = "MicroMsg.Ble.ConnectAction";
                str = "Get Gatt fail!, deviceId=%s mainthread:%b";
                Object[] objArr2 = new Object[2];
                objArr2[0] = this.byN;
                if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
                    z = true;
                }
                objArr2[1] = Boolean.valueOf(z);
                com.tencent.mm.plugin.appbrand.jsapi.bluetooth.ble.sdk.d.a.e(str3, str, objArr2);
            } else {
                com.tencent.mm.plugin.appbrand.jsapi.bluetooth.ble.sdk.d.a.e("MicroMsg.Ble.ConnectAction", "Device not found, deviceId=%s", new Object[]{this.byN});
            }
            a(j.FAIL);
            done();
        }
    }

    public final String getName() {
        return "ConnectAction";
    }

    public final void b(j jVar) {
        switch (1.fLf[jVar.ordinal()]) {
            case 1:
                this.fMb.cM(false);
                return;
            default:
                return;
        }
    }

    public final void onConnectionStateChange(BluetoothGatt bluetoothGatt, int i, int i2) {
        String str = "MicroMsg.Ble.ConnectAction";
        String str2 = "[onConnectionStateChange]gatt:%s gattStatus:%s, newState:%s";
        Object[] objArr = new Object[3];
        objArr[0] = bluetoothGatt != null ? bluetoothGatt.toString() : "";
        objArr[1] = f.kC(i);
        objArr[2] = i2 == 2 ? "CONNECTED" : "DISCONNECTED";
        com.tencent.mm.plugin.appbrand.jsapi.bluetooth.ble.sdk.d.a.i(str, str2, objArr);
        if (i2 == 2) {
            com.tencent.mm.plugin.appbrand.jsapi.bluetooth.ble.sdk.d.a.i("MicroMsg.Ble.ConnectAction", "Attempting to start service discovery", new Object[0]);
            bluetoothGatt.discoverServices();
        } else if (i2 == 0) {
            com.tencent.mm.plugin.appbrand.jsapi.bluetooth.ble.sdk.d.a.i("MicroMsg.Ble.ConnectAction", "close", new Object[0]);
            bluetoothGatt.close();
            a(j.BLE_NO_CONNECTION);
        }
    }

    public final void onServicesDiscovered(BluetoothGatt bluetoothGatt, int i) {
        com.tencent.mm.plugin.appbrand.jsapi.bluetooth.ble.sdk.d.a.i("MicroMsg.Ble.ConnectAction", "[onServicesDiscovered] status:%s", new Object[]{f.kC(i)});
        if (i == 0) {
            a(j.OK);
        } else {
            a(j.BLE_NO_CONNECTION);
        }
        done();
    }

    public final String toString() {
        return "ConnectAction{deviceId='" + this.byN + '\'' + ", debug=" + this.Zq + ", mainThread=" + this.fLy + ", serial=" + this.fLA + '}';
    }
}
