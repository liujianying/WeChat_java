package com.tencent.mm.plugin.facedetect.ui;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.Process;
import com.tencent.mm.plugin.facedetect.model.f;
import com.tencent.mm.plugin.facedetect.service.FaceDetectProcessService;
import com.tencent.mm.plugin.facedetect.service.FaceDetectProcessService.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

class FaceDetectUI$4 implements ServiceConnection {
    final /* synthetic */ FaceDetectUI iRF;

    FaceDetectUI$4(FaceDetectUI faceDetectUI) {
        this.iRF = faceDetectUI;
    }

    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        x.i("MicroMsg.FaceDetectUI", "alvinluo service connected %s", new Object[]{componentName});
        FaceDetectUI.a(this.iRF, true);
        FaceDetectUI.a(this.iRF, ((a) iBinder).iPD);
        f fVar = f.iNu;
        FaceDetectProcessService d = FaceDetectUI.d(this.iRF);
        x.i("MicroMsg.FaceDetectManager", "alvinluo bindService process name: %s, hashCode: %d", new Object[]{bi.an(ad.getContext(), Process.myPid()), Integer.valueOf(fVar.hashCode())});
        fVar.iNv = d;
        x.i("MicroMsg.FaceDetectUI", "alvinluo FaceDetectUI service hashCode: %d", new Object[]{Integer.valueOf(FaceDetectUI.d(this.iRF).hashCode())});
        FaceDetectUI.e(this.iRF);
    }

    public final void onServiceDisconnected(ComponentName componentName) {
        x.i("MicroMsg.FaceDetectUI", "alvinluo service disconnected %s", new Object[]{componentName.toString()});
        FaceDetectUI.a(this.iRF, false);
    }
}
