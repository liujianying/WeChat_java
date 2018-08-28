package com.tencent.magicbrush.handler.a;

import android.graphics.Bitmap;
import android.graphics.Typeface;
import com.tencent.magicbrush.a.c.f;
import com.tencent.magicbrush.handler.a.j.a;
import java.nio.FloatBuffer;

public final class i implements c {
    private b bnM;
    private g bnW;
    private e bnX;
    private f boe;
    private j bof;
    private a bog;
    private boolean boh = false;

    public i(b bVar, a aVar) {
        this.bnM = bVar;
        this.bog = aVar;
    }

    public final void init(int i, int i2) {
        f.i("MicroMsg.MBFontManagerImpl", "init() called with: m_atlasWidth = [" + i + "], m_atlasHeight = [" + i2 + "]", new Object[0]);
        this.bnX = new e(i, i2);
        this.boe = new f(this.bnM);
        this.bnW = new g(this.bnX, this.bog);
        this.bof = new j(a.bol);
    }

    public final String loadFont(String str) {
        f fVar = this.boe;
        if (str == null || str.length() == 0 || fVar.bnM == null) {
            return null;
        }
        Typeface bR = fVar.bnM.bR(str);
        if (bR == null) {
            return null;
        }
        String str2 = "font" + bR.hashCode();
        fVar.bnL.put(str2, bR);
        return str2;
    }

    public final void useFont(String str, float f, boolean z, boolean z2) {
        Typeface create;
        a h = a.h(z, z2);
        j jVar = this.bof;
        f fVar = this.boe;
        a aVar = h == null ? a.bol : h;
        if (str == null || str.length() == 0) {
            create = Typeface.create(null, aVar.bop);
        } else {
            create = (Typeface) fVar.bnL.get(str);
            if (create == null) {
                create = Typeface.create(str, aVar.bop);
            } else if (create.getStyle() != aVar.bop) {
                create = Typeface.create(create, aVar.bop);
            }
        }
        jVar.boi = create;
        this.bof.azb = f;
        this.bof.bok = h;
    }

    public final void enableStroke(boolean z) {
        this.bof.boj = z;
    }

    public final void setStrokeWidth(float f) {
        this.bof.strokeWidth = f;
    }

    public final FloatBuffer drawText(String str) {
        this.bnW.a(this.bof);
        FloatBuffer bS = this.bnW.bS(str);
        if (bS == null) {
            f.i("MicroMsg.MBFontManagerImpl", "drawText() load result is null. atlas may be full. first time, clear and retry; text = [%s]; mCurrentState = [%s]", new Object[]{str, this.bof});
            clear();
            bS = this.bnW.bS(str);
        }
        if (bS != null) {
            return bS;
        }
        f.i("MicroMsg.MBFontManagerImpl", "drawText() load result is null. atlas may be full. second time, just returned; text = [%s]; mCurrentState = [%s]", new Object[]{str, this.bof});
        return null;
    }

    public final Bitmap getBitmapAtlas() {
        if (this.bnX != null) {
            return this.bnX.bnH;
        }
        return null;
    }

    public final int[] checkAndFlushDirtySignal() {
        if (this.bnX == null) {
            return null;
        }
        int i;
        e eVar = this.bnX;
        if (eVar.bnJ.isEmpty()) {
            i = 0;
        } else {
            i = 1;
        }
        if (i == 0) {
            return null;
        }
        eVar.bnK[0] = eVar.bnJ.left;
        eVar.bnK[1] = eVar.bnJ.top;
        eVar.bnK[2] = eVar.bnJ.right;
        eVar.bnK[3] = eVar.bnJ.bottom;
        eVar.bnJ.setEmpty();
        return eVar.bnK;
    }

    public final boolean checkAndFlushClearSignal() {
        boolean z = this.boh;
        this.boh = false;
        return z;
    }

    private void clear() {
        f.i("MicroMsg.MBFontManagerImpl", "FontManager clear", new Object[0]);
        if (this.bnX != null) {
            e eVar = this.bnX;
            eVar.bnJ.setEmpty();
            eVar.bnI.reset();
            if (eVar.bnH != null) {
                eVar.bnH.eraseColor(0);
            }
        }
        if (this.bnW != null) {
            g gVar = this.bnW;
            if (gVar.bnO != null) {
                for (k offer : gVar.bnO.values()) {
                    gVar.bnP.bnV.offer(offer);
                }
                gVar.bnO.clear();
            }
        }
        this.boh = true;
    }

    public final float measureText(String str) {
        this.bnW.a(this.bof);
        float bU = this.bnW.bU(str);
        if (bU == -1.0f) {
            f.i("MicroMsg.MBFontManagerImpl", "measure() load result is null. atlas may be full. first time, clear and retry; text = [%s]; mCurrentState = [%s]", new Object[]{str, this.bof});
            clear();
            bU = this.bnW.bU(str);
        }
        if (bU != -1.0f) {
            return bU;
        }
        f.i("MicroMsg.MBFontManagerImpl", "measure() load result is null. atlas may be full. second time, just returned; text = [%s]; mCurrentState = [%s]", new Object[]{str, this.bof});
        return 0.0f;
    }

    public final void release() {
        if (this.bnX != null) {
            e eVar = this.bnX;
            if (eVar.bnH != null) {
                eVar.bnH.recycle();
            }
            this.bnX = null;
        }
        if (this.boe != null) {
            f fVar = this.boe;
            if (fVar.bnL != null) {
                fVar.bnL.clear();
                fVar.bnL = null;
            }
            this.boe = null;
        }
        if (this.bnW != null) {
            g gVar = this.bnW;
            if (gVar.bnN != null) {
                gVar.bnN = null;
            }
            this.bnW = null;
        }
    }

    public final float getTextLineHeight(String str) {
        if (str == null || str.length() == 0 || this.boe == null || this.bnW == null) {
            return 0.0f;
        }
        this.bnW.a(this.bof);
        h hVar = this.bnW.bnN;
        if (hVar.bod != null) {
            return (hVar.bod.descent - hVar.bod.ascent) + 1.0f;
        }
        return 0.0f;
    }
}
