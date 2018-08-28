package com.tencent.mm.plugin.account.bind.ui;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.mm.plugin.account.a.f;

class c$a {
    String bKg;
    TextView eBR;
    View eIA;
    ProgressBar eIB;
    final /* synthetic */ c eIv;
    int eIy;
    TextView eIz;
    int status;

    public c$a(final c cVar, View view) {
        this.eIv = cVar;
        this.eIz = (TextView) view.findViewById(f.mobile_friend_name);
        this.eIA = view.findViewById(f.mobile_friend_action_view);
        this.eBR = (TextView) view.findViewById(f.mobile_friend_status_tv);
        this.eIB = (ProgressBar) view.findViewById(f.mobile_friend_status_pb);
        this.eIA.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                if (c.f(c$a.this.eIv) != null) {
                    c.f(c$a.this.eIv).c(c$a.this.eIy, c$a.this.bKg, c$a.this.status);
                }
            }
        });
    }
}
