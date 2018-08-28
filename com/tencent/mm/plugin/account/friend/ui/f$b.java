package com.tencent.mm.plugin.account.friend.ui;

import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.mm.plugin.account.a.f;

class f$b {
    String account;
    ImageView eBM;
    TextView eBR;
    View eIA;
    TextView eIG;
    TextView eIH;
    TextView eII;
    ProgressBar eIJ;
    int eIy;
    final /* synthetic */ f eMN;
    int status;

    public f$b(f fVar, View view) {
        this.eMN = fVar;
        this.eIG = (TextView) view.findViewById(f.friend_item_catalog);
        this.eBM = (ImageView) view.findViewById(f.friend_item_avatar_iv);
        this.eIH = (TextView) view.findViewById(f.friend_item_nickname);
        this.eII = (TextView) view.findViewById(f.friend_item_wx_nickname);
        this.eIA = view.findViewById(f.friend_item_action_view);
        this.eBR = (TextView) view.findViewById(f.friend_item_status_tv);
        this.eIJ = (ProgressBar) view.findViewById(f.friend_item_status_pb);
        this.eIA.setOnClickListener(new 1(this, fVar));
    }
}
