package com.tencent.mm.plugin.mmsight.ui.cameraglview;

import com.tencent.mm.plugin.mmsight.model.f;
import com.tencent.mm.sdk.platformtools.x;

class a$1 implements f {
    final /* synthetic */ a lqR;

    a$1(a aVar) {
        this.lqR = aVar;
    }

    public final boolean T(byte[] bArr) {
        if (this.lqR.lqQ != null) {
            MMSightCameraGLSurfaceView mMSightCameraGLSurfaceView = this.lqR.lqQ;
            if (bArr == null || mMSightCameraGLSurfaceView.lqS == null || mMSightCameraGLSurfaceView.lqS.bum) {
                x.v("MicroMsg.MMSightCameraGLSurfaceView", "passing draw");
            } else {
                mMSightCameraGLSurfaceView.lqS.b(bArr, mMSightCameraGLSurfaceView.fau, mMSightCameraGLSurfaceView.fav, mMSightCameraGLSurfaceView.faO, false);
                mMSightCameraGLSurfaceView.requestRender();
            }
        }
        return false;
    }
}
