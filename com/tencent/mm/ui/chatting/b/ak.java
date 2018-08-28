package com.tencent.mm.ui.chatting.b;

import android.content.Context;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.ac.f;
import com.tencent.mm.g.a.fi;
import com.tencent.mm.g.a.fi$a;
import com.tencent.mm.g.a.fm;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.model.s;
import com.tencent.mm.modelvoice.m;
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.bd;
import com.tencent.mm.storage.bx;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.chatting.b.a.a;
import com.tencent.mm.ui.chatting.b.b.ad;
import com.tencent.mm.ui.chatting.viewitems.ChattingItemTranslate.b;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map.Entry;

@a(cwo = ad.class)
public class ak extends a implements ad {
    private static HashMap<Long, String> tSN = new HashMap();
    private static HashMap<Long, b> tSO = new HashMap();
    private static LinkedHashMap<Long, bd> tSP = new LinkedHashMap();
    private static HashMap<Long, Boolean> tSQ = new HashMap();
    boolean tSR = false;
    long tSS = 0;
    boolean tST = false;

    public final synchronized void a(long j, String str, b bVar) {
        tSN.put(Long.valueOf(j), str);
        tSO.put(Long.valueOf(j), bVar);
        if (bVar == b.ues) {
            tSQ.put(Long.valueOf(j), Boolean.valueOf(true));
        }
    }

    private synchronized void gB(long j) {
        tSN.remove(Long.valueOf(j));
        tSO.remove(Long.valueOf(j));
    }

    public final synchronized String w(long j, String str) {
        String str2;
        str2 = (String) tSN.get(Long.valueOf(j));
        if (bi.oW(str2)) {
            bx Zs = m.TJ().Zs(str);
            if (!(Zs == null || bi.oW(Zs.field_content))) {
                str2 = Zs.field_content;
            }
        }
        return str2;
    }

    public final synchronized b gC(long j) {
        b bVar;
        bVar = (b) tSO.get(Long.valueOf(j));
        if (bVar == null) {
            bVar = b.uep;
        }
        return bVar;
    }

    private synchronized void c(long j, bd bdVar) {
        tSP.put(Long.valueOf(j), bdVar);
    }

    public final synchronized boolean gD(long j) {
        boolean z;
        if (tSP.containsKey(Long.valueOf(j))) {
            z = true;
        } else {
            z = false;
        }
        return z;
    }

    private synchronized bd gE(long j) {
        return (bd) tSP.get(Long.valueOf(j));
    }

    public final synchronized bd cwf() {
        bd bdVar;
        Iterator it = tSP.entrySet().iterator();
        if (it.hasNext()) {
            bdVar = (bd) ((Entry) it.next()).getValue();
        } else {
            bdVar = null;
        }
        return bdVar;
    }

    private synchronized void gF(long j) {
        if (tSP.containsKey(Long.valueOf(j))) {
            tSP.remove(Long.valueOf(j));
        }
    }

    private synchronized void cwg() {
        tSP.clear();
    }

    public final boolean cwh() {
        au.HU();
        return !((Boolean) c.DT().get(75, Boolean.valueOf(false))).booleanValue();
    }

    public final void cwi() {
        au.HU();
        c.DT().set(75, Boolean.valueOf(true));
    }

