package com.tencent.mm.plugin.appbrand.jsapi.miniprogram_navigator;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

final class JsApiNavigateToDevMiniProgram$DevPkgInfo implements Parcelable {
    public static final Creator<JsApiNavigateToDevMiniProgram$DevPkgInfo> CREATOR = new 1();
    String appId;
    String cbv;
    String cbw;
    String fVN;

    JsApiNavigateToDevMiniProgram$DevPkgInfo() {
    }

    public final int describeContents() {
        return 0;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.appId);
        parcel.writeString(this.cbv);
        parcel.writeString(this.cbw);
        parcel.writeString(this.fVN);
    }

    JsApiNavigateToDevMiniProgram$DevPkgInfo(Parcel parcel) {
        this.appId = parcel.readString();
        this.cbv = parcel.readString();
        this.cbw = parcel.readString();
        this.fVN = parcel.readString();
    }
}
