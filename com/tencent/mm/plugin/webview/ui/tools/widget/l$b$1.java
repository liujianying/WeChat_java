package com.tencent.mm.plugin.webview.ui.tools.widget;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import com.tencent.mm.R;
import com.tencent.mm.plugin.webview.ui.tools.widget.l.b;
import com.tencent.mm.protocal.c.bio;

class l$b$1 implements OnClickListener {
    final /* synthetic */ ImageView fyA;
    final /* synthetic */ bio fyz;
    final /* synthetic */ b qlp;

    l$b$1(b bVar, bio bio, ImageView imageView) {
        this.qlp = bVar;
        this.fyz = bio;
        this.fyA = imageView;
    }

    public final void onClick(View view) {
        if (this.fyz.sjd == 2) {
            this.fyA.setImageResource(R.k.login_auth_state_not_selected);
            this.fyz.sjd = 1;
        } else if (this.fyz.sjd == 1) {
            this.fyA.setImageResource(R.k.login_auth_state_default_select);
            this.fyz.sjd = 2;
        }
    }
}
