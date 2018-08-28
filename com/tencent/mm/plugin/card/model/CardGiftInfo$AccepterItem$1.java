package com.tencent.mm.plugin.card.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mm.plugin.card.model.CardGiftInfo.AccepterItem;

class CardGiftInfo$AccepterItem$1 implements Creator<AccepterItem> {
    CardGiftInfo$AccepterItem$1() {
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        return new AccepterItem(parcel, (byte) 0);
    }

    public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
        return new AccepterItem[i];
    }
}
