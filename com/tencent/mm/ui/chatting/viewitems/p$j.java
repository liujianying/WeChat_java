package com.tencent.mm.ui.chatting.viewitems;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.ak.o;
import com.tencent.mm.ak.q;
import com.tencent.mm.bg.d;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.t;
import com.tencent.mm.model.u;
import com.tencent.mm.platformtools.ai;
import com.tencent.mm.plugin.appbrand.s$l;
import com.tencent.mm.pluginsdk.ui.applet.e;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.bd;
import com.tencent.mm.ui.chatting.am;
import com.tencent.mm.ui.chatting.ao;
import com.tencent.mm.ui.chatting.b.b.c;
import com.tencent.mm.ui.chatting.c.a;
import com.tencent.mm.ui.chatting.j;
import com.tencent.mm.ui.chatting.r;
import com.tencent.mm.ui.chatting.viewitems.c.f;
import com.tencent.mm.ui.chatting.viewitems.p.b;
import com.tencent.mm.ui.transmit.MsgRetransmitUI;
import com.tencent.mm.y.i;
import com.tencent.mm.y.l;
import com.tencent.mm.y.m;
import java.util.List;

public class p$j extends b {
    private static int hqE;
    private static int hqF = 0;
    private static int hqG = 0;
    private static int mnW = 0;
    private static int mnX;
    private static int mnY;
    private boolean hqK = false;
    private long hqL = 0;
    private a tKy;
    private boolean ubS = false;
    private int ubT = 0;

    public final boolean bba() {
        return false;
    }

    public final boolean aq(int i, boolean z) {
        if (i == 285212721) {
            return true;
        }
        return false;
    }

    public final View a(LayoutInflater layoutInflater, View view) {
        if (view == null || view.getTag() == null) {
            view = new r(layoutInflater, R.i.chatting_item_biz);
            p$c p_c = new p$c();
            p_c.hrs = (TextView) view.findViewById(R.h.chatting_time_tv);
            p_c.tZu = view.findViewById(R.h.chatting_histroy_msg_tip);
            p_c.hrw = (LinearLayout) view.findViewById(R.h.chatting_content_ll);
            p_c.jBR = (CheckBox) view.findViewById(R.h.chatting_checkbox);
            p_c.gFD = view.findViewById(R.h.chatting_maskview);
            p_c.tZU = (TextView) view.findViewById(R.h.chatting_appmsg_comment_tv);
            view.setTag(p_c);
        }
        gQ(layoutInflater.getContext());
        return view;
    }

    private static void gQ(Context context) {
        if (hqG == 0) {
            hqG = context.getResources().getDimensionPixelSize(R.f.SmallPadding);
            mnW = context.getResources().getDimensionPixelSize(R.f.MiddlePadding);
            hqF = context.getResources().getDimensionPixelSize(R.f.LargePadding);
            hqE = context.getResources().getDimensionPixelSize(R.f.chatting_item_biz_sub_item_pic_size);
            mnY = context.getResources().getDimensionPixelSize(R.f.chatting_item_biz_line_big_padding);
            int fk = com.tencent.mm.bp.a.fk(context);
            int fl = com.tencent.mm.bp.a.fl(context);
            if (fk >= fl) {
                fk = fl;
            }
            mnX = ((fk - ((int) (com.tencent.mm.bp.a.getDensity(context) * 32.0f))) * 9) / 16;
        }
    }

    protected final boolean cxM() {
        return false;
    }

