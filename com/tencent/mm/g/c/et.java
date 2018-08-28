package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class et extends c {
    private static final int cTC = "timeStamp".hashCode();
    private static final int cTF = "link".hashCode();
    private static final int cTG = "imgUrl".hashCode();
    public static final String[] ciG = new String[0];
    private static final int ciP = "rowid".hashCode();
    private static final int clt = "recordId".hashCode();
    private static final int cnf = "title".hashCode();
    private static final int cnh = "source".hashCode();
    private boolean cTA = true;
    private boolean cTD = true;
    private boolean cTE = true;
    private boolean clq = true;
    private boolean cnb = true;
    private boolean cnd = true;
    public String field_imgUrl;
    public String field_link;
    public String field_recordId;
    public String field_source;
    public long field_timeStamp;
    public String field_title;

    public final void d(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (clt == hashCode) {
                    this.field_recordId = cursor.getString(i);
                    this.clq = true;
                } else if (cTF == hashCode) {
                    this.field_link = cursor.getString(i);
                } else if (cnf == hashCode) {
                    this.field_title = cursor.getString(i);
                } else if (cnh == hashCode) {
                    this.field_source = cursor.getString(i);
                } else if (cTG == hashCode) {
                    this.field_imgUrl = cursor.getString(i);
                } else if (cTC == hashCode) {
                    this.field_timeStamp = cursor.getLong(i);
                } else if (ciP == hashCode) {
                    this.sKx = cursor.getLong(i);
                }
            }
        }
    }

    public final ContentValues wH() {
        ContentValues contentValues = new ContentValues();
        if (this.clq) {
            contentValues.put("recordId", this.field_recordId);
        }
        if (this.cTD) {
            contentValues.put("link", this.field_link);
        }
        if (this.cnb) {
            contentValues.put("title", this.field_title);
        }
        if (this.cnd) {
            contentValues.put("source", this.field_source);
        }
        if (this.cTE) {
            contentValues.put("imgUrl", this.field_imgUrl);
        }
        if (this.cTA) {
            contentValues.put("timeStamp", Long.valueOf(this.field_timeStamp));
        }
        if (this.sKx > 0) {
            contentValues.put("rowid", Long.valueOf(this.sKx));
        }
        return contentValues;
    }
}
