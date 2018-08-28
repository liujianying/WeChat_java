package com.tencent.mm.plugin.appbrand.jsapi.lbs;

import android.os.Looper;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mm.modelgeo.a.a;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.l;
import com.tencent.mm.plugin.appbrand.page.a$a;
import com.tencent.mm.plugin.appbrand.page.p;
import com.tencent.mm.plugin.appbrand.r.c;
import com.tencent.mm.sdk.a.b;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.x;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

final class JsApiGetLocation$LocationTask extends MainProcessTask {
    public static final Creator<JsApiGetLocation$LocationTask> CREATOR = new 6();
    private double bhF;
    private double bhG;
    private double bhI;
    private int fFw;
    private int fIE = 0;
    private JsApiGetLocation fRa;
    private boolean fRb = false;
    private String fRc;
    private boolean fRd;
    private boolean fRe;
    private float fRf;
    private float fRg;
    private double fRh;
    private double fRi;
    private int fRj;
    private volatile a fRk = null;
    private int fRl = 0;
    private long fRm = 0;
    private l fcy;
    private WeakReference<p> mPageRef;

    static /* synthetic */ void a(JsApiGetLocation$LocationTask jsApiGetLocation$LocationTask) {
        c.br(jsApiGetLocation$LocationTask);
        ah.A(new 1(jsApiGetLocation$LocationTask));
        jsApiGetLocation$LocationTask.fRl = 1;
        AppBrandMainProcessService.a(jsApiGetLocation$LocationTask);
    }

    static /* synthetic */ void aja() {
        Iterator it = JsApiGetLocation.aiY().iterator();
        while (it.hasNext()) {
            com.tencent.mm.modelgeo.c.OB().c((a) it.next());
        }
        JsApiGetLocation.aiY().clear();
        x.i("MicroMsg.JsApiGetLocation", "Stop All Location Callbacks");
    }

    static /* synthetic */ void b(JsApiGetLocation$LocationTask jsApiGetLocation$LocationTask) {
        if (jsApiGetLocation$LocationTask.mPageRef != null) {
            p pVar = (p) jsApiGetLocation$LocationTask.mPageRef.get();
            if (pVar != null) {
                jsApiGetLocation$LocationTask.fIE = com.tencent.mm.plugin.appbrand.page.a.t(pVar.fdO).a(a$a.LBS);
                jsApiGetLocation$LocationTask.fRm = System.currentTimeMillis();
            }
        }
    }

    static /* synthetic */ void d(JsApiGetLocation$LocationTask jsApiGetLocation$LocationTask) {
        jsApiGetLocation$LocationTask.fRk = new 3(jsApiGetLocation$LocationTask);
        new ag(Looper.getMainLooper()).postDelayed(new 4(jsApiGetLocation$LocationTask), 20000);
        if (jsApiGetLocation$LocationTask.fRc.equalsIgnoreCase("gcj02")) {
            com.tencent.mm.modelgeo.c.OB().b(jsApiGetLocation$LocationTask.fRk, false);
        } else if (jsApiGetLocation$LocationTask.fRc.equalsIgnoreCase("wgs84")) {
            com.tencent.mm.modelgeo.c.OB().a(jsApiGetLocation$LocationTask.fRk, false);
        }
        JsApiGetLocation.aiY().add(jsApiGetLocation$LocationTask.fRk);
    }

    static /* synthetic */ void h(JsApiGetLocation$LocationTask jsApiGetLocation$LocationTask) {
        com.tencent.mm.modelgeo.c.OB().c(jsApiGetLocation$LocationTask.fRk);
        JsApiGetLocation.aiY().remove(jsApiGetLocation$LocationTask.fRk);
        jsApiGetLocation$LocationTask.fRk = null;
    }

    static /* synthetic */ boolean k(JsApiGetLocation$LocationTask jsApiGetLocation$LocationTask) {
        return jsApiGetLocation$LocationTask.fRk != null && JsApiGetLocation.aiY().contains(jsApiGetLocation$LocationTask.fRk);
    }

    public final void aaj() {
        super.aaj();
        aiZ();
        c.az(this);
        if (this.fcy != null) {
            if (this.fRe) {
                Map hashMap = new HashMap(4);
                hashMap.put("latitude", Float.valueOf(this.fRf));
                hashMap.put("longitude", Float.valueOf(this.fRg));
                hashMap.put("speed", Double.valueOf(this.bhI));
                hashMap.put("accuracy", Double.valueOf(this.bhG));
                if (this.fRd) {
                    hashMap.put("altitude", Double.valueOf(this.bhF));
                }
                if (b.chp()) {
                    hashMap.put("provider", Integer.valueOf(this.fRj));
                }
                hashMap.put("verticalAccuracy", Double.valueOf(this.fRh));
                hashMap.put("horizontalAccuracy", Double.valueOf(this.fRi));
                this.fcy.E(this.fFw, this.fRa.f("ok", hashMap));
            } else {
                this.fcy.E(this.fFw, this.fRa.f("fail", null));
            }
            this.fRb = true;
        }
    }

    public final void aai() {
        c.br(this);
        ah.A(new 2(this));
    }

    private void aiZ() {
        if (this.mPageRef != null) {
            p pVar = (p) this.mPageRef.get();
            if (pVar != null) {
                long currentTimeMillis = System.currentTimeMillis() - this.fRm;
                if (currentTimeMillis < 3000) {
                    pVar.getContentView().postDelayed(new 5(this), 3000 - currentTimeMillis);
                    return;
                } else {
                    com.tencent.mm.plugin.appbrand.page.a.t(pVar.fdO).ln(this.fIE);
                    return;
                }
            }
        }
        if (this.fcy != null) {
            com.tencent.mm.plugin.appbrand.page.a.t(this.fcy.fdO).ln(this.fIE);
        }
    }

    public final int describeContents() {
        return 0;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        byte b = (byte) 1;
        super.writeToParcel(parcel, i);
        parcel.writeString(this.fRc);
        parcel.writeByte(this.fRd ? (byte) 1 : (byte) 0);
        if (!this.fRe) {
            b = (byte) 0;
        }
        parcel.writeByte(b);
        parcel.writeFloat(this.fRf);
        parcel.writeFloat(this.fRg);
        parcel.writeDouble(this.bhI);
        parcel.writeDouble(this.bhG);
        parcel.writeDouble(this.bhF);
        parcel.writeDouble(this.fRh);
        parcel.writeDouble(this.fRi);
        parcel.writeInt(this.fRl);
        parcel.writeInt(this.fRj);
    }

    public final void g(Parcel parcel) {
        boolean z = true;
        super.g(parcel);
        this.fRc = parcel.readString();
        this.fRd = parcel.readByte() != (byte) 0;
        if (parcel.readByte() == (byte) 0) {
            z = false;
        }
        this.fRe = z;
        this.fRf = parcel.readFloat();
        this.fRg = parcel.readFloat();
        this.bhI = parcel.readDouble();
        this.bhG = parcel.readDouble();
        this.bhF = parcel.readDouble();
        this.fRh = parcel.readDouble();
        this.fRi = parcel.readDouble();
        this.fRl = parcel.readInt();
        this.fRj = parcel.readInt();
    }

    JsApiGetLocation$LocationTask() {
    }

    JsApiGetLocation$LocationTask(Parcel parcel) {
        g(parcel);
    }
}
