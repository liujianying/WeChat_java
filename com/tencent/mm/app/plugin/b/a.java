package com.tencent.mm.app.plugin.b;

import android.database.Cursor;
import com.tencent.mm.g.a.fj;
import com.tencent.mm.modelvoice.m;
import com.tencent.mm.modelvoice.p;
import com.tencent.mm.modelvoice.u;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

public final class a {

    public static class g extends c<fj> {
        public g() {
            this.sFo = fj.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(b bVar) {
            p pVar = null;
            fj fjVar = (fj) bVar;
            if (m.TI() == null) {
                x.e("MicroMsg.SubCoreExtAgent", "SubCoreVoice.getVoiceStg() == null" + bi.cjd());
            }
            u TI = m.TI();
            String str = fjVar.bNK.fileName;
            if (str != null) {
                String str2 = "SELECT FileName, User, MsgId, NetOffset, FileNowSize, TotalLen, Status, CreateTime, LastModifyTime, ClientId, VoiceLength, MsgLocalId, Human, reserved1, reserved2, MsgSource, MsgFlag, MsgSeq, MasterBufId, checksum" + " FROM voiceinfo WHERE FileName= ?";
                Cursor b = TI.dCZ.b(str2, new String[]{str}, 2);
                x.d("MicroMsg.VoiceStorage", "getInfoByFilename fileName[" + str + "] ResCount:" + b.getCount());
                if (b.moveToFirst()) {
                    pVar = new p();
                    pVar.d(b);
                }
                b.close();
            }
            if (pVar != null) {
                fjVar.bNL.bJC = (long) pVar.enN;
            }
            return true;
        }
    }
}
