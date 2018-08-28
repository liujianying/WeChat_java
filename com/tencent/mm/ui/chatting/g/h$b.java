package com.tencent.mm.ui.chatting.g;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.ui.chatting.a.b.a;

class h$b extends a {
    TextView eCn;
    ImageView gmn;
    TextView jet;
    final /* synthetic */ h tYI;

    public h$b(h hVar, View view) {
        this.tYI = hVar;
        super(view);
        this.gmn = (ImageView) view.findViewById(R.h.fav_icon);
        this.eCn = (TextView) view.findViewById(R.h.fav_desc);
        this.jet = (TextView) view.findViewById(R.h.fav_source);
        this.jet.setVisibility(0);
    }
}
