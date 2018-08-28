package com.tencent.mm.plugin.qmessage.ui;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import com.tencent.mm.R;
import com.tencent.mm.ab.e;
import com.tencent.mm.model.au;
import com.tencent.mm.plugin.qmessage.a.b;
import com.tencent.mm.plugin.qmessage.a.d;
import com.tencent.mm.plugin.qmessage.a.g;
import com.tencent.mm.pluginsdk.ui.preference.NormalUserHeaderPreference;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.bl;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.ab;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import junit.framework.Assert;

public final class a implements e, com.tencent.mm.pluginsdk.b.a {
    Context context;
    private ProgressDialog eHw;
    private f eOE;
    private ab guS;

    public a(Context context) {
        this.context = context;
    }

    public final boolean wX(String str) {
        return true;
    }

    public final boolean a(f fVar, ab abVar, boolean z, int i) {
        boolean z2;
        boolean z3 = false;
        Assert.assertTrue(fVar != null);
        if (abVar != null) {
            z2 = true;
        } else {
            z2 = false;
        }
        Assert.assertTrue(z2);
        Assert.assertTrue(ab.XQ(abVar.field_username));
        au.DF().a(140, this);
        this.guS = abVar;
        this.eOE = fVar;
        fVar.addPreferencesFromResource(R.o.contact_info_pref_qcontact);
        NormalUserHeaderPreference normalUserHeaderPreference = (NormalUserHeaderPreference) fVar.ZZ("contact_info_header_normal");
        if (normalUserHeaderPreference != null) {
            normalUserHeaderPreference.qPo = "ContactWidgetQContact";
            normalUserHeaderPreference.a(abVar, 0, null);
        }
        auv();
        d JM = g.boc().JM(this.guS.field_username);
        if (JM == null || bi.oV(JM.getUsername()).length() <= 0) {
            x.e("MicroMsg.ContactWidgetQContact", "getProfileOrNot: QContact is null, should not in this way");
            JM = new d();
            JM.username = this.guS.field_username;
            JM.bWA = -1;
            g.boc().a(JM);
        }
        if (JM.mbv == 1) {
            String str = this.guS.field_username;
            z2 = bi.oV(JM.boa()).length() <= 0;
            if (bi.oV(str).length() > 0) {
                z3 = true;
            }
            Assert.assertTrue(z3);
            Set hashSet = new HashSet();
            hashSet.add(str);
            final b bVar = new b(hashSet);
            new ag().post(new Runnable() {
                public final void run() {
                    au.DF().a(bVar, 0);
                }
            });
            if (z2) {
                Context context = this.context;
                this.context.getString(R.l.app_tip);
                this.eHw = h.a(context, this.context.getString(R.l.app_loading_data), true, new 2(this, bVar));
            }
        }
        return true;
    }

    private void auv() {
        d JM = g.boc().JM(this.guS.field_username);
        if (JM == null || bi.oV(JM.getUsername()).length() <= 0) {
            x.e("MicroMsg.ContactWidgetQContact", "updateProfile : Qcontact is null");
            return;
        }
        if (bi.oV(JM.boa()).length() <= 0) {
            x.e("MicroMsg.ContactWidgetQContact", "updateProfile: QContact extInfo is null");
        }
        Preference ZZ = this.eOE.ZZ("contact_info_qcontact_sex");
        Preference ZZ2 = this.eOE.ZZ("contact_info_qcontact_age");
        Preference ZZ3 = this.eOE.ZZ("contact_info_qcontact_birthday");
        Preference ZZ4 = this.eOE.ZZ("contact_info_qcontact_address");
        a aVar = new a(this, (byte) 0);
        String boa = JM.boa();
        if (bi.oV(boa).length() <= 0) {
            x.e("MicroMsg.ContactWidgetQContact", "QExtInfoContent : parse xml, but xml is null");
        } else {
            Map z = bl.z(boa, "extinfo");
            if (z != null) {
                aVar.mbI = (String) z.get(".extinfo.sex");
                aVar.mbJ = (String) z.get(".extinfo.age");
                aVar.mbK = (String) z.get(".extinfo.bd");
                aVar.country = (String) z.get(".extinfo.country");
                aVar.csK = (String) z.get(".extinfo.province");
                aVar.csL = (String) z.get(".extinfo.city");
            }
            if (aVar.mbI == null || !aVar.mbI.equals("1")) {
                aVar.mbI = aVar.mbH.context.getString(R.l.sex_female);
            } else {
                aVar.mbI = aVar.mbH.context.getString(R.l.sex_male);
            }
            if (aVar.country != null) {
                aVar.dRH += aVar.country + " ";
            }
            if (aVar.csK != null) {
                aVar.dRH += aVar.csK + " ";
            }
            if (aVar.csL != null) {
                aVar.dRH += aVar.csL;
            }
        }
        if (ZZ != null) {
            ZZ.setSummary(aVar.mbI == null ? "" : aVar.mbI);
        }
        if (ZZ2 != null) {
            ZZ2.setSummary(aVar.mbJ == null ? "" : aVar.mbJ);
        }
        if (ZZ3 != null) {
            ZZ3.setSummary(aVar.mbK == null ? "" : aVar.mbK);
        }
        if (ZZ4 != null) {
            ZZ4.setSummary(aVar.dRH == null ? "" : aVar.dRH);
        }
        this.eOE.notifyDataSetChanged();
    }

