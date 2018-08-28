package com.tencent.mm.plugin.remittance.bankcard.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.mm.protocal.c.ua;

public class EnterTimeParcel implements Parcelable {
    public static final Creator<EnterTimeParcel> CREATOR = new 1();
    public String dxh;
    public int mun;
    public String muo;
    public String mup;
    public int muq;

    public EnterTimeParcel(ua uaVar) {
        this.mun = uaVar.mun;
        this.muo = uaVar.muo;
        this.mup = uaVar.mup;
        this.muq = uaVar.muq;
        this.dxh = uaVar.dxh;
    }

    public EnterTimeParcel(Parcel parcel) {
        this.mun = parcel.readInt();
        this.muo = parcel.readString();
        this.mup = parcel.readString();
        this.muq = parcel.readInt();
        this.dxh = parcel.readString();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.mun);
        parcel.writeString(this.muo);
        parcel.writeString(this.mup);
        parcel.writeInt(this.muq);
        parcel.writeString(this.dxh);
    }
}
