package com.tencent.mm.plugin.sns.ui;

import android.os.Process;
import android.view.View;
import android.widget.ListView;
import com.tencent.mm.hardcoder.HardCoderJNI;
import com.tencent.mm.plugin.sns.i.f;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.plugin.sns.model.am;
import com.tencent.mm.plugin.sns.storage.n;
import com.tencent.mm.plugin.sns.ui.bb.a;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.MMPullDownView;
import com.tencent.tmassistantsdk.common.TMAssistantDownloadSDKErrorCode;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

class SnsUserUI$10 implements a {
    final /* synthetic */ SnsUserUI ohd;

    SnsUserUI$10(SnsUserUI snsUserUI) {
        this.ohd = snsUserUI;
    }

    public final void bDY() {
        if (SnsUserUI.b(this.ohd) == null) {
            SnsUserUI.a(this.ohd, af.bye());
        }
        am.a b = SnsUserUI.b(this.ohd);
        String c = SnsUserUI.c(this.ohd);
        SnsUserUI.d(this.ohd);
        b.b(2, c, SnsUserUI.f(this.ohd), SnsUserUI.e(this.ohd));
        af.aRu().postDelayed(SnsUserUI.g(this.ohd), 3000);
    }

    public final ListView bDZ() {
        return (ListView) this.ohd.findViewById(f.sns_photo_list);
    }

    public final View bEa() {
        return this.ohd.findViewById(f.content_root);
    }

    public final View bEb() {
        return this.ohd.findViewById(f.sns_cover_shadow);
    }

    public final MMPullDownView bEc() {
        return (MMPullDownView) this.ohd.findViewById(f.sns_pull_down_view);
    }

    public final int getType() {
        return 2;
    }

    public final void a(int i, List<Integer> list, List<Integer> list2) {
        at a;
        if (!(i == -1 || SnsUserUI.a(this.ohd) == null)) {
            a = SnsUserUI.a(this.ohd);
            if (a.nZG != null) {
                au auVar = a.nZG;
                n xd = af.byo().xd(i);
                if (!(xd == null || xd.bAJ().sqc == null || auVar.list.size() <= 0)) {
                    auVar.list.add(1, xd);
                    auVar.bDK();
                    auVar.bDL();
                }
            }
        }
        if (SnsUserUI.a(this.ohd) != null && list != null && list2 != null) {
            a = SnsUserUI.a(this.ohd);
            if (a.nZG != null && list != null && list2 != null && list.size() + list2.size() != 0) {
                int i2;
                n nVar;
                au auVar2 = a.nZG;
                if (!(list == null || list.size() == 0)) {
                    x.d("MicroMsg.SnsSelfHelper", "remove Items");
                    for (Integer intValue : list) {
                        int intValue2 = intValue.intValue();
                        int size = auVar2.list.size();
                        for (i2 = 1; i2 < size; i2++) {
                            nVar = (n) auVar2.list.get(i2);
                            if (nVar != null && nVar.nJc == intValue2) {
                                auVar2.list.remove(i2);
                                break;
                            }
                        }
                    }
                }
                if (!(list2 == null || list2.size() == 0)) {
                    x.d("MicroMsg.SnsSelfHelper", "change Items");
                    LinkedList linkedList = new LinkedList();
                    i2 = 1;
                    while (i2 < auVar2.list.size()) {
                        nVar = (n) auVar2.list.get(i2);
                        if (nVar != null) {
                            for (Integer intValue3 : list2) {
                                int intValue4 = intValue3.intValue();
                                if (nVar.nJc == intValue4) {
                                    x.d("MicroMsg.SnsSelfHelper", "update list localId " + intValue4);
                                    auVar2.list.remove(i2);
                                    linkedList.add(af.byo().xd(intValue4));
                                    i2--;
                                    break;
                                }
                            }
                        }
                        i2++;
                    }
                    Iterator it = linkedList.iterator();
                    while (it.hasNext()) {
                        auVar2.list.add((n) it.next());
                    }
                }
                auVar2.bDK();
                auVar2.bDL();
            }
        }
    }

    public final boolean bEd() {
        return false;
    }

    public final void bEe() {
        am.a b = SnsUserUI.b(this.ohd);
        String c = SnsUserUI.c(this.ohd);
        SnsUserUI.d(this.ohd);
        b.a(2, c, SnsUserUI.f(this.ohd), SnsUserUI.e(this.ohd));
    }

    public final void bEf() {
    }

    public final void xA(int i) {
        x.i("MicroMsg.SnsUserUI", "onListViewScoll %s", new Object[]{Integer.valueOf(i)});
        if (i == 2) {
            HardCoderJNI.stopPerformace(HardCoderJNI.hcSNSUserScrollEnable, SnsUserUI.h(this.ohd));
            SnsUserUI.a(this.ohd, HardCoderJNI.startPerformance(HardCoderJNI.hcSNSUserScrollEnable, HardCoderJNI.hcSNSUserScrollDelay, HardCoderJNI.hcSNSUserScrollCPU, HardCoderJNI.hcSNSUserScrollIO, HardCoderJNI.hcSNSUserScrollThr ? Process.myTid() : 0, HardCoderJNI.hcSNSUserScrollTimeout, TMAssistantDownloadSDKErrorCode.DownloadSDKErrorCode_PARSER_CONTENT_FAILED, HardCoderJNI.hcSNSUserScrollAction, "MicroMsg.SnsUserUI"));
            x.i("MicroMsg.SnsUserUI", "summer hardcoder sns startPerformance [%s]", new Object[]{Integer.valueOf(SnsUserUI.h(this.ohd))});
        }
    }

    public final void Q(int i, boolean z) {
        Object obj = null;
        if (SnsUserUI.a(this.ohd) != null) {
            at a = SnsUserUI.a(this.ohd);
            if (a.nZG != null) {
                au auVar = a.nZG;
                n xd = af.byo().xd(i);
                if (xd != null && xd.bAJ().sqc != null && auVar.list.size() > 0) {
                    for (int i2 = 0; i2 < auVar.list.size(); i2++) {
                        if (((n) auVar.list.get(i2)).bBe() == xd.bBe()) {
                            obj = 1;
                            auVar.list.remove(i2);
                            break;
                        }
                    }
                    if (obj != null) {
                        auVar.list.add(xd);
                        auVar.bDK();
                        auVar.bDL();
                    }
                }
            }
        }
    }

    public final void it(boolean z) {
    }
}
