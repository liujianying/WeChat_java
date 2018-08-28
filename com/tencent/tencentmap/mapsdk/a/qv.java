package com.tencent.tencentmap.mapsdk.a;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class qv implements Parcelable {
    public static final Creator<qv> CREATOR = new 1();
    private int a;
    private int b;

    public qv(int i, int i2) {
        this.a = 0;
        this.b = 0;
        this.a = i;
        this.b = i2;
    }

    private qv(Parcel parcel) {
        this.a = 0;
        this.b = 0;
        this.a = parcel.readInt();
        this.b = parcel.readInt();
    }

    public int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (obj == null || obj.getClass() != getClass()) {
            return false;
        }
        qv qvVar = (qv) obj;
        return this.a == qvVar.a && this.b == qvVar.b;
    }

    public final int hashCode() {
        return (this.b * 7) + (this.a * 11);
    }

    public final String toString() {
        return this.a + "," + this.b;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.a);
        parcel.writeInt(this.b);
    }
}
