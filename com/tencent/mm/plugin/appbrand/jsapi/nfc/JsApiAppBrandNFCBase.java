package com.tencent.mm.plugin.appbrand.jsapi.nfc;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mm.g.a.ic;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.appbrand.r.c;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

public abstract class JsApiAppBrandNFCBase extends a {
    a fWu = null;

    private static class CheckIsSupportHCETask extends MainProcessTask {
        public static final Creator<CheckIsSupportHCETask> CREATOR = new Creator<CheckIsSupportHCETask>() {
            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                return new CheckIsSupportHCETask(parcel);
            }

            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new CheckIsSupportHCETask[0];
            }
        };
        private String Yy;
        private int errCode;
        private JsApiAppBrandNFCBase fWv = null;

        public CheckIsSupportHCETask(JsApiAppBrandNFCBase jsApiAppBrandNFCBase) {
            this.fWv = jsApiAppBrandNFCBase;
        }

        public CheckIsSupportHCETask(Parcel parcel) {
            g(parcel);
        }

        public final void aai() {
            ic icVar = new ic();
            com.tencent.mm.sdk.b.a.sFg.m(icVar);
            this.errCode = icVar.bRD.errCode;
            this.Yy = icVar.bRD.Yy;
            ahH();
        }

        public final void aaj() {
            super.aaj();
            c.az(this);
            if (this.fWv != null) {
                JsApiAppBrandNFCBase jsApiAppBrandNFCBase = this.fWv;
                int i = this.errCode;
                String str = this.Yy;
                x.i("MicroMsg.JsApiAppBrandNFCBase", "alvinluo checkIsSupport resultCallback errCode: %d, errMsg: %s", new Object[]{Integer.valueOf(i), str});
                if (i != 0) {
                    if (bi.oW(str)) {
                        str = "unknown error";
                    }
                    if (jsApiAppBrandNFCBase.fWu != null) {
                        jsApiAppBrandNFCBase.fWu.M(i, str);
                    }
                } else if (jsApiAppBrandNFCBase.fWu != null) {
                    jsApiAppBrandNFCBase.fWu.M(i, str);
                }
            }
        }

        public int describeContents() {
            return super.describeContents();
        }

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.errCode);
            parcel.writeString(this.Yy);
        }

        public final void g(Parcel parcel) {
            super.g(parcel);
            this.errCode = parcel.readInt();
            this.Yy = parcel.readString();
        }
    }

    protected final void a(a aVar) {
        this.fWu = aVar;
        CheckIsSupportHCETask checkIsSupportHCETask = new CheckIsSupportHCETask(this);
        c.br(checkIsSupportHCETask);
        AppBrandMainProcessService.a(checkIsSupportHCETask);
    }
}
