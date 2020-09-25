package com.example.android.ui.main.home.more;

import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.chad.library.adapter.base.callback.ItemDragAndSwipeCallback;
import com.chad.library.adapter.base.listener.OnItemDragListener;
import com.example.android.R;
import com.example.android.arouter.BridgeConstants;
import com.example.android.base.BaseMvpActivity;
import com.google.android.flexbox.FlexDirection;
import com.google.android.flexbox.FlexWrap;
import com.google.android.flexbox.FlexboxLayoutManager;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * Author:      xxbi
 * Create Date: Created in 2020/9/25 16:41
 * Update Date:
 * Modified By:
 * Description:
 */
@Route(path = BridgeConstants.HOMEMORE)
public class HomeMoreActivity extends BaseMvpActivity<HomeMorePresenter> implements IHomeMoreView {
    @BindView(R.id.rv_container)
    RecyclerView rvContainer;

    private HomeMoreAdapter mAdapter;

    @Override
    protected HomeMorePresenter createPresenter() {
        return new HomeMorePresenter();
    }

    @Override
    protected int getLayoutView() {
        return R.layout.activity_home_more;
    }

    @Override
    protected void initView() {
        provideToolbarHelper().setTitle("更多");

        mAdapter = new HomeMoreAdapter(null);
        mAdapter.bindToRecyclerView(rvContainer);
        rvContainer.setAdapter(mAdapter);
        rvContainer.setLayoutManager(new FlexboxLayoutManager(this, FlexDirection.ROW, FlexWrap.WRAP){
            @Override
            public boolean canScrollVertically() {
                return false;
            }
        });
//        rvContainer.setLayoutManager(new LinearLayoutManager(this, RecyclerView.VERTICAL, false));
        ItemDragAndSwipeCallback callback = new ItemDragAndSwipeCallback(mAdapter);
        ItemTouchHelper helper = new ItemTouchHelper(callback);
        helper.attachToRecyclerView(rvContainer);

        mAdapter.setOnItemDragListener(new OnItemDragListener() {
            @Override
            public void onItemDragStart(RecyclerView.ViewHolder viewHolder, int i) {

            }

            @Override
            public void onItemDragMoving(RecyclerView.ViewHolder viewHolder, int i, RecyclerView.ViewHolder viewHolder1, int i1) {

            }

            @Override
            public void onItemDragEnd(RecyclerView.ViewHolder viewHolder, int i) {

            }
        });
        mAdapter.enableDragItem(helper);



    }

    @Override
    protected void initListener() {

    }

    @Override
    protected void initData() {
        List<HomeMoreEntity> entityList = new ArrayList<>();
        entityList.add(new HomeMoreEntity("A"));
        entityList.add(new HomeMoreEntity("BB"));
        entityList.add(new HomeMoreEntity("CCC"));
        entityList.add(new HomeMoreEntity("DDDD"));
        entityList.add(new HomeMoreEntity("EEEEE"));


        mAdapter.setNewData(entityList);

    }
}
