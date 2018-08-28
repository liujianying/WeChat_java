package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class bm extends c {
    private static final int cAn = "protocolNumber".hashCode();
    private static final int cAo = "logContent".hashCode();
    public static final String[] ciG = new String[0];
    private static final int ciP = "rowid".hashCode();
    private static final int ckb = "createTime".hashCode();
    private static final int cuh = "id".hashCode();
    private boolean cAl = true;
    private boolean cAm = true;
    private boolean cjF = true;
    private boolean cue = true;
    public long field_createTime;
    public String field_id;
    public String field_logContent;
    public int field_protocolNumber;

    public final void d(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (cuh == hashCode) {
                    this.field_id = cursor.getString(i);
                    this.cue = true;
                } else if (cAn == hashCode) {
                    this.field_protocolNumber = cursor.getInt(i);
                } else if (cAo == hashCode) {
                    this.field_logContent = cursor.getString(i);
                } else if (ckb == hashCode) {
                    this.field_createTime = cursor.getLong(i);
                } else if (ciP == hashCode) {
                    this.sKx = cursor.getLong(i);
                }
            }
        }
    }

    public final ContentValues wH() {
        ContentValues contentValues = new ContentValues();
        if (this.cue) {
            contentValues.put("id", this.field_id);
        }
        if (this.cAl) {
            contentValues.put("protocolNumber", Integer.valueOf(this.field_protocolNumber));
        }
        if (this.cAm) {
            contentValues.put("logContent", this.field_logContent);
        }
        if (this.cjF) {
            contentValues.put("createTime", Long.valueOf(this.field_createTime));
        }
        if (this.sKx > 0) {
            contentValues.put("rowid", Long.valueOf(this.sKx));
        }
        return contentValues;
    }
}
