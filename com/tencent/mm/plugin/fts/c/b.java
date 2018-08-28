package com.tencent.mm.plugin.fts.c;

import android.database.Cursor;
import com.tencent.mm.plugin.fts.a.a;
import com.tencent.mm.plugin.fts.a.a.c;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.wcdb.database.SQLiteStatement;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public final class b extends a {
    private SQLiteStatement jvh;

    protected final void BR() {
        if (BS()) {
            this.jpT.execSQL(String.format("DROP TABLE IF EXISTS %s", new Object[]{"Feature"}));
            t(-101, 2);
        }
        if (!this.jpT.Cn("Feature")) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("CREATE TABLE IF NOT EXISTS Feature ( ");
            stringBuilder.append(c.dhO.sql);
            stringBuilder.append(");");
            this.jpT.execSQL(stringBuilder.toString());
        }
        this.jvh = this.jpT.compileStatement(String.format("INSERT INTO %s (featureId, title, titlePY, titleShortPY, tag, actionType, url, helpUrl, updateUrl, androidUrl, iconPath, timestamp) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);", new Object[]{"Feature"}));
    }

    protected final boolean BS() {
        return !cE(-101, 2);
    }

    public final List<a> aQu() {
        List<a> arrayList = new ArrayList();
        HashSet hashSet = new HashSet();
        Cursor rawQuery = this.jpT.rawQuery(String.format("SELECT entity_id, timestamp FROM %s", new Object[]{aPU()}), null);
        while (rawQuery.moveToNext()) {
            int i = rawQuery.getInt(0);
            if (hashSet.add(Integer.valueOf(i))) {
                a aVar = new a();
                aVar.jvi = i;
                aVar.timestamp = rawQuery.getLong(1);
                arrayList.add(aVar);
            }
        }
        rawQuery.close();
        return arrayList;
    }

    public final boolean bl(List<c> list) {
        boolean inTransaction = this.jpT.inTransaction();
        if (!inTransaction) {
            this.jpT.beginTransaction();
        }
        this.jpT.execSQL("Delete from Feature");
        for (c cVar : list) {
            try {
                this.jvh.bindLong(1, (long) cVar.field_featureId);
                this.jvh.bindString(2, cVar.field_title);
                this.jvh.bindString(3, cVar.field_titlePY);
                this.jvh.bindString(4, cVar.field_titleShortPY);
                this.jvh.bindString(5, cVar.field_tag);
                this.jvh.bindLong(6, (long) cVar.field_actionType);
                this.jvh.bindString(7, cVar.field_url);
                this.jvh.bindString(8, cVar.field_helpUrl);
                this.jvh.bindString(9, cVar.field_updateUrl);
                this.jvh.bindString(10, cVar.field_androidUrl);
                this.jvh.bindString(11, cVar.field_iconPath);
                this.jvh.bindLong(12, cVar.field_timestamp);
                long executeInsert = this.jvh.executeInsert();
                x.d("MicroMsg.FTS.FTS5FeatureStorage", "insertFeatureItem rowid=%d timestamp=%d", new Object[]{Long.valueOf(executeInsert), Long.valueOf(cVar.field_timestamp)});
            } catch (Exception e) {
            }
        }
        if (!inTransaction) {
            this.jpT.commit();
        }
        return true;
    }

    public final c qi(int i) {
        c cVar = null;
        Cursor rawQuery = this.jpT.rawQuery("Select * from Feature where featureId = " + i, null);
        try {
            if (rawQuery.moveToFirst()) {
                cVar = new c();
                cVar.d(rawQuery);
                rawQuery.close();
            }
            return cVar;
        } finally {
            rawQuery.close();
        }
    }

    protected final String getTableName() {
        return "Feature";
    }

    public final String getName() {
        return "FTS5FeatureStorage";
    }

    public final int getType() {
        return 17;
    }

    public final int getPriority() {
        return 17;
    }

    protected final boolean BT() {
        super.BT();
        this.jvh.close();
        return true;
    }

    protected final boolean aPW() {
        return true;
    }
}
