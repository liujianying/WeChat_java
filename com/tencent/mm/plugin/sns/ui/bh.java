package com.tencent.mm.plugin.sns.ui;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.modelsns.b;
import com.tencent.mm.plugin.sns.data.i;
import com.tencent.mm.plugin.sns.i.e;
import com.tencent.mm.plugin.sns.i.f;
import com.tencent.mm.plugin.sns.i.j;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.plugin.sns.model.aj;
import com.tencent.mm.plugin.sns.storage.n;
import com.tencent.mm.plugin.sns.storage.v;
import com.tencent.mm.plugin.sns.ui.a.a.c;
import com.tencent.mm.protocal.c.boy;

public final class bh {
    Context mContext;
    LinearLayout nTX;
    LinearLayout nTY;
    int njc = -1;
    FrameLayout ntx;
    private av nuc;
    SnsCommentShowAbLayout ohM = null;

    /* renamed from: com.tencent.mm.plugin.sns.ui.bh$1 */
    class AnonymousClass1 implements Runnable {
        final /* synthetic */ View ohN;
        final /* synthetic */ View val$view;

        AnonymousClass1(View view, View view2) {
            this.val$view = view;
            this.ohN = view2;
        }

        public final void run() {
            bh.a(bh.this, this.val$view, this.ohN);
        }
    }

    static /* synthetic */ void a(bh bhVar, View view, View view2) {
        c cVar = (c) view.getTag();
        n Nl = af.byo().Nl(cVar.bKW);
        if (Nl != null) {
            b io = b.io(740);
            boy n = aj.n(Nl);
            io.nb(i.g(Nl)).ir(Nl.field_type).bP(Nl.xb(32)).nb(Nl.bBo()).nb(Nl.field_userName).ir(n == null ? 0 : n.smJ).ir(n == null ? 0 : n.smM);
            io.RD();
        }
        view2.setVisibility(0);
        view2.startAnimation(bhVar.nuc.nTV);
        bhVar.nTX = (LinearLayout) view2.findViewById(f.album_comment_tv);
        bhVar.nTX.setOnClickListener(bhVar.nuc.ntw.okC);
        bhVar.nTX.setOnTouchListener(bhVar.nuc.nNj);
        bhVar.nTY = (LinearLayout) view2.findViewById(f.album_like_img);
        bhVar.nTY.setOnClickListener(bhVar.nuc.ntw.okD);
        bhVar.nTY.setOnTouchListener(bhVar.nuc.nNj);
        bhVar.nTY.setTag(cVar);
        bhVar.nTX.setTag(cVar);
        ImageView imageView = (ImageView) bhVar.nTY.findViewById(f.album_like_icon);
        ImageView imageView2 = (ImageView) bhVar.nTX.findViewById(f.album_comment_icon);
        TextView textView = (TextView) bhVar.nTY.findViewById(f.album_like_tv);
        TextView textView2 = (TextView) bhVar.nTX.findViewById(f.album_comment_tv_tip);
        if (v.NH(cVar.bSZ)) {
            bhVar.nTX.setEnabled(false);
            bhVar.nTY.setEnabled(false);
            textView2.setTextColor(bhVar.mContext.getResources().getColor(com.tencent.mm.plugin.sns.i.c.sns_like_color));
            if (cVar.hER == 11) {
                imageView.setImageResource(com.tencent.mm.plugin.sns.i.i.friendactivity_comment_likeicon_golden_normal);
                imageView2.setImageResource(com.tencent.mm.plugin.sns.i.i.friendactivity_comment_writeicon_golden_normal);
            } else {
                imageView.setImageResource(com.tencent.mm.plugin.sns.i.i.friendactivity_comment_likeicon_normal);
                imageView2.setImageResource(com.tencent.mm.plugin.sns.i.i.friendactivity_comment_writeicon_normal);
            }
            textView.setText(bhVar.mContext.getString(j.sns_like));
            textView.setTextColor(bhVar.mContext.getResources().getColor(com.tencent.mm.plugin.sns.i.c.sns_like_color));
        } else {
            bhVar.nTX.setEnabled(true);
            if (cVar.hER == 11) {
                imageView.setImageResource(e.lucky_friendactivity_comment_likeicon);
                imageView2.setImageResource(e.lucky_friendactivity_comment_writeicon);
                textView.setTextColor(bhVar.mContext.getResources().getColor(com.tencent.mm.plugin.sns.i.c.sns_lucky_comment));
                textView2.setTextColor(bhVar.mContext.getResources().getColor(com.tencent.mm.plugin.sns.i.c.sns_lucky_comment));
            } else {
                imageView.setImageResource(e.friendactivity_comment_likeicon);
                textView.setTextColor(bhVar.mContext.getResources().getColor(com.tencent.mm.plugin.sns.i.c.white));
                textView2.setTextColor(bhVar.mContext.getResources().getColor(com.tencent.mm.plugin.sns.i.c.white));
            }
            bhVar.nTY.setEnabled(true);
            if (cVar.oiG == 0) {
                textView.setText(bhVar.mContext.getString(j.sns_like));
            } else {
                textView.setText(bhVar.mContext.getString(j.sns_has_liked));
            }
        }
        if (cVar.hER == 11) {
            bhVar.nTY.setBackgroundResource(e.lucky_sns_comment_btn_left);
            bhVar.nTX.setBackgroundResource(e.lucky_sns_comment_btn_right);
        }
    }

    public bh(Context context, av avVar, FrameLayout frameLayout) {
        this.mContext = context;
        this.nuc = avVar;
        this.ntx = frameLayout;
    }

    final void cM(View view) {
        view.clearAnimation();
        view.startAnimation(this.nuc.nTW);
        this.nuc.nTW.setAnimationListener(new 2(this, view));
    }

    public final boolean bCa() {
        if (this.ohM == null) {
            return false;
        }
        this.ntx.removeView(this.ohM);
        this.ohM = null;
        return true;
    }
}
