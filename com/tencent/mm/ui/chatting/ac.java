package com.tencent.mm.ui.chatting;

import android.app.Activity;
import android.os.Looper;
import android.view.ViewStub;
import com.tencent.mm.R;
import com.tencent.mm.ar.d;
import com.tencent.mm.ar.e;
import com.tencent.mm.ar.f;
import com.tencent.mm.ar.h;
import com.tencent.mm.br.f.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.model.s;
import com.tencent.mm.platformtools.ai;
import com.tencent.mm.pluginsdk.g.a.a.m;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.bd;
import java.util.Iterator;
import java.util.List;

public final class ac {
    public List<bd> huM;
    public ag mHandler = new 1(this, Looper.getMainLooper());
    public ChattingAnimFrame tMs = null;
    public Activity tMt;

    public final void a(Activity activity, List<bd> list) {
        if (list != null) {
            for (bd bdVar : list) {
                Object obj;
                au.HU();
                if (ai.bG(ai.d((Long) c.DT().get(68108, null))) * 1000 > 21600000) {
                    new ag().postDelayed(new Runnable() {
                        public final void run() {
                            if (au.HX()) {
                                au.DF().a(new m(37), 0);
                                au.HU();
                                c.DT().set(68108, Long.valueOf(ai.VE()));
                            }
                        }
                    }, 10000);
                }
                f aDT = ((com.tencent.mm.plugin.emoji.b.c) g.n(com.tencent.mm.plugin.emoji.b.c.class)).getEmojiMgr().aDT();
                if (aDT == null) {
                    x.d("MicroMsg.EggMgr", "eggList is null");
                    obj = null;
                    continue;
                } else {
                    int VE = (int) bi.VE();
                    x.d("MicroMsg.EggMgr", "cursecond is %d, getEggList.size is %d", new Object[]{Integer.valueOf(VE), Integer.valueOf(aDT.ecJ.size())});
                    Iterator it = aDT.ecJ.iterator();
                    while (it.hasNext()) {
                        d dVar = (d) it.next();
                        String str = dVar.ecD;
                        Object obj2 = null;
                        if (ai.oW(str)) {
                            obj2 = 1;
                        } else {
                            for (String equals : str.split(",")) {
                                if (equals.equals(w.chP())) {
                                    obj2 = 1;
                                    break;
                                }
                            }
                        }
                        if (obj2 != null) {
                            Iterator it2 = dVar.ecy.iterator();
                            while (it2.hasNext()) {
                                e eVar = (e) it2.next();
                                String str2 = eVar.ecI;
                                if (ai.oW(str2)) {
                                    x.e("MicroMsg.EggMgr", "error egg keyWord");
                                } else {
                                    str = bdVar.field_content;
                                    if (s.fq(bdVar.field_talker)) {
                                        int iA = com.tencent.mm.model.bd.iA(str);
                                        if (iA != -1) {
                                            str = str.substring(iA + 1).trim();
                                        }
                                    }
                                    if (at(str, str2, eVar.lang)) {
                                        if (this.tMs == null) {
                                            ViewStub viewStub = (ViewStub) activity.findViewById(R.h.viewstub_chatting_animframe);
                                            if (viewStub != null) {
                                                viewStub.inflate();
                                            }
                                            this.tMs = (ChattingAnimFrame) activity.findViewById(R.h.chatting_anim_iv);
                                        }
                                        if (this.tMs == null) {
                                            x.e("MicroMsg.EggMgr", "AnimFrameView should not be null");
                                        } else if (dVar.ecB <= VE && ((long) VE) <= ((long) dVar.ecC) + 86400) {
                                            this.tMs.a(dVar);
                                            am(dVar.ecA, bdVar.field_isSend == 1);
                                            x.d("MicroMsg.EggMgr", "match keyWord[%s], time[%d - %d]", new Object[]{str2, Integer.valueOf(dVar.ecB), Integer.valueOf(dVar.ecC)});
                                            obj = 1;
                                            continue;
                                        } else if (dVar.ecB == dVar.ecC && dVar.ecB == 0) {
                                            this.tMs.a(dVar);
                                            am(dVar.ecA, bdVar.field_isSend == 1);
                                            x.d("MicroMsg.EggMgr", "match keyWord[%s], time[0 - 0]", new Object[]{str2});
                                            obj = 1;
                                            continue;
                                        } else {
                                            x.d("MicroMsg.EggMgr", "match keyWord[%s], but not match time[%d - %d]", new Object[]{str2, Integer.valueOf(dVar.ecB), Integer.valueOf(dVar.ecC)});
                                            obj = null;
                                            continue;
                                        }
                                    } else {
                                        continue;
                                    }
                                }
                            }
                            continue;
                        }
                    }
                    x.d("MicroMsg.EggMgr", "no match");
                    obj = null;
                    continue;
                }
                if (obj != null) {
                    return;
                }
            }
        }
    }

