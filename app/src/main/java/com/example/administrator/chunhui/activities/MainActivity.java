package com.example.administrator.chunhui.activities;

import android.util.Log;

import com.example.administrator.chunhui.R;
import com.example.administrator.chunhui.beans.ListNewsBean;
import com.example.administrator.chunhui.beans.News;
import com.example.administrator.chunhui.beans.PersonInfoBean;
import com.example.administrator.chunhui.beans.ResultBean;
import com.example.administrator.chunhui.modules.ChatModule;
import com.example.administrator.frame.base.BaseActivity;
import com.example.administrator.frame.configs.Apiconfig;
import com.example.administrator.frame.presenter.PresenterImp;

public class MainActivity extends BaseActivity<PresenterImp, ChatModule> {

    @Override
    public int getLayout() {
        return R.layout.activity_main;
    }

    @Override
    public PresenterImp getPresenter() {
        return new PresenterImp();
    }

    @Override
    public ChatModule getModule() {
        return new ChatModule();
    }

    @Override
    public void getView() {

    }

    @Override
    public void getData() {
//        mPresenter.setContent(Apiconfig.APICONFIG_FIRST);
//        mPresenter.setContent(Apiconfig.APICONFIG_SECOND);
//        mPresenter.setContent(Apiconfig.APICONFIG_THRID);
        mPresenter.setContent(Apiconfig.APICONFIG_FORTH);
    }

    @Override
    public void showResult(int apiconfig, Object o, Object[] t) {
        switch (apiconfig) {
            case Apiconfig.APICONFIG_FIRST:
                ListNewsBean listNewsBean = (ListNewsBean) o;
                Log.e("vv", "showResult: " + listNewsBean.getData().getNewsChannelList().get(0).getChannelName());
                break;
            case Apiconfig.APICONFIG_SECOND:
                PersonInfoBean personInfoBean = (PersonInfoBean) o;
                Log.e("vv", "showResult: " + personInfoBean.getData().getBirthday());
                break;
            case Apiconfig.APICONFIG_THRID:
                ResultBean resultBean = (ResultBean) o;
                Log.e("vv", "showResult: " + resultBean.getMessage());
                break;
            case Apiconfig.APICONFIG_FORTH:
                News news= (News) o;
                Log.e("vv", "showResult: " + news.getResult().getStat());
                break;

        }
    }

    @Override
    public void showError(int Apiconfig, Throwable throwable) {

    }
}
