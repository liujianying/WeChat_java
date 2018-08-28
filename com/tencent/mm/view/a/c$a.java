package com.tencent.mm.view.a;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.plugin.n.a.e;

class c$a {
    TextView eCn;
    ImageView gmn;
    final /* synthetic */ c uTM;
    TextView uTN;

    public c$a(c cVar, View view) {
        this.uTM = cVar;
        this.gmn = (ImageView) view.findViewById(e.art_emoji_icon_iv);
        this.eCn = (TextView) view.findViewById(e.art_emoji_icon_text);
        this.uTN = (TextView) view.findViewById(e.art_emoji_new_tv);
        this.uTN.setTextSize(1, 12.0f);
    }
}
