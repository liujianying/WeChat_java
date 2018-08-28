package com.google.android.gms.gcm;

import android.os.Parcel;
import android.os.Parcelable.Creator;

class PendingCallback$1 implements Creator<PendingCallback> {
    PendingCallback$1() {
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        return new PendingCallback(parcel);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new PendingCallback[i];
    }
}
