package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class cn extends c {
    private static final int cGT = "wxGroupId".hashCode();
    private static final int cGU = "roomId".hashCode();
    private static final int cGV = "roomKey".hashCode();
    private static final int cGW = "routeId".hashCode();
    private static final int cGX = "inviteUserName".hashCode();
    private static final int cGY = "memberCount".hashCode();
    public static final String[] ciG = new String[0];
    private static final int ciP = "rowid".hashCode();
    private static final int ckb = "createTime".hashCode();
    private static final int cvQ = "state".hashCode();
    private static final int cvX = "groupId".hashCode();
    private boolean cGN = true;
    private boolean cGO = true;
    private boolean cGP = true;
    private boolean cGQ = true;
    private boolean cGR = true;
    private boolean cGS = true;
    private boolean cjF = true;
    private boolean cvo = true;
    private boolean cvw = true;
    public long field_createTime;
    public String field_groupId;
    public String field_inviteUserName;
    public int field_memberCount;
    public int field_roomId;
    public long field_roomKey;
    public int field_routeId;
    public int field_state;
    public String field_wxGroupId;

    public final void d(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (cGT == hashCode) {
                    this.field_wxGroupId = cursor.getString(i);
                    this.cGN = true;
                } else if (cvX == hashCode) {
                    this.field_groupId = cursor.getString(i);
                } else if (cGU == hashCode) {
                    this.field_roomId = cursor.getInt(i);
                } else if (cGV == hashCode) {
                    this.field_roomKey = cursor.getLong(i);
                } else if (cGW == hashCode) {
                    this.field_routeId = cursor.getInt(i);
                } else if (cGX == hashCode) {
                    this.field_inviteUserName = cursor.getString(i);
                } else if (cGY == hashCode) {
                    this.field_memberCount = cursor.getInt(i);
                } else if (ckb == hashCode) {
                    this.field_createTime = cursor.getLong(i);
                } else if (cvQ == hashCode) {
                    this.field_state = cursor.getInt(i);
                } else if (ciP == hashCode) {
                    this.sKx = cursor.getLong(i);
                }
            }
        }
    }

    public final ContentValues wH() {
        ContentValues contentValues = new ContentValues();
        if (this.cGN) {
            contentValues.put("wxGroupId", this.field_wxGroupId);
        }
        if (this.cvw) {
            contentValues.put("groupId", this.field_groupId);
        }
        if (this.cGO) {
            contentValues.put("roomId", Integer.valueOf(this.field_roomId));
        }
        if (this.cGP) {
            contentValues.put("roomKey", Long.valueOf(this.field_roomKey));
        }
        if (this.cGQ) {
            contentValues.put("routeId", Integer.valueOf(this.field_routeId));
        }
        if (this.cGR) {
            contentValues.put("inviteUserName", this.field_inviteUserName);
        }
        if (this.cGS) {
            contentValues.put("memberCount", Integer.valueOf(this.field_memberCount));
        }
        if (this.cjF) {
            contentValues.put("createTime", Long.valueOf(this.field_createTime));
        }
        if (this.cvo) {
            contentValues.put("state", Integer.valueOf(this.field_state));
        }
        if (this.sKx > 0) {
            contentValues.put("rowid", Long.valueOf(this.sKx));
        }
        return contentValues;
    }
}
