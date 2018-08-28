package com.tencent.mm.modelstat;

import android.database.Cursor;

public final class k {
    private static final String FORMAT;
    int bWA = -2;
    public int ejM = 0;
    public int ejN = 0;
    public int ejO = 0;
    public int ejP = 0;
    public int ejQ = 0;
    public int ejR = 0;
    public int ejS = 0;
    public int ejT = 0;
    public int ejU = 0;
    public int ejV = 0;
    public int ejW = 0;
    public int ejX = 0;
    public int ejY = 0;
    public int ejZ = 0;
    public int eka = 0;
    public int ekb = 0;
    public int ekc = 0;
    public int ekd = 0;
    public int eke = 0;
    public int ekf = 0;
    public int ekg = 0;
    public int ekh = 0;
    public int eki = 0;
    public int ekj = 0;
    public int ekk = 0;
    public int ekl = 0;
    public int ekm = 0;
    public int ekn = 0;
    public int eko = 0;
    public int id = 0;

    public final void d(Cursor cursor) {
        this.id = cursor.getInt(0);
        this.ejM = cursor.getInt(1);
        this.ejN = cursor.getInt(2);
        this.ejO = cursor.getInt(3);
        this.ejP = cursor.getInt(4);
        this.ejQ = cursor.getInt(5);
        this.ejR = cursor.getInt(6);
        this.ejS = cursor.getInt(7);
        this.ejT = cursor.getInt(8);
        this.ejU = cursor.getInt(9);
        this.ejV = cursor.getInt(10);
        this.ejW = cursor.getInt(11);
        this.ejX = cursor.getInt(12);
        this.ejY = cursor.getInt(13);
        this.ejZ = cursor.getInt(14);
        this.eka = cursor.getInt(15);
        this.ekb = cursor.getInt(16);
        this.ekc = cursor.getInt(17);
        this.ekd = cursor.getInt(18);
        this.eke = cursor.getInt(19);
        this.ekf = cursor.getInt(20);
        this.ekg = cursor.getInt(21);
        this.ekh = cursor.getInt(22);
        this.eki = cursor.getInt(23);
        this.ekj = cursor.getInt(24);
        this.ekk = cursor.getInt(25);
        this.ekl = cursor.getInt(26);
        this.ekm = cursor.getInt(27);
        this.ekn = cursor.getInt(28);
        this.eko = cursor.getInt(29);
    }

    static {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("NetStatInfo:");
        stringBuilder.append("[mobile in=%dB/%dB/%dB, out=%dB/%dB/%dB]");
        stringBuilder.append("[wifi in=%dB/%dB/%dB, out=%dB/%dB/%dB]");
        stringBuilder.append("[text in=%d/%dB, out=%d/%dB]");
        stringBuilder.append("[image in=%d/%dB, out=%d/%dB]");
        stringBuilder.append("[voice in=%d/%dB, out=%d/%dB]");
        stringBuilder.append("[video in=%d/%dB, out=%d/%dB]");
        FORMAT = stringBuilder.toString();
    }

    public final String toString() {
        return String.format(FORMAT, new Object[]{Integer.valueOf(this.ejV), Integer.valueOf(this.ekl), Integer.valueOf(this.ejX), Integer.valueOf(this.ekh), Integer.valueOf(this.ekn), Integer.valueOf(this.ekj), Integer.valueOf(this.ejW), Integer.valueOf(this.ekm), Integer.valueOf(this.ejY), Integer.valueOf(this.eki), Integer.valueOf(this.eko), Integer.valueOf(this.ekk), Integer.valueOf(this.ejN), Integer.valueOf(this.ejO), Integer.valueOf(this.ejZ), Integer.valueOf(this.eka), Integer.valueOf(this.ejP), Integer.valueOf(this.ejQ), Integer.valueOf(this.ekb), Integer.valueOf(this.ekc), Integer.valueOf(this.ejR), Integer.valueOf(this.ejS), Integer.valueOf(this.ekd), Integer.valueOf(this.eke), Integer.valueOf(this.ejT), Integer.valueOf(this.ejU), Integer.valueOf(this.ekf), Integer.valueOf(this.ekg)});
    }
}
