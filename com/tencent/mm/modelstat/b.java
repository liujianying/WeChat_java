package com.tencent.mm.modelstat;

import android.os.Looper;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.report.kvdata.IMBehavior;
import com.tencent.mm.plugin.report.kvdata.IMBehaviorChattingOP;
import com.tencent.mm.plugin.report.kvdata.IMBehaviorMsgOP;
import com.tencent.mm.plugin.report.kvdata.log_13835;
import com.tencent.mm.plugin.report.kvdata.log_13913;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.bd;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Locale;

public final class b {
    public static b ehL = new b();
    private c cXJ = new 1(this);
    public log_13835 ehK;
    private int ehM = 1;
    private int ehN = 1;
    private boolean hasInit = false;
    public Object lock = new Object();

    private b() {
        a.sFg.a(this.cXJ);
    }

    public final boolean cE(String str) {
        if (bi.oW(str)) {
            x.e("MicroMsg.ChattingOperationUitl", "check error:%s", new Object[]{bi.cjd().toString()});
            log_13913 log_13913 = new log_13913();
            log_13913.scene_ = 1;
            log_13913.error_ = r2;
            h.mEJ.c(13913, log_13913);
            return false;
        }
        if (!(this.ehK == null || this.ehK.currChatName_ == null || this.ehK.currChatName_.equals(str))) {
            xP();
        }
        if (this.ehK == null) {
            this.ehK = new log_13835();
            this.ehK.currChatName_ = str;
        }
        return true;
    }

    public final void xP() {
        if (RS()) {
            int i;
            synchronized (this.lock) {
                i = (this.ehK == null || this.ehK.oplist_.isEmpty()) ? 0 : 1;
            }
            if (i != 0) {
                if (this.ehN != 0) {
                    x.i("MicroMsg.ChattingOperationUitl", "report imOperation(13835)");
                    h.mEJ.c(13835, this.ehK);
                }
                if (this.ehM != 0) {
                    x.i("MicroMsg.ChattingOperationUitl", "report imOperation(13748) reportStr:%s", new Object[]{RR()});
                    h.mEJ.k(13748, r0);
                }
            }
            this.ehK = null;
        }
    }

    public final void K(String str, boolean z) {
        int i = 1;
        if (RS()) {
            IMBehavior iMBehavior = new IMBehavior();
            iMBehavior.opType = 1;
            iMBehavior.chattingOp = new IMBehaviorChattingOP();
            IMBehaviorChattingOP iMBehaviorChattingOP = iMBehavior.chattingOp;
            if (!z) {
                i = 2;
            }
            iMBehaviorChattingOP.changeUnread = i;
            xP();
            if (cE(str)) {
                synchronized (this.lock) {
                    this.ehK.oplist_.add(iMBehavior);
                }
                xP();
            }
        }
    }

    public final void c(boolean z, String str, boolean z2) {
        int i = 1;
        if (RS()) {
            IMBehavior iMBehavior = new IMBehavior();
            iMBehavior.opType = 1;
            iMBehavior.chattingOp = new IMBehaviorChattingOP();
            IMBehaviorChattingOP iMBehaviorChattingOP = iMBehavior.chattingOp;
            if (!z2) {
                i = 2;
            }
            iMBehaviorChattingOP.changeTop = i;
            if (z) {
                xP();
            }
            if (cE(str)) {
                synchronized (this.lock) {
                    this.ehK.oplist_.add(iMBehavior);
                }
                if (z) {
                    xP();
                }
            }
        }
    }

    public final void L(String str, boolean z) {
        int i = 1;
        if (RS() && cE(str)) {
            IMBehavior iMBehavior = new IMBehavior();
            iMBehavior.opType = 1;
            iMBehavior.chattingOp = new IMBehaviorChattingOP();
            IMBehaviorChattingOP iMBehaviorChattingOP = iMBehavior.chattingOp;
            if (!z) {
                i = 2;
            }
            iMBehaviorChattingOP.changeSaveAddress = i;
            synchronized (this.lock) {
                this.ehK.oplist_.add(iMBehavior);
            }
        }
    }

    public final void a(bd bdVar, b bVar, int i) {
        if (cE(bdVar.field_talker)) {
            IMBehavior iMBehavior = new IMBehavior();
            iMBehavior.opType = 2;
            iMBehavior.msgOp = new IMBehaviorMsgOP();
            iMBehavior.msgOp.msgType = bdVar.getType() & 65535;
            if (bdVar.aQm()) {
                iMBehavior.msgOp.appMsgInnerType = i;
            }
            iMBehavior.msgOp.msgOpType = bVar.value;
            iMBehavior.msgOp.count = 1;
            synchronized (this.lock) {
                if (iMBehavior.opType == a.ehQ.value) {
                    this.ehK.oplist_.add(iMBehavior);
                    return;
                }
                Iterator it = this.ehK.oplist_.iterator();
                while (it.hasNext()) {
                    IMBehavior iMBehavior2 = (IMBehavior) it.next();
                    if (iMBehavior2.opType == a.ehR.value) {
                        IMBehaviorMsgOP iMBehaviorMsgOP = iMBehavior2.msgOp;
                        IMBehaviorMsgOP iMBehaviorMsgOP2 = iMBehavior.msgOp;
                        int i2 = (iMBehaviorMsgOP.msgOpType == iMBehaviorMsgOP2.msgOpType && iMBehaviorMsgOP.msgType == iMBehaviorMsgOP2.msgType && iMBehaviorMsgOP.appMsgInnerType == iMBehaviorMsgOP2.appMsgInnerType) ? 1 : 0;
                        if (i2 != 0) {
                            IMBehaviorMsgOP iMBehaviorMsgOP3 = iMBehavior2.msgOp;
                            iMBehaviorMsgOP3.count++;
                            return;
                        }
                    }
                }
                this.ehK.oplist_.add(iMBehavior);
            }
        }
    }

