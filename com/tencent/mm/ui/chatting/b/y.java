package com.tencent.mm.ui.chatting.b;

import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Looper;
import android.widget.AbsListView;
import com.tencent.mm.R;
import com.tencent.mm.a.e;
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.o;
import com.tencent.mm.aw.d;
import com.tencent.mm.booter.notification.queue.b;
import com.tencent.mm.g.a.ch;
import com.tencent.mm.g.a.ld;
import com.tencent.mm.g.a.rz;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.model.u;
import com.tencent.mm.modelcdntran.keep_ProgressInfo;
import com.tencent.mm.modelcdntran.keep_SceneResult;
import com.tencent.mm.modelsimple.g;
import com.tencent.mm.modelsimple.z;
import com.tencent.mm.modelvideo.r;
import com.tencent.mm.modelvideo.t;
import com.tencent.mm.plugin.record.b.h;
import com.tencent.mm.pluginsdk.model.app.ao;
import com.tencent.mm.pluginsdk.model.app.l;
import com.tencent.mm.pluginsdk.wallet.i;
import com.tencent.mm.protocal.c.vx;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.bd;
import com.tencent.mm.ui.MMAppMgr;
import com.tencent.mm.ui.chatting.b.a.a;
import com.tencent.mm.ui.chatting.b.b.s;
import com.tencent.mm.y.g$a;
import java.io.ByteArrayOutputStream;
import java.net.URLEncoder;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@a(cwo = s.class)
@Deprecated
public class y extends a implements s {
    private List<bd> tQQ;
    private int tQR;
    private final al tQS = new al(new 1(this), true);
    private boolean tQT = false;
    private Runnable tQU = null;

    public final void onActivityResult(int i, int i2, Intent intent) {
        boolean z;
        Cursor cursor = null;
        super.onActivityResult(i, i2, intent);
        String str = "MicroMsg.ChattingUI.MessBoxComponent";
        String str2 = "onActivityResult requestCode:%d, data is null:%b  rawUserName:%s ";
        Object[] objArr = new Object[3];
        objArr[0] = Integer.valueOf(i);
        if (intent == null) {
            z = true;
        } else {
            z = false;
        }
        objArr[1] = Boolean.valueOf(z);
        objArr[2] = this.bAG.getTalkerUserName();
        x.i(str, str2, objArr);
        switch (i) {
            case 211:
                if (i2 == -1) {
                    Uri data = intent.getData();
                    if (this.bAG != null) {
                        cursor = this.bAG.tTq.getContext().managedQuery(data, null, null, null, null);
                    }
                    if (cursor.moveToFirst()) {
                        this.bAG.tTq.startActivity(new Intent("android.intent.action.EDIT", Uri.parse("content://com.android.contacts/contacts/" + cursor.getString(cursor.getColumnIndexOrThrow("_id")))));
                        return;
                    }
                    return;
                }
                return;
            case 213:
                if (intent != null && intent.getBooleanExtra("_delete_ok_", false)) {
                    this.bAG.tTq.csV();
                    return;
                }
                return;
            default:
                x.e("MicroMsg.ChattingUI.MessBoxComponent", "onActivityResult: not found this requestCode");
                return;
        }
    }

    public final void onScrollStateChanged(AbsListView absListView, int i) {
        super.onScrollStateChanged(absListView, i);
        if (i == 0) {
            rz rzVar = new rz();
            rzVar.ccO.type = 5;
            rzVar.ccO.ccP = this.bAG.getFirstVisiblePosition();
            rzVar.ccO.ccQ = this.bAG.getLastVisiblePosition();
            rzVar.ccO.ccR = this.bAG.getHeaderViewsCount();
            com.tencent.mm.sdk.b.a.sFg.m(rzVar);
        }
    }

    public final void cun() {
        super.cun();
        au.HU();
        if (c.FM()) {
            z.S(this.bAG.getTalkerUserName(), 5);
        }
    }

    public final List<bd> cvI() {
        return this.tQQ;
    }

