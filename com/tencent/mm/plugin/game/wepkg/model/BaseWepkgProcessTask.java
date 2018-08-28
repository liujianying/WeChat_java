package com.tencent.mm.plugin.game.wepkg.model;

import android.os.Parcel;
import com.tencent.mm.plugin.game.wepkg.ipc.WepkgMainProcessTask;

public abstract class BaseWepkgProcessTask extends WepkgMainProcessTask {
    public boolean bGZ = false;

    public abstract void k(Parcel parcel);

    public abstract void v(Parcel parcel, int i);

    public final void g(Parcel parcel) {
        this.bGZ = parcel.readByte() != (byte) 0;
        k(parcel);
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeByte((byte) (this.bGZ ? 1 : 0));
        v(parcel, i);
    }
}
