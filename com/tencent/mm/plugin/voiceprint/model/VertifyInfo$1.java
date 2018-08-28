package com.tencent.mm.plugin.voiceprint.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;

class VertifyInfo$1 implements Creator<VertifyInfo> {
    VertifyInfo$1() {
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        boolean z = true;
        VertifyInfo vertifyInfo = new VertifyInfo();
        vertifyInfo.oFi = parcel.readInt();
        vertifyInfo.oFj = parcel.readInt();
        vertifyInfo.oFk = parcel.readInt();
        vertifyInfo.oFa = parcel.readInt();
        vertifyInfo.gEw = parcel.readString();
        vertifyInfo.oET = parcel.readString();
        vertifyInfo.mFileName = parcel.readString();
        vertifyInfo.oFl = parcel.readInt() > 0;
        if (parcel.readInt() <= 0) {
            z = false;
        }
        vertifyInfo.oFm = z;
        vertifyInfo.oFa = vertifyInfo.oFi;
        return vertifyInfo;
    }

    public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
        return new VertifyInfo[i];
    }
}
