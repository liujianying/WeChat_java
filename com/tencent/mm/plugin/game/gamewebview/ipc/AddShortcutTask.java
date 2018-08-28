package com.tencent.mm.plugin.game.gamewebview.ipc;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mm.plugin.base.model.d;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

public class AddShortcutTask extends GWMainProcessTask {
    public static final Creator<AddShortcutTask> CREATOR = new 2();
    public String appId;
    public Runnable fFC;
    public boolean success;
    public String username;

    /* synthetic */ AddShortcutTask(Parcel parcel, byte b) {
        this(parcel);
    }

    public final void aai() {
        if (bi.oW(this.appId) || bi.oW(this.username)) {
            x.e("MicroMsg.AddShortcutTask", "appid or username is null");
            this.success = false;
            return;
        }
        d.a(ad.getContext(), this.username, this.appId, new 1(this));
    }

    public final void aaj() {
        if (this.fFC != null) {
            this.fFC.run();
        }
    }

    public int describeContents() {
        return 0;
    }

    public final void g(Parcel parcel) {
        boolean z = true;
        this.username = parcel.readString();
        this.appId = parcel.readString();
        if (parcel.readByte() != (byte) 1) {
            z = false;
        }
        this.success = z;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.username);
        parcel.writeString(this.appId);
        parcel.writeByte((byte) (this.success ? 1 : 0));
    }

    private AddShortcutTask(Parcel parcel) {
        g(parcel);
    }
}
