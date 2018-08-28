package com.tencent.mm.plugin.mmsight.model;

import android.graphics.Rect;
import android.graphics.RectF;
import android.hardware.Camera;
import android.hardware.Camera.Area;
import android.hardware.Camera.Parameters;
import android.os.Looper;
import android.os.Message;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.smtt.utils.TbsLog;
import java.util.ArrayList;
import java.util.List;

class e$c extends ag {
    public float kuY;
    boolean lft = false;
    final /* synthetic */ e lgc;
    int lgh = 0;
    boolean lgi = false;
    boolean lgj = false;
    public float lgk;
    public int lgl;
    public int lgm;

    private static Rect a(float f, float f2, float f3, int i, int i2) {
        float f4 = 80.0f * f3;
        float f5 = (((f / ((float) i)) * 2000.0f) - 1000.0f) - (f4 / 2.0f);
        float f6 = (((f2 / ((float) i2)) * 2000.0f) - 1000.0f) - (f4 / 2.0f);
        float f7 = f5 + f4;
        f4 += f6;
        RectF rectF = new RectF();
        rectF.set(f5, f6, f7, f4);
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

    final void e(Camera camera) {
        if (camera == null) {
            x.w("MicroMsg.MMSightCamera", "want to auto focus, but camera is null, do nothing");
        } else if (e.lfY) {
            e.lfY = false;
            try {
                x.i("MicroMsg.MMSightCamera", "triggerAutoFocus");
                camera.cancelAutoFocus();
                camera.autoFocus(this.lgc.lfZ);
            } catch (Exception e) {
                x.w("MicroMsg.MMSightCamera", "autofocus fail, exception %s", new Object[]{e.getMessage()});
                e.lfY = true;
            }
        } else {
            x.w("MicroMsg.MMSightCamera", "auto focus not back");
        }
    }

    public e$c(e eVar, Looper looper) {
        this.lgc = eVar;
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
            x.e("MicroMsg.MMSightCamera", "get target zoom value error: %s", new Object[]{e.getMessage()});
            maxZoom = 0;
        }
        return maxZoom;
    }

    public final void handleMessage(Message message) {
        boolean z = true;
        Camera camera;
        int zoom;
        switch (message.what) {
            case 4353:
                if (!this.lgj) {
                    int b;
                    camera = (Camera) message.obj;
                    Parameters parameters = camera.getParameters();
                    x.i("MicroMsg.MMSightCamera", "zoomed %s curZoomStep %s params.getZoom() %s", new Object[]{Boolean.valueOf(this.lft), Integer.valueOf(this.lgh), Integer.valueOf(parameters.getZoom())});
                    zoom = parameters.getZoom() + this.lgh;
                    if (this.lft) {
                        b = b(parameters);
                        if (zoom < b) {
                            sendMessageDelayed(obtainMessage(4353, message.obj), this.lgi ? 10 : 20);
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
                    } catch (Exception e) {
                    }
                    if (z) {
                        this.lgl = 0;
                        this.lgm = 0;
                        return;
                    }
                    return;
                }
                return;
            case 4354:
                camera = (Camera) message.obj;
                if (this.lgl == 0 || this.lgm == 0 || d.fS(14)) {
                    e(camera);
                    return;
                }
                float f = this.lgk;
                float f2 = this.kuY;
                zoom = this.lgl;
                int i = this.lgm;
                if (camera == null) {
                    x.w("MicroMsg.MMSightCamera", "want to auto focus, but camera is null, do nothing");
                    return;
                } else if (e.lfY) {
                    e.lfY = false;
                    try {
                        camera.cancelAutoFocus();
                        x.i("MicroMsg.MMSightCamera", "ashutest:: touch %f %f, display %d %d", new Object[]{Float.valueOf(f), Float.valueOf(f2), Integer.valueOf(zoom), Integer.valueOf(i)});
                        x.i("MicroMsg.MMSightCamera", "ashutest:: focus rect %s, meter rect %s", new Object[]{a(f, f2, 1.0f, zoom, i), a(f, f2, 1.5f, zoom, i)});
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
                        camera.autoFocus(this.lgc.lfZ);
                        return;
                    } catch (Exception e2) {
                        x.w("MicroMsg.MMSightCamera", "autofocus with area fail, exception %s", new Object[]{e2.getMessage()});
                        e.lfY = true;
                        return;
                    }
                } else {
                    x.w("MicroMsg.MMSightCamera", "auto focus not back");
                    return;
                }
            default:
                return;
        }
    }
}
