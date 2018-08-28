package com.tencent.mm.plugin.websearch.c.a;

import com.tencent.mm.plugin.fts.a.a.l;
import java.util.List;

public abstract class a<T> {
    protected String bWm;
    protected int pMZ = Integer.MAX_VALUE;

    public abstract void cL(List<l> list);

    public a(String str) {
        this.bWm = str;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        boolean z;
        if (this.bWm == aVar.bWm || (this.bWm != null && this.bWm.equalsIgnoreCase(aVar.bWm))) {
            z = true;
        } else {
            z = false;
        }
        if (aVar.pMZ == this.pMZ && z) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return super.hashCode();
    }
}
