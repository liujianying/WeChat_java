package com.tencent.mm.model;

import android.database.Cursor;
import junit.framework.Assert;

public final class bi {
    int bWA = -1;
    public String dCO = "";
    public String dCP = "";
    public String dCQ = "";
    public long dCR = 0;
    public String dCS = "";
    public String dCT = "";
    public int dCU = 0;
    public int dCV = 0;
    public long dCW = 0;
    public String dCX = "";
    String dCY = "";
    public String dzA = "";
    public String dzy = "";
    public String name = "";
    public long time = 0;
    public String title = "";
    public int type = 0;
    public String url = "";

    public final void d(Cursor cursor) {
        this.dCO = cursor.getString(0);
        this.time = cursor.getLong(1);
        this.type = cursor.getInt(2);
        this.name = cursor.getString(3);
        this.title = cursor.getString(4);
        this.url = cursor.getString(5);
        this.dCP = cursor.getString(6);
        this.dCQ = cursor.getString(7);
        this.dCR = cursor.getLong(8);
        this.dCS = cursor.getString(9);
        this.dCT = cursor.getString(10);
        this.dCU = cursor.getInt(11);
        this.dzy = cursor.getString(12);
        this.dzA = cursor.getString(13);
        this.dCV = cursor.getInt(14);
        this.dCW = cursor.getLong(15);
        this.dCX = cursor.getString(16);
        this.dCY = cursor.getString(17);
    }

    public static String he(int i) {
        if (i == 20) {
            return "newsapp";
        }
        if (i == 11) {
            return "blogapp";
        }
        Assert.assertTrue("INFO TYPE NEITHER NEWS NOR WEIBO", false);
        return null;
    }

    public final boolean Iu() {
        return this.dCV == 1;
    }

    public final String Iv() {
        return this.dCO == null ? "" : this.dCO;
    }

    public final String getName() {
        return this.name == null ? "" : this.name;
    }

    public final String getTitle() {
        return this.title == null ? "" : this.title;
    }

    public final String getUrl() {
        return this.url == null ? "" : this.url;
    }

    public final String Iw() {
        return this.dCP == null ? "" : this.dCP;
    }

    public final String Ix() {
        return this.dCS == null ? "" : this.dCS;
    }

    public final String Iy() {
        return this.dCT == null ? "" : this.dCT;
    }

    public final String Iz() {
        if (this.dzy == null) {
            return "";
        }
        String[] split = this.dzy.split("\\|");
        if (split == null || split.length <= 0) {
            return "";
        }
        return split[0];
    }

    public final String IA() {
        return this.dzA == null ? "" : this.dzA;
    }

    public final String IB() {
        return this.dCX == null ? "" : this.dCX;
    }
}
