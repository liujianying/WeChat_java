package com.tencent.mm.plugin.appbrand.jsapi.media;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.ProcessRequest;

final class JsApiChooseMedia$ChooseRequest extends ProcessRequest {
    public static final Creator<JsApiChooseMedia$ChooseRequest> CREATOR = new 1();
    String appId;
    int count;
    boolean fUA;
    boolean fUB;
    boolean fUC;
    boolean fUi;
    boolean fUj;
    boolean fUz;
    boolean isFront;
    int maxDuration;

    protected final Class<? extends AppBrandProxyUIProcessTask> ahF() {
        return JsApiChooseMedia$a.class;
    }

    protected final String ahE() {
        return "GalleryChooseMedia";
    }

    protected final void i(Parcel parcel) {
        boolean z;
        boolean z2 = true;
        this.appId = parcel.readString();
        this.fUz = parcel.readByte() != (byte) 0;
        if (parcel.readByte() != (byte) 0) {
            z = true;
        } else {
            z = false;
        }
        this.fUA = z;
        if (parcel.readByte() != (byte) 0) {
            z = true;
        } else {
            z = false;
        }
        this.fUB = z;
        if (parcel.readByte() != (byte) 0) {
            z = true;
        } else {
            z = false;
        }
        this.fUC = z;
        if (parcel.readByte() != (byte) 0) {
            z = true;
        } else {
            z = false;
        }
        this.isFront = z;
        this.maxDuration = parcel.readInt();
        this.count = parcel.readInt();
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
        parcel.writeByte(this.fUz ? (byte) 1 : (byte) 0);
        if (this.fUA) {
            b = (byte) 1;
        } else {
            b = (byte) 0;
        }
        parcel.writeByte(b);
        if (this.fUB) {
            b = (byte) 1;
        } else {
            b = (byte) 0;
        }
        parcel.writeByte(b);
        if (this.fUC) {
            b = (byte) 1;
        } else {
            b = (byte) 0;
        }
        parcel.writeByte(b);
        if (this.isFront) {
            b = (byte) 1;
        } else {
            b = (byte) 0;
        }
        parcel.writeByte(b);
        parcel.writeInt(this.maxDuration);
        parcel.writeInt(this.count);
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

    protected final boolean ahD() {
        return true;
    }

    JsApiChooseMedia$ChooseRequest() {
    }

    JsApiChooseMedia$ChooseRequest(Parcel parcel) {
        i(parcel);
    }
}
