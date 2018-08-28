package com.tencent.mm.modelappbrand;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class v implements u {
    private f dFI;
    protected Map<String, k> dFJ = new HashMap();

    public v(f fVar) {
        this.dFI = fVar;
    }

    public v(u uVar) {
        if (uVar != null) {
            this.dFI = uVar.JX();
            a(uVar);
        }
    }

    private void a(u uVar) {
        for (k a : uVar.JY()) {
            a(a);
        }
    }

    public final f JX() {
        return this.dFI;
    }

    public final <T> T jr(String str) {
        return this.dFJ.get(str);
    }

    public final void a(k kVar) {
        this.dFJ.put(kVar.getName(), kVar);
    }

    public final List<k> JY() {
        return new ArrayList(this.dFJ.values());
    }
}
