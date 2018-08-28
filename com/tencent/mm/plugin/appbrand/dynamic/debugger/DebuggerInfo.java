package com.tencent.mm.plugin.appbrand.dynamic.debugger;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class DebuggerInfo implements Parcelable {
    public static final Creator<DebuggerInfo> CREATOR = new 1();
    public boolean fvD;
    public boolean fvE;
    public boolean fvF;

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        int i2;
        int i3 = 1;
        if (this.fvD) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        parcel.writeInt(i2);
        if (this.fvE) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        parcel.writeInt(i2);
        if (!this.fvF) {
            i3 = 0;
        }
        parcel.writeInt(i3);
    }
}
