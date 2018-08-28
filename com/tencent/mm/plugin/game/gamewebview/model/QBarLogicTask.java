package com.tencent.mm.plugin.game.gamewebview.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mm.g.a.ak;
import com.tencent.mm.g.a.ms;
import com.tencent.mm.plugin.game.gamewebview.ipc.GWMainProcessTask;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.x;
import java.util.HashMap;
import java.util.Map;

public class QBarLogicTask extends GWMainProcessTask {
    public static final Creator<QBarLogicTask> CREATOR = new 2();
    private static c dlW = new 1();
    private static Map<String, Integer> jIg;
    public String bSw;
    public int type;

    /* synthetic */ QBarLogicTask(Parcel parcel, byte b) {
        this(parcel);
    }

    public final void aai() {
        String str;
        switch (this.type) {
            case 1:
                str = this.bSw;
                if (jIg == null) {
                    jIg = new HashMap();
                    a.sFg.b(dlW);
                }
                ms msVar = new ms();
                msVar.bXH.filePath = str;
                a.sFg.m(msVar);
                jIg.put(str, Integer.valueOf(1));
                return;
            case 2:
                str = this.bSw;
                if (jIg == null || !jIg.containsKey(str)) {
                    x.e("MicroMsg.QBarLogicTask", "%s is not recognizing", str);
                    return;
                }
                ak akVar = new ak();
                akVar.bHM.filePath = str;
                a.sFg.m(akVar);
                jIg.remove(str);
                return;
            default:
                return;
        }
    }

    public final void aaj() {
    }

    public final void g(Parcel parcel) {
        this.type = parcel.readInt();
        this.bSw = parcel.readString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.type);
        parcel.writeString(this.bSw);
    }

    private QBarLogicTask(Parcel parcel) {
        g(parcel);
    }
}
