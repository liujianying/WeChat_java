package com.tencent.mm.plugin.sns.storage;

import android.database.Cursor;
import com.tencent.mm.g.c.dz;
import com.tencent.mm.protocal.c.bhz;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;
import java.util.List;

public final class t extends dz {
    protected static a dhO;
    public int nJN;

    static {
        a aVar = new a();
        aVar.sKy = new Field[4];
        aVar.columns = new String[5];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.columns[0] = "tagId";
        aVar.sKA.put("tagId", "LONG default '0' ");
        stringBuilder.append(" tagId LONG default '0' ");
        stringBuilder.append(", ");
        aVar.columns[1] = "tagName";
        aVar.sKA.put("tagName", "TEXT default '' ");
        stringBuilder.append(" tagName TEXT default '' ");
        stringBuilder.append(", ");
        aVar.columns[2] = "count";
        aVar.sKA.put("count", "INTEGER default '0' ");
        stringBuilder.append(" count INTEGER default '0' ");
        stringBuilder.append(", ");
        aVar.columns[3] = "memberList";
        aVar.sKA.put("memberList", "TEXT default '' ");
        stringBuilder.append(" memberList TEXT default '' ");
        aVar.columns[4] = "rowid";
        aVar.sql = stringBuilder.toString();
        dhO = aVar;
    }

    protected final a AX() {
        return dhO;
    }

    public final void co(List<bhz> list) {
        this.field_memberList = "";
        for (bhz bhz : list) {
            this.field_memberList += bhz.siM + ",";
        }
    }

    public final void d(Cursor cursor) {
        super.d(cursor);
        this.nJN = (int) this.sKx;
    }
}
