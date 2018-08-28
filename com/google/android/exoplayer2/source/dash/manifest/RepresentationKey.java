package com.google.android.exoplayer2.source.dash.manifest;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public final class RepresentationKey implements Parcelable, Comparable<RepresentationKey> {
    public static final Creator<RepresentationKey> CREATOR = new 1();
    public final int arU;
    public final int asR;
    public final int asS;

    public final /* bridge */ /* synthetic */ int compareTo(Object obj) {
        RepresentationKey representationKey = (RepresentationKey) obj;
        int i = this.arU - representationKey.arU;
        if (i != 0) {
            return i;
        }
        i = this.asR - representationKey.asR;
        return i == 0 ? this.asS - representationKey.asS : i;
    }

    public RepresentationKey(int i, int i2, int i3) {
        this.arU = i;
        this.asR = i2;
        this.asS = i3;
    }

    public final String toString() {
        return this.arU + "." + this.asR + "." + this.asS;
    }

    public final int describeContents() {
        return 0;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.arU);
        parcel.writeInt(this.asR);
        parcel.writeInt(this.asS);
    }
}
