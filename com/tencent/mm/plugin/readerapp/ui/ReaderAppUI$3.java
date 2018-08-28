package com.tencent.mm.plugin.readerapp.ui;

import com.tencent.mm.pluginsdk.ui.tools.j;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.MMPullDownView.g;

class ReaderAppUI$3 implements g {
    final /* synthetic */ ReaderAppUI mnQ;

    ReaderAppUI$3(ReaderAppUI readerAppUI) {
        this.mnQ = readerAppUI;
    }

    public final boolean aCj() {
        if (ReaderAppUI.b(this.mnQ).ayQ()) {
            ReaderAppUI.e(this.mnQ).setSelectionFromTop(0, ReaderAppUI.d(this.mnQ).getTopHeight());
        } else {
            int count = ReaderAppUI.b(this.mnQ).getCount();
            int ayR = ReaderAppUI.b(this.mnQ).ayR();
            x.v("MicroMsg.ReaderAppUI", "onLoadData add count:" + ayR);
            ReaderAppUI.b(this.mnQ).a(null, null);
            x.d("MicroMsg.ReaderAppUI", "onTopLoadData nowCount:%d, preCount:%d", new Object[]{Integer.valueOf(ReaderAppUI.b(this.mnQ).getCount()), Integer.valueOf(count)});
            if (ReaderAppUI.b(this.mnQ).getCount() > count) {
                x.i("MicroMsg.ReaderAppUI", "pullDownView nowCount > preCount on set position %d, set pullDownView.getTopHeight() %d", new Object[]{Integer.valueOf(ayR + 1), Integer.valueOf(ReaderAppUI.d(this.mnQ).getTopHeight())});
                j.a(ReaderAppUI.e(this.mnQ), ayR + 1, ReaderAppUI.d(this.mnQ).getTopHeight(), false);
            }
        }
        return true;
    }
}
