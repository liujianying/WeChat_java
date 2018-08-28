package com.tencent.mm.plugin.appbrand.jsapi.media;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.ProcessRequest;
import com.tencent.mm.plugin.appbrand.jsapi.media.JsApiChooseImage.a;

final class JsApiChooseImage$ChooseRequest extends ProcessRequest {
    public static final Creator<JsApiChooseImage$ChooseRequest> CREATOR = new 1();
    String appId;
    int count;
    boolean fUg;
    boolean fUh;
    boolean fUi;
    boolean fUj;

    protected final Class<? extends AppBrandProxyUIProcessTask> ahF() {
        return a.class;
    }

    protected final void i(Parcel parcel) {
        boolean z;
        boolean z2 = true;
        this.appId = parcel.readString();
        this.count = parcel.readInt();
        if (parcel.readByte() != (byte) 0) {
            z = true;
        } else {
            z = false;
        }
        this.fUg = z;
        if (parcel.readByte() != (byte) 0) {
            z = true;
        } else {
            z = false;
        }
        this.fUh = z;
        if (parcel.readByte() != (byte) 0) {
            z = true;
        } else {
            z = false;
        }
        this.fUi = z;
        if (parcel.readByte() == (byte) 0) {
            z2 = false;
        }
        this.fUj = z2;
    }

    public final int describeContents() {
        return 0;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        byte b;
        byte b2 = (byte) 1;
        parcel.writeString(this.appId);
        parcel.writeInt(this.count);
        if (this.fUg) {
            b = (byte) 1;
        } else {
            b = (byte) 0;
        }
        parcel.writeByte(b);
        if (this.fUh) {
            b = (byte) 1;
        } else {
            b = (byte) 0;
        }
        parcel.writeByte(b);
        if (this.fUi) {
            b = (byte) 1;
        } else {
            b = (byte) 0;
        }
        parcel.writeByte(b);
        if (!this.fUj) {
            b2 = (byte) 0;
        }
        parcel.writeByte(b2);
    }

    protected final String ahE() {
        return "GalleryChooseImage";
    }

    protected final boolean ahD() {
        return true;
    }

    JsApiChooseImage$ChooseRequest() {
    }

    JsApiChooseImage$ChooseRequest(Parcel parcel) {
        i(parcel);
    }
}
