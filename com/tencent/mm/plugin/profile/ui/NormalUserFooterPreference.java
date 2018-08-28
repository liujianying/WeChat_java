package com.tencent.mm.plugin.profile.ui;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.g.a.su;
import com.tencent.mm.g.c.ai;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.model.q;
import com.tencent.mm.model.s;
import com.tencent.mm.pluginsdk.model.m;
import com.tencent.mm.pluginsdk.ui.preference.b;
import com.tencent.mm.sdk.e.j.a;
import com.tencent.mm.sdk.e.k;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.ab;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.preference.Preference;
import java.util.List;
import junit.framework.Assert;

public class NormalUserFooterPreference extends Preference implements a {
    private MMActivity bGc;
    protected k<e, String> dHn = new 1(this);
    public ProgressDialog eHw = null;
    private int eLK;
    private ab guS;
    private String hev = null;
    private boolean iAc;
    private String juZ = "";
    private Button kXG;
    private boolean lUD;
    private int lVM = 0;
    private long lWQ = 0;
    private int lWd;
    private String lWl = "";
    private boolean lWr = false;
    private boolean lXa = false;
    private boolean lXb;
    private boolean lXc;
    private boolean lXd = false;
    private boolean lXe = false;
    private a lXf;
    private View lXg;
    private Button lXh;
    private Button lXi;
    private Button lXj;
    private View lXk;
    private Button lXl;
    private View lXm;
    private Button lXn;
    private Button lXo;
    private Button lXp;
    private Button lXq;
    private Button lXr;
    private Button lXs;
    private TextView lXt;
    private boolean lXu = false;
    public boolean lXv = false;

    class i extends c implements e {
        private ProgressDialog eHw;

        public i() {
            super(NormalUserFooterPreference.this);
        }

        protected void bnA() {
            onDetach();
            onStop();
            au.DF().a(30, (e) this);
            au.DF().a(667, (e) this);
            au.DF().a(853, (e) this);
            super.bnA();
        }

        final void onStop() {
            au.DF().b(30, (e) this);
            au.DF().b(667, (e) this);
            au.DF().b(853, (e) this);
        }

        protected void onDetach() {
            if (this.eHw != null) {
                this.eHw.dismiss();
                this.eHw = null;
            }
            if (NormalUserFooterPreference.this.lXg != null) {
                NormalUserFooterPreference.this.lXg.setVisibility(8);
            }
            if (NormalUserFooterPreference.this.lXm != null) {
                NormalUserFooterPreference.this.lXm.setVisibility(0);
            }
            if (NormalUserFooterPreference.this.kXG != null) {
                NormalUserFooterPreference.this.kXG.setVisibility(8);
            }
            if (NormalUserFooterPreference.this.lXs != null) {
                NormalUserFooterPreference.this.lXs.setVisibility(8);
            }
            if (NormalUserFooterPreference.this.lXq != null) {
                NormalUserFooterPreference.this.lXq.setVisibility(8);
            }
            if (NormalUserFooterPreference.this.lXp != null) {
                NormalUserFooterPreference.this.lXp.setVisibility(8);
            }
            if (NormalUserFooterPreference.this.lXt != null) {
                NormalUserFooterPreference.this.lXt.setVisibility(8);
            }
            onStop();
        }

        private void Bb() {
            NormalUserFooterPreference normalUserFooterPreference = NormalUserFooterPreference.this;
            au.HU();
            ab Yg = c.FR().Yg(NormalUserFooterPreference.this.guS.field_username);
            if (Yg == null || ((int) Yg.dhP) == 0) {
                ai a = NormalUserFooterPreference.this.guS;
                au.HU();
                if (c.FR().S(a)) {
                    au.HU();
                    Yg = c.FR().Yg(NormalUserFooterPreference.this.guS.field_username);
                } else {
                    x.e("MicroMsg.NormalUserFooterPreference", "insert contact failed, username = " + a.field_username);
                    Yg = null;
                }
            }
            normalUserFooterPreference.guS = Yg;
            if (NormalUserFooterPreference.this.guS != null) {
                s.p(NormalUserFooterPreference.this.guS);
            }
        }

