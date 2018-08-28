package com.tencent.magicbrush.handler.a;

import android.graphics.Paint;
import android.graphics.Paint.FontMetrics;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import com.tencent.magicbrush.handler.a.j.a;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

final class g {
    h bnN;
    HashMap<String, k> bnO;
    a bnP;
    private FloatBuffer bnQ;
    private List<k> bnR;
    private j bnS;
    private a bnT;
    private StringBuilder bnU = new StringBuilder();

    g(e eVar, a aVar) {
        this.bnT = aVar;
        this.bnN = new h(eVar, this);
        this.bnO = new HashMap();
        this.bnP = new a();
        this.bnR = new ArrayList();
    }

    final FloatBuffer bS(String str) {
        if (str == null || str.length() == 0) {
            return null;
        }
        List bT = bT(str);
        if (bT == null || bT.size() == 0) {
            return null;
        }
        int max = (Math.max(str.length(), 10) * 36) + 16;
        if (this.bnQ == null || this.bnQ.capacity() * 4 < max) {
            this.bnQ = ByteBuffer.allocateDirect(max).order(ByteOrder.nativeOrder()).asFloatBuffer();
        }
        this.bnQ.clear();
        FloatBuffer floatBuffer = this.bnQ;
        float x = h.x(bT);
        FontMetrics fontMetrics = this.bnN.bod;
        floatBuffer.put(x).put(fontMetrics.ascent).put(fontMetrics.descent).put(fontMetrics.descent - fontMetrics.ascent);
        k.a(floatBuffer, bT);
        floatBuffer.flip();
        this.bnR.clear();
        return floatBuffer;
    }

