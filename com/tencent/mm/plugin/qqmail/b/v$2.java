package com.tencent.mm.plugin.qqmail.b;

import com.tencent.mm.model.au;
import com.tencent.mm.plugin.qqmail.b.v.g;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

class v$2 implements v$b {
    final /* synthetic */ v mdU;

    v$2(v vVar) {
        this.mdU = vVar;
    }

    public final void a(ArrayList<Long> arrayList, HashMap<Long, String> hashMap) {
        v vVar;
        x.i("MicroMsg.ShareModeMailAppService", "finishChckImgStatus, notUploadedImgIdList.size: %d, attachIdMap.size: %d", new Object[]{Integer.valueOf(arrayList.size()), Integer.valueOf(hashMap.size())});
        if (arrayList.size() > 0) {
            vVar = this.mdU;
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                String str = (String) vVar.mdB.get(String.valueOf((Long) it.next()));
                x.i("MicroMsg.ShareModeMailAppService", "appendAllUndownloadImage, filePath: %s", new Object[]{str});
                if (!bi.oW(str)) {
                    if (vVar.mdM == null) {
                        vVar.mdM = new ArrayList();
                    }
                    vVar.mdM.add(new g(str, str));
                }
            }
        }
        if (hashMap.size() > 0) {
            v.a(this.mdU, hashMap);
        }
        this.mdU.uW(10);
        vVar = this.mdU;
        x.i("MicroMsg.ShareModeMailAppService", "uploadMsgImg, filesInfo.size = %d", new Object[]{Integer.valueOf(vVar.mdM.size())});
        if (vVar.mdM == null) {
            vVar.mdM = new ArrayList();
        }
        if (vVar.mdM.size() > 0) {
            v$c v_3 = new v$3(vVar);
            v$d v_4 = new v$4(vVar);
            x.i("MicroMsg.ShareModeMailAppService", "uploadFile, filesInfo.size: %d", new Object[]{Integer.valueOf(vVar.mdM.size())});
            vVar.mdQ = v_3;
            vVar.mdR = v_4;
            vVar.mdS = vVar.mdM.size();
            if (vVar.mdM != null && vVar.mdM.size() > 0) {
                g gVar = (g) vVar.mdM.remove(0);
                vVar.mdN = gVar.fileId;
                vVar.mdO = gVar.fileName;
                vVar.mdP = new HashMap();
                au.DF().a(new o(vVar.mdO, vVar.mdN, vVar.mdT), 0);
                return;
            }
            return;
        }
        vVar.uW(90);
        vVar.bos();
    }
}
