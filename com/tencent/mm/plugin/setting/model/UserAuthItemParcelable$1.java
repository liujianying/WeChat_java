package com.tencent.mm.plugin.setting.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;

class UserAuthItemParcelable$1 implements Creator<UserAuthItemParcelable> {
    UserAuthItemParcelable$1() {
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        UserAuthItemParcelable userAuthItemParcelable = new UserAuthItemParcelable();
        userAuthItemParcelable.scope = parcel.readString();
        userAuthItemParcelable.mPl = parcel.readString();
        userAuthItemParcelable.state = parcel.readInt();
        userAuthItemParcelable.mPm = parcel.readInt();
        return userAuthItemParcelable;
    }

    public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
        return new UserAuthItemParcelable[i];
    }
}
