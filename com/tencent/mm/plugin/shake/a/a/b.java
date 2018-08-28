package com.tencent.mm.plugin.shake.a.a;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class b extends c {
    public static final String[] ciG = new String[0];
    private static final int ciP = "rowid".hashCode();
    private static final int cli = "username".hashCode();
    private static final int mWu = "lastshaketime".hashCode();
    private static final int mWv = "isshowed".hashCode();
    private boolean clg;
    public boolean field_isshowed;
    public int field_lastshaketime;
    public String field_username;
    private boolean mWs;
    private boolean mWt;

    public final void d(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (cli == hashCode) {
                    this.field_username = cursor.getString(i);
                    this.clg = true;
                } else if (mWu == hashCode) {
                    this.field_lastshaketime = cursor.getInt(i);
                } else if (mWv == hashCode) {
                    this.field_isshowed = cursor.getInt(i) != 0;
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
        if (this.mWs) {
            contentValues.put("lastshaketime", Integer.valueOf(this.field_lastshaketime));
        }
        if (this.mWt) {
            contentValues.put("isshowed", Boolean.valueOf(this.field_isshowed));
        }
        if (this.sKx > 0) {
            contentValues.put("rowid", Long.valueOf(this.sKx));
        }
        return contentValues;
    }
}
