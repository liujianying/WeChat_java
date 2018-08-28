package com.tencent.mm.plugin.appbrand.jsapi.file;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask$ProcessRequest;
import com.tencent.mm.plugin.appbrand.jsapi.file.JsApiOpenDocument.a;

final class JsApiOpenDocument$OpenRequest extends AppBrandProxyUIProcessTask$ProcessRequest {
    public static final Creator<JsApiOpenDocument$OpenRequest> CREATOR = new 1();
    public String filePath;
    public String fjS;

    protected final Class<? extends AppBrandProxyUIProcessTask> ahF() {
        return a.class;
    }

    protected final String ahE() {
        return "QbDocumentReader";
    }

    protected final void i(Parcel parcel) {
        super.i(parcel);
        this.filePath = parcel.readString();
        this.fjS = parcel.readString();
    }

    public final int describeContents() {
        return 0;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeString(this.filePath);
        parcel.writeString(this.fjS);
    }

    JsApiOpenDocument$OpenRequest() {
    }

    JsApiOpenDocument$OpenRequest(Parcel parcel) {
        super(parcel);
    }
}
