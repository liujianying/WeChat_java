package com.tencent.mm.plugin.facedetect.model;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mm.g.a.np;
import com.tencent.mm.plugin.facedetect.ui.FaceDetectConfirmUI;
import com.tencent.mm.plugin.facedetect.ui.FaceDetectPrepareUI;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.x;

public final class i extends c<np> {
    public i() {
        this.sFo = np.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        boolean z = false;
        np npVar = (np) bVar;
        if (npVar == null) {
            return false;
        }
        np.b bVar2 = npVar.bYH;
        f fVar = f.iNu;
        Context context = npVar.bYG.context;
        Bundle bundle = npVar.bYG.extras;
        int i = npVar.bYG.bYI;
        x.i("MicroMsg.FaceDetectManager", "start face detect process");
        FaceDetectReporter.aJU().aJV();
        FaceDetectReporter aJU = FaceDetectReporter.aJU();
        x.v("MicroMsg.FaceDetectReporter", "create interface called session");
        aJU.iOg = System.currentTimeMillis();
        aJU.iOj = 0;
        aJU.iOk = false;
        aJU.iOh = -1;
        aJU.iOi = -1;
        long j = aJU.iOg;
        FaceDetectReporter.aJU().iOh = System.currentTimeMillis();
        if (context != null) {
            if (bundle != null) {
                int i2 = bundle.getInt("k_server_scene", 2);
                FaceDetectReporter.aJU().appId = bundle.getString("k_app_id", "");
                if (f.eJ(bundle.getBoolean("is_check_dyncfg", false))) {
                    Intent intent = (i2 == 2 || i2 == 5) ? new Intent(context, FaceDetectConfirmUI.class) : new Intent(context, FaceDetectPrepareUI.class);
                    intent.putExtras(bundle);
                    ((Activity) context).startActivityForResult(intent, i);
                    z = true;
                } else {
                    x.w("MicroMsg.FaceDetectManager", "alvinluo: not support face detect");
                    FaceDetectReporter aJU2 = FaceDetectReporter.aJU();
                    aJU2.I(FaceDetectReporter.pw(i2), false);
                    aJU2.a(FaceDetectReporter.pw(i2), false, 3, 4, 90001);
                }
            } else {
                x.e("MicroMsg.FaceDetectManager", "hy: extras is null! should not happen");
            }
        }
        bVar2.bYJ = z;
        if (!npVar.bYH.bYJ) {
            npVar.bYH.extras = new Bundle();
            npVar.bYH.extras.putInt("err_code", 90001);
            npVar.bYH.extras.putString("err_msg", "face detect not support");
        }
        return true;
    }
}
