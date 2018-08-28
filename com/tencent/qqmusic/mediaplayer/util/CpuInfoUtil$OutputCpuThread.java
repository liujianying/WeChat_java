package com.tencent.qqmusic.mediaplayer.util;

import java.io.BufferedReader;
import java.io.InputStreamReader;

class CpuInfoUtil$OutputCpuThread extends Thread {
    public boolean isStop = false;

    public CpuInfoUtil$OutputCpuThread(String str) {
        super(str);
    }

    public void run() {
        Throwable e;
        super.run();
        StringBuilder stringBuilder = new StringBuilder();
        Process exec;
        BufferedReader bufferedReader;
        try {
            exec = Runtime.getRuntime().exec("top -m 10 -s cpu -t");
            try {
                bufferedReader = new BufferedReader(new InputStreamReader(exec.getInputStream()));
                int i = 0;
                while (true) {
                    try {
                        String readLine = bufferedReader.readLine();
                        if (readLine == null || this.isStop) {
                            try {
                                bufferedReader.close();
                            } catch (Throwable e2) {
                                Logger.e("CpuInfoUtil", e2);
                            }
                            if (exec != null) {
                                exec.destroy();
                                return;
                            }
                            return;
                        }
                        int i2 = i + 1;
                        stringBuilder.append(readLine).append("\n");
                        if (i2 > 15) {
                            try {
                                Logger.d("CpuInfoUtil", stringBuilder.toString());
                                stringBuilder.delete(0, stringBuilder.length() - 1);
                                sleep(5000);
                                i = 0;
                            } catch (Throwable e22) {
                                Logger.e("CpuInfoUtil", e22);
                                i = i2;
                            }
                        } else {
                            i = i2;
                        }
                    } catch (Exception e3) {
                        e22 = e3;
                    }
                }
            } catch (Exception e4) {
                e22 = e4;
                bufferedReader = null;
                try {
                    Logger.e("CpuInfoUtil", e22);
                    if (bufferedReader != null) {
                        try {
                            bufferedReader.close();
                        } catch (Throwable e222) {
                            Logger.e("CpuInfoUtil", e222);
                        }
                    }
                    if (exec != null) {
                        exec.destroy();
                    }
                } catch (Throwable th) {
                    e222 = th;
                    if (bufferedReader != null) {
                        try {
                            bufferedReader.close();
                        } catch (Throwable e5) {
                            Logger.e("CpuInfoUtil", e5);
                        }
                    }
                    if (exec != null) {
                        exec.destroy();
                    }
                    throw e222;
                }
            } catch (Throwable th2) {
                e222 = th2;
                bufferedReader = null;
                if (bufferedReader != null) {
                    try {
                        bufferedReader.close();
                    } catch (Throwable e52) {
                        Logger.e("CpuInfoUtil", e52);
                    }
                }
                if (exec != null) {
                    exec.destroy();
                }
                throw e222;
            }
        } catch (Exception e6) {
            e222 = e6;
            exec = null;
            bufferedReader = null;
        } catch (Throwable th3) {
            e222 = th3;
            exec = null;
            bufferedReader = null;
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (Throwable e522) {
                    Logger.e("CpuInfoUtil", e522);
                }
            }
            if (exec != null) {
                exec.destroy();
            }
            throw e222;
        }
    }
}
