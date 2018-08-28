package com.tencent.mm.ipcinvoker.extension;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class XParcelableWrapper implements Parcelable {
    public static final Creator<XParcelableWrapper> CREATOR = new 1();
    public f dne;

    /* synthetic */ XParcelableWrapper(byte b) {
        this();
    }

    private XParcelableWrapper() {
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        if (this.dne != null) {
            parcel.writeInt(1);
            parcel.writeString(this.dne.getClass().getName());
            this.dne.f(parcel);
            return;
        }
        parcel.writeInt(0);
    }
}
