package com.tencent.mm.plugin.appbrand.ipc;

import android.os.Message;
import android.os.Messenger;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Process;
import com.tencent.mm.sdk.platformtools.x;
import java.util.HashSet;
import java.util.Set;

public abstract class MainProcessTask implements Parcelable {
    private static final Set<Object> fEy = new HashSet();
    public String fEl = (Process.myPid() + hashCode());
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
        obtain.setData(AppBrandMainProcessService.a(this, false));
        try {
            this.fEz.send(obtain);
            return true;
        } catch (Exception e) {
            x.e("MicroMsg.MainProcessTask", e.getMessage());
            return false;
        }
    }

    public final void ahA() {
        fEy.add(this);
    }

    public final void ahB() {
        fEy.remove(this);
    }
}
