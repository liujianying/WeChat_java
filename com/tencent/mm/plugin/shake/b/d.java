package com.tencent.mm.plugin.shake.b;

import android.content.ContentValues;
import com.tencent.mm.g.c.do;
import com.tencent.mm.protocal.c.bhy;
import com.tencent.mm.protocal.c.bmk;
import com.tencent.mm.sdk.e.c.a;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.storage.RegionCodeDecoder;
import java.lang.reflect.Field;

public final class d extends do {
    protected static a dhO;
    public int bWA;
    private bhy mWJ;
    public int scene;

    static {
        a aVar = new a();
        aVar.sKy = new Field[20];
        aVar.columns = new String[21];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.columns[0] = "shakeItemID";
        aVar.sKA.put("shakeItemID", "INTEGER default '0'  PRIMARY KEY ");
        stringBuilder.append(" shakeItemID INTEGER default '0'  PRIMARY KEY ");
        stringBuilder.append(", ");
        aVar.sKz = "shakeItemID";
        aVar.columns[1] = "username";
        aVar.sKA.put("username", "TEXT");
        stringBuilder.append(" username TEXT");
        stringBuilder.append(", ");
        aVar.columns[2] = "nickname";
        aVar.sKA.put("nickname", "TEXT");
        stringBuilder.append(" nickname TEXT");
        stringBuilder.append(", ");
        aVar.columns[3] = "province";
        aVar.sKA.put("province", "TEXT");
        stringBuilder.append(" province TEXT");
        stringBuilder.append(", ");
        aVar.columns[4] = "city";
        aVar.sKA.put("city", "TEXT");
        stringBuilder.append(" city TEXT");
        stringBuilder.append(", ");
        aVar.columns[5] = "signature";
        aVar.sKA.put("signature", "TEXT");
        stringBuilder.append(" signature TEXT");
        stringBuilder.append(", ");
        aVar.columns[6] = "distance";
        aVar.sKA.put("distance", "TEXT");
        stringBuilder.append(" distance TEXT");
        stringBuilder.append(", ");
        aVar.columns[7] = "sex";
        aVar.sKA.put("sex", "INTEGER");
        stringBuilder.append(" sex INTEGER");
        stringBuilder.append(", ");
        aVar.columns[8] = "imgstatus";
        aVar.sKA.put("imgstatus", "INTEGER");
        stringBuilder.append(" imgstatus INTEGER");
        stringBuilder.append(", ");
        aVar.columns[9] = "hasHDImg";
        aVar.sKA.put("hasHDImg", "INTEGER");
        stringBuilder.append(" hasHDImg INTEGER");
        stringBuilder.append(", ");
        aVar.columns[10] = "insertBatch";
        aVar.sKA.put("insertBatch", "INTEGER");
        stringBuilder.append(" insertBatch INTEGER");
        stringBuilder.append(", ");
        aVar.columns[11] = "reserved1";
        aVar.sKA.put("reserved1", "INTEGER");
        stringBuilder.append(" reserved1 INTEGER");
        stringBuilder.append(", ");
        aVar.columns[12] = "reserved2";
        aVar.sKA.put("reserved2", "INTEGER");
        stringBuilder.append(" reserved2 INTEGER");
        stringBuilder.append(", ");
        aVar.columns[13] = "reserved3";
        aVar.sKA.put("reserved3", "TEXT");
        stringBuilder.append(" reserved3 TEXT");
        stringBuilder.append(", ");
        aVar.columns[14] = "reserved4";
        aVar.sKA.put("reserved4", "TEXT");
        stringBuilder.append(" reserved4 TEXT");
        stringBuilder.append(", ");
        aVar.columns[15] = "type";
        aVar.sKA.put("type", "INTEGER");
        stringBuilder.append(" type INTEGER");
        stringBuilder.append(", ");
        aVar.columns[16] = "lvbuffer";
        aVar.sKA.put("lvbuffer", "BLOB");
        stringBuilder.append(" lvbuffer BLOB");
        stringBuilder.append(", ");
        aVar.columns[17] = "regionCode";
        aVar.sKA.put("regionCode", "TEXT");
        stringBuilder.append(" regionCode TEXT");
        stringBuilder.append(", ");
        aVar.columns[18] = "snsFlag";
        aVar.sKA.put("snsFlag", "INTEGER");
        stringBuilder.append(" snsFlag INTEGER");
        stringBuilder.append(", ");
        aVar.columns[19] = "sns_bgurl";
        aVar.sKA.put("sns_bgurl", "TEXT");
        stringBuilder.append(" sns_bgurl TEXT");
        aVar.columns[20] = "rowid";
        aVar.sql = stringBuilder.toString();
        dhO = aVar;
    }

    protected final a AX() {
        return dhO;
    }

