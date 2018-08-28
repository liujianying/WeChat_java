package com.tencent.mm.pluginsdk.ui.applet;

import com.tencent.mm.model.s;
import com.tencent.mm.pluginsdk.ui.applet.k.a;

class i$3 implements a {
    final /* synthetic */ i qIU;

    i$3(i iVar) {
        this.qIU = iVar;
    }

    public final void BZ(int i) {
        int i2 = 1;
        if (this.qIU.opw != null && this.qIU.qIM != null) {
            j jVar = this.qIU.qIM;
            int i3 = jVar.qJi ? (jVar.hNA || i != jVar.qJg + 2) ? 0 : 1 : (jVar.hNA || i != jVar.qJg + 1) ? 0 : 1;
            if (i3 == 0) {
                jVar = this.qIU.qIM;
                if (jVar.hNA || i != jVar.qJg) {
                    i3 = 0;
                } else {
                    i3 = 1;
                }
                if (i3 == 0) {
                    jVar = this.qIU.qIM;
                    if (jVar.hNA || i != jVar.qJg + 1) {
                        i2 = 0;
                    }
                    if (i2 != 0) {
                        if (!this.qIU.qIM.qJi) {
                            return;
                        }
                        if (s.fq(this.qIU.username)) {
                            this.qIU.opw.of(i);
                        } else {
                            this.qIU.qIM.Ca(0);
                        }
                    } else if (this.qIU.qIM.hNA && this.qIU.qIM.Cb(i)) {
                        this.qIU.opw.of(i);
                    } else if (this.qIU.qIM.hNA && !this.qIU.qIM.Cb(i)) {
                        this.qIU.opw.aAK();
                    } else if (!this.qIU.qIM.hNA && this.qIU.qIM.Cb(i)) {
                        this.qIU.opw.og(i);
                    }
                } else if (this.qIU.qIM.qJj) {
                    this.qIU.opw.oh(i);
                }
            }
        }
    }
}
