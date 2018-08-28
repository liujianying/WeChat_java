package com.tencent.mm.ui;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.ak.o;
import com.tencent.mm.ak.p;
import com.tencent.mm.ax.e;
import com.tencent.mm.bg.d;
import com.tencent.mm.g.a.gp;
import com.tencent.mm.g.a.gq;
import com.tencent.mm.g.a.he;
import com.tencent.mm.g.a.hs;
import com.tencent.mm.g.a.in;
import com.tencent.mm.g.a.iq;
import com.tencent.mm.g.a.iv;
import com.tencent.mm.g.a.kx;
import com.tencent.mm.g.a.me;
import com.tencent.mm.g.a.nh;
import com.tencent.mm.g.a.nj;
import com.tencent.mm.g.a.os;
import com.tencent.mm.g.a.ou;
import com.tencent.mm.g.a.ph;
import com.tencent.mm.g.a.pk;
import com.tencent.mm.g.a.rb;
import com.tencent.mm.g.a.sa;
import com.tencent.mm.g.a.tt;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ap;
import com.tencent.mm.model.aq;
import com.tencent.mm.model.au;
import com.tencent.mm.model.bl;
import com.tencent.mm.model.k;
import com.tencent.mm.model.q;
import com.tencent.mm.plugin.account.bind.ui.BindMContactIntroUI;
import com.tencent.mm.plugin.account.bind.ui.MobileFriendUI;
import com.tencent.mm.plugin.account.friend.a.l;
import com.tencent.mm.plugin.account.ui.FacebookFriendUI;
import com.tencent.mm.plugin.appbrand.s$l;
import com.tencent.mm.plugin.sns.b.m;
import com.tencent.mm.plugin.sns.b.n;
import com.tencent.mm.plugin.websearch.api.ac;
import com.tencent.mm.plugin.websearch.api.ad;
import com.tencent.mm.plugin.websearch.api.r;
import com.tencent.mm.pluginsdk.f.f;
import com.tencent.mm.pluginsdk.f.f$a;
import com.tencent.mm.pluginsdk.o$a;
import com.tencent.mm.pluginsdk.wallet.i;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.e.j.a;
import com.tencent.mm.sdk.e.m.b;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.aa;
import com.tencent.mm.ui.base.preference.IconPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.PreferenceSmallCategory;
import com.tencent.mm.ui.base.s;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class h extends a implements ap, aq, a, b {
    private boolean bQt = false;
    private long hXx;
    private c<tt> jxo = new 4(this);
    private CheckBox lBF;
    private com.tencent.mm.ui.widget.a.c lBH = null;
    private ag mHandler = new 1(this, Looper.getMainLooper());
    private int mSF;
    c nqB = new c<rb>() {
        {
            this.sFo = rb.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            x.i("MicroMsg.FindMoreFriendsUI", "mark sns read %d", new Object[]{Integer.valueOf(((rb) bVar).cbQ.bNI)});
            if (((rb) bVar).cbQ.bNI == 9) {
                new ag(Looper.getMainLooper()).post(new 1(this));
            }
            return true;
        }
    };
    private com.tencent.mm.pluginsdk.c.a qOz = new com.tencent.mm.pluginsdk.c.a() {
        public final void j(com.tencent.mm.sdk.b.b bVar) {
            x.d("MicroMsg.FindMoreFriendsUI", "onMStorageNotifyEvent, %s ", new Object[]{bVar});
            if (bVar instanceof iq) {
                h.this.cpp();
            }
        }
    };
    private int status;
    c tiA = new 20(this);
    private com.tencent.mm.pluginsdk.c.a tiB = new 21(this);
    private com.tencent.mm.pluginsdk.c.a tiC = new 22(this);
    private c tiD = new 23(this);
    private c<he> tiE = new 5(this);
    p.a tiF = new 7(this);
    private com.tencent.mm.ui.base.preference.h tig;
    private View tih;
    private boolean tii = false;
    private String tij = "";
    private int tik = 0;
    private String til = null;
    private String tim = null;
    private String tin = null;
    private String tio = null;
    private String tiq = null;
    private boolean tir = false;
    private boolean tis = false;
    private boolean tit = false;
    private boolean tiu = true;
    private int tiv;
    private View tiw;
    private TextView tix;
    private c<os> tiy = new 12(this);
    c tiz = new c<in>() {
        {
            this.sFo = in.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            if (f.qBo != null) {
                com.tencent.mm.plugin.report.service.h.mEJ.h(11178, new Object[]{bi.oV(r0.bGp()), r0.bGq().bGb(), Integer.valueOf(h.cpk())});
            }
            h.this.lw(true);
            h.this.tig.notifyDataSetChanged();
            return true;
        }
    };

    static /* synthetic */ void f(h hVar) {
        hVar.cpm();
        hVar.tig.notifyDataSetChanged();
    }

    public final int Ys() {
        return R.o.find_more_friends;
    }

    public boolean supportNavigationSwipeBack() {
        return false;
    }

    public boolean noActionBar() {
        return true;
    }

    private void cpj() {
        Object obj = null;
        x.i("MicroMsg.FindMoreFriendsUI", "checkLookVisibility");
        if (this.tDd && isAdded()) {
            try {
                Object obj2;
                Object obj3;
                JSONObject PX = r.PX("discoverRecommendEntry");
                if (((com.tencent.mm.plugin.welab.a.a.a) g.l(com.tencent.mm.plugin.welab.a.a.a.class)).RZ("labs_browse")) {
                    Object obj4;
                    if (!((com.tencent.mm.plugin.welab.a.a.a) g.l(com.tencent.mm.plugin.welab.a.a.a.class)).RX("labs_browse")) {
                        x.i("MicroMsg.FindMoreFriendsUI", "checkLookVisibility in experiment but not open");
                        obj4 = null;
                    } else if (((com.tencent.mm.plugin.welab.a.a.a) g.l(com.tencent.mm.plugin.welab.a.a.a.class)).RY("labs_browse")) {
                        obj2 = 1;
                        obj3 = 1;
                    } else {
                        int obj42 = 1;
                    }
                    obj2 = null;
                    obj3 = obj42;
                } else {
                    x.i("MicroMsg.FindMoreFriendsUI", "checkLookVisibility not in experiment");
                    obj2 = null;
                    obj3 = null;
                }
                if (com.tencent.mm.al.b.ml((String) g.Ei().DT().get(274436, null))) {
                    x.i("MicroMsg.FindMoreFriendsUI", "checkLookVisibility EuropeanUnionCountry");
                } else {
                    obj = obj3;
                }
                if (obj != null) {
                    CharSequence optString = PX.optString("wording");
                    String optString2 = PX.optString("androidIcon");
                    IconPreference iconPreference = (IconPreference) this.tig.ZZ("find_friends_by_look");
                    if (bi.oW(optString)) {
                        iconPreference.setTitle(getString(R.l.find_friends_look));
                    } else {
                        iconPreference.setTitle(optString);
                    }
                    if (bi.oW(optString2)) {
                        iconPreference.drawable = com.tencent.mm.bp.a.f(getContext(), R.k.find_more_friend_look);
                        this.tim = null;
                    } else {
                        o.Pe();
                        Bitmap jz = com.tencent.mm.ak.c.jz(optString2);
                        if (jz != null) {
                            iconPreference.drawable = new BitmapDrawable(getContext().getResources(), jz);
                            this.tim = null;
                        } else {
                            x.i("MicroMsg.FindMoreFriendsUI", "load look icon from disk and net %s ", new Object[]{optString2});
                            iconPreference.drawable = com.tencent.mm.bp.a.f(getContext(), R.k.find_more_friend_look);
                            o.Pi().a(optString2, this.tiF);
                            this.tim = optString2;
                        }
                    }
                    this.tiv++;
                    this.tig.bw("find_friends_by_look", false);
                    if (obj2 != null) {
                        iconPreference.Er(0);
                        iconPreference.dk(getString(R.l.app_new), R.g.new_tips_bg);
                    } else {
                        iconPreference.Er(8);
                        ah.A(new 2(this, iconPreference));
                    }
                    com.tencent.mm.plugin.websearch.api.p.bSP();
                    return;
                }
                this.tig.bw("find_friends_by_look", true);
                return;
            } catch (Throwable e) {
                x.e("MicroMsg.FindMoreFriendsUI", bi.i(e));
                return;
            }
        }
        x.i("MicroMsg.FindMoreFriendsUI", "checkLookVisibility preference not add");
    }

    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        x.i("MicroMsg.FindMoreFriendsUI", "onActivityCreated");
    }

    private void anw() {
        this.tiv = 0;
        if (this.tiw != null) {
            this.tiw.setVisibility(8);
        }
        if (this.tDd && isAdded()) {
            boolean z;
            String optString;
            IconPreference iconPreference;
            cpn();
            boolean vO = vO(1048576);
            boolean QS = d.QS("scanner");
            String str = "MicroMsg.FindMoreFriendsUI";
            String str2 = "openScan %s, plugin installed %s";
            Object[] objArr = new Object[2];
            objArr[0] = Boolean.valueOf(!vO);
            objArr[1] = Boolean.valueOf(QS);
            x.i(str, str2, objArr);
            if (vO || !QS) {
                this.tig.bw("find_friends_by_qrcode", true);
            } else {
                this.tig.bw("find_friends_by_qrcode", false);
                this.tiv++;
            }
            cpo();
            vO = vO(2097152);
            QS = d.QS("search");
            str = "MicroMsg.FindMoreFriendsUI";
            str2 = "openSearch %s, plugin installed %s";
            objArr = new Object[2];
            if (vO) {
                z = false;
            } else {
                z = true;
            }
            objArr[0] = Boolean.valueOf(z);
            objArr[1] = Boolean.valueOf(QS);
            x.i(str, str2, objArr);
            if (vO || !QS) {
                this.tig.bw("find_friends_by_search", true);
            } else {
                this.tiv++;
                this.tig.bw("find_friends_by_search", false);
                try {
                    JSONObject PX = r.PX("discoverSearchEntry");
                    CharSequence optString2 = PX.optString("wording");
                    optString = PX.optString("androidIcon");
                    iconPreference = (IconPreference) this.tig.ZZ("find_friends_by_search");
                    if (bi.oW(optString2)) {
                        iconPreference.setTitle(getString(R.l.find_friends_search));
                    } else {
                        iconPreference.setTitle(optString2);
                    }
                    if (bi.oW(optString)) {
                        iconPreference.drawable = com.tencent.mm.bp.a.f(getContext(), R.k.find_more_friend_search);
                        this.tin = null;
                    } else {
                        o.Pe();
                        Bitmap jz = com.tencent.mm.ak.c.jz(optString);
                        if (jz != null) {
                            iconPreference.drawable = new BitmapDrawable(getContext().getResources(), jz);
                            this.tin = null;
                        } else {
                            x.i("MicroMsg.FindMoreFriendsUI", "load search icon from disk and net %s ", new Object[]{optString});
                            iconPreference.drawable = com.tencent.mm.bp.a.f(getContext(), R.k.find_more_friend_search);
                            o.Pi().a(optString, this.tiF);
                            this.tin = optString;
                        }
                    }
                    iconPreference.Er(8);
                    ah.A(new 3(this, iconPreference, ac.bTg().pMk));
                    com.tencent.mm.plugin.websearch.api.p.bSR();
                } catch (Throwable e) {
                    x.printErrStackTrace("MicroMsg.FindMoreFriendsUI", e, "update search entry exception!", new Object[0]);
                }
            }
            cpp();
            if ((this.mSF & 64) == 0) {
                z = true;
            } else {
                z = false;
            }
            x.i("MicroMsg.FindMoreFriendsUI", "openBottle %s, plugin installed %s", new Object[]{Boolean.valueOf(z), Boolean.valueOf(d.QS("bottle"))});
            if (z && r1) {
                this.tiv++;
                this.tig.bw("voice_bottle", false);
                iconPreference = (IconPreference) this.tig.ZZ("voice_bottle");
                if (iconPreference != null) {
                    int GB = k.GB();
                    if (GB > 0) {
                        iconPreference.dk(String.valueOf(GB), com.tencent.mm.ui.tools.r.hd(getContext()));
                    }
                    if (GB <= 0 || (this.status & 32768) != 0) {
                        iconPreference.Er(8);
                    } else {
                        iconPreference.Er(0);
                    }
                }
            } else {
                this.tig.bw("voice_bottle", true);
            }
            vO = vO(4194304);
            optString = "MicroMsg.FindMoreFriendsUI";
            str = "openShoppingEntry %s";
            Object[] objArr2 = new Object[1];
            if (vO) {
                z = false;
            } else {
                z = true;
            }
            objArr2[0] = Boolean.valueOf(z);
            x.i(optString, str, objArr2);
            if (vO) {
                this.tig.bw("jd_market_entrance", true);
            } else {
                lw(false);
            }
            com.tencent.mm.plugin.game.a.a aSm = com.tencent.mm.plugin.game.a.a.a.aSm();
            if (aSm != null) {
                getContext();
                z = aSm.aSd();
            } else {
                z = false;
            }
            QS = vO(8388608);
            str = "MicroMsg.FindMoreFriendsUI";
            str2 = "shouldShowGame %s, openGameEntry %s";
            objArr = new Object[2];
            objArr[0] = Boolean.valueOf(z);
            if (QS) {
                vO = false;
            } else {
                vO = true;
            }
            objArr[1] = Boolean.valueOf(vO);
            x.i(str, str2, objArr);
            if (!z || QS) {
                this.tig.bw("more_tab_game_recommend", true);
            } else {
                this.tig.bw("more_tab_game_recommend", false);
                cpm();
                this.tiv++;
            }
            pk pkVar = new pk();
            pkVar.cah.caj = true;
            com.tencent.mm.sdk.b.a.sFg.m(pkVar);
            vO = pkVar.cai.cak;
            boolean vO2 = vO(16777216);
            str2 = "MicroMsg.FindMoreFriendsUI";
            String str3 = "shouldShowMiniProgram %s, openMiniProgramEntry %s";
            Object[] objArr3 = new Object[2];
            objArr3[0] = Boolean.valueOf(vO);
            if (vO2) {
                z = false;
            } else {
                z = true;
            }
            objArr3[1] = Boolean.valueOf(z);
            x.i(str2, str3, objArr3);
            if (!vO || vO2) {
                this.tig.bw("app_brand_entrance", true);
            } else {
                this.tiv++;
                this.tig.bw("app_brand_entrance", false);
                iconPreference = (IconPreference) this.tig.ZZ("app_brand_entrance");
                iconPreference.Er(pkVar.cai.cam ? 0 : 8);
                iconPreference.dk(getString(R.l.app_new), R.g.new_tips_bg);
                iconPreference.Et(pkVar.cai.cal ? 0 : 8);
            }
            vO = com.tencent.mm.plugin.ipcall.d.aWV();
            QS = vO(33554432);
            str = "MicroMsg.FindMoreFriendsUI";
            str2 = "showShowWeChatOut %s, openWeChatOutEntry %s";
            objArr = new Object[2];
            objArr[0] = Boolean.valueOf(vO);
            if (QS) {
                z = false;
            } else {
                z = true;
            }
            objArr[1] = Boolean.valueOf(z);
            x.i(str, str2, objArr);
            if (!vO || QS) {
                this.tig.bw("ip_call_entrance", true);
            } else {
                this.tiv++;
                this.tig.bw("ip_call_entrance", false);
                iconPreference = (IconPreference) this.tig.ZZ("ip_call_entrance");
                au.HU();
                if (((Integer) com.tencent.mm.model.c.DT().get(aa.a.sRg, Integer.valueOf(0))).intValue() < com.tencent.mm.k.g.AT().getInt("WCOEntranceRedDot", 0)) {
                    iconPreference.Er(0);
                    iconPreference.dk(getString(R.l.app_new), R.g.new_tips_bg);
                } else {
                    iconPreference.Er(8);
                }
                iconPreference.Ew(8);
                au.HU();
                if (((Boolean) com.tencent.mm.model.c.DT().get(aa.a.sRi, Boolean.valueOf(false))).booleanValue()) {
                    iconPreference.lN(true);
                    iconPreference.Er(8);
                    QS = true;
                } else {
                    iconPreference.lN(false);
                    QS = false;
                }
                au.HU();
                String str4 = (String) com.tencent.mm.model.c.DT().get(aa.a.sRh, "");
                iconPreference.ao(str4, -1, -7566196);
                if (!bi.oW(str4)) {
                    QS = true;
                }
                if (QS) {
                    iconPreference.Es(0);
                } else {
                    iconPreference.Es(8);
                }
                this.tig.a(new PreferenceSmallCategory(getContext()), -1);
            }
            cpj();
            this.tig.bw("find_friends_by_facebook", true);
            this.tig.bw("settings_emoji_store", true);
            if (this.tiv == 0) {
                ViewGroup viewGroup = (ViewGroup) findViewById(16908298).getParent();
                if (this.tiw == null) {
                    this.tiw = getContext().getLayoutInflater().inflate(R.i.findmore_ui_empty_jump_view, null);
                    this.tix = (TextView) this.tiw.findViewById(R.h.goto_manage_findmoreui);
                    this.tix.setOnClickListener(new 6(this));
                    viewGroup.addView(this.tiw, new LayoutParams(-1, -1));
                } else {
                    this.tiw.setVisibility(0);
                }
            }
            this.tig.notifyDataSetChanged();
        }
    }

    private void lw(boolean z) {
        String value;
        if (w.chM()) {
            value = com.tencent.mm.k.g.AT().getValue("JDEntranceConfigName");
        } else if (w.chN()) {
            value = com.tencent.mm.k.g.AT().getValue("JDEntranceConfigNameHKTW");
        } else {
            value = com.tencent.mm.k.g.AT().getValue("JDEntranceConfigNameEN");
        }
        String value2 = com.tencent.mm.k.g.AT().getValue("JDEntranceConfigIconUrl");
        f.b bVar = f.qBo;
        boolean z2 = true;
        if (bVar != null) {
            String bGp = bVar.bGp();
            if (!(bi.oW(value) || bi.oW(value2) || bi.oW(bGp))) {
                Object obj;
                CharSequence charSequence;
                IconPreference iconPreference;
                Bitmap jz;
                this.tiv++;
                com.tencent.mm.plugin.subapp.jdbiz.b bVar2 = (com.tencent.mm.plugin.subapp.jdbiz.b) bVar.bGq();
                if ((bVar2.oqO < System.currentTimeMillis() / 1000 ? 1 : null) != null) {
                    if (bVar2.oqP == 0 || bVar2.oqP >= System.currentTimeMillis() / 1000) {
                        obj = null;
                    } else {
                        obj = 1;
                    }
                    if (obj == null) {
                        if (!bi.oW(bVar2.iconUrl)) {
                            value2 = bVar2.iconUrl;
                        }
                        if (!bi.oW(bVar2.title)) {
                            charSequence = bVar2.title;
                            iconPreference = (IconPreference) this.tig.ZZ("jd_market_entrance");
                            o.Pe();
                            jz = com.tencent.mm.ak.c.jz(value2);
                            if (jz == null) {
                                iconPreference.drawable = new BitmapDrawable(getContext().getResources(), jz);
                                this.til = null;
                            } else {
                                iconPreference.drawable = com.tencent.mm.bp.a.f(getContext(), R.k.jd_entrance_icon);
                                o.Pi().a(value2, this.tiF);
                                this.til = value2;
                            }
                            iconPreference.setTitle(charSequence);
                            iconPreference.Er(8);
                            iconPreference.Et(8);
                            iconPreference.Es(8);
                            iconPreference.lN(false);
                            iconPreference.Ew(8);
                            if (bVar.bGh() && bVar2.aiS() && !bVar2.bFZ()) {
                                if (!bi.oW(bVar2.oqK)) {
                                    iconPreference.Er(8);
                                    iconPreference.Et(8);
                                    iconPreference.ao(bVar2.oqK, -1, -7566196);
                                    iconPreference.Es(0);
                                }
                                if (!bi.oW(bVar2.oqL)) {
                                    o.Pe();
                                    Bitmap jz2 = com.tencent.mm.ak.c.jz(bVar2.oqL);
                                    iconPreference.Ew(0);
                                    iconPreference.Ev(0);
                                    iconPreference.Ex(0);
                                    iconPreference.lN(false);
                                    if (jz2 != null) {
                                        this.tiq = null;
                                        iconPreference.V(jz2);
                                    } else {
                                        o.Pi().a(bVar2.oqL, this.tiF);
                                        this.tiq = bVar2.oqL;
                                    }
                                } else if (!bi.oW(bVar2.oqK)) {
                                    iconPreference.lN(true);
                                } else if (bVar2.oqJ) {
                                    iconPreference.Et(0);
                                    iconPreference.dk("", -1);
                                    iconPreference.Er(8);
                                }
                            }
                            if (z) {
                                this.tig.notifyDataSetChanged();
                            }
                            if (!this.tir) {
                                com.tencent.mm.plugin.report.service.h.mEJ.h(11178, new Object[]{bGp, bVar.bGq().bGb(), Integer.valueOf(cpk())});
                                this.tir = true;
                            }
                            z2 = false;
                        }
                    }
                }
                obj = value;
                iconPreference = (IconPreference) this.tig.ZZ("jd_market_entrance");
                o.Pe();
                jz = com.tencent.mm.ak.c.jz(value2);
                if (jz == null) {
                    iconPreference.drawable = com.tencent.mm.bp.a.f(getContext(), R.k.jd_entrance_icon);
                    o.Pi().a(value2, this.tiF);
                    this.til = value2;
                } else {
                    iconPreference.drawable = new BitmapDrawable(getContext().getResources(), jz);
                    this.til = null;
                }
                iconPreference.setTitle(charSequence);
                iconPreference.Er(8);
                iconPreference.Et(8);
                iconPreference.Es(8);
                iconPreference.lN(false);
                iconPreference.Ew(8);
                if (bi.oW(bVar2.oqK)) {
                    iconPreference.Er(8);
                    iconPreference.Et(8);
                    iconPreference.ao(bVar2.oqK, -1, -7566196);
                    iconPreference.Es(0);
                }
                if (!bi.oW(bVar2.oqL)) {
                    o.Pe();
                    Bitmap jz22 = com.tencent.mm.ak.c.jz(bVar2.oqL);
                    iconPreference.Ew(0);
                    iconPreference.Ev(0);
                    iconPreference.Ex(0);
                    iconPreference.lN(false);
                    if (jz22 != null) {
                        this.tiq = null;
                        iconPreference.V(jz22);
                    } else {
                        o.Pi().a(bVar2.oqL, this.tiF);
                        this.tiq = bVar2.oqL;
                    }
                } else if (!bi.oW(bVar2.oqK)) {
                    iconPreference.lN(true);
                } else if (bVar2.oqJ) {
                    iconPreference.Et(0);
                    iconPreference.dk("", -1);
                    iconPreference.Er(8);
                }
                if (z) {
                    this.tig.notifyDataSetChanged();
                }
                if (this.tir) {
                    com.tencent.mm.plugin.report.service.h.mEJ.h(11178, new Object[]{bGp, bVar.bGq().bGb(), Integer.valueOf(cpk())});
                    this.tir = true;
                }
                z2 = false;
            }
        }
        this.tig.bw("jd_market_entrance", z2);
    }

    private static int cpk() {
        f.b bVar = f.qBo;
        if (bVar == null) {
            return 1;
        }
        f$a bGq = bVar.bGq();
        if (!bVar.bGh() || !bGq.aiS() || bGq.bFZ()) {
            return 1;
        }
        if ("3".equals(bGq.bGe()) && !bi.oW(bGq.bGf())) {
            return 6;
        }
        if (!bi.oW(bGq.bGc())) {
            return 3;
        }
        if (bGq.bGd()) {
            return 2;
        }
        return 1;
    }

    public final boolean a(com.tencent.mm.ui.base.preference.f fVar, Preference preference) {
        Intent intent;
        IconPreference iconPreference;
        String aG;
        Intent intent2;
        String bGp;
        if ("album_dyna_photo_ui_title".equals(preference.mKey)) {
            au.HU();
            if (com.tencent.mm.model.c.isSDCardAvailable()) {
                boolean z;
                com.tencent.mm.plugin.report.service.g.vu(10);
                au.HU();
                this.tij = (String) com.tencent.mm.model.c.DT().get(68377, null);
                intent = new Intent();
                com.tencent.mm.modelsns.b bVar = new com.tencent.mm.modelsns.b(701, 1);
                bVar.bP(!bi.oW(this.tij));
                bVar.nb(this.tik);
                intent.putExtra("sns_timeline_NeedFirstLoadint", true);
                intent.putExtra("is_from_find_more", true);
                String str = "enter_by_red";
                if (!bi.oW(this.tij) || this.tik > 0) {
                    z = true;
                } else {
                    z = false;
                }
                intent.putExtra(str, z);
                au.HU();
                intent.putExtra("is_sns_notify_open", bi.a((Boolean) com.tencent.mm.model.c.DT().get(68384, null), true));
                intent.putExtra("sns_unread_count", n.nkz.axd());
                if (!bi.oW(this.tij)) {
                    au.HU();
                    intent.putExtra("new_feed_id", bi.aG((String) com.tencent.mm.model.c.DT().get(68418, null), ""));
                }
                bVar.b(intent, "enter_log");
                hs hsVar = new hs();
                com.tencent.mm.sdk.b.a.sFg.m(hsVar);
                if (hsVar.bRd.isResume) {
                    z = true;
                } else {
                    if (bi.oW(this.tij)) {
                        z = true;
                    } else {
                        z = false;
                    }
                    if (n.nkz != null) {
                        this.tik = n.nkz.axd();
                        if (this.tik > 0) {
                            z = false;
                        }
                    }
                    au.HU();
                    com.tencent.mm.model.c.DT().set(68377, "");
                }
                au.HU();
                com.tencent.mm.model.c.DT().set(589825, Boolean.valueOf(false));
                intent.putExtra("sns_resume_state", z);
                d.b(getContext(), "sns", ".ui.SnsTimeLineUI", intent);
                com.tencent.mm.plugin.report.service.h.mEJ.k(10958, "1");
                new ag().postDelayed(new 8(this), 500);
                return true;
            }
            s.gH(getContext());
            return true;
        } else if ("find_friends_by_near".equals(preference.mKey)) {
            x.i("MicroMsg.FindMoreFriendsUI", "summerper checkPermission checkLocation[%b]", new Object[]{Boolean.valueOf(com.tencent.mm.pluginsdk.permission.a.a(thisActivity(), "android.permission.ACCESS_COARSE_LOCATION", 66, null, null))});
            if (!com.tencent.mm.pluginsdk.permission.a.a(thisActivity(), "android.permission.ACCESS_COARSE_LOCATION", 66, null, null)) {
                return true;
            }
            cpl();
            return true;
        } else if ("find_friends_by_shake".equals(preference.mKey)) {
            if (!this.tis && q.Hn().booleanValue()) {
                iconPreference = (IconPreference) fVar.ZZ("find_friends_by_shake");
                if (iconPreference != null) {
                    iconPreference.Et(8);
                    au.HU();
                    com.tencent.mm.model.c.DT().set(340231, Boolean.valueOf(true));
                    au.HU();
                    com.tencent.mm.model.c.DT().lm(true);
                    com.tencent.mm.plugin.report.service.h.mEJ.a(232, 4, 1, false);
                }
            }
            com.tencent.mm.plugin.report.service.h.mEJ.k(10958, "3");
            au.HU();
            aG = bi.aG((String) com.tencent.mm.model.c.DT().get(aa.a.sRQ, null), "");
            au.HU();
            Boolean valueOf = (!Boolean.valueOf(bi.a((Boolean) com.tencent.mm.model.c.DT().get(aa.a.sRS, null), false)).booleanValue() || aG == null || aG.equals("")) ? Boolean.valueOf(false) : Boolean.valueOf(true);
            if (valueOf.booleanValue()) {
                com.tencent.mm.plugin.report.service.h.mEJ.h(12653, new Object[]{Integer.valueOf(2), Integer.valueOf(2)});
            }
            com.tencent.mm.sdk.b.a.sFg.m(new nh());
            d.A(getContext(), "shake", ".ui.ShakeReportUI");
            return true;
        } else if ("voice_bottle".equals(preference.mKey)) {
            com.tencent.mm.plugin.report.service.h.mEJ.k(10958, "5");
            bl IC = bl.IC();
            if (bi.a(Integer.valueOf(IC.sex), 0) <= 0 || bi.oW(IC.getProvince())) {
                d.A(getContext(), "bottle", ".ui.BottleWizardStep1");
                return true;
            }
            d.A(getContext(), "bottle", ".ui.BottleBeachUI");
            return true;
        } else if ("find_friends_by_qrcode".equals(preference.mKey)) {
            if (com.tencent.mm.p.a.bx(getContext())) {
                return true;
            }
            getContext();
            if (e.Sz()) {
                return true;
            }
            com.tencent.mm.plugin.report.service.h.mEJ.k(10958, "2");
            intent2 = new Intent();
            intent2.putExtra("BaseScanUI_qrcode_right_btn_direct_album", true);
            com.tencent.mm.plugin.report.service.h.mEJ.h(11265, new Object[]{Integer.valueOf(2)});
            d.b(getContext(), "scanner", ".ui.BaseScanUI", intent2);
            return true;
        } else if (preference.mKey.equals("more_tab_game_recommend")) {
            com.tencent.mm.plugin.report.service.h.mEJ.k(10958, "6");
            com.tencent.mm.plugin.report.service.h.mEJ.a(848, 2, 1, false);
            au.HU();
            if (com.tencent.mm.model.c.isSDCardAvailable()) {
                intent = new Intent();
                intent.putExtra("from_find_more_friend", this.tiu);
                intent.putExtra("game_report_from_scene", 901);
                if (this.tiu) {
                    me meVar = new me();
                    com.tencent.mm.sdk.b.a.sFg.m(meVar);
                    iconPreference = (IconPreference) fVar.ZZ("more_tab_game_recommend");
                    if (!(meVar.bWO.bWP == null || iconPreference == null)) {
                        o.Pj().dWO.a(new com.tencent.mm.ak.a.c(iconPreference.kYT, meVar.bWO.bWP));
                    }
                }
                d.b(getContext(), "game", ".ui.GameCenterUI", intent);
                return true;
            }
            s.gH(getContext());
            return true;
        } else if ("find_friends_by_micromsg".equals(preference.mKey)) {
            d.b(getContext(), "subapp", ".ui.pluginapp.ContactSearchUI", new Intent());
            return true;
        } else if ("find_friends_by_mobile".equals(preference.mKey)) {
            if (l.XC() != l.a.eKt) {
                intent2 = new Intent(getContext(), BindMContactIntroUI.class);
                intent2.putExtra("key_upload_scene", 6);
                MMWizardActivity.D(getContext(), intent2);
                return true;
            }
            startActivity(new Intent(getContext(), MobileFriendUI.class));
            return true;
        } else if ("find_friends_by_facebook".equals(preference.mKey)) {
            startActivity(new Intent(getContext(), FacebookFriendUI.class));
            return true;
        } else if ("settings_mm_card_package".equals(preference.mKey)) {
            x.i("MicroMsg.FindMoreFriendsUI", "enter to cardhome");
            d.A(getContext(), "card", ".ui.CardHomePageUI");
            return true;
        } else if (preference.mKey.equals("jd_market_entrance")) {
            i.Cx(9);
            f.b bVar2 = f.qBo;
            if (bVar2 != null) {
                bGp = f.qBo.bGp();
                com.tencent.mm.plugin.report.service.h.mEJ.h(11179, new Object[]{bGp, bVar2.bGq().bGb(), Integer.valueOf(cpk())});
                bVar2.bGk();
                bVar2.bGj();
                ((IconPreference) preference).dk("", -1);
                if (!bi.oW(bGp)) {
                    intent = new Intent();
                    intent.putExtra("rawUrl", bGp);
                    intent.putExtra("useJs", true);
                    intent.putExtra("vertical_scroll", true);
                    intent.putExtra("minimize_secene", 1);
                    intent.putExtra("KPublisherId", "jd_store");
                    d.b(getContext(), "webview", ".ui.tools.WebViewUI", intent);
                }
            } else {
                bGp = null;
            }
            x.i("MicroMsg.FindMoreFriendsUI", "jump to url: " + bGp);
            return true;
        } else if ("ip_call_entrance".equals(preference.mKey)) {
            boolean z2;
            iconPreference = (IconPreference) fVar.ZZ("ip_call_entrance");
            iconPreference.Et(8);
            iconPreference.Es(8);
            iconPreference.lN(false);
            iconPreference.Ew(8);
            au.HU();
            bGp = (String) com.tencent.mm.model.c.DT().get(aa.a.sRh, "");
            au.HU();
            if (((Boolean) com.tencent.mm.model.c.DT().get(aa.a.sRi, Boolean.valueOf(false))).booleanValue()) {
                com.tencent.mm.plugin.ipcall.a.e.i.M(1, -1, -1);
                au.HU();
                com.tencent.mm.model.c.DT().a(aa.a.sRi, Boolean.valueOf(false));
                z2 = true;
            } else {
                z2 = false;
            }
            au.HU();
            if (((Integer) com.tencent.mm.model.c.DT().get(aa.a.sRg, Integer.valueOf(0))).intValue() < com.tencent.mm.k.g.AT().getInt("WCOEntranceRedDot", 0)) {
                com.tencent.mm.plugin.report.service.h.mEJ.h(13254, new Object[]{Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(-1), Integer.valueOf(-1), Integer.valueOf(-1)});
                au.HU();
                com.tencent.mm.model.c.DT().a(aa.a.sRg, Integer.valueOf(com.tencent.mm.k.g.AT().getInt("WCOEntranceRedDot", 0)));
                z2 = true;
            }
            if (!bi.oW(bGp)) {
                au.HU();
                com.tencent.mm.model.c.DT().a(aa.a.sRh, "");
            }
            if (z2) {
                com.tencent.mm.sdk.b.a.sFg.m(new sa());
            }
            if (com.tencent.mm.p.a.BQ()) {
                com.tencent.mm.ui.base.h.a(getContext(), R.l.multitalk_in_tip, 0, null, null);
                return true;
            }
            com.tencent.mm.plugin.report.service.h.mEJ.h(12061, new Object[]{Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0)});
            d.b(getContext(), "ipcall", ".ui.IPCallAddressUI", new Intent());
            return true;
        } else if ("app_brand_entrance".equals(preference.mKey)) {
            ((com.tencent.mm.plugin.appbrand.n.f) g.l(com.tencent.mm.plugin.appbrand.n.f.class)).x(getContext(), 1);
            return true;
        } else if ("find_friends_by_search".equals(preference.mKey)) {
            if (com.tencent.mm.plugin.websearch.api.p.zO(0)) {
                String optString = r.PX("discoverSearchEntry").optString("wording");
                if (bi.oW(optString)) {
                    x.e("MicroMsg.FindMoreFriendsUI", "empty title");
                    return true;
                }
                ac bTg = ac.bTg();
                bTg.pMk = new ac.a();
                bTg.save();
                ((com.tencent.mm.plugin.welab.a.a.a) g.l(com.tencent.mm.plugin.welab.a.a.a.class)).open("labs1de6f3");
                ad.h("", 0, 0, 20);
                String zK = com.tencent.mm.plugin.websearch.api.p.zK(20);
                bGp = com.tencent.mm.plugin.webview.modeltools.e.bUU().bTG();
                Map hashMap = new HashMap();
                hashMap.put("sessionId", zK);
                hashMap.put("inputMarginTop", "32");
                hashMap.put("inputMarginLeftRight", "24");
                hashMap.put("inputHeight", "48");
                if (!(bGp == null || bGp.isEmpty())) {
                    hashMap.put("educationTab", Uri.encode(bGp));
                }
                ((com.tencent.mm.plugin.websearch.api.f) g.l(com.tencent.mm.plugin.websearch.api.f.class)).a(getContext(), 20, "", zK, hashMap, optString);
                ((com.tencent.mm.plugin.boots.a.c) g.l(com.tencent.mm.plugin.boots.a.c.class)).nd(com.tencent.mm.plugin.boots.a.b.hjA);
                return true;
            }
            x.e("MicroMsg.FindMoreFriendsUI", "fts h5 template not avail");
            return true;
        } else if (!"find_friends_by_look".equals(preference.mKey)) {
            return false;
        } else {
            if (com.tencent.mm.plugin.websearch.api.p.zO(1)) {
                aG = r.PX("discoverRecommendEntry").optString("wording");
                if (bi.oW(aG)) {
                    x.e("MicroMsg.FindMoreFriendsUI", "empty query");
                    return true;
                }
                x.i("MicroMsg.FindMoreFriendsUI", "look one look clikced");
                com.tencent.mm.plugin.topstory.ui.d.N(getContext(), 21);
                ((com.tencent.mm.plugin.welab.a.a.a) g.l(com.tencent.mm.plugin.welab.a.a.a.class)).open("labs_browse");
                kx kxVar = new kx();
                kxVar.bVh.scene = 0;
                com.tencent.mm.sdk.b.a.sFg.m(kxVar);
                ad.aR(21, aG);
                ad.reportIdKey649ForLook(21, 0);
                if (com.tencent.mm.plugin.websearch.api.p.zP(1) > com.tencent.mm.plugin.websearch.api.p.zN(1)) {
                    ad.reportIdKey649ForLook(21, 15);
                    return true;
                }
                ad.reportIdKey649ForLook(21, 14);
                return true;
            }
            x.e("MicroMsg.FindMoreFriendsUI", "fts h5 template not avail");
            return true;
        }
    }

    public final void cpl() {
        com.tencent.mm.plugin.report.service.h.mEJ.k(10958, "4");
        au.HU();
        if (bi.d((Boolean) com.tencent.mm.model.c.DT().get(4103, null))) {
            bl ID = bl.ID();
            if (ID == null) {
                d.A(getContext(), "nearby", ".ui.NearbyPersonalInfoUI");
                return;
            }
            String oV = bi.oV(ID.getProvince());
            int a = bi.a(Integer.valueOf(ID.sex), 0);
            if (bi.oW(oV) || a == 0) {
                d.A(getContext(), "nearby", ".ui.NearbyPersonalInfoUI");
                return;
            }
            au.HU();
            Boolean bool = (Boolean) com.tencent.mm.model.c.DT().get(4104, null);
            if (bool == null || !bool.booleanValue()) {
                LauncherUI launcherUI = (LauncherUI) getContext();
                if (launcherUI != null) {
                    launcherUI.tkn.tjF.ZS("tab_find_friend");
                }
                com.tencent.mm.be.a.eF(getContext());
                return;
            }
            if (this.tih == null) {
                this.tih = View.inflate(getContext(), R.i.lbs_open_dialog_view, null);
                this.lBF = (CheckBox) this.tih.findViewById(R.h.lbs_open_dialog_cb);
                this.lBF.setChecked(false);
            }
            if (this.lBH == null) {
                this.lBH = com.tencent.mm.ui.base.h.a(getContext(), getString(R.l.app_tip), this.tih, new 9(this), null);
                return;
            } else {
                this.lBH.show();
                return;
            }
        }
        d.A(getContext(), "nearby", ".ui.NearbyFriendsIntroUI");
    }

    private void cpm() {
        if (((IconPreference) this.tig.ZZ("more_tab_game_recommend")) != null) {
            com.tencent.mm.sdk.f.e.post(new 10(this), "updateGame");
        }
    }

    private synchronized void a(String str, IconPreference iconPreference, me meVar, String str2) {
        if (!(bi.oW(str) || iconPreference == null || iconPreference.kYT == null)) {
            x.d("MicroMsg.FindMoreFriendsUI", "download entrance image : %s", new Object[]{str});
            String str3 = meVar.bWO.bWQ;
            String str4 = meVar.bWO.appId;
            int i = meVar.bWO.msgType;
            String str5 = meVar.bWO.bHF;
            int i2 = meVar.bWO.showType;
            gq gqVar = new gq();
            gqVar.bPN.nc = 1;
            gqVar.bPN.url = str;
            com.tencent.mm.sdk.b.a.sFg.m(gqVar);
            if (gqVar.bPO.bPQ) {
                String str6 = gqVar.bPO.bPP + com.tencent.mm.a.g.u(str.getBytes());
                com.tencent.mm.ak.a.a.c.a aVar = new com.tencent.mm.ak.a.a.c.a();
                aVar.dXy = true;
                aVar.dXA = str6;
                com.tencent.mm.ak.a.a.c Pt = aVar.Pt();
                o.Pj().a(str, iconPreference.kYT, Pt, new 11(this, gqVar), new 13(this, gqVar, iconPreference, i2, str4, i, str3, str5, str2));
            }
        }
    }

    private static void a(String str, int i, String str2, String str3, int i2) {
        g.Ek();
        String str4 = (String) g.Ei().DT().get(aa.a.sZb, "");
        if (str2 != null && !str2.equals(str4)) {
            g.Ek();
            g.Ei().DT().a(aa.a.sZb, str2);
            nj njVar = new nj();
            njVar.bYp.scene = 9;
            njVar.bYp.bYq = 901;
            njVar.bYp.action = 1;
            njVar.bYp.appId = str;
            njVar.bYp.msgType = i;
            njVar.bYp.bWQ = str2;
            njVar.bYp.bHF = str3;
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("function_type", "resource");
                jSONObject.put("function_value", String.valueOf(i2));
            } catch (JSONException e) {
                x.e("MicroMsg.FindMoreFriendsUI", e.getMessage());
            }
            try {
                str4 = URLEncoder.encode(jSONObject.toString(), "utf-8");
            } catch (UnsupportedEncodingException e2) {
                UnsupportedEncodingException unsupportedEncodingException = e2;
                str4 = "";
                x.e("MicroMsg.FindMoreFriendsUI", unsupportedEncodingException.getMessage());
            }
            njVar.bYp.bYr = str4;
            com.tencent.mm.sdk.b.a.sFg.m(njVar);
            com.tencent.mm.plugin.report.service.h.mEJ.a(858, 2, 1, false);
        }
    }

    private String gg(String str, String str2) {
        return !bi.oW(str) ? str : com.tencent.mm.pluginsdk.model.app.g.q(getContext(), str2);
    }

    private static void a(IconPreference iconPreference, int i, int i2, int i3, boolean z, int i4, int i5, int i6) {
        iconPreference.Er(i);
        iconPreference.Et(i2);
        iconPreference.Es(i3);
        iconPreference.lN(z);
        iconPreference.Ew(i4);
        iconPreference.Ev(i5);
        iconPreference.Ex(i6);
    }

    public final void HG() {
        if ((q.GQ() & 32768) == 0) {
            this.tik++;
            cpn();
            this.tig.notifyDataSetChanged();
        }
    }

    public final void HH() {
        if ((q.GQ() & 32768) == 0) {
            cpn();
            this.tig.notifyDataSetChanged();
        }
    }

    public final void HI() {
    }

    public final void HK() {
        if (this.tig != null) {
            this.status = q.GJ();
            anw();
        }
    }

    protected final void coy() {
        x.i("MicroMsg.FindMoreFriendsUI", "on tab create");
        this.tig = this.tCL;
        this.status = q.GJ();
        this.mSF = q.GQ();
        this.hXx = q.GK();
        x.i("MicroMsg.FindMoreFriendsUI", "on tab create end");
    }

    protected final void coz() {
        x.i("MicroMsg.FindMoreFriendsUI", "on tab resume");
        this.bQt = true;
        cpq();
        com.tencent.mm.pluginsdk.c.a.a(iq.class.getName(), this.qOz);
        com.tencent.mm.pluginsdk.c.a.a(gp.class.getName(), this.tiB);
        com.tencent.mm.pluginsdk.c.a.a(ph.class.getName(), this.tiC);
        com.tencent.mm.sdk.b.a.sFg.b(this.tiz);
        com.tencent.mm.sdk.b.a.sFg.b(this.tiy);
        com.tencent.mm.sdk.b.a.sFg.b(this.tiA);
        com.tencent.mm.sdk.b.a.sFg.b(this.nqB);
        com.tencent.mm.sdk.b.a.sFg.b(this.tiD);
        com.tencent.mm.sdk.b.a.sFg.a(this.jxo);
        com.tencent.mm.sdk.b.a.sFg.b(this.tiE);
        com.tencent.mm.az.d.SH().c(this);
        au.HU();
        com.tencent.mm.model.c.FW().a(this);
        au.HU();
        com.tencent.mm.model.c.a(this);
        au.HU();
        com.tencent.mm.model.c.DT().a(this);
        if (n.nkB != null) {
            n.nkB.a(this);
        }
        View findViewById = findViewById(R.h.loading_tips_area);
        if (!(findViewById == null || findViewById.getVisibility() == 8)) {
            new ag(Looper.getMainLooper()).post(new 14(this, findViewById));
        }
        if (isAdded()) {
            com.tencent.mm.blink.b.xi().g(new 15(this));
        }
        x.i("MicroMsg.FindMoreFriendsUI", "on tab resume end");
    }

    private boolean vO(int i) {
        return (this.hXx & ((long) i)) != 0;
    }

    private void cpn() {
        boolean z = (this.mSF & 32768) == 0;
        x.i("MicroMsg.FindMoreFriendsUI", "openSns %s, plugin installed %s", new Object[]{Boolean.valueOf(z), Boolean.valueOf(d.QS("sns"))});
        SharedPreferences sharedPreferences = getSharedPreferences(com.tencent.mm.sdk.platformtools.ad.chY(), 0);
        String string = sharedPreferences.getString(q.GF() + "_sns_entrance_disappear", "");
        if (!z) {
            boolean z2 = sharedPreferences.getBoolean(q.GF() + "_has_mod_userinfo", false);
            int i;
            if (string != null && string.equals("on")) {
                com.tencent.mm.plugin.report.service.h.mEJ.a(150, (long) (z2 ? s$l.AppCompatTheme_spinnerStyle : s$l.AppCompatTheme_switchStyle), 1, true);
                x.e("MicroMsg.FindMoreFriendsUI", "sns entrance disappear autoly, hasModUserInfo:%b", new Object[]{Boolean.valueOf(z2)});
                com.tencent.mm.plugin.report.service.h.mEJ.h(15179, new Object[]{Integer.valueOf(i)});
            } else if (string != null && string.equals("on_close")) {
                if (z2) {
                    i = 112;
                } else {
                    i = 113;
                }
                com.tencent.mm.plugin.report.service.h.mEJ.a(150, (long) i, 1, true);
                x.i("MicroMsg.FindMoreFriendsUI", "sns entrance close by user, hasModUserInfo:%b", new Object[]{Boolean.valueOf(z2)});
                com.tencent.mm.plugin.report.service.h.mEJ.h(15179, new Object[]{Integer.valueOf(i)});
            }
            if (sharedPreferences.contains(q.GF() + "_has_mod_userinfo") || sharedPreferences.contains(q.GF() + "_sns_entrance_disappear")) {
                sharedPreferences.edit().remove(q.GF() + "_has_mod_userinfo").remove(q.GF() + "_sns_entrance_disappear").commit();
            }
        } else if (bi.oW(string)) {
            sharedPreferences.edit().putString(q.GF() + "_sns_entrance_disappear", "on").commit();
        }
        if (z && r10) {
            this.tiv++;
            this.tig.bw("album_dyna_photo_ui_title", false);
            FriendSnsPreference friendSnsPreference = (FriendSnsPreference) this.tig.ZZ("album_dyna_photo_ui_title");
            friendSnsPreference.drawable = com.tencent.mm.bp.a.f(getContext(), R.k.find_more_friend_photograph_icon);
            au.HU();
            boolean d = bi.d((Boolean) com.tencent.mm.model.c.DT().get(48, null));
            friendSnsPreference.Er(8);
            friendSnsPreference.Ex(8);
            if (d) {
                friendSnsPreference.Er(0);
                friendSnsPreference.dk(getString(R.l.app_new), R.g.new_tips_bg);
            }
            au.HU();
            this.tij = (String) com.tencent.mm.model.c.DT().get(68377, null);
            Object obj = g.Ei().DT().get(aa.a.tah, null);
            long longValue = obj == null ? 0 : ((Long) obj).longValue();
            x.i("MicroMsg.FindMoreFriendsUI", "newer snsobj %s", new Object[]{bi.aG(this.tij, "")});
            friendSnsPreference.Ew(0);
            if (bi.oW(this.tij)) {
                au.HU();
                if (((Boolean) com.tencent.mm.model.c.DT().get(589825, Boolean.valueOf(false))).booleanValue()) {
                    friendSnsPreference.Eu(R.k.net_warn_icon);
                    friendSnsPreference.Ev(0);
                    friendSnsPreference.Ex(8);
                } else if (longValue == 0 || !((m) g.l(m.class)).ew(longValue)) {
                    friendSnsPreference.Ev(8);
                } else {
                    friendSnsPreference.Ev(0);
                    friendSnsPreference.Ex(0);
                    friendSnsPreference.tiV = null;
                    friendSnsPreference.tiW = null;
                    friendSnsPreference.tgw = -1;
                    friendSnsPreference.tiX = longValue;
                    if (!(friendSnsPreference.tiX == 0 || friendSnsPreference.kYT == null)) {
                        ((m) g.l(m.class)).a(friendSnsPreference.tiX, friendSnsPreference.kYT, friendSnsPreference.mContext.hashCode());
                    }
                }
            } else {
                friendSnsPreference.Ev(0);
                au.HU();
                friendSnsPreference.Ex(bi.a((Boolean) com.tencent.mm.model.c.DT().get(68384, null), true) ? 0 : 8);
                string = this.tij;
                friendSnsPreference.tiW = null;
                friendSnsPreference.tgw = -1;
                friendSnsPreference.tiV = string;
                friendSnsPreference.tiX = 0;
                if (friendSnsPreference.kYT != null) {
                    com.tencent.mm.pluginsdk.ui.a.b.a(friendSnsPreference.kYT, string);
                }
            }
            if (n.nkz != null) {
                this.tik = n.nkz.axd();
            }
            if (this.tik != 0) {
                friendSnsPreference.Er(0);
                friendSnsPreference.dk(this.tik, com.tencent.mm.ui.tools.r.hd(getContext()));
            }
            friendSnsPreference.Et(8);
            friendSnsPreference.Es(8);
            com.tencent.mm.sdk.b.a.sFg.m(new sa());
            return;
        }
        this.tig.bw("album_dyna_photo_ui_title", true);
    }

    private void cpo() {
        x.i("MicroMsg.FindMoreFriendsUI", "openShake %s, plugin installed %s", new Object[]{Boolean.valueOf((this.mSF & 256) == 0), Boolean.valueOf(d.QS("shake"))});
        if (((this.mSF & 256) == 0) && r1) {
            boolean aU;
            this.tiv++;
            this.tig.bw("find_friends_by_shake", false);
            IconPreference iconPreference = (IconPreference) this.tig.ZZ("find_friends_by_shake");
            int axd = com.tencent.mm.az.d.SH().axd() + o$a.cbj().buv();
            if (axd > 0) {
                iconPreference.Er(0);
                iconPreference.dk(String.valueOf(axd), R.g.unread_count_shape);
            } else {
                iconPreference.Er(8);
                iconPreference.dk("", -1);
            }
            iconPreference.Ev(8);
            o$a.cbj().buw();
            if (o$a.cbj().bux()) {
                aU = com.tencent.mm.s.c.Cp().aU(262154, 266258);
            } else {
                aU = false;
            }
            if (aU) {
                au.HU();
                String str = (String) com.tencent.mm.model.c.DT().get(aa.a.sOK, "");
                if (!TextUtils.isEmpty(str)) {
                    iconPreference.Et(8);
                    iconPreference.Er(0);
                    iconPreference.dk(str, R.g.unread_count_shape);
                } else if (axd > 0) {
                    iconPreference.Et(0);
                } else {
                    iconPreference.Et(0);
                    iconPreference.Er(8);
                    iconPreference.dk("", -1);
                }
            } else {
                iconPreference.Et(8);
            }
            au.HU();
            String aG = bi.aG((String) com.tencent.mm.model.c.DT().get(aa.a.sRQ, null), "");
            au.HU();
            Boolean valueOf = Boolean.valueOf(bi.a((Boolean) com.tencent.mm.model.c.DT().get(aa.a.sRS, null), false));
            au.HU();
            int intValue = ((Integer) com.tencent.mm.model.c.DT().get(aa.a.sRO, Integer.valueOf(0))).intValue();
            if (!valueOf.booleanValue() || aG == null || aG.equals("") || axd > 0 || aU) {
                iconPreference.Es(8);
                return;
            } else if (intValue == 0) {
                iconPreference.Et(8);
                iconPreference.Es(0);
                String[] split = aG.split(",");
                if (split.length > 0) {
                    iconPreference.ao(split[0], -1, Color.parseColor("#8c8c8c"));
                }
                iconPreference.lN(true);
                iconPreference.Ew(8);
                return;
            } else if (intValue == 1) {
                iconPreference.Es(8);
                iconPreference.Er(0);
                iconPreference.tCn = true;
                return;
            } else {
                return;
            }
        }
        this.tig.bw("find_friends_by_shake", true);
    }

    private void cpp() {
        x.i("MicroMsg.FindMoreFriendsUI", "openNearby %s, plugin installed %s", new Object[]{Boolean.valueOf((this.mSF & 512) == 0), Boolean.valueOf(d.QS("nearby"))});
        if (((this.mSF & 512) == 0) && r3) {
            this.tiv++;
            this.tig.bw("find_friends_by_near", false);
            IconPreference iconPreference = (IconPreference) this.tig.ZZ("find_friends_by_near");
            if (iconPreference != null) {
                iv ivVar = new iv();
                ivVar.bSp.bNI = 7;
                com.tencent.mm.sdk.b.a.sFg.m(ivVar);
                if (ivVar.bSq.bJm) {
                    iconPreference.Ev(8);
                } else {
                    iconPreference.Ev(0);
                    iconPreference.Eu(R.g.mm_foot);
                    iconPreference.eW(-2, -2);
                }
                int axd = com.tencent.mm.az.d.SG().axd();
                if (com.tencent.mm.be.a.cbf()) {
                    if (axd > 0) {
                        iconPreference.Et(0);
                        return;
                    } else {
                        iconPreference.Et(8);
                        return;
                    }
                } else if (axd > 0) {
                    iconPreference.Er(0);
                    iconPreference.dk(String.valueOf(axd), com.tencent.mm.ui.tools.r.hd(getContext()));
                    return;
                } else {
                    iconPreference.Er(8);
                    iconPreference.dk("", -1);
                    return;
                }
            }
            return;
        }
        this.tig.bw("find_friends_by_near", true);
    }

    private void cpq() {
        ou ouVar = new ou();
        ouVar.bZO.bQt = this.bQt;
        com.tencent.mm.sdk.b.a.sFg.m(ouVar);
    }

    protected final void coA() {
        x.i("MicroMsg.FindMoreFriendsUI", "on tab start");
    }

    protected final void coB() {
        x.i("MicroMsg.FindMoreFriendsUI", "on tab pause");
        this.bQt = false;
        cpq();
        if (au.HX()) {
            com.tencent.mm.pluginsdk.c.a.b(iq.class.getName(), this.qOz);
            com.tencent.mm.pluginsdk.c.a.b(gp.class.getName(), this.tiB);
            com.tencent.mm.pluginsdk.c.a.b(ph.class.getName(), this.tiC);
            com.tencent.mm.sdk.b.a.sFg.c(this.tiz);
            com.tencent.mm.sdk.b.a.sFg.c(this.tiy);
            com.tencent.mm.sdk.b.a.sFg.c(this.tiA);
            com.tencent.mm.sdk.b.a.sFg.c(this.nqB);
            com.tencent.mm.sdk.b.a.sFg.c(this.tiD);
            com.tencent.mm.sdk.b.a.sFg.c(this.jxo);
            com.tencent.mm.sdk.b.a.sFg.c(this.tiE);
            com.tencent.mm.az.d.SH().d(this);
            au.HU();
            com.tencent.mm.model.c.FW().b(this);
            au.HU();
            com.tencent.mm.model.c.b(this);
            au.HU();
            com.tencent.mm.model.c.DT().b(this);
            if (this.til != null) {
                o.Pe().lF(this.til);
            }
            if (this.tiq != null) {
                o.Pe().lF(this.tiq);
            }
        }
        if (n.nkB != null) {
            n.nkB.b(this);
        }
    }

    protected final void coC() {
        x.i("MicroMsg.FindMoreFriendsUI", "on tab stop");
    }

    protected final void coD() {
        x.i("MicroMsg.FindMoreFriendsUI", "on tab destroy");
    }

    public final void coF() {
        x.i("MicroMsg.FindMoreFriendsUI", "turn to bg");
    }

    public final void coG() {
        x.i("MicroMsg.FindMoreFriendsUI", "turn to fg");
    }

    public final void coI() {
        x.i("MicroMsg.FindMoreFriendsUI", "on tab recreate ui");
    }

    public final void a(String str, com.tencent.mm.sdk.e.l lVar) {
        Object obj = 1;
        x.i("MicroMsg.FindMoreFriendsUI", "onNotifyChange");
        if (LauncherUI.cpR() == 2) {
            Object obj2 = null;
            if (this.status != q.GJ()) {
                this.status = q.GJ();
                obj2 = 1;
            }
            if (this.hXx != q.GK()) {
                this.hXx = q.GK();
                obj2 = 1;
            }
            if (this.mSF != q.GQ()) {
                this.mSF = q.GQ();
            } else {
                obj = obj2;
            }
            if (obj != null) {
                anw();
            }
        }
    }

    public final void a(int i, com.tencent.mm.sdk.e.m mVar, Object obj) {
        Object obj2 = 1;
        x.i("MicroMsg.FindMoreFriendsUI", "onNotifyChange");
        if (LauncherUI.cpR() == 2) {
            Object obj3 = null;
            if (this.status != q.GJ()) {
                this.status = q.GJ();
                obj3 = 1;
            }
            if (this.hXx != q.GK()) {
                this.hXx = q.GK();
                obj3 = 1;
            }
            if (this.mSF != q.GQ()) {
                this.mSF = q.GQ();
            } else {
                obj2 = obj3;
            }
            if (obj2 != null) {
                anw();
            }
        }
    }

    public final void cpr() {
        x.v("MicroMsg.FindMoreFriendsUI", "on tab switch in");
        this.bQt = true;
        cpq();
        com.tencent.mm.blink.b.xi().g(new 16(this));
        r.zZ(20);
    }

    public final void cps() {
        x.v("MicroMsg.FindMoreFriendsUI", "on tab switch out");
        this.bQt = false;
        cpq();
    }

    public final void HJ() {
        x.i("MicroMsg.FindMoreFriendsUI", "notify comment change");
        if ((q.GQ() & 32768) == 0) {
            if (n.nkz != null) {
                this.tik = n.nkz.axd();
            }
            cpn();
            this.tig.notifyDataSetChanged();
        }
    }
}
