package com.tencent.mm.plugin.sns.ui;

import android.os.StrictMode;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.modelsns.b;
import com.tencent.mm.plugin.sns.data.i;
import com.tencent.mm.plugin.sns.i.f;
import com.tencent.mm.plugin.sns.i.j;
import com.tencent.mm.plugin.sns.model.aj;
import com.tencent.mm.plugin.sns.model.am$a;
import com.tencent.mm.plugin.sns.storage.h;
import com.tencent.mm.plugin.sns.storage.n;
import com.tencent.mm.plugin.sns.ui.a.a.c;
import com.tencent.mm.plugin.sns.ui.av.7;
import com.tencent.mm.plugin.sns.ui.j.1;
import com.tencent.mm.protocal.c.boy;

class j$1$2 implements Runnable {
    final /* synthetic */ View gvo;
    final /* synthetic */ 1 nMe;
    final /* synthetic */ n nMf;
    final /* synthetic */ c nMg;

    j$1$2(1 1, n nVar, c cVar, View view) {
        this.nMe = 1;
        this.nMf = nVar;
        this.nMg = cVar;
        this.gvo = view;
    }

    public final void run() {
        if (this.nMe.nMb.nLK != null) {
            this.nMe.nMb.nLK.nrb.u(this.nMf);
        }
        if (this.nMg.oiG == 0) {
            boy n = aj.n(this.nMf);
            b io = b.io(707);
            io.nb(i.g(this.nMf)).ir(this.nMf.field_type).bP(this.nMf.xb(32)).nb(this.nMf.bBo()).nb(this.nMf.field_userName).ir(n.smJ).ir(n.smM);
            io.RD();
            StrictMode.allowThreadDiskReads();
            this.nMg.oiG = 1;
            this.nMf.field_likeFlag = this.nMg.oiG;
            h.a(this.nMf.bAK(), this.nMf);
            ((TextView) this.gvo.findViewById(f.album_like_tv)).setText(j.sns_has_liked);
            am$a.a(this.nMf, this.nMf.xb(32) ? 7 : 1, "");
        } else {
            this.nMg.oiG = 0;
            this.nMf.field_likeFlag = this.nMg.oiG;
            h.a(this.nMf.bAK(), this.nMf);
            ((TextView) this.gvo.findViewById(f.album_like_tv)).setText(j.sns_like);
            am$a.Mp(this.nMf.bAK());
        }
        av avVar = this.nMe.nMb.nuc;
        LinearLayout linearLayout = (LinearLayout) this.gvo;
        1 1 = new 1(this);
        ImageView imageView = (ImageView) linearLayout.findViewById(f.album_like_icon);
        Animation scaleAnimation = new ScaleAnimation(0.9f, 1.2f, 0.9f, 1.2f, 1, 0.5f, 1, 0.5f);
        scaleAnimation.setDuration(400);
        scaleAnimation.setStartOffset(100);
        scaleAnimation.setRepeatCount(0);
        imageView.clearAnimation();
        imageView.startAnimation(scaleAnimation);
        scaleAnimation.setAnimationListener(new 7(avVar, linearLayout, 1));
    }
}
