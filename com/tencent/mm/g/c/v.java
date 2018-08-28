package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class v extends c {
    public static final String[] ciG = new String[0];
    private static final int ciP = "rowid".hashCode();
    private static final int ciV = "status".hashCode();
    private static final int ckj = "content".hashCode();
    private static final int cnI = "bizChatId".hashCode();
    private static final int cnJ = "brandUserName".hashCode();
    private static final int cnK = "unReadCount".hashCode();
    private static final int cnL = "newUnReadCount".hashCode();
    private static final int cnM = "lastMsgID".hashCode();
    private static final int cnN = "lastMsgTime".hashCode();
    private static final int cnO = "digest".hashCode();
    private static final int cnP = "digestUser".hashCode();
    private static final int cnQ = "atCount".hashCode();
    private static final int cnR = "editingMsg".hashCode();
    private static final int cnS = "chatType".hashCode();
    private static final int cnT = "isSend".hashCode();
    private static final int cnU = "msgType".hashCode();
    private static final int cnV = "msgCount".hashCode();
    private static final int cnk = "flag".hashCode();
    private boolean ciS = true;
    private boolean cjN = true;
    private boolean cnA = true;
    private boolean cnB = true;
    private boolean cnC = true;
    private boolean cnD = true;
    private boolean cnE = true;
    private boolean cnF = true;
    private boolean cnG = true;
    private boolean cnH = true;
    private boolean cni = true;
    private boolean cnu = true;
    private boolean cnv = true;
    private boolean cnw = true;
    private boolean cnx = true;
    private boolean cny = true;
    private boolean cnz = true;
    public int field_atCount;
    public long field_bizChatId;
    public String field_brandUserName;
    public int field_chatType;
    public String field_content;
    public String field_digest;
    public String field_digestUser;
    public String field_editingMsg;
    public long field_flag;
    public int field_isSend;
    public long field_lastMsgID;
    public long field_lastMsgTime;
    public int field_msgCount;
    public String field_msgType;
    public int field_newUnReadCount;
    public int field_status;
    public int field_unReadCount;

    public final void d(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (cnI == hashCode) {
                    this.field_bizChatId = cursor.getLong(i);
                    this.cnu = true;
                } else if (cnJ == hashCode) {
                    this.field_brandUserName = cursor.getString(i);
                } else if (cnK == hashCode) {
                    this.field_unReadCount = cursor.getInt(i);
                } else if (cnL == hashCode) {
                    this.field_newUnReadCount = cursor.getInt(i);
                } else if (cnM == hashCode) {
                    this.field_lastMsgID = cursor.getLong(i);
                } else if (cnN == hashCode) {
                    this.field_lastMsgTime = cursor.getLong(i);
                } else if (ckj == hashCode) {
                    this.field_content = cursor.getString(i);
                } else if (cnO == hashCode) {
                    this.field_digest = cursor.getString(i);
                } else if (cnP == hashCode) {
                    this.field_digestUser = cursor.getString(i);
                } else if (cnQ == hashCode) {
                    this.field_atCount = cursor.getInt(i);
                } else if (cnR == hashCode) {
                    this.field_editingMsg = cursor.getString(i);
                } else if (cnS == hashCode) {
                    this.field_chatType = cursor.getInt(i);
                } else if (ciV == hashCode) {
                    this.field_status = cursor.getInt(i);
                } else if (cnT == hashCode) {
                    this.field_isSend = cursor.getInt(i);
                } else if (cnU == hashCode) {
                    this.field_msgType = cursor.getString(i);
                } else if (cnV == hashCode) {
                    this.field_msgCount = cursor.getInt(i);
                } else if (cnk == hashCode) {
                    this.field_flag = cursor.getLong(i);
                } else if (ciP == hashCode) {
                    this.sKx = cursor.getLong(i);
                }
            }
        }
    }

    public final ContentValues wH() {
        ContentValues contentValues = new ContentValues();
        if (this.cnu) {
            contentValues.put("bizChatId", Long.valueOf(this.field_bizChatId));
        }
        if (this.cnv) {
            contentValues.put("brandUserName", this.field_brandUserName);
        }
        if (this.cnw) {
            contentValues.put("unReadCount", Integer.valueOf(this.field_unReadCount));
        }
        if (this.cnx) {
            contentValues.put("newUnReadCount", Integer.valueOf(this.field_newUnReadCount));
        }
        if (this.cny) {
            contentValues.put("lastMsgID", Long.valueOf(this.field_lastMsgID));
        }
        if (this.cnz) {
            contentValues.put("lastMsgTime", Long.valueOf(this.field_lastMsgTime));
        }
        if (this.cjN) {
            contentValues.put("content", this.field_content);
        }
        if (this.field_digest == null) {
            this.field_digest = "";
        }
        if (this.cnA) {
            contentValues.put("digest", this.field_digest);
        }
        if (this.field_digestUser == null) {
            this.field_digestUser = "";
        }
        if (this.cnB) {
            contentValues.put("digestUser", this.field_digestUser);
        }
        if (this.cnC) {
            contentValues.put("atCount", Integer.valueOf(this.field_atCount));
        }
        if (this.cnD) {
            contentValues.put("editingMsg", this.field_editingMsg);
        }
        if (this.cnE) {
            contentValues.put("chatType", Integer.valueOf(this.field_chatType));
        }
        if (this.ciS) {
            contentValues.put("status", Integer.valueOf(this.field_status));
        }
        if (this.cnF) {
            contentValues.put("isSend", Integer.valueOf(this.field_isSend));
        }
        if (this.field_msgType == null) {
            this.field_msgType = "";
        }
        if (this.cnG) {
            contentValues.put("msgType", this.field_msgType);
        }
        if (this.cnH) {
            contentValues.put("msgCount", Integer.valueOf(this.field_msgCount));
        }
        if (this.cni) {
            contentValues.put("flag", Long.valueOf(this.field_flag));
        }
        if (this.sKx > 0) {
            contentValues.put("rowid", Long.valueOf(this.sKx));
        }
        return contentValues;
    }
}
