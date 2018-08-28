package com.tencent.mm.plugin.sns.a.b;

import android.os.SystemClock;
import com.tencent.mm.plugin.sns.a.b.a.a;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.Iterator;
import java.util.LinkedList;

public final class h {
    public String TAG = "MicroMsg.SnsAdVideoStatistic";
    public long egO = 0;
    public long egP = 0;
    public int njk = 0;
    public int njl = 0;
    public long njm = 0;
    public int njn = 0;
    public int njo = 0;
    public int njp = 0;
    public int njq = 0;
    public boolean njr = false;
    public a njs = new a();
    public LinkedList<a> njt = new LinkedList();
    public long nju = 0;

    public h(String str) {
        this.TAG = "MicroMsg.SnsAdVideoStatistic:" + str;
    }

    public final void wh(int i) {
        if (this.njs.nkq <= 0) {
            this.njs.nkq = this.njs.nku == 0 ? 0 : (int) bi.bI(this.njs.nku);
        }
        if (i != 0) {
            this.njs.nkr = i;
            this.nju = (long) i;
        }
        x.i(this.TAG, "pushplayitem duration " + this.njs.nkq + " " + this.njs.nkt);
        this.njt.add(this.njs);
        this.njs = new a();
    }

    public final String bwN() {
        int i;
        LinkedList linkedList;
        a aVar;
        if (this.njm == 0) {
            i = 0;
        } else {
            i = (int) bi.bI(this.njm);
        }
        this.njl = i;
        x.d(this.TAG, "__staytotaltime " + this.njm + " " + this.njl + " clock: " + SystemClock.elapsedRealtime());
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("<viewinfo>");
        stringBuffer.append("<downloadstatus>");
        stringBuffer.append(this.njk);
        stringBuffer.append("</downloadstatus>");
        stringBuffer.append("<staytotaltime>");
        stringBuffer.append(this.njl);
        stringBuffer.append("</staytotaltime>");
        if (this.njn > 0) {
            stringBuffer.append("<masktotaltime>");
            stringBuffer.append(this.njn);
            stringBuffer.append("</masktotaltime>");
        }
        LinkedList linkedList2 = this.njt;
        if (!this.njr || this.njt.size() <= 1) {
            linkedList = linkedList2;
        } else {
            a aVar2 = new a();
            for (int i2 = 0; i2 < this.njt.size(); i2++) {
                aVar = (a) this.njt.get(i2);
                if (i2 == 0) {
                    aVar2.nkr = aVar.nkr;
                    aVar2.nks = aVar.nks;
                    aVar2.nkt = aVar.nkt;
                }
                aVar2.nkp += aVar.nkp;
                aVar2.nkq = aVar.nkq + aVar2.nkq;
            }
            linkedList2 = new LinkedList();
            linkedList2.add(aVar2);
            linkedList = linkedList2;
        }
        stringBuffer.append(String.format("<playitemlist count=\"%d\">", new Object[]{Integer.valueOf(linkedList.size())}));
        for (int i3 = 0; i3 < linkedList.size(); i3++) {
            aVar = (a) linkedList.get(i3);
            stringBuffer.append("<playitem>");
            stringBuffer.append(String.format("<playcount>%d</playcount>", new Object[]{Integer.valueOf(aVar.nkp)}));
            stringBuffer.append(String.format("<playtotaltime>%d</playtotaltime>", new Object[]{Integer.valueOf(aVar.nkq)}));
            stringBuffer.append(String.format("<videototaltime>%d</videototaltime>", new Object[]{Integer.valueOf(aVar.nkr * 1000)}));
            stringBuffer.append(String.format("<playmode>%d</playmode>", new Object[]{Integer.valueOf(aVar.nks)}));
            stringBuffer.append(String.format("<playorientation>%d</playorientation>", new Object[]{Integer.valueOf(aVar.nkt)}));
            stringBuffer.append("</playitem>");
        }
        stringBuffer.append("</playitemlist>");
        stringBuffer.append("</viewinfo>");
        String stringBuffer2 = stringBuffer.toString();
        x.i(this.TAG, "xml " + stringBuffer2);
        return stringBuffer2;
    }

    public final void bwO() {
        this.njo = 0;
        this.njp = 0;
        this.njq = 0;
        Iterator it = this.njt.iterator();
        while (it.hasNext()) {
            a aVar = (a) it.next();
            this.njo += aVar.nko;
            this.njp += aVar.nkp;
            this.njq = aVar.nkq + this.njq;
        }
        if (this.njs != null && !this.njt.contains(this.njs)) {
            this.njo += this.njs.nko;
            this.njp += this.njs.nkp;
            this.njq += this.njs.nkq;
        }
    }

    public final void onResume() {
        if (this.egO != 0) {
            long bI = bi.bI(this.egO);
            this.egP += bI;
            this.egO = 0;
            if (this.njs != null) {
                a aVar = this.njs;
                aVar.nkv = bI + aVar.nkv;
            }
        }
    }
}
