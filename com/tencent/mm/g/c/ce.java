package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class ce extends c {
    private static final int cDG = "countryCode".hashCode();
    private static final int cDH = "callTimeCount".hashCode();
    private static final int cDI = "lastCallTime".hashCode();
    public static final String[] ciG = new String[0];
    private static final int ciP = "rowid".hashCode();
    private boolean cDD = true;
    private boolean cDE = true;
    private boolean cDF = true;
    public long field_callTimeCount;
    public int field_countryCode;
    public long field_lastCallTime;

    public final void d(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (cDG == hashCode) {
                    this.field_countryCode = cursor.getInt(i);
                    this.cDD = true;
                } else if (cDH == hashCode) {
                    this.field_callTimeCount = cursor.getLong(i);
                } else if (cDI == hashCode) {
                    this.field_lastCallTime = cursor.getLong(i);
                } else if (ciP == hashCode) {
                    this.sKx = cursor.getLong(i);
                }
            }
        }
    }

    public final ContentValues wH() {
        ContentValues contentValues = new ContentValues();
        if (this.cDD) {
            contentValues.put("countryCode", Integer.valueOf(this.field_countryCode));
        }
        if (this.cDE) {
            contentValues.put("callTimeCount", Long.valueOf(this.field_callTimeCount));
        }
        if (this.cDF) {
            contentValues.put("lastCallTime", Long.valueOf(this.field_lastCallTime));
        }
        if (this.sKx > 0) {
            contentValues.put("rowid", Long.valueOf(this.sKx));
        }
        return contentValues;
    }
}
