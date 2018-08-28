package com.tencent.mm.plugin.mall.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.mall.ui.MallIndexBaseUI.2;
import com.tencent.mm.plugin.wallet_core.model.mall.MallFunction;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.storage.aa.a;

class MallIndexBaseUI$2$1 implements OnClickListener {
    final /* synthetic */ MallFunction kZr;
    final /* synthetic */ int kZs;
    final /* synthetic */ 2 kZt;

    MallIndexBaseUI$2$1(2 2, MallFunction mallFunction, int i) {
        this.kZt = 2;
        this.kZr = mallFunction;
        this.kZs = i;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        Object obj = null;
        String str = this.kZr.moy;
        if (!bi.oW(str)) {
            g.Ek();
            Object obj2 = (String) g.Ei().DT().get(a.sSe, null);
            if (bi.oW(obj2)) {
                obj2 = str;
            } else {
                String[] split = obj2.split(",");
                if (split == null || split.length == 0) {
                    String obj22 = str;
                } else {
                    for (String equals : split) {
                        if (equals.equals(str)) {
                            obj = 1;
                            break;
                        }
                    }
                    if (obj == null) {
                        obj22 = obj22 + "," + str;
                    }
                }
            }
            g.Ek();
            g.Ei().DT().a(a.sSe, obj22);
        }
        this.kZt.kZq.a(this.kZr, this.kZs);
    }
}
