package com.tencent.mm.plugin.game.model;

import com.tencent.mm.plugin.game.d.ab;
import com.tencent.mm.plugin.game.d.ax;
import com.tencent.mm.plugin.game.d.db;
import com.tencent.mm.plugin.game.e.c;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.io.IOException;

public class h {
    private static h jLM;
    public ax jLN;

    public static h aTL() {
        if (jLM == null) {
            synchronized (h.class) {
                if (jLM == null) {
                    jLM = new h();
                }
            }
        }
        return jLM;
    }

    public final void Zy() {
        c.Em().H(new 1(this));
    }

    private synchronized void ax(byte[] bArr) {
        if (!bi.bC(bArr)) {
            try {
                this.jLN = new ax();
                this.jLN.aG(bArr);
            } catch (IOException e) {
                this.jLN = null;
                x.e("MicroMsg.GameConfigManager", "Parsing Failed: %s", new Object[]{e.getMessage()});
            }
        }
        return;
    }

    public final ab aTM() {
        ab abVar = null;
        if (this.jLN != null) {
            abVar = this.jLN.jRq;
            if (abVar != null) {
                x.i("MicroMsg.GameConfigManager", "getGameDetailSettingControl jumpType:%d, jumpUrl:%s", new Object[]{Integer.valueOf(abVar.jQq), abVar.jOU});
            }
        } else {
            Zy();
        }
        return abVar;
    }

    public final db aTN() {
        if (this.jLN != null) {
            return this.jLN.jRs;
        }
        Zy();
        return null;
    }
}
