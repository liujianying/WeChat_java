package com.tencent.mm.plugin.appbrand.jsapi;

import com.tencent.mm.compatible.loader.c;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import junit.framework.Assert;

public abstract class b {
    private String fEC;
    private Integer fED;

    public b() {
        Assert.assertTrue("Must declare NAME and CTRL_INDEX in subclasses", true);
    }

    public final String getName() {
        if (bi.oW(this.fEC)) {
            try {
                this.fEC = (String) new c(this, "NAME", null).get();
            } catch (Throwable e) {
                x.e("MicroMsg.AppBrand.BaseJsApi", "getName exp = %s", new Object[]{bi.i(e)});
            }
        }
        return this.fEC;
    }

    public final int ahI() {
        return bi.a(ahJ(), -1);
    }

    private Integer ahJ() {
        if (this.fED == null) {
            try {
                this.fED = (Integer) new c(this, "CTRL_INDEX", null).get();
            } catch (Throwable e) {
                x.e("MicroMsg.AppBrand.BaseJsApi", "getCtrlIndex exp = %s", new Object[]{bi.i(e)});
            }
        }
        return this.fED;
    }
}
