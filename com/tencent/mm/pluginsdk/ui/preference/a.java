package com.tencent.mm.pluginsdk.ui.preference;

import android.content.Context;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.az.c;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.au;
import com.tencent.mm.plugin.messenger.foundation.a.i;
import com.tencent.mm.pluginsdk.model.m;
import com.tencent.mm.pluginsdk.ui.d.j;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.at;
import com.tencent.mm.storage.ba;
import com.tencent.mm.storage.bb;
import com.tencent.mm.storage.bd.d;
import com.tencent.mm.storage.bo;
import com.tencent.mm.storage.bp;
import com.tencent.mm.ui.base.p;

public final class a extends LinearLayout implements e {
    private static a qOs;
    private Context context;
    private TextView eZj;
    private Button qOt;
    p tipDialog;

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static /* synthetic */ void a(com.tencent.mm.pluginsdk.ui.preference.a r12, java.lang.String r13) {
        /*
        r7 = 0;
        r11 = 0;
        r10 = 1;
        r0 = qOs;
        if (r0 != 0) goto L_0x0011;
    L_0x0007:
        r0 = "MicroMsg.FMessageItemView";
        r1 = "FMessage Args is null";
        com.tencent.mm.sdk.platformtools.x.e(r0, r1);
    L_0x0010:
        return;
    L_0x0011:
        r0 = "MicroMsg.FMessageItemView";
        r1 = "try to reply verify content";
        com.tencent.mm.sdk.platformtools.x.d(r0, r1);
        r2 = new java.util.LinkedList;
        r2.<init>();
        r0 = qOs;
        r0 = r0.talker;
        r2.add(r0);
        r3 = new java.util.LinkedList;
        r3.<init>();
        r0 = qOs;
        r0 = r0.scene;
        r0 = java.lang.Integer.valueOf(r0);
        r3.add(r0);
        r4 = new java.util.LinkedList;
        r4.<init>();
        r0 = qOs;
        r0 = r0.qOy;
        r4.add(r0);
        r0 = qOs;
        r0 = r0.type;
        r1 = qOs;
        r1 = r1.talker;
        r5 = "MicroMsg.FMessageItemView";
        r6 = new java.lang.StringBuilder;
        r8 = "getOpCode, type = ";
        r6.<init>(r8);
        r6 = r6.append(r0);
        r8 = ", talker = ";
        r6 = r6.append(r8);
        r6 = r6.append(r1);
        r6 = r6.toString();
        com.tencent.mm.sdk.platformtools.x.d(r5, r6);
        switch(r0) {
            case 0: goto L_0x00c1;
            case 1: goto L_0x0103;
            case 2: goto L_0x0126;
            default: goto L_0x006e;
        };
    L_0x006e:
        r1 = 6;
    L_0x006f:
        r0 = "MicroMsg.FMessageItemView";
        r5 = new java.lang.StringBuilder;
        r6 = "reply, final opcode = ";
        r5.<init>(r6);
        r5 = r5.append(r1);
        r5 = r5.toString();
        com.tencent.mm.sdk.platformtools.x.d(r0, r5);
        r0 = com.tencent.mm.model.au.DF();
        r5 = 30;
        r0.a(r5, r12);
        r0 = new com.tencent.mm.pluginsdk.model.m;
        r5 = qOs;
        r6 = r5.juZ;
        r9 = "";
        r5 = r13;
        r8 = r7;
        r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9);
        r1 = com.tencent.mm.model.au.DF();
        r1.a(r0, r11);
        r1 = r12.context;
        r2 = r12.context;
        r3 = com.tencent.mm.R.l.app_tip;
        r2.getString(r3);
        r2 = r12.context;
        r3 = com.tencent.mm.R.l.app_sending;
        r2 = r2.getString(r3);
        r3 = new com.tencent.mm.pluginsdk.ui.preference.a$2;
        r3.<init>(r12, r0);
        r0 = com.tencent.mm.ui.base.h.a(r1, r2, r10, r3);
        r12.tipDialog = r0;
        goto L_0x0010;
    L_0x00c1:
        if (r1 == 0) goto L_0x00c9;
    L_0x00c3:
        r0 = r1.length();
        if (r0 != 0) goto L_0x00d7;
    L_0x00c9:
        r0 = "MicroMsg.FMessageLogic";
        r1 = "isVerifyReceiver, invalid argument";
        com.tencent.mm.sdk.platformtools.x.e(r0, r1);
    L_0x00d2:
        r0 = r11;
    L_0x00d3:
        if (r0 != 0) goto L_0x006e;
    L_0x00d5:
        r1 = 5;
        goto L_0x006f;
    L_0x00d7:
        r0 = com.tencent.mm.az.d.SE();
        r0 = r0.YO(r1);
        if (r0 != 0) goto L_0x00f8;
    L_0x00e1:
        r0 = "MicroMsg.FMessageLogic";
        r5 = new java.lang.StringBuilder;
        r6 = "isVerifyReceiver, lastRecvFmsg does not exist, talker = ";
        r5.<init>(r6);
        r1 = r5.append(r1);
        r1 = r1.toString();
        com.tencent.mm.sdk.platformtools.x.e(r0, r1);
        goto L_0x00d2;
    L_0x00f8:
        r1 = r0.field_type;
        if (r1 == r10) goto L_0x0101;
    L_0x00fc:
        r0 = r0.field_type;
        r1 = 2;
        if (r0 != r1) goto L_0x00d2;
    L_0x0101:
        r0 = r10;
        goto L_0x00d3;
    L_0x0103:
        r0 = com.tencent.mm.az.d.SG();
        r0 = r0.dd(r1, r10);
        if (r0 == 0) goto L_0x011c;
    L_0x010d:
        r0 = r0[r11];
    L_0x010f:
        if (r0 != 0) goto L_0x011e;
    L_0x0111:
        r0 = "MicroMsg.FMessageItemView";
        r1 = "getOpCode, last lbsMsg is null";
        com.tencent.mm.sdk.platformtools.x.e(r0, r1);
        goto L_0x006e;
    L_0x011c:
        r0 = r7;
        goto L_0x010f;
    L_0x011e:
        r0 = r0.field_content;
        r1 = TR(r0);
        goto L_0x006f;
    L_0x0126:
        r0 = com.tencent.mm.az.d.SH();
        r0 = r0.df(r1, r10);
        if (r0 == 0) goto L_0x013f;
    L_0x0130:
        r0 = r0[r11];
    L_0x0132:
        if (r0 != 0) goto L_0x0141;
    L_0x0134:
        r0 = "MicroMsg.FMessageItemView";
        r1 = "getOpCode, last shakeMsg is null";
        com.tencent.mm.sdk.platformtools.x.e(r0, r1);
        goto L_0x006e;
    L_0x013f:
        r0 = r7;
        goto L_0x0132;
    L_0x0141:
        r0 = r0.field_content;
        r1 = TR(r0);
        goto L_0x006f;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.pluginsdk.ui.preference.a.a(com.tencent.mm.pluginsdk.ui.preference.a, java.lang.String):void");
    }

    public static void setFMessageArgs(a aVar) {
        qOs = aVar;
    }

    public a(Context context) {
        super(context);
        this.context = context;
        View inflate = View.inflate(this.context, R.i.fmessage_item_view, this);
        this.eZj = (TextView) inflate.findViewById(R.h.fmessage_item_view_content_tv);
        this.qOt = (Button) inflate.findViewById(R.h.fmessage_item_view_reply_btn);
        this.qOt.setOnClickListener(new 1(this));
    }

    private static int TR(String str) {
        if (str == null) {
            x.d("MicroMsg.FMessageItemView", "getOpCodeFromVerify fail, xml is null");
            return 6;
        }
        switch (d.YY(str).bOh) {
            case 6:
                return 5;
            default:
                return 6;
        }
    }

    public final void setContentText(String str) {
        this.eZj.setText(j.a(this.context, bi.oV(str), this.eZj.getTextSize()));
    }

    public final void setBtnVisibility(int i) {
        if (this.qOt != null) {
            this.qOt.setVisibility(i);
        }
    }

    public final void a(int i, int i2, String str, l lVar) {
        if (lVar.getType() == 30) {
            x.d("MicroMsg.FMessageItemView", "onSceneEnd, errType = " + i + ", errCode = " + i2);
            if (this.tipDialog != null) {
                this.tipDialog.dismiss();
            }
            if (i == 0 && i2 == 0) {
                int i3 = ((m) lVar).bOh;
                String str2 = ((m) lVar).qza;
                x.d("MicroMsg.FMessageItemView", "onSceneEnd, pre insert fmsg, opcode = " + i3 + ", verifyContent = " + str2);
                x.d("MicroMsg.FMessageItemView", "onSceneEnd, type = " + qOs.type);
                switch (qOs.type) {
                    case 1:
                        ba baVar = new ba();
                        g.l(i.class);
                        baVar.field_createtime = bb.YT(qOs.talker);
                        baVar.field_isSend = 1;
                        baVar.field_content = str2;
                        baVar.field_talker = "fmessage";
                        baVar.field_sayhiuser = qOs.talker;
                        baVar.field_svrid = System.currentTimeMillis();
                        baVar.field_status = 4;
                        com.tencent.mm.az.d.SG().a(baVar);
                        break;
                    case 2:
                        bo boVar = new bo();
                        g.l(i.class);
                        boVar.field_createtime = bp.YT(qOs.talker);
                        boVar.field_isSend = 1;
                        boVar.field_content = str2;
                        boVar.field_talker = "fmessage";
                        boVar.field_sayhiuser = qOs.talker;
                        boVar.field_svrid = System.currentTimeMillis();
                        boVar.field_status = 4;
                        x.d("MicroMsg.FMessageItemView", "onSceneEnd, insert shake, ret = " + com.tencent.mm.az.d.SH().a(boVar));
                        break;
                    default:
                        at atVar = new at();
                        atVar.field_createTime = c.o(qOs.talker, 0);
                        atVar.field_isSend = 1;
                        atVar.field_msgContent = str2;
                        atVar.field_talker = qOs.talker;
                        atVar.field_type = i3 == 5 ? 2 : 3;
                        x.d("MicroMsg.FMessageItemView", "onSceneEnd, insert fmsg, ret = " + com.tencent.mm.az.d.SE().b(atVar));
                        break;
                }
            }
            CharSequence str3;
            if (i == 4 && i2 == -34) {
                str3 = this.context.getString(R.l.fmessage_request_too_offen);
            } else if (i == 4 && i2 == -94) {
                str3 = this.context.getString(R.l.fmessage_user_not_support);
            } else if (!(i == 4 && i2 == -24 && !bi.oW(str3))) {
                str3 = this.context.getString(R.l.sendrequest_send_fail);
            }
            Toast.makeText(this.context, str3, 1).show();
            au.DF().b(30, (e) this);
        }
    }
}
