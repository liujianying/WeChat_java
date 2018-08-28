package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class dn extends c {
    private static final int cMm = "productId".hashCode();
    private static final int cMn = "xmlContent".hashCode();
    private static final int cMo = "ScanTime".hashCode();
    private static final int cMp = "funcType".hashCode();
    private static final int cMq = "qrcodeUrl".hashCode();
    public static final String[] ciG = new String[0];
    private static final int ciP = "rowid".hashCode();
    private static final int ckw = "scene".hashCode();
    private boolean cMh = true;
    private boolean cMi = true;
    private boolean cMj = true;
    private boolean cMk = true;
    private boolean cMl = true;
    private boolean cku = true;
    public long field_ScanTime;
    public int field_funcType;
    public String field_productId;
    public String field_qrcodeUrl;
    public int field_scene;
    public String field_xmlContent;

    public final void d(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (cMm == hashCode) {
                    this.field_productId = cursor.getString(i);
                    this.cMh = true;
                } else if (cMn == hashCode) {
                    this.field_xmlContent = cursor.getString(i);
                } else if (cMo == hashCode) {
                    this.field_ScanTime = cursor.getLong(i);
                } else if (cMp == hashCode) {
                    this.field_funcType = cursor.getInt(i);
                } else if (cMq == hashCode) {
                    this.field_qrcodeUrl = cursor.getString(i);
                } else if (ckw == hashCode) {
                    this.field_scene = cursor.getInt(i);
                } else if (ciP == hashCode) {
                    this.sKx = cursor.getLong(i);
                }
            }
        }
    }

    public final ContentValues wH() {
        ContentValues contentValues = new ContentValues();
        if (this.cMh) {
            contentValues.put("productId", this.field_productId);
        }
        if (this.cMi) {
            contentValues.put("xmlContent", this.field_xmlContent);
        }
        if (this.cMj) {
            contentValues.put("ScanTime", Long.valueOf(this.field_ScanTime));
        }
        if (this.cMk) {
            contentValues.put("funcType", Integer.valueOf(this.field_funcType));
        }
        if (this.cMl) {
            contentValues.put("qrcodeUrl", this.field_qrcodeUrl);
        }
        if (this.cku) {
            contentValues.put("scene", Integer.valueOf(this.field_scene));
        }
        if (this.sKx > 0) {
            contentValues.put("rowid", Long.valueOf(this.sKx));
        }
        return contentValues;
    }
}
