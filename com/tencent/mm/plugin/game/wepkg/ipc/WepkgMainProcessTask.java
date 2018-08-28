package com.tencent.mm.plugin.game.wepkg.ipc;

import android.os.Message;
import android.os.Messenger;
import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.mm.sdk.platformtools.x;
import java.util.HashSet;
import java.util.Set;

public abstract class WepkgMainProcessTask implements Parcelable {
    private static final Set<Object> fEi = new HashSet();
    Messenger fEz;
    int mTaskId;

    public abstract void aai();

    public void aaj() {
    }

    public void g(Parcel parcel) {
    }

    public void writeToParcel(Parcel parcel, int i) {
    }

    public int describeContents() {
        return 0;
    }

    public final void En() {
        if (this.fEz != null) {
            Message obtain = Message.obtain();
            obtain.what = this.mTaskId;
            obtain.setData(WepkgMainProcessService.c(this));
            try {
                this.fEz.send(obtain);
            } catch (Exception e) {
                x.e("MicroMsg.Wepkg.WepkgMainProcessTask", e.getMessage());
            }
        }
    }

    public final void ahA() {
        fEi.add(this);
    }

    public final void ahB() {
        fEi.remove(this);
    }
}
