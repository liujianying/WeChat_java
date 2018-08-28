package com.tencent.mm.plugin.appbrand.jsapi.bio.soter;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.compat.a.a;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.l;
import com.tencent.mm.plugin.appbrand.r.c;
import com.tencent.mm.sdk.platformtools.x;
import java.util.HashMap;
import java.util.Map;

class JsApiCheckIsSupportSoterAuthentication$GetIsSupportSoterTask extends MainProcessTask {
    public static final Creator<JsApiCheckIsSupportSoterAuthentication$GetIsSupportSoterTask> CREATOR = new 1();
    private int fFw = -1;
    private JsApiCheckIsSupportSoterAuthentication fKW;
    private int fKX = 0;
    private l fcy = null;

    public final void aaj() {
        super.aaj();
        x.d("MicroMsg.GetIsSupportSoterTask", "hy: callback. supportMode: %d", new Object[]{Integer.valueOf(this.fKX)});
        Map hashMap = new HashMap(2);
        hashMap.put("supportMode", a.kA(this.fKX));
        this.fcy.E(this.fFw, this.fKW.f("ok", hashMap));
        c.az(this);
    }

    public final void aai() {
        this.fKX = ((a) g.l(a.class)).adu();
        x.i("MicroMsg.GetIsSupportSoterTask", "hy: supportMode: %d", new Object[]{Integer.valueOf(this.fKX)});
        ahH();
    }

    public JsApiCheckIsSupportSoterAuthentication$GetIsSupportSoterTask(l lVar, int i, JsApiCheckIsSupportSoterAuthentication jsApiCheckIsSupportSoterAuthentication) {
        this.fcy = lVar;
        this.fFw = i;
        this.fKW = jsApiCheckIsSupportSoterAuthentication;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeInt(this.fKX);
    }

    protected JsApiCheckIsSupportSoterAuthentication$GetIsSupportSoterTask(Parcel parcel) {
        g(parcel);
    }

    public final void g(Parcel parcel) {
        super.g(parcel);
        this.fKX = parcel.readInt();
    }
}
