package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class bz extends c {
    private static final int cDe = "rankID".hashCode();
    private static final int cDf = "appusername".hashCode();
    private static final int cDk = "step".hashCode();
    public static final String[] ciG = new String[0];
    private static final int ciP = "rowid".hashCode();
    private static final int cli = "username".hashCode();
    private static final int cuX = "sort".hashCode();
    private boolean cDb = true;
    private boolean cDc = true;
    private boolean cDj = true;
    private boolean clg = true;
    private boolean cux = true;
    public String field_appusername;
    public String field_rankID;
    public int field_sort;
    public int field_step;
    public String field_username;

    public final void d(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (cDf == hashCode) {
                    this.field_appusername = cursor.getString(i);
                } else if (cDe == hashCode) {
                    this.field_rankID = cursor.getString(i);
                } else if (cli == hashCode) {
                    this.field_username = cursor.getString(i);
                } else if (cDk == hashCode) {
                    this.field_step = cursor.getInt(i);
                } else if (cuX == hashCode) {
                    this.field_sort = cursor.getInt(i);
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
        if (this.cDb) {
            contentValues.put("rankID", this.field_rankID);
        }
        if (this.clg) {
            contentValues.put("username", this.field_username);
        }
        if (this.cDj) {
            contentValues.put("step", Integer.valueOf(this.field_step));
        }
        if (this.cux) {
            contentValues.put("sort", Integer.valueOf(this.field_sort));
        }
        if (this.sKx > 0) {
            contentValues.put("rowid", Long.valueOf(this.sKx));
        }
        return contentValues;
    }
}
