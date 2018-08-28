package com.tencent.mm.pluginsdk.model.app;

import android.database.Cursor;
import com.tencent.mm.g.c.r;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.i;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;
import java.util.List;

public final class o extends i<r> {
    public static final String[] diD = new String[]{i.a(n.dhO, "AppSort")};
    public e diF;

    public o(e eVar) {
        super(eVar, n.dhO, "AppSort", null);
        this.diF = eVar;
        eVar.fV("AppSort", "CREATE INDEX IF NOT EXISTS flagIdIndex ON AppSort ( flag )");
        eVar.fV("AppSort", "CREATE INDEX IF NOT EXISTS flagIdIndex ON AppSort ( sortId )");
    }

    public final List<String> fL(long j) {
        List<String> arrayList = new ArrayList();
        StringBuilder stringBuilder = new StringBuilder(256);
        stringBuilder.append("select * from AppSort");
        stringBuilder.append(" where ");
        stringBuilder.append("flag = ").append(j);
        stringBuilder.append(" order by sortId desc ");
        Cursor rawQuery = rawQuery(stringBuilder.toString(), new String[0]);
        if (rawQuery == null) {
            x.e("MicroMsg.AppSortStorage", "getAppListByFlag : cursor is null");
            return null;
        }
        x.d("MicroMsg.AppSortStorage", "getAppListByFlag count = %d", Integer.valueOf(rawQuery.getCount()));
        int columnIndex = rawQuery.getColumnIndex("appId");
        while (rawQuery.moveToNext()) {
            arrayList.add(rawQuery.getString(columnIndex));
        }
        rawQuery.close();
        return arrayList;
    }

    public final boolean a(n nVar) {
        return super.b((c) nVar);
    }
}
