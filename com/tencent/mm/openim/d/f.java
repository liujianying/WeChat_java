package com.tencent.mm.openim.d;

import android.database.Cursor;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.i;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.LinkedList;
import java.util.List;

public final class f extends i<e> {
    public static final String[] diD = new String[]{i.a(e.dhO, "OpenIMWordingInfo")};
    private e diF;

    public f(e eVar) {
        super(eVar, e.dhO, "OpenIMWordingInfo", null);
        this.diF = eVar;
    }

    public final boolean a(e eVar) {
        eVar.field_updateTime = bi.VE();
        return super.a(eVar);
    }

    public final List<String> x(int i, String str) {
        List<String> linkedList = new LinkedList();
        x.d("MicroMsg.OpenIMWordingInfoStg", "getLastWording sql:%s", new Object[]{" select wordingId from OpenIMWordingInfo where language='" + str + "' order by updateTime limit " + i});
        Cursor b = this.diF.b(r1, null, 2);
        if (b.moveToFirst()) {
            do {
                String string = b.getString(0);
                if (!bi.oW(string)) {
                    linkedList.add(string);
                }
            } while (b.moveToNext());
        }
        x.d("MicroMsg.OpenIMWordingInfoStg", "getLastWording result cnt: %d, language:%s", new Object[]{Integer.valueOf(linkedList.size()), str});
        b.close();
        return linkedList;
    }
}
