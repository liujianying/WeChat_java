package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class by extends c {
    private static final int cDf = "appusername".hashCode();
    private static final int cDi = "score".hashCode();
    public static final String[] ciG = new String[0];
    private static final int ciP = "rowid".hashCode();
    private static final int cnf = "title".hashCode();
    private boolean cDc;
    private boolean cDh;
    private boolean cnb;
    public String field_appusername;
    public int field_score;
    public String field_title;

    public final void d(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (cDf == hashCode) {
                    this.field_appusername = cursor.getString(i);
                } else if (cnf == hashCode) {
                    this.field_title = cursor.getString(i);
                } else if (cDi == hashCode) {
                    this.field_score = cursor.getInt(i);
                } else if (ciP == hashCode) {
                    this.sKx = cursor.getLong(i);
                }
            }
        }
    }

    public final ContentValues wH() {
        ContentValues contentValues = new ContentValues();
        if (this.cDc) {
            contentValues.put("appusername", this.field_appusername);
        }
        if (this.cnb) {
            contentValues.put("title", this.field_title);
        }
        if (this.cDh) {
            contentValues.put("score", Integer.valueOf(this.field_score));
        }
        if (this.sKx > 0) {
            contentValues.put("rowid", Long.valueOf(this.sKx));
        }
        return contentValues;
    }
}
