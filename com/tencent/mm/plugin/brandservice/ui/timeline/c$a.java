package com.tencent.mm.plugin.brandservice.ui.timeline;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.plugin.brandservice.b.d;
import com.tencent.mm.plugin.brandservice.ui.timeline.c.c;

class c$a extends c {
    LinearLayout hrg;
    LinearLayout hrh;

    c$a() {
    }

    public final void cn(View view) {
    }

    public final void avh() {
        if (this.hri != null) {
            this.eCl = (ImageView) this.hri.findViewById(d.avatar_iv);
            this.hrt = (TextView) this.hri.findViewById(d.nick_name_tv);
            this.hrs = (TextView) this.hri.findViewById(d.time_tv);
            this.hrr = (BizAvatarLayout) this.hri.findViewById(d.biz_avatar_layout);
            this.hrg = (LinearLayout) this.hri.findViewById(d.biz_time_line_new_tips_layout);
            this.hrh = (LinearLayout) this.hri.findViewById(d.biz_time_line_item_top);
        }
    }
}
