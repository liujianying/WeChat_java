package com.tencent.mm.plugin.appbrand.launching;

import android.os.Looper;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfig;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.launching.c.a;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.sdk.platformtools.ah;
import java.util.Locale;

public final class AppBrandPreInitTask extends MainProcessTask {
    public static final Creator<AppBrandPreInitTask> CREATOR = new 3();
    private String appId;
    private int fmv;
    private transient a geL;
    private AppBrandInitConfig geM;
    private AppBrandStatObject geN;

    /* synthetic */ AppBrandPreInitTask(Parcel parcel, byte b) {
        this(parcel);
    }

    public AppBrandPreInitTask(String str, int i, AppBrandStatObject appBrandStatObject, a aVar) {
        this.appId = str;
        this.fmv = i;
        this.geN = appBrandStatObject;
        this.geL = aVar;
    }

    public final void akA() {
        ahA();
        AppBrandMainProcessService.a(this);
    }

    public final void aaj() {
        if (this.geL != null) {
            this.geL.b(this.geM, this.geN);
        }
        ahB();
    }

    public final void aai() {
        final c cVar = new c(this.appId, this.fmv, this.geN, new a() {
            public final void d(AppBrandInitConfig appBrandInitConfig, AppBrandStatObject appBrandStatObject) {
                AppBrandPreInitTask.this.geM = appBrandInitConfig;
                AppBrandPreInitTask.this.geN = appBrandStatObject;
                if (appBrandInitConfig != null) {
                    b.c(appBrandInitConfig, appBrandStatObject);
                }
                AppBrandPreInitTask.this.ahH();
            }
        });
        new ah(String.format(Locale.US, "AppBrandPreInitTask-%s|%d", new Object[]{this.appId, Integer.valueOf(this.fmv)})).H(new Runnable() {
            public final void run() {
                cVar.run();
                Looper.myLooper().quit();
            }
        });
    }

    public final int describeContents() {
        return 0;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.appId);
        parcel.writeInt(this.fmv);
        parcel.writeParcelable(this.geM, i);
        parcel.writeParcelable(this.geN, i);
    }

    public final void g(Parcel parcel) {
        this.appId = parcel.readString();
        this.fmv = parcel.readInt();
        this.geM = (AppBrandInitConfig) parcel.readParcelable(AppBrandInitConfig.class.getClassLoader());
        this.geN = (AppBrandStatObject) parcel.readParcelable(AppBrandStatObject.class.getClassLoader());
    }

    private AppBrandPreInitTask(Parcel parcel) {
        g(parcel);
    }
}
