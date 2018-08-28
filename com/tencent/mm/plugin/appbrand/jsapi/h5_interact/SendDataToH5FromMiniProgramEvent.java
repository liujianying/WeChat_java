package com.tencent.mm.plugin.appbrand.jsapi.h5_interact;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.mm.sdk.b.b;

public class SendDataToH5FromMiniProgramEvent extends b implements Parcelable {
    public static final Creator<SendDataToH5FromMiniProgramEvent> CREATOR = new Creator<SendDataToH5FromMiniProgramEvent>() {
        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new SendDataToH5FromMiniProgramEvent(parcel);
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new SendDataToH5FromMiniProgramEvent[i];
        }
    };
    public String data;
    public String fQq;
    public int fQr;

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.fQq);
        parcel.writeString(this.data);
        parcel.writeInt(this.fQr);
    }

    protected SendDataToH5FromMiniProgramEvent(Parcel parcel) {
        this.fQq = parcel.readString();
        this.data = parcel.readString();
        this.fQr = parcel.readInt();
    }
}
