package com.tencent.mm.plugin.record.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.bg.d;

class RecordMsgFileUI$8 implements OnClickListener {
    final /* synthetic */ String jcB;
    final /* synthetic */ RecordMsgFileUI mtg;

    RecordMsgFileUI$8(RecordMsgFileUI recordMsgFileUI, String str) {
        this.mtg = recordMsgFileUI;
        this.jcB = str;
    }

    public final void onClick(View view) {
        Intent intent = new Intent();
        intent.putExtra("rawUrl", this.jcB);
        d.b(this.mtg.mController.tml, "webview", ".ui.tools.WebViewUI", intent);
    }
}
