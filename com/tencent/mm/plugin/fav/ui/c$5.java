package com.tencent.mm.plugin.fav.ui;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.support.v4.app.Fragment;
import com.tencent.mm.plugin.fav.ui.m.i;
import com.tencent.mm.ui.widget.snackbar.a.b;
import com.tencent.mm.ui.widget.snackbar.a.c;

class c$5 implements OnClickListener {
    final /* synthetic */ OnClickListener iYJ;
    final /* synthetic */ b iYK;
    final /* synthetic */ c iYL;
    final /* synthetic */ Activity mr;
    final /* synthetic */ Fragment ok;

    c$5(OnClickListener onClickListener, Fragment fragment, b bVar, c cVar, Activity activity) {
        this.iYJ = onClickListener;
        this.ok = fragment;
        this.iYK = bVar;
        this.iYL = cVar;
        this.mr = activity;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        dialogInterface.dismiss();
        if (this.iYJ != null) {
            this.iYJ.onClick(dialogInterface, -2);
        }
        if (this.ok != null) {
            com.tencent.mm.ui.widget.snackbar.b.a(this.ok, this.ok.getActivity().getString(i.favorite_ok), this.ok.getActivity().getString(i.favorite_add_tag_tips), this.iYK, this.iYL);
        } else {
            com.tencent.mm.ui.widget.snackbar.b.a(this.mr, this.mr.getString(i.favorite_ok), this.mr.getString(i.favorite_add_tag_tips), this.iYK, this.iYL);
        }
    }
}
