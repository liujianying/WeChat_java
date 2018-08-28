package com.tencent.mm.plugin.appbrand.jsapi.contact;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.messenger.foundation.a.i;
import com.tencent.mm.storage.ai;

class JsApiGetContactMessageCountTask extends MainProcessTask {
    public static final Creator<JsApiGetContactMessageCountTask> CREATOR = new 1();
    public int bGz;
    public Runnable fFC;
    public String username;

    public JsApiGetContactMessageCountTask(Parcel parcel) {
        g(parcel);
    }

    public final void aai() {
        ai Yq = ((i) g.l(i.class)).FW().Yq(this.username);
        if (Yq == null) {
            this.bGz = -1;
            e();
            return;
        }
        this.bGz = Yq.field_unReadCount;
        e();
    }

    public final void aaj() {
        if (this.fFC != null) {
            this.fFC.run();
        }
    }

    public final void g(Parcel parcel) {
        this.username = parcel.readString();
        this.bGz = parcel.readInt();
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.username);
        parcel.writeInt(this.bGz);
    }
}
