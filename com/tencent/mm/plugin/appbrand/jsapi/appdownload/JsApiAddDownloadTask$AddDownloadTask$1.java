package com.tencent.mm.plugin.appbrand.jsapi.appdownload;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mm.plugin.appbrand.jsapi.appdownload.JsApiAddDownloadTask.AddDownloadTask;

class JsApiAddDownloadTask$AddDownloadTask$1 implements Creator<AddDownloadTask> {
    JsApiAddDownloadTask$AddDownloadTask$1() {
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        return new AddDownloadTask(parcel);
    }

    public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
        return new AddDownloadTask[i];
    }
}
