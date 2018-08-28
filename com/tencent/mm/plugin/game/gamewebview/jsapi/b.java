package com.tencent.mm.plugin.game.gamewebview.jsapi;

import com.tencent.mm.compatible.loader.c;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import junit.framework.Assert;

public class b {
    private String fEC;
    private Integer jGr;
    private Integer jGs;

    public b() {
        Assert.assertTrue("Must declare NAME and CTRL_BYTE in subclasses", true);
    }

    public final String getName() {
        if (bi.oW(this.fEC)) {
            try {
                this.fEC = (String) new c(this, "NAME", null).get();
            } catch (Throwable e) {
                x.e("MicroMsg.GameBaseJsApii", "getName exp = %s", new Object[]{bi.i(e)});
            }
        }
        return this.fEC;
    }

    public final int aSs() {
        return bi.a(aSt(), -1);
    }

    private Integer aSt() {
        if (this.jGr == null) {
            try {
                this.jGr = (Integer) new c(this, "CTRL_BYTE", null).get();
            } catch (Throwable e) {
                x.e("MicroMsg.GameBaseJsApii", "getCtrlByte exp = %s", new Object[]{bi.i(e)});
            }
        }
        return this.jGr;
    }

    public final int aSu() {
        return bi.a(aSv(), 0);
    }

    private Integer aSv() {
        if (this.jGs == null) {
            try {
                this.jGs = (Integer) new c(this, "DO_IN_ENV", null).get();
            } catch (Exception e) {
                this.jGs = null;
            }
        }
        return this.jGs;
    }
}
