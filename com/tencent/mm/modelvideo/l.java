package com.tencent.mm.modelvideo;

import android.database.Cursor;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.i;
import java.util.LinkedList;
import java.util.List;

public final class l extends i<j> {
    public static final String[] diD = new String[]{i.a(j.dhO, "SightDraftInfo")};
    public e diF;

    public l(e eVar) {
        super(eVar, j.dhO, "SightDraftInfo", null);
        this.diF = eVar;
    }

    public final List<j> SV() {
        List linkedList = new LinkedList();
        String str = "SELECT * FROM SightDraftInfo WHERE fileStatus = ?  ORDER BY localId DESC " + new StringBuilder(" LIMIT 5").toString();
        Cursor b = this.diF.b(str, new String[]{"7"}, 2);
        if (b != null) {
            while (b.moveToNext()) {
                j jVar = new j();
                jVar.d(b);
                linkedList.add(jVar);
            }
            b.close();
        }
        return linkedList;
    }
}
