package com.tencent.mm.plugin.appbrand.performance;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mm.plugin.appbrand.app.e;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;

class AppBrandPerformanceManager$SetAppPerformanceModeTask extends MainProcessTask {
    public static final Creator<AppBrandPerformanceManager$SetAppPerformanceModeTask> CREATOR = new 1();
    private String mAppId;
    private boolean mEnable;

    private AppBrandPerformanceManager$SetAppPerformanceModeTask() {
    }

    /* synthetic */ AppBrandPerformanceManager$SetAppPerformanceModeTask(byte b) {
        this();
    }

    public final void aai() {
        e.abf().bd(this.mAppId + "_PerformancePanelEnabled", this.mEnable ? "1" : "0");
    }

    public final void g(Parcel parcel) {
        this.mAppId = parcel.readString();
        this.mEnable = parcel.readByte() != (byte) 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.mAppId);
        parcel.writeByte(this.mEnable ? (byte) 1 : (byte) 0);
    }
}
