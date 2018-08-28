package com.tencent.mm.plugin.clean.ui.fileindexui;

import android.content.DialogInterface;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.samsung.android.sdk.look.smartclip.SlookSmartClipMetaTag;
import com.tencent.mm.R;
import com.tencent.mm.plugin.downloader.model.d;
import com.tencent.mm.plugin.downloader.model.e$a;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.net.URL;

class CleanNewUI$4 implements OnClickListener {
    final /* synthetic */ CleanNewUI hTh;

    CleanNewUI$4(CleanNewUI cleanNewUI) {
        this.hTh = cleanNewUI;
    }

    public final void onClick(View view) {
        x.i("MicroMsg.CleanNewUI", "qq mgr btn click");
        h.mEJ.a(714, 3, 1, false);
        if (!CleanNewUI.b(this.hTh)) {
            if (CleanNewUI.c(this.hTh)) {
                com.tencent.mm.ui.base.h.a(this.hTh, this.hTh.getString(R.l.clean_download_qqmgr_tips, new Object[]{bi.gc(CleanNewUI.d(this.hTh))}), "", this.hTh.getString(R.l.app_download), this.hTh.getString(R.l.app_cancel), new DialogInterface.OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        try {
                            x.i("MicroMsg.CleanNewUI", "download url:%s, md5:%s", new Object[]{new URL(CleanNewUI.e(CleanNewUI$4.this.hTh).getString(SlookSmartClipMetaTag.TAG_TYPE_URL)), CleanNewUI.e(CleanNewUI$4.this.hTh).getString("md5")});
                            e$a e_a = new e$a();
                            e_a.yS("wesecure.apk");
                            e_a.yQ(r0.toString());
                            e_a.ef(true);
                            e_a.yT(r1);
                            e_a.ox(1);
                            d.aCU().a(e_a.ick);
                        } catch (Throwable e) {
                            x.printErrStackTrace("MicroMsg.CleanNewUI", e, "", new Object[0]);
                        }
                        h.mEJ.a(714, 4, 1, false);
                    }
                }, null);
                return;
            }
            Intent intent = new Intent();
            intent.putExtra("rawUrl", "http://weixin.qq.com/cgi-bin/readtemplate?t=w_safe&qqpimenter=shoushen");
            intent.putExtra("show_bottom", false);
            intent.putExtra("showShare", false);
            com.tencent.mm.bg.d.b(this.hTh.mController.tml, "webview", ".ui.tools.WebViewUI", intent);
            h.mEJ.a(714, 5, 1, false);
        }
    }
}
