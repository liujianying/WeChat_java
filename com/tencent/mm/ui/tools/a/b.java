package com.tencent.mm.ui.tools.a;

import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import com.tencent.mm.a.e;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

public final class b extends a {
    public int fi = 104857600;
    private String kWv;
    private int mHeight = 2048;
    private int mWidth = 2048;
    public int uCN = 0;
    public int uCO = 0;
    public int uCP = 0;
    private a uCQ;

    private b(String str) {
        this.kWv = str;
    }

    public static b abg(String str) {
        return new b(str);
    }

    public final b Gh(int i) {
        this.mWidth = i;
        this.mHeight = i;
        return this;
    }

    public final void a(a aVar) {
        this.uCQ = aVar;
        cfb();
    }

    protected final int afr() {
        boolean z;
        if (bi.oW(this.kWv)) {
            x.w("MicroMsg.ImageBoundaryCheck", "dz[check image but path is null or nil]");
        }
        this.uCN = e.cm(this.kWv);
        String str = this.kWv;
        Options options = new Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(str, options);
        this.uCO = options.outWidth;
        this.uCP = options.outHeight;
        if (this.uCN <= this.fi) {
            if (!(this.uCN < 0)) {
                z = true;
                if (this.uCO > this.mWidth || this.uCP > this.mHeight) {
                    x.d("MicroMsg.ImageBoundaryCheck", "dz[over width or height] width = %d, height = %d", new Object[]{Integer.valueOf(this.uCO), Integer.valueOf(this.uCP)});
                    z = false;
                }
                if (z) {
                    return 1;
                }
                x.i("MicroMsg.ImageBoundaryCheck", "dz[status ok]");
                return 0;
            }
        }
        x.d("MicroMsg.ImageBoundaryCheck", "dz[over size] size = %d", new Object[]{Integer.valueOf(this.uCN)});
        z = false;
        x.d("MicroMsg.ImageBoundaryCheck", "dz[over width or height] width = %d, height = %d", new Object[]{Integer.valueOf(this.uCO), Integer.valueOf(this.uCP)});
        z = false;
        if (z) {
            return 1;
        }
        x.i("MicroMsg.ImageBoundaryCheck", "dz[status ok]");
        return 0;
    }

    protected final void cfb() {
        if (this.uCQ == null) {
            x.w("MicroMsg.ImageBoundaryCheck", "dz[callback is null]");
            return;
        }
        switch (afr()) {
            case 0:
                this.uCQ.a(this);
                return;
            case 1:
                this.uCQ.aFC();
                return;
            default:
                return;
        }
    }
}
