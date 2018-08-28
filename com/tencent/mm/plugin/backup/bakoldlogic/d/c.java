package com.tencent.mm.plugin.backup.bakoldlogic.d;

import com.tencent.mm.ak.g;
import com.tencent.mm.bt.h;
import com.tencent.mm.model.af;
import com.tencent.mm.model.b;
import com.tencent.mm.modelvideo.s;
import com.tencent.mm.plugin.messenger.foundation.a.a.f;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.pluginsdk.model.app.k;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.storage.ay;
import com.tencent.mm.storage.az;
import com.tencent.mm.storage.bn;
import com.tencent.mm.storage.emotion.d;
import com.tencent.mm.storage.x;

public final class c {
    String dqp;
    public h dqq = null;
    x gYC;
    ay gYD;
    f gYE;
    az gYF;
    g gYG;
    d gYH;
    public i gYI;
    s gYJ;
    af gYK;
    public k gYL;
    public com.tencent.mm.pluginsdk.model.app.i gYM;
    com.tencent.mm.pluginsdk.model.app.c gYN;
    bn hbn;
    com.tencent.mm.bt.g hbo = null;
    Boolean hbp = null;
    public int uin = 0;

    public final x DT() {
        if (this.uin != 0) {
            return this.gYC;
        }
        throw new b();
    }

    public final ay FR() {
        if (this.uin != 0) {
            return this.gYD;
        }
        throw new b();
    }

    public final f FT() {
        if (this.uin != 0) {
            return this.gYE;
        }
        throw new b();
    }

    public final az FW() {
        if (this.uin != 0) {
            return this.gYF;
        }
        throw new b();
    }

    public final g asD() {
        if (this.uin != 0) {
            return this.gYG;
        }
        throw new b();
    }

    public final d asE() {
        if (this.uin != 0) {
            return this.gYH;
        }
        throw new b();
    }

    public final s Ta() {
        if (this.uin != 0) {
            return this.gYJ;
        }
        throw new b();
    }

    public final String Gg() {
        if (this.uin != 0) {
            return this.dqp + "emoji/";
        }
        throw new b();
    }

    public final com.tencent.mm.pluginsdk.model.app.c asF() {
        if (this.uin != 0) {
            return this.gYN;
        }
        throw new b();
    }

    public final void ats() {
        com.tencent.mm.sdk.platformtools.x.i("MicroMsg.BakOldTempStorage", "closeDB isTempDb:%s datadb:%s memdb:%s %s", new Object[]{this.hbp, this.dqq, this.hbo, bi.cjd()});
        if (this.hbp == null || this.hbp.booleanValue()) {
            if (this.dqq != null) {
                com.tencent.mm.sdk.platformtools.x.i("MicroMsg.BakOldTempStorage", "closeDB true DB[%s]!!! ", new Object[]{this.dqq});
                this.dqq.closeDB();
                this.dqq = null;
            }
            if (this.hbo != null) {
                com.tencent.mm.bt.g gVar = this.hbo;
                com.tencent.mm.bt.g.tdI = bi.cjd().toString();
                if (gVar.tdk != null) {
                    gVar.tdk.close();
                    gVar.tdk = null;
                }
                this.hbo = null;
            }
            this.hbp = null;
            return;
        }
        this.hbp = null;
    }
}
