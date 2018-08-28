package com.tencent.mm.ui.chatting.b;

import android.content.Intent;
import android.content.res.Configuration;
import android.view.KeyEvent;
import com.tencent.mm.R;
import com.tencent.mm.ac.a.b;
import com.tencent.mm.ac.z;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.au;
import com.tencent.mm.pluginsdk.ui.chat.ChatFooter;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.ai;
import com.tencent.mm.ui.chatting.b.a.a;
import com.tencent.mm.ui.chatting.b.b.ab;
import com.tencent.mm.ui.chatting.b.b.c;
import com.tencent.mm.ui.chatting.b.b.q;
import com.tencent.mm.ui.chatting.b.b.s;

@a(cwo = ab.class)
public class m extends a implements ab {
    private boolean tPs = false;
    private boolean tPt = false;
    private String tPu;
    private String tPv;
    private int tPw = a.tPx;

    public final void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        switch (i) {
            case 212:
                if (intent != null) {
                    com.tencent.mm.ui.chatting.b.b.m mVar = (com.tencent.mm.ui.chatting.b.b.m) this.bAG.O(com.tencent.mm.ui.chatting.b.b.m.class);
                    String stringExtra = intent.getStringExtra("select_raw_user_name");
                    String stringExtra2 = intent.getStringExtra("Select_Conv_User");
                    if (bi.oW(stringExtra2)) {
                        x.d("MicroMsg.ChattingUI.SearchComponent", "@ %s", new Object[]{"[nobody]"});
                        mVar.cvb().setAtSomebody("");
                        this.tPs = false;
                        return;
                    }
                    x.d("MicroMsg.ChattingUI.SearchComponent", "@ %s", new Object[]{stringExtra2});
                    mVar.cvb().setAtSomebody(stringExtra2);
                    mVar.cvb().am(this.bAG.getTalkerUserName(), stringExtra, stringExtra2);
                    this.tPs = true;
                    return;
                }
                return;
            default:
                return;
        }
    }

    public final boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (keyEvent.getKeyCode() == 67) {
            com.tencent.mm.ui.chatting.b.b.m mVar = (com.tencent.mm.ui.chatting.b.b.m) this.bAG.O(com.tencent.mm.ui.chatting.b.b.m.class);
            if (keyEvent.getAction() == 0) {
                if (mVar.cvb().getCharAtCursor() == 8197) {
                    this.tPt = true;
                } else {
                    this.tPt = false;
                }
            }
            if (keyEvent.getAction() == 1 && this.tPt) {
                this.tPt = false;
                ChatFooter cvb = mVar.cvb();
                int selectionStart = cvb.getSelectionStart();
                String substring = cvb.getLastText().substring(0, selectionStart);
                int lastIndexOf = substring.lastIndexOf(64);
                if (lastIndexOf < substring.length() && lastIndexOf >= 0) {
                    substring = substring.substring(0, lastIndexOf);
                    String substring2 = cvb.getLastText().substring(selectionStart);
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append(substring).append(substring2);
                    cvb.setLastText(stringBuilder.toString());
                    cvb.kXF.setSelection(lastIndexOf);
                }
            }
        }
        return false;
    }

    public final void onConfigurationChanged(Configuration configuration) {
        this.tPu = ((com.tencent.mm.ui.chatting.b.b.m) this.bAG.O(com.tencent.mm.ui.chatting.b.b.m.class)).cvb().getLastText();
        cuW();
    }

    public final void cpG() {
        x.d("MicroMsg.ChattingUI.SearchComponent", "jacks mark reset keybord state");
        this.tPw = a.tPx;
        if (this.bAG.oLT != null) {
            c cVar = (c) this.bAG.O(c.class);
            String str;
            if (cVar.cur()) {
                str = z.Nb().bd(cVar.cuC()).field_editingMsg;
                this.tPu = str;
                this.tPv = str;
                return;
            }
            au.HU();
            ai Yq = com.tencent.mm.model.c.FW().Yq(this.bAG.getTalkerUserName());
            if (Yq != null) {
                str = Yq.field_editingMsg;
                this.tPu = str;
                this.tPv = str;
            }
        }
    }

    public final void cpH() {
    }

    public final void cpI() {
    }

    public final void cpJ() {
        com.tencent.mm.ui.chatting.b.b.m mVar = (com.tencent.mm.ui.chatting.b.b.m) this.bAG.O(com.tencent.mm.ui.chatting.b.b.m.class);
        if (mVar.cvb() != null) {
            if (mVar.cvb().ceN()) {
                this.tPw = a.tPy;
                x.d("MicroMsg.ChattingUI.SearchComponent", "jacks mark refreshKeyBordState keybord state: show");
            } else {
                this.tPw = a.tPx;
                x.d("MicroMsg.ChattingUI.SearchComponent", "jacks mark refreshKeyBordState keybord state: hide");
            }
            this.tPu = mVar.cvb().getLastText();
        }
    }

    public final void cpK() {
        com.tencent.mm.ui.chatting.b.b.m mVar = (com.tencent.mm.ui.chatting.b.b.m) this.bAG.O(com.tencent.mm.ui.chatting.b.b.m.class);
        c cVar = (c) this.bAG.O(c.class);
        if (cVar.cur()) {
            com.tencent.mm.ac.a.a bd = z.Nb().bd(cVar.cuC());
            if (mVar.cvb() == null) {
                return;
            }
            if (this.tPv == null || !mVar.cvb().getLastText().trim().equals(this.tPv)) {
                this.tPv = mVar.cvb().getLastText().trim();
                bd.field_editingMsg = this.tPv;
                bd.field_flag = b.a(bd, 1, bi.oW(bd.field_editingMsg) ? bd.field_lastMsgTime : System.currentTimeMillis());
                z.Nb().b(bd);
                x.v("MicroMsg.ChattingUI.SearchComponent", "set editMsg history");
                return;
            }
            return;
        }
        ai aiVar;
        ai aiVar2 = null;
        if (g.Eg().Dx()) {
            au.HU();
            aiVar2 = com.tencent.mm.model.c.FW().Yq(this.bAG.getTalkerUserName());
        }
        if (aiVar2 != null || mVar.cvb() == null || bi.oW(mVar.cvb().getLastText().trim())) {
            aiVar = aiVar2;
        } else {
            aiVar = new ai(this.bAG.oLT.field_username);
            aiVar.as(System.currentTimeMillis());
            if (((s) this.bAG.O(s.class)).cvJ()) {
                aiVar.gf(4194304);
            }
            au.HU();
            com.tencent.mm.model.c.FW().d(aiVar);
        }
        if (aiVar != null && mVar.cvb() != null) {
            if (this.tPv == null || !mVar.cvb().getLastText().trim().equals(this.tPv)) {
                this.tPv = mVar.cvb().getLastText().trim();
                aiVar.eg(mVar.cvb().getLastText().trim());
                aiVar.at(com.tencent.mm.plugin.messenger.foundation.a.a.a.a(aiVar, 1, bi.oW(aiVar.field_editingMsg) ? aiVar.field_conversationTime : System.currentTimeMillis()));
                au.HU();
                com.tencent.mm.model.c.FW().a(aiVar, aiVar.field_username, false);
                x.v("MicroMsg.ChattingUI.SearchComponent", "jacks set editMsg history");
            }
        }
    }

    public final void cuW() {
        if (this.bAG.oLT != null) {
            com.tencent.mm.ui.chatting.b.b.m mVar = (com.tencent.mm.ui.chatting.b.b.m) this.bAG.O(com.tencent.mm.ui.chatting.b.b.m.class);
            if (!bi.oW(this.tPu) && mVar.cvb() != null) {
                boolean z = mVar.cvb().getMode() == 1 && bi.oW(mVar.cve());
                if (z) {
                    com.tencent.mm.ui.chatting.b.b.m mVar2 = (com.tencent.mm.ui.chatting.b.b.m) this.bAG.O(com.tencent.mm.ui.chatting.b.b.m.class);
                    if (mVar2.cvb() != null) {
                        ChatFooter cvb = mVar2.cvb();
                        cvb.showVKB();
                        cvb.kN(true);
                    }
                } else {
                    cuX();
                }
                z = ((c) this.bAG.O(c.class)).cus();
                if ((com.tencent.mm.model.s.fq(this.bAG.getTalkerUserName()) || z) && this.tPs) {
                    this.tPs = false;
                    String atSomebody = mVar.cvb().getAtSomebody();
                    if (!bi.oW(atSomebody)) {
                        int insertPos = mVar.cvb().getInsertPos();
                        if (insertPos > this.tPu.length()) {
                            insertPos = this.tPu.length();
                        }
                        String str = this.tPu.substring(0, insertPos) + atSomebody + 8197 + this.tPu.substring(insertPos, this.tPu.length());
                        insertPos = (insertPos + atSomebody.length()) + 1;
                        mVar.cvb().setLastContent(str);
                        mVar.cvb().o(str, insertPos, false);
                        mVar.cvb().setAtSomebody(null);
                        com.tencent.mm.ui.chatting.c.a aVar = this.bAG;
                        x.i("MicroMsg.ChattingContext", "[showVKB]");
                        aVar.tTr.showVKB();
                    }
                } else {
                    mVar.cvb().setLastContent(this.tPu);
                    mVar.cvb().setLastText(this.tPu);
                    if (!bi.oW(this.tPu) && bi.oW(mVar.cve())) {
                        mVar.cvl();
                    }
                }
                mVar.cvh();
            } else if (mVar.cvb() == null) {
            } else {
                if (((q) this.bAG.O(q.class)).cvD()) {
                    mVar.cvb().setLastText(this.tPu);
                    mVar.cvb().setHint(this.bAG.tTq.getMMResources().getString(R.l.chatting_ui_footer_lbs_mode_hint));
                } else if (mVar.cvb().getIsVoiceInputPanleShow()) {
                    mVar.cvh();
                } else {
                    cuX();
                }
            }
        }
    }

    private void cuX() {
        com.tencent.mm.ui.chatting.b.b.m mVar = (com.tencent.mm.ui.chatting.b.b.m) this.bAG.O(com.tencent.mm.ui.chatting.b.b.m.class);
        if (mVar.cvb() != null) {
            boolean z = this.tPw == a.tPy;
            ChatFooter cvb = mVar.cvb();
            bi.hideVKB(cvb);
            cvb.kN(z);
        }
    }
}