        protected void bnG() {
            if (NormalUserFooterPreference.this.lXf != null) {
                NormalUserFooterPreference.this.lXf.onDetach();
            }
            NormalUserFooterPreference.this.lXf = new c(NormalUserFooterPreference.this);
            NormalUserFooterPreference.this.lXf.FC();
        }

        public void a(int i, int i2, String str, l lVar) {
            int i3 = 0;
            x.d("MicroMsg.NormalUserFooterPreference", "onSceneEnd, errType = " + i + ", errCode = " + i2);
            if (lVar.getType() == 30 || lVar.getType() == 667 || lVar.getType() == 853) {
                onStop();
                if (this.eHw != null) {
                    this.eHw.dismiss();
                    this.eHw = null;
                }
                if (bi.ci(NormalUserFooterPreference.this.mContext)) {
                    int i4;
                    if (i == 0 && i2 == 0) {
                        if (lVar.getType() == 30) {
                            i4 = ((m) lVar).bOh;
                            x.d("MicroMsg.NormalUserFooterPreference", "VerifyBaseHandler onSceneEnd, opCode = " + i4);
                            if (i4 == 1 || i4 == 3) {
                                List<String> list = ((m) lVar).qyZ;
                                if (list != null && list.contains(NormalUserFooterPreference.this.guS.field_username)) {
                                    NormalUserFooterPreference.this.lXu = true;
                                    Bb();
                                    bnG();
                                    for (String aU : list) {
                                        b.aU(aU, NormalUserFooterPreference.this.eLK);
                                    }
                                    au.getNotification().xR();
                                    return;
                                }
                                return;
                            }
                            return;
                        } else if (lVar.getType() == 667 || lVar.getType() == 853) {
                            NormalUserFooterPreference.this.lXu = true;
                            Bb();
                            bnG();
                            b.aU(NormalUserFooterPreference.this.guS.field_username, NormalUserFooterPreference.this.eLK);
                            au.getNotification().xR();
                            return;
                        }
                    }
                    if (i == 4 && i2 == -302) {
                        if (lVar.getType() == 30) {
                            i4 = ((m) lVar).bOh;
                        } else {
                            i4 = 0;
                        }
                        x.w("MicroMsg.NormalUserFooterPreference", "VerifyBaseHandler onSceneEnd, verify relation out of date, opCode = %d", Integer.valueOf(i4));
                        if (i4 == 3 || lVar.getType() == 853) {
                            h.a(NormalUserFooterPreference.this.bGc, NormalUserFooterPreference.this.bGc.getString(R.l.contact_info_verify_outofdate_msg), NormalUserFooterPreference.this.bGc.getString(R.l.app_tip), NormalUserFooterPreference.this.bGc.getString(R.l.app_add), NormalUserFooterPreference.this.bGc.getString(R.l.app_cancel), new OnClickListener() {
                                public final void onClick(DialogInterface dialogInterface, int i) {
                                    i.this.bnF();
                                }
                            }, null);
                        }
                    } else if (i == 4 && i2 == -24 && !bi.oW(str)) {
                        Toast.makeText(NormalUserFooterPreference.this.bGc, str, 1).show();
                    } else {
                        switch (i) {
                            case 1:
                                if (!au.DF().Lh()) {
                                    if (com.tencent.mm.network.ab.bU(NormalUserFooterPreference.this.mContext)) {
                                        com.tencent.mm.pluginsdk.ui.j.eY(NormalUserFooterPreference.this.mContext);
                                        i3 = 1;
                                        break;
                                    }
                                }
                                au.DF().getNetworkServerIp();
                                new StringBuilder().append(i2);
                                i3 = 1;
                                break;
                                break;
                            case 2:
                                Toast.makeText(NormalUserFooterPreference.this.mContext, NormalUserFooterPreference.this.mContext.getString(R.l.fmt_iap_err, new Object[]{Integer.valueOf(2), Integer.valueOf(i2)}), 3000).show();
                                i3 = 1;
                                break;
                            case 4:
                                if (i2 != -100) {
                                    CharSequence str2;
                                    if (i == 4 && i2 == -34) {
                                        str2 = NormalUserFooterPreference.this.bGc.getString(R.l.fmessage_request_too_offen);
                                    } else if (i == 4 && i2 == -94) {
                                        str2 = NormalUserFooterPreference.this.bGc.getString(R.l.fmessage_user_not_support);
                                    } else if (i != 4 || bi.oW(str2)) {
                                        str2 = NormalUserFooterPreference.this.bGc.getString(R.l.sendrequest_send_fail);
                                    }
                                    Toast.makeText(NormalUserFooterPreference.this.bGc, str2, 1).show();
                                    break;
                                }
                                h.a(NormalUserFooterPreference.this.mContext, au.Dh(), com.tencent.mm.bp.a.af(NormalUserFooterPreference.this.mContext, R.l.app_tip), new 1(this), new 2(this));
                                i3 = 1;
                                break;
                                break;
                        }
                        if (i3 == 0) {
                        }
                    }
                }
            }
        }
    }

