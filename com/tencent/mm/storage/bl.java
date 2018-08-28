package com.tencent.mm.storage;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.wcdb.FileUtils;

public final class bl {
    int bWA;
    public String name;
    int status;
    public a tcr;
    public int tcs;

    public static class a {
        private String bWJ;
        private String cfx;

        public a(String str) {
            int indexOf = str.indexOf("@");
            if (indexOf >= 0) {
                this.bWJ = str.substring(0, indexOf);
                this.cfx = str.substring(indexOf);
                return;
            }
            this.bWJ = str;
            this.cfx = "";
        }

        public final String Zk(String str) {
            return this.cfx != null ? this.cfx : str;
        }
    }

    public bl() {
        this.bWA = 135;
        this.name = "";
        this.tcr = null;
        this.tcr = null;
        this.name = "";
        this.status = 0;
        this.tcs = 0;
    }

    public bl(String str, boolean z, int i) {
        this.bWA = 135;
        this.name = "";
        this.tcr = null;
        this.tcr = new a(str);
        this.name = str;
        this.status = (z ? 1 : 0) | 2;
        this.tcs = i;
    }

    public final void setEnable(boolean z) {
        if (z) {
            this.status = (z ? 1 : 0) | this.status;
            return;
        }
        this.status &= -2;
    }

    public final boolean isEnable() {
        return (this.status & 1) != 0;
    }

    public final boolean cmV() {
        return (this.status & 2) != 0;
    }

    public final void d(Cursor cursor) {
        if ((this.bWA & 2) != 0) {
            this.name = cursor.getString(1);
            if (this.tcr == null) {
                this.tcr = new a(this.name);
            }
        }
        if ((this.bWA & 4) != 0) {
            this.status = cursor.getInt(2);
        }
        if ((this.bWA & FileUtils.S_IWUSR) != 0) {
            this.tcs = cursor.getInt(7);
        }
    }

    public final ContentValues wH() {
        ContentValues contentValues = new ContentValues();
        if ((this.bWA & 2) != 0) {
            contentValues.put("name", this.name);
        }
        if ((this.bWA & 4) != 0) {
            contentValues.put("status", Integer.valueOf(this.status));
        }
        if ((this.bWA & FileUtils.S_IWUSR) != 0) {
            contentValues.put("int_reserved1", Integer.valueOf(this.tcs));
        }
        return contentValues;
    }
}
