package com.tencent.mm.pluginsdk.ui.tools;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.compatible.util.h;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.storage.x;
import com.tencent.mm.ui.MMActivity;
import java.io.File;

public class FileExplorerUI extends MMActivity {
    private int qRR = 0;
    private ListView qRS;
    private a qRT;
    private TextView qRU;
    private TextView qRV;
    private View qRW;
    private View qRX;
    private String qRY;
    private String qRZ;
    private File qSa;
    private File qSb;

    static /* synthetic */ int L(File file) {
        return file.isDirectory() ? R.g.qqmail_attach_folder : TY(file.getName());
    }

    static /* synthetic */ void cfm() {
    }

    protected final int getLayoutId() {
        return R.i.mail_file_explorer;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        String stringExtra = getIntent().getStringExtra("key_title");
        if (bi.oW(stringExtra)) {
            setMMTitle(R.l.plugin_qqmail_file_explorer_ui_title);
        } else {
            setMMTitle(stringExtra);
        }
        initView();
    }

    protected void onResume() {
        super.onResume();
    }

    protected void onPause() {
        super.onPause();
    }

    public void onDestroy() {
        super.onDestroy();
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 4 || a.a(this.qRT) == null) {
            if (this.qSb != null) {
                au.HU();
                c.DT().set(131074, this.qSb.getAbsolutePath());
            }
            if (this.qSa != null) {
                au.HU();
                c.DT().set(131073, this.qSa.getAbsolutePath());
            }
            return super.onKeyDown(i, keyEvent);
        }
        if (1 == this.qRR) {
            this.qSb = a.a(this.qRT);
        } else if (this.qRR == 0) {
            this.qSa = a.a(this.qRT);
        }
        this.qRT.g(a.a(this.qRT).getParentFile(), a.a(this.qRT));
        this.qRT.notifyDataSetChanged();
        this.qRS.setSelection(0);
        return true;
    }

    protected final void initView() {
        File file;
        File externalStorageDirectory;
        x DT;
        File file2;
        TextView textView;
        boolean z;
        TextView textView2;
        boolean z2 = true;
        Object obj = null;
        this.qRS = (ListView) findViewById(R.h.qqmail_file_explorer_list_lv);
        this.qRU = (TextView) findViewById(R.h.root_tab);
        this.qRW = findViewById(R.h.root_tab_selector);
        this.qRV = (TextView) findViewById(R.h.sdcard_tab);
        this.qRX = findViewById(R.h.sdcard_tab_selector);
        setBackBtn(new 1(this));
        this.qRY = getString(R.l.plugin_qqmail_file_explorer_root_tag);
        this.qRZ = getString(R.l.plugin_qqmail_file_explorer_sdcard_tag);
        File rootDirectory = h.getRootDirectory();
        if (rootDirectory.canRead()) {
            file = rootDirectory;
        } else {
            rootDirectory = h.getDataDirectory();
            if (rootDirectory.canRead()) {
                this.qRY = rootDirectory.getName();
                file = rootDirectory;
            } else {
                file = null;
            }
        }
        au.HU();
        if (c.isSDCardAvailable()) {
            externalStorageDirectory = h.getExternalStorageDirectory();
        } else {
            rootDirectory = h.getDownloadCacheDirectory();
            if (rootDirectory.canRead()) {
                this.qRZ = rootDirectory.getName();
                externalStorageDirectory = rootDirectory;
            } else {
                externalStorageDirectory = null;
            }
        }
        au.HU();
        String str = (String) c.DT().get(131073, file == null ? null : file.getAbsolutePath());
        if (!(str == null || file == null || file.getAbsolutePath().equals(str))) {
            File file3 = new File(str);
            if (file3.exists()) {
                rootDirectory = file3;
                this.qSa = rootDirectory;
                au.HU();
                DT = c.DT();
                if (externalStorageDirectory != null) {
                    obj = externalStorageDirectory.getAbsolutePath();
                }
                str = (String) DT.get(131074, obj);
                if (!(str == null || externalStorageDirectory == null || externalStorageDirectory.getAbsolutePath().equals(str))) {
                    file2 = new File(str);
                    if (file2.exists()) {
                        rootDirectory = file2;
                        this.qSb = rootDirectory;
                        this.qRT = new a(this, (byte) 0);
                        if (externalStorageDirectory == null) {
                            Cv(1);
                            this.qRT.elx = externalStorageDirectory.getPath();
                            this.qRT.g(this.qSb.getParentFile(), this.qSb);
                        } else if (file != null) {
                            Cv(0);
                            this.qRT.elx = file.getPath();
                            this.qRT.g(this.qSa.getParentFile(), this.qSa);
                        } else {
                            com.tencent.mm.sdk.platformtools.x.d("MicroMsg.FileExplorerUI", "left and right tag disabled in the same time.");
                            return;
                        }
                        textView = this.qRU;
                        if (file != null) {
                            z = true;
                        } else {
                            z = false;
                        }
                        textView.setEnabled(z);
                        textView2 = this.qRV;
                        if (externalStorageDirectory == null) {
                            z2 = false;
                        }
                        textView2.setEnabled(z2);
                        this.qRS.setAdapter(this.qRT);
                        this.qRT.notifyDataSetChanged();
                        this.qRS.setOnItemClickListener(new 2(this));
                        this.qRU.setOnClickListener(new 3(this, file));
                        this.qRV.setOnClickListener(new OnClickListener() {
                            public final void onClick(View view) {
                                FileExplorerUI.this.Cv(1);
                                FileExplorerUI.this.qRT.elx = externalStorageDirectory.getPath();
                                FileExplorerUI.this.qRT.g(FileExplorerUI.this.qSb.getParentFile(), FileExplorerUI.this.qSb);
                                FileExplorerUI.this.qRT.notifyDataSetInvalidated();
                                FileExplorerUI.this.qRT.notifyDataSetChanged();
                                FileExplorerUI.this.qRS.setSelection(0);
                            }
                        });
                    }
                }
                rootDirectory = externalStorageDirectory;
                this.qSb = rootDirectory;
                this.qRT = new a(this, (byte) 0);
                if (externalStorageDirectory == null) {
                    Cv(1);
                    this.qRT.elx = externalStorageDirectory.getPath();
                    this.qRT.g(this.qSb.getParentFile(), this.qSb);
                } else if (file != null) {
                    Cv(0);
                    this.qRT.elx = file.getPath();
                    this.qRT.g(this.qSa.getParentFile(), this.qSa);
                } else {
                    com.tencent.mm.sdk.platformtools.x.d("MicroMsg.FileExplorerUI", "left and right tag disabled in the same time.");
                    return;
                }
                textView = this.qRU;
                if (file != null) {
                    z = false;
                } else {
                    z = true;
                }
                textView.setEnabled(z);
                textView2 = this.qRV;
                if (externalStorageDirectory == null) {
                    z2 = false;
                }
                textView2.setEnabled(z2);
                this.qRS.setAdapter(this.qRT);
                this.qRT.notifyDataSetChanged();
                this.qRS.setOnItemClickListener(new 2(this));
                this.qRU.setOnClickListener(new 3(this, file));
                this.qRV.setOnClickListener(/* anonymous class already generated */);
            }
        }
        rootDirectory = file;
        this.qSa = rootDirectory;
        au.HU();
        DT = c.DT();
        if (externalStorageDirectory != null) {
            obj = externalStorageDirectory.getAbsolutePath();
        }
        str = (String) DT.get(131074, obj);
        file2 = new File(str);
        if (file2.exists()) {
            rootDirectory = file2;
            this.qSb = rootDirectory;
            this.qRT = new a(this, (byte) 0);
            if (externalStorageDirectory == null) {
                Cv(1);
                this.qRT.elx = externalStorageDirectory.getPath();
                this.qRT.g(this.qSb.getParentFile(), this.qSb);
            } else if (file != null) {
                Cv(0);
                this.qRT.elx = file.getPath();
                this.qRT.g(this.qSa.getParentFile(), this.qSa);
            } else {
                com.tencent.mm.sdk.platformtools.x.d("MicroMsg.FileExplorerUI", "left and right tag disabled in the same time.");
                return;
            }
            textView = this.qRU;
            if (file != null) {
                z = true;
            } else {
                z = false;
            }
            textView.setEnabled(z);
            textView2 = this.qRV;
            if (externalStorageDirectory == null) {
                z2 = false;
            }
            textView2.setEnabled(z2);
            this.qRS.setAdapter(this.qRT);
            this.qRT.notifyDataSetChanged();
            this.qRS.setOnItemClickListener(new 2(this));
            this.qRU.setOnClickListener(new 3(this, file));
            this.qRV.setOnClickListener(/* anonymous class already generated */);
        }
        rootDirectory = externalStorageDirectory;
        this.qSb = rootDirectory;
        this.qRT = new a(this, (byte) 0);
        if (externalStorageDirectory == null) {
            Cv(1);
            this.qRT.elx = externalStorageDirectory.getPath();
            this.qRT.g(this.qSb.getParentFile(), this.qSb);
        } else if (file != null) {
            Cv(0);
            this.qRT.elx = file.getPath();
            this.qRT.g(this.qSa.getParentFile(), this.qSa);
        } else {
            com.tencent.mm.sdk.platformtools.x.d("MicroMsg.FileExplorerUI", "left and right tag disabled in the same time.");
            return;
        }
        textView = this.qRU;
        if (file != null) {
            z = true;
        } else {
            z = false;
        }
        textView.setEnabled(z);
        textView2 = this.qRV;
        if (externalStorageDirectory == null) {
            z2 = false;
        }
        textView2.setEnabled(z2);
        this.qRS.setAdapter(this.qRT);
        this.qRT.notifyDataSetChanged();
        this.qRS.setOnItemClickListener(new 2(this));
        this.qRU.setOnClickListener(new 3(this, file));
        this.qRV.setOnClickListener(/* anonymous class already generated */);
    }

    private void Cv(int i) {
        if (1 == i) {
            this.qRR = 1;
            this.qRV.setTextColor(getResources().getColor(R.e.wechat_green));
            this.qRU.setTextColor(getResources().getColor(R.e.normal_text_color));
            this.qRW.setVisibility(4);
            this.qRX.setVisibility(0);
            return;
        }
        this.qRR = 0;
        this.qRU.setTextColor(getResources().getColor(R.e.wechat_green));
        this.qRV.setTextColor(getResources().getColor(R.e.normal_text_color));
        this.qRW.setVisibility(0);
        this.qRX.setVisibility(4);
    }

    public static int TY(String str) {
        Object obj = null;
        String toLowerCase = str.toLowerCase();
        String toLowerCase2 = bi.oV(toLowerCase).toLowerCase();
        Object obj2 = (toLowerCase2.endsWith(".doc") || toLowerCase2.endsWith(".docx") || toLowerCase2.endsWith("wps")) ? 1 : null;
        if (obj2 != null) {
            return R.k.app_attach_file_icon_word;
        }
        if (TZ(toLowerCase)) {
            return R.g.qqmail_attach_img;
        }
        toLowerCase2 = bi.oV(toLowerCase).toLowerCase();
        if (toLowerCase2.endsWith(".rar") || toLowerCase2.endsWith(".zip") || toLowerCase2.endsWith(".7z") || toLowerCase2.endsWith("tar") || toLowerCase2.endsWith(".iso")) {
            obj2 = 1;
        } else {
            obj2 = null;
        }
        if (obj2 != null) {
            return R.k.app_attach_file_icon_rar;
        }
        toLowerCase2 = bi.oV(toLowerCase).toLowerCase();
        if (toLowerCase2.endsWith(".txt") || toLowerCase2.endsWith(".rtf")) {
            obj2 = 1;
        } else {
            obj2 = null;
        }
        if (obj2 != null) {
            return R.k.app_attach_file_icon_txt;
        }
        if (bi.oV(toLowerCase).toLowerCase().endsWith(".pdf")) {
            return R.k.app_attach_file_icon_pdf;
        }
        toLowerCase2 = bi.oV(toLowerCase).toLowerCase();
        if (toLowerCase2.endsWith(".ppt") || toLowerCase2.endsWith(".pptx")) {
            obj2 = 1;
        } else {
            obj2 = null;
        }
        if (obj2 != null) {
            return R.k.app_attach_file_icon_ppt;
        }
        toLowerCase2 = bi.oV(toLowerCase).toLowerCase();
        if (toLowerCase2.endsWith(".xls") || toLowerCase2.endsWith(".xlsx")) {
            obj = 1;
        }
        if (obj != null) {
            return R.k.app_attach_file_icon_excel;
        }
        return R.k.app_attach_file_icon_unknow;
    }

    public static boolean TZ(String str) {
        String toLowerCase = bi.oV(str).toLowerCase();
        return toLowerCase.endsWith(".bmp") || toLowerCase.endsWith(".png") || toLowerCase.endsWith(".jpg") || toLowerCase.endsWith(".jpeg") || toLowerCase.endsWith(".gif");
    }

    public static boolean Ua(String str) {
        String toLowerCase = bi.oV(str).toLowerCase();
        return toLowerCase.endsWith(".mp3") || toLowerCase.endsWith(".wma") || toLowerCase.endsWith(".mp4") || toLowerCase.endsWith(".rm");
    }
}
