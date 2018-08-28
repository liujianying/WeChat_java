package com.tencent.mm.plugin.wallet_core.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mm.plugin.wallet_core.model.Orders.RemarksInfo;

class Orders$RemarksInfo$1 implements Creator<RemarksInfo> {
    Orders$RemarksInfo$1() {
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        return new RemarksInfo(parcel);
    }

    public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
        return new RemarksInfo[i];
    }
}
