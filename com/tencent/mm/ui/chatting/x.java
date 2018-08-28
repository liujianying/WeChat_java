package com.tencent.mm.ui.chatting;

import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.R;

public final class x {
    private LinearLayout irL;
    private OnClickListener mtE = new 1(this);
    private ChatFooterCustom tLV;
    private FrameLayout tLW;

    public x(ChatFooterCustom chatFooterCustom) {
        this.tLV = chatFooterCustom;
    }

    public final void crB() {
        com.tencent.mm.sdk.platformtools.x.i("MicroMsg.Sport.ChattingSportFooterHandler", "initFooter");
        this.tLV.findViewById(R.h.chatting_footer_switch2input).setVisibility(8);
        this.tLV.findViewById(R.h.chatting_footer_menu_arrow).setVisibility(8);
        this.irL = (LinearLayout) this.tLV.findViewById(R.h.chatting_footer_menu_container);
        this.irL.setWeightSum(1.0f);
        this.tLW = (FrameLayout) this.irL.getChildAt(0);
        this.tLW.setVisibility(0);
        this.tLW.setOnClickListener(this.mtE);
        ((TextView) this.tLW.getChildAt(0).findViewById(R.h.chatting_footer_menu_text)).setText(R.l.exdevice_sport_rank_title);
        this.tLW.getChildAt(0).findViewById(R.h.chatting_footer_menu_icon).setVisibility(8);
        this.tLW.getChildAt(1).setVisibility(8);
        for (int i = 1; i < 6; i++) {
            this.irL.getChildAt(i).setVisibility(8);
        }
    }
}