    public final void cpF() {
        this.tQT = this.bAG.tTq.getBooleanExtra("key_is_temp_session", false).booleanValue();
        if (this.tQT) {
            au.DF().a(new g(this.bAG.getTalkerUserName(), this.bAG.tTq.getIntExtra("key_temp_session_scene", 5), this.bAG.tTq.getStringExtra("key_temp_session_from")), 0);
        }
        if (!this.bAG.oLT.ckW() || com.tencent.mm.l.a.gd(this.bAG.oLT.field_type)) {
            this.tQT = false;
        } else {
            au.HU();
            ai Yq = c.FW().Yq(this.bAG.getTalkerUserName());
            boolean a;
            if (Yq == null) {
                if (this.tQT) {
                    Yq = new ai(this.bAG.getTalkerUserName());
                    Yq.gf(4194304);
                    Yq.clx();
                    au.HU();
                    c.FW().d(Yq);
                }
            } else if (Yq.gh(4194304)) {
                this.tQT = true;
            } else if (Yq.field_conversationTime < com.tencent.mm.ac.z.Nm()) {
                au.HU();
                a = c.FW().a(this.bAG.getTalkerUserName(), 4194304, true, Yq.field_attrflag);
                x.i("MicroMsg.ChattingUI.MessBoxComponent", "It is a old version temp session, Set attr flag(talker : %s), %s", new Object[]{this.bAG.getTalkerUserName(), Boolean.valueOf(a)});
                this.tQT = true;
            } else if (this.tQT) {
                au.HU();
                a = c.FW().a(this.bAG.getTalkerUserName(), 4194304, true, Yq.field_attrflag);
                x.i("MicroMsg.ChattingUI.MessBoxComponent", "It is a temp session, Set attr flag(talker : %s), %s", new Object[]{this.bAG.getTalkerUserName(), Boolean.valueOf(a)});
            }
        }
        x.d("MicroMsg.ChattingUI.MessBoxComponent", "is temp session : %s.", new Object[]{Boolean.valueOf(this.tQT)});
    }

    public final void cpG() {
        b yb = b.yb();
        String talkerUserName = this.bAG.getTalkerUserName();
        if (!com.tencent.mm.platformtools.ai.oW(talkerUserName)) {
            yb.cZb.eL(talkerUserName);
        }
        if (this.bAG.cwr()) {
            d.chatType = 1;
        } else {
            d.chatType = 0;
        }
        if (this.tQQ != null) {
            this.tQQ.clear();
        }
        au.HU();
        ai Yq = c.FW().Yq(this.bAG.getTalkerUserName());
        if (((com.tencent.mm.ui.chatting.b.b.c) this.bAG.O(com.tencent.mm.ui.chatting.b.b.c.class)).cur()) {
            this.tQQ = ((com.tencent.mm.ui.chatting.b.b.c) this.bAG.O(com.tencent.mm.ui.chatting.b.b.c.class)).cuw();
        } else if (Yq != null && Yq.field_unReadCount > 0) {
            int i;
            if (Yq.field_unReadCount > 100) {
                i = 100;
            } else {
                i = Yq.field_unReadCount;
            }
            au.HU();
            this.tQQ = c.FT().bz(this.bAG.getTalkerUserName(), i);
        }
        if (this.tQQ == null) {
            this.tQQ = new LinkedList();
        }
        this.tQR = this.tQQ.size();
    }

    public final void cpH() {
        rz rzVar = new rz();
        rzVar.ccO.type = 4;
        com.tencent.mm.sdk.b.a.sFg.m(rzVar);
        if (this.bAG != null) {
            x.i("MicroMsg.ChattingUI.MessBoxComponent", "[addActiveToolsProcessIdleHandler]");
            ag cwt = com.tencent.mm.ui.chatting.c.a.cwt();
            2 2 = new 2(this);
            this.tQU = 2;
            cwt.postDelayed(2, 3000);
        }
        ld ldVar = new ld();
        ldVar.bVw.talker = this.bAG.getTalkerUserName();
        com.tencent.mm.sdk.b.a.sFg.m(ldVar);
        au.HU();
        if (c.FM()) {
            z.S(this.bAG.getTalkerUserName(), 2);
        }
    }

    public final int AQ() {
        return this.tQR;
    }

