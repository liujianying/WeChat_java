package com.tencent.mm.plugin.appbrand.jsapi.media;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mm.plugin.appbrand.appstorage.AppBrandLocalVideoObject;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.ProcessResult;

final class JsApiChooseVideo$ChooseResult extends ProcessResult {
    public static final Creator<JsApiChooseVideo$ChooseResult> CREATOR = new 1();
    int bjW;
    AppBrandLocalVideoObject fUR;

    protected final void i(Parcel parcel) {
        this.bjW = parcel.readInt();
        this.fUR = (AppBrandLocalVideoObject) parcel.readParcelable(AppBrandLocalVideoObject.class.getClassLoader());
    }

    public final int describeContents() {
        return 0;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.bjW);
        parcel.writeParcelable(this.fUR, i);
    }

    JsApiChooseVideo$ChooseResult() {
    }

    JsApiChooseVideo$ChooseResult(Parcel parcel) {
        i(parcel);
    }
}
