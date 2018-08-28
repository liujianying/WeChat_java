package com.tencent.mm.plugin.qqmail.ui;

import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.samsung.android.sdk.look.smartclip.SlookSmartClipMetaTag;
import com.tencent.mm.R;
import com.tencent.mm.plugin.qqmail.b.p;
import com.tencent.mm.plugin.qqmail.ui.CompressPreviewUI.a;
import com.tencent.mm.plugin.qqmail.ui.CompressPreviewUI.b;
import com.tencent.mm.pluginsdk.ui.tools.FileExplorerUI;

class CompressPreviewUI$1 implements OnItemClickListener {
    final /* synthetic */ CompressPreviewUI mfN;

    CompressPreviewUI$1(CompressPreviewUI compressPreviewUI) {
        this.mfN = compressPreviewUI;
    }

    public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        a uY = CompressPreviewUI.a(this.mfN).uY(i);
        String str = uY.id;
        b a = CompressPreviewUI.a(this.mfN);
        if (str.equals(a.mfR == null ? null : a.mfR.id)) {
            CompressPreviewUI.a(this.mfN, CompressPreviewUI.a(this.mfN).boQ());
        } else if (uY.boP()) {
            CompressPreviewUI.a(this.mfN, uY.id);
        } else if (uY.YF) {
            String[] strArr = new String[]{"mailid=" + CompressPreviewUI.b(this.mfN), "attachid=" + uY.id, "compressfilepath=" + CompressPreviewUI.c(this.mfN), "texttype=html"};
            Intent intent = new Intent(this.mfN, MailWebViewUI.class);
            intent.putExtra("uri", "/cgi-bin/viewdocument");
            intent.putExtra("params", strArr);
            intent.putExtra("baseurl", p.bor());
            intent.putExtra("method", "get");
            intent.putExtra("singleColumn", FileExplorerUI.TZ(uY.name));
            intent.putExtra(SlookSmartClipMetaTag.TAG_TYPE_TITLE, this.mfN.getString(R.l.readmail_attachment_preview));
            this.mfN.startActivity(intent);
        }
    }
}
