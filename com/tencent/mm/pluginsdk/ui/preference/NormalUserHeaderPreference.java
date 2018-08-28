package com.tencent.mm.pluginsdk.ui.preference;

import android.content.ClipboardManager;
import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.aa.f.c;
import com.tencent.mm.az.d;
import com.tencent.mm.model.am;
import com.tencent.mm.model.au;
import com.tencent.mm.model.bd;
import com.tencent.mm.model.q;
import com.tencent.mm.model.r;
import com.tencent.mm.model.s;
import com.tencent.mm.plugin.messenger.foundation.a.a.k.a;
import com.tencent.mm.plugin.sns.b.n;
import com.tencent.mm.pluginsdk.ui.ProfileDescribeView;
import com.tencent.mm.pluginsdk.ui.ProfileLabelView;
import com.tencent.mm.pluginsdk.ui.ProfileMobilePhoneView;
import com.tencent.mm.pluginsdk.ui.d.j;
import com.tencent.mm.sdk.e.m;
import com.tencent.mm.sdk.e.m.b;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.aa;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.bq;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.preference.Preference;
import junit.framework.Assert;

public class NormalUserHeaderPreference extends Preference implements c, a, b {
    MMActivity bGc;
    ab guS;
    private boolean iAc = false;
    private TextView jYA;
    private String juZ;
    private TextView kkF;
    private ImageView lUo;
    private boolean lWk;
    private boolean lWr = false;
    private boolean lXu = false;
    private ClipboardManager lyy;
    private ImageView mZF;
    int mZZ;
    public String qGi;
    public String qGj;
    private TextView qOL;
    private TextView qOM;
    private TextView qON;
    private View qOO;
    private Button qOP;
    private Button qOQ;
    private TextView qOR;
    private ImageView qOS;
    private CheckBox qOT;
    private ImageView qOU;
    private ImageView qOV;
    private LinearLayout qOW;
    private Button qOX;
    private FMessageListView qOY;
    private int qOZ = 0;
    private boolean qPa = false;
    private boolean qPb = false;
    private boolean qPc = false;
    private boolean qPd = false;
    private boolean qPe = false;
    private boolean qPf = false;
    private boolean qPg = false;
    private boolean qPh = false;
    private String qPi;
    private ProfileMobilePhoneView qPj;
    private ProfileDescribeView qPk;
    private ProfileLabelView qPl;
    private TextView qPm;
    public OnClickListener qPn;
    public String qPo = null;

    public NormalUserHeaderPreference(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bGc = (MMActivity) context;
        init();
    }

    public NormalUserHeaderPreference(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.bGc = (MMActivity) context;
        init();
    }

    private void init() {
        this.iAc = false;
        this.lyy = (ClipboardManager) this.bGc.getSystemService("clipboard");
    }

    protected final View onCreateView(ViewGroup viewGroup) {
        if (this.qOY != null) {
            this.qOY.detach();
        }
        return super.onCreateView(viewGroup);
    }

