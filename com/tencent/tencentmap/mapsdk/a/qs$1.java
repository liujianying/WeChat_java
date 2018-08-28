package com.tencent.tencentmap.mapsdk.a;

import android.os.Parcel;
import android.os.Parcelable.Creator;

class qs$1 implements Creator<qs> {
    qs$1() {
    }

    /* renamed from: a */
    public final qs createFromParcel(Parcel parcel) {
        float readFloat = parcel.readFloat();
        float readFloat2 = parcel.readFloat();
        return new qs(new qw((double) readFloat, (double) readFloat2), parcel.readFloat());
    }

    /* renamed from: a */
    public final qs[] newArray(int i) {
        return new qs[i];
    }
}
