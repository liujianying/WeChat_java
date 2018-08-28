package com.tencent.mm.plugin.ipcall.ui;

import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.mm.bg.d;
import com.tencent.mm.plugin.ipcall.a.g.g;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.bi;

class IPCallMsgUI$4 implements OnItemClickListener {
    final /* synthetic */ IPCallMsgUI kwA;

    IPCallMsgUI$4(IPCallMsgUI iPCallMsgUI) {
        this.kwA = iPCallMsgUI;
    }

    public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        g gVar = (g) IPCallMsgUI.b(this.kwA).getItem(i);
        if (!bi.oW(gVar.field_descUrl)) {
            int i2 = gVar.field_msgType;
            h.mEJ.h(13780, new Object[]{Integer.valueOf(i2)});
            Intent intent = new Intent();
            intent.putExtra("rawUrl", gVar.field_descUrl);
            intent.putExtra("showShare", false);
            d.b(this.kwA, "webview", ".ui.tools.WebViewUI", intent);
        }
    }
}
