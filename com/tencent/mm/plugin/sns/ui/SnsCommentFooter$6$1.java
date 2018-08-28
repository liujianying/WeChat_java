package com.tencent.mm.plugin.sns.ui;

import com.tencent.mm.plugin.sns.i.j;
import com.tencent.mm.plugin.sns.ui.SnsCommentFooter.6;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.tools.a.c.a;

class SnsCommentFooter$6$1 implements a {
    final /* synthetic */ 6 nVQ;

    SnsCommentFooter$6$1(6 6) {
        this.nVQ = 6;
    }

    public final void pO(String str) {
        this.nVQ.nVP.NJ(SnsCommentFooter.a(this.nVQ.nVN).getText().toString());
        SnsCommentFooter.a(this.nVQ.nVN).setText("");
    }

    public final void YX() {
    }

    public final void YY() {
        h.i(SnsCommentFooter.l(this.nVQ.nVN), j.sns_upload_post_text_invalid_more, j.sns_upload_post_text_invalid_title);
    }
}
