package com.tencent.mm.plugin.remittance.b;

import android.database.Cursor;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.i;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.HashMap;
import java.util.Map;

public final class d extends i<c> {
    public static final String[] diD = new String[]{i.a(c.dhO, "RemittanceRecord")};
    private static final String[] eBa = new String[]{"*", "rowid"};
    public static Map<String, c> eBb = new HashMap();
    private e diF;

    public final /* synthetic */ boolean a(c cVar, String[] strArr) {
        c cVar2 = (c) cVar;
        if (cVar2 != null && eBb.containsKey(cVar2.field_transferId)) {
            eBb.remove(cVar2.field_transferId);
        }
        return super.a(cVar2, strArr);
    }

    public final /* synthetic */ boolean b(c cVar) {
        c cVar2 = (c) cVar;
        if (cVar2 != null && eBb.containsKey(cVar2.field_transferId)) {
            eBb.put(cVar2.field_transferId, cVar2);
        }
        return super.b(cVar2);
    }

    public d(e eVar) {
        super(eVar, c.dhO, "RemittanceRecord", null);
        this.diF = eVar;
    }

    public final c Kx(String str) {
        if (bi.oW(str)) {
            return null;
        }
        Cursor a = this.diF.a("RemittanceRecord", eBa, "transferId=?", new String[]{str}, null, null, null, 2);
        c cVar;
        try {
            if (a.moveToFirst()) {
                cVar = new c();
                cVar.d(a);
                return cVar;
            }
            a.close();
            return null;
        } catch (Exception e) {
            cVar = e;
            x.printErrStackTrace("MicroMsg.RemittanceSendRecordStorage", cVar, "getRecordByTransferId error: %s", new Object[]{cVar.getMessage()});
            return null;
        } finally {
            a.close();
        }
    }

    public final boolean a(c cVar) {
        if (cVar != null && eBb.containsKey(cVar.field_transferId)) {
            eBb.put(cVar.field_transferId, cVar);
        }
        return super.a(cVar);
    }
}
