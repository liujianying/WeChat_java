package com.tencent.mm.aa;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.platformtools.bi;

public final class j {
    public int bWA = -1;
    public int csA = 0;
    int dHP = 0;
    public String dHQ = "";
    public String dHR = "";
    private int dHS = 0;
    int dHT = 0;
    public String username = "";

    public final void d(Cursor cursor) {
        this.username = cursor.getString(0);
        this.csA = cursor.getInt(1);
        this.dHP = cursor.getInt(2);
        this.dHR = cursor.getString(3);
        this.dHQ = cursor.getString(4);
        this.dHS = cursor.getInt(5);
        this.dHT = cursor.getInt(6);
    }

    public final ContentValues Kw() {
        ContentValues contentValues = new ContentValues();
        if ((this.bWA & 1) != 0) {
            contentValues.put("username", getUsername());
        }
        if ((this.bWA & 2) != 0) {
            contentValues.put("imgflag", Integer.valueOf(this.csA));
        }
        if ((this.bWA & 4) != 0) {
            contentValues.put("lastupdatetime", Integer.valueOf(this.dHP));
        }
        if ((this.bWA & 8) != 0) {
            contentValues.put("reserved1", Kx());
        }
        if ((this.bWA & 16) != 0) {
            contentValues.put("reserved2", Ky());
        }
        if ((this.bWA & 32) != 0) {
            contentValues.put("reserved3", Integer.valueOf(this.dHS));
        }
        if ((this.bWA & 64) != 0) {
            contentValues.put("reserved4", Integer.valueOf(this.dHT));
        }
        return contentValues;
    }

    public final void setUsername(String str) {
        this.username = str;
    }

    public final String getUsername() {
        return this.username == null ? "" : this.username;
    }

    public final String Kx() {
        return this.dHR == null ? "" : this.dHR;
    }

    public final void kb(String str) {
        this.dHQ = str;
    }

    public final String Ky() {
        return this.dHQ == null ? "" : this.dHQ;
    }

    public final void by(boolean z) {
        this.dHS = z ? 1 : 0;
    }

    public final void Kz() {
        this.dHT = (int) (bi.VE() / 60);
        this.bWA |= 64;
    }
}
