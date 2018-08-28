package com.tencent.mm.plugin.game.gamewebview.jsapi.biz;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mm.compatible.e.q;
import com.tencent.mm.plugin.game.gamewebview.ipc.GWMainProcessTask;

class GameJsApiGetOpenDeviceId$GetDeviceIdTask extends GWMainProcessTask {
    public static final Creator<GameJsApiGetOpenDeviceId$GetDeviceIdTask> CREATOR = new 1();
    public String byN;
    public String jHa;

    /* synthetic */ GameJsApiGetOpenDeviceId$GetDeviceIdTask(Parcel parcel, byte b) {
        this(parcel);
    }

    public final void aai() {
        this.byN = q.zy();
        this.jHa = q.zz();
    }

    public final void g(Parcel parcel) {
        this.byN = parcel.readString();
        this.jHa = parcel.readString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.byN);
        parcel.writeString(this.jHa);
    }

    private GameJsApiGetOpenDeviceId$GetDeviceIdTask(Parcel parcel) {
        g(parcel);
    }
}
