package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class as extends c {
    public static final String[] ciG = new String[]{"CREATE INDEX IF NOT EXISTS emojiGroupIndex ON EmojiInfo(catalog)"};
    private static final int ciP = "rowid".hashCode();
    private static final int cke = "type".hashCode();
    private static final int ckj = "content".hashCode();
    private static final int clp = "size".hashCode();
    private static final int cnh = "source".hashCode();
    private static final int cuY = "lastUseTime".hashCode();
    private static final int cvM = "md5".hashCode();
    private static final int cvN = "svrid".hashCode();
    private static final int cvO = "catalog".hashCode();
    private static final int cvP = "start".hashCode();
    private static final int cvQ = "state".hashCode();
    private static final int cvR = "name".hashCode();
    private static final int cvS = "reserved1".hashCode();
    private static final int cvT = "reserved2".hashCode();
    private static final int cvU = "reserved3".hashCode();
    private static final int cvV = "reserved4".hashCode();
    private static final int cvW = "app_id".hashCode();
    private static final int cvX = "groupId".hashCode();
    private static final int cvY = "framesInfo".hashCode();
    private static final int cvZ = "temp".hashCode();
    private static final int cvc = "idx".hashCode();
    private static final int cwa = "needupload".hashCode();
    private static final int cwb = "designerID".hashCode();
    private static final int cwc = "thumbUrl".hashCode();
    private static final int cwd = "cdnUrl".hashCode();
    private static final int cwe = "encrypturl".hashCode();
    private static final int cwf = "aeskey".hashCode();
    private static final int cwg = "width".hashCode();
    private static final int cwh = "height".hashCode();
    private static final int cwi = "externUrl".hashCode();
    private static final int cwj = "externMd5".hashCode();
    private static final int cwk = "activityid".hashCode();
    private static final int cwl = "tpurl".hashCode();
    private static final int cwm = "tpauthkey".hashCode();
    private boolean cjI = true;
    private boolean cjN = true;
    private boolean clm = true;
    private boolean cnd = true;
    private boolean cuC = true;
    private boolean cuy = true;
    private boolean cvA = true;
    private boolean cvB = true;
    private boolean cvC = true;
    private boolean cvD = true;
    private boolean cvE = true;
    private boolean cvF = true;
    private boolean cvG = true;
    private boolean cvH = true;
    private boolean cvI = true;
    private boolean cvJ = true;
    private boolean cvK = true;
    private boolean cvL = true;
    private boolean cvk = true;
    private boolean cvl = true;
    private boolean cvm = true;
    private boolean cvn = true;
    private boolean cvo = true;
    private boolean cvp = true;
    private boolean cvq = true;
    private boolean cvr = true;
    private boolean cvs = true;
    private boolean cvt = true;
    private boolean cvu = true;
    private boolean cvw = true;
    private boolean cvx = true;
    private boolean cvy = true;
    private boolean cvz = true;
    public String field_activityid;
    public String field_aeskey;
    public String field_app_id;
    public int field_catalog;
    public String field_cdnUrl;
    public String field_content;
    public String field_designerID;
    public String field_encrypturl;
    public String field_externMd5;
    public String field_externUrl;
    public String field_framesInfo;
    public String field_groupId;
    public int field_height;
    public int field_idx;
    public long field_lastUseTime;
    public String field_md5;
    public String field_name;
    public int field_needupload;
    public String field_reserved1;
    public String field_reserved2;
    public int field_reserved3;
    public int field_reserved4;
    public int field_size;
    public int field_source;
    public int field_start;
    public int field_state;
    public String field_svrid;
    public int field_temp;
    public String field_thumbUrl;
    public String field_tpauthkey;
    public String field_tpurl;
    public int field_type;
    public int field_width;

    public final void d(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (cvM == hashCode) {
                    this.field_md5 = cursor.getString(i);
                    this.cvk = true;
                } else if (cvN == hashCode) {
                    this.field_svrid = cursor.getString(i);
                } else if (cvO == hashCode) {
                    this.field_catalog = cursor.getInt(i);
                } else if (cke == hashCode) {
                    this.field_type = cursor.getInt(i);
                } else if (clp == hashCode) {
                    this.field_size = cursor.getInt(i);
                } else if (cvP == hashCode) {
                    this.field_start = cursor.getInt(i);
                } else if (cvQ == hashCode) {
                    this.field_state = cursor.getInt(i);
                } else if (cvR == hashCode) {
                    this.field_name = cursor.getString(i);
                } else if (ckj == hashCode) {
                    this.field_content = cursor.getString(i);
                } else if (cvS == hashCode) {
                    this.field_reserved1 = cursor.getString(i);
                } else if (cvT == hashCode) {
                    this.field_reserved2 = cursor.getString(i);
                } else if (cvU == hashCode) {
                    this.field_reserved3 = cursor.getInt(i);
                } else if (cvV == hashCode) {
                    this.field_reserved4 = cursor.getInt(i);
                } else if (cvW == hashCode) {
                    this.field_app_id = cursor.getString(i);
                } else if (cvX == hashCode) {
                    this.field_groupId = cursor.getString(i);
                } else if (cuY == hashCode) {
                    this.field_lastUseTime = cursor.getLong(i);
                } else if (cvY == hashCode) {
                    this.field_framesInfo = cursor.getString(i);
                } else if (cvc == hashCode) {
                    this.field_idx = cursor.getInt(i);
                } else if (cvZ == hashCode) {
                    this.field_temp = cursor.getInt(i);
                } else if (cnh == hashCode) {
                    this.field_source = cursor.getInt(i);
                } else if (cwa == hashCode) {
                    this.field_needupload = cursor.getInt(i);
                } else if (cwb == hashCode) {
                    this.field_designerID = cursor.getString(i);
                } else if (cwc == hashCode) {
                    this.field_thumbUrl = cursor.getString(i);
                } else if (cwd == hashCode) {
                    this.field_cdnUrl = cursor.getString(i);
                } else if (cwe == hashCode) {
                    this.field_encrypturl = cursor.getString(i);
                } else if (cwf == hashCode) {
                    this.field_aeskey = cursor.getString(i);
                } else if (cwg == hashCode) {
                    this.field_width = cursor.getInt(i);
                } else if (cwh == hashCode) {
                    this.field_height = cursor.getInt(i);
                } else if (cwi == hashCode) {
                    this.field_externUrl = cursor.getString(i);
                } else if (cwj == hashCode) {
                    this.field_externMd5 = cursor.getString(i);
                } else if (cwk == hashCode) {
                    this.field_activityid = cursor.getString(i);
                } else if (cwl == hashCode) {
                    this.field_tpurl = cursor.getString(i);
                } else if (cwm == hashCode) {
                    this.field_tpauthkey = cursor.getString(i);
                } else if (ciP == hashCode) {
                    this.sKx = cursor.getLong(i);
                }
            }
        }
    }

    public final ContentValues wH() {
        ContentValues contentValues = new ContentValues();
        if (this.cvk) {
            contentValues.put("md5", this.field_md5);
        }
        if (this.cvl) {
            contentValues.put("svrid", this.field_svrid);
        }
        if (this.cvm) {
            contentValues.put("catalog", Integer.valueOf(this.field_catalog));
        }
        if (this.cjI) {
            contentValues.put("type", Integer.valueOf(this.field_type));
        }
        if (this.clm) {
            contentValues.put("size", Integer.valueOf(this.field_size));
        }
        if (this.cvn) {
            contentValues.put("start", Integer.valueOf(this.field_start));
        }
        if (this.cvo) {
            contentValues.put("state", Integer.valueOf(this.field_state));
        }
        if (this.cvp) {
            contentValues.put("name", this.field_name);
        }
        if (this.cjN) {
            contentValues.put("content", this.field_content);
        }
        if (this.cvq) {
            contentValues.put("reserved1", this.field_reserved1);
        }
        if (this.cvr) {
            contentValues.put("reserved2", this.field_reserved2);
        }
        if (this.cvs) {
            contentValues.put("reserved3", Integer.valueOf(this.field_reserved3));
        }
        if (this.cvt) {
            contentValues.put("reserved4", Integer.valueOf(this.field_reserved4));
        }
        if (this.cvu) {
            contentValues.put("app_id", this.field_app_id);
        }
        if (this.field_groupId == null) {
            this.field_groupId = "";
        }
        if (this.cvw) {
            contentValues.put("groupId", this.field_groupId);
        }
        if (this.cuy) {
            contentValues.put("lastUseTime", Long.valueOf(this.field_lastUseTime));
        }
        if (this.field_framesInfo == null) {
            this.field_framesInfo = "";
        }
        if (this.cvx) {
            contentValues.put("framesInfo", this.field_framesInfo);
        }
        if (this.cuC) {
            contentValues.put("idx", Integer.valueOf(this.field_idx));
        }
        if (this.cvy) {
            contentValues.put("temp", Integer.valueOf(this.field_temp));
        }
        if (this.cnd) {
            contentValues.put("source", Integer.valueOf(this.field_source));
        }
        if (this.cvz) {
            contentValues.put("needupload", Integer.valueOf(this.field_needupload));
        }
        if (this.cvA) {
            contentValues.put("designerID", this.field_designerID);
        }
        if (this.cvB) {
            contentValues.put("thumbUrl", this.field_thumbUrl);
        }
        if (this.cvC) {
            contentValues.put("cdnUrl", this.field_cdnUrl);
        }
        if (this.cvD) {
            contentValues.put("encrypturl", this.field_encrypturl);
        }
        if (this.cvE) {
            contentValues.put("aeskey", this.field_aeskey);
        }
        if (this.cvF) {
            contentValues.put("width", Integer.valueOf(this.field_width));
        }
        if (this.cvG) {
            contentValues.put("height", Integer.valueOf(this.field_height));
        }
        if (this.cvH) {
            contentValues.put("externUrl", this.field_externUrl);
        }
        if (this.cvI) {
            contentValues.put("externMd5", this.field_externMd5);
        }
        if (this.cvJ) {
            contentValues.put("activityid", this.field_activityid);
        }
        if (this.cvK) {
            contentValues.put("tpurl", this.field_tpurl);
        }
        if (this.cvL) {
            contentValues.put("tpauthkey", this.field_tpauthkey);
        }
        if (this.sKx > 0) {
            contentValues.put("rowid", Long.valueOf(this.sKx));
        }
        return contentValues;
    }

    public void reset() {
    }
}
