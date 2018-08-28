package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class av extends c {
    public static final String[] ciG = new String[0];
    private static final int ciP = "rowid".hashCode();
    private static final int ckj = "content".hashCode();
    private static final int cwy = "designerIDAndType".hashCode();
    private boolean cjN = true;
    private boolean cwx = true;
    public byte[] field_content;
    public String field_designerIDAndType;

    public final void d(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (cwy == hashCode) {
                    this.field_designerIDAndType = cursor.getString(i);
                    this.cwx = true;
                } else if (ckj == hashCode) {
                    this.field_content = cursor.getBlob(i);
                } else if (ciP == hashCode) {
                    this.sKx = cursor.getLong(i);
                }
            }
        }
    }

    public final ContentValues wH() {
        ContentValues contentValues = new ContentValues();
        if (this.cwx) {
            contentValues.put("designerIDAndType", this.field_designerIDAndType);
        }
        if (this.cjN) {
            contentValues.put("content", this.field_content);
        }
        if (this.sKx > 0) {
            contentValues.put("rowid", Long.valueOf(this.sKx));
        }
        return contentValues;
    }
}
