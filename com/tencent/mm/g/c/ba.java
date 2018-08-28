package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class ba extends c {
    public static final String[] ciG = new String[0];
    private static final int ciP = "rowid".hashCode();
    private static final int cwO = "exptId".hashCode();
    private static final int cwS = "exptKey".hashCode();
    private boolean cwL = true;
    private boolean cwR = true;
    public int field_exptId;
    public String field_exptKey;

    public final void d(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (cwS == hashCode) {
                    this.field_exptKey = cursor.getString(i);
                    this.cwR = true;
                } else if (cwO == hashCode) {
                    this.field_exptId = cursor.getInt(i);
                } else if (ciP == hashCode) {
                    this.sKx = cursor.getLong(i);
                }
            }
        }
    }

    public final ContentValues wH() {
        ContentValues contentValues = new ContentValues();
        if (this.cwR) {
            contentValues.put("exptKey", this.field_exptKey);
        }
        if (this.cwL) {
            contentValues.put("exptId", Integer.valueOf(this.field_exptId));
        }
        if (this.sKx > 0) {
            contentValues.put("rowid", Long.valueOf(this.sKx));
        }
        return contentValues;
    }
}
