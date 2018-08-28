package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class ez extends c {
    private static final int cUN = "msgSubType".hashCode();
    private static final int cUO = "msgtime".hashCode();
    public static final String[] ciG = new String[0];
    private static final int ciO = "msgId".hashCode();
    private static final int ciP = "rowid".hashCode();
    private static final int cli = "username".hashCode();
    private static final int clp = "size".hashCode();
    private static final int cnU = "msgType".hashCode();
    private static final int cxM = "path".hashCode();
    private boolean cUL = true;
    private boolean cUM = true;
    private boolean ciK = true;
    private boolean clg = true;
    private boolean clm = true;
    private boolean cnG = true;
    private boolean cxG = true;
    public long field_msgId;
    public int field_msgSubType;
    public int field_msgType;
    public long field_msgtime;
    public String field_path;
    public long field_size;
    public String field_username;

    public void d(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (ciO == hashCode) {
                    this.field_msgId = cursor.getLong(i);
                } else if (cli == hashCode) {
                    this.field_username = cursor.getString(i);
                } else if (cnU == hashCode) {
                    this.field_msgType = cursor.getInt(i);
                } else if (cUN == hashCode) {
                    this.field_msgSubType = cursor.getInt(i);
                } else if (cxM == hashCode) {
                    this.field_path = cursor.getString(i);
                } else if (clp == hashCode) {
                    this.field_size = cursor.getLong(i);
                } else if (cUO == hashCode) {
                    this.field_msgtime = cursor.getLong(i);
                } else if (ciP == hashCode) {
                    this.sKx = cursor.getLong(i);
                }
            }
        }
    }

    public final ContentValues wH() {
        ContentValues contentValues = new ContentValues();
        if (this.ciK) {
            contentValues.put("msgId", Long.valueOf(this.field_msgId));
        }
        if (this.clg) {
            contentValues.put("username", this.field_username);
        }
        if (this.cnG) {
            contentValues.put("msgType", Integer.valueOf(this.field_msgType));
        }
        if (this.cUL) {
            contentValues.put("msgSubType", Integer.valueOf(this.field_msgSubType));
        }
        if (this.cxG) {
            contentValues.put("path", this.field_path);
        }
        if (this.clm) {
            contentValues.put("size", Long.valueOf(this.field_size));
        }
        if (this.cUM) {
            contentValues.put("msgtime", Long.valueOf(this.field_msgtime));
        }
        if (this.sKx > 0) {
            contentValues.put("rowid", Long.valueOf(this.sKx));
        }
        return contentValues;
    }
}
