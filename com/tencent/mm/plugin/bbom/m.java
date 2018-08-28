package com.tencent.mm.plugin.bbom;

import com.tencent.mm.ac.a.e;
import com.tencent.mm.ac.f;
import com.tencent.mm.plugin.messenger.foundation.a.g;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.protocal.c.ato;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.storage.bd;

public final class m implements g, l {
    public final void a(ato ato, bd bdVar) {
        if (f.eZ(bdVar.field_talker)) {
            ato.rco = bdVar.cqb;
            if (bi.oW(ato.rco)) {
                ato.rco = e.lg(bdVar.cqb);
                return;
            }
            return;
        }
        ato.rco = bdVar.cqb;
    }

    public final String v(bd bdVar) {
        if (f.eZ(bdVar.field_talker)) {
            return e.Ir();
        }
        return null;
    }
}
