package com.tencent.mm.plugin.appbrand;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;

public class AppBrandMainProcessPrepareTask extends MainProcessTask {
    public static final Creator<AppBrandMainProcessPrepareTask> CREATOR = new Creator<AppBrandMainProcessPrepareTask>() {
        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new AppBrandMainProcessPrepareTask(null);
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new AppBrandMainProcessPrepareTask[i];
        }
    };
    private Runnable fcn;

    AppBrandMainProcessPrepareTask(Runnable runnable) {
        this.fcn = runnable;
        ahA();
    }

    public final void aai() {
        b();
    }

    public final void aaj() {
        this.fcn.run();
        ahB();
    }
}
