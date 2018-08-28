package com.tencent.mm.plugin.profile.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.tencent.mm.R;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.model.m;
import com.tencent.mm.pluginsdk.b.a;
import com.tencent.mm.pluginsdk.ui.applet.ContactListExpandPreference;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.u;
import com.tencent.mm.ui.base.preference.PreferenceCategory;
import com.tencent.mm.ui.base.preference.PreferenceSmallCategory;
import com.tencent.mm.ui.base.preference.f;
import java.util.List;
import junit.framework.Assert;

public final class h implements a {
    Context context;
    private int eLK;
    private f eOE;
    private String fsV;
    private ab guS;
    u hLB;
    private boolean lUD;
    private boolean lUE;
    private int lWd;
    ContactListExpandPreference lWe;

    public h(Context context) {
        this.context = context;
        this.lWe = new ContactListExpandPreference(context, 0);
    }

    public final boolean wX(String str) {
        x.d("MicroMsg.ContactWidgetGroupCard", "handleEvent " + str);
        au.HU();
        ab Yg = c.FR().Yg(str);
        if (Yg != null && ((int) Yg.dhP) > 0) {
            Intent intent = new Intent();
            intent.setClass(this.context, ContactInfoUI.class);
            intent.putExtra("Contact_User", Yg.field_username);
            this.context.startActivity(intent);
        }
        return true;
    }

    public final boolean a(f fVar, ab abVar, boolean z, int i) {
        Assert.assertTrue(abVar != null);
        Assert.assertTrue(bi.oV(abVar.field_username).length() > 0);
        Assert.assertTrue(fVar != null);
        this.eOE = fVar;
        this.guS = abVar;
        this.lUD = z;
        this.eLK = i;
        this.lUE = ((Activity) this.context).getIntent().getBooleanExtra("User_Verify", false);
        this.lWd = ((Activity) this.context).getIntent().getIntExtra("Kdel_from", -1);
        this.fsV = abVar.field_username;
        au.HU();
        this.hLB = c.Ga().ii(this.fsV);
        this.eOE.removeAll();
        this.eOE.a(new PreferenceSmallCategory(this.context));
        this.lWe.setKey("roominfo_contact_anchor");
        this.eOE.a(this.lWe);
        this.eOE.a(new PreferenceCategory(this.context));
        NormalUserFooterPreference normalUserFooterPreference = new NormalUserFooterPreference(this.context);
        normalUserFooterPreference.setLayoutResource(R.i.contact_info_footer_normal);
        normalUserFooterPreference.setKey("contact_info_footer_normal");
        if (normalUserFooterPreference.a(this.guS, "", this.lUD, this.lUE, false, this.eLK, this.lWd, false, false, 0, "")) {
            this.eOE.a(normalUserFooterPreference);
        }
        this.lWe.a(this.eOE, this.lWe.mKey);
        List gI = m.gI(this.fsV);
        this.lWe.kG(false).kH(false);
        this.lWe.p(this.fsV, gI);
        this.lWe.a(new 1(this));
        return true;
    }

    public final boolean auw() {
        NormalUserFooterPreference normalUserFooterPreference = (NormalUserFooterPreference) this.eOE.ZZ("contact_info_footer_normal");
        if (normalUserFooterPreference != null) {
            normalUserFooterPreference.auw();
        }
        return true;
    }

    public final void onActivityResult(int i, int i2, Intent intent) {
    }
}
