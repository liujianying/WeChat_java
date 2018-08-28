package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class bq extends c {
    private static final int cAW = "mergerId".hashCode();
    private static final int cAX = "gameMsgId".hashCode();
    private static final int cAY = "expireTime".hashCode();
    private static final int cAZ = "showInMsgList".hashCode();
    private static final int cBa = "isRead".hashCode();
    private static final int cBb = "label".hashCode();
    private static final int cBc = "isHidden".hashCode();
    private static final int cBd = "weight".hashCode();
    private static final int cBe = "receiveTime".hashCode();
    public static final String[] ciG = new String[0];
    private static final int ciO = "msgId".hashCode();
    private static final int ciP = "rowid".hashCode();
    private static final int cjt = "rawXML".hashCode();
    private static final int ckP = "appId".hashCode();
    private static final int ckb = "createTime".hashCode();
    private static final int cnU = "msgType".hashCode();
    private boolean cAN = true;
    private boolean cAO = true;
    private boolean cAP = true;
    private boolean cAQ = true;
    private boolean cAR = true;
    private boolean cAS = true;
    private boolean cAT = true;
    private boolean cAU = true;
    private boolean cAV = true;
    private boolean ciK = true;
    private boolean cjF = true;
    private boolean cjp = true;
    private boolean cky = true;
    private boolean cnG = true;
    public String field_appId;
    public long field_createTime;
    public long field_expireTime;
    public String field_gameMsgId;
    public boolean field_isHidden;
    public boolean field_isRead;
    public String field_label;
    public String field_mergerId;
    public long field_msgId;
    public int field_msgType;
    public String field_rawXML;
    public long field_receiveTime;
    public boolean field_showInMsgList;
    public String field_weight;

    public final void d(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (ciO == hashCode) {
                    this.field_msgId = cursor.getLong(i);
                    this.ciK = true;
                } else if (cAW == hashCode) {
                    this.field_mergerId = cursor.getString(i);
                } else if (cAX == hashCode) {
                    this.field_gameMsgId = cursor.getString(i);
                } else if (cnU == hashCode) {
                    this.field_msgType = cursor.getInt(i);
                } else if (ckb == hashCode) {
                    this.field_createTime = cursor.getLong(i);
                } else if (cAY == hashCode) {
                    this.field_expireTime = cursor.getLong(i);
                } else if (ckP == hashCode) {
                    this.field_appId = cursor.getString(i);
                } else if (cAZ == hashCode) {
                    this.field_showInMsgList = cursor.getInt(i) != 0;
                } else if (cBa == hashCode) {
                    this.field_isRead = cursor.getInt(i) != 0;
                } else if (cBb == hashCode) {
                    this.field_label = cursor.getString(i);
                } else if (cBc == hashCode) {
                    this.field_isHidden = cursor.getInt(i) != 0;
                } else if (cBd == hashCode) {
                    this.field_weight = cursor.getString(i);
                } else if (cjt == hashCode) {
                    this.field_rawXML = cursor.getString(i);
                } else if (cBe == hashCode) {
                    this.field_receiveTime = cursor.getLong(i);
                } else if (ciP == hashCode) {
                    this.sKx = cursor.getLong(i);
                }
            }
        }
    }

    public final ContentValues wH() {
        ContentValues contentValues = new ContentValues();
        if (this.ciK) {
            contentValues.put("msgId", Long.valueOf(this.field_msgId));
        }
        if (this.cAN) {
            contentValues.put("mergerId", this.field_mergerId);
        }
        if (this.cAO) {
            contentValues.put("gameMsgId", this.field_gameMsgId);
        }
        if (this.cnG) {
            contentValues.put("msgType", Integer.valueOf(this.field_msgType));
        }
        if (this.cjF) {
            contentValues.put("createTime", Long.valueOf(this.field_createTime));
        }
        if (this.cAP) {
            contentValues.put("expireTime", Long.valueOf(this.field_expireTime));
        }
        if (this.cky) {
            contentValues.put("appId", this.field_appId);
        }
        if (this.cAQ) {
            contentValues.put("showInMsgList", Boolean.valueOf(this.field_showInMsgList));
        }
        if (this.cAR) {
            contentValues.put("isRead", Boolean.valueOf(this.field_isRead));
        }
        if (this.field_label == null) {
            this.field_label = "";
        }
        if (this.cAS) {
            contentValues.put("label", this.field_label);
        }
        if (this.cAT) {
            contentValues.put("isHidden", Boolean.valueOf(this.field_isHidden));
        }
        if (this.field_weight == null) {
            this.field_weight = "";
        }
        if (this.cAU) {
            contentValues.put("weight", this.field_weight);
        }
        if (this.field_rawXML == null) {
            this.field_rawXML = "";
        }
        if (this.cjp) {
            contentValues.put("rawXML", this.field_rawXML);
        }
        if (this.cAV) {
            contentValues.put("receiveTime", Long.valueOf(this.field_receiveTime));
        }
        if (this.sKx > 0) {
            contentValues.put("rowid", Long.valueOf(this.sKx));
        }
        return contentValues;
    }
}
