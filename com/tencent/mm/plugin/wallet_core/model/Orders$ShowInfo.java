package com.tencent.mm.plugin.wallet_core.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class Orders$ShowInfo implements Parcelable {
    public static final Creator<Orders$ShowInfo> CREATOR = new 1();
    public String jLs;
    public String name;
    public String pqk;
    public int pql;
    public String pqm;
    public String pqn;
    public String pqo;
    public int pqp;
    public String value;

    protected Orders$ShowInfo(Parcel parcel) {
        this.name = parcel.readString();
        this.value = parcel.readString();
        this.jLs = parcel.readString();
        this.pqk = parcel.readString();
        this.pql = parcel.readInt();
        this.pqm = parcel.readString();
        this.pqn = parcel.readString();
        this.pqo = parcel.readString();
        this.pqp = parcel.readInt();
    }

    public String toString() {
        return String.format("ShowInfo name:%s, value:%s, nameColor:%s, valueColor:%s, linkType:%s, linkWeApp:%s, linkAddr:%s, linkUrl:%s, textAttr:%s", new Object[]{this.name, this.value, this.jLs, this.pqk, Integer.valueOf(this.pql), this.pqm, this.pqn, this.pqo, Integer.valueOf(this.pqp)});
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.name);
        parcel.writeString(this.value);
        parcel.writeString(this.jLs);
        parcel.writeString(this.pqk);
        parcel.writeInt(this.pql);
        parcel.writeString(this.pqm);
        parcel.writeString(this.pqn);
        parcel.writeString(this.pqo);
        parcel.writeInt(this.pqp);
    }
}
