package com.tencent.mm.y;

import com.tencent.mm.storage.bd;

public final class h {
    public static int g(bd bdVar) {
        if (!bdVar.aQm()) {
            return 0;
        }
        g$a J = g$a.J(bdVar.field_content, bdVar.field_reserved);
        if (J == null) {
            return 0;
        }
        return J.type;
    }
}
