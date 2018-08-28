package com.tencent.mm.plugin.scanner.util;

import android.app.Activity;
import android.graphics.Point;
import android.graphics.Rect;
import android.hardware.Camera;
import android.hardware.Camera.Area;
import android.hardware.Camera.Parameters;
import android.hardware.Camera.Size;
import android.os.Build;
import android.view.Display;
import android.view.WindowManager;
import com.tencent.mm.compatible.e.q;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.ak;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.regex.Pattern;

public final class h {
    private static final Pattern mNm = Pattern.compile(",");
    public Activity bOb;
    public Camera ddt;
    public int fNR = 0;
    public Rect iKQ;
    public boolean iOl = false;
    public Point iOm = null;
    public Point iOn = null;
    public Point iOo = null;
    public boolean iOp;
    public int iOq;
    public boolean iOr = false;
    public boolean lfJ = false;
    private boolean mNn;
    public Rect mNo;
    private Rect mNp;
    private Rect mNq;
    public int mNr = -1;
    private String mNs = "";
    private int mNt;
    private int mNu;
    private int mNv;

    public h(Activity activity, int i, boolean z) {
        Point point;
        this.bOb = activity;
        if (Build.MANUFACTURER.equalsIgnoreCase("meizu")) {
            Display defaultDisplay = ((WindowManager) activity.getSystemService("window")).getDefaultDisplay();
            point = new Point(defaultDisplay.getWidth(), defaultDisplay.getHeight());
        } else {
            point = ak.gu(activity);
        }
        this.iOn = point;
        this.mNn = z;
        this.fNR = i;
    }

    public final boolean isOpen() {
        if (this.ddt != null) {
            return true;
        }
        return false;
    }

    public final void vF(int i) {
        this.fNR = i;
        this.mNo = null;
        this.iKQ = null;
    }

    public final String getFocusMode() {
        try {
            if (this.ddt != null && this.iOl) {
                return this.ddt.getParameters().getFocusMode();
            }
        } catch (Exception e) {
            x.w("MicroMsg.scanner.ScanCamera", "getFocusMode() %s", new Object[]{e.getMessage()});
        }
        return "";
    }

    public final void release() {
        x.i("MicroMsg.scanner.ScanCamera", "release(), previewing = [%s]", new Object[]{Boolean.valueOf(this.iOl)});
        if (this.ddt != null) {
            long VG = bi.VG();
            this.ddt.setPreviewCallback(null);
            this.ddt.stopPreview();
            this.iOl = false;
            x.i("MicroMsg.scanner.ScanCamera", "stopPreview costTime=[%s]", new Object[]{Long.valueOf(bi.bI(VG))});
            VG = bi.VG();
            this.ddt.release();
            this.ddt = null;
            x.i("MicroMsg.scanner.ScanCamera", "camera.release() costTime=[%s]", new Object[]{Long.valueOf(bi.bI(VG))});
        }
        this.lfJ = false;
        this.iOr = false;
        this.mNr = -1;
        this.fNR = 0;
    }

    public final float btb() {
        if (!this.iOp || this.mNn) {
            return ((float) this.iOo.x) / ((float) this.iOm.x);
        }
        return ((float) this.iOo.x) / ((float) this.iOm.y);
    }

    public final float btc() {
        if (!this.iOp || this.mNn) {
            return ((float) this.iOo.y) / ((float) this.iOm.y);
        }
        return ((float) this.iOo.y) / ((float) this.iOm.x);
    }

    private float btd() {
        if (!this.iOp || this.mNn) {
            return ((float) this.iOm.x) / ((float) this.iOo.x);
        }
        return ((float) this.iOm.y) / ((float) this.iOo.x);
    }

    private float bte() {
        if (!this.iOp || this.mNn) {
            return ((float) this.iOm.y) / ((float) this.iOo.y);
        }
        return ((float) this.iOm.x) / ((float) this.iOo.y);
    }

