package com.tencent.mm.ui.chatting.viewitems;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Typeface;
import android.text.TextUtils;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.ak.o;
import com.tencent.mm.bg.d;
import com.tencent.mm.g.a.kz;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.au;
import com.tencent.mm.model.r;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.pluginsdk.f.h;
import com.tencent.mm.pluginsdk.ui.d.j;
import com.tencent.mm.pluginsdk.wallet.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.bl;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.bd;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.chatting.b.b.e;
import com.tencent.mm.ui.chatting.b.b.f;
import com.tencent.mm.ui.chatting.c.a;
import com.tencent.mm.ui.chatting.t.n;
import com.tencent.mm.ui.m;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public final class s extends b {
    static int ucl = Color.parseColor("#888888");
    static int ucm = Color.parseColor("#888888");
    private OnClickListener iDo;
    private String mAppId;
    private c<kz> tGM;
    private a tKy;
    private p tqa;
    private com.tencent.mm.ak.a.a.c tqj;
    private OnClickListener ucd;
    private OnClickListener uce;
    private OnClickListener ucf;
    private OnClickListener ucg;
    private m uch;
    private OnClickListener uci;
    private String ucj;
    private int uck;

    public final boolean bba() {
        return false;
    }

    public s() {
        com.tencent.mm.ak.a.a.c.a aVar = new com.tencent.mm.ak.a.a.c.a();
        aVar.dXW = true;
        aVar.dXN = R.g.brand_default_head;
        this.tqj = aVar.Pt();
        this.uce = new a(this, (byte) 0);
        this.ucd = new 1(this);
        this.uci = new 11(this);
        this.ucf = new 12(this);
        this.tGM = new 13(this);
        this.uch = new 14(this);
        this.ucg = new 15(this);
        this.iDo = new 16(this);
    }

    public final boolean aq(int i, boolean z) {
        if (i == 318767153) {
            return true;
        }
        return false;
    }

    public final View a(LayoutInflater layoutInflater, View view) {
        if (view != null && view.getTag() != null) {
            return view;
        }
        r rVar = new r(layoutInflater, R.i.chatting_item_dyeing_template);
        as asVar = new as();
        asVar.jBR = (CheckBox) rVar.findViewById(R.h.chatting_checkbox);
        asVar.gFD = rVar.findViewById(R.h.chatting_maskview);
        asVar.mQc = (TextView) rVar.findViewById(R.h.chatting_user_tv);
        asVar.eCl = (ImageView) rVar.findViewById(R.h.chatting_avatar_iv);
        asVar.hrs = (TextView) rVar.findViewById(R.h.chatting_time_tv);
        asVar.hrw = (LinearLayout) rVar.findViewById(R.h.chatting_content_ll);
        asVar.ufp.hri = rVar.findViewById(R.h.chatting_item_dyeing_template_old);
        asVar.ufp.ufr = rVar.findViewById(R.h.headerV);
        asVar.ufp.eGX = (TextView) asVar.ufp.hri.findViewById(R.h.title);
        asVar.ufp.jWm = (TextView) asVar.ufp.hri.findViewById(R.h.time);
        asVar.ufp.ufv = (LinearLayout) asVar.ufp.hri.findViewById(R.h.digest_ll);
        asVar.ufp.ufu = (TextView) asVar.hrw.findViewById(R.h.detail);
        asVar.ufp.ufw = asVar.hrw.findViewById(R.h.separatorLineV);
        asVar.ufp.ufs = rVar.findViewById(R.h.more_v);
        asVar.ufp.uft = rVar.findViewById(R.h.more_v_clone);
        asVar.ufq.ufP = rVar.findViewById(R.h.chatting_item_dyeing_template_new);
        asVar.ufq.ufQ = (ImageView) rVar.findViewById(R.h.new_dyeing_template_img);
        asVar.ufq.ufR = rVar.findViewById(R.h.new_dyeing_template_headerV);
        asVar.ufq.ufT = (TextView) rVar.findViewById(R.h.new_dyeing_template_user_tv);
        asVar.ufq.ufS = (ImageView) rVar.findViewById(R.h.new_dyeing_template_avatar_iv);
        asVar.ufq.ufU = rVar.findViewById(R.h.new_dyeing_template_ban_v);
        asVar.ufq.ufV = (ImageView) rVar.findViewById(R.h.new_dyeing_template_shortcut_iv);
        asVar.ufq.ufW = rVar.findViewById(R.h.new_dyeing_template_more_v);
        asVar.ufq.ufX = rVar.findViewById(R.h.new_dyeing_template_more_v_clone);
        asVar.ufq.ufY = (TextView) rVar.findViewById(R.h.new_dyeing_template_title);
        asVar.ufq.ufZ = (TextView) rVar.findViewById(R.h.new_dyeing_template_time);
        asVar.ufq.uga = (TextView) rVar.findViewById(R.h.new_dyeing_template_first_data);
        asVar.ufq.ugb = rVar.findViewById(R.h.new_dyeing_template_header_layout);
        asVar.ufq.ugc = (LinearLayout) rVar.findViewById(R.h.new_dyeing_template_top_line);
        asVar.ufq.ugd = (TextView) rVar.findViewById(R.h.new_dyeing_template_top_line_key);
        asVar.ufq.ugf = (TextView) rVar.findViewById(R.h.new_dyeing_template_top_line_value);
        asVar.ufq.uge = (TextView) rVar.findViewById(R.h.new_dyeing_template_top_line_value_prefix);
        asVar.ufq.ugg = (TextView) rVar.findViewById(R.h.new_dyeing_template_top_line_value_strikethrough);
        asVar.ufq.ugh = rVar.findViewById(R.h.new_dyeing_template_top_line_divider);
        asVar.ufq.ugi = (LinearLayout) rVar.findViewById(R.h.new_dyeing_template_key_value_lines);
        asVar.ufq.ugm = rVar.findViewById(R.h.new_dyeing_template_buttons_top_divider);
        asVar.ufq.ugj = rVar.findViewById(R.h.bottom_buttons_container);
        asVar.ufq.ugk = (LinearLayout) rVar.findViewById(R.h.new_dyeing_template_buttons);
        asVar.ufq.ugl = (LinearLayout) rVar.findViewById(R.h.dyeing_template_vertical_buttons_container);
        asVar.ufq.ugn = (LinearLayout) rVar.findViewById(R.h.new_dyeing_template_button1);
        asVar.ufq.ugq = (TextView) rVar.findViewById(R.h.new_dyeing_template_button1_text);
        asVar.ufq.ugs = (ImageView) rVar.findViewById(R.h.new_dyeing_template_button1_icon);
        asVar.ufq.ugp = rVar.findViewById(R.h.new_dyeing_template_buttons_divider);
        asVar.ufq.ugo = (LinearLayout) rVar.findViewById(R.h.new_dyeing_template_button2);
        asVar.ufq.ugr = (TextView) rVar.findViewById(R.h.new_dyeing_template_button2_text);
        asVar.ufq.ugt = (ImageView) rVar.findViewById(R.h.new_dyeing_template_button2_icon);
        asVar.ufq.ugu = (ImageView) rVar.findViewById(R.h.new_dyeing_template_arrow);
        asVar.tZW = (ImageView) rVar.findViewById(R.h.chatting_item_dyeding_template_refuse_iv);
        asVar.ufq.ugv = rVar.findViewById(R.h.new_dyeing_template_single_wxa_button);
        asVar.ufq.ugw = (ImageView) rVar.findViewById(R.h.new_dyeing_template_single_wxa_icon_iv);
        asVar.ufq.ugx = (TextView) rVar.findViewById(R.h.new_dyeing_template_single_wxa_name_tv);
        asVar.ufq.ugy = (LinearLayout) rVar.findViewById(R.h.new_dyeing_template_ban_toggle);
        asVar.ufq.ugz = (TextView) rVar.findViewById(R.h.new_dyeing_template_ban_toggle_text);
        rVar.setTag(asVar);
        return rVar;
    }

    protected final boolean cxM() {
        return false;
    }

    public final void a(b.a aVar, int i, a aVar2, bd bdVar, String str) {
        this.tKy = aVar2;
        as asVar = (as) aVar;
        Map z = bl.z(bdVar.field_content, "msg");
        if (z == null || z.size() == 0) {
            x.e("MicroMsg.ChattingItemDyeingTemplate", "filling fail, values is empty");
            asVar.hrw.setVisibility(8);
            return;
        }
        asVar.hrw.setVisibility(0);
        int i2 = bi.getInt((String) z.get(".msg.appmsg.mmreader.template_detail.template_show_type"), 0);
        this.ucj = bi.oV((String) z.get(".msg.appmsg.mmreader.template_header.template_msg_id"));
        this.uck = bi.getInt((String) z.get(".msg.appmsg.mmreader.template_header.pay_style"), 0);
        com.tencent.mm.sdk.b.a.sFg.c(this.tGM);
        ((f) aVar2.O(f.class)).b(this.uch);
        String oV;
        String oV2;
        String str2;
        View view;
        au auVar;
        if (i2 != 0) {
            WxaAttributes rR;
            CharSequence charSequence;
            int paddingLeft;
            int i3;
            int d;
            int d2;
            View inflate;
            int childCount;
            au auVar2;
            asVar.ufp.hri.setVisibility(8);
            az azVar = asVar.ufq;
            if (bi.getInt((String) z.get(".msg.appmsg.mmreader.template_detail.template_ext.type"), 0) == 1) {
                a(azVar, bi.oV((String) z.get(".msg.appmsg.mmreader.template_detail.template_ext.app.avatar_url")), bi.oV((String) z.get(".msg.appmsg.mmreader.template_detail.template_ext.app.display_name")), z, bdVar, false);
            } else if (bi.getInt((String) z.get(".msg.appmsg.mmreader.template_header.show_icon_and_display_name"), 0) != 0) {
                a(azVar, bi.oV((String) z.get(".msg.appmsg.mmreader.template_header.icon_url")), bi.oV((String) z.get(".msg.appmsg.mmreader.template_header.display_name")), z, bdVar, true);
            } else {
                ((View) azVar.ufV.getParent()).setVisibility(8);
                if ("notifymessage".equals(bdVar.field_talker)) {
                    oV = bi.oV((String) z.get(".msg.fromusername"));
                    if (((com.tencent.mm.plugin.biz.a.a) g.l(com.tencent.mm.plugin.biz.a.a.class)).gr(oV)) {
                        rR = ((com.tencent.mm.plugin.appbrand.n.c) g.l(com.tencent.mm.plugin.appbrand.n.c.class)).rR(oV);
                        a(azVar.ufS, this.tKy, oV, bdVar, rR == null ? null : rR.field_brandIconURL);
                        charSequence = rR == null ? oV : rR.field_nickname;
                    } else {
                        a(azVar.ufS, this.tKy, oV, bdVar, null);
                        charSequence = ((e) this.tKy.O(e.class)).gT(oV);
                    }
                    azVar.ufT.setText(j.a(this.tKy.tTq.getContext(), charSequence, azVar.ufT.getTextSize()));
                    if (((com.tencent.mm.plugin.biz.a.a) g.l(com.tencent.mm.plugin.biz.a.a.class)).gr(oV)) {
                        azVar.ufR.setTag(new au(bdVar, oV));
                        azVar.ufR.setOnClickListener(this.ucf);
                    } else {
                        azVar.ufR.setTag(new au(oV, this.tKy.cwr() ? this.tKy.getTalkerUserName() : null));
                        azVar.ufR.setOnClickListener(e(this.tKy));
                    }
                    azVar.ufR.setVisibility(0);
                } else {
                    azVar.ufR.setVisibility(8);
                }
            }
            if (bi.getInt((String) z.get(".msg.appmsg.mmreader.template_header.hide_icon_and_display_name_line"), 0) != 0) {
                azVar.ufR.setBackgroundResource(R.g.mm_trans);
            } else {
                paddingLeft = azVar.ufR.getPaddingLeft();
                azVar.ufR.setBackgroundResource(R.g.list_item_normal);
                azVar.ufR.setPadding(paddingLeft, 0, 0, 0);
            }
            if (bi.getInt((String) z.get(".msg.appmsg.mmreader.template_header.ignore_hide_title_and_time"), 0) == 0) {
                i3 = bi.getInt((String) z.get(".msg.appmsg.mmreader.template_header.hide_title_and_time"), 0);
            } else {
                i3 = 0;
            }
            int i4 = bi.getInt((String) z.get(".msg.appmsg.mmreader.template_header.hide_title"), 0);
            int i5 = bi.getInt((String) z.get(".msg.appmsg.mmreader.template_header.hide_time"), 0);
            azVar.ufY.setVisibility(8);
            azVar.ufZ.setVisibility(8);
            if (i3 == 0) {
                if (i4 == 0) {
                    azVar.ufY.setVisibility(0);
                    charSequence = bi.oV((String) z.get(".msg.appmsg.mmreader.template_header.title"));
                    azVar.ufY.setTextColor(d(z, ".msg.appmsg.mmreader.template_header.title_color", -16777216));
                    azVar.ufY.setText(charSequence);
                }
                if (i5 == 0) {
                    long j = bi.getLong(bi.oV((String) z.get(".msg.appmsg.mmreader.template_header.pub_time")), 0);
                    if (j > 0) {
                        azVar.ufZ.setText(h.h(this.tKy.tTq.getMMResources().getString(R.l.fmt_datetime_normal), j));
                        azVar.ufZ.setVisibility(0);
                    } else {
                        azVar.ufZ.setVisibility(8);
                    }
                }
            }
            charSequence = bi.oV((String) z.get(".msg.appmsg.mmreader.template_header.first_data"));
            i4 = d(z, ".msg.appmsg.mmreader.template_header.first_color", ucm);
            if (bi.oW(charSequence)) {
                azVar.uga.setVisibility(8);
            } else {
                azVar.uga.setTextColor(i4);
                azVar.uga.setText(charSequence);
                azVar.uga.setVisibility(0);
                if (i2 == 2) {
                    azVar.uga.setPadding(0, this.tKy.tTq.getMMResources().getDimensionPixelOffset(R.f.LargePadding), 0, 0);
                } else {
                    azVar.uga.setPadding(0, 0, 0, 0);
                }
            }
            if (i3 == 0 || !bi.oW(charSequence)) {
                azVar.ugb.setVisibility(0);
            } else {
                azVar.ugb.setVisibility(8);
            }
            boolean z2 = false;
            boolean z3 = false;
            if ("notifymessage".equals(bdVar.field_talker)) {
                oV2 = bi.oV((String) z.get(".msg.fromusername"));
                z2 = ((com.tencent.mm.plugin.biz.a.a) g.l(com.tencent.mm.plugin.biz.a.a.class)).gr(oV2);
                if (z2) {
                    ((f) this.tKy.O(f.class)).a(this.uch);
                    com.tencent.mm.sdk.b.a.sFg.b(this.tGM);
                    rR = ((com.tencent.mm.plugin.appbrand.n.c) g.l(com.tencent.mm.plugin.appbrand.n.c.class)).rR(oV2);
                    if (rR != null) {
                        this.mAppId = rR.field_appId;
                        z3 = (rR.field_appOpt & 1) > 0;
                    } else {
                        x.i("MicroMsg.ChattingItemDyeingTemplate", "try2HandleAppBrandLogic, sync attr username %s", new Object[]{oV2});
                        ((com.tencent.mm.plugin.appbrand.n.c) g.l(com.tencent.mm.plugin.appbrand.n.c.class)).a(oV2, new 17(this, z, bdVar, azVar));
                    }
                }
            }
            azVar.ufW.setVisibility(z2 ? 0 : 8);
            azVar.ufW.setTag(R.h.new_dyeing_template_more_v, bdVar);
            azVar.ufW.setOnClickListener(this.ucd);
            a(z, bdVar, azVar, z2, z3);
            azVar.ufQ.setVisibility(8);
            azVar.uga.setText(bi.oV((String) z.get(".msg.appmsg.mmreader.template_header.first_data")));
            str2 = (String) z.get(".msg.appmsg.mmreader.template_detail.line_content.topline.key.word");
            oV2 = (String) z.get(".msg.appmsg.mmreader.template_detail.line_content.topline.value.word");
            String str3 = (String) z.get(".msg.appmsg.mmreader.template_detail.line_content.topline.value.strikethrough_word");
            if (bi.oW(oV2)) {
                azVar.ugc.setVisibility(8);
            } else {
                d = d(z, ".msg.appmsg.mmreader.template_detail.line_content.topline.key.color", -16777216);
                d2 = d(z, ".msg.appmsg.mmreader.template_detail.line_content.topline.value.color", -16777216);
                int d3 = d(z, ".msg.appmsg.mmreader.template_detail.line_content.topline.value.strikethrough_word_color", -16777216);
                i5 = bi.getInt((String) z.get(".msg.appmsg.mmreader.template_detail.line_content.topline.value.small_text_count"), 0);
                azVar.ugd.setTextColor(d);
                azVar.ugf.setTextColor(d2);
                azVar.ugg.setTextColor(d3);
                azVar.ugg.getPaint().setFlags(16);
                azVar.ugd.setText(str2);
                if (i5 <= 0 || i5 >= oV2.length()) {
                    azVar.uge.setTypeface(Typeface.DEFAULT);
                    azVar.uge.setVisibility(8);
                    azVar.ugf.setTypeface(Typeface.DEFAULT);
                    azVar.ugf.setText(oV2);
                } else {
                    azVar.uge.setVisibility(0);
                    azVar.uge.setText(oV2.substring(0, i5));
                    azVar.uge.setTextColor(d2);
                    azVar.uge.setTypeface(((b) g.l(b.class)).dR(this.tKy.tTq.getContext()));
                    azVar.ugf.setTypeface(((b) g.l(b.class)).dR(this.tKy.tTq.getContext()));
                    azVar.ugf.setText(oV2.substring(i5));
                }
                if (bi.oW(str3)) {
                    azVar.ugg.setVisibility(8);
                } else {
                    azVar.ugg.setText(str3);
                    azVar.ugg.setVisibility(0);
                }
                azVar.ugc.setVisibility(0);
            }
            int i6 = bi.getInt((String) z.get(".msg.appmsg.mmreader.category.item.template_op_type"), -1);
            if (i6 == 2) {
                x.i("MicroMsg.ChattingItemDyeingTemplate", "[fillingCustomView]");
                azVar.ufZ.setVisibility(8);
                azVar.ugi.setVisibility(8);
                ViewGroup viewGroup = (ViewGroup) azVar.ugi.getParent();
                View findViewById = viewGroup.findViewById(R.h.custom_view);
                if (findViewById == null) {
                    inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.i.remind_template_item, null);
                    ar arVar = new ar();
                    arVar.gwj = (ImageView) inflate.findViewById(R.h.avatar);
                    arVar.ufo = (TextView) inflate.findViewById(R.h.nickname);
                    arVar.jWm = (TextView) inflate.findViewById(R.h.time);
                    arVar.eGX = (TextView) inflate.findViewById(R.h.title);
                    inflate.setTag(arVar);
                    viewGroup.addView(inflate);
                    view = inflate;
                } else {
                    view = findViewById;
                }
                view.setVisibility(0);
                ar arVar2 = (ar) view.getTag();
                oV2 = (String) z.get(".msg.appmsg.mmreader.category.item.schedule_content");
                str3 = (String) z.get(".msg.appmsg.mmreader.category.item.schedule_username");
                CharSequence charSequence2 = (String) z.get(".msg.appmsg.mmreader.category.item.schedule_nickname");
                String str4 = (String) z.get(".msg.appmsg.mmreader.category.item.schedule_time");
                d2 = bi.getInt((String) z.get(".msg.appmsg.mmreader.category.item.schedule_remindsubtype"), -1);
                arVar2.eGX.setText(j.a(arVar2.eGX.getContext(), oV2));
                TextView textView = arVar2.ufo;
                Context context = arVar2.eGX.getContext();
                if (bi.oW(str3)) {
                    charSequence2 = "";
                } else {
                    oV2 = null;
                    if (com.tencent.mm.model.s.fq(str3)) {
                        au.HU();
                        ab Yg = com.tencent.mm.model.c.FR().Yg(str3);
                        if (Yg != null) {
                            oV2 = Yg.BL() == null ? Yg.BK() : Yg.BL();
                        }
                    } else {
                        au.HU();
                        ab Yg2 = com.tencent.mm.model.c.FR().Yg(str3);
                        oV2 = Yg2.BL() == null ? Yg2.BK() : Yg2.BL();
                    }
                    if (bi.oW(oV2)) {
                        x.i("MicroMsg.ChattingItemDyeingTemplate", "[getDisplayName] username:%s nickname:%s", new Object[]{str3, charSequence2});
                        if (charSequence2 == null) {
                            charSequence2 = ad.getContext().getString(R.l.chatting_roominfo_noname);
                        }
                    } else {
                        Object charSequence22 = oV2;
                    }
                }
                textView.setText(j.a(context, charSequence22));
                arVar2.jWm.setText(str4);
                if (d2 == 2) {
                    arVar2.gwj.setImageDrawable(ad.getContext().getResources().getDrawable(R.g.app_add_to_favorite));
                } else {
                    com.tencent.mm.pluginsdk.ui.a.b.a(arVar2.gwj, str3);
                }
            } else {
                List arrayList = new ArrayList();
                paddingLeft = 0;
                while (true) {
                    d = paddingLeft;
                    if (d < 100) {
                        String str5 = d == 0 ? ".msg.appmsg.mmreader.template_detail.line_content.lines.line" : ".msg.appmsg.mmreader.template_detail.line_content.lines.line" + d;
                        str2 = (String) z.get(str5 + ".value.word");
                        oV2 = (String) z.get(str5 + ".key.word");
                        if (bi.oW(str2) && bi.oW(oV2)) {
                            x.i("MicroMsg.ChattingItemDyeingTemplate", "fillingLines: lines count=%d", new Object[]{Integer.valueOf(d)});
                            break;
                        }
                        aw awVar = new aw();
                        awVar.ufI = str2;
                        awVar.ufH = bi.oV(oV2);
                        awVar.ufJ = d(z, str5 + ".key.color", ucl);
                        awVar.ufK = d(z, str5 + ".value.color", -16777216);
                        awVar.ufL = bi.getInt((String) z.get(new StringBuilder().append(str5).append(".key.hide").toString()), 0) != 0;
                        paddingLeft = (aaC(awVar.ufH) + 1) / 2;
                        if (paddingLeft <= 0) {
                            paddingLeft = 0;
                        }
                        arrayList.add(awVar);
                        d++;
                    } else {
                        break;
                    }
                }
                i5 = 0 > 8 ? 8 : 0;
                LinearLayout linearLayout = azVar.ugi;
                linearLayout.setVisibility(0);
                view = ((ViewGroup) azVar.ugi.getParent()).findViewById(R.h.custom_view);
                if (view != null) {
                    view.setVisibility(8);
                }
                if (linearLayout.getChildCount() > arrayList.size()) {
                    if (arrayList.size() == 0) {
                        linearLayout.removeAllViews();
                    } else {
                        linearLayout.removeViews(arrayList.size(), linearLayout.getChildCount() - arrayList.size());
                    }
                }
                childCount = linearLayout.getChildCount();
                paddingLeft = 0;
                while (true) {
                    d = paddingLeft;
                    if (d >= arrayList.size()) {
                        break;
                    }
                    LinearLayout linearLayout2;
                    aw awVar2 = (aw) arrayList.get(d);
                    if (d < childCount) {
                        linearLayout2 = (LinearLayout) linearLayout.getChildAt(d);
                    } else {
                        linearLayout2 = (LinearLayout) LayoutInflater.from(this.tKy.tTq.getContext()).inflate(R.i.chatting_dyeing_template_line_item, null, false);
                        ax axVar = new ax();
                        axVar.ufM = (TextView) linearLayout2.findViewById(R.h.line_key);
                        axVar.ufN = (TextView) linearLayout2.findViewById(R.h.line_value);
                        linearLayout2.setTag(axVar);
                        linearLayout.addView(linearLayout2);
                    }
                    ax axVar2 = (ax) linearLayout2.getTag();
                    if (awVar2.ufL) {
                        axVar2.ufM.setVisibility(8);
                    } else {
                        axVar2.ufM.setVisibility(0);
                        axVar2.ufM.setEms(i5);
                        axVar2.ufM.setTextColor(awVar2.ufJ);
                        axVar2.ufM.setText(awVar2.ufH);
                    }
                    axVar2.ufN.setTextColor(awVar2.ufK);
                    axVar2.ufN.setText(awVar2.ufI);
                    paddingLeft = d + 1;
                }
                if (linearLayout.getChildCount() == 0) {
                    azVar.ugh.setVisibility(8);
                    linearLayout.setVisibility(8);
                } else {
                    if (bi.getInt((String) z.get(".msg.appmsg.mmreader.template_detail.line_content.topline.key.hide_dash_line"), 0) != 0) {
                        azVar.ugh.setVisibility(8);
                    } else {
                        azVar.ugh.setVisibility(0);
                    }
                    linearLayout.setVisibility(0);
                }
            }
            if (bi.getInt((String) z.get(".msg.appmsg.mmreader.template_detail.opitems.show_type"), 0) != 0) {
                azVar.ugv.setVisibility(8);
                azVar.ugk.setVisibility(8);
                azVar.ugm.setVisibility(8);
                azVar.ugl.setVisibility(0);
                a(azVar, bdVar, z);
            } else {
                String oV3;
                String str6;
                azVar.ugl.setVisibility(8);
                str2 = (String) z.get(".msg.appmsg.mmreader.template_detail.opitems.opitem.word");
                oV2 = (String) z.get(".msg.appmsg.mmreader.template_detail.opitems.opitem.icon");
                if (bi.oW(str2)) {
                    azVar.ugn.setVisibility(8);
                } else {
                    azVar.ugq.setTextColor(d(z, ".msg.appmsg.mmreader.template_detail.opitems.opitem.color", -16777216));
                    azVar.ugq.setText(str2);
                    if (bi.oW(oV2)) {
                        azVar.ugs.setVisibility(8);
                        azVar.ugq.setPadding(0, 0, 0, 0);
                    } else {
                        azVar.ugs.setVisibility(0);
                        g(azVar.ugs, oV2);
                        azVar.ugq.setPadding(0, 0, com.tencent.mm.bp.a.fromDPToPix(this.tKy.tTq.getContext(), 16), 0);
                    }
                    str2 = (String) z.get(".msg.appmsg.mmreader.template_detail.opitems.opitem.url");
                    oV3 = bi.oV((String) z.get(".msg.fromusername"));
                    i4 = bi.getInt((String) z.get(".msg.appmsg.mmreader.template_detail.opitems.opitem.op_type"), 0);
                    str6 = (String) z.get(".msg.appmsg.mmreader.template_detail.opitems.opitem.weapp_username");
                    auVar2 = new au(bdVar, oV3, str2);
                    azVar.ugn.setTag(auVar2);
                    azVar.ugv.setTag(auVar2);
                    if (i4 != 1 || TextUtils.isEmpty(str6)) {
                        azVar.ugn.setOnClickListener(new 4(this, str2, oV3));
                        azVar.ugv.setOnClickListener(null);
                    } else {
                        3 3 = new 3(this, str6, bi.oV((String) z.get(".msg.appmsg.template_id")), bi.getInt((String) z.get(".msg.appmsg.mmreader.template_detail.opitems.opitem.weapp_state"), 0), bi.getInt((String) z.get(".msg.appmsg.mmreader.template_detail.opitems.opitem.weapp_version"), 0), (String) z.get(".msg.appmsg.mmreader.template_detail.opitems.opitem.weapp_path"), oV3);
                        azVar.ugn.setOnClickListener(3);
                        azVar.ugv.setOnClickListener(3);
                    }
                    azVar.ugn.setVisibility(0);
                }
                str2 = (String) z.get(".msg.appmsg.mmreader.template_detail.opitems.opitem1.word");
                str3 = (String) z.get(".msg.appmsg.mmreader.template_detail.opitems.opitem1.icon");
                if (bi.oW(str2)) {
                    azVar.ugo.setVisibility(8);
                } else {
                    azVar.ugr.setTextColor(d(z, ".msg.appmsg.mmreader.template_detail.opitems.opitem1.color", -16777216));
                    azVar.ugr.setText(str2);
                    if (bi.oW(str3)) {
                        azVar.ugt.setVisibility(8);
                        azVar.ugr.setPadding(0, 0, 0, 0);
                    } else {
                        azVar.ugt.setVisibility(0);
                        g(azVar.ugt, str3);
                        azVar.ugr.setPadding(0, 0, com.tencent.mm.bp.a.fromDPToPix(this.tKy.tTq.getContext(), 16), 0);
                    }
                    str2 = (String) z.get(".msg.appmsg.mmreader.template_detail.opitems.opitem1.url");
                    oV3 = bi.oV((String) z.get(".msg.fromusername"));
                    i5 = bi.getInt((String) z.get(".msg.appmsg.mmreader.template_detail.opitems.opitem1.op_type"), 0);
                    str6 = (String) z.get(".msg.appmsg.mmreader.template_detail.opitems.opitem1.weapp_username");
                    azVar.ugo.setTag(new au(bdVar, oV3, str2));
                    if (i5 != 1 || TextUtils.isEmpty(str6)) {
                        final String str7 = oV3;
                        azVar.ugo.setOnClickListener(new OnClickListener() {
                            public final void onClick(View view) {
                                if (!bi.oW(str2)) {
                                    Intent intent = new Intent();
                                    intent.putExtra("rawUrl", str2);
                                    d.b(s.this.tKy.tTq.getContext(), "webview", ".ui.tools.WebViewUI", intent);
                                    com.tencent.mm.plugin.report.service.h.mEJ.h(11608, new Object[]{s.this.ucj, str7, Integer.valueOf(2)});
                                }
                            }
                        });
                    } else {
                        final String str8 = (String) z.get(".msg.appmsg.mmreader.template_detail.opitems.opitem1.weapp_path");
                        final int i7 = bi.getInt((String) z.get(".msg.appmsg.mmreader.template_detail.opitems.opitem1.weapp_version"), 0);
                        childCount = bi.getInt((String) z.get(".msg.appmsg.mmreader.template_detail.opitems.opitem1.weapp_state"), 0);
                        oV = bi.oV((String) z.get(".msg.appmsg.template_id"));
                        azVar.ugo.setOnClickListener(new OnClickListener() {
                            public final void onClick(View view) {
                                au auVar = (au) view.getTag();
                                x.i("MicroMsg.ChattingItemDyeingTemplate", "on app brand(%s) button1 click", new Object[]{str6});
                                AppBrandStatObject appBrandStatObject = new AppBrandStatObject();
                                appBrandStatObject.bGG = auVar.bXQ.field_msgSvrId + ":" + auVar.userName + ":" + s.this.tKy.getTalkerUserName() + ":" + oV;
                                if (((com.tencent.mm.plugin.biz.a.a) g.l(com.tencent.mm.plugin.biz.a.a.class)).gr(auVar.userName)) {
                                    appBrandStatObject.scene = 1014;
                                    ((com.tencent.mm.plugin.appbrand.n.d) g.l(com.tencent.mm.plugin.appbrand.n.d.class)).a(s.this.tKy.tTq.getContext(), str6, null, childCount, i7, str8, appBrandStatObject);
                                } else {
                                    appBrandStatObject.scene = 1043;
                                    com.tencent.mm.ac.d kH = com.tencent.mm.ac.f.kH(auVar.userName);
                                    ((com.tencent.mm.plugin.appbrand.n.d) g.l(com.tencent.mm.plugin.appbrand.n.d.class)).a(s.this.tKy.tTq.getContext(), str6, null, childCount, i7, str8, appBrandStatObject, kH == null ? null : kH.field_appId);
                                }
                                s.B(9, s.this.mAppId, s.this.ucj);
                                com.tencent.mm.plugin.report.service.h.mEJ.h(11608, new Object[]{s.this.ucj, oV3, Integer.valueOf(2)});
                            }
                        });
                    }
                    azVar.ugo.setVisibility(0);
                }
                azVar.ugu.setVisibility(8);
                if (azVar.ugn.getVisibility() == 8 && azVar.ugo.getVisibility() == 8) {
                    azVar.ugk.setVisibility(8);
                    azVar.ugj.setVisibility(8);
                    azVar.ugm.setVisibility(8);
                } else {
                    azVar.ugm.setVisibility(0);
                    paddingLeft = this.tKy.tTq.getMMResources().getDimensionPixelOffset(R.f.LargePadding);
                    if (azVar.ugn.getVisibility() == 0 && azVar.ugo.getVisibility() == 0) {
                        azVar.ugn.setGravity(17);
                        azVar.ugo.setGravity(17);
                        azVar.ugn.setPadding(paddingLeft, 0, paddingLeft, 0);
                        azVar.ugo.setPadding(paddingLeft, 0, paddingLeft, 0);
                    } else if (azVar.ugn.getVisibility() == 0) {
                        if (bi.oW(oV2)) {
                            azVar.ugn.setGravity(19);
                            azVar.ugn.setPadding(paddingLeft, 0, 0, 0);
                            azVar.ugu.setVisibility(0);
                        } else {
                            azVar.ugn.setGravity(17);
                            azVar.ugn.setPadding(paddingLeft, 0, paddingLeft, 0);
                        }
                    } else if (bi.oW(str3)) {
                        azVar.ugo.setGravity(19);
                        azVar.ugo.setPadding(this.tKy.tTq.getMMResources().getDimensionPixelOffset(R.f.LargePadding), 0, 0, 0);
                        azVar.ugu.setVisibility(0);
                    } else {
                        azVar.ugo.setGravity(17);
                        azVar.ugo.setPadding(paddingLeft, 0, paddingLeft, 0);
                    }
                    azVar.ugk.setVisibility(0);
                    azVar.ugj.setVisibility(0);
                }
                if (azVar.ugn.getVisibility() == 0 && azVar.ugo.getVisibility() == 0) {
                    azVar.ugp.setVisibility(0);
                } else {
                    azVar.ugp.setVisibility(8);
                }
                oV2 = bi.oV((String) z.get(".msg.fromusername"));
                i4 = bi.getInt((String) z.get(".msg.appmsg.mmreader.template_detail.opitems.opitem.op_type"), 0);
                str2 = (String) z.get(".msg.appmsg.mmreader.template_detail.opitems.opitem.weapp_username");
                if (!ab.gr(oV2) && azVar.ugn.getVisibility() != 8 && azVar.ugo.getVisibility() == 8 && i4 == 1 && ab.gr(str2)) {
                    WxaAttributes rR2 = ((com.tencent.mm.plugin.appbrand.n.c) g.l(com.tencent.mm.plugin.appbrand.n.c.class)).rR(str2);
                    str3 = rR2 == null ? null : rR2.field_brandIconURL;
                    CharSequence charSequence3 = rR2 == null ? str2 : rR2.field_nickname;
                    o.Pj().a(str3, azVar.ugw, this.tqj);
                    azVar.ugx.setText(charSequence3);
                    if (rR2 == null) {
                        ((com.tencent.mm.plugin.appbrand.n.c) g.l(com.tencent.mm.plugin.appbrand.n.c.class)).a(str2, new 7(this, azVar, str2));
                    }
                    azVar.ugv.setVisibility(0);
                    azVar.ugk.setVisibility(8);
                } else {
                    azVar.ugv.setVisibility(8);
                }
            }
            String oV4 = bi.oV((String) z.get(".msg.fromusername"));
            String str9 = null;
            if (!bi.oW(oV4)) {
                au.HU();
                str9 = com.tencent.mm.model.c.FR().Yg(oV4).BK();
            }
            String str10 = (String) z.get(".msg.appmsg.mmreader.category.item.title");
            String str11 = (String) z.get(".msg.appmsg.mmreader.category.item.url");
            str2 = (String) z.get(".msg.appmsg.mmreader.category.item.native_url");
            oV2 = (String) z.get(".msg.appmsg.template_id");
            str3 = (String) z.get(".msg.appmsg.mmreader.category.item.weapp_username");
            if (i6 == 1 && !TextUtils.isEmpty(str3)) {
                auVar = new au(bdVar, oV4, str11);
                auVar.position = i;
                azVar.ufP.setTag(auVar);
                azVar.ufP.setOnClickListener(this.iDo);
            } else if (i6 == -1 && ((com.tencent.mm.plugin.biz.a.a) g.l(com.tencent.mm.plugin.biz.a.a.class)).gr(oV4)) {
                str3 = (String) z.get(".msg.appmsg.mmreader.template_detail.opitems.opitem.url");
                View view2 = azVar.ufP;
                auVar2 = new au(bdVar, false, i, oV4, false, this.tKy.cuz(), oV4, str9, str10);
                auVar2.ceR = str2;
                auVar2.ufD = str3;
                view2.setTag(auVar2);
                azVar.ufP.setOnClickListener(this.ucg);
            } else if (i6 == 2) {
                auVar = new au(bdVar, oV4, str11);
                auVar.position = i;
                azVar.ufP.setTag(auVar);
                azVar.ufP.setOnClickListener(this.iDo);
            } else {
                inflate = azVar.ufP;
                au auVar3 = new au(bdVar, false, i, str11, false, this.tKy.cuz(), oV4, str9, str10);
                auVar3.ceR = str2;
                inflate.setTag(auVar3);
                azVar.ufP.setOnClickListener(g(this.tKy));
            }
            azVar.ufP.setOnLongClickListener(c(this.tKy));
            if (com.tencent.mm.k.g.AU().AI()) {
                asVar.tZW.setVisibility(0);
                c(this.tKy, asVar.tZW, new n(oV2, bdVar, str9));
            }
            if (((com.tencent.mm.plugin.biz.a.a) g.l(com.tencent.mm.plugin.biz.a.a.class)).gr(bi.oV((String) z.get(".msg.fromusername"))) && "notifymessage".equals(bdVar.field_talker)) {
                x.i("MicroMsg.ChattingItemDyeingTemplate", "fillingMoreVNew handled by app brand");
                azVar.ufX.setTag(null);
                azVar.ufX.setVisibility(8);
            } else {
                if ((bi.getInt((String) z.get(".msg.appmsg.mmreader.template_header.show_complaint_button"), 0) == 1 ? 1 : null) == null) {
                    x.i("MicroMsg.ChattingItemDyeingTemplate", "fillingMoreVNew showMoreV false");
                } else if (azVar.ufR.getVisibility() == 0) {
                    azVar.ufW.setTag(bdVar);
                    azVar.ufW.setOnClickListener(this.uce);
                    azVar.ufW.setVisibility(0);
                    azVar.ufX.setVisibility(8);
                } else if (azVar.ugb.getVisibility() == 0) {
                    azVar.ufX.setTag(bdVar);
                    azVar.ufX.setOnClickListener(this.uce);
                    azVar.ufX.setVisibility(0);
                    azVar.ufW.setVisibility(8);
                }
                azVar.ufW.setTag(null);
                azVar.ufX.setTag(null);
                azVar.ufW.setVisibility(8);
                azVar.ufX.setVisibility(8);
            }
            asVar.ufq.ufP.setVisibility(0);
            return;
        }
        asVar.ufq.ufP.setVisibility(8);
        oV = bi.oV((String) z.get(".msg.fromusername"));
        int i8 = bi.getInt((String) z.get(".msg.appmsg.mmreader.template_detail.template_ext.type"), 0);
        x.i("MicroMsg.ChattingItemDyeingTemplate", "fillingOld extType=%d", new Object[]{Integer.valueOf(i8)});
        if (i8 == 1) {
            oV2 = bi.oV((String) z.get(".msg.appmsg.mmreader.template_detail.template_ext.app.avatar_url"));
            a(asVar, j.a(this.tKy.tTq.getContext(), bi.oV((String) z.get(".msg.appmsg.mmreader.template_detail.template_ext.app.display_name")), asVar.mQc.getTextSize()));
            asVar.eCl.setTag(null);
            asVar.eCl.setOnClickListener(null);
            o.Pj().a(oV2, asVar.eCl, this.tqj);
        } else {
            a(asVar, this.tKy, bdVar, oV);
            a(asVar.eCl, this.tKy, oV, bdVar, null);
            if (((com.tencent.mm.plugin.biz.a.a) g.l(com.tencent.mm.plugin.biz.a.a.class)).gr(oV)) {
                asVar.ufp.ufr.setTag(new au(bdVar, oV));
                asVar.ufp.ufr.setOnClickListener(this.ucf);
            } else {
                asVar.ufp.ufr.setTag(new au(oV, this.tKy.cwr() ? this.tKy.getTalkerUserName() : null));
                asVar.ufp.ufr.setOnClickListener(e(this.tKy));
            }
        }
        x.d("MicroMsg.ChattingItemDyeingTemplate", "dyeing template talker(%s).", new Object[]{bdVar.field_talker});
        if ("notifymessage".equals(bdVar.field_talker) || i8 == 1) {
            asVar.ufp.ufr.setVisibility(0);
            asVar.ufp.eGX.setTextSize(0, (float) com.tencent.mm.bp.a.ad(asVar.ufp.eGX.getContext(), R.f.NormalTextSize));
        } else {
            asVar.ufp.ufr.setVisibility(8);
            asVar.ufp.eGX.setTextSize(0, (float) com.tencent.mm.bp.a.ad(asVar.ufp.eGX.getContext(), R.f.ActionBarTextSize));
        }
        asVar.ufp.hri.setVisibility(0);
        b az = b.az(z);
        asVar.ufp.eGX.setText(az.title);
        asVar.ufp.jWm.setText(h.h(this.tKy.tTq.getMMResources().getString(R.l.fmt_date), az.time));
        t.a(asVar.ufp.ufv, z);
        String str12 = null;
        if (!bi.oW(oV)) {
            au.HU();
            str12 = com.tencent.mm.model.c.FR().Yg(oV).BK();
        }
        Object obj = !bi.oW(az.url) ? 1 : null;
        str2 = (String) z.get(".msg.appmsg.mmreader.category.item.weapp_username");
        if (bi.getInt((String) z.get(".msg.appmsg.mmreader.category.item.template_op_type"), 0) != 1 || TextUtils.isEmpty(str2)) {
            view = asVar.ufp.hri;
            au auVar4 = new au(bdVar, false, i, az.url, false, this.tKy.cuz(), oV, str12, az.title);
            auVar4.ceR = az.ceR;
            view.setTag(auVar4);
            asVar.ufp.hri.setOnClickListener(g(this.tKy));
        } else {
            auVar = new au(bdVar, oV, az.url);
            auVar.position = i;
            asVar.ufp.hri.setTag(auVar);
            asVar.ufp.hri.setOnClickListener(this.iDo);
            obj = 1;
        }
        asVar.ufp.hri.setOnLongClickListener(c(this.tKy));
        if (obj == null) {
            asVar.ufp.ufw.setVisibility(8);
            asVar.ufp.ufu.setVisibility(8);
        } else {
            asVar.ufp.ufw.setVisibility(0);
            asVar.ufp.ufu.setVisibility(0);
        }
        if (com.tencent.mm.k.g.AU().AI()) {
            asVar.tZW.setVisibility(0);
            c(this.tKy, asVar.tZW, new n(az.dxx, bdVar, str12));
        }
        at atVar = asVar.ufp;
        if ((bi.getInt((String) z.get(".msg.appmsg.mmreader.template_header.show_complaint_button"), 0) == 1 ? 1 : null) == null) {
            x.i("MicroMsg.ChattingItemDyeingTemplate", "fillingMoreVNew showMoreV false");
            atVar.ufs.setTag(null);
            atVar.uft.setTag(null);
            atVar.ufs.setVisibility(8);
            atVar.uft.setVisibility(8);
        } else if (atVar.ufr.getVisibility() == 0) {
            atVar.ufs.setTag(bdVar);
            atVar.ufs.setOnClickListener(this.uce);
            atVar.ufs.setVisibility(0);
            atVar.uft.setVisibility(8);
        } else {
            atVar.uft.setTag(bdVar);
            atVar.uft.setOnClickListener(this.uce);
            atVar.uft.setVisibility(0);
            atVar.ufs.setVisibility(8);
        }
        asVar.ufp.hri.setVisibility(0);
    }

    public final boolean a(ContextMenu contextMenu, View view, bd bdVar) {
        au auVar = (au) view.getTag();
        if (auVar == null) {
            return false;
        }
        int i = auVar.position;
        if (!this.tKy.cws()) {
            contextMenu.add(i, 100, 0, view.getContext().getString(R.l.chatting_long_click_menu_delete_msg));
        }
        return true;
    }

    protected final boolean cxO() {
        return this.uck == 0;
    }

    public final boolean b(View view, a aVar, bd bdVar) {
        return false;
    }

    public final boolean a(MenuItem menuItem, a aVar, bd bdVar) {
        switch (menuItem.getItemId()) {
            case 100:
                Map z = bl.z(bdVar.field_content, "msg");
                if (!(z == null || z.size() == 0)) {
                    if (((com.tencent.mm.plugin.biz.a.a) g.l(com.tencent.mm.plugin.biz.a.a.class)).gr(bi.oV((String) z.get(".msg.fromusername")))) {
                        B(7, this.mAppId, this.ucj);
                        break;
                    }
                }
                break;
        }
        return false;
    }

    protected final void a(b.a aVar, a aVar2, bd bdVar, String str) {
        if (str != null && aVar.mQc != null) {
            a(aVar, j.a(aVar2.tTq.getContext(), ((e) aVar2.O(e.class)).gT(str), aVar.mQc.getTextSize()));
        }
    }

    private void a(ImageView imageView, a aVar, String str, bd bdVar, String str2) {
        if (imageView != null) {
            if (com.tencent.mm.model.s.hO(str)) {
                imageView.setVisibility(8);
                return;
            }
            imageView.setVisibility(0);
            if (((com.tencent.mm.plugin.biz.a.a) g.l(com.tencent.mm.plugin.biz.a.a.class)).gr(str)) {
                o.Pj().a(str2, imageView, this.tqj);
                imageView.setTag(new au(bdVar, str));
                imageView.setOnClickListener(this.ucf);
            } else {
                String talkerUserName;
                Bitmap d = com.tencent.mm.ac.m.d(str, null, 0);
                if (d != null) {
                    imageView.setImageBitmap(d);
                } else {
                    imageView.setImageResource(R.g.brand_default_head);
                }
                if (aVar.cwr()) {
                    talkerUserName = aVar.getTalkerUserName();
                } else {
                    talkerUserName = null;
                }
                imageView.setTag(new au(str, talkerUserName));
                imageView.setOnClickListener(e(aVar));
            }
            imageView.setOnLongClickListener(f(aVar));
            imageView.setContentDescription(r.gT(str) + aVar.tTq.getContext().getString(R.l.avatar_desc));
        }
    }

    private void a(az azVar, String str, String str2, Map<String, String> map, bd bdVar, boolean z) {
        azVar.ufT.setText(j.a(this.tKy.tTq.getContext(), str2, azVar.ufT.getTextSize()));
        o.Pj().a(str, azVar.ufS, this.tqj);
        azVar.ufS.setTag(null);
        azVar.ufS.setOnClickListener(null);
        azVar.ufR.setTag(null);
        azVar.ufR.setOnClickListener(null);
        azVar.ufR.setVisibility(0);
        String oV = bi.oV((String) map.get(".msg.appmsg.mmreader.template_header.weapp_username"));
        String oV2 = bi.oV((String) map.get(".msg.appmsg.mmreader.template_header.header_jump_url"));
        if (bi.oW(oV) && bi.oW(oV2)) {
            azVar.ufR.setOnClickListener(null);
        } else {
            azVar.ufR.setTag(new au(bdVar, bi.oV((String) map.get(".msg.fromusername"))));
            azVar.ufR.setOnClickListener(this.uci);
        }
        oV = bi.oV((String) map.get(".msg.appmsg.mmreader.template_header.shortcut_icon_url"));
        if (!z || bi.oW(oV)) {
            ((View) azVar.ufV.getParent()).setVisibility(8);
            return;
        }
        ((View) azVar.ufV.getParent()).setVisibility(0);
        o.Pj().a(oV, azVar.ufV, this.tqj);
    }

    private void a(Map<String, String> map, bd bdVar, az azVar, boolean z, boolean z2) {
        azVar.ugy.setVisibility(z ? 0 : 8);
        if (z2) {
            azVar.ufU.setVisibility(0);
            azVar.ugz.setText(this.tKy.tTq.getMMResources().getString(R.l.notify_message_settings_receive_app_brand_msg_short));
        } else {
            azVar.ufU.setVisibility(8);
            azVar.ugz.setText(this.tKy.tTq.getMMResources().getString(R.l.notify_message_settings_ban_app_brand_msg_short));
        }
        azVar.ugy.setTag(R.h.new_dyeing_template_ban_toggle_text, bdVar);
        azVar.ugy.setOnClickListener(new 18(this, map, z2, azVar, bdVar));
    }

    private void a(az azVar, bd bdVar, Map<String, String> map) {
        LinearLayout linearLayout = azVar.ugl;
        int childCount = linearLayout.getChildCount();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < 10) {
                String str = i2 == 0 ? ".msg.appmsg.mmreader.template_detail.opitems.opitem" : ".msg.appmsg.mmreader.template_detail.opitems.opitem" + i2;
                String str2 = (String) map.get(str + ".word");
                String str3 = (String) map.get(str + ".hint_word");
                if (bi.oW(str2)) {
                    x.i("MicroMsg.ChattingItemDyeingTemplate", "fillingVerticalButtons: count=%d", new Object[]{Integer.valueOf(i2)});
                    i = linearLayout.getChildCount();
                    if (i <= i2) {
                        return;
                    }
                    if (i2 == 0) {
                        linearLayout.removeAllViews();
                        return;
                    } else {
                        linearLayout.removeViews(i2, i - i2);
                        return;
                    }
                }
                LinearLayout linearLayout2;
                if (i2 < childCount) {
                    linearLayout2 = (LinearLayout) linearLayout.getChildAt(i2);
                } else {
                    linearLayout2 = (LinearLayout) LayoutInflater.from(this.tKy.tTq.getContext()).inflate(R.i.chatting_dyeing_template_button_item, null, false);
                    a aVar = new a();
                    aVar.eGX = (TextView) linearLayout2.findViewById(R.h.new_dyeing_template_button_text);
                    aVar.gwj = (ImageView) linearLayout2.findViewById(R.h.new_dyeing_template_button_icon);
                    aVar.tZf = (LinearLayout) linearLayout2.findViewById(R.h.new_dyeing_template_button_Ll);
                    aVar.eGD = (TextView) linearLayout2.findViewById(R.h.new_dyeing_template_button_hint);
                    linearLayout2.setTag(aVar);
                    linearLayout.addView(linearLayout2);
                }
                a aVar2 = (a) linearLayout2.getTag();
                String str4 = (String) map.get(str + ".icon");
                aVar2.eGX.setTextColor(d(map, str + ".color", -16777216));
                aVar2.eGX.setText(str2);
                aVar2.eGD.setText(str3);
                if (bi.oW(str4)) {
                    aVar2.gwj.setVisibility(8);
                    aVar2.eGX.setPadding(0, 0, 0, 0);
                } else {
                    aVar2.gwj.setVisibility(0);
                    g(aVar2.gwj, str4);
                    aVar2.eGX.setPadding(0, 0, com.tencent.mm.bp.a.fromDPToPix(this.tKy.tTq.getContext(), 28), 0);
                }
                str2 = (String) map.get(str + ".url");
                String oV = bi.oV((String) map.get(".msg.fromusername"));
                int i3 = bi.getInt((String) map.get(str + ".op_type"), 0);
                str4 = (String) map.get(str + ".weapp_username");
                aVar2.tZf.setTag(new au(bdVar, oV, str2));
                int i4 = i2 + 1;
                if (i3 == 1 && !TextUtils.isEmpty(str4)) {
                    String str5 = (String) map.get(str + ".weapp_path");
                    aVar2.tZf.setOnClickListener(new 8(this, str4, bi.oV((String) map.get(".msg.appmsg.template_id")), bi.getInt((String) map.get(str + ".weapp_state"), 0), bi.getInt((String) map.get(str + ".weapp_version"), 0), str5, oV, i4));
                } else if (i3 == 2) {
                    aVar2.tZf.setOnClickListener(new 9(this, i4, map));
                } else {
                    aVar2.tZf.setOnClickListener(new 10(this, str2, oV, i4));
                }
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    private static void g(ImageView imageView, String str) {
        if (!bi.oW(str) && imageView != null) {
            com.tencent.mm.ak.a.a.c.a aVar = new com.tencent.mm.ak.a.a.c.a();
            au.HU();
            aVar.dXB = com.tencent.mm.model.c.Gc();
            aVar.dXy = true;
            aVar.dXV = true;
            o.Pj().a(str, imageView, aVar.Pt());
        }
    }

    private static void B(int i, String str, String str2) {
        x.d("MicroMsg.ChattingItemDyeingTemplate", "stev report(%s), eventId : %d, appId %s, templateId %s", new Object[]{Integer.valueOf(13796), Integer.valueOf(i), str, str2});
        com.tencent.mm.plugin.report.service.h.mEJ.h(13796, new Object[]{Integer.valueOf(i), str, str2, Integer.valueOf(0), Long.valueOf(bi.VE())});
    }

    private static int d(Map<String, String> map, String str, int i) {
        if (map == null || bi.oW(str)) {
            return i;
        }
        try {
            return Color.parseColor(bi.oV((String) map.get(str)));
        } catch (Exception e) {
            return i;
        }
    }

    private static int aaC(String str) {
        int i = 0;
        if (bi.oW(str)) {
            return 0;
        }
        String str2 = "[Α-￥]";
        int i2 = 0;
        while (true) {
            int i3 = i;
            if (i2 >= str.length()) {
                return i3;
            }
            if (str.substring(i2, i2 + 1).matches(str2)) {
                i = i3 + 2;
            } else {
                i = i3 + 1;
            }
            i2++;
        }
    }
}
