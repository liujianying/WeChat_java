package com.tencent.mm.plugin.profile.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Looper;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.a.o;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.bg.d;
import com.tencent.mm.g.a.ap;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.am;
import com.tencent.mm.model.au;
import com.tencent.mm.model.m;
import com.tencent.mm.model.q;
import com.tencent.mm.model.r;
import com.tencent.mm.openim.a.b$a;
import com.tencent.mm.openim.a.c$b;
import com.tencent.mm.plugin.account.b;
import com.tencent.mm.plugin.account.friend.a.ao;
import com.tencent.mm.plugin.game.f$k;
import com.tencent.mm.plugin.sns.b.h$a;
import com.tencent.mm.plugin.sns.b.n;
import com.tencent.mm.pluginsdk.b.a;
import com.tencent.mm.pluginsdk.ui.d.j;
import com.tencent.mm.pluginsdk.ui.preference.NormalUserHeaderPreference;
import com.tencent.mm.protocal.c.bqd;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.f;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.aa;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.at;
import com.tencent.mm.storage.u;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.preference.KeyValuePreference;
import com.tencent.mm.ui.base.preference.PreferenceSmallCategory;
import com.tencent.mm.ui.base.preference.PreferenceTitleCategory;
import com.tencent.mm.ui.base.preference.TextPreference;
import com.tencent.mm.ui.base.s;
import junit.framework.Assert;
import org.json.JSONObject;

@f(chx = {ContactInfoUI.class})
public final class k implements e, h$a, a {
    String bHY = null;
    private int bNv = 0;
    Activity bOb;
    int eLK;
    private com.tencent.mm.ui.base.preference.f eOE;
    ab guS;
    u hLB;
    String hMQ;
    private String juZ;
    private String kiv;
    private boolean lUD;
    private boolean lUE;
    private int lWd;
    private bqd lWj = new bqd();
    private boolean lWk;
    private String lWl = "";
    private int lWm = -1;
    private boolean lWn = false;
    private boolean lWo = false;
    private String lWp;
    private boolean lWq = false;
    private boolean lWr = false;
    private String lWs = null;
    private String lWt = null;
    private int lWu;
    String lWv;
    c<ap> lWw = new 3(this);

    public k(Activity activity) {
        this.bOb = activity;
    }

    public final boolean wX(String str) {
        Intent intent;
        if (str.equals("contact_info_sns")) {
            au.HU();
            if (com.tencent.mm.model.c.isSDCardAvailable()) {
                intent = this.bOb.getIntent();
                intent.putExtra("sns_source", this.bNv);
                intent.putExtra("sns_signature", this.guS.signature);
                intent.putExtra("sns_nickName", this.guS.BK());
                intent.putExtra("sns_title", this.guS.BL());
                if (n.nkC != null) {
                    intent = n.nkC.e(intent, this.guS.field_username);
                }
                if (intent == null) {
                    ((MMActivity) this.bOb).finish();
                } else {
                    d.b(this.bOb, "sns", ".ui.SnsUserUI", intent);
                    if ((intent.getFlags() & 67108864) != 0) {
                        ((MMActivity) this.bOb).finish();
                    }
                }
            } else {
                s.gH(this.bOb);
                return true;
            }
        }
        String stringExtra;
        long longExtra;
        String stringExtra2;
        if (str.equals("contact_info_more")) {
            Intent intent2 = new Intent();
            intent2.setClass(this.bOb, ContactMoreInfoUI.class);
            intent2.putExtra("Is_RoomOwner", this.bOb.getIntent().getBooleanExtra("Is_RoomOwner", false));
            intent2.putExtra("Contact_User", this.guS.field_username);
            intent2.putExtra("KLinkedInAddFriendNickName", this.lWs);
            intent2.putExtra("KLinkedInAddFriendPubUrl", this.lWt);
            stringExtra = this.bOb.getIntent().getStringExtra("room_name");
            if (stringExtra == null) {
                stringExtra = this.bOb.getIntent().getStringExtra("Contact_ChatRoomId");
            }
            intent2.putExtra("Contact_ChatRoomId", stringExtra);
            intent2.putExtra("verify_gmail", this.kiv);
            intent2.putExtra("profileName", this.lWp);
            longExtra = this.bOb.getIntent().getLongExtra("Contact_Uin", 0);
            stringExtra = this.bOb.getIntent().getStringExtra("Contact_QQNick");
            intent2.putExtra("Contact_Uin", longExtra);
            intent2.putExtra("Contact_QQNick", stringExtra);
            this.bOb.startActivity(intent2);
        } else if (str.equals("contact_info_social")) {
            intent = new Intent();
            intent.setClass(this.bOb, ContactSocialInfoUI.class);
            intent.putExtra("Contact_User", this.guS.field_username);
            longExtra = this.bOb.getIntent().getLongExtra("Contact_Uin", 0);
            stringExtra2 = this.bOb.getIntent().getStringExtra("Contact_QQNick");
            intent.putExtra("Contact_Uin", longExtra);
            intent.putExtra("Contact_QQNick", stringExtra2);
            intent.putExtra("profileName", this.lWp);
            intent.putExtra("verify_gmail", this.kiv);
            stringExtra2 = this.bOb.getIntent().getStringExtra("Contact_Mobile_MD5");
            String stringExtra3 = this.bOb.getIntent().getStringExtra("Contact_full_Mobile_MD5");
            intent.putExtra("Contact_Mobile_MD5", stringExtra2);
            intent.putExtra("Contact_full_Mobile_MD5", stringExtra3);
            this.bOb.startActivity(intent);
        } else if (str.equals("contact_info_invite_source")) {
            stringExtra = ((KeyValuePreference) this.eOE.ZZ("contact_info_invite_source")).getExtras().getString("inviteer");
            if (!bi.oW(stringExtra)) {
                stringExtra2 = gT(stringExtra);
                Intent intent3 = new Intent();
                intent3.putExtra("Contact_User", stringExtra);
                intent3.putExtra("Contact_RemarkName", stringExtra2);
                intent3.putExtra("Contact_RoomNickname", stringExtra2);
                intent3.putExtra("Contact_RoomMember", true);
                intent3.putExtra("room_name", this.hMQ);
                au.HU();
                intent3.putExtra("Contact_Nick", com.tencent.mm.model.c.FR().Yg(stringExtra).field_nickname);
                intent3.putExtra("Contact_Scene", 14);
                intent3.putExtra("Is_RoomOwner", true);
                intent3.putExtra("Contact_ChatRoomId", this.hMQ);
                com.tencent.mm.plugin.profile.a.ezn.d(intent3, this.bOb);
            }
        }
        return true;
    }

