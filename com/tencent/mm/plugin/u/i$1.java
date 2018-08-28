package com.tencent.mm.plugin.u;

import android.os.Message;
import com.tencent.mm.sdk.platformtools.ag.a;
import com.tencent.mm.sdk.platformtools.x;

class i$1 implements a {
    final /* synthetic */ i ldB;

    i$1(i iVar) {
        this.ldB = iVar;
    }

    public final boolean handleMessage(Message message) {
        switch (message.what) {
            case 1:
                x.i("MicroMsg.VideoPlayer", "%s call prepared ", new Object[]{this.ldB.avA()});
                if (this.ldB.ldz != null) {
                    this.ldB.ldz.iy();
                    break;
                }
                break;
            case 2:
                x.i("MicroMsg.VideoPlayer", "%s call completion ", new Object[]{this.ldB.avA()});
                if (this.ldB.ldz != null) {
                    this.ldB.ldz.wd();
                    break;
                }
                break;
            case 3:
                x.i("MicroMsg.VideoPlayer", "%s call seek completion ", new Object[]{this.ldB.avA()});
                if (this.ldB.ldz != null) {
                    this.ldB.ldz.bdq();
                    break;
                }
                break;
            case 4:
                x.i("MicroMsg.VideoPlayer", "%s call video size changed size [%d, %d] degrees[%d]", new Object[]{this.ldB.avA(), Integer.valueOf(message.arg1), Integer.valueOf(message.arg2), Integer.valueOf(((Integer) message.obj).intValue())});
                if (this.ldB.ldz != null) {
                    this.ldB.ldz.N(message.arg1, message.arg2, ((Integer) message.obj).intValue());
                    break;
                }
                break;
            case 5:
                x.e("MicroMsg.VideoPlayer", "%s call play error [%d, %d]", new Object[]{this.ldB.avA(), Integer.valueOf(message.arg1), Integer.valueOf(message.arg2)});
                if (this.ldB.ldz != null) {
                    this.ldB.ldz.onError(message.arg1, message.arg2);
                    break;
                }
                break;
            case 6:
                try {
                    i iVar = this.ldB;
                    x.i("MicroMsg.VideoPlayer", "%s clear now.", new Object[]{iVar.avA()});
                    iVar.ldv.quit();
                    iVar.ldw.quit();
                    if (iVar.ldx != null) {
                        iVar.ldx.quit();
                    }
                    iVar.ldu.removeMessages(1);
                    iVar.ldu.removeMessages(2);
                    iVar.ldu.removeMessages(3);
                    iVar.ldu.removeMessages(4);
                    iVar.ldu.removeMessages(5);
                    iVar.ldv = null;
                    iVar.ldw = null;
                    iVar.ldu = null;
                    iVar.ldt = null;
                    iVar.ldz = null;
                    iVar.ldy = null;
                    break;
                } catch (Exception e) {
                    break;
                }
            default:
                x.w("MicroMsg.VideoPlayer", "%s it has no idea for msg %d ", new Object[]{this.ldB.avA(), Integer.valueOf(message.what)});
                break;
        }
        return false;
    }
}
