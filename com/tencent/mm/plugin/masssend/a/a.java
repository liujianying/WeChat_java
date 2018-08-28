package com.tencent.mm.plugin.masssend.a;

import android.database.Cursor;

public final class a {
    int bWA = -1;
    public int bxj = 0;
    public long createTime = 0;
    String dCX = "";
    String dCY = "";
    String ehf = "";
    int enI = 0;
    long enK = 0;
    public String filename = "";
    String lai = "";
    public String laj = "";
    public int lak = 0;
    public int lal = 0;
    int lam = 0;
    int lan = 0;
    public int lao = 0;
    public int msgType = 0;
    int status = 0;
    public int videoSource = 0;

    public final void d(Cursor cursor) {
        this.ehf = cursor.getString(0);
        this.status = cursor.getInt(1);
        this.createTime = cursor.getLong(2);
        this.enK = cursor.getLong(3);
        this.filename = cursor.getString(4);
        this.lai = cursor.getString(5);
        this.laj = cursor.getString(6);
        this.lak = cursor.getInt(7);
        this.msgType = cursor.getInt(8);
        this.lal = cursor.getInt(9);
        this.lam = cursor.getInt(10);
        this.bxj = cursor.getInt(11);
        this.enI = cursor.getInt(12);
        this.lan = cursor.getInt(13);
        this.videoSource = cursor.getInt(14);
        this.lao = cursor.getInt(15);
        this.dCX = cursor.getString(16);
        this.dCY = cursor.getString(17);
    }

    public final String bcg() {
        return this.ehf == null ? "" : this.ehf;
    }

    public final String bch() {
        return this.filename == null ? "" : this.filename;
    }

    public final String bci() {
        return this.lai == null ? "" : this.lai;
    }

    public final String bcj() {
        return this.laj == null ? "" : this.laj;
    }
}
