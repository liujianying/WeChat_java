package com.tencent.mm.plugin.sns.ui;

import android.content.Context;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.text.SpannableString;
import android.text.style.ImageSpan;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.bp.a;
import com.tencent.mm.plugin.appbrand.s$l;
import com.tencent.mm.plugin.sns.i;
import com.tencent.mm.plugin.sns.i$f;
import com.tencent.mm.plugin.sns.i$g;
import com.tencent.mm.plugin.sns.i$i;
import com.tencent.mm.plugin.sns.i$j;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.plugin.sns.model.q;
import com.tencent.mm.plugin.sns.storage.e;
import com.tencent.mm.plugin.sns.storage.j;
import com.tencent.mm.plugin.sns.storage.k;
import com.tencent.mm.plugin.sns.storage.n;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.protocal.c.amh;
import com.tencent.mm.protocal.c.ate;
import com.tencent.mm.protocal.c.boh;
import com.tencent.mm.sdk.e.l;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.av;
import com.tencent.mm.ui.MMImageView;
import com.tencent.mm.ui.base.MMSlideDelView;
import com.tencent.mm.ui.base.MMSlideDelView.c;
import com.tencent.mm.ui.base.MMSlideDelView.d;
import com.tencent.mm.ui.base.MMSlideDelView.f;
import com.tencent.mm.ui.base.MMSlideDelView.g;
import com.tencent.mm.ui.r;
import com.tencent.mm.ui.y;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class SnsMsgUI$a extends r<j> {
    int edl = this.hFO;
    int hFO = 10;
    protected g hkN;
    protected c hkO;
    protected d hkQ = new 1(this);
    private Set<MMSlideDelView> kwC = new HashSet();
    final /* synthetic */ SnsMsgUI nYl;
    protected f nYp;

    public SnsMsgUI$a(SnsMsgUI snsMsgUI, Context context, j jVar) {
        this.nYl = snsMsgUI;
        super(context, jVar);
    }

    public final long getItemId(int i) {
        return ((j) getItem(i)).field_snsID;
    }

    protected final void WS() {
        aYc();
        WT();
    }

    public final void setPerformItemClickListener(g gVar) {
        this.hkN = gVar;
    }

    public final void b(f fVar) {
        this.nYp = fVar;
    }

    public final void setGetViewPositionCallback(c cVar) {
        this.hkO = cVar;
    }

    public final synchronized void a(String str, l lVar) {
        super.a(str, lVar);
    }

    public final void WT() {
        if (af.byt().axd() <= 0 || SnsMsgUI.p(this.nYl)) {
            this.edl = af.byt().bAQ();
            k byt = af.byt();
            String str = k.bAO() + " where isSend = 0 order by createTime desc LIMIT " + this.hFO;
            x.v("MicroMsg.SnsCommentStorage", "getCursor sql:" + str);
            setCursor(byt.dCZ.b(str, null, 0));
        } else {
            setCursor(af.byt().bAP());
        }
        notifyDataSetChanged();
    }

    public final boolean ayQ() {
        return this.hFO >= this.edl;
    }

    public final int ayR() {
        if (ayQ()) {
            if (SnsMsgUI.h(this.nYl).getParent() != null) {
                SnsMsgUI.c(this.nYl).removeFooterView(SnsMsgUI.h(this.nYl));
            }
            return 0;
        }
        this.hFO += 10;
        if (this.hFO <= this.edl) {
            return 10;
        }
        this.hFO = this.edl;
        return this.edl % 10;
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        j jVar = (j) getItem(i);
        if (view == null || !(view.getTag() instanceof a)) {
            MMSlideDelView mMSlideDelView = (MMSlideDelView) y.gq(this.context).inflate(i$g.base_slide_del_view, null);
            View inflate = y.gq(this.context).inflate(i$g.sns_msg_item, null);
            a aVar2 = new a(this);
            aVar2.nYr = (ImageView) inflate.findViewById(i$f.sns_msg_avatar_iv);
            aVar2.lWV = (TextView) inflate.findViewById(i$f.sns_msg_nick_tv);
            aVar2.nYu = (TextView) inflate.findViewById(i$f.sns_msg_content_tv);
            aVar2.nYt = (ImageView) inflate.findViewById(i$f.sns_msg_lucky_icon);
            aVar2.hrV = (TextView) inflate.findViewById(i$f.sns_msg_time_tv);
            aVar2.nYv = (MMImageView) inflate.findViewById(i$f.sns_msg_iv);
            aVar2.nYs = (TextView) inflate.findViewById(i$f.sns_msg_tv);
            aVar2.nYv.setOnClickListener(SnsMsgUI.q(this.nYl));
            aVar2.hkW = mMSlideDelView.findViewById(i$f.slide_del_del_view);
            aVar2.hkX = (TextView) mMSlideDelView.findViewById(i$f.slide_del_view_del_word);
            aVar2.nYw = (ImageView) inflate.findViewById(i$f.sns_sight_icon);
            mMSlideDelView.setView(inflate);
            mMSlideDelView.setPerformItemClickListener(this.hkN);
            mMSlideDelView.setGetViewPositionCallback(this.hkO);
            mMSlideDelView.setItemStatusCallBack(this.hkQ);
            mMSlideDelView.setEnable(false);
            mMSlideDelView.setTag(aVar2);
            aVar = aVar2;
            view = mMSlideDelView;
        } else {
            aVar = (a) view.getTag();
        }
        aVar.nYv.setTag(null);
        aVar.nkI = jVar.field_snsID;
        aVar.hkW.setTag(Integer.valueOf(jVar.nJg));
        aVar.hkW.setOnClickListener(new 2(this));
        String str = "";
        boh boh = (boh) new boh().aG(jVar.field_curActionBuf);
        String str2;
        ab Yg;
        CharSequence BL;
        n fi;
        String str3;
        TextView textView;
        int i2;
        Object obj;
        TextView textView2;
        long j;
        e eZ;
        n nVar;
        Object obj2;
        try {
            str2 = ((boh) new boh().aG(jVar.field_refActionBuf)).seC;
            try {
                if (bi.oW(str2) || str2.equals(af.bxU())) {
                    str = "";
                    try {
                        if (bi.oW(boh.seC)) {
                            b.a(aVar.nYr, boh.seC);
                            aVar.nYr.setOnClickListener(new 3(this, boh.seC));
                        } else {
                            x.e("MicroMsg.SnsMsgUI", "action.getFromUsername() is null or Nil");
                        }
                        Yg = SnsMsgUI.r(this.nYl).Yg(boh.seC);
                        if (Yg == null) {
                            BL = Yg.BL();
                        } else if (bi.oW(boh.sme)) {
                            BL = boh.seC;
                        } else {
                            BL = boh.sme;
                        }
                        aVar.lWV.setText(com.tencent.mm.pluginsdk.ui.d.j.a(this.nYl, BL, aVar.lWV.getTextSize()));
                        fi = af.byo().fi(jVar.field_snsID);
                        if (fi == null && fi.field_type == 21) {
                            aVar.lWV.setTextColor(this.nYl.getResources().getColor(i.c.sns_lucky_item_gold));
                        } else {
                            aVar.lWV.setTextColor(this.nYl.getResources().getColor(i.c.sns_link_color));
                        }
                        str3 = boh.seC;
                        textView = aVar.lWV;
                        i2 = boh.rdq;
                        switch (jVar.field_type) {
                            case 1:
                            case 2:
                                obj = null;
                                break;
                            case 3:
                            case 5:
                                obj = 1;
                                break;
                            case 4:
                                obj = null;
                                break;
                            case 7:
                            case 8:
                            case 13:
                            case 14:
                                obj = null;
                                break;
                            default:
                                obj = 1;
                                break;
                        }
                        if (obj != null || SnsMsgUI.s(this.nYl).equals(str3)) {
                            textView.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
                        } else {
                            Drawable f;
                            switch (i2) {
                                case 18:
                                    f = a.f(this.context, i.e.personactivity_notice_stranger_nearicon);
                                    break;
                                case 22:
                                case 23:
                                case 24:
                                case 26:
                                case 27:
                                case s$l.AppCompatTheme_actionModeCloseButtonStyle /*28*/:
                                case s$l.AppCompatTheme_actionModeBackground /*29*/:
                                    f = a.f(this.context, i.e.personactivity_notice_stranger_shakeicon);
                                    break;
                                case 25:
                                    f = a.f(this.context, i.e.personactivity_notice_stranger_bottleicon);
                                    break;
                                case s$l.AppCompatTheme_actionModeSplitBackground /*30*/:
                                    f = a.f(this.context, i.e.personactivity_notice_stranger_codeicon);
                                    break;
                                default:
                                    f = a.f(this.context, i.e.personactivity_notice_stranger_searchicon);
                                    break;
                            }
                            textView.setCompoundDrawablesWithIntrinsicBounds(null, null, f, null);
                        }
                        textView2 = aVar.nYu;
                        j = jVar.field_snsID;
                        if (((jVar.field_commentflag & 1) <= 0 ? 1 : null) == null) {
                            textView2.setTextColor(this.nYl.getResources().getColor(i.c.black));
                            textView2.setBackgroundDrawable(null);
                            textView2.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
                            textView2.setText("");
                            textView2.setCompoundDrawablePadding(0);
                            Drawable f2;
                            String str4;
                            e eZ2;
                            switch (boh.hcE) {
                                case 1:
                                case 5:
                                    fi = af.byo().fi(jVar.field_snsID);
                                    if (fi == null || fi.field_type != 7) {
                                        f2 = a.f(this.context, i$i.friendactivity_likeicon);
                                        if (fi == null || fi.field_type != 21) {
                                            f2.clearColorFilter();
                                        } else {
                                            f2.setColorFilter(this.nYl.getResources().getColor(i.c.sns_lucky_msg_color), Mode.SRC_ATOP);
                                        }
                                        f2.setBounds(0, 0, f2.getIntrinsicWidth(), f2.getIntrinsicHeight());
                                        BL = new SpannableString(" ");
                                        BL.setSpan(new ImageSpan(f2), 0, 1, 18);
                                        textView2.setText(BL);
                                        textView2.setContentDescription(this.nYl.mController.tml.getString(i$j.sns_friend_like));
                                        break;
                                    }
                                    textView2.setText(this.nYl.getString(i$j.sns_like_background));
                                    break;
                                case 2:
                                case 3:
                                    str4 = boh.jSA;
                                    str2 = "";
                                    eZ2 = af.byr().eZ(jVar.field_snsID);
                                    if (boh.smm == 1) {
                                        if (eZ2 != null) {
                                            com.tencent.mm.kernel.g.Ek();
                                            Yg = ((com.tencent.mm.plugin.messenger.foundation.a.i) com.tencent.mm.kernel.g.l(com.tencent.mm.plugin.messenger.foundation.a.i.class)).FR().Ye(eZ2.field_userName);
                                            str2 = this.context.getString(i$j.sns_msgui_at, new Object[]{Yg.BL()});
                                        }
                                    } else if (!bi.oW(str)) {
                                        str2 = this.context.getString(i$j.sns_msgui_reply, new Object[]{str});
                                    }
                                    textView2.setText(com.tencent.mm.pluginsdk.ui.d.j.a(this.nYl, str2 + str4 + " ", textView2.getTextSize()));
                                    break;
                                case 4:
                                    textView2.setText(this.nYl.getString(i$j.sns_timeline_ui_with_you));
                                    break;
                                case 7:
                                    textView2.setCompoundDrawablesWithIntrinsicBounds(a.f(this.context, i$i.friendactivity_likeicon), null, null, null);
                                    textView2.setContentDescription(this.nYl.mController.tml.getString(i$j.sns_friend_like));
                                    break;
                                case 8:
                                    str2 = "";
                                    str4 = boh.jSA;
                                    eZ2 = af.byr().eZ(jVar.field_snsID);
                                    if (boh.smm == 1) {
                                        if (eZ2 != null) {
                                            com.tencent.mm.kernel.g.Ek();
                                            Yg = ((com.tencent.mm.plugin.messenger.foundation.a.i) com.tencent.mm.kernel.g.l(com.tencent.mm.plugin.messenger.foundation.a.i.class)).FR().Ye(eZ2.field_userName);
                                            str2 = this.context.getString(i$j.sns_msgui_at, new Object[]{Yg.BL()});
                                        }
                                    } else if (!bi.oW(str)) {
                                        str2 = this.context.getString(i$j.sns_msgui_reply, new Object[]{str});
                                    }
                                    textView2.setText(com.tencent.mm.pluginsdk.ui.d.j.a(this.nYl, str2 + str4 + " ", textView2.getTextSize()));
                                    break;
                                case 13:
                                    amh amh = new amh();
                                    x.i("MicroMsg.SnsMsgUI", "curAction.HBBuffer " + boh.sml);
                                    try {
                                        amh.aG(com.tencent.mm.platformtools.ab.a(boh.sml));
                                        x.i("MicroMsg.SnsMsgUI", "hbbuffer  " + amh.cfh);
                                    } catch (Exception e) {
                                        x.e("MicroMsg.SnsMsgUI", "parser hbbuffer " + e.getMessage());
                                    }
                                    SnsMsgUI.r(this.nYl).Yg(boh.seC);
                                    f2 = null;
                                    if (amh.cfh == 0) {
                                        SnsMsgUI.b(this.nYl, true);
                                        BL = new SpannableString(this.nYl.getString(i$j.luck_sns_action_prize_msg));
                                    } else {
                                        SnsMsgUI.b(this.nYl, false);
                                        BL = new SpannableString(" " + this.nYl.getString(i$j.luck_sns_action_msg, new Object[]{bi.A(((double) amh.cfh) / 100.0d)}));
                                        f2 = this.nYl.getResources().getDrawable(i.e.album_push_lucky_money_icon_drawable);
                                    }
                                    if (f2 != null) {
                                        f2.setBounds(0, 0, f2.getIntrinsicWidth(), f2.getIntrinsicHeight());
                                        com.tencent.mm.ui.widget.a aVar3 = new com.tencent.mm.ui.widget.a(f2);
                                        aVar3.uFY = (int) (((((float) f2.getIntrinsicHeight()) - textView2.getTextSize()) + ((float) a.fromDPToPix(this.nYl, 2))) / 2.0f);
                                        BL.setSpan(aVar3, 0, 1, 33);
                                    }
                                    textView2.setText(BL);
                                    break;
                                case 14:
                                    amh amh2 = new amh();
                                    x.i("MicroMsg.SnsMsgUI", "curAction.HBBuffer " + boh.sml);
                                    try {
                                        amh2.aG(com.tencent.mm.platformtools.ab.a(boh.sml));
                                        x.i("MicroMsg.SnsMsgUI", "hbbuffer  " + amh2.cfh);
                                    } catch (Exception e2) {
                                        x.e("MicroMsg.SnsMsgUI", "parser hbbuffer " + e2.getMessage());
                                    }
                                    Yg = SnsMsgUI.r(this.nYl).Yg(boh.seC);
                                    textView2.setText(this.nYl.getString(i$j.luck_grab_sns_action_msg, new Object[]{Yg.BL(), bi.A(((double) amh2.cfh) / 100.0d)}));
                                    break;
                            }
                        }
                        textView2.setText(i$j.sns_msg_has_del);
                        textView2.setBackgroundColor(this.nYl.getResources().getColor(i.c.comment_msg_del));
                        textView2.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
                        aVar.hrV.setText(az.k(this.nYl, ((long) boh.lOH) * 1000));
                        fi = null;
                        if (boh.hcE != 7 || boh.hcE == 8) {
                            eZ = af.byr().eZ(jVar.field_snsID);
                            if (eZ != null) {
                                fi = eZ.bAL();
                            }
                            nVar = fi;
                        } else {
                            nVar = af.byo().fi(jVar.field_snsID);
                        }
                        aVar.nYv.setVisibility(8);
                        aVar.nYs.setVisibility(8);
                        aVar.nYw.setVisibility(8);
                        aVar.nYv.setImageBitmap(null);
                        af.byl().cz(aVar.nYv);
                        if (nVar == null) {
                            List list = nVar.bAJ().sqc.ruA;
                            if (nVar.field_type == 2) {
                                aVar.nYv.setTag(null);
                                aVar.nYs.setVisibility(0);
                                aVar.nYs.setText(com.tencent.mm.pluginsdk.ui.d.j.a(this.nYl, nVar.bAJ().spZ, aVar.nYs.getTextSize()));
                            } else {
                                int i3;
                                MMImageView mMImageView;
                                obj2 = null;
                                if (list.size() > 0) {
                                    i3 = nVar.field_type;
                                    mMImageView = aVar.nYv;
                                    int i4 = -1;
                                    switch (i3) {
                                        case 1:
                                            i4 = i.e.app_attach_file_icon_pic;
                                            break;
                                        case 2:
                                            mMImageView.setImageDrawable(null);
                                            break;
                                        case 3:
                                            i4 = i$i.app_attach_file_icon_webpage;
                                            break;
                                        case 4:
                                            i4 = i$i.app_attach_file_icon_music;
                                            break;
                                        case 5:
                                            i4 = i$i.app_attach_file_icon_video;
                                            break;
                                        case 6:
                                            i4 = i$i.app_attach_file_icon_location;
                                            break;
                                        case 7:
                                            i4 = i.e.app_attach_file_icon_pic;
                                            break;
                                        case 8:
                                            mMImageView.setImageDrawable(null);
                                            break;
                                        default:
                                            i4 = i$i.app_attach_file_icon_webpage;
                                            break;
                                    }
                                    af.byl().b((ate) list.get(0), aVar.nYv, i4, this.nYl.hashCode(), av.tbs);
                                    if (nVar.field_type == 15 || (nVar.field_type == 27 && list.size() > 0 && ((ate) list.get(0)).hcE == 6)) {
                                        aVar.nYw.setVisibility(0);
                                        j jVar2 = new j();
                                        af.byt().b(jVar.sKx, jVar2);
                                        aVar.nYv.setTag(jVar2);
                                        obj2 = 1;
                                    } else {
                                        ap apVar = new ap();
                                        apVar.bNH = nVar.bBe();
                                        apVar.index = 0;
                                        List arrayList = new ArrayList();
                                        arrayList.add(aVar.nYv);
                                        apVar.nWx = arrayList;
                                        apVar.position = i;
                                        aVar.nYv.setTag(apVar);
                                        i3 = 1;
                                    }
                                }
                                mMImageView = aVar.nYv;
                                if (obj2 != null) {
                                    i3 = 0;
                                } else {
                                    i3 = 8;
                                }
                                mMImageView.setVisibility(i3);
                            }
                        } else if (!(boh.hcE == 7 || boh.hcE == 8 || !q.eK(jVar.field_snsID))) {
                            com.tencent.mm.kernel.g.Ek();
                            com.tencent.mm.kernel.g.Eh().dpP.a(new q(jVar.field_snsID), 0);
                        }
                    } catch (Throwable e3) {
                        x.printErrStackTrace("MicroMsg.SnsMsgUI", e3, "", new Object[0]);
                    }
                    obj2 = (aVar.nYv.getVisibility() != 0 || aVar.nYw.getVisibility() == 0) ? 1 : null;
                    view.findViewById(i$f.sns_msg_media_parent).setVisibility(obj2 == null ? 0 : 8);
                    view.findViewById(i$f.sns_silence_icon).setVisibility(jVar.field_isSilence != 1 ? 0 : 8);
                    return view;
                }
                ab Yg2 = SnsMsgUI.r(this.nYl).Yg(str2);
                if (!(Yg2 == null || bi.oW(Yg2.BL()))) {
                    str2 = Yg2.BL();
                }
                str = str2;
                if (bi.oW(boh.seC)) {
                    x.e("MicroMsg.SnsMsgUI", "action.getFromUsername() is null or Nil");
                } else {
                    b.a(aVar.nYr, boh.seC);
                    aVar.nYr.setOnClickListener(new 3(this, boh.seC));
                }
                Yg = SnsMsgUI.r(this.nYl).Yg(boh.seC);
                if (Yg == null) {
                    BL = Yg.BL();
                } else if (bi.oW(boh.sme)) {
                    BL = boh.seC;
                } else {
                    BL = boh.sme;
                }
                aVar.lWV.setText(com.tencent.mm.pluginsdk.ui.d.j.a(this.nYl, BL, aVar.lWV.getTextSize()));
                fi = af.byo().fi(jVar.field_snsID);
                if (fi == null) {
                }
                aVar.lWV.setTextColor(this.nYl.getResources().getColor(i.c.sns_link_color));
                str3 = boh.seC;
                textView = aVar.lWV;
                i2 = boh.rdq;
                switch (jVar.field_type) {
                    case 1:
                    case 2:
                        obj = null;
                        break;
                    case 3:
                    case 5:
                        obj = 1;
                        break;
                    case 4:
                        obj = null;
                        break;
                    case 7:
                    case 8:
                    case 13:
                    case 14:
                        obj = null;
                        break;
                    default:
                        obj = 1;
                        break;
                }
                if (obj != null) {
                }
                textView.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
                textView2 = aVar.nYu;
                j = jVar.field_snsID;
                if ((jVar.field_commentflag & 1) <= 0) {
                }
                if (((jVar.field_commentflag & 1) <= 0 ? 1 : null) == null) {
                    textView2.setTextColor(this.nYl.getResources().getColor(i.c.black));
                    textView2.setBackgroundDrawable(null);
                    textView2.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
                    textView2.setText("");
                    textView2.setCompoundDrawablePadding(0);
                    Drawable f22;
                    String str42;
                    e eZ22;
                    switch (boh.hcE) {
                        case 1:
                        case 5:
                            fi = af.byo().fi(jVar.field_snsID);
                            if (fi == null || fi.field_type != 7) {
                                f22 = a.f(this.context, i$i.friendactivity_likeicon);
                                if (fi == null || fi.field_type != 21) {
                                    f22.clearColorFilter();
                                } else {
                                    f22.setColorFilter(this.nYl.getResources().getColor(i.c.sns_lucky_msg_color), Mode.SRC_ATOP);
                                }
                                f22.setBounds(0, 0, f22.getIntrinsicWidth(), f22.getIntrinsicHeight());
                                BL = new SpannableString(" ");
                                BL.setSpan(new ImageSpan(f22), 0, 1, 18);
                                textView2.setText(BL);
                                textView2.setContentDescription(this.nYl.mController.tml.getString(i$j.sns_friend_like));
                                break;
                            }
                            textView2.setText(this.nYl.getString(i$j.sns_like_background));
                            break;
                        case 2:
                        case 3:
                            str42 = boh.jSA;
                            str2 = "";
                            eZ22 = af.byr().eZ(jVar.field_snsID);
                            if (boh.smm == 1) {
                                if (eZ22 != null) {
                                    com.tencent.mm.kernel.g.Ek();
                                    Yg = ((com.tencent.mm.plugin.messenger.foundation.a.i) com.tencent.mm.kernel.g.l(com.tencent.mm.plugin.messenger.foundation.a.i.class)).FR().Ye(eZ22.field_userName);
                                    str2 = this.context.getString(i$j.sns_msgui_at, new Object[]{Yg.BL()});
                                }
                            } else if (!bi.oW(str)) {
                                str2 = this.context.getString(i$j.sns_msgui_reply, new Object[]{str});
                            }
                            textView2.setText(com.tencent.mm.pluginsdk.ui.d.j.a(this.nYl, str2 + str42 + " ", textView2.getTextSize()));
                            break;
                        case 4:
                            textView2.setText(this.nYl.getString(i$j.sns_timeline_ui_with_you));
                            break;
                        case 7:
                            textView2.setCompoundDrawablesWithIntrinsicBounds(a.f(this.context, i$i.friendactivity_likeicon), null, null, null);
                            textView2.setContentDescription(this.nYl.mController.tml.getString(i$j.sns_friend_like));
                            break;
                        case 8:
                            str2 = "";
                            str42 = boh.jSA;
                            eZ22 = af.byr().eZ(jVar.field_snsID);
                            if (boh.smm == 1) {
                                if (eZ22 != null) {
                                    com.tencent.mm.kernel.g.Ek();
                                    Yg = ((com.tencent.mm.plugin.messenger.foundation.a.i) com.tencent.mm.kernel.g.l(com.tencent.mm.plugin.messenger.foundation.a.i.class)).FR().Ye(eZ22.field_userName);
                                    str2 = this.context.getString(i$j.sns_msgui_at, new Object[]{Yg.BL()});
                                }
                            } else if (!bi.oW(str)) {
                                str2 = this.context.getString(i$j.sns_msgui_reply, new Object[]{str});
                            }
                            textView2.setText(com.tencent.mm.pluginsdk.ui.d.j.a(this.nYl, str2 + str42 + " ", textView2.getTextSize()));
                            break;
                        case 13:
                            amh amh3 = new amh();
                            x.i("MicroMsg.SnsMsgUI", "curAction.HBBuffer " + boh.sml);
                            try {
                                amh3.aG(com.tencent.mm.platformtools.ab.a(boh.sml));
                                x.i("MicroMsg.SnsMsgUI", "hbbuffer  " + amh3.cfh);
                            } catch (Exception e22) {
                                x.e("MicroMsg.SnsMsgUI", "parser hbbuffer " + e22.getMessage());
                            }
                            SnsMsgUI.r(this.nYl).Yg(boh.seC);
                            f22 = null;
                            if (amh3.cfh == 0) {
                                SnsMsgUI.b(this.nYl, true);
                                BL = new SpannableString(this.nYl.getString(i$j.luck_sns_action_prize_msg));
                            } else {
                                SnsMsgUI.b(this.nYl, false);
                                BL = new SpannableString(" " + this.nYl.getString(i$j.luck_sns_action_msg, new Object[]{bi.A(((double) amh3.cfh) / 100.0d)}));
                                f22 = this.nYl.getResources().getDrawable(i.e.album_push_lucky_money_icon_drawable);
                            }
                            if (f22 != null) {
                                f22.setBounds(0, 0, f22.getIntrinsicWidth(), f22.getIntrinsicHeight());
                                com.tencent.mm.ui.widget.a aVar32 = new com.tencent.mm.ui.widget.a(f22);
                                aVar32.uFY = (int) (((((float) f22.getIntrinsicHeight()) - textView2.getTextSize()) + ((float) a.fromDPToPix(this.nYl, 2))) / 2.0f);
                                BL.setSpan(aVar32, 0, 1, 33);
                            }
                            textView2.setText(BL);
                            break;
                        case 14:
                            amh amh22 = new amh();
                            x.i("MicroMsg.SnsMsgUI", "curAction.HBBuffer " + boh.sml);
                            try {
                                amh22.aG(com.tencent.mm.platformtools.ab.a(boh.sml));
                                x.i("MicroMsg.SnsMsgUI", "hbbuffer  " + amh22.cfh);
                            } catch (Exception e222) {
                                x.e("MicroMsg.SnsMsgUI", "parser hbbuffer " + e222.getMessage());
                            }
                            Yg = SnsMsgUI.r(this.nYl).Yg(boh.seC);
                            textView2.setText(this.nYl.getString(i$j.luck_grab_sns_action_msg, new Object[]{Yg.BL(), bi.A(((double) amh22.cfh) / 100.0d)}));
                            break;
                    }
                }
                textView2.setText(i$j.sns_msg_has_del);
                textView2.setBackgroundColor(this.nYl.getResources().getColor(i.c.comment_msg_del));
                textView2.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
                aVar.hrV.setText(az.k(this.nYl, ((long) boh.lOH) * 1000));
                fi = null;
                if (boh.hcE != 7) {
                }
                eZ = af.byr().eZ(jVar.field_snsID);
                if (eZ != null) {
                    fi = eZ.bAL();
                }
                nVar = fi;
                aVar.nYv.setVisibility(8);
                aVar.nYs.setVisibility(8);
                aVar.nYw.setVisibility(8);
                aVar.nYv.setImageBitmap(null);
                af.byl().cz(aVar.nYv);
                if (nVar == null) {
                    List list2 = nVar.bAJ().sqc.ruA;
                    if (nVar.field_type == 2) {
                        aVar.nYv.setTag(null);
                        aVar.nYs.setVisibility(0);
                        aVar.nYs.setText(com.tencent.mm.pluginsdk.ui.d.j.a(this.nYl, nVar.bAJ().spZ, aVar.nYs.getTextSize()));
                    } else {
                        int i32;
                        MMImageView mMImageView2;
                        obj2 = null;
                        if (list2.size() > 0) {
                            i32 = nVar.field_type;
                            mMImageView2 = aVar.nYv;
                            int i42 = -1;
                            switch (i32) {
                                case 1:
                                    i42 = i.e.app_attach_file_icon_pic;
                                    break;
                                case 2:
                                    mMImageView2.setImageDrawable(null);
                                    break;
                                case 3:
                                    i42 = i$i.app_attach_file_icon_webpage;
                                    break;
                                case 4:
                                    i42 = i$i.app_attach_file_icon_music;
                                    break;
                                case 5:
                                    i42 = i$i.app_attach_file_icon_video;
                                    break;
                                case 6:
                                    i42 = i$i.app_attach_file_icon_location;
                                    break;
                                case 7:
                                    i42 = i.e.app_attach_file_icon_pic;
                                    break;
                                case 8:
                                    mMImageView2.setImageDrawable(null);
                                    break;
                                default:
                                    i42 = i$i.app_attach_file_icon_webpage;
                                    break;
                            }
                            af.byl().b((ate) list2.get(0), aVar.nYv, i42, this.nYl.hashCode(), av.tbs);
                            if (nVar.field_type == 15 || (nVar.field_type == 27 && list2.size() > 0 && ((ate) list2.get(0)).hcE == 6)) {
                                aVar.nYw.setVisibility(0);
                                j jVar22 = new j();
                                af.byt().b(jVar.sKx, jVar22);
                                aVar.nYv.setTag(jVar22);
                                obj2 = 1;
                            } else {
                                ap apVar2 = new ap();
                                apVar2.bNH = nVar.bBe();
                                apVar2.index = 0;
                                List arrayList2 = new ArrayList();
                                arrayList2.add(aVar.nYv);
                                apVar2.nWx = arrayList2;
                                apVar2.position = i;
                                aVar.nYv.setTag(apVar2);
                                i32 = 1;
                            }
                        }
                        mMImageView2 = aVar.nYv;
                        if (obj2 != null) {
                            i32 = 0;
                        } else {
                            i32 = 8;
                        }
                        mMImageView2.setVisibility(i32);
                    }
                } else if (!(boh.hcE == 7 || boh.hcE == 8 || !q.eK(jVar.field_snsID))) {
                    com.tencent.mm.kernel.g.Ek();
                    com.tencent.mm.kernel.g.Eh().dpP.a(new q(jVar.field_snsID), 0);
                }
                if (aVar.nYv.getVisibility() != 0) {
                }
                if (obj2 == null) {
                }
                view.findViewById(i$f.sns_msg_media_parent).setVisibility(obj2 == null ? 0 : 8);
                if (jVar.field_isSilence != 1) {
                }
                view.findViewById(i$f.sns_silence_icon).setVisibility(jVar.field_isSilence != 1 ? 0 : 8);
                return view;
            } catch (Exception e4) {
                str = str2;
                if (bi.oW(boh.seC)) {
                    x.e("MicroMsg.SnsMsgUI", "action.getFromUsername() is null or Nil");
                } else {
                    b.a(aVar.nYr, boh.seC);
                    aVar.nYr.setOnClickListener(new 3(this, boh.seC));
                }
                Yg = SnsMsgUI.r(this.nYl).Yg(boh.seC);
                if (Yg == null) {
                    BL = Yg.BL();
                } else if (bi.oW(boh.sme)) {
                    BL = boh.seC;
                } else {
                    BL = boh.sme;
                }
                aVar.lWV.setText(com.tencent.mm.pluginsdk.ui.d.j.a(this.nYl, BL, aVar.lWV.getTextSize()));
                fi = af.byo().fi(jVar.field_snsID);
                if (fi == null) {
                }
                aVar.lWV.setTextColor(this.nYl.getResources().getColor(i.c.sns_link_color));
                str3 = boh.seC;
                textView = aVar.lWV;
                i2 = boh.rdq;
                switch (jVar.field_type) {
                    case 1:
                    case 2:
                        obj = null;
                        break;
                    case 3:
                    case 5:
                        obj = 1;
                        break;
                    case 4:
                        obj = null;
                        break;
                    case 7:
                    case 8:
                    case 13:
                    case 14:
                        obj = null;
                        break;
                    default:
                        obj = 1;
                        break;
                }
                if (obj != null) {
                }
                textView.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
                textView2 = aVar.nYu;
                j = jVar.field_snsID;
                if ((jVar.field_commentflag & 1) <= 0) {
                }
                if (((jVar.field_commentflag & 1) <= 0 ? 1 : null) == null) {
                    textView2.setTextColor(this.nYl.getResources().getColor(i.c.black));
                    textView2.setBackgroundDrawable(null);
                    textView2.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
                    textView2.setText("");
                    textView2.setCompoundDrawablePadding(0);
                    Drawable f222;
                    String str422;
                    e eZ222;
                    switch (boh.hcE) {
                        case 1:
                        case 5:
                            fi = af.byo().fi(jVar.field_snsID);
                            if (fi == null || fi.field_type != 7) {
                                f222 = a.f(this.context, i$i.friendactivity_likeicon);
                                if (fi == null || fi.field_type != 21) {
                                    f222.clearColorFilter();
                                } else {
                                    f222.setColorFilter(this.nYl.getResources().getColor(i.c.sns_lucky_msg_color), Mode.SRC_ATOP);
                                }
                                f222.setBounds(0, 0, f222.getIntrinsicWidth(), f222.getIntrinsicHeight());
                                BL = new SpannableString(" ");
                                BL.setSpan(new ImageSpan(f222), 0, 1, 18);
                                textView2.setText(BL);
                                textView2.setContentDescription(this.nYl.mController.tml.getString(i$j.sns_friend_like));
                                break;
                            }
                            textView2.setText(this.nYl.getString(i$j.sns_like_background));
                            break;
                        case 2:
                        case 3:
                            str422 = boh.jSA;
                            str2 = "";
                            eZ222 = af.byr().eZ(jVar.field_snsID);
                            if (boh.smm == 1) {
                                if (eZ222 != null) {
                                    com.tencent.mm.kernel.g.Ek();
                                    Yg = ((com.tencent.mm.plugin.messenger.foundation.a.i) com.tencent.mm.kernel.g.l(com.tencent.mm.plugin.messenger.foundation.a.i.class)).FR().Ye(eZ222.field_userName);
                                    str2 = this.context.getString(i$j.sns_msgui_at, new Object[]{Yg.BL()});
                                }
                            } else if (!bi.oW(str)) {
                                str2 = this.context.getString(i$j.sns_msgui_reply, new Object[]{str});
                            }
                            textView2.setText(com.tencent.mm.pluginsdk.ui.d.j.a(this.nYl, str2 + str422 + " ", textView2.getTextSize()));
                            break;
                        case 4:
                            textView2.setText(this.nYl.getString(i$j.sns_timeline_ui_with_you));
                            break;
                        case 7:
                            textView2.setCompoundDrawablesWithIntrinsicBounds(a.f(this.context, i$i.friendactivity_likeicon), null, null, null);
                            textView2.setContentDescription(this.nYl.mController.tml.getString(i$j.sns_friend_like));
                            break;
                        case 8:
                            str2 = "";
                            str422 = boh.jSA;
                            eZ222 = af.byr().eZ(jVar.field_snsID);
                            if (boh.smm == 1) {
                                if (eZ222 != null) {
                                    com.tencent.mm.kernel.g.Ek();
                                    Yg = ((com.tencent.mm.plugin.messenger.foundation.a.i) com.tencent.mm.kernel.g.l(com.tencent.mm.plugin.messenger.foundation.a.i.class)).FR().Ye(eZ222.field_userName);
                                    str2 = this.context.getString(i$j.sns_msgui_at, new Object[]{Yg.BL()});
                                }
                            } else if (!bi.oW(str)) {
                                str2 = this.context.getString(i$j.sns_msgui_reply, new Object[]{str});
                            }
                            textView2.setText(com.tencent.mm.pluginsdk.ui.d.j.a(this.nYl, str2 + str422 + " ", textView2.getTextSize()));
                            break;
                        case 13:
                            amh amh32 = new amh();
                            x.i("MicroMsg.SnsMsgUI", "curAction.HBBuffer " + boh.sml);
                            try {
                                amh32.aG(com.tencent.mm.platformtools.ab.a(boh.sml));
                                x.i("MicroMsg.SnsMsgUI", "hbbuffer  " + amh32.cfh);
                            } catch (Exception e2222) {
                                x.e("MicroMsg.SnsMsgUI", "parser hbbuffer " + e2222.getMessage());
                            }
                            SnsMsgUI.r(this.nYl).Yg(boh.seC);
                            f222 = null;
                            if (amh32.cfh == 0) {
                                SnsMsgUI.b(this.nYl, true);
                                BL = new SpannableString(this.nYl.getString(i$j.luck_sns_action_prize_msg));
                            } else {
                                SnsMsgUI.b(this.nYl, false);
                                BL = new SpannableString(" " + this.nYl.getString(i$j.luck_sns_action_msg, new Object[]{bi.A(((double) amh32.cfh) / 100.0d)}));
                                f222 = this.nYl.getResources().getDrawable(i.e.album_push_lucky_money_icon_drawable);
                            }
                            if (f222 != null) {
                                f222.setBounds(0, 0, f222.getIntrinsicWidth(), f222.getIntrinsicHeight());
                                com.tencent.mm.ui.widget.a aVar322 = new com.tencent.mm.ui.widget.a(f222);
                                aVar322.uFY = (int) (((((float) f222.getIntrinsicHeight()) - textView2.getTextSize()) + ((float) a.fromDPToPix(this.nYl, 2))) / 2.0f);
                                BL.setSpan(aVar322, 0, 1, 33);
                            }
                            textView2.setText(BL);
                            break;
                        case 14:
                            amh amh222 = new amh();
                            x.i("MicroMsg.SnsMsgUI", "curAction.HBBuffer " + boh.sml);
                            try {
                                amh222.aG(com.tencent.mm.platformtools.ab.a(boh.sml));
                                x.i("MicroMsg.SnsMsgUI", "hbbuffer  " + amh222.cfh);
                            } catch (Exception e22222) {
                                x.e("MicroMsg.SnsMsgUI", "parser hbbuffer " + e22222.getMessage());
                            }
                            Yg = SnsMsgUI.r(this.nYl).Yg(boh.seC);
                            textView2.setText(this.nYl.getString(i$j.luck_grab_sns_action_msg, new Object[]{Yg.BL(), bi.A(((double) amh222.cfh) / 100.0d)}));
                            break;
                    }
                }
                textView2.setText(i$j.sns_msg_has_del);
                textView2.setBackgroundColor(this.nYl.getResources().getColor(i.c.comment_msg_del));
                textView2.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
                aVar.hrV.setText(az.k(this.nYl, ((long) boh.lOH) * 1000));
                fi = null;
                if (boh.hcE != 7) {
                }
                eZ = af.byr().eZ(jVar.field_snsID);
                if (eZ != null) {
                    fi = eZ.bAL();
                }
                nVar = fi;
                aVar.nYv.setVisibility(8);
                aVar.nYs.setVisibility(8);
                aVar.nYw.setVisibility(8);
                aVar.nYv.setImageBitmap(null);
                af.byl().cz(aVar.nYv);
                if (nVar == null) {
                    List list22 = nVar.bAJ().sqc.ruA;
                    if (nVar.field_type == 2) {
                        aVar.nYv.setTag(null);
                        aVar.nYs.setVisibility(0);
                        aVar.nYs.setText(com.tencent.mm.pluginsdk.ui.d.j.a(this.nYl, nVar.bAJ().spZ, aVar.nYs.getTextSize()));
                    } else {
                        int i322;
                        MMImageView mMImageView22;
                        obj2 = null;
                        if (list22.size() > 0) {
                            i322 = nVar.field_type;
                            mMImageView22 = aVar.nYv;
                            int i422 = -1;
                            switch (i322) {
                                case 1:
                                    i422 = i.e.app_attach_file_icon_pic;
                                    break;
                                case 2:
                                    mMImageView22.setImageDrawable(null);
                                    break;
                                case 3:
                                    i422 = i$i.app_attach_file_icon_webpage;
                                    break;
                                case 4:
                                    i422 = i$i.app_attach_file_icon_music;
                                    break;
                                case 5:
                                    i422 = i$i.app_attach_file_icon_video;
                                    break;
                                case 6:
                                    i422 = i$i.app_attach_file_icon_location;
                                    break;
                                case 7:
                                    i422 = i.e.app_attach_file_icon_pic;
                                    break;
                                case 8:
                                    mMImageView22.setImageDrawable(null);
                                    break;
                                default:
                                    i422 = i$i.app_attach_file_icon_webpage;
                                    break;
                            }
                            af.byl().b((ate) list22.get(0), aVar.nYv, i422, this.nYl.hashCode(), av.tbs);
                            if (nVar.field_type == 15 || (nVar.field_type == 27 && list22.size() > 0 && ((ate) list22.get(0)).hcE == 6)) {
                                aVar.nYw.setVisibility(0);
                                j jVar222 = new j();
                                af.byt().b(jVar.sKx, jVar222);
                                aVar.nYv.setTag(jVar222);
                                obj2 = 1;
                            } else {
                                ap apVar22 = new ap();
                                apVar22.bNH = nVar.bBe();
                                apVar22.index = 0;
                                List arrayList22 = new ArrayList();
                                arrayList22.add(aVar.nYv);
                                apVar22.nWx = arrayList22;
                                apVar22.position = i;
                                aVar.nYv.setTag(apVar22);
                                i322 = 1;
                            }
                        }
                        mMImageView22 = aVar.nYv;
                        if (obj2 != null) {
                            i322 = 0;
                        } else {
                            i322 = 8;
                        }
                        mMImageView22.setVisibility(i322);
                    }
                } else if (!(boh.hcE == 7 || boh.hcE == 8 || !q.eK(jVar.field_snsID))) {
                    com.tencent.mm.kernel.g.Ek();
                    com.tencent.mm.kernel.g.Eh().dpP.a(new q(jVar.field_snsID), 0);
                }
                if (aVar.nYv.getVisibility() != 0) {
                }
                if (obj2 == null) {
                }
                view.findViewById(i$f.sns_msg_media_parent).setVisibility(obj2 == null ? 0 : 8);
                if (jVar.field_isSilence != 1) {
                }
                view.findViewById(i$f.sns_silence_icon).setVisibility(jVar.field_isSilence != 1 ? 0 : 8);
                return view;
            }
        } catch (Exception e5) {
            str2 = str;
            str = str2;
            if (bi.oW(boh.seC)) {
                b.a(aVar.nYr, boh.seC);
                aVar.nYr.setOnClickListener(new 3(this, boh.seC));
            } else {
                x.e("MicroMsg.SnsMsgUI", "action.getFromUsername() is null or Nil");
            }
            Yg = SnsMsgUI.r(this.nYl).Yg(boh.seC);
            if (Yg == null) {
                BL = Yg.BL();
            } else if (bi.oW(boh.sme)) {
                BL = boh.seC;
            } else {
                BL = boh.sme;
            }
            aVar.lWV.setText(com.tencent.mm.pluginsdk.ui.d.j.a(this.nYl, BL, aVar.lWV.getTextSize()));
            fi = af.byo().fi(jVar.field_snsID);
            if (fi == null) {
            }
            aVar.lWV.setTextColor(this.nYl.getResources().getColor(i.c.sns_link_color));
            str3 = boh.seC;
            textView = aVar.lWV;
            i2 = boh.rdq;
            switch (jVar.field_type) {
                case 1:
                case 2:
                    obj = null;
                    break;
                case 3:
                case 5:
                    obj = 1;
                    break;
                case 4:
                    obj = null;
                    break;
                case 7:
                case 8:
                case 13:
                case 14:
                    obj = null;
                    break;
                default:
                    obj = 1;
                    break;
            }
            if (obj != null) {
            }
            textView.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
            textView2 = aVar.nYu;
            j = jVar.field_snsID;
            if ((jVar.field_commentflag & 1) <= 0) {
            }
            if (((jVar.field_commentflag & 1) <= 0 ? 1 : null) == null) {
                textView2.setTextColor(this.nYl.getResources().getColor(i.c.black));
                textView2.setBackgroundDrawable(null);
                textView2.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
                textView2.setText("");
                textView2.setCompoundDrawablePadding(0);
                Drawable f2222;
                String str4222;
                e eZ2222;
                switch (boh.hcE) {
                    case 1:
                    case 5:
                        fi = af.byo().fi(jVar.field_snsID);
                        if (fi == null || fi.field_type != 7) {
                            f2222 = a.f(this.context, i$i.friendactivity_likeicon);
                            if (fi == null || fi.field_type != 21) {
                                f2222.clearColorFilter();
                            } else {
                                f2222.setColorFilter(this.nYl.getResources().getColor(i.c.sns_lucky_msg_color), Mode.SRC_ATOP);
                            }
                            f2222.setBounds(0, 0, f2222.getIntrinsicWidth(), f2222.getIntrinsicHeight());
                            BL = new SpannableString(" ");
                            BL.setSpan(new ImageSpan(f2222), 0, 1, 18);
                            textView2.setText(BL);
                            textView2.setContentDescription(this.nYl.mController.tml.getString(i$j.sns_friend_like));
                            break;
                        }
                        textView2.setText(this.nYl.getString(i$j.sns_like_background));
                        break;
                    case 2:
                    case 3:
                        str4222 = boh.jSA;
                        str2 = "";
                        eZ2222 = af.byr().eZ(jVar.field_snsID);
                        if (boh.smm == 1) {
                            if (eZ2222 != null) {
                                com.tencent.mm.kernel.g.Ek();
                                Yg = ((com.tencent.mm.plugin.messenger.foundation.a.i) com.tencent.mm.kernel.g.l(com.tencent.mm.plugin.messenger.foundation.a.i.class)).FR().Ye(eZ2222.field_userName);
                                str2 = this.context.getString(i$j.sns_msgui_at, new Object[]{Yg.BL()});
                            }
                        } else if (!bi.oW(str)) {
                            str2 = this.context.getString(i$j.sns_msgui_reply, new Object[]{str});
                        }
                        textView2.setText(com.tencent.mm.pluginsdk.ui.d.j.a(this.nYl, str2 + str4222 + " ", textView2.getTextSize()));
                        break;
                    case 4:
                        textView2.setText(this.nYl.getString(i$j.sns_timeline_ui_with_you));
                        break;
                    case 7:
                        textView2.setCompoundDrawablesWithIntrinsicBounds(a.f(this.context, i$i.friendactivity_likeicon), null, null, null);
                        textView2.setContentDescription(this.nYl.mController.tml.getString(i$j.sns_friend_like));
                        break;
                    case 8:
                        str2 = "";
                        str4222 = boh.jSA;
                        eZ2222 = af.byr().eZ(jVar.field_snsID);
                        if (boh.smm == 1) {
                            if (eZ2222 != null) {
                                com.tencent.mm.kernel.g.Ek();
                                Yg = ((com.tencent.mm.plugin.messenger.foundation.a.i) com.tencent.mm.kernel.g.l(com.tencent.mm.plugin.messenger.foundation.a.i.class)).FR().Ye(eZ2222.field_userName);
                                str2 = this.context.getString(i$j.sns_msgui_at, new Object[]{Yg.BL()});
                            }
                        } else if (!bi.oW(str)) {
                            str2 = this.context.getString(i$j.sns_msgui_reply, new Object[]{str});
                        }
                        textView2.setText(com.tencent.mm.pluginsdk.ui.d.j.a(this.nYl, str2 + str4222 + " ", textView2.getTextSize()));
                        break;
                    case 13:
                        amh amh322 = new amh();
                        x.i("MicroMsg.SnsMsgUI", "curAction.HBBuffer " + boh.sml);
                        try {
                            amh322.aG(com.tencent.mm.platformtools.ab.a(boh.sml));
                            x.i("MicroMsg.SnsMsgUI", "hbbuffer  " + amh322.cfh);
                        } catch (Exception e222222) {
                            x.e("MicroMsg.SnsMsgUI", "parser hbbuffer " + e222222.getMessage());
                        }
                        SnsMsgUI.r(this.nYl).Yg(boh.seC);
                        f2222 = null;
                        if (amh322.cfh == 0) {
                            SnsMsgUI.b(this.nYl, true);
                            BL = new SpannableString(this.nYl.getString(i$j.luck_sns_action_prize_msg));
                        } else {
                            SnsMsgUI.b(this.nYl, false);
                            BL = new SpannableString(" " + this.nYl.getString(i$j.luck_sns_action_msg, new Object[]{bi.A(((double) amh322.cfh) / 100.0d)}));
                            f2222 = this.nYl.getResources().getDrawable(i.e.album_push_lucky_money_icon_drawable);
                        }
                        if (f2222 != null) {
                            f2222.setBounds(0, 0, f2222.getIntrinsicWidth(), f2222.getIntrinsicHeight());
                            com.tencent.mm.ui.widget.a aVar3222 = new com.tencent.mm.ui.widget.a(f2222);
                            aVar3222.uFY = (int) (((((float) f2222.getIntrinsicHeight()) - textView2.getTextSize()) + ((float) a.fromDPToPix(this.nYl, 2))) / 2.0f);
                            BL.setSpan(aVar3222, 0, 1, 33);
                        }
                        textView2.setText(BL);
                        break;
                    case 14:
                        amh amh2222 = new amh();
                        x.i("MicroMsg.SnsMsgUI", "curAction.HBBuffer " + boh.sml);
                        try {
                            amh2222.aG(com.tencent.mm.platformtools.ab.a(boh.sml));
                            x.i("MicroMsg.SnsMsgUI", "hbbuffer  " + amh2222.cfh);
                        } catch (Exception e2222222) {
                            x.e("MicroMsg.SnsMsgUI", "parser hbbuffer " + e2222222.getMessage());
                        }
                        Yg = SnsMsgUI.r(this.nYl).Yg(boh.seC);
                        textView2.setText(this.nYl.getString(i$j.luck_grab_sns_action_msg, new Object[]{Yg.BL(), bi.A(((double) amh2222.cfh) / 100.0d)}));
                        break;
                }
            }
            textView2.setText(i$j.sns_msg_has_del);
            textView2.setBackgroundColor(this.nYl.getResources().getColor(i.c.comment_msg_del));
            textView2.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
            aVar.hrV.setText(az.k(this.nYl, ((long) boh.lOH) * 1000));
            fi = null;
            if (boh.hcE != 7) {
            }
            eZ = af.byr().eZ(jVar.field_snsID);
            if (eZ != null) {
                fi = eZ.bAL();
            }
            nVar = fi;
            aVar.nYv.setVisibility(8);
            aVar.nYs.setVisibility(8);
            aVar.nYw.setVisibility(8);
            aVar.nYv.setImageBitmap(null);
            af.byl().cz(aVar.nYv);
            if (nVar == null) {
                List list222 = nVar.bAJ().sqc.ruA;
                if (nVar.field_type == 2) {
                    aVar.nYv.setTag(null);
                    aVar.nYs.setVisibility(0);
                    aVar.nYs.setText(com.tencent.mm.pluginsdk.ui.d.j.a(this.nYl, nVar.bAJ().spZ, aVar.nYs.getTextSize()));
                } else {
                    int i3222;
                    MMImageView mMImageView222;
                    obj2 = null;
                    if (list222.size() > 0) {
                        i3222 = nVar.field_type;
                        mMImageView222 = aVar.nYv;
                        int i4222 = -1;
                        switch (i3222) {
                            case 1:
                                i4222 = i.e.app_attach_file_icon_pic;
                                break;
                            case 2:
                                mMImageView222.setImageDrawable(null);
                                break;
                            case 3:
                                i4222 = i$i.app_attach_file_icon_webpage;
                                break;
                            case 4:
                                i4222 = i$i.app_attach_file_icon_music;
                                break;
                            case 5:
                                i4222 = i$i.app_attach_file_icon_video;
                                break;
                            case 6:
                                i4222 = i$i.app_attach_file_icon_location;
                                break;
                            case 7:
                                i4222 = i.e.app_attach_file_icon_pic;
                                break;
                            case 8:
                                mMImageView222.setImageDrawable(null);
                                break;
                            default:
                                i4222 = i$i.app_attach_file_icon_webpage;
                                break;
                        }
                        af.byl().b((ate) list222.get(0), aVar.nYv, i4222, this.nYl.hashCode(), av.tbs);
                        if (nVar.field_type == 15 || (nVar.field_type == 27 && list222.size() > 0 && ((ate) list222.get(0)).hcE == 6)) {
                            aVar.nYw.setVisibility(0);
                            j jVar2222 = new j();
                            af.byt().b(jVar.sKx, jVar2222);
                            aVar.nYv.setTag(jVar2222);
                            obj2 = 1;
                        } else {
                            ap apVar222 = new ap();
                            apVar222.bNH = nVar.bBe();
                            apVar222.index = 0;
                            List arrayList222 = new ArrayList();
                            arrayList222.add(aVar.nYv);
                            apVar222.nWx = arrayList222;
                            apVar222.position = i;
                            aVar.nYv.setTag(apVar222);
                            i3222 = 1;
                        }
                    }
                    mMImageView222 = aVar.nYv;
                    if (obj2 != null) {
                        i3222 = 0;
                    } else {
                        i3222 = 8;
                    }
                    mMImageView222.setVisibility(i3222);
                }
            } else if (!(boh.hcE == 7 || boh.hcE == 8 || !q.eK(jVar.field_snsID))) {
                com.tencent.mm.kernel.g.Ek();
                com.tencent.mm.kernel.g.Eh().dpP.a(new q(jVar.field_snsID), 0);
            }
            if (aVar.nYv.getVisibility() != 0) {
            }
            if (obj2 == null) {
            }
            view.findViewById(i$f.sns_msg_media_parent).setVisibility(obj2 == null ? 0 : 8);
            if (jVar.field_isSilence != 1) {
            }
            view.findViewById(i$f.sns_silence_icon).setVisibility(jVar.field_isSilence != 1 ? 0 : 8);
            return view;
        }
    }
}
