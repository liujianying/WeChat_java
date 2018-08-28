package com.tencent.mm.ae;

import android.database.Cursor;
import com.tencent.mm.model.ah;
import com.tencent.mm.model.au;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.ab;
import java.util.LinkedList;
import java.util.List;

public final class c extends ah {
    public final boolean gV(int i) {
        return i != 0 && i < 620757033;
    }

    public final void transfer(int i) {
        x.d("MicroMsg.DataTransfer.BlackListConvDataTransfer", "the previous version is %d", new Object[]{Integer.valueOf(i)});
        if (i != 0 && i < 620757033) {
            h.mEJ.e(336, 13, 1);
            List<String> linkedList = new LinkedList();
            au.HU();
            Cursor d = com.tencent.mm.model.c.FR().d("@black.android", "", null);
            if (d != null) {
                d.moveToFirst();
                while (!d.isAfterLast()) {
                    ab abVar = new ab();
                    abVar.d(d);
                    linkedList.add(abVar.field_username);
                    d.moveToNext();
                }
                d.close();
            }
            if (linkedList.size() > 0) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Update rconversation");
                stringBuilder.append(" set parentRef = '@blacklist' where 1 != 1 ");
                for (String append : linkedList) {
                    stringBuilder.append(" or username = '").append(append).append("'");
                }
                x.d("MicroMsg.DataTransfer.BlackListConvDataTransfer", "update sql: %s", new Object[]{stringBuilder.toString()});
                au.HU();
                com.tencent.mm.model.c.FO().fV("rconversation", append);
            }
        }
    }

    public final String getTag() {
        return "MicroMsg.DataTransfer.BlackListConvDataTransfer";
    }
}
