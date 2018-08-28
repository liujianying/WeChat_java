package com.tencent.mm.plugin.wallet_core.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import java.util.LinkedList;
import java.util.List;

public class FavorPayInfo implements Parcelable {
    public static final Creator<FavorPayInfo> CREATOR = new 1();
    public String pnP;
    public int pnQ;
    public String pnR;
    public String pnS;
    public String pnT;
    public List<String> pnU = new LinkedList();

    public FavorPayInfo(Parcel parcel) {
        this.pnP = parcel.readString();
        this.pnQ = parcel.readInt();
        this.pnR = parcel.readString();
        this.pnS = parcel.readString();
        this.pnT = parcel.readString();
        this.pnU = parcel.createStringArrayList();
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.pnP);
        parcel.writeInt(this.pnQ);
        parcel.writeString(this.pnR);
        parcel.writeString(this.pnS);
        parcel.writeString(this.pnT);
        parcel.writeStringList(this.pnU);
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(String.format("FavorPayInfo %s isNeedBankPay %s needBankType %s defaultFavorCompId %s changeBankcardTips %s", new Object[]{this.pnP, Integer.valueOf(this.pnQ), this.pnR, this.pnS, this.pnT}));
        if (this.pnU != null) {
            stringBuffer.append("bind_serial_list :");
            for (String str : this.pnU) {
                stringBuffer.append(str + ",");
            }
        }
        return stringBuffer.toString();
    }

    public int describeContents() {
        return 0;
    }
}
