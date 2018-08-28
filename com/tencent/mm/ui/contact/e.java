package com.tencent.mm.ui.contact;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mm.bg.d;
import com.tencent.mm.plugin.account.b;
import com.tencent.mm.plugin.account.friend.a.a;
import com.tencent.mm.plugin.account.friend.a.ao;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.bd;

public final class e {
    public static void l(Intent intent, String str) {
        intent.putExtra("Contact_User", str);
    }

    public static void a(Intent intent, String str) {
        if (intent == null || str == null || str.length() == 0) {
            x.e("MicroMsg.ContactInfoUtil", "setLocalQQMobile fail, intent = " + intent + ", username = " + str);
            return;
        }
        ao pA = b.getQQListStg().pA(str);
        if (pA != null) {
            intent.putExtra("Contact_Uin", pA.eLw);
            intent.putExtra("Contact_QQNick", pA.getDisplayName());
        }
        a pp = b.getAddrUploadStg().pp(str);
        if (pp != null) {
            intent.putExtra("Contact_Mobile_MD5", pp.Xh());
        }
    }

    public static void a(Context context, bd.a aVar) {
        a(context, aVar, false, false, null);
    }

    public static void a(Context context, bd.a aVar, boolean z, boolean z2, Bundle bundle) {
        if (context != null && aVar != null) {
            ab abVar = new ab();
            abVar.setUsername(aVar.otZ);
            abVar.dx(aVar.getDisplayName());
            abVar.dy(aVar.eLz);
            abVar.dz(aVar.eLA);
            a(context, abVar, aVar, z, z2, bundle, aVar.eHT);
        }
    }

    public static void a(Context context, ab abVar, bd.a aVar) {
        a(context, abVar, aVar, false, false, null, aVar.eHT);
    }

    public static void a(Context context, ab abVar, bd.a aVar, boolean z, boolean z2, Bundle bundle, String str) {
        if (abVar != null && aVar != null && abVar.field_username != null && abVar.field_username.length() > 0) {
            Intent intent = new Intent();
            intent.putExtra("Contact_User", abVar.field_username);
            intent.putExtra("Contact_Alias", abVar.wM());
            intent.putExtra("Contact_Nick", abVar.BK());
            intent.putExtra("Contact_QuanPin", abVar.wQ());
            intent.putExtra("Contact_PyInitial", abVar.wP());
            intent.putExtra("Contact_Sex", aVar.sex);
            intent.putExtra("Contact_Province", aVar.getProvince());
            intent.putExtra("Contact_City", aVar.getCity());
            intent.putExtra("Contact_Signature", aVar.signature);
            intent.putExtra("Contact_Uin", aVar.lWQ);
            intent.putExtra("Contact_Mobile_MD5", aVar.tbE);
            intent.putExtra("Contact_full_Mobile_MD5", aVar.tbF);
            intent.putExtra("Contact_QQNick", aVar.cmJ());
            intent.putExtra("User_From_Fmessage", true);
            intent.putExtra("Contact_Scene", aVar.scene);
            intent.putExtra("Contact_from_msgType", 40);
            if (z) {
                intent.putExtra("Contact_ShowUserName", false);
            }
            if (z2) {
                intent.putExtra("Contact_KSnsIFlag", 0);
            }
            if (bundle != null) {
                intent.putExtras(bundle);
            }
            if (!TextUtils.isEmpty(str)) {
                intent.putExtra("verify_gmail", str);
            }
            d.b(context, "profile", ".ui.ContactInfoUI", intent);
        }
    }
}
