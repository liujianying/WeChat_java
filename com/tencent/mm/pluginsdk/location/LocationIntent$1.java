package com.tencent.mm.pluginsdk.location;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mm.modelgeo.Addr;
import com.tencent.mm.sdk.platformtools.bi;

class LocationIntent$1 implements Creator<LocationIntent> {
    LocationIntent$1() {
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        LocationIntent locationIntent = new LocationIntent();
        locationIntent.lat = parcel.readDouble();
        locationIntent.lng = parcel.readDouble();
        locationIntent.bSz = parcel.readInt();
        locationIntent.label = parcel.readString();
        locationIntent.kFa = bi.aG(parcel.readString(), "");
        locationIntent.qyA = bi.aG(parcel.readString(), "");
        locationIntent.kCB = bi.aG(parcel.readString(), "");
        locationIntent.qyB = parcel.readInt();
        locationIntent.dSa = (Addr) parcel.readParcelable(Addr.class.getClassLoader());
        return locationIntent;
    }

    public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
        return new LocationIntent[i];
    }
}
