package com.tencent.mm.plugin.profile.ui;

import android.os.Bundle;
import android.os.Looper;
import com.tencent.mm.R;
import com.tencent.mm.a.o;
import com.tencent.mm.k.g;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.model.q;
import com.tencent.mm.plugin.account.b;
import com.tencent.mm.plugin.account.friend.a.ao;
import com.tencent.mm.plugin.fts.a.a.i;
import com.tencent.mm.plugin.fts.a.l;
import com.tencent.mm.plugin.fts.a.n;
import com.tencent.mm.plugin.wxpay.a$k;
import com.tencent.mm.pluginsdk.ui.d.j;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.aa.a;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.u;
import com.tencent.mm.ui.MMActivity;
import org.json.JSONObject;

public class ContactMoreInfoUI extends MMActivity implements l {
    private String cYO;
    u hLB;
    private String hMQ;
    boolean hNi = false;
    private ag handler = new ag(Looper.getMainLooper());
    private ab ipd;
    private String kiv;
    private ProfileNormalItemView lVb;
    private ProfileNormalItemView lVc;
    private ProfileNormalItemView lVd;
    private ProfileNormalItemView lVe;
    private ProfileNormalItemView lVf;
    private ProfileNormalItemView lVg;
    private ProfileNormalItemView lVh;
    private String lVi;
    private String lVj;
    private String lVk;
    private long lVl;
    private String lVm;
    String lVn = null;

    protected final int getLayoutId() {
        return R.i.contact_info_more_ui;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        bnn();
        initView();
    }

