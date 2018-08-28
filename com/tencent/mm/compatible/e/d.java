package com.tencent.mm.compatible.e;

import android.content.Context;
import android.hardware.Camera;
import android.hardware.Camera.CameraInfo;
import android.os.Build;
import android.os.Build.VERSION;
import com.tencent.mm.sdk.platformtools.x;

public final class d {
    public static int getNumberOfCameras() {
        if (q.deM.dcR && q.deM.dcX) {
            i iVar = new i();
            return i.getNumberOfCameras();
        }
        g gVar = new g();
        return Camera.getNumberOfCameras();
    }

    public static int ze() {
        if (q.deW.ddR == 1) {
            return 0;
        }
        int numberOfCameras = Camera.getNumberOfCameras();
        CameraInfo cameraInfo = new CameraInfo();
        int i = 0;
        while (i < numberOfCameras) {
            Camera.getCameraInfo(i, cameraInfo);
            if (cameraInfo.facing == 0) {
                x.d("MicroMsg.CameraUtil", "tigercam get bid %d", new Object[]{Integer.valueOf(i)});
                break;
            }
            i++;
        }
        i = 0;
        x.d("MicroMsg.CameraUtil", "tigercam getBackCameraId %d", new Object[]{Integer.valueOf(i)});
        return i;
    }

    public static boolean zf() {
        if (q.deM.dcZ == 1) {
            return true;
        }
        if (VERSION.SDK_INT == 10 && Build.MODEL.equals("GT-S5360")) {
            return true;
        }
        return false;
    }

    public static a s(Context context, int i) {
        if (q.deM.dcZ == 1) {
            x.d("MicroMsg.CameraUtil", "openCamera(), CameraUtilImpl20, cameraId = " + i);
            e eVar = new e();
            return e.zg();
        } else if (q.deM.dcR) {
            x.d("MicroMsg.CameraUtil", "openCamera(), CameraUtilImplConfig, cameraId = " + i);
            i iVar = new i();
            return i.fL(i);
        } else if (Build.MODEL.equals("M9")) {
            j jVar = new j();
            return j.zg();
        } else if (getNumberOfCameras() > 1) {
            x.d("MicroMsg.CameraUtil", "openCamera(), CameraUtilImpl23, cameraId = " + i);
            g gVar = new g();
            return g.s(context, i);
        } else {
            f fVar = new f();
            return f.fL(i);
        }
    }
}
