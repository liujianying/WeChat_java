package com.tencent.mm.plugin.mall.ui;

import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.wallet_core.model.w;
import com.tencent.mm.plugin.wallet_core.model.w.a;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.n.c;

class MallIndexUI$13 implements c {
    final /* synthetic */ MallIndexUI lab;
    final /* synthetic */ w lac;

    MallIndexUI$13(MallIndexUI mallIndexUI, w wVar) {
        this.lab = mallIndexUI;
        this.lac = wVar;
    }

    public final void a(l lVar) {
        lVar.add(0, 0, 0, this.lab.getString(i.mall_index_ui_my_msg));
        lVar.add(0, 1, 1, this.lab.getString(i.wallet_index_ui_opt_modify_password));
        lVar.add(0, 2, 2, this.lab.getString(i.wallet_index_ui_opt_wallet_secure));
        lVar.add(0, 3, 3, this.lab.getString(i.wallet_index_ui_opt_common_questions));
        if (MallIndexUI.h(this.lab).cec) {
            lVar.add(0, 4, 4, this.lab.getString(i.wallet_index_ui_opt_wallet_switch));
        }
        int size = this.lac.list.size();
        if (size > 0) {
            for (int i = 0; i < size; i++) {
                lVar.add(0, i + 100, i + 100, ((a) this.lac.list.get(i)).pra);
                h.mEJ.h(14409, new Object[]{Integer.valueOf(1), Integer.valueOf(r0.pqX), r0.pqY, r0.prb, r0.pqZ});
            }
        }
    }
}
