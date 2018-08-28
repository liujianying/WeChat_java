package com.google.android.gms.tagmanager;

import java.util.Arrays;

class ap$b {
    final String aXv;
    final byte[] bde;

    ap$b(String str, byte[] bArr) {
        this.aXv = str;
        this.bde = bArr;
    }

    public final String toString() {
        return "KeyAndSerialized: key = " + this.aXv + " serialized hash = " + Arrays.hashCode(this.bde);
    }
}
