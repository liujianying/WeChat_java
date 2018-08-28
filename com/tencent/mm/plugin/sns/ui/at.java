package com.tencent.mm.plugin.sns.ui;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AbsListView.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.kernel.g;
import com.tencent.mm.l.a;
import com.tencent.mm.plugin.messenger.foundation.a.i;
import com.tencent.mm.plugin.sns.g.b;
import com.tencent.mm.plugin.sns.i.c;
import com.tencent.mm.plugin.sns.i.e;
import com.tencent.mm.plugin.sns.i.f;
import com.tencent.mm.plugin.sns.i.h;
import com.tencent.mm.plugin.sns.i.j;
import com.tencent.mm.plugin.sns.lucky.a.m;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.plugin.sns.model.aj;
import com.tencent.mm.plugin.sns.model.am;
import com.tencent.mm.plugin.sns.storage.n;
import com.tencent.mm.plugin.sns.storage.v;
import com.tencent.mm.protocal.c.ate;
import com.tencent.mm.protocal.c.avq;
import com.tencent.mm.protocal.c.boy;
import com.tencent.mm.protocal.c.bsu;
import com.tencent.mm.protocal.c.vu;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.av;
import com.tencent.mm.storage.ay;
import com.tencent.mm.ui.widget.QFadeImageView;
import com.tencent.mm.ui.y;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

@SuppressLint({"UseSparseArrays"})
public final class at extends BaseAdapter {
    boolean bNu = false;
    private Activity bOb;
    private String country;
    String iKw = "";
    private String kCA = "";
    List<n> list = new ArrayList();
    Map<Integer, Integer> nKG = new HashMap();
    Map<Integer, Integer> nKH = new HashMap();
    int nKI = 0;
    int nKJ = 0;
    String nQU = "";
    private ay nUe = null;
    private av nZC;
    Map<Integer, Integer> nZD = new HashMap();
    private f nZE;
    boolean nZF = false;
    au nZG;
    private c nZH;
    int nZI = Integer.MAX_VALUE;
    int nZJ = 0;
    private long nZK = 0;
    private long nZL = 0;
    int nZM = 0;
    protected OnClickListener nZN = new 6(this);
    private String userName = "";

    public final void fn(long j) {
        if (0 == this.nZK) {
            this.nZK = j;
            this.nZL = 0;
        }
    }

