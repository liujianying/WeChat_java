package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class bb extends c {
    public static final String[] ciG = new String[]{"CREATE INDEX IF NOT EXISTS fmconversation_isnew_Index ON fmessage_conversation(isNew)"};
    private static final int ciP = "rowid".hashCode();
    private static final int cpT = "talker".hashCode();
    private static final int cvQ = "state".hashCode();
    private static final int cxi = "encryptTalker".hashCode();
    private static final int cxj = "displayName".hashCode();
    private static final int cxk = "lastModifiedTime".hashCode();
    private static final int cxl = "isNew".hashCode();
    private static final int cxm = "addScene".hashCode();
    private static final int cxn = "fmsgSysRowId".hashCode();
    private static final int cxo = "fmsgIsSend".hashCode();
    private static final int cxp = "fmsgType".hashCode();
    private static final int cxq = "fmsgContent".hashCode();
    private static final int cxr = "recvFmsgType".hashCode();
    private static final int cxs = "contentFromUsername".hashCode();
    private static final int cxt = "contentNickname".hashCode();
    private static final int cxu = "contentPhoneNumMD5".hashCode();
    private static final int cxv = "contentFullPhoneNumMD5".hashCode();
    private static final int cxw = "contentVerifyContent".hashCode();
    private boolean cpL = true;
    private boolean cvo = true;
    private boolean cwT = true;
    private boolean cwU = true;
    private boolean cwV = true;
    private boolean cwW = true;
    private boolean cwX = true;
    private boolean cwY = true;
    private boolean cwZ = true;
    private boolean cxa = true;
    private boolean cxb = true;
    private boolean cxc = true;
    private boolean cxd = true;
    private boolean cxe = true;
    private boolean cxf = true;
    private boolean cxg = true;
    private boolean cxh = true;
    public int field_addScene;
    public String field_contentFromUsername;
    public String field_contentFullPhoneNumMD5;
    public String field_contentNickname;
    public String field_contentPhoneNumMD5;
    public String field_contentVerifyContent;
    public String field_displayName;
    public String field_encryptTalker;
    public String field_fmsgContent;
    public int field_fmsgIsSend;
    public long field_fmsgSysRowId;
    public int field_fmsgType;
    public int field_isNew;
    public long field_lastModifiedTime;
    public int field_recvFmsgType;
    public int field_state;
    public String field_talker;

    public final void d(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (cpT == hashCode) {
                    this.field_talker = cursor.getString(i);
                    this.cpL = true;
                } else if (cxi == hashCode) {
                    this.field_encryptTalker = cursor.getString(i);
                } else if (cxj == hashCode) {
                    this.field_displayName = cursor.getString(i);
                } else if (cvQ == hashCode) {
                    this.field_state = cursor.getInt(i);
                } else if (cxk == hashCode) {
                    this.field_lastModifiedTime = cursor.getLong(i);
                } else if (cxl == hashCode) {
                    this.field_isNew = cursor.getInt(i);
                } else if (cxm == hashCode) {
                    this.field_addScene = cursor.getInt(i);
                } else if (cxn == hashCode) {
                    this.field_fmsgSysRowId = cursor.getLong(i);
                } else if (cxo == hashCode) {
                    this.field_fmsgIsSend = cursor.getInt(i);
                } else if (cxp == hashCode) {
                    this.field_fmsgType = cursor.getInt(i);
                } else if (cxq == hashCode) {
                    this.field_fmsgContent = cursor.getString(i);
                } else if (cxr == hashCode) {
                    this.field_recvFmsgType = cursor.getInt(i);
                } else if (cxs == hashCode) {
                    this.field_contentFromUsername = cursor.getString(i);
                } else if (cxt == hashCode) {
                    this.field_contentNickname = cursor.getString(i);
                } else if (cxu == hashCode) {
                    this.field_contentPhoneNumMD5 = cursor.getString(i);
                } else if (cxv == hashCode) {
                    this.field_contentFullPhoneNumMD5 = cursor.getString(i);
                } else if (cxw == hashCode) {
                    this.field_contentVerifyContent = cursor.getString(i);
                } else if (ciP == hashCode) {
                    this.sKx = cursor.getLong(i);
                }
            }
        }
    }

    public final ContentValues wH() {
        ContentValues contentValues = new ContentValues();
        if (this.field_talker == null) {
            this.field_talker = "0";
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
        if (this.field_displayName == null) {
            this.field_displayName = "";
        }
        if (this.cwU) {
            contentValues.put("displayName", this.field_displayName);
        }
        if (this.cvo) {
            contentValues.put("state", Integer.valueOf(this.field_state));
        }
        if (this.cwV) {
            contentValues.put("lastModifiedTime", Long.valueOf(this.field_lastModifiedTime));
        }
        if (this.cwW) {
            contentValues.put("isNew", Integer.valueOf(this.field_isNew));
        }
        if (this.cwX) {
            contentValues.put("addScene", Integer.valueOf(this.field_addScene));
        }
        if (this.cwY) {
            contentValues.put("fmsgSysRowId", Long.valueOf(this.field_fmsgSysRowId));
        }
        if (this.cwZ) {
            contentValues.put("fmsgIsSend", Integer.valueOf(this.field_fmsgIsSend));
        }
        if (this.cxa) {
            contentValues.put("fmsgType", Integer.valueOf(this.field_fmsgType));
        }
        if (this.field_fmsgContent == null) {
            this.field_fmsgContent = "";
        }
        if (this.cxb) {
            contentValues.put("fmsgContent", this.field_fmsgContent);
        }
        if (this.cxc) {
            contentValues.put("recvFmsgType", Integer.valueOf(this.field_recvFmsgType));
        }
        if (this.field_contentFromUsername == null) {
            this.field_contentFromUsername = "";
        }
        if (this.cxd) {
            contentValues.put("contentFromUsername", this.field_contentFromUsername);
        }
        if (this.field_contentNickname == null) {
            this.field_contentNickname = "";
        }
        if (this.cxe) {
            contentValues.put("contentNickname", this.field_contentNickname);
        }
        if (this.field_contentPhoneNumMD5 == null) {
            this.field_contentPhoneNumMD5 = "";
        }
        if (this.cxf) {
            contentValues.put("contentPhoneNumMD5", this.field_contentPhoneNumMD5);
        }
        if (this.field_contentFullPhoneNumMD5 == null) {
            this.field_contentFullPhoneNumMD5 = "";
        }
        if (this.cxg) {
            contentValues.put("contentFullPhoneNumMD5", this.field_contentFullPhoneNumMD5);
        }
        if (this.field_contentVerifyContent == null) {
            this.field_contentVerifyContent = "";
        }
        if (this.cxh) {
            contentValues.put("contentVerifyContent", this.field_contentVerifyContent);
        }
        if (this.sKx > 0) {
            contentValues.put("rowid", Long.valueOf(this.sKx));
        }
        return contentValues;
    }
}