    class j extends i implements e {
        public j() {
            super();
        }

        protected final void bnC() {
            if (NormalUserFooterPreference.this.guS == null || !com.tencent.mm.l.a.gd(NormalUserFooterPreference.this.guS.field_type)) {
                z(false, true);
            } else {
                bnB();
            }
        }

        protected final void bnA() {
            super.bnA();
            NormalUserFooterPreference.this.lXg.setVisibility(0);
            NormalUserFooterPreference.this.lXp.setVisibility(8);
            NormalUserFooterPreference.this.kXG.setVisibility(8);
            NormalUserFooterPreference.this.lXs.setVisibility(8);
            NormalUserFooterPreference.this.lXq.setVisibility(8);
            NormalUserFooterPreference.this.lXr.setVisibility(8);
            NormalUserFooterPreference.this.lXm.setVisibility(8);
            NormalUserFooterPreference.this.lXt.setVisibility(8);
            switch (NormalUserFooterPreference.this.eLK) {
                case 1:
                case 2:
                case 3:
                case 12:
                case 13:
                case 18:
                case 22:
                case 23:
                case 24:
                case 25:
                case 26:
                case 27:
                case 28:
                case 29:
                case 30:
                case 34:
                case 58:
                case 59:
                case 60:
                    NormalUserFooterPreference.this.lXl.setVisibility(0);
                    NormalUserFooterPreference.this.lXk.setVisibility(0);
                    break;
                default:
                    NormalUserFooterPreference.this.lXl.setVisibility(8);
                    NormalUserFooterPreference.this.lXk.setVisibility(8);
                    break;
            }
            if (NormalUserFooterPreference.this.guS.BA()) {
                NormalUserFooterPreference.this.lXj.setText(NormalUserFooterPreference.this.bGc.getString(R.l.contact_info_moveout_blacklist));
                NormalUserFooterPreference.this.lXt.setVisibility(0);
            } else {
                NormalUserFooterPreference.this.lXj.setText(NormalUserFooterPreference.this.bGc.getString(R.l.contact_info_movein_blacklist));
            }
            NormalUserFooterPreference.this.lXh.setOnClickListener(new 1(this));
            NormalUserFooterPreference.this.lXj.setOnClickListener(new 2(this));
        }

        protected final void onDetach() {
            super.onDetach();
        }

        protected final void bnG() {
            super.bnG();
        }

        public final void a(int i, int i2, String str, l lVar) {
            super.a(i, i2, str, lVar);
        }
    }

    public NormalUserFooterPreference(Context context) {
        super(context);
        this.bGc = (MMActivity) context;
        init();
    }

