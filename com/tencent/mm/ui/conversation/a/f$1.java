package com.tencent.mm.ui.conversation.a;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.R;
import com.tencent.mm.model.au;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.ui.contact.SelectContactUI;
import com.tencent.mm.ui.contact.s;

class f$1 implements OnClickListener {
    final /* synthetic */ f usf;

    f$1(f fVar) {
        this.usf = fVar;
    }

    public final void onClick(View view) {
        Intent intent = new Intent((Context) this.usf.qJS.get(), SelectContactUI.class);
        intent.putExtra("list_attr", s.fc(s.ukE, 256));
        intent.putExtra("list_type", 10);
        intent.putExtra("received_card_name", this.usf.usd);
        intent.putExtra("recommend_friends", true);
        intent.putExtra("titile", ((Context) this.usf.qJS.get()).getString(R.l.address_title_select_contact));
        ((Context) this.usf.qJS.get()).startActivity(intent);
        au.HU().Gt().iW(this.usf.usd);
        au.HU().Gt().iW(this.usf.use);
        h.mEJ.h(11003, new Object[]{this.usf.usd, Integer.valueOf(2), Integer.valueOf(0)});
    }
}
