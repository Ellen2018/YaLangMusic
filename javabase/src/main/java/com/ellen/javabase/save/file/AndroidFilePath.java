package com.ellen.javabase.save.file;

import android.content.Context;
import android.os.Environment;

public class AndroidFilePath {

    /**
     * 获取Android 外部存储目录
     * @return
     */
    public static String getExternalPath(){
        return Environment.getExternalStorageDirectory().getAbsolutePath();
    }

    /**
     * 获取Android 内部存储目录
     * @param context
     * @return
     */
    public static String getInternalPath(Context context){
        //return Environment.getDataDirectory().getAbsolutePath();
        return context.getFilesDir().getAbsolutePath();
    }
}
