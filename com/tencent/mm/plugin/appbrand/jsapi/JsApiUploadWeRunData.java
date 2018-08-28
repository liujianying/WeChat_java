package com.tencent.mm.plugin.appbrand.jsapi;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mm.ab.b.a;
import com.tencent.mm.ab.v;
import com.tencent.mm.model.bx;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.l;
import com.tencent.mm.protocal.c.bwg;
import com.tencent.mm.protocal.c.bwh;
import com.tencent.mm.sdk.platformtools.x;
import org.json.JSONObject;

public class JsApiUploadWeRunData extends a {
    public static final int CTRL_INDEX = 323;
    public static final String NAME = "uploadWeRunData";
    private UploadMiniAppStepTask fHn;

    private static class UploadMiniAppStepTask extends MainProcessTask {
        public static final Creator<UploadMiniAppStepTask> CREATOR = new 2();
        private String appId;
        private boolean bKE;
        private e fFF;
        private l fFa;
        private int fFd;
        private int fHo;
        private boolean fHp;

        public UploadMiniAppStepTask(e eVar, l lVar, int i, int i2, boolean z) {
            x.d("MicroMsg.JsApiUploadWeRunData", "UploadMiniAppStepTask");
            this.fFF = eVar;
            this.fFa = lVar;
            this.fFd = i;
            this.fHo = i2;
            this.fHp = z;
            this.appId = lVar.mAppId;
        }

        public UploadMiniAppStepTask(Parcel parcel) {
            g(parcel);
        }

        public final void aai() {
            long IR = bx.IR();
            x.d("MicroMsg.JsApiUploadWeRunData", "UploadMiniAppStepTask currentTime %d", new Object[]{Long.valueOf(IR / 1000)});
            if (IR == 0) {
                IR = System.currentTimeMillis();
            }
            a aVar = new a();
            bwg bwg = new bwg();
            aVar.dIG = bwg;
            aVar.dIH = new bwh();
            aVar.uri = "/cgi-bin/mmoc-bin/hardware/uploadminiappstep";
            aVar.dIF = 1949;
            aVar.dII = 0;
            aVar.dIJ = 0;
            bwg.jQb = this.appId;
            bwg.hcC = this.fHo;
            bwg.ssB = this.fHp;
            bwg.jRa = (int) (IR / 1000);
            v.a(aVar.KT(), new 1(this), true);
        }

        public final void aaj() {
            if (this.bKE) {
                this.fFa.E(this.fFd, this.fFF.f("ok", null));
            } else {
                this.fFa.E(this.fFd, this.fFF.f("fail", null));
            }
            ahB();
        }

        public final void g(Parcel parcel) {
            boolean z;
            boolean z2 = true;
            this.fHo = parcel.readInt();
            if (parcel.readByte() != (byte) 0) {
                z = true;
            } else {
                z = false;
            }
            this.fHp = z;
            if (parcel.readByte() == (byte) 0) {
                z2 = false;
            }
            this.bKE = z2;
            this.appId = parcel.readString();
        }

        public void writeToParcel(Parcel parcel, int i) {
            byte b;
            byte b2 = (byte) 1;
            parcel.writeInt(this.fHo);
            if (this.fHp) {
                b = (byte) 1;
            } else {
                b = (byte) 0;
            }
            parcel.writeByte(b);
            if (!this.bKE) {
                b2 = (byte) 0;
            }
            parcel.writeByte(b2);
            parcel.writeString(this.appId);
        }
    }

    public void a(l lVar, JSONObject jSONObject, int i) {
        x.d("MicroMsg.JsApiUploadWeRunData", "JsApiUploadWeRunData!");
        if (jSONObject == null) {
            lVar.E(i, f("fail:data is null", null));
            x.e("MicroMsg.JsApiUploadWeRunData", "data is null");
            return;
        }
        a(this, lVar, i, jSONObject.optInt("step"), false);
    }

    public final void a(e eVar, l lVar, int i, int i2, boolean z) {
        if (i2 <= 0) {
            lVar.E(i, eVar.f("fail:step invalid", null));
            return;
        }
        this.fHn = new UploadMiniAppStepTask(eVar, lVar, i, i2, z);
        this.fHn.ahA();
        AppBrandMainProcessService.a(this.fHn);
    }
}
