package com.tencent.mm.plugin.game.gamewebview.ipc;

import android.os.Message;
import android.os.Messenger;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Process;
import com.tencent.mm.sdk.platformtools.x;
import java.util.HashSet;
import java.util.Set;

public abstract class GWMainProcessTask implements Parcelable {
    private static final Set<Object> fEi = new HashSet();
    String fEl = (Process.myPid() + hashCode());
    Messenger fEz;

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

    public final boolean ahH() {
        if (this.fEz == null) {
            return false;
        }
        Message obtain = Message.obtain();
        obtain.setData(GameWebViewMainProcessService.a(this, false));
        try {
            this.fEz.send(obtain);
            return true;
        } catch (Exception e) {
            x.e("MicroMsg.GWMainProcessTask", e.getMessage());
            return false;
        }
    }

    public final void ahA() {
        fEi.add(this);
    }

    public final void ahB() {
        fEi.remove(this);
    }
}
