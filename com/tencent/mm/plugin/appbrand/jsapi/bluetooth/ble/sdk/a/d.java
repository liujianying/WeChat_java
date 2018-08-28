package com.tencent.mm.plugin.appbrand.jsapi.bluetooth.ble.sdk.a;

import android.annotation.TargetApi;
import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattDescriptor;
import android.content.Context;
import android.util.Base64;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.ble.sdk.c.c;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.ble.sdk.c.e;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.ble.sdk.c.f;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.ble.sdk.c.g;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.ble.sdk.c.h;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.ble.sdk.d.a;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.ble.sdk.d.b;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

@TargetApi(18)
public final class d implements e {
    public String byN;
    public Context context;
    public h fLR;
    public g fLS;
    public b fLU;
    public BluetoothGatt fLV;
    public List<e> fLW;
    public Map<String, List<c>> fLX;

    public d(Context context, String str) {
        this.context = context;
        this.byN = str;
    }

    public final synchronized void cM(boolean z) {
        if (this.fLV != null) {
            a.i("MicroMsg.Ble.BleConnectWorker", "deviceId:%s closeMyself", new Object[]{this.byN});
            if (z) {
                X(this.byN, false);
            }
            if (com.tencent.mm.plugin.appbrand.jsapi.bluetooth.ble.sdk.a.fLt.fLF) {
                b.a(this.fLV);
            }
            this.fLV.close();
            this.fLV = null;
        }
    }

    public final void onConnectionStateChange(BluetoothGatt bluetoothGatt, int i, int i2) {
        String str = "MicroMsg.Ble.BleConnectWorker";
        String str2 = "[onConnectionStateChange]gatt deviceId:%s gattStatus:%s, newState:%s";
        Object[] objArr = new Object[3];
        objArr[0] = bluetoothGatt != null ? bluetoothGatt.getDevice().getAddress() : "";
        objArr[1] = f.kC(i);
        objArr[2] = i2 == 2 ? "CONNECTED" : "DISCONNECTED";
        a.i(str, str2, objArr);
        this.fLU.onConnectionStateChange(bluetoothGatt, i, i2);
        String address = bluetoothGatt.getDevice().getAddress();
        if (i == 0) {
            if (i2 == 2) {
                X(address, true);
                return;
            } else if (i2 != 0) {
                return;
            }
        }
        cM(true);
    }

    private void X(String str, boolean z) {
        if (this.fLR != null) {
            this.fLR.W(str, z);
        }
    }

    public final void onServicesDiscovered(BluetoothGatt bluetoothGatt, int i) {
        String str = "MicroMsg.Ble.BleConnectWorker";
        String str2 = "[onServicesDiscovered]gatt deviceId:%s status:%s";
        Object[] objArr = new Object[2];
        objArr[0] = bluetoothGatt != null ? bluetoothGatt.getDevice().getAddress() : "";
        objArr[1] = f.kC(i);
        a.i(str, str2, objArr);
        this.fLU.onServicesDiscovered(bluetoothGatt, i);
    }

    public final void onCharacteristicRead(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic, int i) {
        String str = "MicroMsg.Ble.BleConnectWorker";
        String str2 = "[onCharacteristicRead]gatt deviceId:%s characteristicId:%s status:%s";
        Object[] objArr = new Object[3];
        objArr[0] = bluetoothGatt != null ? bluetoothGatt.getDevice().getAddress() : "";
        objArr[1] = bluetoothGattCharacteristic != null ? bluetoothGattCharacteristic.getUuid().toString().toUpperCase() : "";
        objArr[2] = f.kC(i);
        a.i(str, str2, objArr);
        this.fLU.onCharacteristicRead(bluetoothGatt, bluetoothGattCharacteristic, i);
        if (i == 0) {
            a.i("MicroMsg.Ble.BleConnectWorker", "[read]deviceId %s, serviceId %s, characteristicId %s, value %s", new Object[]{bluetoothGatt.getDevice().getAddress(), bluetoothGattCharacteristic.getService().getUuid().toString().toUpperCase(), bluetoothGattCharacteristic.getUuid().toString().toUpperCase(), new String(Base64.encode(bluetoothGattCharacteristic.getValue(), 2))});
            this.fLS.g(r0, str2, r3, str);
        }
    }

    public final void onCharacteristicWrite(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic, int i) {
        String str = "MicroMsg.Ble.BleConnectWorker";
        String str2 = "[onCharacteristicWrite]gatt deviceId:%s characteristicId:%s value:%s, status:%s";
        Object[] objArr = new Object[4];
        objArr[0] = bluetoothGatt != null ? bluetoothGatt.getDevice().getAddress() : "";
        objArr[1] = bluetoothGattCharacteristic != null ? bluetoothGattCharacteristic.getUuid().toString().toUpperCase() : "";
        objArr[2] = bluetoothGattCharacteristic != null ? Arrays.asList(new byte[][]{bluetoothGattCharacteristic.getValue()}) : "";
        objArr[3] = f.kC(i);
        a.i(str, str2, objArr);
        this.fLU.onCharacteristicWrite(bluetoothGatt, bluetoothGattCharacteristic, i);
    }

