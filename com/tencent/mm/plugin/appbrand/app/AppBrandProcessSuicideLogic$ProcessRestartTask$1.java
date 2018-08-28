package com.tencent.mm.plugin.appbrand.app;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mm.plugin.appbrand.app.AppBrandProcessSuicideLogic.ProcessRestartTask;

class AppBrandProcessSuicideLogic$ProcessRestartTask$1 implements Creator<ProcessRestartTask> {
    AppBrandProcessSuicideLogic$ProcessRestartTask$1() {
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        ProcessRestartTask processRestartTask = new ProcessRestartTask();
        processRestartTask.g(parcel);
        return processRestartTask;
    }

    public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
        return new ProcessRestartTask[i];
    }
}
