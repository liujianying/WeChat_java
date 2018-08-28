package com.tencent.mm.plugin.wallet_core.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.mm.plugin.wallet_core.model.Orders.DeductShowInfo;
import java.util.ArrayList;
import java.util.List;

public class Orders$DeductInfo implements Parcelable {
    public static final Creator<Orders$DeductInfo> CREATOR = new 1();
    public String desc;
    public String hwH;
    public int pgM;
    public int pgd;
    public String pge;
    public String ppI;
    public List<DeductShowInfo> ppJ = new ArrayList();
    public int ppK;
    public String ppL;
    public String ppM;
    public String title;

    public Orders$DeductInfo(Parcel parcel) {
        this.title = parcel.readString();
        this.desc = parcel.readString();
        this.pgM = parcel.readInt();
        this.ppI = parcel.readString();
        this.ppK = parcel.readInt();
        parcel.readTypedList(this.ppJ, DeductShowInfo.CREATOR);
        this.pgd = parcel.readInt();
        this.hwH = parcel.readString();
        this.pge = parcel.readString();
        this.ppL = parcel.readString();
        this.ppM = parcel.readString();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.title);
        parcel.writeString(this.desc);
        parcel.writeInt(this.pgM);
        parcel.writeString(this.ppI);
        parcel.writeInt(this.ppK);
        parcel.writeTypedList(this.ppJ);
        parcel.writeInt(this.pgd);
        parcel.writeString(this.hwH);
        parcel.writeString(this.pge);
        parcel.writeString(this.ppL);
        parcel.writeString(this.ppM);
    }
}
