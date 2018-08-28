package com.tencent.mm.plugin.appbrand.performance;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mars.cdn.CdnLogic;
import com.tencent.mm.plugin.appbrand.app.e;
import com.tencent.mm.plugin.appbrand.config.c;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.sdk.platformtools.x;

class AppBrandPerformanceManager$GetPkgDownloadCostTask extends MainProcessTask {
    public static final Creator<AppBrandPerformanceManager$GetPkgDownloadCostTask> CREATOR = new 1();
    private long gps;
    private String mAppId;

    private AppBrandPerformanceManager$GetPkgDownloadCostTask() {
    }

    /* synthetic */ AppBrandPerformanceManager$GetPkgDownloadCostTask(byte b) {
        this();
    }

    public final void aai() {
        x.d("MicroMsg.AppBrandPerformanceManager", "try to get pkg download cost in main process.");
        String str = this.mAppId + "_PkgDownloadCost";
        c abf = e.abf();
        if (abf == null) {
            x.e("MicroMsg.AppBrandPerformanceManager", "appBrandCommonKVDataStorage is null, return");
            a();
            return;
        }
        String str2 = abf.get(str, null);
        if (str2 != null) {
            e.abf().bd(str, null);
            try {
                this.gps = Long.parseLong(str2);
            } catch (Exception e) {
                x.e("MicroMsg.AppBrandPerformanceManager", "GetPkgDownloadCost error.");
            }
        }
        a();
    }

    public final void aaj() {
        x.d("MicroMsg.AppBrandPerformanceManager", "received pkg download cost from main process: %d ms", new Object[]{Long.valueOf(this.gps)});
        if (this.gps != 0) {
            AppBrandPerformanceManager.b(this.mAppId, CdnLogic.kAppTypeNearEvent, this.gps);
        }
        ahB();
    }

    public final void g(Parcel parcel) {
        this.mAppId = parcel.readString();
        this.gps = parcel.readLong();
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.mAppId);
        parcel.writeLong(this.gps);
    }
}