    public final void cpI() {
        i.Cx(6);
        this.tQS.J(300000, 300000);
        rz rzVar = new rz();
        rzVar.ccO.type = 0;
        if (this.bAG != null) {
            rzVar.ccO.ccR = this.bAG.getHeaderViewsCount();
            rzVar.ccO.ccP = this.bAG.getFirstVisiblePosition();
            rzVar.ccO.ccQ = this.bAG.getLastVisiblePosition();
        }
        com.tencent.mm.sdk.b.a.sFg.m(rzVar);
        af.Wp("keep_chatting_silent" + this.bAG.getTalkerUserName());
        au.getNotification().eJ(this.bAG.getTalkerUserName());
        MMAppMgr.vo();
    }

    public final void cpJ() {
        this.tQS.SO();
        rz rzVar = new rz();
        rzVar.ccO.type = 1;
        com.tencent.mm.sdk.b.a.sFg.m(rzVar);
        aap(this.bAG.getTalkerUserName());
        au.getNotification().eJ("");
        af.Wq("keep_app_silent");
        af.Wq("keep_chatting_silent" + this.bAG.getTalkerUserName());
    }

    public final void cpK() {
        x.i("MicroMsg.ChattingUI.MessBoxComponent", "[onChattingExitAnimStart]");
        rz rzVar = new rz();
        rzVar.ccO.type = 3;
        com.tencent.mm.sdk.b.a.sFg.m(rzVar);
        com.tencent.mm.ui.chatting.c.a.cwt().removeCallbacks(this.tQU);
    }