    final void JG(String str) {
        if (bi.oW(str)) {
            x.w("MicroMsg.ContactWidgetNormal", "view stranger remark, username is null");
            return;
        }
        Intent intent = new Intent();
        intent.putExtra("Contact_Scene", this.eLK);
        intent.putExtra("Contact_mode_name_type", 0);
        intent.putExtra("Contact_ModStrangerRemark", true);
        intent.putExtra("Contact_User", this.guS.field_username);
        intent.putExtra("Contact_Nick", this.guS.field_nickname);
        intent.putExtra("Contact_RemarkName", this.guS.field_conRemark);
        com.tencent.mm.plugin.profile.a.ezn.o(intent, this.bOb);
    }

    public final boolean a(com.tencent.mm.ui.base.preference.f fVar, ab abVar, boolean z, int i) {
        boolean z2;
        boolean z3 = false;
        Assert.assertTrue(abVar != null);
        if (bi.oV(abVar.field_username).length() > 0) {
            z2 = true;
        } else {
            z2 = false;
        }
        Assert.assertTrue(z2);
        if (fVar != null) {
            z2 = true;
        } else {
            z2 = false;
        }
        Assert.assertTrue(z2);
        this.eOE = fVar;
        this.guS = abVar;
        this.lUD = z;
        this.eLK = i;
        this.lUE = this.bOb.getIntent().getBooleanExtra("User_Verify", false);
        this.juZ = bi.oV(this.bOb.getIntent().getStringExtra("Verify_ticket"));
        this.lWk = this.bOb.getIntent().getBooleanExtra("Contact_IsLBSFriend", false);
        this.lWd = this.bOb.getIntent().getIntExtra("Kdel_from", -1);
        this.lWl = this.bOb.getIntent().getStringExtra("Contact_RemarkName");
        this.bNv = this.bOb.getIntent().getIntExtra("Sns_from_Scene", 0);
        this.lWn = this.bOb.getIntent().getBooleanExtra("Contact_NeedShowChangeRemarkButton", false);
        this.lWo = this.bOb.getIntent().getBooleanExtra("Contact_NeedShowChangeSnsPreButton", false);
        this.lWm = this.bOb.getIntent().getIntExtra("Contact_KSnsIFlag", -1);
        long longExtra = this.bOb.getIntent().getLongExtra("Contact_KSnsBgId", -1);
        String aG = bi.aG(this.bOb.getIntent().getStringExtra("Contact_KSnsBgUrl"), "");
        this.kiv = bi.aG(this.bOb.getIntent().getStringExtra("verify_gmail"), "");
        this.lWp = bi.aG(this.bOb.getIntent().getStringExtra("profileName"), bi.Xe(this.kiv));
        this.lWj.eJS = this.lWm;
        this.lWj.eJU = longExtra;
        this.lWj.eJT = aG;
        this.lWs = this.bOb.getIntent().getStringExtra("KLinkedInAddFriendNickName");
        this.lWt = this.bOb.getIntent().getStringExtra("KLinkedInAddFriendPubUrl");
        if (n.nky != null) {
            this.lWj = n.nky.b(abVar.field_username, this.lWj);
        }
        this.hMQ = this.bOb.getIntent().getStringExtra("room_name");
        au.HU();
        this.hLB = com.tencent.mm.model.c.Ga().ih(this.hMQ);
        this.lWr = abVar.field_deleteFlag == 1;
        bnp();
        au.HU();
        com.tencent.mm.model.c.FR().Yc(abVar.field_username);
        z2 = q.GF().equals(abVar.field_username);
        x.v("MicroMsg.ContactWidgetNormal", "get from extinfo %s", new Object[]{Integer.valueOf(this.lWj.eJS)});
        if ((this.lWj.eJS & 1) > 0) {
            z3 = true;
        }
        if (!(abVar.BA() || ab.XP(abVar.field_username) || !z3 || n.nkC == null)) {
            n.nkC.a(2, abVar.field_username, z2, this.bNv);
        }
        return true;
    }

