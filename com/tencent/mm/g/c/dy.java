package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class dy extends c {
    private static final int cOM = "logtime".hashCode();
    private static final int cON = "logsize".hashCode();
    private static final int cOO = "errorcount".hashCode();
    public static final String[] ciG = new String[]{"CREATE INDEX IF NOT EXISTS snsreport_kv_logtime ON SnsReportKv(logtime)"};
    private static final int ciP = "rowid".hashCode();
    private static final int cjf = "value".hashCode();
    private static final int ckV = "offset".hashCode();
    private boolean cOJ = true;
    private boolean cOK = true;
    private boolean cOL = true;
    private boolean ciX = true;
    private boolean ckE = true;
    public int field_errorcount;
    public int field_logsize;
    public long field_logtime;
    public int field_offset;
    public byte[] field_value;

    public void d(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (cOM == hashCode) {
                    this.field_logtime = cursor.getLong(i);
                } else if (ckV == hashCode) {
                    this.field_offset = cursor.getInt(i);
                } else if (cON == hashCode) {
                    this.field_logsize = cursor.getInt(i);
                } else if (cOO == hashCode) {
                    this.field_errorcount = cursor.getInt(i);
                } else if (cjf == hashCode) {
                    this.field_value = cursor.getBlob(i);
                } else if (ciP == hashCode) {
                    this.sKx = cursor.getLong(i);
                }
            }
        }
    }

    public final ContentValues wH() {
        ContentValues contentValues = new ContentValues();
        if (this.cOJ) {
            contentValues.put("logtime", Long.valueOf(this.field_logtime));
        }
        if (this.ckE) {
            contentValues.put("offset", Integer.valueOf(this.field_offset));
        }
        if (this.cOK) {
            contentValues.put("logsize", Integer.valueOf(this.field_logsize));
        }
        if (this.cOL) {
            contentValues.put("errorcount", Integer.valueOf(this.field_errorcount));
        }
        if (this.ciX) {
            contentValues.put("value", this.field_value);
        }
        if (this.sKx > 0) {
            contentValues.put("rowid", Long.valueOf(this.sKx));
        }
        return contentValues;
    }
}
