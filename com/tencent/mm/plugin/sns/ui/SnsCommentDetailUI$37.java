package com.tencent.mm.plugin.sns.ui;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.plugin.sns.i$c;
import com.tencent.mm.plugin.sns.i$e;
import com.tencent.mm.plugin.sns.i.f;
import com.tencent.mm.plugin.sns.i.i;
import com.tencent.mm.plugin.sns.i.j;
import com.tencent.mm.plugin.sns.lucky.a.m;
import com.tencent.mm.plugin.sns.lucky.ui.a;
import com.tencent.mm.plugin.sns.storage.h;
import com.tencent.mm.plugin.sns.storage.n;
import com.tencent.mm.plugin.sns.storage.v;
import com.tencent.mm.protocal.c.bsu;
import com.tencent.mm.sdk.platformtools.x;

class SnsCommentDetailUI$37 implements OnClickListener {
    final /* synthetic */ n nMf;
    final /* synthetic */ SnsCommentDetailUI nUO;
    final /* synthetic */ TextView nVd;
    final /* synthetic */ TextView nVe;
    final /* synthetic */ ImageView nVf;
    final /* synthetic */ ImageView nVg;

    SnsCommentDetailUI$37(SnsCommentDetailUI snsCommentDetailUI, n nVar, TextView textView, TextView textView2, ImageView imageView, ImageView imageView2) {
        this.nUO = snsCommentDetailUI;
        this.nMf = nVar;
        this.nVd = textView;
        this.nVe = textView2;
        this.nVf = imageView;
        this.nVg = imageView2;
    }

    public final void onClick(View view) {
        x.d("MicroMsg.SnsCommentDetailUI", "showComment click" + SnsCommentDetailUI.B(this.nUO).getVisibility());
        SnsCommentDetailUI.D(this.nUO);
        bsu bAJ = this.nMf.bAJ();
        if (bAJ != null && bAJ.sqc.ruz == 21 && !m.LS(this.nMf.bBe())) {
            a.e(this.nUO.mController.tml, this.nUO.nUK.xm(0));
        } else if (SnsCommentDetailUI.B(this.nUO).getVisibility() == 0) {
            SnsCommentDetailUI.f(this.nUO);
        } else {
            SnsCommentDetailUI.B(this.nUO).setVisibility(0);
            SnsCommentDetailUI.B(this.nUO).startAnimation(SnsCommentDetailUI.E(this.nUO));
            if (SnsCommentDetailUI.y(this.nUO) == 11) {
                SnsCommentDetailUI.F(this.nUO).findViewById(f.album_comment_container).setBackgroundResource(i$e.friendactivity_comment_frame_bg_golden);
            }
            if (v.NG(SnsCommentDetailUI.n(this.nUO))) {
                this.nUO.nTX.setEnabled(true);
                this.nVf.setImageResource(i$e.friendactivity_comment_likeicon);
                this.nUO.nTY.setEnabled(true);
                this.nVd.setTextColor(this.nUO.getResources().getColor(i$c.white));
                this.nVe.setTextColor(this.nUO.getResources().getColor(i$c.white));
                n Nk = h.Nk(SnsCommentDetailUI.n(this.nUO));
                if (SnsCommentDetailUI.y(this.nUO) == 11) {
                    this.nVf.setImageResource(i$e.lucky_friendactivity_comment_likeicon);
                    this.nVg.setImageResource(i$e.lucky_friendactivity_comment_writeicon);
                    this.nVd.setTextColor(this.nUO.getResources().getColor(i$c.sns_lucky_comment));
                    this.nVe.setTextColor(this.nUO.getResources().getColor(i$c.sns_lucky_comment));
                } else {
                    this.nVf.setImageResource(i$e.friendactivity_comment_likeicon);
                    this.nVd.setTextColor(this.nUO.getResources().getColor(i$c.white));
                    this.nVe.setTextColor(this.nUO.getResources().getColor(i$c.white));
                }
                if (Nk.field_likeFlag == 0) {
                    this.nVd.setText(this.nUO.getString(j.sns_like));
                    return;
                } else {
                    this.nVd.setText(this.nUO.getString(j.sns_has_liked));
                    return;
                }
            }
            this.nUO.nTX.setEnabled(false);
            this.nUO.nTY.setEnabled(false);
            this.nVd.setText(this.nUO.getString(j.sns_like));
            this.nVd.setTextColor(this.nUO.getResources().getColor(i$c.sns_like_color));
            this.nVe.setTextColor(this.nUO.getResources().getColor(i$c.sns_like_color));
            if (SnsCommentDetailUI.y(this.nUO) == 11) {
                this.nVf.setImageResource(i.friendactivity_comment_likeicon_golden_normal);
            } else {
                this.nVf.setImageResource(i.friendactivity_comment_likeicon_normal);
            }
        }
    }
}
