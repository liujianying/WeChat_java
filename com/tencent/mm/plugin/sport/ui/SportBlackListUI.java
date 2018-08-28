package com.tencent.mm.plugin.sport.ui;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.R;
import com.tencent.mm.bg.d;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.pluginsdk.ui.applet.ContactListExpandPreference;
import com.tencent.mm.pluginsdk.ui.applet.ContactListExpandPreference.a;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.ui.contact.s;
import java.util.ArrayList;
import java.util.List;

public class SportBlackListUI extends MMPreference {
    private ContactListExpandPreference hLp;
    private List<String> opv;
    private a opw = new 2(this);

    static /* synthetic */ void c(SportBlackListUI sportBlackListUI) {
        String c = bi.c(sportBlackListUI.opv, ",");
        Intent intent = new Intent();
        intent.putExtra("titile", sportBlackListUI.getString(R.l.address_title_select_contact));
        intent.putExtra("list_type", 1);
        intent.putExtra("list_attr", s.s(new int[]{s.ukF, WXMediaMessage.DESCRIPTION_LENGTH_LIMIT}));
        intent.putExtra("always_select_contact", c);
        d.b(sportBlackListUI, ".ui.contact.SelectContactUI", intent, 0);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        com.tencent.mm.plugin.sport.b.d.kB(39);
        if (this.opv == null) {
            this.opv = new ArrayList();
        }
        au.HU();
        Cursor d = c.FR().d("@werun.black.android", "", null);
        while (d.moveToNext()) {
            this.opv.add(d.getString(0));
        }
        d.close();
        this.hLp = (ContactListExpandPreference) this.tCL.ZZ("black_contact_list_pref");
        this.hLp.a(this.tCL, this.hLp.mKey);
        this.hLp.kG(true).kH(true);
        this.hLp.p(null, this.opv);
        this.hLp.a(this.opw);
        this.hLp.setSummary(R.l.exdevice_we_sport_black_list_intro);
        setMMTitle(getString(R.l.exdevice_profile_add_black_list));
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                SportBlackListUI.this.finish();
                return false;
            }
        });
    }

    public final int Ys() {
        return R.o.sportblacklist_pref;
    }

    public final boolean a(f fVar, Preference preference) {
        return false;
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 0 && intent != null) {
            String stringExtra = intent.getStringExtra("Select_Contact");
            if (!bi.oW(stringExtra)) {
                Object<String> F = bi.F(stringExtra.split(","));
                if (F != null) {
                    this.opv.addAll(F);
                    this.hLp.p(null, this.opv);
                    this.hLp.refresh();
                    for (String stringExtra2 : F) {
                        au.HU();
                        com.tencent.mm.model.s.f(c.FR().Yg(stringExtra2));
                    }
                }
            }
        }
    }
}
