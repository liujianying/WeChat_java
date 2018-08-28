package com.tencent.mm.plugin.wear.model.e;

import com.tencent.liteav.network.TXCStreamUploader;
import com.tencent.mm.a.e;
import com.tencent.mm.br.b;
import com.tencent.mm.g.a.tp;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.emoji.b.c;
import com.tencent.mm.plugin.wear.model.c.a;
import com.tencent.mm.protocal.c.cdt;
import com.tencent.mm.protocal.c.cdu;
import com.tencent.mm.protocal.c.cdv;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.emotion.EmojiInfo;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public final class d extends a {
    public final List<Integer> bSy() {
        List<Integer> arrayList = new ArrayList();
        arrayList.add(Integer.valueOf(TXCStreamUploader.TXE_UPLOAD_INFO_CONNECT_SUCCESS));
        arrayList.add(Integer.valueOf(11004));
        return arrayList;
    }

    protected final byte[] p(int i, byte[] bArr) {
        Throwable e;
        if (i == TXCStreamUploader.TXE_UPLOAD_INFO_CONNECT_SUCCESS) {
            cdt cdt = new cdt();
            try {
                cdt.aG(bArr);
            } catch (IOException e2) {
            }
            if (b.cjC().sLx > cdt.rIg) {
                InputStream open;
                try {
                    open = ad.getContext().getAssets().open("color_emoji");
                    try {
                        byte[] g = e.g(open);
                        e.f(open);
                        return g;
                    } catch (IOException e3) {
                        e = e3;
                        try {
                            x.printErrStackTrace("MicroMsg.Wear.EmojiServer", e, "", new Object[0]);
                            e.f(open);
                            return null;
                        } catch (Throwable th) {
                            e = th;
                            e.f(open);
                            throw e;
                        }
                    }
                } catch (IOException e4) {
                    e = e4;
                    open = null;
                } catch (Throwable th2) {
                    e = th2;
                    open = null;
                    e.f(open);
                    throw e;
                }
            }
        } else if (i == 11004) {
            a.zC(9);
            cdu cdu = new cdu();
            try {
                cdu.aG(bArr);
            } catch (IOException e5) {
            }
            cdv cdv = new cdv();
            if (((c) g.n(c.class)).getEmojiMgr() != null) {
                List<EmojiInfo> zk = ((c) g.n(c.class)).getEmojiMgr().zk(cdu.rlw);
                if (zk != null) {
                    for (EmojiInfo emojiInfo : zk) {
                        if (!bi.oW(emojiInfo.Xh())) {
                            cdv.rfd.add(emojiInfo.Xh());
                        }
                    }
                }
            }
            if (cdv.rfd.size() == 0) {
                tp tpVar = new tp();
                String[] strArr = new String[]{cdu.rlw};
                tpVar.cfo.cfp = strArr;
                tpVar.cfo.bIH = 1;
                com.tencent.mm.sdk.b.a.sFg.m(tpVar);
            }
            try {
                return cdv.toByteArray();
            } catch (IOException e6) {
            }
        }
        return null;
    }
}
