package com.tencent.mm.plugin.h.a.b;

import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCallback;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattDescriptor;
import com.tencent.mm.sdk.platformtools.x;

class f$1 extends BluetoothGattCallback {
    final /* synthetic */ f hgG;

    f$1(f fVar) {
        this.hgG = fVar;
    }

    public final void onConnectionStateChange(BluetoothGatt bluetoothGatt, int i, int i2) {
        x.i("MicroMsg.exdevice.BluetoothLESimpleSession", "------onConnectionStateChange------ connect newState = %d, op status = %d, mConnectState = %d", new Object[]{Integer.valueOf(i2), Integer.valueOf(i), Integer.valueOf(f.e(this.hgG))});
        if (!f.f(this.hgG).sendMessage(f.f(this.hgG).obtainMessage(4, i2, 0))) {
            x.e("MicroMsg.exdevice.BluetoothLESimpleSession", "SendMessage Failed!!! MessageWhat = %d", new Object[]{Integer.valueOf(4)});
        }
    }

    public final void onServicesDiscovered(BluetoothGatt bluetoothGatt, int i) {
        x.i("MicroMsg.exdevice.BluetoothLESimpleSession", "------onServicesDiscovered------ status = %d", new Object[]{Integer.valueOf(i)});
        if (!f.f(this.hgG).sendMessage(f.f(this.hgG).obtainMessage(5, i, 0, bluetoothGatt))) {
            x.e("MicroMsg.exdevice.BluetoothLESimpleSession", "SendMessage Failed!!! MessageWhat = %d", new Object[]{Integer.valueOf(5)});
        }
    }

    public final void onDescriptorWrite(BluetoothGatt bluetoothGatt, BluetoothGattDescriptor bluetoothGattDescriptor, int i) {
        x.i("MicroMsg.exdevice.BluetoothLESimpleSession", "------onDescriptorWrite------ status = %d", new Object[]{Integer.valueOf(i)});
        if (!f.f(this.hgG).sendMessage(f.f(this.hgG).obtainMessage(6, i, 0, bluetoothGatt))) {
            x.e("MicroMsg.exdevice.BluetoothLESimpleSession", "SendMessage Failed!!! MessageWhat = %d", new Object[]{Integer.valueOf(6)});
        }
    }

    public final void onCharacteristicChanged(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        x.i("MicroMsg.exdevice.BluetoothLESimpleSession", "------onDataReceive------");
        if (!f.f(this.hgG).sendMessage(f.f(this.hgG).obtainMessage(8, bluetoothGattCharacteristic))) {
            x.e("MicroMsg.exdevice.BluetoothLESimpleSession", "SendMessage Failed!!! MessageWhat = %d", new Object[]{Integer.valueOf(8)});
        }
    }

    public final void onCharacteristicRead(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic, int i) {
        x.i("MicroMsg.exdevice.BluetoothLESimpleSession", "------onCharacteristicRead------ status = %d", new Object[]{Integer.valueOf(i)});
        if (i == 0 && !f.f(this.hgG).sendMessage(f.f(this.hgG).obtainMessage(8, bluetoothGattCharacteristic))) {
            x.e("MicroMsg.exdevice.BluetoothLESimpleSession", "SendMessage Failed!!! MessageWhat = %d", new Object[]{Integer.valueOf(8)});
        }
    }

    public final void onCharacteristicWrite(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic, int i) {
        x.i("MicroMsg.exdevice.BluetoothLESimpleSession", "------onDataWriteCallback------ status = %d", new Object[]{Integer.valueOf(i)});
        if (!f.f(this.hgG).sendMessage(f.f(this.hgG).obtainMessage(7, i, 0))) {
            x.e("MicroMsg.exdevice.BluetoothLESimpleSession", "SendMessage Failed!!! MessageWhat = %d", new Object[]{Integer.valueOf(7)});
        }
    }
}
