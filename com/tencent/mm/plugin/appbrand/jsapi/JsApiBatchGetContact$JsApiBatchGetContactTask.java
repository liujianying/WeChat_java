package com.tencent.mm.plugin.appbrand.jsapi;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.l;
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.bi;
import java.util.ArrayList;

class JsApiBatchGetContact$JsApiBatchGetContactTask extends MainProcessTask {
    public static final Creator<JsApiBatchGetContact$JsApiBatchGetContactTask> CREATOR = new 2();
    private String Yy;
    public ArrayList<String> fFE;
    private e fFF;
    private String fFG;
    private l fFa;
    private int fFd;

    public JsApiBatchGetContact$JsApiBatchGetContactTask(e eVar, l lVar, int i, ArrayList<String> arrayList) {
        this.fFF = eVar;
        this.fFa = lVar;
        this.fFd = i;
        this.fFE = arrayList;
    }

    public JsApiBatchGetContact$JsApiBatchGetContactTask(Parcel parcel) {
        g(parcel);
    }

    public final void aaj() {
        if (bi.oW(this.fFG)) {
            this.fFa.E(this.fFd, this.fFF.f(this.Yy, null));
        } else {
            this.fFa.E(this.fFd, this.fFG);
        }
        ahB();
    }

    public final void aai() {
        e.post(new 1(this), "AppBrandJsApiBatchGetContact");
    }

    public final void g(Parcel parcel) {
        this.fFE = parcel.readArrayList(getClass().getClassLoader());
        this.fFG = parcel.readString();
        this.Yy = parcel.readString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeList(this.fFE);
        parcel.writeString(this.fFG);
        parcel.writeString(this.Yy);
    }
}
