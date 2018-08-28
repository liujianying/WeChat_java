package com.tencent.mm.ui.widget.snackbar;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

class Snack implements Parcelable {
    public static final Creator<Snack> CREATOR = new 1();
    final String kjg;
    final String uMv;
    final int uMw;
    final Parcelable uMx;
    final short uMy;
    final int uMz;

    Snack(String str, String str2, int i, Parcelable parcelable, short s, int i2) {
        this.kjg = str;
        this.uMv = str2;
        this.uMw = i;
        this.uMx = parcelable;
        this.uMy = s;
        this.uMz = i2;
    }

    Snack(Parcel parcel) {
        this.kjg = parcel.readString();
        this.uMv = parcel.readString();
        this.uMw = parcel.readInt();
        this.uMx = parcel.readParcelable(parcel.getClass().getClassLoader());
        this.uMy = (short) parcel.readInt();
        this.uMz = parcel.readInt();
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.kjg);
        parcel.writeString(this.uMv);
        parcel.writeInt(this.uMw);
        parcel.writeParcelable(this.uMx, 0);
        parcel.writeInt(this.uMy);
        parcel.writeInt(this.uMz);
    }

    public int describeContents() {
        return 0;
    }
}
