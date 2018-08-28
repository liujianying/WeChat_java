package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class do extends c {
    private static final int cMC = "shakeItemID".hashCode();
    private static final int cMD = "province".hashCode();
    private static final int cME = "city".hashCode();
    private static final int cMF = "distance".hashCode();
    private static final int cMG = "sex".hashCode();
    private static final int cMH = "imgstatus".hashCode();
    private static final int cMI = "hasHDImg".hashCode();
    private static final int cMJ = "insertBatch".hashCode();
    private static final int cMK = "regionCode".hashCode();
    private static final int cML = "snsFlag".hashCode();
    private static final int cMM = "sns_bgurl".hashCode();
    public static final String[] ciG = new String[0];
    private static final int ciP = "rowid".hashCode();
    private static final int cke = "type".hashCode();
    private static final int cld = "signature".hashCode();
    private static final int cli = "username".hashCode();
    private static final int cpI = "nickname".hashCode();
    private static final int cpV = "lvbuffer".hashCode();
    private static final int cvS = "reserved1".hashCode();
    private static final int cvT = "reserved2".hashCode();
    private static final int cvU = "reserved3".hashCode();
    private static final int cvV = "reserved4".hashCode();
    private boolean cMA = true;
    private boolean cMB = true;
    private boolean cMr = true;
    private boolean cMs = true;
    private boolean cMt = true;
    private boolean cMu = true;
    private boolean cMv = true;
    private boolean cMw = true;
    private boolean cMx = true;
    private boolean cMy = true;
    private boolean cMz = true;
    private boolean cjI = true;
    private boolean ckM = true;
    private boolean clg = true;
    private boolean cpE = true;
    private boolean cpN = true;
    private boolean cvq = true;
    private boolean cvr = true;
    private boolean cvs = true;
    private boolean cvt = true;
    public String field_city;
    public String field_distance;
    public int field_hasHDImg;
    public int field_imgstatus;
    public int field_insertBatch;
    public byte[] field_lvbuffer;
    public String field_nickname;
    public String field_province;
    public String field_regionCode;
    public int field_reserved1;
    public int field_reserved2;
    public String field_reserved3;
    public String field_reserved4;
    public int field_sex;
    public int field_shakeItemID;
    public String field_signature;
    public int field_snsFlag;
    public String field_sns_bgurl;
    public int field_type;
    public String field_username;

    public final void d(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (cMC == hashCode) {
                    this.field_shakeItemID = cursor.getInt(i);
                    this.cMr = true;
                } else if (cli == hashCode) {
                    this.field_username = cursor.getString(i);
                } else if (cpI == hashCode) {
                    this.field_nickname = cursor.getString(i);
                } else if (cMD == hashCode) {
                    this.field_province = cursor.getString(i);
                } else if (cME == hashCode) {
                    this.field_city = cursor.getString(i);
                } else if (cld == hashCode) {
                    this.field_signature = cursor.getString(i);
                } else if (cMF == hashCode) {
                    this.field_distance = cursor.getString(i);
                } else if (cMG == hashCode) {
                    this.field_sex = cursor.getInt(i);
                } else if (cMH == hashCode) {
                    this.field_imgstatus = cursor.getInt(i);
                } else if (cMI == hashCode) {
                    this.field_hasHDImg = cursor.getInt(i);
                } else if (cMJ == hashCode) {
                    this.field_insertBatch = cursor.getInt(i);
                } else if (cvS == hashCode) {
                    this.field_reserved1 = cursor.getInt(i);
                } else if (cvT == hashCode) {
                    this.field_reserved2 = cursor.getInt(i);
                } else if (cvU == hashCode) {
                    this.field_reserved3 = cursor.getString(i);
                } else if (cvV == hashCode) {
                    this.field_reserved4 = cursor.getString(i);
                } else if (cke == hashCode) {
                    this.field_type = cursor.getInt(i);
                } else if (cpV == hashCode) {
                    this.field_lvbuffer = cursor.getBlob(i);
                } else if (cMK == hashCode) {
                    this.field_regionCode = cursor.getString(i);
                } else if (cML == hashCode) {
                    this.field_snsFlag = cursor.getInt(i);
                } else if (cMM == hashCode) {
                    this.field_sns_bgurl = cursor.getString(i);
                } else if (ciP == hashCode) {
                    this.sKx = cursor.getLong(i);
                }
            }
        }
    }

    public ContentValues wH() {
        ContentValues contentValues = new ContentValues();
        if (this.cMr) {
            contentValues.put("shakeItemID", Integer.valueOf(this.field_shakeItemID));
        }
        if (this.clg) {
            contentValues.put("username", this.field_username);
        }
        if (this.cpE) {
            contentValues.put("nickname", this.field_nickname);
        }
        if (this.cMs) {
            contentValues.put("province", this.field_province);
        }
        if (this.cMt) {
            contentValues.put("city", this.field_city);
        }
        if (this.ckM) {
            contentValues.put("signature", this.field_signature);
        }
        if (this.cMu) {
            contentValues.put("distance", this.field_distance);
        }
        if (this.cMv) {
            contentValues.put("sex", Integer.valueOf(this.field_sex));
        }
        if (this.cMw) {
            contentValues.put("imgstatus", Integer.valueOf(this.field_imgstatus));
        }
        if (this.cMx) {
            contentValues.put("hasHDImg", Integer.valueOf(this.field_hasHDImg));
        }
        if (this.cMy) {
            contentValues.put("insertBatch", Integer.valueOf(this.field_insertBatch));
        }
        if (this.cvq) {
            contentValues.put("reserved1", Integer.valueOf(this.field_reserved1));
        }
        if (this.cvr) {
            contentValues.put("reserved2", Integer.valueOf(this.field_reserved2));
        }
        if (this.cvs) {
            contentValues.put("reserved3", this.field_reserved3);
        }
        if (this.cvt) {
            contentValues.put("reserved4", this.field_reserved4);
        }
        if (this.cjI) {
            contentValues.put("type", Integer.valueOf(this.field_type));
        }
        if (this.cpN) {
            contentValues.put("lvbuffer", this.field_lvbuffer);
        }
        if (this.cMz) {
            contentValues.put("regionCode", this.field_regionCode);
        }
        if (this.cMA) {
            contentValues.put("snsFlag", Integer.valueOf(this.field_snsFlag));
        }
        if (this.cMB) {
            contentValues.put("sns_bgurl", this.field_sns_bgurl);
        }
        if (this.sKx > 0) {
            contentValues.put("rowid", Long.valueOf(this.sKx));
        }
        return contentValues;
    }
}