    private void bnp() {
        String stringExtra;
        String stringExtra2;
        String str;
        String str2;
        int i;
        int i2;
        KeyValuePreference keyValuePreference;
        String str3 = null;
        auw();
        this.eOE.removeAll();
        this.eOE.addPreferencesFromResource(R.o.contact_info_pref_normal);
        if (n.nkC != null) {
            n.nkC.a(3, this.guS.field_username, this);
        }
        au.DF().a(30, this);
        au.DF().a(453, this);
        this.lWv = "";
        x.i("MicroMsg.ContactWidgetNormal", "isCancelMatchPhoneMD5 %s", new Object[]{this.guS.BH()});
        if (!this.guS.BH()) {
            com.tencent.mm.plugin.account.friend.a.a aVar;
            stringExtra = this.bOb.getIntent().getStringExtra("Contact_Mobile_MD5");
            stringExtra2 = this.bOb.getIntent().getStringExtra("Contact_full_Mobile_MD5");
            Object[] objArr;
            if (bi.oW(stringExtra) && bi.oW(stringExtra2)) {
                if (!bi.oW(this.guS.field_username)) {
                    com.tencent.mm.plugin.account.friend.a.a pp = b.getAddrUploadStg().pp(this.guS.field_username);
                    str = "MicroMsg.ContactWidgetNormal";
                    str2 = "Contact name: %s AddrUpload IS NULL? %s";
                    objArr = new Object[2];
                    objArr[0] = this.guS.field_username;
                    objArr[1] = pp == null ? "true" : "false";
                    x.i(str, str2, objArr);
                    aVar = pp;
                }
                aVar = null;
            } else {
                if (!(bi.oW(stringExtra) && bi.oW(stringExtra2))) {
                    x.i("MicroMsg.ContactWidgetNormal", "Contact name: %s mMobileByMD5: %s mobileFullMD5:%s", new Object[]{this.guS.field_username, stringExtra, stringExtra2});
                    aVar = b.getAddrUploadStg().pq(stringExtra);
                    if (aVar == null || bi.oW(aVar.Xh())) {
                        aVar = b.getAddrUploadStg().pq(stringExtra2);
                    }
                    str = "MicroMsg.ContactWidgetNormal";
                    str2 = "Contact name: %s AddrUpload IS NULL? %s";
                    objArr = new Object[2];
                    objArr[0] = this.guS.field_username;
                    objArr[1] = aVar == null ? "true" : "false";
                    x.i(str, str2, objArr);
                }
                aVar = null;
            }
            if (!(aVar == null || bi.oW(aVar.Xh()))) {
                this.lWv = bi.oV(aVar.Xp()).replace(" ", "");
                x.i("MicroMsg.ContactWidgetNormal", "Contact name: %s mMobileByMD5: %s", new Object[]{this.guS.field_username, this.lWv});
            }
        }
        NormalUserHeaderPreference normalUserHeaderPreference = (NormalUserHeaderPreference) this.eOE.ZZ("contact_info_header_normal");
        if (normalUserHeaderPreference != null) {
            ab abVar = this.guS;
            i = this.eLK;
            str = this.juZ;
            str2 = this.lWv;
            String str4 = this.guS.csZ;
            normalUserHeaderPreference.qGi = str2;
            normalUserHeaderPreference.qGj = str4;
            normalUserHeaderPreference.a(abVar, i, str);
            normalUserHeaderPreference.bo(this.guS.field_username, this.lWn);
            normalUserHeaderPreference.qPn = new 1(this);
            if (com.tencent.mm.l.a.gd(this.guS.field_type)) {
                this.lWo = false;
            }
            normalUserHeaderPreference.bp(this.guS.field_username, this.lWo);
        } else {
            this.eOE.c(normalUserHeaderPreference);
        }
        if (ab.XR(this.guS.field_username) && this.guS.ctd != 0) {
            int indexOf = this.eOE.indexOf("contact_info_category_1");
            CharSequence i3 = ((com.tencent.mm.openim.a.b) g.l(com.tencent.mm.openim.a.b.class)).i(this.guS.field_openImAppid, "openim_custom_info_header", b$a.eui);
            if (!TextUtils.isEmpty(i3)) {
                PreferenceTitleCategory preferenceTitleCategory = new PreferenceTitleCategory(this.bOb);
                preferenceTitleCategory.setTitle(i3);
                this.eOE.a(preferenceTitleCategory, indexOf);
            }
            com.tencent.mm.openim.a.c cVar = new com.tencent.mm.openim.a.c();
            cVar.oE(this.guS.cte);
            for (com.tencent.mm.openim.a.c.a aVar2 : cVar.eul) {
                for (c$b c_b : aVar2.eum) {
                    indexOf++;
                    4 4 = new 4(this, this.bOb, c_b);
                    4.tmc = aVar2.title;
                    4.setSummary(j.a(this.bOb, c_b.oF(this.guS.field_openImAppid)));
                    this.eOE.a(4, indexOf);
                    if (c_b.action == 0 || c_b.action == 1) {
                        4.setEnabled(true);
                    } else if (c_b.action == 2) {
                        4.tDk = new 5(this, c_b, aVar2);
                    } else if (c_b.action == 3) {
                        4.tDk = new 6(this, c_b, aVar2);
                    } else if (c_b.action == 4) {
                        4.tDk = new 7(this, c_b, aVar2);
                    } else if (c_b.action == 5) {
                        4.tDk = new 8(this, c_b, aVar2);
                    }
                }
            }
            i2 = indexOf + 1;
            this.eOE.a(new PreferenceSmallCategory(this.bOb), i2);
            i = i2 + 1;
            KeyValuePreference keyValuePreference2 = new KeyValuePreference(this.bOb);
            keyValuePreference2.setTitle(R.l.contact_info_enterprise_from);
            Object i4 = ((com.tencent.mm.openim.a.b) g.l(com.tencent.mm.openim.a.b.class)).i(this.guS.field_openImAppid, "openim_intro_desc", b$a.eui);
            keyValuePreference2.setSummary(j.a(this.bOb, i4));
            Object i5 = ((com.tencent.mm.openim.a.b) g.l(com.tencent.mm.openim.a.b.class)).i(this.guS.field_openImAppid, "openim_intro_url", b$a.euj);
            if (!TextUtils.isEmpty(i5)) {
                keyValuePreference2.tDk = new 9(this, i5, i4);
            }
            this.eOE.a(keyValuePreference2, i);
        }
        if (bi.oW(this.guS.getProvince())) {
            this.eOE.aaa("contact_info_district");
        } else {
            keyValuePreference = (KeyValuePreference) this.eOE.ZZ("contact_info_district");
            if (keyValuePreference != null) {
                keyValuePreference.setTitle(this.bOb.getString(R.l.contact_info_district));
                keyValuePreference.setSummary(r.gV(this.guS.getProvince()) + (bi.oW(this.guS.getCity()) ? "" : "  " + this.guS.getCity()));
                keyValuePreference.lO(false);
                keyValuePreference.setEnabled(false);
            }
        }
        if (this.guS.signature == null || this.guS.signature.trim().equals("") || com.tencent.mm.l.a.gd(this.guS.field_type)) {
            this.eOE.aaa("contact_info_signature");
        } else {
            keyValuePreference = (KeyValuePreference) this.eOE.ZZ("contact_info_signature");
            if (keyValuePreference != null) {
                keyValuePreference.tCA = false;
                keyValuePreference.setTitle(this.bOb.getString(R.l.contact_info_signature));
                keyValuePreference.setSummary(j.a(this.bOb, this.guS.signature));
                keyValuePreference.lO(false);
            }
        }
        this.eOE.ZZ("contact_info_facebook");
        this.eOE.aaa("contact_info_facebook");
        if ((this.lWj.eJS & 1) > 0) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        if ((i2 & d.QS("sns")) == 0 || ab.XP(this.guS.field_username) || this.guS.BA()) {
            this.eOE.aaa("contact_info_sns");
        } else {
            com.tencent.mm.ui.base.preference.g gVar = (com.tencent.mm.ui.base.preference.g) this.eOE.ZZ("contact_info_sns");
            if (!(gVar == null || n.nky == null)) {
                gVar.TS(this.guS.field_username);
            }
        }
        this.eOE.aaa("contact_info_verifyuser");
        if (this.eLK == 96) {
            this.eOE.aaa("contact_info_footer_normal");
        }
        long longExtra;
        boolean z;
        if (com.tencent.mm.l.a.gd(this.guS.field_type)) {
            int[] iArr = new int[7];
            ContactMoreInfoPreference contactMoreInfoPreference = (ContactMoreInfoPreference) this.eOE.ZZ("contact_info_more");
            if (contactMoreInfoPreference != null) {
                longExtra = this.bOb.getIntent().getLongExtra("Contact_Uin", 0);
                if (longExtra == -1 || new o(longExtra).longValue() <= 0) {
                    contactMoreInfoPreference.uF(8);
                    iArr[0] = 8;
                } else {
                    contactMoreInfoPreference.uF(0);
                    iArr[0] = 0;
                }
                if (bi.oW(this.kiv) || bi.oW(this.lWp)) {
                    contactMoreInfoPreference.uH(8);
                    iArr[1] = 8;
                } else {
                    contactMoreInfoPreference.uH(0);
                    iArr[1] = 0;
                }
                stringExtra2 = com.tencent.mm.k.g.AT().getValue("LinkedinPluginClose");
                z = bi.oW(stringExtra2) || Integer.valueOf(stringExtra2).intValue() == 0;
                if (!z || bi.oW(this.guS.csV)) {
                    contactMoreInfoPreference.uG(8);
                    iArr[2] = 8;
                } else {
                    contactMoreInfoPreference.uG(0);
                    iArr[2] = 0;
                }
                if (q.GF().equals(this.guS.field_username)) {
                    au.HU();
                    stringExtra2 = (String) com.tencent.mm.model.c.DT().get(aa.a.sRy, null);
                } else {
                    stringExtra2 = this.guS.csY;
                }
                if (!bi.oW(stringExtra2)) {
                    try {
                        stringExtra2 = new JSONObject(stringExtra2).optString("ShopUrl");
                    } catch (Throwable e) {
                        x.printErrStackTrace("MicroMsg.ContactWidgetNormal", e, "", new Object[0]);
                    }
                    if (bi.oW(stringExtra2)) {
                        contactMoreInfoPreference.uI(0);
                        iArr[3] = 0;
                    } else {
                        contactMoreInfoPreference.uI(8);
                        iArr[3] = 8;
                    }
                    if (bi.oW(this.guS.signature)) {
                        iArr[4] = 0;
                    } else {
                        iArr[4] = 8;
                    }
                    if (this.guS.getSource() > 0) {
                        iArr[5] = 8;
                    } else {
                        iArr[5] = 0;
                    }
                    iArr[6] = 8;
                    this.eOE.bw("contact_info_more", false);
                }
                stringExtra2 = null;
                if (bi.oW(stringExtra2)) {
                    contactMoreInfoPreference.uI(8);
                    iArr[3] = 8;
                } else {
                    contactMoreInfoPreference.uI(0);
                    iArr[3] = 0;
                }
                if (bi.oW(this.guS.signature)) {
                    iArr[4] = 0;
                } else {
                    iArr[4] = 8;
                }
                if (this.guS.getSource() > 0) {
                    iArr[5] = 0;
                } else {
                    iArr[5] = 8;
                }
                iArr[6] = 8;
                this.eOE.bw("contact_info_more", false);
            }
            this.eOE.aaa("contact_info_social");
        } else {
            ContactSocialInfoPreference contactSocialInfoPreference = (ContactSocialInfoPreference) this.eOE.ZZ("contact_info_social");
            if (contactSocialInfoPreference != null) {
                if (bi.oW(this.lWv)) {
                    contactSocialInfoPreference.uJ(8);
                } else {
                    contactSocialInfoPreference.uJ(0);
                    this.lWu = 1;
                }
                au.HU();
                i = bi.f((Integer) com.tencent.mm.model.c.DT().get(9, null));
                longExtra = this.bOb.getIntent().getLongExtra("Contact_Uin", 0);
                str = this.bOb.getIntent().getStringExtra("Contact_QQNick");
                if (!(longExtra == 0 || i == 0)) {
                    if (str == null || str.length() == 0) {
                        ao bK = b.getQQListStg().bK(longExtra);
                        if (bK == null) {
                            bK = null;
                        }
                        if (bK != null) {
                            bK.getDisplayName();
                        }
                    }
                    if (longExtra == -1 || new o(longExtra).longValue() <= 0) {
                        contactSocialInfoPreference.uF(8);
                    } else {
                        contactSocialInfoPreference.uF(0);
                        this.lWu = 1;
                    }
                }
                if (bi.oW(this.kiv) || bi.oW(this.lWp)) {
                    contactSocialInfoPreference.uH(8);
                } else {
                    contactSocialInfoPreference.uH(0);
                    this.lWu = 1;
                }
                stringExtra2 = com.tencent.mm.k.g.AT().getValue("LinkedinPluginClose");
                z = bi.oW(stringExtra2) || Integer.valueOf(stringExtra2).intValue() == 0;
                if (!z || bi.oW(this.guS.csV)) {
                    contactSocialInfoPreference.uG(8);
                } else {
                    contactSocialInfoPreference.uG(0);
                    this.lWu = 1;
                }
                if (q.GF().equals(this.guS.field_username)) {
                    au.HU();
                    stringExtra2 = (String) com.tencent.mm.model.c.DT().get(aa.a.sRy, null);
                } else {
                    stringExtra2 = this.guS.csY;
                }
                if (!bi.oW(stringExtra2)) {
                    try {
                        str = new JSONObject(stringExtra2).optString("ShopUrl");
                    } catch (Throwable e2) {
                        x.printErrStackTrace("MicroMsg.ContactWidgetNormal", e2, "", new Object[0]);
                    }
                    x.i("MicroMsg.ContactWidgetNormal", "weiShopInfo:%s, shopUrl:%s", new Object[]{stringExtra2, str});
                    if (bi.oW(str)) {
                        contactSocialInfoPreference.uI(0);
                        this.lWu = 1;
                    } else {
                        contactSocialInfoPreference.uI(8);
                    }
                    if (this.lWu == 0) {
                        this.eOE.aaa("contact_info_social");
                    }
                }
                str = null;
                x.i("MicroMsg.ContactWidgetNormal", "weiShopInfo:%s, shopUrl:%s", new Object[]{stringExtra2, str});
                if (bi.oW(str)) {
                    contactSocialInfoPreference.uI(8);
                } else {
                    contactSocialInfoPreference.uI(0);
                    this.lWu = 1;
                }
                if (this.lWu == 0) {
                    this.eOE.aaa("contact_info_social");
                }
            }
            this.eOE.aaa("contact_info_more");
        }
        if (com.tencent.mm.l.a.gd(this.guS.field_type)) {
            this.eOE.aaa("contact_info_source");
        } else {
            i = this.bOb.getIntent().getIntExtra("Contact_Source_FMessage", 0);
            x.d("MicroMsg.ContactWidgetNormal", "initFriendSource, contact source = " + this.guS.getSource() + ", sourceFMessage = " + i);
            if (i != 0) {
                keyValuePreference = (KeyValuePreference) this.eOE.ZZ("contact_info_source");
                if (this.lUE) {
                    switch (i) {
                        case 1:
                            if (keyValuePreference != null) {
                                keyValuePreference.tCA = false;
                                keyValuePreference.setTitle(this.bOb.getString(R.l.contact_info_source_title));
                                keyValuePreference.setSummary(R.l.contact_info_source_by_search_qq_passive);
                                keyValuePreference.lO(false);
                                break;
                            }
                            break;
                        case 3:
                            if (keyValuePreference != null) {
                                keyValuePreference.tCA = false;
                                keyValuePreference.setTitle(this.bOb.getString(R.l.contact_info_source_title));
                                keyValuePreference.setSummary(R.l.contact_info_source_by_search_wechat_passive);
                                keyValuePreference.lO(false);
                                break;
                            }
                            break;
                        case 4:
                        case 12:
                            if (keyValuePreference != null) {
                                keyValuePreference.tCA = false;
                                keyValuePreference.setTitle(this.bOb.getString(R.l.contact_info_source_title));
                                keyValuePreference.setSummary(this.bOb.getString(R.l.fmessage_come_from_qq));
                                keyValuePreference.lO(false);
                                break;
                            }
                            break;
                        case 8:
                        case 14:
                            if (keyValuePreference != null) {
                                keyValuePreference.tCA = false;
                                keyValuePreference.setTitle(this.bOb.getString(R.l.contact_info_source_title));
                                at YN = com.tencent.mm.az.d.SE().YN(this.guS.field_username);
                                au.HU();
                                ab Yg = com.tencent.mm.model.c.FR().Yg(YN == null ? "" : YN.field_chatroomName);
                                if (Yg != null) {
                                    str3 = Yg.field_nickname;
                                }
                                if (bi.oW(str3)) {
                                    keyValuePreference.setSummary(R.l.contact_info_source_by_chatroom_passive);
                                } else {
                                    keyValuePreference.setSummary(this.bOb.getString(R.l.contact_info_source_by_chatroom_to_add_passive, new Object[]{str3}));
                                }
                                keyValuePreference.lO(false);
                                break;
                            }
                            break;
                        case 10:
                        case 13:
                            if (keyValuePreference != null) {
                                keyValuePreference.tCA = false;
                                keyValuePreference.setTitle(this.bOb.getString(R.l.contact_info_source_title));
                                keyValuePreference.setSummary(R.l.contact_info_source_by_view_address_book_passive);
                                keyValuePreference.lO(false);
                                break;
                            }
                            break;
                        case 15:
                            if (keyValuePreference != null) {
                                keyValuePreference.tCA = false;
                                keyValuePreference.setTitle(this.bOb.getString(R.l.contact_info_source_title));
                                keyValuePreference.setSummary(R.l.contact_info_source_by_search_mobile_passive);
                                keyValuePreference.lO(false);
                                break;
                            }
                            break;
                        case 17:
                            if (keyValuePreference != null) {
                                keyValuePreference.tCA = false;
                                keyValuePreference.setTitle(this.bOb.getString(R.l.contact_info_source_title));
                                stringExtra2 = r.gT(this.bOb.getIntent().getStringExtra("source_from_user_name"));
                                if (bi.oW(stringExtra2)) {
                                    stringExtra2 = this.bOb.getIntent().getStringExtra("source_from_nick_name");
                                }
                                if (bi.oW(stringExtra2)) {
                                    keyValuePreference.setSummary(R.l.contact_info_source_by_card_passive);
                                } else {
                                    keyValuePreference.setSummary(j.a(this.bOb, this.bOb.getString(R.l.contact_info_source_by_card_before_verify_passive, new Object[]{stringExtra2})));
                                }
                                keyValuePreference.lO(false);
                                break;
                            }
                            break;
                        case 18:
                            if (keyValuePreference != null) {
                                keyValuePreference.tCA = false;
                                keyValuePreference.setTitle(this.bOb.getString(R.l.contact_info_source_title));
                                keyValuePreference.setSummary(R.l.contact_info_source_by_lbs_passive);
                                keyValuePreference.lO(false);
                                break;
                            }
                            break;
                        case 25:
                            if (keyValuePreference != null) {
                                keyValuePreference.tCA = false;
                                keyValuePreference.setTitle(this.bOb.getString(R.l.contact_info_source_title));
                                keyValuePreference.setSummary(R.l.contact_info_source_by_bottle_passive);
                                keyValuePreference.lO(false);
                                break;
                            }
                            break;
                        case 30:
                            if (keyValuePreference != null) {
                                keyValuePreference.tCA = false;
                                keyValuePreference.setTitle(this.bOb.getString(R.l.contact_info_source_title));
                                keyValuePreference.setSummary(R.l.contact_info_source_by_qrcode_passive);
                                keyValuePreference.lO(false);
                                break;
                            }
                            break;
                        case f$k.AppCompatTheme_homeAsUpIndicator /*48*/:
                            if (keyValuePreference != null) {
                                keyValuePreference.tCA = false;
                                keyValuePreference.setTitle(this.bOb.getString(R.l.contact_info_source_title));
                                keyValuePreference.setSummary(this.bOb.getString(R.l.contact_info_source_by_raddar));
                                keyValuePreference.lO(false);
                                break;
                            }
                            break;
                        case f$k.AppCompatTheme_toolbarStyle /*58*/:
                        case f$k.AppCompatTheme_toolbarNavigationButtonStyle /*59*/:
                        case f$k.AppCompatTheme_popupMenuStyle /*60*/:
                            if (keyValuePreference != null) {
                                keyValuePreference.tCA = false;
                                keyValuePreference.setTitle(this.bOb.getString(R.l.contact_info_source_title));
                                keyValuePreference.setSummary(this.bOb.getString(R.l.gcontact_from_source));
                                keyValuePreference.lO(false);
                                break;
                            }
                            break;
                        default:
                            this.eOE.c(keyValuePreference);
                            break;
                    }
                } else if (keyValuePreference != null) {
                    if (i == 10) {
                        keyValuePreference.tCA = false;
                        keyValuePreference.setTitle(this.bOb.getString(R.l.contact_info_source_title));
                        keyValuePreference.setSummary(this.bOb.getString(R.l.fmessage_come_from_mobile));
                        keyValuePreference.lO(false);
                    } else {
                        this.eOE.c(keyValuePreference);
                    }
                }
            } else {
                keyValuePreference = (KeyValuePreference) this.eOE.ZZ("contact_info_source");
                if (this.lUE) {
                    switch (this.guS.getSource()) {
                        case 18:
                            if (keyValuePreference != null) {
                                keyValuePreference.tCA = false;
                                keyValuePreference.setTitle(this.bOb.getString(R.l.contact_info_source_title));
                                keyValuePreference.setSummary(R.l.contact_info_source_by_lbs_passive);
                                keyValuePreference.lO(false);
                                break;
                            }
                            break;
                        case 22:
                        case 23:
                        case 24:
                        case 26:
                        case 27:
                        case f$k.AppCompatTheme_actionModeCloseButtonStyle /*28*/:
                        case f$k.AppCompatTheme_actionModeBackground /*29*/:
                            if (keyValuePreference != null) {
                                keyValuePreference.tCA = false;
                                keyValuePreference.setTitle(this.bOb.getString(R.l.contact_info_source_title));
                                keyValuePreference.setSummary(R.l.contact_info_source_by_shake_passive);
                                keyValuePreference.lO(false);
                                break;
                            }
                            break;
                        case 30:
                            if (keyValuePreference != null) {
                                keyValuePreference.tCA = false;
                                keyValuePreference.setTitle(this.bOb.getString(R.l.contact_info_source_title));
                                keyValuePreference.setSummary(R.l.contact_info_source_by_qrcode_passive);
                                keyValuePreference.lO(false);
                                break;
                            }
                            break;
                        case 34:
                            if (keyValuePreference != null) {
                                keyValuePreference.tCA = false;
                                keyValuePreference.setTitle(this.bOb.getString(R.l.contact_info_source_title));
                                keyValuePreference.setSummary(this.bOb.getString(R.l.contact_info_source_brandqa));
                                keyValuePreference.lO(false);
                                break;
                            }
                            break;
                        case f$k.AppCompatTheme_homeAsUpIndicator /*48*/:
                            if (keyValuePreference != null) {
                                keyValuePreference.tCA = false;
                                keyValuePreference.setTitle(this.bOb.getString(R.l.contact_info_source_title));
                                keyValuePreference.setSummary(this.bOb.getString(R.l.contact_info_source_by_raddar));
                                keyValuePreference.lO(false);
                                break;
                            }
                            break;
                        case f$k.AppCompatTheme_toolbarStyle /*58*/:
                        case f$k.AppCompatTheme_toolbarNavigationButtonStyle /*59*/:
                        case f$k.AppCompatTheme_popupMenuStyle /*60*/:
                            if (keyValuePreference != null) {
                                keyValuePreference.tCA = false;
                                keyValuePreference.setTitle(this.bOb.getString(R.l.contact_info_source_title));
                                keyValuePreference.setSummary(this.bOb.getString(R.l.gcontact_from_source));
                                keyValuePreference.lO(false);
                                break;
                            }
                            break;
                        case f$k.AppCompatTheme_textAppearanceListItem /*76*/:
                            if (keyValuePreference != null) {
                                keyValuePreference.tCA = false;
                                keyValuePreference.setTitle(this.bOb.getString(R.l.contact_info_source_title));
                                keyValuePreference.setSummary(this.bOb.getString(R.l.contact_info_source_by_linkedin));
                                keyValuePreference.lO(false);
                                break;
                            }
                            break;
                        default:
                            this.eOE.c(keyValuePreference);
                            break;
                    }
                }
                this.eOE.c(keyValuePreference);
            }
        }
        this.eOE.bw("contact_info_invite_source", true);
        boolean booleanExtra = this.bOb.getIntent().getBooleanExtra("Is_RoomOwner", false);
        if (this.eLK != 14 || !booleanExtra || this.hLB == null || this.guS.field_username.equals(this.hLB.field_roomowner)) {
            stringExtra2 = "MicroMsg.ContactWidgetNormal";
            str = "[initInviteSource] addContactScene:%s isOwner:%s null == member:%s";
            Object[] objArr2 = new Object[3];
            objArr2[0] = Integer.valueOf(this.eLK);
            objArr2[1] = Boolean.valueOf(booleanExtra);
            if (this.hLB == null) {
                booleanExtra = true;
            } else {
                booleanExtra = false;
            }
            objArr2[2] = Boolean.valueOf(booleanExtra);
            x.i(stringExtra2, str, objArr2);
            this.eOE.bw("contact_info_invite_source", true);
        } else {
            this.bHY = this.bOb.getIntent().getStringExtra("inviteer");
            if (bi.oW(this.bHY)) {
                com.tencent.mm.i.a.a.b XK = this.hLB.XK(this.guS.field_username);
                this.bHY = XK == null ? "" : bi.aG(XK.daC, "");
            }
            if (bi.oW(this.bHY)) {
                this.bHY = m.K(this.guS.field_username, this.hMQ);
            }
            if (bi.oW(this.bHY)) {
                x.w("MicroMsg.ContactWidgetNormal", "mRoomId:%s member:%s , inviteer is null!", new Object[]{this.hMQ, this.guS.field_username});
                this.lWw.cht();
                am.a.dBr.a(this.guS.field_username, this.hMQ, new 11(this));
            } else {
                this.bOb.getIntent().putExtra("inviteer", this.bHY);
                stringExtra = gT(this.bHY);
                if (bi.oW(stringExtra)) {
                    am.a.dBr.a(this.guS.field_username, "", new 2(this));
                } else {
                    ee(this.bHY, stringExtra);
                }
            }
        }
        NormalUserFooterPreference normalUserFooterPreference = (NormalUserFooterPreference) this.eOE.ZZ("contact_info_footer_normal");
        boolean booleanExtra2 = this.bOb.getIntent().getBooleanExtra("User_From_Fmessage", false);
        boolean booleanExtra3 = this.bOb.getIntent().getBooleanExtra("Contact_FMessageCard", false);
        this.bOb.getIntent().getBooleanExtra("Contact_KHideExpose", false);
        long longExtra2 = this.bOb.getIntent().getLongExtra("Contact_Uin", -1);
        if (this.eLK == 30 || this.eLK == 45) {
            this.lWk = false;
        }
        if (normalUserFooterPreference == null || !normalUserFooterPreference.a(this.guS, this.juZ, this.lUD, this.lUE, this.lWk, this.eLK, this.lWd, booleanExtra3, booleanExtra2, longExtra2, this.lWl)) {
            this.eOE.aaa("contact_info_footer_normal");
        } else {
            normalUserFooterPreference.dHn.removeAll();
            normalUserFooterPreference.dHn.a(new 10(this, normalUserHeaderPreference), Looper.getMainLooper());
        }
        i = this.guS.csN;
        this.eOE.aaa("clear_lbs_info");
        if (this.lWr) {
            this.eOE.removeAll();
            if (normalUserHeaderPreference != null) {
                this.eOE.a(normalUserHeaderPreference);
            }
            if (normalUserFooterPreference != null) {
                this.eOE.a(normalUserFooterPreference);
            }
        }
    }

