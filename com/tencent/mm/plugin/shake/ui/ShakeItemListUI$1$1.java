package com.tencent.mm.plugin.shake.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.model.au;
import com.tencent.mm.plugin.shake.b.m;
import com.tencent.mm.plugin.shake.d.a.i;
import com.tencent.mm.plugin.shake.ui.ShakeItemListUI.1;
import org.xwalk.core.XWalkResourceClient;

class ShakeItemListUI$1$1 implements OnClickListener {
    final /* synthetic */ 1 mZB;

    ShakeItemListUI$1$1(1 1) {
        this.mZB = 1;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        switch (ShakeItemListUI.a(this.mZB.mZA)) {
            case XWalkResourceClient.ERROR_BAD_URL /*-12*/:
            case 11:
                m.buC().vU(11);
                break;
            case XWalkResourceClient.ERROR_CONNECT /*-6*/:
            case 5:
                m.buC().vU(7);
                m.buC().vU(6);
                m.buC().vU(8);
                m.buC().vU(9);
                m.buC().vU(10);
                m.buC().vU(12);
                break;
            case XWalkResourceClient.ERROR_PROXY_AUTHENTICATION /*-5*/:
            case 4:
                au.Em().H(new i.1());
                m.buC().vU(4);
                break;
            case -1:
            case 0:
                m.buC().vU(0);
                break;
            case 100:
                m.buC().vU(0);
                m.buC().but();
                break;
        }
        ShakeItemListUI.b(this.mZB.mZA).WT();
        ShakeItemListUI.c(this.mZB.mZA).setVisibility(8);
        TextView textView = (TextView) this.mZB.mZA.findViewById(R.h.nearby_friend_not_found);
        textView.setText(ShakeItemListUI.wb(ShakeItemListUI.a(this.mZB.mZA)));
        textView.setVisibility(0);
        this.mZB.mZA.enableOptionMenu(false);
    }
}
