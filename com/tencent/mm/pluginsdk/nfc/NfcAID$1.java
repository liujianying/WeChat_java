package com.tencent.mm.pluginsdk.nfc;

import android.os.Parcel;
import android.os.Parcelable.Creator;

class NfcAID$1 implements Creator<NfcAID> {
    NfcAID$1() {
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        return new NfcAID(parcel);
    }

    public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
        return new NfcAID[i];
    }
}
