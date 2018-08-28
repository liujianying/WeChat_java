package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.samsung.android.sdk.look.smartclip.SlookSmartClipMetaTag;
import com.tencent.mm.sdk.e.c;

public abstract class q extends c {
    public static final String[] ciG = new String[0];
    private static final int ciO = "msgId".hashCode();
    private static final int ciP = "rowid".hashCode();
    private static final int ckP = "appId".hashCode();
    private static final int cke = "type".hashCode();
    private static final int cne = "xml".hashCode();
    private static final int cnf = SlookSmartClipMetaTag.TAG_TYPE_TITLE.hashCode();
    private static final int cng = "description".hashCode();
    private static final int cnh = "source".hashCode();
    private boolean ciK = true;
    private boolean cjI = true;
    private boolean cky = true;
    private boolean cna = true;
    private boolean cnb = true;
    private boolean cnc = true;
    private boolean cnd = true;
    public String field_appId;
    public String field_description;
    public long field_msgId;
    public String field_source;
    public String field_title;
    public int field_type;
    public String field_xml;

    public final void d(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (ciO == hashCode) {
                    this.field_msgId = cursor.getLong(i);
                    this.ciK = true;
                } else if (cne == hashCode) {
                    this.field_xml = cursor.getString(i);
                } else if (ckP == hashCode) {
                    this.field_appId = cursor.getString(i);
                } else if (cnf == hashCode) {
                    this.field_title = cursor.getString(i);
                } else if (cng == hashCode) {
                    this.field_description = cursor.getString(i);
                } else if (cnh == hashCode) {
                    this.field_source = cursor.getString(i);
                } else if (cke == hashCode) {
                    this.field_type = cursor.getInt(i);
                } else if (ciP == hashCode) {
                    this.sKx = cursor.getLong(i);
                }
            }
        }
    }

    public final ContentValues wH() {
        ContentValues contentValues = new ContentValues();
        if (this.ciK) {
            contentValues.put("msgId", Long.valueOf(this.field_msgId));
        }
        if (this.cna) {
            contentValues.put("xml", this.field_xml);
        }
        if (this.cky) {
            contentValues.put("appId", this.field_appId);
        }
        if (this.cnb) {
            contentValues.put(SlookSmartClipMetaTag.TAG_TYPE_TITLE, this.field_title);
        }
        if (this.cnc) {
            contentValues.put("description", this.field_description);
        }
        if (this.cnd) {
            contentValues.put("source", this.field_source);
        }
        if (this.cjI) {
            contentValues.put("type", Integer.valueOf(this.field_type));
        }
        if (this.sKx > 0) {
            contentValues.put("rowid", Long.valueOf(this.sKx));
        }
        return contentValues;
    }
}