    public at(Activity activity, f fVar, String str, c cVar) {
        this.userName = str;
        this.bOb = activity;
        this.nZE = fVar;
        this.nZH = cVar;
        this.nUe = af.byc();
        String d = w.d(this.bOb.getSharedPreferences(ad.chY(), 0));
        x.d("MicroMsg.SnsphotoAdapter", "filterLan temp " + d);
        if (!(d.equals("zh_CN") || d.equals("en") || d.equals("zh_TW"))) {
            d = d.equals("zh_HK") ? "zh_TW" : "en";
        }
        this.kCA = d;
        this.country = w.d(this.bOb.getSharedPreferences(ad.chY(), 0));
        g.Ek();
        if (this.userName.equals((String) g.Ei().DT().get(2, null))) {
            this.bNu = true;
        }
        x.d("MicroMsg.SnsphotoAdapter", "SnsphotoAdapter : userName : " + this.userName + " country: " + this.country);
        if (this.bNu) {
            this.nZC = av.clV();
        } else {
            g.Ek();
            ab Yg = ((i) g.l(i.class)).FR().Yg(str);
            if (Yg == null || !a.gd(Yg.field_type)) {
                this.nZC = av.clW();
            } else {
                this.nZC = av.clU();
            }
        }
        this.nZG = new au(new 1(this, cVar), str, this.bNu);
        fo(0);
        is(false);
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        int itemViewType = getItemViewType(i);
        x.i("MicroMsg.SnsphotoAdapter", "position " + itemViewType);
        d dVar;
        int i2;
        n nVar;
        int i3;
        bsu bAJ;
        CharSequence charSequence;
        a aVar;
        a aVar2;
        if (itemViewType == 0) {
            if (view == null || view.getTag() == null || !(view.getTag() instanceof d)) {
                dVar = new d(this);
                view = y.gq(this.bOb).inflate(com.tencent.mm.plugin.sns.i.g.sns_photo_user_photo, null);
                dVar.nZS = (TextView) view.findViewById(f.sns_day);
                dVar.nZR = (TextView) view.findViewById(f.sns_month);
                dVar.oab = (MaskImageView) view.findViewById(f.img1);
                dVar.oac = (QFadeImageView) view.findViewById(f.take_photo);
                dVar.oad = (MaskImageView) view.findViewById(f.img2);
                dVar.oae = (MaskImageView) view.findViewById(f.img3);
                dVar.nDf = (TextView) view.findViewById(f.desc);
                dVar.oaf = (TextView) view.findViewById(f.with_username1);
                dVar.oag = (TextView) view.findViewById(f.with_username2);
                dVar.oah = (TextView) view.findViewById(f.with_username3);
                dVar.oai = (TextView) view.findViewById(f.img_count);
                dVar.oaj = view.findViewById(f.desc_count);
                dVar.nZV = (TextView) view.findViewById(f.address);
                dVar.nZT = (LinearLayout) view.findViewById(f.line_add_item);
                dVar.nZU = (ImageView) view.findViewById(f.lock_line_add_item_b);
                dVar.nKX = (LinearLayout) view.findViewById(f.listener_keeper);
                dVar.nKY = view.findViewById(f.line_add);
                dVar.oac.setOnClickListener(this.nZE.nKO);
                dVar.oab.setOnClickListener(this.nZE.nKO);
                dVar.oad.setOnClickListener(this.nZE.nKP);
                dVar.oae.setOnClickListener(this.nZE.nKQ);
                dVar.oak = (TextView) view.findViewById(f.warn1);
                dVar.oal = (TextView) view.findViewById(f.warn2);
                dVar.oam = (TextView) view.findViewById(f.warn3);
                dVar.oan = (TextView) view.findViewById(f.tv1);
                dVar.oao = (TextView) view.findViewById(f.tv2);
                dVar.oap = (TextView) view.findViewById(f.tv3);
                dVar.oaq = (MaskLinearLayout) view.findViewById(f.sns_line_blackground);
                dVar.oaq.b(dVar.oab);
                dVar.nZW = (LinearLayout) view.findViewById(f.friends_limit);
                dVar.nZX = (TextView) view.findViewById(f.sns_no_see_tip_reset_tips_btn);
                dVar.nZX.setOnClickListener(new 3(this));
                view.setTag(dVar);
            } else {
                dVar = (d) view.getTag();
            }
            af.byl().cx(dVar.oab);
            af.byl().cx(dVar.oad);
            af.byl().cx(dVar.oae);
            i2 = -1;
            if (this.nKG.get(Integer.valueOf(i)) != null) {
                i2 = ((Integer) this.nKG.get(Integer.valueOf(i))).intValue();
            }
            dVar.init();
            dVar.oaq.settouchEnable(false);
            dVar.oaq.setBackgroundResource(0);
            dVar.oaq.setDescendantFocusability(131072);
            dVar.oaq.setClickable(false);
            dVar.oab.settouchEnable(true);
            dVar.oab.setClickable(true);
            dVar.oaq.setOnClickListener(null);
            if (i2 >= this.nKJ || i2 == -1) {
                view.setLayoutParams(new LayoutParams(-1, 1));
                view.setVisibility(8);
            } else {
                if (i2 - 1 >= 0) {
                    nVar = (n) getItem(i2 - 1);
                    i3 = nVar.field_head;
                    aj.O(nVar.field_localPrivate, this.bNu);
                } else {
                    i3 = -1;
                }
                view.setLayoutParams(new LayoutParams(-1, -2));
                view.setVisibility(0);
                int intValue = this.nKH.get(Integer.valueOf(i)) != null ? ((Integer) this.nKH.get(Integer.valueOf(i))).intValue() : 1;
                n nVar2 = (n) getItem(i2);
                bAJ = nVar2.bAJ();
                if ((this.bNu && i == 0) || i3 == -1 || nVar2.field_head != i3) {
                    a(dVar.nZR, dVar.nZS, (long) nVar2.field_createTime);
                    if (bAJ.sqa != null) {
                        charSequence = bAJ.sqa.eJJ;
                        if (!(charSequence == null || charSequence.equals(""))) {
                            dVar.nZV.setText(charSequence);
                            dVar.nZV.setVisibility(0);
                        }
                    }
                    dVar.nKY.setVisibility(0);
                }
                if (this.nZL != 0 && nVar2.field_snsId == this.nZL) {
                    dVar.nZW.setVisibility(0);
                } else if (this.nZL != 0 || this.nZK == 0 || nVar2.field_snsId > this.nZK) {
                    dVar.nZW.setVisibility(8);
                } else {
                    dVar.nZW.setVisibility(0);
                    this.nZL = nVar2.field_snsId;
                }
                dVar.nZT.setVisibility(0);
                if (this.bNu && i == 0) {
                    dVar.oac.setVisibility(0);
                    dVar.oac.setContentDescription(this.bOb.getString(j.sns_take_photo));
                    dVar.oab.setVisibility(8);
                    dVar.nDf.setText(this.nKI == 1 ? this.bOb.getString(j.sns_user_start) : "");
                    dVar.nDf.setVisibility(0);
                    dVar.oaj.setVisibility(0);
                    dVar.oai.setVisibility(8);
                    af.byl().a(dVar.oac, c.dialog_msg_color, e.sns_takephoto_icon, this.bOb.hashCode());
                    aVar = new a();
                    aVar.nkZ = -1;
                    aVar.position = -1;
                    dVar.oac.setTag(aVar);
                } else {
                    if (intValue > 0) {
                        a(i2, dVar.oab, dVar.oaf, dVar.oai, dVar.oak, dVar.oan, 1, dVar, i);
                    }
                    if (intValue >= 2) {
                        a(i2 + 1, dVar.oad, dVar.oag, dVar.oai, dVar.oal, dVar.oao, 2, dVar, i);
                    }
                    if (intValue >= 3) {
                        a(i2 + 2, dVar.oae, dVar.oah, dVar.oai, dVar.oam, dVar.oap, 3, dVar, i);
                    }
                    if (intValue == 1) {
                        nVar = (n) getItem(i2);
                        if (!bi.oW(nVar.bAJ().spZ) && nVar.field_type == 1) {
                            dVar.oaq.setDescendantFocusability(393216);
                            dVar.oaq.setClickable(true);
                            dVar.oab.setClickable(false);
                            dVar.oab.settouchEnable(false);
                            dVar.oaq.setOnClickListener(this.nZE.nKO);
                            dVar.oaq.settouchEnable(true);
                            itemViewType = nVar2.nJc;
                            aVar2 = new a();
                            aVar2.nkZ = itemViewType;
                            if (this.nZD.get(Integer.valueOf(i)) != null) {
                                aVar2.position = ((Integer) this.nZD.get(Integer.valueOf(i))).intValue();
                            } else {
                                aVar2.position = 0;
                            }
                            dVar.oaq.setTag(aVar2);
                        }
                    }
                    view.setDrawingCacheEnabled(false);
                }
            }
        } else {
            if (itemViewType == 2) {
                e eVar;
                if (view == null || view.getTag() == null || !(view.getTag() instanceof e)) {
                    e eVar2 = new e(this);
                    view = y.gq(this.bOb).inflate(com.tencent.mm.plugin.sns.i.g.sns_sight_user, null);
                    eVar2.nZS = (TextView) view.findViewById(f.sns_day);
                    eVar2.nZR = (TextView) view.findViewById(f.sns_month);
                    eVar2.oab = (MaskImageView) view.findViewById(f.img1);
                    eVar2.nZV = (TextView) view.findViewById(f.address);
                    eVar2.nZT = (LinearLayout) view.findViewById(f.line_add_item);
                    eVar2.nZU = (ImageView) view.findViewById(f.lock_line_add_item_b);
                    eVar2.nKX = (LinearLayout) view.findViewById(f.listener_keeper);
                    eVar2.nKY = view.findViewById(f.line_add);
                    eVar2.oab.setOnClickListener(this.nZE.oat);
                    eVar2.oak = (TextView) view.findViewById(f.warn1);
                    eVar2.oaq = (MaskLinearLayout) view.findViewById(f.sns_line_blackground);
                    eVar2.oaq.b(eVar2.oab);
                    eVar2.nDf = (TextView) view.findViewById(f.desc);
                    eVar2.oaj = view.findViewById(f.desc_count);
                    eVar2.nZW = (LinearLayout) view.findViewById(f.friends_limit);
                    eVar2.nZX = (TextView) view.findViewById(f.sns_no_see_tip_reset_tips_btn);
                    eVar2.nZX.setOnClickListener(new 2(this));
                    view.setTag(eVar2);
                    eVar = eVar2;
                } else {
                    eVar = (e) view.getTag();
                }
                af.byl().cx(eVar.oab);
                int intValue2 = this.nKG.get(Integer.valueOf(i)) != null ? ((Integer) this.nKG.get(Integer.valueOf(i))).intValue() : -1;
                eVar.init();
                eVar.oaq.settouchEnable(false);
                eVar.oaq.setBackgroundResource(0);
                eVar.oaq.setDescendantFocusability(131072);
                eVar.oaq.setClickable(false);
                eVar.oab.settouchEnable(true);
                eVar.oab.setClickable(true);
                eVar.oaq.setOnClickListener(null);
                if (intValue2 >= this.nKJ || intValue2 == -1) {
                    view.setLayoutParams(new LayoutParams(-1, 1));
                    view.setVisibility(8);
                } else {
                    if (intValue2 - 1 >= 0) {
                        nVar = (n) getItem(intValue2 - 1);
                        i2 = nVar.field_head;
                        aj.O(nVar.field_localPrivate, this.bNu);
                    } else {
                        i2 = -1;
                    }
                    view.setLayoutParams(new LayoutParams(-1, -2));
                    view.setVisibility(0);
                    if (this.nKH.get(Integer.valueOf(i)) != null) {
                        ((Integer) this.nKH.get(Integer.valueOf(i))).intValue();
                    }
                    n nVar3 = (n) getItem(intValue2);
                    bsu bAJ2 = nVar3.bAJ();
                    if ((this.bNu && i == 0) || r3 == -1 || nVar3.field_head != r3) {
                        a(eVar.nZR, eVar.nZS, (long) nVar3.field_createTime);
                        if (bAJ2.sqa != null) {
                            charSequence = bAJ2.sqa.eJJ;
                            if (!(charSequence == null || charSequence.equals(""))) {
                                eVar.nZV.setText(charSequence);
                                eVar.nZV.setVisibility(0);
                            }
                        }
                        eVar.nKY.setVisibility(0);
                    }
                    if (this.nZL != 0 && nVar3.field_snsId == this.nZL) {
                        eVar.nZW.setVisibility(0);
                    } else if (this.nZL != 0 || this.nZK == 0 || nVar3.field_snsId > this.nZK) {
                        eVar.nZW.setVisibility(8);
                    } else {
                        eVar.nZW.setVisibility(0);
                        this.nZL = nVar3.field_snsId;
                    }
                    eVar.nZT.setVisibility(0);
                    aj.n(nVar3);
                    av avVar = new av(this.nZC.tag);
                    avVar.time = nVar3.field_createTime;
                    eVar.oab.setVisibility(0);
                    af.byl().a(bAJ2.sqc.ruA, eVar.oab, this.bOb.hashCode(), com.tencent.mm.plugin.sns.model.g.a.nnB, avVar);
                    if (aj.O(nVar3.field_localPrivate, this.bNu)) {
                        eVar.oak.setVisibility(0);
                        eVar.oak.setBackgroundResource(e.personactivity_keyphoto_icon);
                        ab Yg = this.nUe.Yg(nVar3.field_userName);
                        if (Yg != null) {
                            Yg.BL();
                        }
                    }
                    charSequence = ((n) getItem(intValue2)).bAJ().spZ;
                    if (!(charSequence == null || charSequence.equals(""))) {
                        eVar.oaj.setVisibility(0);
                        eVar.nDf.setVisibility(0);
                        eVar.nDf.setText(charSequence);
                        eVar.nDf.setText(com.tencent.mm.pluginsdk.ui.d.j.a(this.bOb, charSequence, eVar.nDf.getTextSize()));
                    }
                    eVar.oaq.setDescendantFocusability(393216);
                    eVar.oaq.setClickable(true);
                    eVar.oab.setClickable(false);
                    eVar.oab.settouchEnable(false);
                    eVar.oaq.setOnClickListener(this.nZE.oat);
                    eVar.oaq.settouchEnable(true);
                    itemViewType = nVar3.nJc;
                    aVar2 = new a();
                    aVar2.nkZ = itemViewType;
                    if (this.nZD.get(Integer.valueOf(i)) != null) {
                        aVar2.position = ((Integer) this.nZD.get(Integer.valueOf(i))).intValue();
                    } else {
                        aVar2.position = 0;
                    }
                    eVar.oaq.setTag(aVar2);
                }
            } else if (itemViewType == 3) {
                if (view == null || view.getTag() == null || !(view.getTag() instanceof d)) {
                    dVar = new d(this);
                    view = y.gq(this.bOb).inflate(com.tencent.mm.plugin.sns.i.g.sns_photo_user_photo, null);
                    dVar.nZS = (TextView) view.findViewById(f.sns_day);
                    dVar.nZR = (TextView) view.findViewById(f.sns_month);
                    dVar.oab = (MaskImageView) view.findViewById(f.img1);
                    dVar.oac = (QFadeImageView) view.findViewById(f.take_photo);
                    dVar.oad = (MaskImageView) view.findViewById(f.img2);
                    dVar.oae = (MaskImageView) view.findViewById(f.img3);
                    dVar.nDf = (TextView) view.findViewById(f.desc);
                    dVar.oaf = (TextView) view.findViewById(f.with_username1);
                    dVar.oag = (TextView) view.findViewById(f.with_username2);
                    dVar.oah = (TextView) view.findViewById(f.with_username3);
                    dVar.oai = (TextView) view.findViewById(f.img_count);
                    dVar.oaj = view.findViewById(f.desc_count);
                    dVar.nZV = (TextView) view.findViewById(f.address);
                    dVar.nZT = (LinearLayout) view.findViewById(f.line_add_item);
                    dVar.nZU = (ImageView) view.findViewById(f.lock_line_add_item_b);
                    dVar.nKX = (LinearLayout) view.findViewById(f.listener_keeper);
                    dVar.nKY = view.findViewById(f.line_add);
                    dVar.oac.setOnClickListener(this.nZE.oas);
                    dVar.oab.setOnClickListener(this.nZE.oas);
                    dVar.oak = (TextView) view.findViewById(f.warn1);
                    dVar.oal = (TextView) view.findViewById(f.warn2);
                    dVar.oam = (TextView) view.findViewById(f.warn3);
                    dVar.oan = (TextView) view.findViewById(f.tv1);
                    dVar.oao = (TextView) view.findViewById(f.tv2);
                    dVar.oap = (TextView) view.findViewById(f.tv3);
                    dVar.oaq = (MaskLinearLayout) view.findViewById(f.sns_line_blackground);
                    dVar.oaq.b(dVar.oab);
                    dVar.nZW = (LinearLayout) view.findViewById(f.friends_limit);
                    dVar.nZX = (TextView) view.findViewById(f.sns_no_see_tip_reset_tips_btn);
                    dVar.nZX.setOnClickListener(new 5(this));
                    view.setTag(dVar);
                } else {
                    dVar = (d) view.getTag();
                }
                af.byl().cx(dVar.oab);
                af.byl().cx(dVar.oad);
                af.byl().cx(dVar.oae);
                i2 = -1;
                if (this.nKG.get(Integer.valueOf(i)) != null) {
                    i2 = ((Integer) this.nKG.get(Integer.valueOf(i))).intValue();
                }
                dVar.init();
                dVar.oaq.settouchEnable(false);
                dVar.oaq.setBackgroundResource(0);
                dVar.oaq.setDescendantFocusability(131072);
                dVar.oaq.setClickable(false);
                dVar.oab.settouchEnable(true);
                dVar.oab.setClickable(true);
                dVar.oaq.setOnClickListener(null);
                if (i2 >= this.nKJ || i2 == -1) {
                    view.setLayoutParams(new LayoutParams(-1, 1));
                    view.setVisibility(8);
                } else {
                    if (i2 - 1 >= 0) {
                        nVar = (n) getItem(i2 - 1);
                        i3 = nVar.field_head;
                        aj.O(nVar.field_localPrivate, this.bNu);
                    } else {
                        i3 = -1;
                    }
                    view.setLayoutParams(new LayoutParams(-1, -2));
                    view.setVisibility(0);
                    n nVar4 = (n) getItem(i2);
                    bAJ = nVar4.bAJ();
                    if ((this.bNu && i == 0) || r4 == -1 || nVar4.field_head != r4) {
                        a(dVar.nZR, dVar.nZS, (long) nVar4.field_createTime);
                        if (bAJ.sqa != null) {
                            charSequence = bAJ.sqa.eJJ;
                            if (!(charSequence == null || charSequence.equals(""))) {
                                dVar.nZV.setText(charSequence);
                                dVar.nZV.setVisibility(0);
                            }
                        }
                        dVar.nKY.setVisibility(0);
                    }
                    if (this.nZL != 0 && nVar4.field_snsId == this.nZL) {
                        dVar.nZW.setVisibility(0);
                    } else if (this.nZL != 0 || this.nZK == 0 || nVar4.field_snsId > this.nZK) {
                        dVar.nZW.setVisibility(8);
                    } else {
                        dVar.nZW.setVisibility(0);
                        this.nZL = nVar4.field_snsId;
                    }
                    dVar.nZT.setVisibility(0);
                    if (this.bNu && i == 0) {
                        dVar.oac.setVisibility(0);
                        dVar.oac.setContentDescription(this.bOb.getString(j.sns_take_photo));
                        dVar.oab.setVisibility(8);
                        dVar.nDf.setText(this.nKI == 1 ? this.bOb.getString(j.sns_user_start) : "");
                        dVar.nDf.setVisibility(0);
                        dVar.oaj.setVisibility(0);
                        dVar.oai.setVisibility(8);
                        af.byl().a(dVar.oac, c.dialog_msg_color, e.sns_takephoto_icon, this.bOb.hashCode());
                        aVar = new a();
                        aVar.nkZ = -1;
                        aVar.position = -1;
                        dVar.oac.setTag(aVar);
                    } else {
                        a(i2, dVar.oab, dVar.oaf, dVar.oai, dVar.oak, dVar.oan, 1, dVar, i);
                        nVar = (n) getItem(i2);
                        if (!bi.oW(nVar.bAJ().spZ) && nVar.field_type == 1) {
                            dVar.oaq.setDescendantFocusability(393216);
                            dVar.oaq.setClickable(true);
                            dVar.oab.setClickable(false);
                            dVar.oab.settouchEnable(false);
                            dVar.oaq.setOnClickListener(this.nZE.oas);
                            dVar.oaq.settouchEnable(true);
                            itemViewType = nVar4.nJc;
                            aVar2 = new a();
                            aVar2.nkZ = itemViewType;
                            if (this.nZD.get(Integer.valueOf(i)) != null) {
                                aVar2.position = ((Integer) this.nZD.get(Integer.valueOf(i))).intValue();
                            } else {
                                aVar2.position = 0;
                            }
                            dVar.oaq.setTag(aVar2);
                        }
                        view.setDrawingCacheEnabled(false);
                    }
                }
            } else {
                b bVar;
                if (view == null || view.getTag() == null || !(view.getTag() instanceof b)) {
                    b bVar2 = new b(this);
                    view = y.gq(this.bOb).inflate(com.tencent.mm.plugin.sns.i.g.sns_photo_user_normal, null);
                    bVar2.nZQ = view.findViewById(f.content_ll);
                    bVar2.nZS = (TextView) view.findViewById(f.sns_day);
                    bVar2.nZR = (TextView) view.findViewById(f.sns_month);
                    bVar2.nZV = (TextView) view.findViewById(f.address);
                    bVar2.nKY = view.findViewById(f.line_add);
                    bVar2.nZV = (TextView) view.findViewById(f.address);
                    bVar2.nZT = (LinearLayout) view.findViewById(f.line_add_item);
                    bVar2.nZU = (ImageView) view.findViewById(f.lock_line_add_item_b);
                    bVar2.nKX = (LinearLayout) view.findViewById(f.listener_keeper);
                    bVar2.fAK = (TextView) view.findViewById(f.desc_tv);
                    bVar2.nZY = (TagImageView) view.findViewById(f.image_left);
                    bVar2.nLz = (ImageView) view.findViewById(f.state);
                    bVar2.eBO = (TextView) view.findViewById(f.titletext);
                    bVar2.nZZ = (TextView) view.findViewById(f.righttext);
                    bVar2.nZQ.setOnClickListener(this.nZE.oar);
                    bVar2.oaa = view.findViewById(f.media_content_rl);
                    bVar2.nZW = (LinearLayout) view.findViewById(f.friends_limit);
                    bVar2.nZX = (TextView) view.findViewById(f.sns_no_see_tip_reset_tips_btn);
                    bVar2.nZX.setOnClickListener(new 4(this));
                    view.setTag(bVar2);
                    com.tencent.mm.plugin.sns.data.i.b(bVar2.nZY, this.bOb);
                    bVar = bVar2;
                } else {
                    bVar = (b) view.getTag();
                }
                i2 = this.nKG.get(Integer.valueOf(i)) != null ? ((Integer) this.nKG.get(Integer.valueOf(i))).intValue() : -1;
                bVar.init();
                if (i2 >= this.nKJ || i2 == -1) {
                    view.setLayoutParams(new LayoutParams(-1, 1));
                    view.setVisibility(8);
                } else {
                    view.setVisibility(0);
                    if (i2 - 1 >= 0) {
                        nVar = (n) getItem(i2 - 1);
                        i3 = nVar.field_head;
                        aj.O(nVar.field_localPrivate, this.bNu);
                    } else {
                        i3 = -1;
                    }
                    view.setLayoutParams(new LayoutParams(-1, -2));
                    view.setVisibility(0);
                    if (this.nKH.get(Integer.valueOf(i)) != null) {
                        ((Integer) this.nKH.get(Integer.valueOf(i))).intValue();
                    }
                    n nVar5 = (n) getItem(i2);
                    bsu bAJ3 = nVar5.bAJ();
                    if ((this.bNu && i == 0) || r4 == -1 || nVar5.field_head != r4) {
                        a(bVar.nZR, bVar.nZS, (long) nVar5.field_createTime);
                        if (bAJ3.sqa != null) {
                            charSequence = bAJ3.sqa.eJJ;
                            if (!(charSequence == null || charSequence.equals(""))) {
                                bVar.nZV.setText(charSequence);
                                bVar.nZV.setVisibility(0);
                            }
                        }
                        bVar.nKY.setVisibility(0);
                    }
                    if (this.nZL != 0 && nVar5.field_snsId == this.nZL) {
                        bVar.nZW.setVisibility(0);
                    } else if (this.nZL != 0 || this.nZK == 0 || nVar5.field_snsId > this.nZK) {
                        bVar.nZW.setVisibility(8);
                    } else {
                        bVar.nZW.setVisibility(0);
                        this.nZL = nVar5.field_snsId;
                    }
                    a aVar3 = new a();
                    aVar3.nkZ = nVar5.nJc;
                    if (this.nZD.get(Integer.valueOf(i)) != null) {
                        aVar3.position = ((Integer) this.nZD.get(Integer.valueOf(i))).intValue();
                    } else {
                        aVar3.position = 0;
                    }
                    bVar.nZQ.setTag(aVar3);
                    if (bi.oW(bAJ3.spZ)) {
                        bVar.fAK.setVisibility(8);
                    } else {
                        bVar.fAK.setVisibility(0);
                        bVar.fAK.setText(bAJ3.spZ);
                        bVar.fAK.setText(com.tencent.mm.pluginsdk.ui.d.j.a(this.bOb, bAJ3.spZ, bVar.fAK.getTextSize()));
                    }
                    bVar.nZT.setVisibility(0);
                    bVar.fAK.setSingleLine(true);
                    bVar.oaa.setVisibility(0);
                    itemViewType = bAJ3.sqc.ruz;
                    av avVar2 = new av(this.nZC.tag);
                    avVar2.time = nVar5.field_createTime;
                    ate ate;
                    if (itemViewType == 2) {
                        bVar.fAK.setVisibility(0);
                        bVar.fAK.setSingleLine(false);
                        bVar.fAK.setMaxLines(2);
                        bVar.oaa.setVisibility(8);
                    } else if (itemViewType != 4) {
                        CharSequence Oa;
                        CharSequence charSequence2;
                        bVar.eBO.setTextColor(this.bOb.getResources().getColor(c.self_sns_link));
                        if (((am.a.byN() & 1) <= 0 ? 1 : null) != null) {
                            Oa = av.Oa(bAJ3.sqc.jPK);
                        } else {
                            Object Oa2 = "";
                        }
                        String str = bAJ3.sqc.bHD;
                        if (str == null || str.length() <= 40) {
                            Object charSequence22 = str;
                        } else {
                            charSequence22 = str.substring(0, 40) + "...";
                        }
                        if (bVar.nZY != null) {
                            bVar.nZY.setOnClickListener(null);
                        }
                        bVar.nLz.setVisibility(8);
                        if (!bAJ3.sqc.ruA.isEmpty()) {
                            bVar.nZY.setVisibility(0);
                            ate = (ate) bAJ3.sqc.ruA.get(0);
                            if (bAJ3.sqc.ruz == 5) {
                                Oa2 = av.Oa(ate.jPK);
                                charSequence22 = ate.bHD;
                                bVar.nLz.setVisibility(0);
                                af.byl().a(ate, bVar.nZY, com.tencent.mm.plugin.sns.i.i.app_attach_file_icon_video, this.bOb.hashCode(), com.tencent.mm.plugin.sns.model.g.a.nnB, avVar2);
                            } else {
                                af.byl().a(ate, bVar.nZY, this.bOb.hashCode(), com.tencent.mm.plugin.sns.model.g.a.nnB, avVar2);
                            }
                        } else if (bAJ3.sqc.ruz != 26) {
                            bVar.nZY.setVisibility(8);
                        } else {
                            bVar.nZY.setVisibility(0);
                            bVar.nZY.setImageResource(com.tencent.mm.plugin.sns.i.i.note_sns_link_default);
                        }
                        if (bi.oW(Oa2)) {
                            bVar.nZZ.setVisibility(8);
                        } else {
                            bVar.nZZ.setVisibility(0);
                            bVar.nZZ.setText(Oa2);
                        }
                        if (bi.oW(charSequence22)) {
                            bVar.eBO.setVisibility(8);
                        } else {
                            if (bVar.nZZ.getVisibility() == 8) {
                                bVar.eBO.setMaxLines(2);
                            } else {
                                bVar.eBO.setMaxLines(1);
                            }
                            bVar.eBO.setVisibility(0);
                            if ((bAJ3.dwt & 1) > 0) {
                                bVar.eBO.setText(com.tencent.mm.plugin.sns.data.i.a(charSequence22, this.bOb, bVar.eBO));
                            } else {
                                bVar.eBO.setText(charSequence22);
                            }
                        }
                    } else if (bAJ3.sqc.ruA.isEmpty()) {
                        bVar.oaa.setVisibility(8);
                    } else {
                        bVar.nZY.setVisibility(0);
                        bVar.nLz.setVisibility(0);
                        bVar.oaa.setVisibility(0);
                        bVar.eBO.setMaxLines(1);
                        bVar.eBO.setTextColor(this.bOb.getResources().getColor(c.sns_link_color));
                        ate = (ate) bAJ3.sqc.ruA.get(0);
                        af.byl().a(ate, bVar.nZY, com.tencent.mm.plugin.sns.i.i.app_attach_file_icon_music, this.bOb.hashCode(), com.tencent.mm.plugin.sns.model.g.a.nnB, avVar2);
                        bVar.nLz.setPressed(false);
                        if (NZ(bAJ3.ksA)) {
                            bVar.nLz.setImageResource(e.music_pauseicon);
                        } else {
                            bVar.nLz.setImageResource(e.music_playicon);
                        }
                        bVar.nZY.setTag(bAJ3);
                        bVar.nZY.setOnClickListener(this.nZN);
                        ate.nkZ = nVar5.nJc;
                        bVar.oaa.setTag(bAJ3);
                        charSequence = ate.jOS;
                        if (bi.oW(charSequence)) {
                            bVar.nZZ.setVisibility(4);
                        } else {
                            bVar.nZZ.setVisibility(0);
                            bVar.nZZ.setText(charSequence);
                        }
                        charSequence = ate.bHD;
                        if (bi.oW(charSequence)) {
                            bVar.eBO.setVisibility(8);
                        } else {
                            bVar.eBO.setVisibility(0);
                            bVar.eBO.setTag(aVar3);
                            bVar.eBO.setOnTouchListener(new ab());
                            bVar.eBO.setText(charSequence);
                        }
                    }
                }
            }
            view.setDrawingCacheEnabled(false);
        }
        return view;
    }

