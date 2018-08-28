package com.tencent.mm.plugin.h.a.b;

import android.bluetooth.BluetoothGattCharacteristic;

public final class a {
    private byte[] hfA = null;
    private int hfB = 0;
    private int hfC = 0;
    BluetoothGattCharacteristic hfD = null;
    private int hfz = 20;

    public final void setData(byte[] bArr) {
        if (bArr == null) {
            this.hfA = null;
            this.hfC = 0;
            this.hfB = 0;
            return;
        }
        this.hfA = new byte[bArr.length];
        System.arraycopy(bArr, 0, this.hfA, 0, bArr.length);
        this.hfC = bArr.length;
        this.hfB = 0;
    }

    public final byte[] atL() {
        int i = this.hfC - this.hfB;
        if (i == 0) {
            return null;
        }
        if (i >= this.hfz) {
            i = this.hfz;
        }
        Object obj = new byte[i];
        System.arraycopy(this.hfA, this.hfB, obj, 0, i);
        this.hfB = i + this.hfB;
        return obj;
    }
}