    public final void a(bd bdVar, int i) {
        new ag(Looper.getMainLooper()).post(new 2(this, bdVar, i));
    }

    public final void f(bd bdVar) {
        new ag(Looper.getMainLooper()).post(new 3(this, bdVar));
    }

    public final void b(bd bdVar, int i) {
        if (RS()) {
            a(bdVar, b.ehX, i);
        }
    }

    public final void x(bd bdVar) {
        if (RS()) {
            a(bdVar, b.ehX, 0);
        }
    }

    public final void c(bd bdVar, int i) {
        if (RS()) {
            a(bdVar, b.ehZ, i);
        }
    }

    public final void y(bd bdVar) {
        if (RS()) {
            a(bdVar, b.ehZ, 0);
        }
    }

    public final void z(bd bdVar) {
        if (RS()) {
            a(bdVar, b.ehV, 0);
        }
    }

    public final void A(bd bdVar) {
        if (RS()) {
            a(bdVar, b.eia, 0);
        }
    }

    public final void a(bd bdVar, boolean z) {
        if (RS() && bdVar.isText()) {
            a(bdVar, z ? b.eib : b.eic, 0);
        }
    }

    public final void B(bd bdVar) {
        if (RS()) {
            a(bdVar, b.eie, 0);
        }
    }

    public final void a(bd bdVar, boolean z, int i) {
        if (RS()) {
            a(bdVar, z ? b.eif : b.eig, i);
        }
    }

    private String RR() {
        if (this.ehK == null) {
            return "";
        }
        String str = ",";
        LinkedList linkedList = new LinkedList();
        synchronized (this.lock) {
            linkedList.addAll(this.ehK.oplist_);
        }
        Iterator it = linkedList.iterator();
        int i = 1;
        while (it.hasNext()) {
            StringBuilder append;
            String str2;
            IMBehavior iMBehavior = (IMBehavior) it.next();
            if (i == 0) {
                str = str + "|";
            }
            str = str + iMBehavior.opType + "#";
            if (iMBehavior.opType == 1) {
                append = new StringBuilder().append(str);
                IMBehaviorChattingOP iMBehaviorChattingOP = iMBehavior.chattingOp;
                str2 = "";
                if (iMBehaviorChattingOP.changeUnread != 0) {
                    str2 = str2 + "changeUnread=" + iMBehaviorChattingOP.changeUnread;
                }
                if (iMBehaviorChattingOP.changeTop != 0) {
                    str2 = str2 + "changeTop=" + iMBehaviorChattingOP.changeTop;
                }
                if (iMBehaviorChattingOP.changeNotifyStatus != 0) {
                    str2 = str2 + "changeNotifyStatus=" + iMBehaviorChattingOP.changeNotifyStatus;
                }
                if (iMBehaviorChattingOP.changeSaveAddress != 0) {
                    str2 = str2 + "changeSaveAddress=" + iMBehaviorChattingOP.changeSaveAddress;
                }
                if (iMBehaviorChattingOP.expose != 0) {
                    str2 = str2 + "expose=" + iMBehaviorChattingOP.expose;
                }
            } else {
                append = new StringBuilder().append(str);
                if (iMBehavior.msgOp.msgType == 49) {
                    str2 = String.format(Locale.US, "msgType=%d&msgOpType=%d&appMsgInnerType=%d&count=%d", new Object[]{Integer.valueOf(iMBehavior.msgOp.msgType), Integer.valueOf(iMBehavior.msgOp.msgOpType), Integer.valueOf(iMBehavior.msgOp.appMsgInnerType), Integer.valueOf(iMBehavior.msgOp.count)});
                } else {
                    str2 = String.format(Locale.US, "msgType=%d&msgOpType=%d&count=%d", new Object[]{Integer.valueOf(iMBehavior.msgOp.msgType), Integer.valueOf(iMBehavior.msgOp.msgOpType), Integer.valueOf(iMBehavior.msgOp.count)});
                }
            }
            str = append.append(str2).toString();
            i = 0;
        }
        return str + "," + this.ehK.currChatName_;
    }

    public final boolean RS() {
        if (!this.hasInit) {
            this.hasInit = true;
            if (g.Eg().Dx()) {
                com.tencent.mm.storage.c fJ = com.tencent.mm.model.c.c.Jx().fJ("100148");
                if (fJ.isValid()) {
                    this.ehM = bi.getInt((String) fJ.ckq().get("needUploadData"), 1);
                }
                fJ = com.tencent.mm.model.c.c.Jx().fJ("100149");
                if (fJ.isValid()) {
                    this.ehN = bi.getInt((String) fJ.ckq().get("needUploadData"), 1);
                }
            } else {
                x.w("MicroMsg.ChattingOperationUitl", "account has not ready");
            }
        }
        return (this.ehM == 0 && this.ehN == 0) ? false : true;
    }
}