    public final int getCount() {
        return this.nKI;
    }

    private void a(TextView textView, TextView textView2, long j) {
        String str = (String) az.a(this.bOb, 1000 * j, !this.kCA.equals("en"));
        String[] split;
        if (str.indexOf(":") > 0) {
            split = str.split(":");
            if (split[1].length() < 2) {
                split[1] = "0" + split[1];
            }
            textView.setText(split[0]);
            textView2.setText(split[1]);
            textView2.setVisibility(0);
            textView.setVisibility(0);
        } else if (str.indexOf("/") > 0) {
            split = str.split("/");
            if (split[1].length() < 2) {
                split[1] = "0" + split[1];
            }
            split[0] = az.v(this.bOb, split[0], this.kCA);
            textView.setText(split[0]);
            textView2.setText(split[1]);
            textView2.setVisibility(0);
            textView.setVisibility(0);
        } else {
            textView2.setVisibility(0);
            textView2.setText(str);
        }
    }

    public final int getItemViewType(int i) {
        if (this.bNu && i == 0) {
            x.d("MicroMsg.SnsphotoAdapter", "position isSelf " + i + " - 0");
            return 0;
        }
        int intValue;
        if (this.nKG.get(Integer.valueOf(i)) != null) {
            intValue = ((Integer) this.nKG.get(Integer.valueOf(i))).intValue();
        } else {
            intValue = -1;
        }
        if (intValue == -1) {
            x.e("MicroMsg.SnsphotoAdapter", "unknow error " + intValue);
            return 0;
        }
        n nVar = (n) getItem(intValue);
        if (nVar.bAJ().sqc.ruz == 1) {
            x.d("MicroMsg.SnsphotoAdapter", "position " + i + " - 0");
            return 0;
        } else if (nVar.bAJ().sqc.ruz != 15) {
            return nVar.bAJ().sqc.ruz == 21 ? 3 : 1;
        } else {
            x.d("MicroMsg.SnsphotoAdapter", "position " + i + " - 2");
            return 2;
        }
    }

