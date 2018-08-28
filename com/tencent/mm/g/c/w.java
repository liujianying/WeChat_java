package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class w extends c {
    public static final String[] ciG = new String[0];
    private static final int ciP = "rowid".hashCode();
    private static final int cnJ = "brandUserName".hashCode();
    private static final int cnS = "chatType".hashCode();
    private static final int coi = "bizChatLocalId".hashCode();
    private static final int coj = "bizChatServId".hashCode();
    private static final int cok = "headImageUrl".hashCode();
    private static final int col = "chatName".hashCode();
    private static final int com = "chatNamePY".hashCode();
    private static final int con = "chatVersion".hashCode();
    private static final int coo = "needToUpdate".hashCode();
    private static final int cop = "bitFlag".hashCode();
    private static final int coq = "maxMemberCnt".hashCode();
    private static final int cor = "ownerUserId".hashCode();
    private static final int cos = "userList".hashCode();
    private static final int cot = "addMemberUrl".hashCode();
    private boolean cnE = true;
    private boolean cnW = true;
    private boolean cnX = true;
    private boolean cnY = true;
    private boolean cnZ = true;
    private boolean cnv = true;
    private boolean coa = true;
    private boolean cob = true;
    private boolean coc = true;
    private boolean cod = true;
    private boolean coe = true;
    private boolean cof = true;
    private boolean cog = true;
    private boolean coh = true;
    public String field_addMemberUrl;
    public int field_bitFlag;
    public long field_bizChatLocalId;
    public String field_bizChatServId;
    public String field_brandUserName;
    public String field_chatName;
    public String field_chatNamePY;
    public int field_chatType;
    public int field_chatVersion;
    public String field_headImageUrl;
    public int field_maxMemberCnt;
    public boolean field_needToUpdate;
    public String field_ownerUserId;
    public String field_userList;

    public final void d(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (coi == hashCode) {
                    this.field_bizChatLocalId = cursor.getLong(i);
                    this.cnW = true;
                } else if (coj == hashCode) {
                    this.field_bizChatServId = cursor.getString(i);
                } else if (cnJ == hashCode) {
                    this.field_brandUserName = cursor.getString(i);
                } else if (cnS == hashCode) {
                    this.field_chatType = cursor.getInt(i);
                } else if (cok == hashCode) {
                    this.field_headImageUrl = cursor.getString(i);
                } else if (col == hashCode) {
                    this.field_chatName = cursor.getString(i);
                } else if (com == hashCode) {
                    this.field_chatNamePY = cursor.getString(i);
                } else if (con == hashCode) {
                    this.field_chatVersion = cursor.getInt(i);
                } else if (coo == hashCode) {
                    this.field_needToUpdate = cursor.getInt(i) != 0;
                } else if (cop == hashCode) {
                    this.field_bitFlag = cursor.getInt(i);
                } else if (coq == hashCode) {
                    this.field_maxMemberCnt = cursor.getInt(i);
                } else if (cor == hashCode) {
                    this.field_ownerUserId = cursor.getString(i);
                } else if (cos == hashCode) {
                    this.field_userList = cursor.getString(i);
                } else if (cot == hashCode) {
                    this.field_addMemberUrl = cursor.getString(i);
                } else if (ciP == hashCode) {
                    this.sKx = cursor.getLong(i);
                }
            }
        }
    }

    public final ContentValues wH() {
        ContentValues contentValues = new ContentValues();
        if (this.cnW) {
            contentValues.put("bizChatLocalId", Long.valueOf(this.field_bizChatLocalId));
        }
        if (this.cnX) {
            contentValues.put("bizChatServId", this.field_bizChatServId);
        }
        if (this.field_brandUserName == null) {
            this.field_brandUserName = "";
        }
        if (this.cnv) {
            contentValues.put("brandUserName", this.field_brandUserName);
        }
        if (this.cnE) {
            contentValues.put("chatType", Integer.valueOf(this.field_chatType));
        }
        if (this.cnY) {
            contentValues.put("headImageUrl", this.field_headImageUrl);
        }
        if (this.field_chatName == null) {
            this.field_chatName = "";
        }
        if (this.cnZ) {
            contentValues.put("chatName", this.field_chatName);
        }
        if (this.field_chatNamePY == null) {
            this.field_chatNamePY = "";
        }
        if (this.coa) {
            contentValues.put("chatNamePY", this.field_chatNamePY);
        }
        if (this.cob) {
            contentValues.put("chatVersion", Integer.valueOf(this.field_chatVersion));
        }
        if (this.coc) {
            contentValues.put("needToUpdate", Boolean.valueOf(this.field_needToUpdate));
        }
        if (this.cod) {
            contentValues.put("bitFlag", Integer.valueOf(this.field_bitFlag));
        }
        if (this.coe) {
            contentValues.put("maxMemberCnt", Integer.valueOf(this.field_maxMemberCnt));
        }
        if (this.cof) {
            contentValues.put("ownerUserId", this.field_ownerUserId);
        }
        if (this.cog) {
            contentValues.put("userList", this.field_userList);
        }
        if (this.coh) {
            contentValues.put("addMemberUrl", this.field_addMemberUrl);
        }
        if (this.sKx > 0) {
            contentValues.put("rowid", Long.valueOf(this.sKx));
        }
        return contentValues;
    }
}
