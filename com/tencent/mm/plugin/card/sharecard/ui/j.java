package com.tencent.mm.plugin.card.sharecard.ui;

import android.content.Context;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mars.smc.IDKey;
import com.tencent.mm.plugin.card.a.b;
import com.tencent.mm.plugin.card.a.d;
import com.tencent.mm.plugin.card.a.e;
import com.tencent.mm.plugin.card.a.g;
import com.tencent.mm.plugin.card.base.c;
import com.tencent.mm.plugin.card.d.l;
import com.tencent.mm.plugin.card.d.m;
import com.tencent.mm.plugin.card.widget.CardTagTextView;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.c.bsf;
import com.tencent.mm.protocal.c.pr;
import com.tencent.mm.sdk.platformtools.bi;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public final class j implements c {
    private ArrayList<Integer> hAA = new ArrayList();
    private ArrayList<String> hAB = new ArrayList();
    private ArrayList<String> hAC = new ArrayList();
    protected LinkedList<CardTagTextView> hAD = new LinkedList();
    private BaseAdapter hAv;
    private long hAw = 0;
    private long hAx = 0;
    private int hAy;
    private int hAz;
    private Context mContext;

    public class a {
        public LinearLayout hAE;
        public TextView hAF;
        public TextView hAG;
        public RelativeLayout hAH;
        public ImageView hAI;
        public TextView hAJ;
        public TextView hAK;
        public TextView hAL;
        public TextView hAM;
        public TextView hAN;
        public View hAO;
        public TextView hAP;
    }

    public j(Context context, BaseAdapter baseAdapter) {
        this.mContext = context;
        this.hAv = baseAdapter;
        this.hAy = this.mContext.getResources().getDimensionPixelSize(b.OneDPPadding);
        this.hAz = this.mContext.getResources().getDimensionPixelSize(b.MiddlePadding);
        this.hAA.clear();
        this.hAB.clear();
        this.hAC.clear();
    }

    public final void release() {
        this.mContext = null;
        this.hAv = null;
        if (this.hAx > 0) {
            ArrayList arrayList = new ArrayList();
            IDKey iDKey = new IDKey();
            iDKey.SetID(281);
            iDKey.SetKey(5);
            iDKey.SetValue(1);
            IDKey iDKey2 = new IDKey();
            iDKey2.SetID(281);
            iDKey2.SetKey(6);
            iDKey2.SetValue((long) ((int) (this.hAw / this.hAx)));
            arrayList.add(iDKey);
            arrayList.add(iDKey2);
            h.mEJ.b(arrayList, true);
        }
        if (this.hAA.size() == this.hAB.size() && this.hAB.size() == this.hAC.size() && this.hAA.size() > 0) {
            long currentTimeMillis = System.currentTimeMillis();
            for (int i = 0; i < this.hAA.size(); i++) {
                h.mEJ.h(13220, new Object[]{this.hAC.get(i), this.hAB.get(i), this.hAA.get(i), Long.valueOf(currentTimeMillis)});
            }
        }
        this.hAA.clear();
        this.hAB.clear();
        this.hAC.clear();
        if (this.hAD != null) {
            this.hAD.clear();
        }
    }

    public final View a(int i, View view, com.tencent.mm.plugin.card.base.b bVar) {
        a aVar;
        Object obj;
        long currentTimeMillis = System.currentTimeMillis();
        if (view == null) {
            view = View.inflate(this.mContext, e.card_share_card_item, null);
            a aVar2 = new a();
            aVar2.hAE = (LinearLayout) view.findViewById(d.card_tag_layout);
            aVar2.hAF = (TextView) view.findViewById(d.card_item_category_title);
            aVar2.hAG = (TextView) view.findViewById(d.card_item_subcategory_title);
            aVar2.hAH = (RelativeLayout) view.findViewById(d.card_container_parent);
            aVar2.hAI = (ImageView) view.findViewById(d.card_img);
            aVar2.hAJ = (TextView) view.findViewById(d.card_brand_name);
            aVar2.hAK = (TextView) view.findViewById(d.card_name);
            aVar2.hAO = view.findViewById(d.card_line);
            aVar2.hAL = (TextView) view.findViewById(d.subtitle);
            aVar2.hAM = (TextView) view.findViewById(d.card_announcement);
            aVar2.hAN = (TextView) view.findViewById(d.card_not_support_tip);
            aVar2.hAP = (TextView) view.findViewById(d.card_count_title);
            aVar2.hAL.setEllipsize(TruncateAt.MIDDLE);
            view.setTag(aVar2);
            aVar = aVar2;
        } else {
            aVar = (a) view.getTag();
        }
        com.tencent.mm.plugin.card.base.b bVar2 = (com.tencent.mm.plugin.card.base.b) this.hAv.getItem(i);
        int awv = bVar2.awv();
        if (com.tencent.mm.plugin.card.sharecard.a.b.nL(bVar2.awv())) {
            if (i == 0) {
                if (!TextUtils.isEmpty(bVar2.nF(awv))) {
                    obj = 1;
                    if (obj != null) {
                        aVar.hAF.setVisibility(0);
                        aVar.hAF.setText(bVar2.nF(awv));
                        if (TextUtils.isEmpty(bVar2.awu())) {
                            aVar.hAG.setVisibility(8);
                        } else {
                            aVar.hAG.setVisibility(0);
                            aVar.hAG.setText(bVar2.awu());
                        }
                    } else {
                        aVar.hAF.setVisibility(8);
                        aVar.hAG.setVisibility(8);
                        aVar.hAF.setText("");
                    }
                    if (bVar.avY()) {
                        aVar.hAI.setVisibility(0);
                        aVar.hAJ.setVisibility(0);
                        aVar.hAE.setVisibility(0);
                        aVar.hAK.setVisibility(0);
                        aVar.hAP.setVisibility(0);
                        aVar.hAO.setVisibility(0);
                        aVar.hAL.setVisibility(0);
                        aVar.hAM.setVisibility(0);
                        aVar.hAN.setVisibility(8);
                        aVar.hAJ.setText(bVar.awm().hwh);
                        if (!bVar.avV()) {
                            aVar.hAK.setText(bVar.awm().title);
                        } else if (bVar.awm().rnG != null && bVar.awm().rnG.size() == 1) {
                            aVar.hAK.setText(((pr) bVar.awm().rnG.get(0)).title);
                        } else if (bVar.awm().rnG != null && bVar.awm().rnG.size() == 2) {
                            StringBuilder stringBuilder = new StringBuilder();
                            stringBuilder.append(((pr) bVar.awm().rnG.get(0)).title);
                            stringBuilder.append("-");
                            stringBuilder.append(((pr) bVar.awm().rnG.get(1)).title);
                            aVar.hAK.setText(stringBuilder.toString());
                        }
                        m.a(aVar.hAI, bVar.awm().huW, this.mContext.getResources().getDimensionPixelSize(b.card_list_logo_height), com.tencent.mm.plugin.card.a.c.my_card_package_defaultlogo, true);
                        aVar.hAJ.setTextColor(this.mContext.getResources().getColor(com.tencent.mm.plugin.card.a.a.card_black_color));
                        CharSequence xt = com.tencent.mm.plugin.card.sharecard.a.b.xt(bVar.awr());
                        if (TextUtils.isEmpty(xt)) {
                            aVar.hAM.setText("");
                        } else {
                            aVar.hAM.setText(xt);
                        }
                        xt = com.tencent.mm.plugin.card.sharecard.a.b.ld(bVar.awr());
                        boolean nL = com.tencent.mm.plugin.card.sharecard.a.b.nL(bVar.awv());
                        if (!TextUtils.isEmpty(xt) && nL) {
                            aVar.hAL.setText(com.tencent.mm.pluginsdk.ui.d.j.a(this.mContext, xt, this.mContext.getResources().getDimensionPixelOffset(b.SmallerTextSize)));
                        } else if (TextUtils.isEmpty(bVar.aws())) {
                            aVar.hAL.setText("");
                        } else {
                            if (TextUtils.isEmpty(l.xY(bVar.aws()))) {
                                aVar.hAL.setText("");
                            } else {
                                aVar.hAL.setText(com.tencent.mm.pluginsdk.ui.d.j.a(this.mContext, this.mContext.getResources().getString(g.card_share_card_list_users, new Object[]{xt}), this.mContext.getResources().getDimensionPixelOffset(b.SmallerTextSize)));
                            }
                        }
                        int xu = com.tencent.mm.plugin.card.sharecard.a.b.xu(bVar.awr());
                        if (xu <= 1 || !nL) {
                            aVar.hAP.setVisibility(8);
                        } else {
                            aVar.hAP.setText("X" + xu);
                            aVar.hAP.setVisibility(0);
                        }
                        if ((bVar.awm().rnZ == null || bi.cX(bVar.awm().rnZ.stj)) && !com.tencent.mm.plugin.card.sharecard.a.b.xw(bVar.awr())) {
                            aVar.hAE.setVisibility(8);
                        } else {
                            aVar.hAE.setVisibility(0);
                            xu = 0;
                            while (true) {
                                int i2 = xu;
                                if (i2 >= aVar.hAE.getChildCount()) {
                                    break;
                                }
                                this.hAD.add((CardTagTextView) aVar.hAE.getChildAt(i2));
                                xu = i2 + 1;
                            }
                            aVar.hAE.removeAllViews();
                            if (com.tencent.mm.plugin.card.sharecard.a.b.xw(bVar.awr())) {
                                CardTagTextView ayb = ayb();
                                ayb.setPadding(this.hAz, this.hAy, this.hAz, this.hAy);
                                ayb.setTextColor(this.mContext.getResources().getColor(com.tencent.mm.plugin.card.a.a.red));
                                ayb.setText(this.mContext.getString(g.card_share_card_top_tips));
                                ayb.setTextSize(12.0f);
                                LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
                                layoutParams.rightMargin = this.mContext.getResources().getDimensionPixelOffset(b.LittlePadding);
                                aVar.hAE.addView(ayb, layoutParams);
                            }
                            if (!(bVar.awm().rnZ == null || bi.cX(bVar.awm().rnZ.stj))) {
                                Iterator it = bVar.awm().rnZ.stj.iterator();
                                while (it.hasNext()) {
                                    bsf bsf = (bsf) it.next();
                                    CardTagTextView ayb2 = ayb();
                                    ayb2.setPadding(this.hAz, this.hAy, this.hAz, this.hAy);
                                    ayb2.setTextColor(l.xV(bsf.dxh));
                                    ayb2.setText(bsf.tag);
                                    ayb2.setTextSize(12.0f);
                                    aVar.hAE.addView(ayb2);
                                }
                            }
                        }
                    } else {
                        aVar.hAI.setVisibility(8);
                        aVar.hAJ.setVisibility(8);
                        aVar.hAE.setVisibility(8);
                        aVar.hAK.setVisibility(8);
                        aVar.hAP.setVisibility(8);
                        aVar.hAO.setVisibility(8);
                        aVar.hAL.setVisibility(8);
                        aVar.hAM.setVisibility(8);
                        aVar.hAN.setVisibility(0);
                        aVar.hAN.setText(this.mContext.getResources().getString(g.card_not_support_card_type));
                    }
                    LinearLayout.LayoutParams layoutParams2;
                    if (i != this.hAv.getCount() - 1 && aVar.hAH != null) {
                        layoutParams2 = (LinearLayout.LayoutParams) aVar.hAH.getLayoutParams();
                        if (layoutParams2.bottomMargin != this.mContext.getResources().getDimensionPixelOffset(b.LittlePadding)) {
                            layoutParams2.bottomMargin = this.mContext.getResources().getDimensionPixelOffset(b.LittlePadding);
                            aVar.hAH.setLayoutParams(layoutParams2);
                        }
                    } else if (aVar.hAH != null) {
                        layoutParams2 = (LinearLayout.LayoutParams) aVar.hAH.getLayoutParams();
                        if (layoutParams2.bottomMargin != 0) {
                            layoutParams2.bottomMargin = 0;
                            aVar.hAH.setLayoutParams(layoutParams2);
                        }
                    }
                    this.hAw = (System.currentTimeMillis() - currentTimeMillis) + this.hAw;
                    this.hAx++;
                    if (!this.hAB.contains(bVar.awq())) {
                        this.hAB.add(bVar.awq());
                        this.hAC.add(bVar.awr());
                        this.hAA.add(Integer.valueOf(i));
                    }
                    return view;
                }
            } else if (awv != ((com.tencent.mm.plugin.card.base.b) this.hAv.getItem(i - 1)).awv()) {
                obj = 1;
                if (obj != null) {
                    aVar.hAF.setVisibility(8);
                    aVar.hAG.setVisibility(8);
                    aVar.hAF.setText("");
                } else {
                    aVar.hAF.setVisibility(0);
                    aVar.hAF.setText(bVar2.nF(awv));
                    if (TextUtils.isEmpty(bVar2.awu())) {
                        aVar.hAG.setVisibility(8);
                    } else {
                        aVar.hAG.setVisibility(0);
                        aVar.hAG.setText(bVar2.awu());
                    }
                }
                if (bVar.avY()) {
                    aVar.hAI.setVisibility(8);
                    aVar.hAJ.setVisibility(8);
                    aVar.hAE.setVisibility(8);
                    aVar.hAK.setVisibility(8);
                    aVar.hAP.setVisibility(8);
                    aVar.hAO.setVisibility(8);
                    aVar.hAL.setVisibility(8);
                    aVar.hAM.setVisibility(8);
                    aVar.hAN.setVisibility(0);
                    aVar.hAN.setText(this.mContext.getResources().getString(g.card_not_support_card_type));
                } else {
                    aVar.hAI.setVisibility(0);
                    aVar.hAJ.setVisibility(0);
                    aVar.hAE.setVisibility(0);
                    aVar.hAK.setVisibility(0);
                    aVar.hAP.setVisibility(0);
                    aVar.hAO.setVisibility(0);
                    aVar.hAL.setVisibility(0);
                    aVar.hAM.setVisibility(0);
                    aVar.hAN.setVisibility(8);
                    aVar.hAJ.setText(bVar.awm().hwh);
                    if (!bVar.avV()) {
                        aVar.hAK.setText(bVar.awm().title);
                    } else if (bVar.awm().rnG != null && bVar.awm().rnG.size() == 1) {
                        aVar.hAK.setText(((pr) bVar.awm().rnG.get(0)).title);
                    } else if (bVar.awm().rnG != null && bVar.awm().rnG.size() == 2) {
                        StringBuilder stringBuilder2 = new StringBuilder();
                        stringBuilder2.append(((pr) bVar.awm().rnG.get(0)).title);
                        stringBuilder2.append("-");
                        stringBuilder2.append(((pr) bVar.awm().rnG.get(1)).title);
                        aVar.hAK.setText(stringBuilder2.toString());
                    }
                    m.a(aVar.hAI, bVar.awm().huW, this.mContext.getResources().getDimensionPixelSize(b.card_list_logo_height), com.tencent.mm.plugin.card.a.c.my_card_package_defaultlogo, true);
                    aVar.hAJ.setTextColor(this.mContext.getResources().getColor(com.tencent.mm.plugin.card.a.a.card_black_color));
                    CharSequence xt2 = com.tencent.mm.plugin.card.sharecard.a.b.xt(bVar.awr());
                    if (TextUtils.isEmpty(xt2)) {
                        aVar.hAM.setText("");
                    } else {
                        aVar.hAM.setText(xt2);
                    }
                    xt2 = com.tencent.mm.plugin.card.sharecard.a.b.ld(bVar.awr());
                    boolean nL2 = com.tencent.mm.plugin.card.sharecard.a.b.nL(bVar.awv());
                    if (!TextUtils.isEmpty(xt2) && nL2) {
                        aVar.hAL.setText(com.tencent.mm.pluginsdk.ui.d.j.a(this.mContext, xt2, this.mContext.getResources().getDimensionPixelOffset(b.SmallerTextSize)));
                    } else if (TextUtils.isEmpty(bVar.aws())) {
                        aVar.hAL.setText("");
                    } else {
                        if (TextUtils.isEmpty(l.xY(bVar.aws()))) {
                            aVar.hAL.setText("");
                        } else {
                            aVar.hAL.setText(com.tencent.mm.pluginsdk.ui.d.j.a(this.mContext, this.mContext.getResources().getString(g.card_share_card_list_users, new Object[]{xt2}), this.mContext.getResources().getDimensionPixelOffset(b.SmallerTextSize)));
                        }
                    }
                    int xu2 = com.tencent.mm.plugin.card.sharecard.a.b.xu(bVar.awr());
                    if (xu2 <= 1 || !nL2) {
                        aVar.hAP.setVisibility(8);
                    } else {
                        aVar.hAP.setText("X" + xu2);
                        aVar.hAP.setVisibility(0);
                    }
                    if ((bVar.awm().rnZ == null || bi.cX(bVar.awm().rnZ.stj)) && !com.tencent.mm.plugin.card.sharecard.a.b.xw(bVar.awr())) {
                        aVar.hAE.setVisibility(8);
                    } else {
                        aVar.hAE.setVisibility(0);
                        xu2 = 0;
                        while (true) {
                            int i22 = xu2;
                            if (i22 >= aVar.hAE.getChildCount()) {
                                break;
                            }
                            this.hAD.add((CardTagTextView) aVar.hAE.getChildAt(i22));
                            xu2 = i22 + 1;
                        }
                        aVar.hAE.removeAllViews();
                        if (com.tencent.mm.plugin.card.sharecard.a.b.xw(bVar.awr())) {
                            CardTagTextView ayb3 = ayb();
                            ayb3.setPadding(this.hAz, this.hAy, this.hAz, this.hAy);
                            ayb3.setTextColor(this.mContext.getResources().getColor(com.tencent.mm.plugin.card.a.a.red));
                            ayb3.setText(this.mContext.getString(g.card_share_card_top_tips));
                            ayb3.setTextSize(12.0f);
                            LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-2, -2);
                            layoutParams3.rightMargin = this.mContext.getResources().getDimensionPixelOffset(b.LittlePadding);
                            aVar.hAE.addView(ayb3, layoutParams3);
                        }
                        if (!(bVar.awm().rnZ == null || bi.cX(bVar.awm().rnZ.stj))) {
                            Iterator it2 = bVar.awm().rnZ.stj.iterator();
                            while (it2.hasNext()) {
                                bsf bsf2 = (bsf) it2.next();
                                CardTagTextView ayb22 = ayb();
                                ayb22.setPadding(this.hAz, this.hAy, this.hAz, this.hAy);
                                ayb22.setTextColor(l.xV(bsf2.dxh));
                                ayb22.setText(bsf2.tag);
                                ayb22.setTextSize(12.0f);
                                aVar.hAE.addView(ayb22);
                            }
                        }
                    }
                }
                if (i != this.hAv.getCount() - 1) {
                }
                if (aVar.hAH != null) {
                    layoutParams2 = (LinearLayout.LayoutParams) aVar.hAH.getLayoutParams();
                    if (layoutParams2.bottomMargin != 0) {
                        layoutParams2.bottomMargin = 0;
                        aVar.hAH.setLayoutParams(layoutParams2);
                    }
                }
                this.hAw = (System.currentTimeMillis() - currentTimeMillis) + this.hAw;
                this.hAx++;
                if (this.hAB.contains(bVar.awq())) {
                    this.hAB.add(bVar.awq());
                    this.hAC.add(bVar.awr());
                    this.hAA.add(Integer.valueOf(i));
                }
                return view;
            }
        }
        obj = null;
        if (obj != null) {
            aVar.hAF.setVisibility(0);
            aVar.hAF.setText(bVar2.nF(awv));
            if (TextUtils.isEmpty(bVar2.awu())) {
                aVar.hAG.setVisibility(8);
            } else {
                aVar.hAG.setVisibility(0);
                aVar.hAG.setText(bVar2.awu());
            }
        } else {
            aVar.hAF.setVisibility(8);
            aVar.hAG.setVisibility(8);
            aVar.hAF.setText("");
        }
        if (bVar.avY()) {
            aVar.hAI.setVisibility(0);
            aVar.hAJ.setVisibility(0);
            aVar.hAE.setVisibility(0);
            aVar.hAK.setVisibility(0);
            aVar.hAP.setVisibility(0);
            aVar.hAO.setVisibility(0);
            aVar.hAL.setVisibility(0);
            aVar.hAM.setVisibility(0);
            aVar.hAN.setVisibility(8);
            aVar.hAJ.setText(bVar.awm().hwh);
            if (!bVar.avV()) {
                aVar.hAK.setText(bVar.awm().title);
            } else if (bVar.awm().rnG != null && bVar.awm().rnG.size() == 1) {
                aVar.hAK.setText(((pr) bVar.awm().rnG.get(0)).title);
            } else if (bVar.awm().rnG != null && bVar.awm().rnG.size() == 2) {
                StringBuilder stringBuilder22 = new StringBuilder();
                stringBuilder22.append(((pr) bVar.awm().rnG.get(0)).title);
                stringBuilder22.append("-");
                stringBuilder22.append(((pr) bVar.awm().rnG.get(1)).title);
                aVar.hAK.setText(stringBuilder22.toString());
            }
            m.a(aVar.hAI, bVar.awm().huW, this.mContext.getResources().getDimensionPixelSize(b.card_list_logo_height), com.tencent.mm.plugin.card.a.c.my_card_package_defaultlogo, true);
            aVar.hAJ.setTextColor(this.mContext.getResources().getColor(com.tencent.mm.plugin.card.a.a.card_black_color));
            CharSequence xt22 = com.tencent.mm.plugin.card.sharecard.a.b.xt(bVar.awr());
            if (TextUtils.isEmpty(xt22)) {
                aVar.hAM.setText("");
            } else {
                aVar.hAM.setText(xt22);
            }
            xt22 = com.tencent.mm.plugin.card.sharecard.a.b.ld(bVar.awr());
            boolean nL22 = com.tencent.mm.plugin.card.sharecard.a.b.nL(bVar.awv());
            if (!TextUtils.isEmpty(xt22) && nL22) {
                aVar.hAL.setText(com.tencent.mm.pluginsdk.ui.d.j.a(this.mContext, xt22, this.mContext.getResources().getDimensionPixelOffset(b.SmallerTextSize)));
            } else if (TextUtils.isEmpty(bVar.aws())) {
                aVar.hAL.setText("");
            } else {
                if (TextUtils.isEmpty(l.xY(bVar.aws()))) {
                    aVar.hAL.setText("");
                } else {
                    aVar.hAL.setText(com.tencent.mm.pluginsdk.ui.d.j.a(this.mContext, this.mContext.getResources().getString(g.card_share_card_list_users, new Object[]{xt22}), this.mContext.getResources().getDimensionPixelOffset(b.SmallerTextSize)));
                }
            }
            int xu22 = com.tencent.mm.plugin.card.sharecard.a.b.xu(bVar.awr());
            if (xu22 <= 1 || !nL22) {
                aVar.hAP.setVisibility(8);
            } else {
                aVar.hAP.setText("X" + xu22);
                aVar.hAP.setVisibility(0);
            }
            if ((bVar.awm().rnZ == null || bi.cX(bVar.awm().rnZ.stj)) && !com.tencent.mm.plugin.card.sharecard.a.b.xw(bVar.awr())) {
                aVar.hAE.setVisibility(8);
            } else {
                aVar.hAE.setVisibility(0);
                xu22 = 0;
                while (true) {
                    int i222 = xu22;
                    if (i222 >= aVar.hAE.getChildCount()) {
                        break;
                    }
                    this.hAD.add((CardTagTextView) aVar.hAE.getChildAt(i222));
                    xu22 = i222 + 1;
                }
                aVar.hAE.removeAllViews();
                if (com.tencent.mm.plugin.card.sharecard.a.b.xw(bVar.awr())) {
                    CardTagTextView ayb32 = ayb();
                    ayb32.setPadding(this.hAz, this.hAy, this.hAz, this.hAy);
                    ayb32.setTextColor(this.mContext.getResources().getColor(com.tencent.mm.plugin.card.a.a.red));
                    ayb32.setText(this.mContext.getString(g.card_share_card_top_tips));
                    ayb32.setTextSize(12.0f);
                    LayoutParams layoutParams32 = new LinearLayout.LayoutParams(-2, -2);
                    layoutParams32.rightMargin = this.mContext.getResources().getDimensionPixelOffset(b.LittlePadding);
                    aVar.hAE.addView(ayb32, layoutParams32);
                }
                if (!(bVar.awm().rnZ == null || bi.cX(bVar.awm().rnZ.stj))) {
                    Iterator it22 = bVar.awm().rnZ.stj.iterator();
                    while (it22.hasNext()) {
                        bsf bsf22 = (bsf) it22.next();
                        CardTagTextView ayb222 = ayb();
                        ayb222.setPadding(this.hAz, this.hAy, this.hAz, this.hAy);
                        ayb222.setTextColor(l.xV(bsf22.dxh));
                        ayb222.setText(bsf22.tag);
                        ayb222.setTextSize(12.0f);
                        aVar.hAE.addView(ayb222);
                    }
                }
            }
        } else {
            aVar.hAI.setVisibility(8);
            aVar.hAJ.setVisibility(8);
            aVar.hAE.setVisibility(8);
            aVar.hAK.setVisibility(8);
            aVar.hAP.setVisibility(8);
            aVar.hAO.setVisibility(8);
            aVar.hAL.setVisibility(8);
            aVar.hAM.setVisibility(8);
            aVar.hAN.setVisibility(0);
            aVar.hAN.setText(this.mContext.getResources().getString(g.card_not_support_card_type));
        }
        if (i != this.hAv.getCount() - 1) {
        }
        if (aVar.hAH != null) {
            layoutParams2 = (LinearLayout.LayoutParams) aVar.hAH.getLayoutParams();
            if (layoutParams2.bottomMargin != 0) {
                layoutParams2.bottomMargin = 0;
                aVar.hAH.setLayoutParams(layoutParams2);
            }
        }
        this.hAw = (System.currentTimeMillis() - currentTimeMillis) + this.hAw;
        this.hAx++;
        if (this.hAB.contains(bVar.awq())) {
            this.hAB.add(bVar.awq());
            this.hAC.add(bVar.awr());
            this.hAA.add(Integer.valueOf(i));
        }
        return view;
    }

    public final void v(View view, int i) {
    }

    public final void w(View view, int i) {
    }

    public final void a(View view, int i, OnClickListener onClickListener) {
    }

    private CardTagTextView ayb() {
        if (this.hAD.size() == 0) {
            return new CardTagTextView(this.mContext);
        }
        return (CardTagTextView) this.hAD.removeFirst();
    }
}
