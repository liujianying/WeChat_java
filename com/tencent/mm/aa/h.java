package com.tencent.mm.aa;

import android.content.ContentValues;
import com.tencent.wcdb.FileUtils;

public final class h {
    int bWA = -1;
    int dHF;
    int dHG;
    String dHH;
    int dHI;
    int dHJ;
    int dHK;
    String dHL;
    String dHM;
    int dHN;
    int dHO;
    String username;

    public h() {
        reset();
    }

    public final void reset() {
        this.username = "";
        this.dHF = 0;
        this.dHG = 0;
        this.dHH = "";
        this.dHI = 0;
        this.dHJ = 0;
        this.dHK = 0;
        this.dHL = "";
        this.dHM = "";
        this.dHN = 0;
        this.dHO = 0;
    }

    public final ContentValues wH() {
        ContentValues contentValues = new ContentValues();
        if ((this.bWA & 1) != 0) {
            contentValues.put("username", this.username == null ? "" : this.username);
        }
        if ((this.bWA & 2) != 0) {
            contentValues.put("imgwidth", Integer.valueOf(this.dHF));
        }
        if ((this.bWA & 4) != 0) {
            contentValues.put("imgheigth", Integer.valueOf(this.dHG));
        }
        if ((this.bWA & 8) != 0) {
            contentValues.put("imgformat", Kv());
        }
        if ((this.bWA & 16) != 0) {
            contentValues.put("totallen", Integer.valueOf(this.dHI));
        }
        if ((this.bWA & 32) != 0) {
            contentValues.put("startpos", Integer.valueOf(this.dHJ));
        }
        if ((this.bWA & 64) != 0) {
            contentValues.put("headimgtype", Integer.valueOf(this.dHK));
        }
        if ((this.bWA & FileUtils.S_IWUSR) != 0) {
            contentValues.put("reserved1", this.dHL == null ? "" : this.dHL);
        }
        if ((this.bWA & 256) != 0) {
            contentValues.put("reserved2", this.dHM == null ? "" : this.dHM);
        }
        if ((this.bWA & 512) != 0) {
            contentValues.put("reserved3", Integer.valueOf(this.dHN));
        }
        if ((this.bWA & 1024) != 0) {
            contentValues.put("reserved4", Integer.valueOf(this.dHO));
        }
        return contentValues;
    }

    public final String Kv() {
        return this.dHH == null ? "" : this.dHH;
    }
}
