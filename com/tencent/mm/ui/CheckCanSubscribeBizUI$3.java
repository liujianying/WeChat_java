package com.tencent.mm.ui;

import com.tencent.mm.sdk.platformtools.x;

class CheckCanSubscribeBizUI$3 implements Runnable {
    final /* synthetic */ String dMs;
    final /* synthetic */ CheckCanSubscribeBizUI thi;

    CheckCanSubscribeBizUI$3(CheckCanSubscribeBizUI checkCanSubscribeBizUI, String str) {
        this.thi = checkCanSubscribeBizUI;
        this.dMs = str;
    }

    public final void run() {
        x.d("MicroMsg.CheckCanSubscribeBizUI", "onNotifyChange toUserName = " + CheckCanSubscribeBizUI.d(this.thi) + ", userName = " + this.dMs);
        if (CheckCanSubscribeBizUI.d(this.thi).equals(this.dMs)) {
            CheckCanSubscribeBizUI.e(this.thi);
            if (!CheckCanSubscribeBizUI.f(this.thi)) {
                CheckCanSubscribeBizUI.b(this.thi);
            }
        }
    }
}
