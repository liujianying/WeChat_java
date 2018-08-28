package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class m extends c {
    public static final String[] ciG = new String[]{"CREATE INDEX IF NOT EXISTS AppBrandLocalUsageRecordUpdateTimeIndex ON AppBrandLocalUsageRecord(updateTime)"};
    private static final int ciP = "rowid".hashCode();
    private static final int cli = "username".hashCode();
    private static final int clj = "updateTime".hashCode();
    private static final int clv = "versionType".hashCode();
    private boolean clg = true;
    private boolean clh = true;
    private boolean cls = true;
    public long field_updateTime;
    public String field_username;
    public int field_versionType;

    public final void d(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (cli == hashCode) {
                    this.field_username = cursor.getString(i);
                } else if (clv == hashCode) {
                    this.field_versionType = cursor.getInt(i);
                } else if (clj == hashCode) {
                    this.field_updateTime = cursor.getLong(i);
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
        if (this.cls) {
            contentValues.put("versionType", Integer.valueOf(this.field_versionType));
        }
        if (this.clh) {
            contentValues.put("updateTime", Long.valueOf(this.field_updateTime));
        }
        if (this.sKx > 0) {
            contentValues.put("rowid", Long.valueOf(this.sKx));
        }
        return contentValues;
    }
}
