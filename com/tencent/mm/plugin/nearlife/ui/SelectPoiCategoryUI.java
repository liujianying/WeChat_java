package com.tencent.mm.plugin.nearlife.ui;

import android.os.Bundle;
import android.view.MenuItem.OnMenuItemClickListener;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import com.tencent.mm.R;
import com.tencent.mm.ar.k;
import com.tencent.mm.model.au;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.aa;
import com.tencent.mm.ui.MMActivity;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class SelectPoiCategoryUI extends MMActivity {
    static final String lEv = (aa.duN + "poi_categories");
    private ListView CU;
    private OnMenuItemClickListener lEq = new 2(this);
    private a lEw;
    private ArrayAdapter<String> lEx;
    private List<String> lEy;
    private OnItemClickListener lEz = new 1(this);

    protected final int getLayoutId() {
        return R.i.select_poi_category_ui;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.lEy = new ArrayList();
        initView();
        this.lEw = new a(this);
        a.sFg.b(this.lEw);
        this.lEw.lEB = this;
        au.DF().a(new k(17), 0);
    }

    protected final void initView() {
        setMMTitle(R.l.nl_select_category);
        setBackBtn(this.lEq);
        this.lEx = new ArrayAdapter(this, R.i.poi_category_item);
        this.CU = (ListView) findViewById(R.h.categories_container);
        this.CU.setAdapter(this.lEx);
        this.CU.setOnItemClickListener(this.lEz);
        if (!IL(lEv + "/lastest_poi_categories.dat")) {
            try {
                t(getAssets().open("default_poi_categories.dat"));
            } catch (IOException e) {
                x.d("MicroMsg.SelectPoiCategoryUI", "open file from assets failed: " + e.getMessage());
            }
        }
        bjg();
    }

    private boolean t(InputStream inputStream) {
        IOException e;
        Throwable th;
        if (inputStream == null) {
            return false;
        }
        this.lEy.clear();
        BufferedReader bufferedReader;
        try {
            bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"));
            while (true) {
                try {
                    String readLine = bufferedReader.readLine();
                    if (readLine != null) {
                        this.lEy.add(readLine);
                    } else {
                        try {
                            break;
                        } catch (Exception e2) {
                            x.d("MicroMsg.SelectPoiCategoryUI", "close file failed: " + e2.getMessage());
                        }
                    }
                } catch (IOException e3) {
                    e = e3;
                    try {
                        x.d("MicroMsg.SelectPoiCategoryUI", "read file failed: " + e.getMessage());
                        if (bufferedReader != null) {
                            try {
                                bufferedReader.close();
                            } catch (Exception e22) {
                                x.d("MicroMsg.SelectPoiCategoryUI", "close file failed: " + e22.getMessage());
                            }
                        }
                        inputStream.close();
                        return true;
                    } catch (Throwable th2) {
                        th = th2;
                        if (bufferedReader != null) {
                            try {
                                bufferedReader.close();
                            } catch (Exception e4) {
                                x.d("MicroMsg.SelectPoiCategoryUI", "close file failed: " + e4.getMessage());
                                throw th;
                            }
                        }
                        inputStream.close();
                        throw th;
                    }
                }
            }
            bufferedReader.close();
            inputStream.close();
        } catch (IOException e5) {
            e = e5;
            bufferedReader = null;
            x.d("MicroMsg.SelectPoiCategoryUI", "read file failed: " + e.getMessage());
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (Exception e222) {
                    x.d("MicroMsg.SelectPoiCategoryUI", "close file failed: " + e222.getMessage());
                }
            }
            inputStream.close();
            return true;
        } catch (Throwable th3) {
            th = th3;
            bufferedReader = null;
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (Exception e42) {
                    x.d("MicroMsg.SelectPoiCategoryUI", "close file failed: " + e42.getMessage());
                    throw th;
                }
            }
            inputStream.close();
            throw th;
        }
        return true;
    }

    private boolean IL(String str) {
        boolean z = false;
        if (bi.oW(str)) {
            return z;
        }
        File file = new File(str);
        if (!file.exists()) {
            return z;
        }
        try {
            return t(new FileInputStream(file));
        } catch (FileNotFoundException e) {
            x.d("MicroMsg.SelectPoiCategoryUI", "update poi categories failed, path:%s, msg:%s", new Object[]{str, e.getMessage()});
            return z;
        }
    }

    protected void onDestroy() {
        super.onDestroy();
        a.sFg.c(this.lEw);
    }

    final void aD(byte[] bArr) {
        String[] split = new String(bArr).split("\n");
        this.lEy.clear();
        for (String trim : split) {
            this.lEy.add(trim.trim());
        }
    }

    final void bjg() {
        this.lEx.clear();
        for (int i = 0; i < this.lEy.size(); i++) {
            this.lEx.add(this.lEy.get(i));
        }
        this.lEx.notifyDataSetChanged();
    }
}
