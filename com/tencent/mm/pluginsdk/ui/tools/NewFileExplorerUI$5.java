package com.tencent.mm.pluginsdk.ui.tools;

import android.content.Intent;
import com.tencent.mm.ui.widget.a.c.a.b;

class NewFileExplorerUI$5 implements b {
    final /* synthetic */ NewFileExplorerUI qTk;

    NewFileExplorerUI$5(NewFileExplorerUI newFileExplorerUI) {
        this.qTk = newFileExplorerUI;
    }

    public final void aMV() {
        Intent intent = new Intent();
        intent.setClass(this.qTk.mController.tml, NewFileExplorerUI.class);
        intent.putExtra("explorer_mode", 1);
        intent.putStringArrayListExtra("selected_file_lst", NewFileExplorerUI.b(this.qTk).cfs());
        intent.putStringArrayListExtra("key_select_video_list", NewFileExplorerUI.b(this.qTk).cfu());
        intent.putStringArrayListExtra("CropImage_OutputPath_List", NewFileExplorerUI.b(this.qTk).cft());
        intent.putExtra("GalleryUI_ToUser", NewFileExplorerUI.f(this.qTk));
        this.qTk.startActivityForResult(intent, 0);
    }
}
