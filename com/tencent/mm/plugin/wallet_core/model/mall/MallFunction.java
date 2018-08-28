package com.tencent.mm.plugin.wallet_core.model.mall;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import java.util.ArrayList;

public class MallFunction implements Parcelable {
    public static final Creator<MallFunction> CREATOR = new Creator<MallFunction>() {
        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new MallFunction(parcel);
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new MallFunction[i];
        }
    };
    public String cbR;
    public String ceR;
    public String kYQ;
    public String kYR;
    public String kck;
    public String moy;
    public String prS;
    public ArrayList<String> prT;
    public MallNews prU;
    public String prV;
    public int prW = 0;
    public int type;

    public int describeContents() {
        return 0;
    }

    public MallFunction(Parcel parcel) {
        this.moy = parcel.readString();
        this.cbR = parcel.readString();
        this.prS = parcel.readString();
        this.kYQ = parcel.readString();
        this.kYR = parcel.readString();
        this.ceR = parcel.readString();
        this.kck = parcel.readString();
        this.prT = new ArrayList();
        parcel.readStringList(this.prT);
        this.prU = (MallNews) parcel.readParcelable(MallNews.class.getClassLoader());
        this.type = parcel.readInt();
        this.prV = parcel.readString();
        this.prW = parcel.readInt();
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.moy);
        parcel.writeString(this.cbR);
        parcel.writeString(this.prS);
        parcel.writeString(this.kYQ);
        parcel.writeString(this.kYR);
        parcel.writeString(this.ceR);
        parcel.writeString(this.kck);
        parcel.writeStringList(this.prT);
        parcel.writeParcelable(this.prU, i);
        parcel.writeInt(this.type);
        parcel.writeString(this.prV);
        parcel.writeInt(this.prW);
    }
}
