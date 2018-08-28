package com.tencent.mm.plugin.exdevice.ui;

import com.tencent.mm.plugin.exdevice.f.b.a.d;

final class e {
    int Xe;
    d iHF;
    int iHG;

    /* synthetic */ e(int i, int i2, String str, String str2, d dVar, byte b) {
        this(i, i2, str, str2, dVar);
    }

    private e(int i, int i2, String str, String str2, d dVar) {
        this.Xe = i;
        this.iHG = i2;
        if (i == 0) {
            return;
        }
        if (dVar != null) {
            this.iHF = dVar;
            return;
        }
        d dVar2 = new d();
        dVar2.field_username = str2;
        dVar2.field_appusername = str;
        dVar2.field_ranknum = 0;
        dVar2.field_selfLikeState = 0;
        dVar2.field_rankID = "";
        dVar2.field_likecount = 0;
        dVar2.field_score = 0;
        this.iHF = dVar2;
    }

    public final String toString() {
        String str = "{ view type: " + this.Xe + " display flag: " + this.iHG;
        if (this.iHF != null) {
            str = str + this.iHF.toString();
        } else {
            str = str + " mExdeviceRankInfo is null";
        }
        return str + "}";
    }
}
