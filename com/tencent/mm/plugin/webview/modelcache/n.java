package com.tencent.mm.plugin.webview.modelcache;

import com.tencent.mm.compatible.util.e;
import com.tencent.mm.model.au;
import com.tencent.mm.model.bv.a;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.modelsfs.SFSContext.Builder;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.x;

public final class n {
    public final a pTc = new 1(this);
    public final c pTd = new 2(this);
    public final c pTe = new 3(this);

    public static void bUJ() {
        com.tencent.mm.model.c cVar = null;
        try {
            cVar = au.HU();
        } catch (Exception e) {
            x.e("MicroMsg.WebViewCacheSubCoreToolsExtension", "setupSFS, getAccStg, exception = %s", new Object[]{e});
        }
        if (cVar != null) {
            FileOp.mL(e.dgx + "sfs");
            FileOp.a(e.dgx, new Builder().setDBDirectory(com.tencent.mm.model.c.Gp() + "sfs").setStoragePath(e.dgx + "sfs").setName("wvcache"));
        }
    }
}
