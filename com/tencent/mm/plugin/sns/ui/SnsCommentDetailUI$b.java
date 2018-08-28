package com.tencent.mm.plugin.sns.ui;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.TextView.BufferType;
import com.tencent.mm.plugin.messenger.foundation.a.i;
import com.tencent.mm.plugin.sns.i.e;
import com.tencent.mm.plugin.sns.i.f;
import com.tencent.mm.plugin.sns.i.g;
import com.tencent.mm.plugin.sns.i.j;
import com.tencent.mm.plugin.sns.model.ap;
import com.tencent.mm.plugin.sns.storage.h;
import com.tencent.mm.plugin.sns.storage.n;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.d.k;
import com.tencent.mm.pluginsdk.ui.d.o;
import com.tencent.mm.protocal.c.bon;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.ab;
import com.tencent.mm.ui.y;
import java.util.LinkedList;

class SnsCommentDetailUI$b extends BaseAdapter {
    Activity activity;
    String bKW;
    final /* synthetic */ SnsCommentDetailUI nUO;
    public LinkedList<bon> nVs;
    LinkedList<bon> nVt;

    public SnsCommentDetailUI$b(SnsCommentDetailUI snsCommentDetailUI, LinkedList<bon> linkedList, LinkedList<bon> linkedList2, Activity activity, String str) {
        this.nUO = snsCommentDetailUI;
        this.nVs = linkedList;
        this.nVt = linkedList2;
        this.activity = activity;
        this.bKW = str;
    }

    public final int getCount() {
        int i = 0;
        if (this.nVt.size() > 0) {
            if (this.nVs != null) {
                i = this.nVs.size();
            }
            return i + 1;
        } else if (this.nVs != null) {
            return this.nVs.size();
        } else {
            return 0;
        }
    }

    public final Object getItem(int i) {
        return null;
    }

