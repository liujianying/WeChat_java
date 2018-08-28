package com.tencent.mm.plugin.voip.ui;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Toast;
import com.tencent.mm.sdk.platformtools.bi;

class e$3 implements OnClickListener {
    final /* synthetic */ e oSe;

    e$3(e eVar) {
        this.oSe = eVar;
    }

    public final void onClick(View view) {
        boolean a = bi.a((Boolean) view.getTag(), false);
        view.setTag(Boolean.valueOf(!a));
        if (a) {
            e.j(this.oSe).setVisibility(8);
            Toast.makeText(this.oSe.getActivity(), "stop face detect", 0).show();
        } else {
            Toast.makeText(this.oSe.getActivity(), "start face detect", 0).show();
        }
        if (this.oSe.oQd != null && this.oSe.oQd.get() != null) {
            ((c) this.oSe.oQd.get()).bKI();
        }
    }
}
