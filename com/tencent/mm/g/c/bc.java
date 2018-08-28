package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class bc extends c {
    public static final String[] ciG = new String[0];
    private static final int ciP = "rowid".hashCode();
    private static final int ckb = "createTime".hashCode();
    private static final int cke = "type".hashCode();
    private static final int cnT = "isSend".hashCode();
    private static final int cpT = "talker".hashCode();
    private static final int cxA = "msgContent".hashCode();
    private static final int cxB = "svrId".hashCode();
    private static final int cxC = "chatroomName".hashCode();
    private static final int cxi = "encryptTalker".hashCode();
    private boolean cjF = true;
    private boolean cjI = true;
    private boolean cnF = true;
    private boolean cpL = true;
    private boolean cwT = true;
    private boolean cxx = true;
    private boolean cxy = true;
    private boolean cxz = true;
    public String field_chatroomName;
    public long field_createTime;
    public String field_encryptTalker;
    public int field_isSend;
    public String field_msgContent;
    public long field_svrId;
    public String field_talker;
    public int field_type;

    public final void d(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (cxA == hashCode) {
                    this.field_msgContent = cursor.getString(i);
                } else if (cnT == hashCode) {
                    this.field_isSend = cursor.getInt(i);
                } else if (cpT == hashCode) {
                    this.field_talker = cursor.getString(i);
                } else if (cxi == hashCode) {
                    this.field_encryptTalker = cursor.getString(i);
                } else if (cxB == hashCode) {
                    this.field_svrId = cursor.getLong(i);
                } else if (cke == hashCode) {
                    this.field_type = cursor.getInt(i);
                } else if (ckb == hashCode) {
                    this.field_createTime = cursor.getLong(i);
                } else if (cxC == hashCode) {
                    this.field_chatroomName = cursor.getString(i);
                } else if (ciP == hashCode) {
                    this.sKx = cursor.getLong(i);
                }
            }
        }
    }

    public final ContentValues wH() {
        ContentValues contentValues = new ContentValues();
        if (this.field_msgContent == null) {
            this.field_msgContent = "";
        }
        if (this.cxx) {
            contentValues.put("msgContent", this.field_msgContent);
        }
        if (this.cnF) {
            contentValues.put("isSend", Integer.valueOf(this.field_isSend));
        }
        if (this.field_talker == null) {
            this.field_talker = "";
        }
        if (this.cpL) {
            contentValues.put("talker", this.field_talker);
        }
        if (this.field_encryptTalker == null) {
            this.field_encryptTalker = "";
        }
        if (this.cwT) {
            contentValues.put("encryptTalker", this.field_encryptTalker);
        }
        if (this.cxy) {
            contentValues.put("svrId", Long.valueOf(this.field_svrId));
        }
        if (this.cjI) {
            contentValues.put("type", Integer.valueOf(this.field_type));
        }
        if (this.cjF) {
            contentValues.put("createTime", Long.valueOf(this.field_createTime));
        }
        if (this.field_chatroomName == null) {
            this.field_chatroomName = "";
        }
        if (this.cxz) {
            contentValues.put("chatroomName", this.field_chatroomName);
        }
        if (this.sKx > 0) {
            contentValues.put("rowid", Long.valueOf(this.sKx));
        }
        return contentValues;
    }
}
