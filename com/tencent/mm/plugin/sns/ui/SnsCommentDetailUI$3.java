package com.tencent.mm.plugin.sns.ui;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import com.tencent.mm.plugin.sns.model.ae;
import com.tencent.mm.plugin.sns.ui.b.b;

class SnsCommentDetailUI$3 extends b {
    final /* synthetic */ SnsCommentDetailUI nUO;

    SnsCommentDetailUI$3(SnsCommentDetailUI snsCommentDetailUI, Activity activity, ae aeVar) {
        this.nUO = snsCommentDetailUI;
        super(1, activity, aeVar);
    }

    public final void b(View view, int i, int i2, int i3) {
    }

    public final void bS(Object obj) {
        SnsCommentDetailUI.f(this.nUO);
        SnsCommentDetailUI.p(this.nUO).a((View) obj, 2, null);
    }

    public final void bBS() {
    }

    public final void cH(View view) {
    }

    public final void cG(View view) {
    }

    public final void cE(View view) {
    }

    public final void cF(View view) {
    }

    public final void cI(View view) {
        SnsCommentDetailUI.q(this.nUO).cD(view);
    }

    public final void bBT() {
        SnsCommentDetailUI.q(this.nUO).bBH();
    }

    public final void cJ(View view) {
        SnsCommentDetailUI.q(this.nUO).bzf();
        Intent intent = new Intent();
        intent.putExtra("result_finish", true);
        this.nUO.setResult(-1, intent);
        this.nUO.finish();
    }
}
