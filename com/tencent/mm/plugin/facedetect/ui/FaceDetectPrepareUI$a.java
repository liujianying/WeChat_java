package com.tencent.mm.plugin.facedetect.ui;

import android.os.Handler;
import android.os.Message;
import com.tencent.mm.sdk.platformtools.x;
import java.lang.ref.WeakReference;

class FaceDetectPrepareUI$a extends Handler {
    private WeakReference<FaceDetectPrepareUI> iQm;

    /* synthetic */ FaceDetectPrepareUI$a(FaceDetectPrepareUI faceDetectPrepareUI, byte b) {
        this(faceDetectPrepareUI);
    }

    private FaceDetectPrepareUI$a(FaceDetectPrepareUI faceDetectPrepareUI) {
        this.iQm = null;
        this.iQm = new WeakReference(faceDetectPrepareUI);
    }

    public final void handleMessage(Message message) {
        x.i("MicroMsg.FaceDetectPrepareUI", "alvinluo client msg.what: %d", new Object[]{Integer.valueOf(message.what)});
        if (this.iQm != null && this.iQm.get() != null) {
            switch (message.what) {
                case 0:
                    FaceDetectPrepareUI.a((FaceDetectPrepareUI) this.iQm.get(), message);
                    return;
                case 1:
                    FaceDetectPrepareUI.b((FaceDetectPrepareUI) this.iQm.get(), message);
                    return;
                default:
                    return;
            }
        }
    }
}