    public final Rect c(Rect rect, int i) {
        Rect rect2 = new Rect();
        x.i("MicroMsg.scanner.ScanCamera", "frame rect:%s, visibleResolution:%s", new Object[]{rect, this.iOo});
        if (!this.iOp || this.mNn) {
            rect2.left = (int) (((float) rect.left) * btd());
            rect2.right = (int) (((float) rect.right) * btd());
            rect2.top = (int) (((float) rect.top) * bte());
            rect2.bottom = (int) (((float) rect.bottom) * bte());
            if (rect2.bottom > this.iOm.y) {
                rect2.bottom = this.iOm.y;
            }
            if (rect2.right > this.iOm.x) {
                rect2.right = this.iOm.x;
            }
        } else {
            x.i("MicroMsg.scanner.ScanCamera", ", needRotate = " + this.iOp + " needLandscape = " + this.mNn);
            rect2.top = (this.iOm.y - ((int) (((float) rect.width()) * btd()))) / 2;
            rect2.bottom = rect2.top + ((int) (((float) rect.width()) * btd()));
            rect2.left = (this.iOm.x - ((int) (((float) rect.height()) * bte()))) / 2;
            rect2.right = rect2.left + ((int) (((float) rect.height()) * bte()));
            if (rect2.bottom > this.iOm.y) {
                rect2.bottom = this.iOm.y;
            }
            if (rect2.right > this.iOm.x) {
                rect2.right = this.iOm.x;
            }
        }
        if (7 == i || 11 == i) {
            int width;
            if (!this.iOp || this.mNn) {
                if ((((double) rect2.width()) * 1.0d) / ((double) rect2.height()) < 1.5859999656677246d) {
                    width = (int) (((float) rect2.width()) / 1.586f);
                    rect2.top = ((rect2.top + rect2.bottom) / 2) - (width / 2);
                    rect2.bottom = width + rect2.top;
                } else {
                    width = (int) (((float) rect2.height()) * 1.586f);
                    rect2.left = ((rect2.left + rect2.right) / 2) - (width / 2);
                    rect2.right = width + rect2.left;
                }
            } else if (((float) rect2.height()) / 1.586f < ((float) rect2.width())) {
                width = (int) (((float) rect2.height()) / 1.586f);
                rect2.left = ((rect2.left + rect2.right) / 2) - (width / 2);
                rect2.right = width + rect2.left;
            } else {
                width = (int) (((float) rect2.width()) * 1.586f);
                rect2.top = ((rect2.top + rect2.bottom) / 2) - (width / 2);
                rect2.bottom = width + rect2.top;
            }
        }
        return rect2;
    }

    public final void btf() {
        if (this.ddt != null && !this.iOr) {
            try {
                int width;
                int height;
                Parameters parameters = this.ddt.getParameters();
                if (this.mNo != null) {
                    this.mNp = new Rect();
                    width = (int) ((((float) this.mNo.width()) / ((float) this.iOm.x)) * 2000.0f);
                    height = (int) ((((float) this.mNo.height()) / ((float) this.iOm.y)) * 2000.0f);
                    this.mNp.left = (-width) / 2;
                    this.mNp.right = width / 2;
                    this.mNp.top = (-height) / 2;
                    this.mNp.bottom = height / 2;
                    x.i("MicroMsg.scanner.ScanCamera", "set focus area:" + this.mNp);
                }
                if (this.mNo != null) {
                    this.mNq = new Rect();
                    width = (int) ((((float) this.mNo.width()) / ((float) this.iOm.x)) * 2000.0f);
                    height = (int) ((((float) this.mNo.height()) / ((float) this.iOm.y)) * 2000.0f);
                    this.mNq.left = (-width) / 2;
                    this.mNq.right = width / 2;
                    this.mNq.top = (-height) / 2;
                    this.mNq.bottom = height / 2;
                    x.i("MicroMsg.scanner.ScanCamera", "set metering area:" + this.mNq);
                }
                if (this.mNp != null && this.mNq != null) {
                    List arrayList;
                    this.iOr = true;
                    if (parameters.getMaxNumMeteringAreas() > 0) {
                        arrayList = new ArrayList();
                        arrayList.add(new Area(this.mNq, 1000));
                        parameters.setMeteringAreas(arrayList);
                    } else {
                        x.i("MicroMsg.scanner.ScanCamera", "setFocusAndMeteringArea, camera not support set metering area");
                    }
                    if (parameters.getMaxNumFocusAreas() > 0) {
                        arrayList = new ArrayList();
                        arrayList.add(new Area(this.mNp, 1000));
                        parameters.setFocusAreas(arrayList);
                    } else {
                        x.i("MicroMsg.scanner.ScanCamera", "setFocusAndMeteringArea, camera not support area focus");
                    }
                    this.ddt.setParameters(parameters);
                }
            } catch (Exception e) {
                x.e("MicroMsg.scanner.ScanCamera", "setFocusAndMeteringArea error: %s", new Object[]{e.getMessage()});
            }
        }
    }

