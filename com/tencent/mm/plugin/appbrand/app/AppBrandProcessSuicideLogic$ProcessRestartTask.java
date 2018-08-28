package com.tencent.mm.plugin.appbrand.app;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mm.modelappbrand.b;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.task.e;

public class AppBrandProcessSuicideLogic$ProcessRestartTask extends MainProcessTask {
    public static final Creator<AppBrandProcessSuicideLogic$ProcessRestartTask> CREATOR = new 1();
    public String dox;
    public String fex;

    public final void aai() {
        b.ji(this.dox);
        e.vA(this.fex);
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.dox);
        parcel.writeString(this.fex);
    }

    public final void g(Parcel parcel) {
        this.dox = parcel.readString();
        this.fex = parcel.readString();
    }
}
