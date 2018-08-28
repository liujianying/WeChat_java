package com.tencent.mm.plugin.sns.ui.b;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.sns.c.a;
import com.tencent.mm.plugin.sns.storage.v;

class b$16 implements OnClickListener {
    final /* synthetic */ b olf;

    b$16(b bVar) {
        this.olf = bVar;
    }

    public final void onClick(View view) {
        try {
            int NF = v.NF((String) view.getTag());
            Intent intent = new Intent();
            intent.putExtra("sns_label_sns_info", NF);
            a.ezn.v(intent, this.olf.activity);
        } catch (Exception e) {
        }
    }
}
