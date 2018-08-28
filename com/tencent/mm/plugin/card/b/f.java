package com.tencent.mm.plugin.card.b;

import android.text.TextUtils;
import com.tencent.mm.model.s;
import com.tencent.mm.plugin.card.a.g;
import com.tencent.mm.plugin.card.base.b;
import com.tencent.mm.plugin.card.d.l;
import com.tencent.mm.protocal.c.la;
import com.tencent.mm.ui.MMActivity;
import java.util.ArrayList;
import java.util.List;

public final class f {
    public MMActivity gKS;
    public int hop = 3;
    public b htQ;
    public List<com.tencent.mm.plugin.card.model.b> htU = new ArrayList();
    public com.tencent.mm.plugin.card.model.b htV;
    public ArrayList<la> htW;

    public f(MMActivity mMActivity) {
        this.gKS = mMActivity;
    }

    public final com.tencent.mm.plugin.card.model.b awL() {
        boolean z;
        com.tencent.mm.plugin.card.model.b bVar = new com.tencent.mm.plugin.card.model.b();
        bVar.hvh = 1;
        if (l.nZ(this.hop) || l.oa(this.hop) || this.hop == 23) {
            if (!(!this.htQ.isAcceptable() || this.htQ.awm().roa == null || TextUtils.isEmpty(this.htQ.awm().roa.text) || TextUtils.isEmpty(this.htQ.awm().rnD))) {
                z = true;
            }
            z = false;
        } else {
            if (!(this.hop != 6 || !this.htQ.awj() || this.htQ.awm().roa == null || TextUtils.isEmpty(this.htQ.awm().roa.text) || TextUtils.isEmpty(this.htQ.awm().rnD))) {
                z = true;
            }
            z = false;
        }
        bVar.hvj = z;
        if (!bVar.hvj && !TextUtils.isEmpty(this.htQ.awm().rnT)) {
            bVar.title = this.htQ.awm().rnT;
        } else if (s.he(this.htQ.awm().rnD)) {
            bVar.title = getString(g.card_menu_find_app_service);
            bVar.hvj = false;
        } else {
            bVar.title = getString(g.card_menu_attention_app_service);
            if (this.htQ.awm().roa == null || this.htQ.awm().roa.rDo != 1) {
                bVar.hvk = false;
            } else {
                bVar.hvk = true;
            }
        }
        if (!TextUtils.isEmpty(this.htQ.awm().rnV)) {
            bVar.huX = this.htQ.awm().rnV;
        }
        bVar.hyz = "";
        bVar.url = "card://jump_service";
        this.htV = bVar;
        return this.htV;
    }

    public final String getTitle() {
        StringBuilder stringBuilder = new StringBuilder();
        if (!TextUtils.isEmpty(this.htQ.awm().hwg)) {
            stringBuilder.append(this.htQ.awm().hwg);
        } else if (this.htQ.avT()) {
            stringBuilder.append(getString(g.card_membership));
        } else if (this.htQ.avU()) {
            stringBuilder.append(getString(g.card_coupon));
        } else if (this.htQ.avV()) {
            stringBuilder.append(getString(g.card_boarding_pass));
        } else if (this.htQ.avW()) {
            stringBuilder.append(getString(g.card_enterprise_cash));
        } else if (this.htQ.avX()) {
            stringBuilder.append(getString(g.card_invoice));
        }
        return stringBuilder.toString();
    }

    public final String getString(int i) {
        return this.gKS.getString(i);
    }
}
