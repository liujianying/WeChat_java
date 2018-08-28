package com.tencent.mm.plugin.game.gamewebview.jsapi;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mm.plugin.game.gamewebview.ipc.GWMainProcessTask;
import com.tencent.mm.plugin.game.gamewebview.ui.d;
import com.tencent.mm.sdk.platformtools.ad;
import java.util.Map;

public class GameJsApiMMTask extends GWMainProcessTask {
    public static final Creator<GameJsApiMMTask> CREATOR = new 2();
    public int fFd;
    public String fII;
    public d jGq;
    public String jGt;
    public String jGu;

    public interface a {
        void tp(String str);
    }

    /* synthetic */ GameJsApiMMTask(Parcel parcel, byte b) {
        this(parcel);
    }

    public final void aai() {
        Map aSw = e.aSw();
        if (aSw != null) {
            c cVar = (c) aSw.get(this.jGt);
            if (!(cVar instanceof f)) {
                ((a) cVar).a(ad.getContext(), this.fII, new 1(this));
            }
        }
    }

    public final void aaj() {
        ahB();
        if (this.jGq != null) {
            this.jGq.E(this.fFd, this.jGu);
        }
    }

    public final void g(Parcel parcel) {
        this.fII = parcel.readString();
        this.jGt = parcel.readString();
        this.jGu = parcel.readString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.fII);
        parcel.writeString(this.jGt);
        parcel.writeString(this.jGu);
    }

    private GameJsApiMMTask(Parcel parcel) {
        g(parcel);
    }
}
