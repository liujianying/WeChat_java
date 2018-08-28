package com.tencent.mm.pluginsdk.i;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.hardware.SensorManager;
import android.media.MediaRecorder;
import android.os.Looper;
import android.view.SurfaceHolder;
import com.tencent.mm.compatible.a.a;
import com.tencent.mm.compatible.e.d;
import com.tencent.mm.compatible.util.g;
import com.tencent.mm.sdk.platformtools.x;

public final class b {
    public Context context;
    public int elY;
    public int fileSize;
    public String filename;
    private boolean lft = false;
    public MediaRecorder lik;
    public a ngs;
    public f qDR;
    public int qDS = 0;
    private final int qDT = 5;
    private a qDU = new a(Looper.getMainLooper());

    @TargetApi(9)
    public final void setOrientationHint(int i) {
        a.a(9, new 1(this, i));
    }

    public final int a(Activity activity, boolean z) {
        int line;
        this.context = activity;
        f fVar = this.qDR;
        a aVar = this.ngs;
        if (aVar == null) {
            line = 0 - g.getLine();
        } else {
            fVar.qEb = aVar;
            if (fVar.bgR == null && fVar.lfy == null) {
                fVar.bgR = (SensorManager) activity.getSystemService("sensor");
                fVar.lfy = fVar.bgR.getDefaultSensor(1);
            }
            if (z || fVar.ddt == null) {
                fVar.bdL();
                if (z) {
                    f.lfv = (f.lfv ^ -1) & 1;
                }
                fVar.lfx = d.s(activity, f.lfv);
                if (fVar.lfx == null) {
                    x.e("MicroMsg.YuvReocrder", "start camera FAILED!");
                    line = 0 - g.getLine();
                } else {
                    fVar.ddt = fVar.lfx.ddt;
                    fVar.qEb.bYE = fVar.lfx.bYE;
                    if (fVar.ddt == null) {
                        x.e("MicroMsg.YuvReocrder", "start camera FAILED!");
                        line = 0 - g.getLine();
                    }
                }
            }
            line = 0;
        }
        if (line != 0) {
            return line;
        }
        return 0;
    }

    public final int ccP() {
        this.qDR.bdL();
        return 0;
    }

    public final int b(SurfaceHolder surfaceHolder) {
        return this.qDR.b(surfaceHolder);
    }

    public final int getPreviewWidth() {
        if (this.qDR.ddt == null) {
            return 0;
        }
        return this.qDR.ddt.getParameters().getPreviewSize().width;
    }

    public final int getPreviewHeight() {
        if (this.qDR.ddt == null) {
            return 0;
        }
        return this.qDR.ddt.getParameters().getPreviewSize().height;
    }
}
