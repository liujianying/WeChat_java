package com.tencent.mm.plugin.mall.ui;

import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.wallet_core.model.mall.MallFunction;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.aa.a;
import com.tencent.mm.ui.base.h;

class MallIndexBaseUI$2 implements b$d {
    final /* synthetic */ MallIndexBaseUI kZq;

    MallIndexBaseUI$2(MallIndexBaseUI mallIndexBaseUI) {
        this.kZq = mallIndexBaseUI;
    }

    public final void a(int i, MallFunction mallFunction) {
        if (mallFunction != null) {
            int i2;
            String str = mallFunction.moy;
            if (bi.oW(str)) {
                i2 = 1;
            } else {
                g.Ek();
                String str2 = (String) g.Ei().DT().get(a.sSe, null);
                if (bi.oW(str2)) {
                    i2 = 0;
                } else {
                    String[] split = str2.split(",");
                    if (split == null || split.length == 0) {
                        i2 = 0;
                    } else {
                        for (String equals : split) {
                            if (equals.equals(str)) {
                                i2 = 1;
                                break;
                            }
                        }
                        i2 = 0;
                    }
                }
            }
            if (i2 != 0 || bi.oW(mallFunction.prV)) {
                this.kZq.a(mallFunction, i);
            } else {
                x.i("MicroMsg.MallIndexBaseUI", "onFunctionItemClick show disclaimer funcId=%s", new Object[]{mallFunction.moy});
                h.a(this.kZq.mController.tml, mallFunction.prV, this.kZq.getString(i.mall_third_party_disclaimer_title), this.kZq.getString(i.remittance_i_known), new 1(this, mallFunction, i));
            }
            x.d("MicroMsg.MallIndexBaseUI", "type: %s", new Object[]{Integer.valueOf(mallFunction.type)});
            com.tencent.mm.plugin.report.service.h.mEJ.h(14419, new Object[]{this.kZq.fMk, Integer.valueOf(4), Integer.valueOf(mallFunction.type)});
            return;
        }
        x.w("MicroMsg.MallIndexBaseUI", "onFunctionItemClick functionItem null; pos=%d", new Object[]{Integer.valueOf(i)});
    }
}
