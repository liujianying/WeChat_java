package com.tencent.mm.ui.contact;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;

class v$1 implements OnClickListener {
    final /* synthetic */ v uli;

    v$1(v vVar) {
        this.uli = vVar;
    }

    public final void onClick(View view) {
        Context context = view.getContext();
        Intent intent = new Intent(context, OpenIMAddressUI.class);
        intent.addFlags(67108864);
        intent.putExtra("key_openim_acctype_id", v.a(this.uli));
        context.startActivity(intent);
    }
}