    public final int getViewTypeCount() {
        return 4;
    }

    private void a(int i, QFadeImageView qFadeImageView, TextView textView, TextView textView2, TextView textView3, TextView textView4, int i2, d dVar, int i3) {
        CharSequence BL;
        n nVar = (n) getItem(i);
        bsu bAJ = nVar.bAJ();
        boy n = aj.n(nVar);
        Object obj = null;
        if (n != null && (((n.rXx & 2) == 2 && n.smW != null) || ((n.rXx & 4) == 4 && n.rWm != null))) {
            obj = 1;
        }
        if (!(!this.bNu || n == null || obj == null || this.userName == null || !this.userName.equals(nVar.field_userName))) {
            textView3.setBackgroundResource(e.personactivity_sharephoto_icon);
            textView3.setVisibility(0);
        }
        ab Yg;
        if (i2 == 1) {
            if (aj.O(nVar.field_localPrivate, this.bNu)) {
                textView3.setVisibility(0);
                textView3.setBackgroundResource(e.personactivity_keyphoto_icon);
                Yg = this.nUe.Yg(nVar.field_userName);
                BL = Yg == null ? "" : Yg.BL();
                if (!(BL.equals("") || this.userName.equals(nVar.field_userName))) {
                    textView.setVisibility(0);
                    textView.setText(BL);
                }
            }
        } else if (aj.O(nVar.field_localPrivate, this.bNu)) {
            textView3.setVisibility(0);
            textView3.setBackgroundResource(e.personactivity_keyphoto_icon);
            Yg = this.nUe.Yg(nVar.field_userName);
            BL = Yg == null ? "" : Yg.BL();
            if (!(BL == null || BL.equals("") || this.userName.equals(nVar.field_userName))) {
                textView.setVisibility(0);
                textView.setText(BL);
            }
        }
        int i4 = nVar.nJc;
        a aVar = new a();
        aVar.nkZ = i4;
        if (this.nZD.get(Integer.valueOf(i3)) != null) {
            aVar.position = ((Integer) this.nZD.get(Integer.valueOf(i3))).intValue();
        } else {
            aVar.position = 0;
        }
        qFadeImageView.setTag(aVar);
        av avVar = new av(this.nZC.tag);
        avVar.time = nVar.field_createTime;
        if (bAJ.sqc.ruz == 1) {
            qFadeImageView.setVisibility(0);
            af.byl().a(bAJ.sqc.ruA, qFadeImageView, this.bOb.hashCode(), com.tencent.mm.plugin.sns.model.g.a.nnB, avVar);
        } else if (bAJ.sqc.ruz == 2) {
            textView4.setText(bi.aG(bAJ.sqc.jOS, ""));
            textView4.setVisibility(0);
        } else if (bAJ.sqc.ruz == 21) {
            nVar.bAW();
            boolean z = true;
            if (this.bNu) {
                z = true;
            } else if (m.a(nVar, n)) {
                z = false;
            }
            qFadeImageView.setVisibility(0);
            af.byl().a(bAJ.sqc.ruA, qFadeImageView, this.bOb.hashCode(), com.tencent.mm.plugin.sns.model.g.a.nnB, avVar, z);
        }
        if (nVar.bxX() && nVar.bBg()) {
            textView3.setVisibility(0);
            textView3.setBackgroundResource(e.personactivity_failicon);
        }
        if (i2 == 1) {
            if (bAJ.sqc.ruA == null || bAJ.sqc.ruA.size() <= 1) {
                textView2.setVisibility(8);
            } else {
                dVar.oaj.setVisibility(0);
                textView2.setVisibility(0);
                textView2.setText(this.bOb.getResources().getQuantityString(h.sns_media_count, i4, new Object[]{Integer.valueOf(bAJ.sqc.ruA.size())}));
            }
            BL = bAJ.spZ;
            if (BL != null && !BL.equals("")) {
                dVar.oaj.setVisibility(0);
                dVar.nDf.setVisibility(0);
                dVar.nDf.setText(BL);
                dVar.nDf.setText(com.tencent.mm.pluginsdk.ui.d.j.a(this.bOb, BL, dVar.nDf.getTextSize()));
            }
        }
    }

