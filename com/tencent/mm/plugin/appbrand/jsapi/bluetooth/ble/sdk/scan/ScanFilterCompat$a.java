package com.tencent.mm.plugin.appbrand.jsapi.bluetooth.ble.sdk.scan;

import android.os.ParcelUuid;

public final class ScanFilterCompat$a {
    byte[] fNA;
    byte[] fNB;
    int fNC = -1;
    byte[] fND;
    byte[] fNE;
    ParcelUuid fNG;
    String fNv;
    String fNw;
    ParcelUuid fNx;
    ParcelUuid fNz;

    public final ScanFilterCompat$a a(ParcelUuid parcelUuid) {
        this.fNx = parcelUuid;
        this.fNG = null;
        return this;
    }

    public final ScanFilterCompat aix() {
        return new ScanFilterCompat(this.fNv, this.fNw, this.fNx, this.fNG, this.fNz, this.fNA, this.fNB, this.fNC, this.fND, this.fNE, (byte) 0);
    }
}
