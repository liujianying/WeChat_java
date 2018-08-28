package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class k extends c {
    public static final String[] ciG = new String[0];
    private static final int ciP = "rowid".hashCode();
    private static final int cjy = "key".hashCode();
    private static final int cln = "data".hashCode();
    private static final int clo = "dataType".hashCode();
    private static final int clp = "size".hashCode();
    private boolean cju = true;
    private boolean clk = true;
    private boolean cll = true;
    private boolean clm = true;
    public String field_data;
    public String field_dataType;
    public String field_key;
    public int field_size;

    public final void d(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (cjy == hashCode) {
                    this.field_key = cursor.getString(i);
                    this.cju = true;
                } else if (cln == hashCode) {
                    this.field_data = cursor.getString(i);
                } else if (clo == hashCode) {
                    this.field_dataType = cursor.getString(i);
                } else if (clp == hashCode) {
                    this.field_size = cursor.getInt(i);
                } else if (ciP == hashCode) {
                    this.sKx = cursor.getLong(i);
                }
            }
        }
    }

    public final ContentValues wH() {
        ContentValues contentValues = new ContentValues();
        if (this.cju) {
            contentValues.put("key", this.field_key);
        }
        if (this.clk) {
            contentValues.put("data", this.field_data);
        }
        if (this.cll) {
            contentValues.put("dataType", this.field_dataType);
        }
        if (this.clm) {
            contentValues.put("size", Integer.valueOf(this.field_size));
        }
        if (this.sKx > 0) {
            contentValues.put("rowid", Long.valueOf(this.sKx));
        }
        return contentValues;
    }
}
