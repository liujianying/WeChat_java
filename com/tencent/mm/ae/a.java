package com.tencent.mm.ae;

import android.database.Cursor;
import com.tencent.mm.ac.d;
import com.tencent.mm.ac.z;
import com.tencent.mm.model.ah;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;
import java.util.List;

public final class a extends ah {
    public final boolean gV(int i) {
        return i != 0 && i < 604372991;
    }

    public final String getTag() {
        return "MicroMsg.App.BizInfoDataTransfer";
    }

    public final void transfer(int i) {
        x.d("MicroMsg.App.BizInfoDataTransfer", "the previous version is %d", new Object[]{Integer.valueOf(i)});
        if (i != 0 && i < 604372991) {
            h.mEJ.e(336, 12, 1);
            au.HU();
            com.tencent.mm.bt.h FO = c.FO();
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("select BizInfo.username, BizInfo.extInfo");
            stringBuilder.append(" from rcontact , BizInfo");
            stringBuilder.append(" where rcontact.username = BizInfo.username");
            stringBuilder.append(" and (rcontact.type & 1 ) != 0 ");
            stringBuilder.append(" and ( rcontact.verifyFlag & 8 ) != 0 ");
            String stringBuilder2 = stringBuilder.toString();
            List<String> arrayList = new ArrayList();
            x.d("MicroMsg.App.BizInfoDataTransfer", "sql %s", new Object[]{stringBuilder2});
            Cursor b = FO.b(stringBuilder.toString(), null, 2);
            if (b != null) {
                while (b.moveToNext()) {
                    d dVar = new d();
                    dVar.d(b);
                    if (dVar.bG(false).Mw() == 1) {
                        arrayList.add(dVar.field_username);
                    }
                }
                b.close();
            }
            if (arrayList.size() > 0) {
                stringBuilder = new StringBuilder();
                stringBuilder.append("Update BizInfo set type = 1 where 1 !=1 ");
                for (String append : arrayList) {
                    stringBuilder.append(" or username = '").append(append).append("'");
                }
                x.d("MicroMsg.App.BizInfoDataTransfer", "update sql %s", new Object[]{stringBuilder.toString()});
                z.MY().fV("BizInfo", append);
            }
        }
    }
}
