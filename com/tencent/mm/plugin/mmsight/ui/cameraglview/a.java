package com.tencent.mm.plugin.mmsight.ui.cameraglview;

import com.tencent.mm.plugin.mmsight.model.f;
import com.tencent.mm.sdk.platformtools.x;

public final class a {
    public f lqP = new 1(this);
    MMSightCameraGLSurfaceView lqQ;

    public final void a(byte[] bArr, boolean z, int i) {
        if (this.lqQ != null) {
            MMSightCameraGLSurfaceView mMSightCameraGLSurfaceView = this.lqQ;
            if (bArr == null || mMSightCameraGLSurfaceView.lqS == null || mMSightCameraGLSurfaceView.lqS.bum) {
                x.v("MicroMsg.MMSightCameraGLSurfaceView", "passing draw");
                return;
            }
            mMSightCameraGLSurfaceView.lqS.b(bArr, mMSightCameraGLSurfaceView.fau, mMSightCameraGLSurfaceView.fav, i, z);
            mMSightCameraGLSurfaceView.requestRender();
        }
    }

    public a(MMSightCameraGLSurfaceView mMSightCameraGLSurfaceView) {
        this.lqQ = mMSightCameraGLSurfaceView;
    }

    public final void Q(int i, int i2, int i3) {
        if (this.lqQ != null) {
            int i4 = (i3 == 0 || i3 == 180) ? i : i2;
            if (i3 == 0 || i3 == 180) {
                i = i2;
            }
            MMSightCameraGLSurfaceView mMSightCameraGLSurfaceView = this.lqQ;
            x.i("MicroMsg.MMSightCameraGLSurfaceView", "setFrameInfo, width: %s, height: %s, rotate: %s this: %s", new Object[]{Integer.valueOf(i4), Integer.valueOf(i), Integer.valueOf(i3), mMSightCameraGLSurfaceView});
            mMSightCameraGLSurfaceView.fau = i4;
            mMSightCameraGLSurfaceView.fav = i;
            mMSightCameraGLSurfaceView.faO = i3;
        }
    }

    public final void bfu() {
        if (this.lqQ != null) {
            MMSightCameraGLSurfaceView mMSightCameraGLSurfaceView = this.lqQ;
            if (mMSightCameraGLSurfaceView.lqS != null) {
                mMSightCameraGLSurfaceView.lqS.faJ = true;
                mMSightCameraGLSurfaceView.requestRender();
            }
        }
    }
}
