package com.tencent.mm.plugin.appbrand.jsapi.bluetooth.ble.sdk.a.a;

import android.annotation.TargetApi;
import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattService;
import android.util.Base64;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.ble.sdk.c.a;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.ble.sdk.c.j;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.ble.sdk.d.b;
import java.util.Arrays;
import java.util.Locale;
import java.util.UUID;

@TargetApi(18)
public final class f extends a {
    private final String fLY;
    private final String fLZ;
    private final String value;

    public f(String str, String str2, String str3) {
        this.fLY = str;
        this.fLZ = str2;
        this.value = str3;
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
                } else if (b.kF(characteristic.getProperties()) || b.kG(characteristic.getProperties())) {
                    byte[] bArr;
                    int i;
                    byte[] decode = Base64.decode(this.value, 2);
                    if (decode == null || decode.length == 0) {
                        bArr = null;
                    } else {
                        int i2;
                        int length = decode.length;
                        if (decode.length < length) {
                            com.tencent.mm.plugin.appbrand.jsapi.bluetooth.ble.sdk.d.a.w("MicroMsg.Ble.BleHelper", "data length is shorter then print command length", new Object[0]);
                            length = decode.length;
                        }
                        StringBuilder stringBuilder = new StringBuilder();
                        for (i = 0; i < length; i++) {
                            i2 = decode[i] & 255;
                            if (i2 < 16) {
                                stringBuilder.append("0");
                            }
                            stringBuilder.append(Integer.toHexString(i2));
                        }
                        String toUpperCase = stringBuilder.toString().toUpperCase(Locale.US);
                        com.tencent.mm.plugin.appbrand.jsapi.bluetooth.ble.sdk.d.a.d("MicroMsg.Ble.BleHelper", "write data = %s", new Object[]{toUpperCase});
                        if (toUpperCase == null || toUpperCase.equals("")) {
                            bArr = new byte[0];
                        } else {
                            int length2 = toUpperCase.toUpperCase().length() / 2;
                            char[] toCharArray = toUpperCase.toCharArray();
                            bArr = new byte[length2];
                            for (i = 0; i < length2; i++) {
                                i2 = i * 2;
                                bArr[i] = (byte) (((byte) "0123456789ABCDEF".indexOf(toCharArray[i2 + 1])) | (((byte) "0123456789ABCDEF".indexOf(toCharArray[i2])) << 4));
                            }
                        }
                    }
                    characteristic.setValue(bArr);
                    String str = "MicroMsg.Ble.Action";
                    String str2 = "dataToWrite's length:%d";
                    Object[] objArr = new Object[1];
                    if (bArr != null) {
                        i = bArr.length;
                    } else {
                        i = 0;
                    }
                    objArr[0] = Integer.valueOf(i);
                    com.tencent.mm.plugin.appbrand.jsapi.bluetooth.ble.sdk.d.a.w(str, str2, objArr);
                    if (this.Zq) {
                        com.tencent.mm.plugin.appbrand.jsapi.bluetooth.ble.sdk.d.a.i("MicroMsg.Ble.Action", "dataToWrite:%s", new Object[]{Arrays.toString(bArr)});
                    }
                    if (!bluetoothGatt.writeCharacteristic(characteristic)) {
                        com.tencent.mm.plugin.appbrand.jsapi.bluetooth.ble.sdk.d.a.e("MicroMsg.Ble.Action", "action:%s bluetoothGatt.writeCharacteristic fail", new Object[]{this});
                        a(j.fMF);
                        done();
                    } else if (!b.kF(characteristic.getProperties()) && b.kG(characteristic.getProperties())) {
                        a(j.fMv);
                        done();
                    }
                } else {
                    com.tencent.mm.plugin.appbrand.jsapi.bluetooth.ble.sdk.d.a.e("MicroMsg.Ble.Action", "action:%s, not support write & writeNoResponse", new Object[]{this});
                    a(j.fME);
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

    public final void onCharacteristicWrite(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic, int i) {
        com.tencent.mm.plugin.appbrand.jsapi.bluetooth.ble.sdk.d.a.i("MicroMsg.Ble.Action", "action:%s onCharacteristicWrite status:%s", new Object[]{this, com.tencent.mm.plugin.appbrand.jsapi.bluetooth.ble.sdk.c.f.kC(i)});
        if (i == 0) {
            a(j.fMv);
        }
        done();
    }

    public final String getName() {
        return "WriteCharacteristicAction";
    }

    public final String toString() {
        return "WriteCharacteristicAction{serviceId='" + this.fLY + '\'' + ", characteristicId='" + this.fLZ + '\'' + ", value='" + this.value + '\'' + ", debug=" + this.Zq + ", mainThread=" + this.fLy + ", serial=" + this.fLA + '}';
    }
}
