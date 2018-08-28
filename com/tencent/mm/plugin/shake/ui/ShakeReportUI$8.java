package com.tencent.mm.plugin.shake.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;

class ShakeReportUI$8 implements OnClickListener {
    final /* synthetic */ ShakeReportUI nbh;

    ShakeReportUI$8(ShakeReportUI shakeReportUI) {
        this.nbh = shakeReportUI;
    }

    public final void onClick(View view) {
        Intent intent = new Intent(this.nbh, ShakeSayHiListUI.class);
        intent.putExtra("IntentSayHiType", 1);
        this.nbh.startActivity(intent);
    }
}
