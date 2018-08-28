package com.tencent.mm.plugin.appbrand.jsapi.bluetooth.ble.sdk.a.a;

import android.annotation.TargetApi;
import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattService;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.ble.sdk.c.a;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.ble.sdk.c.f;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.ble.sdk.c.j;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.ble.sdk.d.b;
import java.util.UUID;

@TargetApi(18)
public final class e extends a {
    private final String fLY;
    private final String fLZ;

    public e(String str, String str2) {
        this.fLY = str;
        this.fLZ = str2;
    }

    public final void aiu() {
        BluetoothGatt bluetoothGatt = this.fMb.fLV;
        if (bluetoothGatt == null) {
            com.tencent.mm.plugin.appbrand.jsapi.bluetooth.ble.sdk.d.a.e("MicroMsg.Ble.Action", "action:%s, bluetoothGatt is null", new Object[]{this});
            a(j.fMD);
            done();
        } else if (b.tv(this.fLY)) {
            BluetoothGattService service = bluetoothGatt.getService(UUID.fromString(this.fLY));
            if (service == null) {
                com.tencent.mm.plugin.appbrand.jsapi.bluetooth.ble.sdk.d.a.e("MicroMsg.Ble.Action", "action:%s, gattService is null", new Object[]{this});
                a(j.fMB);
                done();
            } else if (b.tv(this.fLZ)) {
                BluetoothGattCharacteristic characteristic = service.getCharacteristic(UUID.fromString(this.fLZ));
                if (characteristic == null) {
                    com.tencent.mm.plugin.appbrand.jsapi.bluetooth.ble.sdk.d.a.e("MicroMsg.Ble.Action", "action:%s, gattCharacteristic is null", new Object[]{this});
                    a(j.fMC);
                    done();
                } else if (!b.kE(characteristic.getProperties())) {
                    com.tencent.mm.plugin.appbrand.jsapi.bluetooth.ble.sdk.d.a.e("MicroMsg.Ble.Action", "action:%s, not support read", new Object[]{this});
                    a(j.fME);
                    done();
                } else if (bluetoothGatt.readCharacteristic(characteristic)) {
                    a(j.fMv);
                } else {
                    com.tencent.mm.plugin.appbrand.jsapi.bluetooth.ble.sdk.d.a.e("MicroMsg.Ble.Action", "action:%s bluetoothGatt.readCharacteristic fail", new Object[]{this});
                    a(j.fMF);
                    done();
                }
            } else {
                com.tencent.mm.plugin.appbrand.jsapi.bluetooth.ble.sdk.d.a.e("MicroMsg.Ble.Action", "action:%s, characteristicId is illegal", new Object[]{this});
                a(j.fMC);
                done();
            }
        } else {
            com.tencent.mm.plugin.appbrand.jsapi.bluetooth.ble.sdk.d.a.e("MicroMsg.Ble.Action", "action:%s, serviceId is illegal", new Object[]{this});
            a(j.fMB);
            done();
        }
    }

    public final void onCharacteristicRead(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic, int i) {
        com.tencent.mm.plugin.appbrand.jsapi.bluetooth.ble.sdk.d.a.i("MicroMsg.Ble.Action", "action:%s onCharacteristicRead status:%s", new Object[]{this, f.kC(i)});
        done();
    }

    public final String getName() {
        return "ReadCharacteristicAction";
    }

    public final String toString() {
        return "ReadCharacteristicAction{serviceId='" + this.fLY + '\'' + ", characteristicId='" + this.fLZ + '\'' + ", debug=" + this.Zq + ", mainThread=" + this.fLy + ", serial=" + this.fLA + '}';
    }
}
