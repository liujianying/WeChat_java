package com.tencent.mm.plugin.facedetect.b;

import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.x;

public final class a implements e {
    public int iLW = -1;
    public d iLX = null;
    public c iLY = null;
    public boolean iLZ = false;
    public boolean iMa = false;
    public long iMb = 0;
    public int iMc = 0;
    public l iMd = null;
    public l iMe = null;
    public long iMf = -1;
    public int iMg = -1;
    public com.tencent.mm.modelcdntran.i.a iMh = new 1(this);

    public a(int i) {
        this.iLW = i;
    }

    public final void aJo() {
        if (this.iMe != null) {
            g.DF().b(this.iMe.getType(), this);
        }
    }

    public final void h(int i, int i2, String str) {
        ah.A(new 2(this, i, i2, str));
    }

    public final void a(int i, int i2, String str, l lVar) {
        boolean z = false;
        x.i("MicroMsg.FaceUploadProcessor", "hy: scene: %s, errType: %d, errCode: %d, errMsg: %s", new Object[]{lVar.toString(), Integer.valueOf(i), Integer.valueOf(i2), str});
        if ((lVar instanceof u) || (lVar instanceof v)) {
            if (i == 0 && i2 == 0) {
                b bVar = (b) lVar;
                this.iMb = bVar.aJp();
                com.tencent.mm.plugin.facedetect.model.e.df(this.iMb);
                if (bVar.aJq() == null) {
                    x.e("MicroMsg.FaceUploadProcessor", "hy: backend not return config");
                    h(2, 90015, "face motion config from server is null");
                    return;
                }
                byte[] aJq = bVar.aJq();
                String str2 = "MicroMsg.FaceUploadProcessor";
                String str3 = "configLen: %d, mUploadCallback == null: %b";
                Object[] objArr = new Object[2];
                objArr[0] = Integer.valueOf(aJq.length);
                if (this.iLX == null) {
                    z = true;
                }
                objArr[1] = Boolean.valueOf(z);
                x.i(str2, str3, objArr);
                if (this.iLY != null) {
                    this.iLY.e(this.iMb, aJq);
                }
            } else if (this.iLY != null) {
                this.iLY.ab(i, "get face bio config failed");
            }
        } else if (this.iMe != null && lVar.getType() == this.iMe.getType()) {
            this.iMg = (int) (System.currentTimeMillis() - this.iMf);
            if (this.iLX != null) {
                this.iLX.i(i, i2, str, lVar);
            }
        }
    }
}
