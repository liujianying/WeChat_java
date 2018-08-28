package com.tencent.mm.plugin.shake.ui;

import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.shake.d.a.k;
import com.tencent.mm.plugin.shake.d.a.n;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

class ShakeTvHistoryListUI$3 implements OnItemClickListener {
    final /* synthetic */ ShakeTvHistoryListUI nbu;

    ShakeTvHistoryListUI$3(ShakeTvHistoryListUI shakeTvHistoryListUI) {
        this.nbu = shakeTvHistoryListUI;
    }

    public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        n nVar = (n) ShakeTvHistoryListUI.a(this.nbu).getItem(i);
        ActionBarActivity actionBarActivity = this.nbu.mController.tml;
        if (nVar == null) {
            return;
        }
        if (bi.oW(nVar.field_username) && bi.oW(nVar.field_deeplink)) {
            h.mEJ.h(12108, new Object[]{bi.oV(nVar.field_username), Integer.valueOf(2), Integer.valueOf(0)});
            return;
        }
        k.a(nVar.field_username, nVar.field_deeplink, 2, actionBarActivity);
        x.i("Micromsg.ShakeTVLogic", "doShakeTvHistoryItemClick start do nth");
    }
}
