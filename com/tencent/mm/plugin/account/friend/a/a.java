package com.tencent.mm.plugin.account.friend.a;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.u;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.smtt.sdk.TbsListener$ErrorCode;
import com.tencent.tmassistantsdk.downloadservice.Downloads;

public final class a {
    private String bKg = "";
    public int bWA = -1;
    String bgn = "";
    public String csD = "";
    public String dHL = "";
    public int dHO = 0;
    public String dia = "";
    String eJA = "";
    String eJB = "";
    public String eJC = "";
    public int eJD = 0;
    public byte[] eJE;
    public int eJF;
    public String eJG = "";
    public int eJH = 0;
    public String eJI = "";
    public String eJJ = "";
    public String eJK = "";
    int eJL = 0;
    public String eJM = "";
    int eJN = 0;
    int eJO = 0;
    String eJP = "";
    public String eJQ = "";
    String eJR = "";
    int eJS = -1;
    String eJT = "";
    long eJU = -1;
    int eJV = -1;
    String eJW = "";
    String eJX = "";
    String eJY = "";
    public long eJZ = 0;
    public String eJw = "";
    long eJx = 0;
    public String eJy = "";
    public String eJz = "";
    private int id = 0;
    public int status = 0;
    public int type = 0;
    public String username = "";

    public final void d(Cursor cursor) {
        po(cursor.getString(1));
        this.eJw = cursor.getString(2);
        this.eJx = cursor.getLong(3);
        this.dia = cursor.getString(4);
        this.eJy = cursor.getString(5);
        this.eJz = cursor.getString(6);
        this.username = cursor.getString(7);
        this.bgn = cursor.getString(8);
        this.eJA = cursor.getString(9);
        this.eJB = cursor.getString(10);
        this.type = cursor.getInt(11);
        this.eJC = cursor.getString(12);
        this.csD = cursor.getString(13);
        int i = cursor.getInt(14);
        if (i == 65536) {
            this.status = 0;
        } else {
            this.status = i;
        }
        this.eJD = cursor.getInt(17);
        this.dHL = cursor.getString(15);
        this.dHO = cursor.getInt(18);
        this.eJE = cursor.getBlob(19);
        if (!bi.bC(this.eJE)) {
            byte[] bArr = this.eJE;
            try {
                u uVar = new u();
                i = uVar.by(bArr);
                if (i != 0) {
                    x.e("MicroMsg.AddrUpload", "parse LVBuffer error:" + i);
                } else {
                    this.eJG = uVar.getString();
                    this.eJH = uVar.getInt();
                    this.eJI = uVar.getString();
                    this.eJJ = uVar.getString();
                    this.eJK = uVar.getString();
                    this.eJL = uVar.getInt();
                    this.eJM = uVar.getString();
                    this.eJN = uVar.getInt();
                    this.eJO = uVar.getInt();
                    this.eJP = uVar.getString();
                    this.eJQ = uVar.getString();
                    this.eJR = uVar.getString();
                    this.eJS = uVar.getInt();
                    this.eJT = uVar.getString();
                    this.eJU = uVar.getLong();
                    this.eJV = uVar.getInt();
                    this.eJW = uVar.getString();
                    this.eJX = uVar.getString();
                    this.eJY = uVar.getString();
                    this.eJZ = uVar.getLong();
                }
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.AddrUpload", e, "", new Object[0]);
            }
        }
        this.eJF = cursor.getInt(20);
    }

