package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class bv extends c {
    private static final int cCp = "championUrl".hashCode();
    private static final int cCq = "championMotto".hashCode();
    public static final String[] ciG = new String[0];
    private static final int ciP = "rowid".hashCode();
    private static final int cli = "username".hashCode();
    private boolean cCn = true;
    private boolean cCo = true;
    private boolean clg = true;
    public String field_championMotto;
    public String field_championUrl;
    public String field_username;

    public final void d(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (cli == hashCode) {
                    this.field_username = cursor.getString(i);
                } else if (cCp == hashCode) {
                    this.field_championUrl = cursor.getString(i);
                } else if (cCq == hashCode) {
                    this.field_championMotto = cursor.getString(i);
                } else if (ciP == hashCode) {
                    this.sKx = cursor.getLong(i);
                }
            }
        }
    }

    public final ContentValues wH() {
        ContentValues contentValues = new ContentValues();
        if (this.clg) {
            contentValues.put("username", this.field_username);
        }
        if (this.cCn) {
            contentValues.put("championUrl", this.field_championUrl);
        }
        if (this.cCo) {
            contentValues.put("championMotto", this.field_championMotto);
        }
        if (this.sKx > 0) {
            contentValues.put("rowid", Long.valueOf(this.sKx));
        }
        return contentValues;
    }
}
