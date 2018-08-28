package com.google.android.exoplayer2.video;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import java.util.Arrays;

public final class ColorInfo implements Parcelable {
    public static final Creator<ColorInfo> CREATOR = new Creator<ColorInfo>() {
        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new ColorInfo(parcel);
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new ColorInfo[0];
        }
    };
    public final int aCN;
    public final int aCO;
    public final int aCP;
    public final byte[] aCQ;
    private int aeo;

    ColorInfo(Parcel parcel) {
        this.aCN = parcel.readInt();
        this.aCO = parcel.readInt();
        this.aCP = parcel.readInt();
        this.aCQ = (parcel.readInt() != 0 ? 1 : null) != null ? parcel.createByteArray() : null;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        ColorInfo colorInfo = (ColorInfo) obj;
        if (this.aCN == colorInfo.aCN && this.aCO == colorInfo.aCO && this.aCP == colorInfo.aCP && Arrays.equals(this.aCQ, colorInfo.aCQ)) {
            return true;
        }
        return false;
    }

    public final String toString() {
        return "ColorInfo(" + this.aCN + ", " + this.aCO + ", " + this.aCP + ", " + (this.aCQ != null) + ")";
    }

    public final int hashCode() {
        if (this.aeo == 0) {
            this.aeo = ((((((this.aCN + 527) * 31) + this.aCO) * 31) + this.aCP) * 31) + Arrays.hashCode(this.aCQ);
        }
        return this.aeo;
    }

    public final int describeContents() {
        return 0;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.aCN);
        parcel.writeInt(this.aCO);
        parcel.writeInt(this.aCP);
        parcel.writeInt(this.aCQ != null ? 1 : 0);
        if (this.aCQ != null) {
            parcel.writeByteArray(this.aCQ);
        }
    }
}
