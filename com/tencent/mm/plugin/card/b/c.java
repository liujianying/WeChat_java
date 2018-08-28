package com.tencent.mm.plugin.card.b;

import android.text.TextUtils;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.card.model.ac;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.x;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public final class c implements e {
    List<WeakReference<a>> htB = new ArrayList();
    String htC = "";
    public LinkedList<String> htD = new LinkedList();
    public int htE;
    private int htF;
    private int htG;
    private int htH;
    private int htI = 60;
    private boolean htJ = false;
    private al htK = new al(new 1(this), false);
    private al htL = new al(new 2(this), false);

    public final void release() {
        g.Eh().dpP.b(577, this);
        this.htD.clear();
        this.htJ = false;
        this.htC = "";
        this.htE = 0;
        this.htF = 0;
        this.htG = 0;
        this.htH = 0;
        awB();
        awD();
    }

    public final void a(a aVar) {
        if (this.htB == null) {
            this.htB = new ArrayList();
        }
        if (aVar != null) {
            this.htB.add(new WeakReference(aVar));
        }
    }

    public final void b(a aVar) {
        if (this.htB != null && aVar != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.htB.size()) {
                    WeakReference weakReference = (WeakReference) this.htB.get(i2);
                    if (weakReference != null) {
                        a aVar2 = (a) weakReference.get();
                        if (aVar2 != null && aVar2.equals(aVar)) {
                            this.htB.remove(weakReference);
                            return;
                        }
                    }
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }
    }

    private void onSuccess() {
        x.i("MicroMsg.CardCodeMgr", "onSuccess()");
        if (this.htB != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.htB.size()) {
                    WeakReference weakReference = (WeakReference) this.htB.get(i2);
                    if (weakReference != null) {
                        a aVar = (a) weakReference.get();
                        if (aVar != null) {
                            aVar.onSuccess();
                        }
                    }
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }
    }

    private void xb(String str) {
        x.i("MicroMsg.CardCodeMgr", "onFail()");
        if (this.htB != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.htB.size()) {
                    WeakReference weakReference = (WeakReference) this.htB.get(i2);
                    if (weakReference != null) {
                        a aVar = (a) weakReference.get();
                        if (aVar != null) {
                            aVar.xb(str);
                        }
                    }
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }
    }

    public final String getCode() {
        if (this.htD == null || this.htD.size() == 0) {
            x.e("MicroMsg.CardCodeMgr", "getCode, codes is empty");
            return "";
        } else if (this.htE >= this.htD.size()) {
            x.e("MicroMsg.CardCodeMgr", "getCode, all codes has show! ");
            xc(this.htC);
            return "";
        } else {
            if (this.htG >= this.htD.size() - this.htE) {
                x.i("MicroMsg.CardCodeMgr", "do request code, because the request_count >= than (codes.size() - show_count)");
                xc(this.htC);
            }
            x.i("MicroMsg.CardCodeMgr", "getCode, show_count:" + this.htE + " request_count:" + this.htG + " codes size:" + this.htD.size());
            LinkedList linkedList = this.htD;
            int i = this.htE;
            this.htE = i + 1;
            return (String) linkedList.get(i);
        }
    }

    public final boolean isEmpty() {
        if (this.htD == null || this.htD.size() == 0) {
            x.e("MicroMsg.CardCodeMgr", "getCode, codes is empty");
            return true;
        } else if (this.htE < this.htD.size()) {
            return false;
        } else {
            x.e("MicroMsg.CardCodeMgr", "getCode, all codes has show! ");
            return true;
        }
    }

    public final void xc(String str) {
        if (this.htJ) {
            x.e("MicroMsg.CardCodeMgr", "doGetCardCodes(), is doing get codes");
        } else if (TextUtils.isEmpty(str)) {
            x.e("MicroMsg.CardCodeMgr", "doGetCardCodes(), mCardId is empty!");
        } else {
            x.i("MicroMsg.CardCodeMgr", "doGetCardCodes() do get codes, card id " + str);
            this.htJ = true;
            this.htC = str;
            g.Eh().dpP.a(new ac(this.htC), 0);
        }
    }

    public final void a(int i, int i2, String str, l lVar) {
        x.i("MicroMsg.CardCodeMgr", "onSceneEnd, errType = " + i + " errCode = " + i2);
        if (i == 0 && i2 == 0) {
            if (lVar instanceof ac) {
                this.htJ = false;
                x.e("MicroMsg.CardCodeMgr", "get codes success for card id " + this.htC);
                ac acVar = (ac) lVar;
                this.htF = acVar.htF;
                this.htG = acVar.htG;
                this.htH = acVar.htH;
                if (acVar.htD != null) {
                    this.htD.clear();
                    this.htD.addAll(acVar.htD);
                    this.htE = 0;
                }
                onSuccess();
                awA();
                if (this.htH != 0) {
                    awC();
                }
            }
        } else if (lVar instanceof ac) {
            this.htJ = false;
            x.e("MicroMsg.CardCodeMgr", "get codes failed  for card id " + this.htC);
            xb(str);
        }
    }

    public final void awA() {
        awB();
        x.i("MicroMsg.CardCodeMgr", "startRequestCodeTimer() request_time:" + this.htF);
        if (this.htF <= 0 || TextUtils.isEmpty(this.htC)) {
            x.e("MicroMsg.CardCodeMgr", "not to start request code timer!");
            return;
        }
        long j = (long) (this.htF * 1000);
        this.htK.J(j, j);
        x.i("MicroMsg.CardCodeMgr", "start request code timer!");
    }

    private void awB() {
        x.i("MicroMsg.CardCodeMgr", "stopRequestCodeTimer!");
        if (!this.htK.ciq()) {
            this.htK.SO();
        }
    }

    public final void awC() {
        awD();
        x.i("MicroMsg.CardCodeMgr", "startRefreshCodeTimer() refresh_interval:" + this.htH);
        long j;
        if (this.htH > 0) {
            j = (long) (this.htH * 1000);
            this.htL.J(j, j);
            x.i("MicroMsg.CardCodeMgr", "start refresh code timer!");
            return;
        }
        j = (long) (this.htI * 1000);
        this.htL.J(j, j);
        x.e("MicroMsg.CardCodeMgr", "not to start refresh code timer!");
    }

    public final void awD() {
        x.i("MicroMsg.CardCodeMgr", "stopRefreshCodeTimer()!");
        if (!this.htL.ciq()) {
            this.htL.SO();
        }
    }
}
