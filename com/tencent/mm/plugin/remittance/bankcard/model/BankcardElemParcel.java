package com.tencent.mm.plugin.remittance.bankcard.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.mm.protocal.c.fg;
import com.tencent.mm.protocal.c.ua;
import java.util.ArrayList;
import java.util.Iterator;

public class BankcardElemParcel implements Parcelable {
    public static final Creator<BankcardElemParcel> CREATOR = new 1();
    public String knE;
    public String lMV;
    public String mug;
    public int muh;
    public int mui;
    public String muj;
    public String muk;
    public String mul;
    public ArrayList<EnterTimeParcel> mum;

    public BankcardElemParcel(fg fgVar) {
        this.lMV = fgVar.lMV;
        this.knE = fgVar.knE;
        this.mug = fgVar.mug;
        this.muh = fgVar.muh;
        this.mui = fgVar.mui;
        this.muj = fgVar.muj;
        this.muk = fgVar.muk;
        this.mul = fgVar.mul;
        this.mum = new ArrayList();
        Iterator it = fgVar.rgf.iterator();
        while (it.hasNext()) {
            this.mum.add(new EnterTimeParcel((ua) it.next()));
        }
    }

    public BankcardElemParcel(Parcel parcel) {
        this.lMV = parcel.readString();
        this.knE = parcel.readString();
        this.mug = parcel.readString();
        this.muh = parcel.readInt();
        this.mui = parcel.readInt();
        this.mum = new ArrayList();
        parcel.readTypedList(this.mum, EnterTimeParcel.CREATOR);
        this.muj = parcel.readString();
        this.muk = parcel.readString();
        this.mul = parcel.readString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.lMV);
        parcel.writeString(this.knE);
        parcel.writeString(this.mug);
        parcel.writeInt(this.muh);
        parcel.writeInt(this.mui);
        parcel.writeTypedList(this.mum);
        parcel.writeString(this.muj);
        parcel.writeString(this.muk);
        parcel.writeString(this.mul);
    }

    public int describeContents() {
        return 0;
    }
}