    public final void a(b$a b_a, int i, a aVar, bd bdVar, String str) {
        this.tKy = aVar;
        gQ(aVar.tTq.getContext());
        p$c p_c = (p$c) b_a;
        for (p.a aVar2 : p_c.hrz) {
            if (p_c.hrz.indexOf(aVar2) != p_c.hrz.size() - 1) {
                ao.L(aVar2.hri, 1);
            } else {
                ao.L(aVar2.hri, 2);
            }
            p_c.hrw.removeView(aVar2.hri);
        }
        p_c.hrz.clear();
        l wS = ((com.tencent.mm.plugin.biz.a.a) g.l(com.tencent.mm.plugin.biz.a.a.class)).wS(bdVar.field_content);
        String str2 = wS.cGB;
        if (str2 == null || str2.length() == 0) {
            p_c.tZU.setVisibility(8);
        } else {
            p_c.tZU.setVisibility(0);
            b(aVar, p_c.tZU, au.aaI(str2));
        }
        List list = wS.dzs;
        int size = list.size();
        if (size == 0) {
            p_c.hrw.setVisibility(8);
            a(p_c, -1, 0);
            return;
        }
        int i2;
        View EX;
        p_c.hrw.setVisibility(0);
        a(p_c, ((m) list.get(0)).type, size);
        LayoutInflater layoutInflater = aVar.tTq.getLayoutInflater();
        int size2 = p_c.hrz.size() + 2;
        while (true) {
            i2 = size2;
            if (i2 >= size) {
                break;
            }
            EX = ao.EX(1);
            if (EX == null) {
                EX = layoutInflater.inflate(R.i.chatting_item_biz_slot, null);
            }
            p_c.dF(EX);
            size2 = i2 + 1;
        }
        if (size > 1) {
            EX = ao.EX(2);
            if (EX == null) {
                EX = layoutInflater.inflate(R.i.chatting_item_biz_slot_bottom, null);
            }
            p_c.dF(EX);
            this.ubS = true;
        } else {
            this.ubS = false;
        }
        size2 = 0;
        while (true) {
            i2 = size2;
            if (i2 >= p_c.hrz.size()) {
                break;
            }
            ((p.a) p_c.hrz.get(i2)).hri.setVisibility(8);
            size2 = i2 + 1;
        }
        m mVar = (m) list.get(0);
        CharSequence gR;
        ImageView imageView;
        String str3;
        if (mVar.type == 5) {
            boolean z;
            cm(p_c.ubN.hrL);
            cm(p_c.ubN.mog);
            if (ai.oW(mVar.title)) {
                p_c.ubN.eGX.setVisibility(8);
            } else {
                p_c.ubN.eGX.setText(mVar.title);
                p_c.ubN.eGX.setVisibility(0);
                p_c.ubN.eGX.setTextColor(this.tKy.tTq.getContext().getResources().getColor(R.e.light_grey_text_color));
            }
            if (size == 1) {
                p_c.ubN.hrq.setBackgroundResource(R.g.biz_item_cover_round_mask);
                p_c.ubN.mog.setBackgroundResource(R.g.chatting_share_reader_mask);
            } else {
                p_c.ubN.hrq.setBackgroundResource(R.g.biz_item_cover_top_round_mask);
                p_c.ubN.mog.setBackgroundResource(R.g.chatting_share_reader_mask_top_round);
            }
            gR = i.gR(mVar.dzC);
            if (TextUtils.isEmpty(gR)) {
                p_c.ubN.hrV.setVisibility(8);
            } else {
                p_c.ubN.hrV.setVisibility(0);
                p_c.ubN.hrV.setText(gR);
                p_c.ubN.hrV.setTextColor(this.tKy.tTq.getContext().getResources().getColor(R.e.light_grey_text_color));
            }
            a(mVar, bdVar, i, wS, p_c.ubN.hri);
            p_c.ubN.hrq.setVisibility(8);
            p_c.ubN.gwj.setImageResource(R.k.chatting_item_biz_video_loading_icon);
            String str4 = mVar.dzy;
            ImageView imageView2 = p_c.ubN.hro;
            int type = bdVar.getType();
            if (size > 1) {
                z = true;
            } else {
                z = false;
            }
            a(str4, imageView2, type, z, mnX, new 3(this, p_c));
        } else if (mVar.type == 8) {
            p_c.ubO.eGX.setText(mVar.dzO);
            cm(p_c.ubO.hrL);
            cm(p_c.ubO.mog);
            if (size == 1) {
                p_c.ubO.hrq.setBackgroundResource(R.g.biz_item_cover_round_pic_mask);
                p_c.ubO.mog.setBackgroundResource(R.g.chatting_share_reader_mask);
                p_c.ubO.mof.setBackgroundResource(R.g.biz_bg_rounded_shadow_mask);
            } else {
                p_c.ubO.hrq.setBackgroundResource(R.g.biz_item_cover_top_round_pic_mask);
                p_c.ubO.mog.setBackgroundResource(R.g.chatting_share_reader_mask_top_round);
                p_c.ubO.mof.setBackgroundResource(R.g.biz_bg_top_rounded_shadow_mask);
            }
            p_c.ubO.hrq.setVisibility(8);
            p_c.ubO.mof.setVisibility(8);
            p_c.ubO.eGX.setTextColor(this.tKy.tTq.getContext().getResources().getColor(R.e.light_grey_text_color));
            p_c.ubO.gwj.setBackgroundResource(R.k.chatting_item_biz_pic_loading_icon);
            a(mVar.dzy, p_c.ubO.hro, bdVar.getType(), size > 1, mnX, new 5(this, p_c));
            a(mVar, bdVar, i, wS, p_c.ubO.hri);
        } else if (mVar.type == 7) {
            if (ai.oW(mVar.title)) {
                p_c.ubP.eGX.setVisibility(8);
            } else {
                p_c.ubP.eGX.setVisibility(0);
                p_c.ubP.eGX.setText(mVar.title);
            }
            if (size > 1) {
                p_c.ubP.hri.setBackgroundResource(R.g.chatting_item_multi_top);
            } else {
                p_c.ubP.hri.setBackgroundResource(R.g.chatting_item_one_item);
            }
            gR = i.gR(mVar.dzC);
            if (TextUtils.isEmpty(gR)) {
                p_c.ubP.jWm.setVisibility(4);
            } else {
                p_c.ubP.jWm.setVisibility(0);
                p_c.ubP.jWm.setText(gR);
            }
            Drawable drawable = p_c.ubP.hrp.getDrawable();
            if ((drawable instanceof AnimationDrawable) && ((AnimationDrawable) drawable).isRunning()) {
                ((AnimationDrawable) drawable).stop();
            }
            if ((bdVar.field_msgId + "_0").equals(p_c.tZw)) {
                p_c.ubP.hrp.setImageResource(R.g.chatting_item_biz_voice_playing_selector);
                if (p_c.ubP.hrp.getDrawable() instanceof AnimationDrawable) {
                    ((AnimationDrawable) p_c.ubP.hrp.getDrawable()).start();
                }
            } else {
                p_c.ubP.hrp.setImageResource(R.g.chatting_item_biz_voice_play_selector);
            }
            imageView = p_c.ubP.hrp;
            str3 = mVar.dzy;
            a(imageView, bdVar, 0);
            a(mVar, bdVar, i, wS, p_c.ubP.hri);
        } else if (mVar.type == 6) {
            m mVar2 = (m) list.get(0);
            if (ai.oW(mVar2.title)) {
                p_c.ubQ.eGX.setVisibility(8);
            } else {
                p_c.ubQ.eGX.setVisibility(0);
                p_c.ubQ.eGX.setText(mVar2.title);
            }
            if (size > 1) {
                p_c.ubQ.hri.setBackgroundResource(R.g.chatting_item_multi_top);
            } else {
                p_c.ubQ.hri.setBackgroundResource(R.g.chatting_item_one_item);
            }
            if (TextUtils.isEmpty(mVar2.dzM)) {
                p_c.ubQ.hrJ.setVisibility(8);
            } else {
                p_c.ubQ.hrJ.setVisibility(0);
                p_c.ubQ.hrJ.setText(mVar2.dzM);
            }
            if (mVar2.dzN == 2) {
                p_c.ubQ.hrK.setImageResource(R.k.chatting_item_biz_kugou_music_watermark);
            } else {
                p_c.ubQ.hrK.setImageResource(R.k.chatting_item_biz_qq_music_watermark);
            }
            imageView = p_c.ubQ.hrp;
            str3 = mVar2.dzy;
            a(imageView, bdVar, 0);
            a(mVar2, bdVar, i, wS, p_c.ubQ.hri);
            if ((bdVar.field_msgId + "_0").equals(p_c.tZw)) {
                p_c.ubQ.hrp.setImageResource(R.k.chatting_item_biz_music_pause_loading_icon);
            } else {
                p_c.ubQ.hrp.setImageResource(R.k.chatting_item_biz_music_play_loading_icon);
            }
            p_c.ubQ.hrq.setVisibility(8);
            a(mVar2.dzy, p_c.ubQ.hro, bdVar.getType(), hqE, hqE, "@S", new 4(this, p_c, bdVar));
        } else if (mVar.type == 10) {
            if (ai.oW(mVar.title)) {
                p_c.ubR.eGX.setVisibility(8);
            } else {
                p_c.ubR.eGX.setVisibility(0);
                p_c.ubR.eGX.setText(mVar.title);
            }
            if (size > 1) {
                p_c.ubR.hri.setBackgroundResource(R.g.chatting_item_multi_top);
                p_c.ubR.hrO.setVisibility(8);
                p_c.ubR.eGX.setTextSize(1, 18.0f * com.tencent.mm.bp.a.fe(this.tKy.tTq.getContext()));
            } else {
                p_c.ubR.hri.setBackgroundResource(R.g.chatting_item_one_item);
                p_c.ubR.hrO.setVisibility(0);
                p_c.ubR.eGX.setTextSize(1, 15.0f * com.tencent.mm.bp.a.fe(this.tKy.tTq.getContext()));
            }
            a(mVar, bdVar, i, wS, p_c.ubR.hri);
        } else {
            p_c.ubM.eGX.setVisibility(size > 1 ? 8 : 0);
            TextView textView = p_c.ubM.hrN;
            size2 = (size > 1 || ai.oW(mVar.dzA)) ? 8 : 0;
            textView.setVisibility(size2);
            p_c.ubM.moe.setVisibility(size > 1 ? 0 : 8);
            p_c.ubM.mof.setVisibility(8);
            if (size == 1) {
                p_c.ubM.mog.setBackgroundResource(R.g.chatting_share_reader_mask);
                p_c.ubM.eSd.setVisibility(0);
            } else {
                p_c.ubM.eSd.setVisibility(ai.oW(mVar.dzy) ? 0 : 8);
                p_c.ubM.mog.setBackgroundResource(R.g.chatting_share_reader_mask_top_round);
                p_c.ubM.moe.setTextColor(this.tKy.tTq.getContext().getResources().getColor(R.e.light_grey_text_color));
                p_c.ubM.moe.setBackgroundResource(R.g.mm_trans);
            }
            cm(p_c.ubM.hrL);
            cm(p_c.ubM.mog);
            if (ai.oW(mVar.dzy)) {
                p_c.ubM.hrL.setVisibility(8);
                p_c.ubM.eGX.setVisibility(0);
                p_c.ubM.hrN.setVisibility(ai.oW(mVar.dzA) ? 8 : 0);
                if (size == 1) {
                    p_c.ubM.eSd.setBackgroundResource(R.g.chatting_item_one_item);
                } else {
                    p_c.ubM.eSd.setBackgroundResource(R.g.chatting_item_multi_top);
                }
                p_c.ubM.eSd.setPadding(hqF, hqF, hqF, hqF);
                p_c.ubM.mog.setVisibility(8);
            } else {
                p_c.ubM.hrL.setVisibility(0);
                a(mVar.dzy, p_c.ubM.hro, bdVar.getType(), true, mnX, new 2(this, size, p_c));
                p_c.ubM.eSd.setBackgroundResource(R.g.chatting_item_multbg_bottom_normal);
                p_c.ubM.eSd.setPadding(hqF, mnW, hqF, hqF);
                p_c.ubM.mog.setVisibility(0);
            }
            p_c.ubM.hrN.setText(mVar.dzA);
            p_c.ubM.eGX.setText(mVar.title);
            p_c.ubM.moe.Q(mVar.title);
            if (!(mVar.dzB == 0 || mVar.dzB == 1)) {
                p_c.ubM.moe.setVisibility(4);
            }
            a(mVar, bdVar, i, wS, p_c.ubM.hri);
        }
        for (int i3 = 1; i3 < size; i3++) {
            Object aam;
            au auVar;
            m mVar3 = (m) list.get(i3);
            p.a aVar3 = (p.a) p_c.hrz.get(i3 - 1);
            size2 = mVar.type;
            if (i3 != 1 || (size2 != 5 && size2 != 8 && size2 != 0)) {
                aVar3.hrj.setVisibility(0);
                if (i3 > 1) {
                    m mVar4 = (m) list.get(i3 - 1);
                    m mVar5 = (m) list.get(i3);
                    if ((mVar4.type == 7 || mVar4.type == 5 || mVar4.type == 6 || !ai.oW(mVar4.dzy)) && (mVar5.type == 7 || mVar5.type == 5 || mVar5.type == 6 || !ai.oW(mVar5.dzy))) {
                        E(aVar3.hrj, mnY);
                    } else {
                        E(aVar3.hrj, hqF);
                    }
                    if (i3 == 1) {
                        if (i3 == size - 1) {
                            aVar3.hrk.setPadding(0, hqF, 0, hqF);
                        } else {
                            aVar3.hrk.setPadding(0, hqF, 0, hqG);
                        }
                    } else if (i3 == size - 1) {
                        aVar3.hrk.setPadding(0, hqG, 0, hqF);
                    } else {
                        aVar3.hrk.setPadding(0, hqG, 0, hqG);
                    }
                    a(p_c, aVar3, mVar3, bdVar, i3, false);
                    aVar3.eGX.setText(mVar3.title);
                    aVar3.eGX.setTextColor(aVar.tTq.getMMResources().getColor(R.e.black));
                    if (mVar3.dzB != 0 || mVar3.dzB == 1) {
                        aVar3.hrn.setVisibility(0);
                        aVar3.eGX.setTextColor(aVar.tTq.getMMResources().getColor(R.e.black));
                        if (mVar3.type != 7) {
                            a(R.g.chatting_item_biz_play_icon_bg, aVar3.hro, hqE, hqE);
                        } else if (!ai.oW(mVar3.dzy)) {
                            a(mVar3.dzy, aVar3.hro, bdVar.getType(), hqE, hqE, "@S", new 1(this, p_c, aVar3, mVar3, bdVar, i3));
                        } else if (mVar3.type == 5 || mVar3.type == 6) {
                            a(R.g.chatting_item_biz_play_icon_bg, aVar3.hro, hqE, hqE);
                        } else {
                            aVar3.hrn.setVisibility(8);
                        }
                    } else {
                        aVar3.hrn.setVisibility(8);
                        aVar3.eGX.setTextColor(aVar.tTq.getMMResources().getColor(R.e.hint_text_color));
                    }
                    if (ai.oW(mVar3.dzA) && mVar3.type == 3) {
                        aVar3.hrm.setText(mVar3.dzA);
                        aVar3.hrm.setVisibility(0);
                    } else {
                        aVar3.hrm.setVisibility(8);
                    }
                    aVar3.hri.setVisibility(0);
                    aam = ((c) aVar.O(c.class)).aam(mVar3.url);
                    if (TextUtils.isEmpty(aam)) {
                        auVar = new au(bdVar, false, i, mVar3.url, this.ubS, aVar.cuz(), wS.bZG, wS.bZH);
                        a(auVar, mVar3, bdVar);
                        aVar3.hri.setOnClickListener(g(aVar));
                    } else {
                        x.d("MicroMsg.ChattingItemBizFrom", "productId:%s", new Object[]{aam});
                        auVar = new au(bdVar, false, i, mVar3.url, this.ubS, aVar.cuz(), wS.bZG, wS.bZH, mVar3.title, aam, null, false, true);
                        aVar3.hri.setOnClickListener(h(aVar));
                    }
                    auVar.pSz = bdVar.field_msgSvrId;
                    auVar.pSA = i3;
                    aVar3.hri.setTag(auVar);
                    if (!i.gr(mVar3.dzD)) {
                        a(mVar3, aVar3.hri);
                    }
                    aVar3.hri.setOnLongClickListener(c(aVar));
                    aVar3.hri.setOnTouchListener(((com.tencent.mm.ui.chatting.b.b.g) aVar.O(com.tencent.mm.ui.chatting.b.b.g.class)).ctw());
                }
            } else if (size2 == 0 && ai.oW(((m) list.get(0)).dzy)) {
                aVar3.hrj.setVisibility(0);
            } else {
                aVar3.hrj.setVisibility(8);
                if (i3 == 1) {
                    if (i3 == size - 1) {
                        aVar3.hrk.setPadding(0, hqG, 0, hqF);
                    } else {
                        aVar3.hrk.setPadding(0, hqG, 0, hqG);
                    }
                } else if (i3 == size - 1) {
                    aVar3.hrk.setPadding(0, hqF, 0, hqF);
                } else {
                    aVar3.hrk.setPadding(0, hqF, 0, hqG);
                }
                a(p_c, aVar3, mVar3, bdVar, i3, false);
                aVar3.eGX.setText(mVar3.title);
                aVar3.eGX.setTextColor(aVar.tTq.getMMResources().getColor(R.e.black));
                if (mVar3.dzB != 0) {
                }
                aVar3.hrn.setVisibility(0);
                aVar3.eGX.setTextColor(aVar.tTq.getMMResources().getColor(R.e.black));
                if (mVar3.type != 7) {
                    a(R.g.chatting_item_biz_play_icon_bg, aVar3.hro, hqE, hqE);
                } else if (!ai.oW(mVar3.dzy)) {
                    a(mVar3.dzy, aVar3.hro, bdVar.getType(), hqE, hqE, "@S", new 1(this, p_c, aVar3, mVar3, bdVar, i3));
                } else if (mVar3.type == 5 || mVar3.type == 6) {
                    a(R.g.chatting_item_biz_play_icon_bg, aVar3.hro, hqE, hqE);
                } else {
                    aVar3.hrn.setVisibility(8);
                }
                if (ai.oW(mVar3.dzA)) {
                }
                aVar3.hrm.setVisibility(8);
                aVar3.hri.setVisibility(0);
                aam = ((c) aVar.O(c.class)).aam(mVar3.url);
                if (TextUtils.isEmpty(aam)) {
                    auVar = new au(bdVar, false, i, mVar3.url, this.ubS, aVar.cuz(), wS.bZG, wS.bZH);
                    a(auVar, mVar3, bdVar);
                    aVar3.hri.setOnClickListener(g(aVar));
                } else {
                    x.d("MicroMsg.ChattingItemBizFrom", "productId:%s", new Object[]{aam});
                    auVar = new au(bdVar, false, i, mVar3.url, this.ubS, aVar.cuz(), wS.bZG, wS.bZH, mVar3.title, aam, null, false, true);
                    aVar3.hri.setOnClickListener(h(aVar));
                }
                auVar.pSz = bdVar.field_msgSvrId;
                auVar.pSA = i3;
                aVar3.hri.setTag(auVar);
                if (!i.gr(mVar3.dzD)) {
                    a(mVar3, aVar3.hri);
                }
                aVar3.hri.setOnLongClickListener(c(aVar));
                aVar3.hri.setOnTouchListener(((com.tencent.mm.ui.chatting.b.b.g) aVar.O(com.tencent.mm.ui.chatting.b.b.g.class)).ctw());
            }
            E(aVar3.hrj, hqF);
            if (i3 == 1) {
                if (i3 == size - 1) {
                    aVar3.hrk.setPadding(0, hqF, 0, hqF);
                } else {
                    aVar3.hrk.setPadding(0, hqF, 0, hqG);
                }
            } else if (i3 == size - 1) {
                aVar3.hrk.setPadding(0, hqG, 0, hqF);
            } else {
                aVar3.hrk.setPadding(0, hqG, 0, hqG);
            }
            a(p_c, aVar3, mVar3, bdVar, i3, false);
            aVar3.eGX.setText(mVar3.title);
            aVar3.eGX.setTextColor(aVar.tTq.getMMResources().getColor(R.e.black));
            if (mVar3.dzB != 0) {
            }
            aVar3.hrn.setVisibility(0);
            aVar3.eGX.setTextColor(aVar.tTq.getMMResources().getColor(R.e.black));
            if (mVar3.type != 7) {
                a(R.g.chatting_item_biz_play_icon_bg, aVar3.hro, hqE, hqE);
            } else if (!ai.oW(mVar3.dzy)) {
                a(mVar3.dzy, aVar3.hro, bdVar.getType(), hqE, hqE, "@S", new 1(this, p_c, aVar3, mVar3, bdVar, i3));
            } else if (mVar3.type == 5 || mVar3.type == 6) {
                a(R.g.chatting_item_biz_play_icon_bg, aVar3.hro, hqE, hqE);
            } else {
                aVar3.hrn.setVisibility(8);
            }
            if (ai.oW(mVar3.dzA)) {
            }
            aVar3.hrm.setVisibility(8);
            aVar3.hri.setVisibility(0);
            aam = ((c) aVar.O(c.class)).aam(mVar3.url);
            if (TextUtils.isEmpty(aam)) {
                x.d("MicroMsg.ChattingItemBizFrom", "productId:%s", new Object[]{aam});
                auVar = new au(bdVar, false, i, mVar3.url, this.ubS, aVar.cuz(), wS.bZG, wS.bZH, mVar3.title, aam, null, false, true);
                aVar3.hri.setOnClickListener(h(aVar));
            } else {
                auVar = new au(bdVar, false, i, mVar3.url, this.ubS, aVar.cuz(), wS.bZG, wS.bZH);
                a(auVar, mVar3, bdVar);
                aVar3.hri.setOnClickListener(g(aVar));
            }
            auVar.pSz = bdVar.field_msgSvrId;
            auVar.pSA = i3;
            aVar3.hri.setTag(auVar);
            if (!i.gr(mVar3.dzD)) {
                a(mVar3, aVar3.hri);
            }
            aVar3.hri.setOnLongClickListener(c(aVar));
            aVar3.hri.setOnTouchListener(((com.tencent.mm.ui.chatting.b.b.g) aVar.O(com.tencent.mm.ui.chatting.b.b.g.class)).ctw());
        }
    }

