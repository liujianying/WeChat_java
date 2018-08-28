package com.tencent.mm.plugin.appbrand.game.a;

import com.tencent.mm.plugin.appbrand.app.e;
import com.tencent.mm.plugin.appbrand.game.a.a.b;
import com.tencent.mm.plugin.fts.a.a.l;
import java.util.Comparator;

public final class h implements Comparator<l> {
    public static final h fAM = new h();

    public final /* synthetic */ int compare(Object obj, Object obj2) {
        l lVar = (l) obj;
        if (e.abo() != null) {
            b sO = e.abo().sO(lVar.jrv);
            if (sO != null && sO.field_isSync) {
                return 1;
            }
        }
        return -1;
    }
}
