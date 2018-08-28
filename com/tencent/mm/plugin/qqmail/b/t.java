package com.tencent.mm.plugin.qqmail.b;

import com.tencent.mm.model.au;
import com.tencent.mm.plugin.qqmail.b.v.e;
import com.tencent.mm.plugin.qqmail.b.v.f;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public final class t {
    ArrayList<u> mdt = new ArrayList();
    v mdu = w.box();
    s mdv = null;
    boolean mdw = false;
    f mdx = new f() {
        public final void ab(String str, int i, int i2) {
            if (i == i2) {
                x.i("MicroMsg.ShareMailQueue", "finished one job, queue.size = %d", new Object[]{Integer.valueOf(t.this.mdt.size())});
                if (t.this.mdv != null) {
                    t.this.mdv.JV(str);
                }
                if (t.this.mdt.size() > 0) {
                    x.i("MicroMsg.ShareMailQueue", "continue to send next mail");
                    t.this.b((u) t.this.mdt.remove(0));
                    t.this.mdu.a(this, t.this.mdy);
                    return;
                }
                x.i("MicroMsg.ShareMailQueue", "finished sent all mails");
                t.this.mdw = false;
            }
        }
    };
    e mdy = new e() {
        public final void JX(String str) {
            if (t.this.mdv != null) {
                s sVar = t.this.mdv;
                if (bi.oW(str)) {
                    x.w("MicroMsg.ShareMailInfoMgr", "notify fail error, subject is null");
                } else {
                    s.JW(str);
                    sVar.JV(str);
                }
            }
            if (t.this.mdt.size() > 0) {
                x.i("MicroMsg.ShareMailQueue", "continue to send next mail");
                t.this.b((u) t.this.mdt.remove(0));
                t.this.mdu.a(t.this.mdx, this);
                return;
            }
            x.i("MicroMsg.ShareMailQueue", "final job fail");
            t.this.mdw = false;
        }
    };

    public final void a(u uVar) {
        if (au.HX()) {
            if (this.mdv == null) {
                this.mdv = new s();
            }
            s sVar = this.mdv;
            String str = uVar.mck;
            if (bi.oW(str)) {
                x.w("MicroMsg.ShareMailInfoMgr", "add info fail, info is null");
            } else {
                q qVar = new q();
                qVar.mck = str;
                sVar.mds.lap.add(qVar);
                sVar.save();
            }
            this.mdt.add(uVar);
            x.d("MicroMsg.ShareMailQueue", "add a new job, queue.size: %d", new Object[]{Integer.valueOf(this.mdt.size())});
            if (!this.mdw) {
                x.d("MicroMsg.ShareMailQueue", "start execute");
                if (this.mdt.size() > 0) {
                    this.mdw = true;
                    b((u) this.mdt.remove(0));
                    this.mdu.a(this.mdx, this.mdy);
                }
            }
        }
    }

    final void b(u uVar) {
        v vVar = this.mdu;
        vVar.mdJ.clear();
        vVar.mcP = null;
        vVar.mdL = 0;
        vVar.mdN = null;
        vVar.mdO = null;
        vVar.mdP.clear();
        vVar.mdM.clear();
        vVar.bSS = null;
        vVar.mdI.clear();
        vVar.mdB.clear();
        vVar.mdA = null;
        vVar.mck = null;
        vVar.mdS = 0;
        vVar.mcN = null;
        vVar.mdC.clear();
        vVar.mdG.clear();
        vVar.mdK.clear();
        vVar.mdH = null;
        vVar.mdy = null;
        this.mdu.bSS = uVar.bSS;
        this.mdu.mck = uVar.mck;
        this.mdu.mcN = uVar.mcN;
        this.mdu.mcO = uVar.mcO;
        this.mdu.mdA = uVar.mdA;
        vVar = this.mdu;
        Map map = uVar.mdB;
        vVar.mdB = new HashMap();
        vVar.mdB.putAll(map);
        vVar = this.mdu;
        map = uVar.mdC;
        vVar.mdC = new LinkedHashMap();
        vVar.mdC.putAll(map);
        vVar = this.mdu;
        map = uVar.mdD;
        vVar.mdD = new LinkedHashMap();
        vVar.mdD.putAll(map);
    }
}
