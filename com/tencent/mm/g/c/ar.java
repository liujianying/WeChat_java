package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class ar extends c {
    public static final String[] ciG = new String[0];
    private static final int ciP = "rowid".hashCode();
    private static final int ciV = "status".hashCode();
    private static final int cke = "type".hashCode();
    private static final int cnk = "flag".hashCode();
    private static final int cuK = "productID".hashCode();
    private static final int cuL = "packIconUrl".hashCode();
    private static final int cuM = "packGrayIconUrl".hashCode();
    private static final int cuN = "packCoverUrl".hashCode();
    private static final int cuO = "packName".hashCode();
    private static final int cuP = "packDesc".hashCode();
    private static final int cuQ = "packAuthInfo".hashCode();
    private static final int cuR = "packPrice".hashCode();
    private static final int cuS = "packType".hashCode();
    private static final int cuT = "packFlag".hashCode();
    private static final int cuU = "packExpire".hashCode();
    private static final int cuV = "packTimeStamp".hashCode();
    private static final int cuW = "packCopyright".hashCode();
    private static final int cuX = "sort".hashCode();
    private static final int cuY = "lastUseTime".hashCode();
    private static final int cuZ = "packStatus".hashCode();
    private static final int cva = "recommand".hashCode();
    private static final int cvb = "sync".hashCode();
    private static final int cvc = "idx".hashCode();
    private static final int cvd = "BigIconUrl".hashCode();
    private static final int cve = "MutiLanName".hashCode();
    private static final int cvf = "recommandType".hashCode();
    private static final int cvg = "lang".hashCode();
    private static final int cvh = "recommandWord".hashCode();
    private static final int cvi = "buttonType".hashCode();
    private static final int cvj = "count".hashCode();
    private boolean ciS = true;
    private boolean cjI = true;
    private boolean cni = true;
    private boolean cuA = true;
    private boolean cuB = true;
    private boolean cuC = true;
    private boolean cuD = true;
    private boolean cuE = true;
    private boolean cuF = true;
    private boolean cuG = true;
    private boolean cuH = true;
    private boolean cuI = true;
    private boolean cuJ = true;
    private boolean cuk = true;
    private boolean cul = true;
    private boolean cum = true;
    private boolean cun = true;
    private boolean cuo = true;
    private boolean cup = true;
    private boolean cuq = true;
    private boolean cur = true;
    private boolean cus = true;
    private boolean cut = true;
    private boolean cuu = true;
    private boolean cuv = true;
    private boolean cuw = true;
    private boolean cux = true;
    private boolean cuy = true;
    private boolean cuz = true;
    public String field_BigIconUrl;
    public String field_MutiLanName;
    public int field_buttonType;
    public int field_count;
    public int field_flag;
    public int field_idx;
    public String field_lang;
    public long field_lastUseTime;
    public String field_packAuthInfo;
    public String field_packCopyright;
    public String field_packCoverUrl;
    public String field_packDesc;
    public long field_packExpire;
    public int field_packFlag;
    public String field_packGrayIconUrl;
    public String field_packIconUrl;
    public String field_packName;
    public String field_packPrice;
    public int field_packStatus;
    public long field_packTimeStamp;
    public int field_packType;
    public String field_productID;
    public int field_recommand;
    public int field_recommandType;
    public String field_recommandWord;
    public int field_sort;
    public int field_status;
    public int field_sync;
    public int field_type;

    public final void d(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (cuK == hashCode) {
                    this.field_productID = cursor.getString(i);
                    this.cuk = true;
                } else if (cuL == hashCode) {
                    this.field_packIconUrl = cursor.getString(i);
                } else if (cuM == hashCode) {
                    this.field_packGrayIconUrl = cursor.getString(i);
                } else if (cuN == hashCode) {
                    this.field_packCoverUrl = cursor.getString(i);
                } else if (cuO == hashCode) {
                    this.field_packName = cursor.getString(i);
                } else if (cuP == hashCode) {
                    this.field_packDesc = cursor.getString(i);
                } else if (cuQ == hashCode) {
                    this.field_packAuthInfo = cursor.getString(i);
                } else if (cuR == hashCode) {
                    this.field_packPrice = cursor.getString(i);
                } else if (cuS == hashCode) {
                    this.field_packType = cursor.getInt(i);
                } else if (cuT == hashCode) {
                    this.field_packFlag = cursor.getInt(i);
                } else if (cuU == hashCode) {
                    this.field_packExpire = cursor.getLong(i);
                } else if (cuV == hashCode) {
                    this.field_packTimeStamp = cursor.getLong(i);
                } else if (cuW == hashCode) {
                    this.field_packCopyright = cursor.getString(i);
                } else if (cke == hashCode) {
                    this.field_type = cursor.getInt(i);
                } else if (ciV == hashCode) {
                    this.field_status = cursor.getInt(i);
                } else if (cuX == hashCode) {
                    this.field_sort = cursor.getInt(i);
                } else if (cuY == hashCode) {
                    this.field_lastUseTime = cursor.getLong(i);
                } else if (cuZ == hashCode) {
                    this.field_packStatus = cursor.getInt(i);
                } else if (cnk == hashCode) {
                    this.field_flag = cursor.getInt(i);
                } else if (cva == hashCode) {
                    this.field_recommand = cursor.getInt(i);
                } else if (cvb == hashCode) {
                    this.field_sync = cursor.getInt(i);
                } else if (cvc == hashCode) {
                    this.field_idx = cursor.getInt(i);
                } else if (cvd == hashCode) {
                    this.field_BigIconUrl = cursor.getString(i);
                } else if (cve == hashCode) {
                    this.field_MutiLanName = cursor.getString(i);
                } else if (cvf == hashCode) {
                    this.field_recommandType = cursor.getInt(i);
                } else if (cvg == hashCode) {
                    this.field_lang = cursor.getString(i);
                } else if (cvh == hashCode) {
                    this.field_recommandWord = cursor.getString(i);
                } else if (cvi == hashCode) {
                    this.field_buttonType = cursor.getInt(i);
                } else if (cvj == hashCode) {
                    this.field_count = cursor.getInt(i);
                } else if (ciP == hashCode) {
                    this.sKx = cursor.getLong(i);
                }
            }
        }
    }

    public final ContentValues wH() {
        ContentValues contentValues = new ContentValues();
        if (this.cuk) {
            contentValues.put("productID", this.field_productID);
        }
        if (this.cul) {
            contentValues.put("packIconUrl", this.field_packIconUrl);
        }
        if (this.cum) {
            contentValues.put("packGrayIconUrl", this.field_packGrayIconUrl);
        }
        if (this.cun) {
            contentValues.put("packCoverUrl", this.field_packCoverUrl);
        }
        if (this.cuo) {
            contentValues.put("packName", this.field_packName);
        }
        if (this.cup) {
            contentValues.put("packDesc", this.field_packDesc);
        }
        if (this.cuq) {
            contentValues.put("packAuthInfo", this.field_packAuthInfo);
        }
        if (this.cur) {
            contentValues.put("packPrice", this.field_packPrice);
        }
        if (this.cus) {
            contentValues.put("packType", Integer.valueOf(this.field_packType));
        }
        if (this.cut) {
            contentValues.put("packFlag", Integer.valueOf(this.field_packFlag));
        }
        if (this.cuu) {
            contentValues.put("packExpire", Long.valueOf(this.field_packExpire));
        }
        if (this.cuv) {
            contentValues.put("packTimeStamp", Long.valueOf(this.field_packTimeStamp));
        }
        if (this.cuw) {
            contentValues.put("packCopyright", this.field_packCopyright);
        }
        if (this.cjI) {
            contentValues.put("type", Integer.valueOf(this.field_type));
        }
        if (this.ciS) {
            contentValues.put("status", Integer.valueOf(this.field_status));
        }
        if (this.cux) {
            contentValues.put("sort", Integer.valueOf(this.field_sort));
        }
        if (this.cuy) {
            contentValues.put("lastUseTime", Long.valueOf(this.field_lastUseTime));
        }
        if (this.cuz) {
            contentValues.put("packStatus", Integer.valueOf(this.field_packStatus));
        }
        if (this.cni) {
            contentValues.put("flag", Integer.valueOf(this.field_flag));
        }
        if (this.cuA) {
            contentValues.put("recommand", Integer.valueOf(this.field_recommand));
        }
        if (this.cuB) {
            contentValues.put("sync", Integer.valueOf(this.field_sync));
        }
        if (this.cuC) {
            contentValues.put("idx", Integer.valueOf(this.field_idx));
        }
        if (this.cuD) {
            contentValues.put("BigIconUrl", this.field_BigIconUrl);
        }
        if (this.cuE) {
            contentValues.put("MutiLanName", this.field_MutiLanName);
        }
        if (this.cuF) {
            contentValues.put("recommandType", Integer.valueOf(this.field_recommandType));
        }
        if (this.cuG) {
            contentValues.put("lang", this.field_lang);
        }
        if (this.cuH) {
            contentValues.put("recommandWord", this.field_recommandWord);
        }
        if (this.cuI) {
            contentValues.put("buttonType", Integer.valueOf(this.field_buttonType));
        }
        if (this.cuJ) {
            contentValues.put("count", Integer.valueOf(this.field_count));
        }
        if (this.sKx > 0) {
            contentValues.put("rowid", Long.valueOf(this.sKx));
        }
        return contentValues;
    }
}
