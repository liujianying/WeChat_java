package com.tencent.mm.plugin.wallet_core.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.sdk.platformtools.bi;

public class Authen implements Parcelable {
    public static final Creator<Authen> CREATOR = new 1();
    public int bWA;
    public String country;
    public String csD;
    public String csK;
    public String csL;
    public String dRH;
    public String eXM;
    public String knG;
    public String lMV;
    public String lMW;
    public PayInfo mpb = new PayInfo();
    public String pcx;
    public String pjw;
    public int plh = 0;
    public String pli;
    public String plj;
    public String plk;
    public int pll;
    public String plm;
    public String pln;
    public String plo;
    public String plp;
    public String plq;
    public String plr;
    public String pls;
    public String plt;
    public String plu;
    public String plv;
    public String plw;
    public String plx;
    public String ply;
    public String plz;
    public String token;

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.bWA);
        parcel.writeString(bi.aG(this.pli, ""));
        parcel.writeString(bi.aG(this.lMV, ""));
        parcel.writeString(bi.aG(this.lMW, ""));
        parcel.writeString(bi.aG(this.plj, ""));
        parcel.writeString(bi.aG(this.plk, ""));
        parcel.writeInt(this.pll);
        parcel.writeString(bi.aG(this.pjw, ""));
        parcel.writeString(bi.aG(this.plm, ""));
        parcel.writeString(bi.aG(this.pln, ""));
        parcel.writeString(bi.aG(this.plo, ""));
        parcel.writeString(bi.aG(this.token, ""));
        parcel.writeString(bi.aG(this.plr, ""));
        parcel.writeString(bi.aG(this.pls, ""));
        parcel.writeString(bi.aG(this.country, ""));
        parcel.writeString(bi.aG(this.csK, ""));
        parcel.writeString(bi.aG(this.csL, ""));
        parcel.writeString(bi.aG(this.dRH, ""));
        parcel.writeString(bi.aG(this.knG, ""));
        parcel.writeString(bi.aG(this.eXM, ""));
        parcel.writeString(bi.aG(this.csD, ""));
        parcel.writeString(bi.aG(this.pcx, ""));
        parcel.writeString(bi.aG(this.plt, ""));
        parcel.writeString(bi.aG(this.plu, ""));
        parcel.writeString(bi.aG(this.plq, ""));
        parcel.writeString(bi.aG(this.plv, ""));
        parcel.writeString(bi.aG(this.plw, ""));
        parcel.writeString(bi.aG(this.plx, ""));
        parcel.writeString(bi.aG(this.ply, ""));
        parcel.writeString(bi.aG(this.plz, ""));
    }

    public Authen(Parcel parcel) {
        this.bWA = parcel.readInt();
        this.pli = parcel.readString();
        this.lMV = parcel.readString();
        this.lMW = parcel.readString();
        this.plj = parcel.readString();
        this.plk = parcel.readString();
        this.pll = parcel.readInt();
        this.pjw = parcel.readString();
        this.plm = parcel.readString();
        this.pln = parcel.readString();
        this.plo = parcel.readString();
        this.token = parcel.readString();
        this.plr = parcel.readString();
        this.pls = parcel.readString();
        this.country = parcel.readString();
        this.csK = parcel.readString();
        this.csL = parcel.readString();
        this.dRH = parcel.readString();
        this.knG = parcel.readString();
        this.eXM = parcel.readString();
        this.csD = parcel.readString();
        this.pcx = parcel.readString();
        this.plt = parcel.readString();
        this.plu = parcel.readString();
        this.plq = parcel.readString();
        this.plv = parcel.readString();
        this.plw = parcel.readString();
        this.plx = parcel.readString();
        this.ply = parcel.readString();
        this.plz = parcel.readString();
    }
}
