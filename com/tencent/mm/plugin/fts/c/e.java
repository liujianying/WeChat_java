package com.tencent.mm.plugin.fts.c;

import android.database.Cursor;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.fts.a.a;
import com.tencent.mm.plugin.fts.a.a.k;
import com.tencent.mm.plugin.fts.a.c$a;
import com.tencent.mm.plugin.fts.a.i;
import com.tencent.mm.plugin.fts.a.n;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.wcdb.database.SQLiteStatement;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class e extends a {
    public SQLiteStatement jvm;
    public SQLiteStatement jvn;
    public SQLiteStatement jvo;

    protected final String getTableName() {
        return "TopHits";
    }

    public final String getName() {
        return "FTS5TopHitsStorage";
    }

    public final int getType() {
        return 1;
    }

    public final int getPriority() {
        return 768;
    }

    protected final void BR() {
        if (BS()) {
            this.jpT.t(-100, 3);
        }
        this.jpT.execSQL(String.format("CREATE INDEX IF NOT EXISTS %s_query ON %s(query);", new Object[]{aPU(), aPU()}));
        this.jpT.execSQL(String.format("CREATE INDEX IF NOT EXISTS %s_score ON %s(score);", new Object[]{aPU(), aPU()}));
        this.jvm = this.jpT.compileStatement(String.format("INSERT INTO %s (content) VALUES (?);", new Object[]{aPV()}));
        this.jvn = this.jpT.compileStatement(String.format("INSERT INTO %s (docid, type, subtype, entity_id, aux_index, timestamp, query, score, scene, meta_content) VALUES (last_insert_rowid(), ?, ?, ?, ?, ?, ?, ?, ?, ?);", new Object[]{aPU()}));
        this.jvo = this.jpT.compileStatement(String.format("UPDATE %s SET status=? WHERE aux_index=?", new Object[]{aPU()}));
    }

    public final int aQv() {
        k kVar;
        Cursor rawQuery = this.jpT.rawQuery(String.format("SELECT docid, query, score, scene, aux_index, entity_id, type, subtype, timestamp, meta_content FROM %s WHERE status > 0;", new Object[]{aPU()}), null);
        List<k> arrayList = new ArrayList();
        while (rawQuery.moveToNext()) {
            k kVar2 = new k();
            kVar2.d(rawQuery);
            arrayList.add(kVar2);
        }
        rawQuery.close();
        List linkedList = new LinkedList();
        Object linkedList2 = new LinkedList();
        LinkedList linkedList3 = new LinkedList();
        for (k kVar3 : arrayList) {
            i fTSIndexStorage;
            boolean z = false;
            if (kVar3.type == 262144) {
                fTSIndexStorage = ((n) g.n(n.class)).getFTSIndexStorage(17);
            } else {
                i fTSIndexStorage2 = ((n) g.n(n.class)).getFTSIndexStorage(3);
                z = CL(kVar3.jrv);
                fTSIndexStorage = fTSIndexStorage2;
            }
            String str = null;
            if (!z) {
                str = fTSIndexStorage.br(kVar3.jrv, kVar3.jru);
            }
            if (bi.oW(str)) {
                linkedList2.add(Long.valueOf(kVar3.jsy));
            } else if (kVar3.bWm.equals("​chatroom_tophits")) {
                String str2 = "";
                for (String str3 : c$a.jqA.split(kVar3.jsB)) {
                    if (str.indexOf(str3) >= 0) {
                        str2 = str2 + str3 + "​";
                    }
                }
                if (kVar3.jsB.equals(str2)) {
                    linkedList.add(Long.valueOf(kVar3.jsy));
                } else {
                    kVar3.jsB = str2;
                    linkedList2.add(Long.valueOf(kVar3.jsy));
                    linkedList3.add(kVar3);
                }
            } else if (kVar3.jsB.equals(str)) {
                linkedList.add(Long.valueOf(kVar3.jsy));
            } else {
                kVar3.jsB = str;
                linkedList2.add(Long.valueOf(kVar3.jsy));
                linkedList3.add(kVar3);
            }
        }
        x.i("MicroMsg.FTS.FTS5TopHitsStorage", "updateTopHitsDirty deleteDocIdList=%d needToInsertTopHitListSize=%d normalDocIdList=%d", new Object[]{Integer.valueOf(linkedList2.size()), Integer.valueOf(linkedList3.size()), Integer.valueOf(linkedList.size())});
        if (linkedList2.size() > 0) {
            bi(linkedList2);
        }
        if (linkedList3.size() > 0) {
            boolean inTransaction = this.jpT.inTransaction();
            if (!inTransaction) {
                this.jpT.beginTransaction();
            }
            Iterator it = linkedList3.iterator();
            while (it.hasNext()) {
                kVar3 = (k) it.next();
                if (!bi.oW(kVar3.jsB)) {
                    this.jvm.bindString(1, kVar3.jsB);
                    this.jvm.execute();
                    this.jvn.bindLong(1, (long) kVar3.type);
                    this.jvn.bindLong(2, (long) kVar3.jru);
                    this.jvn.bindLong(3, kVar3.jsA);
                    this.jvn.bindString(4, kVar3.jrv);
                    this.jvn.bindLong(5, kVar3.timestamp);
                    this.jvn.bindString(6, kVar3.bWm);
                    this.jvn.bindLong(7, kVar3.jsz);
                    this.jvn.bindLong(8, kVar3.dDS);
                    this.jvn.bindString(9, kVar3.jsB);
                    this.jvn.execute();
                }
            }
            if (!inTransaction) {
                commit();
            }
        }
        if (linkedList.size() > 0) {
            g(linkedList, 0);
        }
        return linkedList2.size();
    }

    public static boolean CL(String str) {
        return ((com.tencent.mm.plugin.messenger.foundation.a.i) g.l(com.tencent.mm.plugin.messenger.foundation.a.i.class)).bcY().GZ(str) < System.currentTimeMillis() - 5184000000L;
    }

    protected final boolean BT() {
        super.BT();
        this.jvm.close();
        this.jvn.close();
        this.jvo.close();
        return true;
    }

    protected final String aLZ() {
        return String.format("CREATE TABLE IF NOT EXISTS %s (docid INTEGER PRIMARY KEY, type INT, subtype INT DEFAULT 0, entity_id INTEGER, aux_index TEXT, timestamp INTEGER, status INT DEFAULT 0, query TEXT COLLATE NOCASE, score INT, scene INT, meta_content TEXT);", new Object[]{aPU()});
    }

    protected final boolean BS() {
        return !cE(-100, 3);
    }
}
