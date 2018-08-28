package com.tencent.mm.plugin.game.model;

import com.tencent.mm.plugin.game.d.ac;
import com.tencent.mm.plugin.game.d.bb;
import com.tencent.mm.plugin.game.d.w;
import com.tencent.mm.plugin.game.e.d;
import com.tencent.mm.sdk.platformtools.bi;
import java.util.Iterator;

public final class ai extends ac {
    public static void a(bb bbVar) {
        if (bbVar != null && !bi.cX(bbVar.jRH)) {
            Iterator it = bbVar.jRH.iterator();
            while (it.hasNext()) {
                ac acVar = (ac) it.next();
                if (acVar.jQv != null && acVar.jQv.jOV != null) {
                    d.a(a(acVar.jQv.jOV));
                } else if (acVar.jQx != null && !bi.cX(acVar.jQx.jPz)) {
                    Iterator it2 = acVar.jQx.jPz.iterator();
                    while (it2.hasNext()) {
                        d.a(a(((w) it2.next()).jOV));
                    }
                } else if (!(acVar.jQw == null || acVar.jQw.jOV == null)) {
                    d.a(a(acVar.jQw.jOV));
                }
            }
        }
    }
}
