package com.tencent.mm.plugin.appbrand.jsapi.miniprogram_navigator;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.task.e;

final class JsApiLaunchMiniProgram$LaunchPreconditionTask extends MainProcessTask {
    public static final Creator<JsApiLaunchMiniProgram$LaunchPreconditionTask> CREATOR = new 1();
    private String fVF;
    private int fVG;
    private int fVH = a.fVI.ordinal();

    public final void g(Parcel parcel) {
        this.fVF = parcel.readString();
        this.fVG = parcel.readInt();
        this.fVH = parcel.readInt();
    }

    public final void aai() {
        e.vD(this.fVF);
        this.fVH = a.fVK.ordinal();
    }

    public final int describeContents() {
        return 0;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.fVF);
        parcel.writeInt(this.fVG);
        parcel.writeInt(this.fVH);
    }

    JsApiLaunchMiniProgram$LaunchPreconditionTask() {
    }

    JsApiLaunchMiniProgram$LaunchPreconditionTask(Parcel parcel) {
        g(parcel);
    }
}
