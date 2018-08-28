package com.tencent.mm.plugin.wenote.model.nativenote.manager;

import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnKeyListener;
import com.tencent.mm.plugin.wenote.model.a.b;
import com.tencent.mm.plugin.wenote.model.a.h;
import com.tencent.mm.plugin.wenote.model.a.k;
import com.tencent.mm.plugin.wenote.model.nativenote.spans.u;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

class k$1 implements OnKeyListener {
    final /* synthetic */ k qrG;

    k$1(k kVar) {
        this.qrG = kVar;
    }

    public final boolean onKey(View view, int i, KeyEvent keyEvent) {
        if (keyEvent.getAction() != 0 || keyEvent.getKeyCode() != 67 || c.bZD().size() == 0) {
            return false;
        }
        WXRTEditText cai = this.qrG.cai();
        if (cai == null) {
            return false;
        }
        int recyclerItemPosition = cai.getRecyclerItemPosition();
        x.i("MicroMsg.Note.WXRTManager", "current focus pos: %d", new Object[]{Integer.valueOf(recyclerItemPosition)});
        b Bv = c.bZD().Bv(recyclerItemPosition);
        if (Bv == null) {
            x.w("MicroMsg.Note.WXRTManager", "get current item is null %d", new Object[]{Integer.valueOf(recyclerItemPosition)});
            return false;
        }
        b Bv2 = c.bZD().Bv(recyclerItemPosition - 1);
        if (Bv2 == null) {
            x.i("MicroMsg.Note.WXRTManager", "get preItem is null %d", new Object[]{Integer.valueOf(recyclerItemPosition)});
            return false;
        }
        h hVar;
        switch (cai.getEditTextType()) {
            case 0:
                x.i("MicroMsg.Note.WXRTManager", "Handle Editor Type EDITTEXT");
                int selectionStart = cai.getSelectionStart();
                if (selectionStart == cai.getSelectionEnd()) {
                    if (selectionStart == cai.getParagraphsInSelection().Tw) {
                        cai.qqU = true;
                        this.qrG.b(u.qtx, Boolean.valueOf(false));
                        this.qrG.b(u.qty, Boolean.valueOf(false));
                        this.qrG.b(u.qtw, Boolean.valueOf(false));
                        k.a(this.qrG).kt(false);
                        k.a(this.qrG).ku(false);
                        k.a(this.qrG).kv(false);
                        cai.qqU = false;
                    }
                    if (selectionStart == 0 && recyclerItemPosition != 0) {
                        boolean ab;
                        String a = cai.a(i.qrk);
                        c.bZD().bZG();
                        if (Bv2.getType() == 1) {
                            ab = c.bZD().ab(recyclerItemPosition, true);
                            hVar = (h) Bv2;
                            int length = hVar.qoM.getText().toString().length();
                            hVar.content += a;
                            hVar.qoJ = length;
                            hVar.qoH = true;
                            hVar.qoN = false;
                        } else {
                            if (bi.oW(a)) {
                                ab = c.bZD().ab(recyclerItemPosition, true);
                            } else {
                                ab = false;
                            }
                            Bv2.qoL.setSelection(0);
                            Bv2.qoH = true;
                            Bv2.qoN = false;
                        }
                        if (!ab) {
                            k.b(this.qrG).caU().eo(recyclerItemPosition - 1, 2);
                            break;
                        }
                        k.b(this.qrG).caU().Bo(recyclerItemPosition - 1);
                        break;
                    }
                    return false;
                }
                return false;
            case 1:
                x.i("MicroMsg.Note.WXRTManager", "Handle Editor Type PREBUTTON");
                c.bZD().bZG();
                if (Bv2.getType() == 1) {
                    hVar = (h) Bv2;
                    if (bi.oW(hVar.content)) {
                        Bv.qoK.setSelection(0);
                        Bv.qoH = true;
                        Bv.qoN = true;
                        c.bZD().ab(recyclerItemPosition - 1, true);
                        return true;
                    }
                    if (hVar.content.endsWith("<br/>")) {
                        hVar.content = hVar.content.substring(0, hVar.content.length() - 5);
                    }
                    hVar.qoJ = -1;
                    hVar.qoH = true;
                    hVar.qoN = false;
                } else {
                    Bv2.qoL.setSelection(0);
                    Bv2.qoH = true;
                    Bv2.qoN = false;
                }
                k.b(this.qrG).caU().eo(recyclerItemPosition - 1, 2);
                break;
            case 2:
                x.i("MicroMsg.Note.WXRTManager", "Handle Editor Type NEXTBTTTON");
                if (Bv.getType() == 4 && ((k) Bv).qoV.booleanValue()) {
                    x.i("MicroMsg.Note.WXRTManager", "Current Item is Voice and Recording");
                    return false;
                } else if (Bv.qoO || Bv.getType() == -1) {
                    c.bZD().bZG();
                    c.bZD().ab(recyclerItemPosition, false);
                    k.b(this.qrG).caU().Bq(recyclerItemPosition);
                    hVar = new h();
                    hVar.qoH = true;
                    hVar.qoN = false;
                    hVar.content = "";
                    hVar.qoJ = 0;
                    c.bZD().a(recyclerItemPosition, hVar);
                    c.bZD().er(recyclerItemPosition - 1, recyclerItemPosition + 1);
                    k.b(this.qrG).caS().bg(recyclerItemPosition);
                    break;
                } else {
                    c.bZD().ac(recyclerItemPosition, true);
                    return true;
                }
                break;
        }
        return true;
    }
}
