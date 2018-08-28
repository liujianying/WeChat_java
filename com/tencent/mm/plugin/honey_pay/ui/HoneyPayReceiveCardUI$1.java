package com.tencent.mm.plugin.honey_pay.ui;

import android.os.Bundle;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.ui.applet.m;
import com.tencent.mm.pluginsdk.ui.d.g;

class HoneyPayReceiveCardUI$1 implements g {
    final /* synthetic */ HoneyPayReceiveCardUI kmc;

    HoneyPayReceiveCardUI$1(HoneyPayReceiveCardUI honeyPayReceiveCardUI) {
        this.kmc = honeyPayReceiveCardUI;
    }

    public final Object a(m mVar) {
        return null;
    }

    public final Object b(m mVar) {
        if (mVar.type == 1) {
            Object obj = mVar.data;
            if (obj != null && (obj instanceof Bundle) && ((Bundle) obj).getBoolean("click_help", false)) {
                h.mEJ.h(15191, new Object[]{Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0)});
            }
        }
        return null;
    }
}
