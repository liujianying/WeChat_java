package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class cu extends c {
    private static final int cIZ = "language".hashCode();
    private static final int cJd = "appid".hashCode();
    private static final int cJj = "wordingId".hashCode();
    private static final int cJk = "wording".hashCode();
    private static final int cJl = "pinyin".hashCode();
    private static final int cJm = "quanpin".hashCode();
    public static final String[] ciG = new String[0];
    private static final int ciP = "rowid".hashCode();
    private static final int clj = "updateTime".hashCode();
    private boolean cIW = true;
    private boolean cJb = true;
    private boolean cJf = true;
    private boolean cJg = true;
    private boolean cJh = true;
    private boolean cJi = true;
    private boolean clh = true;
    public String field_appid;
    public String field_language;
    public String field_pinyin;
    public String field_quanpin;
    public long field_updateTime;
    public String field_wording;
    public String field_wordingId;

    public final void d(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (cJd == hashCode) {
                    this.field_appid = cursor.getString(i);
                } else if (cJj == hashCode) {
                    this.field_wordingId = cursor.getString(i);
                } else if (cIZ == hashCode) {
                    this.field_language = cursor.getString(i);
                } else if (cJk == hashCode) {
                    this.field_wording = cursor.getString(i);
                } else if (cJl == hashCode) {
                    this.field_pinyin = cursor.getString(i);
                } else if (cJm == hashCode) {
                    this.field_quanpin = cursor.getString(i);
                } else if (clj == hashCode) {
                    this.field_updateTime = cursor.getLong(i);
                } else if (ciP == hashCode) {
                    this.sKx = cursor.getLong(i);
                }
            }
        }
    }

    public final ContentValues wH() {
        ContentValues contentValues = new ContentValues();
        if (this.cJb) {
            contentValues.put("appid", this.field_appid);
        }
        if (this.cJf) {
            contentValues.put("wordingId", this.field_wordingId);
        }
        if (this.cIW) {
            contentValues.put("language", this.field_language);
        }
        if (this.cJg) {
            contentValues.put("wording", this.field_wording);
        }
        if (this.cJh) {
            contentValues.put("pinyin", this.field_pinyin);
        }
        if (this.cJi) {
            contentValues.put("quanpin", this.field_quanpin);
        }
        if (this.clh) {
            contentValues.put("updateTime", Long.valueOf(this.field_updateTime));
        }
        if (this.sKx > 0) {
            contentValues.put("rowid", Long.valueOf(this.sKx));
        }
        return contentValues;
    }
}
