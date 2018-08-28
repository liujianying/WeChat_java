package com.tencent.mm.modelgeo;

import android.os.Parcel;
import android.os.Parcelable.Creator;

class Addr$1 implements Creator<Addr> {
    Addr$1() {
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        Addr addr = new Addr();
        addr.dRH = parcel.readString();
        addr.country = parcel.readString();
        addr.dRI = parcel.readString();
        addr.dRJ = parcel.readString();
        addr.dRK = parcel.readString();
        addr.dRL = parcel.readString();
        addr.dRM = parcel.readString();
        addr.dRN = parcel.readString();
        addr.dRO = parcel.readString();
        addr.dRP = parcel.readString();
        addr.dRQ = parcel.readString();
        addr.dRS = parcel.readFloat();
        addr.dRT = parcel.readFloat();
        return addr;
    }

    public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
        return new Addr[i];
    }
}
