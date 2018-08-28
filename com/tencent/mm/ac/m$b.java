package com.tencent.mm.ac;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.am;
import com.tencent.mm.network.b;
import com.tencent.mm.sdk.platformtools.at.a;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.c;
import com.tencent.mm.sdk.platformtools.x;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;

class m$b implements a {
    public byte[] dHe = null;
    private final String dMB;
    private final String url;

    public m$b(String str, String str2) {
        this.dMB = str;
        this.url = str2;
    }

    public final boolean Kr() {
        if (bi.oW(this.dMB) || bi.oW(this.url)) {
            return false;
        }
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            InputStream n = b.n(this.url, 3000, 5000);
            if (n == null) {
                return false;
            }
            byte[] bArr = new byte[1024];
            while (true) {
                int read = n.read(bArr);
                if (read == -1) {
                    break;
                }
                byteArrayOutputStream.write(bArr, 0, read);
            }
            n.close();
            this.dHe = byteArrayOutputStream.toByteArray();
            byteArrayOutputStream.close();
            if (bi.bC(this.dHe)) {
                x.e("MicroMsg.BrandLogic", "imgBuff null brand:" + this.dMB);
                return false;
            }
            if (g.Eg().Dx()) {
                am.a.dBs.aY(this.dHe.length, 0);
                m.a Ni = z.Ni();
                String str = this.dMB;
                String str2 = this.url;
                byte[] bArr2 = this.dHe;
                try {
                    str2 = str + str2;
                    Bitmap bs = c.bs(bArr2);
                    c.a(bs, 100, CompressFormat.PNG, m.a.kW(str2), false);
                    Ni.g(str, bs);
                    x.i("MicroMsg.BrandLogic", "update brand icon for  " + str + ", done");
                    Ni.dMy.remove(str);
                } catch (Throwable e) {
                    x.e("MicroMsg.BrandLogic", "exception:%s", new Object[]{bi.i(e)});
                }
            }
            return true;
        } catch (Throwable e2) {
            x.e("MicroMsg.BrandLogic", "exception:%s", new Object[]{bi.i(e2)});
            x.e("MicroMsg.BrandLogic", "get url:" + this.url + " failed.");
            this.dHe = null;
            return false;
        }
    }

    public final boolean Ks() {
        m.a Ni = z.Ni();
        String str = this.dMB;
        int i = 0;
        while (i < Ni.dMx.size()) {
            try {
                ((m$a$a) Ni.dMx.get(i)).kX(str);
                i++;
            } catch (Throwable e) {
                x.e("MicroMsg.BrandLogic", "exception:%s", new Object[]{bi.i(e)});
            }
        }
        return false;
    }
}
