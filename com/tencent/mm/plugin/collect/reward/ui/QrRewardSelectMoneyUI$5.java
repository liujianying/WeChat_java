package com.tencent.mm.plugin.collect.reward.ui;

import com.tencent.mm.ab.l;
import com.tencent.mm.plugin.collect.reward.a.a.a;
import com.tencent.mm.plugin.collect.reward.a.f;
import com.tencent.mm.sdk.platformtools.x;
import java.util.LinkedList;

class QrRewardSelectMoneyUI$5 implements a {
    final /* synthetic */ QrRewardSelectMoneyUI hWw;
    final /* synthetic */ f hWx;

    QrRewardSelectMoneyUI$5(QrRewardSelectMoneyUI qrRewardSelectMoneyUI, f fVar) {
        this.hWw = qrRewardSelectMoneyUI;
        this.hWx = fVar;
    }

    public final void i(l lVar) {
        x.d("MicroMsg.QrRewardSelectMoneyUI", "callback succ");
        QrRewardSelectMoneyUI.a(this.hWw, this.hWx.hVc.rqs);
        QrRewardSelectMoneyUI.b(this.hWw, this.hWx.hVc.mxM);
        QrRewardSelectMoneyUI.a(this.hWw, this.hWx.hVc.rqe);
        QrRewardSelectMoneyUI.c(this.hWw, this.hWx.hVc.rqp);
        QrRewardSelectMoneyUI.d(this.hWw, this.hWx.hVc.desc);
        QrRewardSelectMoneyUI.e(this.hWw, this.hWx.hVc.rqx);
        QrRewardSelectMoneyUI.f(this.hWw, this.hWx.hVc.rqy);
        QrRewardSelectMoneyUI.g(this.hWw, this.hWx.hVc.rqv);
        QrRewardSelectMoneyUI.h(this.hWw, this.hWx.hVc.rqB);
        QrRewardSelectMoneyUI.a(this.hWw, this.hWx.hVc.rqc);
        if (QrRewardSelectMoneyUI.a(this.hWw) == null) {
            x.i("MicroMsg.QrRewardSelectMoneyUI", "amt_list is null");
            QrRewardSelectMoneyUI.a(this.hWw, new LinkedList());
        }
        QrRewardSelectMoneyUI.b(this.hWw);
    }
}
