package com.tencent.mm.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.ui.BaseActivity.b;

class BaseActivity$4 implements OnClickListener {
    final /* synthetic */ BaseActivity tgA;
    final /* synthetic */ b tgB;

    BaseActivity$4(BaseActivity baseActivity, b bVar) {
        this.tgA = baseActivity;
        this.tgB = bVar;
    }

    public final void onClick(View view) {
        BaseActivity.a(BaseActivity.b(this.tgA), this.tgB);
    }
}
