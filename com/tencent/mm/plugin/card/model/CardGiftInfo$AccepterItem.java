package com.tencent.mm.plugin.card.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class CardGiftInfo$AccepterItem implements Parcelable {
    public static final Creator<CardGiftInfo$AccepterItem> CREATOR = new 1();
    public String hvV;
    public String hvW;
    public String hvX;
    public String hvY;

    /* synthetic */ CardGiftInfo$AccepterItem(Parcel parcel, byte b) {
        this(parcel);
    }

    private CardGiftInfo$AccepterItem(Parcel parcel) {
        this.hvV = parcel.readString();
        this.hvW = parcel.readString();
        this.hvX = parcel.readString();
        this.hvY = parcel.readString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.hvV);
        parcel.writeString(this.hvW);
        parcel.writeString(this.hvX);
        parcel.writeString(this.hvY);
    }

    public int describeContents() {
        return 0;
    }
}
