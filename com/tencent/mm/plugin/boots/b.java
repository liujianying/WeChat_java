package com.tencent.mm.plugin.boots;

import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.boots.a.a;
import com.tencent.mm.plugin.boots.a.c;
import com.tencent.mm.plugin.boots.a.e;
import java.util.List;

public final class b implements c {
    public final void nd(int i) {
        if (((e) g.n(e.class)).getTinkerLogic() != null) {
            ((e) g.n(e.class)).getTinkerLogic().c(i, false, 0);
        }
    }

    public final void ch(int i, int i2) {
        if (((e) g.n(e.class)).getTinkerLogic() != null) {
            ((e) g.n(e.class)).getTinkerLogic().c(i, true, i2);
        }
    }

    public final List<a> aua() {
        if (((e) g.n(e.class)).getTinkerLogic() != null) {
            return ((e) g.n(e.class)).getTinkerLogic().aua();
        }
        return null;
    }
}
