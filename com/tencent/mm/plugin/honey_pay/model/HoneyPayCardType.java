package com.tencent.mm.plugin.honey_pay.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.mm.protocal.c.alq;
import com.tencent.mm.sdk.platformtools.x;

public class HoneyPayCardType implements Parcelable {
    public static final Creator<HoneyPayCardType> CREATOR = new 1();
    public byte[] lR;

    public HoneyPayCardType(alq alq) {
        try {
            this.lR = alq.toByteArray();
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.HoneyPayCardType", e, "", new Object[0]);
        }
    }

    protected HoneyPayCardType(Parcel parcel) {
        this.lR = new byte[parcel.readInt()];
        parcel.readByteArray(this.lR);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.lR.length);
        parcel.writeByteArray(this.lR);
    }
}
