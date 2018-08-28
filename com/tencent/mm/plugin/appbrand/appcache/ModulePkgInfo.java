package com.tencent.mm.plugin.appbrand.appcache;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes.e;

public class ModulePkgInfo extends e implements Parcelable {
    public static final Creator<ModulePkgInfo> CREATOR = new 1();
    public volatile String ffK;

    /* synthetic */ ModulePkgInfo(Parcel parcel, byte b) {
        this(parcel);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.ffK);
        parcel.writeString(this.name);
        parcel.writeString(this.bKg);
    }

    public void readFromParcel(Parcel parcel) {
        this.ffK = parcel.readString();
        this.name = parcel.readString();
        this.bKg = parcel.readString();
    }

    private ModulePkgInfo(Parcel parcel) {
        readFromParcel(parcel);
    }
}
