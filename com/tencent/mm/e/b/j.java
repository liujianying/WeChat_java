package com.tencent.mm.e.b;

import com.tencent.mm.compatible.b.b.a;
import com.tencent.mm.compatible.util.b;
import com.tencent.mm.compatible.util.g;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.x;

public final class j {
    public static int bFx = 100;
    private b bFu = new b(ad.getContext());
    public b bFv = new b(a.daM);
    public a bFw = null;
    String fileName = "";
    public int status = 0;

    public final boolean de(String str) {
        g.a aVar = new g.a();
        if (this.fileName.length() > 0) {
            x.e("MicroMsg.SimpleVoiceRecorder", "Duplicate Call startRecord , maybe Stop Fail Before");
            return false;
        }
        this.fileName = str;
        try {
            this.bFu.requestFocus();
            this.bFv.a(new 1(this));
            this.bFv.wh();
            this.bFv.wi();
            this.bFv.wg();
            this.bFv.setOutputFile(this.fileName);
            this.bFv.setMaxDuration(3600010);
            this.bFv.prepare();
            this.bFv.start();
            x.d("MicroMsg.SimpleVoiceRecorder", "StartRecord File[" + this.fileName + "] start time:" + aVar.Ad());
            this.status = 1;
            return true;
        } catch (Exception e) {
            this.bFu.zY();
            x.e("MicroMsg.SimpleVoiceRecorder", "StartRecord File[" + this.fileName + "] ErrMsg[" + e.getMessage() + "]");
            this.status = -1;
            return false;
        }
    }

    public final boolean we() {
        this.bFu.zY();
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
            x.e("MicroMsg.SimpleVoiceRecorder", "StopRecord File[" + this.fileName + "] ErrMsg[" + e.getMessage() + "]");
            this.status = -1;
            return false;
        }
    }
}
