package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class au extends c {
    public static final String[] ciG = new String[0];
    private static final int ciP = "rowid".hashCode();
    private static final int cws = "desc".hashCode();
    private static final int cww = "groupID".hashCode();
    private boolean cwo = true;
    private boolean cwv = true;
    public String field_desc;
    public String field_groupID;

    public final void d(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (cww == hashCode) {
                    this.field_groupID = cursor.getString(i);
                } else if (cws == hashCode) {
                    this.field_desc = cursor.getString(i);
                } else if (ciP == hashCode) {
                    this.sKx = cursor.getLong(i);
                }
            }
        }
    }

    public final ContentValues wH() {
        ContentValues contentValues = new ContentValues();
        if (this.cwv) {
            contentValues.put("groupID", this.field_groupID);
        }
        if (this.cwo) {
            contentValues.put("desc", this.field_desc);
        }
        if (this.sKx > 0) {
            contentValues.put("rowid", Long.valueOf(this.sKx));
        }
        return contentValues;
    }
}
