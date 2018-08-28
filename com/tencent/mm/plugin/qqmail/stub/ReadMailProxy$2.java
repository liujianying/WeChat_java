package com.tencent.mm.plugin.qqmail.stub;

import com.tencent.mm.pluginsdk.ui.tools.i$a;

class ReadMailProxy$2 implements i$a {
    final /* synthetic */ ReadMailProxy mej;

    ReadMailProxy$2(ReadMailProxy readMailProxy) {
        this.mej = readMailProxy;
    }

    public final void uX(int i) {
        this.mej.CLIENT_CALL("onGetQQMailUnreadSuccess", new Object[]{Integer.valueOf(i)});
    }

    public final void boB() {
        this.mej.CLIENT_CALL("onGetQQMailUnreadFailed", new Object[0]);
    }
}
