package com.tencent.mm.plugin.recharge.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class MallRechargeProduct implements Parcelable {
    public static final Creator<MallRechargeProduct> CREATOR = new 1();
    public String appId;
    public String bKk;
    public String ioy;
    public boolean isDefault;
    public float moA = 0.0f;
    public float moB = 0.0f;
    public boolean moC;
    public int moD;
    public int moE;
    public int moF;
    public final boolean moG;
    public boolean moH = true;
    public String moy;
    public String moz;

    public MallRechargeProduct(boolean z) {
        this.moG = z;
    }

    public final boolean isValid() {
        if (!this.moC || this.moD > 0) {
            return true;
        }
        return false;
    }

    public static void a(MallRechargeProduct mallRechargeProduct, MallRechargeProduct mallRechargeProduct2) {
        mallRechargeProduct2.appId = mallRechargeProduct.appId;
        mallRechargeProduct2.moy = mallRechargeProduct.moy;
        mallRechargeProduct2.bKk = mallRechargeProduct.bKk;
        mallRechargeProduct2.ioy = mallRechargeProduct.ioy;
        mallRechargeProduct2.moz = mallRechargeProduct.moz;
        mallRechargeProduct2.moA = mallRechargeProduct.moA;
        mallRechargeProduct2.moB = mallRechargeProduct.moB;
        mallRechargeProduct2.moC = mallRechargeProduct.moC;
        mallRechargeProduct2.moD = mallRechargeProduct.moD;
        mallRechargeProduct2.moE = mallRechargeProduct.moE;
        mallRechargeProduct2.isDefault = mallRechargeProduct.isDefault;
        mallRechargeProduct2.moH = mallRechargeProduct.moH;
        mallRechargeProduct2.moF = mallRechargeProduct.moF;
    }

    public int describeContents() {
        return 0;
    }

    public MallRechargeProduct(Parcel parcel) {
        boolean z;
        boolean z2 = true;
        this.moy = parcel.readString();
        this.appId = parcel.readString();
        this.bKk = parcel.readString();
        this.ioy = parcel.readString();
        this.moz = parcel.readString();
        this.moA = parcel.readFloat();
        this.moB = parcel.readFloat();
        this.moC = parcel.readInt() == 1;
        this.moD = parcel.readInt();
        this.moE = parcel.readInt();
        if (parcel.readInt() == 1) {
            z = true;
        } else {
            z = false;
        }
        this.isDefault = z;
        if (parcel.readInt() != 1) {
            z2 = false;
        }
        this.moG = z2;
        this.moF = parcel.readInt();
    }

    public void writeToParcel(Parcel parcel, int i) {
        int i2;
        int i3 = 1;
        parcel.writeString(this.moy);
        parcel.writeString(this.appId);
        parcel.writeString(this.bKk);
        parcel.writeString(this.ioy);
        parcel.writeString(this.moz);
        parcel.writeFloat(this.moA);
        parcel.writeFloat(this.moB);
        parcel.writeInt(this.moC ? 1 : 0);
        parcel.writeInt(this.moD);
        parcel.writeInt(this.moE);
        if (this.isDefault) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        parcel.writeInt(i2);
        if (!this.moG) {
            i3 = 0;
        }
        parcel.writeInt(i3);
        parcel.writeInt(this.moF);
    }
}
