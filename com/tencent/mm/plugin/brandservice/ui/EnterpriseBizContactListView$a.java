package com.tencent.mm.plugin.brandservice.ui;

import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.ac.d;
import com.tencent.mm.ac.f;
import com.tencent.mm.ac.o;
import com.tencent.mm.ac.z;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.foundation.a.a.h.a;
import com.tencent.mm.plugin.messenger.foundation.a.i;
import com.tencent.mm.plugin.profile.a.c;
import com.tencent.mm.protocal.c.atx;
import com.tencent.mm.protocal.c.brs;
import com.tencent.mm.protocal.c.brt;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.p;
import java.lang.ref.WeakReference;

class EnterpriseBizContactListView$a implements e {
    public String hpu;
    com.tencent.mm.ui.widget.e hpv;
    WeakReference<EnterpriseBizContactListView> hpw;
    p tipDialog;

    public EnterpriseBizContactListView$a(EnterpriseBizContactListView enterpriseBizContactListView) {
        this.hpw = new WeakReference(enterpriseBizContactListView);
    }

    protected final void finalize() {
        g.DF().b(1394, this);
        super.finalize();
    }

    public final void a(int i, int i2, String str, l lVar) {
        if (this.tipDialog != null && this.tipDialog.isShowing()) {
            this.tipDialog.dismiss();
        }
        if (i == 0 && i2 == 0 && lVar.getType() == 1394) {
            brs bnl = ((c) lVar).bnl();
            brt bnk = ((c) lVar).bnk();
            if (bnk == null || bnk.riQ == null || bnk.riQ.ret != 0) {
                if (bnk == null || bnk.riQ == null) {
                    x.w("MicroMsg.BrandService.EnterpriseBizContactListView", "chuangchen onSceneEnd type:%s, err:resp == null", new Object[]{Integer.valueOf(lVar.getType())});
                    return;
                }
                x.w("MicroMsg.BrandService.EnterpriseBizContactListView", "chuangchen onSceneEnd type:%s, err:code:%s", new Object[]{Integer.valueOf(lVar.getType()), Integer.valueOf(bnk.riQ.ret)});
            } else if (bnl.spC) {
                d kH = f.kH(bnl.riK);
                kH.field_brandFlag |= 1;
                atx atx = new atx();
                atx.eJV = kH.field_brandFlag;
                atx.hbL = bnl.riK;
                ((i) g.l(i.class)).FQ().b(new a(47, atx));
                z.MY().c(kH, new String[0]);
                ((i) g.l(i.class)).FW().Yp(kH.field_username);
                if (((i) g.l(i.class)).FW().YC(kH.field_enterpriseFather) <= 0) {
                    ((i) g.l(i.class)).FW().Yp(kH.field_enterpriseFather);
                } else {
                    ((o) g.l(o.class)).FV().XJ(kH.field_enterpriseFather);
                }
                EnterpriseBizContactListView enterpriseBizContactListView = (EnterpriseBizContactListView) this.hpw.get();
                if (enterpriseBizContactListView != null) {
                    enterpriseBizContactListView.refresh();
                }
            }
        }
    }
}
