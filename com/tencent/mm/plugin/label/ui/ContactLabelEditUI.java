package com.tencent.mm.plugin.label.ui;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import com.tencent.mm.R;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.bg.d;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.model.q;
import com.tencent.mm.plugin.label.b.a;
import com.tencent.mm.plugin.label.b.b;
import com.tencent.mm.plugin.label.ui.widget.InputClearablePreference;
import com.tencent.mm.pluginsdk.ui.applet.ContactListExpandPreference;
import com.tencent.mm.protocal.c.aqf;
import com.tencent.mm.protocal.c.bxe;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.ad;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.PreferenceTitleCategory;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.ui.contact.s;
import com.tencent.mm.ui.tools.g;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class ContactLabelEditUI extends MMPreference implements e {
    private ProgressDialog eEX;
    private String kAJ;
    private String kAK;
    private String kAL;
    private ad kAM;
    private String kAN;
    private f kAO;
    private ContactListExpandPreference kAP;
    private InputClearablePreference kAQ;
    private Preference kAR;
    private PreferenceTitleCategory kAS;
    private boolean kAT = true;
    private ArrayList<String> kAU = new ArrayList();
    private ArrayList<String> kAV = new ArrayList();
    private HashSet<String> kAW = new HashSet();
    private HashSet<String> kAX = new HashSet();
    private String kAY;
    private boolean kum = true;
    private ag mHandler = new 1(this, Looper.getMainLooper());

    static /* synthetic */ void b(ContactLabelEditUI contactLabelEditUI) {
        x.i("MicroMsg.Label.ContactLabelEditUI", "cpan[saveLabelChange]");
        contactLabelEditUI.FE(contactLabelEditUI.getString(R.l.label_saving));
        contactLabelEditUI.kAK = bi.aG(contactLabelEditUI.kAK, "");
        contactLabelEditUI.kAK = contactLabelEditUI.kAK.trim();
        if (bi.oW(contactLabelEditUI.kAK)) {
            contactLabelEditUI.aYM();
            contactLabelEditUI.zK(contactLabelEditUI.getString(R.l.label_name_cannot_empty));
        } else if (g.abd(contactLabelEditUI.kAK) > 36) {
            contactLabelEditUI.aYM();
            contactLabelEditUI.zK(String.format(contactLabelEditUI.getString(R.l.add_label_over_count), new Object[]{Integer.valueOf(g.be(36, ""))}));
        } else if (!(FG(contactLabelEditUI.kAK) && contactLabelEditUI.kAT) && (!FG(contactLabelEditUI.kAK) || bi.oW(contactLabelEditUI.kAJ) || contactLabelEditUI.kAJ.equals(contactLabelEditUI.kAK))) {
            ad XY = com.tencent.mm.plugin.label.e.aYJ().XY(contactLabelEditUI.kAL);
            if (contactLabelEditUI.kAT || XY.field_isTemporary) {
                au.DF().a(new a(contactLabelEditUI.kAK), 0);
                return;
            }
            au.DF().a(new com.tencent.mm.plugin.label.b.e(Integer.valueOf(contactLabelEditUI.kAL).intValue(), contactLabelEditUI.kAK), 0);
        } else {
            contactLabelEditUI.aYM();
            contactLabelEditUI.zK(contactLabelEditUI.getString(R.l.add_label_exist_msg));
        }
    }

    static /* synthetic */ void d(ContactLabelEditUI contactLabelEditUI) {
        x.i("MicroMsg.Label.ContactLabelEditUI", "cpan[dealAddContact]");
        Intent intent = new Intent();
        intent.putExtra("list_attr", s.s(new int[]{s.ukF, 1024}));
        intent.putExtra("list_type", 1);
        intent.putExtra("titile", contactLabelEditUI.getString(R.l.label_add_member));
        intent.putExtra("show_too_many_member", false);
        intent.putExtra("scene", 6);
        if (contactLabelEditUI.kAU != null) {
            intent.putExtra("always_select_contact", bi.c(contactLabelEditUI.kAU, ","));
        }
        d.b((Context) contactLabelEditUI, ".ui.contact.SelectContactUI", intent, 7001);
    }

    static /* synthetic */ void l(ContactLabelEditUI contactLabelEditUI) {
        if (contactLabelEditUI.kAM.field_isTemporary) {
            contactLabelEditUI.a(contactLabelEditUI.kAM);
            return;
        }
        ad adVar = contactLabelEditUI.kAM;
        if (adVar == null) {
            x.w("MicroMsg.Label.ContactLabelEditUI", "cpan[doDeleteScene] can not do scene. lable is null");
            return;
        }
        contactLabelEditUI.FE(contactLabelEditUI.getString(R.l.label_deleting));
        au.DF().a(new b(adVar.field_labelID), 0);
    }

    public final int Ys() {
        return R.o.label_edit_pref;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.kAY = q.GF();
        this.kAL = getIntent().getStringExtra("label_id");
        this.kAJ = getIntent().getStringExtra("label_name");
        this.kAK = getIntent().getStringExtra("label_name");
        String stringExtra = getIntent().getStringExtra("Select_Contact");
        if (!bi.oW(stringExtra)) {
            List F = bi.F(stringExtra.split(","));
            this.kAU = new ArrayList();
            if (F != null && F.size() > 0) {
                int size = F.size();
                for (int i = 0; i < size; i++) {
                    stringExtra = (String) F.get(i);
                    if (!bi.oW(stringExtra)) {
                        if (!com.tencent.mm.model.s.he(stringExtra) || this.kAU.contains(stringExtra) || stringExtra.equals(this.kAY)) {
                            x.i("MicroMsg.Label.ContactLabelEditUI", "dz[getIntent] %s is no friend or is user self and just filter", new Object[]{stringExtra});
                        } else {
                            this.kAU.add(stringExtra);
                            this.kAW.add(stringExtra);
                        }
                    }
                }
            }
        }
        au.DF().a(635, this);
        au.DF().a(637, this);
        au.DF().a(638, this);
        initView();
    }

    protected void onResume() {
        com.tencent.mm.modelstat.d.b(3, "ContactLabelEditUI" + aYS(), hashCode());
        au.DF().a(636, this);
        FF(this.kAK);
        aYN();
        super.onResume();
    }

    protected void onPause() {
        com.tencent.mm.modelstat.d.b(4, "ContactLabelEditUI" + aYS(), hashCode());
        au.DF().b(636, this);
        super.onPause();
    }

    protected void onDestroy() {
        au.DF().b(635, this);
        au.DF().b(637, this);
        au.DF().b(638, this);
        super.onDestroy();
    }

    protected final void initView() {
        if (bi.oW(this.kAL)) {
            this.kAT = true;
            this.kAN = getString(R.l.pref_label_new_title);
        } else {
            this.kAT = false;
            this.kAM = com.tencent.mm.plugin.label.e.aYJ().XY(this.kAL);
            this.kAN = getString(R.l.pref_label_edit_title);
        }
        setMMTitle(this.kAN);
        setBackBtn(new 7(this));
        a(0, getString(R.l.app_save), new 8(this), com.tencent.mm.ui.s.b.tmX);
        this.kAO = this.tCL;
        this.kAP = (ContactListExpandPreference) this.kAO.ZZ("contact_label_contact_list");
        this.kAP.a(this.kAO, this.kAP.mKey);
        this.kAP.kG(true);
        this.kAP.kH(true);
        this.kAP.cdU();
        this.kAP.cdX();
        this.kAP.a(new 9(this));
        this.kAP.a(new 10(this));
        this.kAQ = (InputClearablePreference) this.kAO.ZZ("contact_label_name");
        InputClearablePreference inputClearablePreference = this.kAQ;
        inputClearablePreference.kCg = getString(R.l.label_input_tip);
        if (inputClearablePreference.kCl != null) {
            inputClearablePreference.kCl.setHint(inputClearablePreference.kCg);
        }
        this.kAQ.fHW = getString(R.l.label_panel_max_tips);
        inputClearablePreference = this.kAQ;
        inputClearablePreference.kCh = getString(R.l.add_label_invaild_msg);
        if (inputClearablePreference.kCn != null) {
            inputClearablePreference.kCn.setText(inputClearablePreference.kCh);
        }
        this.kAQ.kCi = 36;
        this.kAQ.kCk = this.kAT;
        this.kAQ.kCp = new 11(this);
        this.kAQ.setText(this.kAK);
        if (this.mHandler != null) {
            this.mHandler.sendEmptyMessage(6001);
        }
        if (!this.kAT) {
            au.Em().H(new 12(this));
        } else if (this.kAU == null || this.kAU.size() <= 0) {
            this.kAP.aa(new ArrayList());
        } else {
            this.kAP.p(null, this.kAU);
        }
        if (this.kww != null) {
            this.kww.setOnScrollListener(new 13(this));
        }
        this.kAR = this.kAO.ZZ("contact_label_delete");
        this.kAS = (PreferenceTitleCategory) this.kAO.ZZ("contact_label_empty_category");
        if (this.kAT) {
            this.kAO.c(this.kAR);
            this.kAO.c(this.kAS);
        }
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        x.i("MicroMsg.Label.ContactLabelEditUI", "cpan[onActivityResult] requestCode:%d resultCode:%d", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
        if (i2 == -1) {
            switch (i) {
                case 7001:
                    String stringExtra = intent.getStringExtra("Select_Contact");
                    x.i("MicroMsg.Label.ContactLabelEditUI", "cpan[onActivityResult] %s", new Object[]{stringExtra});
                    if (!bi.oW(stringExtra)) {
                        List F = bi.F(stringExtra.split(","));
                        if (F != null && F.size() > 0) {
                            int size = F.size();
                            int i3 = 0;
                            while (i3 < size) {
                                stringExtra = (String) F.get(i3);
                                if (!bi.oW(stringExtra)) {
                                    if (!com.tencent.mm.model.s.he(stringExtra) || this.kAU.contains(stringExtra) || stringExtra.equals(this.kAY)) {
                                        x.i("MicroMsg.Label.ContactLabelEditUI", "dz[getIntent] %s is no friend or is user self and just filter", new Object[]{stringExtra});
                                    } else {
                                        this.kAU.add(stringExtra);
                                        if (!(this.kAV == null || this.kAV.contains(F.get(i3)))) {
                                            this.kAW.add(stringExtra);
                                        }
                                        if (this.kAX != null && this.kAX.contains(stringExtra)) {
                                            this.kAX.remove(stringExtra);
                                        }
                                    }
                                }
                                i3++;
                            }
                        }
                        if (this.mHandler != null) {
                            this.mHandler.sendEmptyMessage(6001);
                            return;
                        }
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    public final boolean a(f fVar, Preference preference) {
        String str = preference.mKey;
        if (bi.oW(str)) {
            x.w("MicroMsg.Label.ContactLabelEditUI", "cpan [onPreferenceTreeClick] key is null.");
        } else {
            if (str.equals("contact_label_delete")) {
                h.a(this, getString(R.l.label_delete_confirm), "", getString(R.l.app_delete), getString(R.l.app_cancel), new 14(this), new 2(this));
            }
            x.d("MicroMsg.Label.ContactLabelEditUI", "cpan [onPreferenceTreeClick] key is %s:", new Object[]{str});
        }
        return false;
    }

    public final void a(int i, int i2, String str, l lVar) {
        x.i("MicroMsg.Label.ContactLabelEditUI", "cpan[onSceneEnd]errType:%d errCode:%d errMsg:%s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str});
        switch (lVar.getType()) {
            case 635:
                if (i == 0 && i2 == 0) {
                    LinkedList linkedList = ((a) lVar).aYL().rbV;
                    if (linkedList == null || linkedList.size() <= 0) {
                        aYP();
                        return;
                    }
                    x.i("MicroMsg.Label.ContactLabelEditUI", "cpan[onSceneEnd] add label pair.LabelID:%s pair.LabelName:%s", new Object[]{r0.rSH, ((aqf) linkedList.get(0)).rSG});
                    this.kAL = r0.rSH;
                    aYQ();
                    return;
                }
                aYP();
                return;
            case 636:
                if (i == 0 && i2 == 0) {
                    a(this.kAM);
                    if (this.mHandler != null) {
                        this.mHandler.sendEmptyMessageDelayed(6002, 300);
                        return;
                    }
                    return;
                }
                x.w("MicroMsg.Label.ContactLabelEditUI", "cpan[onSceneEnd] delete fail.");
                aYR();
                return;
            case 637:
                if (i == 0 && i2 == 0) {
                    int intValue;
                    String str2 = this.kAL;
                    String str3 = this.kAK;
                    x.i("MicroMsg.Label.ContactLabelEditUI", "cpan[doInsertOrUpdateLable]");
                    try {
                        intValue = Integer.valueOf(str2).intValue();
                    } catch (Exception e) {
                        x.e("MicroMsg.Label.ContactLabelEditUI", "id is not integer type:%s", new Object[]{str2});
                        intValue = -1;
                    }
                    if (intValue != -1) {
                        ad XY = com.tencent.mm.plugin.label.e.aYJ().XY(str2);
                        if (XY == null) {
                            XY = new ad();
                        }
                        XY.field_labelID = intValue;
                        XY.field_labelName = str3;
                        XY.field_labelPYFull = com.tencent.mm.platformtools.h.oI(str3);
                        XY.field_labelPYShort = com.tencent.mm.platformtools.h.oJ(str3);
                        com.tencent.mm.plugin.label.e.aYJ().b(true, XY, new String[]{"labelID"});
                    } else {
                        aYP();
                    }
                    aYQ();
                    return;
                }
                aYP();
                return;
            case 638:
                if (i == 0 && i2 == 0) {
                    aYO();
                    if (this.mHandler != null) {
                        this.mHandler.sendEmptyMessageDelayed(6002, 300);
                        return;
                    }
                    return;
                }
                aYP();
                return;
            default:
                return;
        }
    }

    private void aYN() {
        if (this.kAP != null) {
            this.kAP.p(null, this.kAU);
            if (this.kAU == null || this.kAU.size() <= 0) {
                this.kAP.cdV();
            }
        }
        if (this.kAQ != null) {
            this.kAQ.setText(this.kAK);
        }
    }

    private void FF(String str) {
        enableOptionMenu(!bi.oW(str));
    }

    private void aYO() {
        int size;
        x.i("MicroMsg.Label.ContactLabelEditUI", "cpan[savaSuccess]");
        aYM();
        if (this.kAW != null) {
            size = this.kAW.size();
        } else {
            size = 0;
        }
        x.i("MicroMsg.Label.ContactLabelEditUI", "cpan[doUpdateContactList]addnum:%d", new Object[]{Integer.valueOf(size)});
        com.tencent.mm.plugin.report.service.h.mEJ.h(11220, new Object[]{q.GF(), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(size)});
        if (this.kAT) {
            Intent intent = getIntent();
            intent.putExtra("k_sns_label_add_label", this.kAK);
            setResult(0, intent);
        } else {
            setResult(0);
        }
        finish();
    }

    private void aYP() {
        x.i("MicroMsg.Label.ContactLabelEditUI", "cpan[saveFailed]");
        aYM();
        zK(getString(R.l.add_label_fail_msg));
    }

    private static boolean FG(String str) {
        if (bi.oW(com.tencent.mm.plugin.label.e.aYJ().FA(str))) {
            return false;
        }
        return true;
    }

    private void aYQ() {
        int i;
        Iterator it;
        String str;
        String str2;
        String dx;
        bxe bxe;
        String str3 = "MicroMsg.Label.ContactLabelEditUI";
        String str4 = "cpan[doUpdateContactList] addcount:%d,delcount:%d";
        Object[] objArr = new Object[2];
        if (this.kAW == null) {
            i = 0;
        } else {
            i = this.kAW.size();
        }
        objArr[0] = Integer.valueOf(i);
        if (this.kAX == null) {
            i = 0;
        } else {
            i = this.kAX.size();
        }
        objArr[1] = Integer.valueOf(i);
        x.i(str3, str4, objArr);
        LinkedList linkedList = new LinkedList();
        if (this.kAW != null && this.kAW.size() > 0) {
            this.kAW.size();
            it = this.kAW.iterator();
            while (it.hasNext()) {
                str = (String) it.next();
                au.HU();
                ab Yg = c.FR().Yg(str);
                str2 = Yg.field_contactLabelIds;
                dx = com.tencent.mm.plugin.label.c.dx(str2, this.kAL);
                x.i("MicroMsg.Label.ContactLabelEditUI", "labels:%s mixLabelIds:%s", new Object[]{str2, dx});
                if (!dx.equalsIgnoreCase(str2)) {
                    bxe = new bxe();
                    bxe.hbL = Yg.field_username;
                    bxe.rvl = dx;
                    linkedList.add(bxe);
                }
            }
        }
        if (this.kAX != null && this.kAX.size() > 0) {
            this.kAX.size();
            it = this.kAX.iterator();
            while (it.hasNext()) {
                str = (String) it.next();
                au.HU();
                str2 = c.FR().Yg(str).field_contactLabelIds;
                dx = com.tencent.mm.plugin.label.c.dy(str2, this.kAL);
                x.i("MicroMsg.Label.ContactLabelEditUI", "username:%s labels:%s mixLabelIds:%s", new Object[]{str, str2, dx});
                if (!dx.equalsIgnoreCase(str2)) {
                    bxe = new bxe();
                    bxe.hbL = str;
                    bxe.rvl = dx;
                    linkedList.add(bxe);
                }
            }
        }
        if (linkedList.size() > 0) {
            au.DF().a(new com.tencent.mm.plugin.label.b.d(linkedList), 0);
            return;
        }
        aYO();
    }

    private void FE(String str) {
        getString(R.l.app_tip);
        this.eEX = h.a(this, str, true, new 3(this));
    }

    private void aYM() {
        if (this.eEX != null && this.eEX.isShowing()) {
            this.eEX.dismiss();
        }
    }

    private void zK(String str) {
        h.a(this, str, "", new 4(this));
    }

    public void onBackPressed() {
        if ((bi.oW(this.kAK) || this.kAK.equals(this.kAJ)) && ((this.kAW == null || this.kAW.size() <= 0) && (this.kAX == null || this.kAX.size() <= 0))) {
            setResult(0);
            finish();
            return;
        }
        h.a(this, getString(R.l.save_label_msg), "", getString(R.l.btn_save), getString(R.l.btn_unsave), new 5(this), new 6(this));
    }

    private void a(ad adVar) {
        if (com.tencent.mm.plugin.label.e.aYJ().a(true, adVar, new String[]{"labelID"})) {
            setResult(-1);
            finish();
            return;
        }
        x.w("MicroMsg.Label.ContactLabelEditUI", "cpan[doDeleteContactLabel] fail.");
        aYR();
    }

    private void aYR() {
        zK(getString(R.l.del_label_failed_msg));
    }

    protected final String aYS() {
        if (this.kAT) {
            return "_New";
        }
        return "_Edit";
    }
}
