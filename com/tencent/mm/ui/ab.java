package com.tencent.mm.ui;

import android.content.ComponentName;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Looper;
import android.text.Spannable.Factory;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import com.tencent.mm.R;
import com.tencent.mm.ak.o;
import com.tencent.mm.bg.d;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.g.a.nn;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.au;
import com.tencent.mm.model.q;
import com.tencent.mm.platformtools.ai;
import com.tencent.mm.plugin.account.a.j;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.ui.preference.AccountInfoPreference;
import com.tencent.mm.s.a.a;
import com.tencent.mm.s.c;
import com.tencent.mm.sdk.e.m;
import com.tencent.mm.sdk.e.m.b;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.aa;
import com.tencent.mm.storage.bh;
import com.tencent.mm.ui.base.preference.IconPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.ui.base.s;
import com.tencent.mm.ui.contact.AddressUI;
import com.tencent.mm.ui.e.i;
import com.tencent.mm.ui.tools.r;
import java.util.UUID;

public class ab extends a implements b {
    private f eOE;
    private a mUs = new 1(this);

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (!au.HX() || au.Dr()) {
            x.e("MicroMsg.MoreTabUI", "Create MoreTabUI when accready:%b ishold:%b", new Object[]{Boolean.valueOf(au.HX()), Boolean.valueOf(au.Dr())});
        }
    }

    public final int Ys() {
        return R.o.more_tab_pref;
    }

    public boolean supportNavigationSwipeBack() {
        return false;
    }

    public boolean noActionBar() {
        return true;
    }

    public void onDestroy() {
        super.onDestroy();
    }

    public void onActivityCreated(Bundle bundle) {
        x.i("MicroMsg.MoreTabUI", "onActivityCreated");
        super.onActivityCreated(bundle);
        this.eOE = this.tCL;
        this.eOE.bw("more_setting", true);
        this.eOE.bw("settings_emoji_store", true);
        this.eOE.bw("settings_mm_wallet", true);
        this.eOE.bw("settings_mm_cardpackage", true);
        this.eOE.bw("settings_mm_favorite", true);
        this.eOE.bw("settings_my_album", true);
        this.eOE.bw("settings_my_address", true);
        this.eOE.bw("more_tab_setting_personal_info", true);
        this.eOE.bw("more_uishow", true);
        this.eOE.bw("settings_privacy_agreements", true);
    }

    public final boolean a(f fVar, Preference preference) {
        Intent intent;
        boolean aU;
        int i;
        String str;
        if (preference.mKey.equals("more_tab_setting_personal_info")) {
            d.b(getContext(), "setting", ".ui.setting.SettingsPersonalInfoUI", new Intent());
            return true;
        } else if (preference.mKey.equals("settings_my_address")) {
            intent = new Intent(getContext(), AddressUI.class);
            intent.putExtra("Contact_GroupFilter_Type", "@biz.contact");
            startActivity(intent);
            return true;
        } else if (preference.mKey.equals("settings_my_add_contact")) {
            d.b(getContext(), "subapp", ".ui.pluginapp.AddMoreFriendsUI", new Intent());
            return true;
        } else if (preference.mKey.equals("settings_mm_wallet")) {
            boolean aT = c.Cp().aT(262156, 266248);
            aU = c.Cp().aU(262156, 266248);
            h.mEJ.k(10958, "9");
            h hVar = h.mEJ;
            Object[] objArr = new Object[1];
            i = (aT || aU) ? 1 : 0;
            objArr[0] = Integer.valueOf(i);
            hVar.h(13341, objArr);
            h.mEJ.h(14419, new Object[]{UUID.randomUUID().toString(), Integer.valueOf(0)});
            nn nnVar = new nn();
            nnVar.bYA.context = getContext();
            Intent intent2 = new Intent();
            intent2.putExtra("key_wallet_has_red", aU);
            intent2.putExtra("key_uuid", str);
            nnVar.bYA.intent = intent2;
            com.tencent.mm.sdk.b.a.sFg.m(nnVar);
            c.Cp().aV(262156, 266248);
            c.Cp().c(aa.a.sYc, aa.a.sYe);
            au.HU();
            com.tencent.mm.model.c.DT().a(aa.a.sXL, "");
            au.HU();
            com.tencent.mm.model.c.DT().a(aa.a.sXM, Integer.valueOf(-1));
            g.Ek();
            g.Ei().DT().a(aa.a.sZu, Boolean.valueOf(false));
            g.Ek();
            g.Ei().DT().a(aa.a.sZs, "");
            g.Ek();
            g.Ei().DT().a(aa.a.sZt, Boolean.valueOf(false));
            hVar = h.mEJ;
            objArr = new Object[5];
            objArr[0] = Integer.valueOf(6);
            if (aU) {
                i = 1;
            } else {
                i = 0;
            }
            objArr[1] = Integer.valueOf(i);
            objArr[2] = "";
            objArr[3] = "";
            objArr[4] = Integer.valueOf(0);
            hVar.h(14872, objArr);
            return true;
        } else if (preference.mKey.equals("settings_mm_cardpackage")) {
            au.HU();
            com.tencent.mm.model.c.DT().a(aa.a.sPS, "");
            intent = new Intent();
            intent.putExtra("key_from_scene", 22);
            x.i("MicroMsg.MoreTabUI", "enter to cardhome");
            d.b(getContext(), "card", ".ui.CardHomePageUI", intent);
            return true;
        } else if (preference.mKey.equals("settings_my_album")) {
            au.HU();
            if (com.tencent.mm.model.c.isSDCardAvailable()) {
                au.HU();
                str = (String) com.tencent.mm.model.c.DT().get(2, null);
                Intent intent3 = new Intent();
                intent3.putExtra("sns_userName", str);
                intent3.setFlags(536870912);
                intent3.addFlags(67108864);
                au.HU();
                i = ai.g((Integer) com.tencent.mm.model.c.DT().get(68389, null));
                au.HU();
                com.tencent.mm.model.c.DT().set(68389, Integer.valueOf(i + 1));
                d.b(getContext(), "sns", ".ui.SnsUserUI", intent3);
                return true;
            }
            s.gH(getContext());
            return true;
        } else if (preference.mKey.equals("settings_mm_favorite")) {
            h.mEJ.k(10958, "8");
            h.mEJ.h(14103, new Object[]{Integer.valueOf(0)});
            com.tencent.mm.plugin.fav.a.b.a(getContext(), ".ui.FavoriteIndexUI", new Intent());
            intent = new Intent();
            intent.setComponent(new ComponentName(i.thA, "com.tencent.mm.booter.MMReceivers$ToolsProcessReceiver"));
            intent.putExtra("tools_process_action_code_key", "com.tencent.mm.intent.ACTION_START_TOOLS_PROCESS");
            sendBroadcast(intent);
            return true;
        } else if (preference.mKey.equals("settings_emoji_store")) {
            h.mEJ.k(10958, "7");
            c.Cp().aV(262147, 266244);
            c.Cp().aV(262149, 266244);
            intent = new Intent();
            intent.putExtra("preceding_scence", 2);
            d.b(getContext(), "emoji", ".ui.v2.EmojiStoreV2UI", intent);
            h.mEJ.h(12065, new Object[]{Integer.valueOf(1)});
            ((com.tencent.mm.plugin.boots.a.c) g.l(com.tencent.mm.plugin.boots.a.c.class)).ch(com.tencent.mm.plugin.boots.a.b.hjv, 881);
            return true;
        } else if (preference.mKey.equals("more_setting")) {
            aU = c.Cp().aT(262145, 266242);
            c.Cp().aV(262145, 266242);
            c.Cp().aV(262157, 266261);
            c.Cp().aV(262158, 266264);
            c.Cp().b(aa.a.sZC, 266264);
            d.b(getContext(), "setting", ".ui.setting.SettingsUI", new Intent());
            au.HU();
            int intValue = ((Integer) com.tencent.mm.model.c.DT().get(aa.a.sWf, Integer.valueOf(0))).intValue();
            au.HU();
            i = ((Integer) com.tencent.mm.model.c.DT().get(aa.a.sWg, Integer.valueOf(0))).intValue();
            if (aU || intValue <= i) {
                return true;
            }
            au.HU();
            com.tencent.mm.model.c.DT().a(aa.a.sWg, Integer.valueOf(intValue));
            IconPreference iconPreference = (IconPreference) fVar.ZZ("more_setting");
            if (iconPreference != null) {
                iconPreference.Et(8);
            }
            c.Cp().aV(266260, 266241);
            return true;
        } else if (preference.mKey.equals("more_uishow")) {
            g.l(com.tencent.mm.plugin.al.a.a.a.class);
            getContext();
            intent = new Intent();
            return true;
        } else if (!preference.mKey.equals("settings_privacy_agreements")) {
            return false;
        } else {
            com.tencent.mm.platformtools.a.b(getActivity(), getString(j.license_read_url, new Object[]{w.chP(), g.Ei().DT().get(274436, null), "setting", Integer.valueOf(0), Integer.valueOf(0)}), 0, true);
            return true;
        }
    }

    private void cqG() {
        if (d.QS("sns")) {
            this.eOE.bw("settings_my_album", false);
        } else {
            this.eOE.bw("settings_my_album", true);
        }
    }

    private void cqH() {
        com.tencent.mm.plugin.card.c.b bVar = (com.tencent.mm.plugin.card.c.b) g.l(com.tencent.mm.plugin.card.c.b.class);
        if (bVar == null || !((bVar.axz() || bVar.axA()) && d.QS("card"))) {
            this.eOE.bw("settings_mm_cardpackage", true);
            return;
        }
        CharSequence axB;
        String str = "";
        if (bVar != null) {
            axB = bVar.axB();
        } else {
            Object axB2 = str;
        }
        boolean aU = c.Cp().aU(262152, 266256);
        boolean aT = c.Cp().aT(262152, 266256);
        boolean a = c.Cp().a(aa.a.sPM, aa.a.sPO);
        boolean a2 = c.Cp().a(aa.a.sPN, aa.a.sPP);
        this.eOE.bw("settings_mm_cardpackage", false);
        final IconPreference iconPreference = (IconPreference) this.eOE.ZZ("settings_mm_cardpackage");
        if (iconPreference != null) {
            iconPreference.setTitle(R.l.settings_mm_card_package_new);
            if (aT) {
                iconPreference.Er(0);
                iconPreference.dk(getString(R.l.app_new), R.g.new_tips_bg);
                iconPreference.Et(8);
                iconPreference.setSummary(null);
                iconPreference.V(null);
                iconPreference.Ev(8);
                iconPreference.dl("", -1);
                iconPreference.Es(8);
                return;
            }
            au.HU();
            str = (String) com.tencent.mm.model.c.DT().get(aa.a.sPV, "");
            if (!a2 || TextUtils.isEmpty(str)) {
                iconPreference.V(null);
                iconPreference.Ev(8);
            } else {
                int dimensionPixelOffset = getResources().getDimensionPixelOffset(R.f.card_entrance_icon_height);
                com.tencent.mm.ak.a.a.c.a aVar = new com.tencent.mm.ak.a.a.c.a();
                aVar.dXB = e.bnE;
                o.Pk();
                aVar.dXU = null;
                aVar.dXy = true;
                aVar.dXW = true;
                aVar.dXw = true;
                aVar.dXF = dimensionPixelOffset;
                aVar.dXE = dimensionPixelOffset;
                o.Pj().a(str, iconPreference.kYT, aVar.Pt(), new com.tencent.mm.ak.a.c.g() {
                    public final void me(String str) {
                        ah.A(new 1(this));
                    }

                    public final Bitmap a(String str, com.tencent.mm.ak.a.d.b bVar) {
                        return null;
                    }

                    public final void a(String str, View view, com.tencent.mm.ak.a.d.b bVar) {
                        if (bVar.bitmap != null) {
                            ah.A(new 2(this, bVar.bitmap));
                        } else {
                            ah.A(new 3(this));
                        }
                    }
                });
            }
            if (aU) {
                iconPreference.Et(0);
            } else {
                iconPreference.Et(8);
            }
            if (a) {
                iconPreference.dk("", -1);
                iconPreference.Er(8);
                if (a2) {
                    iconPreference.setSummary(null);
                    if (ai.oW(axB2)) {
                        iconPreference.dl("", -1);
                        iconPreference.Es(8);
                        return;
                    }
                    iconPreference.ao(axB2, -1, getResources().getColor(R.e.hint_text_color));
                    iconPreference.Es(0);
                    return;
                }
                iconPreference.dl("", -1);
                iconPreference.Es(8);
                if (ai.oW(axB2)) {
                    iconPreference.setSummary(null);
                    return;
                } else {
                    iconPreference.setSummary(axB2);
                    return;
                }
            }
            iconPreference.Es(8);
            iconPreference.Er(8);
            iconPreference.setSummary(null);
        }
    }

    private void cqI() {
        this.eOE.bw("more_setting", false);
        IconPreference iconPreference = (IconPreference) this.eOE.ZZ("more_setting");
        if (iconPreference != null) {
            iconPreference.Ew(8);
            boolean aT = c.Cp().aT(262145, 266242);
            if (aT) {
                iconPreference.Er(0);
                iconPreference.dk(getString(R.l.app_new), R.g.new_tips_bg);
            } else {
                iconPreference.Er(8);
                iconPreference.dk("", -1);
            }
            au.HU();
            if (((Integer) com.tencent.mm.model.c.DT().get(9, Integer.valueOf(0))).intValue() != 0) {
                if (q.GN()) {
                    iconPreference.setSummary("");
                } else {
                    iconPreference.setSummary(R.l.safe_device_account_state_unsafe_in_setting);
                }
            }
            iconPreference.Et(8);
            if (!aT) {
                au.HU();
                int intValue = ((Integer) com.tencent.mm.model.c.DT().get(aa.a.sWf, Integer.valueOf(0))).intValue();
                au.HU();
                int intValue2 = ((Integer) com.tencent.mm.model.c.DT().get(aa.a.sWg, Integer.valueOf(0))).intValue();
                if ((((com.tencent.mm.plugin.welab.a.a.c) g.l(com.tencent.mm.plugin.welab.a.a.c.class)).bYN() || ((com.tencent.mm.plugin.welab.a.a.c) g.l(com.tencent.mm.plugin.welab.a.a.c.class)).bYO() || intValue > intValue2) && !aT) {
                    iconPreference.Et(0);
                    iconPreference.Er(8);
                    iconPreference.dk("", -1);
                    return;
                }
                iconPreference.Et(8);
                if (c.Cp().aU(262157, 266261)) {
                    iconPreference.Et(0);
                    iconPreference.Er(8);
                    iconPreference.dk("", -1);
                    return;
                }
                iconPreference.Et(8);
                if (c.Cp().aU(262158, 266264)) {
                    iconPreference.Et(0);
                    iconPreference.Er(8);
                    iconPreference.dk("", -1);
                } else if (c.Cp().a(aa.a.sZC, 266264)) {
                    iconPreference.Et(0);
                } else {
                    boolean booleanValue;
                    iconPreference.Et(8);
                    au.HU();
                    if ((com.tencent.mm.model.c.DT().getInt(40, 0) & 131072) == 0) {
                        aT = true;
                    } else {
                        aT = false;
                    }
                    if (bi.getInt(com.tencent.mm.k.g.AT().getValue("VoiceprintEntry"), 0) == 1) {
                        au.HU();
                        booleanValue = ((Boolean) com.tencent.mm.model.c.DT().get(aa.a.sPp, Boolean.valueOf(true))).booleanValue();
                    } else {
                        booleanValue = false;
                    }
                    if (booleanValue && r2) {
                        x.i("MicroMsg.MoreTabUI", "show voiceprint dot");
                        iconPreference.Et(0);
                        return;
                    }
                    iconPreference.Et(8);
                    bh Do = com.tencent.mm.plugin.ab.a.bjj().Do(com.tencent.mm.ao.b.ebm);
                    if (Do == null || Do.field_isExit) {
                        com.tencent.mm.plugin.ab.a.bjk();
                        if (com.tencent.mm.ao.c.ig(com.tencent.mm.ao.b.ebm)) {
                            iconPreference.Et(0);
                            iconPreference.Er(8);
                            iconPreference.dk("", -1);
                            return;
                        }
                        return;
                    }
                    com.tencent.mm.plugin.ab.a.bji().ebC = new 3(this, iconPreference);
                }
            }
        }
    }

    private void cqJ() {
        if (d.QS("emoji")) {
            d.cfH();
            this.eOE.bw("settings_emoji_store", false);
            boolean aT = c.Cp().aT(262147, 266244);
            boolean aT2 = c.Cp().aT(262149, 266244);
            IconPreference iconPreference = (IconPreference) this.eOE.ZZ("settings_emoji_store");
            if (iconPreference != null) {
                if (aT) {
                    iconPreference.Er(0);
                    iconPreference.dk(getString(R.l.app_new), R.g.new_tips_bg);
                } else if (aT2) {
                    iconPreference.Er(0);
                    iconPreference.dk(getString(R.l.app_free), R.g.new_tips_bg);
                } else {
                    iconPreference.Er(8);
                    iconPreference.dk("", -1);
                }
                if (aT2 || aT) {
                    au.HU();
                    o.Pj().a((String) com.tencent.mm.model.c.DT().get(229633, null), iconPreference.kYT, new 5(this, iconPreference));
                    return;
                }
                iconPreference.Ev(8);
                return;
            }
            return;
        }
        this.eOE.bw("settings_emoji_store", false);
    }

    private void cqK() {
        boolean GO = q.GO();
        x.d("MicroMsg.MoreTabUI", "wallet status: is open" + GO);
        this.eOE.bw("settings_mm_wallet", !GO);
        this.tCL.notifyDataSetChanged();
    }

    private void cqL() {
        au.HU();
        int g = ai.g((Integer) com.tencent.mm.model.c.DT().get(204820, null));
        au.HU();
        int g2 = g + ai.g((Integer) com.tencent.mm.model.c.DT().get(204817, null));
        boolean aT = c.Cp().aT(262156, 266248);
        int aU = c.Cp().aU(262156, 266248);
        boolean b = c.Cp().b(aa.a.sYc, aa.a.sYe);
        au.HU();
        String str = (String) com.tencent.mm.model.c.DT().get(aa.a.sYf, "");
        IconPreference iconPreference = (IconPreference) this.eOE.ZZ("settings_mm_wallet");
        if (iconPreference != null) {
            int i;
            x.d("MicroMsg.MoreTabUI", "isShowNew : " + aT);
            x.d("MicroMsg.MoreTabUI", "isShowDot : " + aU);
            au.HU();
            String str2 = (String) com.tencent.mm.model.c.DT().get(aa.a.sXL, "");
            au.HU();
            int intValue = ((Integer) com.tencent.mm.model.c.DT().get(aa.a.sXM, Integer.valueOf(-1))).intValue();
            if (aT || aU != 0) {
                au.HU();
                long longValue = ((Long) com.tencent.mm.model.c.DT().get(aa.a.sXJ, Long.valueOf(-1))).longValue();
                long oX = ai.oX(com.tencent.mm.k.g.AT().getValue("PayWalletRedDotExpire"));
                long j = 86400000 * oX;
                x.i("MicroMsg.MoreTabUI", "pushTick: %s, expireTime: %s, expireTick: %s, currentTick: %s, passDay: %s", new Object[]{Long.valueOf(longValue), Long.valueOf(oX), Long.valueOf(j), Long.valueOf(System.currentTimeMillis()), Double.valueOf((((double) System.currentTimeMillis()) - ((double) longValue)) / 8.64E7d)});
                if (longValue > 0 && oX > 0 && r20 >= ((double) oX)) {
                    aT = false;
                    c.Cp().u(262156, false);
                    aU = 0;
                }
            }
            g.Ek();
            boolean booleanValue = aU | ((Boolean) g.Ei().DT().get(aa.a.sZu, Boolean.valueOf(false))).booleanValue();
            g.Ek();
            String str3 = (String) g.Ei().DT().get(aa.a.sZs, "");
            x.i("MicroMsg.MoreTabUI", "after check, isShowNew: %s, isShowDot: %s, walletEntryWording: %s", new Object[]{Boolean.valueOf(aT), Boolean.valueOf(booleanValue), str3});
            x.d("MicroMsg.MoreTabUI", "bankcardDot : " + b);
            if (b) {
                if (bi.oW(str)) {
                    iconPreference.dl("", -1);
                    iconPreference.Es(8);
                    iconPreference.Et(0);
                } else {
                    iconPreference.Es(0);
                    iconPreference.ao(str, -1, -7566196);
                    iconPreference.lN(true);
                    iconPreference.Et(8);
                }
            } else if (aT) {
                iconPreference.Er(0);
                iconPreference.dk(getString(R.l.app_new), R.g.new_tips_bg);
                iconPreference.Et(8);
            } else if (g2 > 99) {
                iconPreference.Er(0);
                iconPreference.dk(getString(R.l.tab_msg_tip_over), r.hd(getContext()));
                iconPreference.Et(8);
            } else if (g2 > 0) {
                iconPreference.Er(0);
                iconPreference.dk(String.valueOf(g2), r.hd(getContext()));
                iconPreference.Et(8);
            } else if (booleanValue) {
                iconPreference.dk("", -1);
                iconPreference.Er(8);
                iconPreference.Et(0);
            } else if (intValue == 1) {
                iconPreference.dk("", -1);
                iconPreference.Er(8);
                iconPreference.Es(0);
                iconPreference.lN(true);
                if (!ai.oW(str2)) {
                    iconPreference.ao(str2, -1, Color.parseColor("#888888"));
                }
                iconPreference.Ew(8);
            } else {
                iconPreference.dk("", -1);
                iconPreference.Er(8);
                iconPreference.Et(8);
                iconPreference.Es(8);
                iconPreference.dl("", -1);
            }
            if (ai.oW(str3) || !booleanValue) {
                iconPreference.setSummary("");
            } else {
                iconPreference.setSummary(str3);
            }
            h hVar = h.mEJ;
            Object[] objArr = new Object[5];
            objArr[0] = Integer.valueOf(6);
            if (booleanValue) {
                i = 1;
            } else {
                i = 0;
            }
            objArr[1] = Integer.valueOf(i);
            objArr[2] = "";
            objArr[3] = "";
            objArr[4] = Integer.valueOf(1);
            hVar.h(14872, objArr);
        }
    }

    public final void a(int i, m mVar, Object obj) {
        int bc = ai.bc(obj);
        x.d("MicroMsg.MoreTabUI", "onNotifyChange event:%d obj:%d stg:%s", new Object[]{Integer.valueOf(i), Integer.valueOf(bc), mVar});
        au.HU();
        if (mVar != com.tencent.mm.model.c.DT() || bc <= 0) {
            x.e("MicroMsg.MoreTabUI", "onNotifyChange error obj:%d stg:%s", new Object[]{Integer.valueOf(bc), mVar});
        } else if (204817 == bc || 204820 == bc) {
            cqL();
        } else if (40 == bc) {
            cqK();
        } else if ("208899".equals(Integer.valueOf(i))) {
            cqJ();
        }
    }

    protected final void coy() {
        this.eOE = this.tCL;
    }

    protected final void coz() {
        this.eOE = this.tCL;
        au.HU();
        com.tencent.mm.model.c.DT().a(this);
        c.Cp().a(this.mUs);
        this.eOE.bw("more_tab_setting_personal_info", false);
        AccountInfoPreference accountInfoPreference = (AccountInfoPreference) this.tCL.ZZ("more_tab_setting_personal_info");
        String GG = q.GG();
        if (ai.oW(GG)) {
            GG = q.GF();
            if (com.tencent.mm.storage.ab.XT(GG)) {
                accountInfoPreference.qOp = null;
            } else {
                accountInfoPreference.qOp = GG;
            }
        } else {
            accountInfoPreference.qOp = GG;
        }
        accountInfoPreference.userName = q.GF();
        CharSequence GH = q.GH();
        if (ai.oW(GH)) {
            GH = q.GF();
        }
        accountInfoPreference.qOo = com.tencent.mm.pluginsdk.ui.d.j.a(getContext(), GH);
        ((AccountInfoPreference) this.eOE.ZZ("more_tab_setting_personal_info")).qOr = new 4(this);
        IconPreference iconPreference = (IconPreference) this.eOE.ZZ("settings_my_address");
        if (iconPreference != null) {
            int clP = com.tencent.mm.az.d.SF().clP();
            if (clP > 0) {
                iconPreference.Er(0);
                iconPreference.dk(String.valueOf(clP), R.g.new_tips_bg);
            } else {
                iconPreference.Er(8);
                iconPreference.dk("", -1);
            }
        }
        cqG();
        cqJ();
        cqI();
        if (d.QS("favorite")) {
            this.eOE.bw("settings_mm_favorite", false);
        } else {
            this.eOE.bw("settings_mm_favorite", true);
        }
        cqL();
        cqK();
        cqH();
        if (g.Ee().k(com.tencent.mm.plugin.al.a.a.class)) {
            this.eOE.bw("more_uishow", false);
        } else {
            this.eOE.bw("more_uishow", true);
        }
        Preference ZZ = this.eOE.ZZ("settings_privacy_agreements");
        if (com.tencent.mm.al.b.ml((String) g.Ei().DT().get(274436, null))) {
            Object string = getString(com.tencent.mm.plugin.setting.a.i.privacy_detail);
            CharSequence newSpannable = Factory.getInstance().newSpannable(string);
            newSpannable.setSpan(new ForegroundColorSpan(getResources().getColor(com.tencent.mm.plugin.setting.a.c.link_color)), newSpannable.length() - string.length(), newSpannable.length(), 33);
            ZZ.setTitle(newSpannable);
            this.eOE.bw("settings_privacy_agreements", false);
        } else {
            this.eOE.bw("settings_privacy_agreements", true);
        }
        this.eOE.notifyDataSetChanged();
        View findViewById = findViewById(R.h.loading_tips_area);
        if (findViewById != null && findViewById.getVisibility() != 8) {
            new ag(Looper.getMainLooper()).post(new 6(this, findViewById));
        }
    }

    protected final void coA() {
    }

    protected final void coB() {
        c.Cp().b(this.mUs);
        au.HU();
        com.tencent.mm.model.c.DT().b(this);
    }

    protected final void coC() {
    }

    protected final void coD() {
    }

    public final void coF() {
    }

    public final void coG() {
    }

    public final void coI() {
    }

    public final void cpr() {
    }

    public final void cps() {
    }
}
