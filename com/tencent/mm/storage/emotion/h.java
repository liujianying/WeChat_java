package com.tencent.mm.storage.emotion;

import android.database.Cursor;
import com.tencent.mm.bt.g;
import com.tencent.mm.bt.g.a;
import com.tencent.mm.protocal.c.acr;
import com.tencent.mm.protocal.c.act;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.i;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.io.IOException;

public final class h extends i<g> implements a {
    public static final String[] diD = new String[]{i.a(g.dhO, "EmotionDesignerInfo")};
    public e diF;

    public h(e eVar) {
        super(eVar, g.dhO, "EmotionDesignerInfo", null);
        this.diF = eVar;
    }

    public final int a(g gVar) {
        if (gVar != null) {
            this.diF = gVar;
        }
        return 0;
    }

    public final act ZC(String str) {
        Throwable e;
        if (bi.oW(str)) {
            x.w("MicroMsg.emoji.EmotionDesignerInfo", "getDesignerSimpleInfoResponseByID failed. Designer ID is null.");
            return null;
        }
        act act;
        Cursor a;
        try {
            a = this.diF.a("EmotionDesignerInfo", new String[]{"content"}, "designerIDAndType=? ", new String[]{str + a.tcZ.value}, null, null, null, 2);
            if (a != null) {
                try {
                    if (a.moveToFirst()) {
                        act = new act();
                        act.aG(a.getBlob(0));
                        if (a != null) {
                            a.close();
                        }
                        return act;
                    }
                } catch (Exception e2) {
                    e = e2;
                    try {
                        x.e("MicroMsg.emoji.EmotionDesignerInfo", "exception:%s", new Object[]{bi.i(e)});
                        if (a != null) {
                            a.close();
                            act = null;
                        } else {
                            act = null;
                        }
                        return act;
                    } catch (Throwable th) {
                        e = th;
                        if (a != null) {
                            a.close();
                        }
                        throw e;
                    }
                }
            }
            act = null;
            if (a != null) {
                a.close();
            }
        } catch (Exception e3) {
            e = e3;
            a = null;
        } catch (Throwable th2) {
            e = th2;
            a = null;
            if (a != null) {
                a.close();
            }
            throw e;
        }
        return act;
    }

    public final acr ZD(String str) {
        Throwable e;
        if (bi.oW(str)) {
            x.w("MicroMsg.emoji.EmotionDesignerInfo", "getDesignerEmojiListResponseByUIN failed. Designer UIN is null.");
            return null;
        }
        acr acr;
        Cursor a;
        try {
            a = this.diF.a("EmotionDesignerInfo", new String[]{"content"}, "designerIDAndType=? ", new String[]{str + a.tdb.value}, null, null, null, 2);
            if (a != null) {
                try {
                    if (a.moveToFirst()) {
                        acr = new acr();
                        acr.aG(a.getBlob(0));
                        if (a != null) {
                            a.close();
                        }
                        return acr;
                    }
                } catch (IOException e2) {
                    e = e2;
                    try {
                        x.e("MicroMsg.emoji.EmotionDesignerInfo", "exception:%s", new Object[]{bi.i(e)});
                        if (a != null) {
                            a.close();
                            acr = null;
                        } else {
                            acr = null;
                        }
                        return acr;
                    } catch (Throwable th) {
                        e = th;
                        if (a != null) {
                            a.close();
                        }
                        throw e;
                    }
                }
            }
            acr = null;
            if (a != null) {
                a.close();
            }
        } catch (IOException e3) {
            e = e3;
            a = null;
        } catch (Throwable th2) {
            e = th2;
            a = null;
            if (a != null) {
                a.close();
            }
            throw e;
        }
        return acr;
    }
}
