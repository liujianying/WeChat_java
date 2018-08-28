package com.tencent.mm.ui.chatting;

import android.content.Context;
import android.net.Uri;
import com.tencent.mm.R;
import com.tencent.mm.g.a.iy;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.model.m;
import com.tencent.mm.model.q;
import com.tencent.mm.model.r;
import com.tencent.mm.modelvideo.o;
import com.tencent.mm.modelvideo.s;
import com.tencent.mm.pluginsdk.model.app.ao;
import com.tencent.mm.pluginsdk.model.app.b;
import com.tencent.mm.pluginsdk.model.app.f;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.bd;
import com.tencent.mm.y.g$a;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public final class aj {
    private ab bTk = null;
    private Context context;
    private SimpleDateFormat gVk = new SimpleDateFormat("yyyy-MM-dd");
    String juM = null;
    List<bd> tIM;
    private String tME = null;
    ArrayList<Uri> tMF = new ArrayList();

    public aj(Context context, List<bd> list, ab abVar) {
        this.context = context;
        this.tIM = list;
        this.bTk = abVar;
    }

    public final String cuj() {
        String str = "MicroMsg.OtherMailHistoryExporter";
        String str2 = "export: history is null? %B, selectItems.size = %d";
        Object[] objArr = new Object[2];
        objArr[0] = Boolean.valueOf(this.juM == null);
        objArr[1] = Integer.valueOf(this.tIM.size());
        x.d(str, str2, objArr);
        if (this.juM != null) {
            return this.juM;
        }
        this.tMF.clear();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(cuk());
        stringBuilder.append("\n\n");
        for (bd bdVar : this.tIM) {
            if (this.tME == null) {
                this.tME = gw(bdVar.field_createTime);
                stringBuilder.append(String.format("—————  %s  —————\n\n", new Object[]{this.tME}));
                stringBuilder.append("\n");
            } else {
                str = gw(bdVar.field_createTime);
                if (!str.equals(this.tME)) {
                    this.tME = str;
                    stringBuilder.append(String.format("—————  %s  —————\n\n", new Object[]{this.tME}));
                    stringBuilder.append("\n");
                }
            }
            String str3;
            if (bdVar.isText()) {
                if (!bdVar.isText()) {
                    str3 = null;
                } else if (bdVar.field_isSend == 1) {
                    str3 = String.format("%s\n\n%s\n\n", new Object[]{aG(bdVar), bdVar.field_content});
                } else if (this.bTk.field_username.endsWith("@chatroom")) {
                    str3 = com.tencent.mm.model.bd.iA(bdVar.field_content) != -1 ? String.format("%s\n\n%s\n\n", new Object[]{aG(bdVar), bdVar.field_content.substring(com.tencent.mm.model.bd.iA(bdVar.field_content) + 1).trim()}) : null;
                } else {
                    str3 = String.format("%s\n\n%s\n\n", new Object[]{aG(bdVar), bdVar.field_content});
                }
                stringBuilder.append(str3);
            } else if (bdVar.ckA()) {
                if (bdVar.ckA()) {
                    long j = bdVar.field_msgId;
                    long j2 = bdVar.field_msgSvrId;
                    str = ae.gu(j);
                    if (bi.oW(str)) {
                        str = ae.gv(j2);
                    }
                    x.d("MicroMsg.OtherMailHistoryExporter", "hdPath[%s]", new Object[]{str});
                    if (!bi.oW(str)) {
                        this.tMF.add(Uri.parse("file://" + str));
                        str = String.format("[%s: %s(%s)]", new Object[]{this.context.getString(R.l.email_image_prompt), new File(str).getName(), this.context.getString(R.l.email_attach_tips)});
                        str3 = String.format("%s\n\n%s\n\n", new Object[]{aG(bdVar), str});
                        stringBuilder.append(str3);
                    }
                }
                str3 = null;
                stringBuilder.append(str3);
            } else {
                if (bdVar.ckz()) {
                    str = String.format("[%s]", new Object[]{this.context.getString(R.l.email_voice_prompt)});
                } else if (bdVar.cme()) {
                    str = bdVar.field_isSend == 1 ? this.context.getString(R.l.email_send_voip_prompt) : this.context.getString(R.l.email_receive_voip_prompt);
                } else if (bdVar.aQo()) {
                    iy iyVar = new iy();
                    iyVar.bSB.bSv = 1;
                    iyVar.bSB.bGS = bdVar;
                    a.sFg.m(iyVar);
                    str = String.format("[%s]", new Object[]{iyVar.bSC.bPu});
                } else {
                    if (bdVar.aQm()) {
                        g$a gp = g$a.gp(bi.WT(bdVar.field_content));
                        if (gp != null) {
                            switch (gp.type) {
                                case 4:
                                case 6:
                                    b SR = ao.asF().SR(gp.bGP);
                                    if (SR != null) {
                                        File file = new File(SR.field_fileFullPath);
                                        if (file.exists()) {
                                            this.tMF.add(Uri.fromFile(file));
                                            break;
                                        }
                                    }
                                    break;
                            }
                            f bl = g.bl(gp.appId, true);
                            if (bl == null) {
                                str = "";
                            } else {
                                String str4 = bl.field_appName;
                                str = 6 == gp.type ? String.format("[%s: %s(%s)]", new Object[]{this.context.getString(R.l.email_appmsg_prompt), str4, this.context.getString(R.l.email_attach_tips)}) : String.format("[%s: %s]", new Object[]{this.context.getString(R.l.email_appmsg_prompt), str4});
                            }
                        }
                    } else if (bdVar.cmi()) {
                        au.HU();
                        str = c.FT().GR(bdVar.field_content).nickname;
                        str = String.format("[%s: %s]", new Object[]{this.context.getString(R.l.email_card_prompt), str});
                    } else if (bdVar.cmj()) {
                        r7 = new Object[3];
                        o.Ta();
                        r7[1] = new File(s.nK(bdVar.field_imgPath)).getName();
                        r7[2] = this.context.getString(R.l.email_attach_tips);
                        str = String.format("[%s: %s(%s)]", r7);
                        o.Ta();
                        File file2 = new File(s.nK(bdVar.field_imgPath));
                        if (file2.exists()) {
                            this.tMF.add(Uri.fromFile(file2));
                        }
                    } else if (bdVar.cml() || bdVar.cmm()) {
                        str = String.format("[%s]", new Object[]{this.context.getString(R.l.email_emoji_prompt)});
                    }
                    str = null;
                }
                x.i("MicroMsg.OtherMailHistoryExporter", "formatOtherMsg, msgStr = %s", new Object[]{str});
                stringBuilder.append(String.format("%s\n\n%s\n\n", new Object[]{aG(bdVar), str}));
            }
        }
        stringBuilder.append("\n\n");
        this.juM = stringBuilder.toString();
        return this.juM;
    }

    private String cuk() {
        String str;
        if (this.bTk.field_username.endsWith("@chatroom")) {
            if (bi.oW(this.bTk.field_nickname)) {
                String str2;
                str = "";
                Iterator it = m.gI(this.bTk.field_username).iterator();
                while (true) {
                    str2 = str;
                    if (!it.hasNext()) {
                        break;
                    }
                    str = str2 + r.gT((String) it.next()) + ", ";
                }
                str = str2.substring(0, str2.length() - 2);
            } else {
                str = this.bTk.BK();
            }
            return String.format(this.context.getString(R.l.send_mail_content_room_start_msg), new Object[]{str});
        }
        str = this.context.getString(R.l.send_mail_content_start_msg);
        Object[] objArr = new Object[2];
        objArr[0] = this.bTk.BK();
        au.HU();
        objArr[1] = c.DT().get(4, null);
        return String.format(str, objArr);
    }

    private String aG(bd bdVar) {
        String str;
        String str2 = null;
        if (this.bTk.field_username.endsWith("@chatroom")) {
            str = bdVar.field_content;
            int iA = com.tencent.mm.model.bd.iA(str);
            if (iA != -1) {
                str2 = r.gT(str.substring(0, iA).trim());
            }
        } else {
            str2 = r.gT(bdVar.field_talker);
        }
        if (bdVar.field_isSend == 1) {
            x.i("MicroMsg.OtherMailHistoryExporter", "isSend");
            str2 = q.GH();
        }
        str = new SimpleDateFormat("HH:mm").format(new Date(bdVar.field_createTime));
        StringBuilder stringBuilder = new StringBuilder("");
        stringBuilder.append(str2);
        stringBuilder.append("  ");
        stringBuilder.append(str);
        return stringBuilder.toString();
    }

    private String gw(long j) {
        return this.gVk.format(new Date(j));
    }
}