    public NormalUserFooterPreference(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bGc = (MMActivity) context;
        init();
    }

    public NormalUserFooterPreference(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.bGc = (MMActivity) context;
        init();
    }

    private void init() {
        this.iAc = false;
        this.lXf = null;
    }

    private void initView() {
        if (!this.iAc || this.guS == null) {
            x.w("MicroMsg.NormalUserFooterPreference", "iniView : bindView = " + this.iAc + " contact = " + this.guS);
            if (this.lXf != null) {
                try {
                    this.lXf.bnC();
                    return;
                } catch (Throwable th) {
                    return;
                }
            }
            return;
        }
        if (this.lXf != null) {
            this.lXf.FC();
        }
        bnx();
    }

    public final void onBindView(View view) {
        x.d("MicroMsg.NormalUserFooterPreference", "on bindView " + view.toString());
        this.lXg = view.findViewById(R.h.contact_info_passive_verify);
        this.lXh = (Button) view.findViewById(R.h.contact_info_verify_accept);
        this.lXi = (Button) view.findViewById(R.h.contact_info_delete_contact);
        this.lXl = (Button) view.findViewById(R.h.contact_info_verify_expose_btn);
        this.lXk = view.findViewById(R.h.contact_info_verify_mid);
        this.lXj = (Button) view.findViewById(R.h.contact_info_verify_add_black);
        this.lXp = (Button) view.findViewById(R.h.contact_info_add_contact_btn);
        this.lXm = view.findViewById(R.h.contact_info_sayhi_item);
        this.lXn = (Button) view.findViewById(R.h.contact_info_sayhi_expose_btn);
        this.lXo = (Button) view.findViewById(R.h.contact_info_sayhi_request_btn);
        this.kXG = (Button) view.findViewById(R.h.contact_info_send_btn);
        this.lXs = (Button) view.findViewById(R.h.contact_info_mod_snspermission_btn);
        this.lXq = (Button) view.findViewById(R.h.contact_info_voip_btn);
        this.lXr = (Button) view.findViewById(R.h.contact_info_black_list_expose_btn);
        this.lXt = (TextView) view.findViewById(R.h.contact_info_movein_blacklist_tip_tv);
        this.iAc = true;
        initView();
        super.onBindView(view);
        if (this.bGc.getIntent().getBooleanExtra("Accept_NewFriend_FromOutside", false) && this.lXh != null) {
            this.lXh.performClick();
        }
    }

    public final boolean a(ab abVar, String str, boolean z, boolean z2, boolean z3, int i, int i2, boolean z4, boolean z5, long j, String str2) {
        auw();
        Assert.assertTrue(abVar != null);
        Assert.assertTrue(bi.oV(abVar.field_username).length() > 0);
        if (ab.XV(q.GF()).equals(abVar.field_username)) {
            return false;
        }
        this.guS = abVar;
        this.juZ = str;
        this.lUD = z;
        this.eLK = i;
        this.lWd = i2;
        this.lXc = bi.a(Boolean.valueOf(s.hc(abVar.field_username)), false);
        this.lXa = z4;
        this.lXb = z5;
        this.lWQ = j;
        this.lWl = str2;
        this.lXv = false;
        this.lWr = abVar.field_deleteFlag == 1;
        this.lXu = this.bGc.getIntent().getBooleanExtra("Contact_AlwaysShowSnsPreBtn", false);
        this.lVM = this.bGc.getIntent().getIntExtra("add_more_friend_search_scene", 0);
        this.lXd = this.bGc.getIntent().getBooleanExtra("Contact_IsLbsChattingProfile", false);
        this.lXe = this.bGc.getIntent().getBooleanExtra("Contact_IsLbsGotoChatting", false);
        this.hev = this.bGc.getIntent().getStringExtra("lbs_ticket");
        if (!q.gQ(abVar.field_username)) {
            au.HU();
            if (!c.FZ().has(abVar.field_username)) {
                if (ab.XO(abVar.field_username)) {
                    this.lXf = new h(this);
                } else if (s.hr(abVar.field_username)) {
                    this.lXf = new d(this);
                } else if (s.hc(abVar.field_username)) {
                    this.lXf = new g(this);
                } else if (ab.XP(abVar.field_username)) {
                    this.lXf = new f(this);
                } else if (com.tencent.mm.l.a.gd(abVar.field_type) && !ab.gY(abVar.field_username)) {
                    this.lXf = new c(this);
                    this.lXv = true;
                } else if (z2) {
                    this.lXf = new j();
                    this.lXv = true;
                } else if (z3 || ab.gY(abVar.field_username)) {
                    this.lXf = new b(this);
                } else {
                    this.lXf = new c(this);
                    this.lXv = true;
                }
                initView();
                return true;
            }
        }
        this.lXf = new c(this);
        this.lXv = true;
        initView();
        return true;
    }