    protected final void initView() {
        ProfileNormalItemView profileNormalItemView;
        boolean z = false;
        super.initView();
        this.lVb = (ProfileNormalItemView) findViewById(R.h.linkedin);
        this.lVc = (ProfileNormalItemView) findViewById(R.h.google_plus);
        this.lVd = (ProfileNormalItemView) findViewById(R.h.qq);
        this.lVg = (ProfileNormalItemView) findViewById(R.h.signature);
        this.lVg.uM(R.l.contact_info_signature);
        this.lVg.lSk.setSingleLine(false);
        this.lVh = (ProfileNormalItemView) findViewById(R.h.friend_source);
        this.lVh.uM(R.l.contact_info_source_title);
        this.lVf = (ProfileNormalItemView) findViewById(R.h.weishop);
        this.lVe = (ProfileNormalItemView) findViewById(R.h.common_chatroom);
        setBackBtn(new 1(this));
        bnn();
        au.HU();
        this.hLB = c.Ga().ih(this.hMQ);
        String value = g.AT().getValue("LinkedinPluginClose");
        boolean z2 = bi.oW(value) || Integer.valueOf(value).intValue() == 0;
        boolean z3;
        if (!z2 || bi.oW(this.ipd.csV)) {
            this.lVb.setVisibility(8);
            z3 = false;
        } else {
            this.lVb.setVisibility(0);
            if (bi.oW(this.lVi)) {
                this.lVi = this.ipd.csW;
            }
            profileNormalItemView = this.lVb;
            profileNormalItemView.lXS = this.lVi;
            profileNormalItemView.lXT = new 3(this);
            z3 = profileNormalItemView.uO(getResources().getColor(R.e.profile_normal_item_view_summary_color)).bnH();
        }
        this.lVc.setVisibility(0);
        profileNormalItemView = this.lVc;
        profileNormalItemView.lXS = this.kiv;
        boolean bnH = profileNormalItemView.bnH();
        au.HU();
        int f = bi.f((Integer) c.DT().get(9, null));
        this.lVl = getIntent().getLongExtra("Contact_Uin", 0);
        this.lVm = getIntent().getStringExtra("Contact_QQNick");
        boolean z4;
        if (this.lVl == 0 || f == 0) {
            this.lVd.setVisibility(8);
            z4 = false;
        } else {
            if (this.lVm == null || this.lVm.length() == 0) {
                ao bK = b.getQQListStg().bK(this.lVl);
                if (bK == null) {
                    bK = null;
                }
                if (bK != null) {
                    this.lVm = bK.getDisplayName();
                }
            }
            CharSequence charSequence = bi.oV(this.lVm) + " " + new o(this.lVl).longValue();
            this.lVd.setVisibility(0);
            ProfileNormalItemView profileNormalItemView2 = this.lVd;
            profileNormalItemView2.lXS = charSequence;
            profileNormalItemView2.lXT = new 4(this);
            z4 = profileNormalItemView2.bnH();
        }
        profileNormalItemView = this.lVg;
        profileNormalItemView.lXS = j.a(this, this.ipd.signature);
        boolean bnH2 = profileNormalItemView.bnH();
        switch (this.ipd.getSource()) {
            case 1:
                if (this.ipd.BN() <= 1000000) {
                    this.lVh.uN(R.l.contact_info_source_by_search_qq);
                    break;
                } else {
                    this.lVh.uN(R.l.contact_info_source_by_search_qq_passive);
                    break;
                }
            case 3:
                if (this.ipd.BN() <= 1000000) {
                    this.lVh.uN(R.l.contact_info_source_by_search_wechat);
                    break;
                } else {
                    this.lVh.uN(R.l.contact_info_source_by_search_wechat_passive);
                    break;
                }
            case 4:
            case 12:
                this.lVh.uN(R.l.fmessage_come_from_qq);
                break;
            case 8:
            case 14:
                if (this.ipd.BN() <= 1000000) {
                    this.lVh.uN(R.l.contact_info_source_by_chatroom);
                    break;
                } else {
                    this.lVh.uN(R.l.contact_info_source_by_chatroom_passive);
                    break;
                }
            case 10:
                if (this.ipd.BN() <= 1000000) {
                    this.lVh.uN(R.l.contact_info_source_by_view_address_book);
                    break;
                } else {
                    this.lVh.uN(R.l.contact_info_source_by_view_address_book_passive);
                    break;
                }
            case 13:
                if (this.ipd.BN() <= 1000000) {
                    this.lVh.uN(R.l.contact_info_source_by_view_address_book);
                    break;
                } else {
                    this.lVh.uN(R.l.contact_info_source_by_view_address_book_passive);
                    break;
                }
            case 15:
                if (this.ipd.BN() <= 1000000) {
                    this.lVh.uN(R.l.contact_info_source_by_search_mobile);
                    break;
                } else {
                    this.lVh.uN(R.l.contact_info_source_by_search_mobile_passive);
                    break;
                }
            case 17:
                if (this.ipd.BN() <= 1000000) {
                    this.lVh.uN(R.l.contact_info_source_by_card);
                    break;
                } else {
                    this.lVh.uN(R.l.contact_info_source_by_card_passive);
                    break;
                }
            case 18:
                if (this.ipd.BN() <= 1000000) {
                    this.lVh.uN(R.l.contact_info_source_by_lbs);
                    break;
                } else {
                    this.lVh.uN(R.l.contact_info_source_by_lbs_passive);
                    break;
                }
            case 22:
            case 23:
            case 24:
            case 26:
            case 27:
            case 28:
            case 29:
                if (this.ipd.BN() <= 1000000) {
                    this.lVh.uN(R.l.contact_info_source_by_shake);
                    break;
                } else {
                    this.lVh.uN(R.l.contact_info_source_by_shake_passive);
                    break;
                }
            case 25:
                if (this.ipd.BN() <= 1000000) {
                    this.lVh.uN(R.l.contact_info_source_by_bottle);
                    break;
                } else {
                    this.lVh.uN(R.l.contact_info_source_by_bottle_passive);
                    break;
                }
            case a$k.AppCompatTheme_actionModeSplitBackground /*30*/:
                if (this.ipd.BN() <= 1000000) {
                    this.lVh.uN(R.l.contact_info_source_by_qrcode);
                    break;
                } else {
                    this.lVh.uN(R.l.contact_info_source_by_qrcode_passive);
                    break;
                }
            case 34:
                this.lVh.uN(R.l.contact_info_source_brandqa);
                break;
            case a$k.AppCompatTheme_homeAsUpIndicator /*48*/:
                this.lVh.uN(R.l.contact_info_source_by_raddar);
                break;
            case a$k.AppCompatTheme_toolbarStyle /*58*/:
            case 59:
            case a$k.AppCompatTheme_popupMenuStyle /*60*/:
                this.lVh.uN(R.l.gcontact_from_source);
                break;
            case a$k.AppCompatTheme_textAppearanceListItem /*76*/:
                this.lVh.uN(R.l.contact_info_source_by_linkedin);
                break;
            default:
                this.lVh.lXS = null;
                break;
        }
        boolean bnH3 = this.lVh.bnH();
        boolean I = I(this.ipd);
        if (!this.ipd.field_username.equals(q.GF())) {
            ab abVar = this.ipd;
            if (ab.XR(abVar.field_username) || abVar.field_username.equals(q.GF())) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (z2) {
                this.lVe.setVisibility(8);
            } else {
                if (abVar.sex == 1) {
                    this.lVe.uM(R.l.contact_info_common_chatroom_male);
                } else if (abVar.sex == 2) {
                    this.lVe.uM(R.l.contact_info_common_chatroom_female);
                } else {
                    this.lVe.uM(R.l.contact_info_common_chatroom_unknow);
                }
                this.lVe.bnH();
                i iVar = new i();
                iVar.bWm = abVar.field_username;
                iVar.jsv = this;
                iVar.handler = this.handler;
                iVar.jsn = 5;
                ((n) com.tencent.mm.kernel.g.n(n.class)).search(2, iVar);
                z = true;
            }
        }
        if (!bnH2 && !bnH3 && !I && !z3 && !bnH && !z4 && !z) {
            finish();
        }
    }

