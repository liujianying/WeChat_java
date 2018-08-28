package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class cl extends c {
    private static final int cGj = "loan_jump_url".hashCode();
    private static final int cGk = "red_dot_index".hashCode();
    private static final int cGl = "is_show_entry".hashCode();
    private static final int cGm = "tips".hashCode();
    private static final int cGn = "is_overdue".hashCode();
    private static final int cGo = "available_otb".hashCode();
    public static final String[] ciG = new String[0];
    private static final int ciP = "rowid".hashCode();
    private static final int cnf = "title".hashCode();
    private boolean cGd = true;
    private boolean cGe = true;
    private boolean cGf = true;
    private boolean cGg = true;
    private boolean cGh = true;
    private boolean cGi = true;
    private boolean cnb = true;
    public String field_available_otb;
    public int field_is_overdue;
    public int field_is_show_entry;
    public String field_loan_jump_url;
    public int field_red_dot_index;
    public String field_tips;
    public String field_title;

    public final void d(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (cnf == hashCode) {
                    this.field_title = cursor.getString(i);
                    this.cnb = true;
                } else if (cGj == hashCode) {
                    this.field_loan_jump_url = cursor.getString(i);
                } else if (cGk == hashCode) {
                    this.field_red_dot_index = cursor.getInt(i);
                } else if (cGl == hashCode) {
                    this.field_is_show_entry = cursor.getInt(i);
                } else if (cGm == hashCode) {
                    this.field_tips = cursor.getString(i);
                } else if (cGn == hashCode) {
                    this.field_is_overdue = cursor.getInt(i);
                } else if (cGo == hashCode) {
                    this.field_available_otb = cursor.getString(i);
                } else if (ciP == hashCode) {
                    this.sKx = cursor.getLong(i);
                }
            }
        }
    }

    public final ContentValues wH() {
        ContentValues contentValues = new ContentValues();
        if (this.cnb) {
            contentValues.put("title", this.field_title);
        }
        if (this.cGd) {
            contentValues.put("loan_jump_url", this.field_loan_jump_url);
        }
        if (this.cGe) {
            contentValues.put("red_dot_index", Integer.valueOf(this.field_red_dot_index));
        }
        if (this.cGf) {
            contentValues.put("is_show_entry", Integer.valueOf(this.field_is_show_entry));
        }
        if (this.cGg) {
            contentValues.put("tips", this.field_tips);
        }
        if (this.cGh) {
            contentValues.put("is_overdue", Integer.valueOf(this.field_is_overdue));
        }
        if (this.cGi) {
            contentValues.put("available_otb", this.field_available_otb);
        }
        if (this.sKx > 0) {
            contentValues.put("rowid", Long.valueOf(this.sKx));
        }
        return contentValues;
    }
}
