package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class ej extends c {
    private static final int cRw = "bulletin_scene".hashCode();
    private static final int cRx = "bulletin_content".hashCode();
    private static final int cRy = "bulletin_url".hashCode();
    public static final String[] ciG = new String[0];
    private static final int ciP = "rowid".hashCode();
    private boolean cRt = true;
    private boolean cRu = true;
    private boolean cRv = true;
    public String field_bulletin_content;
    public String field_bulletin_scene;
    public String field_bulletin_url;

    public final void d(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (cRw == hashCode) {
                    this.field_bulletin_scene = cursor.getString(i);
                    this.cRt = true;
                } else if (cRx == hashCode) {
                    this.field_bulletin_content = cursor.getString(i);
                } else if (cRy == hashCode) {
                    this.field_bulletin_url = cursor.getString(i);
                } else if (ciP == hashCode) {
                    this.sKx = cursor.getLong(i);
                }
            }
        }
    }

    public final ContentValues wH() {
        ContentValues contentValues = new ContentValues();
        if (this.cRt) {
            contentValues.put("bulletin_scene", this.field_bulletin_scene);
        }
        if (this.cRu) {
            contentValues.put("bulletin_content", this.field_bulletin_content);
        }
        if (this.cRv) {
            contentValues.put("bulletin_url", this.field_bulletin_url);
        }
        if (this.sKx > 0) {
            contentValues.put("rowid", Long.valueOf(this.sKx));
        }
        return contentValues;
    }
}
