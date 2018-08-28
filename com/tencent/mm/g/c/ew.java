package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable$Columns;

public abstract class ew extends c {
    private static final int cTY = "domin".hashCode();
    public static final String[] ciG = new String[0];
    private static final int ciP = "rowid".hashCode();
    private static final int cjf = DownloadSettingTable$Columns.VALUE.hashCode();
    private static final int cjy = "key".hashCode();
    private static final int ckP = "appId".hashCode();
    private static final int clt = "recordId".hashCode();
    private boolean cTX = true;
    private boolean ciX = true;
    private boolean cju = true;
    private boolean cky = true;
    private boolean clq = true;
    public String field_appId;
    public String field_domin;
    public String field_key;
    public int field_recordId;
    public String field_value;

    public final void d(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (clt == hashCode) {
                    this.field_recordId = cursor.getInt(i);
                    this.clq = true;
                } else if (ckP == hashCode) {
                    this.field_appId = cursor.getString(i);
                } else if (cTY == hashCode) {
                    this.field_domin = cursor.getString(i);
                } else if (cjy == hashCode) {
                    this.field_key = cursor.getString(i);
                } else if (cjf == hashCode) {
                    this.field_value = cursor.getString(i);
                } else if (ciP == hashCode) {
                    this.sKx = cursor.getLong(i);
                }
            }
        }
    }

    public final ContentValues wH() {
        ContentValues contentValues = new ContentValues();
        if (this.clq) {
            contentValues.put("recordId", Integer.valueOf(this.field_recordId));
        }
        if (this.cky) {
            contentValues.put("appId", this.field_appId);
        }
        if (this.cTX) {
            contentValues.put("domin", this.field_domin);
        }
        if (this.cju) {
            contentValues.put("key", this.field_key);
        }
        if (this.ciX) {
            contentValues.put(DownloadSettingTable$Columns.VALUE, this.field_value);
        }
        if (this.sKx > 0) {
            contentValues.put("rowid", Long.valueOf(this.sKx));
        }
        return contentValues;
    }
}
