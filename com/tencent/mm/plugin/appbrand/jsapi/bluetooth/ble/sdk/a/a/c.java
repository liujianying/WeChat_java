package com.tencent.mm.plugin.appbrand.jsapi.bluetooth.ble.sdk.a.a;

import android.annotation.TargetApi;
import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattDescriptor;
import android.bluetooth.BluetoothGattService;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.ble.sdk.c.a;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.ble.sdk.c.f;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.ble.sdk.c.j;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.ble.sdk.d.b;
import java.util.UUID;

@TargetApi(18)
public final class c extends a {
    private final boolean bKe;
    private final String fLY;
    private final String fLZ;

    public c(String str, String str2, boolean z) {
        this.fLY = str;
        this.fLZ = str2;
        this.bKe = z;
    }

    public final void aiu() {
        BluetoothGatt bluetoothGatt = this.fMb.fLV;
        if (bluetoothGatt == null) {
            com.tencent.mm.plugin.appbrand.jsapi.bluetooth.ble.sdk.d.a.e("MicroMsg.Ble.Action", "action:%s, bluetoothGatt is null", this);
            a(j.fMD);
            done();
            return;
        }
        BluetoothGattService service = bluetoothGatt.getService(UUID.fromString(this.fLY));
        if (service == null) {
            com.tencent.mm.plugin.appbrand.jsapi.bluetooth.ble.sdk.d.a.e("MicroMsg.Ble.Action", "action:%s, gattService is null", this);
            a(j.fMB);
            done();
        } else if (b.tv(this.fLZ)) {
            BluetoothGattCharacteristic characteristic = service.getCharacteristic(UUID.fromString(this.fLZ));
            if (characteristic == null) {
                com.tencent.mm.plugin.appbrand.jsapi.bluetooth.ble.sdk.d.a.e("MicroMsg.Ble.Action", "action:%s, gattCharacteristic is null", this);
                a(j.fMC);
                done();
            } else if (!b.kI(characteristic.getProperties())) {
                com.tencent.mm.plugin.appbrand.jsapi.bluetooth.ble.sdk.d.a.e("MicroMsg.Ble.Action", "action:%s, not support indicate", this);
                a(j.fME);
                done();
            } else if (bluetoothGatt.setCharacteristicNotification(characteristic, this.bKe)) {
                BluetoothGattDescriptor descriptor = characteristic.getDescriptor(com.tencent.mm.plugin.appbrand.jsapi.bluetooth.ble.sdk.b.a.fMa);
                if (descriptor == null) {
                    com.tencent.mm.plugin.appbrand.jsapi.bluetooth.ble.sdk.d.a.e("MicroMsg.Ble.Action", "action:%s gattCharacteristic.getDescriptor fail", this);
                    a(j.fMH);
                    done();
                    return;
                }
                if (!descriptor.setValue(this.bKe ? BluetoothGattDescriptor.ENABLE_INDICATION_VALUE : BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE)) {
                    com.tencent.mm.plugin.appbrand.jsapi.bluetooth.ble.sdk.d.a.e("MicroMsg.Ble.Action", "action:%s gattDescriptor.setValue fail", this);
                    a(j.fMI);
                    done();
                } else if (bluetoothGatt.writeDescriptor(descriptor)) {
                    a(j.fMv);
                } else {
                    com.tencent.mm.plugin.appbrand.jsapi.bluetooth.ble.sdk.d.a.e("MicroMsg.Ble.Action", "action:%s bluetoothGatt.writeDescriptor fail", this);
                    a(j.fMJ);
                    done();
                }
            } else {
                com.tencent.mm.plugin.appbrand.jsapi.bluetooth.ble.sdk.d.a.e("MicroMsg.Ble.Action", "action:%s bluetoothGatt.setCharacteristicNotification fail", this);
                a(j.fMF);
                done();
            }
        } else {
            com.tencent.mm.plugin.appbrand.jsapi.bluetooth.ble.sdk.d.a.e("MicroMsg.Ble.Action", "action:%s, characteristicId is illegal", this);
            a(j.fMC);
            done();
        }
    }

    public final void onDescriptorWrite(BluetoothGatt bluetoothGatt, BluetoothGattDescriptor bluetoothGattDescriptor, int i) {
        com.tencent.mm.plugin.appbrand.jsapi.bluetooth.ble.sdk.d.a.i("MicroMsg.Ble.Action", "action:%s onDescriptorWrite status:%s", this, f.kC(i));
        done();
    }

    public final String getName() {
        return "IndicateCharacteristicAction";
    }

    public final String toString() {
        return "IndicateCharacteristicAction{serviceId='" + this.fLY + '\'' + ", characteristicId='" + this.fLZ + '\'' + ", enable=" + this.bKe + ", debug=" + this.Zq + ", mainThread=" + this.fLy + ", serial=" + this.fLA + '}';
    }
}
