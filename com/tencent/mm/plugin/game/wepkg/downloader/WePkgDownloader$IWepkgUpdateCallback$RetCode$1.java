package com.tencent.mm.plugin.game.wepkg.downloader;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mm.plugin.game.wepkg.downloader.WePkgDownloader.IWepkgUpdateCallback.RetCode;

class WePkgDownloader$IWepkgUpdateCallback$RetCode$1 implements Creator<RetCode> {
    WePkgDownloader$IWepkgUpdateCallback$RetCode$1() {
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        return RetCode.values()[parcel.readInt()];
    }

    public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
        return new RetCode[i];
    }
}
