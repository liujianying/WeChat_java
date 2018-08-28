package com.tencent.mm.ui.chatting.i;

import android.content.Context;
import android.content.Intent;
import android.text.SpannableStringBuilder;
import android.view.View;
import com.tencent.mm.bg.d;
import com.tencent.mm.plugin.messenger.a.a;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.ui.d.j;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.lang.ref.WeakReference;
import java.util.Map;

public final class b extends a {
    public b(com.tencent.mm.ui.chatting.i.a.b bVar) {
        super(bVar);
    }

    final String cxK() {
        return "link_profile";
    }

    final CharSequence a(Map<String, String> map, String str, final WeakReference<Context> weakReference) {
        CharSequence spannableStringBuilder = new SpannableStringBuilder();
        CharSequence aG = bi.aG((String) map.get(str + ".separator"), "、");
        int i = 0;
        while (true) {
            String str2 = str + ".memberlist.member" + (i != 0 ? Integer.valueOf(i) : "");
            if (map.get(str2) == null) {
                return spannableStringBuilder;
            }
            if (i != 0) {
                spannableStringBuilder.append(aG);
            }
            final String str3 = (String) map.get(str2 + ".username");
            str2 = (String) map.get(str2 + ".nickname");
            if (bi.oW(str3) || bi.oW(str2)) {
                x.w("MicroMsg.SysMsgHandlerProfile", "hy: can not resolve username or nickname");
            } else {
                CharSequence a = j.a(ad.getContext(), str2);
                a.setSpan(new a() {
                    public final void onClickImp(View view) {
                        if (weakReference != null && weakReference.get() != null) {
                            Context context = (Context) weakReference.get();
                            String str = str3;
                            if (context != null && !bi.oW(str)) {
                                h.mEJ.h(14516, new Object[]{Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0)});
                                Intent putExtra = new Intent().putExtra("Contact_User", str);
                                putExtra.putExtra("Contact_Scene", 14);
                                d.b(context, "profile", ".ui.ContactInfoUI", putExtra);
                            }
                        }
                    }
                }, 0, str2.length(), 33);
                spannableStringBuilder.append(a);
            }
            i++;
        }
    }
}
