package com.tencent.mm.plugin.appbrand.jsapi;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.x;

class JsApiAddNativeDownloadTask$AddNativeDownloadTaskTask extends MainProcessTask {
    public static final Creator<JsApiAddNativeDownloadTask$AddNativeDownloadTaskTask> CREATOR = new 2();
    public long bGm = 0;
    public int bWA = 0;
    private c fFB;
    Runnable fFC;

    public final void aai() {
        x.i("MicroMsg.JsApiAddNativeDownloadTask", "runInMainProcess flag:%d", new Object[]{Integer.valueOf(this.bWA)});
        this.fFB = new 1(this);
        a.sFg.a(this.fFB);
    }

    public final void aaj() {
        if (this.fFC != null) {
            this.fFC.run();
        }
    }

    public final void g(Parcel parcel) {
        this.bWA = parcel.readInt();
        this.bGm = parcel.readLong();
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.bWA);
        parcel.writeLong(this.bGm);
    }
}
