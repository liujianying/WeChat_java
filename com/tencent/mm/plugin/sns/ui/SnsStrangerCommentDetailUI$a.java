package com.tencent.mm.plugin.sns.ui;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.TextView.BufferType;
import com.tencent.mm.bt.h;
import com.tencent.mm.model.q;
import com.tencent.mm.plugin.appbrand.s$l;
import com.tencent.mm.plugin.sns.c.a;
import com.tencent.mm.plugin.sns.i$f;
import com.tencent.mm.plugin.sns.i$g;
import com.tencent.mm.plugin.sns.i$j;
import com.tencent.mm.plugin.sns.i.e;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.plugin.sns.storage.j;
import com.tencent.mm.plugin.sns.storage.k;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.protocal.c.boh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.r;

class SnsStrangerCommentDetailUI$a extends r<j> {
    private Activity bOb;
    private OnClickListener hqU = new OnClickListener() {
        public final void onClick(View view) {
            String str = (String) view.getTag();
            x.d("MicroMsg.SnsStrangerCommentDetailUI", "onCommentClick:" + str);
            Intent intent = new Intent();
            intent.putExtra("Contact_User", str);
            a.ezn.d(intent, SnsStrangerCommentDetailUI$a.this.bOb);
        }
    };
    final /* synthetic */ SnsStrangerCommentDetailUI obC;

    public final /* synthetic */ Object a(Object obj, Cursor cursor) {
        j jVar = (j) obj;
        if (jVar == null) {
            jVar = new j();
        }
        jVar.d(cursor);
        return jVar;
    }

    public SnsStrangerCommentDetailUI$a(SnsStrangerCommentDetailUI snsStrangerCommentDetailUI, Activity activity) {
        this.obC = snsStrangerCommentDetailUI;
        super(activity, new j());
        this.bOb = activity;
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        if (view == null) {
            a aVar2 = new a(this);
            view = View.inflate(this.bOb, i$g.sns_stranger_comment_item, null);
            aVar2.eCl = (ImageView) view.findViewById(i$f.sns_comment_avatar_iv);
            aVar2.eZj = (TextView) view.findViewById(i$f.sns_comment_content_tv);
            aVar2.lWV = (TextView) view.findViewById(i$f.sns_comment_nickname_tv);
            aVar2.mKZ = (TextView) view.findViewById(i$f.sns_comment_source);
            aVar2.hrV = (TextView) view.findViewById(i$f.sns_comment_time);
            aVar2.obF = (ImageView) view.findViewById(i$f.sns_comment_heart_iv);
            view.setTag(aVar2);
            aVar = aVar2;
        } else {
            aVar = (a) view.getTag();
        }
        j jVar = (j) getItem(i);
        try {
            Object obj;
            boh boh = (boh) new boh().aG(jVar.field_curActionBuf);
            b.p(aVar.eCl, boh.seC);
            aVar.eCl.setTag(boh.seC);
            aVar.eCl.setOnClickListener(this.hqU);
            if (boh.sme != null) {
                obj = boh.sme;
            } else {
                obj = ((j) this.tlE).field_talker;
            }
            aVar.lWV.setTag(boh.seC);
            CharSequence a = com.tencent.mm.pluginsdk.ui.d.j.a(this.bOb, obj, aVar.lWV.getTextSize());
            a.setSpan(new 2(this, boh.seC), 0, obj.length(), 33);
            aVar.lWV.setText(a, BufferType.SPANNABLE);
            aVar.lWV.setOnTouchListener(new ab());
            if (jVar.field_type == 3) {
                aVar.eZj.setVisibility(0);
                aVar.obF.setVisibility(8);
                x.v("MicroMsg.SnsStrangerCommentDetailUI", "source:" + boh.rdq + "  time:" + boh.lOH + " timeFormatted:" + az.k(this.bOb, ((long) boh.lOH) * 1000));
                aVar.eZj.setText(boh.jSA + " ");
                com.tencent.mm.pluginsdk.ui.d.j.g(aVar.eZj, 2);
                aVar.eZj.setVisibility(0);
            } else {
                aVar.eZj.setVisibility(8);
                aVar.obF.setVisibility(0);
            }
            if (!q.GF().equals(boh.seC)) {
                aVar.mKZ.setVisibility(0);
                TextView textView = aVar.mKZ;
                switch (boh.rdq) {
                    case 18:
                        textView.setText(this.obC.getString(i$j.sns_from_lbs));
                        textView.setCompoundDrawablesWithIntrinsicBounds(null, null, com.tencent.mm.bp.a.f(this.bOb, e.personactivity_notice_stranger_nearicon), null);
                        break;
                    case 22:
                    case 23:
                    case 24:
                    case 26:
                    case 27:
                    case s$l.AppCompatTheme_actionModeCloseButtonStyle /*28*/:
                    case s$l.AppCompatTheme_actionModeBackground /*29*/:
                        textView.setText(this.obC.getString(i$j.sns_from_shake));
                        textView.setCompoundDrawablesWithIntrinsicBounds(null, null, com.tencent.mm.bp.a.f(this.bOb, e.personactivity_notice_stranger_shakeicon), null);
                        break;
                    case 25:
                        textView.setText(this.obC.getString(i$j.sns_from_bottle));
                        textView.setCompoundDrawablesWithIntrinsicBounds(null, null, com.tencent.mm.bp.a.f(this.bOb, e.personactivity_notice_stranger_bottleicon), null);
                        break;
                    case s$l.AppCompatTheme_actionModeSplitBackground /*30*/:
                        textView.setText(this.obC.getString(i$j.sns_from_qrcode));
                        textView.setCompoundDrawablesWithIntrinsicBounds(null, null, com.tencent.mm.bp.a.f(this.bOb, e.personactivity_notice_stranger_codeicon), null);
                        break;
                    default:
                        textView.setText(this.obC.getString(i$j.sns_from_stranger));
                        textView.setCompoundDrawablesWithIntrinsicBounds(null, null, com.tencent.mm.bp.a.f(this.bOb, e.personactivity_notice_stranger_searchicon), null);
                        break;
                }
            }
            aVar.mKZ.setVisibility(8);
            aVar.hrV.setText(az.k(this.bOb, ((long) boh.lOH) * 1000));
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.SnsStrangerCommentDetailUI", e, "", new Object[0]);
        }
        return view;
    }

    public final void WT() {
        k byt = af.byt();
        String l = SnsStrangerCommentDetailUI.l(this.obC);
        l = k.bAO() + " where talker = " + h.fz(l) + " and  snsID = " + SnsStrangerCommentDetailUI.m(this.obC) + " and ( type = 3 or type = 5 )";
        x.v("MicroMsg.SnsCommentStorage", "comment sql:" + l);
        setCursor(byt.dCZ.b(l, null, 0));
    }

    protected final void WS() {
        WT();
    }
}
