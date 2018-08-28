package com.tencent.tencentmap.mapsdk.a;

import android.os.Parcel;
import android.os.Parcelable.Creator;

class ox$1 implements Creator<ox> {
    ox$1() {
    }

    /* renamed from: a */
    public final ox[] newArray(int i) {
        return new ox[i];
    }

    /* renamed from: a */
    public final ox createFromParcel(Parcel parcel) {
        return new ox(parcel, null);
    }
}