    private void is(boolean z) {
        x.d("MicroMsg.SnsphotoAdapter", "limitSeq " + this.iKw);
        if (this.nZG != null) {
            this.nZG.g(this.iKw, this.nZF, z);
        }
    }

    public final void notifyDataSetChanged() {
        super.notifyDataSetChanged();
    }

    public final void bCb() {
        is(true);
        notifyDataSetChanged();
    }

    public final void bDI() {
        x.d("MicroMsg.SnsphotoAdapter", "i addSize ");
        fo(this.list.isEmpty() ? 0 : ((n) this.list.get(this.list.size() - 1)).field_snsId);
    }

    private void fo(long j) {
        at atVar;
        String eG = com.tencent.mm.plugin.sns.data.i.eG(af.byo().a(j, af.bye().Mo(this.userName), this.userName, this.bNu));
        if (this.nQU.equals("")) {
            atVar = this;
        } else if (eG.compareTo(this.nQU) < 0) {
            atVar = this;
        } else {
            eG = this.nQU;
            atVar = this;
        }
        atVar.iKw = eG;
        vu bAV = af.bys().Np(this.userName).bAV();
        if (bAV.rzb != 0) {
            eG = com.tencent.mm.plugin.sns.data.i.eG(bAV.rzb);
            if (this.iKw.equals("")) {
                this.iKw = eG;
                return;
            }
            if (eG.compareTo(this.iKw) <= 0) {
                eG = this.iKw;
            }
            this.iKw = eG;
        }
    }