    public static Point a(Parameters parameters, Point point, Point point2, boolean z) {
        String str;
        String str2 = parameters.get("preview-size-values");
        if (str2 == null) {
            str = parameters.get("preview-size-value");
        } else {
            str = str2;
        }
        Point point3 = null;
        if (str != null) {
            x.d("MicroMsg.scanner.ScanCamera", "preview-size-values parameter: " + str);
            point3 = a(parameters, point, z);
        }
        if (point3 == null) {
            return new Point((point2.x >> 3) << 3, (point2.y >> 3) << 3);
        }
        return point3;
    }

    private static Point a(Parameters parameters, Point point, boolean z) {
        Size previewSize;
        List<Size> arrayList = new ArrayList(parameters.getSupportedPreviewSizes());
        Collections.sort(arrayList, new a((byte) 0));
        arrayList.remove(0);
        Point point2 = null;
        x.d("MicroMsg.scanner.ScanCamera", "screen.x: %d, screen.y: %d, ratio: %f", new Object[]{Integer.valueOf(point.x), Integer.valueOf(point.y), Float.valueOf(((float) point.x) / ((float) point.y))});
        x.i("MicroMsg.scanner.ScanCamera", "SCREEN_PIXELS: %s, MAX_PREVIEW_PIXELS_USE_BIGGER: %s", new Object[]{Integer.valueOf(point.x * point.y), Integer.valueOf(2073600)});
        float f = Float.POSITIVE_INFINITY;
        for (Size previewSize2 : arrayList) {
            int i = previewSize2.width;
            int i2 = previewSize2.height;
            x.i("MicroMsg.scanner.ScanCamera", "realWidth: %d, realHeight: %d", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
            int i3 = i * i2;
            if (i3 >= 150400 && i3 <= 2073600) {
                if (i3 <= r7 || Math.min(point.x, point.y) < 720) {
                    int i4;
                    Object obj = i > i2 ? 1 : null;
                    if (obj == null || z) {
                        i4 = i;
                    } else {
                        i4 = i2;
                    }
                    if (obj == null || z) {
                        i3 = i2;
                    } else {
                        i3 = i;
                    }
                    x.d("MicroMsg.scanner.ScanCamera", "maybeFlippedWidth: %d, maybeFlippedHeight: %d", new Object[]{Integer.valueOf(i4), Integer.valueOf(i3)});
                    if (i4 == point.x && i3 == point.y) {
                        point2 = new Point(i, i2);
                        x.i("MicroMsg.scanner.ScanCamera", "Found preview size exactly matching screen size: " + point2);
                        return point2;
                    }
                    float f2;
                    float abs = Math.abs((((float) i4) / ((float) i3)) - r6);
                    if (abs < f) {
                        f2 = abs;
                        point2 = new Point(i, i2);
                    } else {
                        f2 = f;
                    }
                    x.i("MicroMsg.scanner.ScanCamera", "diff:[%s] newdiff:[%s] w:[%s] h:[%s]", new Object[]{Float.valueOf(f2), Float.valueOf(abs), Integer.valueOf(i), Integer.valueOf(i2)});
                    f = f2;
                }
            }
        }
        if (point2 == null) {
            previewSize2 = parameters.getPreviewSize();
            point2 = new Point(previewSize2.width, previewSize2.height);
            x.i("MicroMsg.scanner.ScanCamera", "No suitable preview sizes, using default: " + point2);
        }
        x.i("MicroMsg.scanner.ScanCamera", "Found best approximate preview size: " + point2);
        return point2;
    }

    public final void btg() {
        try {
            if (this.ddt != null) {
                Parameters parameters = this.ddt.getParameters();
                String str = parameters.get("zoom-supported");
                if (bi.oW(str) || !Boolean.parseBoolean(str)) {
                    x.i("MicroMsg.scanner.ScanCamera", "not support zoom");
                    return;
                }
                List zoomRatios = parameters.getZoomRatios();
                if (zoomRatios != null && zoomRatios.size() > 0) {
                    au.HU();
                    q.fd(c.DU().cmX());
                    x.i("MicroMsg.scanner.ScanCamera", "needZoom: %s, qrCodeZoom: %s", new Object[]{Boolean.valueOf(q.deW.ddV == 1), Integer.valueOf(q.deW.ddV)});
                    if ((q.deW.ddV == 1) && this.iOn.x >= 720 && (this.fNR == 1 || this.fNR == 8 || this.fNR == 4)) {
                        this.mNu = zoomRatios.size() / 5;
                        if (this.mNu > 150) {
                            this.mNu = 150;
                        }
                    } else {
                        this.mNu = 0;
                    }
                    double d = 1.5d;
                    if (q.deW.ddW != -1.0d) {
                        d = q.deW.ddW;
                    }
                    this.mNv = (int) (((double) zoomRatios.size()) / d);
                    x.d("MicroMsg.scanner.ScanCamera", "divideRatio: %f,max zoom: %d", new Object[]{Double.valueOf(d), Integer.valueOf(this.mNv)});
                    if (this.mNv < this.mNu) {
                        this.mNv = this.mNu;
                    } else if (this.mNv > 400) {
                        this.mNv = 400;
                    }
                    x.i("MicroMsg.scanner.ScanCamera", "default zoom:%d,default ratio:%d,max zoom:%d,max ratio:%d", new Object[]{Integer.valueOf(this.mNu), zoomRatios.get(this.mNu), Integer.valueOf(this.mNv), zoomRatios.get(this.mNv)});
                }
            }
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.scanner.ScanCamera", e, "init zoom exception!", new Object[0]);
        }
    }

    public final void vG(int i) {
        if (this.ddt != null && this.iOl && i > 0) {
            try {
                Parameters parameters = this.ddt.getParameters();
                List zoomRatios = parameters.getZoomRatios();
                if (zoomRatios != null && zoomRatios.size() > 0) {
                    int binarySearch;
                    int intValue = (int) (((double) ((Integer) zoomRatios.get(this.mNt)).intValue()) * (((double) i) / 100.0d));
                    x.d("MicroMsg.scanner.ScanCamera", "scale:%d,to ratio:%d", new Object[]{Integer.valueOf(i), Integer.valueOf(intValue)});
                    if (intValue >= ((Integer) zoomRatios.get(this.mNu)).intValue() && intValue <= ((Integer) zoomRatios.get(this.mNv)).intValue()) {
                        if (zoomRatios != null && zoomRatios.size() > 0) {
                            x.i("MicroMsg.scanner.ScanCamera", "zoomRatios: %s,size: %d", new Object[]{zoomRatios, Integer.valueOf(zoomRatios.size())});
                            binarySearch = Collections.binarySearch(zoomRatios, Integer.valueOf(intValue));
                            x.i("MicroMsg.scanner.ScanCamera", "insert index:%d", new Object[]{Integer.valueOf(binarySearch)});
                            if (binarySearch < 0) {
                                int i2 = -(binarySearch + 1);
                                int i3 = i2 - 1;
                                if (i2 >= 0) {
                                    if (i2 <= zoomRatios.size() - 1 && i3 >= 0 && i3 <= zoomRatios.size() - 1) {
                                        binarySearch = ((Integer) zoomRatios.get(i2)).intValue() - intValue > intValue - ((Integer) zoomRatios.get(i3)).intValue() ? i3 : i2;
                                    }
                                }
                                if (i2 >= 0 && i2 <= zoomRatios.size() - 1) {
                                    binarySearch = i2;
                                } else if (i3 >= 0 && i3 <= zoomRatios.size() - 1) {
                                    binarySearch = i3;
                                }
                            }
                        }
                        binarySearch = 0;
                    } else if (intValue < ((Integer) zoomRatios.get(this.mNu)).intValue()) {
                        binarySearch = this.mNu;
                    } else {
                        x.i("MicroMsg.scanner.ScanCamera", "exceed max zoom");
                        binarySearch = this.mNt + ((this.mNv - this.mNt) / 5);
                        if (binarySearch > this.mNv) {
                            binarySearch = this.mNv;
                        }
                    }
                    x.i("MicroMsg.scanner.ScanCamera", "zoom:%d,ratio:%d", new Object[]{Integer.valueOf(binarySearch), zoomRatios.get(binarySearch)});
                    this.mNt = binarySearch;
                    parameters.setZoom(binarySearch);
                    this.ddt.setParameters(parameters);
                }
            } catch (Exception e) {
                x.e("MicroMsg.scanner.ScanCamera", "zoom scale exception:" + e.getMessage());
            }
        }
    }

    public final void vH(int i) {
        if (this.ddt != null && this.iOl) {
            try {
                Parameters parameters = this.ddt.getParameters();
                List zoomRatios = parameters.getZoomRatios();
                if (zoomRatios != null && zoomRatios.size() > 0) {
                    x.i("MicroMsg.scanner.ScanCamera", "zoom action:%d,beforeZoom:%d", new Object[]{Integer.valueOf(i), Integer.valueOf(parameters.getZoom())});
                    switch (i) {
                        case 0:
                            this.mNt = 0;
                            break;
                        case 1:
                            this.mNt = this.mNu;
                            break;
                        case 2:
                            if (this.mNt < this.mNv) {
                                this.mNt++;
                                this.mNt = this.mNt > this.mNv ? this.mNv : this.mNt;
                                break;
                            }
                            break;
                        case 3:
                            if (this.mNt > this.mNu) {
                                this.mNt--;
                                this.mNt = this.mNt < this.mNu ? this.mNu : this.mNt;
                                break;
                            }
                            break;
                        case 4:
                            this.mNt = this.mNv;
                            break;
                        case 5:
                            if (this.mNt == this.mNu) {
                                this.mNt = this.mNv;
                                break;
                            } else {
                                this.mNt = this.mNu;
                                break;
                            }
                    }
                    parameters.setZoom(this.mNt);
                    this.ddt.setParameters(parameters);
                    x.i("MicroMsg.scanner.ScanCamera", "zoom action:%d,afterZoom:%d", new Object[]{Integer.valueOf(i), Integer.valueOf(parameters.getZoom())});
                }
            } catch (Exception e) {
                x.e("MicroMsg.scanner.ScanCamera", "zoom action exception:" + e.getMessage());
            }
        }
    }

    public final int bth() {
        if (this.ddt == null || this.ddt.getParameters() == null || this.ddt.getParameters().getZoomRatios() == null || this.ddt.getParameters().getZoomRatios().size() <= 0) {
            return 100;
        }
        return ((Integer) this.ddt.getParameters().getZoomRatios().get(this.mNt)).intValue();
    }

    public static void c(Parameters parameters) {
        try {
            List<String> supportedFocusModes = parameters.getSupportedFocusModes();
            if (supportedFocusModes != null) {
                x.i("MicroMsg.scanner.ScanCamera", "supported focus modes size = " + supportedFocusModes.size());
                for (String str : supportedFocusModes) {
                    x.i("MicroMsg.scanner.ScanCamera", "supported focus modes : " + str);
                }
                if (supportedFocusModes.contains("continuous-video")) {
                    x.d("MicroMsg.scanner.ScanCamera", "camera support continuous video focus");
                    parameters.setFocusMode("continuous-video");
                } else if (supportedFocusModes.contains("auto")) {
                    x.d("MicroMsg.scanner.ScanCamera", "camera support auto focus");
                    parameters.setFocusMode("auto");
                }
            }
        } catch (Exception e) {
            x.e("MicroMsg.scanner.ScanCamera", "setAutoFocus error: %s", new Object[]{e.getMessage()});
        }
    }

    public final boolean bti() {
        if (this.ddt != null && this.iOl) {
            try {
                Parameters parameters = this.ddt.getParameters();
                if (!bi.cX(parameters.getSupportedFlashModes()) && parameters.getSupportedFlashModes().contains("torch")) {
                    return true;
                }
                x.i("MicroMsg.scanner.ScanCamera", "camera not support flash!!");
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.scanner.ScanCamera", e, "isFlashSupported error: %s", new Object[]{e.getMessage()});
            }
        }
        return false;
    }

    public final void bdR() {
        x.i("MicroMsg.scanner.ScanCamera", "closeFlash, camera: %s, isPreviewing: %s", new Object[]{this.ddt, Boolean.valueOf(this.iOl)});
        if (this.ddt != null && this.iOl) {
            try {
                this.lfJ = false;
                Parameters parameters = this.ddt.getParameters();
                if (bi.cX(parameters.getSupportedFlashModes()) || !parameters.getSupportedFlashModes().contains("off")) {
                    x.i("MicroMsg.scanner.ScanCamera", "camera not support close flash!!");
                    return;
                }
                parameters.setFlashMode("off");
                this.ddt.setParameters(parameters);
                x.i("MicroMsg.scanner.ScanCamera", "close flash");
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.scanner.ScanCamera", e, "closeFlash error: %s", new Object[]{e.getMessage()});
            }
        }
    }
}
