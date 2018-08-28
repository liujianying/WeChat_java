package com.tencent.mm.ui;

import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.R;

class MultiTalkRoomPopupNav$a {
    private Button iRz;
    TextView titleView;
    final /* synthetic */ MultiTalkRoomPopupNav toY;
    LinearLayout toZ;

    /* synthetic */ MultiTalkRoomPopupNav$a(MultiTalkRoomPopupNav multiTalkRoomPopupNav, boolean z, byte b) {
        this(multiTalkRoomPopupNav, z);
    }

    private MultiTalkRoomPopupNav$a(MultiTalkRoomPopupNav multiTalkRoomPopupNav, boolean z) {
        this.toY = multiTalkRoomPopupNav;
        this.iRz = (Button) multiTalkRoomPopupNav.findViewById(R.h.multitalk_alert_cancel_btn);
        this.titleView = (TextView) multiTalkRoomPopupNav.findViewById(R.h.multitalk_tv_dialog_title);
        this.toZ = (LinearLayout) multiTalkRoomPopupNav.findViewById(R.h.multitalk_dialog_layout);
        if (z) {
            this.toZ.setBackgroundResource(R.g.multitalk_talking_banner_shape);
            this.iRz.setTextColor(multiTalkRoomPopupNav.getResources().getColor(R.e.multitalk_popup_nav_black_text_color));
            return;
        }
        this.toZ.setBackgroundResource(R.g.multitalk_default_banner_shape);
        this.iRz.setTextColor(multiTalkRoomPopupNav.getResources().getColor(R.e.cancel_btn_color));
    }
}
