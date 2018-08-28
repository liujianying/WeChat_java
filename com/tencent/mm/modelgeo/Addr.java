package com.tencent.mm.modelgeo;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.mm.sdk.platformtools.bi;

public class Addr implements Parcelable {
    public static final Creator<Addr> CREATOR = new 1();
    public String country;
    public String dRH;
    public String dRI;
    public String dRJ;
    public String dRK;
    public String dRL;
    public String dRM;
    public String dRN;
    public String dRO;
    public String dRP;
    public String dRQ;
    public String dRR;
    public float dRS;
    public float dRT;
    public Object tag = "";

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("address='" + this.dRH + '\'');
        stringBuilder.append(", country='" + this.country + '\'');
        stringBuilder.append(", administrative_area_level_1='" + this.dRI + '\'');
        stringBuilder.append(", locality='" + this.dRJ + '\'');
        stringBuilder.append(", locality_shi='" + this.dRK + '\'');
        stringBuilder.append(", sublocality='" + this.dRL + '\'');
        stringBuilder.append(", neighborhood='" + this.dRM + '\'');
        stringBuilder.append(", route='" + this.dRN + '\'');
        stringBuilder.append(", streetNum='" + this.dRO + '\'');
        stringBuilder.append(", roughAddr='" + this.dRP + '\'');
        stringBuilder.append(", poi_name='" + this.dRQ + '\'');
        stringBuilder.append(", lat=" + this.dRS);
        stringBuilder.append(", lng=" + this.dRT);
        stringBuilder.append(", tag=" + this.tag);
        return stringBuilder.toString();
    }

    public final String Oy() {
        return bi.aG(this.dRK, "") + bi.aG(this.dRL, "") + bi.aG(this.dRM, "") + bi.aG(this.dRN, "") + bi.aG(this.dRO, "");
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(bi.aG(this.dRH, ""));
        parcel.writeString(bi.aG(this.country, ""));
        parcel.writeString(bi.aG(this.dRI, ""));
        parcel.writeString(bi.aG(this.dRJ, ""));
        parcel.writeString(bi.aG(this.dRK, ""));
        parcel.writeString(bi.aG(this.dRL, ""));
        parcel.writeString(bi.aG(this.dRM, ""));
        parcel.writeString(bi.aG(this.dRN, ""));
        parcel.writeString(bi.aG(this.dRO, ""));
        parcel.writeString(bi.aG(this.dRP, ""));
        parcel.writeString(bi.aG(this.dRQ, ""));
        parcel.writeFloat(this.dRS);
        parcel.writeFloat(this.dRT);
    }
}
