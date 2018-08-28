package com.tencent.xweb.xwalk.a;

import org.xwalk.core.XWalkInitializer;
import org.xwalk.core.XWalkUpdater.UpdateConfig;

public class c$a {
    static final /* synthetic */ boolean $assertionsDisabled = (!c.class.desiredAssertionStatus());
    public boolean bUseCdn;
    public String bxD;
    public long vFA;
    public String vFB;
    public int vFC;
    public String vFk;
    public String vFl;
    public String vFp;
    public boolean vFq;
    public int vFr;
    public long vFy;
    public boolean vFz;

    public final UpdateConfig cJw() {
        try {
            UpdateConfig updateConfig;
            if (this.vFz) {
                if (this.vFk != null && !this.vFk.isEmpty() && this.bxD != null && !this.bxD.isEmpty()) {
                    updateConfig = new UpdateConfig(this.bxD, true, this.vFk, this.vFp, this.vFr);
                } else if ($assertionsDisabled) {
                    updateConfig = new UpdateConfig(this.vFp, true, this.vFr);
                } else {
                    throw new AssertionError("royle:no md5 info, maybe something wrong");
                }
            } else if (this.vFk != null && !this.vFk.isEmpty()) {
                updateConfig = new UpdateConfig(this.vFk, false, null, this.vFp, this.vFr);
            } else if ($assertionsDisabled) {
                updateConfig = new UpdateConfig(this.vFp, false, this.vFr);
            } else {
                throw new AssertionError("royle:no md5 info, maybe something wrong");
            }
            updateConfig.versionDetail = this.vFB;
            updateConfig.bUseCdn = this.bUseCdn;
            return updateConfig;
        } catch (Exception e) {
            XWalkInitializer.addXWalkInitializeLog("create  UpdateConfig failed , args is not valid");
            c.a(null);
            return null;
        }
    }
}
