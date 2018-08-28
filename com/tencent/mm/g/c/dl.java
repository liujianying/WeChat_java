package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class dl extends c {
    private static final int cDi = "score".hashCode();
    private static final int cLX = "daySec".hashCode();
    private static final int cLY = "isMute".hashCode();
    private static final int cLZ = "sendCount".hashCode();
    private static final int cMa = "enterCount".hashCode();
    private static final int cMb = "disRedDotCount".hashCode();
    private static final int cMc = "stayTime".hashCode();
    public static final String[] ciG = new String[0];
    private static final int ciN = "chatroom".hashCode();
    private static final int ciP = "rowid".hashCode();
    private static final int cnK = "unReadCount".hashCode();
    private static final int cpI = "nickname".hashCode();
    private boolean cDh = true;
    private boolean cLR = true;
    private boolean cLS = true;
    private boolean cLT = true;
    private boolean cLU = true;
    private boolean cLV = true;
    private boolean cLW = true;
    private boolean ciJ = true;
    private boolean cnw = true;
    private boolean cpE = true;
    public String field_chatroom;
    public String field_daySec;
    public int field_disRedDotCount;
    public int field_enterCount;
    public int field_isMute;
    public String field_nickname;
    public float field_score;
    public int field_sendCount;
    public long field_stayTime;
    public int field_unReadCount;

    public final void d(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (ciN == hashCode) {
                    this.field_chatroom = cursor.getString(i);
                } else if (cLX == hashCode) {
                    this.field_daySec = cursor.getString(i);
                } else if (cpI == hashCode) {
                    this.field_nickname = cursor.getString(i);
                } else if (cLY == hashCode) {
                    this.field_isMute = cursor.getInt(i);
                } else if (cnK == hashCode) {
                    this.field_unReadCount = cursor.getInt(i);
                } else if (cLZ == hashCode) {
                    this.field_sendCount = cursor.getInt(i);
                } else if (cMa == hashCode) {
                    this.field_enterCount = cursor.getInt(i);
                } else if (cMb == hashCode) {
                    this.field_disRedDotCount = cursor.getInt(i);
                } else if (cMc == hashCode) {
                    this.field_stayTime = cursor.getLong(i);
                } else if (cDi == hashCode) {
                    this.field_score = cursor.getFloat(i);
                } else if (ciP == hashCode) {
                    this.sKx = cursor.getLong(i);
                }
            }
        }
    }

    public final ContentValues wH() {
        ContentValues contentValues = new ContentValues();
        if (this.ciJ) {
            contentValues.put("chatroom", this.field_chatroom);
        }
        if (this.cLR) {
            contentValues.put("daySec", this.field_daySec);
        }
        if (this.cpE) {
            contentValues.put("nickname", this.field_nickname);
        }
        if (this.cLS) {
            contentValues.put("isMute", Integer.valueOf(this.field_isMute));
        }
        if (this.cnw) {
            contentValues.put("unReadCount", Integer.valueOf(this.field_unReadCount));
        }
        if (this.cLT) {
            contentValues.put("sendCount", Integer.valueOf(this.field_sendCount));
        }
        if (this.cLU) {
            contentValues.put("enterCount", Integer.valueOf(this.field_enterCount));
        }
        if (this.cLV) {
            contentValues.put("disRedDotCount", Integer.valueOf(this.field_disRedDotCount));
        }
        if (this.cLW) {
            contentValues.put("stayTime", Long.valueOf(this.field_stayTime));
        }
        if (this.cDh) {
            contentValues.put("score", Float.valueOf(this.field_score));
        }
        if (this.sKx > 0) {
            contentValues.put("rowid", Long.valueOf(this.sKx));
        }
        return contentValues;
    }
}
