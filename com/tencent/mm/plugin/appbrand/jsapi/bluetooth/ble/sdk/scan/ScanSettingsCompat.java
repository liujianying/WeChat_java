package com.tencent.mm.plugin.appbrand.jsapi.bluetooth.ble.sdk.scan;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class ScanSettingsCompat implements Parcelable {
    public static final Creator<ScanSettingsCompat> CREATOR = new 1();
    final int fNR;
    private final int fNS;
    final long fNT;

    /* synthetic */ ScanSettingsCompat(int i, long j, byte b) {
        this(i, j);
    }

    private ScanSettingsCompat(int i, long j) {
        this.fNR = i;
        this.fNS = 1;
        this.fNT = j;
    }

    private ScanSettingsCompat(Parcel parcel) {
        this.fNR = parcel.readInt();
        this.fNS = parcel.readInt();
        this.fNT = parcel.readLong();
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.fNR);
        parcel.writeInt(this.fNS);
        parcel.writeLong(this.fNT);
    }

    public int describeContents() {
        return 0;
    }
}
