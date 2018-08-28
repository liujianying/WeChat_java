package com.tencent.mm.ui.transmit;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import com.tencent.mm.R;
import com.tencent.mm.model.q;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.modelvideo.n;
import com.tencent.mm.modelvideo.o;
import com.tencent.mm.modelvideo.r;
import com.tencent.mm.modelvideo.s;
import com.tencent.mm.modelvideo.t;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.c.bri;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.chatting.ChattingUI;
import com.tencent.mm.ui.transmit.MsgRetransmitUI.b;

public final class MsgRetransmitUI$a extends AsyncTask<Object, Object, String> {
    public String bZN;
    public Context context;
    public String cqb;
    public Dialog eXG;
    public int elY;
    public int enM;
    public String fileName;
    private ag mHandler = new ag();
    public boolean uDV;
    public String uDW;
    public boolean uDX = true;
    public boolean uDY = false;
    public boolean uDZ = true;
    public boolean uDo = false;
    public int uDq;
    public bri uEa = null;
    public b uEb = null;
    public String userName;

    protected final /* synthetic */ Object doInBackground(Object[] objArr) {
        String nJ = s.nJ(q.GF());
        o.Ta();
        String nL = s.nL(nJ);
        if (this.uDZ) {
            FileOp.y(s.nK(this.fileName), s.nK(nJ));
            FileOp.y(s.nL(this.fileName), nL);
        } else {
            FileOp.y(this.fileName, s.nK(nJ));
            FileOp.y(this.uDW, nL);
        }
        r nW = t.nW(this.fileName);
        int i = nW != null ? nW.status : 0;
        x.i("MicroMsg.MsgRetransmitUI", "CopyVideoTask ori[%s] status[%d] new[%s]", new Object[]{this.fileName, Integer.valueOf(i), nJ});
        return nJ;
    }

    protected final /* synthetic */ void onPostExecute(Object obj) {
        String str = (String) obj;
        if (this.eXG != null) {
            this.eXG.dismiss();
            this.eXG = null;
        }
        o.Ta();
        boolean cn = FileOp.cn(s.nK(str));
        o.Ta();
        String nL = s.nL(str);
        boolean cn2 = FileOp.cn(nL);
        if (this.uDV) {
            if (cn) {
                FileOp.deleteFile(str);
            }
            if (cn2) {
                FileOp.deleteFile(nL);
                return;
            }
            return;
        }
        x.d("MicroMsg.MsgRetransmitUI", "dkvideo videoIsExport :" + this.uDq + ", videoMsgType :43 videoType : " + this.elY);
        t.a(str, this.enM, this.userName, null, this.uDq, "", 43, this.uEa, this.bZN);
        Object obj2 = t.nR(str) != 0 ? 1 : null;
        o.Ta();
        nL = s.nK(str);
        int i = 3;
        if (!bi.oW(this.fileName) && this.fileName.contains("favorite")) {
            i = 7;
        }
        int i2 = (bi.oW(this.fileName) || !this.fileName.contains("sns")) ? i : 6;
        n.SY().a("", nL, this.userName, this.cqb, "", i2, 2);
        h.mEJ.h(10424, new Object[]{Integer.valueOf(43), Integer.valueOf(8), this.userName});
        if (this.uEb != null) {
            b bVar = this.uEb;
            nL = this.userName;
            Object obj3 = obj2 == null ? 1 : null;
            if (bVar.uEd != null && bVar.uEd.contains(nL)) {
                bVar.uEd.remove(nL);
                if (obj3 == null) {
                    bVar.bJm = false;
                }
                if (bVar.uEd.size() == 0) {
                    obj3 = 1;
                    if (obj3 != null) {
                        obj2 = !this.uEb.bJm ? 1 : null;
                    } else {
                        return;
                    }
                }
            }
            obj3 = null;
            if (obj3 != null) {
                obj2 = !this.uEb.bJm ? 1 : null;
            } else {
                return;
            }
        }
        if (this.uDX) {
            Intent intent = new Intent(this.context, ChattingUI.class);
            intent.addFlags(67108864);
            intent.putExtra("Chat_User", this.userName);
            this.context.startActivity(intent);
        }
        if (this.uDo && (this.context instanceof Activity)) {
            com.tencent.mm.ui.widget.snackbar.b.h((Activity) this.context, this.context.getString(obj2 == null ? R.l.has_send : R.l.sendrequest_send_fail));
        }
        this.mHandler.postDelayed(new 1(this), 1800);
    }
}
