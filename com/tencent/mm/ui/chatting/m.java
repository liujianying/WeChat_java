package com.tencent.mm.ui.chatting;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.mm.R;
import com.tencent.mm.ac.a.c;
import com.tencent.mm.ac.a.e;
import com.tencent.mm.ac.d;
import com.tencent.mm.ac.f;
import com.tencent.mm.ac.z;
import com.tencent.mm.g.a.mw;
import com.tencent.mm.platformtools.ai;
import com.tencent.mm.sdk.platformtools.at.a;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.bd;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.bizchat.BizChatSelectConversationUI;
import com.tencent.mm.ui.chatting.b.j;
import com.tencent.mm.ui.tools.k;
import java.util.LinkedList;
import java.util.List;

public final class m {
    private static p tIC = null;
    private static a tIO;

    private static class b implements a {
        private com.tencent.mm.ui.chatting.c.a bAG;
        private Context context;
        private String dKF;
        private long hpD;
        private boolean qIZ;
        private a tIW;

        public b(com.tencent.mm.ui.chatting.c.a aVar, Context context, String str, long j, a aVar2) {
            this.bAG = aVar;
            this.context = context;
            this.dKF = str;
            this.hpD = j;
            this.tIW = aVar2;
            this.qIZ = f.eZ(str);
        }

        public final boolean Kr() {
            if (this.qIZ) {
                c ak = z.Na().ak(this.hpD);
                synchronized (e.dNr) {
                    String Ir = e.Ir();
                    e.d(ak);
                    if (this.tIW.tIV) {
                        cti();
                    } else {
                        ctj();
                    }
                    e.lh(Ir);
                }
            } else if (this.tIW.tIV) {
                cti();
            } else {
                ctj();
            }
            return true;
        }

        private void cti() {
            for (bd bdVar : this.tIW.tIM) {
                Context context = this.context;
                boolean z = this.tIW.tGg;
                String str = this.dKF;
                if (bdVar.isText()) {
                    j.a(context, str, bdVar, z);
                } else if (bdVar.ckA()) {
                    j.b(context, str, bdVar);
                } else if (bdVar.cmj() && !this.qIZ) {
                    j.c(context, str, bdVar);
                } else if (bdVar.aQo()) {
                    j.c(context, str, bdVar, z);
                } else if ((bdVar.cml() || bdVar.cmm()) && !this.qIZ) {
                    if (!j.ap(bdVar)) {
                        j.a(context, str, bdVar);
                    }
                } else if (bdVar.aQm() && !((this.qIZ && !j.ax(bdVar)) || j.ay(bdVar) || bdVar.getType() == 318767153 || j.aC(bdVar) || j.ar(bdVar))) {
                    j.b(context, str, bdVar, z);
                }
            }
        }

        private void ctj() {
            m.bB(this.context, this.dKF);
            mw mwVar = new mw();
            mwVar.bXL.type = 5;
            mwVar.bXL.bXR = this.tIW.tIM;
            mwVar.bXL.toUser = this.dKF;
            mwVar.bXL.bXS = this.tIW.bXS;
            mwVar.bXL.context = this.context;
            mwVar.bXL.bXn = this.tIW.bXn;
            mwVar.bXL.bXU = this.tIW.tIN;
            com.tencent.mm.sdk.b.a.sFg.m(mwVar);
        }

        public final boolean Ks() {
            if (m.tIC != null) {
                m.tIC.dismiss();
            }
            com.tencent.mm.ui.widget.snackbar.b.a(this.context, this.bAG.findViewById(R.h.mm_content_fl), this.context.getString(R.l.finish_sent));
            return true;
        }
    }

    public static void a(com.tencent.mm.ui.chatting.c.a aVar, List<bd> list, boolean z, j jVar, ab abVar) {
        if (aVar == null) {
            x.w("MicroMsg.ChattingEditModeSendToBrand", "do send to brand fail, fragment is null");
        } else if (list == null || list.isEmpty()) {
            x.w("MicroMsg.ChattingEditModeSendToBrand", "do send to brand fail, select item empty");
        } else {
            a aVar2 = new a((byte) 0);
            tIO = aVar2;
            aVar2.tIM = new LinkedList(list);
            tIO.tGg = z;
            tIO.bXS = abVar.field_username;
            tIO.tIV = true;
            Context context = aVar.tTq.getContext();
            if (context != null) {
                k kVar = new k(context);
                kVar.uAx = new 1();
                kVar.uAy = new 2(context);
                kVar.ofp = new 3(com.tencent.mm.pluginsdk.model.app.p.r(context, "com.tencent.wework") ? j.ctd() : j.ctc());
                kVar.ofq = new 4(list, context, aVar, abVar, jVar);
                kVar.bEo();
            }
        }
    }

