package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class fb extends c {
    private static final int cGb = "versionInfo".hashCode();
    private static final int cGw = "reserved".hashCode();
    private static final int cVb = "usernameHash".hashCode();
    private static final int cVc = "roundedSquareIconURL".hashCode();
    private static final int cVd = "bigHeadURL".hashCode();
    private static final int cVe = "smallHeadURL".hashCode();
    private static final int cVf = "appOpt".hashCode();
    private static final int cVg = "registerSource".hashCode();
    private static final int cVh = "appInfo".hashCode();
    private static final int cVi = "bindWxaInfo".hashCode();
    private static final int cVj = "dynamicInfo".hashCode();
    private static final int cVk = "syncTimeSecond".hashCode();
    private static final int cVl = "syncVersion".hashCode();
    private static final int cVm = "bizMenu".hashCode();
    public static final String[] ciG = new String[]{"CREATE INDEX IF NOT EXISTS WxaAttributesTableAppIdIndex ON WxaAttributesTable(appId)"};
    private static final int ciP = "rowid".hashCode();
    private static final int ckP = "appId".hashCode();
    private static final int cld = "signature".hashCode();
    private static final int cli = "username".hashCode();
    private static final int cpI = "nickname".hashCode();
    private static final int cpu = "brandIconURL".hashCode();
    private boolean cFW = true;
    private boolean cGq = true;
    private boolean cUP = true;
    private boolean cUQ = true;
    private boolean cUR = true;
    private boolean cUS = true;
    private boolean cUT = true;
    private boolean cUU = true;
    private boolean cUV = true;
    private boolean cUW = true;
    private boolean cUX = true;
    private boolean cUY = true;
    private boolean cUZ = true;
    private boolean cVa = true;
    private boolean ckM = true;
    private boolean cky = true;
    private boolean clg = true;
    private boolean cpE = true;
    private boolean cpg = true;
    public String field_appId;
    public String field_appInfo;
    public int field_appOpt;
    public String field_bigHeadURL;
    public String field_bindWxaInfo;
    public String field_bizMenu;
    public String field_brandIconURL;
    public String field_dynamicInfo;
    public String field_nickname;
    public String field_registerSource;
    public String field_reserved;
    public String field_roundedSquareIconURL;
    public String field_signature;
    public String field_smallHeadURL;
    public long field_syncTimeSecond;
    public String field_syncVersion;
    public String field_username;
    public int field_usernameHash;
    public String field_versionInfo;

    public void d(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (cVb == hashCode) {
                    this.field_usernameHash = cursor.getInt(i);
                    this.cUP = true;
                } else if (cli == hashCode) {
                    this.field_username = cursor.getString(i);
                } else if (ckP == hashCode) {
                    this.field_appId = cursor.getString(i);
                } else if (cpI == hashCode) {
                    this.field_nickname = cursor.getString(i);
                } else if (cpu == hashCode) {
                    this.field_brandIconURL = cursor.getString(i);
                } else if (cVc == hashCode) {
                    this.field_roundedSquareIconURL = cursor.getString(i);
                } else if (cVd == hashCode) {
                    this.field_bigHeadURL = cursor.getString(i);
                } else if (cVe == hashCode) {
                    this.field_smallHeadURL = cursor.getString(i);
                } else if (cld == hashCode) {
                    this.field_signature = cursor.getString(i);
                } else if (cVf == hashCode) {
                    this.field_appOpt = cursor.getInt(i);
                } else if (cVg == hashCode) {
                    this.field_registerSource = cursor.getString(i);
                } else if (cVh == hashCode) {
                    this.field_appInfo = cursor.getString(i);
                } else if (cGb == hashCode) {
                    this.field_versionInfo = cursor.getString(i);
                } else if (cVi == hashCode) {
                    this.field_bindWxaInfo = cursor.getString(i);
                } else if (cVj == hashCode) {
                    this.field_dynamicInfo = cursor.getString(i);
                } else if (cGw == hashCode) {
                    this.field_reserved = cursor.getString(i);
                } else if (cVk == hashCode) {
                    this.field_syncTimeSecond = cursor.getLong(i);
                } else if (cVl == hashCode) {
                    this.field_syncVersion = cursor.getString(i);
                } else if (cVm == hashCode) {
                    this.field_bizMenu = cursor.getString(i);
                } else if (ciP == hashCode) {
                    this.sKx = cursor.getLong(i);
                }
            }
        }
    }

    public final ContentValues wH() {
        ContentValues contentValues = new ContentValues();
        if (this.cUP) {
            contentValues.put("usernameHash", Integer.valueOf(this.field_usernameHash));
        }
        if (this.clg) {
            contentValues.put("username", this.field_username);
        }
        if (this.cky) {
            contentValues.put("appId", this.field_appId);
        }
        if (this.cpE) {
            contentValues.put("nickname", this.field_nickname);
        }
        if (this.cpg) {
            contentValues.put("brandIconURL", this.field_brandIconURL);
        }
        if (this.cUQ) {
            contentValues.put("roundedSquareIconURL", this.field_roundedSquareIconURL);
        }
        if (this.cUR) {
            contentValues.put("bigHeadURL", this.field_bigHeadURL);
        }
        if (this.cUS) {
            contentValues.put("smallHeadURL", this.field_smallHeadURL);
        }
        if (this.ckM) {
            contentValues.put("signature", this.field_signature);
        }
        if (this.cUT) {
            contentValues.put("appOpt", Integer.valueOf(this.field_appOpt));
        }
        if (this.cUU) {
            contentValues.put("registerSource", this.field_registerSource);
        }
        if (this.cUV) {
            contentValues.put("appInfo", this.field_appInfo);
        }
        if (this.cFW) {
            contentValues.put("versionInfo", this.field_versionInfo);
        }
        if (this.cUW) {
            contentValues.put("bindWxaInfo", this.field_bindWxaInfo);
        }
        if (this.cUX) {
            contentValues.put("dynamicInfo", this.field_dynamicInfo);
        }
        if (this.cGq) {
            contentValues.put("reserved", this.field_reserved);
        }
        if (this.cUY) {
            contentValues.put("syncTimeSecond", Long.valueOf(this.field_syncTimeSecond));
        }
        if (this.cUZ) {
            contentValues.put("syncVersion", this.field_syncVersion);
        }
        if (this.cVa) {
            contentValues.put("bizMenu", this.field_bizMenu);
        }
        if (this.sKx > 0) {
            contentValues.put("rowid", Long.valueOf(this.sKx));
        }
        return contentValues;
    }
}