    public final void onBindView(View view) {
        int i = 0;
        x.d("MicroMsg.ContactInfoHeader", "onBindView");
        this.jYA = (TextView) view.findViewById(R.h.contact_info_nickname_tv);
        this.kkF = (TextView) view.findViewById(R.h.contact_info_username_tv);
        this.qOR = (TextView) view.findViewById(R.h.contact_info_account_deleted_tv);
        this.qOL = (TextView) view.findViewById(R.h.contact_info_chatroom_nickname_tv);
        this.qOM = (TextView) view.findViewById(R.h.contact_info_nickname_when_has_remark_tv);
        this.qOP = (Button) view.findViewById(R.h.contact_info_remarkname_btn);
        this.qOQ = (Button) view.findViewById(R.h.contact_info_snspermission_btn);
        this.qPj = (ProfileMobilePhoneView) view.findViewById(R.h.mobile_phone);
        ProfileMobilePhoneView profileMobilePhoneView = this.qPj;
        au.HU();
        profileMobilePhoneView.qGs = ((Boolean) com.tencent.mm.model.c.DT().get(aa.a.sRf, Boolean.valueOf(false))).booleanValue();
        this.qPk = (ProfileDescribeView) view.findViewById(R.h.desc_info);
        this.qPl = (ProfileLabelView) view.findViewById(R.h.label_info);
        this.qPm = (TextView) view.findViewById(R.h.set_desc_and_label_tv);
        this.qPk.setOnClickListener(this.qPn);
        this.qPl.setOnClickListener(this.qPn);
        this.qPm.setOnClickListener(this.qPn);
        if (q.gQ(this.guS.field_username) || (!bi.oW(this.guS.field_username) && s.hH(this.guS.field_username))) {
            this.qPm.setVisibility(8);
            this.qPj.setVisibility(8);
            this.qPk.setVisibility(8);
            this.qPl.setVisibility(8);
        } else {
            ProfileMobilePhoneView profileMobilePhoneView2 = this.qPj;
            x.i("MicroMsg.ProfileMobilePhoneView", "phoneNumberByMD5:%s phoneNumberList:%s", new Object[]{this.qGi, this.qGj});
            profileMobilePhoneView2.qGi = r3;
            profileMobilePhoneView2.qGj = r4;
            profileMobilePhoneView2.bnH();
            if (com.tencent.mm.l.a.gd(this.guS.field_type)) {
                this.qPj.setVisibility(0);
            } else {
                this.qPj.setVisibility(8);
            }
            boolean N = this.qPk.N(this.guS);
            boolean N2 = this.qPl.N(this.guS);
            if (N || N2) {
                this.qPm.setVisibility(8);
            } else {
                if (this.qPg || this.qPe) {
                    this.qPm.setVisibility(8);
                } else {
                    this.qPm.setVisibility(0);
                }
                if (this.qPo != null && (this.qPo.equals("ContactWidgetBottleContact") || this.qPo.equals("ContactWidgetQContact"))) {
                    this.qPm.setVisibility(8);
                }
            }
        }
        this.qON = (TextView) view.findViewById(R.h.contact_info_hing_tv);
        this.qOX = (Button) view.findViewById(R.h.contact_info_edit_btn);
        this.qOY = (FMessageListView) view.findViewById(R.h.contact_info_fmessage_listview);
        a.a aVar = new a.a();
        aVar.talker = this.guS.field_username;
        aVar.scene = this.mZZ;
        aVar.juZ = this.juZ;
        aVar.qOy = this.guS.cta;
        aVar.type = 0;
        if (this.mZZ == 18) {
            aVar.type = 1;
        } else if (bd.hd(this.mZZ)) {
            aVar.type = 2;
        }
        this.qOY.setFMessageArgs(aVar);
        this.qOO = view.findViewById(R.h.small_category);
        this.qOW = (LinearLayout) view.findViewById(R.h.head_root);
        this.lUo = (ImageView) view.findViewById(R.h.contact_info_avatar_iv);
        this.mZF = (ImageView) view.findViewById(R.h.contact_info_sex_iv);
        this.qOS = (ImageView) view.findViewById(R.h.contact_info_vuserinfo_iv);
        this.qOT = (CheckBox) view.findViewById(R.h.contact_info_star_iv);
        this.qOU = (ImageView) view.findViewById(R.h.contact_info_sns_iv);
        this.qOV = (ImageView) view.findViewById(R.h.contact_info_sns_black_iv);
        this.iAc = true;
        initView();
        if (com.tencent.mm.l.a.gd(this.guS.field_type)) {
            x.d("MicroMsg.ContactInfoHeader", "initAddContent, showFMessageList false");
            this.qOY.setVisibility(8);
            if (this.qOY.getVisibility() == 8 && this.qPm.getVisibility() == 8 && this.qPl.getVisibility() == 8 && this.qPk.getVisibility() == 8 && this.qON.getVisibility() == 8) {
                this.qOO.setVisibility(8);
            }
        } else if (this.juZ == null || this.juZ.length() == 0) {
            x.d("MicroMsg.ContactInfoHeader", "initAddContent, FMessageListView gone, addScene = " + this.mZZ + ", verifyTicket = " + this.juZ);
            this.qOY.setVisibility(8);
            if (this.qOY.getVisibility() == 8 && this.qPm.getVisibility() == 8 && this.qPl.getVisibility() == 8 && this.qPk.getVisibility() == 8 && this.qON.getVisibility() == 8) {
                this.qOO.setVisibility(8);
            }
        } else {
            b[] a;
            x.d("MicroMsg.ContactInfoHeader", "initAddContent, scene = " + this.mZZ);
            if (this.mZZ == 18) {
                x.d("MicroMsg.ContactInfoHeader", "initAddContent, scene is lbs");
                a = b.a(this.bGc, d.SG().YR(this.guS.field_username));
            } else if (bd.hd(this.mZZ)) {
                x.d("MicroMsg.ContactInfoHeader", "initAddContent, scene is shake");
                a = b.a(this.bGc, d.SH().Zp(this.guS.field_username));
            } else {
                x.d("MicroMsg.ContactInfoHeader", "initAddContent, scene is other");
                a = b.a(this.bGc, d.SE().YM(this.guS.field_username));
            }
            if (a == null || a.length == 0) {
                x.e("MicroMsg.ContactInfoHeader", "initAddContent, providerList is null");
                this.qOY.setVisibility(8);
                if (this.qOY.getVisibility() == 8 && this.qPm.getVisibility() == 8 && this.qPl.getVisibility() == 8 && this.qPk.getVisibility() == 8 && this.qON.getVisibility() == 8) {
                    this.qOO.setVisibility(8);
                }
            } else {
                x.d("MicroMsg.ContactInfoHeader", "initAddContent, providerList size = " + a.length);
                for (b bVar : a) {
                    if (bVar != null) {
                        x.d("MicroMsg.ContactInfoHeader", "initAddContent, username = " + bVar.username + ", nickname = " + bVar.nickname + ", digest = " + bVar.dzA + ", addScene = " + bVar.mZZ);
                    }
                }
                this.qOY.setVisibility(ab.XR(this.guS.field_username) ? 8 : 0);
                if (this.qOY.getVisibility() == 0 || this.qPm.getVisibility() == 0 || this.qPl.getVisibility() == 0 || this.qPk.getVisibility() == 0 || this.qON.getVisibility() == 0) {
                    this.qOO.setVisibility(0);
                }
                int length = a.length;
                while (i < length) {
                    this.qOY.a(a[i]);
                    i++;
                }
            }
        }
        super.onBindView(view);
    }

