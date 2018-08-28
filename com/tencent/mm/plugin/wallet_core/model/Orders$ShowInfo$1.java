package com.tencent.mm.plugin.wallet_core.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mm.plugin.wallet_core.model.Orders.ShowInfo;

class Orders$ShowInfo$1 implements Creator<ShowInfo> {
    Orders$ShowInfo$1() {
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        return new ShowInfo(parcel);
    }

    public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
        return new ShowInfo[i];
    }
}
