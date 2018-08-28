package com.tencent.mm.plugin.appbrand.jsapi.appdownload;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mm.plugin.appbrand.jsapi.appdownload.JsApiCancelDownloadTask.CancelDownloadTask;

class JsApiCancelDownloadTask$CancelDownloadTask$1 implements Creator<CancelDownloadTask> {
    JsApiCancelDownloadTask$CancelDownloadTask$1() {
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        return new CancelDownloadTask(parcel, (byte) 0);
    }

    public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
        return new CancelDownloadTask[i];
    }
}
