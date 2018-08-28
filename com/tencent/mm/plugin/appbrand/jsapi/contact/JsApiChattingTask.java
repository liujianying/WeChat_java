package com.tencent.mm.plugin.appbrand.jsapi.contact;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.n.c;
import com.tencent.mm.plugin.messenger.foundation.a.i;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.ab;

public class JsApiChattingTask extends MainProcessTask {
    public static final Creator<JsApiChattingTask> CREATOR = new 2();
    public Runnable fFC;
    public String nickname;
    public String sessionFrom;
    public String username;

    public JsApiChattingTask(Parcel parcel) {
        g(parcel);
    }

    public final void aai() {
        ab Yg = ((i) g.l(i.class)).FR().Yg(this.username);
        x.d("MicroMsg.JsApiChattingTask", "sessionFrom:%s,username:%s,nickname:%s", new Object[]{this.sessionFrom, this.username, this.nickname});
        if (Yg == null || ((int) Yg.dhP) == 0) {
            ab abVar = new ab(this.username);
            abVar.setType(0);
            abVar.dx(this.nickname);
            ((i) g.l(i.class)).FR().T(abVar);
            x.i("MicroMsg.JsApiChattingTask", "%s save to contact_table", new Object[]{this.username});
        }
        ((c) g.l(c.class)).b(this.username, new 1(this));
    }

    public final void aaj() {
        if (this.fFC != null) {
            this.fFC.run();
        }
    }

    public final void g(Parcel parcel) {
        this.sessionFrom = parcel.readString();
        this.username = parcel.readString();
        this.nickname = parcel.readString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.sessionFrom);
        parcel.writeString(this.username);
        parcel.writeString(this.nickname);
    }
}
