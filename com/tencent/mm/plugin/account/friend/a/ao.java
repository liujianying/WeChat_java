package com.tencent.mm.plugin.account.friend.a;

import android.content.ContentValues;
import android.database.Cursor;

public final class ao {
    int bWA = -1;
    String dHL = "";
    String dHM = "";
    public int dHN = 0;
    public int dHO = 0;
    String eLA = "";
    String eLB = "";
    String eLC = "";
    String eLD = "";
    public String eLE = "";
    String eLF = "";
    String eLG = "";
    public long eLw = 0;
    public int eLx = 0;
    int eLy = 0;
    String eLz = "";
    public String nickname = "";
    public String username = "";

    public final void d(Cursor cursor) {
        this.eLw = cursor.getLong(0);
        int i = cursor.getInt(1);
        if (i == 65536) {
            this.eLx = 0;
        } else {
            this.eLx = i;
        }
        this.eLy = cursor.getInt(2);
        this.username = cursor.getString(3);
        this.nickname = cursor.getString(4);
        this.eLz = cursor.getString(5);
        this.eLA = cursor.getString(6);
        this.eLB = cursor.getString(7);
        this.eLC = cursor.getString(8);
        this.eLD = cursor.getString(9);
        this.eLE = cursor.getString(10);
        this.eLF = cursor.getString(11);
        this.eLG = cursor.getString(12);
        this.dHL = cursor.getString(13);
        this.dHM = cursor.getString(14);
        this.dHN = cursor.getInt(15);
        this.dHO = cursor.getInt(16);
    }

    public final ContentValues XV() {
        ContentValues contentValues = new ContentValues();
        if ((this.bWA & 1) != 0) {
            contentValues.put("qq", Long.valueOf(this.eLw));
        }
        if ((this.bWA & 2) != 0) {
            int i = this.eLx;
            if (i == 0) {
                contentValues.put("wexinstatus", Integer.valueOf(65536));
            } else {
                contentValues.put("wexinstatus", Integer.valueOf(i));
            }
        }
        if ((this.bWA & 4) != 0) {
            contentValues.put("groupid", Integer.valueOf(this.eLy));
        }
        if ((this.bWA & 8) != 0) {
            contentValues.put("username", getUsername());
        }
        if ((this.bWA & 16) != 0) {
            contentValues.put("nickname", wO());
        }
        if ((this.bWA & 32) != 0) {
            contentValues.put("pyinitial", this.eLz == null ? "" : this.eLz);
        }
        if ((this.bWA & 64) != 0) {
            contentValues.put("quanpin", this.eLA == null ? "" : this.eLA);
        }
        if ((this.bWA & 128) != 0) {
            contentValues.put("qqnickname", XW());
        }
        if ((this.bWA & 256) != 0) {
            contentValues.put("qqpyinitial", XX());
        }
        if ((this.bWA & 512) != 0) {
            contentValues.put("qqquanpin", XY());
        }
        if ((this.bWA & 1024) != 0) {
            contentValues.put("qqremark", XZ());
        }
        if ((this.bWA & 2048) != 0) {
            contentValues.put("qqremarkpyinitial", Ya());
        }
        if ((this.bWA & 4096) != 0) {
            contentValues.put("qqremarkquanpin", Yb());
        }
        if ((this.bWA & 16384) != 0) {
            contentValues.put("reserved2", this.dHM == null ? "" : this.dHM);
        }
        if ((this.bWA & 32768) != 0) {
            contentValues.put("reserved3", Integer.valueOf(this.dHN));
        }
        if ((this.bWA & 65536) != 0) {
            contentValues.put("reserved4", Integer.valueOf(this.dHO));
        }
        return contentValues;
    }

    public final String getUsername() {
        return this.username == null ? "" : this.username;
    }

    public final String wO() {
        return this.nickname == null ? "" : this.nickname;
    }

    public final String XW() {
        return this.eLB == null ? "" : this.eLB;
    }

    public final String XX() {
        return this.eLC == null ? "" : this.eLC;
    }

    public final String XY() {
        return this.eLD == null ? "" : this.eLD;
    }

    public final String XZ() {
        return this.eLE == null ? "" : this.eLE;
    }

    public final String Ya() {
        return this.eLF == null ? "" : this.eLF;
    }

    public final String Yb() {
        return this.eLG == null ? "" : this.eLG;
    }

    public final String getDisplayName() {
        if (XZ() == null || XZ().length() <= 0) {
            return XW();
        }
        return XZ();
    }

    public final void Yc() {
        this.dHN |= 1;
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("groupID\t:").append(this.eLy).append("\n");
        stringBuilder.append("qq\t:").append(this.eLw).append("\n");
        stringBuilder.append("username\t:").append(this.username).append("\n");
        stringBuilder.append("nickname\t:").append(this.nickname).append("\n");
        stringBuilder.append("wexinStatus\t:").append(this.eLx).append("\n");
        stringBuilder.append("reserved3\t:").append(this.dHN).append("\n");
        stringBuilder.append("reserved4\t:").append(this.dHO).append("\n");
        return stringBuilder.toString();
    }
}
