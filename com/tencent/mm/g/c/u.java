package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class u extends c {
    public static final String[] ciG = new String[0];
    private static final int ciP = "rowid".hashCode();
    private static final int cjj = "startTime".hashCode();
    private static final int cjk = "endTime".hashCode();
    private static final int cnq = "sessionName".hashCode();
    private boolean cjb = true;
    private boolean cjc = true;
    private boolean cnn = true;
    public long field_endTime;
    public String field_sessionName;
    public long field_startTime;

    public final void d(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (cnq == hashCode) {
                    this.field_sessionName = cursor.getString(i);
                } else if (cjj == hashCode) {
                    this.field_startTime = cursor.getLong(i);
                } else if (cjk == hashCode) {
                    this.field_endTime = cursor.getLong(i);
                } else if (ciP == hashCode) {
                    this.sKx = cursor.getLong(i);
                }
            }
        }
    }

    public final ContentValues wH() {
        ContentValues contentValues = new ContentValues();
        if (this.field_sessionName == null) {
            this.field_sessionName = "";
        }
        if (this.cnn) {
            contentValues.put("sessionName", this.field_sessionName);
        }
        if (this.cjb) {
            contentValues.put("startTime", Long.valueOf(this.field_startTime));
        }
        if (this.cjc) {
            contentValues.put("endTime", Long.valueOf(this.field_endTime));
        }
        if (this.sKx > 0) {
            contentValues.put("rowid", Long.valueOf(this.sKx));
        }
        return contentValues;
    }
}