    private List<k> bT(String str) {
        if (str == null || str.length() == 0) {
            return null;
        }
        this.bnR.clear();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= str.length()) {
                return this.bnR;
            }
            Object obj;
            int n = this.bnT == null ? 0 : this.bnT.n(str, i2);
            k kVar;
            k obj2;
            int ceil;
            Object obj3;
            if (n <= 0) {
                char charAt = str.charAt(i2);
                if (this.bnS == null) {
                    obj2 = null;
                } else {
                    Object obj4;
                    if (this.bnS == null) {
                        obj4 = null;
                    } else {
                        this.bnU.setLength(0);
                        StringBuilder append = this.bnU.append(charAt).append("|").append(this.bnS.azb).append("|").append(this.bnS.boi == null ? "null" : Integer.valueOf(this.bnS.boi.hashCode()));
                        if (this.bnS.boj) {
                            append.append("|").append(this.bnS.strokeWidth);
                        }
                        if (this.bnS.bok != null) {
                            append.append("|").append(this.bnS.bok.bop);
                        }
                        String obj42 = append.toString();
                    }
                    kVar = (k) this.bnO.get(obj42);
                    if (kVar != null) {
                        obj2 = kVar;
                    } else {
                        h hVar = this.bnN;
                        k te = hVar.bnW.bnP.te();
                        te.boy = false;
                        ceil = (int) Math.ceil((double) (hVar.bod.descent - hVar.bod.ascent));
                        hVar.boa[0] = charAt;
                        hVar.bnZ.getTextBounds(hVar.boa, 0, 1, hVar.bob);
                        n = (int) Math.ceil((double) (Math.max((float) hVar.bob.width(), hVar.bnZ.measureText(hVar.boa, 0, 1)) + 1.0f));
                        if (te != null) {
                            te.bos = (float) n;
                            Paint paint = hVar.bnZ;
                            obj3 = (paint == null || !(paint.getStyle() == Style.STROKE || paint.getStyle() == Style.FILL_AND_STROKE)) ? null : 1;
                            if (obj3 != null) {
                                te.bot = (-hVar.bnZ.getStrokeWidth()) / 2.0f;
                                te.v(((float) n) + hVar.bnZ.getStrokeWidth(), (float) ceil);
                            } else {
                                te.bot = 0.0f;
                                te.v((float) n, (float) ceil);
                            }
                        }
                        if (hVar.bnX.b((int) Math.ceil((double) te.width), (int) Math.ceil((double) te.height), hVar.bob)) {
                            Rect rect = hVar.bob;
                            te.d(((float) rect.left) / ((float) hVar.bnX.width()), ((float) rect.top) / ((float) hVar.bnX.height()), ((float) rect.right) / ((float) hVar.bnX.width()), ((float) rect.bottom) / ((float) hVar.bnX.height()));
                            Rect rect2 = hVar.bob;
                            Paint paint2 = hVar.bnZ;
                            if (!(paint2 == null || te == null || rect2 == null)) {
                                hVar.boa[0] = charAt;
                                hVar.bnY.save();
                                hVar.bnY.clipRect(rect2);
                                hVar.bnY.drawText(hVar.boa, 0, 1, ((float) rect2.left) - te.bot, ((((float) rect2.top) + te.height) - hVar.bod.descent) - 1.0f, paint2);
                                hVar.bnY.restore();
                            }
                            kVar = te;
                        } else {
                            obj3 = null;
                        }
                        if (obj3 == null) {
                            new StringBuilder("Load glyph failed. glyph == null [").append(charAt).append("]");
                            obj2 = null;
                        } else {
                            this.bnO.put(obj42, obj3);
                            obj2 = obj3;
                        }
                    }
                }
                i = i2 + 1;
            } else if (n <= 0) {
                throw new IllegalStateException("There is no font drawable");
            } else {
                this.bnU.setLength(0);
                ceil = i2;
                for (i = n; i > 0; i--) {
                    this.bnU.append(str.charAt(ceil));
                    ceil++;
                }
                this.bnU.append("|").append(this.bnS.azb);
                String stringBuilder = this.bnU.toString();
                kVar = (k) this.bnO.get(stringBuilder);
                if (kVar != null) {
                    obj2 = kVar;
                } else if (this.bnT == null) {
                    throw new IllegalStateException("FontDrawableProvider must support");
                } else {
                    Drawable o = this.bnT.o(str, i2);
                    if (o == null) {
                        obj2 = k.bor;
                    } else {
                        int i3 = (int) this.bnS.azb;
                        int i4 = (int) this.bnS.azb;
                        if (i3 <= 0 || i4 <= 0) {
                            obj2 = k.bor;
                        } else {
                            h hVar2 = this.bnN;
                            if (i3 > 0 && i4 > 0) {
                                obj3 = hVar2.bnW.bnP.te();
                                obj3.bos = (float) i3;
                                obj3.bot = 0.0f;
                                hVar2.bnX.b(i3, i4, hVar2.bob);
                                Rect rect3 = hVar2.bob;
                                if (rect3.left < 0 || rect3.right < 0 || rect3.width() <= 0 || rect3.height() <= 0) {
                                    obj3 = null;
                                } else {
                                    obj3.v((float) i3, (float) i4);
                                    obj3.d(((float) rect3.left) / ((float) hVar2.bnX.width()), ((float) rect3.top) / ((float) hVar2.bnX.height()), ((float) rect3.right) / ((float) hVar2.bnX.width()), ((float) rect3.bottom) / ((float) hVar2.bnX.height()));
                                    obj3.boy = true;
                                    hVar2.bnY.save();
                                    hVar2.bnY.clipRect(rect3);
                                    o.setBounds(rect3);
                                    o.draw(hVar2.bnY);
                                    hVar2.bnY.restore();
                                }
                                if (obj3 == null) {
                                    obj2 = null;
                                } else {
                                    this.bnO.put(stringBuilder, obj3);
                                    obj2 = obj3;
                                }
                            }
                        }
                    }
                }
                i = i2 + n;
            }
            if (obj2 == null) {
                this.bnR.clear();
                return null;
            }
            this.bnR.add(obj2);
        }
        throw new IllegalArgumentException("width or height unexpected");
    }

    final void a(j jVar) {
        boolean z = false;
        this.bnS = jVar;
        h hVar = this.bnN;
        hVar.bnZ.setTypeface(jVar.boi);
        hVar.bnZ.setTextSize(jVar.azb);
        if (jVar.boj) {
            hVar.bnZ.setStyle(Style.STROKE);
            hVar.bnZ.setStrokeWidth(jVar.strokeWidth);
        } else {
            hVar.bnZ.setStyle(Style.FILL);
        }
        hVar.bnZ.setTextSkewX(0.0f);
        hVar.bnZ.setFakeBoldText(false);
        if (jVar.bok != null) {
            if (jVar.boi == null || jVar.boi.getStyle() != jVar.bok.bop) {
                if (jVar.bok == a.bon || jVar.bok == a.boo) {
                    hVar.bnZ.setTextSkewX(-0.25f);
                }
                if (jVar.bok == a.bom || jVar.bok == a.boo) {
                    hVar.bnZ.setFakeBoldText(true);
                }
            }
            a aVar = jVar.bok;
            if (aVar == a.bom || aVar == a.boo) {
                z = true;
            }
            if (z) {
                hVar.bnZ.setFakeBoldText(true);
            }
        }
        hVar.bnZ.getFontMetrics(hVar.bod);
    }

    final float bU(String str) {
        if (str == null || str.length() == 0) {
            return 0.0f;
        }
        List bT = bT(str);
        if (bT == null || bT.size() == 0) {
            return -1.0f;
        }
        return h.x(bT);
    }
}
