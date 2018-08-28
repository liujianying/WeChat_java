package com.tencent.mm.plugin.appbrand.game.c;

import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.x;
import java.util.Random;

public enum i {
    ;
    
    public ah fCb;
    public final f fCc;
    public final g fCd;
    public final h fCe;
    public e fCf;
    public Boolean fCg;
    public boolean fCh;
    public volatile boolean fCi;
    public long fCj;
    public String mAppId;

    private i(String str) {
        this.fCb = null;
        this.fCc = new f();
        this.fCd = new g();
        this.fCe = new h();
        this.fCg = null;
        this.fCh = false;
        this.fCi = false;
    }

    public static boolean b(int i, double d) {
        boolean z;
        x.i("MicroMsg.WAGamePerfManager", "WAGamePerfManager.shouldEnableReport gamePercentage = [%f]", Double.valueOf(d));
        if (new Random(((long) i) ^ System.nanoTime()).nextDouble() <= d) {
            z = true;
        } else {
            z = false;
        }
        x.i("MicroMsg.WAGamePerfManager", "shouldEnableReport() returned: [%b], localRandom = [%f] serverPercent = [%f]", Boolean.valueOf(z), Double.valueOf(r4), Double.valueOf(d));
        return z;
    }

    public final h agv() {
        h hVar;
        synchronized (fCa) {
            if (this.fCi) {
                hVar = this.fCe;
            } else {
                hVar = null;
            }
        }
        return hVar;
    }

    public final f agw() {
        f fVar;
        synchronized (fCa) {
            if (this.fCi && this.fCh) {
                fVar = this.fCc;
            } else {
                fVar = null;
            }
        }
        return fVar;
    }

    public final g agx() {
        g gVar;
        synchronized (fCa) {
            if (this.fCi) {
                gVar = this.fCd;
            } else {
                gVar = null;
            }
        }
        return gVar;
    }

    public final ah agy() {
        if (this.fCb == null) {
            this.fCb = new ah("WAGamePerfManager_thread");
        }
        return this.fCb;
    }
}
