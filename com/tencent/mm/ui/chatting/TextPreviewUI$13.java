package com.tencent.mm.ui.chatting;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.model.bf;
import com.tencent.mm.plugin.webview.ui.tools.WebViewUI;

class TextPreviewUI$13 implements OnClickListener {
    final /* synthetic */ TextPreviewUI tNo;

    TextPreviewUI$13(TextPreviewUI textPreviewUI) {
        this.tNo = textPreviewUI;
    }

    public final void onClick(View view) {
        Intent intent = new Intent(this.tNo, WebViewUI.class);
        intent.putExtra("rawUrl", bf.n(TextPreviewUI.d(this.tNo)));
        intent.putExtra("showShare", false);
        intent.putExtra("show_bottom", false);
        intent.putExtra("needRedirect", false);
        this.tNo.startActivity(intent);
    }
}