    public final void e(bd bdVar, boolean z) {
        int i = 2;
        if (bdVar == null) {
            x.d("MicroMsg.TransformComponent", "go VoiceTransTextAct need MsgInfo but null");
        } else if (gG(bdVar.field_msgId)) {
            x.i("MicroMsg.TransformComponent", "go VoiceTransTextAct unsetflag MsgId:%s,isVoiceTransforming:%s", new Object[]{Long.valueOf(bdVar.field_msgId), Boolean.valueOf(this.tSR)});
            bdVar.cmD();
            gH(bdVar.field_msgId);
            notifyDataSetChanged();
        } else if (gD(bdVar.field_msgId) && z) {
            if (gC(bdVar.field_msgId) == b.ueq) {
                x.i("MicroMsg.TransformComponent", "go VoiceTransTextAct unsetflag removeCache");
                gF(bdVar.field_msgId);
                gB(bdVar.field_msgId);
                c(5, bdVar);
            } else if (this.tSR) {
                fi fiVar = new fi();
                fiVar.bNF.bNI = 3;
                com.tencent.mm.sdk.b.a.sFg.m(fiVar);
                gF(bdVar.field_msgId);
                gB(bdVar.field_msgId);
                bdVar.cmD();
                au.HU();
                c.FT().a(bdVar.field_msgId, bdVar);
                cwj();
            }
            notifyDataSetChanged();
        } else {
            bx Zs = m.TJ().Zs(bdVar.field_imgPath);
            if (Zs == null || bi.oW(Zs.field_content)) {
                int Lg = au.DF().Lg();
                if (Lg != 4 && Lg != 6) {
                    h.i(getContext(), R.l.chatting_transform_network_unavailable, R.l.app_tip);
                    c(2, bdVar);
                    return;
                } else if (this.tSR) {
                    x.i("MicroMsg.TransformComponent", "go VoiceTransformText insert transformQueue");
                    c(bdVar.field_msgId, bdVar);
                    a(bdVar.field_msgId, "", b.ueq);
                    notifyDataSetChanged();
                    return;
                } else {
                    fi fiVar2 = new fi();
                    fiVar2.bNF.bNI = 1;
                    com.tencent.mm.sdk.b.a.sFg.m(fiVar2);
                    fiVar2 = new fi();
                    fiVar2.bNF.bNH = String.valueOf(bdVar.field_msgId);
                    fiVar2.bNF.fileName = bdVar.field_imgPath;
                    fiVar2.bNF.bJu = 1;
                    fiVar2.bNF.bNI = 0;
                    fi$a fi_a = fiVar2.bNF;
                    if (s.hf(this.bAG.getTalkerUserName())) {
                        i = ((com.tencent.mm.ui.chatting.b.b.c) this.bAG.O(com.tencent.mm.ui.chatting.b.b.c.class)).cur() ? ((com.tencent.mm.ui.chatting.b.b.c) this.bAG.O(com.tencent.mm.ui.chatting.b.b.c.class)).cus() ? 5 : 4 : f.kL(this.bAG.getTalkerUserName()) ? 3 : f.kM(this.bAG.getTalkerUserName()) ? 0 : f.kI(this.bAG.getTalkerUserName()) ? 6 : 7;
                    } else if (!s.fq(this.bAG.getTalkerUserName())) {
                        i = 1;
                    }
                    fi_a.scene = i;
                    fiVar2.bNF.bNJ = new 1(this, fiVar2);
                    a(Long.valueOf(fiVar2.bNF.bNH).longValue(), "", b.uer);
                    c(bdVar.field_msgId, bdVar);
                    this.tSR = true;
                    notifyDataSetChanged();
                    if (com.tencent.mm.sdk.b.a.sFg.m(fiVar2)) {
                        x.i("MicroMsg.TransformComponent", "go VoiceTransTextAct publish ExtTranslateVoiceEvent");
                        return;
                    }
                    x.i("MicroMsg.TransformComponent", "go VoiceTransTextAct publish ExtTranslateVoiceEvent fail");
                    aat(getContext().getString(R.l.chatting_transform_fail));
                    gB(Long.valueOf(fiVar2.bNF.bNH).longValue());
                    gF(Long.valueOf(fiVar2.bNF.bNH).longValue());
                    this.tSR = false;
                    cwj();
                    return;
                }
            }
            x.i("MicroMsg.TransformComponent", "alvinluo VoiceTransformText has TransContent MsgId:%s, clientMsgId: %s", new Object[]{Long.valueOf(bdVar.field_msgId), bdVar.field_imgPath});
            bdVar.cmE();
            a(bdVar.field_msgId, Zs.field_content, b.ues);
            au.HU();
            c.FT().a(bdVar.field_msgId, bdVar);
        }
    }

    private static void c(int i, bd bdVar) {
        if (bdVar != null) {
            fm fmVar = new fm();
            fmVar.bNQ.bNS = 0;
            fmVar.bNQ.bNT = 0;
            fmVar.bNQ.bNU = 0;
            fmVar.bNQ.bNR = 0;
            fmVar.bNQ.fileName = bdVar.field_imgPath;
            fmVar.bNQ.result = i;
            com.tencent.mm.sdk.b.a.sFg.m(fmVar);
        }
    }

    private synchronized void cwj() {
        ag cwt = this.bAG != null ? com.tencent.mm.ui.chatting.c.a.cwt() : null;
        if (cwt != null) {
            cwt.post(new 2(this));
        }
    }

    private void notifyDataSetChanged() {
        if (this.bAG != null) {
            this.bAG.avj();
        }
    }

    private Context getContext() {
        if (this.bAG != null) {
            return this.bAG.tTq.getContext();
        }
        return com.tencent.mm.sdk.platformtools.ad.getContext();
    }

    private void aat(String str) {
        if (this.bAG != null && this.bAG.tTq.getContext() != null) {
            Toast makeText = Toast.makeText(this.bAG.tTq.getContext(), str, 0);
            makeText.setGravity(17, 0, 0);
            makeText.show();
        }
    }

    public final synchronized boolean gG(long j) {
        boolean booleanValue;
        Boolean bool = (Boolean) tSQ.get(Long.valueOf(j));
        if (bool != null) {
            booleanValue = bool.booleanValue();
        } else {
            booleanValue = false;
        }
        return booleanValue;
    }

    private synchronized void gH(long j) {
        tSQ.put(Long.valueOf(j), Boolean.valueOf(false));
    }

    public final void cpK() {
        x.i("MicroMsg.TransformComponent", "[onChattingExitAnimStart]");
        x.i("MicroMsg.TransformComponent", "clear VoiceTransTextAct");
        cwg();
        if (this.tSR) {
            fi fiVar = new fi();
            fiVar.bNF.bNI = 3;
            com.tencent.mm.sdk.b.a.sFg.m(fiVar);
        }
        x.i("MicroMsg.TransformComponent", "alvinluo hide transformText");
        e.post(new 3(this), "UnsetTransformFlag");
    }
}
