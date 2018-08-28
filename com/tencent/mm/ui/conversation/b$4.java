package com.tencent.mm.ui.conversation;

import android.app.ProgressDialog;
import com.tencent.mm.model.au;
import com.tencent.mm.model.bd.a;
import com.tencent.mm.model.c;
import com.tencent.mm.model.s;
import com.tencent.mm.pointers.PBool;
import com.tencent.mm.storage.ab;

class b$4 implements a {
    final /* synthetic */ String dhh;
    final /* synthetic */ ProgressDialog hsv;
    final /* synthetic */ PBool unC;

    b$4(PBool pBool, ProgressDialog progressDialog, String str) {
        this.unC = pBool;
        this.hsv = progressDialog;
        this.dhh = str;
    }

    public final boolean Ip() {
        return this.unC.value || this.hsv == null || !this.hsv.isShowing();
    }

    public final void Io() {
        au.HU();
        ab Yg = c.FR().Yg(this.dhh);
        Yg.Bi();
        if (com.tencent.mm.l.a.gd(Yg.field_type)) {
            s.u(Yg.field_username, false);
        } else {
            au.HU();
            c.FR().a(this.dhh, Yg);
        }
        au.HU();
        c.FW().Yp(this.dhh);
        if (this.hsv != null) {
            this.hsv.dismiss();
        }
    }
}
