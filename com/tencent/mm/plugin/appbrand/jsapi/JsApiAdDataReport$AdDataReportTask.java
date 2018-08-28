package com.tencent.mm.plugin.appbrand.jsapi;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.a;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.page.p;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import org.json.JSONObject;

class JsApiAdDataReport$AdDataReportTask extends MainProcessTask {
    public static final Creator<JsApiAdDataReport$AdDataReportTask> CREATOR = new 1();
    private e fFu;
    private p fFv;
    private int fFw;
    private String fFx;

    public JsApiAdDataReport$AdDataReportTask(e eVar, p pVar, int i, JSONObject jSONObject) {
        this.fFu = eVar;
        this.fFv = pVar;
        this.fFw = i;
        AppBrandStatObject qb = a.qb(pVar.mAppId);
        if (qb != null) {
            this.fFx = qb.scene + "," + qb.bGG + "," + qb.cbB + "," + qb.cbC + "," + jSONObject.optString("adInfo");
        } else {
            this.fFx = jSONObject.optString("adInfo");
        }
    }

    public JsApiAdDataReport$AdDataReportTask(Parcel parcel) {
        g(parcel);
    }

    public final void aai() {
        x.i("MicroMsg.JsApiAdDataReport", "mReportStr : %s", new Object[]{this.fFx});
        ((com.tencent.mm.plugin.sns.b.a) g.l(com.tencent.mm.plugin.sns.b.a.class)).g(15175, this.fFx, (int) bi.VE());
        b();
    }

    public final void aaj() {
        this.fFv.E(this.fFw, this.fFu.f("ok", null));
    }

    public final void g(Parcel parcel) {
        this.fFx = parcel.readString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.fFx);
    }
}
