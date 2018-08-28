package com.tencent.mm.plugin.scanner.a;

import android.graphics.Point;
import android.graphics.Rect;
import android.os.Bundle;
import com.tencent.mm.g.a.no;
import com.tencent.mm.plugin.facedetect.model.q;
import com.tencent.mm.plugin.scanner.util.b.a;
import com.tencent.mm.plugin.scanner.util.d;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.x;

public final class m extends c<no> implements a {
    private boolean jAi;
    private d mGj;
    private q mGk;

    public m() {
        this.mGj = null;
        this.jAi = false;
        this.mGk = null;
        this.sFo = no.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        no noVar = (no) bVar;
        q qVar = noVar.bYB.bYF;
        if (!this.jAi || qVar == null) {
            this.mGk = qVar;
            this.jAi = true;
            if (this.mGj == null) {
                this.mGj = new d(this, 3, false);
            }
            if (this.mGj.mJI) {
                this.mGj.bsU();
            }
            int i = noVar.bYB.width;
            int i2 = noVar.bYB.height;
            Rect rect = noVar.bYB.bYD;
            byte[] bArr = noVar.bYB.bYC;
            int i3 = noVar.bYB.bYE;
            String str = "MicroMsg.RecogQBarInYUVListener";
            String str2 = "hy: request scanning width: %d, height: %d, scanRect: %s, yuvLen: %d, rotate: %d";
            Object[] objArr = new Object[5];
            objArr[0] = Integer.valueOf(i);
            objArr[1] = Integer.valueOf(i2);
            objArr[2] = rect;
            objArr[3] = Integer.valueOf(bArr != null ? bArr.length : 0);
            objArr[4] = Integer.valueOf(i3);
            x.i(str, str2, objArr);
            this.mGj.lhy = i3 != 0;
            this.mGj.a(bArr, new Point(i, i2), i3, rect);
        } else {
            x.w("MicroMsg.RecogQBarInYUVListener", "hy: is decoding. direct return");
            qVar.N("", -1, -1);
        }
        return false;
    }

    public final void b(int i, String str, byte[] bArr, byte[] bArr2, int i2, int i3) {
        x.i("MicroMsg.RecogQBarInYUVListener", "hy: on decode success. result type: %d, result: %s, codeType: %d, codeVersion: %d", new Object[]{Integer.valueOf(i), str, Integer.valueOf(i2), Integer.valueOf(i3)});
        if (this.mGk != null) {
            this.mGk.N(str, i2, i3);
        }
        this.jAi = false;
    }

    public final void bsf() {
        x.i("MicroMsg.RecogQBarInYUVListener", "hy: on qrcode decode failed");
        if (this.mGk != null) {
            this.mGk.N("", -2, -1);
        }
        this.jAi = false;
    }

    public final void E(Bundle bundle) {
    }
}
