package com.tencent.mm.plugin.sns.f;

import android.content.Context;
import android.content.Intent;
import android.text.SpannableString;
import android.view.View;
import android.view.ViewStub;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.TextView.BufferType;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.g.a.kn;
import com.tencent.mm.g.a.ko;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.platformtools.ab;
import com.tencent.mm.plugin.sns.data.i;
import com.tencent.mm.plugin.sns.f.d.b;
import com.tencent.mm.plugin.sns.i.f;
import com.tencent.mm.plugin.sns.i.j;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.plugin.sns.model.r;
import com.tencent.mm.plugin.sns.ui.av;
import com.tencent.mm.plugin.sns.ui.bf;
import com.tencent.mm.pluginsdk.ui.d.o;
import com.tencent.mm.pluginsdk.ui.d.o$a;
import com.tencent.mm.protocal.c.boy;
import com.tencent.mm.protocal.c.bpg;
import com.tencent.mm.protocal.c.bsu;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.s;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class c implements e, com.tencent.mm.plugin.sns.model.e {
    public static final Pattern nuh = Pattern.compile("\\{richtext:([\\s\\S]*?)\\}");
    public static final Pattern nui = Pattern.compile("\\{sex:([\\s\\S]*?):([\\s\\S]*?):([\\s\\S]*?)\\}");
    private com.tencent.mm.plugin.sns.g.c now;
    public final int ntZ = 500;
    public final int ntv = 14;
    private List<d> nua;
    public ListView nub;
    public av nuc;
    public Map<Long, Integer> nud = new HashMap();
    public HashSet<Long> nue = new HashSet();
    public HashSet<Long> nuf = new HashSet();
    private HashMap<Long, a> nug = new HashMap();
    private o$a nuj = new 6(this);

    public final void a(int i, int i2, String str, l lVar) {
        x.i("MicroMsg.SnSABTestMgr", "onSceneend " + i + " errCode " + i2);
        a.sFg.m(new kn());
    }

    public final void init() {
        List arrayList = new ArrayList();
        for (com.tencent.mm.storage.c cVar : com.tencent.mm.model.c.c.Jx().XF("10001").values()) {
            d dVar = new d();
            if (cVar == null) {
                x.i("MicroMsg.SnsABTestStrategy", "abtest is null");
            } else if (cVar.isValid()) {
                Map ckq = cVar.ckq();
                if (ckq != null) {
                    x.i("MicroMsg.SnsABTestStrategy", "snsabtest feed " + cVar.field_expId + " " + cVar.field_layerId + " " + cVar.field_startTime + " " + cVar.field_endTime);
                    dVar.d(cVar.field_layerId, cVar.field_expId, ckq);
                    int i = (!dVar.bKE || dVar.nuB == null || dVar.nuB.size() <= 0) ? 0 : 1;
                    if (i != 0) {
                        arrayList.add(dVar);
                    }
                }
            } else {
                x.i("MicroMsg.SnsABTestStrategy", "abtest is invalid");
            }
        }
        this.nua = arrayList;
        this.nud.clear();
        this.nue.clear();
        this.nug.clear();
        this.now = null;
        if (this.nua != null && this.nua.size() != 0) {
            long currentTimeMillis = System.currentTimeMillis();
            StringBuilder stringBuilder = new StringBuilder();
            g.Ek();
            String stringBuilder2 = stringBuilder.append(g.Ei().cachePath).append("ws_1100004").toString();
            x.i("MicroMsg.SnSABTestMgr", "filepath to list  " + stringBuilder2);
            byte[] e = FileOp.e(stringBuilder2, 0, -1);
            if (e != null) {
                try {
                    this.now = (com.tencent.mm.plugin.sns.g.c) new com.tencent.mm.plugin.sns.g.c().aG(e);
                    x.i("MicroMsg.SnSABTestMgr", "fileToList " + (System.currentTimeMillis() - currentTimeMillis));
                    if (this.now == null) {
                        x.i("MicroMsg.SnSABTestMgr", "igNoreAbTestId parser error");
                    } else {
                        x.i("MicroMsg.SnSABTestMgr", "igNoreAbTestId size " + this.now.nuR.size());
                    }
                } catch (Throwable e2) {
                    x.printErrStackTrace("MicroMsg.SnSABTestMgr", e2, "", new Object[0]);
                    FileOp.deleteFile(stringBuilder2);
                }
            }
        }
    }

    private void eX(long j) {
        if (this.now == null) {
            this.now = new com.tencent.mm.plugin.sns.g.c();
        }
        if (this.now.nuR.size() > 500) {
            this.now.nuR.remove(0);
        }
        this.now.nuR.add(Long.valueOf(j));
    }

    public final void clean() {
        this.nub = null;
        this.nuc = null;
        if (this.nue != null) {
            Iterator it = this.nue.iterator();
            while (it.hasNext()) {
                Long l = (Long) it.next();
                r rVar = new r(l.longValue(), 0, 0, null);
                g.Ek();
                g.Eh().dpP.a(rVar, 0);
                x.i("MicroMsg.SnSABTestMgr", "report id " + l);
            }
        }
        if (this.nug != null) {
            for (a a : this.nug.values()) {
                a(a);
            }
            this.nug.clear();
        }
        if (this.nua.size() != 0 && this.now != null) {
            long currentTimeMillis = System.currentTimeMillis();
            StringBuilder stringBuilder = new StringBuilder();
            g.Ek();
            String stringBuilder2 = stringBuilder.append(g.Ei().cachePath).append("ws_1100004").toString();
            x.i("MicroMsg.SnSABTestMgr", "listToFile to list  " + stringBuilder2);
            try {
                byte[] toByteArray = this.now.toByteArray();
                com.tencent.mm.a.e.b(stringBuilder2, toByteArray, toByteArray.length);
                x.i("MicroMsg.SnSABTestMgr", "listTofile " + (System.currentTimeMillis() - currentTimeMillis) + " igNoreAbTestId " + this.now.nuR.size());
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.SnSABTestMgr", e, "listToFile failed: " + stringBuilder2, new Object[0]);
            }
        }
    }

    public static void c(View view, com.tencent.mm.plugin.sns.ui.a.a.c cVar) {
        cVar.ojs = false;
        cVar.ojr = (ViewStub) view.findViewById(f.sns_post_item_abtest);
        cVar.ojr.setVisibility(8);
        cVar.ojw = (ViewStub) view.findViewById(f.sns_item_abtest_layout);
        cVar.ojw.setVisibility(8);
    }

    public final void a(Context context, boy boy, com.tencent.mm.plugin.sns.ui.a.a.c cVar) {
        if (!w.chM()) {
            b(cVar);
        } else if (this.nua == null || this.nua.size() == 0) {
            b(cVar);
        } else if (this.nuf.contains(Long.valueOf(boy.rlK))) {
            b(cVar);
            cVar.ojO.setVisibility(8);
            cVar.eCl.setVisibility(8);
            cVar.jEz.setVisibility(8);
        } else if (boy.rdS == null || boy.rdS.equals(af.bxU())) {
            b(cVar);
        } else if (this.now == null || !this.now.nuR.contains(Long.valueOf(boy.rlK))) {
            int i;
            if (boy != null) {
                try {
                    byte[] a = ab.a(boy.smY);
                    if (bi.bC(a)) {
                        i = 0;
                    } else {
                        i = ((bpg) new bpg().aG(a)).snj;
                    }
                } catch (Exception e) {
                    i = 0;
                }
            } else {
                i = 0;
            }
            int i2 = 0;
            if (this.nud.containsKey(Long.valueOf(boy.rlK))) {
                i2 = ((Integer) this.nud.get(Long.valueOf(boy.rlK))).intValue();
                if (i2 == -1) {
                    b(cVar);
                    return;
                }
            }
            int i3 = i2;
            d dVar = null;
            for (d dVar2 : this.nua) {
                if (dVar2 != null) {
                    if (dVar2.nuA == i) {
                        dVar = dVar2;
                        break;
                    }
                }
                b(cVar);
                return;
            }
            if (dVar == null) {
                b(cVar);
            } else if (i3 >= dVar.nuB.size()) {
                b(cVar);
            } else {
                b bVar = (b) dVar.nuB.get(i3);
                int i4 = bVar.showType;
                b(cVar);
                if (i > 0) {
                    if (this.nug.containsKey(Long.valueOf(boy.rlK))) {
                        ((a) this.nug.get(Long.valueOf(boy.rlK))).dv(i4, bVar.frZ.size());
                    } else {
                        a aVar = new a(System.currentTimeMillis(), boy.rlK, i.eF(boy.rlK), dVar);
                        aVar.dv(i4, bVar.frZ.size());
                        this.nug.put(Long.valueOf(boy.rlK), aVar);
                    }
                    if (i4 == 1) {
                        CharSequence charSequence = bVar.title;
                        if (!cVar.ojs) {
                            cVar.ojt = cVar.ojr.inflate();
                            cVar.ojs = true;
                            cVar.ojv = (TextView) cVar.ojt.findViewById(f.post_abtest_click_text);
                            cVar.oju = (LinearLayout) cVar.ojt.findViewById(f.abtest_button_list);
                        }
                        cVar.ojt.setVisibility(0);
                        cVar.ojv.setText(charSequence);
                        List list = bVar.frZ;
                        if (list.size() != cVar.oju.getChildCount()) {
                            cVar.oju.removeAllViews();
                            i2 = 0;
                            while (true) {
                                i = i2;
                                if (i >= list.size()) {
                                    break;
                                }
                                d.a aVar2 = (d.a) list.get(i);
                                View textView = new TextView(cVar.oju.getContext());
                                textView.setText(aVar2.nuC);
                                textView.setPadding(0, 0, com.tencent.mm.bp.a.fromDPToPix(context, 10), 0);
                                textView.setVisibility(0);
                                textView.setTextSize(1, 14.0f * com.tencent.mm.bp.a.fe(context));
                                textView.setTextColor(context.getResources().getColor(com.tencent.mm.plugin.sns.i.c.sns_link_color));
                                cVar.oju.addView(textView);
                                i2 = i + 1;
                            }
                        }
                        for (i2 = 0; i2 < list.size(); i2++) {
                            d.a aVar3 = (d.a) list.get(i2);
                            TextView textView2 = (TextView) cVar.oju.getChildAt(i2);
                            textView2.setText(a(context, textView2, a(f.a(aVar3), boy), boy, cVar, aVar3, bVar, dVar));
                            textView2.setTag(boy);
                            textView2.setOnClickListener(new 1(this, context, aVar3, bVar, cVar, dVar));
                        }
                        return;
                    } else if (i4 == 4) {
                        a(context, boy, cVar, bVar, dVar);
                        return;
                    } else if (i4 == 2) {
                        if (!b(context, boy, cVar, bVar, dVar)) {
                            return;
                        }
                        return;
                    }
                }
                b(cVar);
            }
        } else {
            b(cVar);
        }
    }

    private boolean a(Context context, boy boy, com.tencent.mm.plugin.sns.ui.a.a.c cVar, b bVar, d dVar) {
        cVar.jEz.setBackgroundDrawable(null);
        int i = cVar.position - 1;
        if (this.nuc != null) {
            WeakReference weakReference = (WeakReference) this.nuc.obX.get(Integer.valueOf(i));
            if (!(weakReference == null || weakReference.get() == null)) {
                ((View) weakReference.get()).setBackgroundDrawable(null);
            }
        }
        if (!cVar.ojx) {
            cVar.ojy = cVar.ojw.inflate();
            cVar.ojx = true;
            cVar.ojz = (LinearLayout) cVar.ojy.findViewById(f.sns_abtest_one_item_ll);
        }
        cVar.ojy.setVisibility(0);
        cVar.ojO.setVisibility(8);
        cVar.eCl.setVisibility(8);
        List list = bVar.frZ;
        if (list.size() != cVar.ojz.getChildCount()) {
            cVar.ojz.removeAllViews();
            int fromDPToPix = com.tencent.mm.bp.a.fromDPToPix(context, 10);
            for (i = 0; i < list.size(); i++) {
                View textView = new TextView(context);
                textView.setBackgroundResource(com.tencent.mm.plugin.sns.i.e.album_abtesti_cellbg);
                textView.setPadding(fromDPToPix, fromDPToPix, fromDPToPix, fromDPToPix);
                textView.setTextSize(1, 14.0f * com.tencent.mm.bp.a.fe(context));
                textView.setTextColor(context.getResources().getColor(com.tencent.mm.plugin.sns.i.c.black));
                cVar.ojz.addView(textView);
            }
        }
        i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= list.size()) {
                return true;
            }
            d.a aVar = (d.a) list.get(i2);
            TextView textView2 = (TextView) cVar.ojz.getChildAt(i2);
            textView2.setText(aVar.nuC);
            textView2.setTag(boy);
            String a = a(f.a(aVar), boy);
            textView2.setOnClickListener(new 2(this, context, aVar, bVar, cVar, dVar));
            textView2.setText(a(context, textView2, a, boy, cVar, aVar, bVar, dVar), BufferType.SPANNABLE);
            if (aVar.actionType != 5) {
                textView2.setCompoundDrawablePadding(com.tencent.mm.bp.a.fromDPToPix(context, 5));
                textView2.setCompoundDrawablesWithIntrinsicBounds(context.getResources().getDrawable(com.tencent.mm.plugin.sns.i.i.album_abtesti_icon2), null, null, null);
            }
            i = i2 + 1;
        }
    }

    private boolean b(Context context, boy boy, com.tencent.mm.plugin.sns.ui.a.a.c cVar, b bVar, d dVar) {
        if (bVar.frZ.size() != 2) {
            return false;
        }
        d.a aVar = (d.a) bVar.frZ.get(0);
        d.a aVar2 = (d.a) bVar.frZ.get(1);
        String a = a(f.a(aVar), boy);
        String a2 = a(f.a(aVar2), boy);
        h.a(context, a(bVar.title, boy), context.getString(j.app_tip), a, a2, new 3(this, context, boy, aVar, bVar, cVar, dVar), new 4(this, context, boy, aVar2, bVar, cVar, dVar));
        return true;
    }

    private void a(com.tencent.mm.plugin.sns.ui.a.a.c cVar) {
        if (cVar != null) {
            Context context = cVar.jEz.getContext();
            if (context != null) {
                if (cVar.jEz.getBackground() == null) {
                    cVar.jEz.setBackgroundResource(com.tencent.mm.plugin.sns.i.e.comm_list_item_selector);
                    cVar.jEz.setPadding(com.tencent.mm.bp.a.fromDPToPix(context, 12), com.tencent.mm.bp.a.fromDPToPix(context, 12), com.tencent.mm.bp.a.fromDPToPix(context, 12), com.tencent.mm.bp.a.fromDPToPix(context, 8));
                }
                int i = cVar.position - 1;
                if (this.nuc != null) {
                    WeakReference weakReference = (WeakReference) this.nuc.obX.get(Integer.valueOf(i));
                    if (weakReference != null && weakReference.get() != null) {
                        ((View) weakReference.get()).setBackgroundResource(com.tencent.mm.plugin.sns.i.e.comm_list_item_selector);
                        ((View) weakReference.get()).setPadding(com.tencent.mm.bp.a.fromDPToPix(context, 12), com.tencent.mm.bp.a.fromDPToPix(context, 12), com.tencent.mm.bp.a.fromDPToPix(context, 12), com.tencent.mm.bp.a.fromDPToPix(context, 8));
                    }
                }
            }
        }
    }

    private void a(Context context, boy boy, d.a aVar, b bVar, com.tencent.mm.plugin.sns.ui.a.a.c cVar, d dVar) {
        x.i("MicroMsg.SnSABTestMgr", "processButtonClick snsobj " + boy.rdS + " " + boy.rlK);
        int i = aVar.nuE - 1;
        a aVar2 = (a) this.nug.get(Long.valueOf(boy.rlK));
        if (aVar2 != null) {
            aVar2.t(bVar.showType, bVar.frZ.size(), aVar.index, aVar.actionType);
            aVar2.nuv = -1;
            aVar2.nuw = -1;
        }
        String str;
        if (aVar.actionType == 3) {
            this.nue.add(Long.valueOf(boy.rlK));
            this.nud.put(Long.valueOf(boy.rlK), Integer.valueOf(i));
        } else if (aVar.actionType == 1) {
            this.nud.put(Long.valueOf(boy.rlK), Integer.valueOf(i));
            eX(boy.rlK);
            b(cVar);
        } else if (aVar.actionType == 5) {
            if (this.nue.contains(Long.valueOf(boy.rlK))) {
                this.nue.remove(Long.valueOf(boy.rlK));
                eX(boy.rlK);
                b(cVar);
                if (this.nug.containsKey(Long.valueOf(boy.rlK))) {
                    a((a) this.nug.remove(Long.valueOf(boy.rlK)));
                }
            }
            this.nud.put(Long.valueOf(boy.rlK), Integer.valueOf(-1));
            a(cVar);
            return;
        } else if (aVar.actionType == 7) {
            if (i < dVar.nuB.size()) {
                b bVar2 = (b) dVar.nuB.get(i);
                if (bVar2.showType == 2) {
                    b(context, boy, cVar, bVar2, dVar);
                    return;
                } else if (bVar2.showType == 5) {
                    s.makeText(context, bi.aG(bVar2.title, ""), 0).show();
                    eX(boy.rlK);
                    b(cVar);
                    return;
                }
            }
        } else if (aVar.actionType == 6) {
            s.makeText(context, bi.aG(context.getString(j.sns_abtest_toast), ""), 0).show();
            this.nuf.add(Long.valueOf(boy.rlK));
            b(cVar);
            a.sFg.m(new ko());
            a(cVar);
            return;
        } else if (aVar.actionType == 2) {
            str = aVar.jumpUrl;
            x.i("MicroMsg.SnSABTestMgr", "jump url " + str);
            Intent intent = new Intent();
            intent.putExtra("rawUrl", str);
            intent.putExtra("useJs", true);
            com.tencent.mm.plugin.sns.c.a.ezn.j(intent, context);
            eX(boy.rlK);
            b(cVar);
            a(cVar);
            return;
        } else if (aVar.actionType == 8) {
            return;
        } else {
            if (aVar.actionType == 4) {
                str = boy.rdS;
                List linkedList = new LinkedList();
                linkedList.add(str);
                com.tencent.mm.plugin.sns.model.w wVar = new com.tencent.mm.plugin.sns.model.w(1, 5, "", linkedList.size(), linkedList, 0);
                g.Ek();
                g.Eh().dpP.a(wVar, 0);
            }
        }
        if (i == 4 || i == 1) {
            a(context, boy, cVar);
        }
    }

    private static void b(com.tencent.mm.plugin.sns.ui.a.a.c cVar) {
        if (cVar != null) {
            if (cVar.ojr != null) {
                cVar.ojr.setVisibility(8);
            }
            if (cVar.ojt != null) {
                cVar.ojt.setVisibility(8);
            }
            if (cVar.ojw != null) {
                cVar.ojw.setVisibility(8);
            }
            if (cVar.ojy != null) {
                cVar.ojy.setVisibility(8);
            }
            if (cVar.ojO.getVisibility() == 8) {
                cVar.ojO.setVisibility(0);
            }
            if (cVar.eCl.getVisibility() == 8) {
                cVar.eCl.setVisibility(0);
            }
            if (cVar.jEz.getVisibility() == 8) {
                cVar.jEz.setVisibility(0);
            }
        }
    }

    private static String a(String str, boy boy) {
        Throwable e;
        String str2;
        try {
            if (bi.oW(str)) {
                return "";
            }
            int i;
            String str3 = boy.rdS;
            g.Ek();
            com.tencent.mm.storage.ab Yg = ((com.tencent.mm.plugin.messenger.foundation.a.i) g.l(com.tencent.mm.plugin.messenger.foundation.a.i.class)).FR().Yg(str3);
            if (str.contains("{username}")) {
                str = str.replace("{username}", Yg.BL());
            }
            if (Yg.sex == 1) {
                i = 0;
            } else if (Yg.sex == 2) {
                i = 1;
            } else {
                i = 2;
            }
            while (true) {
                try {
                    str2 = str;
                    Matcher matcher = nui.matcher(str2);
                    if (!matcher.find() || matcher.groupCount() != 3) {
                        return str2;
                    }
                    CharSequence group = matcher.group();
                    CharSequence group2 = i == 0 ? matcher.group(1) : i == 1 ? matcher.group(2) : matcher.group(3);
                    str = str2.replace(group, group2);
                } catch (Exception e2) {
                    e = e2;
                    x.printErrStackTrace("MicroMsg.SnSABTestMgr", e, "settext error ", new Object[0]);
                    return str2;
                }
            }
        } catch (Exception e3) {
            e = e3;
            str2 = str;
            x.printErrStackTrace("MicroMsg.SnSABTestMgr", e, "settext error ", new Object[0]);
            return str2;
        }
    }

    private SpannableString a(Context context, TextView textView, String str, boy boy, com.tencent.mm.plugin.sns.ui.a.a.c cVar, d.a aVar, b bVar, d dVar) {
        Matcher matcher = nuh.matcher(str);
        if (!matcher.find() || matcher.groupCount() != 1) {
            return com.tencent.mm.pluginsdk.ui.d.j.a(context, str);
        }
        CharSequence group = matcher.group();
        Object group2 = matcher.group(1);
        int indexOf = str.indexOf(group);
        CharSequence replace = str.replace(group, group2);
        textView.setOnClickListener(null);
        textView.setClickable(true);
        SpannableString spannableString = new SpannableString(replace);
        textView.setOnTouchListener(new com.tencent.mm.plugin.sns.ui.ab());
        spannableString.setSpan(new o(boy.rdS, new 5(this, context, boy, aVar, bVar, cVar, dVar)), indexOf, group2.length() + indexOf, 33);
        return spannableString;
    }

    public final void a(int i, String str, long j, String str2, bsu bsu, boolean z, bf bfVar) {
    }

    public final void a(int i, String str, long j, String str2, bsu bsu, boolean z) {
        if (this.nug.containsKey(Long.valueOf(j))) {
            a aVar = (a) this.nug.get(Long.valueOf(j));
            if (aVar.mEndTime == -1) {
                aVar.mEndTime = System.currentTimeMillis();
            }
            aVar.t(aVar.nuv, aVar.nuw, 0, 0);
        }
    }

    private static void a(a aVar) {
        d dVar = aVar.nuu;
        if (dVar != null) {
            String str = dVar.ntY;
            String str2 = dVar.ntX;
            String str3 = aVar.nuz;
            aVar.t(aVar.nuv, aVar.nuw, 0, 0);
            String str4 = aVar.nuy;
            if (bi.oW(str4)) {
                str4 = aVar.nuv + ":" + aVar.nuw + ":0:0";
            }
            String str5 = "";
            long j = aVar.mStartTime / 1000;
            if (aVar.mEndTime == -1) {
                aVar.mEndTime = System.currentTimeMillis();
            }
            long j2 = aVar.mEndTime / 1000;
            if (aVar != null) {
                x.i("MicroMsg.SnSABTestMgr", "report layerId: " + str + " expid " + str2 + " acton " + str4 + " starttime " + j + " timelineId: " + str3);
                com.tencent.mm.plugin.report.service.h.mEJ.h(11917, new Object[]{str, str2, str5, str5, Integer.valueOf(1), str3, str4, Long.valueOf(j), Long.valueOf(j2)});
            }
        }
    }
}
