package com.tencent.mm.plugin.honey_pay.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;

class HoneyPayCardType$1 implements Creator<HoneyPayCardType> {
    HoneyPayCardType$1() {
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        return new HoneyPayCardType(parcel);
    }

    public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
        return new HoneyPayCardType[i];
    }
}
