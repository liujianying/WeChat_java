package com.tencent.mm.plugin.facedetect.c;

import android.content.Context;
import android.os.Bundle;
import com.tencent.mm.ab.l;
import com.tencent.mm.plugin.facedetect.a.h;
import com.tencent.mm.plugin.facedetect.b.m;
import com.tencent.mm.plugin.facedetect.model.FaceDetectReporter;
import com.tencent.mm.plugin.facedetect.ui.a;
import com.tencent.mm.plugin.facedetect.ui.a.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

public final class d extends a {
    String appId;
    private String bVc;
    boolean hUE;
    private String iMV;
    private String iMW;
    String iNc;

    d(Context context, e eVar, int i, Bundle bundle) {
        super(context, eVar, i);
        this.hUE = false;
        this.iMS = true;
        this.appId = bundle.getString("k_app_id", null);
        this.bVc = bundle.getString("request_verify_pre_info", null);
        this.iNc = bundle.getString("key_feedback_url", null);
    }

    public final l aJy() {
        return new m(aJw(), this.appId, this.bVc, this.iMV, this.iMW);
    }

    public final void onStart() {
        x.i("MicroMsg.FaceDetectMpController", "alvinluo onStart and create report session");
        if (this.hUE) {
            FaceDetectReporter.aJU().aJV();
        }
        FaceDetectReporter.aJU().I(this.iMP, this.hUE);
        FaceDetectReporter aJU = FaceDetectReporter.aJU();
        aJU.iOj++;
        x.v("MicroMsg.FaceDetectReporter", "alvinluo addFaceDetectCount: %d", new Object[]{Integer.valueOf(aJU.iOj)});
    }

    public final void onRelease() {
        if (!FaceDetectReporter.aJU().iOd) {
            FaceDetectReporter.aJU().a(this.iMP, this.hUE, 2, 1, 90006);
        }
    }

    public final void i(int i, int i2, String str) {
        x.v("MicroMsg.FaceDetectMpController", "alvinluo onCollectEnd errType: %d, errCode: %d, errMsg: %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str});
    }

    public final boolean b(int i, String str, Bundle bundle) {
        x.i("MicroMsg.FaceDetectMpController", "alvinluo onUploadEnd errType: %d, errCode: %d, errMsg: %s", new Object[]{Integer.valueOf(i), Integer.valueOf(0), str});
        if (i != 0) {
            FaceDetectReporter.aJU().a(this.iMP, this.hUE, 1, 2, 90012);
            a(i, 0, str, false, null);
            return true;
        } else if (bundle == null || bi.oW(bundle.getString("key_pic_cdn_id"))) {
            x.e("MicroMsg.FaceDetectMpController", "hy: not return cdn id!");
            a(4, 6, "not return cdn id", false, null);
            return true;
        } else {
            this.iMV = bundle.getString("key_pic_cdn_id");
            this.iMW = bundle.getString("key_cdn_aes_key");
            x.v("MicroMsg.FaceDetectMpController", "hy: start upload: picCdnId: %s, aes key: %s", new Object[]{this.iMV, this.iMW});
            return false;
        }
    }

    public final void i(int i, int i2, String str, l lVar) {
        x.i("MicroMsg.FaceDetectMpController", "alvinluo onVerifyEnd sceneType: %d, errType: %d, errCode: %d, errMsg: %s", new Object[]{Integer.valueOf(lVar.getType()), Integer.valueOf(i), Integer.valueOf(i2), str});
        if (lVar instanceof m) {
            Bundle bundle = new Bundle();
            bundle.putString("verify_result", ((m) lVar).iMB);
            if (i == 0 && i2 == 0) {
                FaceDetectReporter.aJU().a(this.iMP, this.hUE, 0, i, i2, this.iMR != null ? this.iMR.iMg : 0);
                FaceDetectReporter.aJU().iOk = true;
                b pC = a.pC(com.tencent.mm.plugin.facedetect.a.d.face_tick);
                pC.iQs = true;
                pC.iQA = ad.getResources().getString(h.jsapi_success);
                a(false, true, pC);
                final int i3 = i;
                final int i4 = i2;
                final String str2 = str;
                final Bundle bundle2 = bundle;
                ah.i(new Runnable() {
                    public final void run() {
                        d.this.a(i3, i4, str2, bundle2);
                    }
                }, 1500);
                return;
            }
            int i5;
            FaceDetectReporter aJU = FaceDetectReporter.aJU();
            int i6 = this.iMP;
            boolean z = this.hUE;
            if (this.iMR != null) {
                i5 = this.iMR.iMg;
            } else {
                i5 = 0;
            }
            aJU.a(i6, z, 1, i, i2, i5);
            a(i, i2, str, ((m) lVar).iMC, bundle);
        }
    }

    public final void c(int i, int i2, String str, Bundle bundle) {
        x.i("MicroMsg.FaceDetectMpController", "alvinluo onError errType: %d, errCode: %d, errMsg: %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str});
        if (!FaceDetectReporter.aJU().iOd) {
            FaceDetectReporter.aJU().a(this.iMP, this.hUE, 3, i, i2);
        }
        if (bundle != null) {
            Bundle bundle2 = new Bundle();
            bundle2.putString("verify_result", bundle.getString("verify_result"));
            a(i, i2, str, bundle2);
            return;
        }
        a(i, i2, str, null);
    }

    public final void ac(int i, String str) {
        x.i("MicroMsg.FaceDetectMpController", "alvinluo onCancel, errCode: %d, errMsg: %s", new Object[]{Integer.valueOf(i), str});
        if (!FaceDetectReporter.aJU().iOd) {
            FaceDetectReporter.aJU().a(this.iMP, this.hUE, 2, 1, i);
        }
        a(1, i, str, null);
    }

    public final Bundle aJz() {
        Bundle bundle = new Bundle();
        bundle.putLong("k_bio_id", aJw());
        bundle.putString("key_app_id", this.appId);
        return bundle;
    }

    private void a(int i, int i2, String str, boolean z, Bundle bundle) {
        String string;
        b(i, i2, str, bundle);
        Context context = ad.getContext();
        if (str == null) {
            string = context.getString(h.face_compare_fail);
        } else {
            string = str;
        }
        b b = a.b(com.tencent.mm.plugin.facedetect.a.d.face_err_icon, string, z ? context.getString(h.face_try_again) : context.getString(h.face_severe_error_main_btn), z ? context.getString(h.app_cancel) : null, new 2(this, z, i, i2, str, bundle), new 3(this, i, i2, str, bundle));
        a.a(b, context.getString(h.face_detect_feedback), new 4(this, bundle, i2, context));
        a(true, false, b);
    }
}
