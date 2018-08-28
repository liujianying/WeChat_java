package com.tencent.mm.plugin.appbrand.dynamic.launching;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class WidgetRuntimeConfig implements Parcelable {
    public static final Creator<WidgetRuntimeConfig> CREATOR = new 1();
    public String appId;
    public int fwV;
    public int fxl = 32;
    public boolean fxm = false;
    public boolean fxn = true;

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        int i2;
        int i3 = 1;
        parcel.writeString(this.appId);
        parcel.writeInt(this.fwV);
        parcel.writeInt(this.fxl);
        if (this.fxm) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        parcel.writeInt(i2);
        if (!this.fxn) {
            i3 = 0;
        }
        parcel.writeInt(i3);
    }
}
