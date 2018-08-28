package com.tencent.mm.pluginsdk.ui.d;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract.Contacts;
import android.widget.Toast;
import com.tencent.mars.comm.PlatformComm.C2Java;
import com.tencent.mm.R;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.q;
import com.tencent.mm.plugin.messenger.foundation.a.i;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.c.aur;
import com.tencent.mm.protocal.c.bar;
import com.tencent.mm.protocal.c.bas;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.aa.a;
import com.tencent.mm.storage.ab;
import com.tencent.mm.ui.base.k;
import com.tencent.smtt.sdk.WebView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class l {
    static String qQc;

    static /* synthetic */ void a(Activity activity, String str, Bundle bundle) {
        String oV = bi.oV(bundle.getString("Contact_User"));
        if (oV == null) {
            x.e("MicroMsg.MailPhoneMenuHelper", "username is null");
            return;
        }
        ab Yg = ((i) g.l(i.class)).FR().Yg(oV);
        if (Yg == null) {
            x.e("MicroMsg.MailPhoneMenuHelper", "contact is null");
            return;
        }
        int i;
        ArrayList arrayList;
        String string = bundle.getString("Contact_Mobile_MD5");
        String str2 = Yg.csZ;
        if (!bi.oW(string)) {
            if (string == str) {
                i = 0;
            } else if (!Yg.BH()) {
                i = 1;
            }
            arrayList = new ArrayList();
            if (!bi.oW(str2)) {
                String[] split = str2.split(",");
                for (Object add : split) {
                    arrayList.add(add);
                }
                if (arrayList.contains(str)) {
                    arrayList.remove(str);
                }
            }
            arrayList.add(str);
            if (arrayList.size() + i > 5) {
                a(activity, Yg, oV, arrayList);
                h.mEJ.h(12040, new Object[]{Yg.field_username, Integer.valueOf(4), Integer.valueOf(i), Integer.valueOf(i + arrayList.size())});
            }
            Toast.makeText(activity, activity.getString(R.l.more_than_five_phone_number), 0).show();
            return;
        }
        i = 0;
        arrayList = new ArrayList();
        if (bi.oW(str2)) {
            String[] split2 = str2.split(",");
            for (Object add2 : split2) {
                arrayList.add(add2);
            }
            if (arrayList.contains(str)) {
                arrayList.remove(str);
            }
        }
        arrayList.add(str);
        if (arrayList.size() + i > 5) {
            Toast.makeText(activity, activity.getString(R.l.more_than_five_phone_number), 0).show();
            return;
        }
        a(activity, Yg, oV, arrayList);
        h.mEJ.h(12040, new Object[]{Yg.field_username, Integer.valueOf(4), Integer.valueOf(i), Integer.valueOf(i + arrayList.size())});
    }

    static /* synthetic */ void bn(Context context, String str) {
        Intent intent = new Intent("android.intent.action.SENDTO");
        intent.setData(Uri.parse(WebView.SCHEME_MAILTO));
        intent.putExtra("android.intent.extra.EMAIL", new String[]{str});
        if (bi.k(context, intent)) {
            context.startActivity(intent);
        } else {
            com.tencent.mm.ui.base.h.a(context, R.l.chatting_no_default_email_app, R.l.app_tip, new 8());
        }
    }

    static /* synthetic */ void bo(Context context, String str) {
        Intent intent = new Intent("android.intent.action.INSERT_OR_EDIT", Contacts.CONTENT_URI);
        intent.setType("vnd.android.cursor.item/person");
        intent.putExtra("phone", str);
        if (bi.k(context, intent)) {
            context.startActivity(intent);
        }
    }

    public static void b(Context context, String str, OnDismissListener onDismissListener) {
        if (((q.GQ() & 1) == 0 ? 1 : 0) != 0) {
            com.tencent.mm.ui.base.h.a(context, str, context.getResources().getStringArray(R.c.email_url), "", new 1(onDismissListener, str, context));
        } else {
            com.tencent.mm.ui.base.h.a(context, str, new String[]{context.getResources().getString(R.l.chatting_email_by_default_account)}, "", new 2(onDismissListener, str, context));
        }
    }

    public static void a(Context context, String str, OnDismissListener onDismissListener, Bundle bundle) {
        boolean booleanValue;
        boolean z;
        List F;
        if (!(context instanceof Activity)) {
            x.w("MicroMsg.MailPhoneMenuHelper", "context should be Activity, %s", new Object[]{bi.cjd()});
        }
        if (g.Eg().Dx()) {
            booleanValue = ((Boolean) g.Ei().DT().get(a.sRf, Boolean.valueOf(false))).booleanValue();
        } else {
            booleanValue = false;
        }
        int i = bundle != null ? bundle.getInt("fromScene") : 0;
        if (cfi() || cfj()) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            String str2;
            String[] strArr;
            if (bundle == null) {
                str2 = "";
            } else {
                str2 = bundle.getString("Contact_User");
            }
            String oV = bi.oV(str2);
            if (oV == null || oV == "" || oV.endsWith("@chatroom") || q.gQ(oV)) {
                strArr = booleanValue ? new String[]{context.getResources().getString(R.l.chatting_phone_use), context.getResources().getString(R.l.chatting_phone_use_by_ipcall), context.getResources().getString(R.l.chatting_phone_copy), context.getResources().getString(R.l.chatting_phone_add_op)} : new String[]{context.getResources().getString(R.l.chatting_phone_use), context.getResources().getString(R.l.chatting_phone_copy), context.getResources().getString(R.l.chatting_phone_add_op)};
            } else {
                ab Yg = ((i) g.l(i.class)).FR().Yg(oV);
                if (Yg != null) {
                    str2 = Yg.BL();
                    qQc = context.getResources().getString(R.l.chatting_phone_add_remark, new Object[]{str2});
                    strArr = booleanValue ? new String[]{context.getResources().getString(R.l.chatting_phone_use), context.getResources().getString(R.l.chatting_phone_use_by_ipcall), qQc, context.getResources().getString(R.l.chatting_phone_copy), context.getResources().getString(R.l.chatting_phone_add_op)} : new String[]{context.getResources().getString(R.l.chatting_phone_use), qQc, context.getResources().getString(R.l.chatting_phone_copy), context.getResources().getString(R.l.chatting_phone_add_op)};
                } else {
                    return;
                }
            }
            F = bi.F(strArr);
        } else {
            F = bi.F(new String[]{context.getResources().getString(R.l.chatting_phone_use), context.getResources().getString(R.l.chatting_phone_copy)});
        }
        h.mEJ.h(11621, new Object[]{Integer.valueOf(i), Integer.valueOf(2)});
        if (q.vq()) {
            F.add(context.getResources().getString(R.l.chatting_phone_download_wxpb));
            h.mEJ.h(11621, new Object[]{Integer.valueOf(i), Integer.valueOf(3)});
            if (C2Java.isNetworkConnected()) {
                x.v("MicroMsg.WxPhoneBookHelper", "hy: minus pb counter, ori counter = %d", new Object[]{Integer.valueOf(bi.a((Integer) g.Ei().DT().get(a.sPC, null), 3))});
                g.Ei().DT().a(a.sPC, Integer.valueOf(r0 - 1));
            }
        }
        k kVar = new k(context);
        kVar.setTitle(str);
        a aVar = new a(F, context, onDismissListener, bundle);
        aVar.qQk = new 5(kVar, onDismissListener);
        kVar.hAv = aVar;
        com.tencent.mm.ui.base.h.a(context, kVar);
        kVar.setOnCancelListener(new 6(onDismissListener));
        kVar.qRL = new 7(str, F, context, kVar, onDismissListener, i, bundle);
        kVar.show();
    }

    static boolean cfi() {
        Context context = ad.getContext();
        Intent intent = new Intent("android.intent.action.INSERT");
        intent.setType("vnd.android.cursor.dir/contact");
        intent.putExtra("phone", "10086");
        return bi.k(context, intent);
    }

    static boolean cfj() {
        return bi.k(ad.getContext(), new Intent("android.intent.action.PICK", Contacts.CONTENT_URI));
    }

    private static void a(Activity activity, ab abVar, String str, ArrayList<String> arrayList) {
        String str2;
        aur aur = new aur();
        aur.rXy = str;
        bas bas = new bas();
        bas.hbF = arrayList.size();
        bas.sdd = new LinkedList();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            str2 = (String) it.next();
            bar bar = new bar();
            bar.sdc = str2;
            bas.sdd.add(bar);
        }
        aur.rXu = bas;
        ((i) g.l(i.class)).FQ().b(new com.tencent.mm.plugin.messenger.foundation.a.a.h.a(60, aur));
        ab Yg = ((i) g.l(i.class)).FR().Yg(str);
        if (Yg != null && ((int) Yg.dhP) > 0 && com.tencent.mm.l.a.gd(Yg.field_type)) {
            String str3;
            str2 = "";
            Iterator it2 = arrayList.iterator();
            while (true) {
                str3 = str2;
                if (!it2.hasNext()) {
                    break;
                }
                str2 = (str3 + ((String) it2.next())) + ",";
            }
            abVar.dZ(str3);
            ((i) g.l(i.class)).FR().S(abVar);
        }
        Toast.makeText(activity, activity.getString(R.l.succeed_add_to_remark), 0).show();
    }
}
