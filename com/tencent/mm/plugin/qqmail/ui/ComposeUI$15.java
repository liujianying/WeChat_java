package com.tencent.mm.plugin.qqmail.ui;

import com.tencent.mm.R;
import com.tencent.mm.plugin.qqmail.b.p.a;
import com.tencent.mm.ui.base.h;
import java.util.Map;

class ComposeUI$15 extends a {
    final /* synthetic */ ComposeUI mfs;

    ComposeUI$15(ComposeUI composeUI) {
        this.mfs = composeUI;
    }

    public final void onSuccess(String str, Map<String, String> map) {
        h.a(this.mfs, R.l.plugin_qqmail_compose_send_success, R.l.app_tip, new 1(this));
        ComposeUI.d(this.mfs).bL(this.mfs.mey.getMailAddrs());
        ComposeUI.d(this.mfs).bL(ComposeUI.e(this.mfs).getMailAddrs());
        ComposeUI.d(this.mfs).bL(ComposeUI.f(this.mfs).getMailAddrs());
    }

    public final void onError(int i, String str) {
        if (i == -5) {
            this.mfs.meR.a(new 2(this));
        } else {
            h.a(this.mfs, str, this.mfs.getString(R.l.plugin_qqmail_compose_send_error), null);
        }
    }

    public final void onComplete() {
        if (ComposeUI.G(this.mfs) != null) {
            ComposeUI.G(this.mfs).dismiss();
            ComposeUI.a(this.mfs, null);
        }
    }
}
