package com.tencent.mm.plugin.fts.b;

import android.database.Cursor;
import com.tencent.mm.plugin.fts.a.a.a;
import com.tencent.mm.plugin.fts.a.a.f;
import com.tencent.mm.plugin.fts.a.a.k;
import com.tencent.mm.plugin.fts.a.a.l;
import com.tencent.mm.plugin.fts.a.c;
import com.tencent.mm.plugin.fts.c.e;
import com.tencent.mm.sdk.platformtools.x;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map.Entry;

class e$c extends a {
    private String bWm;
    private HashMap<String, String> jqH;
    final /* synthetic */ e juS;
    private l juT;
    private int scene;

    private e$c(e eVar) {
        this.juS = eVar;
    }

    /* synthetic */ e$c(e eVar, byte b) {
        this(eVar);
    }

    public final boolean execute() {
        e eVar = this.juS.juO;
        String str = this.bWm;
        l lVar = this.juT;
        int i = this.scene;
        HashMap hashMap = this.jqH;
        Object trim = str.trim();
        hashMap.remove(lVar.jrv);
        boolean inTransaction = eVar.jpT.inTransaction();
        if (!inTransaction) {
            eVar.jpT.beginTransaction();
        }
        long currentTimeMillis = System.currentTimeMillis();
        if ((lVar.type == 131072 || lVar.type == 131075) && e.CL(lVar.jrv)) {
            x.i("MicroMsg.FTS.FTS5TopHitsStorage", "last contact msg time older than 60 days");
        } else {
            int i2;
            int i3;
            int i4;
            int i5;
            Cursor rawQuery = eVar.jpT.rawQuery(String.format("SELECT docid, score FROM %s WHERE query=? AND aux_index=? AND subtype = ? AND scene=?;", new Object[]{eVar.aPU()}), new String[]{trim, lVar.jrv, String.valueOf(lVar.jru), String.valueOf(i)});
            if (rawQuery.moveToNext()) {
                i2 = rawQuery.getInt(0);
                i3 = rawQuery.getInt(1);
                i4 = i2;
            } else {
                i3 = -1;
                i4 = -1;
            }
            rawQuery.close();
            String str2 = "";
            for (Entry entry : hashMap.entrySet()) {
                str2 = !((String) entry.getValue()).equals("​chatroom_tophits") ? str2 + "'" + ((String) entry.getKey()) + "'," : str2;
            }
            if (str2.length() > 0) {
                str = "AND aux_index IN (" + str2.substring(0, str2.length() - 1) + ")";
                eVar.jpT.execSQL(String.format("UPDATE %s SET score=CASE WHEN score > 6 THEN 6 WHEN score > 2 THEN (score - 1) ELSE score END WHERE scene = %d %s;", new Object[]{eVar.aPU(), Integer.valueOf(i), str}));
            }
            str2 = "";
            for (Entry entry2 : hashMap.entrySet()) {
                str2 = ((String) entry2.getValue()).equals("​chatroom_tophits") ? str2 + "'" + ((String) entry2.getKey()) + "'," : str2;
            }
            if (str2.length() > 0) {
                str = "AND aux_index IN(" + str2.substring(0, str2.length() - 1) + ")";
                eVar.jpT.execSQL(String.format("UPDATE %s SET score=CASE WHEN score = 1 THEN 0 WHEN score < 5 THEN (score - 1) ELSE 4 END WHERE query = ? AND scene = %d %s;", new Object[]{eVar.aPU(), Integer.valueOf(i), str}), new String[]{"​chatroom_tophits"});
            }
            if (i4 < 0 || i3 < 0) {
                eVar.jvm.bindString(1, lVar.content);
                eVar.jvm.execute();
                eVar.jvn.bindLong(1, (long) lVar.type);
                eVar.jvn.bindLong(2, (long) lVar.jru);
                eVar.jvn.bindLong(3, lVar.jsA);
                eVar.jvn.bindString(4, lVar.jrv);
                eVar.jvn.bindLong(5, currentTimeMillis);
                eVar.jvn.bindString(6, trim);
                eVar.jvn.bindLong(7, 3);
                eVar.jvn.bindLong(8, (long) i);
                eVar.jvn.bindString(9, lVar.content);
                eVar.jvn.execute();
            } else {
                i5 = i3 > 6 ? i3 + 1 : i3 + 3;
                eVar.jpT.execSQL(String.format("UPDATE %s SET score=?, timestamp=? WHERE docid=?", new Object[]{eVar.aPU()}), new String[]{String.valueOf(i5), String.valueOf(currentTimeMillis), String.valueOf(i4)});
            }
            if (!inTransaction) {
                eVar.jpT.commit();
            }
            String[] split = c.a.jqE.split(trim);
            if (split.length > 1 && lVar.type == 131075 && lVar.jru == 38) {
                HashSet hashSet = new HashSet();
                k kVar = new k();
                Cursor rawQuery2 = eVar.jpT.rawQuery(String.format("SELECT docid, query, score, scene, aux_index, entity_id, type, subtype, timestamp, meta_content FROM %s WHERE aux_index=? AND query=?;", new Object[]{eVar.aPU()}), new String[]{lVar.jrv, "​chatroom_tophits"});
                if (rawQuery2.moveToNext()) {
                    kVar.d(rawQuery2);
                    for (Object add : c.a.jqA.split(kVar.jsB)) {
                        hashSet.add(add);
                    }
                }
                rawQuery2.close();
                i5 = 0;
                while (true) {
                    i2 = i5;
                    if (i2 >= lVar.jsH.size() || i2 >= split.length) {
                        x.i("MicroMsg.FTS.FTS5TopHitsStorage", "update tophits content=%s", new Object[]{kVar.jsB});
                    } else {
                        f fVar = (f) lVar.jsH.get(i2);
                        if (hashSet.add(fVar.content)) {
                            kVar.jsB += fVar.content + "​";
                        }
                        i5 = i2 + 1;
                    }
                }
                x.i("MicroMsg.FTS.FTS5TopHitsStorage", "update tophits content=%s", new Object[]{kVar.jsB});
                if (kVar.jsy > 0) {
                    eVar.g(Long.valueOf(kVar.jsy));
                }
                kVar.jsy = 0;
                kVar.bWm = "​chatroom_tophits";
                kVar.jsz++;
                kVar.dDS = (long) i;
                kVar.jrv = lVar.jrv;
                kVar.jsA = lVar.jsA;
                kVar.type = lVar.type;
                kVar.jru = lVar.jru;
                kVar.timestamp = currentTimeMillis;
                eVar.jvm.bindString(1, kVar.jsB);
                eVar.jvm.execute();
                eVar.jvn.bindLong(1, (long) kVar.type);
                eVar.jvn.bindLong(2, (long) kVar.jru);
                eVar.jvn.bindLong(3, kVar.jsA);
                eVar.jvn.bindString(4, kVar.jrv);
                eVar.jvn.bindLong(5, kVar.timestamp);
                eVar.jvn.bindString(6, kVar.bWm);
                eVar.jvn.bindLong(7, kVar.jsz);
                eVar.jvn.bindLong(8, kVar.dDS);
                eVar.jvn.bindString(9, kVar.jsB);
                eVar.jvn.execute();
            }
        }
        return true;
    }

    public final String toString() {
        return String.format("%s : query=%s scene=%d", new Object[]{super.toString(), this.bWm, Integer.valueOf(this.scene)});
    }

    public final String getName() {
        return "UpdateTopHitsWithQueryTask";
    }
}
