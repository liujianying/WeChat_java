package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;

public abstract class c extends com.tencent.mm.sdk.e.c {
    public static final String[] ciG = new String[0];
    private static final int ciP = "rowid".hashCode();
    private static final int cje = "abtestkey".hashCode();
    private static final int cjf = "value".hashCode();
    private static final int cjg = "expId".hashCode();
    private static final int cjh = "sequence".hashCode();
    private static final int cji = "prioritylevel".hashCode();
    private static final int cjj = "startTime".hashCode();
    private static final int cjk = "endTime".hashCode();
    private static final int cjl = "noReport".hashCode();
    private boolean ciW = true;
    private boolean ciX = true;
    private boolean ciY = true;
    private boolean ciZ = true;
    private boolean cja = true;
    private boolean cjb = true;
    private boolean cjc = true;
    private boolean cjd = true;
    public String field_abtestkey;
    public long field_endTime;
    public String field_expId;
    public boolean field_noReport;
    public int field_prioritylevel;
    public long field_sequence;
    public long field_startTime;
    public String field_value;

    public final void d(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (cje == hashCode) {
                    this.field_abtestkey = cursor.getString(i);
                    this.ciW = true;
                } else if (cjf == hashCode) {
                    this.field_value = cursor.getString(i);
                } else if (cjg == hashCode) {
                    this.field_expId = cursor.getString(i);
                } else if (cjh == hashCode) {
                    this.field_sequence = cursor.getLong(i);
                } else if (cji == hashCode) {
                    this.field_prioritylevel = cursor.getInt(i);
                } else if (cjj == hashCode) {
                    this.field_startTime = cursor.getLong(i);
                } else if (cjk == hashCode) {
                    this.field_endTime = cursor.getLong(i);
                } else if (cjl == hashCode) {
                    this.field_noReport = cursor.getInt(i) != 0;
                } else if (ciP == hashCode) {
                    this.sKx = cursor.getLong(i);
                }
            }
        }
    }

    public final ContentValues wH() {
        ContentValues contentValues = new ContentValues();
        if (this.ciW) {
            contentValues.put("abtestkey", this.field_abtestkey);
        }
        if (this.ciX) {
            contentValues.put("value", this.field_value);
        }
        if (this.ciY) {
            contentValues.put("expId", this.field_expId);
        }
        if (this.ciZ) {
            contentValues.put("sequence", Long.valueOf(this.field_sequence));
        }
        if (this.cja) {
            contentValues.put("prioritylevel", Integer.valueOf(this.field_prioritylevel));
        }
        if (this.cjb) {
            contentValues.put("startTime", Long.valueOf(this.field_startTime));
        }
        if (this.cjc) {
            contentValues.put("endTime", Long.valueOf(this.field_endTime));
        }
        if (this.cjd) {
            contentValues.put("noReport", Boolean.valueOf(this.field_noReport));
        }
        if (this.sKx > 0) {
            contentValues.put("rowid", Long.valueOf(this.sKx));
        }
        return contentValues;
    }
}
