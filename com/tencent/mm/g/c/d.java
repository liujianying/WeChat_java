package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class d extends c {
    public static final String[] ciG = new String[0];
    private static final int ciP = "rowid".hashCode();
    private static final int cjg = "expId".hashCode();
    private static final int cjh = "sequence".hashCode();
    private static final int cji = "prioritylevel".hashCode();
    private static final int cjj = "startTime".hashCode();
    private static final int cjk = "endTime".hashCode();
    private static final int cjq = "layerId".hashCode();
    private static final int cjr = "business".hashCode();
    private static final int cjs = "needReport".hashCode();
    private static final int cjt = "rawXML".hashCode();
    private boolean ciY = true;
    private boolean ciZ = true;
    private boolean cja = true;
    private boolean cjb = true;
    private boolean cjc = true;
    private boolean cjm = true;
    private boolean cjn = true;
    private boolean cjo = true;
    private boolean cjp = true;
    public String field_business;
    public long field_endTime;
    public String field_expId;
    public String field_layerId;
    public boolean field_needReport;
    public int field_prioritylevel;
    public String field_rawXML;
    public long field_sequence;
    public long field_startTime;

    public final void d(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (cjq == hashCode) {
                    this.field_layerId = cursor.getString(i);
                    this.cjm = true;
                } else if (cjr == hashCode) {
                    this.field_business = cursor.getString(i);
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
                } else if (cjs == hashCode) {
                    this.field_needReport = cursor.getInt(i) != 0;
                } else if (cjt == hashCode) {
                    this.field_rawXML = cursor.getString(i);
                } else if (ciP == hashCode) {
                    this.sKx = cursor.getLong(i);
                }
            }
        }
    }

    public final ContentValues wH() {
        ContentValues contentValues = new ContentValues();
        if (this.cjm) {
            contentValues.put("layerId", this.field_layerId);
        }
        if (this.cjn) {
            contentValues.put("business", this.field_business);
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
        if (this.cjo) {
            contentValues.put("needReport", Boolean.valueOf(this.field_needReport));
        }
        if (this.field_rawXML == null) {
            this.field_rawXML = "";
        }
        if (this.cjp) {
            contentValues.put("rawXML", this.field_rawXML);
        }
        if (this.sKx > 0) {
            contentValues.put("rowid", Long.valueOf(this.sKx));
        }
        return contentValues;
    }
}