    private boolean bnm() {
        return this.iAc && this.guS != null;
    }

    private void bru() {
        com.tencent.mm.pluginsdk.ui.a.b.a(this.lUo, this.guS.field_username);
        if (this.lUo != null) {
            int ad = com.tencent.mm.bp.a.ad(this.mContext, R.f.BigAvatarSize);
            int fromDPToPix = com.tencent.mm.bp.a.fromDPToPix(this.bGc, 88);
            if (ad <= fromDPToPix) {
                fromDPToPix = ad;
            }
            LayoutParams layoutParams = new LinearLayout.LayoutParams(fromDPToPix, fromDPToPix);
            layoutParams.setMargins(0, 0, com.tencent.mm.bp.a.ae(this.mContext, R.f.LargerPadding), 0);
            this.lUo.setLayoutParams(layoutParams);
        }
    }

    private void initView() {
        int i = 0;
        if (!bnm()) {
            x.w("MicroMsg.ContactInfoHeader", "initView : bindView = " + this.iAc + "contact = " + this.guS);
        } else if (this.lWr) {
            this.qOR.setVisibility(0);
            this.jYA.setText(j.a(this.bGc, bi.oV(this.guS.BK()) + " ", this.jYA.getTextSize()));
            bru();
            this.qOX.setVisibility(8);
            this.kkF.setVisibility(8);
            this.qOY.setVisibility(8);
            if (this.qOY.getVisibility() == 8 && this.qPm.getVisibility() == 8 && this.qPl.getVisibility() == 8 && this.qPk.getVisibility() == 8 && this.qON.getVisibility() == 8) {
                this.qOO.setVisibility(8);
            }
            this.qOP.setVisibility(8);
            this.qOQ.setVisibility(8);
            this.qOT.setVisibility(8);
            if (this.qPl != null) {
                this.qPl.setVisibility(8);
            }
            if (this.qPj != null) {
                this.qPj.setVisibility(8);
            }
            if (this.qPk != null) {
                this.qPk.setVisibility(8);
            }
            if (this.qPm != null) {
                this.qPm.setVisibility(8);
            }
            if (this.qOM != null) {
                this.qOM.setVisibility(8);
            }
        } else {
            boolean gY = ab.gY(this.guS.field_username);
            if (gY) {
                this.jYA.setText("");
                if (ab.XV(q.GF()).equals(this.guS.field_username)) {
                    this.qOX.setVisibility(0);
                    this.qOX.setOnClickListener(new 1(this));
                }
            } else {
                this.jYA.setText(j.a(this.bGc, bi.oV(this.guS.BK()) + " ", this.jYA.getTextSize()));
            }
            this.mZF.setVisibility(0);
            this.qPc = true;
            if (this.guS.sex == 1) {
                this.mZF.setImageDrawable(com.tencent.mm.bp.a.f(this.bGc, R.k.ic_sex_male));
                this.mZF.setContentDescription(this.mContext.getString(R.l.profile_sex_male_desc));
            } else if (this.guS.sex == 2) {
                this.mZF.setImageDrawable(com.tencent.mm.bp.a.f(this.bGc, R.k.ic_sex_female));
                this.mZF.setContentDescription(this.mContext.getString(R.l.profile_sex_female_desc));
            } else if (this.guS.sex == 0) {
                this.mZF.setVisibility(8);
                this.qPc = false;
            }
            if (this.guS.field_verifyFlag != 0) {
                Bitmap e;
                this.qOS.setVisibility(0);
                if (am.a.dBt != null) {
                    e = BackwardSupportUtil.b.e(am.a.dBt.gX(this.guS.field_verifyFlag), 2.0f);
                } else {
                    e = null;
                }
                this.qOS.setImageBitmap(e);
                this.qOZ = e == null ? 0 : e.getWidth();
            }
            bru();
            this.lUo.setOnClickListener(new 2(this));
            if (ab.XQ(this.guS.field_username)) {
                this.kkF.setText(this.mContext.getString(R.l.app_field_qquin) + this.guS.BM());
            } else if (ab.XO(this.guS.field_username)) {
                this.kkF.setText(this.mContext.getString(R.l.app_field_weibo) + this.guS.BM());
            } else if (this.lWk) {
                if (com.tencent.mm.l.a.gd(this.guS.field_type)) {
                    cfc();
                } else if (this.guS.csM == null || this.guS.csM.equals("")) {
                    this.kkF.setText(R.l.app_empty_string);
                } else {
                    this.kkF.setText(this.guS.csM);
                }
            } else if (gY) {
                this.kkF.setText((bi.oV(r.gV(this.guS.getProvince())) + " " + bi.oV(this.guS.getCity())).trim());
            } else {
                if (!ab.XP(this.guS.field_username) && this.bGc.getIntent().getBooleanExtra("Contact_ShowUserName", true)) {
                    if (bi.oW(this.guS.wM()) && (ab.XT(this.guS.field_username) || s.hd(this.guS.field_username))) {
                        this.kkF.setVisibility(8);
                    } else if (com.tencent.mm.l.a.gd(this.guS.field_type)) {
                        cfc();
                    }
                }
                this.kkF.setVisibility(8);
            }
            if (s.hH(this.guS.field_username)) {
                this.qON.setVisibility(0);
            } else {
                this.qON.setVisibility(8);
            }
            cfe();
            cfd();
            cff();
            if (bi.oW(this.qPi)) {
                this.qOL.setVisibility(8);
            } else {
                if (!q.gQ(this.guS.field_username) && bi.oV(this.guS.field_conRemark).length() > 0) {
                    this.kkF.setVisibility(8);
                }
                this.qOL.setVisibility(0);
                this.qOL.setText(j.a(this.bGc, this.bGc.getString(R.l.contact_info_chatroom_nickname) + this.qPi, this.qOL.getTextSize()));
            }
            this.qOP.setOnClickListener(new 3(this));
            this.qOQ.setOnClickListener(new 4(this));
            if (this.qPc) {
                i = com.tencent.mm.bp.a.fromDPToPix(this.bGc, 17) + 0;
            }
            int i2 = this.qOZ + i;
            if (this.qPa) {
                i2 += com.tencent.mm.bp.a.fromDPToPix(this.bGc, 27);
            }
            if (this.qPb) {
                i2 += com.tencent.mm.bp.a.fromDPToPix(this.bGc, 27);
            }
            if (this.qPd) {
                i2 += com.tencent.mm.bp.a.fromDPToPix(this.bGc, 30);
            }
            this.jYA.setMaxWidth(this.bGc.getResources().getDisplayMetrics().widthPixels - ((com.tencent.mm.bp.a.fi(this.mContext) ? i2 + com.tencent.mm.bp.a.fromDPToPix(this.bGc, 88) : i2 + com.tencent.mm.bp.a.fromDPToPix(this.bGc, 64)) + com.tencent.mm.bp.a.fromDPToPix(this.bGc, 60)));
            this.kkF.setLongClickable(true);
            this.kkF.setOnLongClickListener(new 5(this));
        }
    }

