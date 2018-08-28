package com.tencent.mm.plugin.messenger.b;

import android.content.Context;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextUtils;
import android.text.style.ClickableSpan;
import com.tencent.mm.kernel.g;
import com.tencent.mm.platformtools.ab;
import com.tencent.mm.plugin.messenger.a.e;
import com.tencent.mm.plugin.messenger.a.e$a;
import com.tencent.mm.plugin.messenger.a.e.b;
import com.tencent.mm.plugin.messenger.foundation.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.pluginsdk.ui.d.j;
import com.tencent.mm.protocal.c.by;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.bl;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.bd;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public final class a implements e {
    private Map<String, b> lcI = new HashMap();
    private Map<String, e$a> lcJ = new HashMap();
    private com.tencent.mm.ak.a.d.a<Long, CharSequence> lcK = new com.tencent.mm.ak.a.d.a(200);
    private com.tencent.mm.ak.a.d.a<Long, CharSequence> lcL = new com.tencent.mm.ak.a.d.a(500);
    public n lcM = new 1(this);

    static /* synthetic */ boolean d(com.tencent.mm.ab.d.a aVar) {
        if (aVar == null || aVar.dIN == null) {
            x.e("MicroMsg.SysMsgTemplateImp", "hy: addMsgInfo or addMsgInfo.addMsg is null! should not happen");
            return false;
        }
        by byVar = aVar.dIN;
        String a = ab.a(byVar.rcl);
        String a2 = ab.a(byVar.rcj);
        bd I = ((i) g.l(i.class)).bcY().I(a2, byVar.rcq);
        boolean z = I.field_msgId > 0;
        I.ax(byVar.rcq);
        if (!(aVar.dIO && aVar.dIQ)) {
            I.ay(com.tencent.mm.model.bd.o(a2, (long) byVar.lOH));
        }
        I.setType(570425393);
        I.setContent(a);
        I.eX(0);
        I.ep(a2);
        I.dt(byVar.rco);
        com.tencent.mm.model.bd.a(I, aVar);
        if (z) {
            ((i) g.l(i.class)).bcY().b(byVar.rcq, I);
            return true;
        }
        com.tencent.mm.model.bd.i(I);
        return true;
    }

    public final void a(String str, b bVar) {
        x.i("MicroMsg.SysMsgTemplateImp", "hy: adding template listener: %s", new Object[]{str});
        this.lcI.put(str, bVar);
    }

    public final void Gs(String str) {
        x.i("MicroMsg.SysMsgTemplateImp", "hy: removing template listener: %s", new Object[]{str});
        this.lcI.remove(str);
    }

    public final void a(String str, e$a e_a) {
        x.i("MicroMsg.SysMsgTemplateImp", "hy: adding digest listener: %s", new Object[]{str});
        this.lcJ.put(str, e_a);
    }

    public final void Gt(String str) {
        x.i("MicroMsg.SysMsgTemplateImp", "hy: removing digest listener: %s", new Object[]{str});
        this.lcJ.remove(str);
    }

    public final CharSequence a(String str, Bundle bundle, WeakReference<Context> weakReference) {
        if (bi.oW(str)) {
            x.w("MicroMsg.SysMsgTemplateImp", "hy: request translate content is null!");
            return null;
        }
        Map z = bl.z(str, "sysmsg");
        if (z == null) {
            x.i("MicroMsg.SysMsgTemplateImp", "hy: not retrieved sysmsg from new xml!");
            return null;
        }
        String str2 = (String) z.get(".sysmsg.$type");
        if (!bi.oW(str2) && "sysmsgtemplate".equals(str2)) {
            return a(z, bundle, weakReference, 0);
        }
        x.w("MicroMsg.SysMsgTemplateImp", "hy: not acceptable sysmsg: %s", new Object[]{str2});
        return null;
    }

    public final CharSequence Gu(String str) {
        if (bi.oW(str)) {
            x.w("MicroMsg.SysMsgTemplateImp", "hy: [digest] request translate content is null!");
            return null;
        }
        Map z = bl.z(str, "sysmsg");
        if (z == null) {
            x.i("MicroMsg.SysMsgTemplateImp", "hy: [digest] not retrieved sysmsg from new xml!");
            return null;
        }
        String str2 = (String) z.get(".sysmsg.$type");
        if (!bi.oW(str2) && "sysmsgtemplate".equals(str2)) {
            return a(z, null, null, 1);
        }
        x.w("MicroMsg.SysMsgTemplateImp", "hy: [digest] not acceptable sysmsg: %s", new Object[]{str2});
        return null;
    }

    private CharSequence a(Map<String, String> map, Bundle bundle, WeakReference<Context> weakReference, int i) {
        String str = ".sysmsg.sysmsgtemplate.content_template";
        ArrayList arrayList = new ArrayList();
        int i2 = 0;
        while (true) {
            int i3 = i2;
            String str2 = str + ((i3 == 0 ? "" : Integer.valueOf(i3)));
            if (bi.oW((String) map.get(str2))) {
                break;
            }
            String str3 = (String) map.get(str2 + ".$type");
            Object obj = ("tmpl_type_profile".equals(str3) || "tmpl_type_profilewithrevoke".equals(str3) || "tmpl_type_profilewithrevokeqrcode".equals(str3) || "tmpl_type_wxappnotifywithview".equals(str3)) ? 1 : null;
            if (obj == null) {
                x.w("MicroMsg.SysMsgTemplateImp", "hy: non supported type: %s", new Object[]{str3});
                arrayList.add(j(str2, map));
            }
            x.v("MicroMsg.SysMsgTemplateImp", "hy: rawTemplate : %s", new Object[]{(String) map.get(str2 + ".template")});
            ArrayList Hk = b.Hk(str3);
            str2 = "MicroMsg.SysMsgTemplateImp";
            String str4 = "hy: parsed %d models";
            Object[] objArr = new Object[1];
            objArr[0] = Integer.valueOf(Hk == null ? 0 : Hk.size());
            x.d(str2, str4, objArr);
            if (Hk == null || Hk.size() == 0) {
                arrayList.add(new SpannableString(""));
            } else {
                ArrayList arrayList2 = new ArrayList();
                Iterator it = Hk.iterator();
                while (it.hasNext()) {
                    com.tencent.mm.plugin.messenger.b.b.a aVar = (com.tencent.mm.plugin.messenger.b.b.a) it.next();
                    if (aVar.type == 0) {
                        arrayList2.add(new SpannableString(j.a(ad.getContext(), aVar.content)));
                    } else if (aVar.type == 1) {
                        int i4 = 0;
                        while (true) {
                            int i5 = i4;
                            String str5 = str + ".link_list.link";
                            if (i5 != 0) {
                                str4 = str5 + i5;
                            } else {
                                str4 = str5;
                            }
                            if (bi.oW((String) map.get(str4))) {
                                break;
                            }
                            if (aVar.content.equals((String) map.get(str4 + ".$name"))) {
                                str5 = (String) map.get(str4 + ".$type");
                                if (i == 0) {
                                    b bVar = (b) this.lcI.get(str5);
                                    if (!Hj(str5) || bVar == null) {
                                        String str6 = "MicroMsg.SysMsgTemplateImp";
                                        String str7 = "alvinluo not support link type: %s or listener == null: %b";
                                        Object[] objArr2 = new Object[2];
                                        objArr2[0] = bi.aG(str5, "");
                                        objArr2[1] = Boolean.valueOf(bVar == null);
                                        x.i(str6, str7, objArr2);
                                        arrayList2.add(j(str4, map));
                                    } else {
                                        obj = bVar.a(map, str4, bundle, weakReference);
                                        x(obj);
                                        if (obj == null || obj.length() == 0) {
                                            obj = new SpannableString("");
                                        }
                                        arrayList2.add(obj);
                                    }
                                } else if (i == 1) {
                                    e$a e_a = (e$a) this.lcJ.get(str5);
                                    if (!Hj(str5) || e_a == null) {
                                        arrayList2.add(j(str4, map));
                                    } else {
                                        arrayList2.add(bi.oV(e_a.h(map, str4)));
                                    }
                                } else {
                                    x.e("MicroMsg.SysMsgTemplateImp", "hy: not supported digest type");
                                }
                            }
                            i4 = i5 + 1;
                        }
                    } else {
                        x.e("MicroMsg.SysMsgTemplateImp", "hy: invalid! should not get here");
                    }
                }
                x.v("MicroMsg.SysMsgTemplateImp", "hy: concatedvalue is %s", new Object[]{F(arrayList2)});
                arrayList.add(r3);
            }
            i2 = i3 + 1;
        }
        if (arrayList.size() != 0) {
            return F(arrayList);
        }
        x.w("MicroMsg.SysMsgTemplateImp", "hy: not handled");
        return new SpannableString("");
    }

    private static void x(CharSequence charSequence) {
        int i = 0;
        if (charSequence != null && charSequence.length() > 0 && (charSequence instanceof Spanned)) {
            ClickableSpan[] clickableSpanArr = (ClickableSpan[]) ((Spanned) charSequence).getSpans(0, charSequence.length(), ClickableSpan.class);
            if (clickableSpanArr != null && clickableSpanArr.length > 0) {
                int length = clickableSpanArr.length;
                while (i < length) {
                    if (clickableSpanArr[i] instanceof com.tencent.mm.ui.base.a.a) {
                        i++;
                    } else {
                        throw new IllegalArgumentException("hy: actively throw Exception!!! all clickable spans must be instance of com.tencent.mm.ui.base.span.IPressableSpan!");
                    }
                }
            }
        }
    }

    private static CharSequence F(ArrayList<CharSequence> arrayList) {
        CharSequence spannableString = new SpannableString("");
        Iterator it = arrayList.iterator();
        while (true) {
            CharSequence charSequence = spannableString;
            if (!it.hasNext()) {
                return charSequence;
            }
            spannableString = (CharSequence) it.next();
            spannableString = TextUtils.concat(new CharSequence[]{charSequence, spannableString});
        }
    }

    private static CharSequence j(String str, Map<String, String> map) {
        if ((bi.getInt((String) map.get(new StringBuilder().append(str).append(".$hidden").toString()), 0) == 1 ? 1 : 0) != 0) {
            x.v("MicroMsg.SysMsgTemplateImp", "hy: hide");
            return new SpannableString("");
        }
        return new SpannableString(j.a(ad.getContext(), bi.oV((String) map.get(str + ".plain"))));
    }

    private static boolean Hj(String str) {
        if ("link_profile".equals(str) || "link_revoke".equals(str) || "link_revoke_qrcode".equals(str) || "link_plain".equals(str) || "link_view_wxapp".equals(str)) {
            return true;
        }
        return false;
    }
}