    private boolean I(ab abVar) {
        String str;
        CharSequence optString;
        if (q.GF().equals(abVar.field_username)) {
            au.HU();
            str = (String) c.DT().get(a.sRy, null);
        } else {
            str = abVar.csY;
        }
        if (!bi.oW(str)) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                this.lVn = jSONObject.optString("ShopUrl");
                optString = jSONObject.optString("ShopName");
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.ContactMoreInfoUI", e, "", new Object[0]);
            }
            if (bi.oW(this.lVn)) {
                this.lVf.setVisibility(0);
                this.lVf.lXS = optString;
                this.lVf.uO(getResources().getColor(R.e.profile_normal_item_view_summary_color));
                ProfileNormalItemView profileNormalItemView = this.lVf;
                profileNormalItemView.lXT = new 2(this);
                profileNormalItemView.bnH();
                return true;
            }
            this.lVf.setVisibility(8);
            return false;
        }
        optString = null;
        if (bi.oW(this.lVn)) {
            this.lVf.setVisibility(8);
            return false;
        }
        this.lVf.setVisibility(0);
        this.lVf.lXS = optString;
        this.lVf.uO(getResources().getColor(R.e.profile_normal_item_view_summary_color));
        ProfileNormalItemView profileNormalItemView2 = this.lVf;
        profileNormalItemView2.lXT = new 2(this);
        profileNormalItemView2.bnH();
        return true;
    }

    private void bnn() {
        this.hNi = getIntent().getBooleanExtra("Is_RoomOwner", false);
        this.hMQ = getIntent().getStringExtra("Contact_ChatRoomId");
        this.cYO = getIntent().getStringExtra("Contact_User");
        au.HU();
        this.ipd = c.FR().Yg(this.cYO);
        this.lVi = getIntent().getStringExtra("KLinkedInAddFriendNickName");
        this.lVj = getIntent().getStringExtra("KLinkedInAddFriendPubUrl");
        this.kiv = getIntent().getStringExtra("verify_gmail");
        this.lVk = getIntent().getStringExtra("profileName");
    }

    public final void b(com.tencent.mm.plugin.fts.a.a.j jVar) {
        if (jVar.bjW == 0) {
            int intValue = ((Integer) ((com.tencent.mm.plugin.fts.a.a.l) jVar.jsx.get(0)).userData).intValue();
            this.lVe.lXS = getString(R.l.contact_info_common_chatroom_number, new Object[]{Integer.valueOf(intValue)});
            this.lVe.lXT = new 5(this, intValue);
        } else {
            this.lVe.lXS = getString(R.l.contact_info_common_chatroom_number, new Object[]{Integer.valueOf(0)});
        }
        this.lVe.bnH();
    }
}
