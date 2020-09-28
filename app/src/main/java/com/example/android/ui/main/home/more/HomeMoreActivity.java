package com.example.android.ui.main.home.more;

import android.graphics.Canvas;
import android.util.Log;
import android.view.View;

import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.callback.ItemDragAndSwipeCallback;
import com.chad.library.adapter.base.listener.OnItemDragListener;
import com.chad.library.adapter.base.listener.OnItemSwipeListener;
import com.chad.library.adapter.base.loadmore.LoadMoreView;
import com.example.android.R;
import com.example.android.arouter.BridgeConstants;
import com.example.android.base.BaseMvpActivity;

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
        provideToolbarHelper().setTitle("更多")
                .enableRightButton()
                .addRightButtonListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {


                    }
                })
                .enableBack(this);

        mAdapter = new HomeMoreAdapter(null);
        mAdapter.bindToRecyclerView(rvContainer);
        rvContainer.setAdapter(mAdapter);
        /*rvContainer.setLayoutManager(new FlexboxLayoutManager(this, FlexDirection.ROW, FlexWrap.WRAP){
            @Override
            public boolean canScrollVertically() {
                return true;
            }
        });*/
        rvContainer.setLayoutManager(new LinearLayoutManager(this, RecyclerView.VERTICAL, false));

        ItemDragAndSwipeCallback callback = new ItemDragAndSwipeCallback(mAdapter);
        ItemTouchHelper helper = new ItemTouchHelper(callback);
        helper.attachToRecyclerView(rvContainer);

        mAdapter.openLoadAnimation(BaseQuickAdapter.SCALEIN);
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

        mAdapter.setOnItemSwipeListener(new OnItemSwipeListener() {
            @Override
            public void onItemSwipeStart(RecyclerView.ViewHolder viewHolder, int i) {
                Log.d("xxbi", "onItemSwipeStart");
            }

            @Override
            public void clearView(RecyclerView.ViewHolder viewHolder, int i) {
                Log.d("xxbi", "clearView");
            }

            @Override
            public void onItemSwiped(RecyclerView.ViewHolder viewHolder, int i) {
                Log.d("xxbi", "onItemSwiped");
            }

            @Override
            public void onItemSwipeMoving(Canvas canvas, RecyclerView.ViewHolder viewHolder, float v, float v1, boolean b) {
                Log.d("xxbi", "onItemSwipeMoving");
            }
        });
        mAdapter.enableSwipeItem();

//        mAdapter.setEnableLoadMore(true);
        mAdapter.setOnLoadMoreListener(new BaseQuickAdapter.RequestLoadMoreListener() {
            @Override
            public void onLoadMoreRequested() {
//                mPresenter.getData();
            }
        }, rvContainer);
        mAdapter.setLoadMoreView(new LoadMoreView() {
            @Override
            public int getLayoutId() {
                return R.layout.item_load_more;
            }

            @Override
            protected int getLoadingViewId() {
                return R.id.load_more_loading_view;
            }

            @Override
            protected int getLoadFailViewId() {
                return R.id.load_more_fail_view;
            }

            @Override
            protected int getLoadEndViewId() {
                return R.id.load_more_end_view;
            }
        });
    }

    @Override
    protected void initListener() {

    }

    @Override
    protected void initData() {
        List<HomeMoreEntity> entityList = new ArrayList<>();
        entityList.add(new HomeMoreEntity("Start"));
        for (int i = 0; i < 10; i++) {
            entityList.add(new HomeMoreEntity("A"));
            entityList.add(new HomeMoreEntity("BB"));
            entityList.add(new HomeMoreEntity("CCC"));
            entityList.add(new HomeMoreEntity("DDDD"));
            entityList.add(new HomeMoreEntity("EEEEE"));
        }
        entityList.add(new HomeMoreEntity("End"));

        mAdapter.setNewData(entityList);

    }

    @Override
    public void requestDataSuccess() {
        List<HomeMoreEntity> entityList = new ArrayList<>();
        entityList.add(new HomeMoreEntity("A"));
        entityList.add(new HomeMoreEntity("BB"));
        entityList.add(new HomeMoreEntity("CCC"));
        entityList.add(new HomeMoreEntity("DDDD"));
        entityList.add(new HomeMoreEntity("EEEEE"));

        mAdapter.setNewData(entityList);
        mAdapter.loadMoreEnd();
    }


}
