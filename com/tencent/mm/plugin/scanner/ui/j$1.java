package com.tencent.mm.plugin.scanner.ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.R;
import com.tencent.mm.ui.base.h;

class j$1 implements OnClickListener {
    final /* synthetic */ j mKz;

    j$1(j jVar) {
        this.mKz = jVar;
    }

    public final void onClick(View view) {
        View inflate = ((LayoutInflater) this.mKz.mKp.getContext().getSystemService("layout_inflater")).inflate(R.i.scan_bank_card_declare, null);
        Context context = this.mKz.mKp.getContext();
        h.a(context, context.getString(R.l.scan_bank_card_declare_title), context.getString(R.l.scan_bank_card_declare_ok), inflate, new 1(this)).show();
    }
}
