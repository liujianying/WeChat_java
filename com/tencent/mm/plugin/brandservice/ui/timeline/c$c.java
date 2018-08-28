package com.tencent.mm.plugin.brandservice.ui.timeline;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.plugin.brandservice.b.d;

class c$c {
    ImageView eCl;
    View hri;
    ImageView hrq;
    BizAvatarLayout hrr;
    TextView hrs;
    TextView hrt;

    c$c() {
    }

    public void cn(View view) {
    }

    public void avh() {
        if (this.hri != null) {
            this.eCl = (ImageView) this.hri.findViewById(d.avatar_iv);
            this.hrt = (TextView) this.hri.findViewById(d.nick_name_tv);
            this.hrs = (TextView) this.hri.findViewById(d.time_tv);
            this.hrr = (BizAvatarLayout) this.hri.findViewById(d.biz_avatar_layout);
        }
    }
}
