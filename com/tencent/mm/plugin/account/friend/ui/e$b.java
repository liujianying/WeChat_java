package com.tencent.mm.plugin.account.friend.ui;

import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.mm.plugin.account.a$f;

class e$b {
    ImageView eBM;
    TextView eBR;
    View eIA;
    ProgressBar eIB;
    int eIy;
    TextView eIz;
    final /* synthetic */ e eMG;
    String eMI;
    int status;

    public e$b(e eVar, View view) {
        this.eMG = eVar;
        this.eBM = (ImageView) view.findViewById(a$f.contactitem_avatar_iv);
        this.eIz = (TextView) view.findViewById(a$f.qq_friend_name);
        this.eIA = view.findViewById(a$f.qq_friend_action_view);
        this.eBR = (TextView) view.findViewById(a$f.qq_friend_status_tv);
        this.eIB = (ProgressBar) view.findViewById(a$f.qq_friend_status_pb);
        this.eIA.setOnClickListener(new 1(this, eVar));
    }
}