    public final long getItemId(int i) {
        return 0;
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        CharSequence BL;
        ab Ye;
        String BL2;
        if (this.nVt.size() > 0) {
            if (i == 0) {
                return SnsCommentDetailUI.G(this.nUO);
            }
            i--;
        }
        bon bon = (bon) this.nVs.get(i);
        if (view == null || !(view.getTag() instanceof a)) {
            view = y.gq(this.activity).inflate(g.sns_comment_detail_item, null);
            view.setOnTouchListener(SnsCommentDetailUI.H(this.nUO));
            a aVar2 = new a(this);
            aVar2.eCl = (ImageView) view.findViewById(f.album_comment_avatar_iv);
            aVar2.eCl.setOnClickListener(SnsCommentDetailUI.I(this.nUO));
            aVar2.lWV = (TextView) view.findViewById(f.album_comment_nick_tv);
            aVar2.lWV.setOnTouchListener(new ab());
            aVar2.lWV.setOnClickListener(new 2(this));
            aVar2.hrV = (TextView) view.findViewById(f.album_comment_time_tv);
            aVar2.eZj = (TextView) view.findViewById(f.album_comment_content_tv);
            aVar2.eZj.setOnTouchListener(new ab());
            aVar2.nVv = (SnsTranslateResultView) view.findViewById(f.sns_translate_result_view);
            aVar2.nVv.setVisibility(8);
            if (SnsCommentDetailUI.y(this.nUO) == 11) {
                view.findViewById(f.comment_view_parent).setBackgroundResource(e.friendactivity_comment_detail_list_golden);
                aVar = aVar2;
            } else {
                aVar = aVar2;
            }
        } else {
            aVar = (a) view.getTag();
        }
        aVar.nVw = bon;
        aVar.userName = bon.rdS;
        int i2 = SnsCommentDetailUI.y(this.nUO) == 11 ? 3 : 2;
        int i3 = SnsCommentDetailUI.y(this.nUO) == 11 ? 3 : 2;
        com.tencent.mm.kernel.g.Ek();
        ab Ye2 = ((i) com.tencent.mm.kernel.g.l(i.class)).FR().Ye(aVar.userName);
        if (i == 0 && this.nVt.isEmpty()) {
            if (SnsCommentDetailUI.y(this.nUO) == 11) {
                view.setBackgroundResource(e.friendactivity_comment_detail_list_golden_arror);
            } else {
                view.setBackgroundResource(e.sns_comment_detail_headitem_bg);
            }
        } else if (SnsCommentDetailUI.y(this.nUO) == 11) {
            view.setBackgroundResource(e.sns_comment_detail_item_bg_golden);
        } else {
            view.setBackgroundResource(e.sns_comment_detail_item_bg);
        }
        if (i == 0) {
            view.findViewById(f.sns_comment_left_icon).setVisibility(0);
            view.findViewById(f.sns_comment_line).setVisibility(8);
            if (SnsCommentDetailUI.y(this.nUO) == 11) {
                ((ImageView) view.findViewById(f.sns_comment_left_icon)).setImageResource(com.tencent.mm.plugin.sns.i.i.friendactivity_writeicon_golden);
            }
        } else {
            view.findViewById(f.sns_comment_left_icon).setVisibility(4);
            view.findViewById(f.sns_comment_line).setVisibility(0);
        }
        b.p(aVar.eCl, bon.rdS);
        aVar.eCl.setTag(bon.rdS);
        if (Ye2 != null) {
            BL = Ye2.BL();
        } else {
            Object BL3 = bon.rTW != null ? bon.rTW : bon.rdS;
        }
        CharSequence charSequence = null;
        CharSequence charSequence2 = null;
        int i4 = 0;
        int i5 = 0;
        n Nk = h.Nk(SnsCommentDetailUI.n(this.nUO));
        aVar.eZj.setText(bon.jSA + " ");
        CharSequence charSequence3 = aVar.eZj.getText().toString();
        if (Nk != null) {
            com.tencent.mm.kernel.g.Ek();
            Ye = ((i) com.tencent.mm.kernel.g.l(i.class)).FR().Ye(Nk.field_userName);
        } else {
            Ye = null;
        }
        if (bon.smm == 1) {
            if (Ye != null) {
                charSequence2 = Ye.BL();
                i5 = this.nUO.getString(j.sns_at).length();
                charSequence3 = this.nUO.getString(j.sns_at) + charSequence2 + this.nUO.getString(j.sns_after_reply) + charSequence3;
            }
        } else if (!bi.oW(bon.smB)) {
            Ye = SnsCommentDetailUI.J(this.nUO).Yg(bon.smB);
            BL2 = Ye == null ? bon.smB : Ye.BL();
            i4 = this.nUO.getString(j.sns_reply).length();
            charSequence3 = this.nUO.getString(j.sns_reply) + BL2 + this.nUO.getString(j.sns_after_reply) + charSequence3;
            Object charSequence4 = BL2;
        }
        aVar.lWV.setText(BL3, BufferType.SPANNABLE);
        com.tencent.mm.pluginsdk.ui.d.j.g(aVar.lWV, i2);
        CharSequence kVar = new k(aVar.lWV.getText());
        kVar.a(new o(bon.rdS, SnsCommentDetailUI.K(this.nUO), i2), BL3, 0);
        aVar.lWV.setText(kVar, BufferType.SPANNABLE);
        aVar.hrV.setText(az.l(this.activity, ((long) bon.lOH) * 1000));
        aVar.eZj.setText(charSequence3, BufferType.SPANNABLE);
        com.tencent.mm.pluginsdk.ui.d.j.g(aVar.eZj, i3);
        Object kVar2 = new k(aVar.eZj.getText());
        if (charSequence2 != null) {
            kVar2.a(new o(Nk.field_userName, SnsCommentDetailUI.K(this.nUO), i3), charSequence2, i5);
        } else if (charSequence4 != null) {
            kVar2.a(new o(bon.smB, SnsCommentDetailUI.K(this.nUO), i3), charSequence4, i4);
        }
        aVar.eZj.setText(kVar2, BufferType.SPANNABLE);
        aVar.eZj.setVisibility(0);
        SnsCommentDetailUI.L(this.nUO).a(view, SnsCommentDetailUI.x(this.nUO).okI, SnsCommentDetailUI.x(this.nUO).okv);
        SnsCommentDetailUI.L(this.nUO).a(aVar.eZj, SnsCommentDetailUI.x(this.nUO).okI, SnsCommentDetailUI.x(this.nUO).okv);
        BL2 = ap.ez(SnsCommentDetailUI.n(this.nUO), String.valueOf(bon.smh != 0 ? (long) bon.smh : bon.smk));
        if (ap.cd(BL2, 4) && aVar.nVv != null) {
            ap.b Mq = ap.Mq(BL2);
            if (Mq != null) {
                aVar.nVv.setVisibility(0);
                if (!Mq.dDR) {
                    aVar.nVv.xD(2);
                } else if (Mq.dHC) {
                    aVar.nVv.setVisibility(8);
                } else {
                    aVar.nVv.a(Mq, 2, Mq.result, Mq.dMB, Mq.nrI);
                }
            } else {
                aVar.nVv.setVisibility(8);
            }
        }
        view.setClickable(true);
        x.d("MicroMsg.SnsCommentDetailUI", "position " + bon.rdS + " self " + SnsCommentDetailUI.M(this.nUO) + " commentid " + bon.smh + " snsid " + SnsCommentDetailUI.n(this.nUO));
        if (SnsCommentDetailUI.M(this.nUO).equals(bon.rdS)) {
            aVar.aAy = bon;
        } else {
            aVar.aAy = new Object[]{Integer.valueOf(i), bon, bon.rdS, BL3};
        }
        m mVar = new m(SnsCommentDetailUI.n(this.nUO), bon, bon.rdS, bon.jSA, aVar.eZj, 2);
        mVar.tag = aVar;
        view.setTag(mVar);
        aVar.eZj.setTag(mVar);
        view.setOnClickListener(SnsCommentDetailUI.N(this.nUO));
        aVar.eZj.setOnClickListener(SnsCommentDetailUI.N(this.nUO));
        return view;
    }
}
