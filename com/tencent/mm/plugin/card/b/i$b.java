package com.tencent.mm.plugin.card.b;

import java.util.Arrays;

class i$b {
    int bMF;
    String byN;
    byte[] huy;
    String name;

    public i$b(String str, int i, String str2, byte[] bArr) {
        this.byN = str;
        this.bMF = i;
        this.name = str2;
        this.huy = bArr;
    }

    public final String toString() {
        return "DeviceInfo{deviceId='" + this.byN + '\'' + ", rssi=" + this.bMF + ", name='" + this.name + '\'' + ", manuData=" + Arrays.toString(this.huy) + '}';
    }
}
