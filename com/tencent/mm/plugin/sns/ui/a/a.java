package com.tencent.mm.plugin.sns.ui.a;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.text.Layout;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import android.widget.TextView.BufferType;
import com.tencent.mm.plugin.sns.abtest.c;
import com.tencent.mm.plugin.sns.data.i;
import com.tencent.mm.plugin.sns.i.d;
import com.tencent.mm.plugin.sns.i.e;
import com.tencent.mm.plugin.sns.i.f;
import com.tencent.mm.plugin.sns.i.g;
import com.tencent.mm.plugin.sns.i.j;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.plugin.sns.model.ap;
import com.tencent.mm.plugin.sns.model.ap.b;
import com.tencent.mm.plugin.sns.storage.n;
import com.tencent.mm.plugin.sns.storage.v;
import com.tencent.mm.plugin.sns.ui.AsyncNormalTextView;
import com.tencent.mm.plugin.sns.ui.AsyncTextView;
import com.tencent.mm.plugin.sns.ui.MaskTextView;
import com.tencent.mm.plugin.sns.ui.SnsTranslateResultView;
import com.tencent.mm.plugin.sns.ui.TranslateCommentTextView;
import com.tencent.mm.plugin.sns.ui.ab;
import com.tencent.mm.plugin.sns.ui.as;
import com.tencent.mm.plugin.sns.ui.av;
import com.tencent.mm.plugin.sns.ui.ax;
import com.tencent.mm.plugin.sns.ui.ay;
import com.tencent.mm.plugin.sns.ui.bd;
import com.tencent.mm.plugin.sns.ui.bf;
import com.tencent.mm.plugin.sns.ui.k;
import com.tencent.mm.plugin.sns.ui.widget.SnsCardAdTagListView;
import com.tencent.mm.plugin.sns.ui.widget.SnsCommentPreloadTextView;
import com.tencent.mm.pluginsdk.ui.d.m;
import com.tencent.mm.pluginsdk.ui.d.o;
import com.tencent.mm.protocal.c.atf;
import com.tencent.mm.protocal.c.bon;
import com.tencent.mm.protocal.c.boy;
import com.tencent.mm.protocal.c.bsu;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.tools.MaskImageButton;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public abstract class a {
    public boolean DEBUG = false;
    protected int hER;
    protected Activity mActivity;
    protected boolean nTx = false;
    protected av nuc;
    public ArrayList<b> oiD = new ArrayList();

    public abstract void a(c cVar, int i, ay ayVar, bsu bsu, int i2, av avVar);

    public abstract void c(c cVar);

    public final void setIsFromMainTimeline(boolean z) {
        this.nTx = z;
    }

    private void a(c cVar, n nVar) {
        LayoutParams layoutParams;
        if (!nVar.xb(32)) {
            if (cVar.oiK != null) {
                cVar.oiK.setVisibility(0);
            }
            cVar.oiP.setLongClickable(false);
            cVar.oiP.setOnClickListener(null);
            if (cVar.oji != null) {
                layoutParams = (LayoutParams) cVar.oji.getLayoutParams();
                layoutParams.leftMargin = 0;
                layoutParams.rightMargin = 0;
                cVar.oji.setLayoutParams(layoutParams);
            }
            if (cVar.ojG) {
                layoutParams = (LayoutParams) cVar.ojH.nRB.getLayoutParams();
                layoutParams.leftMargin = 0;
                layoutParams.rightMargin = 0;
                cVar.ojH.nRB.setLayoutParams(layoutParams);
            }
            cVar.oiP.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
            cVar.oiP.setBackgroundColor(Color.parseColor("#00ffffff"));
            if (cVar.oiM != null) {
                cVar.oiM.setVisibility(8);
            }
            if (cVar.oiL != null) {
                cVar.oiL.setVisibility(8);
            }
        } else if (nVar.bAF() == null || nVar.bAF().nzp != 1) {
            if (cVar.oiK != null) {
                cVar.oiK.setVisibility(0);
            }
            cVar.oiP.setLongClickable(false);
            cVar.oiP.setOnClickListener(null);
            cVar.oiP.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
            cVar.oiP.setBackgroundColor(Color.parseColor("#00ffffff"));
            if (cVar.oji != null) {
                layoutParams = (LayoutParams) cVar.oji.getLayoutParams();
                layoutParams.leftMargin = 0;
                layoutParams.rightMargin = 0;
                cVar.oji.setLayoutParams(layoutParams);
            }
            if (cVar.ojG) {
                layoutParams = (LayoutParams) cVar.ojH.nRB.getLayoutParams();
                layoutParams.leftMargin = 0;
                layoutParams.rightMargin = 0;
                cVar.ojH.nRB.setLayoutParams(layoutParams);
            }
            layoutParams = (LayoutParams) cVar.ojZ.getLayoutParams();
            layoutParams.leftMargin = com.tencent.mm.bp.a.fromDPToPix(this.mActivity, 0);
            layoutParams.rightMargin = com.tencent.mm.bp.a.fromDPToPix(this.mActivity, 0);
            cVar.ojZ.setLayoutParams(layoutParams);
            if (cVar.oiM != null) {
                cVar.oiM.setVisibility(8);
            }
            if (cVar.oiL != null) {
                cVar.oiL.setVisibility(8);
            }
        } else {
            if (cVar.oiK != null) {
                cVar.oiK.setVisibility(8);
            }
            cVar.oiP.setTag(cVar);
            cVar.oiP.setOnClickListener(this.nuc.ntw.olb);
            int width = ((WindowManager) this.mActivity.getSystemService("window")).getDefaultDisplay().getWidth();
            if (cVar.oji != null) {
                layoutParams = (LayoutParams) cVar.oji.getLayoutParams();
                layoutParams.leftMargin = com.tencent.mm.bp.a.fromDPToPix(this.mActivity, 10);
                layoutParams.rightMargin = com.tencent.mm.bp.a.fromDPToPix(this.mActivity, 10);
                cVar.oji.setLayoutParams(layoutParams);
            }
            if (cVar.ojG) {
                layoutParams = (LayoutParams) cVar.ojH.nRB.getLayoutParams();
                layoutParams.leftMargin = com.tencent.mm.bp.a.fromDPToPix(this.mActivity, 10);
                layoutParams.rightMargin = com.tencent.mm.bp.a.fromDPToPix(this.mActivity, 10);
                cVar.ojH.nRB.setLayoutParams(layoutParams);
            }
            layoutParams = (LayoutParams) cVar.ojZ.getLayoutParams();
            layoutParams.leftMargin = com.tencent.mm.bp.a.fromDPToPix(this.mActivity, 10);
            layoutParams.rightMargin = com.tencent.mm.bp.a.fromDPToPix(this.mActivity, 10);
            cVar.ojZ.setLayoutParams(layoutParams);
            if (cVar.ojM.sqc.ruz == 27) {
                cVar.oiP.setLayoutParams(new LinearLayout.LayoutParams((((width - com.tencent.mm.bp.a.fromDPToPix(this.mActivity, 50)) - com.tencent.mm.bp.a.fromDPToPix(this.mActivity, 12)) - com.tencent.mm.bp.a.fromDPToPix(this.mActivity, 12)) - com.tencent.mm.bp.a.fromDPToPix(this.mActivity, 8), -2));
                return;
            }
            ViewGroup.LayoutParams layoutParams2 = new LinearLayout.LayoutParams((((width - com.tencent.mm.bp.a.fromDPToPix(this.mActivity, 50)) - com.tencent.mm.bp.a.fromDPToPix(this.mActivity, 12)) - com.tencent.mm.bp.a.fromDPToPix(this.mActivity, 12)) - com.tencent.mm.bp.a.fromDPToPix(this.mActivity, 8), -2);
            layoutParams2.setMargins(0, com.tencent.mm.bp.a.fromDPToPix(this.mActivity, 5), 0, 0);
            cVar.oiP.setLayoutParams(layoutParams2);
            cVar.oiP.setBackgroundResource(e.sns_ad_pic_style_bg);
            if (cVar.oiM != null) {
                cVar.oiM.setVisibility(0);
            }
            if (cVar.oiL == null) {
                return;
            }
            if (bi.oW(nVar.bAF().nzq)) {
                cVar.oiL.setVisibility(8);
            } else {
                cVar.oiL.setVisibility(0);
            }
        }
    }

    public final View a(Activity activity, c cVar, int i, av avVar, n nVar) {
        String str;
        this.mActivity = activity;
        this.hER = i;
        this.nuc = avVar;
        cVar.bSZ = nVar.bAK();
        switch (i) {
            case 0:
                str = "R.layout.sns_media_sub_item2";
                break;
            case 1:
                str = "R.layout.sns_media_sub_item2";
                break;
            case 2:
                str = "R.layout.sns_timeline_imagesline_one";
                break;
            case 3:
                str = "R.layout.sns_timeline_imagesline1";
                break;
            case 4:
                str = "R.layout.sns_timeline_imagesline2";
                break;
            case 5:
                str = "R.layout.sns_timeline_imagesline3";
                break;
            case 6:
                str = "R.layout.sns_timeline_item_photo_one3";
                break;
            case 7:
                str = "R.layout.sns_media_sub_item2";
                break;
            case 8:
                str = "R.layout.sns_media_sub_item2";
                break;
            case 9:
                str = "R.layout.sns_media_sight_item";
                break;
            case 10:
                str = "R.layout.sns_media_sub_item2";
                break;
            case 11:
                str = "R.layout.sns_hb_reward_item";
                break;
            case 12:
                str = "R.layout.sns_timeline_turn_media";
                break;
            case 13:
                str = "R.layout.sns_media_collapse_item";
                break;
            default:
                str = "R.layout.sns_media_sub_item2";
                break;
        }
        View a = com.tencent.mm.kiss.a.b.EY().a(this.mActivity, str, g.sns_timeline_item_photo_one3);
        cVar.ojV = str;
        View findViewById = a.findViewById(f.images_keeper_li);
        if (findViewById instanceof ViewStub) {
            cVar.oiQ = (ViewStub) findViewById;
        } else {
            cVar.oiQ = null;
        }
        x.i("MicroMsg.BaseTimeLineItem", "create new item  " + i + "  " + a.hashCode());
        cVar.ojO = a.findViewById(f.sns_timeline_content);
        cVar.hER = i;
        cVar.eCl = (MaskImageButton) a.findViewById(f.album_avatar_iv);
        cVar.eCl.setOnClickListener(avVar.ntw.okw);
        cVar.eCl.setOnLongClickListener(avVar.ntw.okx);
        cVar.eCl.setOnTouchListener(new 1(this));
        cVar.oiH = (AsyncTextView) a.findViewById(f.nickname_tv);
        cVar.oiI = (ImageView) a.findViewById(f.type_desc_tv);
        cVar.oiH.setOnTouchListener(new ab());
        cVar.oiJ = (ViewGroup) a.findViewById(f.nick_type_ll);
        cVar.oiK = (AsyncNormalTextView) a.findViewById(f.desc_collapse_tv);
        cVar.oiK.setOpClickListener(avVar.ocg);
        cVar.oiM = (TextView) a.findViewById(f.desc_collapse_pic_style_tv);
        cVar.oiM.setClickable(false);
        cVar.oiM.setLongClickable(false);
        cVar.oiO = a.findViewById(f.card_weapp_tag);
        cVar.oiL = (TextView) a.findViewById(f.desc_collapse_pic_style_title_tv);
        cVar.oiL.setClickable(false);
        cVar.oiL.setLongClickable(false);
        cVar.ojW = a.findViewById(f.card_btn_container);
        cVar.ojX = (Button) a.findViewById(f.card_btn_left);
        cVar.ojY = (Button) a.findViewById(f.card_btn_right);
        cVar.ojX.setOnClickListener(avVar.ntw.okZ);
        cVar.ojY.setOnClickListener(avVar.ntw.ola);
        cVar.ojZ = a.findViewById(f.sns_ad_card_header_container);
        cVar.oka = (ImageView) a.findViewById(f.sns_ad_card_header_avatar);
        cVar.okb = (TextView) a.findViewById(f.sns_ad_card_header_title);
        cVar.okc = (SnsCardAdTagListView) a.findViewById(f.card_ad_tag_list);
        cVar.okc.setActivityContext(this.mActivity);
        cVar.oiP = (LinearLayout) a.findViewById(f.images_keeper_lieaner_layout);
        if (nVar.xb(32)) {
            com.tencent.mm.plugin.sns.storage.b bAF = nVar.bAF();
            if (bAF != null && bAF.nze == 1) {
                cVar.oiK.setContentWidth((((((WindowManager) this.mActivity.getSystemService("window")).getDefaultDisplay().getWidth() - com.tencent.mm.bp.a.fromDPToPix(this.mActivity, 50)) - com.tencent.mm.bp.a.fromDPToPix(this.mActivity, 50)) - com.tencent.mm.bp.a.fromDPToPix(this.mActivity, 12)) - com.tencent.mm.bp.a.fromDPToPix(this.mActivity, 12));
                cVar.oiK.bBM();
            } else if (bAF != null && bAF.nze == 2) {
                cVar.oiK.setContentWidth(((((WindowManager) this.mActivity.getSystemService("window")).getDefaultDisplay().getWidth() - com.tencent.mm.bp.a.fromDPToPix(this.mActivity, 50)) - com.tencent.mm.bp.a.fromDPToPix(this.mActivity, 12)) - com.tencent.mm.bp.a.fromDPToPix(this.mActivity, 12));
                cVar.oiK.bBM();
            }
        }
        cVar.oiP.setTag(cVar);
        cVar.oiP.setOnClickListener(avVar.ntw.olb);
        avVar.hql.c(a.findViewById(f.desc_tv), avVar.ntw.oky, avVar.ntw.okv);
        avVar.hql.c((TextView) a.findViewById(f.desc_tv_single), avVar.ntw.oky, avVar.ntw.okv);
        cVar.oiN = (SnsTranslateResultView) a.findViewById(f.sns_translate_result_view);
        cVar.oiN.setVisibility(8);
        cVar.oiN.getSplitlineView().setPadding(0, 0, (int) this.mActivity.getResources().getDimension(d.SmallPadding), 0);
        cVar.oiN.getResultTextView().setBackgroundResource(e.sns_clickable_bg);
        avVar.hql.c(cVar.oiN.getResultTextView(), avVar.ntw.oky, avVar.ntw.okv);
        cVar.ojh = (LinearLayout) a.findViewById(f.comment_ll);
        cVar.oiW = (TextView) a.findViewById(f.with_info_tv);
        cVar.hrV = (TextView) a.findViewById(f.album_publish_time);
        cVar.oiX = (AsyncTextView) a.findViewById(f.album_ad_tail_desc);
        cVar.oiY = (AsyncTextView) a.findViewById(f.album_ad_at_tail);
        cVar.nZV = (TextView) a.findViewById(f.album_address);
        cVar.nkH = new bf(a);
        cVar.nkH.a(avVar.ntw.okG, avVar.ntw.okU);
        cVar.nNC = (TextView) a.findViewById(f.album_del);
        cVar.nNC.setText(activity.getString(j.app_delete));
        cVar.nNC.setOnClickListener(avVar.ntw.okA);
        cVar.oiX.setOnClickListener(avVar.ntw.okV);
        cVar.oiY.setOnClickListener(avVar.ntw.okW);
        cVar.nZV.setOnClickListener(avVar.ntw.okR);
        cVar.oja = a.findViewById(f.album_groupid);
        cVar.oja.setOnClickListener(avVar.ntw.okF);
        cVar.oiZ = (TextView) a.findViewById(f.album_from);
        cVar.ojb = (ImageView) a.findViewById(f.album_show_comment_tv);
        cVar.ojk = (ViewStub) a.findViewById(f.album_comment_stub);
        cVar.nKX = (LinearLayout) a.findViewById(f.album_list_fatherview);
        cVar.ojQ = (ViewStub) a.findViewById(f.album_hb_reward);
        cVar.ojm = (ViewStub) a.findViewById(f.sns_post_error_stub);
        cVar.oiS = (TextView) a.findViewById(f.game_more_tv);
        cVar.oiS.setOnClickListener(avVar.ntw.okB);
        cVar.ojU = (TextView) a.findViewById(f.hb_tip);
        cVar.jEz = a;
        if (this.nTx) {
            c.b(a, cVar);
            com.tencent.mm.plugin.sns.abtest.a.a(a, cVar);
            af.byf();
            com.tencent.mm.plugin.sns.f.c.c(a, cVar);
        }
        c(cVar);
        a.setTag(cVar);
        a(cVar, nVar);
        return a;
    }

    public final void a(c cVar, int i, n nVar, bsu bsu, int i2, av avVar) {
        String bBe;
        String str;
        int parseColor;
        CharSequence charSequence;
        CharSequence charSequence2;
        com.tencent.mm.ui.a.a cqX;
        View view;
        AsyncTextView asyncTextView;
        TextView textView;
        String content;
        TextView textView2;
        boolean z;
        ay ayVar = (ay) avVar.bDU().bCc().get(Integer.valueOf(i));
        a(cVar, nVar);
        this.hER = i2;
        this.nuc = avVar;
        if (this.nTx) {
            ax.D(nVar);
        }
        if (nVar.xb(32)) {
            x.i("MicroMsg.BaseTimeLineItem", "the ad sns id is " + i.eG(nVar.field_snsId) + " for susan");
        }
        cVar.oiF = ayVar.oew;
        cVar.jLu = false;
        cVar.position = i;
        cVar.bSZ = ayVar.oev;
        cVar.bKW = ayVar.nMU;
        cVar.oiG = ayVar.oeA;
        cVar.ojb.setOnClickListener(avVar.ocf);
        cVar.ojM = bsu;
        boy boy = ayVar.nhb;
        cVar.nib = boy;
        com.tencent.mm.plugin.sns.h.b bVar = avVar.obV.nLK.nrb;
        if (nVar != null) {
            bBe = nVar.bBe();
            bVar.nxm.add(bBe);
            if (nVar.xb(32)) {
                bVar.nxr.add(bBe);
            }
            bVar.nxs.add(nVar.field_userName);
            switch (nVar.field_type) {
                case 1:
                    bVar.nxo.add(bBe);
                    break;
                case 2:
                    bVar.nxn.add(bBe);
                    break;
                case 3:
                    if (!bi.oW(bsu.sqd)) {
                        bVar.nxt.add(bBe);
                        break;
                    } else {
                        bVar.nxu.add(bBe);
                        break;
                    }
                case 4:
                    bVar.nxq.add(bBe);
                    break;
                case 5:
                    bVar.nxv.add(bBe);
                    break;
                case 15:
                    bVar.nxp.add(bBe);
                    break;
                case 18:
                    bVar.nxw.add(bBe);
                    break;
                default:
                    bVar.nxx.add(bBe);
                    break;
            }
            if (i < bVar.nxk) {
                bVar.nxk = i;
                bVar.nvQ = i.g(nVar);
            }
            if (i > bVar.nxl) {
                bVar.nxl = i;
                bVar.nvR = i.g(nVar);
            }
            bVar.nvW = bVar.nxn.size();
            bVar.nvX = bVar.nxo.size();
            bVar.nvY = bVar.nxp.size();
            bVar.nwa = bVar.nxq.size();
            bVar.nvZ = bVar.nxr.size();
            bVar.nwb = bVar.nxv.size();
            bVar.nwj = bVar.nxw.size();
            bVar.hpo = bVar.nxs.size();
            bVar.nvU = bVar.nxt.size();
            bVar.nvV = bVar.nxu.size();
            bVar.nwi = bVar.nxx.size();
            bVar.nvE = bVar.nxm.size();
        }
        bBe = ayVar.gtX;
        if (!bi.oW(bBe)) {
            cVar.ojN = ayVar.oeu;
            if (ayVar.oeL) {
                x.i("MicroMsg.BaseTimeLineItem", "getContact %s", new Object[]{bBe});
                if (com.tencent.mm.pluginsdk.ui.a.b.ccZ().uM() != null) {
                    cVar.eCl.setImageBitmap(com.tencent.mm.pluginsdk.ui.a.b.ccZ().uM());
                }
                com.tencent.mm.model.am.a.dBr.a(bBe, "", new av.b(avVar.bDU(), i));
            } else {
                com.tencent.mm.pluginsdk.ui.a.b.a(cVar.eCl, bBe);
            }
            cVar.eCl.setTag(bBe);
            ((MaskImageButton) cVar.eCl).uAL = ayVar.nMU;
            AsyncTextView asyncTextView2 = cVar.oiH;
            String str2 = ayVar.oeK;
            k kVar = avVar.nUh;
            boolean z2 = ayVar.nLv;
            String str3 = ayVar.nMU;
            boolean z3 = ayVar.nLv;
            asyncTextView2.userName = bBe;
            asyncTextView2.nLu = str2;
            asyncTextView2.hER = i2;
            asyncTextView2.nLv = z2;
            asyncTextView2.nLw = str3;
            asyncTextView2.nLx = kVar;
            asyncTextView2.nLy = z3;
            asyncTextView2.run();
        }
        cVar.oiI.setVisibility(8);
        if (ayVar.nLv) {
            cVar.nkG = true;
            cVar.jLu = ayVar.oeB;
            cVar.fvT = ayVar.oeC;
        } else {
            cVar.nkG = false;
            cVar.fvT = "";
        }
        cVar.oiO.setVisibility(8);
        cVar.ojW.setVisibility(8);
        cVar.ojZ.setVisibility(8);
        cVar.ojZ.setTag("");
        cVar.okc.setVisibility(8);
        if (cVar == null || !nVar.xb(32) || nVar.bAF() == null || nVar.bAF().nzp != 1) {
            AsyncNormalTextView asyncNormalTextView = cVar.oiK;
            bBe = ayVar.oex;
            asyncNormalTextView.nLs = ayVar.oey;
            asyncNormalTextView.content = bBe;
            asyncNormalTextView.nuc = avVar;
            asyncNormalTextView.nLt = ayVar;
            if (bi.oW(bBe)) {
                asyncNormalTextView.setVisibility(8);
            }
            cVar.oiK.setShow(cVar);
        } else {
            com.tencent.mm.plugin.sns.storage.a bAH = nVar.bAH();
            if (!(bAH == null || !bAH.bzk() || nVar.bBs())) {
                cVar.oiO.setVisibility(0);
            }
            str = bi.oW(nVar.bAF().nzr) ? bsu.spZ : nVar.bAF().nzr;
            if (bi.oW(str)) {
                cVar.oiM.setVisibility(8);
            } else {
                cVar.oiM.setText(str + " ");
                com.tencent.mm.pluginsdk.ui.d.j.g(cVar.oiM, 2);
                cVar.oiM.setVisibility(0);
            }
            str = nVar.bAF().nzq;
            if (bi.oW(str)) {
                cVar.oiL.setVisibility(8);
            } else {
                cVar.oiL.setText(str + " ");
                com.tencent.mm.pluginsdk.ui.d.j.g(cVar.oiL, 2);
                cVar.oiL.setVisibility(0);
            }
            cVar.okc.removeAllViews();
            if (nVar.bAF().nzu.size() > 0) {
                cVar.okc.setVisibility(0);
                cVar.okc.setTagSpace(com.tencent.mm.bp.a.fromDPToPix(this.mActivity, 6));
                cVar.okc.cw(nVar.bAF().nzu);
            }
            if (bi.oW(nVar.bAF().nzs)) {
                cVar.okb.setVisibility(4);
            } else {
                cVar.ojZ.setVisibility(0);
                cVar.okb.setVisibility(0);
                cVar.okb.setText(nVar.bAF().nzs);
            }
            cVar.ojZ.setTag(nVar.bAF().nzt);
            if (bi.oW(nVar.bAF().nzt)) {
                cVar.oka.setVisibility(4);
            } else {
                com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.d.a(nVar.bAF().nzt, new 2(this, cVar));
            }
            if (nVar.bAF().bzs() || nVar.bAF().bzt()) {
                cVar.ojW.setVisibility(0);
                int i3 = e.sns_card_select_btn_solid_white;
                int parseColor2 = Color.parseColor("#cdcdcd");
                parseColor = Color.parseColor("#ffffff");
                Object obj = 1;
                if (nVar.bAF().bzt()) {
                    int eN = v.eN(nVar.bAF().nzy.nzF, nVar.bBo());
                    if (eN > 0 && eN <= 2) {
                        if (eN == 1) {
                            cVar.ojY.setBackgroundColor(parseColor);
                            cVar.ojY.setTextColor(parseColor2);
                            cVar.ojY.setText(nVar.bAF().nzy.wK(1));
                            cVar.ojX.setBackgroundResource(i3);
                            cVar.ojX.setTextColor(-16777216);
                            cVar.ojX.setText(nVar.bAF().nzy.wJ(0));
                        } else if (eN == 2) {
                            cVar.ojX.setBackgroundColor(parseColor);
                            cVar.ojX.setTextColor(parseColor2);
                            cVar.ojX.setText(nVar.bAF().nzy.wK(0));
                            cVar.ojY.setBackgroundResource(i3);
                            cVar.ojY.setTextColor(-16777216);
                            cVar.ojY.setText(nVar.bAF().nzy.wJ(1));
                        }
                        obj = null;
                    }
                }
                if (obj != null) {
                    cVar.ojX.setTextColor(-16777216);
                    cVar.ojX.setBackgroundResource(i3);
                    cVar.ojY.setTextColor(-16777216);
                    cVar.ojY.setBackgroundResource(i3);
                    cVar.ojX.setText(nVar.bAF().bzn());
                    cVar.ojY.setText(nVar.bAF().bzo());
                }
            }
        }
        cVar.oiZ.setOnTouchListener(new ab());
        a(cVar, i, ayVar, bsu, i2, avVar);
        avVar.obX.put(Integer.valueOf(i), new WeakReference(cVar.jEz));
        if (cVar.jEz.getBackground() == null) {
            cVar.jEz.setBackgroundResource(e.comm_list_item_selector);
            int fromDPToPix = com.tencent.mm.bp.a.fromDPToPix(this.mActivity, 12);
            cVar.jEz.setPadding(fromDPToPix, fromDPToPix, fromDPToPix, com.tencent.mm.bp.a.fromDPToPix(this.mActivity, 8));
        }
        cVar.hrV.setText(ayVar.oeD);
        cVar.oiX.setVisibility(8);
        cVar.oiY.setVisibility(8);
        if (ayVar.nLv) {
            com.tencent.mm.plugin.sns.storage.a aVar = ayVar.oeE;
            cVar.oiX.setTag(ayVar.nMU);
            if (ayVar.oeE.nye == com.tencent.mm.plugin.sns.storage.a.nxQ) {
                if (bi.oW(ayVar.oeH)) {
                    cVar.oiX.setVisibility(8);
                } else {
                    cVar.oiX.setText(ayVar.oeH);
                    cVar.oiX.setVisibility(0);
                }
            } else if (aVar.nye == com.tencent.mm.plugin.sns.storage.a.nxR) {
                if (bi.oW(ayVar.oeI)) {
                    cVar.oiX.setVisibility(8);
                } else {
                    str = ayVar.oeJ;
                    charSequence = ayVar.oeI;
                    Context context = this.mActivity;
                    cVar.oiX.getTextSize();
                    com.tencent.mm.pluginsdk.ui.d.k kVar2 = new com.tencent.mm.pluginsdk.ui.d.k(com.tencent.mm.pluginsdk.ui.d.j.b(context, charSequence, 1));
                    kVar2.a(null, charSequence, 0);
                    TextPaint paint = cVar.oiX.getPaint();
                    if (com.tencent.mm.bp.a.ag(this.mActivity, (int) Layout.getDesiredWidth(kVar2, 0, kVar2.length(), paint)) > cVar.nUp) {
                        while (str.length() > 1) {
                            str = str.substring(0, str.length() - 2);
                            CharSequence format = String.format(aVar.nyf, new Object[]{str + "..."});
                            Context context2 = this.mActivity;
                            cVar.oiX.getTextSize();
                            com.tencent.mm.pluginsdk.ui.d.k kVar3 = new com.tencent.mm.pluginsdk.ui.d.k(com.tencent.mm.pluginsdk.ui.d.j.b(context2, format, 1));
                            kVar3.a(null, format, 0);
                            parseColor = com.tencent.mm.bp.a.ag(this.mActivity, (int) Layout.getDesiredWidth(kVar3, 0, kVar3.length(), paint));
                            cVar.oiX.setText(kVar3, BufferType.SPANNABLE);
                            cVar.oiX.setVisibility(0);
                            if (parseColor <= cVar.nUp) {
                            }
                        }
                    } else {
                        cVar.oiX.setText(kVar2, BufferType.SPANNABLE);
                        cVar.oiX.setVisibility(0);
                    }
                }
            }
            if (cVar.oiX.getVisibility() != 8 && bi.oW(aVar.nyg)) {
                cVar.oiX.setTextColor(this.mActivity.getResources().getColor(com.tencent.mm.plugin.sns.i.c.sns_word_color));
                cVar.oiX.setOnClickListener(null);
            }
            if (nVar.bAJ().sqc.ruB == 4) {
                cVar.oiY.setTag(cVar);
                cVar.oiY.setVisibility(0);
                cVar.oiY.setText(String.format("%s%s%s", new Object[]{this.mActivity.getResources().getString(j.sns_ad_at_tips1), ayVar.oeK, this.mActivity.getResources().getString(j.sns_ad_at_tips2)}));
            } else {
                cVar.oiY.setVisibility(8);
            }
        }
        if (ayVar.oeN) {
            cVar.ojU.setText(avVar.bGc.getString(j.lucky_sns_reward_numbers, new Object[]{Integer.valueOf(ayVar.oeO)}));
            cVar.ojU.setVisibility(0);
        } else {
            cVar.ojU.setVisibility(8);
        }
        cVar.nZV.setTag(ayVar.nMU);
        if (bi.oW(ayVar.oeQ)) {
            cVar.nZV.setVisibility(8);
        } else {
            cVar.nZV.setVisibility(0);
            cVar.nZV.setText(ayVar.oeQ);
            cVar.nZV.setClickable(ayVar.oeR);
            cVar.nZV.setTextColor(ayVar.oeR ? -11048043 : -9211021);
        }
        cVar.oiZ.setTextColor(this.mActivity.getResources().getColor(com.tencent.mm.plugin.sns.i.c.sns_link_color));
        if (ayVar.oeS) {
            cVar.oiZ.setVisibility(0);
            charSequence2 = this.mActivity.getString(j.sns_comefrome) + ayVar.mAppName;
            if (charSequence2.length() > 10) {
                charSequence2 = charSequence2.substring(0, 10) + "...";
            }
            CharSequence spannableString = new SpannableString(charSequence2);
            spannableString.setSpan(new b(this), 0, spannableString.length(), 33);
            cVar.oiZ.setText(spannableString, BufferType.SPANNABLE);
            if (!(ayVar.oeU || "wx7fa037cc7dfabad5".equals(bsu.sqb.ksA))) {
                cVar.oiZ.setTextColor(this.mActivity.getResources().getColor(com.tencent.mm.plugin.sns.i.c.sns_word_color));
                cVar.oiZ.setOnTouchListener(null);
            }
            cVar.oiZ.setTag(bsu);
        } else if (ayVar.oeT) {
            cVar.oiZ.setVisibility(0);
            charSequence2 = new SpannableString(ayVar.oeW);
            charSequence2.setSpan(new d(this), 0, charSequence2.length(), 33);
            cVar.oiZ.setText(charSequence2, BufferType.SPANNABLE);
            cVar.oiZ.setTag(new bd(ayVar.oeV, ayVar.oeW));
        } else if (ayVar.oeX) {
            cVar.oiZ.setVisibility(0);
            str = this.mActivity.getString(j.app_brand_appbrand_with_dot);
            Object obj2 = str + ayVar.mAppName;
            charSequence = new SpannableString(obj2);
            charSequence.setSpan(new ForegroundColorSpan(this.mActivity.getResources().getColor(com.tencent.mm.plugin.sns.i.c.sns_word_color)), 0, str.length(), 33);
            charSequence.setSpan(new a(this), str.length(), obj2.length(), 33);
            cVar.oiZ.setText(charSequence, BufferType.SPANNABLE);
            if (!(ayVar.oeU || "wx7fa037cc7dfabad5".equals(bsu.sqb.ksA))) {
                cVar.oiZ.setTextColor(this.mActivity.getResources().getColor(com.tencent.mm.plugin.sns.i.c.sns_word_color));
                cVar.oiZ.setOnTouchListener(null);
            }
            cVar.oiZ.setTag(bsu);
        } else {
            cVar.oiZ.setVisibility(8);
        }
        if (ayVar.oeM) {
            cVar.nNC.setVisibility(0);
            cVar.nNC.setTag(ayVar.nMU);
        } else {
            cVar.nNC.setVisibility(8);
        }
        cVar.ojb.setTag(cVar);
        if (ayVar.oeY) {
            if (!cVar.ojq) {
                cVar.ojf = (LinearLayout) cVar.ojm.inflate();
                cVar.ojg = cVar.jEz.findViewById(f.post_again_click_id);
                cVar.ojq = true;
                cVar.ojg.setTag(ayVar.nMU);
                cVar.nEJ = (TextView) cVar.ojf.findViewById(f.post_again_click_id);
            }
            cVar.ojm.setVisibility(0);
            cVar.ojg.setOnClickListener(avVar.ntw.okE);
            switch (ayVar.oeZ) {
                case 201:
                    cVar.nEJ.setText(j.sns_post_error_ban_again);
                    cVar.ojg.setClickable(false);
                    cVar.ojg.setEnabled(false);
                    break;
                case 210:
                    cVar.nEJ.setText(j.sns_post_error_to_long_again);
                    cVar.ojg.setClickable(false);
                    cVar.ojg.setEnabled(false);
                    break;
                case 211:
                    cVar.nEJ.setText(j.sns_post_error_ten_min_again);
                    cVar.ojg.setClickable(true);
                    cVar.ojg.setEnabled(true);
                    break;
                default:
                    cVar.nEJ.setText(j.sns_post_error_touch_again);
                    cVar.ojg.setClickable(true);
                    cVar.ojg.setEnabled(true);
                    break;
            }
            atf bAW = nVar.bAW();
            if (!(bAW == null || bi.oW(bAW.rWr))) {
                cVar.nEJ.setText(bAW.rWr);
            }
        } else if (cVar.ojq) {
            cVar.ojm.setVisibility(8);
        }
        if (ayVar.ofa) {
            cVar.oja.setVisibility(0);
            cVar.oja.setTag(ayVar.nMU);
        } else {
            cVar.oja.setVisibility(8);
        }
        if (ayVar.ofb) {
            if (!bi.oW(ayVar.ofc)) {
                cVar.oiW.setVisibility(0);
                if (i2 == 7) {
                    charSequence2 = String.format(this.mActivity.getString(j.sns_timeline_ui_tv_with_to), new Object[]{ayVar.ofc});
                } else {
                    charSequence2 = String.format(this.mActivity.getString(j.sns_timeline_ui_with_to), new Object[]{ayVar.ofc});
                }
                cVar.oiW.setText(com.tencent.mm.pluginsdk.ui.d.j.a(this.mActivity, charSequence2, cVar.oiW.getTextSize()));
            } else if (ayVar.ofd) {
                cVar.oiW.setVisibility(0);
                cVar.oiW.setText(com.tencent.mm.pluginsdk.ui.d.j.a(this.mActivity, this.mActivity.getString(j.sns_timeline_ui_with_you).toString(), cVar.oiW.getTextSize()));
            }
            if (ayVar.ofe) {
                if (cVar.ojR == null) {
                    cVar.ojR = cVar.ojQ.inflate();
                    cVar.nmi = (TextView) cVar.ojR.findViewById(f.album_hb_reward_tip);
                    cVar.ojS = (MaskTextView) cVar.ojR.findViewById(f.album_hb_reward_users);
                    cVar.ojS.setOnTouchListener(new ab());
                }
                cVar.ojR.setVisibility(0);
                b(cVar.ojS, ayVar.ofi, i2);
                cVar.nmi.setText(this.mActivity.getString(j.sns_lucky_reward_tip_info, new Object[]{Integer.valueOf(ayVar.ofg), bi.A(ayVar.ofh / 100.0d)}));
                cVar.ojR.setTag(nVar);
                cVar.ojR.setOnClickListener(avVar.ntw.okH);
            } else if (cVar.ojR != null) {
                cVar.ojR.setVisibility(8);
            }
            if ((ayVar.ofj == null && ayVar.ofj.size() != 0) || (ayVar.ofk != null && ayVar.ofk.size() != 0)) {
                if (!cVar.ojl) {
                    if (cVar.nKX == null) {
                        cVar.nKX = (LinearLayout) cVar.ojk.inflate();
                    }
                    cVar.ojd = (MaskTextView) cVar.nKX.findViewById(f.album_liked_list_tv);
                    cVar.ojd.setOnTouchListener(new ab());
                    cVar.oje = (LinearLayout) cVar.jEz.findViewById(f.album_comment_list_li);
                    cVar.nKX.setTag(ayVar.oev);
                    cVar.ojd.setTag(ayVar.oev);
                    cVar.ojj = cVar.nKX.findViewById(f.album_list_line);
                    cVar.ojT = cVar.nKX.findViewById(f.album_list_fatherview);
                    cVar.ojl = true;
                }
                cVar.nKX.setVisibility(0);
                if (ayVar.ofj == null || ayVar.ofj.size() <= 0) {
                    cVar.ojd.setVisibility(8);
                } else {
                    cVar.ojd.setVisibility(0);
                    a(cVar.ojd, ayVar.ofj, i2);
                }
                if (ayVar.ofk != null) {
                    a(boy.smO, ayVar.ofk, cVar);
                } else {
                    cVar.oje.setVisibility(8);
                }
                if (ayVar.ofj == null || ayVar.ofj.size() == 0 || ayVar.ofk == null || ayVar.ofk.size() == 0) {
                    cVar.ojj.setVisibility(8);
                } else {
                    cVar.ojj.setVisibility(0);
                }
            } else if (cVar.nKX != null) {
                cVar.nKX.setVisibility(8);
            } else if (cVar.ojl) {
                cVar.ojk.setVisibility(8);
            }
            if (ayVar.ofl) {
                cVar.oiS.setVisibility(8);
            } else {
                cVar.oiS.setTag(ayVar.nMU);
                cVar.oiS.setText(ayVar.ofm);
                cVar.oiS.setVisibility(0);
            }
            if (ayVar.nLv) {
                cVar.nkH.setVisibility(8);
            } else {
                x.i("MicroMsg.BaseTimeLineItem", "adatag " + ayVar.oeG);
                cVar.nkH.r(Long.valueOf(ayVar.oew), new com.tencent.mm.plugin.sns.data.b(cVar.nkH, cVar.position, ayVar.nMU, ayVar.oew, ayVar.oeC));
                cVar.nkH.a(ayVar.oeF, ayVar.oeE);
                cVar.nkH.setVisibility(0);
                if (cVar.nZV != null && cVar.nZV.getVisibility() == 0) {
                    if ((cVar.nkH.ohl.getVisibility() == 0 ? 1 : null) != null) {
                        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) cVar.nZV.getLayoutParams();
                        layoutParams.setMargins(layoutParams.leftMargin, BackwardSupportUtil.b.b(this.mActivity, 0.0f), layoutParams.rightMargin, layoutParams.bottomMargin);
                        cVar.nZV.setLayoutParams(layoutParams);
                    }
                }
            }
            if (this.nTx) {
                af.byf().a(this.mActivity, boy, cVar);
            }
            cVar.oiN.getResultTextView().setTag(new as(ayVar.oev, ayVar.nMU, false, true, 1));
            cqX = com.tencent.mm.ui.a.a.a.cqX();
            view = cVar.jEz;
            asyncTextView = cVar.oiH;
            textView = cVar.hrV;
            content = cVar.oiK.getContent();
            textView2 = cVar.oiU;
            z = cVar.ojG;
            if (cqX.cqW() && cqX.rc != null && view != null && asyncTextView != null && textView != null) {
                com.tencent.mm.ui.a.b bVar2 = new com.tencent.mm.ui.a.b();
                bVar2.ZU(asyncTextView.getText().toString());
                bVar2.ZU(content);
                if (textView2 != null) {
                    bVar2.ZU(textView2.getText().toString());
                }
                if (z) {
                    bVar2.ZU(cqX.rc.getString(com.tencent.mm.w.a.k.contains_sight_desc));
                }
                bVar2.dl(view);
                return;
            }
            return;
        }
        cVar.oiW.setVisibility(8);
        if (ayVar.ofe) {
            if (cVar.ojR == null) {
                cVar.ojR = cVar.ojQ.inflate();
                cVar.nmi = (TextView) cVar.ojR.findViewById(f.album_hb_reward_tip);
                cVar.ojS = (MaskTextView) cVar.ojR.findViewById(f.album_hb_reward_users);
                cVar.ojS.setOnTouchListener(new ab());
            }
            cVar.ojR.setVisibility(0);
            b(cVar.ojS, ayVar.ofi, i2);
            cVar.nmi.setText(this.mActivity.getString(j.sns_lucky_reward_tip_info, new Object[]{Integer.valueOf(ayVar.ofg), bi.A(ayVar.ofh / 100.0d)}));
            cVar.ojR.setTag(nVar);
            cVar.ojR.setOnClickListener(avVar.ntw.okH);
        } else if (cVar.ojR != null) {
            cVar.ojR.setVisibility(8);
        }
        if (ayVar.ofj == null) {
        }
        if (cVar.nKX != null) {
            cVar.nKX.setVisibility(8);
        } else if (cVar.ojl) {
            cVar.ojk.setVisibility(8);
        }
        if (ayVar.ofl) {
            cVar.oiS.setVisibility(8);
        } else {
            cVar.oiS.setTag(ayVar.nMU);
            cVar.oiS.setText(ayVar.ofm);
            cVar.oiS.setVisibility(0);
        }
        if (ayVar.nLv) {
            cVar.nkH.setVisibility(8);
        } else {
            x.i("MicroMsg.BaseTimeLineItem", "adatag " + ayVar.oeG);
            cVar.nkH.r(Long.valueOf(ayVar.oew), new com.tencent.mm.plugin.sns.data.b(cVar.nkH, cVar.position, ayVar.nMU, ayVar.oew, ayVar.oeC));
            cVar.nkH.a(ayVar.oeF, ayVar.oeE);
            cVar.nkH.setVisibility(0);
            if (cVar.nZV != null && cVar.nZV.getVisibility() == 0) {
                if ((cVar.nkH.ohl.getVisibility() == 0 ? 1 : null) != null) {
                    LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) cVar.nZV.getLayoutParams();
                    layoutParams2.setMargins(layoutParams2.leftMargin, BackwardSupportUtil.b.b(this.mActivity, 0.0f), layoutParams2.rightMargin, layoutParams2.bottomMargin);
                    cVar.nZV.setLayoutParams(layoutParams2);
                }
            }
        }
        if (this.nTx) {
            af.byf().a(this.mActivity, boy, cVar);
        }
        cVar.oiN.getResultTextView().setTag(new as(ayVar.oev, ayVar.nMU, false, true, 1));
        cqX = com.tencent.mm.ui.a.a.a.cqX();
        view = cVar.jEz;
        asyncTextView = cVar.oiH;
        textView = cVar.hrV;
        content = cVar.oiK.getContent();
        textView2 = cVar.oiU;
        z = cVar.ojG;
        if (cqX.cqW()) {
        }
    }

    public static void d(c cVar) {
        if (cVar != null && cVar.oiN != null) {
            cVar.oiN.setVisibility(8);
        }
    }

    private boolean a(MaskTextView maskTextView, com.tencent.mm.vending.d.b<com.tencent.mm.vending.j.a> bVar, int i) {
        int i2;
        CharSequence spannableStringBuilder = new SpannableStringBuilder(" ");
        int length = spannableStringBuilder.length() - 1;
        StringBuffer stringBuffer = new StringBuffer();
        int[] iArr = new int[bVar.size()];
        int[] iArr2 = new int[bVar.size()];
        Object obj = 1;
        int i3 = 0;
        while (true) {
            try {
                i2 = i3;
                if (i2 >= bVar.size()) {
                    break;
                }
                String str = (String) ((com.tencent.mm.vending.j.a) bVar.get(i2)).get(1);
                if (obj != null) {
                    spannableStringBuilder.append(" ");
                    stringBuffer.append(" ");
                    obj = null;
                } else {
                    spannableStringBuilder.append(", ");
                    stringBuffer.append(", ");
                }
                iArr[i2] = spannableStringBuilder.length();
                iArr2[i2] = iArr[i2] + str.length();
                stringBuffer.append(str);
                spannableStringBuilder.append(com.tencent.mm.pluginsdk.ui.d.j.a(this.mActivity, str, maskTextView.getTextSize()));
                i3 = i2 + 1;
            } catch (Throwable e) {
                x.e("MicroMsg.BaseTimeLineItem", "setLikedList  e:%s", new Object[]{bi.i(e)});
            }
        }
        Drawable drawable = this.mActivity.getResources().getDrawable(i == 11 ? e.golden_like_icon : e.normal_like_icon);
        drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        com.tencent.mm.ui.widget.a aVar = new com.tencent.mm.ui.widget.a(drawable);
        aVar.uFY = (int) (((((float) drawable.getIntrinsicHeight()) - maskTextView.getTextSize()) + ((float) com.tencent.mm.bp.a.fromDPToPix(this.mActivity, 2))) / 2.0f);
        spannableStringBuilder.setSpan(aVar, length, length + 1, 33);
        int i4 = i == 11 ? 3 : 2;
        i3 = 0;
        while (true) {
            i2 = i3;
            if (i2 >= iArr.length) {
                break;
            }
            spannableStringBuilder.setSpan(new o((String) ((com.tencent.mm.vending.j.a) bVar.get(i2)).get(0), this.nuc.nUh, i4), iArr[i2], iArr2[i2], 33);
            i3 = i2 + 1;
        }
        maskTextView.setText(spannableStringBuilder, BufferType.SPANNABLE);
        maskTextView.setOriginText(stringBuffer.toString());
        return true;
    }

    private void b(MaskTextView maskTextView, com.tencent.mm.vending.d.b<com.tencent.mm.vending.j.a> bVar, int i) {
        if (bVar.size() == 0) {
            maskTextView.setVisibility(8);
            return;
        }
        int i2;
        maskTextView.setVisibility(0);
        CharSequence spannableStringBuilder = new SpannableStringBuilder(" ");
        int length = spannableStringBuilder.length() - 1;
        StringBuffer stringBuffer = new StringBuffer();
        int[] iArr = new int[bVar.size()];
        int[] iArr2 = new int[bVar.size()];
        Object obj = 1;
        int i3 = 0;
        while (true) {
            try {
                i2 = i3;
                if (i2 >= bVar.size()) {
                    break;
                }
                String str = (String) ((com.tencent.mm.vending.j.a) bVar.get(i2)).get(1);
                if (obj != null) {
                    spannableStringBuilder.append(" ");
                    stringBuffer.append(" ");
                    obj = null;
                } else {
                    spannableStringBuilder.append(", ");
                    stringBuffer.append(", ");
                }
                iArr[i2] = spannableStringBuilder.length();
                iArr2[i2] = iArr[i2] + str.length();
                stringBuffer.append(str);
                spannableStringBuilder.append(com.tencent.mm.pluginsdk.ui.d.j.a(this.mActivity, str, maskTextView.getTextSize()));
                i3 = i2 + 1;
            } catch (Throwable e) {
                x.e("MicroMsg.BaseTimeLineItem", "setReward error  e:%s", new Object[]{bi.i(e)});
                return;
            }
        }
        Drawable drawable = this.mActivity.getResources().getDrawable(com.tencent.mm.plugin.sns.i.i.friendactivity_luckymoney_icon);
        drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        com.tencent.mm.ui.widget.a aVar = new com.tencent.mm.ui.widget.a(drawable);
        aVar.uFY = (int) (((((float) drawable.getIntrinsicHeight()) - maskTextView.getTextSize()) + ((float) com.tencent.mm.bp.a.fromDPToPix(this.mActivity, 2))) / 2.0f);
        spannableStringBuilder.setSpan(aVar, length, length + 1, 33);
        int i4 = i == 11 ? 3 : 2;
        i3 = 0;
        while (true) {
            i2 = i3;
            if (i2 < iArr.length) {
                spannableStringBuilder.setSpan(new o((String) ((com.tencent.mm.vending.j.a) bVar.get(i2)).get(0), this.nuc.nUh, i4), iArr[i2], iArr2[i2], 33);
                i3 = i2 + 1;
            } else {
                maskTextView.setText(spannableStringBuilder, BufferType.SPANNABLE);
                maskTextView.setOriginText(stringBuffer.toString());
                return;
            }
        }
    }

    public final void a(c cVar, int i, n nVar) {
        c cVar2 = cVar;
        int i2 = i;
        a(cVar2, i2, (ay) this.nuc.bDU().bCc().get(Integer.valueOf(i)), nVar.bAJ(), cVar.hER, this.nuc);
    }

    private boolean a(List<bon> list, com.tencent.mm.vending.d.b<com.tencent.mm.vending.j.a> bVar, c cVar) {
        int i;
        LinearLayout linearLayout = cVar.oje;
        int childCount = linearLayout.getChildCount();
        int size = bVar.size();
        if (childCount > size) {
            for (i = size; i < childCount; i++) {
                View childAt = linearLayout.getChildAt(size);
                linearLayout.removeViewAt(size);
                if (childAt instanceof SnsCommentPreloadTextView) {
                    this.nuc.a((SnsCommentPreloadTextView) childAt);
                }
            }
        }
        if (bVar.size() == 0) {
            linearLayout.setVisibility(8);
            return false;
        }
        ay ayVar;
        linearLayout.setVisibility(0);
        com.tencent.mm.plugin.sns.ui.x bDU = this.nuc.bDU();
        if (bDU instanceof ax) {
            ayVar = (ay) ((ax) bDU).oeg.get(cVar.position);
        } else {
            ayVar = null;
        }
        int i2 = 0;
        if (this.DEBUG) {
            x.d("MicroMsg.BaseTimeLineItem", "debug:setCommentList position " + cVar.position + " commentCount: " + size);
        }
        i = 0;
        while (true) {
            int i3 = i2;
            int i4 = i;
            if (i4 >= bVar.size()) {
                return true;
            }
            TranslateCommentTextView bDQ;
            Object obj;
            View view;
            Object obj2;
            View view2;
            com.tencent.mm.vending.j.a aVar = (com.tencent.mm.vending.j.a) bVar.get(i4);
            long longValue = ((Long) aVar.get(0)).longValue();
            String str = (String) aVar.get(1);
            String str2 = (String) aVar.get(2);
            String str3 = (String) aVar.get(3);
            CharSequence charSequence = (CharSequence) aVar.get(4);
            bon bon = (bon) list.get(i4);
            b aj = aj(cVar.bSZ, longValue);
            if (aj != null && aj.dHC) {
                ap.cc(aj.id, 2);
            }
            if (i3 >= childCount) {
                if (aj == null || aj.dHC) {
                    bDQ = this.nuc.bDQ();
                    ((SnsCommentPreloadTextView) bDQ).setTextSize$255e752(15.0f * com.tencent.mm.bp.a.fe(bDQ.getContext()));
                    if (this.nuc.obZ == -1) {
                        this.nuc.obZ = this.mActivity.getResources().getColor(com.tencent.mm.plugin.sns.i.c.sns_comment_color);
                    }
                    ((SnsCommentPreloadTextView) bDQ).setTextColor(this.nuc.obZ);
                    ((SnsCommentPreloadTextView) bDQ).setGravity(16);
                } else {
                    bDQ = new TranslateCommentTextView(this.mActivity);
                    bDQ.getTranslateResultView().setResultTextSize$255e752(15.0f * com.tencent.mm.bp.a.fe(bDQ.getContext()));
                    bDQ.getOriginCommentTextView().setTextSize(1, 15.0f * com.tencent.mm.bp.a.fe(bDQ.getContext()));
                }
                obj = 1;
                view = bDQ;
            } else {
                view = linearLayout.getChildAt(i3);
                obj = null;
            }
            if (aj != null) {
                if (!(view instanceof TranslateCommentTextView)) {
                    linearLayout.removeView(view);
                    bDQ = new TranslateCommentTextView(this.mActivity);
                    linearLayout.addView(bDQ, i3);
                    bDQ.getTranslateResultView().setResultTextSize$255e752(15.0f * com.tencent.mm.bp.a.fe(bDQ.getContext()));
                    bDQ.getOriginCommentTextView().setTextSize(1, 15.0f * com.tencent.mm.bp.a.fe(bDQ.getContext()));
                    view = bDQ;
                }
                TranslateCommentTextView translateCommentTextView = (TranslateCommentTextView) view;
                view.setOnTouchListener(null);
                a(translateCommentTextView.getOriginCommentTextView(), charSequence);
                if (!aj.dDR) {
                    translateCommentTextView.oic.setTextSize(1, 15.0f * com.tencent.mm.bp.a.fe(translateCommentTextView.getContext()));
                    translateCommentTextView.nVv.xD(2);
                    translateCommentTextView.nVv.setVisibility(0);
                    obj2 = 1;
                    view2 = view;
                } else if (aj.dHC) {
                    translateCommentTextView.getTranslateResultView().setVisibility(8);
                    i2 = 1;
                    view2 = view;
                } else {
                    String str4 = aj.result;
                    String str5 = aj.dMB;
                    String charSequence2 = translateCommentTextView.oic.getText().toString();
                    if (!bi.oW(charSequence2)) {
                        String[] strArr;
                        String[] split = charSequence2.split(":");
                        if (split.length > 2) {
                            strArr = new String[]{split[0], charSequence2.substring(r2[0].length() + 1)};
                        } else {
                            strArr = split;
                        }
                        if (strArr.length == 2) {
                            if (bi.oW(str4)) {
                                translateCommentTextView.nVv.a(aj, 2, null, str5, aj.nrH);
                            } else {
                                translateCommentTextView.nVv.a(aj, 2, strArr[0] + ": " + str4, str5, aj.nrH);
                            }
                            translateCommentTextView.nVv.setVisibility(0);
                        }
                        translateCommentTextView.oic.setTextSize(1, 15.0f * com.tencent.mm.bp.a.fe(translateCommentTextView.getContext()));
                    }
                    i2 = 1;
                    view2 = view;
                }
            } else {
                if (obj == null && (view instanceof TranslateCommentTextView)) {
                    linearLayout.removeView(view);
                    SnsCommentPreloadTextView bDQ2 = this.nuc.bDQ();
                    linearLayout.addView(bDQ2, i3);
                    bDQ2.setTextSize$255e752(15.0f * com.tencent.mm.bp.a.fe(bDQ2.getContext()));
                    view = bDQ2;
                }
                view.setOnTouchListener(new m(this.mActivity));
                a(view, charSequence);
                obj2 = null;
                view2 = view;
            }
            view2.setBackgroundResource(e.sns_timeline_comment_bg);
            if (i3 > 0) {
                if (obj2 != null) {
                    view2.setPadding(0, com.tencent.mm.bp.a.fromDPToPix(this.mActivity, 2), 0, com.tencent.mm.bp.a.fromDPToPix(this.mActivity, 7));
                } else {
                    view2.setPadding(0, com.tencent.mm.bp.a.fromDPToPix(this.mActivity, 2), 0, com.tencent.mm.bp.a.fromDPToPix(this.mActivity, 3));
                }
            } else if (obj2 != null) {
                view2.setPadding(0, 1, 0, com.tencent.mm.bp.a.fromDPToPix(this.mActivity, 7));
            } else {
                view2.setPadding(0, 1, 0, com.tencent.mm.bp.a.fromDPToPix(this.mActivity, 3));
            }
            if (obj2 != null) {
                i = (int) this.mActivity.getResources().getDimension(d.SmallPadding);
                ((TranslateCommentTextView) view2).nVv.getSplitlineView().setPadding(0, 0, i, 0);
            }
            view2.setOnLongClickListener(new 3(this, view2));
            view2.setOnClickListener(new com.tencent.mm.plugin.sns.ui.j.a(this.nuc.obV, bon, str2, str3, cVar));
            if (ayVar != null) {
                view2.setTag(new com.tencent.mm.plugin.sns.ui.m(ayVar.oev, bon, str, str3, view2, 1));
            }
            if (obj != null) {
                linearLayout.addView(view2);
            }
            i2 = i3 + 1;
            i = i4 + 1;
        }
    }

    private static void a(View view, CharSequence charSequence) {
        if (view instanceof SnsCommentPreloadTextView) {
            ((SnsCommentPreloadTextView) view).setText(charSequence);
        } else if (view instanceof TextView) {
            ((TextView) view).setText(charSequence);
        }
    }

    private b aj(String str, long j) {
        if (this.oiD.size() <= 0) {
            return null;
        }
        Iterator it = this.oiD.iterator();
        while (it.hasNext()) {
            b bVar = (b) it.next();
            if (bVar.id != null && bVar.id.equals(ap.ez(str, String.valueOf(j)))) {
                return bVar;
            }
        }
        return null;
    }
}