    public final boolean cvJ() {
        return this.tQT;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(android.view.MenuItem r9, com.tencent.mm.ui.chatting.viewitems.b r10) {
        /*
        r8 = this;
        r6 = 2;
        r2 = 0;
        r1 = 1;
        r0 = r8.bAG;
        r3 = com.tencent.mm.ui.chatting.b.b.g.class;
        r0 = r0.O(r3);
        r0 = (com.tencent.mm.ui.chatting.b.b.g) r0;
        r3 = r9.getGroupId();
        r3 = r0.ES(r3);
        if (r3 != 0) goto L_0x0021;
    L_0x0017:
        r0 = "MicroMsg.ChattingUI.MessBoxComponent";
        r1 = "context item select failed, null msg";
        com.tencent.mm.sdk.platformtools.x.e(r0, r1);
    L_0x0020:
        return;
    L_0x0021:
        r0 = r8.bAG;
        r4 = com.tencent.mm.ui.chatting.b.b.t.class;
        r0 = r0.O(r4);
        r0 = (com.tencent.mm.ui.chatting.b.b.t) r0;
        r0.k(r9);
        r0 = r9.getItemId();
        switch(r0) {
            case 100: goto L_0x0036;
            case 114: goto L_0x0162;
            case 116: goto L_0x0230;
            case 122: goto L_0x00ab;
            case 123: goto L_0x0202;
            case 129: goto L_0x00c0;
            default: goto L_0x0035;
        };
    L_0x0035:
        goto L_0x0020;
    L_0x0036:
        r0 = r3.cmj();
        if (r0 == 0) goto L_0x0041;
    L_0x003c:
        r0 = r3.field_imgPath;
        com.tencent.mm.pluginsdk.model.j.SO(r0);
    L_0x0041:
        r4 = r3.field_msgId;
        com.tencent.mm.model.bd.aU(r4);
        r0 = r3.aQm();
        if (r0 == 0) goto L_0x00ba;
    L_0x004c:
        r0 = com.tencent.mm.modelstat.b.ehL;
        r4 = com.tencent.mm.y.h.g(r3);
        r0.c(r3, r4);
    L_0x0055:
        r0 = "MicroMsg.ChattingUI.MessBoxComponent";
        r4 = "delete msg, id:%d";
        r5 = new java.lang.Object[r1];
        r6 = r3.field_msgId;
        r6 = java.lang.Long.valueOf(r6);
        r5[r2] = r6;
        com.tencent.mm.sdk.platformtools.x.i(r0, r4, r5);
        r0 = r8.bAG;
        r0 = r0.getTalkerUserName();
        r2 = "medianote";
        r0 = r0.equals(r2);
        if (r0 != 0) goto L_0x008a;
    L_0x0077:
        com.tencent.mm.model.au.HU();
        r0 = com.tencent.mm.model.c.FQ();
        r2 = new com.tencent.mm.aq.e;
        r4 = r3.field_talker;
        r6 = r3.field_msgSvrId;
        r2.<init>(r4, r6);
        r0.b(r2);
    L_0x008a:
        r0 = r3.field_status;
        if (r0 != r1) goto L_0x0020;
    L_0x008e:
        r0 = r3.field_isSend;
        if (r0 != r1) goto L_0x0020;
    L_0x0092:
        r0 = "MicroMsg.ChattingUI.MessBoxComponent";
        r1 = "delete a sending msg, publish SendMsgFailEvent";
        com.tencent.mm.sdk.platformtools.x.d(r0, r1);
        r0 = new com.tencent.mm.g.a.ox;
        r0.<init>();
        r1 = r0.bZS;
        r1.bGS = r3;
        r1 = com.tencent.mm.sdk.b.a.sFg;
        r1.m(r0);
        goto L_0x0020;
    L_0x00ab:
        r0 = r8.bAG;
        r1 = com.tencent.mm.ui.chatting.b.b.h.class;
        r0 = r0.O(r1);
        r0 = (com.tencent.mm.ui.chatting.b.b.h) r0;
        r0.aT(r3);
        goto L_0x0020;
    L_0x00ba:
        r0 = com.tencent.mm.modelstat.b.ehL;
        r0.y(r3);
        goto L_0x0055;
    L_0x00c0:
        r0 = r8.bAG;
        r0 = r0.cwr();
        r4 = r3.field_content;
        r5 = r3.field_isSend;
        r0 = com.tencent.mm.model.bd.b(r0, r4, r5);
        r0 = com.tencent.mm.y.g$a.gp(r0);
        if (r0 == 0) goto L_0x0127;
    L_0x00d4:
        r4 = r0.type;
        r5 = 6;
        if (r4 == r5) goto L_0x00dd;
    L_0x00d9:
        r4 = r0.type;
        if (r4 != r6) goto L_0x0127;
    L_0x00dd:
        r4 = com.tencent.mm.pluginsdk.model.app.ao.asF();
        r0 = r0.bGP;
        r0 = r4.SR(r0);
        if (r0 == 0) goto L_0x00f1;
    L_0x00e9:
        r0 = r0.field_fileFullPath;
        r0 = com.tencent.mm.modelsfs.FileOp.cn(r0);
        if (r0 != 0) goto L_0x0235;
    L_0x00f1:
        r0 = r2;
    L_0x00f2:
        r2 = r0;
    L_0x00f3:
        r0 = r8.bAG;
        r4 = com.tencent.mm.ui.chatting.b.b.af.class;
        r0 = r0.O(r4);
        r0 = (com.tencent.mm.ui.chatting.b.b.af) r0;
        r0 = r0.g(r3, r2);
        if (r0 != 0) goto L_0x013c;
    L_0x0103:
        r0 = r8.bAG;
        r0 = r0.tTq;
        r0 = r0.getContext();
        r1 = r8.bAG;
        r1 = r1.tTq;
        r1 = r1.getMMResources();
        r2 = com.tencent.mm.R.l.contain_undownload_msg_send;
        r1 = r1.getString(r2);
        r2 = "";
        r3 = new com.tencent.mm.ui.chatting.b.y$3;
        r3.<init>(r8);
        r4 = 0;
        com.tencent.mm.ui.base.h.a(r0, r1, r2, r3, r4);
        goto L_0x0020;
    L_0x0127:
        r0 = r3.ckA();
        if (r0 == 0) goto L_0x013a;
    L_0x012d:
        com.tencent.mm.ak.o.Pf();
        r0 = com.tencent.mm.ak.g.s(r3);
        r0 = com.tencent.mm.sdk.platformtools.bi.oW(r0);
        if (r0 != 0) goto L_0x00f3;
    L_0x013a:
        r2 = r1;
        goto L_0x00f3;
    L_0x013c:
        r0 = new android.content.Intent;
        r2 = r8.bAG;
        r2 = r2.tTq;
        r2 = r2.getContext();
        r4 = com.tencent.mm.ui.chatting.ChattingSendDataToDeviceUI.class;
        r0.<init>(r2, r4);
        r2 = "exdevice_open_scene_type";
        r0.putExtra(r2, r1);
        r1 = "Retr_Msg_Id";
        r2 = r3.field_msgId;
        r0.putExtra(r1, r2);
        r1 = r8.bAG;
        r1 = r1.tTq;
        r1.startActivity(r0);
        goto L_0x0020;
    L_0x0162:
        r0 = r3.isText();
        if (r0 == 0) goto L_0x0198;
    L_0x0168:
        r0 = r8.bAG;
        r0 = r0.cwr();
        r4 = r3.field_content;
        r5 = r3.field_isSend;
        r0 = com.tencent.mm.model.bd.b(r0, r4, r5);
        r4 = r8.bAG;
        r4 = r4.tTq;
        r4 = r4.getContext();
        com.tencent.mm.ui.chatting.am.l(r0, r4);
    L_0x0181:
        r0 = "MicroMsg.ChattingUI.MessBoxComponent";
        r4 = "type is %d";
        r1 = new java.lang.Object[r1];
        r3 = r3.getType();
        r3 = java.lang.Integer.valueOf(r3);
        r1[r2] = r3;
        com.tencent.mm.sdk.platformtools.x.i(r0, r4, r1);
        goto L_0x0020;
    L_0x0198:
        r0 = r3.ckz();
        if (r0 == 0) goto L_0x01aa;
    L_0x019e:
        r0 = r8.bAG;
        r0 = r0.tTq;
        r0 = r0.getContext();
        com.tencent.mm.ui.chatting.am.b(r3, r0);
        goto L_0x0181;
    L_0x01aa:
        r0 = r3.ckA();
        if (r0 == 0) goto L_0x01c8;
    L_0x01b0:
        r0 = r8.bAG;
        r0 = r0.tTq;
        r0 = r0.getContext();
        r4 = r8.bAG;
        r4 = r10.b(r4, r3);
        r5 = r8.bAG;
        r5 = r5.cwr();
        com.tencent.mm.ui.chatting.am.a(r3, r0, r4, r5);
        goto L_0x0181;
    L_0x01c8:
        r0 = r3.cmj();
        if (r0 == 0) goto L_0x01da;
    L_0x01ce:
        r0 = r8.bAG;
        r0 = r0.tTq;
        r0 = r0.getContext();
        com.tencent.mm.ui.chatting.am.c(r3, r0);
        goto L_0x0181;
    L_0x01da:
        r0 = r3.aQo();
        if (r0 == 0) goto L_0x01ee;
    L_0x01e0:
        r0 = r3.field_content;
        r4 = r8.bAG;
        r4 = r4.tTq;
        r4 = r4.getContext();
        com.tencent.mm.ui.chatting.am.m(r0, r4);
        goto L_0x0181;
    L_0x01ee:
        r0 = r3.cmi();
        if (r0 == 0) goto L_0x0181;
    L_0x01f4:
        r0 = r3.field_content;
        r4 = r8.bAG;
        r4 = r4.tTq;
        r4 = r4.getContext();
        com.tencent.mm.ui.chatting.am.n(r0, r4);
        goto L_0x0181;
    L_0x0202:
        r0 = "MicroMsg.ChattingUI.MessBoxComponent";
        r4 = "[oneliang][longclick_menu_revoke] type:%d,item.getGroupId:%d";
        r5 = new java.lang.Object[r6];
        r6 = r3.getType();
        r6 = java.lang.Integer.valueOf(r6);
        r5[r2] = r6;
        r2 = r9.getGroupId();
        r2 = java.lang.Integer.valueOf(r2);
        r5[r1] = r2;
        com.tencent.mm.sdk.platformtools.x.d(r0, r4, r5);
        r0 = r8.bAG;
        r1 = com.tencent.mm.ui.chatting.b.b.v.class;
        r0 = r0.O(r1);
        r0 = (com.tencent.mm.ui.chatting.b.b.v) r0;
        r0.ba(r3);
        goto L_0x0020;
    L_0x0230:
        r8.aY(r3);
        goto L_0x0020;
    L_0x0235:
        r0 = r1;
        goto L_0x00f2;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.ui.chatting.b.y.a(android.view.MenuItem, com.tencent.mm.ui.chatting.viewitems.b):void");
    }

    public final boolean aap(String str) {
        x.i("MicroMsg.ChattingUI.MessBoxComponent", "[writeOpLogAndMarkRead] username:%s isTContact:%s thread name:%s", new Object[]{str, Boolean.valueOf(ab.XO(str)), Thread.currentThread().getName()});
        if (ab.XO(str) || this.bAG == null) {
            au.HU();
            Cursor GO = c.FT().GO(str);
            GO.moveToFirst();
            boolean z = false;
            while (!GO.isAfterLast()) {
                bd bdVar = new bd();
                bdVar.d(GO);
                if (bdVar.getType() != 34) {
                    bdVar.setStatus(4);
                    x.d("MicroMsg.ChattingUI.MessBoxComponent", "writeOpLog: msgSvrId = " + bdVar.field_msgSvrId + " status = " + bdVar.field_status);
                }
                GO.moveToNext();
                z = true;
            }
            GO.close();
            if (z) {
                au.HU();
                c.FW().Ys(str);
                au.HU();
                c.FT().GM(str);
            }
            return z;
        }
        com.tencent.mm.ui.chatting.b.b.c cVar = (com.tencent.mm.ui.chatting.b.b.c) this.bAG.O(com.tencent.mm.ui.chatting.b.b.c.class);
        if (cVar != null) {
            return cVar.cuB();
        }
        x.e("MicroMsg.ChattingUI.MessBoxComponent", "[writeOpLogAndMarkRead] ");
        return false;
    }

    private void aY(final bd bdVar) {
        boolean z = true;
        if (bdVar.aQm()) {
            g$a gp = g$a.gp(bdVar.field_content);
            if (gp.type == 6 && !bi.oW(gp.dwu)) {
                final com.tencent.mm.pluginsdk.model.app.b d = l.d(bdVar, gp.bGP);
                if (!(d == null || (e.cn(d.field_fileFullPath) && ((long) e.cm(d.field_fileFullPath)) == d.field_totalLen))) {
                    com.tencent.mm.modelcdntran.i iVar = new com.tencent.mm.modelcdntran.i();
                    iVar.dPV = new com.tencent.mm.modelcdntran.i.a() {
                        public final int a(String str, int i, keep_ProgressInfo keep_progressinfo, keep_SceneResult keep_sceneresult, boolean z) {
                            if (i == 0 && keep_progressinfo != null) {
                                d.field_offset = (long) keep_progressinfo.field_finishedLength;
                                ao.asF().c(d, new String[0]);
                            }
                            if (i == 0 && keep_sceneresult != null && keep_sceneresult.field_retCode == 0) {
                                d.field_status = 199;
                                d.field_offset = d.field_totalLen;
                                ao.asF().c(d, new String[0]);
                                bdVar.setStatus(3);
                                au.HU();
                                c.FT().a(bdVar.field_msgId, bdVar);
                                new ag(Looper.getMainLooper()).post(new 1(this));
                            }
                            return 0;
                        }

                        public final void a(String str, ByteArrayOutputStream byteArrayOutputStream) {
                        }

                        public final byte[] i(String str, byte[] bArr) {
                            return new byte[0];
                        }
                    };
                    iVar.field_mediaId = com.tencent.mm.modelcdntran.d.a("checkExist", bi.VF(), bdVar.field_talker, bdVar.field_msgId);
                    iVar.field_aesKey = gp.dwK;
                    iVar.field_fileType = 19;
                    iVar.field_authKey = gp.dwA;
                    iVar.dPW = gp.dwu;
                    if (d == null || bi.oW(d.field_fileFullPath)) {
                        au.HU();
                        iVar.field_fullpath = l.al(c.Gk(), gp.title, gp.dwp);
                    } else {
                        iVar.field_fullpath = d.field_fileFullPath;
                    }
                    if (!com.tencent.mm.modelcdntran.g.ND().b(iVar, -1)) {
                        x.e("MicroMsg.ChattingUI.MessBoxComponent", "openim attach download failed before rescend");
                        return;
                    }
                    return;
                }
            } else if (gp.type == 19) {
                com.tencent.mm.protocal.b.a.c Ks = h.Ks(gp.dwW);
                HashSet hashSet = new HashSet();
                Iterator it = Ks.dzs.iterator();
                while (it.hasNext()) {
                    vx vxVar = (vx) it.next();
                    String c = h.c(vxVar, bdVar.field_msgId);
                    if (!(bi.oW(vxVar.rAG) || e.cn(c))) {
                        a(vxVar.rAG, vxVar.rAD, vxVar.dwA, c, h.e(vxVar.jdM, bdVar.field_msgId, true), bdVar, hashSet);
                    }
                    c = h.f(vxVar, bdVar.field_msgId);
                    if (!(bi.oW(vxVar.dwv) || e.cn(c))) {
                        a(vxVar.dwv, vxVar.dwB, vxVar.dwA, c, h.e(h.Ba(vxVar.jdM), bdVar.field_msgId, true), bdVar, hashSet);
                    }
                }
                if (!hashSet.isEmpty()) {
                    return;
                }
            }
        }
        if (bdVar.ckA()) {
            int i;
            int i2;
            com.tencent.mm.ak.e bq = o.Pf().bq(bdVar.field_msgSvrId);
            if (bdVar.field_isSend == 1) {
                i = bq.ON();
            } else if (bq.ON()) {
                i = !e.cn(o.Pf().o(f.a(bq).dTL, "", "")) ? 0 : 1;
            } else {
                i = 0;
            }
            if (bq.offset < bq.dHI || bq.dHI == 0) {
                x.i("MicroMsg.ChattingUI.MessBoxComponent", "oreh downloadImgAndFav start  msgID:%d", new Object[]{Long.valueOf(bdVar.field_msgId)});
                o.Pg().a(bq.dTK, bdVar.field_msgId, i, bdVar, R.g.chat_img_template, new 6(this, bdVar));
                i2 = true;
            } else {
                i2 = 0;
            }
            if (i2 != 0) {
                return;
            }
        }
        if (bdVar.cmj() || bdVar.cmk()) {
            r nW = t.nW(bdVar.field_imgPath);
            if (nW == null || nW.status == 199) {
                z = false;
            } else {
                com.tencent.mm.modelvideo.o.Ta().a(new com.tencent.mm.modelvideo.s.a() {
                    public final void a(com.tencent.mm.modelvideo.s.a.a aVar) {
                        if (bdVar.field_imgPath.equals(aVar.fileName)) {
                            r nW = t.nW(aVar.fileName);
                            if (nW == null || !nW.Tp()) {
                                x.i("MicroMsg.ChattingUI.MessBoxComponent", "oreh downloadVideoAndFav fialed msgID:%d, fileName:%s", new Object[]{Long.valueOf(bdVar.field_msgId), aVar.fileName});
                            } else {
                                x.i("MicroMsg.ChattingUI.MessBoxComponent", "oreh downloadVideoAndFav suc msgID:%d, fileName:%s", new Object[]{Long.valueOf(bdVar.field_msgId), aVar.fileName});
                            }
                            com.tencent.mm.modelvideo.o.Ta().a(this);
                            new ag(Looper.getMainLooper()).post(new 1(this));
                        }
                    }
                }, Looper.getMainLooper());
                x.i("MicroMsg.ChattingUI.MessBoxComponent", "oreh downloadVideoAndFav start  msgID:%d, fileName:%s", new Object[]{Long.valueOf(bdVar.field_msgId), bdVar.field_imgPath});
                if (nW.To()) {
                    x.i("MicroMsg.ChattingUI.MessBoxComponent", "start complete online video");
                    t.oa(bdVar.field_imgPath);
                } else {
                    x.i("MicroMsg.ChattingUI.MessBoxComponent", "start complete offline video");
                    t.nS(bdVar.field_imgPath);
                }
            }
            if (z) {
                return;
            }
        }
        aZ(bdVar);
    }

    private void a(String str, String str2, String str3, String str4, String str5, bd bdVar, HashSet<String> hashSet) {
        x.i("MicroMsg.ChattingUI.MessBoxComponent", "oreh downloadTpUrl msgId:%d, mediaId:%s, path:%s", new Object[]{Long.valueOf(bdVar.field_msgId), str5, str4});
        hashSet.add(str5);
        com.tencent.mm.modelcdntran.i iVar = new com.tencent.mm.modelcdntran.i();
        iVar.field_fileType = 19;
        iVar.field_authKey = str3;
        iVar.field_aesKey = str2;
        iVar.dPW = str;
        iVar.field_fullpath = str4;
        iVar.field_mediaId = str5;
        iVar.dPV = new 4(this, bdVar, str4, hashSet);
        if (!com.tencent.mm.modelcdntran.g.ND().b(iVar, -1)) {
            x.e("MicroMsg.ChattingUI.MessBoxComponent", "recv openim record, add task failed");
        }
    }

    private void aZ(bd bdVar) {
        ch chVar = new ch();
        com.tencent.mm.pluginsdk.model.e.a(chVar, bdVar);
        chVar.bJF.nd = this.bAG.tTq;
        chVar.bJF.bJM = 43;
        com.tencent.mm.sdk.b.a.sFg.m(chVar);
        if (chVar.bJG.ret == 0) {
            if (bdVar.aQm()) {
                com.tencent.mm.modelstat.b.ehL.b(bdVar, com.tencent.mm.y.h.g(bdVar));
            } else {
                com.tencent.mm.modelstat.b.ehL.x(bdVar);
            }
            if (bdVar.aQm() || bdVar.cky()) {
                String ic = u.ic(bdVar.field_msgSvrId);
                boolean cur = ((com.tencent.mm.ui.chatting.b.b.c) this.bAG.O(com.tencent.mm.ui.chatting.b.b.c.class)).cur();
                u.b v = u.Hx().v(ic, true);
                v.p("prePublishId", "msg_" + bdVar.field_msgSvrId);
                v.p("preUsername", com.tencent.mm.ui.chatting.viewitems.b.a(bdVar, com.tencent.mm.model.s.fq(this.bAG.getTalkerUserName()), cur));
                v.p("preChatName", this.bAG.getTalkerUserName());
                v.p("preMsgIndex", Integer.valueOf(0));
                v.p("sendAppMsgScene", Integer.valueOf(1));
                ((com.tencent.mm.plugin.sns.b.i) com.tencent.mm.kernel.g.l(com.tencent.mm.plugin.sns.b.i.class)).a("adExtStr", v, bdVar);
                chVar.bJF.bJK = ic;
            }
            g$a gp = g$a.gp(bi.WT(bdVar.field_content));
            if (!(gp == null || gp.type != 5 || gp.url == null)) {
                long VE = bi.VE();
                x.d("MicroMsg.ChattingUI.MessBoxComponent", "report(%s), url : %s, clickTimestamp : %d, scene : %d, actionType : %d, flag : %d", new Object[]{Integer.valueOf(13378), gp.url, Long.valueOf(VE), Integer.valueOf(2), Integer.valueOf(2), Integer.valueOf(1)});
                String str = "";
                try {
                    str = URLEncoder.encode(gp.url, "UTF-8");
                } catch (Throwable e) {
                    x.printErrStackTrace("MicroMsg.ChattingUI.MessBoxComponent", e, "", new Object[0]);
                }
                com.tencent.mm.plugin.report.service.h.mEJ.h(13378, new Object[]{str, Long.valueOf(VE), Integer.valueOf(2), Integer.valueOf(2), Integer.valueOf(1)});
            }
            this.bAG.YC();
            com.tencent.mm.ui.chatting.a.a(com.tencent.mm.ui.chatting.a.c.tFU, com.tencent.mm.ui.chatting.a.d.tFZ, bdVar, 0);
        }
    }
}