    public final void cfc() {
        ab.ckV();
        this.kkF.setVisibility(0);
        if (!bi.oW(this.guS.wM())) {
            this.kkF.setText(this.mContext.getString(R.l.app_field_username) + this.guS.wM());
        } else if (ab.XT(this.guS.field_username) || s.hd(this.guS.field_username)) {
            this.kkF.setVisibility(8);
        } else {
            this.kkF.setText(this.mContext.getString(R.l.app_field_username) + bi.oV(this.guS.BM()));
        }
    }

    public final void bo(String str, boolean z) {
        if (str != null && str.equals(this.guS.field_username)) {
            this.qPe = z;
        }
    }

    public final void bp(String str, boolean z) {
        if (str != null && str.equals(this.guS.field_username)) {
            this.qPf = z;
        }
    }

    public final void a(ab abVar, int i, String str) {
        boolean z;
        boolean z2 = true;
        onDetach();
        au.HU();
        com.tencent.mm.model.c.FR().a(this);
        au.HU();
        com.tencent.mm.model.c.FS().a(this);
        com.tencent.mm.aa.q.Kp().d(this);
        this.guS = abVar;
        this.mZZ = i;
        this.juZ = str;
        this.lWk = this.bGc.getIntent().getBooleanExtra("Contact_IsLBSFriend", false);
        this.qPh = this.bGc.getIntent().getBooleanExtra("Contact_ShowFMessageList", false);
        this.qPe = this.bGc.getIntent().getBooleanExtra("Contact_NeedShowChangeRemarkButton", false);
        this.qPf = this.bGc.getIntent().getBooleanExtra("Contact_NeedShowChangeSnsPreButton", false);
        this.qPg = this.bGc.getIntent().getBooleanExtra("Contact_AlwaysShowRemarkBtn", false);
        this.lXu = this.bGc.getIntent().getBooleanExtra("Contact_AlwaysShowSnsPreBtn", false);
        this.qPi = this.bGc.getIntent().getStringExtra("Contact_RoomNickname");
        if (abVar.field_deleteFlag == 1) {
            z = true;
        } else {
            z = false;
        }
        this.lWr = z;
        String str2 = "initView: contact username is null";
        if (bi.oV(abVar.field_username).length() <= 0) {
            z2 = false;
        }
        Assert.assertTrue(str2, z2);
        initView();
    }

