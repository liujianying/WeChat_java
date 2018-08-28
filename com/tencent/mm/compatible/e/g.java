package com.tencent.mm.compatible.e;

import android.content.Context;
import android.hardware.Camera;
import android.hardware.Camera.CameraInfo;
import android.view.WindowManager;
import com.tencent.mm.compatible.e.d.a;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.rtmp.TXLiveConstants;

public final class g implements a {
    public static d$a$a s(Context context, int i) {
        d$a$a d_a_a = new d$a$a();
        d_a_a.ddt = null;
        try {
            long VG = bi.VG();
            x.i("MicroMsg.CameraUtil", "ashu::begin to try Call Camera.open cameraID %d", new Object[]{Integer.valueOf(i)});
            d_a_a.ddt = Camera.open(i);
            x.i("MicroMsg.CameraUtil", "ashu::Call Camera.open back, use %dms", new Object[]{Long.valueOf(bi.bI(VG))});
            if (d_a_a.ddt == null) {
                x.e("MicroMsg.CameraUtil", "open camera error, not exception, but camera null");
                return null;
            }
            int i2;
            CameraInfo cameraInfo = new CameraInfo();
            VG = bi.VG();
            x.i("MicroMsg.CameraUtil", "ashu::begin to Call Camera.getCameraInfo cameraID %d", new Object[]{Integer.valueOf(i)});
            Camera.getCameraInfo(i, cameraInfo);
            x.i("MicroMsg.CameraUtil", "ashu::Call Camera.getCameraInfo back, use %dms", new Object[]{Long.valueOf(bi.bI(VG))});
            switch (((WindowManager) context.getSystemService("window")).getDefaultDisplay().getRotation()) {
                case 0:
                    i2 = 0;
                    break;
                case 1:
                    i2 = 90;
                    break;
                case 2:
                    i2 = 180;
                    break;
                case 3:
                    i2 = TXLiveConstants.RENDER_ROTATION_LANDSCAPE;
                    break;
                default:
                    i2 = 0;
                    break;
            }
            if (cameraInfo.facing == 1) {
                i2 = (360 - (cameraInfo.orientation % 360)) % 360;
            } else {
                i2 = ((cameraInfo.orientation - i2) + 360) % 360;
            }
            VG = bi.VG();
            x.i("MicroMsg.CameraUtil", "ashu::begin to Call Camera.setDisplayOrientation %d", new Object[]{Integer.valueOf(i2)});
            d_a_a.ddt.setDisplayOrientation(i2);
            x.i("MicroMsg.CameraUtil", "ashu::Call Camera.setDisplayOrientation back, use %dms", new Object[]{Long.valueOf(bi.bI(VG))});
            d_a_a.bYE = cameraInfo.orientation;
            return d_a_a;
        } catch (Throwable e) {
            x.e("MicroMsg.CameraUtil", "open camera error %s", new Object[]{e.getMessage()});
            x.printErrStackTrace("MicroMsg.CameraUtil", e, "", new Object[0]);
            return null;
        }
    }
}
