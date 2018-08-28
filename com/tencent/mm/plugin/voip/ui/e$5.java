package com.tencent.mm.plugin.voip.ui;

import android.graphics.Point;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.voip.video.MovableTextureView;
import com.tencent.mm.sdk.platformtools.x;

class e$5 implements OnClickListener {
    final /* synthetic */ e oSe;

    e$5(e eVar) {
        this.oSe = eVar;
    }

    public final void onClick(View view) {
        x.i("MicroMsg.Voip.VoipVideoFragment", "steve: hwTxtureViewSmall clicked!");
        if (e.h(this.oSe)) {
            boolean z;
            e.c(this.oSe, !e.k(this.oSe));
            e eVar = this.oSe;
            if (e.k(this.oSe)) {
                z = false;
            } else {
                z = true;
            }
            Point d = e.d(eVar, z);
            MovableTextureView movableTextureView = (MovableTextureView) this.oSe.oRM;
            int i = d.x;
            int i2 = d.y;
            LayoutParams layoutParams = (LayoutParams) movableTextureView.getLayoutParams();
            ViewGroup.LayoutParams layoutParams2 = new LayoutParams(i, i2);
            layoutParams2.leftMargin = layoutParams.leftMargin;
            layoutParams2.topMargin = layoutParams.topMargin;
            movableTextureView.mWidth = i;
            movableTextureView.oTN = i2;
            movableTextureView.setLayoutParams(layoutParams2);
            this.oSe.oRM.setVisibility(4);
            this.oSe.oRL.setVisibility(0);
            e.l(this.oSe).setVisibility(0);
            x.i("MicroMsg.Voip.VoipVideoFragment", "steve: change to big hw texture view!");
            ViewGroup.LayoutParams layoutParams3 = new LayoutParams(-1, -2);
            layoutParams3.addRule(13);
            int indexOfChild = this.oSe.oQr.indexOfChild(e.m(this.oSe));
            this.oSe.oQr.removeView(this.oSe.oRM);
            this.oSe.oQr.addView(this.oSe.oRL, indexOfChild + 1, layoutParams3);
            ((c) this.oSe.oQd.get()).a(this.oSe.oRL);
            e.a(this.oSe, false);
            h.mEJ.h(11079, new Object[]{Integer.valueOf(3)});
        }
    }
}