    private void a(m mVar, bd bdVar, int i, l lVar, View view) {
        au auVar;
        Object aam = ((c) this.tKy.O(c.class)).aam(mVar.url);
        if (TextUtils.isEmpty(aam)) {
            auVar = new au(bdVar, false, i, mVar.url, false, this.tKy.cuz(), lVar.bZG, lVar.bZH, mVar.title);
            a(auVar, mVar, bdVar);
            view.setOnClickListener(g(this.tKy));
        } else {
            x.d("MicroMsg.ChattingItemBizFrom", "productId:%s", new Object[]{aam});
            auVar = new au(bdVar, false, i, mVar.url, false, this.tKy.cuz(), lVar.bZG, lVar.bZH, mVar.title, aam, null, false, false);
            view.setOnClickListener(h(this.tKy));
        }
        auVar.pSz = bdVar.field_msgSvrId;
        auVar.pSA = 0;
        view.setTag(auVar);
        if (i.gr(mVar.dzD)) {
            a(mVar, view);
        }
        view.setOnLongClickListener(c(this.tKy));
        view.setOnTouchListener(((com.tencent.mm.ui.chatting.b.b.g) this.tKy.O(com.tencent.mm.ui.chatting.b.b.g.class)).ctw());
    }

    private static void cm(View view) {
        LayoutParams layoutParams = view.getLayoutParams();
        layoutParams.height = mnX;
        view.setLayoutParams(layoutParams);
    }

