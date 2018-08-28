package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class at extends c {
    public static final String[] ciG = new String[0];
    private static final int ciP = "rowid".hashCode();
    private static final int cvM = "md5".hashCode();
    private static final int cvX = "groupId".hashCode();
    private static final int cvg = "lang".hashCode();
    private static final int cwr = "md5_lang".hashCode();
    private static final int cws = "desc".hashCode();
    private static final int cwt = "click_flag".hashCode();
    private static final int cwu = "download_flag".hashCode();
    private boolean cuG = true;
    private boolean cvk = true;
    private boolean cvw = true;
    private boolean cwn = true;
    private boolean cwo = true;
    private boolean cwp = true;
    private boolean cwq = true;
    public int field_click_flag;
    public String field_desc;
    public int field_download_flag;
    public String field_groupId;
    public String field_lang;
    public String field_md5;
    public String field_md5_lang;

    public final void d(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (cwr == hashCode) {
                    this.field_md5_lang = cursor.getString(i);
                    this.cwn = true;
                } else if (cvM == hashCode) {
                    this.field_md5 = cursor.getString(i);
                } else if (cvg == hashCode) {
                    this.field_lang = cursor.getString(i);
                } else if (cws == hashCode) {
                    this.field_desc = cursor.getString(i);
                } else if (cvX == hashCode) {
                    this.field_groupId = cursor.getString(i);
                } else if (cwt == hashCode) {
                    this.field_click_flag = cursor.getInt(i);
                } else if (cwu == hashCode) {
                    this.field_download_flag = cursor.getInt(i);
                } else if (ciP == hashCode) {
                    this.sKx = cursor.getLong(i);
                }
            }
        }
    }

    public final ContentValues wH() {
        ContentValues contentValues = new ContentValues();
        if (this.cwn) {
            contentValues.put("md5_lang", this.field_md5_lang);
        }
        if (this.cvk) {
            contentValues.put("md5", this.field_md5);
        }
        if (this.cuG) {
            contentValues.put("lang", this.field_lang);
        }
        if (this.cwo) {
            contentValues.put("desc", this.field_desc);
        }
        if (this.field_groupId == null) {
            this.field_groupId = "";
        }
        if (this.cvw) {
            contentValues.put("groupId", this.field_groupId);
        }
        if (this.cwp) {
            contentValues.put("click_flag", Integer.valueOf(this.field_click_flag));
        }
        if (this.cwq) {
            contentValues.put("download_flag", Integer.valueOf(this.field_download_flag));
        }
        if (this.sKx > 0) {
            contentValues.put("rowid", Long.valueOf(this.sKx));
        }
        return contentValues;
    }
}
