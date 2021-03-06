package com.andy.infrastructure.demos.animotion;


import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Animation;
import android.widget.Button;
import android.widget.RelativeLayout;

import com.andy.baselibrary.activity.BaseActivity;
import com.andy.infrastructure.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class AnimationActivity extends BaseActivity {
    @BindView(R.id.btn_animation)
    Button btnAnimation;
    @BindView(R.id.activity_animation)
    RelativeLayout activityAnimation;
    @BindView(R.id.lengthUpAnimation)
    Button lengthUpAnimation;

    private float centerX;
    private float centerY;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_animation;
    }

    @Override
    protected void initData() {
        centerX = activityAnimation.getWidth() / 2.0f;
        centerY = activityAnimation.getHeight() / 2.0f;
    }

    private void startAnimation(float degreeDelta) {

        final Rotate3dAnimation rotation = new Rotate3dAnimation(0, degreeDelta, 0, btnAnimation.getHeight()/2.0f, 310.0f, true);
        rotation.setDuration(2000);
        rotation.setFillAfter(true);
        rotation.setInterpolator(new AccelerateInterpolator());

//        activityAnimation.startAnimation(rotation);
    }

    @Override
    protected void initViews() {
//        startAnimation(15);

        ViewWrapper viewWrapper = new ViewWrapper(lengthUpAnimation);
        ObjectAnimator widthChangeAnim = ObjectAnimator.ofFloat(viewWrapper, "width", viewWrapper.getWidth(), 300);
        widthChangeAnim.setDuration(3000);
        widthChangeAnim.start();

        ObjectAnimator alphAnim = ObjectAnimator.ofFloat(btnAnimation, "alpha", 1f, 0f);
        alphAnim.setDuration(3000);
        alphAnim.start();
    }

}
