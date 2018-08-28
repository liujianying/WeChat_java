package com.tencent.mm.ui.chatting.viewitems;

import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewStub;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.mm.R;

public class b$a {
    public ImageView eCl;
    public View gFD;
    public View hrH;
    public TextView hrs;
    public CheckBox jBR;
    public View jEz;
    public TextView mQc;
    public ProgressBar mgA;
    public ViewStub tZt;
    public View tZu;
    public ImageView tZv;
    public String tZw;
    public b tZx;

    public final void dx(View view) {
        this.jEz = view;
        this.hrs = (TextView) view.findViewById(R.h.chatting_time_tv);
        this.eCl = (ImageView) view.findViewById(R.h.chatting_avatar_iv);
        this.tZu = view.findViewById(R.h.chatting_histroy_msg_tip);
        this.hrH = view.findViewById(R.h.chatting_click_area);
        this.tZv = (ImageView) view.findViewById(R.h.chatting_state_iv);
        this.tZt = (ViewStub) view.findViewById(R.h.chatting_send_from_watch_vs);
    }

    public final void me(boolean z) {
        int i = z ? 0 : 8;
        if (!(this.jBR == null || this.jBR.getVisibility() == i)) {
            this.jBR.setVisibility(i);
        }
        if (this.gFD != null && this.gFD.getVisibility() != i) {
            this.gFD.setVisibility(i);
        }
    }

    public static void P(View view, int i) {
        if (view != null) {
            LayoutParams layoutParams = view.getLayoutParams();
            layoutParams.width = i;
            view.setLayoutParams(layoutParams);
            view.requestLayout();
        }
    }
}
