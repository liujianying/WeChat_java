package com.tencent.mm.pluginsdk.wallet;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class PayInfo implements Parcelable {
    public static final Creator<PayInfo> CREATOR = new Creator<PayInfo>() {
        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new PayInfo(parcel);
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new PayInfo[i];
        }
    };
    public String Yy;
    public String appId;
    public String bKk;
    public String bOd;
    public int bPZ;
    public String bQb;
    public String bQc;
    public String bVE = "";
    public int bVU;
    public int bVY = 0;
    public int bVZ = -1;
    public String cdL;
    public String fMk;
    public String fky;
    public String hvl;
    public boolean jNf = false;
    public int myh = 0;
    public String pCO;
    public String partnerId;
    public int pxN = 0;
    public int pxO = 0;
    public int qUI = 0;
    public boolean qUJ = true;
    public String qUK;
    public Bundle qUL;
    public int qUM;
    public long qUN = 0;
    public int qUO = -1;
    public String qUP;
    public String qUQ;
    public int qUR = 1;
    public double qUS = 0.0d;

    public PayInfo(Parcel parcel) {
        boolean z = true;
        this.bVY = parcel.readInt();
        this.qUI = parcel.readInt();
        this.bOd = parcel.readString();
        this.fMk = parcel.readString();
        this.appId = parcel.readString();
        this.pCO = parcel.readString();
        this.partnerId = parcel.readString();
        this.cdL = parcel.readString();
        this.bKk = parcel.readString();
        this.Yy = parcel.readString();
        this.bVU = parcel.readInt();
        this.bVZ = parcel.readInt();
        this.jNf = parcel.readInt() == 1;
        if (parcel.readInt() != 1) {
            z = false;
        }
        this.qUJ = z;
        this.qUL = parcel.readBundle();
        this.pxN = parcel.readInt();
        this.bQb = parcel.readString();
        this.bQc = parcel.readString();
        this.bPZ = parcel.readInt();
        this.qUN = parcel.readLong();
        this.bVE = parcel.readString();
        this.qUP = parcel.readString();
        this.qUQ = parcel.readString();
        this.qUR = parcel.readInt();
        this.hvl = parcel.readString();
        this.fky = parcel.readString();
        this.myh = parcel.readInt();
        this.qUS = parcel.readDouble();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        int i2 = 1;
        parcel.writeInt(this.bVY);
        parcel.writeInt(this.qUI);
        parcel.writeString(this.bOd);
        parcel.writeString(this.fMk);
        parcel.writeString(this.appId);
        parcel.writeString(this.pCO);
        parcel.writeString(this.partnerId);
        parcel.writeString(this.cdL);
        parcel.writeString(this.bKk);
        parcel.writeString(this.Yy);
        parcel.writeInt(this.bVU);
        parcel.writeInt(this.bVZ);
        parcel.writeInt(this.jNf ? 1 : 0);
        if (!this.qUJ) {
            i2 = 0;
        }
        parcel.writeInt(i2);
        parcel.writeBundle(this.qUL);
        parcel.writeInt(this.pxN);
        parcel.writeString(this.bQb);
        parcel.writeString(this.bQc);
        parcel.writeInt(this.bPZ);
        parcel.writeLong(this.qUN);
        parcel.writeString(this.bVE);
        parcel.writeString(this.qUP);
        parcel.writeString(this.qUQ);
        parcel.writeInt(this.qUR);
        parcel.writeString(this.hvl);
        parcel.writeString(this.fky);
        parcel.writeInt(this.myh);
        parcel.writeDouble(this.qUS);
    }

    public String toString() {
        return String.format("sense : %d, reqKey : %s, uuid : %s, appId : %s, appSource : %s, partnerId : %s, paySign : %s, productId : %s, soterAuth: %s", new Object[]{Integer.valueOf(this.bVY), this.bOd, this.fMk, this.appId, this.pCO, this.partnerId, this.cdL, this.bKk, this.bVE});
    }
}
