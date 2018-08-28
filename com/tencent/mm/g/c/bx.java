package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class bx extends c {
    private static final int cDe = "rankID".hashCode();
    private static final int cDf = "appusername".hashCode();
    private static final int cDg = "liketips".hashCode();
    public static final String[] ciG = new String[0];
    private static final int ciP = "rowid".hashCode();
    private static final int cli = "username".hashCode();
    private static final int cyU = "timestamp".hashCode();
    private boolean cDb = true;
    private boolean cDc = true;
    private boolean cDd = true;
    private boolean clg = true;
    private boolean cyK = true;
    public String field_appusername;
    public String field_liketips;
    public String field_rankID;
    public int field_timestamp;
    public String field_username;

    public final void d(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (cDe == hashCode) {
                    this.field_rankID = cursor.getString(i);
                } else if (cDf == hashCode) {
                    this.field_appusername = cursor.getString(i);
                } else if (cli == hashCode) {
                    this.field_username = cursor.getString(i);
                } else if (cyU == hashCode) {
                    this.field_timestamp = cursor.getInt(i);
                } else if (cDg == hashCode) {
                    this.field_liketips = cursor.getString(i);
                } else if (ciP == hashCode) {
                    this.sKx = cursor.getLong(i);
                }
            }
        }
    }

    public final ContentValues wH() {
        ContentValues contentValues = new ContentValues();
        if (this.cDb) {
            contentValues.put("rankID", this.field_rankID);
        }
        if (this.cDc) {
            contentValues.put("appusername", this.field_appusername);
        }
        if (this.clg) {
            contentValues.put("username", this.field_username);
        }
        if (this.cyK) {
            contentValues.put("timestamp", Integer.valueOf(this.field_timestamp));
        }
        if (this.field_liketips == null) {
            this.field_liketips = "";
        }
        if (this.cDd) {
            contentValues.put("liketips", this.field_liketips);
        }
        if (this.sKx > 0) {
            contentValues.put("rowid", Long.valueOf(this.sKx));
        }
        return contentValues;
    }
}
