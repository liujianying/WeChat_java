package com.tencent.mm.plugin.facedetect.service;

import android.content.Intent;
import com.tencent.mm.plugin.facedetect.e.a$b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

class b$1 implements a$b {
    final /* synthetic */ long iPJ;
    final /* synthetic */ b iPK;

    b$1(b bVar, long j) {
        this.iPK = bVar;
        this.iPJ = j;
    }

    public final void AW(String str) {
        x.i("MicroMsg.FaceDetectServiceControllerMp", "hy: video release done. using: %d ms. file path: %s", new Object[]{Long.valueOf(bi.bI(this.iPJ)), str});
        if (!bi.oW(str)) {
            Intent intent = new Intent(ad.getContext(), FaceUploadVideoService.class);
            intent.putExtra("key_video_file_name", str);
            intent.putExtra("k_bio_id", this.iPK.iNq);
            intent.putExtra("key_app_id", this.iPK.mAppId);
            ad.getContext().startService(intent);
        }
    }
}
