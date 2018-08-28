package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class cd extends c {
    private static final int cBa = "isRead".hashCode();
    private static final int cDB = "pushTime".hashCode();
    private static final int cDC = "descUrl".hashCode();
    public static final String[] ciG = new String[0];
    private static final int ciP = "rowid".hashCode();
    private static final int ckj = "content".hashCode();
    private static final int cnU = "msgType".hashCode();
    private static final int cnf = "title".hashCode();
    private static final int cxB = "svrId".hashCode();
    private boolean cAR = true;
    private boolean cDA = true;
    private boolean cDz = true;
    private boolean cjN = true;
    private boolean cnG = true;
    private boolean cnb = true;
    private boolean cxy = true;
    public String field_content;
    public String field_descUrl;
    public short field_isRead;
    public int field_msgType;
    public long field_pushTime;
    public long field_svrId;
    public String field_title;

    public final void d(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (cxB == hashCode) {
                    this.field_svrId = cursor.getLong(i);
                    this.cxy = true;
                } else if (cBa == hashCode) {
                    this.field_isRead = cursor.getShort(i);
                } else if (cnf == hashCode) {
                    this.field_title = cursor.getString(i);
                } else if (ckj == hashCode) {
                    this.field_content = cursor.getString(i);
                } else if (cDB == hashCode) {
                    this.field_pushTime = cursor.getLong(i);
                } else if (cnU == hashCode) {
                    this.field_msgType = cursor.getInt(i);
                } else if (cDC == hashCode) {
                    this.field_descUrl = cursor.getString(i);
                } else if (ciP == hashCode) {
                    this.sKx = cursor.getLong(i);
                }
            }
        }
    }

    public final ContentValues wH() {
        ContentValues contentValues = new ContentValues();
        if (this.cxy) {
            contentValues.put("svrId", Long.valueOf(this.field_svrId));
        }
        if (this.cAR) {
            contentValues.put("isRead", Short.valueOf(this.field_isRead));
        }
        if (this.cnb) {
            contentValues.put("title", this.field_title);
        }
        if (this.cjN) {
            contentValues.put("content", this.field_content);
        }
        if (this.cDz) {
            contentValues.put("pushTime", Long.valueOf(this.field_pushTime));
        }
        if (this.cnG) {
            contentValues.put("msgType", Integer.valueOf(this.field_msgType));
        }
        if (this.cDA) {
            contentValues.put("descUrl", this.field_descUrl);
        }
        if (this.sKx > 0) {
            contentValues.put("rowid", Long.valueOf(this.sKx));
        }
        return contentValues;
    }
}