    final void ee(String str, String str2) {
        x.i("MicroMsg.ContactWidgetNormal", "[showInviteerView] inviteer:%s inviteerDisplayName:%s", new Object[]{str, str2});
        KeyValuePreference keyValuePreference = (KeyValuePreference) this.eOE.ZZ("contact_info_invite_source");
        TextPreference textPreference = (TextPreference) this.eOE.ZZ("contact_info_hint");
        this.eOE.bw("contact_info_invite_source", false);
        CharSequence spannableString = new SpannableString(j.a(this.bOb, this.bOb.getResources().getString(R.l.contact_info_invite_source, new Object[]{str2})));
        spannableString.setSpan(new ForegroundColorSpan(this.bOb.getResources().getColor(R.e.green_text_color)), 0, str2.length(), 33);
        keyValuePreference.setSummary(spannableString);
        keyValuePreference.getExtras().putString("inviteer", str);
        this.bOb.getIntent().putExtra("inviteer", str);
        if (this.hLB == null || this.hLB.Nn().contains(this.guS.field_username)) {
            this.eOE.bw("contact_info_footer_normal", false);
            return;
        }
        this.eOE.bw("contact_info_footer_normal", true);
        textPreference.N(j.a(this.bOb, this.bOb.getResources().getString(R.l.contact_info_not_in_room, new Object[]{gT(this.guS.field_username)})));
    }

