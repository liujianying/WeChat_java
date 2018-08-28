package com.tencent.mm.plugin.appbrand.jsapi;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.l;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.x;

class JsApiMakeVoIPCall$StartVoIPCall extends MainProcessTask {
    public static final Creator<JsApiMakeVoIPCall$StartVoIPCall> CREATOR = new 2();
    private e fFF;
    private l fFa;
    private int fFd;
    private c fGl = new 1(this);
    public int status;

    public JsApiMakeVoIPCall$StartVoIPCall(e eVar, l lVar, int i) {
        this.fFF = eVar;
        this.fFa = lVar;
        this.fFd = i;
    }

    public JsApiMakeVoIPCall$StartVoIPCall(Parcel parcel) {
        g(parcel);
    }

    public final void aai() {
        a.sFg.b(this.fGl);
    }

    public final void aaj() {
        ahB();
        x.i("MicroMsg.JsApiMakeVoIPCall", "makeVoIPCall = %d", new Object[]{Integer.valueOf(this.status)});
        if (this.status == 1) {
            this.fFa.E(this.fFd, this.fFF.f("cancel", null));
        } else if (this.status == 2) {
            this.fFa.E(this.fFd, this.fFF.f("ok", null));
        } else if (this.status == 3) {
            this.fFa.E(this.fFd, this.fFF.f("fail:network error", null));
        } else if (this.status == 4) {
            this.fFa.E(this.fFd, this.fFF.f("fail:param not match", null));
        } else {
            this.fFa.E(this.fFd, this.fFF.f("fail:unknow", null));
        }
    }

    public final void g(Parcel parcel) {
        this.status = parcel.readInt();
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.status);
    }
}
