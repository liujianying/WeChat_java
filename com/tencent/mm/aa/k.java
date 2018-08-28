package com.tencent.mm.aa;

import android.database.Cursor;
import com.tencent.mm.a.f;
import com.tencent.mm.bt.h;
import com.tencent.mm.hardcoder.HardCoderJNI;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.List;
import junit.framework.Assert;

public final class k extends j {
    public static final String[] diD = new String[]{"CREATE TABLE IF NOT EXISTS img_flag ( username VARCHAR(40) PRIMARY KEY , imgflag int , lastupdatetime int , reserved1 text ,reserved2 text ,reserved3 int ,reserved4 int )", "CREATE INDEX IF NOT EXISTS img_flag_small_url_index ON img_flag ( reserved2 )"};
    h dCZ;
    final f<String, j> dHU = new f(HardCoderJNI.sHCQUITCHATTINGTIMEOUT);

    public k(h hVar) {
        this.dCZ = hVar;
    }

    public final j kc(String str) {
        j jVar = (j) this.dHU.get(str);
        if (jVar != null && jVar.getUsername().equals(str)) {
            return jVar;
        }
        Cursor b = this.dCZ.b("select img_flag.username,img_flag.imgflag,img_flag.lastupdatetime,img_flag.reserved1,img_flag.reserved2,img_flag.reserved3,img_flag.reserved4 from img_flag where img_flag.username=\"" + bi.oU(str) + "\"", null, 2);
        if (b == null) {
            return null;
        }
        if (b.moveToFirst()) {
            jVar = new j();
            jVar.d(b);
        } else {
            jVar = null;
        }
        b.close();
        this.dHU.m(str, jVar);
        return jVar;
    }

    public final boolean a(j jVar) {
        boolean z;
        x.i("MicroMsg.ImgFlagStorage", "new smallImageUrl = %s, bigImageUrl = %s", jVar.Ky(), jVar.Kx());
        if (kc(jVar.getUsername()) == null) {
            this.dHU.m(jVar.getUsername(), jVar);
            if (jVar == null || jVar.getUsername() == null) {
                z = false;
            } else {
                z = true;
            }
            Assert.assertTrue(z);
            jVar.dHP = (int) (System.currentTimeMillis() / 1000);
            jVar.Kz();
            jVar.bWA = -1;
            z = ((int) this.dCZ.insert("img_flag", "username", jVar.Kw())) >= 0;
            if (z) {
                b(jVar.getUsername(), 2, jVar.getUsername());
            }
        } else {
            x.i("MicroMsg.ImgFlagStorage", "old, smallImageUrl = %s, bigImageUrl = %s", kc(jVar.getUsername()).Ky(), kc(jVar.getUsername()).Kx());
            this.dHU.remove(jVar.getUsername());
            z = (jVar == null || jVar.getUsername() == null) ? false : true;
            Assert.assertTrue(z);
            jVar.dHP = (int) (System.currentTimeMillis() / 1000);
            jVar.bWA |= 4;
            z = this.dCZ.update("img_flag", jVar.Kw(), "username=?", new String[]{new StringBuilder().append(jVar.getUsername()).toString()}) > 0;
            if (z) {
                b(jVar.getUsername(), 3, jVar.getUsername());
            }
        }
        return z;
    }

    public final boolean L(List<j> list) {
        if (list.size() == 0) {
            return false;
        }
        boolean z;
        long dO = this.dCZ.dO(Thread.currentThread().getId());
        int i = 0;
        while (i < list.size()) {
            try {
                a((j) list.get(i));
                i++;
            } catch (Exception e) {
                x.e("MicroMsg.ImgFlagStorage", e.getMessage());
                z = false;
            }
        }
        z = true;
        this.dCZ.gp(dO);
        return z;
    }

    public final void kd(String str) {
        if (!bi.oW(str)) {
            this.dHU.remove(str);
            this.dCZ.delete("img_flag", "username=?", new String[]{str});
        }
    }
}