    public static void a(final String str, final com.tencent.mm.ui.chatting.c.a aVar, List<bd> list) {
        Context context = aVar.tTq.getContext();
        if (context != null) {
            d kH = f.kH(str);
            if (kH != null) {
                String string;
                boolean Ma = kH.Ma();
                if (tIO.tIV) {
                    boolean dz = j.dz(list);
                    if (Ma) {
                        Object obj;
                        if (list == null || list.isEmpty()) {
                            x.w("MicroMsg.ChattingEditModeLogic", "check contain invalid send to bizchat msg error, selected item empty");
                            obj = 1;
                        } else {
                            for (bd bdVar : list) {
                                if (!bdVar.isText() && !bdVar.ckz() && !bdVar.ckA() && !bdVar.aQo() && !j.ax(bdVar)) {
                                    int obj2 = 1;
                                    break;
                                }
                            }
                            obj2 = null;
                        }
                        tIO.tIM = new LinkedList(list);
                        if (dz || obj2 != null) {
                            string = context.getString(R.l.enterprise_invalid_chat_msg_warning);
                            if (string != null) {
                                h.a(context, string, "", new OnClickListener() {
                                    public final void onClick(DialogInterface dialogInterface, int i) {
                                        m.a(str, aVar);
                                    }
                                }, null);
                            } else {
                                a(str, aVar);
                            }
                        }
                    } else if (dz) {
                        string = context.getString(R.l.enterprise_invalid_msg_warning);
                        if (string != null) {
                            a(str, aVar);
                        } else {
                            h.a(context, string, "", /* anonymous class already generated */, null);
                        }
                    }
                }
                string = null;
                if (string != null) {
                    h.a(context, string, "", /* anonymous class already generated */, null);
                } else {
                    a(str, aVar);
                }
            }
        }
    }

    public static void a(String str, com.tencent.mm.ui.chatting.c.a aVar) {
        d kH = f.kH(str);
        if (kH != null) {
            Intent intent;
            if (kH.Ma()) {
                intent = new Intent(aVar.tTq.getContext(), BizChatSelectConversationUI.class);
                intent.putExtra("enterprise_biz_name", str);
                intent.putExtra("biz_chat_scene", 2);
                intent.putExtra("enterprise_extra_params", tIO.tIV);
                aVar.a(intent, 225, new 6(aVar));
            } else if (kH.LY()) {
                intent = new Intent();
                intent.putExtra("enterprise_biz_name", str);
                intent.putExtra("enterprise_scene", 1);
                com.tencent.mm.bg.d.a(aVar.tTq, "brandservice", ".ui.EnterpriseBizContactPlainListUI", intent, 225);
            }
        }
    }

    public static mw bB(Context context, String str) {
        mw mwVar = new mw();
        mwVar.bXL.type = 6;
        mwVar.bXL.bXR = tIO.tIM;
        mwVar.bXL.toUser = str;
        mwVar.bXL.bXS = tIO.bXS;
        mwVar.bXL.context = context;
        com.tencent.mm.sdk.b.a.sFg.m(mwVar);
        tIO.bXn = mwVar.bXM.bXn;
        tIO.tIN = mwVar.bXM.bXU;
        return mwVar;
    }

    public static void a(com.tencent.mm.ui.chatting.c.a aVar, String str, long j) {
        Context context = aVar.tTq.getContext();
        if (!ai.oW(str) && str.length() > 0) {
            context.getString(R.l.app_tip);
            tIC = h.a(context, context.getString(R.l.sending_message), false, null);
            j.tOP.c(new b(aVar, context, str, j, tIO));
        }
        ((com.tencent.mm.ui.chatting.b.b.h) aVar.O(com.tencent.mm.ui.chatting.b.b.h.class)).cuQ();
    }
}
