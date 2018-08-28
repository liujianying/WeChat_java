package com.tencent.mm.plugin.appbrand.menu;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mm.plugin.appbrand.app.e;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.sdk.platformtools.bi;

class MenuDelegate_EnableDebug$SetAppDebugModeTask extends MainProcessTask {
    public static final Creator<MenuDelegate_EnableDebug$SetAppDebugModeTask> CREATOR = new 1();
    public String appId;
    public boolean bKe;

    private MenuDelegate_EnableDebug$SetAppDebugModeTask() {
    }

    /* synthetic */ MenuDelegate_EnableDebug$SetAppDebugModeTask(byte b) {
        this();
    }

    public final void aai() {
        String str = this.appId;
        boolean z = this.bKe;
        if (!bi.oW(str) && e.abf() != null) {
            e.abf().bd(str + "_AppDebugEnabled", String.valueOf(z));
        }
    }

    public final void g(Parcel parcel) {
        this.appId = parcel.readString();
        this.bKe = parcel.readByte() != (byte) 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.appId);
        parcel.writeByte(this.bKe ? (byte) 1 : (byte) 0);
    }
}
