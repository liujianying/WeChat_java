package org.b.c;

import java.util.Collections;
import org.b.d.e;
import org.b.g.d;

public final class c implements b {
    public final String a(org.b.d.c cVar) {
        d.j(cVar, "Cannot extract base string from null object");
        if (cVar.vKu == null || cVar.vKu.size() <= 0) {
            throw new org.b.b.c(cVar);
        }
        String encode = org.b.g.c.encode(cVar.cKt().name());
        String encode2 = org.b.g.c.encode(cVar.cKy());
        e eVar = new e();
        eVar.a(cVar.cKs());
        eVar.a(cVar.cKx());
        eVar.a(new e(cVar.vKu));
        e eVar2 = new e(eVar.vKv);
        Collections.sort(eVar2.vKv);
        String encode3 = org.b.g.c.encode(eVar2.cKz());
        return String.format("%s&%s&%s", new Object[]{encode, encode2, encode3});
    }
}
