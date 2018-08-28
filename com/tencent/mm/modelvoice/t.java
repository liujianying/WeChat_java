package com.tencent.mm.modelvoice;

import com.tencent.mm.ab.i;
import com.tencent.mm.compatible.util.g;
import com.tencent.mm.e.b.a;
import com.tencent.mm.e.b.b;
import com.tencent.mm.sdk.platformtools.x;

public final class t implements a {
    private static int bFx = 100;
    private b bFv;
    private i.a epV = null;
    String fileName = "";
    private int status = 0;

    public final int getStatus() {
        return this.status;
    }

    public final int wf() {
        b bVar = this.bFv;
        return ((bVar.bDq == com.tencent.mm.compatible.b.b.a.daL || bVar.bDq == com.tencent.mm.compatible.b.b.a.daN) && bVar.bDp != null) ? bVar.bDp.bEg : 1;
    }

    public final void a(i.a aVar) {
        this.epV = aVar;
    }

    public t(com.tencent.mm.compatible.b.b.a aVar) {
        this.bFv = new b(aVar);
    }

    public final boolean dc(String str) {
        g.a aVar = new g.a();
        if (this.fileName.length() > 0) {
            x.e("VoiceRecorder", "Duplicate Call startRecord , maybe Stop Fail Before");
            return false;
        }
        this.fileName = str;
        try {
            this.bFv.a(new 1(this));
            this.bFv.wh();
            this.bFv.wi();
            this.bFv.wg();
            this.bFv.setOutputFile(this.fileName);
            this.bFv.setMaxDuration(70000);
            this.bFv.prepare();
            this.bFv.start();
            x.d("VoiceRecorder", "StartRecord File[" + this.fileName + "] start time:" + aVar.Ad());
            this.status = 1;
            return true;
        } catch (Exception e) {
            x.e("VoiceRecorder", "StartRecord File[" + this.fileName + "] ErrMsg[" + e.getMessage() + "]");
            this.status = -1;
            return false;
        }
    }

    public final boolean we() {
        if (this.bFv == null) {
            return true;
        }
        try {
            this.bFv.wk();
            this.bFv.release();
            this.fileName = "";
            this.status = 0;
            return true;
        } catch (Exception e) {
            x.e("VoiceRecorder", "StopRecord File[" + this.fileName + "] ErrMsg[" + e.getMessage() + "]");
            this.status = -1;
            return false;
        }
    }

    public final int getMaxAmplitude() {
        if (this.status != 1) {
            return 0;
        }
        int maxAmplitude = this.bFv.getMaxAmplitude();
        if (maxAmplitude > bFx) {
            bFx = maxAmplitude;
        }
        return (maxAmplitude * 100) / bFx;
    }
}
