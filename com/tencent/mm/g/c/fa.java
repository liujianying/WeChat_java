package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class fa extends c {
    private static final int cJQ = "reportId".hashCode();
    public static final String[] ciG = new String[]{"CREATE INDEX IF NOT EXISTS WxaAttrVersionServerNotifyRecordAppVersionIndex ON WxaAttrVersionServerNotifyRecord(appVersion)"};
    private static final int ciP = "rowid".hashCode();
    private static final int cli = "username".hashCode();
    private static final int cmj = "appVersion".hashCode();
    private boolean cJN = true;
    private boolean clM = true;
    private boolean clg = true;
    public int field_appVersion;
    public int field_reportId;
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
                } else if (cmj == hashCode) {
                    this.field_appVersion = cursor.getInt(i);
                } else if (cJQ == hashCode) {
                    this.field_reportId = cursor.getInt(i);
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
        if (this.clM) {
            contentValues.put("appVersion", Integer.valueOf(this.field_appVersion));
        }
        if (this.cJN) {
            contentValues.put("reportId", Integer.valueOf(this.field_reportId));
        }
        if (this.sKx > 0) {
            contentValues.put("rowid", Long.valueOf(this.sKx));
        }
        return contentValues;
    }
}
