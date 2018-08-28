package com.tencent.mm.ak;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.platformtools.x;

public final class e {
    public int bWA = -2;
    public long bYu;
    int cGG = 0;
    public int dHI;
    public long dTK;
    public String dTL = "";
    public String dTM = "";
    public String dTN = "";
    public int dTO;
    int dTP;
    private String dTQ = "";
    int dTR;
    public long dTS;
    int dTT;
    public int dTU = 0;
    public String dTV = "";
    int dTW = 1;
    private boolean dTX;
    private boolean dTY;
    private boolean dTZ;
    private boolean dUa;
    private boolean dUb;
    private boolean dUc;
    private boolean dUd;
    private boolean dUe;
    private boolean dUf;
    private boolean dUg;
    private boolean dUh;
    private boolean dUi;
    boolean dUj;
    private boolean dUk;
    boolean dUl;
    private boolean dUm;
    private boolean dUn;
    private boolean dUo;
    private boolean dUp;
    public int offset;
    int source;
    public int status;

    public final void lG(String str) {
        this.dTQ = str;
        this.dUn = true;
    }

    public final void setStatus(int i) {
        this.status = i;
        this.dUg = true;
    }

    public final void hJ(int i) {
        this.dTT = i;
        this.dUh = true;
    }

    public final void hK(int i) {
        this.dTR = i;
        this.dUe = true;
    }

    public final void bo(long j) {
        this.dTS = j;
        this.dUf = true;
    }

    public final void bp(long j) {
        this.dTK = j;
        this.dTX = true;
    }

    public final void ax(long j) {
        if (this.bYu != j) {
            this.dTY = true;
        }
        this.bYu = j;
    }

    public final void setOffset(int i) {
        int i2 = 0;
        if (this.offset != i) {
            this.dTZ = true;
        }
        this.offset = i;
        x.e("MicroMsg.Imgfo", "set offset : %d  id:%d total:%d", Integer.valueOf(i), Long.valueOf(this.dTS), Integer.valueOf(this.dHI));
        if (i >= this.dHI) {
            i2 = 1;
        }
        hO(i2);
    }

    public final void hL(int i) {
        this.dHI = i;
        this.dUa = true;
    }

    public final void lH(String str) {
        this.dTL = str;
        this.dUb = true;
    }

    public final void lI(String str) {
        this.dTM = str;
        this.dUc = true;
    }

    public final void lJ(String str) {
        this.dTN = str;
        this.dUd = true;
    }

    public final void hM(int i) {
        this.dTU = i;
        this.dUi = true;
    }

    public final void hN(int i) {
        this.dTP = i;
        this.dUp = true;
    }

    public final boolean OM() {
        return this.dHI != 0 && this.dHI == this.offset;
    }

    public final boolean ON() {
        return this.dTU > 0;
    }

    public final void lK(String str) {
        if ((this.dTV == null && str != null) || !(this.dTV == null || this.dTV.equals(str))) {
            this.dUk = true;
        }
        this.dTV = str;
    }

    public final void d(Cursor cursor) {
        this.dTK = (long) cursor.getInt(0);
        this.bYu = cursor.getLong(1);
        this.offset = cursor.getInt(2);
        this.dHI = cursor.getInt(3);
        this.dTL = cursor.getString(4);
        this.dTN = cursor.getString(5);
        this.dTR = cursor.getInt(6);
        this.dTS = (long) cursor.getInt(7);
        this.status = cursor.getInt(8);
        this.dTT = cursor.getInt(9);
        this.dTU = cursor.getInt(10);
        this.source = cursor.getInt(11);
        this.dTV = cursor.getString(12);
        this.cGG = cursor.getInt(14);
        this.dTW = cursor.getInt(15);
        this.dTQ = cursor.getString(16);
        this.dTO = cursor.getInt(17);
        this.dTM = cursor.getString(18);
        this.dTP = cursor.getInt(19);
    }

    public final void hO(int i) {
        if (this.dTW != i) {
            this.dUm = true;
        }
        this.dTW = i;
    }

    public final void hP(int i) {
        this.dTO = i;
        this.dUo = true;
    }

    public final ContentValues wH() {
        ContentValues contentValues = new ContentValues();
        if (this.dTX) {
            contentValues.put("id", Long.valueOf(this.dTK));
        }
        if (this.dTY) {
            contentValues.put("msgSvrId", Long.valueOf(this.bYu));
        }
        if (this.dTZ) {
            contentValues.put("offset", Integer.valueOf(this.offset));
        }
        if (this.dUa) {
            contentValues.put("totalLen", Integer.valueOf(this.dHI));
        }
        if (this.dUb) {
            contentValues.put("bigImgPath", this.dTL);
        }
        if (this.dUc) {
            contentValues.put("midImgPath", this.dTM);
        }
        if (this.dUd) {
            contentValues.put("thumbImgPath", this.dTN);
        }
        if (this.dUe) {
            contentValues.put("createtime", Integer.valueOf(this.dTR));
        }
        if (this.dUf) {
            contentValues.put("msglocalid", Long.valueOf(this.dTS));
        }
        if (this.dUg) {
            contentValues.put("status", Integer.valueOf(this.status));
        }
        if (this.dUh) {
            contentValues.put("nettimes", Integer.valueOf(this.dTT));
        }
        if (this.dUi) {
            contentValues.put("reserved1", Integer.valueOf(this.dTU));
        }
        if (this.dUj) {
            contentValues.put("reserved2", Integer.valueOf(this.source));
        }
        if (this.dUk) {
            contentValues.put("reserved3", this.dTV);
        }
        if (this.dUl) {
            contentValues.put("hashdthumb", Integer.valueOf(this.cGG));
        }
        if (this.dUm) {
            contentValues.put("iscomplete", Integer.valueOf(this.offset < this.dHI ? 0 : 1));
        }
        if (this.dUn) {
            contentValues.put("origImgMD5", this.dTQ);
        }
        if (this.dUo) {
            contentValues.put("compressType", Integer.valueOf(this.dTO));
        }
        if (this.dUp) {
            contentValues.put("forwardType", Integer.valueOf(this.dTP));
        }
        return contentValues;
    }

    public final void OO() {
        this.dTX = false;
        this.dTY = false;
        this.dTZ = false;
        this.dUa = false;
        this.dUb = false;
        this.dUc = false;
        this.dUd = false;
        this.dUe = false;
        this.dUf = false;
        this.dUg = false;
        this.dUh = false;
        this.dUi = false;
        this.dUj = false;
        this.dUk = false;
        this.dUl = false;
        this.dUm = false;
        this.dUn = false;
        this.dUo = false;
        this.dUp = false;
    }
}
