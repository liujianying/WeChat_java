package com.tencent.mm.plugin.mmsight.model;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.ImageFormat;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.SurfaceTexture;
import android.hardware.Camera;
import android.hardware.Camera.Area;
import android.hardware.Camera.AutoFocusCallback;
import android.hardware.Camera.CameraInfo;
import android.hardware.Camera.Parameters;
import android.hardware.Camera.Size;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Build;
import android.os.Looper;
import com.tencent.mm.compatible.e.d$a$a;
import com.tencent.mm.compatible.e.q;
import com.tencent.mm.compatible.util.g;
import com.tencent.mm.g.a.lr;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.plugin.mmsight.d;
import com.tencent.mm.plugin.mmsight.model.a.j;
import com.tencent.mm.plugin.mmsight.model.a.k;
import com.tencent.mm.plugin.mmsight.model.g.b;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.ak;
import com.tencent.mm.ui.widget.a.c;
import com.tencent.rtmp.TXLiveConstants;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public final class e implements SensorEventListener {
    static boolean lfY = true;
    private static int lfw = Integer.MAX_VALUE;
    private boolean ZU = false;
    private SensorManager bgR;
    public Camera ddt = null;
    private float lfA = 0.0f;
    private float lfB = 0.0f;
    private Point lfC = null;
    public Point lfD = null;
    private Point lfE = null;
    private int lfF = 0;
    private byte[] lfG;
    private boolean lfH = false;
    private com.tencent.mm.plugin.base.model.a lfI = new com.tencent.mm.plugin.base.model.a();
    public boolean lfJ = false;
    private List<f> lfK = new ArrayList();
    private boolean lfL = false;
    private a lfM = a.Preview;
    private b lfN = new b("prevcameraCallback");
    private b lfO = new b("cameraCallback");
    private b lfP = new b("cameraPreviewCallback");
    private b lfQ = new b("cameraCropCallback");
    private b lfR = new b("mirrorCameraCallback");
    private b lfS = new b("finishCallbackTimeCallback");
    private VideoTransPara lfT;
    public volatile byte[] lfU = null;
    public volatile boolean lfV = false;
    public boolean lfW = false;
    private boolean lfX = false;
    AutoFocusCallback lfZ = new 2(this);
    private int lfq = -1;
    public int lfr = -1;
    private p lfs = p.bec();
    private boolean lft = false;
    public boolean lfu = false;
    private int lfv = 0;
    d$a$a lfx;
    private Sensor lfy;
    private float lfz = 0.0f;
    public c lga = new c(this, Looper.getMainLooper());
    public boolean lgb = true;
    private Context mContext = null;
    private int scene = 0;

    public enum a {
        Preview,
        Recording,
        Stoping
    }

    public e(VideoTransPara videoTransPara, int i) {
        this.lfT = videoTransPara;
        this.scene = i;
    }

    public final void a(f fVar) {
        if (fVar != null) {
            this.lfK.add(fVar);
        }
    }

    public final void b(f fVar) {
        if (fVar != null) {
            this.lfK.remove(fVar);
        }
    }

    public final void a(a aVar) {
        this.lfM = aVar;
        if (aVar == a.Stoping) {
            a bdH = a.bdH();
            String bdJ = this.lfO.bdJ();
            String bdJ2 = this.lfN.bdJ();
            com.tencent.mm.plugin.base.model.a aVar2 = this.lfI;
            int i = aVar2.hdr == 0 ? 0 : aVar2.hdq / aVar2.hdr;
            bdH.leW = (int) (bi.WW(bdJ) * 10.0d);
            bdH.leX = (int) (bi.WW(bdJ2) * 10.0d);
            bdH.lfd = i;
        }
    }

    public final void bdL() {
        if (!(this.bgR == null || this.lfy == null)) {
            this.bgR.unregisterListener(this);
        }
        x.i("MicroMsg.MMSightCamera", this.lfN.getValue());
        x.i("MicroMsg.MMSightCamera", this.lfO.getValue());
        x.i("MicroMsg.MMSightCamera", this.lfP.getValue());
        x.i("MicroMsg.MMSightCamera", this.lfQ.getValue());
        x.i("MicroMsg.MMSightCamera", this.lfR.getValue());
        x.i("MicroMsg.MMSightCamera", this.lfS.getValue());
        if (this.ddt != null) {
            long VG = bi.VG();
            x.i("MicroMsg.MMSightCamera", "release camera beg, %s", new Object[]{Looper.myLooper()});
            this.lga.removeCallbacksAndMessages(null);
            this.lga.lgj = true;
            this.ddt.setPreviewCallback(null);
            this.ddt.stopPreview();
            this.ddt.release();
            this.ddt = null;
            this.lfu = false;
            x.i("MicroMsg.MMSightCamera", "release camera end, use %dms, %s", new Object[]{Long.valueOf(bi.bI(VG)), Looper.myLooper()});
        }
        this.lft = false;
        this.lfz = 0.0f;
        this.lfA = 0.0f;
        this.lfB = 0.0f;
        lfY = true;
        this.mContext = null;
        this.lfX = false;
        this.lfD = null;
        this.lfE = null;
        this.lfU = null;
        this.lfL = false;
    }

    private boolean a(Camera camera, boolean z) {
        if (camera == null) {
            return false;
        }
        try {
            a bdH;
            boolean z2;
            int i;
            Parameters parameters = camera.getParameters();
            Point dO = d.dO(this.mContext);
            List supportedPreviewSizes;
            List supportedPictureSizes;
            int i2;
            if (this.lgb) {
                bdH = a.bdH();
                supportedPreviewSizes = parameters.getSupportedPreviewSizes();
                supportedPictureSizes = parameters.getSupportedPictureSizes();
                i2 = this.lfx.bYE;
                if (bi.oW(bdH.leM)) {
                    bdH.leM = d.bz(supportedPreviewSizes);
                }
                if (bi.oW(bdH.leN)) {
                    bdH.leN = d.bz(supportedPictureSizes);
                }
                bdH.bYE = i2;
                bdH.lfi = 1;
            } else {
                bdH = a.bdH();
                supportedPreviewSizes = parameters.getSupportedPreviewSizes();
                supportedPictureSizes = parameters.getSupportedPictureSizes();
                i2 = this.lfx.bYE;
                if (bi.oW(bdH.leO)) {
                    bdH.leO = d.bz(supportedPreviewSizes);
                }
                if (bi.oW(bdH.leP)) {
                    bdH.leP = d.bz(supportedPictureSizes);
                }
                bdH.bYE = i2;
                bdH.lfi = 2;
            }
            if (z) {
                z2 = this.lfx.bYE == 90 || this.lfx.bYE == TXLiveConstants.RENDER_ROTATION_LANDSCAPE;
                j.a(parameters, z2);
            }
            k.bey();
            int beA = k.beA();
            z2 = this.lfx.bYE == 90 || this.lfx.bYE == TXLiveConstants.RENDER_ROTATION_LANDSCAPE;
            b a = g.a(parameters, dO, beA, z2);
            j.a(a);
            Point point = a.lgn;
            if (point == null) {
                h.mEJ.a(440, 140, 0, false);
            }
            if (point != null) {
                this.lfs.iSp = point.x;
                this.lfs.iSq = point.y;
                this.lfD = point;
            }
            Context context = this.mContext;
            z2 = this.lfx.bYE == 90 || this.lfx.bYE == TXLiveConstants.RENDER_ROTATION_LANDSCAPE;
            boolean a2 = d.a(context, point, z2);
            x.i("MicroMsg.MMSightCameraSetting", "checkIfNeedUsePreviewLarge, needCrop: %s", new Object[]{Boolean.valueOf(a2)});
            if (a2) {
                if (j.lgz.dfb == 2) {
                    this.lfE = a.lgp;
                    if (this.lfE.x < point.x || this.lfE.y < point.y) {
                        if (this.lfx.bYE == 90 || this.lfx.bYE == TXLiveConstants.RENDER_ROTATION_LANDSCAPE) {
                            this.lfE.y = d.sN(this.lfE.y);
                        } else {
                            this.lfE.x = d.sN(this.lfE.x);
                        }
                    }
                } else {
                    this.lfE = a.lgo;
                }
                this.lfD = new Point(this.lfE.x, this.lfE.y);
                this.lfF = ((this.lfE.x * this.lfE.y) * 3) / 2;
                x.i("MicroMsg.MMSightCameraSetting", "cropSize: %s", new Object[]{this.lfE});
            }
            if (j.lgz.lgK) {
                Object obj = 1;
                if (this.lfx.bYE == 90 || this.lfx.bYE == TXLiveConstants.RENDER_ROTATION_LANDSCAPE) {
                    if (point.y < this.lfT.width || point.x < this.lfT.height) {
                        obj = null;
                        x.w("MicroMsg.MMSightCamera", "previewSize %s not support", new Object[]{point});
                    }
                    if (obj != null) {
                        if (j.lgz.lfa == 1080) {
                            this.lfD = new Point(d.cP(this.lfE == null ? point.x / 2 : this.lfE.x / 2, this.lfE == null ? point.x : this.lfE.x), d.cP(this.lfE == null ? point.y / 2 : this.lfE.y / 2, this.lfE == null ? point.y : this.lfE.y));
                        } else if (j.lgz.lfa == 720) {
                            this.lfD = new Point(d.cP((int) (this.lfE == null ? ((float) point.x) * 0.75f : ((float) this.lfE.x) * 0.75f), this.lfE == null ? point.x : this.lfE.x), d.cP((int) (this.lfE == null ? ((float) point.y) * 0.75f : ((float) this.lfE.y) * 0.75f), this.lfE == null ? point.y : this.lfE.y));
                        }
                    }
                } else {
                    if (point.x < this.lfT.width || point.y < this.lfT.height) {
                        obj = null;
                        x.w("MicroMsg.MMSightCamera", "previewSize %s not support", new Object[]{point});
                    }
                    if (obj != null) {
                        if (j.lgz.lfa == 1080) {
                            this.lfD = new Point(d.cP(this.lfE == null ? point.y / 2 : this.lfE.y / 2, this.lfE == null ? point.y : this.lfE.y), d.cP(this.lfE == null ? point.x / 2 : this.lfE.x / 2, this.lfE == null ? point.x : this.lfE.x));
                        } else if (j.lgz.lfa == 720) {
                            beA = (int) (this.lfE == null ? ((float) point.x) * 0.75f : ((float) this.lfE.x) * 0.75f);
                            int cP = d.cP((int) (this.lfE == null ? ((float) point.y) * 0.75f : ((float) this.lfE.y) * 0.75f), this.lfE == null ? point.y : this.lfE.y);
                            if (this.lfE == null) {
                                i = point.x;
                            } else {
                                i = this.lfE.x;
                            }
                            this.lfD = new Point(cP, d.cP(beA, i));
                        }
                    }
                }
            }
            bdH = a.bdH();
            dO = this.lfE;
            Point point2 = this.lfD;
            bdH.leV = -1;
            bdH.leU = -1;
            bdH.leR = -1;
            bdH.leQ = -1;
            bdH.leT = -1;
            bdH.leS = -1;
            if (point != null) {
                bdH.leS = point.x;
                bdH.leT = point.y;
            }
            if (dO != null) {
                bdH.leQ = dO.x;
                bdH.leR = dO.y;
            }
            if (point2 != null) {
                bdH.leU = point2.x;
                bdH.leV = point2.y;
            }
            if (z) {
                if (a2 || j.lgz.dfb != 2 || d.sL(this.lfD.y)) {
                    j.f(this.lfD);
                } else {
                    i = d.sM(this.lfD.y);
                    if (Math.abs(i - this.lfD.y) <= 16) {
                        x.i("MicroMsg.MMSightCamera", "padding 16 for encode video best size: %s, alignY: %s", new Object[]{this.lfD, Integer.valueOf(i)});
                        this.lfC = new Point(this.lfD.x, this.lfD.y);
                        this.lfD.y = i;
                        this.lfH = true;
                        this.lfG = new byte[(((this.lfD.x * this.lfD.y) * 3) / 2)];
                    } else {
                        j.f(this.lfD);
                    }
                }
            } else if (!a2 && j.lgz.dfb == 2 && !d.sL(this.lfD.y) && this.lfH && this.lfG != null && this.lfC.y == this.lfD.y) {
                i = d.sM(this.lfD.y);
                if (this.lfG.length == ((this.lfD.x * i) * 3) / 2) {
                    this.lfD.y = i;
                }
            }
            x.i("MicroMsg.MMSightCameraSetting", "final set camera preview size: %s, encodeVideoBestSize: %s, cropSize: %s", new Object[]{point, this.lfD, this.lfE});
            parameters.setPreviewSize(this.lfs.iSp, this.lfs.iSq);
            camera.setParameters(parameters);
            return true;
        } catch (Exception e) {
            x.i("MicroMsg.MMSightCameraSetting", "setPreviewSize Exception, %s, %s", new Object[]{Looper.myLooper(), e.getMessage()});
            return false;
        }
    }

    private boolean a(Camera camera, int i, float f, boolean z) {
        if (camera == null || i <= 0) {
            return false;
        }
        try {
            int i2;
            Parameters parameters = camera.getParameters();
            Point point = new Point(i, (int) (((float) i) / f));
            Point gu = ak.gu(ad.getContext());
            float min = ((float) Math.min(gu.x, gu.y)) / ((float) Math.max(gu.x, gu.y));
            float f2 = 1.0f / f;
            if (f < 1.0f) {
                i2 = i;
            } else {
                i2 = Math.round(((float) i) / f2);
            }
            x.i("MicroMsg.MMSightCamera", "safeSetPreviewSizeWithLimitAndRatio, shortSize: %s, displayRatio: %s, screenRatio: %s", new Object[]{Integer.valueOf(i2), Float.valueOf(f), Float.valueOf(min)});
            boolean z2 = this.lfx.bYE == 90 || this.lfx.bYE == TXLiveConstants.RENDER_ROTATION_LANDSCAPE;
            b a = g.a(parameters, gu, i2, z2);
            if (a == null || a.lgn == null) {
                x.e("MicroMsg.MMSightCamera", "fuck, preview size still null!!");
                z2 = this.lfx.bYE == 90 || this.lfx.bYE == TXLiveConstants.RENDER_ROTATION_LANDSCAPE;
                a = g.b(parameters, gu, i, z2);
                this.lfW = false;
            }
            if (!(a == null || a.lgn == null)) {
                x.i("MicroMsg.MMSightCamera", "safeSetPreviewSizeWithLimitAndRatio result preview size: %s, cropHeight: %s", new Object[]{a.lgn, Integer.valueOf((int) (((float) a.lgn.x) * f))});
                if (((int) (((float) a.lgn.x) * f)) <= a.lgn.y) {
                    this.lfW = false;
                } else {
                    this.lfW = true;
                }
            }
            if (!(a == null || a.lgn == null)) {
                point = a.lgn;
                this.lfs.iSp = point.x;
                this.lfs.iSq = point.y;
                this.lfD = point;
                this.lfE = null;
                if (!z) {
                    if (j.lgz.dfb != 2 || d.sL(this.lfD.y)) {
                        j.f(this.lfD);
                    } else {
                        i2 = d.sM(this.lfD.y);
                        if (Math.abs(i2 - this.lfD.y) <= 16) {
                            x.i("MicroMsg.MMSightCamera", "padding 16 for encode video best size: %s, alignY: %s", new Object[]{this.lfD, Integer.valueOf(i2)});
                            this.lfC = new Point(this.lfD.x, this.lfD.y);
                            this.lfD.y = i2;
                            this.lfH = true;
                            this.lfG = new byte[(((this.lfD.x * this.lfD.y) * 3) / 2)];
                        } else {
                            j.f(this.lfD);
                        }
                    }
                }
                x.i("MicroMsg.MMSightCameraSetting", "final set camera preview size: %s, encodeVideoBestSize: %s, cropSize: %s, cropWidth: %s", new Object[]{point, this.lfD, this.lfE, Boolean.valueOf(this.lfW)});
                parameters.setPreviewSize(this.lfs.iSp, this.lfs.iSq);
                camera.setParameters(parameters);
                return true;
            }
        } catch (Exception e) {
            x.e("MicroMsg.MMSightCamera", "safeSetPreviewSizeWithLimit error: %s", new Object[]{e.getMessage()});
        }
        return false;
    }

    @TargetApi(14)
    private static boolean a(Camera camera) {
        if (camera == null) {
            return false;
        }
        try {
            x.i("MicroMsg.MMSightCameraSetting", "safeSetMetering");
            Parameters parameters = camera.getParameters();
            if (parameters.getMaxNumMeteringAreas() > 0) {
                List arrayList = new ArrayList();
                arrayList.add(new Area(new Rect(-1000, -1000, 1000, 1000), 600));
                parameters.setMeteringAreas(arrayList);
            }
            camera.setParameters(parameters);
            return true;
        } catch (Exception e) {
            x.i("MicroMsg.MMSightCameraSetting", "safeSetMetering Exception, %s, %s", new Object[]{Looper.myLooper(), e.getMessage()});
            return false;
        }
    }

    private static boolean b(Camera camera, boolean z) {
        if (camera == null) {
            return false;
        }
        try {
            Parameters parameters = camera.getParameters();
            int i;
            if (z) {
                if (q.deM.dcY > 0) {
                    x.i("MicroMsg.MMSightCameraSetting", "set frame rate > 0, do not try set preview frame rate");
                } else if (parameters == null) {
                    x.e("MicroMsg.MMSightCamera", "trySetPreviewFrameRateParameters error, p is null!");
                } else {
                    try {
                        Collection supportedPreviewFrameRates = parameters.getSupportedPreviewFrameRates();
                        if (supportedPreviewFrameRates != null && supportedPreviewFrameRates.size() > 0) {
                            parameters.setPreviewFrameRate(Math.min(30, ((Integer) Collections.max(supportedPreviewFrameRates)).intValue()));
                            x.i("MicroMsg.MMSightCameraSetting", "set preview frame rate %d", new Object[]{Integer.valueOf(i)});
                        }
                    } catch (Exception e) {
                        x.i("MicroMsg.MMSightCameraSetting", "trySetPreviewFrameRateParameters Exception, %s, %s", new Object[]{Looper.myLooper(), e.getMessage()});
                    }
                }
            } else if (q.deM.dcY > 0) {
                x.i("MicroMsg.MMSightCameraSetting", "set frame rate > 0, do not try set preview fps range");
            } else {
                List supportedPreviewFpsRange = parameters.getSupportedPreviewFpsRange();
                if (!(supportedPreviewFpsRange == null || supportedPreviewFpsRange.size() == 0)) {
                    int i2 = Integer.MIN_VALUE;
                    int i3 = Integer.MIN_VALUE;
                    Object obj = null;
                    int size = supportedPreviewFpsRange.size();
                    int i4 = 0;
                    while (i4 < size) {
                        Object obj2;
                        int[] iArr = (int[]) supportedPreviewFpsRange.get(i4);
                        if (iArr != null && iArr.length > 1) {
                            int i5 = iArr[0];
                            i = iArr[1];
                            x.i("MicroMsg.MMSightCamera", "dkfps %d:[%d %d]", new Object[]{Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i)});
                            if (i5 >= 0 && i >= i5) {
                                if (i >= i3 && obj == null) {
                                    i3 = i;
                                    i2 = i5;
                                }
                                if (i >= 30000) {
                                    obj2 = 1;
                                    i4++;
                                    obj = obj2;
                                }
                            }
                        }
                        obj2 = obj;
                        i4++;
                        obj = obj2;
                    }
                    x.i("MicroMsg.MMSightCameraSetting", "dkfps get fit  [%d %d], max target fps %d", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(30)});
                    if (!(i2 == Integer.MAX_VALUE || i3 == Integer.MAX_VALUE)) {
                        try {
                            parameters.setPreviewFpsRange(i2, i3);
                            x.i("MicroMsg.MMSightCameraSetting", "set fps range %d %d", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3)});
                        } catch (Exception e2) {
                            x.i("MicroMsg.MMSightCameraSetting", "trySetPreviewFpsRangeParameters Exception, %s, %s", new Object[]{Looper.myLooper(), e2.getMessage()});
                        }
                    }
                }
            }
            List supportedPreviewFrameRates2 = parameters.getSupportedPreviewFrameRates();
            x.i("MicroMsg.MMSightCameraSetting", "use fix mode %B, supported preview frame rates %s", new Object[]{Boolean.valueOf(z), supportedPreviewFrameRates2});
            camera.setParameters(parameters);
            return true;
        } catch (Exception e22) {
            x.i("MicroMsg.MMSightCameraSetting", "setPreviewFrameRate Exception, %s, %s", new Object[]{Looper.myLooper(), e22.getMessage()});
            return false;
        }
    }

    private static boolean b(Camera camera) {
        if (camera == null) {
            return false;
        }
        try {
            x.i("MicroMsg.MMSightCameraSetting", "safeSetPreviewFormat");
            Parameters parameters = camera.getParameters();
            List supportedPreviewFormats = parameters.getSupportedPreviewFormats();
            if (supportedPreviewFormats == null || !supportedPreviewFormats.contains(Integer.valueOf(17))) {
                x.e("MicroMsg.MMSightCameraSetting", "not support YCbCr_420_SP");
            }
            parameters.setPreviewFormat(17);
            camera.setParameters(parameters);
            return true;
        } catch (Exception e) {
            x.i("MicroMsg.MMSightCameraSetting", "setPreviewFormat Exception, %s, %s", new Object[]{Looper.myLooper(), e.getMessage()});
            return false;
        }
    }

    private static boolean c(Camera camera) {
        if (camera == null) {
            return false;
        }
        try {
            Parameters parameters = camera.getParameters();
            List supportedFocusModes = parameters.getSupportedFocusModes();
            if (supportedFocusModes != null && supportedFocusModes.contains("continuous-picture")) {
                x.i("MicroMsg.MMSightCameraSetting", "support continuous picture");
                parameters.setFocusMode("continuous-picture");
            } else if (supportedFocusModes == null || !supportedFocusModes.contains("continuous-video")) {
                if (supportedFocusModes != null) {
                    if (supportedFocusModes.contains("auto")) {
                        x.i("MicroMsg.MMSightCameraSetting", "support auto focus");
                        parameters.setFocusMode("auto");
                    }
                }
                x.i("MicroMsg.MMSightCameraSetting", "not support continuous video or auto focus");
            } else {
                x.i("MicroMsg.MMSightCameraSetting", "support continuous video");
                parameters.setFocusMode("continuous-video");
            }
            camera.setParameters(parameters);
            return true;
        } catch (Exception e) {
            x.i("MicroMsg.MMSightCameraSetting", "setFocusMode Exception, %s, %s", new Object[]{Looper.myLooper(), e.getMessage()});
            return false;
        }
    }

    public final void bdM() {
        x.i("MicroMsg.MMSightCamera", "switchToPictureFocusMode");
        if (this.ddt != null && this.lfu) {
            try {
                Parameters parameters = this.ddt.getParameters();
                List supportedFocusModes = parameters.getSupportedFocusModes();
                if (supportedFocusModes != null && supportedFocusModes.contains("continuous-picture")) {
                    x.i("MicroMsg.MMSightCameraSetting", "support continuous picture");
                    parameters.setFocusMode("continuous-picture");
                }
                this.ddt.setParameters(parameters);
            } catch (Exception e) {
                x.i("MicroMsg.MMSightCamera", "switchToPictureFocusMode error: %s", new Object[]{e.getMessage()});
            }
        }
    }

    private void bdN() {
        if (this.ddt != null) {
            try {
                Parameters parameters = this.ddt.getParameters();
                x.i("MicroMsg.MMSightCamera", "setPreviewCallbackImpl");
                int bitsPerPixel = (ImageFormat.getBitsPerPixel(parameters.getPreviewFormat()) * (this.lfs.iSp * this.lfs.iSq)) / 8;
                for (int i = 0; i < 5; i++) {
                    this.ddt.addCallbackBuffer(j.lin.i(Integer.valueOf(bitsPerPixel)));
                }
                this.lfN.reset();
                this.lfO.reset();
                this.lfP.reset();
                this.lfQ.reset();
                this.lfR.reset();
                this.lfS.reset();
                this.lfI = new com.tencent.mm.plugin.base.model.a();
                this.ddt.setPreviewCallbackWithBuffer(new 1(this));
            } catch (Exception e) {
                x.e("MicroMsg.MMSightCamera", "setPreviewCallbackImpl error: %s", new Object[]{e.getMessage()});
            }
        }
    }

    @TargetApi(11)
    public final int a(SurfaceTexture surfaceTexture, boolean z) {
        long VG = bi.VG();
        this.lfL = false;
        x.i("MicroMsg.MMSightCamera", "start preview, previewing %B, %s %s autoConfig %s", new Object[]{Boolean.valueOf(this.lfu), Looper.myLooper(), surfaceTexture, Boolean.valueOf(z)});
        if (this.lfu) {
            return 0;
        }
        if (surfaceTexture == null) {
            return 0 - g.getLine();
        }
        x.i("MicroMsg.MMSightCamera", "this texture %s", new Object[]{surfaceTexture});
        try {
            Integer valueOf;
            boolean z2;
            a(this.ddt, z);
            Integer valueOf2 = Integer.valueOf(0);
            if (k.bey().lip != null) {
                valueOf = Integer.valueOf(k.bey().lip.lev);
            } else {
                valueOf = valueOf2;
            }
            String str = "MicroMsg.MMSightCamera";
            String str2 = "startPreview Texture:: sightTest %s, config list: setFPS[%s], setYUV420SP[%B], useMetering[%B], useContinueFocus[%B] mUseContinueVideoFocusMode[%B]";
            Object[] objArr = new Object[6];
            objArr[0] = valueOf;
            String str3 = q.deM.ddd == 1 ? "Range" : q.deM.ddc == 1 ? "Fix" : "Error";
            objArr[1] = str3;
            objArr[2] = Boolean.valueOf(q.deM.dde == 1);
            if (q.deM.ddf == 1) {
                z2 = true;
            } else {
                z2 = false;
            }
            objArr[3] = Boolean.valueOf(z2);
            if (q.deM.ddg == 1) {
                z2 = true;
            } else {
                z2 = false;
            }
            objArr[4] = Boolean.valueOf(z2);
            if (q.deM.ddh == 1) {
                z2 = true;
            } else {
                z2 = false;
            }
            objArr[5] = Boolean.valueOf(z2);
            x.i(str, str2, objArr);
            if (q.deM.ddd == 1 && (valueOf.intValue() == 0 || valueOf.intValue() == 1)) {
                b(this.ddt, false);
            } else if (q.deM.ddc == 1 && (valueOf.intValue() == 0 || valueOf.intValue() == 5)) {
                b(this.ddt, true);
            }
            if (q.deM.dde == 1 && (valueOf.intValue() == 0 || valueOf.intValue() == 2)) {
                b(this.ddt);
            }
            if (q.deT.dfj != -1 && q.deT.dfj == 1 && com.tencent.mm.compatible.util.d.fT(14)) {
                a(this.ddt);
            }
            if (q.deM.ddg == 1 && (valueOf.intValue() == 0 || valueOf.intValue() == 4)) {
                c(this.ddt);
            }
            if (q.deM.ddh == 1 && valueOf.intValue() != 0) {
                valueOf.intValue();
            }
            d(this.ddt);
            bdN();
            this.ddt.setPreviewTexture(surfaceTexture);
            this.ddt.startPreview();
            if (!j.lgz.lgL) {
                this.bgR.registerListener(this, this.lfy, 2);
            } else if (!(q.deM.ddg != 0 || this.bgR == null || this.lfy == null)) {
                this.bgR.registerListener(this, this.lfy, 2);
            }
            this.lfu = true;
            x.i("MicroMsg.MMSightCamera", "start preview end, use %dms %s", new Object[]{Long.valueOf(bi.bI(VG)), Looper.myLooper()});
            return 0;
        } catch (Exception e) {
            x.e("MicroMsg.MMSightCamera", "start preview FAILED, %s, %s", new Object[]{Looper.myLooper(), e.getMessage()});
            return 0 - g.getLine();
        }
    }

    public final int a(SurfaceTexture surfaceTexture, int i, float f, boolean z) {
        long VG = bi.VG();
        this.lfL = false;
        x.i("MicroMsg.MMSightCamera", "start preview, previewing %B, %s %s", new Object[]{Boolean.valueOf(this.lfu), Looper.myLooper(), surfaceTexture});
        if (this.lfu) {
            return 0;
        }
        if (surfaceTexture == null) {
            return 0 - g.getLine();
        }
        x.i("MicroMsg.MMSightCamera", "this texture %s", new Object[]{surfaceTexture});
        try {
            Integer valueOf;
            a(this.ddt, i, f, z);
            Integer valueOf2 = Integer.valueOf(0);
            if (k.bey().lip != null) {
                valueOf = Integer.valueOf(k.bey().lip.lev);
            } else {
                valueOf = valueOf2;
            }
            String str = "MicroMsg.MMSightCamera";
            String str2 = "startPreview Texture:: sightTest %s, config list: setFPS[%s], setYUV420SP[%B], useMetering[%B], useContinueFocus[%B] mUseContinueVideoFocusMode[%B]";
            Object[] objArr = new Object[6];
            objArr[0] = valueOf;
            String str3 = q.deM.ddd == 1 ? "Range" : q.deM.ddc == 1 ? "Fix" : "Error";
            objArr[1] = str3;
            objArr[2] = Boolean.valueOf(q.deM.dde == 1);
            objArr[3] = Boolean.valueOf(q.deM.ddf == 1);
            objArr[4] = Boolean.valueOf(q.deM.ddg == 1);
            objArr[5] = Boolean.valueOf(q.deM.ddh == 1);
            x.i(str, str2, objArr);
            if (q.deM.ddd == 1 && (valueOf.intValue() == 0 || valueOf.intValue() == 1)) {
                b(this.ddt, false);
            } else if (q.deM.ddc == 1 && (valueOf.intValue() == 0 || valueOf.intValue() == 5)) {
                b(this.ddt, true);
            }
            if (q.deM.dde == 1 && (valueOf.intValue() == 0 || valueOf.intValue() == 2)) {
                b(this.ddt);
            }
            if (q.deT.dfj != -1 && q.deT.dfj == 1 && com.tencent.mm.compatible.util.d.fT(14)) {
                a(this.ddt);
            }
            if (q.deM.ddg == 1 && (valueOf.intValue() == 0 || valueOf.intValue() == 4)) {
                c(this.ddt);
            }
            if (q.deM.ddh == 1 && valueOf.intValue() != 0) {
                valueOf.intValue();
            }
            d(this.ddt);
            bdN();
            this.ddt.setPreviewTexture(surfaceTexture);
            this.ddt.startPreview();
            if (!j.lgz.lgL) {
                this.bgR.registerListener(this, this.lfy, 2);
            } else if (!(q.deM.ddg != 0 || this.bgR == null || this.lfy == null)) {
                this.bgR.registerListener(this, this.lfy, 2);
            }
            this.lfu = true;
            x.i("MicroMsg.MMSightCamera", "start preview end, use %dms %s", new Object[]{Long.valueOf(bi.bI(VG)), Looper.myLooper()});
            return 0;
        } catch (Exception e) {
            x.e("MicroMsg.MMSightCamera", "start preview FAILED, %s, %s", new Object[]{Looper.myLooper(), e.getMessage()});
            return 0 - g.getLine();
        }
    }

    private static void d(Camera camera) {
        try {
            Parameters parameters = camera.getParameters();
            if (parameters.isZoomSupported()) {
                parameters.setZoom(0);
            }
            camera.setParameters(parameters);
        } catch (Exception e) {
            x.e("MicroMsg.MMSightCamera", "safeResetZoom error: %s", new Object[]{e.getMessage()});
        }
    }

    private void bdO() {
        if (true != this.lfX && this.mContext != null) {
            if (!Build.MANUFACTURER.equalsIgnoreCase("meizu") || com.tencent.mm.compatible.f.b.zV()) {
                lr lrVar = new lr();
                lrVar.bWf.type = 2;
                com.tencent.mm.sdk.b.a.sFg.m(lrVar);
                if (lrVar.bWg.bWe) {
                    this.lfX = true;
                    return;
                }
                c i = com.tencent.mm.ui.base.h.i(this.mContext, com.tencent.mm.plugin.v.a.a.short_video_no_record_video_permission, com.tencent.mm.plugin.v.a.a.app_tip);
                if (i != null) {
                    i.setCancelable(false);
                    i.setCanceledOnTouchOutside(false);
                    i.show();
                    this.lfX = true;
                }
            }
        }
    }

    public final String bdP() {
        if (this.ddt == null) {
            return "";
        }
        try {
            StringBuffer stringBuffer = new StringBuffer();
            ArrayList a = d.a(this.ddt.getParameters());
            Point dO = d.dO(this.mContext);
            stringBuffer.append(String.format("Screen size %d %d r:%.4f\n", new Object[]{Integer.valueOf(dO.x), Integer.valueOf(dO.y), Double.valueOf((((double) dO.x) * 1.0d) / ((double) dO.y))}));
            Iterator it = a.iterator();
            while (it.hasNext()) {
                Size size = (Size) it.next();
                if ((getPreviewWidth() == size.width && getPreviewHeight() == size.height) || (getPreviewWidth() == size.height && getPreviewHeight() == size.width)) {
                    stringBuffer.append(String.format("%s*%s √ r:%.4f\n", new Object[]{Integer.valueOf(size.width), Integer.valueOf(size.height), Double.valueOf((((double) size.height) * 1.0d) / ((double) size.width))}));
                } else {
                    stringBuffer.append(String.format("%s*%s X r:%.4f\n", new Object[]{Integer.valueOf(size.width), Integer.valueOf(size.height), Double.valueOf((((double) size.height) * 1.0d) / ((double) size.width))}));
                }
            }
            if (this.lfE != null) {
                stringBuffer.append("\nSIGHTCROPMODE:  " + this.lfE.x + " " + this.lfE.y + " from " + this.lfs.iSp + " " + this.lfs.iSq);
            } else {
                stringBuffer.append("\nFinalPreviewSize: " + getPreviewWidth() + " " + getPreviewHeight());
            }
            stringBuffer.append("\ngetOrientation:" + getOrientation());
            stringBuffer.append("\nrecorderOption: " + q.deT.dfi);
            return stringBuffer.toString();
        } catch (Exception e) {
            x.e("MicroMsg.MMSightCamera", "getDebugInfo error: %s", new Object[]{e.getMessage()});
            return null;
        }
    }

    public final void a(b bVar, boolean z, int i) {
        x.i("MicroMsg.MMSightCamera", "takePicture, callback: %s, currentFrameData: %s, isLandscape: %s, degree: %s", new Object[]{bVar, this.lfU, Boolean.valueOf(z), Integer.valueOf(i)});
        if (this.lfU != null) {
            try {
                this.lfV = true;
                Point point = new Point();
                if (this.lfE != null) {
                    point.x = this.lfE.x;
                    point.y = this.lfE.y;
                } else if (this.lfG == null || !this.lfH) {
                    point.x = this.lfs.iSp;
                    point.y = this.lfs.iSq;
                } else {
                    point.x = this.lfD.x;
                    point.y = this.lfD.y;
                }
                Object i2 = j.lin.i(Integer.valueOf(this.lfU.length));
                System.arraycopy(this.lfU, 0, i2, 0, this.lfU.length);
                int i3 = this.lfx.bYE;
                bVar.a(i2, point.x, point.y, i3, i);
                this.lfV = false;
            } catch (Exception e) {
                x.e("MicroMsg.MMSightCamera", "takePicture error: %s", new Object[]{e.getMessage()});
                this.lfV = false;
                bVar.a(null, 0, 0, -1, 0);
                this.lfV = false;
            } catch (Throwable th) {
                this.lfV = false;
                throw th;
            }
        }
    }

    public final void onAccuracyChanged(Sensor sensor, int i) {
    }

    public final void onSensorChanged(SensorEvent sensorEvent) {
        float f = sensorEvent.values[0];
        float f2 = sensorEvent.values[1];
        float f3 = sensorEvent.values[2];
        if (Math.abs(this.lfz - f) > 5.0f || Math.abs(this.lfA - f2) > 5.0f || Math.abs(this.lfB - f3) > 5.0f) {
            x.i("MicroMsg.MMSightCamera", "match accel limit %f, try auto focus x %s y %s z %s", new Object[]{Float.valueOf(5.0f), Float.valueOf(f), Float.valueOf(f2), Float.valueOf(f3)});
            this.lga.e(this.ddt);
            this.lfz = f;
            this.lfA = f2;
            this.lfB = f3;
        }
    }

    public final void b(boolean z, boolean z2, int i) {
        if (this.ddt != null && this.lfu) {
            try {
                x.d("MicroMsg.MMSightCamera", "triggerSmallZoom, zoom: %s", new Object[]{Boolean.valueOf(z)});
                if (this.ZU) {
                    x.d("MicroMsg.MMSightCamera", "triggerSmallZoom, zooming, ignore");
                    return;
                }
                Parameters parameters = this.ddt.getParameters();
                if (parameters.isZoomSupported()) {
                    int i2;
                    this.ZU = true;
                    int zoom = parameters.getZoom();
                    int maxZoom = parameters.getMaxZoom();
                    if (!z2) {
                        if (this.lfq <= 0) {
                            this.lfq = Math.round(((float) maxZoom) / 15.0f);
                            if (this.lfq > 5) {
                                this.lfq = 5;
                            }
                        }
                        i2 = this.lfq;
                    } else if (this.lfr <= 0) {
                        x.e("MicroMsg.MMSightCamera", "scroll zoom error, scrollSmallZoomStep: %s", new Object[]{Integer.valueOf(this.lfr)});
                        this.ZU = false;
                        return;
                    } else {
                        i2 = this.lfr;
                    }
                    x.d("MicroMsg.MMSightCamera", "triggerSmallZoom, currentZoom: %s, maxZoom: %s, smallZoomStep: %s, scrollSmallZoomStep: %s, factor: %s", new Object[]{Integer.valueOf(zoom), Integer.valueOf(maxZoom), Integer.valueOf(this.lfq), Integer.valueOf(this.lfr), Integer.valueOf(i)});
                    if (i > 0) {
                        i2 *= i;
                    }
                    if (z) {
                        if (zoom >= maxZoom) {
                            this.ZU = false;
                            return;
                        }
                        i2 += zoom;
                        if (i2 < maxZoom) {
                            maxZoom = i2;
                        }
                    } else if (zoom == 0) {
                        this.ZU = false;
                        return;
                    } else {
                        maxZoom = zoom - i2;
                        if (maxZoom <= 0) {
                            maxZoom = 0;
                        }
                    }
                    x.d("MicroMsg.MMSightCamera", "triggerSmallZoom, nextZoom: %s", new Object[]{Integer.valueOf(maxZoom)});
                    parameters.setZoom(maxZoom);
                    this.ddt.setParameters(parameters);
                }
                this.ZU = false;
            } catch (Exception e) {
                x.e("MicroMsg.MMSightCamera", "triggerSmallZoom error: %s", new Object[]{e.getMessage()});
            } finally {
                this.ZU = false;
            }
        }
    }

    public final boolean o(Context context, boolean z) {
        if (!j.lgz.lgL || (q.deM.ddg == 0 && this.bgR == null && this.lfy == null)) {
            this.bgR = (SensorManager) context.getSystemService("sensor");
            this.lfy = this.bgR.getDefaultSensor(1);
        }
        if (this.ddt == null) {
            bdL();
            this.lgb = z;
            if (z) {
                try {
                    this.lfv = com.tencent.mm.compatible.e.d.ze();
                } catch (Throwable e) {
                    x.printErrStackTrace("MicroMsg.MMSightCamera", e, "try to get cameraid error %s, useBackCamera: %s", new Object[]{e.getMessage(), Boolean.valueOf(this.lgb)});
                    this.lfv = 0;
                }
            } else {
                int numberOfCameras = Camera.getNumberOfCameras();
                CameraInfo cameraInfo = new CameraInfo();
                int i = 0;
                while (i < numberOfCameras) {
                    Camera.getCameraInfo(i, cameraInfo);
                    if (cameraInfo.facing == 1) {
                        x.d("MicroMsg.CameraUtil", "tigercam get fid %d", new Object[]{Integer.valueOf(i)});
                        break;
                    }
                    i++;
                }
                i = 0;
                x.d("MicroMsg.CameraUtil", "tigercam getBackCameraId %d", new Object[]{Integer.valueOf(i)});
                this.lfv = i;
            }
            x.i("MicroMsg.MMSightCamera", "use camera id %d, DeviceInfo id %d", new Object[]{Integer.valueOf(this.lfv), Integer.valueOf(q.deM.ddj)});
            this.lfX = false;
            this.mContext = context;
            this.lfx = new n().s(context, this.lfv);
            x.i("MicroMsg.MMSightCamera", "open camera end, %s", new Object[]{Looper.myLooper()});
            if (this.lfx == null) {
                x.i("MicroMsg.MMSightCamera", "open camera FAILED, %s", new Object[]{Looper.myLooper()});
                bdO();
                return false;
            }
            this.ddt = this.lfx.ddt;
            this.lga.lgj = false;
            this.lfs.bYE = this.lfx.bYE;
            if (this.ddt == null) {
                x.e("MicroMsg.MMSightCamera", "start camera FAILED!");
                bdO();
                return false;
            }
        }
        return true;
    }

    public final boolean a(Context context, SurfaceTexture surfaceTexture, boolean z) {
        x.i("MicroMsg.MMSightCamera", "switch camera, current useBack: %s", new Object[]{Boolean.valueOf(this.lgb)});
        try {
            bdL();
            o(context, !this.lgb);
            a(surfaceTexture, z);
            return true;
        } catch (Exception e) {
            x.e("MicroMsg.MMSightCamera", "switchCamera error: %s", new Object[]{e});
            return false;
        }
    }

    public final boolean a(Context context, SurfaceTexture surfaceTexture, int i, float f, boolean z) {
        x.i("MicroMsg.MMSightCamera", "switch camera with limit, current useBack: %s", new Object[]{Boolean.valueOf(this.lgb)});
        try {
            bdL();
            o(context, !this.lgb);
            a(surfaceTexture, i, f, z);
            return true;
        } catch (Exception e) {
            x.e("MicroMsg.MMSightCamera", "switchCamera error: %s", new Object[]{e});
            return false;
        }
    }

    public final void bdQ() {
        x.i("MicroMsg.MMSightCamera", "openFlash, camera: %s, isPreviewing: %s", new Object[]{this.ddt, Boolean.valueOf(this.lfu)});
        if (this.ddt != null && this.lfu) {
            try {
                this.lfJ = true;
                Parameters parameters = this.ddt.getParameters();
                if (bi.cX(parameters.getSupportedFlashModes()) || !parameters.getSupportedFlashModes().contains("torch")) {
                    x.i("MicroMsg.MMSightCamera", "camera not support flash!!");
                    return;
                }
                parameters.setFlashMode("torch");
                this.ddt.setParameters(parameters);
                x.i("MicroMsg.MMSightCamera", "open flash");
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.MMSightCamera", e, "openFlash error: %s", new Object[]{e.getMessage()});
            }
        }
    }

    public final void bdR() {
        x.i("MicroMsg.MMSightCamera", "closeFlash, camera: %s, isPreviewing: %s", new Object[]{this.ddt, Boolean.valueOf(this.lfu)});
        if (this.ddt != null && this.lfu) {
            try {
                this.lfJ = false;
                Parameters parameters = this.ddt.getParameters();
                if (bi.cX(parameters.getSupportedFlashModes()) || !parameters.getSupportedFlashModes().contains("off")) {
                    x.i("MicroMsg.MMSightCamera", "camera not support close flash!!");
                    return;
                }
                parameters.setFlashMode("off");
                this.ddt.setParameters(parameters);
                x.i("MicroMsg.MMSightCamera", "close flash");
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.MMSightCamera", e, "closeFlash error: %s", new Object[]{e.getMessage()});
            }
        }
    }

    public final int getPreviewWidth() {
        if (this.ddt == null || this.lfx == null) {
            return 0;
        }
        try {
            return (!this.lfH || this.lfG == null) ? this.lfE == null ? (this.lfx.bYE == 0 || this.lfx.bYE == 180) ? this.lfs.iSp : this.lfs.iSq : (this.lfx.bYE == 0 || this.lfx.bYE == 180) ? this.lfE.x : this.lfE.y : (this.lfx.bYE == 0 || this.lfx.bYE == 180) ? this.lfD.x : this.lfD.y;
        } catch (Exception e) {
            x.e("MicroMsg.MMSightCamera", "getPreviewWidth: %s", new Object[]{e.getMessage()});
            return 0;
        }
    }

    public final int getPreviewHeight() {
        if (this.ddt == null || this.lfx == null) {
            return 0;
        }
        try {
            return (!this.lfH || this.lfG == null) ? this.lfE == null ? (this.lfx.bYE == 0 || this.lfx.bYE == 180) ? this.lfs.iSq : this.lfs.iSp : (this.lfx.bYE == 0 || this.lfx.bYE == 180) ? this.lfE.y : this.lfE.x : (this.lfx.bYE == 0 || this.lfx.bYE == 180) ? this.lfD.y : this.lfD.x;
        } catch (Exception e) {
            x.e("MicroMsg.MMSightCamera", "getPreviewHeight: %s", new Object[]{e.getMessage()});
            return 0;
        }
    }

    public final int getOrientation() {
        if (this.lfx == null || !this.lfu) {
            return -1;
        }
        return this.lfx.bYE;
    }
}
