package com.tencent.mm.model;

import com.tencent.mm.sdk.platformtools.x;
import java.util.HashSet;
import java.util.Set;

public final class by {
    public boolean bgH = false;
    public Set<a> dDD = new HashSet();

    public interface a {
        boolean IS();
    }

    public final boolean a(a aVar) {
        if (!this.bgH) {
            return this.dDD.add(aVar);
        }
        x.e("MicroMsg.UninitForUEH", "add , is running , forbid add");
        return false;
    }

    public final boolean b(a aVar) {
        if (!this.bgH) {
            return this.dDD.remove(aVar);
        }
        x.e("MicroMsg.UninitForUEH", "remove , is running , forbid remove");
        return false;
    }
}
