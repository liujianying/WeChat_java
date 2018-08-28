package com.tencent.mm.openim.b;

import com.tencent.mm.ab.b;
import com.tencent.mm.ab.b.a;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.kernel.g;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.openim.PluginOpenIM;
import com.tencent.mm.plugin.appbrand.jsapi.bc;
import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.mm.protocal.c.afs;
import com.tencent.mm.protocal.c.aft;
import com.tencent.mm.protocal.c.as;
import com.tencent.mm.protocal.c.ayc;
import com.tencent.mm.protocal.c.cgb;
import com.tencent.mm.protocal.c.db;
import com.tencent.mm.sdk.platformtools.x;
import java.util.Iterator;
import java.util.LinkedList;

public final class c extends l implements k {
    String aem;
    public final b diG;
    private e diJ;
    String eus;
    private LinkedList<String> eut = new LinkedList();

    public c(String str, String str2, LinkedList<String> linkedList) {
        a aVar = new a();
        aVar.dIG = new afs();
        aVar.dIH = new aft();
        aVar.uri = "/cgi-bin/micromsg-bin/getopenimresource";
        aVar.dIF = bc.CTRL_INDEX;
        this.diG = aVar.KT();
        this.eus = str;
        this.aem = str2;
        this.eut.addAll(linkedList);
        int size = 10 - this.eut.size();
        if (size > 0) {
            this.eut.addAll(((PluginOpenIM) g.n(PluginOpenIM.class)).getWordingInfoStg().x(size, str2));
        }
        afs afs = (afs) this.diG.dID.dIL;
        afs.hva = str;
        afs.aem = str2;
        afs.rJC = this.eut;
        x.i("MicroMsg.NetSceneGetOpenIMResource", "init NetSceneGetOpenIMResource appid:%s, lang:%s, initWordingIDs:%s, wordidList:%s", new Object[]{str, str2, o(linkedList), o(this.eut)});
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.diJ = eVar2;
        return a(eVar, this.diG, this);
    }

    public final int getType() {
        return bc.CTRL_INDEX;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.i("MicroMsg.NetSceneGetOpenIMResource", "onGYNetEnd : errType : %d, errCode : %d, errMsg : %s, appid:%s, lang:%s", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), str, this.eus, this.aem});
        if (i2 == 0 && i3 == 0) {
            aft aft = (aft) this.diG.dIE.dIL;
            as asVar = aft.rJE;
            x.i("MicroMsg.NetSceneGetOpenIMResource", "onGYNetEnd acct_type_resource  url:%d, word:%d", new Object[]{Integer.valueOf(asVar.raL.size()), Integer.valueOf(asVar.raK.size())});
            com.tencent.mm.openim.d.a aVar = new com.tencent.mm.openim.d.a();
            aVar.field_acctTypeId = asVar.raJ;
            aVar.field_language = this.aem;
            g.Ek();
            ((PluginOpenIM) g.n(PluginOpenIM.class)).getAccTypeInfoStg().b(aVar, new String[]{"acctTypeId", FFmpegMetadataRetriever.METADATA_KEY_LANGUAGE});
            aVar.field_accTypeRec = asVar;
            g.Ek();
            ((PluginOpenIM) g.n(PluginOpenIM.class)).getAccTypeInfoStg().a(aVar);
            db dbVar = aft.rJD;
            x.i("MicroMsg.NetSceneGetOpenIMResource", "onGYNetEnd appid_resource funcFlag:%d, url:%d, word:%d", new Object[]{Integer.valueOf(dbVar.rde), Integer.valueOf(dbVar.raL.size()), Integer.valueOf(dbVar.raK.size())});
            com.tencent.mm.openim.d.c cVar = new com.tencent.mm.openim.d.c();
            cVar.field_appid = this.eus;
            cVar.field_language = this.aem;
            g.Ek();
            ((PluginOpenIM) g.n(PluginOpenIM.class)).getAppIdInfoStg().b(cVar, new String[]{"appid", FFmpegMetadataRetriever.METADATA_KEY_LANGUAGE});
            cVar.field_appRec = dbVar;
            cVar.field_acctTypeId = asVar.raJ;
            g.Ek();
            ((PluginOpenIM) g.n(PluginOpenIM.class)).getAppIdInfoStg().a(cVar);
            Iterator it = dbVar.raL.iterator();
            while (it.hasNext()) {
                ayc ayc = (ayc) it.next();
                if ("openim_desc_icon".equals(ayc.aAL)) {
                    ((com.tencent.mm.openim.a.b) g.l(com.tencent.mm.openim.a.b.class)).oC(ayc.url);
                }
            }
            x.i("MicroMsg.NetSceneGetOpenIMResource", "onGYNetEnd wording_id_resource   word:%d", new Object[]{Integer.valueOf(aft.rJF.size())});
            Iterator it2 = aft.rJF.iterator();
            while (it2.hasNext()) {
                cgb cgb = (cgb) it2.next();
                com.tencent.mm.openim.d.e eVar = new com.tencent.mm.openim.d.e();
                eVar.field_appid = this.eus;
                eVar.field_wordingId = cgb.sAz;
                eVar.field_language = this.aem;
                g.Ek();
                ((PluginOpenIM) g.n(PluginOpenIM.class)).getWordingInfoStg().b(eVar, new String[]{"appid", "wordingId", FFmpegMetadataRetriever.METADATA_KEY_LANGUAGE});
                eVar.field_wording = cgb.bSc;
                eVar.field_pinyin = cgb.mcD;
                eVar.field_quanpin = cgb.sAA;
                g.Ek();
                ((PluginOpenIM) g.n(PluginOpenIM.class)).getWordingInfoStg().a(eVar);
            }
            this.diJ.a(i2, i3, str, this);
            return;
        }
        this.diJ.a(i2, i3, str, this);
    }

    private static String o(LinkedList<String> linkedList) {
        String str = "size:" + linkedList.size() + "[";
        Iterator it = linkedList.iterator();
        while (true) {
            String str2 = str;
            if (!it.hasNext()) {
                return str2 + "]";
            }
            str = str2 + ((String) it.next()) + ",";
        }
    }
}
