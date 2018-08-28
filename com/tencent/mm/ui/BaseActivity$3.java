package com.tencent.mm.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.ui.BaseActivity.b;

class BaseActivity$3 implements OnClickListener {
    final /* synthetic */ BaseActivity tgA;
    final /* synthetic */ b tgB;

    BaseActivity$3(BaseActivity baseActivity, b bVar) {
        this.tgA = baseActivity;
        this.tgB = bVar;
    }

    public final void onClick(View view) {
        BaseActivity.a(BaseActivity.a(this.tgA), this.tgB);
    }
}
