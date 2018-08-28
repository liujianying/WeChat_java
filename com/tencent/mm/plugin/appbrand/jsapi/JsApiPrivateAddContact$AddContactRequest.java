package com.tencent.mm.plugin.appbrand.jsapi;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.ProcessRequest;
import com.tencent.mm.plugin.appbrand.jsapi.JsApiPrivateAddContact.a;

final class JsApiPrivateAddContact$AddContactRequest extends ProcessRequest {
    public static final Creator<JsApiPrivateAddContact$AddContactRequest> CREATOR = new 1();
    int fGD;
    int scene;
    String userName;

    JsApiPrivateAddContact$AddContactRequest() {
    }

    JsApiPrivateAddContact$AddContactRequest(Parcel parcel) {
        i(parcel);
    }

    protected final Class<? extends AppBrandProxyUIProcessTask> ahF() {
        return a.class;
    }

    public final void i(Parcel parcel) {
        this.userName = parcel.readString();
        this.scene = parcel.readInt();
        this.fGD = parcel.readInt();
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.userName);
        parcel.writeInt(this.scene);
        parcel.writeInt(this.fGD);
    }
}
