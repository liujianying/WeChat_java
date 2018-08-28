package com.tencent.mm.pluginsdk.ui.tools;

import android.database.Cursor;
import android.graphics.Bitmap;
import android.provider.MediaStore.Images.Media;
import android.provider.MediaStore.Images.Thumbnails;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.platformtools.h;
import com.tencent.mm.sdk.platformtools.bi;
import java.io.File;
import java.io.FileFilter;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class NewFileExplorerUI$a extends BaseAdapter {
    private File qSg;
    File[] qSh = new File[0];
    final /* synthetic */ NewFileExplorerUI qTk;
    private File qTl;
    private boolean qTm = false;
    private ArrayList<File> qTn = new ArrayList();

    private class a {
        File file;
        String qTp;
        long time;

        private a() {
        }

        /* synthetic */ a(NewFileExplorerUI$a newFileExplorerUI$a, byte b) {
            this();
        }
    }

    public NewFileExplorerUI$a(NewFileExplorerUI newFileExplorerUI) {
        this.qTk = newFileExplorerUI;
    }

    public final /* bridge */ /* synthetic */ Object getItem(int i) {
        return this.qSh[i];
    }

    public final void c(File file, boolean z) {
        this.qTl = file;
        this.qTm = z;
    }

    public final void a(File file, List<String> list) {
        byte b = (byte) 0;
        this.qSg = file;
        if (this.qSg != null && this.qSg.canRead() && this.qSg.isDirectory()) {
            this.qSh = this.qSg.listFiles(new FileFilter() {
                public final boolean accept(File file) {
                    if (file.isHidden()) {
                        return false;
                    }
                    if (NewFileExplorerUI$a.this.qTm && file.isDirectory()) {
                        return false;
                    }
                    return true;
                }
            });
            if (this.qSh == null) {
                this.qSh = new File[0];
            }
            if (this.qSh.length > 0) {
                File[] fileArr = this.qSh;
                if (fileArr != null && fileArr.length != 0) {
                    int i;
                    List arrayList = new ArrayList();
                    List<a> arrayList2 = new ArrayList();
                    for (File file2 : fileArr) {
                        a aVar = new a(this, (byte) 0);
                        aVar.file = file2;
                        aVar.time = file2.lastModified();
                        if (file2.isDirectory()) {
                            aVar.qTp = h.oI(file2.getName()).toUpperCase();
                            arrayList.add(aVar);
                        } else {
                            arrayList2.add(aVar);
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
                        fileArr[i] = ((a) it.next()).file;
                        b = i + 1;
                    }
                    for (a aVar2 : arrayList2) {
                        fileArr[i] = aVar2.file;
                        i++;
                    }
                }
            }
        } else if (list != null) {
            this.qSh = new File[list.size()];
            while (true) {
                byte b2 = b;
                if (b2 < list.size()) {
                    this.qSh[b2] = new File((String) list.get(b2));
                    this.qTn.add(this.qSh[b2]);
                    b = b2 + 1;
                } else {
                    return;
                }
            }
        }
    }

    public final int boX() {
        int i = 0;
        Iterator it = this.qTn.iterator();
        while (true) {
            int i2 = i;
            if (!it.hasNext()) {
                return i2;
            }
            i = (int) (((File) it.next()).length() + ((long) i2));
        }
    }

    public final ArrayList<String> cfs() {
        ArrayList<String> arrayList = new ArrayList();
        Iterator it = this.qTn.iterator();
        while (it.hasNext()) {
            File file = (File) it.next();
            if (!(TZ(file.getName()) || au(file.getName()))) {
                arrayList.add(file.getPath());
            }
        }
        return arrayList;
    }

    public final ArrayList<String> cft() {
        ArrayList<String> arrayList = new ArrayList();
        Iterator it = this.qTn.iterator();
        while (it.hasNext()) {
            File file = (File) it.next();
            if (TZ(file.getName())) {
                arrayList.add(file.getPath());
            }
        }
        return arrayList;
    }

    public final ArrayList<String> cfu() {
        ArrayList<String> arrayList = new ArrayList();
        Iterator it = this.qTn.iterator();
        while (it.hasNext()) {
            File file = (File) it.next();
            if (au(file.getName())) {
                arrayList.add(file.getPath());
            }
        }
        return arrayList;
    }

    public final File cfv() {
        if (this.qSg.hashCode() == this.qTl.hashCode()) {
            return null;
        }
        return this.qSg.getParentFile();
    }

    public final int getCount() {
        return this.qSh.length;
    }

    public final long getItemId(int i) {
        return 0;
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        Bitmap bitmap = null;
        if (view == null) {
            view = View.inflate(viewGroup.getContext(), R.i.fm_file_item, null);
            b bVar = new b(this, (byte) 0);
            bVar.qTq = (FrameLayout) view.findViewById(R.h.item_selector_wrapper);
            bVar.qTr = (CheckBox) bVar.qTq.findViewById(R.h.item_selector);
            bVar.gmn = (ImageView) view.findViewById(R.h.item_icon);
            bVar.eCm = (TextView) view.findViewById(R.h.item_title);
            bVar.mfT = (TextView) view.findViewById(R.h.item_size);
            bVar.hrs = (TextView) view.findViewById(R.h.item_time);
            bVar.qTq.setOnClickListener(new 4(this));
            view.setTag(bVar);
        }
        b bVar2 = (b) view.getTag();
        File file = this.qSh[i];
        bVar2.eCm.setText(file.getName());
        if (file.isDirectory()) {
            bVar2.gmn.setImageResource(R.k.app_attach_file_icon_folders);
            bVar2.qTq.setVisibility(4);
            bVar2.mfT.setVisibility(0);
            bVar2.hrs.setVisibility(8);
            String[] list = file.list(new FilenameFilter() {
                public final boolean accept(File file, String str) {
                    if (str.startsWith(".")) {
                        return false;
                    }
                    return true;
                }
            });
            int length = list != null ? list.length : 0;
            bVar2.mfT.setText(this.qTk.getString(R.l.file_explorer_dir_subfile_size, new Object[]{Integer.valueOf(length)}));
        } else {
            bVar2.qTq.setVisibility(0);
            bVar2.mfT.setVisibility(0);
            bVar2.hrs.setVisibility(0);
            bVar2.mfT.setText(bi.bF(file.length()));
            bVar2.hrs.setText(com.tencent.mm.pluginsdk.f.h.c(this.qTk, file.lastModified(), true));
            if (TZ(file.getName())) {
                String path = file.getPath();
                Cursor query = this.qTk.getContentResolver().query(Media.EXTERNAL_CONTENT_URI, new String[]{"_id"}, "_data=?", new String[]{path}, null);
                if (query != null) {
                    if (query.moveToFirst()) {
                        int i2 = query.getInt(query.getColumnIndex("_id"));
                        query.close();
                        bitmap = Thumbnails.getThumbnail(this.qTk.getContentResolver(), (long) i2, 3, null);
                    } else {
                        query.close();
                    }
                }
                if (bitmap != null) {
                    bVar2.gmn.setImageBitmap(bitmap);
                } else {
                    bVar2.gmn.setImageResource(TY(file.getName()));
                }
            } else {
                bVar2.gmn.setImageResource(TY(file.getName()));
            }
        }
        bVar2.qTr.setChecked(this.qTn.contains(file));
        bVar2.qTq.setTag(Integer.valueOf(i));
        return view;
    }

    private static int TY(String str) {
        Object obj = null;
        String toLowerCase = str.toLowerCase();
        String toLowerCase2 = bi.oV(toLowerCase).toLowerCase();
        Object obj2 = (toLowerCase2.endsWith(".doc") || toLowerCase2.endsWith(".docx") || toLowerCase2.endsWith("wps")) ? 1 : null;
        if (obj2 != null) {
            return R.k.app_attach_file_icon_word;
        }
        if (TZ(toLowerCase)) {
            return R.g.app_attach_file_icon_pic;
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
            obj2 = 1;
        } else {
            obj2 = null;
        }
        if (obj2 != null) {
            return R.k.app_attach_file_icon_excel;
        }
        toLowerCase2 = bi.oV(toLowerCase).toLowerCase();
        if (toLowerCase2.endsWith(".mp3") || toLowerCase2.endsWith(".wma")) {
            obj = 1;
        }
        if (obj != null) {
            return R.k.app_attach_file_icon_music;
        }
        if (au(toLowerCase)) {
            return R.k.app_attach_file_icon_video;
        }
        if (bi.oV(toLowerCase).toLowerCase().endsWith(".html")) {
            return R.k.app_attach_file_icon_webpage;
        }
        if (bi.oV(toLowerCase).toLowerCase().endsWith(".key")) {
            return R.k.app_attach_file_icon_keynote;
        }
        if (bi.oV(toLowerCase).toLowerCase().endsWith(".number")) {
            return R.k.app_attach_file_icon_number;
        }
        if (bi.oV(toLowerCase).toLowerCase().endsWith(".pages")) {
            return R.k.app_attach_file_icon_page;
        }
        return R.k.app_attach_file_icon_unknow;
    }

    private static boolean TZ(String str) {
        String toLowerCase = bi.oV(str).toLowerCase();
        return toLowerCase.endsWith(".bmp") || toLowerCase.endsWith(".png") || toLowerCase.endsWith(".jpg") || toLowerCase.endsWith(".jpeg") || toLowerCase.endsWith(".gif");
    }

    static boolean au(String str) {
        String toLowerCase = bi.oV(str).toLowerCase();
        return toLowerCase.endsWith(".mp4") || toLowerCase.endsWith(".rm");
    }
}
