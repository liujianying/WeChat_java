package com.tencent.mm.plugin.voip.video;

import android.content.Context;
import android.content.pm.PackageManager;
import android.graphics.Point;
import android.hardware.Camera;
import android.hardware.Camera.CameraInfo;
import android.os.Build.VERSION;
import com.tencent.mm.compatible.e.q;
import com.tencent.mm.sdk.platformtools.x;

public final class j {
    public static h oVo;
    public static int oVp = -1;
    public static int oVq = -1;
    public static int oVr = 0;
    public static int oVs = 0;
    public static int oVt = 0;
    public static boolean oVu = true;

    public static boolean bMl() {
        if (q.deM.dcL && q.deM.dcK == 8) {
            return false;
        }
        return true;
    }

    private static boolean bMm() {
        try {
            if (Class.forName("android.hardware.Camera").getDeclaredMethod("getNumberOfCameras", null) != null) {
                return true;
            }
            x.d("GetfcMethod", "GetfcMethod is null");
            return false;
        } catch (Exception e) {
            x.e("MicroMsg.CameraUtil", "find getNumberOfCameras failed: " + e.getMessage());
            return false;
        }
    }

    public static void eq(Context context) {
        if (oVo == null) {
            oVo = new h("*");
            boolean bMm = bMm();
            oVu = bMm;
            if (!bMm || q.deM.dcJ) {
                if (oVu && q.deM.dcJ) {
                    bMn();
                }
                if (q.deM.dcJ) {
                    oVo.dcI = q.deM.dcI;
                }
                if (q.deM.dcQ) {
                    if (q.deM.dcP.ddp != 0) {
                        oVo.oTZ = true;
                    } else {
                        oVo.oTZ = false;
                    }
                }
                if (q.deM.dcO) {
                    if (q.deM.dcN.ddp != 0) {
                        oVo.oTY = true;
                    } else {
                        oVo.oTY = false;
                    }
                }
                if (q.deM.dcO && q.deM.dcN.ddq >= 0) {
                    oVo.oUa = q.deM.dcN.ddq;
                    oVr = oVo.oUa;
                }
                if (q.deM.dcQ && q.deM.dcP.ddq >= 0) {
                    oVo.oUb = q.deM.dcP.ddq;
                    oVs = oVo.oUb;
                }
                if (q.deM.dcO) {
                    if (oVo.oUc == null) {
                        oVo.oUc = new Point(0, 0);
                    }
                    oVo.oUc = new Point(q.deM.dcN.width, q.deM.dcN.height);
                }
                if (q.deM.dcQ) {
                    if (oVo.oUd == null) {
                        oVo.oUd = new Point(0, 0);
                    }
                    oVo.oUd = new Point(q.deM.dcP.width, q.deM.dcP.height);
                }
                if (q.deM.dcQ && q.deM.dcP.fps != 0) {
                    oVo.oTX = q.deM.dcP.fps;
                }
                if (q.deM.dcO && q.deM.dcN.fps != 0) {
                    oVo.oTX = q.deM.dcN.fps;
                }
                PackageManager packageManager = context.getPackageManager();
                if (!(q.deM.dcJ || packageManager.hasSystemFeature("android.hardware.camera"))) {
                    oVo.dcI = 0;
                    oVo.oTY = false;
                    oVo.oTZ = false;
                }
            } else {
                bMn();
            }
            if (q.deM.anb) {
                oVt = q.deM.dcM;
            }
            x.i("MicroMsg.CameraUtil", "gCameraNum:" + oVo.dcI + "\ngIsHasFrontCamera:" + oVo.oTY + "\ngIsHasBackCamera:" + oVo.oTZ + "\ngFrontCameraId:" + oVp + "\ngBackCameraId:" + oVq + "\ngBackOrientation:" + oVo.oUb + "\ngFrontOrientation:" + oVo.oUa + "\ngBestFps:" + oVo.oTX + "\ngFacePreviewSize:" + oVo.oUc + "\ngNonFacePreviewSize:" + oVo.oUd + "\ngFaceCameraIsRotate180:" + oVr + "\ngMainCameraIsRotate180:" + oVs + "\ngCameraFormat:" + oVt + "\ngFaceNotRotate:SDK:" + VERSION.SDK_INT + "\n");
        }
    }

    private static void bMn() {
        oVo.dcI = Camera.getNumberOfCameras();
        CameraInfo cameraInfo = new CameraInfo();
        int i = 0;
        while (i < oVo.dcI) {
            try {
                Camera.getCameraInfo(i, cameraInfo);
                if (cameraInfo.facing == 1) {
                    oVp = i;
                    oVo.oUa = cameraInfo.orientation;
                    oVo.oTY = true;
                } else if (cameraInfo.facing == 0) {
                    oVq = i;
                    oVo.oUb = cameraInfo.orientation;
                    oVo.oTZ = true;
                }
                i++;
            } catch (Exception e) {
                x.e("MicroMsg.CameraUtil", "get camera info error: %s", new Object[]{e.getMessage()});
            }
        }
        String property = System.getProperty("ro.media.enc.camera.platform", null);
        boolean equalsIgnoreCase = property == null ? false : property.equalsIgnoreCase("Mediatek");
        if (oVo.oUa == 270 || (equalsIgnoreCase && oVo.oUa == 0)) {
            oVr = 1;
        } else {
            oVr = 0;
        }
        if (oVo.oUb == 270 || (equalsIgnoreCase && oVo.oUb == 0)) {
            oVs = 1;
        } else {
            oVs = 0;
        }
    }
}
