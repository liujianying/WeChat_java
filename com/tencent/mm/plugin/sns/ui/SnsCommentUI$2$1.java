package com.tencent.mm.plugin.sns.ui;

import com.tencent.mm.plugin.sns.data.i;
import com.tencent.mm.plugin.sns.f.h;
import com.tencent.mm.plugin.sns.i.j;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.plugin.sns.ui.SnsCommentUI.2;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.tools.a.c.a;

class SnsCommentUI$2$1 implements a {
    final /* synthetic */ 2 nVY;

    SnsCommentUI$2$1(2 2) {
        this.nVY = 2;
    }

    public final void pO(String str) {
        String trim = SnsCommentUI.b(this.nVY.nVX).getText().toString().trim();
        SnsCommentUI.b(this.nVY.nVX).setText("");
        if (trim.length() > 0) {
            switch (SnsCommentUI.a(this.nVY.nVX)) {
                case 0:
                    this.nVY.nVX.YC();
                    SnsCommentUI.a(this.nVY.nVX, trim);
                    return;
                case 1:
                    this.nVY.nVX.YC();
                    SnsCommentUI.b(this.nVY.nVX, trim);
                    return;
                case 2:
                    this.nVY.nVX.YC();
                    long longExtra = this.nVY.nVX.getIntent().getLongExtra("sns_id", 0);
                    long longExtra2 = this.nVY.nVX.getIntent().getLongExtra("action_st_time", 0);
                    String aG = bi.aG(this.nVY.nVX.getIntent().getStringExtra("sns_uxinfo"), "");
                    trim = bi.aG(this.nVY.nVX.getIntent().getStringExtra("sns_actionresult"), "") + "|4:1:" + trim;
                    long currentTimeMillis = System.currentTimeMillis();
                    h bzh = af.byg().bzh();
                    if (bzh != null && bzh.bzi()) {
                        String str2 = bzh.ntY;
                        String str3 = bzh.ntX;
                        x.d("MicroMsg.SnsCommentUI", "report abtestnotlike " + longExtra + " uxinfo:" + aG + " actionresult: " + trim + " " + longExtra2 + " " + currentTimeMillis);
                        com.tencent.mm.plugin.report.service.h.mEJ.h(11988, new Object[]{str2, str3, "", "", i.eF(longExtra), aG, trim, Long.valueOf(longExtra2 / 1000), Long.valueOf(currentTimeMillis / 1000)});
                        SnsCommentUI.c(this.nVY.nVX);
                        this.nVY.nVX.finish();
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    public final void YX() {
    }

    public final void YY() {
        com.tencent.mm.ui.base.h.i(this.nVY.nVX, j.sns_upload_post_text_invalid_more, j.sns_upload_post_text_invalid_title);
    }
}
