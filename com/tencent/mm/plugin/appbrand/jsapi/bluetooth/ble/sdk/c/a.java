package com.tencent.mm.plugin.appbrand.jsapi.bluetooth.ble.sdk.c;

import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattDescriptor;
import android.os.Handler;
import android.os.Looper;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.ble.sdk.a.b;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.ble.sdk.a.d;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.ble.sdk.a.e;
import junit.framework.Assert;

public abstract class a implements e {
    public boolean Zq = com.tencent.mm.plugin.appbrand.jsapi.bluetooth.ble.sdk.a.fLt.Zq;
    public boolean anR = false;
    public boolean fLA = com.tencent.mm.plugin.appbrand.jsapi.bluetooth.ble.sdk.a.fLt.fLA;
    private final Handler fLN = new Handler(Looper.getMainLooper());
    public boolean fLy = com.tencent.mm.plugin.appbrand.jsapi.bluetooth.ble.sdk.a.fLt.fLy;
    public d fMb;
    protected b fMc;
    public b fMd;
    private Runnable fMe = new 1(this);
    public long fMf = com.tencent.mm.plugin.appbrand.jsapi.bluetooth.ble.sdk.a.fLt.fLv;
    public long fMg = ((long) com.tencent.mm.plugin.appbrand.jsapi.bluetooth.ble.sdk.a.fLt.fLE);
    public j fMh;

    public abstract void aiu();

    public abstract String getName();

    public final void a(b bVar) {
        this.fMc = bVar;
    }

    public final void aiv() {
        Assert.assertNotNull(this.fMb);
        Assert.assertNotNull(this.fMc);
        Assert.assertNotNull(this.fMd);
        this.fLN.postDelayed(this.fMe, this.fMf);
        aiu();
    }

    public final void a(j jVar) {
        this.fMh = jVar;
        if (this.fLy) {
            this.fLN.post(new 2(this, jVar));
        } else {
            this.fMd.a(jVar);
        }
    }

    public final void done() {
        this.fLN.removeCallbacks(this.fMe);
        this.anR = true;
        b(this.fMh);
        b bVar = this.fMc;
        j jVar = this.fMh;
        String str = "MicroMsg.Ble.BleConnectDispatcher";
        String str2 = "actionCompleteCallback action:%s result:%s";
        Object[] objArr = new Object[2];
        objArr[0] = this;
        if (jVar == null) {
            jVar = "";
        }
        objArr[1] = jVar;
        com.tencent.mm.plugin.appbrand.jsapi.bluetooth.ble.sdk.d.a.i(str, str2, objArr);
        if (this == null) {
            return;
        }
        if (this.fLA) {
            bVar.ait();
        } else {
            bVar.fLM.remove(this);
        }
    }

    public void b(j jVar) {
    }

    public void onConnectionStateChange(BluetoothGatt bluetoothGatt, int i, int i2) {
    }

    public void onServicesDiscovered(BluetoothGatt bluetoothGatt, int i) {
    }

    public void onCharacteristicRead(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic, int i) {
    }

    public void onCharacteristicWrite(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic, int i) {
    }

    public final void onCharacteristicChanged(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic) {
    }

    public final void onDescriptorRead(BluetoothGatt bluetoothGatt, BluetoothGattDescriptor bluetoothGattDescriptor, int i) {
    }

    public void onDescriptorWrite(BluetoothGatt bluetoothGatt, BluetoothGattDescriptor bluetoothGattDescriptor, int i) {
    }

    public final void onReliableWriteCompleted(BluetoothGatt bluetoothGatt, int i) {
    }

    public final void onReadRemoteRssi(BluetoothGatt bluetoothGatt, int i, int i2) {
    }

    public final void onMtuChanged(BluetoothGatt bluetoothGatt, int i, int i2) {
    }

    public String toString() {
        return "Action{action='" + getName() + '\'' + ", debug=" + this.Zq + ", mainThread=" + this.fLy + ", serial=" + this.fLA + '}';
    }
}