    public final ContentValues wH() {
        ContentValues contentValues = new ContentValues();
        if ((this.bWA & 1) != 0) {
            contentValues.put("id", Integer.valueOf(this.id));
        }
        if ((this.bWA & 2) != 0) {
            contentValues.put("md5", Xh());
        }
        if ((this.bWA & 4) != 0) {
            contentValues.put("peopleid", Xi());
        }
        if ((this.bWA & 8) != 0) {
            contentValues.put("uploadtime", Long.valueOf(this.eJx));
        }
        if ((this.bWA & 16) != 0) {
            contentValues.put("realname", Xj());
        }
        if ((this.bWA & 32) != 0) {
            contentValues.put("realnamepyinitial", Xk());
        }
        if ((this.bWA & 64) != 0) {
            contentValues.put("realnamequanpin", Xl());
        }
        if ((this.bWA & 128) != 0) {
            contentValues.put("username", getUsername());
        }
        if ((this.bWA & 256) != 0) {
            contentValues.put("nickname", Xm());
        }
        if ((this.bWA & 512) != 0) {
            contentValues.put("nicknamepyinitial", Xn());
        }
        if ((this.bWA & 1024) != 0) {
            contentValues.put("nicknamequanpin", Xo());
        }
        if ((this.bWA & 2048) != 0) {
            contentValues.put("type", Integer.valueOf(this.type));
        }
        if ((this.bWA & Downloads.RECV_BUFFER_SIZE) != 0) {
            contentValues.put("moblie", Xp());
        }
        if ((this.bWA & 8192) != 0) {
            contentValues.put("email", Xq());
        }
        if ((this.bWA & 16384) != 0) {
            int i = this.status;
            if (i == 0) {
                contentValues.put("status", Integer.valueOf(65536));
            } else {
                contentValues.put("status", Integer.valueOf(i));
            }
        }
        if ((this.bWA & 32768) != 0) {
            contentValues.put("reserved1", this.dHL);
        }
        if ((this.bWA & 131072) != 0) {
            contentValues.put("reserved3", Integer.valueOf(this.eJD));
        }
        if ((this.bWA & 262144) != 0) {
            contentValues.put("reserved4", Integer.valueOf(this.dHO));
        }
        if ((this.bWA & 524288) != 0) {
            this.eJE = Xg();
            contentValues.put("lvbuf", this.eJE);
        }
        if ((this.bWA & 1048576) != 0) {
            contentValues.put("showhead", Integer.valueOf(this.eJF));
        }
        return contentValues;
    }

    private byte[] Xg() {
        try {
            u uVar = new u();
            uVar.chE();
            uVar.Wj(this.eJG);
            uVar.CZ(this.eJH);
            uVar.Wj(this.eJI);
            uVar.Wj(this.eJJ);
            uVar.Wj(this.eJK);
            uVar.CZ(this.eJL);
            uVar.Wj(this.eJM);
            uVar.CZ(this.eJN);
            uVar.CZ(this.eJO);
            uVar.Wj(this.eJP);
            uVar.Wj(this.eJQ);
            uVar.Wj(this.eJR);
            uVar.CZ(this.eJS);
            uVar.Wj(this.eJT);
            uVar.fX(this.eJU);
            uVar.CZ(this.eJV);
            uVar.Wj(this.eJW);
            uVar.Wj(this.eJX);
            uVar.Wj(this.eJY);
            uVar.fX(this.eJZ);
            return uVar.chF();
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.AddrUpload", e, "", new Object[0]);
            return null;
        }
    }

    public static int pn(String str) {
        int i = 0;
        try {
            return bi.WM("0x" + str.substring(0, 8));
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.AddrUpload", e, "md5: %s", new Object[]{str});
            return i;
        }
    }

    public final void po(String str) {
        this.bKg = str;
        this.id = pn(str);
    }

    public final String Xh() {
        return this.bKg == null ? "" : this.bKg;
    }

    public final String Xi() {
        return this.eJw == null ? "" : this.eJw;
    }

    public final String Xj() {
        return this.dia == null ? "" : this.dia;
    }

    public final String Xk() {
        return this.eJy == null ? "" : this.eJy;
    }

    public final String Xl() {
        return this.eJz == null ? "" : this.eJz;
    }

    public final String getUsername() {
        return this.username == null ? "" : this.username;
    }

    public final String Xm() {
        return this.bgn == null ? "" : this.bgn;
    }

    public final String Xn() {
        return this.eJA == null ? "" : this.eJA;
    }

    public final String Xo() {
        return this.eJB == null ? "" : this.eJB;
    }

    public final String Xp() {
        return this.eJC == null ? "" : this.eJC;
    }

    public final String Xq() {
        return this.csD == null ? "" : this.csD;
    }

    public final void Xr() {
        this.eJD |= 1;
    }

    public final boolean Xs() {
        return (this.eJD & 1) == 0;
    }

    public final int AY() {
        int i = 32;
        if (!bi.oW(Xk())) {
            i = Xk().charAt(0);
        } else if (!bi.oW(Xl())) {
            i = Xl().charAt(0);
        }
        if (i >= 97 && i <= TbsListener$ErrorCode.DOWNLOAD_HAS_COPY_TBS_ERROR) {
            return (char) (i - 32);
        }
        if (i < 65 || i > 90) {
            return TbsListener$ErrorCode.DOWNLOAD_RETRYTIMES302_EXCEED;
        }
        return i;
    }
}
