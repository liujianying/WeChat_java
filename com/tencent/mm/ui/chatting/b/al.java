package com.tencent.mm.ui.chatting.b;

import android.view.MenuItem;
import com.tencent.mm.R;
import com.tencent.mm.g.a.rt;
import com.tencent.mm.g.a.ru;
import com.tencent.mm.model.au;
import com.tencent.mm.model.s;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.at;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.bd;
import com.tencent.mm.ui.chatting.b.a.a;
import com.tencent.mm.ui.chatting.b.b.ae;
import com.tencent.mm.ui.chatting.viewitems.ChattingItemTranslate.b;
import java.util.HashMap;

@a(cwo = ae.class)
public class al extends a implements ae {
    private at tSV = new at(5, "msg-translate-update-worker");
    private HashMap<Long, b> tSW = new HashMap();
    private c tSX = new 2(this);

    public final void a(long j, b bVar) {
        this.tSW.put(Long.valueOf(j), bVar);
    }

    public final b bc(bd bdVar) {
        b bVar = (b) this.tSW.get(Long.valueOf(bdVar.field_msgId));
        if (bVar != null) {
            return bVar;
        }
        if (!bdVar.cmt()) {
            ru ruVar = new ru();
            ruVar.ccI.id = bdVar.field_msgId;
            com.tencent.mm.sdk.b.a.sFg.m(ruVar);
            if (!ruVar.ccJ.ccK) {
                return b.NoTransform;
            }
            bVar = b.Transforming;
            a(bdVar.field_msgId, bVar);
            return bVar;
        } else if (bdVar.cmy()) {
            return b.Transformed;
        } else {
            return b.NoTransform;
        }
    }

    public final boolean b(MenuItem menuItem, bd bdVar) {
        int itemId = menuItem.getItemId();
        switch (itemId) {
            case 124:
            case 125:
                int i;
                x.d("MicroMsg.ChattingUI.TranslateComponent", "longclick transalte type: %d isShowTranslated: %s", new Object[]{Integer.valueOf(bdVar.getType()), Boolean.valueOf(bdVar.cmy())});
                if (itemId == 124) {
                    au.HU();
                    if (!((Boolean) com.tencent.mm.model.c.DT().get(327712, Boolean.valueOf(false))).booleanValue()) {
                        i = R.l.chatting_translate_tips_content;
                        au.HU();
                        com.tencent.mm.model.c.DT().set(327712, Boolean.valueOf(true));
                        if (i != 0) {
                            com.tencent.mm.ui.widget.a.c.a aVar = new com.tencent.mm.ui.widget.a.c.a(this.bAG.tTq.getContext());
                            aVar.abu(this.bAG.tTq.getMMResources().getString(i));
                            aVar.abt(this.bAG.tTq.getMMResources().getString(R.l.chatting_translate_tips_title));
                            aVar.Gt(R.l.i_know_it).a(new 3(this, bdVar, menuItem, itemId));
                            aVar.anj().show();
                            return true;
                        }
                        menuItem.getGroupId();
                        f(bdVar, itemId == 125);
                        return true;
                    }
                }
                if (itemId == 125) {
                    au.HU();
                    if (!((Boolean) com.tencent.mm.model.c.DT().get(327713, Boolean.valueOf(false))).booleanValue()) {
                        i = R.l.chatting_retranslate_tips_content;
                        au.HU();
                        com.tencent.mm.model.c.DT().set(327713, Boolean.valueOf(true));
                        if (i != 0) {
                            menuItem.getGroupId();
                            f(bdVar, itemId == 125);
                            return true;
                        }
                        com.tencent.mm.ui.widget.a.c.a aVar2 = new com.tencent.mm.ui.widget.a.c.a(this.bAG.tTq.getContext());
                        aVar2.abu(this.bAG.tTq.getMMResources().getString(i));
                        aVar2.abt(this.bAG.tTq.getMMResources().getString(R.l.chatting_translate_tips_title));
                        aVar2.Gt(R.l.i_know_it).a(new 3(this, bdVar, menuItem, itemId));
                        aVar2.anj().show();
                        return true;
                    }
                }
                i = 0;
                if (i != 0) {
                    com.tencent.mm.ui.widget.a.c.a aVar22 = new com.tencent.mm.ui.widget.a.c.a(this.bAG.tTq.getContext());
                    aVar22.abu(this.bAG.tTq.getMMResources().getString(i));
                    aVar22.abt(this.bAG.tTq.getMMResources().getString(R.l.chatting_translate_tips_title));
                    aVar22.Gt(R.l.i_know_it).a(new 3(this, bdVar, menuItem, itemId));
                    aVar22.anj().show();
                    return true;
                }
                menuItem.getGroupId();
                f(bdVar, itemId == 125);
                return true;
            default:
                return false;
        }
    }

    public final String bd(bd bdVar) {
        String str = bdVar.field_content;
        return (s.fq(this.bAG.getTalkerUserName()) && str != null && bdVar.field_isSend == 0) ? com.tencent.mm.model.bd.iC(str) : str;
    }

    private void f(bd bdVar, boolean z) {
        if (bdVar.cmt() && !z) {
            if (bdVar.cmy()) {
                if (bdVar.cmt()) {
                    bdVar.eC(bdVar.cqa & -17);
                }
                a(bdVar.field_msgId, b.NoTransform);
                com.tencent.mm.modelstat.b.ehL.a(bdVar, false);
            } else {
                bdVar.cmz();
                a(bdVar.field_msgId, b.Transformed);
                com.tencent.mm.modelstat.b.ehL.a(bdVar, true);
            }
            au.HU();
            com.tencent.mm.model.c.FT().a(bdVar.field_msgId, bdVar);
        } else if (bc(bdVar) != b.Transforming) {
            rt rtVar = new rt();
            rtVar.ccE.ccG = false;
            rtVar.ccE.id = bdVar.field_msgId;
            rtVar.ccE.ccF = bdVar.field_content;
            rtVar.ccE.ccH = bdVar.cGM;
            if (!this.bAG.cwr() || bdVar.field_isSend == 1) {
                rtVar.ccE.type = 0;
            } else {
                rtVar.ccE.type = 1;
            }
            rtVar.ccE.bhd = this.bAG.getTalkerUserName();
            com.tencent.mm.sdk.b.a.sFg.m(rtVar);
            a(bdVar.field_msgId, b.Transforming);
        } else {
            return;
        }
        this.bAG.avj();
    }

    public final void cpH() {
        this.tSW.clear();
        com.tencent.mm.sdk.b.a.sFg.b(this.tSX);
    }

    public final void cpK() {
        com.tencent.mm.sdk.b.a.sFg.c(this.tSX);
    }
}
