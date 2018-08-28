package com.tencent.mm.plugin.card.b;

import android.text.TextUtils;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.card.sharecard.model.f;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.smtt.utils.TbsLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

public final class j implements e {
    private List<WeakReference<a>> htB = new ArrayList();
    public ArrayList<String> huA = new ArrayList();
    public ag huB = new ag();
    public HashMap<String, Runnable> huC = new LinkedHashMap();
    public ArrayList<String> huz = new ArrayList();

    public j() {
        g.Eh().dpP.a(907, this);
        this.huz.clear();
        this.huA.clear();
        this.huC.clear();
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

    private void a(String str, b bVar) {
        x.i("MicroMsg.CardMarkCodeMgr", "markSuccess()");
        if (this.htB != null) {
            if (this.huz.contains(str) || this.huA.contains(str)) {
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 < this.htB.size()) {
                        WeakReference weakReference = (WeakReference) this.htB.get(i2);
                        if (weakReference != null) {
                            a aVar = (a) weakReference.get();
                            if (aVar != null) {
                                if (this.huz.contains(str)) {
                                    aVar.b(str, bVar);
                                } else if (this.huA.contains(str)) {
                                    aVar.xh(str);
                                }
                            }
                        }
                        i = i2 + 1;
                    } else {
                        return;
                    }
                }
            }
            x.i("MicroMsg.CardMarkCodeMgr", "markSuccess the card id is not in mark list and un mark list.");
        }
    }

    private void bY(String str, String str2) {
        x.i("MicroMsg.CardMarkCodeMgr", "onMarkFail()");
        if (this.htB != null) {
            if (!this.huz.contains(str) || this.huA.contains(str)) {
                x.i("MicroMsg.CardMarkCodeMgr", "markSuccess the card is not in mark list");
                return;
            }
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.htB.size()) {
                    WeakReference weakReference = (WeakReference) this.htB.get(i2);
                    if (weakReference != null) {
                        a aVar = (a) weakReference.get();
                        if (aVar != null) {
                            aVar.bZ(str, str2);
                        }
                    }
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }
    }

    private void xf(String str) {
        x.i("MicroMsg.CardMarkCodeMgr", "removeId()");
        if (this.huz.contains(str) && !this.huA.contains(str)) {
            this.huz.remove(str);
            x.i("MicroMsg.CardMarkCodeMgr", "remove mark card id in mMarkList. card is " + str);
        }
        if (!this.huz.contains(str) && this.huA.contains(str)) {
            this.huA.remove(str);
            Runnable runnable = (Runnable) this.huC.get(str);
            this.huC.remove(str);
            this.huB.removeCallbacks(runnable);
            x.i("MicroMsg.CardMarkCodeMgr", "remove unmark card id in mUnMarkList. card is " + str);
            x.i("MicroMsg.CardMarkCodeMgr", "remove unmark card mask id in mId2Runner. card is " + str);
        }
    }

    private void xg(String str) {
        x.i("MicroMsg.CardMarkCodeMgr", "cancelUnmark()");
        if (this.huA.contains(str)) {
            this.huA.remove(str);
            x.i("MicroMsg.CardMarkCodeMgr", "remove unmark card id in mUnMarkList. card is " + str);
        }
        if (this.huC.containsKey(str)) {
            x.i("MicroMsg.CardMarkCodeMgr", "remove unmark card mask id in mId2Runner. card is " + str);
            Runnable runnable = (Runnable) this.huC.get(str);
            this.huC.remove(str);
            this.huB.removeCallbacks(runnable);
        }
    }

    public final void H(String str, int i, int i2) {
        x.i("MicroMsg.CardMarkCodeMgr", "doMarkCode()");
        xg(str);
        if (!this.huz.contains(str)) {
            this.huz.add(str);
        }
        f(str, i, 1, i2);
    }

    public final void aX(final String str, final int i) {
        x.i("MicroMsg.CardMarkCodeMgr", "doUnmarkCode()");
        xg(str);
        this.huA.add(str);
        Runnable anonymousClass1 = new Runnable() {
            final /* synthetic */ int huE = 0;
            final /* synthetic */ int huF = 0;

            public final void run() {
                j.f(str, this.huE, this.huF, i);
                x.i("MicroMsg.CardMarkCodeMgr", "run the unmark task, the card is " + str + " system.time:" + System.currentTimeMillis());
            }
        };
        this.huB.postDelayed(anonymousClass1, (long) (bi.getInt(com.tencent.mm.k.g.AU().G("ShareCard", "UnMarkDelay"), 0) * TbsLog.TBSLOG_CODE_SDK_BASE));
        this.huC.put(str, anonymousClass1);
        x.i("MicroMsg.CardMarkCodeMgr", "add unmark card mask id in mId2Runner. card is " + str + " system.time:" + System.currentTimeMillis());
    }

    static void f(String str, int i, int i2, int i3) {
        if (TextUtils.isEmpty(str)) {
            x.i("MicroMsg.CardMarkCodeMgr", "card_id is empty, don't call NetSceneMarkShareCard cgi");
            return;
        }
        x.i("MicroMsg.CardMarkCodeMgr", "doMarkNetscene()");
        g.Eh().dpP.a(new f(str, i, i2, i3), 0);
    }

    public final void a(int i, int i2, String str, l lVar) {
        x.i("MicroMsg.CardMarkCodeMgr", "onSceneEnd, errType = " + i + " errCode = " + i2);
        f fVar;
        if (i == 0 && i2 == 0) {
            if (lVar instanceof f) {
                fVar = (f) lVar;
                b bVar = new b();
                bVar.huH = fVar.huH;
                bVar.huI = fVar.huI;
                bVar.huJ = fVar.huJ;
                bVar.huK = fVar.huK;
                bVar.huL = fVar.huL;
                x.i("MicroMsg.CardMarkCodeMgr", "onSceneEnd, markSuccess original_card_id = " + fVar.hyn);
                x.i("MicroMsg.CardMarkCodeMgr", "mark_user:" + bVar.huH + " mark_succ:" + bVar.huI + " mark_card_id:" + bVar.huJ + " expire_time:" + bVar.huK + " pay_qrcode_wording:" + bVar.huL);
                a(fVar.hyn, bVar);
                xf(fVar.hyn);
            }
        } else if (lVar instanceof f) {
            fVar = (f) lVar;
            x.i("MicroMsg.CardMarkCodeMgr", "onSceneEnd, markFail original_card_id = " + fVar.hyn);
            bY(fVar.hyn, str);
            xf(fVar.hyn);
        }
    }
}