    public d() {
        this.bWA = -1;
        this.field_insertBatch = 2;
    }

    public d(bmk bmk) {
        this.bWA = -1;
        this.field_username = bmk.hbL;
        this.field_nickname = bmk.hcS;
        this.field_signature = bmk.eJK;
        this.field_distance = bmk.rTd;
        this.field_reserved4 = String.valueOf(bmk.skE);
        this.field_sex = bmk.eJH;
        this.field_imgstatus = bmk.rcm;
        this.field_hasHDImg = bmk.skC;
        this.field_reserved1 = bmk.rTe;
        this.field_reserved3 = bmk.rTf;
        this.field_insertBatch = 2;
        if (bmk.rTk != null) {
            this.field_snsFlag = bmk.rTk.eJS;
            this.field_sns_bgurl = bmk.rTk.eJT;
        }
        this.mWJ = bmk.skD;
        this.field_province = bmk.eJI;
        this.field_city = bmk.eJJ;
        this.field_regionCode = RegionCodeDecoder.aq(bmk.eJQ, this.field_province, this.field_city);
    }

    public final String getProvince() {
        if (!bi.oW(this.field_regionCode)) {
            String[] split = this.field_regionCode.split("_");
            if (split.length > 0) {
                if (split.length <= 2 || !split[0].equalsIgnoreCase("cn")) {
                    RegionCodeDecoder.cmS();
                    this.field_province = RegionCodeDecoder.Zi(split[0]);
                } else {
                    RegionCodeDecoder.cmS();
                    this.field_province = RegionCodeDecoder.ga(split[0], split[1]);
                }
            }
        }
        return this.field_province;
    }

    public final String getCity() {
        if (!bi.oW(this.field_regionCode)) {
            String[] split = this.field_regionCode.split("_");
            if (split.length > 0) {
                if (split.length > 2) {
                    RegionCodeDecoder.cmS();
                    this.field_city = RegionCodeDecoder.ar(split[0], split[1], split[2]);
                } else if (split.length == 2) {
                    RegionCodeDecoder.cmS();
                    this.field_city = RegionCodeDecoder.ga(split[0], split[1]);
                } else {
                    this.field_city = "";
                }
            }
        }
        return this.field_city;
    }

    private int buq() {
        try {
            return Integer.valueOf(this.field_reserved4).intValue();
        } catch (Throwable th) {
            return 0;
        }
    }

    public final ContentValues wH() {
        ContentValues contentValues = new ContentValues();
        if ((this.bWA & 2) != 0) {
            contentValues.put("username", this.field_username);
        }
        if ((this.bWA & 4) != 0) {
            contentValues.put("nickname", this.field_nickname);
        }
        if ((this.bWA & 8) != 0) {
            contentValues.put("province", getProvince());
        }
        if ((this.bWA & 16) != 0) {
            contentValues.put("city", getCity());
        }
        if ((this.bWA & 32) != 0) {
            contentValues.put("signature", this.field_signature);
        }
        if ((this.bWA & 64) != 0) {
            contentValues.put("distance", this.field_distance);
        }
        if ((this.bWA & 128) != 0) {
            contentValues.put("sex", Integer.valueOf(this.field_sex));
        }
        if ((this.bWA & 256) != 0) {
            contentValues.put("imgstatus", Integer.valueOf(this.field_imgstatus));
        }
        if ((this.bWA & 512) != 0) {
            contentValues.put("hasHDImg", Integer.valueOf(this.field_hasHDImg));
        }
        if ((this.bWA & 1024) != 0) {
            contentValues.put("insertBatch", Integer.valueOf(this.field_insertBatch));
        }
        if ((this.bWA & 2048) != 0) {
            contentValues.put("reserved1", Integer.valueOf(this.field_reserved1));
        }
        if ((this.bWA & 4096) != 0) {
            contentValues.put("reserved2", Integer.valueOf(this.field_reserved2));
        }
        if ((this.bWA & 8192) != 0) {
            contentValues.put("reserved3", this.field_reserved3);
        }
        if ((this.bWA & 16384) != 0) {
            contentValues.put("reserved4", Integer.valueOf(buq()));
        }
        if ((this.bWA & 32768) != 0) {
            contentValues.put("type", Integer.valueOf(this.field_type));
        }
        if ((this.bWA & 65536) != 0) {
            contentValues.put("lvbuffer", this.field_lvbuffer);
        }
        if ((this.bWA & 131072) != 0) {
            contentValues.put("regionCode", this.field_regionCode);
        }
        if ((this.bWA & 262144) != 0) {
            contentValues.put("snsFlag", Integer.valueOf(this.field_snsFlag));
        }
        if ((this.bWA & 524288) != 0) {
            contentValues.put("sns_bgurl", this.field_sns_bgurl);
        }
        return contentValues;
    }
}
