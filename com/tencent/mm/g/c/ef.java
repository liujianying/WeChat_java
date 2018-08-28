package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class ef extends c {
    private static final int cPw = "canvasExt".hashCode();
    public static final String[] ciG = new String[0];
    private static final int ciP = "rowid".hashCode();
    private static final int ckb = "createTime".hashCode();
    private static final int cqe = "canvasId".hashCode();
    private static final int cqf = "canvasXml".hashCode();
    private boolean cPv = true;
    private boolean cjF = true;
    private boolean cqc = true;
    private boolean cqd = true;
    public String field_canvasExt;
    public String field_canvasId;
    public String field_canvasXml;
    public long field_createTime;

    public final void d(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (cqe == hashCode) {
                    this.field_canvasId = cursor.getString(i);
                    this.cqc = true;
                } else if (cqf == hashCode) {
                    this.field_canvasXml = cursor.getString(i);
                } else if (ckb == hashCode) {
                    this.field_createTime = cursor.getLong(i);
                } else if (cPw == hashCode) {
                    this.field_canvasExt = cursor.getString(i);
                } else if (ciP == hashCode) {
                    this.sKx = cursor.getLong(i);
                }
            }
        }
    }

    public final ContentValues wH() {
        ContentValues contentValues = new ContentValues();
        if (this.cqc) {
            contentValues.put("canvasId", this.field_canvasId);
        }
        if (this.cqd) {
            contentValues.put("canvasXml", this.field_canvasXml);
        }
        if (this.cjF) {
            contentValues.put("createTime", Long.valueOf(this.field_createTime));
        }
        if (this.cPv) {
            contentValues.put("canvasExt", this.field_canvasExt);
        }
        if (this.sKx > 0) {
            contentValues.put("rowid", Long.valueOf(this.sKx));
        }
        return contentValues;
    }
}
