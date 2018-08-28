package com.tencent.mm.plugin.appbrand.jsapi.media;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.ProcessResult;

final class JsApiChooseMedia$ChooseResult extends ProcessResult {
    public static final Creator<JsApiChooseMedia$ChooseResult> CREATOR = new 1();
    int bjW;
    String fUD;
    String type;

    protected final void i(Parcel parcel) {
        this.bjW = parcel.readInt();
        this.type = parcel.readString();
        this.fUD = parcel.readString();
    }

    public final int describeContents() {
        return 0;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.bjW);
        parcel.writeString(this.type);
        parcel.writeString(this.fUD);
    }

    JsApiChooseMedia$ChooseResult() {
    }

    JsApiChooseMedia$ChooseResult(Parcel parcel) {
        i(parcel);
    }
}
