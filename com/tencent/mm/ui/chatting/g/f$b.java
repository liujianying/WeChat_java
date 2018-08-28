package com.tencent.mm.ui.chatting.g;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.ui.chatting.a.b.a;

class f$b extends a {
    TextView eCn;
    ImageView gmn;
    TextView jet;
    ImageView jez;
    final /* synthetic */ f tYA;

    public f$b(f fVar, View view) {
        this.tYA = fVar;
        super(view);
        this.gmn = (ImageView) view.findViewById(R.h.fav_icon);
        this.eCn = (TextView) view.findViewById(R.h.fav_desc);
        this.eCn.setVisibility(8);
        this.jet = (TextView) view.findViewById(R.h.fav_source);
        this.jez = (ImageView) view.findViewById(R.h.fav_icon_mask);
        this.jez.setImageResource(R.g.music_playicon);
        this.jez.setVisibility(0);
    }
}
