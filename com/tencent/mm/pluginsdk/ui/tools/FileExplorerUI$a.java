package com.tencent.mm.pluginsdk.ui.tools;

import android.text.format.DateFormat;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.platformtools.h;
import com.tencent.mm.pluginsdk.ui.tools.FileExplorerUI.c;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

class FileExplorerUI$a extends BaseAdapter {
    String elx;
    final /* synthetic */ FileExplorerUI qSc;
    private File qSf;
    private File qSg;
    private File[] qSh;

    private FileExplorerUI$a(FileExplorerUI fileExplorerUI) {
        this.qSc = fileExplorerUI;
    }

    /* synthetic */ FileExplorerUI$a(FileExplorerUI fileExplorerUI, byte b) {
        this(fileExplorerUI);
    }

    public final void g(File file, File file2) {
        byte b = (byte) 0;
        this.qSf = file;
        if (file2.getAbsolutePath().equalsIgnoreCase(this.elx)) {
            this.qSf = null;
        }
        this.qSg = file2;
        if (this.qSg.canRead() && this.qSg.isDirectory()) {
            this.qSh = this.qSg.listFiles(new 1(this));
            if (this.qSh.length > 0) {
                File[] fileArr = this.qSh;
                if (fileArr != null && fileArr.length != 0) {
                    int i;
                    List arrayList = new ArrayList();
                    List<FileExplorerUI$b> arrayList2 = new ArrayList();
                    for (File file3 : fileArr) {
                        FileExplorerUI$b fileExplorerUI$b = new FileExplorerUI$b(this.qSc, (byte) 0);
                        fileExplorerUI$b.file = file3;
                        fileExplorerUI$b.qSj = h.oI(file3.getName()).toUpperCase();
                        if (file3.isDirectory()) {
                            arrayList.add(fileExplorerUI$b);
                        } else {
                            arrayList2.add(fileExplorerUI$b);
                        }
                    }
                    Collections.sort(arrayList, new 2(this));
                    Collections.sort(arrayList2, new 3(this));
                    Iterator it = arrayList.iterator();
                    while (true) {
                        i = b;
                        if (!it.hasNext()) {
                            break;
                        }
                        fileArr[i] = ((FileExplorerUI$b) it.next()).file;
                        b = i + 1;
                    }
                    for (FileExplorerUI$b fileExplorerUI$b2 : arrayList2) {
                        fileArr[i] = fileExplorerUI$b2.file;
                        i++;
                    }
                    return;
                }
                return;
            }
            return;
        }
        this.qSh = new File[0];
    }

    public final int getCount() {
        int i = 0;
        if (this.qSh == null) {
            return 0;
        }
        int length = this.qSh.length;
        if (this.qSf != null) {
            i = 1;
        }
        return i + length;
    }

    public final Object getItem(int i) {
        if (this.qSf != null && i == 0) {
            return this.qSf;
        }
        x.d("FileExplorer", "pos:" + i + ", subFile length:" + this.qSh.length);
        File[] fileArr = this.qSh;
        if (this.qSf != null) {
            i--;
        }
        return fileArr[i];
    }

    public final long getItemId(int i) {
        return 0;
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = View.inflate(this.qSc, R.i.mail_file_explorer_item, null);
            c cVar = new c(this.qSc, (byte) 0);
            cVar.gmn = (ImageView) view.findViewById(R.h.file_icon_iv);
            cVar.eMe = (TextView) view.findViewById(R.h.file_name_tv);
            cVar.qSk = (TextView) view.findViewById(R.h.file_summary_tv);
            view.setTag(cVar);
        }
        c cVar2 = (c) view.getTag();
        File file = (File) getItem(i);
        if (file == this.qSf) {
            cVar2.eMe.setText(file.getName());
            cVar2.gmn.setImageResource(R.g.qqmail_attach_back);
            cVar2.qSk.setVisibility(0);
        } else {
            cVar2.gmn.setImageResource(FileExplorerUI.L(file));
            cVar2.eMe.setText(file.getName());
            cVar2.qSk.setText(DateFormat.format("yyyy-MM-dd hh:mm:ss", file.lastModified()).toString() + (file.isDirectory() ? "" : "  " + bi.bF(file.length())));
        }
        return view;
    }
}
