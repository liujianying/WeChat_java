package com.tencent.mm.plugin.sight.encode.ui;

import android.graphics.Rect;
import android.graphics.RectF;
import android.hardware.Camera;
import android.hardware.Camera.Area;
import android.hardware.Camera.AutoFocusCallback;
import android.hardware.Camera.Parameters;
import android.os.Looper;
import android.os.Message;
import com.tencent.mm.bp.a;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.smtt.utils.TbsLog;
import java.util.ArrayList;
import java.util.List;

class e$a extends ag {
    static boolean lfY = true;
    static AutoFocusCallback lfZ = new 1();
    float kuY;
    boolean lft = false;
    int lgh = 0;
    boolean lgi = false;
    boolean lgj = false;
    float lgk;
    int lgl;
    int lgm;

    private static Rect a(float f, float f2, float f3, int i, int i2) {
        int intValue = Float.valueOf(((float) a.fromDPToPix(ad.getContext(), 72)) * f3).intValue();
        RectF rectF = new RectF();
        rectF.set((((f - ((float) (intValue / 2))) * 2000.0f) / ((float) i)) - 1000.0f, (((f2 - ((float) (intValue / 2))) * 2000.0f) / ((float) i2)) - 1000.0f, (((((float) (intValue / 2)) + f) * 2000.0f) / ((float) i)) - 1000.0f, (((((float) (intValue / 2)) + f2) * 2000.0f) / ((float) i2)) - 1000.0f);
        return new Rect(sP(Math.round(rectF.left)), sP(Math.round(rectF.top)), sP(Math.round(rectF.right)), sP(Math.round(rectF.bottom)));
    }

    private static int sP(int i) {
        if (i > TbsLog.TBSLOG_CODE_SDK_BASE) {
            return TbsLog.TBSLOG_CODE_SDK_BASE;
        }
        if (i < -1000) {
            return -1000;
        }
        return i;
    }

    static void f(Camera camera) {
        if (camera == null) {
            x.w("MicroMsg.SightCamera", "want to auto focus, but camera is null, do nothing");
        }
        if (lfY) {
            lfY = false;
            try {
                camera.autoFocus(lfZ);
                return;
            } catch (Exception e) {
                x.w("MicroMsg.SightCamera", "autofocus fail, exception %s", new Object[]{e.getMessage()});
                lfY = true;
                return;
            }
        }
        x.w("MicroMsg.SightCamera", "auto focus not back");
    }

    public e$a(Looper looper) {
        super(looper);
    }

    private static int b(Parameters parameters) {
        if (parameters == null) {
            return 0;
        }
        int maxZoom;
        try {
            maxZoom = parameters.getMaxZoom() / 2;
            if (maxZoom <= 0) {
                maxZoom = parameters.getMaxZoom();
            }
        } catch (Exception e) {
            x.e("MicroMsg.SightCamera", "get target zoom value error: %s", new Object[]{e.getMessage()});
            maxZoom = 0;
        }
        return maxZoom;
    }

    static int d(Parameters parameters) {
        int b = b(parameters) / 6;
        if (b <= 0) {
            return 1;
        }
        return b;
    }

    public final void handleMessage(Message message) {
        boolean z = true;
        Camera camera;
        switch (message.what) {
            case 4353:
                if (!this.lgj) {
                    int b;
                    camera = (Camera) message.obj;
                    Parameters parameters = camera.getParameters();
                    x.i("MicroMsg.SightCamera", "zoomed %s curZoomStep %s params.getZoom() %s", new Object[]{Boolean.valueOf(this.lft), Integer.valueOf(this.lgh), Integer.valueOf(parameters.getZoom())});
                    int zoom = parameters.getZoom() + this.lgh;
                    if (this.lft) {
                        b = b(parameters);
                        if (zoom < b) {
                            long j;
                            Message obtainMessage = obtainMessage(4353, message.obj);
                            if (this.lgi) {
                                j = 10;
                            } else {
                                j = 20;
                            }
                            sendMessageDelayed(obtainMessage, j);
                            z = false;
                            b = zoom;
                        }
                    } else if (zoom <= 0) {
                        b = 0;
                    } else {
                        sendMessageDelayed(obtainMessage(4353, message.obj), this.lgi ? 10 : 20);
                        z = false;
                        b = zoom;
                    }
                    parameters.setZoom(b);
                    try {
                        camera.setParameters(parameters);
                    } catch (Throwable e) {
                        x.printErrStackTrace("MicroMsg.SightCamera", e, "", new Object[0]);
                    }
                    if (z) {
                        this.lgl = 0;
                        this.lgm = 0;
                        sendMessageDelayed(obtainMessage(4354, message.obj), 20);
                        return;
                    }
                    return;
                }
                return;
            case 4354:
                camera = (Camera) message.obj;
                if (this.lgl == 0 || this.lgl == 0 || d.fS(14)) {
                    f(camera);
                    return;
                }
                float f = this.lgk;
                float f2 = this.kuY;
                int i = this.lgl;
                int i2 = this.lgm;
                if (camera == null) {
                    x.w("MicroMsg.SightCamera", "want to auto focus, but camera is null, do nothing");
                }
                if (lfY) {
                    lfY = false;
                    try {
                        x.i("MicroMsg.SightCamera", "ashutest:: touch %f %f, display %d %d", new Object[]{Float.valueOf(f), Float.valueOf(f2), Integer.valueOf(i), Integer.valueOf(i2)});
                        x.i("MicroMsg.SightCamera", "ashutest:: focus rect %s, meter rect %s", new Object[]{a(f, f2, 1.0f, i, i2), a(f, f2, 1.5f, i, i2)});
                        Parameters parameters2 = camera.getParameters();
                        List supportedFocusModes = parameters2.getSupportedFocusModes();
                        if (supportedFocusModes != null && supportedFocusModes.contains("auto")) {
                            parameters2.setFocusMode("auto");
                        }
                        if (parameters2.getMaxNumFocusAreas() > 0) {
                            supportedFocusModes = new ArrayList(1);
                            supportedFocusModes.add(new Area(r7, TbsLog.TBSLOG_CODE_SDK_BASE));
                            parameters2.setFocusAreas(supportedFocusModes);
                        }
                        if (parameters2.getMaxNumMeteringAreas() > 0) {
                            supportedFocusModes = new ArrayList(1);
                            supportedFocusModes.add(new Area(r2, TbsLog.TBSLOG_CODE_SDK_BASE));
                            parameters2.setMeteringAreas(supportedFocusModes);
                        }
                        camera.setParameters(parameters2);
                        camera.autoFocus(lfZ);
                        return;
                    } catch (Exception e2) {
                        x.w("MicroMsg.SightCamera", "autofocus with area fail, exception %s", new Object[]{e2.getMessage()});
                        lfY = true;
                        return;
                    }
                }
                x.w("MicroMsg.SightCamera", "auto focus not back");
                return;
            default:
                return;
        }
    }
}