    public final boolean bnx() {
        if (this.lXu && com.tencent.mm.l.a.gd(this.guS.field_type)) {
            this.lXs.setVisibility(0);
            return true;
        }
        this.lXs.setVisibility(8);
        return false;
    }

    public final boolean auw() {
        if (this.lXf != null) {
            this.lXf.onDetach();
        }
        this.dHn.removeAll();
        if (this.eHw != null) {
            this.eHw.dismiss();
            this.eHw = null;
        }
        return true;
    }

    public final void a(String str, com.tencent.mm.sdk.e.l lVar) {
        if (bi.oV(str).length() <= 0 || this.guS == null) {
            return;
        }
        if (str.equals(this.guS.field_username) || str.equals(this.guS.field_encryptUsername)) {
            au.HU();
            this.guS = c.FR().Yg(this.guS.field_username);
            ah.A(new 2(this));
        }
    }

    public final void bny() {
        x.i("MicroMsg.NormalUserFooterPreference", "summerper checkPermission checkmicrophone[%b], stack[%s], activity[%s]", Boolean.valueOf(com.tencent.mm.pluginsdk.permission.a.a(this.bGc, "android.permission.RECORD_AUDIO", 82, "", "")), bi.cjd(), this.bGc);
        if (com.tencent.mm.pluginsdk.permission.a.a(this.bGc, "android.permission.RECORD_AUDIO", 82, "", "")) {
            su suVar = new su();
            suVar.cdE.bOh = 5;
            suVar.cdE.talker = this.guS.field_username;
            suVar.cdE.context = this.bGc;
            suVar.cdE.cdz = 4;
            com.tencent.mm.sdk.b.a.sFg.m(suVar);
        }
    }

    public final void bnz() {
        x.i("MicroMsg.NormalUserFooterPreference", "summerper checkPermission checkCamera[%b], stack[%s], activity[%s]", Boolean.valueOf(com.tencent.mm.pluginsdk.permission.a.a(this.bGc, "android.permission.CAMERA", 19, "", "")), bi.cjd(), this.bGc);
        if (com.tencent.mm.pluginsdk.permission.a.a(this.bGc, "android.permission.CAMERA", 19, "", "")) {
            x.i("MicroMsg.NormalUserFooterPreference", "summerper checkPermission checkmicrophone[%b], stack[%s], activity[%s]", Boolean.valueOf(com.tencent.mm.pluginsdk.permission.a.a(this.bGc, "android.permission.RECORD_AUDIO", 19, "", "")), bi.cjd(), this.bGc);
            if (com.tencent.mm.pluginsdk.permission.a.a(this.bGc, "android.permission.RECORD_AUDIO", 19, "", "")) {
                su suVar = new su();
                suVar.cdE.bOh = 5;
                suVar.cdE.talker = this.guS.field_username;
                suVar.cdE.context = this.bGc;
                suVar.cdE.cdz = 2;
                com.tencent.mm.sdk.b.a.sFg.m(suVar);
            }
        }
    }
}
