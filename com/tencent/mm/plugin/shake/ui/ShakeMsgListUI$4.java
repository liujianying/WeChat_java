package com.tencent.mm.plugin.shake.ui;

import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.mm.bg.d;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.shake.b.f;
import com.tencent.mm.sdk.platformtools.bi;

class ShakeMsgListUI$4 implements OnItemClickListener {
    final /* synthetic */ ShakeMsgListUI mZP;

    ShakeMsgListUI$4(ShakeMsgListUI shakeMsgListUI) {
        this.mZP = shakeMsgListUI;
    }

    public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        f fVar = (f) ShakeMsgListUI.b(this.mZP).getItem(i);
        if (!bi.oW(fVar.field_tag)) {
            h.mEJ.k(11316, ShakeMsgListUI.g(this.mZP) + "," + fVar.field_tag);
            Intent intent = new Intent();
            intent.putExtra("rawUrl", fVar.field_tag);
            d.b(this.mZP.mController.tml, "webview", ".ui.tools.WebViewUI", intent);
        }
    }
}
