package com.tencent.mm.plugin.game.model;

import com.tencent.mm.bk.a;
import com.tencent.mm.plugin.game.d.as;
import com.tencent.mm.plugin.game.d.bh;
import com.tencent.mm.plugin.game.d.p;
import com.tencent.mm.sdk.platformtools.x;
import java.io.IOException;

public final class ag extends ac {
    private bh jNL;

    public ag(a aVar) {
        if (aVar == null) {
            this.jNL = new bh();
        } else {
            this.jNL = (bh) aVar;
        }
    }

    public ag(byte[] bArr) {
        this.jNL = new bh();
        if (bArr != null && bArr.length != 0) {
            try {
                this.jNL.aG(bArr);
            } catch (IOException e) {
                x.e("MicroMsg.GamePBDataDownloadGuidance", "Parsing Failed: %s", new Object[]{e.getMessage()});
            }
        }
    }

    public final p aUr() {
        return this.jNL != null ? this.jNL.jRU : null;
    }

    public final as aUs() {
        return this.jNL != null ? this.jNL.jRV : null;
    }
}
