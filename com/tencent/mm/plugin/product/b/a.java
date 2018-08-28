package com.tencent.mm.plugin.product.b;

import com.tencent.mm.g.a.lz;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

public final class a extends c<lz> {
    public a() {
        this.sFo = lz.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        String str = null;
        lz lzVar = (lz) bVar;
        switch (lzVar.bWu.opType) {
            case 1:
                com.tencent.mm.plugin.product.a.a.bmF();
                c bmG = com.tencent.mm.plugin.product.a.a.bmG();
                if (bmG != null) {
                    m b = m.b(null, lzVar.bWu.bWw);
                    bmG.a(b, null);
                    lzVar.bWv.bWx = bmG.bmY();
                    lz.b bVar2 = lzVar.bWv;
                    if (!bi.oW(b.bnb())) {
                        str = com.tencent.mm.plugin.product.ui.c.JC(b.bnb());
                    }
                    bVar2.bOX = str;
                    lzVar.bWv.bJm = true;
                    break;
                }
                x.w("MicroMsg.MallProductListener", "error, xml[%s] can not parse", new Object[]{lzVar.bWu.bWw});
                lzVar.bWv.bJm = false;
                break;
        }
        return false;
    }
}
