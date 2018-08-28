package com.tencent.mm.plugin.card.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class CardGiftInfo$AcceptedCardItem implements Parcelable {
    public static final Creator<CardGiftInfo$AcceptedCardItem> CREATOR = new 1();
    public String hvV;
    public String hvW;

    /* synthetic */ CardGiftInfo$AcceptedCardItem(Parcel parcel, byte b) {
        this(parcel);
    }

    private CardGiftInfo$AcceptedCardItem(Parcel parcel) {
        this.hvV = parcel.readString();
        this.hvW = parcel.readString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.hvV);
        parcel.writeString(this.hvW);
    }

    public int describeContents() {
        return 0;
    }
}
