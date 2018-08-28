package com.tencent.mm.plugin.downloader.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.plugin.downloader.model.d;
import com.tencent.mm.sdk.platformtools.x;

class FileDownloadConfirmUI$1 implements OnClickListener {
    final /* synthetic */ long ibH;
    final /* synthetic */ FileDownloadConfirmUI icN;

    FileDownloadConfirmUI$1(FileDownloadConfirmUI fileDownloadConfirmUI, long j) {
        this.icN = fileDownloadConfirmUI;
        this.ibH = j;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        d.aCU().cl(this.ibH);
        x.i("MicroMsg.FileDownloadConfirmUI", "Remove task: %d", new Object[]{Long.valueOf(this.ibH)});
    }
}