    public final void onCharacteristicChanged(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        String str = "MicroMsg.Ble.BleConnectWorker";
        String str2 = "[onCharacteristicChanged]gatt deviceId:%s characteristicId:%s";
        Object[] objArr = new Object[2];
        objArr[0] = bluetoothGatt != null ? bluetoothGatt.getDevice().getAddress() : "";
        objArr[1] = bluetoothGattCharacteristic != null ? bluetoothGattCharacteristic.getUuid().toString().toUpperCase() : "";
        a.i(str, str2, objArr);
        this.fLU.onCharacteristicChanged(bluetoothGatt, bluetoothGattCharacteristic);
        if (this.fLS != null) {
            a.i("MicroMsg.Ble.BleConnectWorker", "[change]deviceId %s, serviceId %s, characteristicId %s, value %s", new Object[]{bluetoothGatt.getDevice().getAddress(), bluetoothGattCharacteristic.getService().getUuid().toString().toUpperCase(), bluetoothGattCharacteristic.getUuid().toString().toUpperCase(), new String(Base64.encode(bluetoothGattCharacteristic.getValue(), 2))});
            this.fLS.g(r0, str2, r3, str);
        }
    }

    public final void onDescriptorRead(BluetoothGatt bluetoothGatt, BluetoothGattDescriptor bluetoothGattDescriptor, int i) {
        String str = "MicroMsg.Ble.BleConnectWorker";
        String str2 = "[onDescriptorRead]gatt deviceId:%s descriptorId:%s";
        Object[] objArr = new Object[2];
        objArr[0] = bluetoothGatt != null ? bluetoothGatt.getDevice().getAddress() : "";
        objArr[1] = bluetoothGattDescriptor != null ? bluetoothGattDescriptor.getUuid().toString().toUpperCase() : "";
        a.i(str, str2, objArr);
        this.fLU.onDescriptorRead(bluetoothGatt, bluetoothGattDescriptor, i);
    }

    public final void onDescriptorWrite(BluetoothGatt bluetoothGatt, BluetoothGattDescriptor bluetoothGattDescriptor, int i) {
        String str = "MicroMsg.Ble.BleConnectWorker";
        String str2 = "[onDescriptorWrite]gatt deviceId:%s descriptorId:%s";
        Object[] objArr = new Object[2];
        objArr[0] = bluetoothGatt != null ? bluetoothGatt.getDevice().getAddress() : "";
        objArr[1] = bluetoothGattDescriptor != null ? bluetoothGattDescriptor.getUuid().toString().toUpperCase() : "";
        a.i(str, str2, objArr);
        this.fLU.onDescriptorWrite(bluetoothGatt, bluetoothGattDescriptor, i);
    }

    public final void onReliableWriteCompleted(BluetoothGatt bluetoothGatt, int i) {
        String str = "MicroMsg.Ble.BleConnectWorker";
        String str2 = "[onReliableWriteCompleted]gatt deviceId:%s status:%s";
        Object[] objArr = new Object[2];
        objArr[0] = bluetoothGatt != null ? bluetoothGatt.getDevice().getAddress() : "";
        objArr[1] = f.kC(i);
        a.i(str, str2, objArr);
        this.fLU.onReliableWriteCompleted(bluetoothGatt, i);
    }

    public final void onReadRemoteRssi(BluetoothGatt bluetoothGatt, int i, int i2) {
        String str = "MicroMsg.Ble.BleConnectWorker";
        String str2 = "[onReadRemoteRssi]gatt deviceId:%s rssi:%d status:%s";
        Object[] objArr = new Object[3];
        objArr[0] = bluetoothGatt != null ? bluetoothGatt.getDevice().getAddress() : "";
        objArr[1] = Integer.valueOf(i);
        objArr[2] = f.kC(i2);
        a.i(str, str2, objArr);
        this.fLU.onReadRemoteRssi(bluetoothGatt, i, i2);
    }

    public final void onMtuChanged(BluetoothGatt bluetoothGatt, int i, int i2) {
        String str = "MicroMsg.Ble.BleConnectWorker";
        String str2 = "[onMtuChanged]gatt deviceId:%s mtu:%d status:%s";
        Object[] objArr = new Object[3];
        objArr[0] = bluetoothGatt != null ? bluetoothGatt.getDevice().getAddress() : "";
        objArr[1] = Integer.valueOf(i);
        objArr[2] = f.kC(i2);
        a.i(str, str2, objArr);
        this.fLU.onMtuChanged(bluetoothGatt, i, i2);
    }
}