    private static void E(View view, int i) {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) view.getLayoutParams();
        layoutParams.rightMargin = i;
        view.setLayoutParams(layoutParams);
    }

    private void a(p$c p_c, p.a aVar, m mVar, bd bdVar, int i, boolean z) {
        ImageView imageView;
        String str;
        if (mVar.type == 5) {
            aVar.hrp.setVisibility(0);
            if (z) {
                aVar.hrp.setImageResource(R.k.chatting_item_biz_video_small_icon);
            } else {
                aVar.hrp.setImageResource(R.k.chatting_item_biz_video_small_loading_icon);
            }
            aVar.hrp.setOnClickListener(new 6(this, aVar));
        } else if (mVar.type == 6) {
            aVar.hrp.setVisibility(0);
            if (z) {
                if ((bdVar.field_msgId + "_" + i).equals(p_c.tZw)) {
                    aVar.hrp.setImageResource(R.g.chatting_item_biz_music_pause_selector);
                } else {
                    aVar.hrp.setImageResource(R.g.chatting_item_biz_music_play_selector);
                }
            } else if ((bdVar.field_msgId + "_" + i).equals(p_c.tZw)) {
                aVar.hrp.setImageResource(R.k.chatting_item_biz_music_pause_loading_icon);
            } else {
                aVar.hrp.setImageResource(R.k.chatting_item_biz_music_play_loading_icon);
            }
            imageView = aVar.hrp;
            str = mVar.dzy;
            a(imageView, bdVar, i);
        } else if (mVar.type == 7) {
            aVar.hrp.setVisibility(0);
            Drawable drawable = aVar.hrp.getDrawable();
            if ((drawable instanceof AnimationDrawable) && ((AnimationDrawable) drawable).isRunning()) {
                ((AnimationDrawable) drawable).stop();
            }
            if ((bdVar.field_msgId + "_" + i).equals(p_c.tZw)) {
                aVar.hrp.setImageResource(R.g.chatting_item_biz_voice_playing_selector);
                if (aVar.hrp.getDrawable() instanceof AnimationDrawable) {
                    ((AnimationDrawable) aVar.hrp.getDrawable()).start();
                }
            } else {
                aVar.hrp.setImageResource(R.g.chatting_item_biz_voice_play_selector);
            }
            imageView = aVar.hrp;
            str = mVar.dzy;
            a(imageView, bdVar, i);
        } else {
            aVar.hrp.setVisibility(8);
        }
    }

    private void a(ImageView imageView, bd bdVar, int i) {
        f fVar = new f();
        fVar.bJC = bdVar.field_msgId;
        fVar.uaH = i;
        fVar.bVv = bdVar.field_content;
        imageView.setTag(fVar);
        imageView.setOnClickListener(((com.tencent.mm.ui.chatting.b.b.g) this.tKy.O(com.tencent.mm.ui.chatting.b.b.g.class)).ctx());
    }

    private static void a(View view, b bVar, boolean z) {
        if (z) {
            if (bVar.hri == null) {
                bVar.cn(view);
            }
            if (bVar.hri != null) {
                bVar.hri.setVisibility(0);
            }
        } else if (bVar.hri != null) {
            bVar.hri.setVisibility(8);
        }
    }

    private static void a(p$c p_c, int i, int i2) {
        boolean z;
        boolean z2 = true;
        boolean z3 = i == 5;
        a(p_c.hrw, p_c.ubN, z3);
        if (z3) {
            z = true;
        } else {
            z = false;
        }
        if (i == 8) {
            z3 = true;
        } else {
            z3 = false;
        }
        a(p_c.hrw, p_c.ubO, z3);
        if (z3) {
            z = true;
        }
        if (i == 7) {
            z3 = true;
        } else {
            z3 = false;
        }
        a(p_c.hrw, p_c.ubP, z3);
        if (z3) {
            z = true;
        }
        if (i == 6) {
            z3 = true;
        } else {
            z3 = false;
        }
        a(p_c.hrw, p_c.ubQ, z3);
        if (z3) {
            z = true;
        }
        if (i == 10) {
            z3 = true;
        } else {
            z3 = false;
        }
        a(p_c.hrw, p_c.ubR, z3);
        if (z3) {
            z3 = true;
        } else {
            z3 = z;
        }
        View view = p_c.hrw;
        b bVar = p_c.ubM;
        if (z3 || i2 <= 0) {
            z2 = false;
        }
        a(view, bVar, z2);
    }

    public final boolean a(ContextMenu contextMenu, View view, bd bdVar) {
        au auVar = (au) view.getTag();
        if (auVar == null) {
            return false;
        }
        this.ubT = auVar.pSA;
        int i = auVar.position;
        l wS = ((com.tencent.mm.plugin.biz.a.a) g.l(com.tencent.mm.plugin.biz.a.a.class)).wS(bdVar.field_content);
        if (wS == null) {
            x.w("MicroMsg.ChattingItemBizFrom", "onCreateContextMenu reader is null");
            return false;
        }
        this.hqK = false;
        if (this.ubT >= 0 && this.ubT < wS.dzs.size() && i.gr(((m) wS.dzs.get(this.ubT)).dzD)) {
            this.hqK = true;
        }
        if (!(this.tKy.cws() || j.ay(bdVar))) {
            contextMenu.add(i, s$l.AppCompatTheme_switchStyle, 0, view.getContext().getString(R.l.retransmit));
        }
        if (d.QS("favorite") && !this.hqK) {
            contextMenu.add(i, 126, 0, view.getContext().getString(R.l.plugin_favorite_opt));
        }
        return true;
    }

    private void a(au auVar, m mVar, bd bdVar) {
        int i;
        Bundle bundle = new Bundle();
        switch (t.N(b(this.tKy, bdVar), this.tKy.getTalkerUserName())) {
            case 1:
                i = 3;
                break;
            case 2:
                i = 2;
                break;
            case 6:
            case 7:
                i = 5;
                break;
            default:
                i = 0;
                break;
        }
        bundle.putString("share_report_pre_msg_url", mVar.url);
        bundle.putString("share_report_pre_msg_title", mVar.title);
        bundle.putString("share_report_pre_msg_desc", mVar.dzA);
        bundle.putString("share_report_pre_msg_icon_url", mVar.dzy);
        bundle.putString("share_report_pre_msg_appid", "");
        bundle.putInt("share_report_from_scene", i);
        if (i == 5) {
            bundle.putString("share_report_biz_username", this.tKy.getTalkerUserName());
        }
        auVar.ufE = bundle;
    }

    private static void a(String str, ImageView imageView, int i, int i2, int i3, String str2, e.a aVar) {
        String lX;
        if (q.Pn()) {
            lX = q.lX(str);
        } else {
            lX = str;
        }
        com.tencent.mm.ak.a.a Pj = o.Pj();
        com.tencent.mm.ak.a.a.c.a aVar2 = new com.tencent.mm.ak.a.a.c.a();
        aVar2.dXR = R.e.chatting_item_biz_default_bg;
        aVar2.dXy = true;
        aVar2 = aVar2.bg(i2, i3);
        aVar2.dXn = new com.tencent.mm.pluginsdk.ui.applet.f();
        aVar2.dXA = com.tencent.mm.pluginsdk.model.q.v(lX, i, str2);
        Pj.a(lX, imageView, aVar2.Pt(), null, new e(0, 0, 0, aVar));
    }

    private static void a(String str, ImageView imageView, int i, int i2) {
        com.tencent.mm.ak.a.a Pj = o.Pj();
        com.tencent.mm.ak.a.a.c.a aVar = new com.tencent.mm.ak.a.a.c.a();
        aVar.dXw = true;
        aVar.dXN = R.e.chatting_item_biz_default_bg;
        aVar = aVar.bg(i, i2);
        aVar.dXD = 4;
        Pj.a(str, imageView, aVar.Pt(), null, new e());
    }

    private void a(String str, ImageView imageView, int i, boolean z, int i2, e.a aVar) {
        String lX;
        if (q.Pn()) {
            lX = q.lX(str);
        } else {
            lX = str;
        }
        int i3 = z ? R.g.biz_bg_top_rounded_mask : R.g.biz_bg_rounded_mask;
        int i4 = z ? R.g.biz_item_cover_top_round_bg : R.g.biz_item_cover_round_bg;
        int fk = com.tencent.mm.bp.a.fk(imageView.getContext()) - ((int) (((float) (((com.tencent.mm.ui.chatting.b.b.g) this.tKy.O(com.tencent.mm.ui.chatting.b.b.g.class)).isInEditMode() ? 72 : 32)) * com.tencent.mm.bp.a.getDensity(imageView.getContext())));
        com.tencent.mm.ak.a.a Pj = o.Pj();
        com.tencent.mm.ak.a.a.c.a aVar2 = new com.tencent.mm.ak.a.a.c.a();
        aVar2.dXR = i4;
        aVar2.dXy = true;
        aVar2.dXT = String.valueOf(i3);
        com.tencent.mm.ak.a.a.c.a bg = aVar2.bg(fk, i2);
        bg.dXn = new com.tencent.mm.pluginsdk.ui.applet.f();
        bg.dXA = com.tencent.mm.pluginsdk.model.q.v(lX, i, "@T");
        Pj.a(lX, imageView, bg.Pt(), null, new e(i3, fk, i2, aVar));
    }

    public final boolean a(MenuItem menuItem, a aVar, bd bdVar) {
        this.hqL = ai.VE();
        String a;
        switch (menuItem.getItemId()) {
            case s$l.AppCompatTheme_switchStyle /*111*/:
                if (this.hqK) {
                    if (!this.hqK) {
                        x.w("MicroMsg.ChattingItemBizFrom", "transmitAppBrandMsg not AppBrandMsg!");
                        break;
                    }
                    r.a(this.ubT, aVar.tTq.getContext(), bdVar.field_content, bdVar.field_talker, bdVar.field_msgId, bdVar.field_msgSvrId);
                    break;
                }
                a = a(bdVar, aVar.tTq.getContext(), this.ubT);
                if (!ai.oW(a)) {
                    Intent intent = new Intent(aVar.tTq.getContext(), MsgRetransmitUI.class);
                    intent.putExtra("Retr_Msg_content", a);
                    intent.putExtra("Retr_Msg_Type", 2);
                    intent.putExtra("Retr_Biz_Msg_Selected_Msg_Index", this.ubT);
                    intent.putExtra("Retr_Msg_Id", bdVar.field_msgId);
                    intent.putExtra("Retr_MsgFromScene", 1);
                    a = bdVar.field_talker;
                    String ic = u.ic(bdVar.field_msgSvrId);
                    intent.putExtra("reportSessionId", ic);
                    u.b v = u.Hx().v(ic, true);
                    v.p("prePublishId", "msg_" + bdVar.field_msgSvrId);
                    v.p("preUsername", a);
                    v.p("preChatName", a);
                    v.p("preMsgIndex", Integer.valueOf(this.ubT));
                    v.p("sendAppMsgScene", Integer.valueOf(1));
                    aVar.startActivity(intent);
                    break;
                }
                break;
            case 114:
                a = a(bdVar, aVar.tTq.getContext(), 0);
                if (!ai.oW(a)) {
                    am.c(bdVar, a, aVar.tTq.getContext());
                    break;
                }
                break;
            case 126:
                r.a(this.hqL, this.ubT, aVar.tTq.getContext(), aVar.tTq, null, bdVar);
                break;
        }
        return false;
    }

    private static String a(bd bdVar, Context context, int i) {
        if (context == null) {
            x.w("MicroMsg.ChattingItemBizFrom", "getReaderAppMsgContent: context is null");
            return null;
        } else if (bdVar != null) {
            return i.a(context, i, bdVar.field_content, bdVar.field_talker);
        } else {
            x.w("MicroMsg.ChattingItemBizFrom", "getReaderAppMsgContent: msg is null");
            return null;
        }
    }

    public final boolean b(View view, a aVar, bd bdVar) {
        return false;
    }

    private void a(m mVar, View view) {
        r.a(mVar, view, this.tKy.getTalkerUserName());
    }
}
