package com.tencent.mm.pluginsdk.nfc;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class NfcAID implements Parcelable {
    public static final Creator<NfcAID> CREATOR = new 1();
    public String mURL = null;
    public String qBe = null;

    public int describeContents() {
        return 0;
    }

    public NfcAID(Parcel parcel) {
        this.qBe = parcel.readString();
        this.mURL = parcel.readString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.qBe);
        parcel.writeString(this.mURL);
    }
}
