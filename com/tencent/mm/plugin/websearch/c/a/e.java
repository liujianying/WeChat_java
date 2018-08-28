package com.tencent.mm.plugin.websearch.c.a;

import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.fts.a.a.l;
import com.tencent.mm.plugin.messenger.foundation.a.i;
import com.tencent.mm.storage.ab;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class e extends a<a> {
    public List<a> jte = Collections.emptyList();

    public e(String str) {
        super(str);
    }

    public final void cL(List<l> list) {
        this.jte = new ArrayList(list.size());
        for (l lVar : list) {
            ab Yg = ((i) g.l(i.class)).FR().Yg(lVar.jrv);
            a aVar = new a();
            aVar.userName = Yg.field_username;
            aVar.pNf = lVar.content;
            aVar.bgn = Yg.field_nickname;
            aVar.fky = Yg.field_conRemark;
            aVar.cCR = Yg.wM();
            aVar.desc = Yg.csT;
            this.jte.add(aVar);
        }
    }
}
