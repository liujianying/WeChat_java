package com.tencent.mm.plugin.setting.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class UserAuthItemParcelable implements Parcelable {
    public static final Creator<UserAuthItemParcelable> CREATOR = new 1();
    public String mPl;
    public int mPm;
    public String scope;
    public int state;

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.scope);
        parcel.writeString(this.mPl);
        parcel.writeInt(this.state);
        parcel.writeInt(this.mPm);
    }
}
