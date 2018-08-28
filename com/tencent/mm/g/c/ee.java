package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class ee extends c {
    public static final String[] ciG = new String[0];
    private static final int ciP = "rowid".hashCode();
    private static final int ckP = "appId".hashCode();
    private static final int cli = "username".hashCode();
    private static final int cmt = "openId".hashCode();
    private boolean cky = true;
    private boolean clW = true;
    private boolean clg = true;
    public String field_appId;
    public String field_openId;
    public String field_username;

    public final void d(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (cmt == hashCode) {
                    this.field_openId = cursor.getString(i);
                    this.clW = true;
                } else if (ckP == hashCode) {
                    this.field_appId = cursor.getString(i);
                } else if (cli == hashCode) {
                    this.field_username = cursor.getString(i);
                } else if (ciP == hashCode) {
                    this.sKx = cursor.getLong(i);
                }
            }
        }
    }

    public final ContentValues wH() {
        ContentValues contentValues = new ContentValues();
        if (this.clW) {
            contentValues.put("openId", this.field_openId);
        }
        if (this.cky) {
            contentValues.put("appId", this.field_appId);
        }
        if (this.clg) {
            contentValues.put("username", this.field_username);
        }
        if (this.sKx > 0) {
            contentValues.put("rowid", Long.valueOf(this.sKx));
        }
        return contentValues;
    }
}
