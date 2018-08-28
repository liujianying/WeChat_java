package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class e extends c {
    public static final String[] ciG = new String[0];
    private static final int ciP = "rowid".hashCode();
    private static final int cjA = "dau".hashCode();
    private static final int cjB = "useTime".hashCode();
    private static final int cjy = "key".hashCode();
    private static final int cjz = "mau".hashCode();
    private boolean cju = true;
    private boolean cjv = true;
    private boolean cjw = true;
    private boolean cjx = true;
    public int field_dau;
    public int field_key;
    public int field_mau;
    public long field_useTime;

    public final void d(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (cjy == hashCode) {
                    this.field_key = cursor.getInt(i);
                    this.cju = true;
                } else if (cjz == hashCode) {
                    this.field_mau = cursor.getInt(i);
                } else if (cjA == hashCode) {
                    this.field_dau = cursor.getInt(i);
                } else if (cjB == hashCode) {
                    this.field_useTime = cursor.getLong(i);
                } else if (ciP == hashCode) {
                    this.sKx = cursor.getLong(i);
                }
            }
        }
    }

    public final ContentValues wH() {
        ContentValues contentValues = new ContentValues();
        if (this.cju) {
            contentValues.put("key", Integer.valueOf(this.field_key));
        }
        if (this.cjv) {
            contentValues.put("mau", Integer.valueOf(this.field_mau));
        }
        if (this.cjw) {
            contentValues.put("dau", Integer.valueOf(this.field_dau));
        }
        if (this.cjx) {
            contentValues.put("useTime", Long.valueOf(this.field_useTime));
        }
        if (this.sKx > 0) {
            contentValues.put("rowid", Long.valueOf(this.sKx));
        }
        return contentValues;
    }
}
