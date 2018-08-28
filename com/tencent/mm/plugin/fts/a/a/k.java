package com.tencent.mm.plugin.fts.a.a;

import android.database.Cursor;

public final class k {
    public String bWm = "";
    public long dDS = 0;
    public int jru = 0;
    public String jrv = "";
    public long jsA = 0;
    public String jsB = "";
    public long jsy = 0;
    public long jsz = 0;
    public long timestamp = 0;
    public int type = 0;

    public final void d(Cursor cursor) {
        this.jsy = cursor.getLong(0);
        this.bWm = cursor.getString(1);
        this.jsz = cursor.getLong(2);
        this.dDS = cursor.getLong(3);
        this.jrv = cursor.getString(4);
        this.jsA = cursor.getLong(5);
        this.type = cursor.getInt(6);
        this.jru = cursor.getInt(7);
        this.timestamp = cursor.getLong(8);
        this.jsB = cursor.getString(9);
    }
}
