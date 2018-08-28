package com.tencent.mm.pluginsdk.model.app;

import android.content.Context;
import android.os.Looper;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ac.b;
import com.tencent.mm.plugin.ac.a;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Vector;

public final class h implements e, b, t {
    Map<String, Integer> fxF;
    private List<String> mTQ;
    private List<String> qzB;
    private al qzC;
    private List<String> qzM;
    private List<String> qzN;
    private volatile boolean qzO;

    public h() {
        this.qzB = null;
        this.mTQ = null;
        this.fxF = null;
        this.qzO = false;
        this.qzC = new al(Looper.getMainLooper(), new 1(this), false);
        this.qzB = new ArrayList();
        this.mTQ = new ArrayList();
        this.fxF = new HashMap();
        this.qzM = new Vector();
        this.qzN = new ArrayList();
        this.qzC.J(600000, 600000);
        g.Eh().dpP.a(231, this);
        a.bmi().a(7, (t) this);
    }

    public final String q(Context context, String str) {
        return g.q(context, str);
    }

    public final void ap(LinkedList<String> linkedList) {
        if (linkedList == null || linkedList.size() == 0) {
            x.e("MicroMsg.AppInfoService", "batch push appinfo err: null or nil applist");
            return;
        }
        Iterator it = linkedList.iterator();
        while (it.hasNext()) {
            ST((String) it.next());
        }
        cbN();
    }

    private synchronized void ST(String str) {
        if (bi.oW(str) || this.qzM.contains(str)) {
            x.i("MicroMsg.AppInfoService", "should not add this appid:[%s], it is already runing", new Object[]{str});
        } else if (SV(str)) {
            x.i("MicroMsg.AppInfoService", "add appid:[%s]", new Object[]{str});
            this.qzM.add(str);
        } else {
            x.e("MicroMsg.AppInfoService", "this app has reach the max retry count, appid is %s", new Object[]{str});
        }
    }

    public final void SU(String str) {
        if (str == null || str.length() == 0) {
            x.e("MicroMsg.AppInfoService", "push fail, appId is null");
            return;
        }
        x.i("MicroMsg.AppInfoService", "push appid : " + str);
        ST(str);
        cbN();
    }

    private void cbN() {
        int i = 20;
        if (this.qzO) {
            x.d("MicroMsg.AppInfoService", " batch get appinfo doing now");
        } else if (this.qzM == null || this.qzM.isEmpty()) {
            x.d("MicroMsg.AppInfoService", "batchwaitinglist is empty, no need to doscene");
        } else {
            int size = this.qzM.size();
            if (size <= 20) {
                i = size;
            }
            synchronized (this) {
                this.qzN.addAll(this.qzM.subList(0, i));
            }
            if (this.qzN != null && !this.qzN.isEmpty()) {
                this.qzO = true;
                g.Eh().dpP.a(new y(7, new ae(this.qzN)), 0);
            }
        }
    }

    private boolean SV(String str) {
        if (str == null) {
            x.e("MicroMsg.AppInfoService", "increaseCounter fail, appId is null");
            return false;
        }
        Integer valueOf = Integer.valueOf(bi.a((Integer) this.fxF.get(str), 0));
        if (valueOf.intValue() >= 5) {
            x.e("MicroMsg.AppInfoService", "increaseCounter fail, has reached the max try count");
            return false;
        }
        this.fxF.put(str, Integer.valueOf(valueOf.intValue() + 1));
        return true;
    }

    public final void a(int i, int i2, String str, l lVar) {
        int type = lVar.getType();
        switch (type) {
            case 231:
                String str2 = ((ad) lVar).appId;
                if (this.qzB.contains(str2)) {
                    this.qzB.remove(str2);
                }
                while (this.mTQ.size() > 0) {
                    boolean z;
                    str2 = (String) this.mTQ.remove(0);
                    if (str2 == null || str2.length() == 0) {
                        x.e("MicroMsg.AppInfoService", "startDownload fail, appId is null");
                        z = false;
                        continue;
                    } else if (SV(str2)) {
                        g.Eh().dpP.a(new ad(str2), 0);
                        z = true;
                        continue;
                    } else {
                        x.e("MicroMsg.AppInfoService", "increaseCounter fail");
                        z = false;
                        continue;
                    }
                    if (z) {
                        this.qzB.add(str2);
                        return;
                    }
                }
                return;
            case 451:
                synchronized (this) {
                    if (!(this.qzN == null || this.qzN.isEmpty())) {
                        this.qzM.removeAll(this.qzN);
                        this.qzN.clear();
                    }
                }
                this.qzO = false;
                cbN();
                return;
            default:
                x.e("MicroMsg.AppInfoService", "error type: " + type);
                return;
        }
    }

    public final void a(int i, int i2, String str, x xVar) {
        if (xVar.getType() != 7) {
            x.d("MicroMsg.AppInfoService", "not the getappinfolist scene, ignore");
            return;
        }
        synchronized (this) {
            if (!(this.qzN == null || this.qzN.isEmpty())) {
                this.qzM.removeAll(this.qzN);
                this.qzN.clear();
            }
        }
        this.qzO = false;
        cbN();
    }
}
