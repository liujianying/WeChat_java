package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class aw extends c {
    public static final String[] ciG = new String[0];
    private static final int ciP = "rowid".hashCode();
    private static final int ckj = "content".hashCode();
    private static final int cuK = "productID".hashCode();
    private static final int cwA = "lan".hashCode();
    private boolean cjN = true;
    private boolean cuk = true;
    private boolean cwz = true;
    public byte[] field_content;
    public String field_lan;
    public String field_productID;

    public final void d(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (cuK == hashCode) {
                    this.field_productID = cursor.getString(i);
                    this.cuk = true;
                } else if (ckj == hashCode) {
                    this.field_content = cursor.getBlob(i);
                } else if (cwA == hashCode) {
                    this.field_lan = cursor.getString(i);
                } else if (ciP == hashCode) {
                    this.sKx = cursor.getLong(i);
                }
            }
        }
    }

    public final ContentValues wH() {
        ContentValues contentValues = new ContentValues();
        if (this.cuk) {
            contentValues.put("productID", this.field_productID);
        }
        if (this.cjN) {
            contentValues.put("content", this.field_content);
        }
        if (this.field_lan == null) {
            this.field_lan = "";
        }
        if (this.cwz) {
            contentValues.put("lan", this.field_lan);
        }
        if (this.sKx > 0) {
            contentValues.put("rowid", Long.valueOf(this.sKx));
        }
        return contentValues;
    }
}
