package com.tencent.mm.plugin.game.gamewebview.jsapi;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mm.plugin.game.gamewebview.ipc.GameProcessActivityTask;
import com.tencent.mm.plugin.game.gamewebview.ipc.GameProcessActivityTask.a;
import com.tencent.mm.plugin.game.gamewebview.ui.d;
import com.tencent.mm.sdk.platformtools.x;
import java.util.Map;

public class GameJsApiActivityTask extends GameProcessActivityTask {
    public static final Creator<GameJsApiActivityTask> CREATOR = new Creator<GameJsApiActivityTask>() {
        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new GameJsApiActivityTask(parcel, (byte) 0);
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new GameJsApiActivityTask[i];
        }
    };
    public int fFd;
    public String fII;
    public d jGq;
    public String jGt;
    public String jGu;

    /* synthetic */ GameJsApiActivityTask(Parcel parcel, byte b) {
        this(parcel);
    }

    public final void a(Context context, a aVar) {
        x.i("MicroMsg.GameJsApiActivityTask", "runInMainProcess, apiName = %s", new Object[]{this.jGt});
        Map aSw = e.aSw();
        if (aSw != null) {
            c cVar = (c) aSw.get(this.jGt);
            if (!(cVar instanceof f)) {
                ((a) cVar).a(context, this.fII, new 1(this, aVar));
            }
        }
    }

    public final void aaj() {
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

    public GameJsApiActivityTask(Context context) {
        super(context);
    }

    private GameJsApiActivityTask(Parcel parcel) {
        g(parcel);
    }
}
