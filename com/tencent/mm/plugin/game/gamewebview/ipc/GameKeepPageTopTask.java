package com.tencent.mm.plugin.game.gamewebview.ipc;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mm.ba.a;
import com.tencent.mm.sdk.platformtools.x;

public class GameKeepPageTopTask extends GWMainProcessTask {
    public static final Creator<GameKeepPageTopTask> CREATOR = new 1();
    public boolean jGf;
    public String title;
    public int type;
    public String url;
    public String username;

    /* synthetic */ GameKeepPageTopTask(Parcel parcel, byte b) {
        this(parcel);
    }

    public final void aai() {
        x.i("MicroMsg.GameKeepPageTopTask", "type = " + this.type);
        a aVar;
        switch (this.type) {
            case 1:
                aVar = a.erR;
                this.jGf = a.Us();
                aVar = a.erR;
                this.url = a.Ut();
                return;
            case 2:
                aVar = a.erR;
                a.s(this.url, this.title, this.username);
                return;
            default:
                return;
        }
    }

    public final void g(Parcel parcel) {
        boolean z = true;
        this.type = parcel.readInt();
        if (parcel.readByte() != (byte) 1) {
            z = false;
        }
        this.jGf = z;
        this.url = parcel.readString();
        this.title = parcel.readString();
        this.username = parcel.readString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.type);
        parcel.writeByte((byte) (this.jGf ? 1 : 0));
        parcel.writeString(this.url);
        parcel.writeString(this.title);
        parcel.writeString(this.username);
    }

    public int describeContents() {
        return 0;
    }

    private GameKeepPageTopTask(Parcel parcel) {
        g(parcel);
    }
}
