package com.tencent.mm.plugin.appbrand.jsapi;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.util.Pair;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.app.e;
import com.tencent.mm.plugin.appbrand.appcache.a.c.a;
import com.tencent.mm.plugin.appbrand.appcache.a.d.b;
import com.tencent.mm.plugin.appbrand.config.m;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;

class JsApiGetAppConfigTask extends MainProcessTask {
    public static final Creator<JsApiGetAppConfigTask> CREATOR = new 2();
    public String aAL;
    public String appId;
    public Runnable fFC;
    public int scene;
    public int type;
    public String value;

    public JsApiGetAppConfigTask(Parcel parcel) {
        g(parcel);
    }

    public final void aai() {
        if (g.Eg().dpD) {
            boolean z;
            Pair w = ((b) e.x(b.class)).w(this.appId, 4, this.scene);
            if (((Boolean) w.first).booleanValue()) {
                int i = a.fiY;
                a.n((long) ((Integer) w.second).intValue(), 166);
            }
            if (((Boolean) w.first).booleanValue()) {
                z = false;
            } else {
                z = true;
            }
            m.a(this.appId, this.type, 0, new 1(this), z);
        }
    }

    public final void aaj() {
        if (this.fFC != null) {
            this.fFC.run();
        }
    }

    public final void g(Parcel parcel) {
        this.appId = parcel.readString();
        this.aAL = parcel.readString();
        this.value = parcel.readString();
        this.type = parcel.readInt();
        this.scene = parcel.readInt();
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.appId);
        parcel.writeString(this.aAL);
        parcel.writeString(this.value);
        parcel.writeInt(this.type);
        parcel.writeInt(this.scene);
    }
}
