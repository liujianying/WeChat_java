package com.tencent.mm.plugin.exdevice.ui;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

class ExdeviceRankChampionInfoView$2 implements OnClickListener {
    final /* synthetic */ ExdeviceRankChampionInfoView iFc;
    final /* synthetic */ Context val$context;

    ExdeviceRankChampionInfoView$2(ExdeviceRankChampionInfoView exdeviceRankChampionInfoView, Context context) {
        this.iFc = exdeviceRankChampionInfoView;
        this.val$context = context;
    }

    public final void onClick(View view) {
        if (bi.oW(ExdeviceRankChampionInfoView.a(this.iFc))) {
            x.w("MicroMsg.ExdeviceRankChampionInfoView", "username is null.");
            return;
        }
        Intent intent = new Intent(this.val$context, ExdeviceProfileUI.class);
        intent.putExtra("username", ExdeviceRankChampionInfoView.a(this.iFc));
        this.val$context.startActivity(intent);
    }
}
