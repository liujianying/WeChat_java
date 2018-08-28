package com.tencent.mm.ipcinvoker.extension.event;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.mm.ipcinvoker.extension.a;
import com.tencent.mm.ipcinvoker.extension.c;

class WrapperParcelable implements Parcelable {
    public static final Creator<WrapperParcelable> CREATOR = new 1();
    Object dna;

    /* synthetic */ WrapperParcelable(byte b) {
        this();
    }

    private WrapperParcelable() {
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        if (this.dna != null) {
            a ax = c.ax(this.dna);
            if (ax != null) {
                parcel.writeInt(1);
                parcel.writeString(ax.getClass().getName());
                ax.a(this.dna, parcel);
                return;
            }
        }
        parcel.writeInt(1);
    }
}
