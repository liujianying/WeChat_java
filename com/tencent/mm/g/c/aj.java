package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class aj extends c {
    public static final String[] ciG = new String[0];
    private static final int ciP = "rowid".hashCode();
    private static final int cli = "username".hashCode();
    private static final int ctg = "cmdbuf".hashCode();
    private boolean clg = true;
    private boolean ctf = true;
    public byte[] field_cmdbuf;
    public String field_username;

    public final void d(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (cli == hashCode) {
                    this.field_username = cursor.getString(i);
                    this.clg = true;
                } else if (ctg == hashCode) {
                    this.field_cmdbuf = cursor.getBlob(i);
                } else if (ciP == hashCode) {
                    this.sKx = cursor.getLong(i);
                }
            }
        }
    }

    public final ContentValues wH() {
        ContentValues contentValues = new ContentValues();
        if (this.field_username == null) {
            this.field_username = "";
        }
        if (this.clg) {
            contentValues.put("username", this.field_username);
        }
        if (this.ctf) {
            contentValues.put("cmdbuf", this.field_cmdbuf);
        }
        if (this.sKx > 0) {
            contentValues.put("rowid", Long.valueOf(this.sKx));
        }
        return contentValues;
    }
}