    final String gT(String str) {
        String str2 = null;
        if (this.hLB == null) {
            return null;
        }
        au.HU();
        ab Yg = com.tencent.mm.model.c.FR().Yg(str);
        if (Yg != null && ((int) Yg.dhP) > 0) {
            str2 = Yg.field_conRemark;
        }
        if (bi.oW(str2)) {
            str2 = this.hLB.gT(str);
        }
        if (!bi.oW(str2) || Yg == null) {
            return str2;
        }
        return Yg.BK();
    }

    public final boolean auw() {
        if (n.nkC != null) {
            n.nkC.a(this, 3);
        }
        au.DF().b(30, this);
        au.DF().b(453, this);
        NormalUserHeaderPreference normalUserHeaderPreference = (NormalUserHeaderPreference) this.eOE.ZZ("contact_info_header_normal");
        if (normalUserHeaderPreference != null) {
            normalUserHeaderPreference.onDetach();
        }
        NormalUserFooterPreference normalUserFooterPreference = (NormalUserFooterPreference) this.eOE.ZZ("contact_info_footer_normal");
        if (normalUserFooterPreference != null) {
            normalUserFooterPreference.auw();
        }
        FriendPreference friendPreference = (FriendPreference) this.eOE.ZZ("contact_info_friend_qq");
        if (friendPreference != null) {
            friendPreference.auw();
        }
        friendPreference = (FriendPreference) this.eOE.ZZ("contact_info_friend_mobile");
        if (friendPreference != null) {
            friendPreference.auw();
        }
        friendPreference = (FriendPreference) this.eOE.ZZ("contact_info_facebook");
        if (friendPreference != null) {
            friendPreference.auw();
        }
        this.eOE.ZZ("contact_info_sns");
        return true;
    }

