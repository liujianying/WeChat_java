package com.tencent.mm.plugin.game.gamewebview.ipc;

import android.os.Parcel;
import android.os.Parcelable.Creator;

public class BindServiceTask extends GWMainProcessTask {
    public static final Creator<BindServiceTask> CREATOR = new 1();
    public Runnable fFC;

    public final void aai() {
        ahH();
    }

    public final void aaj() {
        if (this.fFC != null) {
            this.fFC.run();
        }
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
    }

    public final void g(Parcel parcel) {
    }

    public BindServiceTask(byte b) {
    }
}
