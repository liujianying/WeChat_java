package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class en extends c {
    private static final int cSh = "pref_key".hashCode();
    private static final int cSi = "pref_title".hashCode();
    private static final int cSj = "pref_url".hashCode();
    private static final int cSk = "is_show".hashCode();
    public static final String[] ciG = new String[0];
    private static final int ciP = "rowid".hashCode();
    private boolean cSd = true;
    private boolean cSe = true;
    private boolean cSf = true;
    private boolean cSg = true;
    public int field_is_show;
    public String field_pref_key;
    public String field_pref_title;
    public String field_pref_url;

    public final void d(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (cSh == hashCode) {
                    this.field_pref_key = cursor.getString(i);
                    this.cSd = true;
                } else if (cSi == hashCode) {
                    this.field_pref_title = cursor.getString(i);
                } else if (cSj == hashCode) {
                    this.field_pref_url = cursor.getString(i);
                } else if (cSk == hashCode) {
                    this.field_is_show = cursor.getInt(i);
                } else if (ciP == hashCode) {
                    this.sKx = cursor.getLong(i);
                }
            }
        }
    }

    public final ContentValues wH() {
        ContentValues contentValues = new ContentValues();
        if (this.cSd) {
            contentValues.put("pref_key", this.field_pref_key);
        }
        if (this.cSe) {
            contentValues.put("pref_title", this.field_pref_title);
        }
        if (this.cSf) {
            contentValues.put("pref_url", this.field_pref_url);
        }
        if (this.cSg) {
            contentValues.put("is_show", Integer.valueOf(this.field_is_show));
        }
        if (this.sKx > 0) {
            contentValues.put("rowid", Long.valueOf(this.sKx));
        }
        return contentValues;
    }
}
