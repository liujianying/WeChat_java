package com.tencent.mm.plugin.wallet_core.model.mall;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class MallNews implements Parcelable {
    public static final Creator<MallNews> CREATOR = new 1();
    public String bLe;
    public String oqH;
    public int ppS;
    public String psa = "0";
    public String psb = "0";
    public String psc;
    public String psd;
    public String pse;
    public String psf;
    public int psg;
    public String psh;
    public int psi;
    public String psj;
    public String psk;
    public int showType;
    public String type;

    public MallNews(String str) {
        this.psc = str;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof MallNews)) {
            return false;
        }
        MallNews mallNews = (MallNews) obj;
        if (this.psc == null || !this.psc.equals(mallNews.psc) || this.oqH == null || !this.oqH.equals(mallNews.oqH)) {
            return false;
        }
        return true;
    }

    public MallNews(Parcel parcel) {
        this.psc = parcel.readString();
        this.oqH = parcel.readString();
        this.bLe = parcel.readString();
        this.psd = parcel.readString();
        this.pse = parcel.readString();
        this.psf = parcel.readString();
        this.psg = parcel.readInt();
        this.psh = parcel.readString();
        this.psa = parcel.readString();
        this.psb = parcel.readString();
        this.showType = parcel.readInt();
        this.psj = parcel.readString();
        this.ppS = parcel.readInt();
        this.psk = parcel.readString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.psc);
        parcel.writeString(this.oqH);
        parcel.writeString(this.bLe);
        parcel.writeString(this.psd);
        parcel.writeString(this.pse);
        parcel.writeString(this.psf);
        parcel.writeInt(this.psg);
        parcel.writeString(this.psh);
        parcel.writeString(this.psa);
        parcel.writeString(this.psb);
        parcel.writeInt(this.showType);
        parcel.writeString(this.psj);
        parcel.writeInt(this.ppS);
        parcel.writeString(this.psk);
    }

    public int describeContents() {
        return 0;
    }

    public String toString() {
        return String.format("functionId : %s, activityId : %s, ticket : %s, activityMsg : %s, activityLink : %s, activityIconLink : %s, showFlag : %s, orgStr : %s, activityTips: %s, activityType: %d, activityUrl: %s", new Object[]{this.psc, this.oqH, this.bLe, this.psd, this.pse, this.psf, this.psa, this.psj, this.psh, Integer.valueOf(this.ppS), this.psk});
    }
}
