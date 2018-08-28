package com.tencent.mm.plugin.appbrand.jsapi.share;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelappbrand.i;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.y.a.b;

class JsApiShowUpdatableMessageSubscribeButton$ShowUpdatableMessageSubscribeButtonTask extends MainProcessTask {
    public static final Creator<JsApiShowUpdatableMessageSubscribeButton$ShowUpdatableMessageSubscribeButtonTask> CREATOR = new 1();
    public String dzR;

    public JsApiShowUpdatableMessageSubscribeButton$ShowUpdatableMessageSubscribeButtonTask(Parcel parcel) {
        g(parcel);
    }

    public final void aai() {
        b jm = ((i) g.l(i.class)).jm(this.dzR);
        if (jm == null || (jm.field_btnState != 2 && jm.field_msgState == 0)) {
            ((i) g.l(i.class)).I(this.dzR, 1);
            return;
        }
        x.e("MicroMsg.ShowUpdatableMessageSubscribeButtonTask", "shareKey:%s btnState:%d msgState:%d ingore already process", new Object[]{this.dzR, Integer.valueOf(jm.field_btnState), Integer.valueOf(jm.field_msgState)});
    }

    public final void g(Parcel parcel) {
        this.dzR = parcel.readString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.dzR);
    }
}
