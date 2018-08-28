package com.tencent.mm.plugin.remittance.bankcard.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.mm.protocal.c.bty;
import java.util.ArrayList;
import java.util.List;

public class TransferRecordParcel implements Parcelable {
    public static final Creator<TransferRecordParcel> CREATOR = new 1();
    public String knE;
    public String lMV;
    public String muA;
    public String muB;
    public String muC;
    public String muD;
    public String mug;

    private TransferRecordParcel(bty bty) {
        this.muA = bty.muA;
        this.muB = bty.muB;
        this.mug = bty.mug;
        this.knE = bty.knE;
        this.lMV = bty.lMV;
        this.muC = bty.muC;
        this.muD = bty.muD;
    }

    protected TransferRecordParcel(Parcel parcel) {
        this.muA = parcel.readString();
        this.muB = parcel.readString();
        this.mug = parcel.readString();
        this.knE = parcel.readString();
        this.lMV = parcel.readString();
        this.muC = parcel.readString();
        this.muD = parcel.readString();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.muA);
        parcel.writeString(this.muB);
        parcel.writeString(this.mug);
        parcel.writeString(this.knE);
        parcel.writeString(this.lMV);
        parcel.writeString(this.muC);
        parcel.writeString(this.muD);
    }

    public static ArrayList<TransferRecordParcel> bT(List<bty> list) {
        if (list == null) {
            return null;
        }
        ArrayList<TransferRecordParcel> arrayList = new ArrayList();
        for (bty transferRecordParcel : list) {
            arrayList.add(new TransferRecordParcel(transferRecordParcel));
        }
        return arrayList;
    }
}
