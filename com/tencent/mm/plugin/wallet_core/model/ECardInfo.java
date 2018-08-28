package com.tencent.mm.plugin.wallet_core.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import java.util.ArrayList;

public class ECardInfo implements Parcelable {
    public static final Creator<ECardInfo> CREATOR = new Creator<ECardInfo>() {
        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new ECardInfo(parcel);
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new ECardInfo[i];
        }
    };
    public String bJV;
    public String ceh;
    public int pmY;
    public int pmZ;
    public int pna;
    public String pnb;
    public String pnc;
    public String pnd;
    public int pne;
    public ArrayList<String> pnf = new ArrayList();
    public String png;
    public String pnh;
    public String pni;
    public String pnj;
    public String title;

    public ECardInfo(Parcel parcel) {
        this.pmY = parcel.readInt();
        this.bJV = parcel.readString();
        this.pmZ = parcel.readInt();
        this.pna = parcel.readInt();
        this.pnb = parcel.readString();
        this.pnc = parcel.readString();
        this.pnd = parcel.readString();
        this.pne = parcel.readInt();
        this.title = parcel.readString();
        parcel.readStringList(this.pnf);
        this.png = parcel.readString();
        this.pnh = parcel.readString();
        this.pni = parcel.readString();
        this.pnj = parcel.readString();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.pmY);
        parcel.writeString(this.bJV);
        parcel.writeInt(this.pmZ);
        parcel.writeInt(this.pna);
        parcel.writeString(this.pnb);
        parcel.writeString(this.pnc);
        parcel.writeString(this.pnd);
        parcel.writeInt(this.pne);
        parcel.writeString(this.title);
        parcel.writeStringList(this.pnf);
        parcel.writeString(this.png);
        parcel.writeString(this.pnh);
        parcel.writeString(this.pni);
        parcel.writeString(this.pnj);
    }
}
