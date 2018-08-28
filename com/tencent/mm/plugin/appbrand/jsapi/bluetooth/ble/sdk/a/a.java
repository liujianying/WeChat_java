package com.tencent.mm.plugin.appbrand.jsapi.bluetooth.ble.sdk.a;

import android.annotation.TargetApi;
import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCallback;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattDescriptor;

@TargetApi(18)
public final class a extends BluetoothGattCallback {
    public e fLJ;

    public a(e eVar) {
        this.fLJ = eVar;
    }

    public final void onConnectionStateChange(BluetoothGatt bluetoothGatt, int i, int i2) {
        this.fLJ.onConnectionStateChange(bluetoothGatt, i, i2);
    }

    public final void onServicesDiscovered(BluetoothGatt bluetoothGatt, int i) {
        this.fLJ.onServicesDiscovered(bluetoothGatt, i);
    }

    public final void onCharacteristicRead(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic, int i) {
        this.fLJ.onCharacteristicRead(bluetoothGatt, bluetoothGattCharacteristic, i);
    }

    public final void onCharacteristicWrite(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic, int i) {
        this.fLJ.onCharacteristicWrite(bluetoothGatt, bluetoothGattCharacteristic, i);
    }

    public final void onCharacteristicChanged(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        this.fLJ.onCharacteristicChanged(bluetoothGatt, bluetoothGattCharacteristic);
    }

    public final void onDescriptorRead(BluetoothGatt bluetoothGatt, BluetoothGattDescriptor bluetoothGattDescriptor, int i) {
        this.fLJ.onDescriptorRead(bluetoothGatt, bluetoothGattDescriptor, i);
    }

    public final void onDescriptorWrite(BluetoothGatt bluetoothGatt, BluetoothGattDescriptor bluetoothGattDescriptor, int i) {
        this.fLJ.onDescriptorWrite(bluetoothGatt, bluetoothGattDescriptor, i);
    }

    public final void onReliableWriteCompleted(BluetoothGatt bluetoothGatt, int i) {
        this.fLJ.onReliableWriteCompleted(bluetoothGatt, i);
    }

    public final void onReadRemoteRssi(BluetoothGatt bluetoothGatt, int i, int i2) {
        this.fLJ.onReadRemoteRssi(bluetoothGatt, i, i2);
    }

    public final void onMtuChanged(BluetoothGatt bluetoothGatt, int i, int i2) {
        this.fLJ.onMtuChanged(bluetoothGatt, i, i2);
    }
}
