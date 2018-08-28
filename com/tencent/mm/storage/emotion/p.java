package com.tencent.mm.storage.emotion;

import android.database.Cursor;
import com.tencent.mm.bt.g;
import com.tencent.mm.bt.g.a;
import com.tencent.mm.protocal.c.acz;
import com.tencent.mm.protocal.c.adh;
import com.tencent.mm.protocal.c.agl;
import com.tencent.mm.protocal.c.bnv;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.i;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.io.IOException;

public final class p extends i<o> implements a {
    public static final String[] diD = new String[]{i.a(o.dhO, "GetEmotionListCache")};
    private e diF;

    public p(e eVar) {
        this(eVar, o.dhO, "GetEmotionListCache");
    }

    private p(e eVar, c.a aVar, String str) {
        super(eVar, aVar, str, null);
        this.diF = eVar;
    }

    public final int a(g gVar) {
        if (gVar != null) {
            this.diF = gVar;
        }
        return 0;
    }

    private boolean ZG(String str) {
        if (this.diF.delete("GetEmotionListCache", "reqType=?", new String[]{str}) > 0) {
            return true;
        }
        return false;
    }

    public final boolean a(int i, adh adh) {
        boolean z = false;
        if (adh == null) {
            return z;
        }
        try {
            this.diF.delete("GetEmotionListCache", "reqType=?", new String[]{String.valueOf(i)});
            o oVar = new o(String.valueOf(i), adh.toByteArray());
            x.d("MicroMsg.emoji.Storage", "insert cache: %d", new Object[]{Integer.valueOf(i)});
            return b(oVar);
        } catch (Throwable e) {
            x.e("MicroMsg.emoji.Storage", "exception:%s", new Object[]{bi.i(e)});
            return z;
        }
    }

    public final adh Dw(int i) {
        adh adh = null;
        Cursor a = this.diF.a("GetEmotionListCache", null, "reqType=?", new String[]{String.valueOf(i)}, null, null, null, 2);
        if (a != null && a.moveToFirst()) {
            o oVar = new o(a);
            try {
                adh adh2 = new adh();
                adh2.aG(oVar.field_cache);
                x.d("MicroMsg.emoji.Storage", "succed get cache: %d", new Object[]{Integer.valueOf(i)});
                adh = adh2;
            } catch (Throwable e) {
                x.e("MicroMsg.emoji.Storage", "exception:%s", new Object[]{bi.i(e)});
            }
        }
        if (a != null) {
            a.close();
        }
        return adh;
    }

    public final boolean a(String str, agl agl) {
        boolean z = false;
        if (agl == null) {
            return z;
        }
        try {
            ZG(str);
            return b(new o(str, agl.toByteArray()));
        } catch (Throwable e) {
            x.e("MicroMsg.emoji.Storage", "exception:%s", new Object[]{bi.i(e)});
            return z;
        }
    }

    public final agl ZH(String str) {
        agl agl = null;
        Cursor a = this.diF.a("GetEmotionListCache", null, "reqType=?", new String[]{str}, null, null, null, 2);
        if (a != null && a.moveToFirst()) {
            o oVar = new o(a);
            try {
                agl agl2 = new agl();
                agl2.aG(oVar.field_cache);
                x.d("MicroMsg.emoji.Storage", "succed get designerID cache: %s", new Object[]{str});
                agl = agl2;
            } catch (Throwable e) {
                x.e("MicroMsg.emoji.Storage", "exception:%s", new Object[]{bi.i(e)});
            }
        }
        if (a != null) {
            a.close();
        }
        return agl;
    }

    public final bnv aDU() {
        Throwable e;
        Cursor query;
        try {
            bnv bnv;
            query = this.diF.query("GetEmotionListCache", null, "reqType=?", new String[]{"Smiley_panel_req_type"}, null, null, null);
            if (query != null) {
                try {
                    if (query.moveToFirst()) {
                        o oVar = new o(query);
                        bnv = new bnv();
                        bnv.aG(oVar.field_cache);
                        if (query != null) {
                            return bnv;
                        }
                        query.close();
                        return bnv;
                    }
                } catch (Exception e2) {
                    e = e2;
                    try {
                        x.e("MicroMsg.emoji.Storage", "exception:%s", new Object[]{bi.i(e)});
                        if (query == null) {
                            return null;
                        }
                        query.close();
                        return null;
                    } catch (Throwable th) {
                        e = th;
                        if (query != null) {
                            query.close();
                        }
                        throw e;
                    }
                }
            }
            bnv = null;
            if (query != null) {
                return bnv;
            }
            query.close();
            return bnv;
        } catch (Exception e3) {
            e = e3;
            query = null;
        } catch (Throwable th2) {
            e = th2;
            query = null;
            if (query != null) {
                query.close();
            }
            throw e;
        }
    }

    public final boolean b(bnv bnv) {
        boolean z = false;
        if (bnv == null) {
            return z;
        }
        try {
            ZG("Smiley_panel_req_type");
            return b(new o("Smiley_panel_req_type", bnv.toByteArray()));
        } catch (Throwable e) {
            x.e("MicroMsg.emoji.Storage", "exception:%s", new Object[]{bi.i(e)});
            return z;
        }
    }

    public final acz ZI(String str) {
        Throwable e;
        if (bi.oW(str)) {
            x.w("MicroMsg.emoji.Storage", "getEmotionActivityByID failed. activityID is null.");
            return null;
        }
        acz acz;
        Cursor query;
        try {
            query = this.diF.query("GetEmotionListCache", null, "reqType=?", new String[]{str}, null, null, null);
            if (query != null) {
                try {
                    if (query.moveToFirst()) {
                        o oVar = new o(query);
                        acz = new acz();
                        acz.aG(oVar.field_cache);
                        if (query != null) {
                            query.close();
                        }
                        return acz;
                    }
                } catch (IOException e2) {
                    e = e2;
                    try {
                        x.e("MicroMsg.emoji.Storage", "exception:%s", new Object[]{bi.i(e)});
                        if (query != null) {
                            query.close();
                            acz = null;
                        } else {
                            acz = null;
                        }
                        return acz;
                    } catch (Throwable th) {
                        e = th;
                        if (query != null) {
                            query.close();
                        }
                        throw e;
                    }
                }
            }
            acz = null;
            if (query != null) {
                query.close();
            }
        } catch (IOException e3) {
            e = e3;
            query = null;
        } catch (Throwable th2) {
            e = th2;
            query = null;
            if (query != null) {
                query.close();
            }
            throw e;
        }
        return acz;
    }

    public final boolean a(String str, acz acz) {
        boolean z = false;
        if (acz == null) {
            return z;
        }
        try {
            ZG(str);
            return b(new o(str, acz.toByteArray()));
        } catch (Throwable e) {
            x.e("MicroMsg.emoji.Storage", "exception:%s", new Object[]{bi.i(e)});
            return z;
        }
    }
}
