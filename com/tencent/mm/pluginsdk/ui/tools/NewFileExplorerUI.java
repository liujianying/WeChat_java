package com.tencent.mm.pluginsdk.ui.tools;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.pluginsdk.ui.applet.g;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.s.b;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;

@a(19)
public class NewFileExplorerUI extends MMActivity {
    private ListView eVT;
    private TextView mfT;
    private int mode = 0;
    private a qTf;
    private TextView qTg;
    private FileSelectorFolderView qTh;
    private g.a qTi;
    private FileSelectorFolderView.a qTj = new FileSelectorFolderView.a() {
        public final void Cw(int i) {
            x.i("MicroMsg.FileExplorerUI", "position: %d", new Object[]{Integer.valueOf(i)});
            if (i == 0) {
                NewFileExplorerUI.this.setMMTitle(R.l.file_explorer_mm_download_title);
                NewFileExplorerUI.this.setMMSubTitle(null);
                NewFileExplorerUI.this.qTg = (TextView) NewFileExplorerUI.this.findViewById(R.h.file_explorer_folder_title_tv);
                NewFileExplorerUI.this.qTg.setText(R.l.file_explorer_mm_download_title);
                NewFileExplorerUI.this.qTf.c(new File(e.dgj), true);
                NewFileExplorerUI.this.qTf.a(new File(e.dgj), null);
            } else {
                NewFileExplorerUI.this.qTf.c(new File(e.bnC), false);
                NewFileExplorerUI.this.qTf.a(new File(e.bnC), null);
                NewFileExplorerUI.this.setMMTitle(R.l.file_explorer_mobile_dir_title);
                NewFileExplorerUI.this.qTg.setText(R.l.file_explorer_mobile_dir_title);
            }
            NewFileExplorerUI.this.qTf.notifyDataSetChanged();
            NewFileExplorerUI.this.cfr();
        }
    };
    private String toUserName;

    static /* synthetic */ void e(NewFileExplorerUI newFileExplorerUI) {
        newFileExplorerUI.qTi = new g.a(newFileExplorerUI.mController.tml);
        newFileExplorerUI.qTi.bZ(newFileExplorerUI.toUserName);
        newFileExplorerUI.qTi.g(Boolean.valueOf(true));
        newFileExplorerUI.qTi.TH(newFileExplorerUI.getString(R.l.app_file) + newFileExplorerUI.getString(R.l.file_explorer_confirm_file_size, new Object[]{Integer.valueOf(a.a(newFileExplorerUI.qTf).size()), bi.bF((long) newFileExplorerUI.qTf.boX())}));
        newFileExplorerUI.qTi.a(new 5(newFileExplorerUI));
        newFileExplorerUI.qTi.BX(R.l.app_send).a(new 6(newFileExplorerUI)).eIW.show();
    }

