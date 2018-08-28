package com.tencent.mm.plugin.appbrand.jsapi.bio.soter;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mm.g.a.hk;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.l;
import com.tencent.mm.plugin.appbrand.r.c;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.x;
import java.util.HashMap;
import java.util.Map;

class JsApiCheckBioEnrollment$GetIsEnrolledTask extends MainProcessTask {
    public static final Creator<JsApiCheckBioEnrollment$GetIsEnrolledTask> CREATOR = new 1();
    private int fFw = -1;
    private JsApiCheckBioEnrollment fKS;
    private int fKT = -1;
    private int fKU = -1;
    private l fcy = null;

    public final void aaj() {
        boolean z = false;
        super.aaj();
        x.d("MicroMsg.GetIsEnrolledTask", "hy: callback. enrollResult: %d", new Object[]{Integer.valueOf(this.fKU)});
        Map hashMap = new HashMap(2);
        String str = "isEnrolled";
        if (this.fKU == 1) {
            z = true;
        }
        hashMap.put(str, Boolean.valueOf(z));
        if (this.fKU == 0) {
            this.fcy.E(this.fFw, this.fKS.f("ok", hashMap));
        } else if (this.fKU == -1) {
            this.fcy.E(this.fFw, this.fKS.f("fail not support", hashMap));
        } else if (this.fKU == 1) {
            this.fcy.E(this.fFw, this.fKS.f("ok", hashMap));
        } else {
            this.fcy.E(this.fFw, this.fKS.f("fail unknown error", hashMap));
        }
        c.az(this);
    }

    public final void aai() {
        hk hkVar = new hk();
        hkVar.bQI.bQK = this.fKT;
        a.sFg.m(hkVar);
        this.fKU = hkVar.bQJ.bQL;
        x.i("MicroMsg.GetIsEnrolledTask", "hy: enrollResult: %d", new Object[]{Integer.valueOf(this.fKU)});
        ahH();
    }

    public JsApiCheckBioEnrollment$GetIsEnrolledTask(l lVar, int i, int i2, JsApiCheckBioEnrollment jsApiCheckBioEnrollment) {
        this.fcy = lVar;
        this.fFw = i;
        this.fKS = jsApiCheckBioEnrollment;
        this.fKT = i2;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeInt(this.fKU);
        parcel.writeInt(this.fKT);
    }

    protected JsApiCheckBioEnrollment$GetIsEnrolledTask(Parcel parcel) {
        g(parcel);
    }

    public final void g(Parcel parcel) {
        super.g(parcel);
        this.fKU = parcel.readInt();
        this.fKT = parcel.readInt();
    }
}
