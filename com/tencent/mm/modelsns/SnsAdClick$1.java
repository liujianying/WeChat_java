package com.tencent.mm.modelsns;

import android.os.Parcel;
import android.os.Parcelable.Creator;

class SnsAdClick$1 implements Creator<SnsAdClick> {
    SnsAdClick$1() {
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        SnsAdClick snsAdClick = new SnsAdClick();
        snsAdClick.egF = parcel.readString();
        snsAdClick.scene = parcel.readInt();
        snsAdClick.egJ = parcel.readInt();
        snsAdClick.egG = parcel.readLong();
        snsAdClick.egH = parcel.readString();
        snsAdClick.egK = parcel.readLong();
        snsAdClick.egM = parcel.readInt();
        snsAdClick.egL = parcel.readInt();
        snsAdClick.egN = parcel.readInt();
        snsAdClick.egI = parcel.readString();
        snsAdClick.egP = parcel.readLong();
        return snsAdClick;
    }

    public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
        return new SnsAdClick[i];
    }
}
