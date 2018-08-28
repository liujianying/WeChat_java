package com.tencent.mm.storage;

import android.database.Cursor;
import com.tencent.mm.protocal.c.uj;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.i;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;

public final class b extends i<a> {
    public static final String[] diD = new String[]{i.a(a.dhO, "ABTestInfo")};
    private e diF;

    public b(e eVar) {
        super(eVar, a.dhO, "ABTestInfo", null);
        this.diF = eVar;
    }

    public final void j(List<a> list, int i) {
        a aVar;
        Object obj = null;
        long VE = bi.VE();
        this.diF.delete("ABTestInfo", String.format(Locale.US, "%s<>0 and %s<%d", new Object[]{"endTime", "endTime", Long.valueOf(VE)}), null);
        if (1 == i) {
            aVar = new a();
            aVar.field_prioritylevel = 1;
            a(aVar, false, new String[]{"prioritylevel"});
        }
        for (a aVar2 : list) {
            boolean z;
            Object obj2;
            if (aVar2 == null || bi.oW(aVar2.field_abtestkey)) {
                x.e("MicroMsg.ABTestInfoStorage", "saveIfNecessary, Invalid item");
                z = false;
            } else {
                a aVar3 = new a();
                aVar3.field_abtestkey = aVar2.field_abtestkey;
                if (!super.b(aVar3, new String[0])) {
                    x.i("MicroMsg.ABTestInfoStorage", "Inserted: %s, Result: %b", new Object[]{aVar2.field_abtestkey, Boolean.valueOf(super.a(aVar2, false))});
                    z = r2;
                } else if ((aVar2.field_sequence <= aVar3.field_sequence || aVar2.field_prioritylevel != aVar3.field_prioritylevel) && aVar2.field_prioritylevel <= aVar3.field_prioritylevel) {
                    x.i("MicroMsg.ABTestInfoStorage", "Ignored: %s, Seq: %d, %d, PriorityLV: %d, %d", new Object[]{aVar2.field_abtestkey, Long.valueOf(aVar3.field_sequence), Long.valueOf(aVar2.field_sequence), Integer.valueOf(aVar3.field_prioritylevel), Integer.valueOf(aVar2.field_prioritylevel)});
                    z = false;
                } else {
                    x.i("MicroMsg.ABTestInfoStorage", "Updated: %s, Result: %b, Seq: %d, %d, PriorityLV: %d, %d", new Object[]{aVar2.field_abtestkey, Boolean.valueOf(super.b(aVar2, false, new String[0])), Long.valueOf(aVar3.field_sequence), Long.valueOf(aVar2.field_sequence), Integer.valueOf(aVar3.field_prioritylevel), Integer.valueOf(aVar2.field_prioritylevel)});
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

    public final LinkedList<uj> cko() {
        LinkedList<uj> linkedList = new LinkedList();
        Cursor axc = axc();
        if (axc != null) {
            if (axc.moveToFirst()) {
                a aVar = new a();
                do {
                    aVar.d(axc);
                    uj ujVar = new uj();
                    try {
                        ujVar.rvu = bi.getInt(aVar.field_expId, 0);
                    } catch (Exception e) {
                        x.e("MicroMsg.ABTestInfoStorage", "expId parse failed, %s", new Object[]{aVar.field_expId});
                    }
                    ujVar.priority = aVar.field_prioritylevel;
                    linkedList.add(ujVar);
                } while (axc.moveToNext());
                axc.close();
            } else {
                axc.close();
            }
        }
        return linkedList;
    }

    public final a XE(String str) {
        a aVar = new a();
        aVar.field_abtestkey = str;
        if (super.b(aVar, new String[0]) && aVar.field_endTime == 0) {
            aVar.field_endTime = Long.MAX_VALUE;
        }
        x.i("MicroMsg.ABTestInfoStorage", "getByLayerId, id: %s, return: %b", new Object[]{str, Boolean.valueOf(r1)});
        return aVar;
    }

    public final int da(String str, int i) {
        a XE = XE(str);
        if (XE.isValid()) {
            return bi.getInt(XE.field_value, i);
        }
        return i;
    }

    public final String getExpIdByKey(String str) {
        a XE = XE(str);
        if (XE.isValid()) {
            return XE.field_expId == null ? "" : XE.field_expId;
        } else {
            return "";
        }
    }

    public final String ckp() {
        Cursor axc = axc();
        if (axc == null) {
            return "null cursor!!";
        }
        if (axc.moveToFirst()) {
            StringBuilder stringBuilder = new StringBuilder();
            a aVar = new a();
            do {
                stringBuilder.append("============\n");
                aVar.d(axc);
                stringBuilder.append("abtestkey = ").append(aVar.field_abtestkey).append("\n");
                stringBuilder.append("sequence = ").append(aVar.field_sequence).append("\n");
                stringBuilder.append("priorityLV = ").append(aVar.field_prioritylevel).append("\n");
                stringBuilder.append("expId = ").append(aVar.field_expId).append("\n");
            } while (axc.moveToNext());
            axc.close();
            return stringBuilder.toString();
        }
        axc.close();
        return "cursor empty!!";
    }
}
