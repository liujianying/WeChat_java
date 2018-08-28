package com.tencent.mm.plugin.shake.a.a;

import android.content.ContentValues;
import android.database.Cursor;

public abstract class c extends com.tencent.mm.sdk.e.c {
    private static final int cEa = "createtime".hashCode();
    public static final String[] ciG = new String[0];
    private static final int ciP = "rowid".hashCode();
    private static final int cli = "username".hashCode();
    private static final int cnf = "title".hashCode();
    private static final int mWy = "deeplink".hashCode();
    private static final int mWz = "iconurl".hashCode();
    private boolean cDV = true;
    private boolean clg = true;
    private boolean cnb = true;
    public long field_createtime;
    public String field_deeplink;
    public String field_iconurl;
    public String field_title;
    public String field_username;
    private boolean mWw = true;
    private boolean mWx = true;

    public final void d(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (cli == hashCode) {
                    this.field_username = cursor.getString(i);
                    this.clg = true;
                } else if (mWy == hashCode) {
                    this.field_deeplink = cursor.getString(i);
                } else if (cnf == hashCode) {
                    this.field_title = cursor.getString(i);
                } else if (mWz == hashCode) {
                    this.field_iconurl = cursor.getString(i);
                } else if (cEa == hashCode) {
                    this.field_createtime = cursor.getLong(i);
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
        if (this.field_deeplink == null) {
            this.field_deeplink = "";
        }
        if (this.mWw) {
            contentValues.put("deeplink", this.field_deeplink);
        }
        if (this.field_title == null) {
            this.field_title = "";
        }
        if (this.cnb) {
            contentValues.put("title", this.field_title);
        }
        if (this.field_iconurl == null) {
            this.field_iconurl = "";
        }
        if (this.mWx) {
            contentValues.put("iconurl", this.field_iconurl);
        }
        if (this.cDV) {
            contentValues.put("createtime", Long.valueOf(this.field_createtime));
        }
        if (this.sKx > 0) {
            contentValues.put("rowid", Long.valueOf(this.sKx));
        }
        return contentValues;
    }
}
