package com.tencent.mm.plugin.facedetect.service;

import android.content.Intent;
import com.tencent.mm.plugin.facedetect.e.a;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

public final class b extends a {
    long iNq = -1;
    String mAppId = "";

    public final void C(Intent intent) {
        this.iNq = intent.getLongExtra("k_bio_id", -1);
        this.mAppId = intent.getStringExtra("key_app_id");
        x.i("MicroMsg.FaceDetectServiceControllerMp", "hy: got bioid: %d, appid: %s", new Object[]{Long.valueOf(this.iNq), this.mAppId});
        x.i("MicroMsg.FaceDetectServiceControllerMp", "hy: requesting release and send video");
        if (a.aKA().iSn && (a.aKA().aKD() == a.a.iSP || a.aKA().aKD() == a.a.iSQ || a.aKA().aKD() == a.a.iSR)) {
            a.aKA().a(new 1(this, bi.VG()));
            return;
        }
        x.i("MicroMsg.FaceDetectServiceControllerMp", "hy: not recording video");
    }
}
