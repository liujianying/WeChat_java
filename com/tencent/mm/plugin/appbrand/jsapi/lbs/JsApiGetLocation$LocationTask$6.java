package com.tencent.mm.plugin.appbrand.jsapi.lbs;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mm.plugin.appbrand.jsapi.lbs.JsApiGetLocation.LocationTask;

class JsApiGetLocation$LocationTask$6 implements Creator<LocationTask> {
    JsApiGetLocation$LocationTask$6() {
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        return new LocationTask(parcel);
    }

    public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
        return new LocationTask[i];
    }
}
