package com.tencent.mm.ui.chatting;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.view.MenuItem;
import com.tencent.mm.R;
import com.tencent.mm.ac.f;
import com.tencent.mm.ak.e;
import com.tencent.mm.ak.o;
import com.tencent.mm.modelvideo.r;
import com.tencent.mm.modelvideo.t;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.bd;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.chatting.b.j;
import com.tencent.mm.ui.chatting.c.a;
import com.tencent.mm.ui.chatting.m.b;
import com.tencent.mm.ui.tools.k;
import java.util.List;

class m$4 implements d {
    final /* synthetic */ List tIF;
    final /* synthetic */ a tIQ;
    final /* synthetic */ ab tIR;
    final /* synthetic */ j tIS;
    final /* synthetic */ Context val$context;

    m$4(List list, Context context, a aVar, ab abVar, j jVar) {
        this.tIF = list;
        this.val$context = context;
        this.tIQ = aVar;
        this.tIR = abVar;
        this.tIS = jVar;
    }

    public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
        if (menuItem.getItemId() == 1193046) {
            if (j.dC(this.tIF)) {
                h.a(this.val$context, this.val$context.getString(R.l.contain_remuxing_msg), "", this.val$context.getString(R.l.I_known), new 1(this));
            } else if (j.dD(this.tIF)) {
                h.a(this.val$context, this.val$context.getString(R.l.contain_shortvideo_msg), "", this.val$context.getString(R.l.I_known), new OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                    }
                });
            } else if (j.dB(this.tIF)) {
                h.a(this.val$context, this.val$context.getString(R.l.contain_undownload_msg), "", new 3(this), null);
            } else if (n.a(this.tIQ, this.tIF, this.tIR) && this.tIS != null) {
                this.tIS.cuQ();
            }
        } else if (j.dC(this.tIF)) {
            h.a(this.val$context, this.val$context.getString(R.l.contain_remuxing_msg), "", this.val$context.getString(R.l.I_known), new 4(this));
        } else if (j.dD(this.tIF)) {
            h.a(this.val$context, this.val$context.getString(R.l.contain_shortvideo_msg), "", this.val$context.getString(R.l.I_known), new 5(this));
        } else {
            boolean z;
            List<bd> list = this.tIF;
            if (list != null) {
                for (bd bdVar : list) {
                    r nI;
                    if (bdVar.field_isSend == 1) {
                        break;
                    } else if (bdVar.ckA()) {
                        e br;
                        e bq;
                        if (bdVar.field_msgId > 0) {
                            br = o.Pf().br(bdVar.field_msgId);
                        } else {
                            br = null;
                        }
                        if ((br == null || br.dTK <= 0) && bdVar.field_msgSvrId > 0) {
                            bq = o.Pf().bq(bdVar.field_msgSvrId);
                        } else {
                            bq = br;
                        }
                        if (bq != null && (bq.offset < bq.dHI || bq.dHI == 0)) {
                            z = true;
                            break;
                        }
                    } else if (bdVar.cmj()) {
                        nI = com.tencent.mm.modelvideo.o.Ta().nI(bdVar.field_imgPath);
                        if (!(nI == null || nI.status == 199 || nI.status == 199)) {
                            z = true;
                            break;
                        }
                    } else if (bdVar.cmk()) {
                        nI = t.nW(bdVar.field_imgPath);
                        if (!(nI == null || nI.status == 199 || nI.status == 199)) {
                            z = true;
                            break;
                        }
                    } else if (bdVar.cmm()) {
                        z = !j.aq(bdVar);
                    }
                }
            } else {
                x.w("MicroMsg.ChattingEditModeLogic", "check contain undownload image or video error, select item empty");
            }
            z = false;
            if (z || j.dB(this.tIF)) {
                h.a(this.val$context, this.val$context.getString(R.l.contain_undownload_msg), "", new 6(this), null);
                return;
            }
            String str = (String) menuItem.getTitle();
            if (f.kK(str)) {
                if (this.tIF.size() <= 1) {
                    m.ctg().tIV = true;
                    m.a(str, this.tIQ, this.tIF);
                    return;
                }
                new k(this.val$context).b(menuItem.getActionView(), new 7(this), new 8(this, str));
            } else if (j.dz(this.tIF)) {
                h.a(this.val$context, this.val$context.getString(R.l.invalid_brand_msg_warning), "", new 9(this, menuItem), null);
            } else {
                Context context = this.val$context;
                this.val$context.getString(R.l.app_tip);
                m.a(h.a(context, this.val$context.getString(R.l.sending_message), false, null));
                j.tOP.c(new b(this.tIQ, this.val$context, menuItem.getTitle(), -1, m.ctg()));
                if (this.tIS != null) {
                    this.tIS.cuQ();
                }
            }
        }
    }
}
