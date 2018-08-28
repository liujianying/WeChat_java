package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.platformtools.u;
import com.tencent.mm.sdk.platformtools.x;

public abstract class p extends c {
    public static final String[] ciG = new String[]{"CREATE INDEX IF NOT EXISTS appInfo_status_Index ON AppInfo(status)"};
    private static final int ciP = "rowid".hashCode();
    private static final int ciV = "status".hashCode();
    private static final int ckP = "appId".hashCode();
    private static final int cld = "signature".hashCode();
    private static final int cmA = "appSupportContentType".hashCode();
    private static final int cmB = "svrAppSupportContentType".hashCode();
    private static final int cmf = "appName".hashCode();
    private static final int cmg = "appDiscription".hashCode();
    private static final int cmh = "appIconUrl".hashCode();
    private static final int cmi = "appStoreUrl".hashCode();
    private static final int cmj = "appVersion".hashCode();
    private static final int cmk = "appWatermarkUrl".hashCode();
    private static final int cml = "packageName".hashCode();
    private static final int cmm = "modifyTime".hashCode();
    private static final int cmn = "appName_en".hashCode();
    private static final int cmo = "appName_tw".hashCode();
    private static final int cmp = "appName_hk".hashCode();
    private static final int cmq = "appDiscription_en".hashCode();
    private static final int cmr = "appDiscription_tw".hashCode();
    private static final int cms = "appType".hashCode();
    private static final int cmt = "openId".hashCode();
    private static final int cmu = "authFlag".hashCode();
    private static final int cmv = "appInfoFlag".hashCode();
    private static final int cmw = "lvbuff".hashCode();
    private static final int cmx = "serviceAppType".hashCode();
    private static final int cmy = "serviceAppInfoFlag".hashCode();
    private static final int cmz = "serviceShowFlag".hashCode();
    private boolean ciS = true;
    private boolean ckM = true;
    private boolean cky = true;
    private boolean clI = true;
    private boolean clJ = true;
    private boolean clK = true;
    private boolean clL = true;
    private boolean clM = true;
    private boolean clN = true;
    private boolean clO = true;
    private boolean clP = true;
    private boolean clQ = true;
    private boolean clR = true;
    private boolean clS = true;
    private boolean clT = true;
    private boolean clU = true;
    private boolean clV = true;
    private boolean clW = true;
    private boolean clX = true;
    private boolean clY = true;
    public boolean clZ = true;
    public String cmC;
    public String cmD;
    public String cmE;
    public int cmF;
    public int cmG;
    public String cmH;
    public String cmI;
    public String cmJ;
    public String cmK;
    public String cmL;
    public String cmM;
    public int cmN;
    public String cmO;
    public String cmP;
    public String cmQ;
    public String cmR;
    public String cmS;
    public int cmT;
    public String cmU;
    private int cmV;
    public String cmW;
    public String cmX;
    public String cmY;
    public int cmZ;
    private boolean cma = true;
    private boolean cmb = true;
    private boolean cmc = true;
    private boolean cmd = true;
    private boolean cme = true;
    public String field_appDiscription;
    public String field_appDiscription_en;
    public String field_appDiscription_tw;
    public String field_appIconUrl;
    public String field_appId;
    public int field_appInfoFlag;
    public String field_appName;
    public String field_appName_en;
    public String field_appName_hk;
    public String field_appName_tw;
    public String field_appStoreUrl;
    public long field_appSupportContentType;
    public String field_appType;
    public int field_appVersion;
    public String field_appWatermarkUrl;
    public int field_authFlag;
    public byte[] field_lvbuff;
    public long field_modifyTime;
    public String field_openId;
    public String field_packageName;
    public int field_serviceAppInfoFlag;
    public int field_serviceAppType;
    public int field_serviceShowFlag;
    public String field_signature;
    public int field_status;
    public long field_svrAppSupportContentType;

