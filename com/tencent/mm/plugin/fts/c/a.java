package com.tencent.mm.plugin.fts.c;

import android.database.Cursor;
import com.tencent.mm.plugin.fts.a.a.g;
import com.tencent.mm.plugin.fts.a.a.g.c;
import com.tencent.mm.plugin.fts.a.d;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.wcdb.database.SQLiteStatement;
import java.util.List;

public final class a extends com.tencent.mm.plugin.fts.a.a {
    public SQLiteStatement jva;
    public SQLiteStatement jvb;
    private SQLiteStatement jvc;
    public SQLiteStatement jvd;
    public SQLiteStatement jve;
    private SQLiteStatement jvf;
    public SQLiteStatement jvg;

    protected final void BR() {
        if (BS()) {
            this.jpT.t(-102, 4);
        }
        this.jpT.execSQL("CREATE TABLE IF NOT EXISTS FTS5ChatRoomMembers (chatroom TEXT, member TEXT);");
        this.jpT.execSQL("CREATE INDEX IF NOT EXISTS FTS5ChatRoomMembers_chatroom ON FTS5ChatRoomMembers(chatroom);");
        this.jpT.execSQL("CREATE INDEX IF NOT EXISTS FTS5ChatRoomMembers_member ON FTS5ChatRoomMembers(member);");
        this.jpT.execSQL("CREATE TABLE IF NOT EXISTS FTS5ContactLabels (user TEXT, label_id INTEGER);");
        this.jpT.execSQL("CREATE INDEX IF NOT EXISTS FTS5ContactLabels_user ON FTS5ContactLabels(user);");
        this.jpT.execSQL("CREATE INDEX IF NOT EXISTS FTS5ContactLabels_label ON FTS5ContactLabels(label_id);");
        this.jva = this.jpT.compileStatement("INSERT INTO FTS5ChatRoomMembers (chatroom, member) VALUES (?, ?);");
        this.jvb = this.jpT.compileStatement("DELETE FROM FTS5ChatRoomMembers WHERE chatroom=? AND member=?;");
        this.jvc = this.jpT.compileStatement("DELETE FROM FTS5ChatRoomMembers WHERE chatroom=?;");
        this.jvd = this.jpT.compileStatement("INSERT INTO FTS5ContactLabels (user, label_id) VALUES (?, ?);");
        this.jve = this.jpT.compileStatement("DELETE FROM FTS5ContactLabels WHERE user=? AND label_id=?;");
        this.jvf = this.jpT.compileStatement("DELETE FROM FTS5ContactLabels WHERE user=?;");
        this.jvg = this.jpT.compileStatement("SELECT changes();");
    }

    protected final boolean BT() {
        super.BT();
        this.jva.close();
        this.jvb.close();
        this.jvc.close();
        this.jvd.close();
        this.jve.close();
        this.jvf.close();
        this.jvg.close();
        return true;
    }

    public final void h(String str, List<Long> list) {
        if (list != null && !list.isEmpty()) {
            boolean inTransaction = this.jpT.inTransaction();
            if (!inTransaction) {
                this.jpT.beginTransaction();
            }
            this.jvd.bindString(1, str);
            for (Long longValue : list) {
                this.jvd.bindLong(2, longValue.longValue());
                this.jvd.execute();
            }
            if (!inTransaction) {
                this.jpT.commit();
            }
        }
    }

    public final void CI(String str) {
        this.jvf.bindString(1, str);
        this.jvf.execute();
    }

    public final Cursor CJ(String str) {
        return this.jpT.rawQuery("SELECT DISTINCT chatroom FROM FTS5ChatRoomMembers WHERE member=?;", new String[]{str});
    }

    public final void j(String str, String[] strArr) {
        if (strArr != null && strArr.length != 0) {
            boolean inTransaction = this.jpT.inTransaction();
            if (!inTransaction) {
                this.jpT.beginTransaction();
            }
            this.jva.bindString(1, str);
            for (String bindString : strArr) {
                this.jva.bindString(2, bindString);
                this.jva.execute();
            }
            if (!inTransaction) {
                this.jpT.commit();
            }
        }
    }

    public final void CK(String str) {
        this.jvc.bindString(1, str);
        this.jvc.execute();
    }

    protected final String getTableName() {
        return "Contact";
    }

    public final String getName() {
        return "FTS5ContactStorage";
    }

    public final int getType() {
        return 3;
    }

    public final int getPriority() {
        return 3;
    }

    protected final String aLZ() {
        return String.format("CREATE TABLE IF NOT EXISTS %s (docid INTEGER PRIMARY KEY, type INT, subtype INT DEFAULT 0, entity_id INTEGER, aux_index TEXT, timestamp INTEGER, status INT DEFAULT 0);", new Object[]{aPU()});
    }

    protected final boolean BS() {
        return !cE(-102, 4);
    }

    public final Cursor a(g gVar, String str, int[] iArr, int[] iArr2) {
        String aQa = gVar.aQa();
        String format = bi.oW(str) ? "" : String.format(" AND aux_index = '%s'", new Object[]{str});
        String str2 = (iArr == null || iArr.length <= 0) ? "" : " AND type IN " + d.l(iArr);
        String str3 = (iArr2 == null || iArr2.length <= 0) ? "" : " AND subtype IN " + d.l(iArr2);
        return this.jpT.rawQuery(String.format("SELECT aux_index, type, subtype FROM %s NOT INDEXED JOIN %s ON (%s.docid = %s.rowid) WHERE %s MATCH '%s'" + format + str2 + str3 + " AND status >= 0 ORDER BY subtype;", new Object[]{aPU(), aPV(), aPU(), aPV(), aPV(), aQa}), null);
    }

    public final boolean b(g gVar) {
        int i = 0;
        String str = "SELECT 1 FROM %s NOT INDEXED JOIN %s ON (%s.docid = %s.rowid) WHERE %s MATCH '%s' AND type=131072 LIMIT 1;";
        Object[] objArr = new Object[6];
        objArr[0] = aPU();
        objArr[1] = aPV();
        objArr[2] = aPU();
        objArr[3] = aPV();
        objArr[4] = aPV();
        StringBuffer stringBuffer = new StringBuffer();
        while (true) {
            int i2 = i;
            if (i2 < gVar.jrZ.size()) {
                stringBuffer.append("(");
                stringBuffer.append(((c) gVar.jrZ.get(i2)).aQb());
                stringBuffer.append(")");
                if (i2 != gVar.jrZ.size() - 1) {
                    stringBuffer.append(" OR ");
                }
                i = i2 + 1;
            } else {
                objArr[5] = stringBuffer.toString();
                Cursor rawQuery = this.jpT.rawQuery(String.format(str, objArr), null);
                boolean moveToNext = rawQuery.moveToNext();
                rawQuery.close();
                return moveToNext;
            }
        }
    }

    protected final boolean aPW() {
        return true;
    }
}