    protected final int getLayoutId() {
        return R.i.new_file_explorer_ui;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.toUserName = getIntent().getStringExtra("TO_USER");
        this.eVT = (ListView) findViewById(R.h.file_explorer_lv);
        this.qTf = new a(this);
        this.mfT = (TextView) findViewById(R.h.selected_file_size);
        this.mode = getIntent().getIntExtra("explorer_mode", 0);
        if (this.mode == 1) {
            setMMTitle(R.l.file_explorer_selected_mode_title);
            setMMSubTitle(null);
            this.qTf.a(null, getIntent().getStringArrayListExtra("selected_file_lst"));
        } else {
            setMMTitle(R.l.file_explorer_mm_download_title);
            setMMSubTitle(null);
            this.qTg = (TextView) findViewById(R.h.file_explorer_folder_title_tv);
            this.qTg.setText(R.l.file_explorer_mm_download_title);
            this.qTf.c(new File(e.dgj), true);
            this.qTf.a(new File(e.dgj), null);
            if (this.qTf.getCount() == 0) {
                this.qTf.c(new File(e.bnC), false);
                this.qTf.a(new File(e.bnC), null);
                setMMTitle(R.l.file_explorer_mobile_dir_title);
                this.qTg.setText(R.l.file_explorer_mobile_dir_title);
            }
            findViewById(R.h.file_explorer_folder).setVisibility(0);
            findViewById(R.h.file_explorer_folder).setOnClickListener(new 1(this));
            this.qTh = (FileSelectorFolderView) findViewById(R.h.file_explorer_folder_mgr_view);
            this.qTh.setListener(this.qTj);
        }
        this.eVT.setAdapter(this.qTf);
        this.eVT.setOnItemClickListener(new OnItemClickListener() {
            public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                File file = NewFileExplorerUI.this.qTf.qSh[i];
                if (file.isDirectory()) {
                    NewFileExplorerUI.this.qTf.a(file, null);
                    NewFileExplorerUI.this.qTf.notifyDataSetChanged();
                    NewFileExplorerUI.this.cfr();
                    return;
                }
                a.b(NewFileExplorerUI.this, file.getPath(), com.tencent.mm.a.e.cp(file.getPath()), 1);
            }
        });
        this.eVT.setEmptyView(findViewById(R.h.file_explorer_empty_view));
        setBackBtn(new 3(this), this.mode == 0 ? R.k.actionbar_quit_webview_icon : 0);
        if (this.mode == 0) {
            a(1, getString(R.l.app_send), new OnMenuItemClickListener() {
                public final boolean onMenuItemClick(MenuItem menuItem) {
                    NewFileExplorerUI.e(NewFileExplorerUI.this);
                    return true;
                }
            }, b.tmX);
        }
        btU();
    }

    protected void onDestroy() {
        super.onDestroy();
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 4) {
            return super.onKeyDown(i, keyEvent);
        }
        kV(false);
        return true;
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        if (i == 0 && i2 == -1) {
            ArrayList stringArrayListExtra = intent.getStringArrayListExtra("selected_file_lst");
            if (a.a(this.qTf).size() != stringArrayListExtra.size()) {
                this.qTi.eIW.dismiss();
                a.a(this.qTf).clear();
                Iterator it = stringArrayListExtra.iterator();
                while (it.hasNext()) {
                    a.a(this.qTf).add(new File((String) it.next()));
                }
                this.qTf.notifyDataSetChanged();
                cfr();
                btU();
            }
        } else if (i == 2) {
            a.a(this, i, i2, intent, true, R.l.download_no_match_msg, R.l.download_no_match_title, 1);
        }
    }

    private void kV(boolean z) {
        if (this.mode != 0) {
            Intent intent = new Intent();
            intent.putStringArrayListExtra("selected_file_lst", this.qTf.cfs());
            intent.putStringArrayListExtra("key_select_video_list", this.qTf.cfu());
            intent.putStringArrayListExtra("CropImage_OutputPath_List", this.qTf.cft());
            intent.putExtra("GalleryUI_ToUser", this.toUserName);
            setResult(-1, intent);
            finish();
        } else if (z || this.qTf.cfv() == null) {
            setResult(0);
            finish();
        } else {
            this.qTf.a(this.qTf.cfv(), null);
            this.qTf.notifyDataSetChanged();
            cfr();
        }
    }

    private void btU() {
        int size = a.a(this.qTf).size();
        if (size > 0) {
            if (this.mode == 0) {
                updateOptionMenuText(1, getString(R.l.app_send) + "(" + size + "/9)");
                enableOptionMenu(1, true);
            }
            this.mfT.setText(getString(R.l.file_explorer_selected_file_size, new Object[]{bi.bF((long) this.qTf.boX())}));
            this.mfT.setVisibility(0);
            return;
        }
        if (this.mode == 0) {
            updateOptionMenuText(1, getString(R.l.app_send));
            enableOptionMenu(1, false);
        }
        this.mfT.setVisibility(8);
    }

    private void cfr() {
        if (a.b(this.qTf) != null && a.c(this.qTf) != null) {
            String replace = a.c(this.qTf).getPath().replace(a.b(this.qTf).getPath(), "");
            if (replace.startsWith("/")) {
                replace = replace.substring(1);
            }
            if (replace.length() == 0) {
                replace = null;
            }
            setMMSubTitle(replace);
        }
    }
}
