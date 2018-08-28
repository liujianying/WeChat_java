package com.tencent.mm.ui.chatting.b;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.PorterDuff.Mode;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.ActionBarContainer;
import android.util.DisplayMetrics;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewStub;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.aa.f.c;
import com.tencent.mm.aa.q;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.au;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.u;
import com.tencent.mm.ui.b;
import com.tencent.mm.ui.chatting.b.a.a;
import com.tencent.mm.ui.chatting.b.b.l;
import com.tencent.mm.ui.chatting.b.b.m;
import com.tencent.mm.ui.chatting.b.b.o;
import com.tencent.mm.ui.chatting.b.b.w;
import com.tencent.mm.ui.chatting.e;
import com.tencent.mm.ui.t;
import com.tencent.mm.ui.v;
import com.tencent.mm.ui.y;
import java.util.LinkedList;
import java.util.List;

@a(cwo = o.class)
public class s extends a implements o {
    private int mZZ = 0;
    private boolean tOB = false;
    private final j.a tOy = new 4(this);
    protected LinearLayout tQe;
    protected LinearLayout tQf;
    private List<String> tQg = new LinkedList();
    private String tQh;
    private ActionBarContainer tQi = null;
    public t tQj = null;
    private b tQk;
    private View tQl;
    final v tQm = new a(this);
    private com.tencent.mm.model.b.b.a tQn = new 1(this);
    private final c tQo = new 3(this);
    private OnMenuItemClickListener tQp = new 7(this);
    final int tQq = 1;
    final int tQr = 2;
    final OnMenuItemClickListener tQs = new 8(this);
    private View tQt = null;
    private View tQu = null;

