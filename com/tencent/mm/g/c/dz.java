package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class dz extends c {
    private static final int cOS = "tagId".hashCode();
    private static final int cOT = "tagName".hashCode();
    private static final int cOU = "memberList".hashCode();
    public static final String[] ciG = new String[0];
    private static final int ciP = "rowid".hashCode();
    private static final int cvj = "count".hashCode();
    private boolean cOP = true;
    private boolean cOQ = true;
    private boolean cOR = true;
    private boolean cuJ = true;
    public int field_count;
    public String field_memberList;
    public long field_tagId;
    public String field_tagName;

    public void d(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (cOS == hashCode) {
                    this.field_tagId = cursor.getLong(i);
                } else if (cOT == hashCode) {
                    this.field_tagName = cursor.getString(i);
                } else if (cvj == hashCode) {
                    this.field_count = cursor.getInt(i);
                } else if (cOU == hashCode) {
                    this.field_memberList = cursor.getString(i);
                } else if (ciP == hashCode) {
                    this.sKx = cursor.getLong(i);
                }
            }
        }
    }

    public final ContentValues wH() {
        ContentValues contentValues = new ContentValues();
        if (this.cOP) {
            contentValues.put("tagId", Long.valueOf(this.field_tagId));
        }
        if (this.field_tagName == null) {
            this.field_tagName = "";
        }
        if (this.cOQ) {
            contentValues.put("tagName", this.field_tagName);
        }
        if (this.cuJ) {
            contentValues.put("count", Integer.valueOf(this.field_count));
        }
        if (this.field_memberList == null) {
            this.field_memberList = "";
        }
        if (this.cOR) {
            contentValues.put("memberList", this.field_memberList);
        }
        if (this.sKx > 0) {
            contentValues.put("rowid", Long.valueOf(this.sKx));
        }
        return contentValues;
    }
}
