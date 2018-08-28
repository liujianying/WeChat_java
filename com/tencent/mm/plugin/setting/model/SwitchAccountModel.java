package com.tencent.mm.plugin.setting.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class SwitchAccountModel implements Parcelable {
    public static final Creator<SwitchAccountModel> CREATOR = new Creator<SwitchAccountModel>() {
        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new SwitchAccountModel(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readInt());
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new SwitchAccountModel[i];
        }
    };
    public final String jed;
    public final String mOP;
    public final String mOQ;
    public final int mOR;
    public final String username;

    public SwitchAccountModel(String str, String str2, String str3, String str4, int i) {
        this.mOP = str;
        this.username = str2;
        this.jed = str3;
        this.mOQ = str4;
        this.mOR = i;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.mOP);
        parcel.writeString(this.username);
        parcel.writeString(this.jed);
        parcel.writeString(this.mOQ);
        parcel.writeInt(this.mOR);
    }
}
