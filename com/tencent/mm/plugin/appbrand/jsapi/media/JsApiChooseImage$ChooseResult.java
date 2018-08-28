package com.tencent.mm.plugin.appbrand.jsapi.media;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mm.plugin.appbrand.appstorage.AppBrandLocalMediaObject;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.ProcessResult;
import java.util.ArrayList;

final class JsApiChooseImage$ChooseResult extends ProcessResult {
    public static final Creator<JsApiChooseImage$ChooseResult> CREATOR = new Creator<JsApiChooseImage$ChooseResult>() {
        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new JsApiChooseImage$ChooseResult(parcel);
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new JsApiChooseImage$ChooseResult[i];
        }
    };
    int bjW;
    ArrayList<AppBrandLocalMediaObject> fUk;

    protected final void i(Parcel parcel) {
        this.bjW = parcel.readInt();
        this.fUk = parcel.createTypedArrayList(AppBrandLocalMediaObject.CREATOR);
    }

    public final int describeContents() {
        return 0;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.bjW);
        parcel.writeTypedList(this.fUk);
    }

    JsApiChooseImage$ChooseResult() {
    }

    JsApiChooseImage$ChooseResult(Parcel parcel) {
        super(parcel);
    }
}
