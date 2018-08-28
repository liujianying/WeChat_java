package com.tencent.mm.plugin.appbrand.ipc;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mm.sdk.platformtools.x;

public class SampleTask1 extends MainProcessTask {
    public static final Creator<SampleTask1> CREATOR = new 1();
    public String fEA;
    public String fEB;

    public SampleTask1(Parcel parcel) {
        g(parcel);
    }

    public final void aai() {
        x.e("SampleTask", this.fEA);
        this.fEB = "String from Main Process";
        b();
    }

    public final void aaj() {
        x.e("SampleTask", this.fEB);
    }

    public final void g(Parcel parcel) {
        this.fEA = parcel.readString();
        this.fEB = parcel.readString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.fEA);
        parcel.writeString(this.fEB);
    }
}