    public final void onConfigurationChanged(Configuration configuration) {
        int i;
        int i2 = 1;
        super.onConfigurationChanged(configuration);
        x.d("MicroMsg.ChattingUI.HeaderComponent", "getConfiguration().orientation = " + this.bAG.tTq.getMMResources().getConfiguration().orientation + ", newConfig.orientation = " + configuration.orientation);
        this.bAG.tTq.getMMResources().getConfiguration().orientation = configuration.orientation;
        ((m) this.bAG.O(m.class)).cvb().ul();
        if (this.tQi != null) {
            i = 1;
        } else {
            i = 0;
        }
        if (this.tQl == null) {
            i2 = 0;
        }
        if ((i & i2) != 0) {
            i2 = com.tencent.mm.compatible.util.a.i(this.bAG.tTq.getContext());
            this.tQl.setMinimumHeight(i2);
            LayoutParams layoutParams = this.tQl.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = new LayoutParams(-1, -1);
            }
            layoutParams.height = i2;
            this.tQl.setLayoutParams(layoutParams);
            layoutParams = this.tQi.getLayoutParams();
            layoutParams.height = i2;
            this.tQi.setLayoutParams(layoutParams);
        }
        if (this.tQj != null) {
            this.tQj.tnv.mActionBar.onConfigurationChanged(configuration);
        }
    }

    public final void a(com.tencent.mm.ui.chatting.c.a aVar) {
        super.a(aVar);
        if (isSupportCustomActionBar()) {
            this.tQj = new t();
            Object obj = this.tQj;
            e eVar = this.bAG.tTq;
            obj.tnu = eVar;
            obj.tnv = new com.tencent.mm.ui.b.b(eVar.thisActivity(), obj);
            this.bAG.tTq.setActivityController(this.tQj);
        }
    }

    public final void cpF() {
        cvo();
    }

    public final void cpG() {
        this.mZZ = this.bAG.tTq.getIntExtra("add_scene", 0);
        q.Kp().a(this.tQo);
        au.HU();
        com.tencent.mm.model.c.Ga().c(this.tOy);
        setBackBtn(this.tQp);
        csI();
        cvn();
        cvp();
        this.tOB = true;
    }

    public final void cpH() {
    }

    public final void cpI() {
        au.HU().Gt().a(new 5(this));
        au.HU().Gu().a(new 6(this));
        com.tencent.mm.model.b.b Gv = au.HU().Gv();
        com.tencent.mm.model.b.b.a aVar = this.tQn;
        synchronized (com.tencent.mm.model.b.b.class) {
            Gv.mListeners.add(aVar);
        }
        if (!this.tOB) {
            csI();
        }
        cvq();
        this.tOB = false;
    }

    public final void cpJ() {
        if (g.Eg().Dx()) {
            au.HU().Gt().a(null);
            au.HU().Gu().a(null);
            com.tencent.mm.model.b.b Gv = au.HU().Gv();
            com.tencent.mm.model.b.b.a aVar = this.tQn;
            synchronized (com.tencent.mm.model.b.b.class) {
                Gv.mListeners.remove(aVar);
            }
        }
    }

    public final void cpK() {
        q.Kp().b(this.tQo);
        au.HU();
        com.tencent.mm.model.c.Ga().d(this.tOy);
    }

    public final void cvm() {
        if (this.bAG.getHeaderViewsCount() > 0) {
            this.tQe = (LinearLayout) this.bAG.getListView().findViewById(R.h.list_header);
        } else {
            this.tQe = (LinearLayout) this.bAG.tTq.getContext().getLayoutInflater().inflate(R.i.chatting_list_header_container, null);
            com.tencent.mm.ui.chatting.c.a aVar = this.bAG;
            aVar.tTr.addHeaderView(this.tQe);
        }
        this.tQe.removeAllViews();
        cvq();
    }

    private void csI() {
        if (com.tencent.mm.model.s.hb(this.bAG.getTalkerUserName())) {
            com.tencent.mm.plugin.ab.a.bjk();
            this.bAG.tTq.addIconOptionMenu(0, R.l.actionbar_title_setting, R.k.actionbar_setting_icon, Boolean.valueOf(com.tencent.mm.ao.c.ig(com.tencent.mm.ao.b.ebo)).booleanValue(), this.tQm);
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void cvn() {
        /*
        r7 = this;
        r2 = 2;
        r5 = 1;
        r6 = 0;
        r0 = r7.bAG;
        r0 = r0.tTq;
        r1 = 0;
        r0.setMMSubTitle(r1);
        r0 = r7.bAG;
        r0 = r0.getTalkerUserName();
        r0 = com.tencent.mm.model.s.hb(r0);
        if (r0 == 0) goto L_0x0023;
    L_0x0017:
        r0 = r7.bAG;
        r0 = r0.oLT;
        r0 = r0.BK();
        r7.setMMTitle(r0);
    L_0x0022:
        return;
    L_0x0023:
        r0 = r7.bAG;
        r1 = com.tencent.mm.ui.chatting.b.b.w.class;
        r0 = r0.O(r1);
        r0 = (com.tencent.mm.ui.chatting.b.b.w) r0;
        r0 = r0.cvR();
        if (r0 == 0) goto L_0x0039;
    L_0x0033:
        r0 = com.tencent.mm.R.l.search_chat_content;
        r7.setMMTitle(r0);
        goto L_0x0022;
    L_0x0039:
        r0 = r7.bAG;
        r0 = r0.getTalkerUserName();
        r0 = com.tencent.mm.storage.ab.XO(r0);
        if (r0 == 0) goto L_0x0064;
    L_0x0045:
        r0 = r7.bAG;
        r1 = com.tencent.mm.ui.chatting.b.b.m.class;
        r0 = r0.O(r1);
        r0 = (com.tencent.mm.ui.chatting.b.b.m) r0;
        r0 = r0.cvb();
        r1 = 140; // 0x8c float:1.96E-43 double:6.9E-322;
        r0.setWordCountLimit(r1);
        r0 = r7.bAG;
        r0 = r0.oLT;
        r0 = r0.BL();
        r7.setMMTitle(r0);
        goto L_0x0022;
    L_0x0064:
        r0 = r7.bAG;
        r0 = r0.getTalkerUserName();
        r0 = com.tencent.mm.model.s.hL(r0);
        if (r0 == 0) goto L_0x007c;
    L_0x0070:
        r0 = r7.bAG;
        r0 = r0.oLT;
        r0 = r0.BK();
        r7.setMMTitle(r0);
        goto L_0x0022;
    L_0x007c:
        r0 = r7.bAG;
        r0 = r0.getTalkerUserName();
        r0 = com.tencent.mm.storage.ab.gY(r0);
        if (r0 == 0) goto L_0x00f4;
    L_0x0088:
        r0 = r7.bAG;
        r0 = r0.tTq;
        r1 = r0.getContext();
        r2 = com.tencent.mm.R.l.bottle_chatting_from_city;
        r3 = new java.lang.Object[r5];
        r0 = r7.bAG;
        r4 = r0.oLT;
        if (r4 == 0) goto L_0x00e5;
    L_0x009a:
        r0 = r4.getCountryCode();
        r0 = com.tencent.mm.storage.RegionCodeDecoder.Zh(r0);
        if (r0 == 0) goto L_0x00d7;
    L_0x00a4:
        r0 = r4.getCity();
        r5 = com.tencent.mm.sdk.platformtools.bi.oW(r0);
        if (r5 != 0) goto L_0x00bd;
    L_0x00ae:
        r3[r6] = r0;
        r0 = r1.getString(r2, r3);
        r0 = r0.trim();
        r7.setMMTitle(r0);
        goto L_0x0022;
    L_0x00bd:
        r0 = r4.getProvince();
        r0 = com.tencent.mm.model.r.gV(r0);
        r5 = com.tencent.mm.sdk.platformtools.bi.oW(r0);
        if (r5 == 0) goto L_0x00ae;
    L_0x00cb:
        com.tencent.mm.storage.RegionCodeDecoder.cmS();
        r0 = r4.getCountryCode();
        r0 = com.tencent.mm.storage.RegionCodeDecoder.getLocName(r0);
        goto L_0x00ae;
    L_0x00d7:
        r0 = r4.getProvince();
        r0 = com.tencent.mm.model.r.gV(r0);
        r4 = com.tencent.mm.sdk.platformtools.bi.oW(r0);
        if (r4 == 0) goto L_0x00ae;
    L_0x00e5:
        r0 = r7.bAG;
        r0 = r0.tTq;
        r0 = r0.getContext();
        r4 = com.tencent.mm.R.l.bottle_unknowed_city;
        r0 = r0.getString(r4);
        goto L_0x00ae;
    L_0x00f4:
        r0 = r7.bAG;
        r0 = r0.getTalkerUserName();
        r0 = com.tencent.mm.model.s.fq(r0);
        if (r0 == 0) goto L_0x018f;
    L_0x0100:
        r0 = r7.bAG;
        r0 = r0.oLT;
        r0 = r0.field_nickname;
        r0 = com.tencent.mm.sdk.platformtools.bi.oW(r0);
        if (r0 == 0) goto L_0x0160;
    L_0x010c:
        r0 = r7.bAG;
        r0 = r0.getTalkerUserName();
        r0 = com.tencent.mm.model.m.gK(r0);
        if (r0 != 0) goto L_0x012b;
    L_0x0118:
        r0 = r7.bAG;
        r0 = r0.tTq;
        r0 = r0.getContext();
        r1 = com.tencent.mm.R.l.chatting_roominfo_noname;
        r0 = r0.getString(r1);
        r7.setMMTitle(r0);
        goto L_0x0022;
    L_0x012b:
        r0 = r7.bAG;
        r0 = r0.tTq;
        r0 = r0.getContext();
        r1 = com.tencent.mm.R.l.fmt_chatting_title_group;
        r2 = new java.lang.Object[r2];
        r3 = r7.bAG;
        r3 = r3.tTq;
        r3 = r3.getContext();
        r4 = com.tencent.mm.R.l.chatting_roominfo_noname;
        r3 = r3.getString(r4);
        r2[r6] = r3;
        r3 = r7.bAG;
        r3 = r3.getTalkerUserName();
        r3 = com.tencent.mm.model.m.gK(r3);
        r3 = java.lang.Integer.valueOf(r3);
        r2[r5] = r3;
        r0 = r0.getString(r1, r2);
        r7.setMMTitle(r0);
        goto L_0x0022;
    L_0x0160:
        r0 = r7.bAG;
        r0 = r0.tTq;
        r0 = r0.getContext();
        r1 = com.tencent.mm.R.l.fmt_chatting_title_group;
        r2 = new java.lang.Object[r2];
        r3 = r7.bAG;
        r3 = r3.oLT;
        r3 = r3.BK();
        r2[r6] = r3;
        r3 = r7.bAG;
        r3 = r3.getTalkerUserName();
        r3 = com.tencent.mm.model.m.gK(r3);
        r3 = java.lang.Integer.valueOf(r3);
        r2[r5] = r3;
        r0 = r0.getString(r1, r2);
        r7.setMMTitle(r0);
        goto L_0x0022;
    L_0x018f:
        r0 = r7.bAG;
        r1 = com.tencent.mm.ui.chatting.b.b.c.class;
        r0 = r0.O(r1);
        r0 = (com.tencent.mm.ui.chatting.b.b.c) r0;
        r0 = r0.cut();
        if (r0 != 0) goto L_0x0022;
    L_0x019f:
        r0 = r7.tQk;
        r1 = r7.bAG;
        r1 = r1.getTalkerUserName();
        r1 = com.tencent.mm.storage.ab.XQ(r1);
        r0.lr(r1);
        r0 = r7.bAG;
        r0 = r0.tTq;
        r1 = r7.bAG;
        r1 = r1.oLT;
        r1 = r1.BL();
        r0.setMMTitle(r1);
        r0 = r7.tQk;
        r1 = r7.bAG;
        r1 = r1.getTalkerUserName();
        r1 = com.tencent.mm.storage.ab.XQ(r1);
        r0.lr(r1);
        r0 = r7.bAG;
        r0 = r0.getTalkerUserName();
        r0 = com.tencent.mm.storage.ab.XR(r0);
        if (r0 == 0) goto L_0x0022;
    L_0x01d8:
        r0 = r7.bAG;
        r1 = r0.tTq;
        r0 = com.tencent.mm.openim.a.b.class;
        r0 = com.tencent.mm.kernel.g.l(r0);
        r0 = (com.tencent.mm.openim.a.b) r0;
        r2 = r7.bAG;
        r2 = r2.oLT;
        r2 = r2.field_openImAppid;
        r3 = r7.bAG;
        r3 = r3.oLT;
        r3 = r3.field_descWordingId;
        r0 = r0.aE(r2, r3);
        r1.setMMSubTitle(r0);
        goto L_0x0022;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.ui.chatting.b.s.cvn():void");
    }

    public final void setMMTitle(int i) {
        setMMTitle(this.bAG.tTq.getMMResources().getString(i));
    }

    private boolean isSupportCustomActionBar() {
        return this.bAG.tTq.isSupportNavigationSwipeBack();
    }

    public final void dt(View view) {
        x.d("MicroMsg.ChattingUI.HeaderComponent", "dealContentView");
        if (isSupportCustomActionBar()) {
            if (this.tQi == null) {
                this.tQi = (ActionBarContainer) ((ViewStub) view.findViewById(R.h.chatting_custom_action_bar)).inflate();
            }
            this.tQj.tnv.CK = (ViewGroup) view;
        }
    }

    private View n(ViewGroup viewGroup) {
        if (this.tQl == null) {
            if (viewGroup == null) {
                this.tQl = y.gq(this.bAG.tTq.getContext()).inflate(R.i.actionbar_custom_area, null);
            } else {
                this.tQl = y.gq(this.bAG.tTq.getContext()).inflate(R.i.actionbar_custom_area, viewGroup, false);
            }
            return this.tQl;
        } else if (this.tQl.getParent() == null) {
            return this.tQl;
        } else {
            if (this.tQl.getParent() instanceof ViewGroup) {
                ((ViewGroup) this.tQl.getParent()).removeView(this.tQl);
                return this.tQl;
            }
            if (viewGroup == null) {
                this.tQl = y.gq(this.bAG.tTq.getContext()).inflate(R.i.actionbar_custom_area, null);
            } else {
                this.tQl = y.gq(this.bAG.tTq.getContext()).inflate(R.i.actionbar_custom_area, viewGroup, false);
            }
            return this.tQl;
        }
    }

    public final void cvo() {
        ActionBar actionBar;
        View n;
        if (this.bAG.tTq.isCurrentActivity || !isSupportCustomActionBar()) {
            ActionBar supportActionBar = ((ActionBarActivity) this.bAG.tTq.getContext()).getSupportActionBar();
            n = n(null);
            supportActionBar.setCustomView(n);
            this.tQk = new b(n);
            actionBar = supportActionBar;
        } else {
            ViewGroup viewGroup = (ViewGroup) this.tQi.findViewById(R.h.action_bar);
            x.i("MicroMsg.ChattingUI.HeaderComponent", "mActionBarContainer %s", this.tQi);
            n = this.tQi.findViewById(R.h.action_context_bar);
            x.i("MicroMsg.ChattingUI.HeaderComponent", "ctxView %s", n);
            viewGroup.setVisibility(0);
            ActionBar supportActionBar2 = this.tQj.getSupportActionBar();
            View n2 = n(viewGroup);
            supportActionBar2.setCustomView(n2);
            this.tQk = new b(n2);
            int height = supportActionBar2.getHeight();
            if (height == 0) {
                DisplayMetrics displayMetrics = this.bAG.tTq.getMMResources().getDisplayMetrics();
                if (displayMetrics.widthPixels > displayMetrics.heightPixels) {
                    height = this.bAG.tTq.getMMResources().getDimensionPixelSize(R.f.DefaultActionbarHeightLand);
                } else {
                    height = this.bAG.tTq.getMMResources().getDimensionPixelSize(R.f.DefaultActionbarHeightPort);
                }
            }
            n2.setMinimumHeight(height);
            LayoutParams layoutParams = n2.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = new LayoutParams(-1, -1);
            }
            layoutParams.height = height;
            n2.setLayoutParams(layoutParams);
            actionBar = supportActionBar2;
        }
        boolean z = ad.getContext().getSharedPreferences(ad.chY() + "_redesign", 4).getBoolean("dark_actionbar", false);
        if (actionBar.getCustomView() != null) {
            ImageView imageView = (ImageView) actionBar.getCustomView().findViewById(R.h.arrow_area_btn);
            if (imageView != null && z) {
                if (imageView.getDrawable() != null) {
                    imageView.getDrawable().setColorFilter(-1, Mode.SRC_ATOP);
                } else {
                    imageView.setColorFilter(-1, Mode.SRC_ATOP);
                }
            }
            TextView textView = (TextView) actionBar.getCustomView().findViewById(R.h.title_area);
            if (textView != null && z) {
                textView.setTextColor(this.bAG.tTq.getMMResources().getColor(R.e.white_text_color));
            }
            textView = (TextView) actionBar.getCustomView().findViewById(R.h.sub_title_area);
            if (textView != null && z) {
                textView.setTextColor(this.bAG.tTq.getMMResources().getColor(R.e.white_text_color));
            }
            imageView = (ImageView) actionBar.getCustomView().findViewById(R.h.mute_icon);
            if (imageView != null && z) {
                if (imageView.getDrawable() != null) {
                    imageView.getDrawable().setColorFilter(-1, Mode.SRC_ATOP);
                } else {
                    imageView.setColorFilter(-1, Mode.SRC_ATOP);
                }
            }
            imageView = (ImageView) actionBar.getCustomView().findViewById(R.h.phone_icon);
            if (imageView != null && z) {
                if (imageView.getDrawable() != null) {
                    imageView.getDrawable().setColorFilter(-1, Mode.SRC_ATOP);
                } else {
                    imageView.setColorFilter(-1, Mode.SRC_ATOP);
                }
            }
        }
        this.tQk.lr(false);
        actionBar.setDisplayOptions((((actionBar.getDisplayOptions() | 16) & -5) & -3) & -9);
        this.tQg.clear();
        this.tQg.add(this.bAG.tTq.getStringExtra("Chat_User"));
        setBackBtn(this.tQp);
    }

    public final void cvp() {
        w wVar = (w) this.bAG.O(w.class);
        if (wVar.cvR() || wVar.cvQ()) {
            this.bAG.showOptionMenu(false);
        } else if (((l) this.bAG.O(l.class)).cva()) {
            this.bAG.showOptionMenu(false);
        } else {
            this.bAG.tTq.removeAllOptionMenu();
            if (com.tencent.mm.model.s.hb(this.bAG.getTalkerUserName())) {
                com.tencent.mm.plugin.ab.a.bjk();
                this.bAG.tTq.addIconOptionMenu(0, R.l.actionbar_title_setting, R.k.actionbar_setting_icon, Boolean.valueOf(com.tencent.mm.ao.c.ig(com.tencent.mm.ao.b.ebo)).booleanValue(), this.tQm);
            } else if (com.tencent.mm.model.s.hi(this.bAG.getTalkerUserName())) {
                this.bAG.tTq.addIconOptionMenu(0, R.l.actionbar_title_setting, R.k.actionbar_setting_icon, this.tQm);
                h.mEJ.k(10071, "1");
            } else if (com.tencent.mm.model.s.hj(this.bAG.getTalkerUserName())) {
                this.bAG.tTq.addIconOptionMenu(0, R.l.actionbar_title_setting, R.k.actionbar_setting_icon, this.tQm);
            } else if (com.tencent.mm.model.s.hJ(this.bAG.getTalkerUserName())) {
                this.bAG.tTq.addIconOptionMenu(0, R.l.actionbar_title_setting, R.k.actionbar_setting_icon, this.tQm);
            } else if (com.tencent.mm.model.s.hO(this.bAG.getTalkerUserName())) {
                if (com.tencent.mm.model.s.hu(this.bAG.getTalkerUserName())) {
                    this.bAG.showOptionMenu(false);
                    return;
                }
                this.bAG.tTq.addIconOptionMenu(0, R.l.actionbar_title_setting, R.k.actionbar_setting_icon, this.tQm);
            } else if (ab.XO(this.bAG.getTalkerUserName()) || ab.XQ(this.bAG.getTalkerUserName()) || ab.gY(this.bAG.getTalkerUserName())) {
                this.bAG.tTq.addIconOptionMenu(0, R.l.chatting_profile_desc, R.k.actionbar_icon_dark_more, this.tQm);
            } else if (((com.tencent.mm.ui.chatting.b.b.s) this.bAG.O(com.tencent.mm.ui.chatting.b.b.s.class)).cvJ() && i.aan(this.bAG.getTalkerUserName())) {
                this.bAG.tTq.addIconOptionMenu(0, R.l.chatting_profile_desc, R.k.ofm_add_icon, this.tQm);
            } else {
                com.tencent.mm.ui.chatting.b.b.c cVar = (com.tencent.mm.ui.chatting.b.b.c) this.bAG.O(com.tencent.mm.ui.chatting.b.b.c.class);
                if (!this.bAG.getTalkerUserName().endsWith("@chatroom") && !cVar.cur()) {
                    if (!(!(1 == bi.getInt(com.tencent.mm.k.g.AT().getValue("VOIPShowInChat"), 0)) || com.tencent.mm.model.s.hf(this.bAG.getTalkerUserName()) || this.bAG.getTalkerUserName().endsWith("@chatroom") || ab.XO(this.bAG.getTalkerUserName()) || ab.XQ(this.bAG.getTalkerUserName()) || ab.gY(this.bAG.getTalkerUserName()))) {
                        if (1 == bi.getInt(com.tencent.mm.k.g.AT().getValue("VOIPCallType"), 0)) {
                            this.bAG.tTq.addIconOptionMenu(2, R.l.chatting_voip_video, R.k.actionbar_voip_video_icon, this.tQs);
                        } else {
                            this.bAG.tTq.addIconOptionMenu(1, R.l.chatting_voip_voice, R.k.actionbar_voip_voice_icon, this.tQs);
                        }
                    }
                    if (com.tencent.mm.model.s.hf(this.bAG.getTalkerUserName())) {
                        this.bAG.tTq.addIconOptionMenu(0, R.l.chatting_profile_desc, R.k.actionbar_particular_icon, this.tQm);
                    } else {
                        this.bAG.tTq.addIconOptionMenu(0, R.l.chatting_profile_desc, R.k.actionbar_icon_dark_more, this.tQm);
                    }
                } else if (((com.tencent.mm.ui.chatting.b.b.e) this.bAG.O(com.tencent.mm.ui.chatting.b.b.e.class)).cuI()) {
                    x.i("MicroMsg.ChattingUI.HeaderComponent", "cpan show chatroom right btn");
                    this.bAG.tTq.addIconOptionMenu(0, R.l.chatting_profile_desc, R.k.actionbar_icon_dark_more, this.tQm);
                    this.bAG.showOptionMenu(true);
                } else if (!cVar.cur() || cVar.cus()) {
                    this.bAG.showOptionMenu(false);
                    return;
                } else {
                    this.bAG.tTq.addIconOptionMenu(0, R.l.chatting_profile_desc, R.k.actionbar_particular_icon, this.tQm);
                    this.bAG.showOptionMenu(true);
                }
            }
            if (ab.gY(this.bAG.getTalkerUserName())) {
                this.bAG.lZ(true);
            } else {
                this.bAG.showOptionMenu(true);
            }
        }
    }

    public final void cvq() {
        if (this.bAG == null) {
            x.e("MicroMsg.ChattingUI.HeaderComponent", "[updateBannerStatus] mChattingContext == null!");
            return;
        }
        if (this.bAG.cwr()) {
            String talkerUserName = this.bAG.getTalkerUserName();
            au.HU();
            u ih = com.tencent.mm.model.c.Ga().ih(talkerUserName);
            if (ih != null && ih.Nn().size() == 2) {
                int size = ih.Nn().size();
                for (int i = 0; i < size; i++) {
                    talkerUserName = (String) ih.Nn().get(i);
                    if (i.aan(talkerUserName)) {
                        break;
                    }
                }
            }
            talkerUserName = null;
            this.tQh = talkerUserName;
            if (bi.oW(this.tQh) || !(((com.tencent.mm.ui.chatting.b.b.e) this.bAG.O(com.tencent.mm.ui.chatting.b.b.e.class)).cuI() || ((com.tencent.mm.ui.chatting.b.b.c) this.bAG.O(com.tencent.mm.ui.chatting.b.b.c.class)).cux())) {
                cvu();
            } else {
                cvs();
            }
        } else if (i.aan(this.bAG.getTalkerUserName()) && !((com.tencent.mm.ui.chatting.b.b.s) this.bAG.O(com.tencent.mm.ui.chatting.b.b.s.class)).cvJ()) {
            this.tQh = this.bAG.getTalkerUserName();
            cvs();
        } else if (!((com.tencent.mm.ui.chatting.b.b.q) this.bAG.O(com.tencent.mm.ui.chatting.b.b.q.class)).cvE()) {
            cvu();
            cvt();
        }
        cvv();
        cvr();
    }

    private void cvr() {
        if (this.bAG.tTq.getContext() == null) {
            x.w("MicroMsg.ChattingUI.HeaderComponent", "getActivity is null");
            return;
        }
        cvx();
        ViewGroup viewGroup = (ViewGroup) this.bAG.tTq.getContext().findViewById(R.h.chatting_banner_content);
        com.tencent.mm.pluginsdk.ui.b.a a = com.tencent.mm.ui.conversation.a.e.a(this.bAG.tTq.getContext(), com.tencent.mm.ui.conversation.a.e.a.usb, new Object[]{com.tencent.mm.model.b.b.b.dDZ});
        if (viewGroup != null && a != null && a.getView() != null && this.tQu == null) {
            this.tQu = a.getView();
            viewGroup.addView(this.tQu, new LayoutParams(-1, -2));
        }
    }

    @SuppressLint({"ResourceType"})
    public final void cvs() {
        cvu();
        if (this.tQf == null) {
            i.a(this.bAG.tTq, R.h.viewstub_fixheader);
            this.tQf = (LinearLayout) this.bAG.tTq.getContext().findViewById(R.h.fixed_header);
        }
        this.tQf.setVisibility(0);
        LinearLayout linearLayout = (LinearLayout) this.bAG.tTq.getContext().getLayoutInflater().inflate(R.i.chatting_list_header, null);
        ImageView imageView = (ImageView) linearLayout.findViewById(R.h.add_friends_avatar);
        String str = this.tQh;
        if (bi.oW(str)) {
            str = this.bAG.oLT.field_username;
        }
        Bitmap a = com.tencent.mm.aa.c.a(str, false, -1);
        if (a == null) {
            imageView.setImageResource(R.k.default_avatar);
        } else {
            imageView.setImageBitmap(a);
        }
        Button button = (Button) linearLayout.findViewById(R.h.chatting_addcontact_btn);
        if (((com.tencent.mm.ui.chatting.b.b.q) this.bAG.O(com.tencent.mm.ui.chatting.b.b.q.class)).cvD()) {
            ((com.tencent.mm.ui.chatting.b.b.q) this.bAG.O(com.tencent.mm.ui.chatting.b.b.q.class)).a(button, linearLayout, this.tQf);
        }
        imageView.setOnClickListener(new 9(this));
        button.setOnClickListener(new 10(this, linearLayout));
        h.mEJ.h(11004, this.tQh, Integer.valueOf(1));
        this.tQf.addView(linearLayout, new LayoutParams(-1, -2));
    }

    private void cvt() {
        if (!this.bAG.cwr() && this.tQe != null) {
            cvu();
            com.tencent.mm.pluginsdk.ui.b.a a = com.tencent.mm.ui.conversation.a.e.a(this.bAG.tTq.getContext(), com.tencent.mm.ui.conversation.a.e.a.urS, new Object[]{this.bAG.getTalkerUserName(), this.bAG.cuz()});
            if (!(a == null || a.getView() == null)) {
                this.tQe.addView(a.getView(), new LayoutParams(-1, -2));
                this.tQe.setVisibility(0);
            }
            h.mEJ.h(11003, this.bAG.getTalkerUserName(), Integer.valueOf(1), Integer.valueOf(0));
        }
    }

    private void cvu() {
        if (this.tQe != null) {
            this.tQe.removeAllViews();
        }
        if (this.tQf != null) {
            this.tQf.setVisibility(8);
            this.tQf.removeAllViews();
        }
    }

    private void cvv() {
        if (this.bAG.tTq.getContext() == null) {
            x.w("MicroMsg.ChattingUI.HeaderComponent", "getActivity is null");
            return;
        }
        cvw();
        ViewGroup viewGroup = (ViewGroup) this.bAG.tTq.getContext().findViewById(R.h.chatting_content);
        com.tencent.mm.pluginsdk.ui.b.a a = com.tencent.mm.ui.conversation.a.e.a(this.bAG.tTq.getContext(), com.tencent.mm.ui.conversation.a.e.a.urT, new Object[]{this.bAG.getTalkerUserName(), this.bAG.cuz(), Boolean.valueOf(this.bAG.cwr())});
        if (viewGroup != null && a != null && a.getView() != null && this.tQt == null) {
            this.tQt = a.getView();
            viewGroup.addView(this.tQt, new LayoutParams(-1, -2));
        }
    }

    private void cvw() {
        ViewGroup viewGroup = (ViewGroup) this.bAG.tTq.getContext().findViewById(R.h.chatting_content);
        if (viewGroup != null && this.tQt != null) {
            viewGroup.removeView(this.tQt);
            this.tQt = null;
        }
    }

    private void cvx() {
        ViewGroup viewGroup = (ViewGroup) this.bAG.tTq.getContext().findViewById(R.h.chatting_banner_content);
        if (viewGroup != null && this.tQu != null) {
            viewGroup.removeView(this.tQu);
            this.tQu = null;
        }
    }

    public final int cvy() {
        if (this.tQe == null || !this.tQe.isShown()) {
            return 0;
        }
        return this.tQe.getHeight() + 0;
    }

    public final void setMMTitle(String str) {
        CharSequence d;
        if (ab.XR(this.bAG.oLT.field_username)) {
            com.tencent.mm.openim.a.b bVar = (com.tencent.mm.openim.a.b) g.l(com.tencent.mm.openim.a.b.class);
            Context context = ad.getContext();
            String str2 = this.bAG.oLT.field_openImAppid;
            d = bVar.d(context, str, com.tencent.mm.bp.a.ad(ad.getContext(), R.f.BigTextSize));
        } else {
            d = com.tencent.mm.pluginsdk.ui.d.j.a(this.bAG.tTq.getContext(), (CharSequence) str, com.tencent.mm.bp.a.ad(this.bAG.tTq.getContext(), R.f.BigTextSize));
        }
        this.tQk.setTitle(d);
        this.bAG.tTq.updateDescription(this.bAG.tTq.getContext().getString(R.l.chatting_back_talker_desc, new Object[]{d}));
    }

    public final void setMMSubTitle(String str) {
        x.i("MicroMsg.ChattingUI.HeaderComponent", "now connect state, text : %s", str);
        CharSequence a = com.tencent.mm.pluginsdk.ui.d.j.a(this.bAG.tTq.getContext(), (CharSequence) str, com.tencent.mm.bp.a.ad(this.bAG.tTq.getContext(), R.f.HintTextSize));
        b bVar = this.tQk;
        if (a == null || bi.oW(a.toString())) {
            bVar.tfV.setVisibility(8);
            return;
        }
        bVar.tfV.setVisibility(0);
        bVar.tfV.setText(a);
        if (com.tencent.mm.bp.a.fi(bVar.tfV.getContext())) {
            bVar.tfV.setTextSize(1, 14.0f);
            bVar.eCm.setTextSize(1, 18.0f);
        }
    }

    public final void setBackBtn(OnMenuItemClickListener onMenuItemClickListener) {
        this.tQk.b(new 2(this, onMenuItemClickListener));
    }

    public final void setTitlePhoneIconVisibility(int i) {
        int i2;
        int i3 = 0;
        b bVar = this.tQk;
        if (i == 0) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        ImageView imageView = bVar.tfX;
        if (i2 == 0) {
            i3 = 8;
        }
        imageView.setVisibility(i3);
    }

    public final void setTitleMuteIconVisibility(int i) {
        boolean z = false;
        if (com.tencent.mm.model.s.hJ(this.bAG.getTalkerUserName())) {
            this.tQk.lq(false);
            return;
        }
        b bVar = this.tQk;
        if (i == 0) {
            z = true;
        }
        bVar.lq(z);
    }

    public final void Fa(int i) {
        int i2;
        int i3 = 0;
        b bVar = this.tQk;
        if (i == 0) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        ImageView imageView = bVar.tfZ;
        if (i2 == 0) {
            i3 = 8;
        }
        imageView.setVisibility(i3);
    }

    public final t csU() {
        return this.tQj;
    }
}
