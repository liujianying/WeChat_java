package com.tencent.mm.plugin.card.ui.view;

import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import com.tencent.mm.plugin.card.base.b;
import com.tencent.mm.plugin.card.d.c;

class n$3 implements OnClickListener {
    final /* synthetic */ ViewGroup hHO;
    final /* synthetic */ n hHP;
    final /* synthetic */ b hHR;
    final /* synthetic */ View hHS;
    final /* synthetic */ View hHT;
    final /* synthetic */ ImageView hHU;
    final /* synthetic */ Button hHV;

    n$3(n nVar, View view, View view2, ImageView imageView, Button button, ViewGroup viewGroup, b bVar) {
        this.hHP = nVar;
        this.hHS = view;
        this.hHT = view2;
        this.hHU = imageView;
        this.hHV = button;
        this.hHO = viewGroup;
        this.hHR = bVar;
    }

    public final void onClick(View view) {
        this.hHS.setVisibility(8);
        this.hHT.setVisibility(8);
        this.hHU.setVisibility(0);
        this.hHV.setVisibility(8);
        this.hHP.hHC.d(c.hIy);
        this.hHP.d(this.hHO, this.hHR);
    }
}
