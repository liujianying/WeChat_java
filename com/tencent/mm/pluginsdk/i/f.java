package com.tencent.mm.pluginsdk.i;

import android.annotation.TargetApi;
import android.hardware.Camera;
import android.hardware.Camera.AutoFocusCallback;
import android.hardware.Camera.Parameters;
import android.hardware.Camera.PreviewCallback;
import android.hardware.Camera.Size;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Build.VERSION;
import android.view.SurfaceHolder;
import com.tencent.mm.compatible.e.d$a.a;
import com.tencent.mm.compatible.e.h;
import com.tencent.mm.compatible.e.q;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.compatible.util.g;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public final class f implements SensorEventListener {
    static int lfv = 0;
    SensorManager bgR;
    public Camera ddt = null;
    private float lfA = 0.0f;
    private float lfB = 0.0f;
    private boolean lfu = false;
    a lfx;
    Sensor lfy;
    private float lfz = 0.0f;
    private PreviewCallback ngt = null;
    private SurfaceHolder oyi = null;
    a qEb;
    public List<Integer> qEc = new ArrayList();
    private boolean qEd = true;
    private boolean qEe = true;
    private AutoFocusCallback qEf = new 1(this);

    public static int getCameraId() {
        return lfv;
    }

    public final void bdL() {
        if (!(this.bgR == null || this.lfy == null)) {
            this.bgR.unregisterListener(this);
        }
        if (this.ddt != null) {
            x.d("MicroMsg.YuvReocrder", "release camera");
            this.ddt.setPreviewCallback(null);
            this.ddt.stopPreview();
            this.ddt.release();
            this.ddt = null;
            this.lfu = false;
        }
    }

    @TargetApi(9)
    private static void e(Parameters parameters) {
        if (q.deM.dcY <= 0 && VERSION.SDK_INT >= 9) {
            List supportedPreviewFpsRange = parameters.getSupportedPreviewFpsRange();
            if (supportedPreviewFpsRange != null && supportedPreviewFpsRange.size() != 0) {
                int size = supportedPreviewFpsRange.size();
                int i = 0;
                int i2 = Integer.MIN_VALUE;
                int i3 = Integer.MIN_VALUE;
                while (i < size) {
                    int i4;
                    int i5;
                    int[] iArr = (int[]) supportedPreviewFpsRange.get(i);
                    if (iArr != null && iArr.length > 1) {
                        i4 = iArr[0];
                        i5 = iArr[1];
                        x.d("MicroMsg.YuvReocrder", "dkfps %d:[%d %d]", new Object[]{Integer.valueOf(i), Integer.valueOf(i4), Integer.valueOf(i5)});
                        if (i4 >= 0 && i5 >= i4 && i5 >= i2) {
                            i++;
                            i2 = i5;
                            i3 = i4;
                        }
                    }
                    i5 = i2;
                    i4 = i3;
                    i++;
                    i2 = i5;
                    i3 = i4;
                }
                x.d("MicroMsg.YuvReocrder", "dkfps get fit  [%d %d]", new Object[]{Integer.valueOf(i3), Integer.valueOf(i2)});
                if (i3 != Integer.MAX_VALUE && i2 != Integer.MAX_VALUE) {
                    try {
                        parameters.setPreviewFpsRange(i3, i2);
                    } catch (Throwable e) {
                        x.printErrStackTrace("MicroMsg.YuvReocrder", e, "", new Object[0]);
                    }
                }
            }
        }
    }

    public final int b(SurfaceHolder surfaceHolder) {
        if (this.lfu) {
            return 0;
        }
        if (surfaceHolder == null) {
            return 0 - g.getLine();
        }
        try {
            List supportedVideoSizes;
            List supportedPreviewSizes;
            this.oyi = surfaceHolder;
            Parameters parameters = this.ddt.getParameters();
            a aVar = this.qEb;
            x.d("MicroMsg.YuvReocrder", "getFitRecordSize");
            int i = Integer.MAX_VALUE;
            if (VERSION.SDK_INT >= 11) {
                h hVar = new h();
                supportedVideoSizes = parameters.getSupportedVideoSizes();
            } else {
                supportedVideoSizes = null;
            }
            if (supportedVideoSizes == null) {
                x.d("MicroMsg.YuvReocrder", "getFitRecordSize getSupportedVideoSizes null, use getSupportedPreviewSizes instead");
                com.tencent.mm.compatible.e.g gVar = new com.tencent.mm.compatible.e.g();
                supportedPreviewSizes = parameters.getSupportedPreviewSizes();
            } else {
                supportedPreviewSizes = supportedVideoSizes;
            }
            Size previewSize;
            if (supportedPreviewSizes != null) {
                int i2 = 0;
                boolean z = false;
                while (i2 < supportedPreviewSizes.size()) {
                    boolean z2;
                    int i3 = ((Size) supportedPreviewSizes.get(i2)).height;
                    int i4 = ((Size) supportedPreviewSizes.get(i2)).width;
                    x.d("MicroMsg.YuvReocrder", "supp w:" + i4 + " h:" + i3);
                    int i5 = i3 * i4;
                    if ((((aVar.bYE == 0 || aVar.bYE == 180) && i3 >= aVar.lgR && i4 >= aVar.lgS) || ((aVar.bYE == 90 || aVar.bYE == 270) && i4 >= aVar.lgR && i3 >= aVar.lgS)) && i5 < i) {
                        aVar.iSp = i4;
                        aVar.iSq = i3;
                        z2 = true;
                    } else {
                        z2 = z;
                        i5 = i;
                    }
                    i2++;
                    z = z2;
                    i = i5;
                }
                if (!z) {
                    previewSize = parameters.getPreviewSize();
                    aVar.iSq = previewSize.height;
                    aVar.iSp = previewSize.width;
                }
            } else {
                previewSize = parameters.getPreviewSize();
                aVar.iSq = previewSize.height;
                aVar.iSp = previewSize.width;
            }
            x.d("MicroMsg.YuvReocrder", " rotate:" + aVar.bYE + " w:" + aVar.iSp + " h:" + aVar.iSq);
            parameters.setPreviewSize(this.qEb.iSp, this.qEb.iSq);
            e(parameters);
            Collection supportedPreviewFrameRates = parameters.getSupportedPreviewFrameRates();
            this.qEc.clear();
            this.qEc.addAll(supportedPreviewFrameRates);
            parameters.setPreviewFormat(17);
            supportedVideoSizes = parameters.getSupportedFocusModes();
            if (supportedVideoSizes != null) {
                if (d.fT(9) && true == supportedVideoSizes.contains("continuous-video")) {
                    x.i("MicroMsg.YuvReocrder", "support continous-video");
                    this.qEd = false;
                    parameters.setFocusMode("continuous-video");
                } else if (!supportedVideoSizes.contains("auto")) {
                    x.i("MicroMsg.YuvReocrder", "don't support auto");
                    this.qEd = false;
                }
            }
            this.ddt.setParameters(parameters);
            this.ddt.setPreviewDisplay(surfaceHolder);
            this.ddt.startPreview();
            if (!(this.bgR == null || this.lfy == null || !this.qEd)) {
                this.bgR.registerListener(this, this.lfy, 2);
            }
            this.lfu = true;
            return 0;
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.YuvReocrder", e, "", new Object[0]);
            x.e("MicroMsg.YuvReocrder", "Start preview FAILED :" + e.getMessage());
            return 0 - g.getLine();
        }
    }

    public final void onAccuracyChanged(Sensor sensor, int i) {
    }

    public final void onSensorChanged(SensorEvent sensorEvent) {
        float f = sensorEvent.values[0];
        float f2 = sensorEvent.values[1];
        float f3 = sensorEvent.values[2];
        if ((Math.abs(this.lfz - f) > 2.0f || Math.abs(this.lfA - f2) > 2.0f || Math.abs(this.lfB - f3) > 2.0f) && this.ddt != null && this.qEe && true == this.qEd) {
            try {
                x.d("MicroMsg.YuvReocrder", "auto focus");
                this.ddt.autoFocus(this.qEf);
                this.qEe = false;
            } catch (Exception e) {
                x.d("MicroMsg.YuvReocrder", "auto focus failed");
            }
        }
        this.lfz = f;
        this.lfA = f2;
        this.lfB = f3;
    }
}
