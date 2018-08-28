package com.tencent.mm.plugin.bottle.a;

import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.model.au;
import com.tencent.mm.plugin.bottle.a;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.bl;
import com.tencent.mm.sdk.platformtools.x;
import java.util.Map;
import junit.framework.Assert;

public final class h {

    public static class b implements e {
        public int hjQ = -10001;
        public String hjV;
        private a hka = null;
        public String hkb = "";
        public final f hkc = new f();
        public String iconUrl = "";

        public final boolean a(a aVar) {
            x.d("MicroMsg.PickBottle", "bottle pick:" + c.aud() + " throw:" + c.auc());
            Assert.assertTrue("renew this class", this.hka == null);
            Assert.assertTrue("must call back onFin", true);
            if (c.aud() <= 0) {
                aVar.ci(1, 16);
                return false;
            }
            au.DF().a(155, this);
            au.DF().a(156, this);
            this.hka = aVar;
            return au.DF().a(this.hkc, 0);
        }

        public final void a(int i, int i2, String str, l lVar) {
            x.d("MicroMsg.PickBottle", "type:" + lVar.getType() + " errType:" + i + " errCode:" + i2);
            if (lVar.getType() == 155) {
                f fVar = (f) lVar;
                if (fVar.hjY) {
                    au.DF().b(155, this);
                    a.ezo.vl();
                    this.hjV = fVar.auh().say == null ? "" : fVar.auh().say;
                    this.hjQ = fVar.auh().jQd;
                    Map z = bl.z(fVar.auh().rIk == null ? "" : fVar.auh().rIk, "branduser");
                    if (z != null) {
                        this.hkb = (String) z.get(".branduser.$username");
                        this.iconUrl = (String) z.get(".branduser.$iconurl");
                        if (this.hkb != null) {
                            this.hjQ = 19990;
                            if (this.hka != null) {
                                if (i == 0 && i2 == 0) {
                                    this.hka.ci(i, i2);
                                } else {
                                    this.hka.ci(i, i2);
                                }
                            }
                            this.hka = null;
                            return;
                        }
                    }
                    au.DF().a(new e(this.hjV, this.hjQ), 0);
                    return;
                }
                if (this.hka != null) {
                    this.hka.ci(i, i2);
                }
                this.hka = null;
                au.DF().b(155, this);
                au.DF().b(156, this);
            } else if (lVar.getType() == 156) {
                au.DF().b(156, this);
                if (this.hka != null) {
                    if (i == 0 && i2 == 0) {
                        this.hka.ci(i, i2);
                    } else {
                        this.hka.ci(i, i2);
                    }
                }
                this.hka = null;
            }
        }
    }

    public static class c implements e {
        private a hka = null;
        private int hkd = 0;

        public c(String str, a aVar) {
            boolean z;
            Assert.assertTrue("emtpy input text", !bi.oW(str));
            String str2 = "must call back onFin";
            if (aVar != null) {
                z = true;
            } else {
                z = false;
            }
            Assert.assertTrue(str2, z);
            if (c.auc() > 0) {
                au.DF().a(154, this);
                this.hka = aVar;
                au.DF().a(new g(str), 0);
            } else if (aVar != null) {
                aVar.ci(1, 16);
            }
        }

        public final void a(int i, int i2, String str, l lVar) {
            if (lVar.getType() == 154) {
                if (this.hka != null) {
                    this.hkd = ((g) lVar).aui();
                    this.hka.ci(i, i2);
                }
                this.hka = null;
                au.DF().b(154, this);
            }
        }
    }
}
