package com.tencent.mm.plugin.game.gamewebview.ipc;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.mm.plugin.game.gamewebview.b.a.a;
import com.tencent.mm.plugin.game.gamewebview.b.a.c;
import com.tencent.mm.plugin.game.gamewebview.b.a.d;
import com.tencent.mm.plugin.game.gamewebview.b.a.e;
import com.tencent.mm.plugin.game.gamewebview.b.b;
import com.tencent.mm.plugin.game.gamewebview.ui.h;
import com.tencent.mm.plugin.game.gamewebview.ui.h.3;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.HashMap;

public class GameMMToClientEvent extends GWMainProcessTask {
    public static Creator<GameMMToClientEvent> CREATOR = new 1();
    private static GameMMToClientEvent jGh;
    private int fEp;
    private String fEq;
    public Object fEr;
    int jGg;
    public Bundle jfZ;

    /* synthetic */ GameMMToClientEvent(Parcel parcel, byte b) {
        this(parcel);
    }

    private static GameMMToClientEvent aSo() {
        if (jGh == null) {
            synchronized (GameMMToClientEvent.class) {
                if (jGh == null) {
                    jGh = new GameMMToClientEvent();
                }
            }
        }
        return jGh;
    }

    public static void qI(int i) {
        aSo().fEp = 1;
        aSo().jGg = i;
        GameWebViewMainProcessService.a(aSo());
    }

    public static void qJ(int i) {
        aSo().fEp = 2;
        aSo().jGg = i;
        GameWebViewMainProcessService.a(aSo());
    }

    public final void aai() {
        switch (this.fEp) {
            case 1:
                a.a(this.jGg, this);
                return;
            case 2:
                a.qK(this.jGg);
                return;
            default:
                return;
        }
    }

    public final void aaj() {
        int i = this.jfZ.getInt("mm_to_client_notify_type");
        x.i("MicroMsg.GameMMToClientEvent", "notifyType = " + i);
        switch (i) {
            case 1:
                String string = this.jfZ.getString("js_event_name");
                if (!bi.oW(string)) {
                    if (b.jHU == null || b.jHU.size() == 0) {
                        b.jHU = new HashMap();
                        b.a(new c());
                        b.a(new com.tencent.mm.plugin.game.gamewebview.b.a.b());
                        b.a(new e());
                        b.a(new d());
                        b.a(new a());
                    }
                    com.tencent.mm.plugin.game.gamewebview.b.a aVar = (com.tencent.mm.plugin.game.gamewebview.b.a) b.jHU.get(string);
                    if (aVar != null) {
                        aVar.m(this.jGg, this.jfZ);
                        return;
                    }
                    return;
                }
                return;
            case 2:
                com.tencent.mm.plugin.game.gamewebview.ui.d qL = com.tencent.mm.plugin.game.gamewebview.model.a.qL(this.jGg);
                if (qL != null) {
                    String string2 = this.jfZ.getString("file_path");
                    String string3 = this.jfZ.getString("result");
                    int i2 = this.jfZ.getInt("code_type");
                    int i3 = this.jfZ.getInt("code_version");
                    if (qL.jJy != null) {
                        h hVar = qL.jJy;
                        x.d("MicroMsg.GameWebViewMenuListHelper", "result: " + string3);
                        if (hVar.gcU != null && string2 != null && string2.equals(hVar.gcU.pUp)) {
                            if (hVar.gcU != null) {
                                hVar.gcU.bVc();
                            }
                            hVar.gcS = i2;
                            hVar.gcT = i3;
                            if (string3 != null && hVar.gcQ != null) {
                                new ag().post(new 3(hVar, string3));
                                return;
                            }
                            return;
                        }
                        return;
                    }
                    return;
                }
                return;
            default:
                return;
        }
    }

    public final void g(Parcel parcel) {
        this.fEp = parcel.readInt();
        this.jGg = parcel.readInt();
        this.jfZ = parcel.readBundle(getClass().getClassLoader());
        try {
            this.fEq = parcel.readString();
            if (!bi.oW(this.fEq)) {
                Class cls = Class.forName(this.fEq);
                if (cls != null) {
                    this.fEr = parcel.readParcelable(cls.getClassLoader());
                }
            }
        } catch (Exception e) {
            x.e("MicroMsg.GameMMToClientEvent", "can't parcel data ex: " + e.getMessage());
        }
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.fEp);
        parcel.writeInt(this.jGg);
        parcel.writeBundle(this.jfZ);
        if (!bi.oW(this.fEq) && this.fEr != null) {
            parcel.writeString(this.fEq);
            parcel.writeParcelable((Parcelable) this.fEr, i);
        }
    }

    public int describeContents() {
        return 0;
    }

    private GameMMToClientEvent(Parcel parcel) {
        g(parcel);
    }
}
