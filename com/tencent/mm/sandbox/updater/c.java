package com.tencent.mm.sandbox.updater;

import android.os.Message;
import com.tencent.mm.compatible.util.f;
import com.tencent.mm.compatible.util.h;
import com.tencent.mm.protocal.c.bhp;
import com.tencent.mm.sandbox.b.a;
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.x;

public final class c extends com.tencent.mm.sandbox.monitor.c {
    private String bxD;
    private boolean dZm = false;
    private int htY = 0;
    private String knk;
    private a sDE;
    private String[] sDK;
    private a sDL = null;
    private boolean sDM = false;
    private ag sDN = new 1(this);
    private a sDO = new 3(this);

    static /* synthetic */ void a(c cVar, bhp bhp) {
        try {
            x.d("MicroMsg.NetSceneGetUpdatePackFromCDN", "in genNewAPKInNewThread()");
            e.post(new 2(cVar, bhp), "NetSceneGetUpdatePackFromCDN_genApk");
        } catch (Throwable e) {
            x.e("MicroMsg.NetSceneGetUpdatePackFromCDN", "exception in genNewAPKInNewThread()");
            x.printErrStackTrace("MicroMsg.NetSceneGetUpdatePackFromCDN", e, "", new Object[0]);
            Message obtain = Message.obtain();
            obtain.what = 1;
            obtain.arg1 = 3;
            obtain.obj = bhp;
            cVar.sDN.sendMessage(obtain);
        }
    }

    public c(int i, String str, int i2, String[] strArr, boolean z) {
        super(i, str, i2, z);
        this.sDK = strArr;
    }

    public c(int i, String str, int i2, String str2, String str3, String str4, boolean z) {
        super(i, str, i2, z);
        this.sDK = new String[]{str2};
        this.sDM = true;
        this.bxD = str3;
        this.knk = str4;
    }

    public final void a(a aVar) {
        this.sDE = aVar;
        if (!h.getExternalStorageState().equals("mounted")) {
            x.e("MicroMsg.NetSceneGetUpdatePackFromCDN", "SDCard not available.");
            aVar.a(-1, -1, null);
        } else if (this.dZm) {
            x.e("MicroMsg.NetSceneGetUpdatePackFromCDN", "netscene had been canceled.");
            aVar.a(-1, -1, null);
        } else if (cgM() || cgT() >= this.sDK.length) {
            x.e("MicroMsg.NetSceneGetUpdatePackFromCDN", "exceed max download url. url count = " + this.sDK.length);
            if (this.sDM) {
                aVar.a(1, -1, null);
            } else {
                aVar.a(-1, -1, null);
            }
        } else if (f.aM((long) this.sDj)) {
            this.sDL = new a(this, this.sDj, com.tencent.mm.a.e.cm(beJ()), this.sDO);
            this.sDL.execute(new String[]{this.sDK[cgT()]});
        } else {
            x.e("MicroMsg.NetSceneGetUpdatePackFromCDN", "SDCard full");
            if (this.sDM) {
                aVar.a(13, -1, null);
            } else {
                aVar.a(-1, -1, null);
            }
        }
    }

    protected final String beJ() {
        if (this.sDM) {
            return sDh + this.bxD + ".temp";
        }
        return super.beJ();
    }

    public final String cgL() {
        if (this.sDM) {
            return sDh + this.knk + ".apk";
        }
        return sDh + this.sDl + ".apk";
    }

    public final void cancel() {
        x.d("MicroMsg.NetSceneGetUpdatePackFromCDN", "cancel netscene");
        this.dZm = true;
        if (this.sDL != null && !this.sDL.isCancelled()) {
            this.sDL.cancel(true);
        }
    }

    private int cgT() {
        x.i("MicroMsg.NetSceneGetUpdatePackFromCDN", "requestCount=" + this.htY + ", curLinkIdx = " + (this.htY / 5));
        return this.htY / 5;
    }
}
