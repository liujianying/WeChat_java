package com.tencent.mm.plugin.voip.video;

import android.annotation.TargetApi;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.SurfaceTexture;
import android.hardware.Camera;
import android.hardware.Camera.Area;
import android.hardware.Camera.CameraInfo;
import android.hardware.Camera.Parameters;
import android.hardware.Camera.PreviewCallback;
import android.hardware.Camera.Size;
import android.view.SurfaceHolder;
import android.view.WindowManager;
import com.tencent.mm.compatible.e.q;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.compatible.util.l;
import com.tencent.mm.g.a.lr;
import com.tencent.mm.plugin.game.gamewebview.jsapi.biz.aw;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.video.ObservableSurfaceView;
import com.tencent.mm.plugin.video.ObservableTextureView;
import com.tencent.mm.plugin.video.b;
import com.tencent.mm.plugin.voip.model.i;
import com.tencent.mm.plugin.voip_cs.b.c;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public final class a implements com.tencent.mm.plugin.video.a, b {
    private static final Pattern mNm = Pattern.compile(",");
    private static int oTa = 20;
    private static int oTb = 70;
    protected int mHeight = 240;
    protected int mWidth = 320;
    protected int oTA;
    protected int oTB = 0;
    protected int oTC = 0;
    protected int oTD = 0;
    PreviewCallback oTE = new 2(this);
    protected boolean oTc = false;
    protected boolean oTd = false;
    protected boolean oTe = false;
    protected boolean oTf = false;
    protected boolean oTg = false;
    protected long oTh = 0;
    protected long oTi = 30000;
    protected int oTj = 0;
    protected Camera oTk;
    protected Parameters oTl;
    protected Size oTm;
    protected int oTn;
    protected boolean oTo = false;
    protected boolean oTp = false;
    protected boolean oTq = false;
    protected ObservableSurfaceView oTr = null;
    protected ObservableTextureView oTs;
    protected g oTt;
    protected boolean oTu = false;
    protected boolean oTv = false;
    protected byte[] oTw = null;
    protected int[] oTx = null;
    protected List<byte[]> oTy;
    protected boolean oTz = true;

    public a(int i, int i2) {
        this.mWidth = i;
        this.mHeight = i2;
        j.eq(ad.getContext().getApplicationContext());
        x.d("MicroMsg.Voip.CaptureRender", "width: %d, height: %d", new Object[]{Integer.valueOf(this.mWidth), Integer.valueOf(this.mHeight)});
    }

    public final void a(ObservableSurfaceView observableSurfaceView) {
        if (observableSurfaceView != null) {
            this.oTr = observableSurfaceView;
            this.oTr.setSurfaceChangeCallback(this);
            this.oTq = true;
        }
    }

    public final void a(ObservableTextureView observableTextureView) {
        x.d("MicroMsg.Voip.CaptureRender", "bindTextureView");
        if (observableTextureView != null) {
            this.oTs = observableTextureView;
            this.oTs.setTextureChangeCallback(this);
            this.oTq = false;
        }
    }

    public final void a(SurfaceHolder surfaceHolder) {
        boolean z = false;
        x.d("MicroMsg.Voip.CaptureRender", "surfaceChange");
        if (!this.oTo || surfaceHolder.getSurface() == null) {
            String str = "MicroMsg.Voip.CaptureRender";
            String str2 = "surfaceChange failed, CameraOpen: %b, surface: %b";
            Object[] objArr = new Object[2];
            objArr[0] = Boolean.valueOf(this.oTo);
            if (surfaceHolder.getSurface() == null) {
                z = true;
            }
            objArr[1] = Boolean.valueOf(z);
            x.e(str, str2, objArr);
            return;
        }
        try {
            this.oTk.setPreviewCallback(null);
            this.oTk.stopPreview();
            this.oTk.setPreviewDisplay(surfaceHolder);
            bLW();
            this.oTk.startPreview();
        } catch (Exception e) {
            Exception exception = e;
            h.mEJ.a(159, 0, 1, false);
            h.mEJ.a(159, 2, 1, false);
            x.e("MicroMsg.Voip.CaptureRender", "surfaceChange failed" + exception.getMessage());
            this.oTj = 1;
        }
        if (this.oTv) {
            bLY();
            this.oTv = false;
        }
        i.bJI().yI(this.oTj);
    }

    public final void d(SurfaceTexture surfaceTexture) {
        boolean z = false;
        x.d("MicroMsg.Voip.CaptureRender", "onSurfaceTextureAvailable");
        if (!this.oTo || surfaceTexture == null) {
            String str = "MicroMsg.Voip.CaptureRender";
            String str2 = "onSurfaceTextureAvailable failed, CameraOpen: %b, surface: %b";
            Object[] objArr = new Object[2];
            objArr[0] = Boolean.valueOf(this.oTo);
            if (surfaceTexture == null) {
                z = true;
            }
            objArr[1] = Boolean.valueOf(z);
            x.e(str, str2, objArr);
            return;
        }
        try {
            this.oTk.setPreviewCallback(null);
            this.oTk.stopPreview();
            this.oTk.setPreviewTexture(surfaceTexture);
            bLW();
            this.oTk.startPreview();
        } catch (Exception e) {
            Exception exception = e;
            h.mEJ.a(159, 0, 1, false);
            h.mEJ.a(159, 2, 1, false);
            x.e("MicroMsg.Voip.CaptureRender", "surfaceChange failed" + exception.getMessage());
            this.oTj = 1;
        }
        if (this.oTv) {
            bLY();
            this.oTv = false;
        }
        i.bJI().yI(this.oTj);
    }

    public final int a(g gVar, boolean z) {
        if (j.oVo.dcI <= 0) {
            this.oTj = 1;
            return -1;
        }
        if (z) {
            if (!j.oVo.oTY) {
                z = false;
            }
        } else if (!j.oVo.oTZ) {
            z = true;
        }
        this.oTt = gVar;
        if (e(z, this.mWidth, this.mHeight) <= 0) {
            int e = e(z, 0, 0);
            if (e <= 0) {
                this.oTj = 1;
                return e;
            }
        }
        bLW();
        this.oTj = 0;
        return 1;
    }

    private void bLW() {
        int i = 0;
        if (this.oTm == null || this.oTm.height <= 0 || this.oTm.width <= 0) {
            this.oTk.setPreviewCallback(this.oTE);
            return;
        }
        int i2;
        int i3 = ((this.oTm.height * this.oTm.width) * 3) / 2;
        if (this.oTy == null) {
            this.oTy = new ArrayList(3);
            for (i2 = 0; i2 < 3; i2++) {
                this.oTy.add(new byte[i3]);
            }
        }
        while (true) {
            i2 = i;
            if (i2 < this.oTy.size()) {
                this.oTk.addCallbackBuffer((byte[]) this.oTy.get(i2));
                i = i2 + 1;
            } else {
                this.oTk.setPreviewCallbackWithBuffer(this.oTE);
                return;
            }
        }
    }

    private static Camera iV(boolean z) {
        Camera camera = null;
        if (j.oVo.dcI <= 0 || !j.oVu) {
            return null;
        }
        if (z) {
            try {
                camera = Camera.open(j.oVp);
                x.i("Camera", "Use front");
                return camera;
            } catch (Exception e) {
                Exception exception = e;
                h.mEJ.a(159, 0, 1, false);
                h.mEJ.a(159, 1, 1, false);
                x.e("MicroMsg.Voip.CaptureRender", "openCameraByHighApiLvl:error:" + exception.toString());
                return camera;
            }
        }
        camera = Camera.open(j.oVq);
        x.i("Camera", "Use back");
        return camera;
    }

    private Camera iW(boolean z) {
        Camera iV = iV(z);
        if (iV == null) {
            try {
                iV = Camera.open();
                try {
                    Parameters parameters = iV.getParameters();
                    parameters.set("camera-id", z ? 2 : 1);
                    iV.setParameters(parameters);
                } catch (Exception e) {
                    Exception exception = e;
                    h.mEJ.a(159, 0, 1, false);
                    x.e("MicroMsg.Voip.CaptureRender", "set camera-id error:" + exception.toString());
                }
            } catch (Exception e2) {
                x.e("MicroMsg.Voip.CaptureRender", "OpenCameraError:" + e2.toString());
                h.mEJ.a(159, 0, 1, false);
                h.mEJ.a(159, 1, 1, false);
                if (this.oTt != null) {
                    this.oTt.bgV();
                }
                return null;
            }
        }
        this.oTc = z;
        i(iV);
        h(iV);
        return iV;
    }

    private static boolean a(Camera camera, int i, int i2) {
        if (camera == null) {
            return false;
        }
        try {
            Parameters parameters = camera.getParameters();
            if (i > 0 && i2 > 0) {
                parameters.setPreviewSize(i, i2);
            }
            camera.setParameters(parameters);
            return true;
        } catch (Exception e) {
            h.mEJ.a(159, 0, 1, false);
            x.e("MicroMsg.Voip.CaptureRender", "TryPreviewSize fail:" + e.toString());
            return false;
        }
    }

    private boolean g(Camera camera) {
        if (camera == null) {
            return false;
        }
        try {
            Parameters parameters = camera.getParameters();
            List<String> supportedFocusModes = parameters.getSupportedFocusModes();
            if (supportedFocusModes != null) {
                x.d("MicroMsg.Voip.CaptureRender", "supported focus modes size = " + supportedFocusModes.size());
                for (String str : supportedFocusModes) {
                    x.d("MicroMsg.Voip.CaptureRender", "supported focus modes : " + str);
                }
                if (q.deM.ddo == 0) {
                    if (supportedFocusModes.contains("auto")) {
                        x.d("MicroMsg.Voip.CaptureRender", "camera support auto focus");
                        parameters.setFocusMode("auto");
                        this.oTp = false;
                    } else if (supportedFocusModes.contains("continuous-video")) {
                        x.d("MicroMsg.Voip.CaptureRender", "camera support continuous video focus");
                        parameters.setFocusMode("continuous-video");
                        this.oTp = true;
                    }
                } else if (q.deM.ddo == 1) {
                    if (supportedFocusModes.contains("continuous-video")) {
                        x.d("MicroMsg.Voip.CaptureRender", "camera support continuous video focus");
                        parameters.setFocusMode("continuous-video");
                        this.oTp = true;
                    } else if (supportedFocusModes.contains("auto")) {
                        x.d("MicroMsg.Voip.CaptureRender", "camera support auto focus");
                        parameters.setFocusMode("auto");
                        this.oTp = false;
                    }
                }
                camera.setParameters(parameters);
            }
            return true;
        } catch (Exception e) {
            h.mEJ.a(159, 0, 1, false);
            x.e("MicroMsg.Voip.CaptureRender", "TrySetAutoFocus fail:" + e.toString());
            return false;
        }
    }

    private static Point a(CharSequence charSequence, Point point) {
        int indexOf;
        int parseInt;
        int i = Integer.MAX_VALUE;
        int i2 = 0;
        int i3 = 0;
        for (String trim : mNm.split(charSequence)) {
            String trim2 = trim2.trim();
            indexOf = trim2.indexOf(120);
            if (indexOf < 0) {
                x.w("MicroMsg.Voip.CaptureRender", "Bad preview-size: " + trim2);
            } else {
                try {
                    parseInt = Integer.parseInt(trim2.substring(0, indexOf));
                    indexOf = Integer.parseInt(trim2.substring(indexOf + 1));
                    int abs = Math.abs(parseInt - point.x) + Math.abs(indexOf - point.y);
                    if (abs == 0) {
                        break;
                    } else if (abs < i && parseInt != indexOf) {
                        i = abs;
                        i2 = indexOf;
                        i3 = parseInt;
                    }
                } catch (NumberFormatException e) {
                    x.w("MicroMsg.Voip.CaptureRender", "Bad preview-size: " + trim2);
                }
            }
        }
        indexOf = i2;
        parseInt = i3;
        if (parseInt <= 0 || indexOf <= 0) {
            return null;
        }
        return new Point(parseInt, indexOf);
    }

    private int e(boolean z, int i, int i2) {
        Exception e;
        Object obj;
        Size size;
        Camera camera;
        CameraInfo cameraInfo;
        int i3;
        x.i("MicroMsg.Voip.CaptureRender", "try open camera, face: " + z);
        this.oTp = false;
        Object obj2 = 1;
        if (this.oTk != null) {
            if (this.oTc != z) {
                this.oTk.setPreviewCallback(null);
                this.oTk.stopPreview();
                this.oTk.release();
                this.oTk = null;
            } else {
                obj2 = null;
            }
        }
        if (obj2 != null) {
            this.oTk = iW(z);
            if (this.oTk == null) {
                this.oTo = false;
                return -1;
            }
        }
        try {
            Parameters parameters;
            Point point;
            Size size2;
            if (this.oTk != null) {
                this.oTk.getParameters();
            }
            this.oTo = true;
            Camera camera2 = this.oTk;
            int i4 = j.oVo.oTX;
            if (camera2 != null) {
                try {
                    parameters = camera2.getParameters();
                    if (l.xZ()) {
                        parameters.setPreviewFpsRange(i4 * 1000, i4 * 1000);
                    } else {
                        parameters.setPreviewFrameRate(i4);
                    }
                    camera2.setParameters(parameters);
                } catch (Exception e2) {
                    x.e("MicroMsg.Voip.CaptureRender", "SafeSetFps error:" + e2.toString());
                }
            }
            x.i("MicroMsg.Voip.CaptureRender", "Camera Open Success, try set size: w,h:" + i + "," + i2);
            if (z) {
                point = j.oVo.oUc;
            } else {
                point = j.oVo.oUd;
            }
            if (point != null) {
                obj = 1;
            } else {
                obj = null;
            }
            Size size3 = null;
            if (point != null) {
                Camera camera3 = this.oTk;
                camera3.getClass();
                Size size4 = new Size(camera3, point.x, point.y);
                x.i("MicroMsg.Voip.CaptureRender", "getCameraSize from table:" + size4.width + "," + size4.height);
                size = size4;
            } else {
                size = null;
            }
            try {
                CharSequence charSequence;
                Camera camera4 = this.oTk;
                parameters = camera4.getParameters();
                Point point2 = new Point(i, i2);
                String str = parameters.get("preview-size-values");
                if (str == null) {
                    charSequence = parameters.get("preview-size-value");
                } else {
                    Object charSequence2 = str;
                }
                Point point3 = null;
                if (charSequence2 != null) {
                    x.i("MicroMsg.Voip.CaptureRender", "preview-size-values parameter: " + charSequence2);
                    point3 = a(charSequence2, point2);
                }
                if (point3 == null) {
                    point3 = new Point((point2.x >> 3) << 3, (point2.y >> 3) << 3);
                }
                camera4.getClass();
                size2 = new Size(camera4, point3.x, point3.y);
                try {
                    x.i("MicroMsg.Voip.CaptureRender", "getCameraResolution:" + size2.width + "," + size2.height);
                } catch (Exception e3) {
                    e2 = e3;
                    size3 = size2;
                    x.e("MicroMsg.Voip.CaptureRender", "getCameraResolution failed: %s", new Object[]{e2.getMessage()});
                    size2 = size3;
                    if (obj != null) {
                        x.i("MicroMsg.Voip.CaptureRender", "2.no config size!");
                        if (size2 != null) {
                            x.i("MicroMsg.Voip.CaptureRender", "2.try support size alternatively! w" + size2.width + ",h" + size2.height);
                            if (!a(this.oTk, size2.width, size2.height)) {
                                x.e("MicroMsg.Voip.CaptureRender", "2.try support size fail: w" + size2.width + ",h" + size2.height);
                                return -1;
                            }
                        }
                    }
                    boolean a = a(this.oTk, size.width, size.height);
                    x.i("MicroMsg.Voip.CaptureRender", "1.try config size first! w" + size.width + ",h" + size.height);
                    if (!(a || size2 == null)) {
                        x.e("MicroMsg.Voip.CaptureRender", "1.try config size failed!,try support size: w" + size2.width + ",h" + size2.height);
                        if (!a(this.oTk, size2.width, size2.height)) {
                            x.e("MicroMsg.Voip.CaptureRender", "1.try support size fail: w" + size2.width + ",h" + size2.height);
                            return -1;
                        }
                    }
                    g(this.oTk);
                    this.oTl = this.oTk.getParameters();
                    this.oTm = this.oTl.getPreviewSize();
                    i4 = this.oTl.getPreviewFrameRate();
                    this.oTn = j.oVt;
                    if (this.oTn <= 0) {
                        this.oTn = 7;
                    }
                    try {
                        camera = this.oTk;
                        cameraInfo = new CameraInfo();
                        Camera.getCameraInfo(this.oTc ? j.oVq : j.oVp, cameraInfo);
                        i3 = 0;
                        switch (((WindowManager) ad.getContext().getSystemService("window")).getDefaultDisplay().getRotation()) {
                            case 0:
                                i3 = 0;
                                break;
                            case 1:
                                i3 = 90;
                                break;
                            case 2:
                                i3 = 180;
                                break;
                            case 3:
                                i3 = aw.CTRL_BYTE;
                                break;
                        }
                        i3 = this.oTc ? ((cameraInfo.orientation - i3) + 360) % 360 : (360 - ((i3 + cameraInfo.orientation) % 360)) % 360;
                        camera.setDisplayOrientation(i3);
                        this.oTA = i3;
                    } catch (Exception e22) {
                        x.e("MicroMsg.Voip.CaptureRender", "setDisplayOrientation failed: %s", new Object[]{e22.getMessage()});
                    }
                    x.i("MicroMsg.Voip.CaptureRender", "Camera ok, fps: %d, mSize.width: %d, mSize.height: %d, format: %d, IsRotate180: %d, displayOrientation: %d", new Object[]{Integer.valueOf(i4), Integer.valueOf(this.oTm.width), Integer.valueOf(this.oTm.height), Integer.valueOf(this.oTn), Integer.valueOf(j.oVr), Integer.valueOf(this.oTA)});
                    return 1;
                }
            } catch (Exception e4) {
                e22 = e4;
                x.e("MicroMsg.Voip.CaptureRender", "getCameraResolution failed: %s", new Object[]{e22.getMessage()});
                size2 = size3;
                if (obj != null) {
                    boolean a2 = a(this.oTk, size.width, size.height);
                    x.i("MicroMsg.Voip.CaptureRender", "1.try config size first! w" + size.width + ",h" + size.height);
                    if (!(a2 || size2 == null)) {
                        x.e("MicroMsg.Voip.CaptureRender", "1.try config size failed!,try support size: w" + size2.width + ",h" + size2.height);
                        if (!a(this.oTk, size2.width, size2.height)) {
                            x.e("MicroMsg.Voip.CaptureRender", "1.try support size fail: w" + size2.width + ",h" + size2.height);
                            return -1;
                        }
                    }
                }
                x.i("MicroMsg.Voip.CaptureRender", "2.no config size!");
                if (size2 != null) {
                    x.i("MicroMsg.Voip.CaptureRender", "2.try support size alternatively! w" + size2.width + ",h" + size2.height);
                    if (!a(this.oTk, size2.width, size2.height)) {
                        x.e("MicroMsg.Voip.CaptureRender", "2.try support size fail: w" + size2.width + ",h" + size2.height);
                        return -1;
                    }
                }
                g(this.oTk);
                this.oTl = this.oTk.getParameters();
                this.oTm = this.oTl.getPreviewSize();
                i4 = this.oTl.getPreviewFrameRate();
                this.oTn = j.oVt;
                if (this.oTn <= 0) {
                    this.oTn = 7;
                }
                camera = this.oTk;
                cameraInfo = new CameraInfo();
                if (this.oTc) {
                }
                Camera.getCameraInfo(this.oTc ? j.oVq : j.oVp, cameraInfo);
                i3 = 0;
                switch (((WindowManager) ad.getContext().getSystemService("window")).getDefaultDisplay().getRotation()) {
                    case 0:
                        i3 = 0;
                        break;
                    case 1:
                        i3 = 90;
                        break;
                    case 2:
                        i3 = 180;
                        break;
                    case 3:
                        i3 = aw.CTRL_BYTE;
                        break;
                }
                if (this.oTc) {
                }
                camera.setDisplayOrientation(i3);
                this.oTA = i3;
                x.i("MicroMsg.Voip.CaptureRender", "Camera ok, fps: %d, mSize.width: %d, mSize.height: %d, format: %d, IsRotate180: %d, displayOrientation: %d", new Object[]{Integer.valueOf(i4), Integer.valueOf(this.oTm.width), Integer.valueOf(this.oTm.height), Integer.valueOf(this.oTn), Integer.valueOf(j.oVr), Integer.valueOf(this.oTA)});
                return 1;
            }
            if (obj != null) {
                boolean a22 = a(this.oTk, size.width, size.height);
                x.i("MicroMsg.Voip.CaptureRender", "1.try config size first! w" + size.width + ",h" + size.height);
                if (!(a22 || size2 == null)) {
                    x.e("MicroMsg.Voip.CaptureRender", "1.try config size failed!,try support size: w" + size2.width + ",h" + size2.height);
                    if (!a(this.oTk, size2.width, size2.height)) {
                        x.e("MicroMsg.Voip.CaptureRender", "1.try support size fail: w" + size2.width + ",h" + size2.height);
                        return -1;
                    }
                }
            }
            x.i("MicroMsg.Voip.CaptureRender", "2.no config size!");
            if (size2 != null) {
                x.i("MicroMsg.Voip.CaptureRender", "2.try support size alternatively! w" + size2.width + ",h" + size2.height);
                if (!a(this.oTk, size2.width, size2.height)) {
                    x.e("MicroMsg.Voip.CaptureRender", "2.try support size fail: w" + size2.width + ",h" + size2.height);
                    return -1;
                }
            }
            g(this.oTk);
            try {
                this.oTl = this.oTk.getParameters();
                this.oTm = this.oTl.getPreviewSize();
                i4 = this.oTl.getPreviewFrameRate();
                this.oTn = j.oVt;
                if (this.oTn <= 0) {
                    this.oTn = 7;
                }
                camera = this.oTk;
                cameraInfo = new CameraInfo();
                if (this.oTc) {
                }
                Camera.getCameraInfo(this.oTc ? j.oVq : j.oVp, cameraInfo);
                i3 = 0;
                switch (((WindowManager) ad.getContext().getSystemService("window")).getDefaultDisplay().getRotation()) {
                    case 0:
                        i3 = 0;
                        break;
                    case 1:
                        i3 = 90;
                        break;
                    case 2:
                        i3 = 180;
                        break;
                    case 3:
                        i3 = aw.CTRL_BYTE;
                        break;
                }
                if (this.oTc) {
                }
                camera.setDisplayOrientation(i3);
                this.oTA = i3;
                x.i("MicroMsg.Voip.CaptureRender", "Camera ok, fps: %d, mSize.width: %d, mSize.height: %d, format: %d, IsRotate180: %d, displayOrientation: %d", new Object[]{Integer.valueOf(i4), Integer.valueOf(this.oTm.width), Integer.valueOf(this.oTm.height), Integer.valueOf(this.oTn), Integer.valueOf(j.oVr), Integer.valueOf(this.oTA)});
                return 1;
            } catch (Exception e222) {
                h.mEJ.a(159, 0, 1, false);
                x.e("MicroMsg.Voip.CaptureRender", "try getParameters and getPreviewSize fail, error:%s", new Object[]{e222.getMessage()});
                return -1;
            }
        } catch (Exception e2222) {
            h.mEJ.a(159, 0, 1, false);
            x.e("MicroMsg.Voip.CaptureRender", "Camera open failed, error:%s", new Object[]{e2222.getMessage()});
            if (this.oTt != null) {
                this.oTt.bgV();
            }
            return -1;
        }
    }

    public final void bLX() {
        if (j.oVo.dcI < 2) {
            x.e("MicroMsg.Voip.CaptureRender", "ExchangeCapture...gCameraNum= " + j.oVo.dcI);
            return;
        }
        x.i("MicroMsg.Voip.CaptureRender", "ExchangeCapture start, gCameraNum= " + j.oVo.dcI);
        bLZ();
        a(this.oTt, !this.oTc);
        bLY();
        i.bJI().yI(this.oTj);
        this.oTz = true;
    }

    public final int bLY() {
        if (!this.oTo) {
            x.e("MicroMsg.Voip.CaptureRender", "StartCapture: failed without open camera");
            this.oTj = 1;
            return -1;
        } else if (this.oTu) {
            x.e("MicroMsg.Voip.CaptureRender", "StartCapture: is in capture already ");
            return -1;
        } else if (this.oTr == null || this.oTr.bIT()) {
            x.d("MicroMsg.Voip.CaptureRender", "StartCapture now, isUesSurfacePreivew: %b", new Object[]{Boolean.valueOf(this.oTq)});
            if (this.oTr != null && this.oTq) {
                try {
                    this.oTk.setPreviewDisplay(this.oTr.getSurfaceHolder());
                } catch (Exception e) {
                    h.mEJ.a(159, 0, 1, false);
                    h.mEJ.a(159, 2, 1, false);
                    this.oTj = 1;
                    x.e("MicroMsg.Voip.CaptureRender", "StartCapture:error:" + e.toString());
                }
            } else if (!(this.oTs == null || this.oTq)) {
                try {
                    this.oTk.setPreviewTexture(this.oTs.getSurfaceTexture());
                } catch (Exception e2) {
                    h.mEJ.a(159, 0, 1, false);
                    h.mEJ.a(159, 2, 1, false);
                    this.oTj = 1;
                    x.e("MicroMsg.Voip.CaptureRender", "StartCapture:error:" + e2.toString());
                }
            }
            try {
                this.oTk.startPreview();
            } catch (Exception e22) {
                h.mEJ.a(159, 0, 1, false);
                h.mEJ.a(159, 2, 1, false);
                this.oTj = 1;
                if (this.oTt != null) {
                    this.oTt.bgV();
                }
                x.e("MicroMsg.Voip.CaptureRender", "startPreview:error" + e22.toString());
            }
            this.oTu = true;
            return 1;
        } else {
            x.d("MicroMsg.Voip.CaptureRender", "StartCapture:surface not ready, try later.... ");
            this.oTv = true;
            return 0;
        }
    }

    public final void bLZ() {
        x.d("MicroMsg.Voip.CaptureRender", "StopCapture....mIsInCapture = " + this.oTu);
        if (this.oTu) {
            this.oTv = false;
            this.oTk.setPreviewCallback(null);
            try {
                this.oTk.stopPreview();
            } catch (Exception e) {
                x.e("MicroMsg.Voip.CaptureRender", "stopPreview:error" + e.toString());
            }
            this.oTu = false;
        }
        if (1 == this.oTj) {
            lr lrVar = new lr();
            lrVar.bWf.type = 2;
            com.tencent.mm.sdk.b.a.sFg.m(lrVar);
        }
        x.d("MicroMsg.Voip.CaptureRender", "UnInitCapture....mCameraOpen = " + this.oTo);
        if (this.oTo) {
            this.oTj = 0;
            this.oTv = false;
            this.oTk.setPreviewCallback(null);
            this.oTk.release();
            this.oTk = null;
            this.oTo = false;
        } else if (this.oTk != null) {
            this.oTk.release();
            this.oTk = null;
            this.oTo = false;
        }
        this.oTw = null;
        if (this.oTy != null) {
            this.oTy.clear();
        }
        this.oTy = null;
        this.oTp = false;
    }

    public static void bMa() {
    }

    @TargetApi(14)
    public final void o(int[] iArr) {
        boolean z = true;
        if (q.deM.ddo != 1 || !this.oTp) {
            if (q.deM.ddn > 2000) {
                this.oTi = (long) q.deM.ddn;
            }
            boolean z2;
            boolean z3;
            if (iArr == null) {
                x.e("MicroMsg.Voip.CaptureRender", "focusOnFace error, faceLocation is null");
                z2 = System.currentTimeMillis() - this.oTh > this.oTi;
                if (!this.oTe || z2 || this.oTf != this.oTc) {
                    String str = "MicroMsg.Voip.CaptureRender";
                    StringBuilder stringBuilder = new StringBuilder("now i need autoFocus! and !mIsCameraNoParamAutoFocus: ");
                    if (this.oTe) {
                        z3 = false;
                    } else {
                        z3 = true;
                    }
                    StringBuilder append = stringBuilder.append(z3).append(",isAutoFocusTimeout: ").append(z2).append(",mAutoFocusTimeOut:").append(this.oTi).append(",mIsLastAutoFocusFaceCamera != mIsCurrentFaceCamera :");
                    if (this.oTf == this.oTc) {
                        z = false;
                    }
                    x.i(str, append.append(z).append(",isClickScreen :false").toString());
                    try {
                        if (this.oTk != null && this.oTk.getParameters() != null && this.oTk.getParameters().getFocusMode() != null && this.oTk.getParameters().getFocusMode().equals("auto")) {
                            this.oTk.autoFocus(null);
                            this.oTx = null;
                            this.oTh = System.currentTimeMillis();
                            this.oTe = true;
                            this.oTf = this.oTc;
                            return;
                        }
                        return;
                    } catch (Exception e) {
                        x.e("MicroMsg.Voip.CaptureRender", "mCamera.getParameters() or autoFocus fail!" + e.toString());
                        return;
                    }
                }
                return;
            }
            Rect rect;
            Parameters parameters;
            if (this.oTx == null) {
                this.oTx = iArr;
                z2 = true;
            } else {
                z2 = false;
            }
            int[] iArr2 = this.oTx;
            int abs = Math.abs(iArr2[3] - iArr[3]) + ((Math.abs(iArr2[0] - iArr[0]) + Math.abs(iArr2[1] - iArr[1])) + Math.abs(iArr2[2] - iArr[2]));
            x.d("MicroMsg.Voip.CaptureRender", "face location diff:%d", new Object[]{Integer.valueOf(abs)});
            if (abs > oTb || abs > oTa) {
                this.oTx = iArr;
                if (abs > oTb) {
                    z2 = true;
                }
                if (abs > oTa) {
                    z3 = true;
                    if (!z2 || z3) {
                        List arrayList;
                        rect = new Rect(this.oTx[0], this.oTx[1], this.oTx[2], this.oTx[3]);
                        parameters = this.oTk.getParameters();
                        if (z3) {
                            if (!d.fR(14) || parameters.getMaxNumMeteringAreas() <= 0) {
                                x.d("MicroMsg.Voip.CaptureRender", "camera not support metering area");
                                z3 = false;
                            } else {
                                arrayList = new ArrayList();
                                arrayList.add(new Area(rect, 1000));
                                parameters.setMeteringAreas(arrayList);
                            }
                        }
                        if (z2) {
                            if (!d.fR(14) || parameters.getMaxNumFocusAreas() <= 0) {
                                x.d("MicroMsg.Voip.CaptureRender", "camera not support area focus");
                                z2 = false;
                            } else {
                                arrayList = new ArrayList();
                                arrayList.add(new Area(rect, 1000));
                                parameters.setFocusAreas(arrayList);
                            }
                        }
                        if (z2 || r3) {
                            this.oTk.setParameters(parameters);
                        }
                        if (z2) {
                            x.d("MicroMsg.Voip.CaptureRender", "refocus, mIsFocusOnFace:%b", new Object[]{Boolean.valueOf(this.oTz)});
                            if (this.oTz) {
                                this.oTe = false;
                                this.oTz = false;
                                this.oTk.autoFocus(new 1(this));
                            }
                        }
                    }
                    return;
                }
            }
            z3 = false;
            if (z2) {
            }
            try {
                rect = new Rect(this.oTx[0], this.oTx[1], this.oTx[2], this.oTx[3]);
                parameters = this.oTk.getParameters();
                if (z3) {
                    if (!d.fR(14) || parameters.getMaxNumMeteringAreas() <= 0) {
                        x.d("MicroMsg.Voip.CaptureRender", "camera not support metering area");
                        z3 = false;
                    } else {
                        arrayList = new ArrayList();
                        arrayList.add(new Area(rect, 1000));
                        parameters.setMeteringAreas(arrayList);
                    }
                }
                if (z2) {
                    if (!d.fR(14) || parameters.getMaxNumFocusAreas() <= 0) {
                        x.d("MicroMsg.Voip.CaptureRender", "camera not support area focus");
                        z2 = false;
                    } else {
                        arrayList = new ArrayList();
                        arrayList.add(new Area(rect, 1000));
                        parameters.setFocusAreas(arrayList);
                    }
                }
                this.oTk.setParameters(parameters);
                if (z2) {
                    x.d("MicroMsg.Voip.CaptureRender", "refocus, mIsFocusOnFace:%b", new Object[]{Boolean.valueOf(this.oTz)});
                    if (this.oTz) {
                        this.oTe = false;
                        this.oTz = false;
                        this.oTk.autoFocus(new 1(this));
                    }
                }
            } catch (Exception e2) {
                x.e("MicroMsg.Voip.CaptureRender", "focusOnFace exception:%s", new Object[]{e2.getMessage()});
            }
        }
    }

    private int h(Camera camera) {
        Throwable e;
        int i;
        if (camera == null) {
            return 0;
        }
        try {
            int i2;
            List<Size> supportedPreviewSizes = camera.getParameters().getSupportedPreviewSizes();
            if (supportedPreviewSizes == null || supportedPreviewSizes.size() == 0) {
                i2 = 0;
            } else {
                int i3 = 0;
                for (Size size : supportedPreviewSizes) {
                    try {
                        x.d("MicroMsg.Voip.CaptureRender", "support Size:" + size.width + "," + size.height);
                        if (i3 == 0) {
                            this.oTB = size.width;
                            this.oTC = size.height;
                        }
                        i3++;
                    } catch (Throwable e2) {
                        e = e2;
                        i = i3;
                        x.printErrStackTrace("MicroMsg.Voip.CaptureRender", e, "", new Object[0]);
                        return i;
                    }
                }
                i2 = i3;
            }
            try {
                List<Integer> supportedPreviewFormats = camera.getParameters().getSupportedPreviewFormats();
                if (!(supportedPreviewFormats == null || supportedPreviewFormats.size() == 0)) {
                    for (Integer intValue : supportedPreviewFormats) {
                        x.i("MicroMsg.Voip.CaptureRender", "support Format:" + intValue.intValue());
                    }
                }
                return i2;
            } catch (Exception e3) {
                e = e3;
                i = i2;
                x.printErrStackTrace("MicroMsg.Voip.CaptureRender", e, "", new Object[0]);
                return i;
            }
        } catch (Throwable e22) {
            e = e22;
            i = 0;
            x.printErrStackTrace("MicroMsg.Voip.CaptureRender", e, "", new Object[0]);
            return i;
        }
    }

    private static void i(Camera camera) {
        List supportedPreviewFrameRates;
        List list = null;
        try {
            supportedPreviewFrameRates = camera.getParameters().getSupportedPreviewFrameRates();
        } catch (Exception e) {
            x.d("MicroMsg.Voip.CaptureRender", "getSupportedPreviewFrameRates:error:" + e.toString());
            supportedPreviewFrameRates = list;
        }
        String str = "supportFps:";
        if (supportedPreviewFrameRates != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= supportedPreviewFrameRates.size()) {
                    break;
                }
                str = str + ((Integer) supportedPreviewFrameRates.get(i2)).intValue() + ",";
                i = i2 + 1;
            }
        }
        x.i("MicroMsg.Voip.CaptureRender", str);
    }

    public final boolean bMb() {
        return this.oTc;
    }

    public final boolean bMc() {
        return this.oTd;
    }

    public final int bMd() {
        return this.oTj;
    }

    public final void bMe() {
        try {
            if (this.oTl != null) {
                Size previewSize = this.oTl.getPreviewSize();
                c bMx = com.tencent.mm.plugin.voip_cs.b.b.bMx();
                int i = this.oTo ? 1 : 0;
                this.oTl.getPreviewFrameRate();
                int i2 = this.oTB;
                int i3 = this.oTC;
                int i4 = previewSize.width;
                int i5 = previewSize.height;
                x.d("MicroMsg.VoipCSReportHelper", "setCameraInfo");
                bMx.oWC = i;
                bMx.oWy = i2;
                bMx.oWz = i3;
                bMx.oWA = i4;
                bMx.oWB = i5;
            }
        } catch (Exception e) {
            x.e("MicroMsg.Voip.CaptureRender", "getCameraDataForVoipCS failed" + e.getMessage());
        }
    }
}