    private static boolean at(String str, String str2, String str3) {
        if (ai.oW(str) || ai.oW(str2) || ad.getContext() == null) {
            return false;
        }
        String toLowerCase = str.toLowerCase();
        int indexOf = toLowerCase.indexOf(str2.toLowerCase());
        if (indexOf == -1) {
            return false;
        }
        do {
            int i = indexOf;
            try {
                boolean z;
                if (i >= toLowerCase.length() - 1 || ai.oW(str3)) {
                    z = true;
                } else {
                    if (i > 0 && toLowerCase.charAt(i - 1) >= 'a' && toLowerCase.charAt(i - 1) <= 'z') {
                        x.v("MicroMsg.EggMgr", "letter in the prefix");
                        String substring = str.substring(0, i);
                        indexOf = substring.lastIndexOf(47);
                        if (indexOf != -1) {
                            substring = substring.subSequence(indexOf, substring.length());
                            com.tencent.mm.br.g.cjL();
                            a Xx = com.tencent.mm.br.f.cjI().Xx(substring);
                            substring = Xx != null ? Xx.text : null;
                            if (!ai.oW(substring) && substring.length() + indexOf == i) {
                                x.v("MicroMsg.EggMgr", "letter in the prefix is smiley");
                                indexOf = -2;
                            }
                        }
                        if (indexOf != -2) {
                            z = false;
                            if (z && str2.length() + i < toLowerCase.length() && toLowerCase.charAt(str2.length() + i) >= 'a' && toLowerCase.charAt(str2.length() + i) <= 'z') {
                                x.v("MicroMsg.EggMgr", "letter in the suffix");
                                z = false;
                            }
                        }
                    }
                    z = true;
                    x.v("MicroMsg.EggMgr", "letter in the suffix");
                    z = false;
                }
                if (z) {
                    x.v("MicroMsg.EggMgr", "full match, matchPos = %s, TextLength = %s, keyLength = %s", new Object[]{Integer.valueOf(i), Integer.valueOf(toLowerCase.length()), Integer.valueOf(str2.length())});
                    return z;
                }
                indexOf = toLowerCase.indexOf(str2.toLowerCase(), i + 1);
            } catch (Throwable e) {
                x.v("MicroMsg.EggMgr", "Exception in isKeywordMatch, %s", new Object[]{e.getMessage()});
                x.printErrStackTrace("MicroMsg.EggMgr", e, "", new Object[0]);
                return false;
            }
        } while (indexOf != -1);
        return false;
    }

    private static void am(int i, boolean z) {
        try {
            h hVar;
            int i2;
            StringBuilder stringBuilder;
            StringBuilder stringBuilder2 = new StringBuilder();
            au.HU();
            byte[] f = com.tencent.mm.a.e.f(stringBuilder2.append(c.Gp()).append("eggresult.rep").toString(), 0, -1);
            if (f != null) {
                x.d("MicroMsg.EggMgr", "data not null, parse it");
                hVar = (h) new h().aG(f);
            } else {
                x.d("MicroMsg.EggMgr", "data is null, new one");
                hVar = new h();
            }
            Iterator it = hVar.ecN.iterator();
            while (it.hasNext()) {
                com.tencent.mm.ar.g gVar = (com.tencent.mm.ar.g) it.next();
                if (gVar.ecA == i) {
                    if (z) {
                        gVar.ecL++;
                    } else {
                        gVar.ecM++;
                    }
                    i2 = 1;
                    if (i2 == 0) {
                        gVar = new com.tencent.mm.ar.g();
                        gVar.ecA = i;
                        if (z) {
                            gVar.ecL = 1;
                        } else {
                            gVar.ecM = 1;
                        }
                        hVar.ecN.add(gVar);
                    }
                    f = hVar.toByteArray();
                    x.d("MicroMsg.EggMgr", "report list is %s, then save it", new Object[]{hVar.toString()});
                    stringBuilder = new StringBuilder();
                    au.HU();
                    com.tencent.mm.a.e.b(stringBuilder.append(c.Gp()).append("eggresult.rep").toString(), f, f.length);
                }
            }
            i2 = 0;
            if (i2 == 0) {
                gVar = new com.tencent.mm.ar.g();
                gVar.ecA = i;
                if (z) {
                    gVar.ecL = 1;
                } else {
                    gVar.ecM = 1;
                }
                hVar.ecN.add(gVar);
            }
            f = hVar.toByteArray();
            x.d("MicroMsg.EggMgr", "report list is %s, then save it", new Object[]{hVar.toString()});
            stringBuilder = new StringBuilder();
            au.HU();
            com.tencent.mm.a.e.b(stringBuilder.append(c.Gp()).append("eggresult.rep").toString(), f, f.length);
        } catch (Throwable e) {
            x.w("MicroMsg.EggMgr", "statistics crash : %s", new Object[]{e.getLocalizedMessage()});
            x.printErrStackTrace("MicroMsg.EggMgr", e, "", new Object[0]);
        }
    }
}
