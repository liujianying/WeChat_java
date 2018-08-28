package com.tencent.mm.storage;

import android.database.Cursor;
import com.tencent.mm.protocal.c.uj;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.i;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Map;

public final class d extends i<c> {
    public static final String[] diD = new String[]{i.a(c.dhO, "ABTestItem")};
    private final e diF;

    public d(e eVar) {
        super(eVar, c.dhO, "ABTestItem", null);
        this.diF = eVar;
    }

    public final c fJ(String str) {
        c cVar = new c();
        cVar.field_layerId = str;
        if (super.b(cVar, new String[0]) && cVar.field_endTime == 0) {
            cVar.field_endTime = Long.MAX_VALUE;
        }
        x.i("MicroMsg.ABTestStorage", "getByLayerId, id: %s, return: %b", str, Boolean.valueOf(r1));
        return cVar;
    }

    public final Map<String, c> XF(String str) {
        Cursor cursor;
        if (bi.oW(str)) {
            cursor = null;
        } else {
            cursor = rawQuery(String.format("select * from %s where %s = %s", new Object[]{"ABTestItem", "business", str}), new String[0]);
        }
        if (cursor == null || !cursor.moveToFirst()) {
            if (cursor != null) {
                cursor.close();
            }
            return new HashMap(0);
        }
        Map<String, c> hashMap = new HashMap();
        do {
            c cVar = new c();
            cVar.d(cursor);
            hashMap.put(cVar.field_layerId, cVar);
        } while (cursor.moveToNext());
        cursor.close();
        return hashMap;
    }

    public final void j(List<c> list, int i) {
        Object obj = null;
        long VE = bi.VE();
        this.diF.delete("ABTestItem", String.format(Locale.US, "%s<>0 and %s<%d", new Object[]{"endTime", "endTime", Long.valueOf(VE)}), null);
        if (i == 0) {
            c cVar = new c();
            cVar.field_prioritylevel = 1;
            a((c) cVar, false, "prioritylevel");
        }
        Iterator it = list.iterator();
        while (it.hasNext()) {
            boolean z;
            Object obj2;
            c cVar2 = (c) it.next();
            if (cVar2 == null || bi.oW(cVar2.field_layerId)) {
                x.e("MicroMsg.ABTestStorage", "saveIfNecessary, Invalid item");
                z = false;
            } else {
                c cVar3 = new c();
                cVar3.field_layerId = cVar2.field_layerId;
                if (!super.b(cVar3, new String[0])) {
                    x.i("MicroMsg.ABTestStorage", "Inserted: %s, Result: %b", cVar2.field_layerId, Boolean.valueOf(super.a(cVar2, false)));
                    z = r2;
                } else if ((cVar2.field_sequence <= cVar3.field_sequence || cVar2.field_prioritylevel != cVar3.field_prioritylevel) && cVar2.field_prioritylevel <= cVar3.field_prioritylevel) {
                    x.i("MicroMsg.ABTestStorage", "Ignored: %s, Seq: %d, %d, PriorityLV: %d, %d", cVar2.field_layerId, Long.valueOf(cVar3.field_sequence), Long.valueOf(cVar2.field_sequence), Integer.valueOf(cVar3.field_prioritylevel), Integer.valueOf(cVar2.field_prioritylevel));
                    z = false;
                } else {
                    x.i("MicroMsg.ABTestStorage", "Updated: %s, Result: %b, Seq: %d, %d, PriorityLV: %d, %d", cVar2.field_layerId, Boolean.valueOf(super.b(cVar2, false, new String[0])), Long.valueOf(cVar3.field_sequence), Long.valueOf(cVar2.field_sequence), Integer.valueOf(cVar3.field_prioritylevel), Integer.valueOf(cVar2.field_prioritylevel));
                    z = r2;
                }
            }
            if (z) {
                obj2 = 1;
            } else {
                obj2 = obj;
            }
            obj = obj2;
        }
        if (obj != null) {
            Xp("event_updated");
        }
    }

    public final String ckp() {
        Cursor axc = axc();
        if (axc == null) {
            return "null cursor!!";
        }
        if (axc.moveToFirst()) {
            StringBuilder stringBuilder = new StringBuilder();
            c cVar = new c();
            do {
                stringBuilder.append("============\n");
                cVar.d(axc);
                stringBuilder.append("layerId = ").append(cVar.field_layerId).append("\n");
                stringBuilder.append("sequence = ").append(cVar.field_sequence).append("\n");
                stringBuilder.append("priorityLV = ").append(cVar.field_prioritylevel).append("\n");
                stringBuilder.append("expId = ").append(cVar.field_expId).append("\n");
            } while (axc.moveToNext());
            axc.close();
            return stringBuilder.toString();
        }
        axc.close();
        return "cursor empty!!";
    }

    public final LinkedList<uj> cko() {
        LinkedList<uj> linkedList = new LinkedList();
        Cursor axc = axc();
        if (axc != null && axc.moveToFirst()) {
            c cVar = new c();
            do {
                cVar.d(axc);
                uj ujVar = new uj();
                try {
                    ujVar.rvu = bi.getInt(cVar.field_expId, 0);
                } catch (Exception e) {
                    x.e("MicroMsg.ABTestStorage", "expId parse failed, %s", cVar.field_expId);
                }
                ujVar.priority = cVar.field_prioritylevel;
                linkedList.add(ujVar);
            } while (axc.moveToNext());
            axc.close();
        }
        return linkedList;
    }
}
