package com.tencent.mm.plugin.appbrand.launching;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mm.kernel.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.config.AppBrandLaunchReferrer;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.launching.AppBrandTaskUsageRecorder.LaunchCheckParams;
import com.tencent.mm.plugin.appbrand.launching.a.b;
import com.tencent.mm.protocal.c.cgg;
import com.tencent.mm.protocal.c.chh;
import com.tencent.mm.protocal.c.chx;

final class AppBrandTaskUsageRecorder$UpdateTask extends MainProcessTask {
    public static final Creator<AppBrandTaskUsageRecorder$UpdateTask> CREATOR = new 1();
    LaunchCheckParams gfr;

    public final void aai() {
        if (g.Eg().dpD && !a.Dr()) {
            this.gfr.getClass();
            AppBrandLaunchReferrer appBrandLaunchReferrer = this.gfr.gfp.fqA;
            chx b = b.b(appBrandLaunchReferrer);
            chh c = b.c(appBrandLaunchReferrer);
            cgg cgg = new cgg();
            cgg.rRb = this.gfr.gfp.fig;
            cgg.riv = this.gfr.fii;
            cgg.otY = this.gfr.gfq.scene;
            cgg.rUC = this.gfr.gfp.fqx;
            cgg.rUB = 1;
            cgg.rUA = this.gfr.gfq.cbB;
            new com.tencent.mm.plugin.appbrand.launching.a.a(this.gfr.gfp.appId, false, cgg, b, c, this.gfr.fdE, this.gfr.fKP).akR();
        }
    }

    public AppBrandTaskUsageRecorder$UpdateTask(LaunchCheckParams launchCheckParams) {
        this.gfr = launchCheckParams;
    }

    AppBrandTaskUsageRecorder$UpdateTask(Parcel parcel) {
        g(parcel);
    }

    public final int describeContents() {
        return 0;
    }

    public final void g(Parcel parcel) {
        this.gfr = (LaunchCheckParams) parcel.readParcelable(LaunchCheckParams.class.getClassLoader());
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(this.gfr, i);
    }
}
