package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.wearable.l;

public class MessageEventParcelable implements SafeParcelable, l {
    public static final Creator<MessageEventParcelable> CREATOR = new aa();
    final String aYw;
    final byte[] bdf;
    final int beF;
    final String ben;
    final int mVersionCode;

    MessageEventParcelable(int i, int i2, String str, byte[] bArr, String str2) {
        this.mVersionCode = i;
        this.beF = i2;
        this.ben = str;
        this.bdf = bArr;
        this.aYw = str2;
    }

    public int describeContents() {
        return 0;
    }

    public final byte[] getData() {
        return this.bdf;
    }

    public final String getPath() {
        return this.ben;
    }

    public String toString() {
        return "MessageEventParcelable[" + this.beF + "," + this.ben + ", size=" + (this.bdf == null ? "null" : Integer.valueOf(this.bdf.length)) + "]";
    }

    public void writeToParcel(Parcel parcel, int i) {
        aa.a(this, parcel);
    }
}
