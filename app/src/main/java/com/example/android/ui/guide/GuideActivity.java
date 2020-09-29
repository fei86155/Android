package com.example.android.ui.guide;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.ViewFlipper;

import androidx.core.content.res.ResourcesCompat;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.example.android.R;
import com.example.android.arouter.BridgeConstants;
import com.example.android.base.BaseMvpActivity;

import butterknife.BindView;

/**
 * Author:      xxbi
 * Create Date: Created in 2020/9/24 16:10
 * Update Date:
 * Modified By:
 * Description:
 */
@Route(path = BridgeConstants.GUIDE)
public class GuideActivity extends BaseMvpActivity<GuidePresenter> implements IGuideView{
    @BindView(R.id.vf_container)
    ViewFlipper vfContainer;

    @Override
    protected GuidePresenter createPresenter() {
        return new GuidePresenter();
    }

    @Override
    protected int getLayoutView() {
        return R.layout.activity_guide;
    }

    @Override
    protected void initView() {
        vfContainer.setFlipInterval(1000);
        View view1 = LayoutInflater.from(this).inflate(R.layout.item_guide, null, false);
        View view2 = LayoutInflater.from(this).inflate(R.layout.item_guide, null, false);
        ImageView imageView = view1.findViewById(R.id.iv_content);
//        imageView.setImageResource(R.drawable.bg_room);
        View view3 = LayoutInflater.from(this).inflate(R.layout.item_guide, null, false);
        vfContainer.addView(view1, 0);
        vfContainer.addView(view2, 1);
        vfContainer.addView(view3, 2);
        vfContainer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                vfContainer.showNext();
            }
        });
    }

    @Override
    protected void initListener() {

    }

    @Override
    protected void initData() {

    }
}
