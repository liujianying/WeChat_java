package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class az extends c {
    public static final String[] ciG = new String[0];
    private static final int ciP = "rowid".hashCode();
    private static final int cjj = "startTime".hashCode();
    private static final int cjk = "endTime".hashCode();
    private static final int cvX = "groupId".hashCode();
    private static final int cwO = "exptId".hashCode();
    private static final int cwP = "exptSeq".hashCode();
    private static final int cwQ = "exptContent".hashCode();
    private boolean cjb = true;
    private boolean cjc = true;
    private boolean cvw = true;
    private boolean cwL = true;
    private boolean cwM = true;
    private boolean cwN = true;
    public long field_endTime;
    public String field_exptContent;
    public int field_exptId;
    public int field_exptSeq;
    public int field_groupId;
    public long field_startTime;

    public final void d(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (cwO == hashCode) {
                    this.field_exptId = cursor.getInt(i);
                    this.cwL = true;
                } else if (cvX == hashCode) {
                    this.field_groupId = cursor.getInt(i);
                } else if (cwP == hashCode) {
                    this.field_exptSeq = cursor.getInt(i);
                } else if (cwQ == hashCode) {
                    this.field_exptContent = cursor.getString(i);
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
        if (this.cwL) {
            contentValues.put("exptId", Integer.valueOf(this.field_exptId));
        }
        if (this.cvw) {
            contentValues.put("groupId", Integer.valueOf(this.field_groupId));
        }
        if (this.cwM) {
            contentValues.put("exptSeq", Integer.valueOf(this.field_exptSeq));
        }
        if (this.cwN) {
            contentValues.put("exptContent", this.field_exptContent);
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
