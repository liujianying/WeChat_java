package com.tencent.mm.model;

import android.content.Context;
import com.tencent.mm.R;
import com.tencent.mm.l.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.storage.ab;

public final class aa {
    private c dBo;

    public aa(c cVar) {
        this.dBo = cVar;
    }

    static int a(boolean z, String str, boolean z2) {
        int i = 3;
        a Yg = c.FR().Yg(str);
        if (Yg == null) {
            Yg = new ab();
        }
        if (((int) Yg.dhP) == 0) {
            Yg.setUsername(str);
            Yg.Bb();
            x(Yg);
            if (z2) {
                i = 4;
            }
            Yg.eI(i);
            Yg.Bk();
            c.FR().T(Yg);
            return 1;
        } else if (!z) {
            return 3;
        } else {
            Yg.Bk();
            c.FR().a(str, Yg);
            return 2;
        }
    }

    public static void w(ab abVar) {
        a abVar2;
        if (abVar2 == null) {
            abVar2 = new ab();
        }
        if (((int) abVar2.dhP) == 0) {
            abVar2.setUsername("filehelper");
            au.HU();
            if (c.FW().Yq(abVar2.field_username) == null) {
                abVar2.Bc();
            } else {
                abVar2.Bb();
            }
            abVar2.eI(3);
            au.HU();
            c.FR().S(abVar2);
        }
    }