    public final boolean auw() {
        au.DF().b(140, this);
        NormalUserHeaderPreference normalUserHeaderPreference = (NormalUserHeaderPreference) this.eOE.ZZ("contact_info_header_normal");
        if (normalUserHeaderPreference != null) {
            normalUserHeaderPreference.onDetach();
        }
        return true;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(int r9, int r10, java.lang.String r11, com.tencent.mm.ab.l r12) {
        /*
        r8 = this;
        r7 = 3000; // 0xbb8 float:4.204E-42 double:1.482E-320;
        r6 = 2;
        r1 = 0;
        r0 = 1;
        r2 = r12.getType();
        r3 = 140; // 0x8c float:1.96E-43 double:6.9E-322;
        if (r2 == r3) goto L_0x000e;
    L_0x000d:
        return;
    L_0x000e:
        r2 = r8.eHw;
        if (r2 == 0) goto L_0x0020;
    L_0x0012:
        r2 = r8.eHw;
        r2.dismiss();
        r2 = 0;
        r8.eHw = r2;
        switch(r9) {
            case 1: goto L_0x005e;
            case 2: goto L_0x0082;
            default: goto L_0x001d;
        };
    L_0x001d:
        r0 = r1;
    L_0x001e:
        if (r0 != 0) goto L_0x000d;
    L_0x0020:
        if (r9 != 0) goto L_0x000d;
    L_0x0022:
        if (r10 != 0) goto L_0x000d;
    L_0x0024:
        r0 = com.tencent.mm.plugin.qmessage.a.g.boc();
        r2 = r8.guS;
        r2 = r2.field_username;
        r0 = r0.JM(r2);
        if (r0 == 0) goto L_0x0040;
    L_0x0032:
        r2 = r0.getUsername();
        r2 = com.tencent.mm.sdk.platformtools.bi.oV(r2);
        r2 = r2.length();
        if (r2 > 0) goto L_0x00a7;
    L_0x0040:
        r0 = "MicroMsg.ContactWidgetQContact";
        r1 = new java.lang.StringBuilder;
        r2 = "resetUpdateStatus: did not find this QContact, username = ";
        r1.<init>(r2);
        r2 = r8.guS;
        r2 = r2.field_username;
        r1 = r1.append(r2);
        r1 = r1.toString();
        com.tencent.mm.sdk.platformtools.x.e(r0, r1);
    L_0x005a:
        r8.auv();
        goto L_0x000d;
    L_0x005e:
        r2 = com.tencent.mm.platformtools.af.ewA;
        if (r2 == 0) goto L_0x001d;
    L_0x0062:
        r2 = r8.context;
        r3 = r8.context;
        r4 = com.tencent.mm.R.l.fmt_http_err;
        r5 = new java.lang.Object[r6];
        r6 = java.lang.Integer.valueOf(r0);
        r5[r1] = r6;
        r6 = java.lang.Integer.valueOf(r10);
        r5[r0] = r6;
        r3 = r3.getString(r4, r5);
        r2 = android.widget.Toast.makeText(r2, r3, r7);
        r2.show();
        goto L_0x001e;
    L_0x0082:
        r2 = com.tencent.mm.platformtools.af.ewA;
        if (r2 == 0) goto L_0x001d;
    L_0x0086:
        r2 = r8.context;
        r3 = r8.context;
        r4 = com.tencent.mm.R.l.fmt_iap_err;
        r5 = new java.lang.Object[r6];
        r6 = java.lang.Integer.valueOf(r6);
        r5[r1] = r6;
        r6 = java.lang.Integer.valueOf(r10);
        r5[r0] = r6;
        r3 = r3.getString(r4, r5);
        r2 = android.widget.Toast.makeText(r2, r3, r7);
        r2.show();
        goto L_0x001e;
    L_0x00a7:
        r2 = 8;
        r0.bWA = r2;
        r0.mbv = r1;
        r1 = com.tencent.mm.plugin.qmessage.a.g.boc();
        r2 = r8.guS;
        r2 = r2.field_username;
        r0 = r1.a(r2, r0);
        if (r0 != 0) goto L_0x005a;
    L_0x00bb:
        r0 = "MicroMsg.ContactWidgetQContact";
        r1 = new java.lang.StringBuilder;
        r2 = "resetUpdateStatus: update Qcontact failed, username = ";
        r1.<init>(r2);
        r2 = r8.guS;
        r2 = r2.field_username;
        r1 = r1.append(r2);
        r1 = r1.toString();
        com.tencent.mm.sdk.platformtools.x.e(r0, r1);
        goto L_0x005a;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.qmessage.ui.a.a(int, int, java.lang.String, com.tencent.mm.ab.l):void");
    }

    public final void onActivityResult(int i, int i2, Intent intent) {
    }
}
