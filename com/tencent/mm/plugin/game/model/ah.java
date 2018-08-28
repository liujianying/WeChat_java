package com.tencent.mm.plugin.game.model;

import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.game.a.b;
import com.tencent.mm.plugin.game.d.ag;
import com.tencent.mm.plugin.game.d.al;
import com.tencent.mm.plugin.game.d.bd;
import com.tencent.mm.plugin.game.d.bx;
import com.tencent.mm.plugin.game.d.dg;
import com.tencent.mm.plugin.game.e.d;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.x;
import java.io.IOException;

public final class ah extends ac {
    private bd jNM;
    public bx jNN;
    public a jNO;
    public ag jNP;
    public dg jNQ;
    public al jNR;

    public ah(bd bdVar) {
        if (bdVar == null) {
            this.jNM = new bd();
            return;
        }
        this.jNM = bdVar;
        fu(true);
    }

    public ah(byte[] bArr) {
        this.jNM = new bd();
        if (bArr != null && bArr.length != 0) {
            try {
                this.jNM.aG(bArr);
            } catch (IOException e) {
                x.e("MicroMsg.GamePBDataIndex4", "Parsing Failed: %s", new Object[]{e.getMessage()});
            }
            fu(false);
        }
    }

    private void fu(boolean z) {
        if (this.jNM != null) {
            this.jNN = this.jNM.jRR;
            if (!(this.jNM.jRO == null || this.jNM.jRO.jOV == null)) {
                this.jNO = new a();
                this.jNO.jNS = a(this.jNM.jRO.jOV);
                if (this.jNO.jNS != null) {
                    this.jNO.jNS.jLc = this.jNM.jRO.jOS;
                    this.jNO.jNS.scene = 10;
                    this.jNO.jNS.bYq = 1002;
                    this.jNO.jNS.position = 1;
                }
                this.jNO.jNT = this.jNM.jRO.jQE;
                this.jNO.jNU = this.jNM.jRO.jQD;
                this.jNO.desc = this.jNM.jRO.jOS;
                this.jNO.jNV = this.jNM.jRQ;
            }
            this.jNP = this.jNM.jRP;
            this.jNQ = this.jNM.jRS;
            this.jNR = this.jNM.jRT;
        }
        if (this.jNM != null && z) {
            if (!(this.jNM.jRO == null || this.jNM.jRO.jOV == null)) {
                d.a(a(this.jNM.jRO.jOV));
            }
            ((b) g.l(b.class)).aSf().init(ad.getContext());
        }
    }
}
