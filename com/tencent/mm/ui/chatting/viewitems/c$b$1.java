package com.tencent.mm.ui.chatting.viewitems;

import android.content.Intent;
import com.tencent.mm.R;
import com.tencent.mm.modelcdntran.i.a;
import com.tencent.mm.modelcdntran.keep_ProgressInfo;
import com.tencent.mm.modelcdntran.keep_SceneResult;
import com.tencent.mm.pluginsdk.model.app.b;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.bd;
import com.tencent.mm.ui.base.h;
import java.io.ByteArrayOutputStream;

class c$b$1 implements a {
    final /* synthetic */ bd dAs;
    final /* synthetic */ b tIK;
    final /* synthetic */ com.tencent.mm.ui.chatting.c.a tZG;
    final /* synthetic */ Intent val$intent;

    c$b$1(com.tencent.mm.ui.chatting.c.a aVar, Intent intent, bd bdVar, b bVar) {
        this.tZG = aVar;
        this.val$intent = intent;
        this.dAs = bdVar;
        this.tIK = bVar;
    }

    public final int a(String str, int i, keep_ProgressInfo keep_progressinfo, keep_SceneResult keep_sceneresult, boolean z) {
        String str2 = "MicroMsg.AppMessageUtil";
        String str3 = "summerbig cdnCallback mediaId:%s startRet:%d proginfo:[%s] res:[%s], progressing[%b], finish[%b], onlyCheckExist[%b]";
        Object[] objArr = new Object[7];
        objArr[0] = str;
        objArr[1] = Integer.valueOf(i);
        objArr[2] = keep_progressinfo;
        objArr[3] = keep_sceneresult;
        objArr[4] = Boolean.valueOf(keep_progressinfo != null);
        objArr[5] = Boolean.valueOf(keep_sceneresult != null);
        objArr[6] = Boolean.valueOf(z);
        x.i(str2, str3, objArr);
        if (keep_sceneresult != null) {
            if (keep_sceneresult.field_exist_whencheck) {
                this.tZG.startActivity(this.val$intent);
            } else if (this.dAs.cmu() || (this.tIK != null && c.b.e(this.dAs, this.tIK.field_fileFullPath))) {
                x.i("MicroMsg.AppMessageUtil", "appmsg is expired or clean!!!");
                h.a(this.tZG.tTq.getContext(), this.tZG.tTq.getContext().getString(R.l.file_fail_or_clean), this.tZG.tTq.getContext().getString(R.l.app_tip), new 1(this));
            } else {
                h.b(this.tZG.tTq.getContext(), this.tZG.tTq.getMMResources().getString(R.l.contain_undownload_msg), "", true);
            }
        }
        return 0;
    }

    public final void a(String str, ByteArrayOutputStream byteArrayOutputStream) {
    }

    public final byte[] i(String str, byte[] bArr) {
        return new byte[0];
    }
}