    public final void onDetach() {
        if (this.qOY != null) {
            this.qOY.detach();
        }
        if (this.qPh) {
            d.SF().YK(this.guS.field_username);
        }
        this.bGc.getIntent().putExtra("Contact_NeedShowChangeRemarkButton", this.qPe);
        this.bGc.getIntent().putExtra("Contact_NeedShowChangeSnsPreButton", this.qPf);
        au.HU();
        com.tencent.mm.model.c.FR().b(this);
        com.tencent.mm.aa.q.Kp().e(this);
        au.HU();
        com.tencent.mm.model.c.FS().b(this);
    }

    private void cfd() {
        int i = 0;
        if (this.qOU != null && s.gW(this.guS.field_username)) {
            this.qPb = this.guS.BF();
            this.qOU.setVisibility(this.qPb ? 0 : 8);
        }
        if (this.qOV != null && s.gW(this.guS.field_username)) {
            boolean Lz;
            String str = this.guS.field_username;
            if (n.nkA != null) {
                Lz = n.nkA.Lz(str);
            } else {
                Lz = false;
            }
            this.qPa = Lz;
            ImageView imageView = this.qOV;
            if (!this.qPa) {
                i = 8;
            }
            imageView.setVisibility(i);
        }
    }

    private void cfe() {
        if (q.gQ(this.guS.field_username) || bi.oV(this.guS.field_conRemark).length() <= 0) {
            this.qOM.setVisibility(8);
            this.jYA.setText(j.a(this.bGc, bi.oV(this.guS.BK()) + " ", this.jYA.getTextSize()));
            if (this.qPg) {
                this.qOP.setVisibility(0);
                this.qPm.setVisibility(8);
            } else if (this.qPe) {
                this.qOP.setVisibility(0);
                this.qPm.setVisibility(8);
            } else {
                if (com.tencent.mm.l.a.gd(this.guS.field_type)) {
                    this.qOP.setVisibility(8);
                }
                boolean N = this.qPk.N(this.guS);
                boolean N2 = this.qPl.N(this.guS);
                if (N || N2) {
                    this.qPm.setVisibility(8);
                }
            }
        } else {
            this.jYA.setText(j.a(this.bGc, bi.oV(this.guS.field_conRemark) + " ", this.jYA.getTextSize()));
            this.qOM.setVisibility(0);
            this.qOM.setText(j.a(this.bGc, this.mContext.getString(R.l.contact_info_nickname) + this.guS.BK(), this.qOM.getTextSize()));
            this.qOP.setVisibility(8);
        }
        if (ab.XR(this.guS.field_username)) {
            this.qPm.setText(R.l.contact_set_des_only);
            int i = R.h.line_username;
            if (this.qOW != null) {
                View findViewById = this.qOW.findViewById(i);
                if (findViewById != null) {
                    findViewById.setVisibility(8);
                }
            }
        }
        if (this.lXu && !com.tencent.mm.l.a.gd(this.guS.field_type)) {
            this.qOQ.setVisibility(0);
        } else if (this.qPf) {
            this.qOQ.setVisibility(0);
            if (com.tencent.mm.bp.a.fi(this.bGc)) {
                this.qOQ.setTextSize(0, (float) this.bGc.getResources().getDimensionPixelSize(R.f.HintTextSize));
                this.qOP.setTextSize(0, (float) this.bGc.getResources().getDimensionPixelSize(R.f.HintTextSize));
            }
        } else {
            this.qOQ.setVisibility(8);
        }
        if (ab.gY(this.guS.field_username)) {
            this.jYA.setText("");
        }
        if (this.mZZ == 76 && this.guS.field_username != null && this.guS.field_username.endsWith("@stranger")) {
            this.jYA.setText(j.a(this.bGc, bi.oV(this.guS.field_nickname) + " ", this.jYA.getTextSize()));
        }
        if (this.qOQ.getVisibility() == 0 && this.qOM.getVisibility() == 0) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.qOM.getLayoutParams();
            layoutParams.topMargin = this.mContext.getResources().getDimensionPixelSize(R.f.SmallPadding);
            this.qOM.setLayoutParams(layoutParams);
        }
    }

    private void cff() {
        this.qOT.setClickable(false);
        if ((s.gW(this.guS.field_username) || ab.XR(this.guS.field_username)) && com.tencent.mm.l.a.gd(this.guS.field_type) && !q.gQ(this.guS.field_username)) {
            this.qOT.setVisibility(0);
            if (this.guS.BC()) {
                this.qOT.setChecked(true);
                this.qPd = true;
                return;
            }
            this.qOT.setChecked(false);
            this.qOT.setVisibility(8);
            this.qPd = false;
            return;
        }
        this.qPd = false;
        this.qOT.setVisibility(8);
    }

    public final void jX(String str) {
        if (!bnm()) {
            x.e("MicroMsg.ContactInfoHeader", "initView : bindView = " + this.iAc + "contact = " + this.guS);
        } else if (bi.oV(str).length() <= 0) {
            x.e("MicroMsg.ContactInfoHeader", "notifyChanged: user = " + str);
        } else if (str.equals(this.guS.field_username)) {
            initView();
        }
    }

    public final void a(int i, m mVar, Object obj) {
        x.d("MicroMsg.ContactInfoHeader", "onNotifyChange event:%d stg:%s obj:%s", new Object[]{Integer.valueOf(i), mVar, obj});
        if (obj == null || !(obj instanceof String)) {
            x.e("MicroMsg.ContactInfoHeader", "onNotifyChange obj not String event:%d stg:%s obj:%s", new Object[]{Integer.valueOf(i), mVar, obj});
            return;
        }
        String str = (String) obj;
        x.d("MicroMsg.ContactInfoHeader", "onNotifyChange username = " + str + ", contact = " + this.guS);
        if (!bnm()) {
            x.e("MicroMsg.ContactInfoHeader", "initView : bindView = " + this.iAc + "contact = " + this.guS);
        } else if (bi.oV(str).length() > 0 && this.guS != null && this.guS.field_username.equals(str)) {
            au.HU();
            this.guS = com.tencent.mm.model.c.FR().Yg(str);
            ah.A(new 6(this));
        }
    }

    public final void a(bq bqVar) {
        ah.A(new 7(this, bqVar));
    }
}