    public final void onActivityResult(int i, int i2, Intent intent) {
        switch (i) {
            case 1:
                if (i2 == -1 && intent != null) {
                    String stringExtra = intent.getStringExtra("be_send_card_name");
                    String stringExtra2 = intent.getStringExtra("received_card_name");
                    boolean booleanExtra = intent.getBooleanExtra("Is_Chatroom", false);
                    String stringExtra3 = intent.getStringExtra("custom_send_text");
                    com.tencent.mm.plugin.messenger.a.g.bcT().l(stringExtra, stringExtra2, booleanExtra);
                    com.tencent.mm.plugin.messenger.a.g.bcT().dF(stringExtra3, stringExtra2);
                    com.tencent.mm.ui.widget.snackbar.b.h(this.bOb, this.bOb.getString(R.l.finish_sent));
                    return;
                }
                return;
            default:
                return;
        }
    }

    public final void a(int i, int i2, String str, l lVar) {
        if (lVar.getType() != 30 && lVar.getType() != 458) {
            x.w("MicroMsg.ContactWidgetNormal", "not expected scene,  type = " + lVar.getType());
        } else if (i == 0 && i2 == 0) {
            if (lVar.getType() == 30) {
                com.tencent.mm.pluginsdk.model.m mVar = (com.tencent.mm.pluginsdk.model.m) lVar;
                if (mVar.bOh != 1 && mVar.bOh != 3) {
                    return;
                }
                if (mVar.qyZ == null || mVar.qyZ.contains(this.guS.field_username)) {
                    NormalUserHeaderPreference normalUserHeaderPreference = (NormalUserHeaderPreference) this.eOE.ZZ("contact_info_header_normal");
                    NormalUserFooterPreference normalUserFooterPreference = (NormalUserFooterPreference) this.eOE.ZZ("contact_info_footer_normal");
                    if (!(normalUserHeaderPreference == null || normalUserFooterPreference == null || !normalUserFooterPreference.lXv)) {
                        x.d("MicroMsg.ContactWidgetNormal", "happy update remark change");
                        this.lWn = false;
                        this.lWo = false;
                        normalUserHeaderPreference.bo(this.guS.field_username, false);
                        normalUserHeaderPreference.bp(this.guS.field_username, false);
                        normalUserHeaderPreference.jX(this.guS.field_username);
                        this.bOb.getIntent().putExtra("Contact_NeedShowChangeRemarkButton", this.lWn);
                        this.bOb.getIntent().putExtra("Contact_NeedShowChangeSnsPreButton", this.lWo);
                    }
                } else {
                    return;
                }
            }
            if (lVar.getType() == 453) {
                bnp();
            }
        } else if (i == 4 && i2 == -24 && !bi.oW(str)) {
            Toast.makeText(this.bOb, str, 1).show();
        }
    }

    public final void a(boolean z, boolean z2, String str, boolean z3, boolean z4, int i, long j) {
        com.tencent.mm.ui.base.preference.g gVar = (com.tencent.mm.ui.base.preference.g) this.eOE.ZZ("contact_info_sns");
        if (!(gVar == null || n.nky == null)) {
            gVar.TS(this.guS.field_username);
        }
        this.lWj = n.nky.b(this.guS.field_username, this.lWj);
        this.eOE.notifyDataSetChanged();
        if (z3) {
            x.d("MicroMsg.ContactWidgetNormal", "bg Change!");
            if (n.nkC != null) {
                n.nkC.Ly(this.guS.field_username);
            }
        }
    }

    public final void a(boolean z, String str, boolean z2, boolean z3, int i, long j) {
    }
}
