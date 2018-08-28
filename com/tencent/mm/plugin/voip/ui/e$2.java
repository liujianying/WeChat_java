package com.tencent.mm.plugin.voip.ui;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Toast;

class e$2 implements OnClickListener {
    final /* synthetic */ e oSe;

    e$2(e eVar) {
        this.oSe = eVar;
    }

    public final void onClick(View view) {
        e.b(this.oSe, !e.i(this.oSe));
        if (!e.i(this.oSe)) {
            e.j(this.oSe).setVisibility(8);
        }
        Toast.makeText(this.oSe.getActivity(), String.format("mIsShowFaceRect:%b", new Object[]{Boolean.valueOf(e.i(this.oSe))}), 0).show();
    }
}
