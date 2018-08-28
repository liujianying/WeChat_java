package com.tencent.mm.plugin.shake.a.a;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class a extends c {
    private static final int cEa = "createtime".hashCode();
    public static final String[] ciG = new String[0];
    private static final int ciP = "rowid".hashCode();
    private static final int ciV = "status".hashCode();
    private static final int cke = "type".hashCode();
    private static final int cnf = "title".hashCode();
    private static final int cvN = "svrid".hashCode();
    private static final int cvS = "reserved1".hashCode();
    private static final int cvT = "reserved2".hashCode();
    private static final int cvU = "reserved3".hashCode();
    private static final int cws = "desc".hashCode();
    private static final int cyA = "subtype".hashCode();
    private static final int cyO = "tag".hashCode();
    private static final int mWq = "thumburl".hashCode();
    private static final int mWr = "reservedBuf".hashCode();
    private boolean cDV = true;
    private boolean ciS = true;
    private boolean cjI = true;
    private boolean cnb = true;
    private boolean cvl = true;
    private boolean cvq = true;
    private boolean cvr = true;
    private boolean cvs = true;
    private boolean cwo = true;
    private boolean cyE = true;
    private boolean cyy = true;
    public long field_createtime;
    public String field_desc;
    public String field_reserved1;
    public String field_reserved2;
    public int field_reserved3;
    public byte[] field_reservedBuf;
    public int field_status;
    public int field_subtype;
    public long field_svrid;
    public String field_tag;
    public String field_thumburl;
    public String field_title;
    public int field_type;
    private boolean mWo = true;
    private boolean mWp = true;

    public final void d(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (cvN == hashCode) {
                    this.field_svrid = cursor.getLong(i);
                    this.cvl = true;
                } else if (cke == hashCode) {
                    this.field_type = cursor.getInt(i);
                } else if (cyA == hashCode) {
                    this.field_subtype = cursor.getInt(i);
                } else if (cEa == hashCode) {
                    this.field_createtime = cursor.getLong(i);
                } else if (cyO == hashCode) {
                    this.field_tag = cursor.getString(i);
                } else if (ciV == hashCode) {
                    this.field_status = cursor.getInt(i);
                } else if (cnf == hashCode) {
                    this.field_title = cursor.getString(i);
                } else if (cws == hashCode) {
                    this.field_desc = cursor.getString(i);
                } else if (mWq == hashCode) {
                    this.field_thumburl = cursor.getString(i);
                } else if (cvS == hashCode) {
                    this.field_reserved1 = cursor.getString(i);
                } else if (cvT == hashCode) {
                    this.field_reserved2 = cursor.getString(i);
                } else if (cvU == hashCode) {
                    this.field_reserved3 = cursor.getInt(i);
                } else if (mWr == hashCode) {
                    this.field_reservedBuf = cursor.getBlob(i);
                } else if (ciP == hashCode) {
                    this.sKx = cursor.getLong(i);
                }
            }
        }
    }

    public final ContentValues wH() {
        ContentValues contentValues = new ContentValues();
        if (this.cvl) {
            contentValues.put("svrid", Long.valueOf(this.field_svrid));
        }
        if (this.cjI) {
            contentValues.put("type", Integer.valueOf(this.field_type));
        }
        if (this.cyy) {
            contentValues.put("subtype", Integer.valueOf(this.field_subtype));
        }
        if (this.cDV) {
            contentValues.put("createtime", Long.valueOf(this.field_createtime));
        }
        if (this.cyE) {
            contentValues.put("tag", this.field_tag);
        }
        if (this.ciS) {
            contentValues.put("status", Integer.valueOf(this.field_status));
        }
        if (this.cnb) {
            contentValues.put("title", this.field_title);
        }
        if (this.cwo) {
            contentValues.put("desc", this.field_desc);
        }
        if (this.mWo) {
            contentValues.put("thumburl", this.field_thumburl);
        }
        if (this.cvq) {
            contentValues.put("reserved1", this.field_reserved1);
        }
        if (this.cvr) {
            contentValues.put("reserved2", this.field_reserved2);
        }
        if (this.cvs) {
            contentValues.put("reserved3", Integer.valueOf(this.field_reserved3));
        }
        if (this.mWp) {
            contentValues.put("reservedBuf", this.field_reservedBuf);
        }
        if (this.sKx > 0) {
            contentValues.put("rowid", Long.valueOf(this.sKx));
        }
        return contentValues;
    }
}
