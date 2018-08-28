package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class dt extends c {
    private static final int cNK = "cnValue".hashCode();
    private static final int cNL = "qqValue".hashCode();
    private static final int cNM = "twValue".hashCode();
    private static final int cNN = "enValue".hashCode();
    private static final int cNO = "thValue".hashCode();
    private static final int cNP = "eggIndex".hashCode();
    private static final int cNQ = "position".hashCode();
    public static final String[] ciG = new String[0];
    private static final int ciP = "rowid".hashCode();
    private static final int cjy = "key".hashCode();
    private static final int cnk = "flag".hashCode();
    private static final int czu = "fileName".hashCode();
    private boolean cND = true;
    private boolean cNE = true;
    private boolean cNF = true;
    private boolean cNG = true;
    private boolean cNH = true;
    private boolean cNI = true;
    private boolean cNJ = true;
    private boolean cju = true;
    private boolean cni = true;
    private boolean cyZ = true;
    public String field_cnValue;
    public int field_eggIndex;
    public String field_enValue;
    public String field_fileName;
    public int field_flag;
    public String field_key;
    public int field_position;
    public String field_qqValue;
    public String field_thValue;
    public String field_twValue;

    public final void d(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (cjy == hashCode) {
                    this.field_key = cursor.getString(i);
                    this.cju = true;
                } else if (cNK == hashCode) {
                    this.field_cnValue = cursor.getString(i);
                } else if (cNL == hashCode) {
                    this.field_qqValue = cursor.getString(i);
                } else if (cNM == hashCode) {
                    this.field_twValue = cursor.getString(i);
                } else if (cNN == hashCode) {
                    this.field_enValue = cursor.getString(i);
                } else if (cNO == hashCode) {
                    this.field_thValue = cursor.getString(i);
                } else if (czu == hashCode) {
                    this.field_fileName = cursor.getString(i);
                } else if (cNP == hashCode) {
                    this.field_eggIndex = cursor.getInt(i);
                } else if (cNQ == hashCode) {
                    this.field_position = cursor.getInt(i);
                } else if (cnk == hashCode) {
                    this.field_flag = cursor.getInt(i);
                } else if (ciP == hashCode) {
                    this.sKx = cursor.getLong(i);
                }
            }
        }
    }

    public final ContentValues wH() {
        ContentValues contentValues = new ContentValues();
        if (this.cju) {
            contentValues.put("key", this.field_key);
        }
        if (this.cND) {
            contentValues.put("cnValue", this.field_cnValue);
        }
        if (this.cNE) {
            contentValues.put("qqValue", this.field_qqValue);
        }
        if (this.cNF) {
            contentValues.put("twValue", this.field_twValue);
        }
        if (this.cNG) {
            contentValues.put("enValue", this.field_enValue);
        }
        if (this.cNH) {
            contentValues.put("thValue", this.field_thValue);
        }
        if (this.cyZ) {
            contentValues.put("fileName", this.field_fileName);
        }
        if (this.cNI) {
            contentValues.put("eggIndex", Integer.valueOf(this.field_eggIndex));
        }
        if (this.cNJ) {
            contentValues.put("position", Integer.valueOf(this.field_position));
        }
        if (this.cni) {
            contentValues.put("flag", Integer.valueOf(this.field_flag));
        }
        if (this.sKx > 0) {
            contentValues.put("rowid", Long.valueOf(this.sKx));
        }
        return contentValues;
    }
}
