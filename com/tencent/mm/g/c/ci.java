package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class ci extends c {
    private static final int cEU = "LabsAppId".hashCode();
    private static final int cEV = "Type".hashCode();
    private static final int cEW = "BizType".hashCode();
    private static final int cEX = "Switch".hashCode();
    private static final int cEY = "AllVer".hashCode();
    private static final int cEZ = "DetailURL".hashCode();
    private static final int cFA = "RedPoint".hashCode();
    private static final int cFB = "WeAppDebugMode".hashCode();
    private static final int cFC = "idkey".hashCode();
    private static final int cFD = "idkeyValue".hashCode();
    private static final int cFE = "Icon".hashCode();
    private static final int cFF = "ImgUrl_cn".hashCode();
    private static final int cFG = "ImgUrl_hk".hashCode();
    private static final int cFH = "ImgUrl_tw".hashCode();
    private static final int cFI = "ImgUrl_en".hashCode();
    private static final int cFa = "WeAppUser".hashCode();
    private static final int cFb = "WeAppPath".hashCode();
    private static final int cFc = "Pos".hashCode();
    private static final int cFd = "TitleKey_android".hashCode();
    private static final int cFe = "Title_cn".hashCode();
    private static final int cFf = "Title_hk".hashCode();
    private static final int cFg = "Title_tw".hashCode();
    private static final int cFh = "Title_en".hashCode();
    private static final int cFi = "Desc_cn".hashCode();
    private static final int cFj = "Desc_hk".hashCode();
    private static final int cFk = "Desc_tw".hashCode();
    private static final int cFl = "Desc_en".hashCode();
    private static final int cFm = "Introduce_cn".hashCode();
    private static final int cFn = "Introduce_hk".hashCode();
    private static final int cFo = "Introduce_tw".hashCode();
    private static final int cFp = "Introduce_en".hashCode();
    private static final int cFq = "starttime".hashCode();
    private static final int cFr = "endtime".hashCode();
    private static final int cFs = "ThumbUrl_cn".hashCode();
    private static final int cFt = "ThumbUrl_hk".hashCode();
    private static final int cFu = "ThumbUrl_tw".hashCode();
    private static final int cFv = "ThumbUrl_en".hashCode();
    private static final int cFw = "ImgUrl_android_cn".hashCode();
    private static final int cFx = "ImgUrl_android_hk".hashCode();
    private static final int cFy = "ImgUrl_android_tw".hashCode();
    private static final int cFz = "ImgUrl_android_en".hashCode();
    public static final String[] ciG = new String[0];
    private static final int ciP = "rowid".hashCode();
    private static final int ciV = "status".hashCode();
    private static final int cjg = "expId".hashCode();
    private static final int cjh = "sequence".hashCode();
    private static final int cji = "prioritylevel".hashCode();
    private boolean cEA = true;
    private boolean cEB = true;
    private boolean cEC = true;
    private boolean cED = true;
    private boolean cEE = true;
    private boolean cEF = true;
    private boolean cEG = true;
    private boolean cEH = true;
    private boolean cEI = true;
    private boolean cEJ = true;
    private boolean cEK = true;
    private boolean cEL = true;
    private boolean cEM = true;
    private boolean cEN = true;
    private boolean cEO = true;
    private boolean cEP = true;
    private boolean cEQ = true;
    private boolean cER = true;
    private boolean cES = true;
    private boolean cET = true;
    private boolean cEf = true;
    private boolean cEg = true;
    private boolean cEh = true;
    private boolean cEi = true;
    private boolean cEj = true;
    private boolean cEk = true;
    private boolean cEl = true;
    private boolean cEm = true;
    private boolean cEn = true;
    private boolean cEo = true;
    private boolean cEp = true;
    private boolean cEq = true;
    private boolean cEr = true;
    private boolean cEs = true;
    private boolean cEt = true;
    private boolean cEu = true;
    private boolean cEv = true;
    private boolean cEw = true;
    private boolean cEx = true;
    private boolean cEy = true;
    private boolean cEz = true;
    private boolean ciS = true;
    private boolean ciY = true;
    private boolean ciZ = true;
    private boolean cja = true;
    public int field_AllVer;
    public int field_BizType;
    public String field_Desc_cn;
    public String field_Desc_en;
    public String field_Desc_hk;
    public String field_Desc_tw;
    public String field_DetailURL;
    public String field_Icon;
    public String field_ImgUrl_android_cn;
    public String field_ImgUrl_android_en;
    public String field_ImgUrl_android_hk;
    public String field_ImgUrl_android_tw;
    public String field_ImgUrl_cn;
    public String field_ImgUrl_en;
    public String field_ImgUrl_hk;
    public String field_ImgUrl_tw;
    public String field_Introduce_cn;
    public String field_Introduce_en;
    public String field_Introduce_hk;
    public String field_Introduce_tw;
    public String field_LabsAppId;
    public int field_Pos;
    public int field_RedPoint;
    public int field_Switch;
    public String field_ThumbUrl_cn;
    public String field_ThumbUrl_en;
    public String field_ThumbUrl_hk;
    public String field_ThumbUrl_tw;
    public String field_TitleKey_android;
    public String field_Title_cn;
    public String field_Title_en;
    public String field_Title_hk;
    public String field_Title_tw;
    public int field_Type;
    public int field_WeAppDebugMode;
    public String field_WeAppPath;
    public String field_WeAppUser;
    public long field_endtime;
    public String field_expId;
    public int field_idkey;
    public int field_idkeyValue;
    public int field_prioritylevel;
    public long field_sequence;
    public long field_starttime;
    public int field_status;

    public final void d(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (cEU == hashCode) {
                    this.field_LabsAppId = cursor.getString(i);
                    this.cEf = true;
                } else if (cjg == hashCode) {
                    this.field_expId = cursor.getString(i);
                } else if (cEV == hashCode) {
                    this.field_Type = cursor.getInt(i);
                } else if (cEW == hashCode) {
                    this.field_BizType = cursor.getInt(i);
                } else if (cEX == hashCode) {
                    this.field_Switch = cursor.getInt(i);
                } else if (cEY == hashCode) {
                    this.field_AllVer = cursor.getInt(i);
                } else if (cEZ == hashCode) {
                    this.field_DetailURL = cursor.getString(i);
                } else if (cFa == hashCode) {
                    this.field_WeAppUser = cursor.getString(i);
                } else if (cFb == hashCode) {
                    this.field_WeAppPath = cursor.getString(i);
                } else if (cFc == hashCode) {
                    this.field_Pos = cursor.getInt(i);
                } else if (cFd == hashCode) {
                    this.field_TitleKey_android = cursor.getString(i);
                } else if (cFe == hashCode) {
                    this.field_Title_cn = cursor.getString(i);
                } else if (cFf == hashCode) {
                    this.field_Title_hk = cursor.getString(i);
                } else if (cFg == hashCode) {
                    this.field_Title_tw = cursor.getString(i);
                } else if (cFh == hashCode) {
                    this.field_Title_en = cursor.getString(i);
                } else if (cFi == hashCode) {
                    this.field_Desc_cn = cursor.getString(i);
                } else if (cFj == hashCode) {
                    this.field_Desc_hk = cursor.getString(i);
                } else if (cFk == hashCode) {
                    this.field_Desc_tw = cursor.getString(i);
                } else if (cFl == hashCode) {
                    this.field_Desc_en = cursor.getString(i);
                } else if (cFm == hashCode) {
                    this.field_Introduce_cn = cursor.getString(i);
                } else if (cFn == hashCode) {
                    this.field_Introduce_hk = cursor.getString(i);
                } else if (cFo == hashCode) {
                    this.field_Introduce_tw = cursor.getString(i);
                } else if (cFp == hashCode) {
                    this.field_Introduce_en = cursor.getString(i);
                } else if (cFq == hashCode) {
                    this.field_starttime = cursor.getLong(i);
                } else if (cFr == hashCode) {
                    this.field_endtime = cursor.getLong(i);
                } else if (cjh == hashCode) {
                    this.field_sequence = cursor.getLong(i);
                } else if (cji == hashCode) {
                    this.field_prioritylevel = cursor.getInt(i);
                } else if (ciV == hashCode) {
                    this.field_status = cursor.getInt(i);
                } else if (cFs == hashCode) {
                    this.field_ThumbUrl_cn = cursor.getString(i);
                } else if (cFt == hashCode) {
                    this.field_ThumbUrl_hk = cursor.getString(i);
                } else if (cFu == hashCode) {
                    this.field_ThumbUrl_tw = cursor.getString(i);
                } else if (cFv == hashCode) {
                    this.field_ThumbUrl_en = cursor.getString(i);
                } else if (cFw == hashCode) {
                    this.field_ImgUrl_android_cn = cursor.getString(i);
                } else if (cFx == hashCode) {
                    this.field_ImgUrl_android_hk = cursor.getString(i);
                } else if (cFy == hashCode) {
                    this.field_ImgUrl_android_tw = cursor.getString(i);
                } else if (cFz == hashCode) {
                    this.field_ImgUrl_android_en = cursor.getString(i);
                } else if (cFA == hashCode) {
                    this.field_RedPoint = cursor.getInt(i);
                } else if (cFB == hashCode) {
                    this.field_WeAppDebugMode = cursor.getInt(i);
                } else if (cFC == hashCode) {
                    this.field_idkey = cursor.getInt(i);
                } else if (cFD == hashCode) {
                    this.field_idkeyValue = cursor.getInt(i);
                } else if (cFE == hashCode) {
                    this.field_Icon = cursor.getString(i);
                } else if (cFF == hashCode) {
                    this.field_ImgUrl_cn = cursor.getString(i);
                } else if (cFG == hashCode) {
                    this.field_ImgUrl_hk = cursor.getString(i);
                } else if (cFH == hashCode) {
                    this.field_ImgUrl_tw = cursor.getString(i);
                } else if (cFI == hashCode) {
                    this.field_ImgUrl_en = cursor.getString(i);
                } else if (ciP == hashCode) {
                    this.sKx = cursor.getLong(i);
                }
            }
        }
    }

    public final ContentValues wH() {
        ContentValues contentValues = new ContentValues();
        if (this.cEf) {
            contentValues.put("LabsAppId", this.field_LabsAppId);
        }
        if (this.field_expId == null) {
            this.field_expId = "";
        }
        if (this.ciY) {
            contentValues.put("expId", this.field_expId);
        }
        if (this.cEg) {
            contentValues.put("Type", Integer.valueOf(this.field_Type));
        }
        if (this.cEh) {
            contentValues.put("BizType", Integer.valueOf(this.field_BizType));
        }
        if (this.cEi) {
            contentValues.put("Switch", Integer.valueOf(this.field_Switch));
        }
        if (this.cEj) {
            contentValues.put("AllVer", Integer.valueOf(this.field_AllVer));
        }
        if (this.cEk) {
            contentValues.put("DetailURL", this.field_DetailURL);
        }
        if (this.cEl) {
            contentValues.put("WeAppUser", this.field_WeAppUser);
        }
        if (this.cEm) {
            contentValues.put("WeAppPath", this.field_WeAppPath);
        }
        if (this.cEn) {
            contentValues.put("Pos", Integer.valueOf(this.field_Pos));
        }
        if (this.cEo) {
            contentValues.put("TitleKey_android", this.field_TitleKey_android);
        }
        if (this.cEp) {
            contentValues.put("Title_cn", this.field_Title_cn);
        }
        if (this.cEq) {
            contentValues.put("Title_hk", this.field_Title_hk);
        }
        if (this.cEr) {
            contentValues.put("Title_tw", this.field_Title_tw);
        }
        if (this.cEs) {
            contentValues.put("Title_en", this.field_Title_en);
        }
        if (this.cEt) {
            contentValues.put("Desc_cn", this.field_Desc_cn);
        }
        if (this.cEu) {
            contentValues.put("Desc_hk", this.field_Desc_hk);
        }
        if (this.cEv) {
            contentValues.put("Desc_tw", this.field_Desc_tw);
        }
        if (this.cEw) {
            contentValues.put("Desc_en", this.field_Desc_en);
        }
        if (this.cEx) {
            contentValues.put("Introduce_cn", this.field_Introduce_cn);
        }
        if (this.cEy) {
            contentValues.put("Introduce_hk", this.field_Introduce_hk);
        }
        if (this.cEz) {
            contentValues.put("Introduce_tw", this.field_Introduce_tw);
        }
        if (this.cEA) {
            contentValues.put("Introduce_en", this.field_Introduce_en);
        }
        if (this.cEB) {
            contentValues.put("starttime", Long.valueOf(this.field_starttime));
        }
        if (this.cEC) {
            contentValues.put("endtime", Long.valueOf(this.field_endtime));
        }
        if (this.ciZ) {
            contentValues.put("sequence", Long.valueOf(this.field_sequence));
        }
        if (this.cja) {
            contentValues.put("prioritylevel", Integer.valueOf(this.field_prioritylevel));
        }
        if (this.ciS) {
            contentValues.put("status", Integer.valueOf(this.field_status));
        }
        if (this.cED) {
            contentValues.put("ThumbUrl_cn", this.field_ThumbUrl_cn);
        }
        if (this.cEE) {
            contentValues.put("ThumbUrl_hk", this.field_ThumbUrl_hk);
        }
        if (this.cEF) {
            contentValues.put("ThumbUrl_tw", this.field_ThumbUrl_tw);
        }
        if (this.cEG) {
            contentValues.put("ThumbUrl_en", this.field_ThumbUrl_en);
        }
        if (this.cEH) {
            contentValues.put("ImgUrl_android_cn", this.field_ImgUrl_android_cn);
        }
        if (this.cEI) {
            contentValues.put("ImgUrl_android_hk", this.field_ImgUrl_android_hk);
        }
        if (this.cEJ) {
            contentValues.put("ImgUrl_android_tw", this.field_ImgUrl_android_tw);
        }
        if (this.cEK) {
            contentValues.put("ImgUrl_android_en", this.field_ImgUrl_android_en);
        }
        if (this.cEL) {
            contentValues.put("RedPoint", Integer.valueOf(this.field_RedPoint));
        }
        if (this.cEM) {
            contentValues.put("WeAppDebugMode", Integer.valueOf(this.field_WeAppDebugMode));
        }
        if (this.cEN) {
            contentValues.put("idkey", Integer.valueOf(this.field_idkey));
        }
        if (this.cEO) {
            contentValues.put("idkeyValue", Integer.valueOf(this.field_idkeyValue));
        }
        if (this.cEP) {
            contentValues.put("Icon", this.field_Icon);
        }
        if (this.cEQ) {
            contentValues.put("ImgUrl_cn", this.field_ImgUrl_cn);
        }
        if (this.cER) {
            contentValues.put("ImgUrl_hk", this.field_ImgUrl_hk);
        }
        if (this.cES) {
            contentValues.put("ImgUrl_tw", this.field_ImgUrl_tw);
        }
        if (this.cET) {
            contentValues.put("ImgUrl_en", this.field_ImgUrl_en);
        }
        if (this.sKx > 0) {
            contentValues.put("rowid", Long.valueOf(this.sKx));
        }
        return contentValues;
    }
}
