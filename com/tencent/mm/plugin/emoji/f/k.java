package com.tencent.mm.plugin.emoji.f;

import android.text.TextUtils;
import com.tencent.mm.ab.b;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.bt.h;
import com.tencent.mm.g.a.mj;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.emoji.g.c.a;
import com.tencent.mm.plugin.emoji.model.i;
import com.tencent.mm.protocal.c.ada;
import com.tencent.mm.protocal.c.adb;
import com.tencent.mm.protocal.c.aqi;
import com.tencent.mm.protocal.c.tm;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.emotion.c;
import java.util.Iterator;
import java.util.List;

public final class k extends l implements com.tencent.mm.network.k {
    public final b diG;
    private e doG;
    private a iiK;
    private boolean iiL = false;
    private mj iiM = null;
    public String iil = "";

    public k(String str) {
        b.a aVar = new b.a();
        aVar.dIG = new ada();
        aVar.dIH = new adb();
        aVar.uri = "/cgi-bin/micromsg-bin/getemotiondesc";
        aVar.dIF = 521;
        aVar.dII = 0;
        aVar.dIJ = 0;
        this.diG = aVar.KT();
        this.iil = str;
        this.iiM = new mj();
    }

    public k(String str, a aVar) {
        b.a aVar2 = new b.a();
        aVar2.dIG = new ada();
        aVar2.dIH = new adb();
        aVar2.uri = "/cgi-bin/micromsg-bin/getemotiondesc";
        aVar2.dIF = 521;
        aVar2.dII = 0;
        aVar2.dIJ = 0;
        this.diG = aVar2.KT();
        this.iil = str;
        this.iiK = aVar;
        this.iiL = true;
        this.iiM = new mj();
    }

    public final int getType() {
        return 521;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        x.d("MicroMsg.emoji.NetSceneGetEmotionDesc", "getEmotionDesc %s ", new Object[]{this.iil});
        this.doG = eVar2;
        ((ada) this.diG.dID.dIL).rem = this.iil;
        if (!TextUtils.isEmpty(this.iil)) {
            return a(eVar, this.diG, this);
        }
        x.w("MicroMsg.emoji.NetSceneGetEmotionDesc", "get emoji desc faild. product id is null.");
        return -1;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        if (i2 != 0 || i3 != 0) {
            x.i("MicroMsg.emoji.NetSceneGetEmotionDesc", "end getEmojiDesc, & errType:%d, errCode:%d, productId: %s ", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), this.iil});
            if (this.iiL) {
                x.i("MicroMsg.emoji.NetSceneGetEmotionDesc", "new emotion get des failed. ignore");
            }
        } else if (!this.iiL) {
            List<tm> list = ((adb) this.diG.dIE.dIL).hbG;
            c cVar = i.aEA().igz;
            String str2 = this.iil;
            int i4 = ((adb) this.diG.dIE.dIL).rHu;
            int aEN = aEN();
            if (cVar.tcX != null) {
                cVar.tcX.edit().putLong("274544" + str2, System.currentTimeMillis()).commit();
            }
            if (list != null && list.size() > 0) {
                long dO;
                h hVar = null;
                if (cVar.diF instanceof h) {
                    h hVar2 = (h) cVar.diF;
                    dO = hVar2.dO(Thread.currentThread().getId());
                    hVar = hVar2;
                } else {
                    dO = -1;
                }
                cVar.diF.delete("EmojiInfoDesc", "groupId=?", new String[]{str2});
                com.tencent.mm.storage.emotion.b bVar = new com.tencent.mm.storage.emotion.b();
                bVar.field_groupId = str2;
                bVar.field_click_flag = i4;
                bVar.field_download_flag = aEN;
                for (tm tmVar : list) {
                    bVar.field_md5 = tmVar.rwk;
                    Iterator it = tmVar.hbG.iterator();
                    while (it.hasNext()) {
                        aqi aqi = (aqi) it.next();
                        bVar.field_desc = aqi.jOS;
                        bVar.field_lang = aqi.jRj;
                        bVar.field_md5_lang = bVar.field_md5 + bVar.field_lang;
                        if (cVar.diF.replace("EmojiInfoDesc", "md5_lang", bVar.wH()) < 0) {
                            if (hVar != null) {
                                hVar.gp(dO);
                            }
                        }
                    }
                }
                cVar.diF.replace("EmojiInfoDesc", "md5_lang", bVar.wH());
                if (hVar != null) {
                    hVar.gp(dO);
                }
            }
            if (list != null && list.size() > 0) {
                x.i("MicroMsg.emoji.NetSceneGetEmotionDesc", "end getEmojiDesc, productId: %s ", new Object[]{this.iil});
                this.iiM.bXk.bKk = this.iil;
                com.tencent.mm.sdk.b.a.sFg.m(this.iiM);
            }
        } else if ((aEN() & 1) == 1) {
            com.tencent.mm.plugin.emoji.g.c.a(this.iiK);
        } else {
            x.i("MicroMsg.emoji.NetSceneGetEmotionDesc", "new emotion is can't download. ignore");
        }
        this.doG.a(i2, i3, str, this);
    }

    private int aEN() {
        return ((adb) this.diG.dIE.dIL).rHw;
    }

    protected final int Cc() {
        return 50;
    }

    protected final int a(q qVar) {
        return l.b.dJm;
    }
}
