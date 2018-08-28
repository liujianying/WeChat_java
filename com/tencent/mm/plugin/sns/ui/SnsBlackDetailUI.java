package com.tencent.mm.plugin.sns.ui;

import android.os.Bundle;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.q;
import com.tencent.mm.model.s;
import com.tencent.mm.plugin.messenger.foundation.a.i;
import com.tencent.mm.plugin.sns.c.a;
import com.tencent.mm.plugin.sns.i.j;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.sdk.e.m.b;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.ay;
import com.tencent.mm.ui.base.h;
import java.util.LinkedList;
import java.util.List;

public class SnsBlackDetailUI extends SnsTagDetailUI implements e, b {
    public final void bCV() {
        x.d("MicroMsg.SnsBlackDetailUI", "SnsBlackDetailUI __onCreate");
        g.Ek();
        ((i) g.l(i.class)).FR().a(this);
    }

    protected final void bCW() {
        x.d("MicroMsg.SnsBlackDetailUI", "SnsBlackDetailUI __onDestroy");
        g.Ek();
        if (g.Eg().Dx()) {
            g.Ek();
            ((i) g.l(i.class)).FR().b(this);
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        x.d("MicroMsg.SnsBlackDetailUI", "SnsBlackDetailUI onCreate");
    }

    public void onDestroy() {
        if (this.tipDialog != null) {
            this.tipDialog.dismiss();
        }
        g.Ek();
        g.Eh().dpP.b(com.tencent.mm.plugin.appbrand.jsapi.audio.e.CTRL_INDEX, this);
        g.Ek();
        g.Eh().dpP.b(291, this);
        g.Ek();
        g.Eh().dpP.b(292, this);
        g.Ek();
        g.Eh().dpP.b(293, this);
        g.Ek();
        if (g.Eg().Dx()) {
            g.Ek();
            ((i) g.l(i.class)).FR().b(this);
        }
        super.onDestroy();
    }

    protected final void bCX() {
    }

    protected final void aZV() {
        if ((this.obG + " " + bi.c(this.jzp, ",")).equals(this.bKg) && this.noJ != 0) {
            finish();
        } else if (af.byu().q(this.noJ, this.obG)) {
            h.b(this, getString(j.sns_tag_exist, new Object[]{this.obG}), getString(j.app_tip), true);
        } else {
            List<String> bCY = bCY();
            List<String> linkedList = new LinkedList();
            List<String> linkedList2 = new LinkedList();
            for (String str : bCY) {
                if (!this.jzp.contains(str)) {
                    linkedList.add(str);
                }
            }
            for (String str2 : this.jzp) {
                if (!bCY.contains(str2)) {
                    linkedList2.add(str2);
                }
            }
            for (String str22 : linkedList) {
                s.s(str22, false);
            }
            for (String str222 : linkedList2) {
                s.s(str222, true);
            }
            a.ezo.vl();
            finish();
        }
    }

    protected final List<String> bCY() {
        List<String> linkedList = new LinkedList();
        if (this.noJ != 4) {
            return linkedList;
        }
        LinkedList linkedList2 = new LinkedList();
        return s.Hv();
    }

    protected final void yp(String str) {
        super.yp(str);
    }

    protected final void cr(List<String> list) {
        ay byc = af.byc();
        String GF = q.GF();
        for (String str : list) {
            if (!(this.jzp.contains(str) || !com.tencent.mm.l.a.gd(byc.Yg(str).field_type) || GF.equals(str))) {
                this.jzp.add(str);
            }
        }
        if (this.hLp != null) {
            this.hLp.bt(this.jzp);
        }
        updateTitle();
    }

    public final void a(int i, int i2, String str, l lVar) {
        x.i("MicroMsg.SnsBlackDetailUI", "onSceneEnd: errType = " + i + " errCode = " + i2 + " errMsg = " + str);
        if (this.tipDialog != null) {
            this.tipDialog.dismiss();
        }
    }
}
