package com.tencent.mm.plugin.appbrand.jsapi.appdownload;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mm.plugin.appbrand.jsapi.appdownload.JsApiAddDownloadTaskStraight.AddDownloadTaskStraightTask;

class JsApiAddDownloadTaskStraight$AddDownloadTaskStraightTask$1 implements Creator<AddDownloadTaskStraightTask> {
    JsApiAddDownloadTaskStraight$AddDownloadTaskStraightTask$1() {
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        return new AddDownloadTaskStraightTask(parcel);
    }

    public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
        return new AddDownloadTaskStraightTask[i];
    }
}
