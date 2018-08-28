package com.tencent.mm.plugin.backup.bakoldlogic.b;

import com.tencent.mm.plugin.backup.bakoldlogic.d.b;
import com.tencent.mm.plugin.backup.bakoldlogic.d.d;
import com.tencent.mm.plugin.backup.h.u;
import com.tencent.mm.plugin.wxpay.a$k;
import com.tencent.mm.protocal.c.ey;
import com.tencent.mm.storage.bd;
import java.util.LinkedList;

public final class f implements j {
    public final int a(ey eyVar, bd bdVar, LinkedList<u> linkedList) {
        return bdVar.field_content == null ? 0 : bdVar.field_content.getBytes().length;
    }

    public final int a(String str, ey eyVar, bd bdVar) {
        String str2 = new String(eyVar.rcl.siM);
        com.tencent.mm.plugin.messenger.foundation.a.a.f FT = b.atl().atm().FT();
        bdVar.setContent(str2);
        switch (eyVar.hcE) {
            case a$k.AppCompatTheme_buttonBarStyle /*50*/:
                bdVar.setStatus(6);
                break;
        }
        if (bdVar.field_msgId == 0) {
            d.i(bdVar);
        } else {
            FT.b(eyVar.rcq, bdVar);
        }
        return 0;
    }
}
