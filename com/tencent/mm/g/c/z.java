package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class z extends c {
    public static final String[] ciG = new String[0];
    private static final int ciP = "rowid".hashCode();
    private static final int cjZ = "userName".hashCode();
    private static final int coO = "qyUin".hashCode();
    private static final int coP = "userUin".hashCode();
    private static final int coQ = "userFlag".hashCode();
    private static final int coR = "wwExposeTimes".hashCode();
    private static final int coS = "wwMaxExposeTimes".hashCode();
    private static final int coT = "wwCorpId".hashCode();
    private static final int coU = "wwUserVid".hashCode();
    private static final int coV = "userType".hashCode();
    private static final int coW = "chatOpen".hashCode();
    private static final int coX = "wwUnreadCnt".hashCode();
    private static final int coY = "show_confirm".hashCode();
    private static final int coZ = "use_preset_banner_tips".hashCode();
    private boolean cjD = true;
    private boolean coC = true;
    private boolean coD = true;
    private boolean coE = true;
    private boolean coF = true;
    private boolean coG = true;
    private boolean coH = true;
    private boolean coI = true;
    private boolean coJ = true;
    private boolean coK = true;
    private boolean coL = true;
    private boolean coM = true;
    private boolean coN = true;
    public boolean field_chatOpen;
    public int field_qyUin;
    public boolean field_show_confirm;
    public boolean field_use_preset_banner_tips;
    public int field_userFlag;
    public String field_userName;
    public int field_userType;
    public int field_userUin;
    public long field_wwCorpId;
    public int field_wwExposeTimes;
    public int field_wwMaxExposeTimes;
    public int field_wwUnreadCnt;
    public long field_wwUserVid;

    public final void d(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (cjZ == hashCode) {
                    this.field_userName = cursor.getString(i);
                    this.cjD = true;
                } else if (coO == hashCode) {
                    this.field_qyUin = cursor.getInt(i);
                } else if (coP == hashCode) {
                    this.field_userUin = cursor.getInt(i);
                } else if (coQ == hashCode) {
                    this.field_userFlag = cursor.getInt(i);
                } else if (coR == hashCode) {
                    this.field_wwExposeTimes = cursor.getInt(i);
                } else if (coS == hashCode) {
                    this.field_wwMaxExposeTimes = cursor.getInt(i);
                } else if (coT == hashCode) {
                    this.field_wwCorpId = cursor.getLong(i);
                } else if (coU == hashCode) {
                    this.field_wwUserVid = cursor.getLong(i);
                } else if (coV == hashCode) {
                    this.field_userType = cursor.getInt(i);
                } else if (coW == hashCode) {
                    this.field_chatOpen = cursor.getInt(i) != 0;
                } else if (coX == hashCode) {
                    this.field_wwUnreadCnt = cursor.getInt(i);
                } else if (coY == hashCode) {
                    this.field_show_confirm = cursor.getInt(i) != 0;
                } else if (coZ == hashCode) {
                    this.field_use_preset_banner_tips = cursor.getInt(i) != 0;
                } else if (ciP == hashCode) {
                    this.sKx = cursor.getLong(i);
                }
            }
        }
    }

    public final ContentValues wH() {
        ContentValues contentValues = new ContentValues();
        if (this.cjD) {
            contentValues.put("userName", this.field_userName);
        }
        if (this.coC) {
            contentValues.put("qyUin", Integer.valueOf(this.field_qyUin));
        }
        if (this.coD) {
            contentValues.put("userUin", Integer.valueOf(this.field_userUin));
        }
        if (this.coE) {
            contentValues.put("userFlag", Integer.valueOf(this.field_userFlag));
        }
        if (this.coF) {
            contentValues.put("wwExposeTimes", Integer.valueOf(this.field_wwExposeTimes));
        }
        if (this.coG) {
            contentValues.put("wwMaxExposeTimes", Integer.valueOf(this.field_wwMaxExposeTimes));
        }
        if (this.coH) {
            contentValues.put("wwCorpId", Long.valueOf(this.field_wwCorpId));
        }
        if (this.coI) {
            contentValues.put("wwUserVid", Long.valueOf(this.field_wwUserVid));
        }
        if (this.coJ) {
            contentValues.put("userType", Integer.valueOf(this.field_userType));
        }
        if (this.coK) {
            contentValues.put("chatOpen", Boolean.valueOf(this.field_chatOpen));
        }
        if (this.coL) {
            contentValues.put("wwUnreadCnt", Integer.valueOf(this.field_wwUnreadCnt));
        }
        if (this.coM) {
            contentValues.put("show_confirm", Boolean.valueOf(this.field_show_confirm));
        }
        if (this.coN) {
            contentValues.put("use_preset_banner_tips", Boolean.valueOf(this.field_use_preset_banner_tips));
        }
        if (this.sKx > 0) {
            contentValues.put("rowid", Long.valueOf(this.sKx));
        }
        return contentValues;
    }
}
