package com.tencent.mm.plugin.appbrand.jsapi;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mm.ab.v;
import com.tencent.mm.modelsimple.h;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;

public class JsApiScanCode$GetA8KeyTask extends MainProcessTask {
    public static final Creator<JsApiScanCode$GetA8KeyTask> CREATOR = new 2();
    public int actionCode;
    public int bJr;
    public int bJs;
    public String fGT;
    public String fGU;
    public Runnable fGV;

    public final void aai() {
        h hVar = new h(this.fGT, 36, this.bJr, this.bJs, null, (int) System.currentTimeMillis(), new byte[0]);
        v.a(hVar.diG, new 1(this, hVar), true);
    }

    public final void aaj() {
        if (this.fGV != null) {
            this.fGV.run();
        }
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.fGT);
        parcel.writeInt(this.actionCode);
        parcel.writeString(this.fGU);
        parcel.writeInt(this.bJr);
        parcel.writeInt(this.bJs);
    }

    public final void g(Parcel parcel) {
        this.fGT = parcel.readString();
        this.actionCode = parcel.readInt();
        this.fGU = parcel.readString();
        this.bJr = parcel.readInt();
        this.bJs = parcel.readInt();
    }
}
