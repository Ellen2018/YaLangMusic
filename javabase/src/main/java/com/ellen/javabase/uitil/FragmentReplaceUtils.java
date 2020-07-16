package com.ellen.javabase.uitil;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;

import java.lang.ref.WeakReference;

/**
 *
 * 此工具类仅支持v4包下的Fragment
 */
public class FragmentReplaceUtils {

    private FragmentManager fragmentManager;
    private WeakReference<FragmentActivity> contextWeakReference;
    private Callback callback;
    private int fragmentId;
    private Fragment currentFragment;
    private String currentTag;

    public FragmentReplaceUtils(FragmentActivity activity, int fragmentId){
        contextWeakReference = new WeakReference<>(activity);
        this.fragmentId = fragmentId;
    }

    public void  setCallback(Callback callback){
        this.callback = callback;
    }

    public Fragment getCurrentFragment() {
        return currentFragment;
    }

    public void replace(String tag){
        Fragment returnFragment = null;
        fragmentManager = null;
        if(fragmentManager == null){
            fragmentManager = contextWeakReference.get().getSupportFragmentManager();
        }
        if (currentFragment != null){
            //当不为空就说明已经选择了fragment,消除当前碎片页面（不消除的话会让下一选中页面和当前界面重复）
            fragmentManager.beginTransaction().hide(currentFragment).commit();
        }
        //复用fragment,避免下方选择重复new创建碎片对象
        // myFragment = getSupportFragmentManager().findFragmentById(position);
        returnFragment = fragmentManager.findFragmentByTag(tag);
        if (returnFragment == null){
            //碎片为空，将选中的碎片加载显现
            Fragment newFragment = callback.getNewFragment(tag);
            fragmentManager.beginTransaction().add(fragmentId,newFragment, String.valueOf(tag)).commit();
            returnFragment = newFragment;
        }else{
            //碎片不为空，直接显示当前界面
            fragmentManager.beginTransaction().show(returnFragment).commit();
        }
        currentTag = tag;
        currentFragment = returnFragment;
    }

    public interface Callback{
        Fragment getNewFragment(String tag);
    }

}
