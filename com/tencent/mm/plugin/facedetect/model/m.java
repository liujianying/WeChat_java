package com.tencent.mm.plugin.facedetect.model;

import android.content.Context;
import android.graphics.ImageFormat;
import android.graphics.Point;
import android.graphics.SurfaceTexture;
import android.hardware.Camera;
import android.hardware.Camera.CameraInfo;
import android.hardware.Camera.Parameters;
import android.hardware.Camera.PreviewCallback;
import android.hardware.Camera.Size;
import com.tencent.mm.compatible.e.d;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public final class m {
    private Context context;
    public Camera ddt;
    public boolean iOl = false;
    public Point iOm = null;
    public Point iOn = null;
    private Point iOo = null;
    private boolean iOp;
    public int iOq;
    private boolean iOr = false;
    private boolean iOs = true;
    public boolean iOt = false;
    public Point iOu = null;

    private static class a implements Comparator<Size> {
        private a() {
        }

        /* synthetic */ a(byte b) {
            this();
        }

        public final /* bridge */ /* synthetic */ int compare(Object obj, Object obj2) {
            Size size = (Size) obj;
            Size size2 = (Size) obj2;
            int i = size.height * size.width;
            int i2 = size2.height * size2.width;
            if (i2 < i) {
                return -1;
            }
            return i2 > i ? 1 : 0;
        }
    }

    public m(Context context) {
        this.context = context;
    }

    public final void e(SurfaceTexture surfaceTexture) {
        if (this.iOl) {
            x.w("MicroMsg.FaceScanCamera", "in open(), previewing");
            release();
        }
        this.iOs = true;
        int numberOfCameras = Camera.getNumberOfCameras();
        int i = 0;
        while (i < numberOfCameras) {
            CameraInfo cameraInfo = new CameraInfo();
            Camera.getCameraInfo(i, cameraInfo);
            if (cameraInfo.facing != 1 || !this.iOs) {
                if (cameraInfo.facing == 0 && !this.iOs) {
                    x.d("MicroMsg.FaceScanCamera", "hy: front Camera found");
                    break;
                }
                i++;
            } else {
                x.d("MicroMsg.FaceScanCamera", "hy: front Camera found");
                break;
            }
        }
        i = -1;
        long VG = bi.VG();
        com.tencent.mm.compatible.e.d.a.a s = d.s(this.context, i);
        if (s == null) {
            x.e("MicroMsg.FaceScanCamera", "in open(), openCameraRes == null");
            throw new IOException();
        }
        boolean z;
        this.iOt = true;
        x.d("MicroMsg.FaceScanCamera", "openCamera done, cameraId=[%s] costTime=[%s]", new Object[]{Integer.valueOf(i), Long.valueOf(bi.bI(VG))});
        this.iOq = s.bYE;
        if (s.bYE % 180 != 0) {
            z = true;
        } else {
            z = false;
        }
        this.iOp = z;
        this.ddt = s.ddt;
        if (this.ddt == null) {
            x.e("MicroMsg.FaceScanCamera", "in open(), camera == null, bNeedRotate=[%s]", new Object[]{Boolean.valueOf(this.iOp)});
            throw new IOException();
        }
        String str;
        this.ddt.setPreviewTexture(surfaceTexture);
        Parameters parameters = this.ddt.getParameters();
        Point point = this.iOn;
        Point point2 = this.iOo;
        String str2 = parameters.get("preview-size-values");
        if (str2 == null) {
            str = parameters.get("preview-size-value");
        } else {
            str = str2;
        }
        Point point3 = null;
        if (str != null) {
            x.d("MicroMsg.FaceScanCamera", "preview-size-values parameter: " + str);
            point3 = a(parameters, point);
        }
        if (point3 == null) {
            point3 = new Point((point2.x >> 3) << 3, (point2.y >> 3) << 3);
        }
        this.iOm = point3;
        this.iOu = new Point(this.iOm);
        x.d("MicroMsg.FaceScanCamera", "getCameraResolution: " + this.iOn + " camera:" + this.iOm + "bestVideoEncodeSize: " + this.iOu);
        parameters.setPreviewSize(this.iOm.x, this.iOm.y);
        parameters.setZoom(0);
        parameters.setSceneMode("auto");
        try {
            List<Integer> supportedPreviewFormats;
            boolean z2;
            if (parameters.getSupportedFocusModes() == null || !parameters.getSupportedFocusModes().contains("auto")) {
                x.i("MicroMsg.FaceScanCamera", "camera not support FOCUS_MODE_AUTO");
                supportedPreviewFormats = parameters.getSupportedPreviewFormats();
                z2 = false;
                for (Integer intValue : supportedPreviewFormats) {
                    i = intValue.intValue();
                    x.d("MicroMsg.FaceScanCamera", "supportedPreviewFormat: " + i);
                    if (i == 17) {
                        z = true;
                        break;
                    }
                    if (i == 842094169) {
                        z = true;
                    } else {
                        z = z2;
                    }
                    z2 = z;
                }
                z = false;
                if (z) {
                    parameters.setPreviewFormat(17);
                } else if (z2) {
                    x.e("MicroMsg.FaceScanCamera", "Preview not support PixelFormat.YCbCr_420_SP, but hasYU12");
                    parameters.setPreviewFormat(842094169);
                } else {
                    x.e("MicroMsg.FaceScanCamera", "Preview not support PixelFormat.YCbCr_420_SP. Use format: %s", new Object[]{supportedPreviewFormats.get(0)});
                    parameters.setPreviewFormat(((Integer) supportedPreviewFormats.get(0)).intValue());
                }
                if (this.iOp) {
                    parameters.setRotation(this.iOq);
                }
                this.ddt.setParameters(parameters);
            }
            x.i("MicroMsg.FaceScanCamera", "set FocusMode to FOCUS_MODE_AUTO");
            parameters.setFocusMode("auto");
            supportedPreviewFormats = parameters.getSupportedPreviewFormats();
            z2 = false;
            while (r6.hasNext()) {
                i = intValue.intValue();
                x.d("MicroMsg.FaceScanCamera", "supportedPreviewFormat: " + i);
                if (i == 17) {
                    z = true;
                    break;
                }
                if (i == 842094169) {
                    z = true;
                } else {
                    z = z2;
                }
                z2 = z;
            }
            z = false;
            if (z) {
                parameters.setPreviewFormat(17);
            } else if (z2) {
                x.e("MicroMsg.FaceScanCamera", "Preview not support PixelFormat.YCbCr_420_SP, but hasYU12");
                parameters.setPreviewFormat(842094169);
            } else {
                x.e("MicroMsg.FaceScanCamera", "Preview not support PixelFormat.YCbCr_420_SP. Use format: %s", new Object[]{supportedPreviewFormats.get(0)});
                parameters.setPreviewFormat(((Integer) supportedPreviewFormats.get(0)).intValue());
            }
            if (this.iOp) {
                parameters.setRotation(this.iOq);
            }
            this.ddt.setParameters(parameters);
        } catch (Exception e) {
            x.e("MicroMsg.FaceScanCamera", "set focus mode error: %s", new Object[]{e.getMessage()});
        }
    }

    public final void release() {
        x.d("MicroMsg.FaceScanCamera", "release(), previewing = [%s]", new Object[]{Boolean.valueOf(this.iOl)});
        if (this.ddt != null) {
            long VG = bi.VG();
            if (this.iOl) {
                this.ddt.setPreviewCallback(null);
                this.ddt.stopPreview();
                this.iOl = false;
                x.d("MicroMsg.FaceScanCamera", "stopPreview costTime=[%s]", new Object[]{Long.valueOf(bi.bI(VG))});
            }
            VG = bi.VG();
            this.ddt.release();
            this.ddt = null;
            this.iOt = false;
            x.d("MicroMsg.FaceScanCamera", "camera.release() costTime=[%s]", new Object[]{Long.valueOf(bi.bI(VG))});
        }
        this.iOr = false;
    }

    public final int getPreviewWidth() {
        x.v("MicroMsg.FaceScanCamera", "hy: preview width: %d", new Object[]{Integer.valueOf(this.iOm.x)});
        return this.iOm.x;
    }

    public final int getPreviewHeight() {
        x.v("MicroMsg.FaceScanCamera", "hy: preview height: %d", new Object[]{Integer.valueOf(this.iOm.y)});
        return this.iOm.y;
    }

    private static Point a(Parameters parameters, Point point) {
        Size previewSize;
        List<Size> arrayList = new ArrayList(parameters.getSupportedPreviewSizes());
        Collections.sort(arrayList, new a());
        Point point2 = null;
        x.d("MicroMsg.FaceScanCamera", "screen.x: %d, screen.y: %d, ratio: %f", new Object[]{Integer.valueOf(point.x), Integer.valueOf(point.y), Float.valueOf(((float) point.x) / ((float) point.y))});
        long fQ = bi.fQ(ad.getContext());
        x.d("MicroMsg.FaceScanCamera", "systemAvailableMemInMB: %d", new Object[]{Long.valueOf(fQ)});
        int i = point.x;
        i = point.y;
        float f = Float.POSITIVE_INFINITY;
        for (Size previewSize2 : arrayList) {
            int i2 = previewSize2.width;
            int i3 = previewSize2.height;
            x.i("MicroMsg.FaceScanCamera", "realWidth: %d, realHeight: %d", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3)});
            int i4 = i2 * i3;
            if (i4 >= 150400 && i4 <= 983040) {
                Object obj = i2 > i3 ? 1 : null;
                if (obj != null) {
                    i = i3;
                } else {
                    i = i2;
                }
                if (obj != null) {
                    i4 = i2;
                } else {
                    i4 = i3;
                }
                x.d("MicroMsg.FaceScanCamera", "maybeFlippedWidth: %d, maybeFlippedHeight: %d", new Object[]{Integer.valueOf(i), Integer.valueOf(i4)});
                if (i == point.x && i4 == point.y && f(i, i4, fQ)) {
                    point2 = new Point(i2, i3);
                    x.i("MicroMsg.FaceScanCamera", "Found preview size exactly matching screen size: " + point2);
                    return point2;
                }
                float f2;
                float abs = Math.abs((((float) i) / ((float) i4)) - r8);
                if (abs >= f || !f(i2, i3, fQ)) {
                    f2 = f;
                } else {
                    f2 = abs;
                    point2 = new Point(i2, i3);
                }
                x.i("MicroMsg.FaceScanCamera", "diff:[%s] newdiff:[%s] w:[%s] h:[%s]", new Object[]{Float.valueOf(f2), Float.valueOf(abs), Integer.valueOf(i2), Integer.valueOf(i3)});
                f = f2;
            }
        }
        if (point2 == null) {
            previewSize2 = parameters.getPreviewSize();
            if (previewSize2 != null) {
                point2 = new Point(previewSize2.width, previewSize2.height);
                x.i("MicroMsg.FaceScanCamera", "No suitable preview sizes, using default: " + point2);
            } else {
                x.e("MicroMsg.FaceScanCamera", "hy: can not find default size!!");
            }
        }
        x.i("MicroMsg.FaceScanCamera", "Found best approximate preview size: " + point2);
        return point2;
    }

    private static boolean f(int i, int i2, long j) {
        x.d("MicroMsg.FaceScanCamera", "dataSizeInMB: %f, availableMemInMb: %d", new Object[]{Double.valueOf(((((((double) i) * ((double) i2)) * 3.0d) / 2.0d) / 1024.0d) / 1024.0d), Long.valueOf(j)});
        if (((double) j) / (((((((double) i) * ((double) i2)) * 3.0d) / 2.0d) / 1024.0d) / 1024.0d) >= 5.0d) {
            return true;
        }
        return false;
    }

    public final void setPreviewCallback(final PreviewCallback previewCallback) {
        if (this.ddt == null) {
            x.w("MicroMsg.FaceScanCamera", "hy: camera is null. setPreviewCallback failed");
            return;
        }
        this.ddt.addCallbackBuffer(c.iNi.i(Integer.valueOf(((getPreviewWidth() * getPreviewHeight()) * ImageFormat.getBitsPerPixel(this.ddt.getParameters().getPreviewFormat())) / 8)));
        this.ddt.setPreviewCallbackWithBuffer(new PreviewCallback() {
            public final void onPreviewFrame(byte[] bArr, Camera camera) {
                if (previewCallback != null) {
                    previewCallback.onPreviewFrame(bArr, camera);
                }
                camera.addCallbackBuffer(bArr);
            }
        });
    }
}