    public final void d(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (ckP == hashCode) {
                    this.field_appId = cursor.getString(i);
                    this.cky = true;
                } else if (cmf == hashCode) {
                    this.field_appName = cursor.getString(i);
                } else if (cmg == hashCode) {
                    this.field_appDiscription = cursor.getString(i);
                } else if (cmh == hashCode) {
                    this.field_appIconUrl = cursor.getString(i);
                } else if (cmi == hashCode) {
                    this.field_appStoreUrl = cursor.getString(i);
                } else if (cmj == hashCode) {
                    this.field_appVersion = cursor.getInt(i);
                } else if (cmk == hashCode) {
                    this.field_appWatermarkUrl = cursor.getString(i);
                } else if (cml == hashCode) {
                    this.field_packageName = cursor.getString(i);
                } else if (ciV == hashCode) {
                    this.field_status = cursor.getInt(i);
                } else if (cld == hashCode) {
                    this.field_signature = cursor.getString(i);
                } else if (cmm == hashCode) {
                    this.field_modifyTime = cursor.getLong(i);
                } else if (cmn == hashCode) {
                    this.field_appName_en = cursor.getString(i);
                } else if (cmo == hashCode) {
                    this.field_appName_tw = cursor.getString(i);
                } else if (cmp == hashCode) {
                    this.field_appName_hk = cursor.getString(i);
                } else if (cmq == hashCode) {
                    this.field_appDiscription_en = cursor.getString(i);
                } else if (cmr == hashCode) {
                    this.field_appDiscription_tw = cursor.getString(i);
                } else if (cms == hashCode) {
                    this.field_appType = cursor.getString(i);
                } else if (cmt == hashCode) {
                    this.field_openId = cursor.getString(i);
                } else if (cmu == hashCode) {
                    this.field_authFlag = cursor.getInt(i);
                } else if (cmv == hashCode) {
                    this.field_appInfoFlag = cursor.getInt(i);
                } else if (cmw == hashCode) {
                    this.field_lvbuff = cursor.getBlob(i);
                } else if (cmx == hashCode) {
                    this.field_serviceAppType = cursor.getInt(i);
                } else if (cmy == hashCode) {
                    this.field_serviceAppInfoFlag = cursor.getInt(i);
                } else if (cmz == hashCode) {
                    this.field_serviceShowFlag = cursor.getInt(i);
                } else if (cmA == hashCode) {
                    this.field_appSupportContentType = cursor.getLong(i);
                } else if (cmB == hashCode) {
                    this.field_svrAppSupportContentType = cursor.getLong(i);
                } else if (ciP == hashCode) {
                    this.sKx = cursor.getLong(i);
                }
            }
            try {
                if (this.field_lvbuff != null && this.field_lvbuff.length != 0) {
                    u uVar = new u();
                    int by = uVar.by(this.field_lvbuff);
                    if (by != 0) {
                        x.e("MicroMsg.SDK.BaseAppInfo", "parse LVBuffer error:" + by);
                        return;
                    }
                    this.cmC = uVar.getString();
                    this.cmD = uVar.getString();
                    this.cmE = uVar.getString();
                    this.cmF = uVar.getInt();
                    this.cmG = uVar.getInt();
                    this.cmH = uVar.getString();
                    this.cmI = uVar.getString();
                    this.cmJ = uVar.getString();
                    this.cmK = uVar.getString();
                    if (!uVar.chD()) {
                        this.cmL = uVar.getString();
                    }
                    if (!uVar.chD()) {
                        this.cmM = uVar.getString();
                    }
                    if (!uVar.chD()) {
                        this.cmN = uVar.getInt();
                    }
                    if (!uVar.chD()) {
                        this.cmO = uVar.getString();
                    }
                    if (!uVar.chD()) {
                        this.cmP = uVar.getString();
                    }
                    if (!uVar.chD()) {
                        this.cmQ = uVar.getString();
                    }
                    if (!uVar.chD()) {
                        this.cmR = uVar.getString();
                    }
                    if (!uVar.chD()) {
                        this.cmS = uVar.getString();
                    }
                    if (!uVar.chD()) {
                        this.cmT = uVar.getInt();
                    }
                    if (!uVar.chD()) {
                        this.cmU = uVar.getString();
                    }
                    if (!uVar.chD()) {
                        this.cmV = uVar.getInt();
                    }
                    if (!uVar.chD()) {
                        this.cmW = uVar.getString();
                    }
                    if (!uVar.chD()) {
                        this.cmX = uVar.getString();
                    }
                    if (!uVar.chD()) {
                        this.cmY = uVar.getString();
                    }
                    if (!uVar.chD()) {
                        this.cmZ = uVar.getInt();
                    }
                }
            } catch (Exception e) {
                x.e("MicroMsg.SDK.BaseAppInfo", "get value failed");
            }
        }
    }

    public ContentValues wH() {
        try {
            if (this.clZ) {
                u uVar = new u();
                uVar.chE();
                uVar.Wj(this.cmC);
                uVar.Wj(this.cmD);
                uVar.Wj(this.cmE);
                uVar.CZ(this.cmF);
                uVar.CZ(this.cmG);
                uVar.Wj(this.cmH);
                uVar.Wj(this.cmI);
                uVar.Wj(this.cmJ);
                uVar.Wj(this.cmK);
                uVar.Wj(this.cmL);
                uVar.Wj(this.cmM);
                uVar.CZ(this.cmN);
                uVar.Wj(this.cmO);
                uVar.Wj(this.cmP);
                uVar.Wj(this.cmQ);
                uVar.Wj(this.cmR);
                uVar.Wj(this.cmS);
                uVar.CZ(this.cmT);
                uVar.Wj(this.cmU);
                uVar.CZ(this.cmV);
                uVar.Wj(this.cmW);
                uVar.Wj(this.cmX);
                uVar.Wj(this.cmY);
                uVar.CZ(this.cmZ);
                this.field_lvbuff = uVar.chF();
            }
        } catch (Exception e) {
            x.e("MicroMsg.SDK.BaseAppInfo", "get value failed, %s", new Object[]{e.getMessage()});
        }
        ContentValues contentValues = new ContentValues();
        if (this.field_appId == null) {
            this.field_appId = "";
        }
        if (this.cky) {
            contentValues.put("appId", this.field_appId);
        }
        if (this.clI) {
            contentValues.put("appName", this.field_appName);
        }
        if (this.clJ) {
            contentValues.put("appDiscription", this.field_appDiscription);
        }
        if (this.clK) {
            contentValues.put("appIconUrl", this.field_appIconUrl);
        }
        if (this.clL) {
            contentValues.put("appStoreUrl", this.field_appStoreUrl);
        }
        if (this.clM) {
            contentValues.put("appVersion", Integer.valueOf(this.field_appVersion));
        }
        if (this.clN) {
            contentValues.put("appWatermarkUrl", this.field_appWatermarkUrl);
        }
        if (this.clO) {
            contentValues.put("packageName", this.field_packageName);
        }
        if (this.ciS) {
            contentValues.put("status", Integer.valueOf(this.field_status));
        }
        if (this.ckM) {
            contentValues.put("signature", this.field_signature);
        }
        if (this.clP) {
            contentValues.put("modifyTime", Long.valueOf(this.field_modifyTime));
        }
        if (this.clQ) {
            contentValues.put("appName_en", this.field_appName_en);
        }
        if (this.clR) {
            contentValues.put("appName_tw", this.field_appName_tw);
        }
        if (this.clS) {
            contentValues.put("appName_hk", this.field_appName_hk);
        }
        if (this.clT) {
            contentValues.put("appDiscription_en", this.field_appDiscription_en);
        }
        if (this.clU) {
            contentValues.put("appDiscription_tw", this.field_appDiscription_tw);
        }
        if (this.clV) {
            contentValues.put("appType", this.field_appType);
        }
        if (this.clW) {
            contentValues.put("openId", this.field_openId);
        }
        if (this.clX) {
            contentValues.put("authFlag", Integer.valueOf(this.field_authFlag));
        }
        if (this.clY) {
            contentValues.put("appInfoFlag", Integer.valueOf(this.field_appInfoFlag));
        }
        if (this.clZ) {
            contentValues.put("lvbuff", this.field_lvbuff);
        }
        if (this.cma) {
            contentValues.put("serviceAppType", Integer.valueOf(this.field_serviceAppType));
        }
        if (this.cmb) {
            contentValues.put("serviceAppInfoFlag", Integer.valueOf(this.field_serviceAppInfoFlag));
        }
        if (this.cmc) {
            contentValues.put("serviceShowFlag", Integer.valueOf(this.field_serviceShowFlag));
        }
        if (this.cmd) {
            contentValues.put("appSupportContentType", Long.valueOf(this.field_appSupportContentType));
        }
        if (this.cme) {
            contentValues.put("svrAppSupportContentType", Long.valueOf(this.field_svrAppSupportContentType));
        }
        if (this.sKx > 0) {
            contentValues.put("rowid", Long.valueOf(this.sKx));
        }
        return contentValues;
    }

    public final void dg(String str) {
        this.cmC = str;
        this.clZ = true;
    }

    public final void dh(String str) {
        this.cmD = str;
        this.clZ = true;
    }

    public final String wJ() {
        return this.cmE;
    }

    public final void di(String str) {
        this.cmE = str;
        this.clZ = true;
    }

    public final void dj(String str) {
        this.cmH = str;
        this.clZ = true;
    }

    public final void dk(String str) {
        this.cmI = str;
        this.clZ = true;
    }

    public final String wK() {
        return this.cmJ;
    }

    public final void dl(String str) {
        this.cmJ = str;
        this.clZ = true;
    }

    public final String wL() {
        return this.cmK;
    }

    public final void dm(String str) {
        this.cmK = str;
        this.clZ = true;
    }

    public final void dn(String str) {
        this.cmL = str;
        this.clZ = true;
    }

    public final void do(String str) {
        this.cmM = str;
        this.clZ = true;
    }

    public final void eA(int i) {
        this.cmN = i;
        this.clZ = true;
    }

    public final void dp(String str) {
        this.cmO = str;
        this.clZ = true;
    }

    public final void dq(String str) {
        this.cmP = str;
        this.clZ = true;
    }

    public final void dr(String str) {
        this.cmQ = str;
        this.clZ = true;
    }

    public final void ds(String str) {
        this.cmR = str;
        this.clZ = true;
    }

    public final void eB(int i) {
        this.cmT = i;
        this.clZ = true;
    }
}
