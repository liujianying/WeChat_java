package com.tencent.mm.plugin.game.ui;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.mm.plugin.game.e.c;
import com.tencent.mm.plugin.game.model.an;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.LinkedList;

class GameSearchUI$6 implements OnItemClickListener {
    final /* synthetic */ GameSearchUI kcH;

    GameSearchUI$6(GameSearchUI gameSearchUI) {
        this.kcH = gameSearchUI;
    }

    public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        s$a rb = ((s) adapterView.getAdapter()).rb(i);
        if (!bi.oW(rb.text)) {
            if (bi.oW(rb.appId)) {
                LinkedList linkedList = new LinkedList();
                linkedList.add(rb.text);
                GameSearchUI.b(this.kcH, linkedList);
                GameSearchUI.h(this.kcH);
                return;
            }
            int b;
            switch (rb.actionType) {
                case 1:
                    Bundle bundle = new Bundle();
                    bundle.putCharSequence("game_app_id", rb.appId);
                    bundle.putInt("game_report_from_scene", 1402);
                    b = c.b(this.kcH, rb.appId, null, bundle);
                    an.a(this.kcH, 14, 1402, i, b, rb.appId, GameSearchUI.g(this.kcH), null);
                    return;
                case 2:
                    b = c.r(this.kcH.mController.tml, rb.kcm, "game_center_detail");
                    an.a(this.kcH, 14, 1402, i, b, rb.appId, GameSearchUI.g(this.kcH), null);
                    return;
                default:
                    x.e("MicroMsg.GameSearchUI", "unknowed actionType : " + rb.actionType);
                    return;
            }
        }
    }
}
