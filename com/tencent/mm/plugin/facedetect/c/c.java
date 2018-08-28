package com.tencent.mm.plugin.facedetect.c;

import android.content.Context;
import android.os.Bundle;
import com.tencent.mm.ab.l;
import com.tencent.mm.plugin.facedetect.a$d;
import com.tencent.mm.plugin.facedetect.a$h;
import com.tencent.mm.plugin.facedetect.b.e;
import com.tencent.mm.plugin.facedetect.b.n;
import com.tencent.mm.plugin.facedetect.b.o;
import com.tencent.mm.plugin.facedetect.b.s;
import com.tencent.mm.plugin.facedetect.b.t;
import com.tencent.mm.plugin.facedetect.model.FaceDetectReporter;
import com.tencent.mm.plugin.facedetect.ui.a;
import com.tencent.mm.plugin.facedetect.ui.a.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

public final class c extends a {
    boolean hUE;
    private String iMV;
    private String iMW;
    private int iMX;

    c(Context context, e eVar, int i) {
        super(context, eVar, i);
        this.hUE = false;
        this.iMS = true;
        this.iMX = i;
    }

    private String getResultKey() {
        switch (this.iMX) {
            case 0:
            case 3:
                return "faceregister_ticket";
            case 1:
            case 4:
                return "faceverify_ticket";
            default:
                return "verify_result";
        }
    }

    public final l aJy() {
        long aJw = aJw();
        String str = this.iMV;
        String str2 = this.iMW;
        switch (this.iMX) {
            case 0:
                return new n(aJw, str, str2);
            case 1:
                return new s(aJw, str, str2);
            case 3:
                return new o(aJw, str, str2);
            case 4:
                return new t(aJw, str, str2);
            default:
                return null;
        }
    }

    public final void onStart() {
        x.i("MicroMsg.FaceDetectLoginController", "alvinluo onStart and create report session");
        if (this.hUE) {
            FaceDetectReporter.aJU().aJV();
            FaceDetectReporter.aJU().I(FaceDetectReporter.pw(this.iMX), this.hUE);
        }
    }

    public final void onRelease() {
        if (!FaceDetectReporter.aJU().iOd) {
            FaceDetectReporter.aJU().a(FaceDetectReporter.pw(this.iMX), this.hUE, 2, 1, 90006);
        }
    }

    public final void i(int i, int i2, String str) {
        x.v("MicroMsg.FaceDetectLoginController", "alvinluo onCollectEnd errType: %d, errCode: %d, errMsg: %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str});
    }

    public final boolean b(int i, String str, Bundle bundle) {
        x.i("MicroMsg.FaceDetectLoginController", "alvinluo onUploadEnd errType: %d, errCode: %d, errMsg: %s", new Object[]{Integer.valueOf(i), Integer.valueOf(0), str});
        if (i != 0) {
            FaceDetectReporter.aJU().a(FaceDetectReporter.pw(this.iMX), this.hUE, 1, 2, 90012);
            a(i, 0, str, false, null);
            return true;
        } else if (bundle == null || bi.oW(bundle.getString("key_pic_cdn_id"))) {
            x.e("MicroMsg.FaceDetectLoginController", "hy: not return cdn id!");
            a(4, 6, "not return cdn id", false, null);
            return true;
        } else {
            this.iMV = bundle.getString("key_pic_cdn_id");
            this.iMW = bundle.getString("key_cdn_aes_key");
            x.v("MicroMsg.FaceDetectLoginController", "hy: start upload: picCdnId: %s, aes key: %s", new Object[]{this.iMV, this.iMW});
            return false;
        }
    }

    public final void i(int i, int i2, String str, l lVar) {
        x.i("MicroMsg.FaceDetectLoginController", "alvinluo onVerifyEnd sceneType: %d, errType: %d, errCode: %d, errMsg: %s", new Object[]{Integer.valueOf(lVar.getType()), Integer.valueOf(i), Integer.valueOf(i2), str});
        if (lVar instanceof e) {
            e eVar = (e) lVar;
            Bundle bundle = new Bundle();
            bundle.putString(getResultKey(), eVar.aJs());
            if (i == 0 && i2 == 0) {
                FaceDetectReporter.aJU().a(this.iMP, eVar.aJr(), 0, i, i2, this.iMR != null ? this.iMR.iMg : 0);
                b pC = a.pC(a$d.face_tick);
                pC.iQs = true;
                pC.iQA = ad.getResources().getString(a$h.jsapi_success);
                a(false, true, pC);
                ah.i(new 1(this, i, i2, str, bundle), 1500);
                return;
            }
            int i3;
            FaceDetectReporter aJU = FaceDetectReporter.aJU();
            int i4 = this.iMP;
            boolean aJr = eVar.aJr();
            if (this.iMR != null) {
                i3 = this.iMR.iMg;
            } else {
                i3 = 0;
            }
            aJU.a(i4, aJr, 1, i, i2, i3);
            a(i, i2, str, eVar.aJr(), bundle);
        }
    }

    public final void c(int i, int i2, String str, Bundle bundle) {
        x.i("MicroMsg.FaceDetectLoginController", "alvinluo onError errType: %d, errCode: %d, errMsg: %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str});
        if (!FaceDetectReporter.aJU().iOd) {
            FaceDetectReporter.aJU().a(FaceDetectReporter.pw(this.iMX), this.hUE, 3, i, i2);
        }
        if (bundle != null) {
            Bundle bundle2 = new Bundle();
            bundle2.putString(getResultKey(), bundle.getString(getResultKey()));
            a(i, i2, str, bundle2);
            return;
        }
        a(i, i2, str, null);
    }

    public final void ac(int i, String str) {
        x.i("MicroMsg.FaceDetectLoginController", "alvinluo onCancel, errCode: %d, errMsg: %s", new Object[]{Integer.valueOf(i), str});
        if (!FaceDetectReporter.aJU().iOd) {
            FaceDetectReporter.aJU().a(FaceDetectReporter.pw(this.iMX), this.hUE, 2, 1, i);
        }
        a(1, i, str, null);
    }

    public final Bundle aJz() {
        Bundle bundle = new Bundle();
        bundle.putLong("k_bio_id", aJw());
        return bundle;
    }

    private void a(int i, int i2, String str, boolean z, Bundle bundle) {
        String string;
        b(i, i2, str, bundle);
        Context context = ad.getContext();
        if (str == null) {
            string = context.getString(a$h.face_compare_fail);
        } else {
            string = str;
        }
        a(true, false, a.b(a$d.face_err_icon, string, z ? context.getString(a$h.face_try_again) : context.getString(a$h.face_severe_error_main_btn), z ? context.getString(a$h.app_cancel) : null, new 2(this, z, i, i2, str, bundle), new 3(this, i, i2, str, bundle)));
    }
}
