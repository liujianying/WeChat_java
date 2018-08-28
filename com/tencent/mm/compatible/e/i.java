package com.tencent.mm.compatible.e;

import android.hardware.Camera;
import android.hardware.Camera.CameraInfo;
import com.tencent.mm.compatible.e.d.a;
import com.tencent.mm.sdk.platformtools.x;

final class i implements a {
    i() {
    }

    public static int getNumberOfCameras() {
        int numberOfCameras;
        if (!q.deM.dcX || q.deM.dcW == -1) {
            numberOfCameras = d.getNumberOfCameras();
            x.d("CameraUtilImplConfig", "getNumberOfCameras " + numberOfCameras);
            return numberOfCameras <= 1 ? 0 : numberOfCameras;
        } else {
            numberOfCameras = q.deM.dcW;
            x.d("CameraUtilImplConfig", "mVRCameraNum " + numberOfCameras);
            return numberOfCameras;
        }
    }

    public static d$a$a fL(int i) {
        d$a$a d_a_a = new d$a$a();
        d_a_a.ddt = null;
        try {
            d_a_a.ddt = Camera.open(i);
            if (d_a_a.ddt == null) {
                return null;
            }
            d_a_a.bYE = 0;
            x.d("CameraUtilImplConfig", "DeviceInfo.mCameraInfo.hasVRInfo " + q.deM.dcR);
            x.d("CameraUtilImplConfig", "DeviceInfo.mCameraInfo.mVRFaceRotate " + q.deM.dcS);
            x.d("CameraUtilImplConfig", "DeviceInfo.mCameraInfo.mVRFaceDisplayOrientation " + q.deM.dcT);
            x.d("CameraUtilImplConfig", "DeviceInfo.mCameraInfo.mVRBackRotate " + q.deM.dcU);
            x.d("CameraUtilImplConfig", "DeviceInfo.mCameraInfo.mVRBackDisplayOrientation " + q.deM.dcV);
            if (getNumberOfCameras() > 1) {
                try {
                    CameraInfo cameraInfo = new CameraInfo();
                    Camera.getCameraInfo(i, cameraInfo);
                    x.d("CameraUtilImplConfig", "info.facing " + cameraInfo.facing);
                    if (cameraInfo.facing == 1) {
                        if (q.deM.dcR && q.deM.dcS != -1) {
                            d_a_a.bYE = q.deM.dcS;
                        }
                        if (q.deM.dcR && q.deM.dcT != -1) {
                            d_a_a.ddt.setDisplayOrientation(q.deM.dcT);
                        }
                    } else {
                        if (q.deM.dcR && q.deM.dcU != -1) {
                            d_a_a.bYE = q.deM.dcU;
                        }
                        if (q.deM.dcR && q.deM.dcV != -1) {
                            d_a_a.ddt.setDisplayOrientation(q.deM.dcV);
                        }
                    }
                } catch (Throwable e) {
                    x.printErrStackTrace("CameraUtilImplConfig", e, "", new Object[0]);
                }
            } else {
                if (q.deM.dcR && q.deM.dcU != -1) {
                    d_a_a.bYE = q.deM.dcU;
                }
                if (q.deM.dcR && q.deM.dcV != -1) {
                    d_a_a.ddt.setDisplayOrientation(q.deM.dcV);
                }
            }
            return d_a_a;
        } catch (Exception e2) {
            return null;
        }
    }
}
