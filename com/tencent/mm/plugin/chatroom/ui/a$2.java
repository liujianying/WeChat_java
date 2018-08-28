package com.tencent.mm.plugin.chatroom.ui;

import android.app.Activity;
import android.app.ProgressDialog;
import com.tencent.mm.R;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.model.m;
import com.tencent.mm.model.q;
import com.tencent.mm.plugin.chatroom.d.o;
import com.tencent.mm.plugin.chatroom.ui.a.a;
import com.tencent.mm.storage.u;

class a$2 implements e {
    final /* synthetic */ boolean hNQ = false;
    final /* synthetic */ a hNR;
    final /* synthetic */ ProgressDialog hsv;
    final /* synthetic */ Activity mr;

    a$2(ProgressDialog progressDialog, Activity activity, a aVar) {
        this.hsv = progressDialog;
        this.mr = activity;
        this.hNR = aVar;
    }

    public final void a(int i, int i2, String str, l lVar) {
        au.DF().b(482, this);
        if (!this.hNQ) {
            this.hsv.cancel();
        }
        boolean z = false;
        this.mr.getString(R.l.room_upgrade_result_failed);
        o oVar = (o) lVar;
        if (i == 0 && i2 == 0) {
            au.HU();
            u ih = c.Ga().ih(oVar.chatroomName);
            if (ih == null) {
                ih = new u();
            }
            ih.fY(q.GF(), oVar.hLh);
            m.a(ih);
            z = true;
        }
        if (this.hNR != null) {
            this.hNR.h(z, oVar.hLi);
        }
    }
}
