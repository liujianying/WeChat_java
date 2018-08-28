package com.tencent.mm.plugin.appbrand.jsapi.bluetooth.ble.sdk.scan;

import android.os.Parcel;
import android.os.Parcelable.Creator;

class ScanResultCompat$1 implements Creator<ScanResultCompat> {
    ScanResultCompat$1() {
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        return new ScanResultCompat(parcel, (byte) 0);
    }

    public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
        return new ScanResultCompat[i];
    }
}
