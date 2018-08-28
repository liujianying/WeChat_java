package com.tencent.mm.ui.chatting;

import android.support.v4.app.Fragment;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMFragmentActivity;
import com.tencent.mm.ui.n;
import java.util.List;

public final class aa implements n {
    private MMFragmentActivity nfG;
    private e tpn;

    public aa(MMFragmentActivity mMFragmentActivity, e eVar) {
        this.tpn = eVar;
        this.nfG = mMFragmentActivity;
    }

    public final void aj(int i, boolean z) {
        boolean z2;
        this.tpn.tHA = true;
        List<Fragment> fragments = this.nfG.getSupportFragmentManager().getFragments();
        if (fragments == null) {
            x.i("MicroMsg.ChattingUIProxy", "fragments is null");
        } else if (fragments.size() >= 5) {
            x.e("MicroMsg.ChattingUIProxy", "fragments more than 5! %s", new Object[]{Integer.valueOf(fragments.size())});
            for (Fragment fragment : fragments) {
                if (fragment instanceof y) {
                    x.e("MicroMsg.ChattingUIProxy", "fragments more than 5 and find a ChattingUIFragment!!");
                    z2 = false;
                    break;
                }
            }
        } else {
            x.i("MicroMsg.ChattingUIProxy", "fragments size %s", new Object[]{Integer.valueOf(fragments.size())});
        }
        z2 = true;
        x.i("MicroMsg.ChattingUIProxy", "[onInit] isPreload：%s ok:%s", new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)});
        if (z2) {
            this.nfG.getSupportFragmentManager().bk().a(i, this.tpn).commitAllowingStateLoss();
            this.nfG.getSupportFragmentManager().executePendingTransactions();
        } else {
            this.nfG.getSupportFragmentManager().bk().b(i, this.tpn).commitAllowingStateLoss();
        }
        if (z) {
            cpO();
            cpP();
        }
        this.tpn.tHA = false;
    }

    public final void cpM() {
        x.i("MicroMsg.ChattingUIProxy", "[onEnterBegin]");
        this.tpn.onActivityCreated(null);
        this.tpn.cpM();
        this.tpn.onStart();
    }

    public final void cpN() {
        x.i("MicroMsg.ChattingUIProxy", "[onEnterEnd]");
        if (this.tpn.EH(256)) {
            this.tpn.onResume();
            this.tpn.cpN();
        }
    }

    public final void cpO() {
        x.i("MicroMsg.ChattingUIProxy", "[onExitBegin]");
        this.tpn.cpO();
    }

    public final void cpP() {
        x.i("MicroMsg.ChattingUIProxy", "[onExitEnd]");
        this.tpn.onPause();
        this.tpn.onStop();
        this.tpn.onDestroy();
        this.tpn.cpP();
    }
}
