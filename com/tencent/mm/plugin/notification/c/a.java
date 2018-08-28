package com.tencent.mm.plugin.notification.c;

import android.content.Context;
import android.os.Build.VERSION;
import android.os.Looper;
import android.support.v4.app.z.d;
import com.tencent.mm.g.a.kf;
import com.tencent.mm.plugin.notification.d.b;
import com.tencent.mm.plugin.notification.d.f;
import com.tencent.mm.plugin.notification.ui.FailSendMsgNotification;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public abstract class a<T> implements c {
    private al lHA;
    private c lHB;
    public b lHt;
    protected FailSendMsgNotification lHu;
    protected boolean lHv;
    protected ArrayList<Long> lHw;
    protected ArrayList<Long> lHx;
    protected ArrayList<Long> lHy;
    private ArrayList<al> lHz;
    public Context mContext;

    public abstract void I(ArrayList<Long> arrayList);

    public abstract String T(int i, int i2, int i3);

    public abstract long bL(T t);

    public abstract ArrayList<Long> bM(T t);

    public abstract void bko();

    public abstract String dc(int i, int i2);

    public abstract String dd(int i, int i2);

    public abstract void eh(long j);

    public abstract boolean ei(long j);

    public abstract int getType();

    public abstract String ue(int i);

    static /* synthetic */ void a(a aVar) {
        x.d("MicroMsg.AbstractSendMsgFailNotification", "checkMsgExistBeforeResend, mMsgList.size:%d", new Object[]{Integer.valueOf(aVar.lHt.lHE.size())});
        aVar.bkg();
        if (VERSION.SDK_INT >= 16) {
            aVar.lHu.IU(aVar.ue(aVar.lHt.lHE.size()));
        }
        x.d("MicroMsg.AbstractSendMsgFailNotification", "checkMsgExistBeforeResend, after check, mMsgList.size:%d", new Object[]{Integer.valueOf(aVar.lHt.lHE.size())});
    }

    static /* synthetic */ void a(a aVar, long j) {
        while (!aVar.ei(j)) {
            aVar.lHx.add(Long.valueOf(j));
            x.d("MicroMsg.AbstractSendMsgFailNotification", "tryResendNextMsg, msg:%d not exist", new Object[]{Long.valueOf(j)});
            aVar.bkc();
            j = aVar.lHt.bks();
            if (j == -1) {
                x.e("MicroMsg.AbstractSendMsgFailNotification", "tryResendNextMsg error, finalMsgId is -1, may be resend finish");
                if (aVar.lHw.size() + aVar.lHx.size() >= aVar.lHt.lHE.size()) {
                    x.d("MicroMsg.AbstractSendMsgFailNotification", "tryResendNextMsg, resend finish");
                    aVar.bkd();
                    return;
                }
                return;
            }
        }
        x.d("MicroMsg.AbstractSendMsgFailNotification", "tryResendNextMsg, finalMsgId:%d", new Object[]{Long.valueOf(j)});
        aVar.eh(j);
        al alVar = new al(new 8(aVar, j), false);
        alVar.J(1800000, 1800000);
        aVar.lHz.add(alVar);
    }

    public a() {
        this.lHt = null;
        this.lHu = null;
        this.lHv = false;
        this.mContext = null;
        this.lHw = null;
        this.lHx = null;
        this.lHy = null;
        this.lHz = new ArrayList();
        this.lHA = null;
        this.lHB = new 1(this);
        this.lHt = new b();
        this.lHu = new FailSendMsgNotification(getType());
        this.lHv = false;
        this.mContext = ad.getContext();
        this.lHw = new ArrayList();
        this.lHx = new ArrayList();
        this.lHy = new ArrayList();
        this.lHu.lIn = new 2(this);
        this.lHu.lIo = new 3(this);
        this.lHu.lIp = new 4(this);
        bka();
    }

    private void bka() {
        this.lHA = new al(Looper.getMainLooper(), new 5(this), true);
    }

    public final void bJ(T t) {
        if (t != null) {
            x.d("MicroMsg.AbstractSendMsgFailNotification", "processSendMsgFail, msgId:%d, msgList:%s, isResending:%b", new Object[]{Long.valueOf(bL(t)), bkj(), Boolean.valueOf(this.lHv)});
            if (this.lHv) {
                if (this.lHt.ek(bL(t)) && !this.lHx.contains(Long.valueOf(bL(t)))) {
                    this.lHx.add(Long.valueOf(bL(t)));
                }
                if (!this.lHt.ek(bL(t))) {
                    x.d("MicroMsg.AbstractSendMsgFailNotification", "sending msg, another fail msg");
                    this.lHt.ej(bL(t));
                }
                bkc();
                x.d("MicroMsg.AbstractSendMsgFailNotification", "processSendMsgFail, successlist.size:%d, faillist.size:%d", new Object[]{Integer.valueOf(this.lHw.size()), Integer.valueOf(this.lHx.size())});
                if (this.lHw.size() + this.lHx.size() < this.lHt.lHE.size()) {
                    long bks = this.lHt.bks();
                    if (bks == -1) {
                        x.e("TAG", "resend error, next msg id is -1");
                        return;
                    }
                    x.d("MicroMsg.AbstractSendMsgFailNotification", "continue resend, nextId:%d", new Object[]{Long.valueOf(bks)});
                    bkn();
                    eg(bks);
                    return;
                }
                bkd();
            } else if (this.lHy.contains(Long.valueOf(bL(t)))) {
                this.lHy.remove(Long.valueOf(bL(t)));
            } else if (t == null) {
                x.e("MicroMsg.AbstractSendMsgFailNotification", "showNotificationAfterSendFail, msgObj is null");
            } else {
                Collection bM = bM(t);
                if (bM == null || bM.size() <= 0) {
                    x.e("MicroMsg.AbstractSendMsgFailNotification", "showNotificationAfterSendFail, cannot get history fail msg");
                    return;
                }
                aXL();
                b bVar = this.lHt;
                if (bM != null && bM.size() > 0) {
                    bVar.lHE.addAll(bM);
                }
                bkn();
                x.d("MicroMsg.AbstractSendMsgFailNotification", "showNotificationAfterSendFail, msgList.size:%d, msgList:%s", new Object[]{Integer.valueOf(this.lHt.lHE.size()), bkj()});
                h.mEJ.h(11426, new Object[]{Integer.valueOf(getType())});
                ah.i(new 6(this), 1000);
            }
        }
    }

    private void bkb() {
        x.d("MicroMsg.AbstractSendMsgFailNotification", "showInitNotification, isInForeground:%b", new Object[]{Boolean.valueOf(f.bkz())});
        this.lHu.lIr = ue(this.lHt.lHE.size());
        this.lHu.bkE();
        if (!f.bkz() && !this.lHu.lIw) {
            this.lHu.lIq = ue(this.lHt.lHE.size());
            this.lHu.bkD();
            this.lHu.bkC();
            x.d("MicroMsg.AbstractSendMsgFailNotification", "showInitNotification, first show notification");
            this.lHu.show();
            com.tencent.mm.sdk.b.a.sFg.c(this.lHB);
            com.tencent.mm.sdk.b.a.sFg.b(this.lHB);
        } else if (this.lHu.lIw) {
            this.lHu.bkD();
            this.lHu.bkC();
            x.d("MicroMsg.AbstractSendMsgFailNotification", "showInitNotification, update notification content text");
            this.lHu.IU(ue(this.lHt.lHE.size()));
            com.tencent.mm.sdk.b.a.sFg.c(this.lHB);
            com.tencent.mm.sdk.b.a.sFg.b(this.lHB);
        } else {
            x.d("MicroMsg.AbstractSendMsgFailNotification", "showInitNotification, not show or update notification, isForeground:%b", new Object[]{Boolean.valueOf(f.bkz())});
        }
    }

    public final void bK(T t) {
        x.d("MicroMsg.AbstractSendMsgFailNotification", "processSendMsgSucess, msgId:%d, msgList:%s", new Object[]{Long.valueOf(bL(t)), bkj()});
        if (this.lHt.ek(bL(t))) {
            long bL = bL(t);
            if (this.lHy.contains(Long.valueOf(bL)) && this.lHx.contains(Long.valueOf(bL))) {
                x.i("MicroMsg.AbstractSendMsgFailNotification", "receive send msg success event from a timout message, remvoe it from the fail list");
                this.lHy.remove(Long.valueOf(bL));
                this.lHx.remove(Long.valueOf(bL));
            }
            if (this.lHv) {
                this.lHw.add(Long.valueOf(bL));
                bkc();
                x.d("MicroMsg.AbstractSendMsgFailNotification", "processSendMsgSuccess, successlist.size:%d, faillist.size:%d", new Object[]{Integer.valueOf(this.lHw.size()), Integer.valueOf(this.lHx.size())});
                if (this.lHw.size() + this.lHx.size() < this.lHt.lHE.size()) {
                    bL = this.lHt.bks();
                    if (bL == -1) {
                        x.e("TAG", "resend error, next msg id is -1");
                        return;
                    }
                    x.d("MicroMsg.AbstractSendMsgFailNotification", "continue resend, nextId:%d", new Object[]{Long.valueOf(bL)});
                    bkn();
                    eg(bL);
                    return;
                }
                bkd();
                return;
            }
            this.lHt.remove(bL(t));
            if (this.lHt.lHE.size() == 0) {
                this.lHu.dismiss();
                aXL();
                b.ug(getType());
                return;
            }
            x.d("MicroMsg.AbstractSendMsgFailNotification", "maybe the user manually resend the message, update init wording");
            this.lHu.IU(ue(this.lHt.lHE.size()));
        }
    }

    private void bkc() {
        if (VERSION.SDK_INT >= 16) {
            this.lHu.lIr = ue(this.lHt.lHE.size());
            if (this.lHx.size() <= 0) {
                this.lHu.IU(dc(this.lHt.lHE.size(), this.lHw.size() + this.lHx.size()));
            } else {
                this.lHu.IU(T(this.lHt.lHE.size(), this.lHw.size() + this.lHx.size(), this.lHx.size()));
            }
        }
    }

    private void bkd() {
        Long l;
        this.lHv = false;
        x.d("MicroMsg.AbstractSendMsgFailNotification", "finish resend, msgList.size:%d, mFailList.size:%d, mSuccessList.size:%d", new Object[]{Integer.valueOf(this.lHt.lHE.size()), Integer.valueOf(this.lHx.size()), Integer.valueOf(this.lHw.size())});
        x.d("MicroMsg.AbstractSendMsgFailNotification", "checkMsgExistAfterResend, before check, mMsgList.size:%d, mSuccessList.size:%d, mFailList.size:%d", new Object[]{Integer.valueOf(this.lHt.lHE.size()), Integer.valueOf(this.lHw.size()), Integer.valueOf(this.lHx.size())});
        bkg();
        ArrayList arrayList = new ArrayList();
        Iterator it = this.lHw.iterator();
        while (it.hasNext()) {
            l = (Long) it.next();
            if (!ei(l.longValue())) {
                arrayList.add(l);
            }
        }
        it = arrayList.iterator();
        while (it.hasNext()) {
            this.lHw.remove((Long) it.next());
        }
        arrayList.clear();
        it = this.lHx.iterator();
        while (it.hasNext()) {
            l = (Long) it.next();
            if (!ei(l.longValue())) {
                arrayList.add(l);
            }
        }
        Iterator it2 = arrayList.iterator();
        while (it2.hasNext()) {
            this.lHx.remove((Long) it2.next());
        }
        x.d("MicroMsg.AbstractSendMsgFailNotification", "checkMsgExistAfterResend, after check, mMsgList.size:%d, mSuccessList.size:%d, mFailList.size:%d", new Object[]{Integer.valueOf(this.lHt.lHE.size()), Integer.valueOf(this.lHw.size()), Integer.valueOf(this.lHx.size())});
        if (this.lHx.size() <= 0 || VERSION.SDK_INT < 16) {
            b.ug(getType());
        }
        h.mEJ.h(11425, new Object[]{Integer.valueOf(getType()), Integer.valueOf(0), Integer.valueOf(this.lHw.size()), Integer.valueOf(this.lHx.size())});
        if (VERSION.SDK_INT >= 16) {
            this.lHu.bkD();
            this.lHu.lIr = ue(this.lHt.lHE.size());
            FailSendMsgNotification failSendMsgNotification = this.lHu;
            this.lHt.lHE.size();
            failSendMsgNotification.IU(dd(this.lHw.size(), this.lHx.size()));
            this.lHu.bkC();
            if (this.lHx.size() > 0) {
                this.lHu.bkE();
                this.lHu.show();
                bkl();
                bkn();
            }
        }
        kf kfVar = new kf();
        kfVar.bUC.type = getType();
        com.tencent.mm.sdk.b.a.sFg.m(kfVar);
        if (this.lHA != null) {
            this.lHA.SO();
        } else {
            x.e("MicroMsg.AbstractSendMsgFailNotification", "stopCheckMsgExistTimer error, timer is null");
        }
        bkh();
        com.tencent.mm.sdk.b.a.sFg.c(this.lHB);
        bke();
    }

    public void bke() {
    }

    public final void bkf() {
        x.d("MicroMsg.AbstractSendMsgFailNotification", "resendAllMsg, mMsgList.size:%d", new Object[]{Integer.valueOf(this.lHt.lHE.size())});
        this.lHv = true;
        if (VERSION.SDK_INT >= 16) {
            FailSendMsgNotification failSendMsgNotification = this.lHu;
            failSendMsgNotification.lIy = false;
            failSendMsgNotification.lIk = new d(failSendMsgNotification.mContext);
            failSendMsgNotification.bkB();
            failSendMsgNotification.show();
            x.d("MicroMsg.FailSendMsgNotification", "FailSendMsgNotification, removeActionButton");
            failSendMsgNotification = this.lHu;
            failSendMsgNotification.lIk.j(2, true);
            failSendMsgNotification.lIx = true;
            failSendMsgNotification.show();
            x.d("MicroMsg.FailSendMsgNotification", "FailSendMsgNotification, setLockInNotificationBar");
            this.lHu.IU(dc(this.lHt.lHE.size(), 0));
        }
        this.lHt.currentIndex = 0;
        bkh();
        com.tencent.mm.sdk.b.a.sFg.c(this.lHB);
        com.tencent.mm.sdk.b.a.sFg.b(this.lHB);
        eg(this.lHt.bks());
        if (this.lHA != null) {
            this.lHA.J(300000, 300000);
        } else {
            x.e("MicroMsg.AbstractSendMsgFailNotification", "startCheckMsgExistTimer error, timer is null");
        }
    }

    final void bkg() {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < this.lHt.lHE.size(); i++) {
            long j = this.lHt.get(i);
            if (!ei(j)) {
                arrayList.add(Long.valueOf(j));
            }
        }
        if (arrayList.size() > 0) {
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                this.lHt.remove(((Long) it.next()).longValue());
            }
        }
    }

    final void eg(long j) {
        ah.i(new 7(this, j), 200);
    }

    private void bkh() {
        Iterator it = this.lHz.iterator();
        while (it.hasNext()) {
            ((al) it.next()).SO();
        }
        this.lHz.clear();
        this.lHy.clear();
    }

    public final void bki() {
        x.d("MicroMsg.AbstractSendMsgFailNotification", "omitFailMsg, size:%d", new Object[]{Integer.valueOf(this.lHt.lHE.size())});
        if (this.lHt.lHE.size() > 0) {
            b bVar = this.lHt;
            ArrayList arrayList = new ArrayList();
            Iterator it = bVar.lHE.iterator();
            while (it.hasNext()) {
                arrayList.add(Long.valueOf(((Long) it.next()).longValue()));
            }
            I(arrayList);
        }
    }

    private void aXL() {
        this.lHt.clear();
        this.lHv = false;
        this.lHw.clear();
        this.lHx.clear();
        bkh();
    }

    private String bkj() {
        StringBuilder stringBuilder = new StringBuilder("");
        for (int i = 0; i < this.lHt.lHE.size(); i++) {
            stringBuilder.append(this.lHt.get(i) + ", ");
        }
        return stringBuilder.toString();
    }

    public final FailSendMsgNotification bkk() {
        return this.lHu;
    }

    private void bkl() {
        this.lHt.currentIndex = 0;
        if (this.lHw.size() > 0) {
            Iterator it = this.lHw.iterator();
            while (it.hasNext()) {
                this.lHt.remove(((Long) it.next()).longValue());
            }
        }
        this.lHw.clear();
        this.lHx.clear();
    }

    protected final void bkm() {
        if (this.lHt == null || this.lHt.lHE.size() == 0) {
            x.d("MicroMsg.AbstractSendMsgFailNotification", "autoResumeFromCrash");
            com.tencent.mm.plugin.notification.d.b.a uf = b.uf(getType());
            if (uf == null) {
                x.e("MicroMsg.AbstractSendMsgFailNotification", "resetNotificationAfterCrash, cacheObj is null");
                return;
            }
            if (this.lHA == null) {
                bka();
            }
            b bVar = uf.lHG;
            Collection collection = uf.lHI;
            Collection collection2 = uf.lHJ;
            int i = uf.lHH;
            if (collection.size() == 0 && collection2.size() == 0 && i == 0) {
                x.d("MicroMsg.AbstractSendMsgFailNotification", "resetNotificationAfterCrash, not start resend");
                this.lHt.clear();
                this.lHt = bVar;
                this.lHw.clear();
                this.lHx.clear();
                bkb();
            } else if (collection.size() + collection2.size() >= bVar.lHE.size()) {
                x.d("MicroMsg.AbstractSendMsgFailNotification", "resetNotificationAfterCrash, resendFinish");
                bkd();
            } else {
                x.d("MicroMsg.AbstractSendMsgFailNotification", "resetNotificationAfterCrash, currently resending");
                this.lHt.clear();
                this.lHt = bVar;
                this.lHt.currentIndex = i;
                this.lHw.clear();
                this.lHw.addAll(collection);
                this.lHx.clear();
                this.lHx.addAll(collection2);
                bkc();
            }
        }
    }

    private void bkn() {
        b.a(getType(), new com.tencent.mm.plugin.notification.d.b.a(this.lHt, this.lHt.currentIndex, this.lHw, this.lHx));
    }
}
