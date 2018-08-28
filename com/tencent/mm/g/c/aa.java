package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class aa extends c {
    public static final String[] ciG = new String[0];
    private static final int ciP = "rowid".hashCode();
    private static final int ciV = "status".hashCode();
    private static final int ckP = "appId".hashCode();
    private static final int cke = "type".hashCode();
    private static final int cli = "username".hashCode();
    private static final int clj = "updateTime".hashCode();
    private static final int cop = "bitFlag".hashCode();
    private static final int cpA = "attrSyncVersion".hashCode();
    private static final int cpB = "incrementUpdateTime".hashCode();
    private static final int cpo = "brandList".hashCode();
    private static final int cpp = "brandListVersion".hashCode();
    private static final int cpq = "brandListContent".hashCode();
    private static final int cpr = "brandFlag".hashCode();
    private static final int cps = "extInfo".hashCode();
    private static final int cpt = "brandInfo".hashCode();
    private static final int cpu = "brandIconURL".hashCode();
    private static final int cpv = "hadAlert".hashCode();
    private static final int cpw = "acceptType".hashCode();
    private static final int cpx = "enterpriseFather".hashCode();
    private static final int cpy = "kfWorkerId".hashCode();
    private static final int cpz = "specialType".hashCode();
    private boolean ciS = true;
    private boolean cjI = true;
    private boolean cky = true;
    private boolean clg = true;
    private boolean clh = true;
    private boolean cod = true;
    private boolean cpa = true;
    private boolean cpb = true;
    private boolean cpc = true;
    private boolean cpd = true;
    private boolean cpe = true;
    private boolean cpf = true;
    private boolean cpg = true;
    private boolean cph = true;
    private boolean cpi = true;
    private boolean cpj = true;
    private boolean cpk = true;
    private boolean cpl = true;
    private boolean cpm = true;
    private boolean cpn = true;
    public int field_acceptType;
    public String field_appId;
    public String field_attrSyncVersion;
    public int field_bitFlag;
    public int field_brandFlag;
    public String field_brandIconURL;
    public String field_brandInfo;
    public String field_brandList;
    public String field_brandListContent;
    public String field_brandListVersion;
    public String field_enterpriseFather;
    public String field_extInfo;
    public int field_hadAlert;
    public long field_incrementUpdateTime;
    public String field_kfWorkerId;
    public int field_specialType;
    public int field_status;
    public int field_type;
    public long field_updateTime;
    public String field_username;

    public void d(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (cli == hashCode) {
                    this.field_username = cursor.getString(i);
                    this.clg = true;
                } else if (ckP == hashCode) {
                    this.field_appId = cursor.getString(i);
                } else if (cpo == hashCode) {
                    this.field_brandList = cursor.getString(i);
                } else if (cpp == hashCode) {
                    this.field_brandListVersion = cursor.getString(i);
                } else if (cpq == hashCode) {
                    this.field_brandListContent = cursor.getString(i);
                } else if (cpr == hashCode) {
                    this.field_brandFlag = cursor.getInt(i);
                } else if (cps == hashCode) {
                    this.field_extInfo = cursor.getString(i);
                } else if (cpt == hashCode) {
                    this.field_brandInfo = cursor.getString(i);
                } else if (cpu == hashCode) {
                    this.field_brandIconURL = cursor.getString(i);
                } else if (clj == hashCode) {
                    this.field_updateTime = cursor.getLong(i);
                } else if (cpv == hashCode) {
                    this.field_hadAlert = cursor.getInt(i);
                } else if (cpw == hashCode) {
                    this.field_acceptType = cursor.getInt(i);
                } else if (cke == hashCode) {
                    this.field_type = cursor.getInt(i);
                } else if (ciV == hashCode) {
                    this.field_status = cursor.getInt(i);
                } else if (cpx == hashCode) {
                    this.field_enterpriseFather = cursor.getString(i);
                } else if (cpy == hashCode) {
                    this.field_kfWorkerId = cursor.getString(i);
                } else if (cpz == hashCode) {
                    this.field_specialType = cursor.getInt(i);
                } else if (cpA == hashCode) {
                    this.field_attrSyncVersion = cursor.getString(i);
                } else if (cpB == hashCode) {
                    this.field_incrementUpdateTime = cursor.getLong(i);
                } else if (cop == hashCode) {
                    this.field_bitFlag = cursor.getInt(i);
                } else if (ciP == hashCode) {
                    this.sKx = cursor.getLong(i);
                }
            }
        }
    }

    public ContentValues wH() {
        ContentValues contentValues = new ContentValues();
        if (this.clg) {
            contentValues.put("username", this.field_username);
        }
        if (this.cky) {
            contentValues.put("appId", this.field_appId);
        }
        if (this.field_brandList == null) {
            this.field_brandList = "";
        }
        if (this.cpa) {
            contentValues.put("brandList", this.field_brandList);
        }
        if (this.cpb) {
            contentValues.put("brandListVersion", this.field_brandListVersion);
        }
        if (this.cpc) {
            contentValues.put("brandListContent", this.field_brandListContent);
        }
        if (this.cpd) {
            contentValues.put("brandFlag", Integer.valueOf(this.field_brandFlag));
        }
        if (this.cpe) {
            contentValues.put("extInfo", this.field_extInfo);
        }
        if (this.cpf) {
            contentValues.put("brandInfo", this.field_brandInfo);
        }
        if (this.cpg) {
            contentValues.put("brandIconURL", this.field_brandIconURL);
        }
        if (this.clh) {
            contentValues.put("updateTime", Long.valueOf(this.field_updateTime));
        }
        if (this.cph) {
            contentValues.put("hadAlert", Integer.valueOf(this.field_hadAlert));
        }
        if (this.cpi) {
            contentValues.put("acceptType", Integer.valueOf(this.field_acceptType));
        }
        if (this.cjI) {
            contentValues.put("type", Integer.valueOf(this.field_type));
        }
        if (this.ciS) {
            contentValues.put("status", Integer.valueOf(this.field_status));
        }
        if (this.cpj) {
            contentValues.put("enterpriseFather", this.field_enterpriseFather);
        }
        if (this.cpk) {
            contentValues.put("kfWorkerId", this.field_kfWorkerId);
        }
        if (this.cpl) {
            contentValues.put("specialType", Integer.valueOf(this.field_specialType));
        }
        if (this.cpm) {
            contentValues.put("attrSyncVersion", this.field_attrSyncVersion);
        }
        if (this.cpn) {
            contentValues.put("incrementUpdateTime", Long.valueOf(this.field_incrementUpdateTime));
        }
        if (this.cod) {
            contentValues.put("bitFlag", Integer.valueOf(this.field_bitFlag));
        }
        if (this.sKx > 0) {
            contentValues.put("rowid", Long.valueOf(this.sKx));
        }
        return contentValues;
    }
}
