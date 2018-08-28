package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class dv extends c {
    private static final int cBa = "isRead".hashCode();
    private static final int cNZ = "snsID".hashCode();
    private static final int cOa = "parentID".hashCode();
    private static final int cOb = "curActionBuf".hashCode();
    private static final int cOc = "refActionBuf".hashCode();
    private static final int cOd = "commentSvrID".hashCode();
    private static final int cOe = "clientId".hashCode();
    private static final int cOf = "commentflag".hashCode();
    private static final int cOg = "isSilence".hashCode();
    public static final String[] ciG = new String[]{"CREATE INDEX IF NOT EXISTS SnsComment_snsID_index ON SnsComment(snsID)", "CREATE INDEX IF NOT EXISTS SnsComment_parentID_index ON SnsComment(parentID)", "CREATE INDEX IF NOT EXISTS SnsComment_isRead_index ON SnsComment(isRead)", "CREATE INDEX IF NOT EXISTS SnsComment_isSend_index ON SnsComment(isSend)"};
    private static final int ciP = "rowid".hashCode();
    private static final int ckb = "createTime".hashCode();
    private static final int cke = "type".hashCode();
    private static final int cnT = "isSend".hashCode();
    private static final int cpT = "talker".hashCode();
    private boolean cAR = true;
    private boolean cNR = true;
    private boolean cNS = true;
    private boolean cNT = true;
    private boolean cNU = true;
    private boolean cNV = true;
    private boolean cNW = true;
    private boolean cNX = true;
    private boolean cNY = true;
    private boolean cjF = true;
    private boolean cjI = true;
    private boolean cnF = true;
    private boolean cpL = true;
    public String field_clientId;
    public long field_commentSvrID;
    public int field_commentflag;
    public int field_createTime;
    public byte[] field_curActionBuf;
    public short field_isRead;
    public boolean field_isSend;
    public int field_isSilence;
    public long field_parentID;
    public byte[] field_refActionBuf;
    public long field_snsID;
    public String field_talker;
    public int field_type;

    public void d(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (cNZ == hashCode) {
                    this.field_snsID = cursor.getLong(i);
                } else if (cOa == hashCode) {
                    this.field_parentID = cursor.getLong(i);
                } else if (cBa == hashCode) {
                    this.field_isRead = cursor.getShort(i);
                } else if (ckb == hashCode) {
                    this.field_createTime = cursor.getInt(i);
                } else if (cpT == hashCode) {
                    this.field_talker = cursor.getString(i);
                } else if (cke == hashCode) {
                    this.field_type = cursor.getInt(i);
                } else if (cnT == hashCode) {
                    this.field_isSend = cursor.getInt(i) != 0;
                } else if (cOb == hashCode) {
                    this.field_curActionBuf = cursor.getBlob(i);
                } else if (cOc == hashCode) {
                    this.field_refActionBuf = cursor.getBlob(i);
                } else if (cOd == hashCode) {
                    this.field_commentSvrID = cursor.getLong(i);
                } else if (cOe == hashCode) {
                    this.field_clientId = cursor.getString(i);
                } else if (cOf == hashCode) {
                    this.field_commentflag = cursor.getInt(i);
                } else if (cOg == hashCode) {
                    this.field_isSilence = cursor.getInt(i);
                } else if (ciP == hashCode) {
                    this.sKx = cursor.getLong(i);
                }
            }
        }
    }

    public final ContentValues wH() {
        ContentValues contentValues = new ContentValues();
        if (this.cNR) {
            contentValues.put("snsID", Long.valueOf(this.field_snsID));
        }
        if (this.cNS) {
            contentValues.put("parentID", Long.valueOf(this.field_parentID));
        }
        if (this.cAR) {
            contentValues.put("isRead", Short.valueOf(this.field_isRead));
        }
        if (this.cjF) {
            contentValues.put("createTime", Integer.valueOf(this.field_createTime));
        }
        if (this.cpL) {
            contentValues.put("talker", this.field_talker);
        }
        if (this.cjI) {
            contentValues.put("type", Integer.valueOf(this.field_type));
        }
        if (this.cnF) {
            contentValues.put("isSend", Boolean.valueOf(this.field_isSend));
        }
        if (this.cNT) {
            contentValues.put("curActionBuf", this.field_curActionBuf);
        }
        if (this.cNU) {
            contentValues.put("refActionBuf", this.field_refActionBuf);
        }
        if (this.cNV) {
            contentValues.put("commentSvrID", Long.valueOf(this.field_commentSvrID));
        }
        if (this.cNW) {
            contentValues.put("clientId", this.field_clientId);
        }
        if (this.cNX) {
            contentValues.put("commentflag", Integer.valueOf(this.field_commentflag));
        }
        if (this.cNY) {
            contentValues.put("isSilence", Integer.valueOf(this.field_isSilence));
        }
        if (this.sKx > 0) {
            contentValues.put("rowid", Long.valueOf(this.sKx));
        }
        return contentValues;
    }
}
