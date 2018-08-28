package com.tencent.mm.plugin.appbrand.jsapi.appdownload;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mm.plugin.appbrand.jsapi.appdownload.JsApiInstallDownloadTask.InstallDownloadTask;

class JsApiInstallDownloadTask$InstallDownloadTask$1 implements Creator<InstallDownloadTask> {
    JsApiInstallDownloadTask$InstallDownloadTask$1() {
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        return new InstallDownloadTask(parcel);
    }

    public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
        return new InstallDownloadTask[i];
    }
}
