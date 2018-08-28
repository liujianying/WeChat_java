package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class fc extends c {
    private static final int cJs = "msgState".hashCode();
    private static final int cVr = "shareKeyHash".hashCode();
    private static final int cVs = "btnState".hashCode();
    private static final int cVt = "contentColor".hashCode();
    private static final int cVu = "updatePeroid".hashCode();
    public static final String[] ciG = new String[0];
    private static final int ciP = "rowid".hashCode();
    private static final int ckj = "content".hashCode();
    private boolean cJp = true;
    private boolean cVn = true;
    private boolean cVo = true;
    private boolean cVp = true;
    private boolean cVq = true;
    private boolean cjN = true;
    public int field_btnState;
    public String field_content;
    public String field_contentColor;
    public int field_msgState;
    public int field_shareKeyHash;
    public int field_updatePeroid;

    public final void d(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (cVr == hashCode) {
                    this.field_shareKeyHash = cursor.getInt(i);
                    this.cVn = true;
                } else if (cVs == hashCode) {
                    this.field_btnState = cursor.getInt(i);
                } else if (cJs == hashCode) {
                    this.field_msgState = cursor.getInt(i);
                } else if (ckj == hashCode) {
                    this.field_content = cursor.getString(i);
                } else if (cVt == hashCode) {
                    this.field_contentColor = cursor.getString(i);
                } else if (cVu == hashCode) {
                    this.field_updatePeroid = cursor.getInt(i);
                } else if (ciP == hashCode) {
                    this.sKx = cursor.getLong(i);
                }
            }
        }
    }

    public final ContentValues wH() {
        ContentValues contentValues = new ContentValues();
        if (this.cVn) {
            contentValues.put("shareKeyHash", Integer.valueOf(this.field_shareKeyHash));
        }
        if (this.cVo) {
            contentValues.put("btnState", Integer.valueOf(this.field_btnState));
        }
        if (this.cJp) {
            contentValues.put("msgState", Integer.valueOf(this.field_msgState));
        }
        if (this.cjN) {
            contentValues.put("content", this.field_content);
        }
        if (this.cVp) {
            contentValues.put("contentColor", this.field_contentColor);
        }
        if (this.cVq) {
            contentValues.put("updatePeroid", Integer.valueOf(this.field_updatePeroid));
        }
        if (this.sKx > 0) {
            contentValues.put("rowid", Long.valueOf(this.sKx));
        }
        return contentValues;
    }
}
