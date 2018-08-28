package com.tencent.mm.plugin.appbrand.jsapi.storage;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mm.plugin.appbrand.app.e;
import com.tencent.mm.plugin.appbrand.appstorage.c;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;

public class JsApiRemoveStorageTask extends MainProcessTask {
    public static final Creator<JsApiRemoveStorageTask> CREATOR = new 1();
    public String aAL;
    public String appId;

    public final void aai() {
        c aaZ = e.aaZ();
        if (aaZ != null) {
            aaZ.aU(this.appId, this.aAL);
        }
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.appId);
        parcel.writeString(this.aAL);
    }

    public final void g(Parcel parcel) {
        this.appId = parcel.readString();
        this.aAL = parcel.readString();
    }
}
