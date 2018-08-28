package com.tencent.mm.ui.contact;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.os.Bundle;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;
import com.tencent.map.lib.util.SystemUtil;
import com.tencent.mm.R;
import com.tencent.mm.ab.e;
import com.tencent.mm.bg.d;
import com.tencent.mm.g.a.sh;
import com.tencent.mm.model.au;
import com.tencent.mm.platformtools.ai;
import com.tencent.mm.plugin.appbrand.s$l;
import com.tencent.mm.plugin.messenger.foundation.a.a.h.a;
import com.tencent.mm.pluginsdk.ui.ProfileEditPhoneNumberView;
import com.tencent.mm.pluginsdk.ui.d.j;
import com.tencent.mm.pluginsdk.ui.d.k;
import com.tencent.mm.pluginsdk.ui.tools.l;
import com.tencent.mm.protocal.c.auf;
import com.tencent.mm.protocal.c.aur;
import com.tencent.mm.protocal.c.bar;
import com.tencent.mm.protocal.c.bas;
import com.tencent.mm.sdk.e.m.b;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.ExifHelper;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.bq;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MMClearEditText;
import com.tencent.mm.ui.base.MMTagPanel;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.s;
import com.tencent.mm.ui.tools.g;
import com.tencent.mm.ui.widget.MMEditText;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class ContactRemarkInfoModUI extends MMActivity implements e {
    private String bgo;
    private String csT;
    private ProgressDialog dId;
    private int eLK;
    private String edD;
    private ab guS;
    private String kBP;
    private MMTagPanel lYe;
    private List<String> lYf;
    private b lYg = new 1(this);
    private String qPi;
    private MMClearEditText uiF;
    private TextView uiG;
    private MMEditText uiH;
    private TextView uiI;
    private TextView uiJ;
    private TextView uiK;
    private TextView uiL;
    private ImageView uiM;
    private ImageView uiN;
    private TextView uiO;
    private View uiP;
    private View uiQ;
    private String uiR;
    private boolean uiS = false;
    private boolean uiT = false;
    private boolean uiU = false;
    private boolean uiV = false;
    private boolean uiW = false;
    private a uiX = new a(this, (byte) 0);
    private TextView uiY;
    private ScrollView uiZ;
    private ProfileEditPhoneNumberView uja;
    private String ujb;
    private String ujc;
    private String ujd;
    boolean uje = true;
    boolean ujf = false;
    private boolean ujg = false;
    private String username;

    private class c extends ClickableSpan {
        public String fky;

        public c(String str) {
            this.fky = str;
        }

        public final void onClick(View view) {
            ContactRemarkInfoModUI.this.uiU = true;
            ContactRemarkInfoModUI.this.z(true, -1);
            ContactRemarkInfoModUI.this.uiF.setText(j.a(ContactRemarkInfoModUI.this, ai.oV(this.fky), ContactRemarkInfoModUI.this.uiF.getTextSize()));
            ContactRemarkInfoModUI.this.uiF.setSelection(ContactRemarkInfoModUI.this.uiF.getText().length());
            ContactRemarkInfoModUI.this.uiP.setVisibility(8);
        }

        public final void updateDrawState(TextPaint textPaint) {
            textPaint.setColor(ContactRemarkInfoModUI.this.getResources().getColor(R.e.blue_text_color));
            textPaint.setUnderlineText(false);
        }
    }

    static /* synthetic */ void a(ContactRemarkInfoModUI contactRemarkInfoModUI, boolean z) {
        au.HU();
        if (!com.tencent.mm.model.c.isSDCardAvailable()) {
            s.gH(contactRemarkInfoModUI);
        }
        if (z) {
            h.a(contactRemarkInfoModUI, "", new String[]{contactRemarkInfoModUI.getString(R.l.selectattach_image), contactRemarkInfoModUI.getString(R.l.app_delete)}, "", new 7(contactRemarkInfoModUI));
            return;
        }
        Intent intent = new Intent();
        intent.putExtra("max_select_count", 1);
        intent.putExtra("query_source_type", 0);
        intent.putExtra("send_btn_string", " ");
        intent.addFlags(67108864);
        d.b(contactRemarkInfoModUI, "gallery", ".ui.GalleryEntryUI", intent, 200);
    }

    static /* synthetic */ void c(ContactRemarkInfoModUI contactRemarkInfoModUI) {
        Intent intent = new Intent();
        intent.putExtra("label_id_list", contactRemarkInfoModUI.kBP);
        if (contactRemarkInfoModUI.lYf != null) {
            intent.putStringArrayListExtra("label_str_list", (ArrayList) contactRemarkInfoModUI.lYf);
        }
        intent.putExtra("label_username", contactRemarkInfoModUI.username);
        d.b(contactRemarkInfoModUI, "label", ".ui.ContactLabelUI", intent, 600);
    }

    static /* synthetic */ void q(ContactRemarkInfoModUI contactRemarkInfoModUI) {
        com.tencent.mm.ui.tools.a.c.d(contactRemarkInfoModUI.uiF).Gi(100).a(new 4(contactRemarkInfoModUI));
        com.tencent.mm.ui.tools.a.c.d(contactRemarkInfoModUI.uiH).Gi(800).a(new 5(contactRemarkInfoModUI));
        if (contactRemarkInfoModUI.uje) {
            String obj;
            x.i("MiroMsg.ContactRemarkInfoModUI", "[dealModRemarkDesc] :%s", new Object[]{contactRemarkInfoModUI.username});
            if (contactRemarkInfoModUI.cyh()) {
                obj = contactRemarkInfoModUI.uiH.getText().toString();
                contactRemarkInfoModUI.csT = obj;
                auf auf = new auf();
                auf.rXy = contactRemarkInfoModUI.username;
                auf.jOS = obj;
                au.HU();
                com.tencent.mm.model.c.FQ().b(new a(54, auf));
            }
            String obj2 = contactRemarkInfoModUI.uiF.getText().toString();
            x.i("MiroMsg.ContactRemarkInfoModUI", "Set New RemarkName : " + obj2 + ", Report kvStat, addContactScene = " + contactRemarkInfoModUI.eLK);
            com.tencent.mm.plugin.report.service.h.mEJ.h(10448, new Object[]{Integer.valueOf(contactRemarkInfoModUI.eLK)});
            switch (contactRemarkInfoModUI.guS.getSource()) {
                case 10:
                case 11:
                case 13:
                    com.tencent.mm.plugin.account.friend.a.a pp = com.tencent.mm.plugin.account.b.getAddrUploadStg().pp(contactRemarkInfoModUI.guS.field_username);
                    if (!(pp == null || ai.oW(pp.Xj()))) {
                        if (ai.oW(obj2)) {
                            pp.Xr();
                        } else {
                            pp.eJD &= -2;
                        }
                        com.tencent.mm.plugin.account.b.getAddrUploadStg().a(pp.Xh(), pp);
                        break;
                    }
            }
            au.HU();
            bq Hh = com.tencent.mm.model.c.FS().Hh(contactRemarkInfoModUI.guS.field_username);
            if ((Hh == null || ai.oW(Hh.field_encryptUsername)) && !ai.oW(contactRemarkInfoModUI.guS.field_encryptUsername)) {
                au.HU();
                Hh = com.tencent.mm.model.c.FS().Hh(contactRemarkInfoModUI.guS.field_encryptUsername);
            }
            if (!(Hh == null || ai.oW(Hh.field_encryptUsername))) {
                au.HU();
                com.tencent.mm.model.c.FS().Hi(Hh.field_encryptUsername);
            }
            if (contactRemarkInfoModUI.mj(false)) {
                contactRemarkInfoModUI.bgo = obj2;
                x.i("MiroMsg.ContactRemarkInfoModUI", "usernamne %s operationSetRemark %s", new Object[]{contactRemarkInfoModUI.guS.field_username, obj2});
                com.tencent.mm.model.s.b(contactRemarkInfoModUI.guS, obj2);
            } else {
                x.i("MiroMsg.ContactRemarkInfoModUI", "remarkNameChanged", new Object[]{Boolean.valueOf(contactRemarkInfoModUI.mj(false))});
            }
            contactRemarkInfoModUI.cyg();
            obj = contactRemarkInfoModUI.bgo;
            obj2 = contactRemarkInfoModUI.csT;
            String str = contactRemarkInfoModUI.edD;
            x.i("MiroMsg.ContactRemarkInfoModUI", "[saveRemarkInfo] :%s :%s", new Object[]{contactRemarkInfoModUI.username, obj});
            au.HU();
            ab Yg = com.tencent.mm.model.c.FR().Yg(contactRemarkInfoModUI.username);
            if (Yg == null || ((int) Yg.dhP) <= 0 || !com.tencent.mm.l.a.gd(Yg.field_type)) {
                x.e("MiroMsg.ContactRemarkInfoModUI", "[saveRemarkInfo] is error!");
            } else {
                contactRemarkInfoModUI.guS.dv(obj);
                contactRemarkInfoModUI.guS.dT(obj2);
                contactRemarkInfoModUI.guS.dU(str);
                contactRemarkInfoModUI.guS.BH();
                au.HU();
                boolean S = com.tencent.mm.model.c.FR().S(contactRemarkInfoModUI.guS);
                x.i("MiroMsg.ContactRemarkInfoModUI", "saveRemarkInfo ret %s", new Object[]{Boolean.valueOf(S)});
                str = "MiroMsg.ContactRemarkInfoModUI";
                String str2 = "remarkDesc (%s, %s, %s)";
                Object[] objArr = new Object[3];
                objArr[0] = Boolean.valueOf(obj2 == null);
                objArr[1] = Integer.valueOf(obj2 == null ? 0 : obj2.length());
                objArr[2] = obj2 == null ? "" : bi.Xf(obj2);
                x.i(str, str2, objArr);
                com.tencent.mm.sdk.b.a.sFg.m(new sh());
            }
            if (!contactRemarkInfoModUI.cyi()) {
                contactRemarkInfoModUI.finish();
            } else if (contactRemarkInfoModUI.uiW) {
                au.DF().a(new com.tencent.mm.at.a(contactRemarkInfoModUI.username), 0);
                contactRemarkInfoModUI.getString(R.l.app_tip);
                contactRemarkInfoModUI.dId = h.a(contactRemarkInfoModUI, contactRemarkInfoModUI.getString(R.l.contact_info_change_remarkimage_save), false, new 8(contactRemarkInfoModUI));
            } else {
                au.DF().a(new com.tencent.mm.at.b(contactRemarkInfoModUI.username, contactRemarkInfoModUI.uiR), 0);
                contactRemarkInfoModUI.getString(R.l.app_tip);
                contactRemarkInfoModUI.dId = h.a(contactRemarkInfoModUI, contactRemarkInfoModUI.getString(R.l.contact_info_change_remarkimage_uploading), false, null);
            }
        }
    }

    private void aAM() {
        boolean z;
        ProfileEditPhoneNumberView profileEditPhoneNumberView = this.uja;
        ArrayList phoneNumberList = profileEditPhoneNumberView.getPhoneNumberList();
        if (phoneNumberList == null || phoneNumberList.isEmpty()) {
            if (profileEditPhoneNumberView.qGk != null) {
                z = true;
            }
            z = false;
        } else if (profileEditPhoneNumberView.qGk == null) {
            z = true;
        } else if (phoneNumberList.size() != profileEditPhoneNumberView.qGk.length) {
            z = true;
        } else {
            Iterator it = phoneNumberList.iterator();
            int i = 0;
            while (it.hasNext()) {
                if (!((String) it.next()).equals(profileEditPhoneNumberView.qGk[i])) {
                    z = true;
                    break;
                }
                i++;
            }
            z = false;
        }
        this.ujg = z;
        if (cyh() || cyi() || mj(false) || this.ujg) {
            enableOptionMenu(true);
        } else {
            enableOptionMenu(false);
        }
    }

    public void onCreate(Bundle bundle) {
        int i = 0;
        super.onCreate(bundle);
        au.DF().a(575, this);
        au.DF().a(576, this);
        this.eLK = getIntent().getIntExtra("Contact_Scene", 9);
        this.qPi = getIntent().getStringExtra("Contact_RoomNickname");
        this.uiV = getIntent().getBooleanExtra("view_mode", false);
        this.ujd = getIntent().getStringExtra("contact_auto_app_phone_from_chatting");
        this.ujb = getIntent().getStringExtra("contact_phone_number_by_md5");
        this.ujc = getIntent().getStringExtra("contact_phone_number_list");
        this.username = getIntent().getStringExtra("Contact_User");
        if (ai.oW(this.username)) {
            finish();
            return;
        }
        int i2;
        au.HU();
        this.guS = com.tencent.mm.model.c.FR().Yg(this.username);
        this.bgo = this.guS.field_conRemark;
        this.csT = this.guS.csT;
        this.edD = this.guS.csU;
        this.kBP = this.guS.field_contactLabelIds;
        this.lYf = com.tencent.mm.plugin.label.a.a.aYK().FC(this.kBP);
        initView();
        aAM();
        if (this.guS == null || !ab.XR(this.guS.field_username)) {
            i2 = 0;
        } else {
            i2 = 1;
        }
        if (i2 != 0 && this.uiF != null) {
            View view = (ViewGroup) this.uiF.getParent();
            ViewGroup viewGroup = (ViewGroup) view.getParent();
            int childCount = viewGroup.getChildCount();
            while (i < childCount) {
                View childAt = viewGroup.getChildAt(i);
                if (childAt != view) {
                    childAt.setVisibility(8);
                }
                i++;
            }
        }
    }

    public void onResume() {
        super.onResume();
        au.HU();
        com.tencent.mm.model.c.FR().a(this.lYg);
        bnI();
    }

    protected void onPause() {
        au.HU();
        com.tencent.mm.model.c.FR().b(this.lYg);
        super.onPause();
    }

    public void onDestroy() {
        au.DF().b(575, this);
        au.DF().b(576, this);
        super.onDestroy();
    }

    protected final int getLayoutId() {
        return R.i.contact_remark_info_mod;
    }

    private void z(boolean z, int i) {
        if (this.uiU) {
            this.uiI.setVisibility(8);
            if (z && ai.oW(this.csT)) {
                this.uiJ.setVisibility(0);
                this.uiQ.setVisibility(8);
            } else if (i == R.h.contact_info_remark_desc_tv) {
                this.uiJ.setVisibility(8);
                this.uiQ.setVisibility(0);
            }
            this.uiF.setVisibility(0);
            return;
        }
        this.uiI.setVisibility(0);
        this.uiJ.setVisibility(0);
        this.uiF.setVisibility(8);
        this.uiQ.setVisibility(8);
    }

    protected final void initView() {
        boolean z;
        k kVar;
        this.uiG = (TextView) findViewById(R.h.contact_info_mod_remark_name_hint_tv);
        this.uiI = (TextView) findViewById(R.h.contact_info_remark_name_tv);
        this.uiJ = (TextView) findViewById(R.h.contact_info_remark_desc_tv);
        this.uiK = (TextView) findViewById(R.h.contact_info_remark_image_tv);
        this.uiF = (MMClearEditText) findViewById(R.h.contact_info_mod_remark_name_et);
        this.uiH = (MMEditText) findViewById(R.h.contact_info_mod_remark_desc_et);
        this.uiM = (ImageView) findViewById(R.h.remark_pic_display);
        this.uiN = (ImageView) findViewById(R.h.remark_pic_failed);
        this.uiL = (TextView) findViewById(R.h.wordcount);
        this.uiQ = findViewById(R.h.contact_info_mod_remark_desc_container);
        this.uja = (ProfileEditPhoneNumberView) findViewById(R.h.mod_phone_number);
        this.uja.ipd = this.guS;
        ProfileEditPhoneNumberView profileEditPhoneNumberView = this.uja;
        String str = this.ujb;
        String str2 = this.ujc;
        profileEditPhoneNumberView.qGi = str;
        profileEditPhoneNumberView.qGj = str2;
        profileEditPhoneNumberView.bnH();
        this.uja.qGn = new 10(this);
        this.lYe = (MMTagPanel) findViewById(R.h.contact_info_mod_label_et);
        this.lYe.setPanelClickable(false);
        this.uiZ = (ScrollView) findViewById(R.h.scrollview);
        this.uiY = (TextView) findViewById(R.h.contact_info_label_tv);
        this.uiY.setText(R.l.mod_label_hint);
        this.lYe.setOnClickListener(this.uiX);
        this.uiY.setOnClickListener(this.uiX);
        setMMTitle(R.l.contact_info_mod_remarkinfo);
        if (ai.oW(this.bgo)) {
            this.uiF.setText(j.a(this, ai.oV(this.guS.BK()), this.uiF.getTextSize()));
            this.uiI.setText(j.a(this, ai.oV(this.guS.BK()), this.uiF.getTextSize()));
        } else {
            this.uiF.setText(j.a(this, ai.oV(this.bgo), this.uiF.getTextSize()));
            this.uiI.setText(j.a(this, ai.oV(this.bgo), this.uiI.getTextSize()));
        }
        this.uiF.setSelection(this.uiF.getText().length());
        this.uiH.setText(j.a(this, ai.oV(this.csT), this.uiJ.getTextSize()));
        this.uiH.setSelection(this.uiH.getText().length());
        if (!ai.oW(this.csT)) {
            this.uiJ.setText(j.a(this, ai.oV(this.csT), this.uiJ.getTextSize()));
            this.uiJ.setTextColor(getResources().getColor(R.e.normal_text_color));
        }
        this.uiI.setOnClickListener(new 12(this));
        this.uiJ.setOnClickListener(new 13(this));
        this.uiF.addTextChangedListener(new 14(this));
        this.uiL.setText(g.be(800, this.uiH.getEditableText().toString()));
        this.uiH.setOnFocusChangeListener(new 15(this));
        this.uiH.addTextChangedListener(new b(this, (byte) 0));
        if (ai.oW(this.edD)) {
            this.uiK.setVisibility(0);
            this.uiM.setVisibility(8);
        } else {
            this.uiK.setVisibility(8);
            this.uiM.setVisibility(0);
            com.tencent.mm.at.c.Qt();
            if (com.tencent.mm.at.c.mz(this.username)) {
                cyf();
            } else {
                com.tencent.mm.at.c.Qt().a(this.username, this.edD, new 6(this));
            }
        }
        this.uiM.setOnClickListener(new 16(this));
        this.uiK.setOnClickListener(new 17(this));
        com.tencent.mm.plugin.account.friend.a.a pp = com.tencent.mm.plugin.account.b.getAddrUploadStg().pp(this.guS.field_username);
        if (pp == null || ai.oW(pp.Xj()) || pp.Xj().equals(this.uiF.getText().toString())) {
            z = false;
        } else {
            this.uiO = (TextView) findViewById(R.h.mode_remark_mobile_name);
            this.uiP = findViewById(R.h.mod_remark_mobile_name_area);
            this.uiP.setVisibility(0);
            this.uiO.setText(ai.oV(getString(R.l.contact_info_set_reamrk_mobile_name, new Object[]{pp.Xj()})));
            kVar = new k(getString(R.l.write_contact_remark));
            kVar.setSpan(new c(pp.Xj()), 0, kVar.length(), 17);
            this.uiO.append(" ");
            this.uiO.append(kVar);
            this.uiO.setMovementMethod(LinkMovementMethod.getInstance());
            z = true;
        }
        if (!(z || this.eLK != 14 || ai.oW(this.qPi) || this.qPi.equals(this.uiF.getText().toString()))) {
            this.uiO = (TextView) findViewById(R.h.mode_remark_mobile_name);
            this.uiP = findViewById(R.h.mod_remark_mobile_name_area);
            this.uiP.setVisibility(0);
            this.uiO.setText(j.a(this, ai.oV(getString(R.l.contact_info_set_reamrk_chatroom_name, new Object[]{this.qPi})), this.uiO.getTextSize()));
            kVar = new k(getString(R.l.write_contact_remark));
            kVar.setSpan(new c(this.qPi), 0, kVar.length(), 17);
            this.uiO.append(" ");
            this.uiO.append(kVar);
            this.uiO.setMovementMethod(LinkMovementMethod.getInstance());
        }
        a(0, getString(R.l.app_finish), new 18(this), com.tencent.mm.ui.s.b.tmX);
        setBackBtn(new 2(this));
        if (ai.oW(this.bgo)) {
            enableOptionMenu(true);
        } else {
            enableOptionMenu(false);
        }
        this.uiN.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                ContactRemarkInfoModUI.a(ContactRemarkInfoModUI.this, true);
                ContactRemarkInfoModUI.this.cye();
            }
        });
        if (!this.uiV) {
            this.uiU = true;
            z(true, -1);
        }
        cye();
    }

    private void cye() {
        this.uiG.setFocusableInTouchMode(true);
        this.uiG.requestFocus();
        this.uiF.clearFocus();
        this.uiH.clearFocus();
        this.uja.clearFocus();
        YC();
    }

    private void cyf() {
        com.tencent.mm.at.c.Qt();
        Bitmap mB = com.tencent.mm.at.c.mB(this.username);
        if (mB != null) {
            this.uiK.setVisibility(8);
            this.uiN.setVisibility(8);
            this.uiM.setVisibility(0);
            this.uiM.setImageBitmap(mB);
        }
        this.uiS = true;
    }

    private void aaL(String str) {
        if (!ai.oW(str)) {
            File file = new File(str);
            if (!file.exists()) {
                return;
            }
            if (file.length() > 204800) {
                h.b(this, getString(R.l.contact_info_change_remarkimage_error_too_big), null, true);
                return;
            }
            Bitmap e = BackwardSupportUtil.b.e(this.uiR, com.tencent.mm.bp.a.getDensity(this));
            if (e != null) {
                this.uiK.setVisibility(8);
                this.uiN.setVisibility(8);
                this.uiM.setVisibility(0);
                this.uiM.setImageBitmap(e);
                this.uiS = true;
            }
        }
    }

    private void cyg() {
        if (this.ujg) {
            String str;
            aur aur = new aur();
            aur.rXy = this.username;
            bas bas = new bas();
            ArrayList phoneNumberList = this.uja.getPhoneNumberList();
            bas.hbF = phoneNumberList == null ? 0 : phoneNumberList.size();
            bas.sdd = new LinkedList();
            if (phoneNumberList != null) {
                Iterator it = phoneNumberList.iterator();
                while (it.hasNext()) {
                    str = (String) it.next();
                    bar bar = new bar();
                    bar.sdc = str;
                    bas.sdd.add(bar);
                }
            }
            aur.rXu = bas;
            au.HU();
            com.tencent.mm.model.c.FQ().b(new a(60, aur));
            au.HU();
            ab Yg = com.tencent.mm.model.c.FR().Yg(this.username);
            if (Yg != null && ((int) Yg.dhP) > 0 && com.tencent.mm.l.a.gd(Yg.field_type)) {
                String str2;
                str = "";
                if (phoneNumberList != null) {
                    Iterator it2 = phoneNumberList.iterator();
                    while (true) {
                        str2 = str;
                        if (!it2.hasNext()) {
                            break;
                        }
                        str = (str2 + ((String) it2.next())) + ",";
                    }
                } else {
                    str2 = str;
                }
                x.i("MiroMsg.ContactRemarkInfoModUI", "[dealModPhoneNumberList] username:%s %s", new Object[]{this.username, str2});
                this.guS.dZ(str2);
                au.HU();
                com.tencent.mm.model.c.FR().S(this.guS);
            }
        }
    }

    private boolean mj(boolean z) {
        String obj = this.uiF.getText().toString();
        if (z) {
            boolean z2;
            if ((this.bgo == null || !this.bgo.equals(obj)) && !(ai.oW(this.bgo) && ai.oW(obj))) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (!z2 || (obj != null && obj.equals(this.guS.field_nickname))) {
                return false;
            }
            return true;
        } else if ((this.bgo == null || !this.bgo.equals(obj)) && (!ai.oW(this.bgo) || !ai.oW(obj))) {
            return true;
        } else {
            return false;
        }
    }

    private boolean cyh() {
        String obj = this.uiH.getText().toString();
        return (this.csT == null || !this.csT.equals(obj)) && !(ai.oW(this.csT) && ai.oW(obj));
    }

    private boolean cyi() {
        return !ai.oW(this.uiR) || this.uiW;
    }

    private void goBack() {
        boolean cyi = cyi();
        boolean mj = mj(true);
        boolean cyh = cyh();
        if (cyi || mj || cyh) {
            h.a(this, getString(R.l.contact_info_remark_info_cancel_alert), null, getString(R.l.contact_info_remark_info_cancel_alert_save), getString(R.l.contact_info_remark_info_cancel_alert_cancel), new 9(this), new 11(this));
            return;
        }
        YC();
        finish();
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (keyEvent.getKeyCode() != 4) {
            return false;
        }
        goBack();
        return true;
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        x.i("MiroMsg.ContactRemarkInfoModUI", "onAcvityResult requestCode:%d, resultCode:%d", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
        if (intent == null) {
            x.e("MiroMsg.ContactRemarkInfoModUI", "data shouldnot be null");
            return;
        }
        Context applicationContext;
        String d;
        switch (i) {
            case s$l.AppCompatTheme_buttonStyle /*100*/:
                applicationContext = getApplicationContext();
                au.HU();
                d = l.d(applicationContext, intent, com.tencent.mm.model.c.Gb());
                if (d != null) {
                    this.uiR = aaM(d);
                    aaL(this.uiR);
                    this.uiT = true;
                    this.uiW = false;
                    aAM();
                    return;
                }
                return;
            case 200:
                applicationContext = getApplicationContext();
                au.HU();
                d = com.tencent.mm.ui.tools.a.e(applicationContext, intent, com.tencent.mm.model.c.Gb());
                if (d != null) {
                    this.uiR = aaM(d);
                    aaL(this.uiR);
                    this.uiT = true;
                    this.uiW = false;
                    aAM();
                    return;
                }
                return;
            case SystemUtil.SMALL_SCREEN_THRESHOLD /*400*/:
                if (intent.getBooleanExtra("response_delete", false)) {
                    cyj();
                    return;
                }
                return;
            case 600:
                if (mj(true) || cyh() || cyi() || intent.getBooleanExtra("hasLableChange", false)) {
                    enableOptionMenu(true);
                    return;
                } else {
                    enableOptionMenu(false);
                    return;
                }
            default:
                return;
        }
    }

    private void cyj() {
        this.uiW = true;
        this.uiN.setVisibility(8);
        this.uiK.setVisibility(0);
        this.uiM.setVisibility(8);
        this.uiM.setImageBitmap(null);
        aAM();
    }

    public final void a(int i, int i2, String str, com.tencent.mm.ab.l lVar) {
        x.i("MiroMsg.ContactRemarkInfoModUI", "onSceneEnd: errType = " + i + " errCode = " + i2 + " errMsg = " + str);
        if (this.dId != null) {
            this.dId.dismiss();
            this.dId = null;
        }
        if (i == 0 && i2 == 0) {
            if (lVar.getType() == 575) {
                if (this.uiR != null) {
                    File file = new File(this.uiR);
                    if (file.exists()) {
                        com.tencent.mm.at.c.Qt();
                        file.renameTo(new File(com.tencent.mm.at.c.my(this.username)));
                    }
                }
                String str2 = ((com.tencent.mm.at.b) lVar).edD;
                if (!ai.oW(str2)) {
                    this.edD = str2;
                }
            } else if (lVar.getType() == 576) {
                this.uiR = null;
                this.edD = null;
                this.uiS = false;
                au.HU();
                this.guS = com.tencent.mm.model.c.FR().Yg(this.username);
                this.guS.dU("");
                au.HU();
                com.tencent.mm.model.c.FR().a(this.username, this.guS);
            }
            finish();
            return;
        }
        h.b(this, getString(R.l.app_err_server_busy_tip), null, true);
    }

    private String aaM(String str) {
        if (!com.tencent.mm.a.e.cn(str)) {
            return null;
        }
        int VX = ExifHelper.VX(str);
        StringBuilder stringBuilder = new StringBuilder();
        com.tencent.mm.at.c.Qt();
        String stringBuilder2 = stringBuilder.append(com.tencent.mm.at.c.my(this.username)).append(".tmp").toString();
        if (!com.tencent.mm.sdk.platformtools.c.a(str, 960, 960, CompressFormat.JPEG, 70, stringBuilder2)) {
            x.e("MiroMsg.ContactRemarkInfoModUI", "createThumbNail big pic fail");
            return null;
        } else if (VX == 0 || com.tencent.mm.sdk.platformtools.c.a(stringBuilder2, VX, CompressFormat.JPEG, 70, stringBuilder2)) {
            return stringBuilder2;
        } else {
            x.e("MiroMsg.ContactRemarkInfoModUI", "rotate big pic fail");
            return null;
        }
    }

    private void bnI() {
        au.HU();
        this.guS = com.tencent.mm.model.c.FR().Yg(this.username);
        this.kBP = this.guS.field_contactLabelIds;
        this.lYf = com.tencent.mm.plugin.label.a.a.aYK().FC(this.kBP);
        if (ai.oW(this.kBP)) {
            this.lYe.setVisibility(8);
            this.uiY.setVisibility(0);
            return;
        }
        this.lYe.setVisibility(0);
        this.uiY.setVisibility(8);
        this.lYe.a(this.lYf, this.lYf);
    }
}
