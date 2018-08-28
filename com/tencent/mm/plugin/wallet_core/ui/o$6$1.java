package com.tencent.mm.plugin.wallet_core.ui;

import com.tencent.mm.plugin.wallet.a.h;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.FavorPayInfo;
import com.tencent.mm.plugin.wallet_core.model.o;
import com.tencent.mm.plugin.wallet_core.ui.j.b;
import com.tencent.mm.plugin.wallet_core.ui.o.6;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.wallet_core.c.u;
import com.tencent.mm.wallet_core.ui.e;
import java.util.ArrayList;
import java.util.List;

class o$6$1 implements b {
    final /* synthetic */ 6 pyb;

    o$6$1(6 6) {
        this.pyb = 6;
    }

    public final void a(FavorPayInfo favorPayInfo) {
        boolean z;
        List list;
        double d;
        String B;
        String string;
        String str;
        String str2;
        String str3;
        String str4 = null;
        this.pyb.pxX.pfz = favorPayInfo;
        u.d(this.pyb.pxX.mpb == null ? 0 : this.pyb.pxX.mpb.bVY, this.pyb.pxX.mpb == null ? "" : this.pyb.pxX.mpb.bOd, 15, this.pyb.pxX.pfz.pnP);
        this.pyb.pxX.pxA = false;
        int i = this.pyb.pxX.pfz.pnQ;
        String str5 = this.pyb.pxX.pfz.pnR;
        ArrayList jl = o.bOW().jl(true);
        if (i != 0) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            List arrayList = new ArrayList();
            for (int i2 = 0; i2 < jl.size(); i2++) {
                if (bi.oW(str5)) {
                    if (!((Bankcard) jl.get(i2)).field_bankcardType.equals("CFT")) {
                        z = true;
                    }
                    z = false;
                } else {
                    if (((Bankcard) jl.get(i2)).field_bankcardType.equals(str5)) {
                        z = true;
                    }
                    z = false;
                }
                if (z) {
                    arrayList.add((Bankcard) jl.get(i2));
                }
            }
            list = arrayList;
        } else {
            list = jl;
        }
        this.pyb.pxX.pfz.pnT = "";
        if (a.a(this.pyb.pxX.pfz, this.pyb.pxX.pxC)) {
            this.pyb.pxX.pxA = true;
            if (list.size() == 0) {
                this.pyb.pxX.pfz.pnT = this.pyb.val$context.getString(i.wallet_favor_need_bind_bankcard);
            } else {
                this.pyb.pxX.pfz.pnT = this.pyb.val$context.getString(i.wallet_favor_need_change_bankcard);
            }
            this.pyb.pxX.dismiss();
            if (this.pyb.pxX.pxU != null) {
                this.pyb.pxX.pxU.a(this.pyb.pxX.pxo.getText(), this.pyb.pxX.pfz, this.pyb.pxX.pxA);
                return;
            }
        }
        if (this.pyb.pxX.pxr != null) {
            this.pyb.pxX.pxr.setTag(this.pyb.pxX.pfz);
        }
        h Pn = this.pyb.pxX.pgk.Pn(this.pyb.pxX.pfz.pnP);
        double d2 = this.pyb.pya.ppg.pdX;
        if (Pn == null || Pn.pef <= 0.0d) {
            d = this.pyb.pya.ppg.pdV;
            B = e.B(this.pyb.pya.ppg.pdV);
            string = this.pyb.val$context.getString(i.wallet_pwd_dialog_more_favors);
            str = null;
            str2 = null;
            str3 = B;
        } else {
            d = Pn.pdX;
            str3 = e.B(Pn.pee);
            str2 = e.B(this.pyb.pya.ppg.pdV);
            string = null;
            str = Pn.peh;
        }
        if (Pn == null || Pn.peg == 0) {
            B = null;
        } else {
            B = Pn.pei;
            if (!bi.oW(str)) {
                B = "," + B;
            }
        }
        if (bi.oW(str) && bi.oW(B)) {
            str4 = string;
        } else if (!bi.oW(string)) {
            str4 = "," + string;
        }
        this.pyb.pxX.d(str3, d);
        this.pyb.pxX.Pw(str2);
        this.pyb.pxX.ff(str, str4);
        o oVar = this.pyb.pxX;
        str = this.pyb.pya.lNV;
        oVar.Px(B);
    }
}