    public final Object getItem(int i) {
        return this.list.get(i);
    }

    public final long getItemId(int i) {
        return 0;
    }

    public final ArrayList<b> dD(int i, int i2) {
        ArrayList<b> arrayList = new ArrayList();
        this.nZM = i2;
        for (int i3 = 0; i3 < this.list.size(); i3++) {
            n nVar = (n) this.list.get(i3);
            int i4 = nVar.nJc;
            if (!(nVar.bAJ() == null || nVar.bAJ().sqc == null || nVar.bAJ().sqc.ruA.size() == 0 || (nVar.bAJ().sqc.ruz != 1 && nVar.bAJ().sqc.ruz != 15))) {
                if (i4 == i) {
                    this.nZM = arrayList.size();
                }
                Iterator it = nVar.bAJ().sqc.ruA.iterator();
                int i5 = 0;
                while (it.hasNext()) {
                    ate ate = (ate) it.next();
                    b bVar = new b();
                    bVar.caK = ate;
                    bVar.nuP = v.ai("sns_table_", (long) i4);
                    bVar.dTR = nVar.field_createTime;
                    int i6 = i5 + 1;
                    bVar.nuQ = i5;
                    arrayList.add(bVar);
                    i5 = i6;
                }
            }
        }
        return arrayList;
    }

    protected static boolean NZ(String str) {
        avq Qa = com.tencent.mm.an.b.Qa();
        if (Qa != null && com.tencent.mm.an.b.d(Qa) && str.equals(Qa.rsp) && com.tencent.mm.an.b.PY()) {
            return true;
        }
        return false;
    }
}
