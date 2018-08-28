package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class bt extends c {
    private static final int cBH = "originSvrId".hashCode();
    private static final int cBI = "newMsgId".hashCode();
    private static final int cBJ = "fromUserName".hashCode();
    private static final int cBK = "toUserName".hashCode();
    private static final int cBL = "msgSource".hashCode();
    private static final int cBM = "msgSeq".hashCode();
    public static final String[] ciG = new String[0];
    private static final int ciP = "rowid".hashCode();
    private static final int ckb = "createTime".hashCode();
    private static final int ckj = "content".hashCode();
    private static final int cnk = "flag".hashCode();
    private static final int cvS = "reserved1".hashCode();
    private static final int cvT = "reserved2".hashCode();
    private static final int cvU = "reserved3".hashCode();
    private static final int cvV = "reserved4".hashCode();
    private boolean cBB = true;
    private boolean cBC = true;
    private boolean cBD = true;
    private boolean cBE = true;
    private boolean cBF = true;
    private boolean cBG = true;
    private boolean cjF = true;
    private boolean cjN = true;
    private boolean cni = true;
    private boolean cvq = true;
    private boolean cvr = true;
    private boolean cvs = true;
    private boolean cvt = true;
    public String field_content;
    public long field_createTime;
    public int field_flag;
    public String field_fromUserName;
    public int field_msgSeq;
    public String field_msgSource;
    public long field_newMsgId;
    public long field_originSvrId;
    public int field_reserved1;
    public long field_reserved2;
    public String field_reserved3;
    public String field_reserved4;
    public String field_toUserName;

    public final void d(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (cBH == hashCode) {
                    this.field_originSvrId = cursor.getLong(i);
                    this.cBB = true;
                } else if (cBI == hashCode) {
                    this.field_newMsgId = cursor.getLong(i);
                } else if (cBJ == hashCode) {
                    this.field_fromUserName = cursor.getString(i);
                } else if (cBK == hashCode) {
                    this.field_toUserName = cursor.getString(i);
                } else if (ckb == hashCode) {
                    this.field_createTime = cursor.getLong(i);
                } else if (ckj == hashCode) {
                    this.field_content = cursor.getString(i);
                } else if (cBL == hashCode) {
                    this.field_msgSource = cursor.getString(i);
                } else if (cBM == hashCode) {
                    this.field_msgSeq = cursor.getInt(i);
                } else if (cnk == hashCode) {
                    this.field_flag = cursor.getInt(i);
                } else if (cvS == hashCode) {
                    this.field_reserved1 = cursor.getInt(i);
                } else if (cvT == hashCode) {
                    this.field_reserved2 = cursor.getLong(i);
                } else if (cvU == hashCode) {
                    this.field_reserved3 = cursor.getString(i);
                } else if (cvV == hashCode) {
                    this.field_reserved4 = cursor.getString(i);
                } else if (ciP == hashCode) {
                    this.sKx = cursor.getLong(i);
                }
            }
        }
    }

    public final ContentValues wH() {
        ContentValues contentValues = new ContentValues();
        if (this.cBB) {
            contentValues.put("originSvrId", Long.valueOf(this.field_originSvrId));
        }
        if (this.cBC) {
            contentValues.put("newMsgId", Long.valueOf(this.field_newMsgId));
        }
        if (this.field_fromUserName == null) {
            this.field_fromUserName = "";
        }
        if (this.cBD) {
            contentValues.put("fromUserName", this.field_fromUserName);
        }
        if (this.field_toUserName == null) {
            this.field_toUserName = "";
        }
        if (this.cBE) {
            contentValues.put("toUserName", this.field_toUserName);
        }
        if (this.cjF) {
            contentValues.put("createTime", Long.valueOf(this.field_createTime));
        }
        if (this.field_content == null) {
            this.field_content = "";
        }
        if (this.cjN) {
            contentValues.put("content", this.field_content);
        }
        if (this.field_msgSource == null) {
            this.field_msgSource = "";
        }
        if (this.cBF) {
            contentValues.put("msgSource", this.field_msgSource);
        }
        if (this.cBG) {
            contentValues.put("msgSeq", Integer.valueOf(this.field_msgSeq));
        }
        if (this.cni) {
            contentValues.put("flag", Integer.valueOf(this.field_flag));
        }
        if (this.cvq) {
            contentValues.put("reserved1", Integer.valueOf(this.field_reserved1));
        }
        if (this.cvr) {
            contentValues.put("reserved2", Long.valueOf(this.field_reserved2));
        }
        if (this.field_reserved3 == null) {
            this.field_reserved3 = "";
        }
        if (this.cvs) {
            contentValues.put("reserved3", this.field_reserved3);
        }
        if (this.field_reserved4 == null) {
            this.field_reserved4 = "";
        }
        if (this.cvt) {
            contentValues.put("reserved4", this.field_reserved4);
        }
        if (this.sKx > 0) {
            contentValues.put("rowid", Long.valueOf(this.sKx));
        }
        return contentValues;
    }
}
