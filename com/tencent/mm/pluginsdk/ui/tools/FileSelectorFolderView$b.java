package com.tencent.mm.pluginsdk.ui.tools;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.tencent.mm.R;
import com.tencent.mm.pluginsdk.ui.tools.FileSelectorFolderView.c;

public class FileSelectorFolderView$b extends BaseAdapter {
    private Context mContext;

    public FileSelectorFolderView$b(Context context) {
        this.mContext = context;
    }

    public final int getCount() {
        return 2;
    }

    public final Object getItem(int i) {
        return Integer.valueOf(i);
    }

    public final long getItemId(int i) {
        return (long) i;
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        c cVar;
        if (view == null || view.getTag() == null) {
            view = LayoutInflater.from(this.mContext).inflate(R.i.fm_folder_item, null);
            cVar = new c(view);
            view.setTag(cVar);
        } else {
            cVar = (c) view.getTag();
        }
        switch (i) {
            case 0:
                cVar.eBO.setText(R.l.file_explorer_mm_download_title);
                break;
            case 1:
                cVar.eBO.setText(R.l.file_explorer_mobile_dir_title);
                break;
            default:
                cVar.eBO.setText(R.l.app_empty_string);
                break;
        }
        return view;
    }
}
