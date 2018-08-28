package com.tencent.mm.plugin.sns.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.plugin.sight.decode.ui.c;
import com.tencent.mm.sdk.platformtools.x;

class al$2 implements OnClickListener {
    final /* synthetic */ al nRJ;

    al$2(al alVar) {
        this.nRJ = alVar;
    }

    public final void onClick(View view) {
        if (FileOp.cn(this.nRJ.videoPath)) {
            if (this.nRJ.nRI != null) {
                this.nRJ.nRI.dismiss();
                this.nRJ.nRI = null;
            }
            this.nRJ.nRI = new c(this.nRJ.bGc);
            c cVar = this.nRJ.nRI;
            String str = this.nRJ.videoPath;
            String str2 = this.nRJ.bOX;
            cVar.dXA = str;
            cVar.imagePath = str2;
            cVar = this.nRJ.nRI;
            cVar.ccR = 0;
            cVar.ncW = 0;
            cVar.iYO = 1;
            this.nRJ.nRI.show();
            return;
        }
        x.i("MicroMsg.SightWidget", "click videopath is not exist " + this.nRJ.videoPath);
    }
}
