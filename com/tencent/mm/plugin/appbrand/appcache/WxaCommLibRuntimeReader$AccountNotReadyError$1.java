package com.tencent.mm.plugin.appbrand.appcache;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mm.plugin.appbrand.appcache.WxaCommLibRuntimeReader.AccountNotReadyError;

class WxaCommLibRuntimeReader$AccountNotReadyError$1 implements Creator<AccountNotReadyError> {
    WxaCommLibRuntimeReader$AccountNotReadyError$1() {
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        return new AccountNotReadyError((byte) 0);
    }

    public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
        return new AccountNotReadyError[i];
    }
}
