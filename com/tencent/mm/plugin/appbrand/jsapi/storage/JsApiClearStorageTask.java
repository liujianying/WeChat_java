package com.tencent.mm.plugin.appbrand.jsapi.storage;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mm.plugin.appbrand.app.e;
import com.tencent.mm.plugin.appbrand.appstorage.c;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;

class JsApiClearStorageTask extends MainProcessTask {
    public static final Creator<JsApiClearStorageTask> CREATOR = new 1();
    public String appId;

    public JsApiClearStorageTask(Parcel parcel) {
        g(parcel);
    }

    public final void aai() {
        c aaZ = e.aaZ();
        if (aaZ != null) {
            aaZ.clear(this.appId);
        }
    }

    public final void g(Parcel parcel) {
        this.appId = parcel.readString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.appId);
    }
}
