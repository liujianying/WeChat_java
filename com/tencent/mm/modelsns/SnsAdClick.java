package com.tencent.mm.modelsns;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.mm.g.a.ng;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.bi;

public class SnsAdClick implements Parcelable {
    public static final Creator<SnsAdClick> CREATOR = new 1();
    public String egF;
    public long egG;
    public String egH;
    public String egI;
    public int egJ;
    public long egK;
    public int egL;
    public int egM;
    public int egN;
    public long egO;
    public long egP;
    public int scene;

    public SnsAdClick() {
        this.egF = "";
        this.scene = 0;
        this.egG = 0;
        this.egH = "";
        this.egI = "";
        this.egJ = 0;
        this.egK = 0;
        this.egL = 0;
        this.egM = 0;
        this.egN = 0;
        this.egO = 0;
        this.egP = 0;
    }

    public SnsAdClick(String str, int i, long j, String str2, int i2) {
        this.egF = "";
        this.scene = 0;
        this.egG = 0;
        this.egH = "";
        this.egI = "";
        this.egJ = 0;
        this.egK = 0;
        this.egL = 0;
        this.egM = 0;
        this.egN = 0;
        this.egO = 0;
        this.egP = 0;
        this.egF = str;
        this.scene = i;
        this.egG = j;
        this.egH = str2;
        this.egL = i2;
        this.egM = 1;
        this.egK = System.currentTimeMillis();
    }

    public SnsAdClick(String str, int i, long j, String str2, int i2, byte b) {
        this.egF = "";
        this.scene = 0;
        this.egG = 0;
        this.egH = "";
        this.egI = "";
        this.egJ = 0;
        this.egK = 0;
        this.egL = 0;
        this.egM = 0;
        this.egN = 0;
        this.egO = 0;
        this.egP = 0;
        this.egF = str;
        this.scene = i;
        this.egG = j;
        this.egH = str2;
        this.egL = i2;
        this.egM = 0;
        this.egK = System.currentTimeMillis();
    }

    public SnsAdClick(String str, String str2, int i, int i2) {
        this.egF = "";
        this.scene = 0;
        this.egG = 0;
        this.egH = "";
        this.egI = "";
        this.egJ = 0;
        this.egK = 0;
        this.egL = 0;
        this.egM = 0;
        this.egN = 0;
        this.egO = 0;
        this.egP = 0;
        this.egF = "";
        this.scene = 7;
        this.egI = str;
        this.egH = str2;
        this.egL = i;
        this.egM = 0;
        this.egN = i2;
        this.egK = System.currentTimeMillis();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.egF);
        parcel.writeInt(this.scene);
        parcel.writeInt(this.egJ);
        parcel.writeLong(this.egG);
        parcel.writeString(bi.aG(this.egH, ""));
        parcel.writeLong(this.egK);
        parcel.writeInt(this.egM);
        parcel.writeInt(this.egL);
        parcel.writeInt(this.egN);
        parcel.writeString(this.egI);
        parcel.writeLong(this.egP);
    }

    public final void in(int i) {
        Ry();
        ng ngVar = new ng();
        this.egJ = i;
        ngVar.bYk.bYl = this;
        a.sFg.m(ngVar);
    }

    public final void Ry() {
        if (this.egO > 0) {
            this.egP += bi.bI(this.egO);
            this.egO = 0;
        }
    }
}
