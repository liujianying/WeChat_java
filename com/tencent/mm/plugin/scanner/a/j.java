package com.tencent.mm.plugin.scanner.a;

import com.tencent.mm.g.a.lz;
import com.tencent.mm.plugin.scanner.util.n.a;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.x;

public final class j extends c<lz> {
    public j() {
        this.sFo = lz.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        lz lzVar = (lz) bVar;
        switch (lzVar.bWu.opType) {
            case 0:
                a bY = i.bY(lzVar.bWu.bWw, 0);
                if (bY != null) {
                    lzVar.bWv.bWx = i.a(lzVar.bWu.context, bY);
                    lzVar.bWv.bOX = com.tencent.mm.plugin.scanner.c.brY().eq(bY.field_thumburl, "@S");
                    lzVar.bWv.bJm = true;
                    break;
                }
                x.w("MicroMsg.ProductOperationListener", "error, xml[%s] can not parse", new Object[]{lzVar.bWu.bWw});
                lzVar.bWv.bJm = false;
                break;
        }
        return false;
    }
}
