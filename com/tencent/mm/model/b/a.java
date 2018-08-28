package com.tencent.mm.model.b;

import android.content.SharedPreferences;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;

public abstract class a implements e {
    protected com.tencent.mm.model.b.e.a dDU;
    protected String dDV = IY();
    protected String[] dDW = IX();

    public abstract String IY();

    public final boolean iV(String str) {
        au.HU();
        SharedPreferences gh = c.gh("banner");
        if (gh == null || !gh.getBoolean(this.dDV + str, false)) {
            return false;
        }
        return true;
    }

    public final void a(String str, boolean z, String[] strArr) {
        au.HU();
        SharedPreferences gh = c.gh("banner");
        if (gh != null) {
            gh.edit().putBoolean(this.dDV + str, z).commit();
            if (!(this.dDW == null || strArr == null || this.dDW.length != strArr.length)) {
                int i = 0;
                for (String str2 : this.dDW) {
                    if (str2 != null) {
                        gh.edit().putString(this.dDV + str2 + str, strArr[i] != null ? strArr[i] : "").commit();
                    }
                    i++;
                }
            }
            if (this.dDU != null) {
                this.dDU.Jk();
            }
        }
    }

    public final String X(String str, String str2) {
        au.HU();
        SharedPreferences gh = c.gh("banner");
        if (gh == null) {
            return null;
        }
        return gh.getString(this.dDV + str2 + str, null);
    }

    public final void iW(String str) {
        au.HU();
        SharedPreferences gh = c.gh("banner");
        if (gh != null) {
            gh.edit().remove(this.dDV + str).commit();
            if (this.dDW != null) {
                for (String str2 : this.dDW) {
                    if (str2 != null) {
                        gh.edit().remove(this.dDV + str2 + str).commit();
                    }
                }
            }
            if (this.dDU != null) {
                this.dDU.Jl();
            }
        }
    }

    public final void a(com.tencent.mm.model.b.e.a aVar) {
        this.dDU = aVar;
    }

    protected String[] IX() {
        return null;
    }
}