    static void x(ab abVar) {
        String str = abVar.field_username;
        Context context = ad.getContext();
        if (str.equals("qqsync")) {
            abVar.dx(context.getString(R.l.hardcode_plugin_qqsync_nick));
            abVar.dy(context.getString(R.l.hardcode_plugin_qqsync_pyinitial));
            abVar.dz(context.getString(R.l.hardcode_plugin_qqsync_quanpin));
        }
        if (str.equals("floatbottle")) {
            abVar.dx(context.getString(R.l.hardcode_plugin_bottle_nick));
            abVar.dy(context.getString(R.l.hardcode_plugin_bottle_pyinitial));
            abVar.dz(context.getString(R.l.hardcode_plugin_bottle_quanpin));
        }
        if (str.equals("shakeapp")) {
            abVar.dx(context.getString(R.l.hardcode_plugin_shake_nick));
            abVar.dy(context.getString(R.l.hardcode_plugin_shake_pyinitial));
            abVar.dz(context.getString(R.l.hardcode_plugin_shake_quanpin));
        }
        if (str.equals("lbsapp")) {
            abVar.dx(context.getString(R.l.hardcode_plugin_lbs_nick));
            abVar.dy(context.getString(R.l.hardcode_plugin_lbs_pyinitial));
            abVar.dz(context.getString(R.l.hardcode_plugin_lbs_quanpin));
        }
        if (str.equals("medianote")) {
            abVar.dx(context.getString(R.l.hardcode_plugin_medianote_nick));
            abVar.dy(context.getString(R.l.hardcode_plugin_medianote_pyinitial));
            abVar.dz(context.getString(R.l.hardcode_plugin_medianote_quanpin));
        }
        if (str.equals("newsapp")) {
            abVar.dx(context.getString(R.l.hardcode_plugin_readerappnews_nick));
            abVar.dy(context.getString(R.l.hardcode_plugin_readerappnews_pyinitial));
            abVar.dz(context.getString(R.l.hardcode_plugin_readerappnews_quanpin));
        }
        if (str.equals("facebookapp")) {
            abVar.dx(context.getString(R.l.hardcode_plugin_facebookapp_nick));
            abVar.dy(context.getString(R.l.hardcode_plugin_facebookapp_pyinitial));
            abVar.dz(context.getString(R.l.hardcode_plugin_facebookapp_quanpin));
        }
        if (str.equals("qqfriend")) {
            abVar.dx(context.getString(R.l.hardcode_plugin_qqfriend_nick));
            abVar.dy(context.getString(R.l.hardcode_plugin_qqfriend_pyinitial));
            abVar.dz(context.getString(R.l.hardcode_plugin_qqfriend_quanpin));
        }
        if (str.equals("masssendapp")) {
            abVar.dx(context.getString(R.l.hardcode_plugin_masssend_nick));
            abVar.dy(context.getString(R.l.hardcode_plugin_masssend_pyinitial));
            abVar.dz(context.getString(R.l.hardcode_plugin_masssend_quanpin));
        }
        if (str.equals("feedsapp")) {
            abVar.dx(context.getString(R.l.hardcode_plugin_feedsapp_nick));
            abVar.dy(context.getString(R.l.hardcode_plugin_feedsapp_pyinitial));
            abVar.dz(context.getString(R.l.hardcode_plugin_feedsapp_quanpin));
        }
        if (str.equals("fmessage")) {
            abVar.dx(context.getString(R.l.hardcode_plugin_fmessage_nick));
            abVar.dy(context.getString(R.l.hardcode_plugin_fmessage_pyinitial));
            abVar.dz(context.getString(R.l.hardcode_plugin_fmessage_quanpin));
        }
        if (str.equals("voipapp")) {
            abVar.dx(context.getString(R.l.hardcode_plugin_voip_nick));
            abVar.dy(context.getString(R.l.hardcode_plugin_voip_pyinitial));
            abVar.dz(context.getString(R.l.hardcode_plugin_voip_quanpin));
        }
        if (str.equals("officialaccounts")) {
            abVar.dx(context.getString(R.l.hardcode_plugin_official_accounts_nick));
            abVar.dy(context.getString(R.l.hardcode_plugin_official_accounts_pyinitial));
            abVar.dz(context.getString(R.l.hardcode_plugin_official_accounts_quanpin));
        }
        if (str.equals("helper_entry")) {
            abVar.dx(context.getString(R.l.hardcode_plugin_helper_entry_nick));
            abVar.dy(context.getString(R.l.hardcode_plugin_helper_entry_pyinitial));
            abVar.dz(context.getString(R.l.hardcode_plugin_helper_entry_quanpin));
        }
        if (str.equals("cardpackage")) {
            abVar.dx(context.getString(R.l.hardcode_plugin_card_package_nick));
            abVar.dy(context.getString(R.l.hardcode_plugin_card_package_pyinitial));
            abVar.dz(context.getString(R.l.hardcode_plugin_card_package_quanpin));
        }
        if (str.equals("voicevoipapp")) {
            abVar.dx(context.getString(R.l.hardcode_plugin_voipaudio_nick));
            abVar.dy(context.getString(R.l.hardcode_plugin_voipaudio_pyinitial));
            abVar.dz(context.getString(R.l.hardcode_plugin_voipaudio_quanpin));
        }
        if (str.equals("voiceinputapp")) {
            abVar.dx(context.getString(R.l.hardcode_plugin_voiceinput_nick));
            abVar.dy(context.getString(R.l.hardcode_plugin_voiceinput_pyinitial));
            abVar.dz(context.getString(R.l.hardcode_plugin_voiceinput_quanpin));
        }
        if (str.equals("qqmail")) {
            abVar.dx(context.getString(R.l.hardcode_plugin_qqmail_nick));
            abVar.dy(context.getString(R.l.hardcode_plugin_qqmail_pyinitial));
            abVar.dz(context.getString(R.l.hardcode_plugin_qqmail_quanpin));
        }
        if (str.equals("linkedinplugin")) {
            abVar.dx(context.getString(R.l.hardcode_plugin_linkedin_nick));
            abVar.dy(context.getString(R.l.hardcode_plugin_linkedin_pyinitial));
            abVar.dz(context.getString(R.l.hardcode_plugin_linkedin_quanpin));
        }
        if (str.equals("notifymessage")) {
            abVar.dx(context.getString(R.l.hardcode_plugin_notify_message_nick));
            abVar.dy(context.getString(R.l.hardcode_plugin_notify_message_pyinitial));
            abVar.dz(context.getString(R.l.hardcode_plugin_notify_message_quanpin));
        }
        if (str.equals("appbrandcustomerservicemsg")) {
            abVar.dx(context.getString(R.l.hardcode_plugin_app_brand_customer_service_message_nick));
            abVar.dy(context.getString(R.l.hardcode_plugin_app_brand_customer_service_message_pyinitial));
            abVar.dz(context.getString(R.l.hardcode_plugin_app_brand_customer_service_message_quanpin));
        }
    }
}
