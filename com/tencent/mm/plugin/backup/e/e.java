package com.tencent.mm.plugin.backup.e;

import com.tencent.mm.plugin.backup.e.h.a;
import com.tencent.mm.plugin.backup.g.c;
import com.tencent.mm.plugin.backup.g.d;
import com.tencent.mm.plugin.backup.h.u;
import com.tencent.mm.plugin.messenger.foundation.a.a.f;
import com.tencent.mm.protocal.c.ey;
import com.tencent.mm.storage.bd;
import java.util.HashMap;
import java.util.LinkedList;

public final class e implements l {
    public final int a(ey eyVar, boolean z, bd bdVar, String str, LinkedList<u> linkedList, HashMap<Long, a> hashMap, boolean z2, long j) {
        return bdVar.field_content == null ? 0 : bdVar.field_content.getBytes().length;
    }

    public final int a(String str, ey eyVar, bd bdVar) {
        String str2 = new String(eyVar.rcl.siM);
        f FT = d.asG().asH().FT();
        bdVar.setContent(str2);
        switch (eyVar.hcE) {
            case 50:
                bdVar.setStatus(6);
                break;
        }
        if (bdVar.field_msgId == 0) {
            c.i(bdVar);
        } else {
            FT.b(eyVar.rcq, bdVar);
        }
        return 0;
    }
}
