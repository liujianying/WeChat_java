package com.tencent.mm.plugin.gallery.model;

import com.tencent.mm.plugin.gallery.model.g.a;
import com.tencent.mm.plugin.gallery.model.g.b;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.HashSet;

public final class l {
    private int fUn = 3;
    HashSet<a> jBj = new HashSet();
    public HashSet<b> jBk = new HashSet();
    g jBl;
    public int jBm = 1;

    public final void qt(int i) {
        this.jBm = i;
        aRH();
    }

    private void aRH() {
        x.i("MicroMsg.MediaQueryService", "initQueryType: %d", new Object[]{Integer.valueOf(this.jBm)});
        switch (this.jBm) {
            case 1:
                this.jBl = new i();
                return;
            case 2:
                this.jBl = new n();
                return;
            case 3:
                this.jBl = new h();
                return;
            default:
                this.jBl = new i();
                return;
        }
    }

    public final void qu(int i) {
        x.i("MicroMsg.MediaQueryService", "setQuerySource, %d, %s", new Object[]{Integer.valueOf(i), bi.cjd()});
        this.fUn = i;
    }

    public final int aRI() {
        x.i("MicroMsg.MediaQueryService", "getQuerySource, %d, %s", new Object[]{Integer.valueOf(this.fUn), bi.cjd()});
        return this.fUn;
    }

    public final int aRJ() {
        x.i("MicroMsg.MediaQueryService", "getQueryType, %d, %s", new Object[]{Integer.valueOf(this.jBm), bi.cjd()});
        return this.jBm;
    }

    public final void a(a aVar) {
        this.jBj.add(aVar);
    }

    public final void b(a aVar) {
        this.jBj.remove(aVar);
    }

    public final void aRK() {
        if (this.jBl == null) {
            x.f("MicroMsg.MediaQueryService", "media query not init, init again");
            aRH();
        }
        c.aRg().z(new 1(this));
    }

    public final void e(String str, int i, long j) {
        if (this.jBl == null) {
            x.f("MicroMsg.MediaQueryService", "media query not init, init again");
            aRH();
        }
        c.aRg().aRt().removeCallbacksAndMessages(null);
        this.jBl.aRA();
        e aRg = c.aRg();
        aRg.aRt().post(new 2(this, str, i, j));
    }
}
