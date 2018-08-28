package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class ec extends c {
    private static final int cPf = "tableHash".hashCode();
    private static final int cPg = "tableSQLMD5".hashCode();
    public static final String[] ciG = new String[0];
    private static final int ciP = "rowid".hashCode();
    private boolean cPd = true;
    private boolean cPe = true;
    public int field_tableHash;
    public String field_tableSQLMD5;

    public final void d(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (cPf == hashCode) {
                    this.field_tableHash = cursor.getInt(i);
                    this.cPd = true;
                } else if (cPg == hashCode) {
                    this.field_tableSQLMD5 = cursor.getString(i);
                } else if (ciP == hashCode) {
                    this.sKx = cursor.getLong(i);
                }
            }
        }
    }

    public final ContentValues wH() {
        ContentValues contentValues = new ContentValues();
        if (this.cPd) {
            contentValues.put("tableHash", Integer.valueOf(this.field_tableHash));
        }
        if (this.cPe) {
            contentValues.put("tableSQLMD5", this.field_tableSQLMD5);
        }
        if (this.sKx > 0) {
            contentValues.put("rowid", Long.valueOf(this.sKx));
        }
        return contentValues;
    }
}
