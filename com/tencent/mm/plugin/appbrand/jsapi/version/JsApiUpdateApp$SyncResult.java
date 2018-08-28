package com.tencent.mm.plugin.appbrand.jsapi.version;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

final class JsApiUpdateApp$SyncResult implements Parcelable {
    public static final Creator<JsApiUpdateApp$SyncResult> CREATOR = new 1();
    private int cbu;
    private boolean fZK;

    JsApiUpdateApp$SyncResult(boolean z, int i) {
        this.fZK = z;
        this.cbu = i;
    }

    public final int describeContents() {
        return 0;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeByte(this.fZK ? (byte) 1 : (byte) 0);
        parcel.writeInt(this.cbu);
    }

    JsApiUpdateApp$SyncResult(Parcel parcel) {
        this.fZK = parcel.readByte() != (byte) 0;
        this.cbu = parcel.readInt();
    }
}
