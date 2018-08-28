package com.tencent.mm.plugin.sns.model;

import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.storage.c;

public class AdLandingPagesProxy$b {
    private long lastUpdateTime = 0;
    public boolean nmv = false;

    public final void update() {
        boolean z = true;
        boolean z2 = bi.VG() - this.lastUpdateTime > 3600;
        if (AdLandingPagesProxy.bxi() != null) {
            if (z2) {
                AdLandingPagesProxy.nmp.nmv = AdLandingPagesProxy.bxi().isUseSnsDownloadImage();
                this.lastUpdateTime = bi.VG();
            }
        } else if (z2) {
            try {
                c fJ = com.tencent.mm.model.c.c.Jx().fJ("100348");
                if (fJ.isValid()) {
                    if (bi.getInt((String) fJ.ckq().get("downloadMode"), 0) != 1) {
                        z = false;
                    }
                    this.nmv = z;
                } else {
                    this.nmv = false;
                }
            } catch (Exception e) {
                this.nmv = false;
            }
            this.lastUpdateTime = bi.VG();
        }
    }
}
