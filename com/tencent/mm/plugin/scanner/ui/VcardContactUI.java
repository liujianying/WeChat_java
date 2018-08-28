package com.tencent.mm.plugin.scanner.ui;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract.Contacts;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.R;
import com.tencent.mm.model.au;
import com.tencent.mm.model.br;
import com.tencent.mm.plugin.scanner.a.o;
import com.tencent.mm.plugin.scanner.a.o.a;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.h.c;
import com.tencent.mm.ui.base.preference.KeyValuePreference;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;
import java.util.ArrayList;
import java.util.List;

public class VcardContactUI extends MMPreference {
    private static ArrayList<String> mMo = new ArrayList();
    private static int mMq = 1;
    private static int mMr = 1;
    private f eOE;
    private o mMn;
    private r mMp;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        initView();
    }

    public final int Ys() {
        return -1;
    }

    public final boolean a(f fVar, Preference preference) {
        if (preference.mKey.equals("add_vcard_contact")) {
            h.a(this, "", new String[]{getString(R.l.v_contact_add_new_contact), getString(R.l.v_contact_add_exist_contact)}, "", new c() {
                public final void ju(int i) {
                    Intent intent;
                    switch (i) {
                        case 0:
                            br.IE().c(10238, new Object[]{Integer.valueOf(1)});
                            intent = new Intent("android.intent.action.INSERT", Contacts.CONTENT_URI);
                            VcardContactUI.a(VcardContactUI.this, intent);
                            VcardContactUI.this.startActivity(intent);
                            return;
                        case 1:
                            br.IE().c(10239, new Object[]{Integer.valueOf(1)});
                            intent = new Intent("android.intent.action.INSERT_OR_EDIT", Contacts.CONTENT_URI);
                            intent.setType("vnd.android.cursor.item/person");
                            VcardContactUI.a(VcardContactUI.this, intent);
                            VcardContactUI.this.startActivity(intent);
                            return;
                        default:
                            return;
                    }
                }
            });
            return true;
        }
        String str;
        if (preference.mKey.equals("v_contact_info_photo_uri") || preference.mKey.equals("v_contact_info_home_page") || preference.mKey.equals("v_contact_info_logo")) {
            String charSequence = preference.getSummary().toString();
            if (charSequence != null && charSequence.length() > 0) {
                r rVar = this.mMp;
                if (!rVar.lYo.ciq()) {
                    x.e("MicroMsg.scanner.ViewMMURL", "already running, skipped");
                } else if (charSequence == null || charSequence.length() == 0) {
                    x.e("MicroMsg.scanner.ViewMMURL", "go fail, qqNum is null");
                } else {
                    rVar.url = charSequence;
                    au.HU();
                    str = (String) com.tencent.mm.model.c.DT().get(46, null);
                    if (str == null || str.length() == 0) {
                        rVar.b(charSequence, (int) System.currentTimeMillis(), new byte[0]);
                    } else {
                        au.DF().a(233, rVar);
                        rVar.mMA = new com.tencent.mm.modelsimple.h(charSequence, null, 4, (int) System.currentTimeMillis(), new byte[0]);
                        au.DF().a(rVar.mMA, 0);
                        rVar.lYo.J(3000, 3000);
                    }
                }
                return true;
            }
        } else if (mMo.contains(preference.mKey) && !preference.mKey.toLowerCase().contains("fax")) {
            str = preference.getSummary().toString().trim();
            if (str != null && str.length() > 0) {
                h.a(this, "", new String[]{getString(R.l.chatting_phone_use)}, "", new c() {
                    public final void ju(int i) {
                        switch (i) {
                            case 0:
                                Intent intent = new Intent("android.intent.action.DIAL");
                                intent.setFlags(268435456);
                                intent.setData(Uri.parse("tel:" + str));
                                VcardContactUI.this.startActivity(intent);
                                return;
                            default:
                                return;
                        }
                    }
                });
                return true;
            }
        } else if (preference.mKey.equals("v_contact_info_email")) {
            String[] strArr = new String[]{this.mController.tml.getString(R.l.send_mail_by_qqmail), this.mController.tml.getString(R.l.send_mail_by_default_account)};
            h.a(this, "", strArr, "", new 2(this, preference.getSummary().toString()));
        }
        return false;
    }

    protected final void initView() {
        VcardContactLinkPreference vcardContactLinkPreference;
        KeyValuePreference keyValuePreference;
        this.mMp = new r(this);
        this.eOE = this.tCL;
        this.mMn = o.mGG;
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                VcardContactUI.this.finish();
                return true;
            }
        });
        setMMTitle("");
        this.eOE.removeAll();
        this.eOE.addPreferencesFromResource(R.o.vcard_contact_info_pref);
        VcardContactUserHeaderPreference vcardContactUserHeaderPreference = (VcardContactUserHeaderPreference) this.eOE.ZZ("v_contact_info_header");
        if (vcardContactUserHeaderPreference != null) {
            o oVar = this.mMn;
            if (oVar != null) {
                if (!bi.oW(oVar.mGp.acD())) {
                    vcardContactUserHeaderPreference.mMz = oVar.mGp.acD();
                }
                if (!bi.oW(oVar.bgn)) {
                    vcardContactUserHeaderPreference.bgn = oVar.bgn;
                }
                if (!bi.oW(oVar.mGD)) {
                    vcardContactUserHeaderPreference.mGD = oVar.mGD;
                }
                if (!bi.oW(oVar.title)) {
                    vcardContactUserHeaderPreference.title = oVar.title;
                }
            }
        }
        this.eOE.aaa("c_contact_info_wx_id");
        if (bi.oW(this.mMn.fkq)) {
            this.eOE.aaa("v_contact_info_photo_uri");
            this.eOE.aaa("v_category_photo_uri");
        } else {
            vcardContactLinkPreference = (VcardContactLinkPreference) this.eOE.ZZ("v_contact_info_photo_uri");
            if (vcardContactLinkPreference != null) {
                vcardContactLinkPreference.setSummary(this.mMn.fkq);
                vcardContactLinkPreference.lO(false);
                vcardContactLinkPreference.tCA = false;
                mMq += 2;
                mMr += 2;
            }
        }
        a aVar = this.mMn.mGw;
        if (aVar != null && aVar.acD().length() > 0) {
            es(aVar.acD(), this.mController.tml.getString(R.l.v_contact_home_address));
        }
        aVar = this.mMn.mGx;
        if (aVar != null && aVar.acD().length() > 0) {
            es(aVar.acD(), this.mController.tml.getString(R.l.v_contact_work_address));
        }
        aVar = this.mMn.mGu;
        if (aVar != null && aVar.acD().length() > 0) {
            es(aVar.acD(), this.mController.tml.getString(R.l.v_contact_address));
        }
        aVar = this.mMn.mGv;
        if (aVar != null && aVar.acD().length() > 0) {
            es(aVar.acD(), this.mController.tml.getString(R.l.v_contact_address));
        }
        List list = this.mMn.mGA;
        if (list != null && list.size() > 0) {
            b(list, "WorkTel", this.mController.tml.getString(R.l.v_contact_work_tel));
        }
        list = this.mMn.mGz;
        if (list != null && list.size() > 0) {
            b(list, "HomeTel", this.mController.tml.getString(R.l.v_contact_home_tel));
        }
        list = this.mMn.mGB;
        if (list != null && list.size() > 0) {
            b(list, "VideoTEL", this.mController.tml.getString(R.l.v_contact_video_tel));
        }
        list = this.mMn.mGC;
        if (list != null && list.size() > 0) {
            b(list, "NormalTel", this.mController.tml.getString(R.l.v_contact_normal_tel));
        }
        list = this.mMn.mGy;
        if (list != null && list.size() > 0) {
            b(list, "CellTel", this.mController.tml.getString(R.l.v_contact_cell_tel));
        }
        if (bi.oW(this.mMn.fkz)) {
            this.eOE.aaa("v_contact_info_org");
        } else {
            keyValuePreference = (KeyValuePreference) this.eOE.ZZ("v_contact_info_org");
            if (keyValuePreference != null) {
                keyValuePreference.setSummary(this.mMn.fkz);
                keyValuePreference.lO(false);
                keyValuePreference.tCA = true;
            }
        }
        if (bi.oW(this.mMn.mGE)) {
            this.eOE.aaa("v_contact_info_agent");
        } else {
            keyValuePreference = (KeyValuePreference) this.eOE.ZZ("v_contact_info_agent");
            if (keyValuePreference != null) {
                keyValuePreference.setSummary(this.mMn.mGE);
                keyValuePreference.lO(false);
                keyValuePreference.tCA = true;
            }
        }
        if (bi.oW(this.mMn.url)) {
            this.eOE.aaa("v_contact_info_home_page");
            this.eOE.aaa("v_category_home_page");
        } else {
            vcardContactLinkPreference = (VcardContactLinkPreference) this.eOE.ZZ("v_contact_info_home_page");
            if (vcardContactLinkPreference != null) {
                vcardContactLinkPreference.setSummary(this.mMn.url);
                vcardContactLinkPreference.lO(false);
                vcardContactLinkPreference.tCA = true;
            }
        }
        if (bi.oW(this.mMn.csD)) {
            this.eOE.aaa("v_contact_info_email");
        } else {
            vcardContactLinkPreference = (VcardContactLinkPreference) this.eOE.ZZ("v_contact_info_email");
            if (vcardContactLinkPreference != null) {
                vcardContactLinkPreference.setSummary(this.mMn.csD);
                vcardContactLinkPreference.lO(false);
                vcardContactLinkPreference.tCA = true;
            }
        }
        if (bi.oW(this.mMn.mGt)) {
            this.eOE.aaa("v_contact_info_birthday");
            this.eOE.aaa("v_category_birthday");
        } else {
            keyValuePreference = (KeyValuePreference) this.eOE.ZZ("v_contact_info_birthday");
            if (keyValuePreference != null) {
                keyValuePreference.setSummary(this.mMn.mGt);
                keyValuePreference.lO(false);
                keyValuePreference.tCA = true;
            }
        }
        if (bi.oW(this.mMn.mGF)) {
            this.eOE.aaa("v_contact_info_remark");
            this.eOE.aaa("v_category_remark");
        } else {
            keyValuePreference = (KeyValuePreference) this.eOE.ZZ("v_contact_info_remark");
            if (keyValuePreference != null) {
                keyValuePreference.setSummary(this.mMn.mGF);
                keyValuePreference.lO(false);
                keyValuePreference.tCA = true;
            }
        }
        if (this.mMn.mGr == null || !this.mMn.mGr.mGJ.contains("uri")) {
            this.eOE.aaa("v_contact_info_logo");
            this.eOE.aaa("v_category_logo");
            return;
        }
        vcardContactLinkPreference = (VcardContactLinkPreference) this.eOE.ZZ("v_contact_info_logo");
        vcardContactLinkPreference.setSummary(this.mMn.mGr.mGK);
        vcardContactLinkPreference.tCA = false;
        vcardContactLinkPreference.lO(false);
    }

    private void b(List<String> list, String str, String str2) {
        if (list != null && list.size() > 0) {
            for (String str3 : list) {
                VcardContactLinkPreference vcardContactLinkPreference = new VcardContactLinkPreference(this);
                vcardContactLinkPreference.setKey(str + String.valueOf(str3));
                if (!mMo.contains(str + String.valueOf(str3))) {
                    mMo.add(str + String.valueOf(str3));
                }
                vcardContactLinkPreference.setTitle(str2);
                vcardContactLinkPreference.setLayoutResource(R.i.mm_preference);
                vcardContactLinkPreference.setSummary(str3);
                vcardContactLinkPreference.lO(false);
                vcardContactLinkPreference.tCA = true;
                vcardContactLinkPreference.csl();
                this.eOE.a(vcardContactLinkPreference, mMq);
            }
        }
    }

    private void es(String str, String str2) {
        Preference keyValuePreference = new KeyValuePreference(this);
        keyValuePreference.setTitle((CharSequence) str2);
        keyValuePreference.setLayoutResource(R.i.mm_preference);
        keyValuePreference.lO(false);
        keyValuePreference.setSummary((CharSequence) str);
        keyValuePreference.tCA = false;
        keyValuePreference.csl();
        this.eOE.a(keyValuePreference, mMr);
    }

    private static void a(List<String> list, Intent intent, int i, int i2) {
        for (String str : list) {
            if (i2 == 1) {
                intent.putExtra("phone", str);
                intent.putExtra("phone_type", i);
            } else if (i2 == 2) {
                intent.putExtra("secondary_phone", str);
                intent.putExtra("phone_type", i);
            } else if (i2 == 3) {
                intent.putExtra("tertiary_phone", str);
                intent.putExtra("phone_type", i);
            }
        }
    }
}
