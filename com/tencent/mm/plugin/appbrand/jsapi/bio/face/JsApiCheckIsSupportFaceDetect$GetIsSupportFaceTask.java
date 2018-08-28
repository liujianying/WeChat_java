package com.tencent.mm.plugin.appbrand.jsapi.bio.face;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mm.g.a.hl;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.l;
import com.tencent.mm.plugin.appbrand.r.c;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.x;
import java.util.HashMap;
import java.util.Map;

class JsApiCheckIsSupportFaceDetect$GetIsSupportFaceTask extends MainProcessTask {
    public static final Creator<JsApiCheckIsSupportFaceDetect$GetIsSupportFaceTask> CREATOR = new 1();
    private String Yy = "not returned";
    private boolean cbY = false;
    private int errCode = -1;
    private int fFw = -1;
    private JsApiCheckIsSupportFaceDetect fKO;
    private int fKP = -1;
    private l fcy = null;

    public final void aaj() {
        super.aaj();
        x.d("MicroMsg.GetIsSupportFaceTask", "hy: callback. isSupport: %b, errCode: %d, errMsg: %s, libVersion: %d", new Object[]{Boolean.valueOf(this.cbY), Integer.valueOf(this.errCode), this.Yy, Integer.valueOf(this.fKP)});
        Map hashMap = new HashMap(3);
        hashMap.put("errCode", Integer.valueOf(this.errCode));
        hashMap.put("libVersionCode", Integer.valueOf(this.fKP));
        if (this.errCode == 0) {
            this.fcy.E(this.fFw, this.fKO.f("ok", hashMap));
        } else {
            this.fcy.E(this.fFw, this.fKO.f("fail " + this.Yy, hashMap));
        }
        c.az(this);
    }

    public final void aai() {
        hl hlVar = new hl();
        a.sFg.m(hlVar);
        this.cbY = hlVar.bQM.bQN;
        this.errCode = hlVar.bQM.bQO;
        this.Yy = hlVar.bQM.bQP;
        this.fKP = hlVar.bQM.bQQ;
        x.i("MicroMsg.GetIsSupportFaceTask", "hy: is support: %b, errCode: %d, errMsg: %s, ilbVersion: %d", new Object[]{Boolean.valueOf(this.cbY), Integer.valueOf(this.errCode), this.Yy, Integer.valueOf(this.fKP)});
        ahH();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeByte(this.cbY ? (byte) 1 : (byte) 0);
        parcel.writeInt(this.errCode);
        parcel.writeString(this.Yy);
        parcel.writeInt(this.fKP);
    }

    public JsApiCheckIsSupportFaceDetect$GetIsSupportFaceTask(l lVar, int i, JsApiCheckIsSupportFaceDetect jsApiCheckIsSupportFaceDetect) {
        this.fcy = lVar;
        this.fFw = i;
        this.fKO = jsApiCheckIsSupportFaceDetect;
    }

    protected JsApiCheckIsSupportFaceDetect$GetIsSupportFaceTask(Parcel parcel) {
        g(parcel);
    }

    public final void g(Parcel parcel) {
        super.g(parcel);
        this.cbY = parcel.readByte() != (byte) 0;
        this.errCode = parcel.readInt();
        this.Yy = parcel.readString();
        this.fKP = parcel.readInt();
    }
}
